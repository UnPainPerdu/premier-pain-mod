package com.unpainperdu.premierpainmod.level.world.fluid.beer;

import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.fluid.FluidRegister;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.fluid.FluidTypeRegister;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidType;

public abstract class PainDieuxFluid extends BeerFluid
{

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
    public Fluid getFlowing()
    {
        return FluidRegister.FLOWING_PAIN_DIEUX_FLUID.get();
    }

    @Override
    public Fluid getSource()
    {
        return FluidRegister.PAIN_DIEUX_FLUID.get();
    }

    @Override
    public FluidType getFluidType()
    {
        return FluidTypeRegister.PAIN_DIEUX_TYPE.get();
    }

    @Override
    public boolean isSame(Fluid fluid)
    {
        return fluid == FluidRegister.PAIN_DIEUX_FLUID.get() || fluid == FluidRegister.FLOWING_PAIN_DIEUX_FLUID.get();
    }

    @Override
    public BlockState createLegacyBlock(FluidState state)
    {
        return BlockRegister.PAIN_DIEUX.get().defaultBlockState().setValue(LiquidBlock.LEVEL, Integer.valueOf(getLegacyLevel(state)));
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
