package com.unpainperdu.premierpainmod.level.world.block.abstractBlock;


import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.AdaptableSitShape;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.ModBlockStateProperties;
import com.unpainperdu.premierpainmod.util.toolKit.DirectionHelper;
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
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public abstract class AbstractAdaptableSit extends Block implements SimpleWaterloggedBlock
{
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<AdaptableSitShape> ADAPTABLE_SIT = ModBlockStateProperties.ADAPTABLE_SIT_SHAPE;

    public AbstractAdaptableSit(Properties properties)
    {
        super(properties);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext)
    {
        BlockPos pos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        FluidState fluidstate = level.getFluidState(pos);
        Direction direction = pContext.getHorizontalDirection();

        BlockPos leftPos = DirectionHelper.getLeftPos(pos, direction);
        BlockPos rightPos = DirectionHelper.getRightPos(pos, direction);
        Boolean leftFlag = isWithSameDirection(level, leftPos, direction);
        Boolean rightFlag = isWithSameDirection(level, rightPos, direction);

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
    protected BlockState updateShape(BlockState selfState, Direction direction, BlockState facingState, LevelAccessor level, BlockPos selfPos, BlockPos facingPos)
    {
        if (selfState.getValue(WATERLOGGED))
        {
            level.scheduleTick(selfPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        Direction currentDirection = selfState.getValue(FACING);
        BlockPos leftPos = DirectionHelper.getLeftPos(selfPos, currentDirection);
        BlockPos rightPos = DirectionHelper.getRightPos(selfPos, currentDirection);

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
    public abstract VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context);

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(ADAPTABLE_SIT, FACING, WATERLOGGED);
    }

    @Override
    protected BlockState rotate(BlockState pState, Rotation pRot)
    {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }

    @Override
    protected @NotNull FluidState getFluidState(BlockState pState)
    {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    public abstract MapCodec<? extends AbstractAdaptableSit> codec();

    protected Boolean isWithSameDirection(LevelAccessor level, BlockPos pos, Direction directionWanted)
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
