package com.unpainperdu.premierpainmod.level.world.block.vegetation.growing_above_vegetation;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractGrowingAboveVegetation extends Block
{
    public static final IntegerProperty MAX_HEIGHT = IntegerProperty.create("max_height", 0, 25);
    public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
    protected static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 16, 14);

    public final int max_height;

    public AbstractGrowingAboveVegetation(Properties properties, int maxHeight)
    {
        super(properties);
        this.max_height = maxHeight;
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(MAX_HEIGHT, 0));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        Vec3 vec3 = state.getOffset(pos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random)
    {
        if (!state.canSurvive(level, pos))
        {
            level.destroyBlock(pos, true);
        }
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random)
    {
        if (level.isEmptyBlock(pos.above()))
        {
            int i = 1;
            while (level.getBlockState(pos.below(i)).getBlock() instanceof AbstractGrowingAboveVegetation)
            {
                i++;
            }

            int maxHeight = state.getValue(MAX_HEIGHT);
            if (i < maxHeight)
            {
                int j = state.getValue(AGE);
                if (net.neoforged.neoforge.common.CommonHooks.canCropGrow(level, pos, state, true))
                {
                    if (j == 15)
                    {
                        level.setBlockAndUpdate(pos.above(), this.defaultBlockState().setValue(MAX_HEIGHT, maxHeight));
                        net.neoforged.neoforge.common.CommonHooks.fireCropGrowPost(level, pos.above(), this.defaultBlockState());
                        level.setBlock(pos, state.setValue(AGE, 0).setValue(MAX_HEIGHT, getRandomMaxHeight(getSeedFromPos(pos))), 4);
                    }
                    else
                    {
                        level.setBlock(pos, state.setValue(AGE, j + 1), 4);
                    }
                }
            }
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
        BlockState blockstate = level.getBlockState(pos.below());
        return blockstate.is(this) || blockstate.is(BlockTags.DIRT);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(AGE, MAX_HEIGHT);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state)
    {
        return true;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        BlockPos pos = context.getClickedPos();
        long seed = getSeedFromPos(pos);
        int randomMaxHeight = getRandomMaxHeight(seed);
        return this.defaultBlockState().setValue(MAX_HEIGHT, randomMaxHeight);
    }

    public int getRandomMaxHeight(long seed)
    {
        return ((Math.abs(RandomSource.create(seed).nextInt())) % (this.max_height - 1)) + 2;
    }

    public long getSeedFromPos(BlockPos pos)
    {
        return pos.getX() + pos.getY() + pos.getZ() + (long) (Math.abs(RandomSource.create().nextInt())) % 20;
    }
}