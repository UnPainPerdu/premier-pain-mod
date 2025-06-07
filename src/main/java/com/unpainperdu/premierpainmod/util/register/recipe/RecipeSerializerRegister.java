package com.unpainperdu.premierpainmod.util.register.recipe;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.VillagerWorkshopRecipe;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.villager_brewing_station.VillagerBrewingStationRecipe;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.villager_brewing_station.VillagerBrewingStationSerializer;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RecipeSerializerRegister
{
    private RecipeSerializerRegister()
    {
    }

    public static final DeferredRegister<net.minecraft.world.item.crafting.RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, PremierPainMod.MOD_ID);

    public static final DeferredHolder<net.minecraft.world.item.crafting.RecipeSerializer<?>, net.minecraft.world.item.crafting.RecipeSerializer<VillagerWorkshopRecipe>> VILLAGER_WORKSHOP_SERIALIZER = RECIPE_SERIALIZERS.register("villager_workshopping", () -> new VillagerWorkshopRecipe.Serializer<>(VillagerWorkshopRecipe::new));
    public static final DeferredHolder<net.minecraft.world.item.crafting.RecipeSerializer<?>, net.minecraft.world.item.crafting.RecipeSerializer<VillagerBrewingStationRecipe>> VILLAGER_BREWING_STATION_SERIALIZER = RECIPE_SERIALIZERS.register("villager_brewing", VillagerBrewingStationSerializer::new);

    public static void register(IEventBus modEventBus)
    {
        RECIPE_SERIALIZERS.register(modEventBus);
    }
}
