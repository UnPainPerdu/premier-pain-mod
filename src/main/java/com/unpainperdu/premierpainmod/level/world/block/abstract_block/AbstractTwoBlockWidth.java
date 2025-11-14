package com.unpainperdu.premierpainmod.level.world.block.abstract_block;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.ModBlockStateProperties;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.TwoBlockWidthPart;
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
    public static final EnumProperty<TwoBlockWidthPart> PART = ModBlockStateProperties.TWO_BLOCK_WIDTH_PART;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public AbstractTwoBlockWidth(Properties pProperties)
    {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, TwoBlockWidthPart.RIGHT).setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    protected abstract @NotNull MapCodec<? extends HorizontalDirectionalBlock> codec();

    @Override
    protected @NotNull BlockState updateShape(BlockState state, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor level, @NotNull BlockPos currentPos, @NotNull BlockPos facingPos)
    {
        if (state.getValue(WATERLOGGED))
        {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        TwoBlockWidthPart twoBlockWidthPart = state.getValue(PART);
        if (facing != getNeighbourDirection(state.getValue(PART), DirectionSwitcher(state.getValue(FACING))))
        {
            return twoBlockWidthPart == TwoBlockWidthPart.RIGHT && facing == reverseDirectionSwitcher(state.getValue(FACING)) && !state.canSurvive(level, currentPos)
                    ? Blocks.AIR.defaultBlockState()
                    : super.updateShape(state, facing, facingState, level, currentPos, facingPos);
        }
        else
        {
            return facingState.is(this) && facingState.getValue(PART) != state.getValue(PART)
                    ? state
                    : Blocks.AIR.defaultBlockState();
        }
    }

    @Override
    protected @NotNull FluidState getFluidState(BlockState state)
    {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    private static Direction getNeighbourDirection(TwoBlockWidthPart part, Direction direction)
    {
        return part == TwoBlockWidthPart.RIGHT ? direction : direction.getOpposite();
    }

    @Override
    public @NotNull BlockState playerWillDestroy(Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Player player)
    {
        if (!level.isClientSide && (player.isCreative() || !player.hasCorrectToolForDrops(state, level, pos)))
        {
            preventCreativeDropFromRightPart(level, pos, state, player);
        }

        super.playerWillDestroy(level, pos, state, player);
        return state;
    }

    //Pète le bloc de droite si gauche cassé
    protected static void preventCreativeDropFromRightPart(Level level, BlockPos pos, BlockState state, Player player)
    {
        TwoBlockWidthPart twoBlockWidthPart = state.getValue(PART);
        if (twoBlockWidthPart == TwoBlockWidthPart.LEFT)
        {
            BlockPos blockpos = pos.relative(reverseDirectionSwitcher(state.getValue(FACING)));
            BlockState blockstate = level.getBlockState(blockpos);
            if (blockstate.is(state.getBlock()) && blockstate.getValue(PART) == TwoBlockWidthPart.RIGHT)
            {
                BlockState blockstate1 = blockstate.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                level.setBlock(blockpos, blockstate1, 35);
                level.levelEvent(player, 2001, blockpos, Block.getId(blockstate));
            }
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        Level level = context.getLevel();
        Direction direction = context.getHorizontalDirection();
        BlockPos blockpos = context.getClickedPos();
        BlockPos blockpos1 = blockpos.relative(DirectionSwitcher(direction));
        FluidState fluidstateDown = level.getFluidState(blockpos);
        boolean flag = fluidstateDown.getType() == Fluids.WATER;

        return level.getBlockState(blockpos1).canBeReplaced(context) && level.getWorldBorder().isWithinBounds(blockpos1) ? this.defaultBlockState().setValue(FACING, direction).setValue(WATERLOGGED, flag) : null;
    }

    @Override
    public abstract @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context);

    protected static Direction DirectionSwitcher(Direction direction)
    {
        return switch (direction)
        {
            case Direction.WEST -> Direction.SOUTH;
            case Direction.EAST -> Direction.NORTH;
            case Direction.SOUTH -> Direction.EAST;
            default -> Direction.WEST;
        };
    }

    protected static Direction reverseDirectionSwitcher(Direction direction)
    {
        return switch (direction)
        {
            case Direction.WEST -> Direction.NORTH;
            case Direction.EAST -> Direction.SOUTH;
            case Direction.SOUTH -> Direction.WEST;
            default -> Direction.EAST;
        };
    }


    protected abstract void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder);

    public void setPlacedBy(@NotNull Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, @NotNull ItemStack stack)
    {
        BlockPos blockpos1 = pos.relative(DirectionSwitcher(state.getValue(FACING)));
        super.setPlacedBy(level, pos, state, placer, stack);
        if (!level.isClientSide)
        {
            FluidState fluidstateUp = level.getFluidState(blockpos1);
            boolean flag = fluidstateUp.getType() == Fluids.WATER;
            BlockPos blockpos = pos.relative(DirectionSwitcher(state.getValue(FACING)));
            level.setBlock(blockpos, state.setValue(PART, TwoBlockWidthPart.LEFT).setValue(WATERLOGGED, flag), 3);
            level.blockUpdated(pos, Blocks.AIR);
            state.updateNeighbourShapes(level, pos, 3);
        }
    }

    @Override
    protected @NotNull BlockState rotate(BlockState state, Rotation rot)
    {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }
}
