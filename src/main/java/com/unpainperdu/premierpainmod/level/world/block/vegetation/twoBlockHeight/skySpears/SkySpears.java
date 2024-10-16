package com.unpainperdu.premierpainmod.level.world.block.vegetation.twoBlockHeight.skySpears;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstractBlock.AbstractTallGrass;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import com.unpainperdu.premierpainmod.util.toolKit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SkySpears extends AbstractTallGrass
{
    public static final MapCodec<SkySpears> CODEC = simpleCodec(SkySpears::new);

    public SkySpears(Properties properties)
    {
        super(properties, BlockTags.DIRT);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random)
    {
        if (state.getValue(SkySpears.HALF) == DoubleBlockHalf.UPPER && level.getBlockState(pos.above()).isAir())
        {
            if (RandomUtil.getRandomIntInRange(100, random) >= 65)
            {
               level.setBlock(pos.above(), BlockRegister.SKY_SPEARS_FLOWER.get().defaultBlockState(), 2);
            }
        }
    }

    @Override
    public MapCodec<SkySpears> codec()
    {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context)
    {
        return Block.box(0,0,0,16,16,16);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state)
    {
        return true;
    }
}
