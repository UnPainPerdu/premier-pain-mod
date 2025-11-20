package com.unpainperdu.premierpainmod.level.world.entity.block_entity.all_materials_block;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.fluid.beer.BeerFluid;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.villager_brewing_station.VillagerBrewingStationInput;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.villager_brewing_station.VillagerBrewingStationRecipe;
import com.unpainperdu.premierpainmod.level.world.menu.menu.all_materials_block.VillagerBrewingStationMenu;
import com.unpainperdu.premierpainmod.util.register.Item.ItemRegister;
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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeCraftingHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VillagerBrewingStationBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, RecipeCraftingHolder, StackedContentsCompatible
{
    private static final int WATER_INPUT_SLOT = 0;
    public static final int[] SLOTS_FOR_INGREDIENT = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private static final int GLASS_INPUT_SLOT_1 = 13;
    private static final int OUTPUT_SLOT = 14;
    private static final int[] SIDE_SLOTS = new int[]{0, 13};
    private static final int[] SLOTS_FOR_OUTPUT = new int[]{14, WATER_INPUT_SLOT};
    private static final int SLOTS_NUMBER = 15;
    public static final int BREWING_TIME_STANDARD = 100;
    int brewingProgress;
    int brewingTotalTime;
    private NonNullList<ItemStack> items = NonNullList.withSize(SLOTS_NUMBER, ItemStack.EMPTY);
    private final FluidTank fluidTank;

    public final ContainerData dataAccess = new ContainerData()
    {
        @Override
        public int get(int dataIndex)
        {
            return switch (dataIndex)
            {
                case 0 -> VillagerBrewingStationBlockEntity.this.getBrewingProgress();
                case 1 -> VillagerBrewingStationBlockEntity.this.getBrewingTotalTime();
                default -> 0;
            };
        }

        @Override
        public void set(int dataIndex, int newValue)
        {
            switch (dataIndex)
            {
                case 0 -> VillagerBrewingStationBlockEntity.this.brewingProgress = newValue;

                case 1 -> VillagerBrewingStationBlockEntity.this.brewingTotalTime = newValue;
            }
        }

        @Override
        public int getCount()
        {
            return 2;
        }
    };
    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
    private final RecipeManager.CachedCheck<VillagerBrewingStationInput, ? extends VillagerBrewingStationRecipe> quickCheck;

    public VillagerBrewingStationBlockEntity(BlockPos pos, BlockState blockState)
    {
        super(BlockEntityRegister.VILLAGER_BREWING_STATION_ENTITY.get(), pos, blockState);
        this.fluidTank = new FluidTank(1000);
        this.quickCheck = RecipeManager.createCheck(RecipeTypeRegister.VILLAGER_BREWING_STATION_RECIPE_TYPE.get());
        this.brewingTotalTime = BREWING_TIME_STANDARD;
    }

    @Override
    protected @NotNull Component getDefaultName()
    {
        return Component.translatable("container." + PremierPainMod.MOD_ID + ".villager_brewing_station");
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
    public @NotNull AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory)
    {
        return new VillagerBrewingStationMenu(id, inventory, this);
    }

    @Override
    public boolean canOpen(@NotNull Player player)
    {
        return !player.isSpectator();
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries)
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
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries)
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
        boolean flag1 = false;
        if (blockEntity.fluidTank.isEmpty())
        {
            NonNullList<ItemStack> itemStacks = blockEntity.items;
            if (itemStacks.get(WATER_INPUT_SLOT).is(Items.WATER_BUCKET))
            {
                blockEntity.fluidTank.fill(new FluidStack(Fluids.WATER, 1000), IFluidHandler.FluidAction.EXECUTE);
                itemStacks.set(WATER_INPUT_SLOT, new ItemStack(Items.BUCKET));
                blockEntity.setItems(itemStacks);
                playSound(blockEntity.getLevel(), blockEntity.getBlockPos(), SoundEvents.BUCKET_EMPTY);
                flag1 = true;
            }
        }
        List<ItemStack> itemStacks = blockEntity.getIngredientItem();
        FluidStack fluidStackInput = blockEntity.fluidTank.getFluid();

        if (blockEntity.hasEnoughItems(itemStacks) && blockEntity.fluidTank.getFluid().is(Fluids.WATER) && blockEntity.fluidTank.getFluidAmount() >= 1000)
        {
            RecipeHolder<?> recipeholder = blockEntity.quickCheck.getRecipeFor(new VillagerBrewingStationInput(fluidStackInput, itemStacks), level).orElse(null);

            if (!canBrew(level.registryAccess(), recipeholder, fluidStackInput, blockEntity.getIngredientItem(), blockEntity))
            {
                blockEntity.brewingProgress = 0;
            }
            else
            {
                blockEntity.brewingProgress++;
                if (blockEntity.brewingProgress == blockEntity.brewingTotalTime)
                {
                    blockEntity.brewingProgress = 0;
                    if (brew(level.registryAccess(), recipeholder, fluidStackInput, blockEntity.getIngredientItem(), blockEntity))
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
                    playSound(blockEntity.getLevel(), blockEntity.getBlockPos(), SoundEvents.BOTTLE_FILL);
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
                        playSound(blockEntity.getLevel(), blockEntity.getBlockPos(), SoundEvents.BOTTLE_FILL);
                        flag1 = true;
                    }
                    else if (itemList.get(OUTPUT_SLOT).is(mug.getItem()) && itemList.get(OUTPUT_SLOT).getCount() < itemList.get(OUTPUT_SLOT).getMaxStackSize())
                    {
                        blockEntity.fluidTank.drain(250, IFluidHandler.FluidAction.EXECUTE);
                        blockEntity.items.get(OUTPUT_SLOT).grow(1);
                        blockEntity.items.get(GLASS_INPUT_SLOT_1).shrink(1);
                        playSound(blockEntity.getLevel(), blockEntity.getBlockPos(), SoundEvents.BOTTLE_FILL);
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
                        playSound(blockEntity.getLevel(), blockEntity.getBlockPos(), SoundEvents.BOTTLE_FILL);
                        flag1 = true;
                    }
                    else if (itemList.get(OUTPUT_SLOT).is(bottle.getItem()) && itemList.get(OUTPUT_SLOT).getCount() < itemList.get(OUTPUT_SLOT).getMaxStackSize())
                    {
                        blockEntity.fluidTank.drain(250, IFluidHandler.FluidAction.EXECUTE);
                        blockEntity.items.get(OUTPUT_SLOT).grow(1);
                        blockEntity.items.get(GLASS_INPUT_SLOT_1).shrink(1);
                        playSound(blockEntity.getLevel(), blockEntity.getBlockPos(), SoundEvents.BOTTLE_FILL);
                        flag1 = true;
                    }
                }
            }
        }

        if (flag1)
        {
            blockEntity.setChanged();
        }
    }


    protected boolean hasEnoughItems(List<ItemStack> itemStackList)
    {
        int i = 0;
        for (ItemStack itemStack : itemStackList)
        {
            if (!itemStack.isEmpty())
            {
                i++;
            }
        }
        return i >= 1;
    }

    public FluidTank getFluidTank()
    {
        return fluidTank;
    }

    @Override
    public @NotNull NonNullList<ItemStack> getItems()
    {
        return items;
    }

    @Override
    public void setItems(@NotNull NonNullList<ItemStack> items)
    {
        this.items = items;
    }

    @Override
    public boolean canPlaceItem(int index, @NotNull ItemStack stack)
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
    public int @NotNull [] getSlotsForFace(Direction side)
    {
        switch (side)
        {
            case Direction.DOWN ->
            {
                return SLOTS_FOR_OUTPUT;
            }
            case Direction.UP ->
            {
                return SLOTS_FOR_INGREDIENT;
            }
            default ->
            {
                return SIDE_SLOTS;
            }
        }
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, @NotNull ItemStack itemStack, @Nullable Direction direction)
    {
        return this.canPlaceItem(index, itemStack);
    }

    @Override
    public boolean canTakeItemThroughFace(int index, @NotNull ItemStack stack, @NotNull Direction direction)
    {
        return (index == OUTPUT_SLOT) || (index == WATER_INPUT_SLOT && stack.is(Items.BUCKET));
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
    public void fillStackedContents(@NotNull StackedContents contents)
    {
        for (ItemStack itemstack : this.items)
        {
            contents.accountStack(itemstack);
        }
    }

    private static boolean brew(RegistryAccess registryAccess, @javax.annotation.Nullable RecipeHolder<?> recipe, FluidStack fluidStackInput, NonNullList<ItemStack> ingredients, VillagerBrewingStationBlockEntity brewingStation)
    {
        if (recipe != null && canBrew(registryAccess, recipe, fluidStackInput, ingredients, brewingStation))
        {
            FluidStack fluidStackResult = ((VillagerBrewingStationRecipe) recipe.value()).assembleFluidResult(new VillagerBrewingStationInput(fluidStackInput, ingredients), registryAccess);
            brewingStation.fluidTank.setFluid(fluidStackResult);
            playSound(brewingStation.getLevel(), brewingStation.getBlockPos(), SoundEvents.BREWING_STAND_BREW);
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

    private static boolean canBrew(RegistryAccess registryAccess, RecipeHolder<?> recipe, FluidStack fluidStackInput, NonNullList<ItemStack> ingredients, VillagerBrewingStationBlockEntity brewingStation)
    {
        boolean canBrew = false;
        if (brewingStation.hasEnoughItems(ingredients) && recipe != null)
        {
            FluidStack fluidStackResult = ((VillagerBrewingStationRecipe) recipe.value()).assembleFluidResult(new VillagerBrewingStationInput(fluidStackInput, ingredients), registryAccess);
            if (!fluidStackResult.isEmpty())
            {
                canBrew = true;
            }
        }
        return canBrew;
    }

    private NonNullList<ItemStack> getIngredientItem()
    {
        NonNullList<ItemStack> temp = NonNullList.withSize(SLOTS_FOR_INGREDIENT.length, ItemStack.EMPTY);
        int i = 0;
        int m = 0;
        for (ItemStack item : this.items)
        {
            if (i != 0 && i != 13 && i != 14)
            {
                temp.set(m, item);
                m++;
            }
            i++;
        }
        return temp;
    }

    @javax.annotation.Nullable
    public static <T extends BlockEntity> BlockEntityTicker<T> createBrewingStationTicker(
            Level level, BlockEntityType<T> serverType, BlockEntityType<VillagerBrewingStationBlockEntity> clientType
    )
    {
        return level.isClientSide ? null : createTickerHelper(serverType, clientType, VillagerBrewingStationBlockEntity::serverTick);
    }

    @javax.annotation.Nullable
    public static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> serverType, BlockEntityType<E> clientType, BlockEntityTicker<? super E> ticker)
    {
        return clientType == serverType ? (BlockEntityTicker<A>) ticker : null;
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider registries)
    {
        return saveWithoutMetadata(registries);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void setChanged()
    {
        if (level instanceof ServerLevel serverLevel)
        {
            serverLevel.getChunkSource().blockChanged(getBlockPos());
        }
        super.setChanged();
    }

    private static void playSound(Level level, BlockPos pos, SoundEvent pSound)
    {
        if (level != null)
        {
            level.playSound(null, pos, pSound, SoundSource.BLOCKS, 1.0F, 1.0F);
        }
    }
}
