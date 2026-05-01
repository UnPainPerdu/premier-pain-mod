package com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.cooking_pot_block;

import com.unpainperdu.premierpainmod.util.register.recipe.RecipeSerializerRegister;
import com.unpainperdu.premierpainmod.util.register.recipe.RecipeTypeRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import org.jetbrains.annotations.NotNull;

public class CookingPotRecipe implements Recipe<CookingPotInput>
{
    private final SizedFluidIngredient inputFluid;
    private final Ingredient inputItem;
    private final ItemStack result;
    private PlacementInfo placementInfo;

    public CookingPotRecipe(SizedFluidIngredient inputFluid, Ingredient inputItem, ItemStack result)
    {
        this.inputFluid = inputFluid;
        this.inputItem = inputItem;
        this.result = result;
    }

    @Override
    public boolean matches(@NotNull CookingPotInput input, @NotNull Level level)
    {
        FluidStack fluidInput = input.fluidInput();
        ItemStack itemInput = input.itemInput();
        Ingredient wantedIngredient = this.inputItem;
        SizedFluidIngredient wantedFluid = this.inputFluid;
        boolean canCook = true;
        if (!wantedFluid.test(fluidInput))
        {
            canCook = false;
        }
        if (!wantedIngredient.test(itemInput))
        {
            canCook = false;
        }
        return canCook;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull CookingPotInput input, HolderLookup.@NotNull Provider registries)
    {
        return this.result.copy();
    }


    public ItemStack getResultItem()
    {
        return this.result;
    }

    public Ingredient getInputItem()
    {
        return this.inputItem;
    }

    public SizedFluidIngredient getInputFluid()
    {
        return this.inputFluid;
    }

    @Override
    public RecipeSerializer<? extends Recipe<CookingPotInput>> getSerializer()
    {
        return RecipeSerializerRegister.COOKING_POT_SERIALIZER.get();
    }

    @Override
    public @NotNull RecipeType<? extends Recipe<CookingPotInput>> getType()
    {
        return RecipeTypeRegister.COOKING_POT_RECIPE_TYPE.get();
    }

    @Override
    public PlacementInfo placementInfo()
    {
        if (this.placementInfo == null)
        {
            this.placementInfo = PlacementInfo.create(this.getInputItem());
        }

        return this.placementInfo;
    }

    @Override
    public RecipeBookCategory recipeBookCategory()
    {
        return null;
    }

    @Override
    public boolean isSpecial()
    {
        return true;
    }
}