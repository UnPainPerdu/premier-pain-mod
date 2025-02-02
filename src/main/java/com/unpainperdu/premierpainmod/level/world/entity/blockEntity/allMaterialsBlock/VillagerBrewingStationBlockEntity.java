package com.unpainperdu.premierpainmod.level.world.entity.blockEntity.allMaterialsBlock;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerBrewingStation;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.LiquidContent;
import com.unpainperdu.premierpainmod.level.world.fluid.beer.BeerFluid;
import com.unpainperdu.premierpainmod.level.world.fluid.fluidType.BeerFluidType;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.villagerBrewingStation.VillagerBrewingStationInput;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.villagerBrewingStation.VillagerBrewingStationRecipe;
import com.unpainperdu.premierpainmod.level.world.menu.menu.allMaterialsBlock.VillagerBrewingStationMenu;
import com.unpainperdu.premierpainmod.util.ModContainerData.IFluidStackContainerData;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.block.BlockEntityRegister;
import com.unpainperdu.premierpainmod.util.register.recipe.RecipeTypeRegister;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VillagerBrewingStationBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, RecipeCraftingHolder, StackedContentsCompatible
{
    private static final int WATER_INPUT_SLOT = 0;
    public static final int[] SLOTS_FOR_INGREDIENT = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
    private static final int GLASS_INPUT_SLOT_1 = 13;
    private static final int OUTPUT_SLOT = 14;
    private static final int[] SIDE_SLOTS = new int[]{0, 13};
    private static final int[] SLOTS_FOR_OUTPUT = new int[]{13, WATER_INPUT_SLOT};
    private static final int SLOTS_NUMBER = 15;
    public static final int BREWING_TIME_STANDARD = 100;
    public static final int DATA_BREWING_PROGRESS = 0;
    public static final int DATA_BREWING_TOTAL_TIME = 1;
    int brewingProgress;
    int brewingTotalTime;
    private NonNullList<ItemStack> items = NonNullList.withSize(SLOTS_NUMBER, ItemStack.EMPTY);
    private FluidTank fluidTank;

    public final ContainerData dataAccess = new ContainerData()
    {
        @Override
        public int get(int dataIndex)
        {
            switch (dataIndex)
            {
                case 0:
                    return VillagerBrewingStationBlockEntity.this.getBrewingProgress();
                case 1:
                    return VillagerBrewingStationBlockEntity.this.getBrewingTotalTime();
                default:
                    return 0;
            }
        }

        @Override
        public void set(int dataIndex, int newValue)
        {
            switch (dataIndex)
            {
                case 0:
                    VillagerBrewingStationBlockEntity.this.brewingProgress = newValue;
                    break;
                case 1:
                    VillagerBrewingStationBlockEntity.this.brewingTotalTime = newValue;
            }
        }

        @Override
        public int getCount()
        {
            return 2;
        }
    };
    private final RecipeType<? extends VillagerBrewingStationRecipe> recipeType;
    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
    private final RecipeManager.CachedCheck<VillagerBrewingStationInput, ? extends VillagerBrewingStationRecipe> quickCheck;

    public VillagerBrewingStationBlockEntity(BlockPos pos, BlockState blockState)
    {
        super(BlockEntityRegister.VILLAGER_BREWING_STATION_ENTITY.get(), pos, blockState);
        this.fluidTank = new FluidTank(1000);
        this.quickCheck = RecipeManager.createCheck((RecipeType<VillagerBrewingStationRecipe>) RecipeTypeRegister.VILLAGER_BREWING_STATION_RECIPE_TYPE.get());
        this.recipeType = RecipeTypeRegister.VILLAGER_BREWING_STATION_RECIPE_TYPE.get();
        this.brewingTotalTime = BREWING_TIME_STANDARD;
    }

    @Override
    protected Component getDefaultName()
    {
        return Component.translatable("container."+ PremierPainMod.MOD_ID +".villager_brewing_station");
    }

    public int getBrewingProgress()
    {
        return this.brewingProgress;
    }

    public int getBrewingTotalTime()
    {
        return this.brewingTotalTime;
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory)
    {
        return new VillagerBrewingStationMenu(id, inventory, this);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.loadAdditional(tag, registries);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(tag, this.items, registries);
        fluidTank.readFromNBT(registries, tag.getCompound("tank"));
        this.brewingProgress = tag.getInt("BrewTime");
        this.brewingTotalTime = tag.getInt("BrewTimeTotal");
        CompoundTag compoundtag = tag.getCompound("RecipesUsed");
        for (String s : compoundtag.getAllKeys())
        {
            this.recipesUsed.put(ResourceLocation.parse(s), compoundtag.getInt(s));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.saveAdditional(tag, registries);
        tag.putInt("BrewTime", this.brewingProgress);
        tag.putInt("BrewTimeTotal", this.brewingTotalTime);
        ContainerHelper.saveAllItems(tag, this.items, registries);
        CompoundTag compoundTagFluidTank = new CompoundTag();
        fluidTank.writeToNBT(registries, compoundTagFluidTank);
        tag.put("tank", compoundTagFluidTank);
        CompoundTag compoundTagRecipe = new CompoundTag();
        this.recipesUsed.forEach((p_187449_, p_187450_) -> compoundTagRecipe.putInt(p_187449_.toString(), p_187450_));
        tag.put("RecipesUsed", compoundTagRecipe);
    }


    public static void serverTick(Level level, BlockPos pos, BlockState state, VillagerBrewingStationBlockEntity blockEntity)
    {
        if (blockEntity.fluidTank.isEmpty())
        {
            NonNullList<ItemStack> itemStacks = blockEntity.items;
            if (itemStacks.get(WATER_INPUT_SLOT).is(Items.WATER_BUCKET))
            {
                blockEntity.fluidTank.fill(new FluidStack(Fluids.WATER, 1000), IFluidHandler.FluidAction.EXECUTE);
                itemStacks.set(WATER_INPUT_SLOT, new ItemStack(Items.BUCKET));
                blockEntity.setItems(itemStacks);
                blockEntity.setChanged();
            }
        }
        boolean flag1 = false;
        List<ItemStack>  itemStacks = blockEntity.getIngredientItem();
        FluidStack fluidStackInput = blockEntity.fluidTank.getFluid();

        if (blockEntity.hasEnoughItems(itemStacks) && blockEntity.fluidTank.getFluid().is(Fluids.WATER) && blockEntity.fluidTank.getFluidAmount() >= 1000)
        {
            RecipeHolder<?> recipeholder = blockEntity.quickCheck.getRecipeFor(new VillagerBrewingStationInput(fluidStackInput, itemStacks), level).orElse(null);

            int i = blockEntity.getMaxStackSize();
            if (!canBrew(level.registryAccess(), recipeholder,fluidStackInput, blockEntity.getIngredientItem(), i, blockEntity))
            {
                blockEntity.brewingProgress = 0;
            }
            else
            {
                blockEntity.brewingProgress++;
                if (blockEntity.brewingProgress == blockEntity.brewingTotalTime)
                {
                    blockEntity.brewingProgress = 0;
                    if (brew(level.registryAccess(), recipeholder, fluidStackInput, blockEntity.getIngredientItem(), i, blockEntity))
                    {
                        blockEntity.setRecipeUsed(recipeholder);
                    }

                    flag1 = true;
                }
            }
        }
        else
        {
            blockEntity.brewingProgress = 0;
        }

        if (!blockEntity.fluidTank.isEmpty() && !blockEntity.items.get(GLASS_INPUT_SLOT_1).isEmpty())
        {
            NonNullList<ItemStack> itemList = blockEntity.getItems();
            ItemStack glassInput = itemList.get(GLASS_INPUT_SLOT_1);
            FluidStack fluidStack = blockEntity.fluidTank.getFluid();
            ItemStack output = itemList.get(OUTPUT_SLOT);
            if (glassInput.is(Items.BUCKET))
            {
                if (output.isEmpty() && fluidStack.getFluid() instanceof FlowingFluid && blockEntity.fluidTank.getFluidAmount() >= 1000)
                {
                    ItemStack bucket = new ItemStack(fluidStack.getFluid().getBucket());
                    blockEntity.fluidTank.drain(1000, IFluidHandler.FluidAction.EXECUTE);
                    itemList.set(OUTPUT_SLOT, bucket.copy());
                    blockEntity.setItems(itemList);
                    blockEntity.items.get(GLASS_INPUT_SLOT_1).shrink(1);
                    flag1 = true;
                }
            }
            else if (fluidStack.getFluid() instanceof BeerFluid && blockEntity.fluidTank.getFluidAmount() >= 250)
            {
                if (glassInput.is(ItemRegister.EMPTY_MUG))
                {
                    ItemStack mug = new ItemStack(((BeerFluid) fluidStack.getFluid()).getMug());
                    if (output.isEmpty())
                    {
                        blockEntity.fluidTank.drain(250, IFluidHandler.FluidAction.EXECUTE);
                        itemList.set(OUTPUT_SLOT, mug.copy());
                        blockEntity.setItems(itemList);
                        blockEntity.items.get(GLASS_INPUT_SLOT_1).shrink(1);
                        flag1 = true;
                    }
                    else if (itemList.get(OUTPUT_SLOT).is(mug.getItem()) && itemList.get(OUTPUT_SLOT).getCount() < itemList.get(OUTPUT_SLOT).getMaxStackSize())
                    {
                        blockEntity.fluidTank.drain(250, IFluidHandler.FluidAction.EXECUTE);
                        blockEntity.items.get(OUTPUT_SLOT).grow(1);
                        blockEntity.items.get(GLASS_INPUT_SLOT_1).shrink(1);
                        flag1 = true;
                    }

                }
                else if (glassInput.is(ItemRegister.EMPTY_BOTTLE))
                {
                    ItemStack bottle = new ItemStack(((BeerFluid) fluidStack.getFluid()).getBottle());
                    if (output.isEmpty())
                    {
                        blockEntity.fluidTank.drain(250, IFluidHandler.FluidAction.EXECUTE);
                        itemList.set(OUTPUT_SLOT, bottle.copy());
                        blockEntity.setItems(itemList);
                        blockEntity.items.get(GLASS_INPUT_SLOT_1).shrink(1);
                        flag1 = true;
                    }
                    else if (itemList.get(OUTPUT_SLOT).is(bottle.getItem()) && itemList.get(OUTPUT_SLOT).getCount() < itemList.get(OUTPUT_SLOT).getMaxStackSize())
                    {
                        blockEntity.fluidTank.drain(250, IFluidHandler.FluidAction.EXECUTE);
                        blockEntity.items.get(OUTPUT_SLOT).grow(1);
                        blockEntity.items.get(GLASS_INPUT_SLOT_1).shrink(1);
                        flag1 = true;
                    }
                }
            }
        }

        if (flag1)
        {
            setChanged(level, pos, state);
        }
        blockEntity.updateLevelFromTank(level, pos, state, blockEntity.fluidTank);

        //System.out.println(blockEntity.brewingProgress);
        //System.out.println(blockEntity.fluidTank.getFluid() + " " + blockEntity.fluidTank.getFluidAmount());
    }

    protected void updateLevelFromTank(Level level, BlockPos pos, BlockState state, FluidTank fluidTank)
    {
        LiquidContent content = LiquidContent.WATER;
        int levelInt = 0;
        FluidType fluidType = fluidTank.getFluid().getFluidType();
        if (fluidType instanceof BeerFluidType)
        {
            content = ((BeerFluidType) fluidType).getLiquidContent();
        }
        if (fluidTank.getFluidAmount() >= 1000)
        {
            levelInt = 4;
        }
        else if (fluidTank.getFluidAmount() >= 750)
        {
            levelInt = 3;
        }
        else if (fluidTank.getFluidAmount() >= 500)
        {
            levelInt = 2;
        }
        else if (fluidTank.getFluidAmount() >= 250)
        {
            levelInt = 1;
        }
        level.setBlock(pos, state.setValue(VillagerBrewingStation.LEVEL, levelInt).setValue(VillagerBrewingStation.CONTENT, content), 3);
    }

    protected boolean hasEnoughItems(List<ItemStack> itemStackList)
    {
        int i = 0;
        for (ItemStack itemStack : itemStackList)
        {
            if (!itemStack.isEmpty())
            {
                i ++;
            }
        }
        return i >= 1;
    }

    public FluidTank getFluidTank()
    {
        return fluidTank;
    }

    @Override
    public NonNullList<ItemStack> getItems()
    {
        return items;
    }

    @Override
    public void setItems(NonNullList<ItemStack> items)
    {
        this.items = items;
    }

    @Override
    public boolean canPlaceItem(int index, ItemStack stack)
    {
        if (index == OUTPUT_SLOT)
        {
            return false;
        }
        else if (index == GLASS_INPUT_SLOT_1)
        {
            return stack.is(ItemRegister.EMPTY_MUG.get()) || stack.is(ItemRegister.EMPTY_BOTTLE.get()) || stack.is(Items.BUCKET);
        }
        else if (index != WATER_INPUT_SLOT)
        {
            return true;
        }
        else
        {
            ItemStack itemstack = this.items.get(WATER_INPUT_SLOT);
            return stack.is(Items.WATER_BUCKET) && itemstack.isEmpty();
        }
    }

    @Override
    public int[] getSlotsForFace(Direction side)
    {
        switch (side)
        {
            case Direction.DOWN -> {return SLOTS_FOR_OUTPUT;}
            case Direction.UP -> {return SLOTS_FOR_INGREDIENT;}
            default -> {return SIDE_SLOTS;}
        }
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack itemStack, @Nullable Direction direction)
    {
        return this.canPlaceItem(index, itemStack);
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction)
    {
        boolean flag = false;
        if (index == OUTPUT_SLOT)
        {
            flag = true;
        }

        if (index == WATER_INPUT_SLOT && stack.is(Items.BUCKET))
        {
            flag = true;
        }
        return flag;
    }

    @Override
    public int getContainerSize()
    {
        return SLOTS_NUMBER;
    }

    @Override
    public void setRecipeUsed(@Nullable RecipeHolder<?> recipe)
    {
        if (recipe != null)
        {
            ResourceLocation resourcelocation = recipe.id();
            this.recipesUsed.addTo(resourcelocation, 1);
        }
    }

    @Nullable
    @Override
    public RecipeHolder<?> getRecipeUsed()
    {
        return null;
    }

    @Override
    public void fillStackedContents(StackedContents contents)
    {
        for (ItemStack itemstack : this.items)
        {
            contents.accountStack(itemstack);
        }
    }

    private static boolean brew(RegistryAccess registryAccess, @javax.annotation.Nullable RecipeHolder<?> recipe,FluidStack fluidStackInput, NonNullList<ItemStack> ingredients, int maxStackSize, VillagerBrewingStationBlockEntity brewingStation)
    {
        if (recipe != null && canBrew(registryAccess, recipe, fluidStackInput,ingredients, maxStackSize, brewingStation))
        {
            FluidStack fluidStackResult = ((RecipeHolder<? extends VillagerBrewingStationRecipe>) recipe).value().assembleFluidResult(new VillagerBrewingStationInput(fluidStackInput, ingredients), registryAccess);

            brewingStation.fluidTank.setFluid(fluidStackResult);
            for (ItemStack itemStack : ingredients)
            {
                itemStack.shrink(1);
            }
            return true;
        }
        else
        {
            return false;
        }
    }

    private static boolean canBrew(RegistryAccess registryAccess, RecipeHolder<?> recipe, FluidStack fluidStackInput, NonNullList<ItemStack> ingredients, int maxStackSize, VillagerBrewingStationBlockEntity brewingStation)
    {
        if (brewingStation.hasEnoughItems(ingredients) && recipe != null)
        {
            FluidStack fluidStackResult = ((RecipeHolder<? extends VillagerBrewingStationRecipe>) recipe).value().assembleFluidResult(new VillagerBrewingStationInput(fluidStackInput, ingredients), registryAccess);
            if (fluidStackResult.isEmpty())
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    @javax.annotation.Nullable
    public static <T extends BlockEntity> BlockEntityTicker<T> createBrewingStationTicker(
            Level level, BlockEntityType<T> serverType, BlockEntityType<VillagerBrewingStationBlockEntity> clientType
    )
    {
        return level.isClientSide ? null : createTickerHelper(serverType, clientType, VillagerBrewingStationBlockEntity::serverTick);
    }

    private NonNullList<ItemStack> getIngredientItem()
    {
        NonNullList<ItemStack> temp = NonNullList.withSize(SLOTS_FOR_INGREDIENT.length, ItemStack.EMPTY);
        int i = 0;
        int m = 0;
        for (ItemStack item : this.items)
        {
            if (i != 0 && i != 13 && i !=14)
            {
                temp.set(m, item);
                m ++;
            }
            i ++;
        }
        return temp ;
    }

    @javax.annotation.Nullable
    public static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> serverType, BlockEntityType<E> clientType, BlockEntityTicker<? super E> ticker)
    {
        return clientType == serverType ? (BlockEntityTicker<A>)ticker : null;
    }

    //for link between client side BE and server side BE I suppose
    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries)
    {
        return saveWithoutMetadata(registries);
    }

    //for link between client side BE and server side BE I suppose
    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
