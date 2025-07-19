package com.unpainperdu.premierpainmod.level.world.fluid.beer;

import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.ParticleTypeRegister;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.NotNull;

public abstract class LaChateauFluid extends BeerFluid
{
    public static final String NAME = "la_chateau";

    @Override
    public ParticleOptions getFoam()
    {
        return ParticleTypeRegister.BROWN_BEER_FOAM.get();
    }

    @Override
    public Item getGlass()
    {
        return ItemRegister.LA_CHATEAU_GLASS.get();
    }

    @Override
    public Item getBottle()
    {
        return ItemRegister.LA_CHATEAU_BOTTLE.get();
    }

    @Override
    public Item getMug()
    {
        return ItemRegister.LA_CHATEAU_MUG.get();
    }

    @Override
    public @NotNull Item getBucket()
    {
        return ItemRegister.LA_CHATEAU_BUCKET.get();
    }

    @Override
    public String getName()
    {
        return NAME;
    }

    public static class Flowing extends LaChateauFluid
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

    public static class Source extends LaChateauFluid
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
