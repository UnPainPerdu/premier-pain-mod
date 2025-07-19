package com.unpainperdu.premierpainmod.level.world.fluid.oil;

import com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.WaterFluid;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;

public abstract class OilFluid extends WaterFluid
{
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
