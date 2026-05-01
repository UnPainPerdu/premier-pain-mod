package com.unpainperdu.premierpainmod.level.world.fluid.beer;

import com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
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
import org.jetbrains.annotations.NotNull;

public abstract class BeerFluid extends WaterFluid
{
    public abstract Item getGlass();

    public abstract Item getBottle();

    public abstract Item getMug();

    public abstract ParticleOptions getFoam();

    public abstract String getName();

    @Override
    public @NotNull Fluid getFlowing()
    {
        return AllInOneFluidRegister.getFlowingFluid(getName()).get();
    }

    @Override
    public @NotNull Fluid getSource()
    {
        return AllInOneFluidRegister.getFluid(getName()).get();
    }

    @Override
    public @NotNull FluidType getFluidType()
    {
        return AllInOneFluidRegister.getFluidType(getName()).get();
    }

    public Block getLiquidBlock()
    {
        return AllInOneFluidRegister.getBlock(getName()).get();
    }

    @Override
    protected boolean canConvertToSource(@NotNull ServerLevel level)
    {
        return false;
    }

    @Override
    public boolean canConvertToSource(@NotNull FluidState state, @NotNull ServerLevel level, @NotNull BlockPos pos)
    {
        return false;
    }

    @Override
    public void animateTick(Level level, BlockPos pos, @NotNull FluidState state, @NotNull RandomSource random)
    {
        BlockPos blockpos = pos.above();
        if (level.getBlockState(blockpos).isAir() && !level.getBlockState(blockpos).isSolidRender())
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
    public boolean isSame(@NotNull Fluid fluid)
    {
        return fluid == getSource() || fluid == getFlowing();
    }

    @Override
    public @NotNull BlockState createLegacyBlock(@NotNull FluidState state)
    {
        return getLiquidBlock().defaultBlockState().setValue(LiquidBlock.LEVEL, getLegacyLevel(state));
    }
}