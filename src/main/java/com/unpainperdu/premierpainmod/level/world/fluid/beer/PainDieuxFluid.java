package com.unpainperdu.premierpainmod.level.world.fluid.beer;

import com.unpainperdu.premierpainmod.util.register.Item.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.ParticleTypeRegister;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public abstract class PainDieuxFluid extends BeerFluid
{
    public static final String NAME = "pain_dieux";

    @Override
    public ParticleOptions getFoam()
    {
        return ParticleTypeRegister.BLOND_BEER_FOAM.get();
    }

    @Override
    public Item getGlass()
    {
        return ItemRegister.PAIN_DIEUX_GLASS.get();
    }

    @Override
    public Item getBottle()
    {
        return ItemRegister.PAIN_DIEUX_BOTTLE.get();
    }

    @Override
    public Item getMug()
    {
        return ItemRegister.PAIN_DIEUX_MUG.get();
    }

    @Override
    public Item getBucket()
    {
        return ItemRegister.PAIN_DIEUX_BUCKET.get();
    }

    @Override
    public String getName()
    {
        return NAME;
    }

    public static class Flowing extends PainDieuxFluid
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

    public static class Source extends PainDieuxFluid
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
