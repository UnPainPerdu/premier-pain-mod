package com.unpainperdu.premierpainmod.level.world.item.crafting.villagerWorkshopRecipe;

import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.recipe.RecipeSerializer;
import com.unpainperdu.premierpainmod.util.register.recipe.RecipeTypeRegister;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class VillagerWorkshopRecipe extends SingleItemRecipe
{
    public VillagerWorkshopRecipe(String pGroup, Ingredient pIngredient, ItemStack pResult)
    {
        super(RecipeTypeRegister.VILLAGER_WORKSHOP_RECIPE_TYPE, RecipeSerializer.VILLAGER_WORKSHOP_SERIALIZER.get(), pGroup, pIngredient, pResult);
    }

    @Override
    public boolean matches(SingleRecipeInput singleRecipeInput, Level level)
    {
        return this.ingredient.test(singleRecipeInput.item());
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(BlockRegister.VILLAGER_WORKSHOP);
    }

    public static class Serializer<VillagerWorkshopRecipe extends SingleItemRecipe> extends SingleItemRecipe.Serializer<VillagerWorkshopRecipe>
    {
        public Serializer(SingleItemRecipe.Factory<VillagerWorkshopRecipe> factory)
        {
            super(factory);
        }
    }
}
