package com.unpainperdu.premierpainmod.level.world.item.crafting.villagerWorkshopRecipe;

import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;

public class VillagerWorkshopRecipe extends SingleItemRecipe
{
    public VillagerWorkshopRecipe(RecipeType<?> type, RecipeSerializer<?> serializer, String pGroup, Ingredient pIngredient, ItemStack pResult)
    {
        super(type, serializer, pGroup, pIngredient, pResult);
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
