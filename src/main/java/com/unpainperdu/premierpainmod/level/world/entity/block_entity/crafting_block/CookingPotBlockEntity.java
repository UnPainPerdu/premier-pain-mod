package com.unpainperdu.premierpainmod.level.world.entity.block_entity.crafting_block;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.all_materials_block.VillagerBrewingStationBlockEntity;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.cooking_pot_block.CookingPotInput;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.cooking_pot_block.CookingPotRecipe;
import com.unpainperdu.premierpainmod.level.world.menu.menu.all_materials_block.CookingPotMenu;
import com.unpainperdu.premierpainmod.util.register.block.BlockEntityRegister;
import com.unpainperdu.premierpainmod.util.register.recipe.RecipeTypeRegister;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeCraftingHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CookingPotBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, RecipeCraftingHolder, StackedContentsCompatible
{
    private static final int FLUID_INPUT = 0;
    private static final int[] ITEM_INPUT = new int[]{1,2,3};
    private static final int[] ITEM_OUTPUT = new int[]{4,5,6};
    private static final int FLUID_OUTPUT = 7;
    public static final int SLOT_NUMBER = 8;
    private NonNullList<ItemStack> items = NonNullList.withSize(SLOT_NUMBER, ItemStack.EMPTY);
    private FluidTank fluidTank;
    private static final int MAX_COOKING_TIME = 60;
    private int cookingTime = 0;

    public final ContainerData dataAccess = new ContainerData()
    {
        @Override
        public int get(int dataIndex)
        {
            if (dataIndex == 0)
            {
                return CookingPotBlockEntity.this.getCookingTime();
            }
            return 0;
        }

        @Override
        public void set(int dataIndex, int newValue)
        {
            if (dataIndex == 0)
            {
                CookingPotBlockEntity.this.setCookingTime(newValue);
            }
        }

        @Override
        public int getCount()
        {
            return 1;
        }
    };
    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
    private final RecipeManager.CachedCheck<CookingPotInput, ? extends CookingPotRecipe> quickCheck;

    public CookingPotBlockEntity(BlockPos pos, BlockState blockState)
    {
        super(BlockEntityRegister.COOKING_POT_BLOCK_ENTITY.get(), pos, blockState);
        this.fluidTank = new FluidTank(1000);
        this.quickCheck = RecipeManager.createCheck(RecipeTypeRegister.COOKING_POT_RECIPE_TYPE.get());
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int containerId, @NotNull Inventory inventory)
    {
        return new CookingPotMenu(containerId, inventory, this);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, VillagerBrewingStationBlockEntity blockEntity)
    {

    }

    @Override
    public int @NotNull [] getSlotsForFace(@NotNull Direction side)
    {
        return new int[0];
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, @NotNull ItemStack itemStack, @Nullable Direction direction)
    {
        return true;
    }

    @Override
    public boolean canTakeItemThroughFace(int index, @NotNull ItemStack stack, @NotNull Direction direction)
    {
        return true;
    }

    @Override
    protected @NotNull Component getDefaultName()
    {
        return Component.translatable("container." + PremierPainMod.MOD_ID + ".cooking_pot_block");
    }

    @Override
    protected @NotNull NonNullList<ItemStack> getItems()
    {
        return this.items;
    }

    @Override
    protected void setItems(@NotNull NonNullList<ItemStack> items)
    {
        this.items = items;
    }

    @Override
    public int getContainerSize()
    {
        return SLOT_NUMBER;
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

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.loadAdditional(tag, registries);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(tag, this.items, registries);
        fluidTank.readFromNBT(registries, tag.getCompound("tank"));
        this.cookingTime = tag.getInt("cooking_time");
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
        tag.putInt("cooking_time", this.cookingTime);
        ContainerHelper.saveAllItems(tag, this.items, registries);
        CompoundTag compoundTagFluidTank = new CompoundTag();
        fluidTank.writeToNBT(registries, compoundTagFluidTank);
        tag.put("tank", compoundTagFluidTank);
        CompoundTag compoundTagRecipe = new CompoundTag();
        this.recipesUsed.forEach((p_187449_, p_187450_) -> compoundTagRecipe.putInt(p_187449_.toString(), p_187450_));
        tag.put("RecipesUsed", compoundTagRecipe);
    }

    public void setCookingTime(int cookingTime)
    {
        this.cookingTime = cookingTime;
    }

    public int getCookingTime()
    {
        return cookingTime;
    }
}
