package com.unpainperdu.premierpainmod.level.world.block.vegetation.two_block_height.sky_spears;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractTallGrass;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
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
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SkySpearsFlower extends Block
{
    public static final MapCodec<SkySpearsFlower> CODEC = simpleCodec(SkySpearsFlower::new);

    public SkySpearsFlower(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any());
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random)
    {
        if (RandomUtil.getRandomIntInRange(100, random) >= 80)
        {
            if (level.getBlockState(pos.below()).is(BlockTags.DIRT))
            {
                if (level.getBlockState(pos.above()).isAir())
                {
                    level.setBlock(pos, BlockRegister.SKY_SPEARS.get().defaultBlockState().setValue(SkySpears.HALF, DoubleBlockHalf.LOWER), 2);
                    level.setBlock(pos.above(), BlockRegister.SKY_SPEARS.get().defaultBlockState().setValue(SkySpears.HALF, DoubleBlockHalf.UPPER), 2);
                }
            }
        }
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
        BlockState stateBelow = level.getBlockState(pos.below());
        if (stateBelow == BlockRegister.SKY_SPEARS.get().defaultBlockState().setValue(AbstractTallGrass.HALF, DoubleBlockHalf.UPPER)
                || stateBelow.is(BlockTags.DIRT)
        )
        {
            flag = true;
        }
        return flag;
    }

    @Override
    public MapCodec<SkySpearsFlower> codec()
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
        return Block.box(0, 0, 0, 16, 16, 16).move(vec3.x, vec3.y, vec3.z);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state)
    {
        return true;
    }
}