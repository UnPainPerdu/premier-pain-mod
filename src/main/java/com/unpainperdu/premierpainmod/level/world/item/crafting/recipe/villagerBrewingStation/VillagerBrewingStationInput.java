package com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.villagerBrewingStation;

import com.unpainperdu.premierpainmod.level.world.entity.blockEntity.allMaterialsBlock.VillagerBrewingStationBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.neoforged.neoforge.fluids.FluidStack;

import java.util.List;

public record VillagerBrewingStationInput(FluidStack fluidStack, List<ItemStack> itemStacks) implements RecipeInput
{
    @Override
    public ItemStack getItem(int index)
    {
        if (index > VillagerBrewingStationBlockEntity.SLOTS_FOR_INGREDIENT.length) throw new IllegalArgumentException("No item for index" + index);
        return this.itemStacks.get(index);
    }

    @Override
    public int size()
    {
        return this.itemStacks.toArray().length;
    }
}
