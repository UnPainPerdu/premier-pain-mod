package com.unpainperdu.premierpainmod.level.world.fluid.beer;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.WaterFluid;
import net.neoforged.neoforge.fluids.FluidType;

import static com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister.*;

public abstract class BeerFluid extends WaterFluid
{
    public abstract Item getGlass();

    public abstract Item getBottle();

    public abstract Item getMug();

    public abstract ParticleOptions getFoam();

    public abstract String getName();

    @Override
    public Fluid getFlowing()
    {
        String flowingFluidName = "flowing_" + getName() + "_fluid";
        return FLUIDS.get(flowingFluidName).get();
    }

    @Override
    public Fluid getSource()
    {
        String fluidName = getName() + "_fluid";
        return FLUIDS.get(fluidName).get();
    }

    @Override
    public FluidType getFluidType()
    {
        String fluidTypeName = getName() + "_type";
        return FLUID_TYPES.get(fluidTypeName).get();
    }

    public Block getLiquidBlock()
    {
        return FLUID_BLOCKS.get(getName()).get();
    }

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

    @Override
    public void animateTick(Level level, BlockPos pos, FluidState state, RandomSource random)
    {
        BlockPos blockpos = pos.above();
        if (level.getBlockState(blockpos).isAir() && !level.getBlockState(blockpos).isSolidRender(level, blockpos))
        {
            if (random.nextInt(1) == 0)
            {
                double d0 = (double) pos.getX() + random.nextDouble();
                double d1 = (double) pos.getY() + 1.0;
                double d2 = (double) pos.getZ() + random.nextDouble();
                level.addParticle(getFoam(), d0, d1, d2, 0.0, 0.0, 0.0);
            }
        }
        super.animateTick(level, pos, state, random);
    }

    @Override
    public boolean isSame(Fluid fluid)
    {
        return fluid == getSource() || fluid == getFlowing();
    }

    @Override
    public BlockState createLegacyBlock(FluidState state)
    {
        return getLiquidBlock().defaultBlockState().setValue(LiquidBlock.LEVEL, Integer.valueOf(getLegacyLevel(state)));
    }
}
