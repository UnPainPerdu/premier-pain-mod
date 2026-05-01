package com.unpainperdu.premierpainmod.level.world.block.abstract_block;

import com.unpainperdu.premierpainmod.level.world.block.state.propertie.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public abstract class AbstractTwoBlockHeightBlock extends Block implements SimpleWaterloggedBlock
{
    public static final EnumProperty<Direction> FACING = ModBlockStateProperties.DIRECTION;
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public AbstractTwoBlockHeightBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, Boolean.FALSE));
    }

    //Applique la hit-box
    @Override
    public abstract @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter blockGetter, @NotNull BlockPos pos, @NotNull CollisionContext context);

    //check si le dessus est libre
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        BlockPos blockpos = context.getClickedPos();
        Level level = context.getLevel();
        FluidState fluidstateDown = level.getFluidState(blockpos);
        boolean flag = fluidstateDown.getType() == Fluids.WATER;
        if (blockpos.getY() < level.getMaxY() && level.getBlockState(blockpos.above()).canBeReplaced(context))
        {
            return this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, flag).setValue(FACING, context.getHorizontalDirection());
        }
        else
        {
            return null;
        }
    }

    @Override
    protected @NotNull FluidState getFluidState(BlockState state)
    {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    // Pose le bloc du dessus
    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, @NotNull ItemStack stack)
    {
        FluidState fluidstateUp = level.getFluidState(pos.above());
        boolean flag = fluidstateUp.getType() == Fluids.WATER;
        level.setBlock(pos.above(), state.setValue(HALF, DoubleBlockHalf.UPPER).setValue(WATERLOGGED, flag), 3);
    }

    //Si dessous pété, péte le dessus
    @Override
    protected BlockState updateShape(BlockState selfState, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos selfPos, Direction direction, BlockPos facingPos, BlockState facingState, RandomSource rand)
    {
        DoubleBlockHalf doubleblockhalf = selfState.getValue(HALF);
        if (selfState.getValue(WATERLOGGED))
        {
            scheduledTickAccess.createTick(selfPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        if (direction.getAxis() == Direction.Axis.Y && doubleblockhalf == DoubleBlockHalf.LOWER == (direction == Direction.UP))
        {
            return facingState.is(this) && facingState.getValue(HALF) != doubleblockhalf
                    ? selfState.setValue(FACING, facingState.getValue(FACING))
                    : Blocks.AIR.defaultBlockState();
        }
        else
        {
            return doubleblockhalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !selfState.canSurvive(level, selfPos)
                    ? Blocks.AIR.defaultBlockState()
                    : super.updateShape(selfState, level, scheduledTickAccess, selfPos, direction, facingPos, facingState, rand);
        }
    }

    //créé un nouveau BlockState nommé HALF
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(HALF, FACING, WATERLOGGED);
    }

    //quand le bloc est pété
    @Override
    public @NotNull BlockState playerWillDestroy(Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Player player)
    {
        if (!level.isClientSide && (player.isCreative() || !player.hasCorrectToolForDrops(state, level, pos)))
        {
            preventCreativeDropFromBottomPart(level, pos, state, player);
        }

        super.playerWillDestroy(level, pos, state, player);
        return state;
    }

    //Pète le bloc du dessous si dessus cassé
    protected static void preventCreativeDropFromBottomPart(Level level, BlockPos pos, BlockState state, Player player)
    {
        DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
        if (doubleblockhalf == DoubleBlockHalf.UPPER)
        {
            BlockPos blockpos = pos.below();
            BlockState blockstate = level.getBlockState(blockpos);
            if (blockstate.is(state.getBlock()) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER)
            {
                BlockState blockstate1 = blockstate.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                level.setBlock(blockpos, blockstate1, 35);
                level.levelEvent(player, 2001, blockpos, Block.getId(blockstate));
            }
        }
    }

    @Override
    protected @NotNull BlockState rotate(BlockState state, Rotation rot)
    {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }
}