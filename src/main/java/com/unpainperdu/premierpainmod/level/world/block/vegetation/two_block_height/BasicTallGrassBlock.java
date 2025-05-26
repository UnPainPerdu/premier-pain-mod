package com.unpainperdu.premierpainmod.level.world.block.vegetation.two_block_height;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractTallGrass;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class BasicTallGrassBlock extends AbstractTallGrass
{
    public static final MapCodec<BasicTallGrassBlock> CODEC = simpleCodec(BasicTallGrassBlock::new);

    public BasicTallGrassBlock(Properties properties)
    {
        super(properties, BlockTags.DIRT);
    }

    @Override
    public MapCodec<BasicTallGrassBlock> codec()
    {
        return CODEC;
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity)
    {

    }
}
