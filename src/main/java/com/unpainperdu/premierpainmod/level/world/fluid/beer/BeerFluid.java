package com.unpainperdu.premierpainmod.level.world.fluid.beer;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.WaterFluid;

public abstract class BeerFluid extends WaterFluid
{
    public abstract Item getGlass();

    public abstract Item getBottle();

    public abstract Item getMug();

    @Override
    protected boolean canConvertToSource(Level level)
    {
        return false;
    }

    @Override
    public boolean canConvertToSource(FluidState state, Level level, BlockPos pos)
    {
        return false;
    }
}
