package com.unpainperdu.premierpainmod.level.world.item.crafting.villagerWorkshopRecipe;

import com.unpainperdu.premierpainmod.util.register.RecipeTypeRegister;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class TestRecipe extends VillagerWorkshopRecipe
{
    public TestRecipe(String group, Ingredient ingredient, ItemStack result)
    {
        super(RecipeTypeRegister.VILLAGER_WORKSHOP_RECIPE_TYPE, RecipeTypeRegister.VILLAGER_WORKSHOPPING.get(), group, ingredient, result);
    }
}
