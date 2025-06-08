package com.unpainperdu.premierpainmod.util.register.fluid;

import net.minecraft.world.level.material.Fluid;

import java.util.function.Supplier;

import static com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister.FLUIDS;
import static com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister.FLUID_REGISTRIES;

public class FluidRegister
{

    private FluidRegister()
    {
    }

    public static <T extends Fluid> void registerFluid(String name, Supplier<Fluid> source, Supplier<Fluid> flowing)
    {
        String fluidName = name + "_fluid";
        String flowingFluidName = "flowing_" + name + "_fluid";
        FLUIDS.put(fluidName, FLUID_REGISTRIES.register(fluidName, source));
        FLUIDS.put(flowingFluidName, FLUID_REGISTRIES.register(flowingFluidName, flowing));
    }
}
