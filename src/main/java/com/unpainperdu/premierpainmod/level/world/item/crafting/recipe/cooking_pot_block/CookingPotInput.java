package com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.cooking_pot_block;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

public record CookingPotInput(FluidStack fluidInput, ItemStack itemInput) implements RecipeInput
{
    @Override
    public @NotNull ItemStack getItem(int index) {
        if (index != 0) {
            throw new IllegalArgumentException("No item for index " + index);
        } else {
            return this.itemInput;
        }
    }

    @Override
    public int size()
    {
        return 1;
    }
}