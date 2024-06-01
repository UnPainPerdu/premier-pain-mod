package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.world.item.crafting.Recipe;
import com.unpainperdu.premierpainmod.level.world.item.crafting.VillagerWorkshopRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@SuppressWarnings({"rawtypes", "unchecked"})
public class RecipeTypeRegister
{
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPE = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, PremierPainMod.MODID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, PremierPainMod.MODID);

    public static final RecipeType<VillagerWorkshopRecipe> VILLAGER_WORKSHOP_RECIPE_TYPE = registerType("villager_workshopping");
    public static final DeferredHolder<RecipeSerializer<VillagerWorkshopRecipe>,RecipeSerializer<VillagerWorkshopRecipe>> VILLAGER_WORKSHOPPING = register("villager_workshopping", () -> new VillagerWorkshopRecipe.Serializer(VillagerWorkshopRecipe::new), VILLAGER_WORKSHOP_RECIPE_TYPE);

    private static <T extends Recipe<?>> DeferredHolder<RecipeSerializer<?>,RecipeSerializer<T>> register(final String name, final Supplier<RecipeSerializer<T>> serializer, RecipeType<T> recipeType)
    {
        return RECIPE_SERIALIZERS.register(name, serializer);
    }
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
        RECIPE_SERIALIZERS.register(modEventBus);
    }
}
