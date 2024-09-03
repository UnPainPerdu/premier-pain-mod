package com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;

public class CactusFlowerBlock extends Block
{
    public static final MapCodec<CactusFlowerBlock> CODEC = simpleCodec(CactusFlowerBlock::new);

    public CactusFlowerBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any());
    }

    @Override
    protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom)
    {
        if (!pState.canSurvive(pLevel, pPos))
        {
            pLevel.destroyBlock(pPos, true);
        }
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState pFacingState, LevelAccessor level, BlockPos pos, BlockPos pFacingPos)
    {
        if (!state.canSurvive(level, pos))
        {
            level.scheduleTick(pos, this, 1);
        }

        return super.updateShape(state, direction, pFacingState, level, pos, pFacingPos);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos)
    {
        boolean flag = false;
        if (level.getBlockState(pos.below()).getBlock() instanceof FloweredCactusBlock)
        {
            if (level.getBlockState(pos.below()).getValue(FloweredCactusBlock.PART_NUM) == 1)
            {
                flag = true;
            }
        }
        if (level.getBlockState(pos.below()).is(BlockTags.SAND) || level.getBlockState(pos.below()).is(BlockTags.DIRT))
        {
            flag = true ;
        }
        return flag;
    }

    @Override
    public MapCodec<CactusFlowerBlock> codec()
    {
        return CODEC;
    }

    @Override
    protected boolean isPathfindable(BlockState pState, PathComputationType pPathComputationType)
    {
        return false;
    }
}
