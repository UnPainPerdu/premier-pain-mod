package com.unpainperdu.premierpainmod.level.world.fluid.oil;

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
import org.jetbrains.annotations.NotNull;

import static com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister.*;

public abstract class OilFluid extends WaterFluid
{
    public abstract String getName();

    @Override
    public @NotNull Fluid getFlowing()
    {
        String flowingFluidName = "flowing_" + getName() + "_fluid";
        return FLUIDS.get(flowingFluidName).get();
    }

    @Override
    public @NotNull Fluid getSource()
    {
        String fluidName = getName() + "_fluid";
        return FLUIDS.get(fluidName).get();
    }

    @Override
    public @NotNull FluidType getFluidType()
    {
        String fluidTypeName = getName() + "_type";
        return FLUID_TYPES.get(fluidTypeName).get();
    }

    public Block getLiquidBlock()
    {
        return FLUID_BLOCKS.get(getName()).get();
    }

    @Override
    protected boolean canConvertToSource(@NotNull Level level)
    {
        return false;
    }

    @Override
    public boolean canConvertToSource(@NotNull FluidState state, @NotNull Level level, @NotNull BlockPos pos)
    {
        return false;
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
