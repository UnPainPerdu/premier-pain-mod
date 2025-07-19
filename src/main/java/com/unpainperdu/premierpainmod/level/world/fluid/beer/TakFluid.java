package com.unpainperdu.premierpainmod.level.world.fluid.beer;

import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.ParticleTypeRegister;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.NotNull;

public abstract class TakFluid extends BeerFluid
{
    public static final String NAME = "tak";

    @Override
    public ParticleOptions getFoam()
    {
        return ParticleTypeRegister.AMBER_BEER_FOAM.get();
    }

    @Override
    public Item getGlass()
    {
        return ItemRegister.TAK_GLASS.get();
    }

    @Override
    public Item getBottle()
    {
        return ItemRegister.TAK_BOTTLE.get();
    }

    @Override
    public Item getMug()
    {
        return ItemRegister.TAK_MUG.get();
    }

    @Override
    public @NotNull Item getBucket()
    {
        return ItemRegister.TAK_BUCKET.get();
    }

    @Override
    public String getName()
    {
        return NAME;
    }

    public static class Flowing extends TakFluid
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

    public static class Source extends TakFluid
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
