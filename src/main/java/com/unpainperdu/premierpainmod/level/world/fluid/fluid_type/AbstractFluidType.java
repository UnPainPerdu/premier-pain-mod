package com.unpainperdu.premierpainmod.level.world.fluid.fluid_type;

import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidType;

public abstract class AbstractFluidType extends FluidType
{
    public AbstractFluidType(Properties properties)
    {
        super(properties);
    }

    public abstract IClientFluidTypeExtensions register();
}