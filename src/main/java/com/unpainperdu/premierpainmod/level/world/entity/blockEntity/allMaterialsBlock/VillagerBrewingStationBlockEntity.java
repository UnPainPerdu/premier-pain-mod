package com.unpainperdu.premierpainmod.level.world.entity.blockEntity.allMaterialsBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.RecipeCraftingHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

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
    private static final int[] SLOTS_FOR_OUTPUT = new int[]{13};
    private static final int SLOTS_NUMBER = 14;
    int cookingProgress;
    private NonNullList<ItemStack> items = NonNullList.withSize(SLOTS_NUMBER, ItemStack.EMPTY);

    public VillagerBrewingStationBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState)
    {
        super(type, pos, blockState);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries)
    {

    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries)
    {

    }

    @Override
    public Component getDisplayName()
    {
        return null;
    }

    @Override
    protected Component getDefaultName()
    {
        return null;
    }

    @Override
    protected NonNullList<ItemStack> getItems()
    {
        return items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items)
    {
        this.items = items;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player)
    {
        return null;
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory)
    {
        return null;
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
        return false;
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction)
    {
        return false;
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
}
