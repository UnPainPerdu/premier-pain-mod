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

public abstract class CraneNoirFluid extends BeerFluid
{
    @Override
    public ParticleOptions getFoam()
    {
        return ParticleTypeRegister.BLOND_BEER_FOAM.get();
    }

    @Override
    public Item getGlass()
    {
        return ItemRegister.CRANE_NOIR_GLASS.get();
    }

    @Override
    public Item getBottle()
    {
        return ItemRegister.CRANE_NOIR_BOTTLE.get();
    }

    @Override
    public Item getMug()
    {
        return ItemRegister.CRANE_NOIR_MUG.get();
    }

    @Override
    public Item getBucket()
    {
        return ItemRegister.CRANE_NOIR_BUCKET.get();
    }

    @Override
    public Fluid getFlowing()
    {
        return FluidRegister.FLOWING_CRANE_NOIR_FLUID.get();
    }

    @Override
    public Fluid getSource()
    {
        return FluidRegister.CRANE_NOIR_FLUID.get();
    }

    @Override
    public FluidType getFluidType()
    {
        return FluidTypeRegister.CRANE_NOIR_TYPE.get();
    }

    @Override
    public Block getLiquidBlock()
    {
        return BlockRegister.CRANE_NOIR.get();
    }

    public static class Flowing extends CraneNoirFluid
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

    public static class Source extends CraneNoirFluid
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
