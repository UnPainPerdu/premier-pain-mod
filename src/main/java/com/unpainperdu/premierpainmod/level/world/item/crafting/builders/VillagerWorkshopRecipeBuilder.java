package com.unpainperdu.premierpainmod.level.world.item.crafting.builders;

import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.VillagerWorkshopRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.ItemLike;

public class VillagerWorkshopRecipeBuilder extends SingleItemRecipeBuilder
{
    public VillagerWorkshopRecipeBuilder(RecipeCategory category, SingleItemRecipe.Factory<?> factory, Ingredient ingredient, ItemLike itemLike, int count)
    {
        super(category, factory, ingredient, itemLike, count);
    }

    public static SingleItemRecipeBuilder villagerWorkshoping(Ingredient ingredient, RecipeCategory category, ItemLike result, int count)
    {
        return new SingleItemRecipeBuilder(category, VillagerWorkshopRecipe::new, ingredient, result, count);
    }
}