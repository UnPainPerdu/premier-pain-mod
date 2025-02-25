package com.unpainperdu.premierpainmod.level.world.block.all_materials_block;

import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.VillagerDrawer;
import com.unpainperdu.premierpainmod.util.tool_kit.DirectionHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class VillagerChiseledHead extends Block
{
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public VillagerChiseledHead(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.Y).setValue(WATERLOGGED, false).setValue(LIT, true));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult)
    {
        if (level.isClientSide)
        {
            return InteractionResult.SUCCESS;
        }
        else
        {
            level.setBlock(pos, state.setValue(LIT, !state.getValue(LIT)), 3);
            level.playSound(null, pos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS, 1.0F, 1.0F);
            return InteractionResult.CONSUME;
        }
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext)
    {
        VoxelShape BASE_SHAPE = Block.box(1, 0, 1, 15, 16, 15);
        return BASE_SHAPE;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext)
    {
        BlockPos blockpos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        FluidState fluidstate = level.getFluidState(blockpos);

        boolean flag = fluidstate.getType() == Fluids.WATER;
        if (blockpos.getY() < level.getMaxBuildHeight())
        {
            return this.defaultBlockState().setValue(WATERLOGGED, flag).setValue(AXIS, pContext.getClickedFace().getAxis());
        }
        else
        {
            return null;
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(AXIS, WATERLOGGED, LIT);
    }

    @Override
    protected @NotNull FluidState getFluidState(BlockState pState)
    {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rotation)
    {
        if (state.getValue(AXIS) != Direction.Axis.Y)
        {
            if (rotation == Rotation.CLOCKWISE_90 || rotation == Rotation.COUNTERCLOCKWISE_90)
            {
                Direction.Axis axis = state.getValue(AXIS);
                if (axis == Direction.Axis.X)
                {
                    axis = Direction.Axis.Z;
                }
                else
                {
                    axis = Direction.Axis.X;
                }
                state = state.setValue(AXIS, axis);
            }
        }
        return state;
    }
}
