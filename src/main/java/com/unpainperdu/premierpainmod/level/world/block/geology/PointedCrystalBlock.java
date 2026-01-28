package com.unpainperdu.premierpainmod.level.world.block.geology;

import com.unpainperdu.premierpainmod.level.world.block.state.propertie.ModBlockStateProperties;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.PointedCrystalState;
import com.unpainperdu.premierpainmod.util.tool_kit.VoxelShapeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class PointedCrystalBlock extends AmethystBlock implements SimpleWaterloggedBlock
{
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final EnumProperty<PointedCrystalState> POINTED_CRYSTAL_STATE = ModBlockStateProperties.POINTED_CRYSTAL_STATE;

    protected static final VoxelShape SHAPE_TOP = Block.box(5.0, 0.0, 5.0, 11.0, 12.0, 11.0);
    protected static final VoxelShape SHAPE_START_TOP = Block.box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
    protected static final VoxelShape SHAPE_MIDDLE = Block.box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
    protected static final VoxelShape SHAPE_BASE = Block.box(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);

    public PointedCrystalBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false).setValue(FACING, Direction.UP).setValue(POINTED_CRYSTAL_STATE, PointedCrystalState.TOP));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(WATERLOGGED, FACING, POINTED_CRYSTAL_STATE);
    }

    @Override
    protected @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context)
    {
        Direction direction = state.getValue(FACING);
        PointedCrystalState pointedCrystalState = state.getValue(POINTED_CRYSTAL_STATE);
        return switch (pointedCrystalState)
        {
            case PointedCrystalState.BASE -> getShape(SHAPE_BASE, direction);
            case PointedCrystalState.MIDDLE -> getShape(SHAPE_MIDDLE, direction);
            case PointedCrystalState.START_TOP -> getShape(SHAPE_START_TOP, direction);
            default -> getShape(SHAPE_TOP, direction);
        };
    }

    private VoxelShape getShape(VoxelShape shape, Direction direction)
    {
        return VoxelShapeHelper.fromVoxelShape(shape)
                .rotateFromCenterByDirection(direction)
                .toVoxelShape();
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        LevelAccessor levelaccessor = context.getLevel();
        BlockPos wantedPlacementPos = context.getClickedPos();
        Direction wantedDirection = context.getClickedFace();

        return this.defaultBlockState()
                .setValue(WATERLOGGED, levelaccessor.getFluidState(wantedPlacementPos).getType() == Fluids.WATER)
                .setValue(FACING, wantedDirection);
    }

    @Override
    protected @NotNull BlockState updateShape(@NotNull BlockState selfState, @NotNull Direction direction, @NotNull BlockState facingState, @NotNull LevelAccessor level, @NotNull BlockPos selfPos, @NotNull BlockPos facingPos)
    {
        if (selfState.getValue(WATERLOGGED))
        {
            level.scheduleTick(selfPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        if (selfState.canSurvive(level, selfPos))
        {
            BlockState finalState = selfState;
            Direction currentDirection = selfState.getValue(FACING);
            BlockPos nextPointedBlockPos = selfPos.relative(currentDirection);
            BlockPos previousPointedBlockPos = selfPos.relative(currentDirection.getOpposite());
            BlockState nextBlockState = level.getBlockState(nextPointedBlockPos);
            BlockState previousBlockState = level.getBlockState(previousPointedBlockPos);
            if (!(nextBlockState.is(this) && nextBlockState.getValue(FACING) == currentDirection))
            {
                finalState = selfState.setValue(POINTED_CRYSTAL_STATE, PointedCrystalState.TOP);
            }
            else
            {
                if (!(previousBlockState.is(this) && previousBlockState.getValue(FACING) == currentDirection))
                {
                    switch (nextBlockState.getValue(POINTED_CRYSTAL_STATE))
                    {
                        case TOP -> finalState = selfState.setValue(POINTED_CRYSTAL_STATE, PointedCrystalState.START_TOP);
                        case START_TOP -> finalState = selfState.setValue(POINTED_CRYSTAL_STATE, PointedCrystalState.MIDDLE);
                        case MIDDLE -> finalState = selfState.setValue(POINTED_CRYSTAL_STATE, PointedCrystalState.BASE);
                    }
                }
                else
                {
                    switch (nextBlockState.getValue(POINTED_CRYSTAL_STATE))
                    {
                        case TOP -> finalState = selfState.setValue(POINTED_CRYSTAL_STATE, PointedCrystalState.START_TOP);
                        case START_TOP -> finalState = selfState.setValue(POINTED_CRYSTAL_STATE, PointedCrystalState.MIDDLE);
                    }
                }
            }
            return super.updateShape(finalState, direction, facingState, level, selfPos, facingPos);
        }
        else
        {
            return Blocks.AIR.defaultBlockState();
        }
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos)
    {
        Direction direction = state.getValue(FACING);
        BlockPos oppositePos = pos.relative(direction.getOpposite());
        BlockState oppositeState = level.getBlockState(oppositePos);
        Block opposeiteBlock = oppositeState.getBlock();
        return oppositeState.isFaceSturdy(level, oppositePos, direction) || (opposeiteBlock instanceof PointedCrystalBlock && oppositeState.getValue(FACING) == direction);
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
