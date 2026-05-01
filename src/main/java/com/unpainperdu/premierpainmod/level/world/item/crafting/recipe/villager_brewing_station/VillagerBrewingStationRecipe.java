package com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.villager_brewing_station;

import com.unpainperdu.premierpainmod.util.register.recipe.RecipeSerializerRegister;
import com.unpainperdu.premierpainmod.util.register.recipe.RecipeTypeRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

import java.util.ArrayList;
import java.util.List;

public class VillagerBrewingStationRecipe implements Recipe<VillagerBrewingStationInput>
{
    private final SizedFluidIngredient inputFluid;
    private final List<Ingredient> inputItem;
    private final FluidStack result;
    private PlacementInfo placementInfo;

    public VillagerBrewingStationRecipe(SizedFluidIngredient inputFluid, List<Ingredient> inputItem, FluidStack result)
    {
        this.inputFluid = inputFluid;
        this.inputItem = inputItem;
        this.result = result;
    }

    @Override
    public boolean matches(VillagerBrewingStationInput input, Level level)
    {
        boolean flag = true;
        if (!this.inputFluid.test(input.fluidStack()))
        {
            flag = false;
        }
        List<Ingredient> ingredientList = new ArrayList<>(this.inputItem);
        List<ItemStack> itemStacks = input.itemStacks();

        for (Ingredient ingredient : ingredientList)
        {
            boolean flagIngr = false;

            for (ItemStack itemStack : itemStacks)
            {
                if (ingredient.test(itemStack))
                {
                    flagIngr = true;
                }
            }
            if (!flagIngr)
            {
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public ItemStack assemble(VillagerBrewingStationInput input, HolderLookup.Provider registries)
    {
        return new ItemStack(Blocks.AIR);
    }

    public FluidStack assembleFluidResult(VillagerBrewingStationInput input, HolderLookup.Provider registries)
    {
        return this.result.copy();
    }

    public List<Ingredient> getInputItems()
    {
        return inputItem;
    }

    public SizedFluidIngredient getInputFluid()
    {
        return inputFluid;
    }

    public FluidStack getResultFluid()
    {
        return result;
    }

    @Override
    public RecipeSerializer<? extends Recipe<VillagerBrewingStationInput>> getSerializer()
    {
        return RecipeSerializerRegister.VILLAGER_BREWING_STATION_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<VillagerBrewingStationInput>> getType()
    {
        return RecipeTypeRegister.VILLAGER_BREWING_STATION_RECIPE_TYPE.get();
    }

    @Override
    public PlacementInfo placementInfo()
    {
        if (this.placementInfo == null)
        {
            this.placementInfo = PlacementInfo.create(this.getInputItems());
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