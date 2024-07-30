package com.unpainperdu.premierpainmod.util.register.recipe;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.item.crafting.villagerWorkshopRecipe.VillagerWorkshopRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RecipeSerializer
{
    public static final DeferredRegister<net.minecraft.world.item.crafting.RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, PremierPainMod.MODID);

    public static final DeferredHolder<net.minecraft.world.item.crafting.RecipeSerializer<VillagerWorkshopRecipe>, net.minecraft.world.item.crafting.RecipeSerializer<VillagerWorkshopRecipe>> VILLAGER_WORKSHOP_SERIALIZER = register("villager_workshopping", () -> new VillagerWorkshopRecipe.Serializer(VillagerWorkshopRecipe::new), RecipeTypeRegister.VILLAGER_WORKSHOP_RECIPE_TYPE);

    private static <T extends Recipe<?>> DeferredHolder<net.minecraft.world.item.crafting.RecipeSerializer<?>, net.minecraft.world.item.crafting.RecipeSerializer<T>> register(final String name, final Supplier<net.minecraft.world.item.crafting.RecipeSerializer<T>> serializer, RecipeType<T> recipeType)
    {
        return RECIPE_SERIALIZERS.register(name, serializer);
    }
    public static void register(IEventBus modEventBus)
    {
        RECIPE_SERIALIZERS.register(modEventBus);
    }
}
