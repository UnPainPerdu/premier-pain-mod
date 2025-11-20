package com.unpainperdu.premierpainmod.level.world.fluid.oil;

import com.unpainperdu.premierpainmod.util.register.Item.ItemRegister;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.NotNull;

public abstract class MorichePalmOilFluid extends OilFluid
{
    public static final String NAME = "moriche_palm_oil";

    @Override
    public @NotNull Item getBucket()
    {
        return ItemRegister.MORICHE_PALM_OIL_BUCKET.get();
    }

    @Override
    public String getName()
    {
        return NAME;
    }

    public static class Flowing extends MorichePalmOilFluid
    {
        @Override
        protected void createFluidStateDefinition(StateDefinition.@NotNull Builder<Fluid, FluidState> builder)
        {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState state)
        {
            return state.getValue(LEVEL);
        }

        @Override
        public boolean isSource(@NotNull FluidState state)
        {
            return false;
        }
    }

    public static class Source extends MorichePalmOilFluid
    {
        @Override
        public int getAmount(@NotNull FluidState state)
        {
            return 8;
        }

        @Override
        public boolean isSource(@NotNull FluidState state)
        {
            return true;
        }
    }
}

