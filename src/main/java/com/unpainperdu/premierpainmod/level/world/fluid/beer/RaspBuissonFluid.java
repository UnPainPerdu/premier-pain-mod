package com.unpainperdu.premierpainmod.level.world.fluid.beer;

import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.ParticleTypeRegister;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public abstract class RaspBuissonFluid extends BeerFluid
{
    private final String NAME = "raspbuisson";

    @Override
    public ParticleOptions getFoam()
    {
        return ParticleTypeRegister.DARK_RED_BEER_FOAM.get();
    }

    @Override
    public Item getGlass()
    {
        return ItemRegister.RASPBUISSON_GLASS.get();
    }

    @Override
    public Item getBottle()
    {
        return ItemRegister.RASPBUISSON_BOTTLE.get();
    }

    @Override
    public Item getMug()
    {
        return ItemRegister.RASPBUISSON_MUG.get();
    }

    @Override
    public Item getBucket()
    {
        return ItemRegister.RASPBUISSON_BUCKET.get();
    }

    @Override
    public String getName()
    {
        return NAME;
    }

    public static class Flowing extends RaspBuissonFluid
    {
        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder)
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
        public boolean isSource(FluidState state)
        {
            return false;
        }
    }

    public static class Source extends RaspBuissonFluid
    {
        @Override
        public int getAmount(FluidState state)
        {
            return 8;
        }

        @Override
        public boolean isSource(FluidState state)
        {
            return true;
        }
    }
}
