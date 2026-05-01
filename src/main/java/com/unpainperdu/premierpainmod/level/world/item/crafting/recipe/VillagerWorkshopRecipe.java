package com.unpainperdu.premierpainmod.level.world.item.crafting.recipe;

import com.unpainperdu.premierpainmod.util.register.recipe.RecipeSerializerRegister;
import com.unpainperdu.premierpainmod.util.register.recipe.RecipeTypeRegister;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class VillagerWorkshopRecipe extends SingleItemRecipe
{
    public VillagerWorkshopRecipe(String group, Ingredient ingredient, ItemStack result)
    {
        super(group, ingredient, result);
    }

    @Override
    public RecipeSerializer<? extends SingleItemRecipe> getSerializer()
    {
        return RecipeSerializerRegister.VILLAGER_WORKSHOP_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends SingleItemRecipe> getType()
    {
        return RecipeTypeRegister.VILLAGER_WORKSHOP_RECIPE_TYPE.get();
    }

    @Override
    public RecipeBookCategory recipeBookCategory()
    {
        return null;
    }

    public ItemStack result() {
        return super.result();
    }

    @Override
    public boolean matches(SingleRecipeInput singleRecipeInput, Level level)
    {
        return this.input().test(singleRecipeInput.item());
    }

    public static class Serializer<VillagerWorkshopRecipe extends SingleItemRecipe> extends SingleItemRecipe.Serializer<VillagerWorkshopRecipe>
    {
        public Serializer(SingleItemRecipe.Factory<VillagerWorkshopRecipe> factory)
        {
            super(factory);
        }
    }

    @Override
    public boolean isSpecial()
    {
        return true;
    }
}