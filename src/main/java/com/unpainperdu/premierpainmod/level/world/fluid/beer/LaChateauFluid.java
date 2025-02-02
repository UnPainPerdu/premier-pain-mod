package com.unpainperdu.premierpainmod.level.world.fluid.beer;

import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.ParticleTypeRegister;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.fluid.FluidRegister;
import com.unpainperdu.premierpainmod.util.register.fluid.FluidTypeRegister;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.FluidType;

public abstract class LaChateauFluid extends BeerFluid
{
    @Override
    public ParticleOptions getFoam()
    {
        return ParticleTypeRegister.BLOND_BEER_FOAM.get();
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
    public Item getBucket()
    {
        return ItemRegister.LA_CHATEAU_BUCKET.get();
    }

    @Override
    public Fluid getFlowing()
    {
        return FluidRegister.FLOWING_LA_CHATEAU_FLUID.get();
    }

    @Override
    public Fluid getSource()
    {
        return FluidRegister.LA_CHATEAU_FLUID.get();
    }

    @Override
    public FluidType getFluidType()
    {
        return FluidTypeRegister.LA_CHATEAU_TYPE.get();
    }

    @Override
    public Block getLiquidBlock()
    {
        return BlockRegister.LA_CHATEAU.get();
    }

    public static class Flowing extends LaChateauFluid
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

    public static class Source extends LaChateauFluid
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
