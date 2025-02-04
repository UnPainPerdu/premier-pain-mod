package com.unpainperdu.premierpainmod.util.register.recipe;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.villagerBrewingStation.VillagerBrewingStationRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.VillagerWorkshopRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RecipeTypeRegister
{
    private RecipeTypeRegister(){}

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPE = DeferredRegister.create(Registries.RECIPE_TYPE, PremierPainMod.MOD_ID);

    public static final DeferredHolder<RecipeType<?>,RecipeType<VillagerWorkshopRecipe>> VILLAGER_WORKSHOP_RECIPE_TYPE = registerType("villager_workshopping");
    public static final DeferredHolder<RecipeType<?>,RecipeType<VillagerBrewingStationRecipe>> VILLAGER_BREWING_STATION_RECIPE_TYPE = registerType("villager_brewing");

    private static <T extends Recipe<?>> DeferredHolder<RecipeType<?>,RecipeType<T>> registerType(String name)
    {
        return RECIPE_TYPE.register( name, () -> new RecipeType<T>()
        {
            @Override
            public String toString()
            {
                return name;
            }
        });
    }
    public static void register(IEventBus modEventBus)
    {
        RECIPE_TYPE.register(modEventBus);
        RecipeSerializerRegister.register(modEventBus);
    }
}
