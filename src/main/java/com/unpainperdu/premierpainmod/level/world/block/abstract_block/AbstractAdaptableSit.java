package com.unpainperdu.premierpainmod.level.world.block.abstract_block;


import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.AdaptableSitShape;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.ModBlockStateProperties;
import com.unpainperdu.premierpainmod.util.tool_kit.DirectionHelper;
import com.unpainperdu.premierpainmod.util.tool_kit.PosHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public abstract class AbstractAdaptableSit extends Block implements SimpleWaterloggedBlock
{
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<AdaptableSitShape> ADAPTABLE_SIT = ModBlockStateProperties.ADAPTABLE_SIT_SHAPE;

    protected AbstractAdaptableSit(Properties properties)
    {
        super(properties);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext)
    {
        BlockPos pos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        FluidState fluidstate = level.getFluidState(pos);
        Direction direction = pContext.getHorizontalDirection();

        BlockPos leftPos = PosHelper.getLeft(pos, direction);
        BlockPos rightPos = PosHelper.getRight(pos, direction);
        boolean leftFlag = isWithSameDirection(level, leftPos, direction);
        boolean rightFlag = isWithSameDirection(level, rightPos, direction);

        AdaptableSitShape adaptableSitShape = AdaptableSitShape.ALONE;
        if (leftFlag && rightFlag)
        {
            adaptableSitShape = AdaptableSitShape.WITH_LEFT_AND_RIGHT;
        }
        else if (leftFlag)
        {
            adaptableSitShape = AdaptableSitShape.WITH_LEFT;
        }
        else if (rightFlag)
        {
            adaptableSitShape = AdaptableSitShape.WITH_RIGHT;
        }

        boolean flag = fluidstate.getType() == Fluids.WATER;
        if (!(pos.getY() < level.getMaxBuildHeight()))
        {
            return null;
        }
        return this.defaultBlockState().setValue(WATERLOGGED, flag).setValue(FACING, direction).setValue(ADAPTABLE_SIT, adaptableSitShape);
    }

    @Override
    protected @NotNull BlockState updateShape(BlockState selfState, @NotNull Direction direction, @NotNull BlockState facingState, @NotNull LevelAccessor level, @NotNull BlockPos selfPos, @NotNull BlockPos facingPos)
    {
        if (selfState.getValue(WATERLOGGED))
        {
            level.scheduleTick(selfPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        Direction currentDirection = selfState.getValue(FACING);

        boolean isLeftPos = direction ==  DirectionHelper.getLeftDirection(currentDirection);
        boolean isRightPos = direction == DirectionHelper.getRightDirection(currentDirection);

        if (isRightPos || isLeftPos)
        {
            AdaptableSitShape selfShape = selfState.getValue(ADAPTABLE_SIT);
            if(selfShape == AdaptableSitShape.ALONE)
            {
                if (isLeftPos && facingState.is(this))
                {
                    if(facingState.getValue(FACING) == selfState.getValue(FACING))
                    {
                        return selfState.setValue(ADAPTABLE_SIT, AdaptableSitShape.WITH_LEFT);
                    }
                }
                else if(isRightPos && facingState.is(this))
                {
                    if(facingState.getValue(FACING) == selfState.getValue(FACING))
                    {
                        return selfState.setValue(ADAPTABLE_SIT, AdaptableSitShape.WITH_RIGHT);
                    }
                }
            }
            else if (selfShape == AdaptableSitShape.WITH_RIGHT)
            {
                if (isRightPos && !(facingState.is(this)))
                {
                    return selfState.setValue(ADAPTABLE_SIT, AdaptableSitShape.ALONE);
                }
                else if (isLeftPos && facingState.is(this))
                {
                    if(facingState.getValue(FACING) == selfState.getValue(FACING))
                    {
                        return selfState.setValue(ADAPTABLE_SIT, AdaptableSitShape.WITH_LEFT_AND_RIGHT);
                    }
                }
            }
            else if (selfShape == AdaptableSitShape.WITH_LEFT)
            {
                if (isLeftPos && !(facingState.is(this)))
                {
                    return selfState.setValue(ADAPTABLE_SIT, AdaptableSitShape.ALONE);
                }
                else if (isRightPos && facingState.is(this))
                {
                    if(facingState.getValue(FACING) == selfState.getValue(FACING))
                    {
                        return selfState.setValue(ADAPTABLE_SIT, AdaptableSitShape.WITH_LEFT_AND_RIGHT);
                    }
                }
            }
            else if (selfShape == AdaptableSitShape.WITH_LEFT_AND_RIGHT)
            {
                if (isLeftPos && !(facingState.is(this)))
                {
                    return selfState.setValue(ADAPTABLE_SIT, AdaptableSitShape.WITH_RIGHT);
                }
                else if (isRightPos && !(facingState.is(this)))
                {
                    return selfState.setValue(ADAPTABLE_SIT, AdaptableSitShape.WITH_LEFT);
                }
            }
        }

        return super.updateShape(selfState, direction, facingState, level, selfPos, facingPos);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context)
    {
        VoxelShape shape;
        if(state.getValue(FACING) == Direction.NORTH)
        {
            shape = Shapes.or(Block.box(0, 4, 1, 16, 7, 14), Block.box(0, 7, 1, 16, 16, 3));
        }
        else if (state.getValue(FACING) == Direction.EAST)
        {
            shape = Shapes.or(Block.box(2, 4, 0, 15, 7, 16), Block.box(13, 7, 0, 15, 16, 16));
        }
        else if (state.getValue(FACING) == Direction.WEST)
        {
            shape = Shapes.or(Block.box(1, 4, 0, 14, 7, 16), Block.box(1, 7, 0, 3, 16, 16));
        }
        else
        {
            shape = Shapes.or(Block.box(0, 4, 2, 16, 7, 15), Block.box(0, 7, 13, 16, 16, 15));
        }
        return shape;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(ADAPTABLE_SIT, FACING, WATERLOGGED);
    }

    @Override
    protected @NotNull BlockState rotate(BlockState pState, Rotation pRot)
    {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }

    @Override
    protected @NotNull FluidState getFluidState(BlockState pState)
    {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    public abstract @NotNull MapCodec<? extends AbstractAdaptableSit> codec();

    protected boolean isWithSameDirection(LevelAccessor level, BlockPos pos, Direction directionWanted)
    {
        boolean flag = false;
        BlockState stateChecked = level.getBlockState(pos);
        if(stateChecked.is(this))
        {
            flag = stateChecked.getValue(FACING) == directionWanted;
        }
        return flag;
    }
}
