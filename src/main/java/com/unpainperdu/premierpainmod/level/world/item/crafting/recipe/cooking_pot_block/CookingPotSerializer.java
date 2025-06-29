package com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.cooking_pot_block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

public class CookingPotSerializer implements RecipeSerializer<CookingPotRecipe>
{

    public static final MapCodec<CookingPotRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            SizedFluidIngredient.NESTED_CODEC.fieldOf("fluidInput").forGetter(CookingPotRecipe::getInputFluid),
            Ingredient.CODEC.fieldOf("ingredient").forGetter(CookingPotRecipe::getInputItem),
            ItemStack.CODEC.fieldOf("result").forGetter(CookingPotRecipe::getResultItem)
    ).apply(inst, CookingPotRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, CookingPotRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    SizedFluidIngredient.STREAM_CODEC, CookingPotRecipe::getInputFluid,
                    Ingredient.CONTENTS_STREAM_CODEC, CookingPotRecipe::getInputItem,
                    ItemStack.STREAM_CODEC, CookingPotRecipe::getResultItem,
                    CookingPotRecipe::new
            );

    @Override
    public MapCodec<CookingPotRecipe> codec()
    {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, CookingPotRecipe> streamCodec()
    {
        return STREAM_CODEC;
    }
}
