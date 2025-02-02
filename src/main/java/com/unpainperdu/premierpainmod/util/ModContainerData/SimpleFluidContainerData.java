package com.unpainperdu.premierpainmod.util.ModContainerData;

import net.neoforged.neoforge.fluids.FluidStack;

public class SimpleFluidContainerData implements IFluidStackContainerData
{
    private final FluidStack[] fluidStacks;

    public SimpleFluidContainerData(int size)
    {
        this.fluidStacks = new FluidStack[size];
    }

    @Override
    public FluidStack get(int index)
    {
        return this.fluidStacks[index];
    }

    @Override
    public void set(int index, FluidStack fluidStack)
    {
        this.fluidStacks[index] = fluidStack;
    }

    @Override
    public int getCount() {
        return this.fluidStacks.length;
    }
}
