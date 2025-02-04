package com.unpainperdu.premierpainmod.integration.jei;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.VillagerWorkshopRecipe;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.villager_brewing_station.VillagerBrewingStationRecipe;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.resources.ResourceLocation;

public class JEIRecipeType
{
    public static final ResourceLocation VILLAGER_WORKSHOP_TYPE_ID = ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "villager_workshopping");
    public static final ResourceLocation VILLAGER_BREWING_STATION_TYPE_ID = ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "villager_brewing");

    public static final RecipeType<VillagerWorkshopRecipe> VILLAGER_WORKSHOP_TYPE = new RecipeType<VillagerWorkshopRecipe>(VILLAGER_WORKSHOP_TYPE_ID, VillagerWorkshopRecipe.class);

    public static final RecipeType<VillagerBrewingStationRecipe> VILLAGER_BREWING_STATION_TYPE = new RecipeType<VillagerBrewingStationRecipe>(VILLAGER_BREWING_STATION_TYPE_ID, VillagerBrewingStationRecipe.class);
}
