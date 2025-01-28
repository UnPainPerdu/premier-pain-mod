package com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.villagerBrewingStation;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

public class VillagerBrewingStationSerializer implements RecipeSerializer<VillagerBrewingStationRecipe>
{
    public static final MapCodec<VillagerBrewingStationRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            SizedFluidIngredient.NESTED_CODEC.fieldOf("fluidInput").forGetter(VillagerBrewingStationRecipe::getInputFluid),
            Ingredient.LIST_CODEC.fieldOf("ingredients").forGetter(VillagerBrewingStationRecipe::getInputItems),
            FluidStack.CODEC.fieldOf("fluidResult").forGetter(VillagerBrewingStationRecipe::getResultFluid)
    ).apply(inst, VillagerBrewingStationRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, VillagerBrewingStationRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    SizedFluidIngredient.STREAM_CODEC, VillagerBrewingStationRecipe::getInputFluid,
                    Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list()), VillagerBrewingStationRecipe::getInputItems,
                    FluidStack.STREAM_CODEC, VillagerBrewingStationRecipe::getResultFluid,
                    VillagerBrewingStationRecipe::new
            );

    @Override
    public MapCodec<VillagerBrewingStationRecipe> codec()
    {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, VillagerBrewingStationRecipe> streamCodec()
    {
        return STREAM_CODEC;
    }
}