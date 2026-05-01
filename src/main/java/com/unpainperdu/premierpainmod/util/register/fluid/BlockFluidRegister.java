package com.unpainperdu.premierpainmod.util.register.fluid;

import com.unpainperdu.premierpainmod.level.world.block.fluid.BeerBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;

import static com.unpainperdu.premierpainmod.util.register.block.BlockRegister.BLOCKS;
import static com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister.FLUIDS;
import static com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister.FLUID_BLOCKS;
import static com.unpainperdu.premierpainmod.util.register.fluid.FluidTypeRegister.BEER_TYPE;
import static com.unpainperdu.premierpainmod.util.register.fluid.FluidTypeRegister.OIL_TYPE;
import static net.minecraft.world.level.block.Blocks.WATER;

public class BlockFluidRegister
{
    //liquid block zone, see FluidRegister too
    //beer
    private static final BlockBehaviour.Properties fluidStandardProperties = BlockBehaviour.Properties.of().replaceable().noCollission().strength(100.0F).pushReaction(PushReaction.DESTROY).noLootTable().liquid().sound(SoundType.EMPTY);

    public static void registerFluidBlock(String name, String type)
    {
        String flowingFluidName = "flowing_" + name + "_fluid";
        switch (type)
        {
            case BEER_TYPE ->
                    FLUID_BLOCKS.put(name, registerBlockOnly(name, () -> new BeerBlock((FlowingFluid) FLUIDS.get(flowingFluidName).get(), fluidStandardProperties)));
            case OIL_TYPE ->
                    FLUID_BLOCKS.put(name, registerBlockOnly(name, () -> new LiquidBlock((FlowingFluid) FLUIDS.get(flowingFluidName).get(), fluidStandardProperties)));
            default ->
                    FLUID_BLOCKS.put(name, registerBlockOnly(name, () -> new LiquidBlock((FlowingFluid) FLUIDS.get(flowingFluidName).get(), BlockBehaviour.Properties.ofFullCopy(WATER))));
        }
    }

    private static DeferredBlock<Block> registerBlockOnly(String name, Supplier<Block> block)
    {
        return BLOCKS.register(name, block);
    }
}