package com.unpainperdu.premierpainmod.level.world.item.crafting.builders;

import com.unpainperdu.premierpainmod.level.world.item.crafting.villagerWorkshopRecipe.TestRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.ItemLike;

public class VillagerWorkshopRecipeBuilder extends SingleItemRecipeBuilder
{
    public VillagerWorkshopRecipeBuilder(RecipeCategory p_251425_, SingleItemRecipe.Factory<?> p_312361_, Ingredient p_251221_, ItemLike p_251302_, int p_250964_)
    {
        super(p_251425_, p_312361_, p_251221_, p_251302_, p_250964_);
    }
    public static SingleItemRecipeBuilder villagerWorkshoping(Ingredient pIngredient, RecipeCategory pCategory, ItemLike pResult)
    {
        return new SingleItemRecipeBuilder(pCategory, TestRecipe::new, pIngredient, pResult, 1);
    }

    public static SingleItemRecipeBuilder villagerWorkshoping(Ingredient pIngredient, RecipeCategory pCategory, ItemLike pResult, int pCount)
    {
        return new SingleItemRecipeBuilder(pCategory, TestRecipe::new, pIngredient, pResult, pCount);
    }
}
