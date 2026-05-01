package com.unpainperdu.premierpainmod.level.world.block.geology;

import com.unpainperdu.premierpainmod.datagen.data.tag.mod_tags.ModBlockTags;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.ModBlockStateProperties;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import com.unpainperdu.premierpainmod.util.tool_kit.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class GrowingCrystalCluster extends AmethystBlock implements SimpleWaterloggedBlock
{
    private static final int MAX_AGE = 3;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    public static final EnumProperty<Direction> FACING = ModBlockStateProperties.DIRECTION;

    protected static final VoxelShape SHAPE_AGE_0 = Block.box(4.0, 0.0, 4.0, 12.0, 2.0, 12.0);
    protected static final VoxelShape SHAPE_AGE_1 = Block.box(4.0, 0.0, 4.0, 12.0, 4.0, 12.0);
    protected static final VoxelShape SHAPE_AGE_2 = Block.box(4.0, 0.0, 4.0, 12.0, 8.0, 12.0);
    protected static final VoxelShape SHAPE_AGE_3 = Block.box(4.0, 0.0, 4.0, 12.0, 12.0, 12.0);

    public GrowingCrystalCluster(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(WATERLOGGED, false).setValue(FACING, Direction.UP));
    }

    @Override
    protected void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random)
    {
        if (RandomUtil.getRandomPositiveIntInRange(5, random) == 0 && canGrow(state, level, pos) && state.getValue(AGE) < getMaxAge())
        {
            level.setBlockAndUpdate(pos, state.setValue(AGE, state.getValue(AGE) + 1));
        }
    }

    private boolean canGrow(BlockState state, ServerLevel level, BlockPos pos)
    {
        BlockState stateBelow = level.getBlockState(pos.relative(state.getValue(FACING).getOpposite()));
        return stateBelow.is(ModBlockTags.GYPSUM);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state)
    {
        return (state.getValue(GrowingCrystalCluster.AGE) < getMaxAge() && state.getValue(GrowingCrystalCluster.WATERLOGGED));
    }

    public int getMaxAge()
    {
        return MAX_AGE;
    }

    @Override
    protected BlockState updateShape(BlockState selfState, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos selfPos, Direction direction, BlockPos facingPos, BlockState facingState, RandomSource rand)
    {
        if (selfState.getValue(WATERLOGGED))
        {
            scheduledTickAccess.createTick(selfPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return direction == selfState.getValue(FACING).getOpposite() && !selfState.canSurvive(level, selfPos)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(selfState, level, scheduledTickAccess, selfPos, direction, facingPos, facingState, rand);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos)
    {
        Direction direction = state.getValue(FACING);
        BlockPos blockpos = pos.relative(direction.getOpposite());
        return level.getBlockState(blockpos).isFaceSturdy(level, blockpos, direction);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        LevelAccessor levelaccessor = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        return this.defaultBlockState()
                .setValue(WATERLOGGED, levelaccessor.getFluidState(blockpos).getType() == Fluids.WATER)
                .setValue(FACING, context.getClickedFace());
    }

    @Override
    protected @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context)
    {
        Direction direction = state.getValue(FACING);
        int age = state.getValue(AGE);
        return switch (age)
        {
            case 3 -> getShape(SHAPE_AGE_3, direction);
            case 2 -> getShape(SHAPE_AGE_2, direction);
            case 1 -> getShape(SHAPE_AGE_1, direction);
            default -> getShape(SHAPE_AGE_0, direction);
        };
    }

    private VoxelShape getShape(VoxelShape shape, Direction direction)
    {
        return VoxelShapeHelper.fromVoxelShape(shape)
                .rotateFromCenterByDirection(direction)
                .toVoxelShape();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(WATERLOGGED, AGE, FACING);
    }

    @Override
    protected @NotNull FluidState getFluidState(BlockState pState)
    {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    protected @NotNull BlockState rotate(BlockState state, Rotation rotation)
    {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    protected @NotNull BlockState mirror(BlockState state, Mirror mirror)
    {
        return state.setValue(FACING, mirror.rotation().rotate(state.getValue(FACING)));
    }
}