package com.unpainperdu.premierpainmod.util.ModContainerData;

import net.neoforged.neoforge.fluids.FluidStack;

public interface IFluidStackContainerData
{
    FluidStack get(int index);

    void set(int index, FluidStack fluidStack);

    int getCount();
}
