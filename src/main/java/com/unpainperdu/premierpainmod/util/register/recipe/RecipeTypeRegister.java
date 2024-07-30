package com.unpainperdu.premierpainmod.util.register.recipe;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import com.unpainperdu.premierpainmod.level.world.item.crafting.villagerWorkshopRecipe.VillagerWorkshopRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RecipeTypeRegister
{
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPE = DeferredRegister.create(Registries.RECIPE_TYPE, PremierPainMod.MODID);

    public static final RecipeType<VillagerWorkshopRecipe> VILLAGER_WORKSHOP_RECIPE_TYPE = registerType("villager_workshopping");

    private static <T extends Recipe<?>> RecipeType<T> registerType(String name)
    {
        return new RecipeType<T>()
        {
            @Override
            public String toString()
            {
                return name;
            }
        };
    }
    public static void register(IEventBus modEventBus)
    {
        RECIPE_TYPE.register(modEventBus);
        RecipeSerializer.register(modEventBus);
    }
}
