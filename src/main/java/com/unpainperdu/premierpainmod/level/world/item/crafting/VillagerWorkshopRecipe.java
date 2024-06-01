package com.unpainperdu.premierpainmod.level.world.item.crafting;

import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.RecipeTypeRegister;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;

public class VillagerWorkshopRecipe extends SingleItemRecipe
{
    public VillagerWorkshopRecipe(String pGroup, Ingredient pIngredient, ItemStack pResult)
    {
        super(RecipeTypeRegister.VILLAGER_WORKSHOP_RECIPE_TYPE, RecipeTypeRegister.VILLAGER_WORKSHOPPING.get(), pGroup, pIngredient, pResult);
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel)
    {
        return this.ingredient.test(pContainer.getItem(0));
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(BlockRegister.VILLAGER_WORKSHOP);
    }

    public static class Serializer<T extends VillagerWorkshopRecipe> extends SingleItemRecipe.Serializer<T>
    {

        public Serializer(SingleItemRecipe.Factory<T> factory)
        {
            super(factory);
        }
    }
}
