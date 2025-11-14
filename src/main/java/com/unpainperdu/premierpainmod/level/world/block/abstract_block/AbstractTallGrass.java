package com.unpainperdu.premierpainmod.level.world.block.abstract_block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public abstract class AbstractTallGrass extends Block
{
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    protected final TagKey<Block> BLOCKS_ON;

    public AbstractTallGrass(Properties properties, TagKey<Block> blocksOn)
    {
        super(properties);
        this.BLOCKS_ON = blocksOn;
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter blockGetter, @NotNull BlockPos pos, @NotNull CollisionContext context)
    {
        Vec3 vec3 = state.getOffset(blockGetter, pos);
        return Block.box(0, 0, 0, 16, 16, 16).move(vec3.x, vec3.y, vec3.z);
    }

    @Override
    protected @NotNull BlockState updateShape(BlockState state, @NotNull Direction direction, @NotNull BlockState facingState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos facingPos)
    {
        if (!state.canSurvive(level, pos))
        {
            level.scheduleTick(pos, this, 1);
        }

        DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
        if (direction.getAxis() == Direction.Axis.Y && doubleblockhalf == DoubleBlockHalf.LOWER == (direction == Direction.UP))
        {
            return facingState.is(this) && facingState.getValue(HALF) != doubleblockhalf
                    ? state
                    : Blocks.AIR.defaultBlockState();
        }
        else
        {
            return doubleblockhalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !state.canSurvive(level, pos)
                    ? Blocks.AIR.defaultBlockState()
                    : super.updateShape(state, direction, facingState, level, pos, facingPos);
        }

    }

    @Override
    protected void tick(BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random)
    {
        if (!state.canSurvive(level, pos))
        {
            level.destroyBlock(pos, true);
        }
    }

    @Override
    protected boolean canSurvive(@NotNull BlockState state, LevelReader level, @NotNull BlockPos pos)
    {
        boolean flag = false;
        state = level.getBlockState(pos);
        BlockState stateBelow = level.getBlockState(pos.below());
        if (state.getBlock() instanceof AirBlock)
        {
            if (stateBelow.is(BLOCKS_ON))
            {
                flag = true;
            }
        }
        else if (state.getBlock() instanceof AbstractTallGrass)
        {
            if (stateBelow.getBlock() instanceof AbstractTallGrass)
            {
                if (stateBelow.getValue(AbstractTallGrass.HALF) == DoubleBlockHalf.LOWER)
                {
                    flag = true;
                }
            }
            if (stateBelow.is(BLOCKS_ON))
            {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public @NotNull BlockState playerWillDestroy(Level pLevel, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Player player)
    {
        if (!pLevel.isClientSide && (player.isCreative() || !player.hasCorrectToolForDrops(state, pLevel, pos)))
        {
            preventCreativeDropFromBottomPart(pLevel, pos, state, player);
        }

        super.playerWillDestroy(pLevel, pos, state, player);
        return state;
    }

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
    protected boolean isPathfindable(@NotNull BlockState state, @NotNull PathComputationType pathComputationType)
    {
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(HALF);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, @NotNull ItemStack itemStack)
    {
        level.setBlock(pos.above(), state.setValue(HALF, DoubleBlockHalf.UPPER), 3);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        BlockPos blockpos = context.getClickedPos();
        Level level = context.getLevel();
        if (blockpos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockpos.above()).canBeReplaced(context))
        {
            return this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER);
        }
        else
        {
            return null;
        }
    }

    @Override
    protected void entityInside(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Entity entity)
    {
        Vec3 vec3 = new Vec3(0.95, 0.95, 0.95);
        entity.makeStuckInBlock(state, vec3);
    }
}
