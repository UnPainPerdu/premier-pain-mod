package com.unpainperdu.premierpainmod.level.world.block.twoBlockWidth;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.state.properties.TwoBlockWidthPart;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public abstract class AbstractTwoBlockWidth extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock
{
    public static final EnumProperty<TwoBlockWidthPart> PART;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public AbstractTwoBlockWidth(Properties pProperties)
    {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, TwoBlockWidthPart.RIGHT).setValue(WATERLOGGED, Boolean.FALSE));
    }
    @Override
    protected abstract MapCodec<? extends HorizontalDirectionalBlock> codec();

    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos)
    {
        if (pState.getValue(WATERLOGGED))
        {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }
        TwoBlockWidthPart twoBlockWidthPart = pState.getValue(PART);
        if (pFacing != getNeighbourDirection((TwoBlockWidthPart) pState.getValue(PART), DirectionSwitcher(pState.getValue(FACING))))
        {
            return twoBlockWidthPart == TwoBlockWidthPart.RIGHT && pFacing == reverseDirectionSwitcher(pState.getValue(FACING)) && !pState.canSurvive(pLevel, pCurrentPos)
                    ? Blocks.AIR.defaultBlockState()
                    : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
        }
        else
        {
            return pFacingState.is(this) && pFacingState.getValue(PART) != pState.getValue(PART)
                    ? (BlockState)pState
                    : Blocks.AIR.defaultBlockState();
        }
    }
    @Override
    protected @NotNull FluidState getFluidState(BlockState pState)
    {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    private static Direction getNeighbourDirection(TwoBlockWidthPart pPart, Direction pDirection)
    {
        return pPart == TwoBlockWidthPart.RIGHT ? pDirection : pDirection.getOpposite();
    }

    public BlockState playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer)
    {
        if (!pLevel.isClientSide && (pPlayer.isCreative() || !pPlayer.hasCorrectToolForDrops(pState, pLevel, pPos)))
        {
            preventCreativeDropFromRightPart(pLevel, pPos, pState, pPlayer);
        }

        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
        return pState;
    }
    //Pète le bloc de droite si gauche cassé
    protected static void preventCreativeDropFromRightPart(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer)
    {
        TwoBlockWidthPart twoBlockWidthPart = (TwoBlockWidthPart)pState.getValue(PART);
        if (twoBlockWidthPart == TwoBlockWidthPart.LEFT)
        {
            BlockPos blockpos = pPos.relative(reverseDirectionSwitcher(pState.getValue(FACING)));
            BlockState blockstate = pLevel.getBlockState(blockpos);
            if (blockstate.is(pState.getBlock()) && blockstate.getValue(PART) == TwoBlockWidthPart.RIGHT)
            {
                BlockState blockstate1 = blockstate.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                pLevel.setBlock(blockpos, blockstate1, 35);
                pLevel.levelEvent(pPlayer, 2001, blockpos, Block.getId(blockstate));
            }
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext)
    {
        Level level = pContext.getLevel();
        Direction direction = pContext.getHorizontalDirection();
        BlockPos blockpos = pContext.getClickedPos();
        BlockPos blockpos1 = blockpos.relative(DirectionSwitcher(direction));
        FluidState fluidstateDown = level.getFluidState(blockpos);
        boolean flag = fluidstateDown.getType() == Fluids.WATER;

        return level.getBlockState(blockpos1).canBeReplaced(pContext) && level.getWorldBorder().isWithinBounds(blockpos1) ? (BlockState)this.defaultBlockState().setValue(FACING, direction).setValue(WATERLOGGED, Boolean.valueOf(flag)) : null;
    }

    @Override
    public abstract VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_);

    protected static Direction DirectionSwitcher(Direction direction)
    {
        switch (direction)
        {
            case Direction.WEST:
            {
                return Direction.SOUTH;
            }
            case Direction.EAST:
            {
                return Direction.NORTH;
            }
            case Direction.SOUTH:
            {
                return Direction.EAST;
            }
            default:
            {
                return Direction.WEST;
            }
        }
    }
    protected static Direction reverseDirectionSwitcher(Direction direction)
    {
        switch (direction)
        {
            case Direction.WEST:
            {
                return Direction.NORTH;
            }
            case Direction.EAST:
            {
                return Direction.SOUTH;
            }
            case Direction.SOUTH:
            {
                return Direction.WEST;
            }
            default:
            {
                return Direction.EAST;
            }
        }
    }
    static
    {
        PART = EnumProperty.create("villagerworkshoppart", TwoBlockWidthPart.class);
    }

    protected abstract void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder);

    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack)
    {
        BlockPos blockpos1 = pPos.relative(DirectionSwitcher(pState.getValue(FACING)));
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
        if (!pLevel.isClientSide)
        {
            FluidState fluidstateUp = pLevel.getFluidState(blockpos1);
            boolean flag = fluidstateUp.getType() == Fluids.WATER;
            BlockPos blockpos = pPos.relative(DirectionSwitcher(pState.getValue(FACING)));
            pLevel.setBlock(blockpos, (BlockState)pState.setValue(PART, TwoBlockWidthPart.LEFT).setValue(WATERLOGGED, Boolean.valueOf(flag)), 3);
            pLevel.blockUpdated(pPos, Blocks.AIR);
            pState.updateNeighbourShapes(pLevel, pPos, 3);
        }
    }
    @Override
    protected BlockState rotate(BlockState pState, Rotation pRot)
    {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }
}
