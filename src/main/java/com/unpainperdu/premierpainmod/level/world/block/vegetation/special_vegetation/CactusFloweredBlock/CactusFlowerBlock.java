package com.unpainperdu.premierpainmod.level.world.block.vegetation.special_vegetation.CactusFloweredBlock;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

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
    protected BlockState updateShape(BlockState selfState, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos selfPos, Direction direction, BlockPos facingPos, BlockState facingState, RandomSource rand)
    {
        if (!selfState.canSurvive(level, selfPos))
        {
            scheduledTickAccess.createTick(selfPos, this, 1);
        }

        return super.updateShape(selfState, level, scheduledTickAccess, selfPos, direction, facingPos, facingState, rand);
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
            flag = true;
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

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        Vec3 vec3 = state.getOffset(pos);
        return Block.box(5, 0, 5, 11, 10, 11).move(vec3.x, vec3.y, vec3.z);
    }
}