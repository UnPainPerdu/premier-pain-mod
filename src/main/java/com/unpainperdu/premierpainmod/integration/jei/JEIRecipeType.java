package com.unpainperdu.premierpainmod.integration.jei;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.VillagerWorkshopRecipe;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.cooking_pot_block.CookingPotRecipe;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.villager_brewing_station.VillagerBrewingStationRecipe;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;

public class JEIRecipeType
{
    public static final IRecipeType<VillagerWorkshopRecipe> VILLAGER_WORKSHOP_TYPE = registerType("villager_workshopping", VillagerWorkshopRecipe.class);
    public static final IRecipeType<VillagerBrewingStationRecipe> VILLAGER_BREWING_STATION_TYPE = registerType("villager_brewing", VillagerBrewingStationRecipe.class);
    public static final IRecipeType<CookingPotRecipe> COOKING_POT_STATION_TYPE = registerType("cooking_pot", CookingPotRecipe.class);

    private static <R extends RecipeInput, T extends Recipe<R>> IRecipeType<T> registerType(String id, Class<T> recipeClass)
    {
        return IRecipeType.create(ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, id), recipeClass);
    }
}