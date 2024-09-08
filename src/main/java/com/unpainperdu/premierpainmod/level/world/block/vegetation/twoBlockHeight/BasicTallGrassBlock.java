package com.unpainperdu.premierpainmod.level.world.block.vegetation.twoBlockHeight;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstractBlock.AbstractTallGrass;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BasicTallGrassBlock extends AbstractTallGrass
{
    public static final MapCodec<BasicTallGrassBlock> CODEC = simpleCodec(BasicTallGrassBlock::new);

    public BasicTallGrassBlock(Properties properties)
    {
        super(properties, BlockTags.DIRT);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context)
    {
        return Block.box(0,0,0,16,16,16);
    }

    @Override
    public MapCodec<BasicTallGrassBlock> codec()
    {
        return CODEC;
    }
}
