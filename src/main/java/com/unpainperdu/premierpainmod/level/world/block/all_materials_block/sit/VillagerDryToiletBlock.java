package com.unpainperdu.premierpainmod.level.world.block.all_materials_block.sit;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class VillagerDryToiletBlock extends Block implements SimpleWaterloggedBlock
{
    public static final MapCodec<VillagerDryToiletBlock> CODEC = simpleCodec(VillagerDryToiletBlock::new);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<Direction> FACING = ModBlockStateProperties.DIRECTION;

    public VillagerDryToiletBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.FALSE));
    }

    public @NotNull MapCodec<VillagerDryToiletBlock> codec()
    {
        return CODEC;
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext)
    {
        VoxelShape baseShape = Block.box(0, 0, 0, 16, 8, 16);
        VoxelShape variableShape;
        switch (blockState.getValue(HorizontalDirectionalBlock.FACING))
        {
            case NORTH -> variableShape = Block.box(0, 8, 0, 16, 16, 8);
            case WEST -> variableShape = Block.box(0, 8, 0, 8, 16, 16);
            case SOUTH -> variableShape = Block.box(0, 8, 8, 16, 16, 16);
            default -> variableShape = Block.box(8, 8, 0, 16, 16, 16);
        }
        return Shapes.or(baseShape, variableShape);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext)
    {
        BlockPos blockpos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        FluidState fluidstate = level.getFluidState(blockpos);

        boolean flag = fluidstate.getType() == Fluids.WATER;
        if (blockpos.getY() < level.getMaxY())
        {
            return this.defaultBlockState().setValue(WATERLOGGED, flag).setValue(FACING, pContext.getHorizontalDirection());
        }
        else
        {
            return null;
        }
    }

    @Override
    protected @NotNull FluidState getFluidState(BlockState pState)
    {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(FACING, WATERLOGGED);
    }

    @Override
    protected @NotNull BlockState rotate(BlockState pState, Rotation pRot)
    {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }

    @Override
    protected boolean isPathfindable(@NotNull BlockState state, @NotNull PathComputationType pathComputationType)
    {
        return false;
    }
}