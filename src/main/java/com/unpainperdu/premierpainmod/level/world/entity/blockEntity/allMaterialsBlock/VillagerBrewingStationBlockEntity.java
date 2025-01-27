package com.unpainperdu.premierpainmod.level.world.entity.blockEntity.allMaterialsBlock;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerBrewingStation;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.LiquidContent;
import com.unpainperdu.premierpainmod.level.world.menu.menu.allMaterialsBlock.VillagerBrewingStationMenu;
import com.unpainperdu.premierpainmod.util.register.BlockEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.WaterFluid;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VillagerBrewingStationBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, RecipeCraftingHolder, StackedContentsCompatible
{
    private static final int WATER_INPUT_SLOT = 0;
    private static final int[] SLOTS_FOR_WATER = new int[]{0};
    private static final int INGREDIENT_INPUT_SLOT_0 = 1;
    private static final int INGREDIENT_INPUT_SLOT_1 = 2;
    private static final int INGREDIENT_INPUT_SLOT_2 = 3;
    private static final int INGREDIENT_INPUT_SLOT_3 = 4;
    private static final int INGREDIENT_INPUT_SLOT_4 = 5;
    private static final int INGREDIENT_INPUT_SLOT_5 = 6;
    private static final int INGREDIENT_INPUT_SLOT_6 = 7;
    private static final int INGREDIENT_INPUT_SLOT_7 = 8;
    private static final int INGREDIENT_INPUT_SLOT_8 = 9;
    private static final int INGREDIENT_INPUT_SLOT_9 = 10;
    private static final int INGREDIENT_INPUT_SLOT_10 = 11;
    private static final int INGREDIENT_INPUT_SLOT_11 = 12;
    private static final int[] SLOTS_FOR_INPUT = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
    private static final int OUTPUT_SLOT = 13;
    private static final int[] SLOTS_FOR_OUTPUT = new int[]{13, WATER_INPUT_SLOT};
    private static final int SLOTS_NUMBER = 14;
    public static final int BREWING_TIME_STANDARD = 2000;
    public static final int DATA_BREWING_PROGRESS = 0;
    public static final int DATA_BREWING_TOTAL_TIME = 1;
    //int brewingProgress;
    //int brewingTotalTime;
    private NonNullList<ItemStack> items = NonNullList.withSize(SLOTS_NUMBER, ItemStack.EMPTY);
    private FluidTank fluidTank;
    /*
    protected final ContainerData dataAccess = new ContainerData()
    {
        @Override
        public int get(int dataIndex)
        {
            switch (dataIndex)
            {
                case 0:
                    return VillagerBrewingStationBlockEntity.this.brewingProgress;
                case 1:
                    return VillagerBrewingStationBlockEntity.this.brewingTotalTime;
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
     */

    //private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();

    public VillagerBrewingStationBlockEntity(BlockPos pos, BlockState blockState)
    {
        super(BlockEntityRegister.VILLAGER_BREWING_STATION_ENTITY.get(), pos, blockState);
        this.fluidTank = new FluidTank(1000);
    }

    @Override
    protected Component getDefaultName()
    {
        return Component.translatable("container."+ PremierPainMod.MOD_ID +".villager_brewing_station");
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player)
    {
        return VillagerBrewingStationMenu.VillagerBrewingStationMenu(id, player, this);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.loadAdditional(tag, registries);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(tag, this.items, registries);
        fluidTank.readFromNBT(registries, tag.getCompound("tank"));
        //this.brewingProgress = tag.getInt("BrewTime");
        //this.brewingTotalTime = tag.getInt("BrewTimeTotal");
        //CompoundTag compoundtag = tag.getCompound("RecipesUsed");
        /*
        for (String s : compoundtag.getAllKeys())
        {
            this.recipesUsed.put(ResourceLocation.parse(s), compoundtag.getInt(s));
        }

         */
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.saveAdditional(tag, registries);
        //tag.putInt("BrewTime", this.brewingProgress);
        //tag.putInt("BrewTimeTotal", this.brewingTotalTime);
        ContainerHelper.saveAllItems(tag, this.items, registries);
        CompoundTag compoundTagFluidTank = new CompoundTag();
        fluidTank.writeToNBT(registries, compoundTagFluidTank);
        tag.put("tank", compoundTagFluidTank);
        //CompoundTag compoundTagRecipe = new CompoundTag();
        //this.recipesUsed.forEach((p_187449_, p_187450_) -> compoundTagRecipe.putInt(p_187449_.toString(), p_187450_));
        //tag.put("RecipesUsed", compoundTagRecipe);
    }


    public static void serverTick(Level level, BlockPos pos, BlockState state, VillagerBrewingStationBlockEntity blockEntity)
    {
        if (blockEntity.fluidTank.isEmpty())
        {
            NonNullList<ItemStack> itemStacks = blockEntity.items;
            if (itemStacks.get(WATER_INPUT_SLOT).is(Items.WATER_BUCKET))
            {
                blockEntity.fluidTank.fill(new FluidStack(Fluids.WATER, 1000), IFluidHandler.FluidAction.EXECUTE);
                level.setBlock(pos, state.setValue(VillagerBrewingStation.LEVEL, 4).setValue(VillagerBrewingStation.CONTENT, LiquidContent.WATER), 3);
                itemStacks.set(WATER_INPUT_SLOT, new ItemStack(Items.BUCKET));
                blockEntity.setItems(itemStacks);
                blockEntity.setChanged();
            }
        }
        /*
        boolean flag1 = false;

        List<ItemStack>  itemStacks = blockEntity.items;
        ItemStack itemstack = blockEntity.items.get(1);
        ItemStack itemstack1 = blockEntity.items.get(0);
        boolean hasEnoughItems = blockEntity.hasEnoughItems(itemStacks);
        if (hasEnoughItems && isFull(blockEntity))
        {
            //RecipeHolder<?> recipeholder = blockEntity.quickCheck.getRecipeFor(new SingleRecipeInput(itemstack1), level).orElse(null);

            int i = blockEntity.getMaxStackSize();

            if (!blockEntity.isLit() && canBurn(level.registryAccess(), recipeholder, blockEntity.items, i, blockEntity))
            {
                blockEntity.litTime = blockEntity.getBurnDuration(itemstack);
                blockEntity.litDuration = blockEntity.litTime;
                if (blockEntity.isLit())
                {
                    flag1 = true;
                    if (itemstack.hasCraftingRemainingItem())
                    {
                        blockEntity.items.set(1, itemstack.getCraftingRemainingItem());
                    }
                    else
                    if (flag3)
                    {
                        Item item = itemstack.getItem();
                        itemstack.shrink(1);
                        if (itemstack.isEmpty())
                        {
                            blockEntity.items.set(1, itemstack.getCraftingRemainingItem());
                        }
                    }
                }
            }

            if (blockEntity.isLit() && canBurn(level.registryAccess(), recipeholder, blockEntity.items, i, blockEntity))
            {
                blockEntity.cookingProgress++;
                if (blockEntity.cookingProgress == blockEntity.cookingTotalTime)
                {
                    blockEntity.cookingProgress = 0;
                    blockEntity.cookingTotalTime = getTotalCookTime(level, blockEntity);
                    if (burn(level.registryAccess(), recipeholder, blockEntity.items, i, blockEntity))
                    {
                        blockEntity.setRecipeUsed(recipeholder);
                    }

                    flag1 = true;
                }
            }
            else
            {
                blockEntity.cookingProgress = 0;
            }
        }
        else if (!blockEntity.isLit() && blockEntity.cookingProgress > 0)
        {
            blockEntity.cookingProgress = Mth.clamp(blockEntity.cookingProgress - 2, 0, blockEntity.cookingTotalTime);
        }

        if (flag != blockEntity.isLit())
        {
            flag1 = true;
            state = state.setValue(AbstractFurnaceBlock.LIT, Boolean.valueOf(blockEntity.isLit()));
            level.setBlock(pos, state, 3);
        }

        if (flag1)
        {
            setChanged(level, pos, state);
        }

    }
*/

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
        return i >= 3;
    }

    //todo
    protected boolean isFilled()
    {
        return false;
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
            case Direction.UP -> {return SLOTS_FOR_INPUT;}
            default -> {return SLOTS_FOR_WATER;}
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
        return clientType == serverType ? (BlockEntityTicker<A>)ticker : null;
    }
}
