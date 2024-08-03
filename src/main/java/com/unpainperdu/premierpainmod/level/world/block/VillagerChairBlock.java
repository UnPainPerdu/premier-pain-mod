package com.unpainperdu.premierpainmod.level.world.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

/*
Credit to bl4ckscor3 for everything about sitting with this block
see Seatentity, SeatUtil, SeatHandler and SeatClient
*/
public class VillagerChairBlock extends Block implements SimpleWaterloggedBlock
{
    public static final MapCodec<VillagerChairBlock> CODEC = simpleCodec(VillagerChairBlock::new);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public VillagerChairBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.FALSE));
    }
    public MapCodec<VillagerChairBlock> codec()
    {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext)
    {
        VoxelShape BASE_SHAPE = Block.box(3, 7, 3, 13, 8, 13);

        VoxelShape FOOT_SHAPE1 = Block.box(3, 0, 3, 5, 8, 5);
        VoxelShape FOOT_SHAPE2 = Block.box(11, 0, 3, 13, 8, 5);
        VoxelShape FOOT_SHAPE3 = Block.box(3, 0, 11, 5, 8, 13);
        VoxelShape FOOT_SHAPE4 = Block.box(11, 0, 11, 13, 8, 13);

        VoxelShape BACK_N = Block.box(3, 8, 3, 13, 16, 5);
        VoxelShape BACK_S = Block.box(3, 8, 11, 13, 16, 13);
        VoxelShape BACK_E = Block.box(11, 8, 3, 13, 16, 13);
        VoxelShape BACK_W = Block.box(3, 8, 3, 5, 16, 13);

        VoxelShape shape =  Shapes.or(BASE_SHAPE,FOOT_SHAPE1,FOOT_SHAPE2,FOOT_SHAPE3,FOOT_SHAPE4);
        switch (blockState.getValue(FACING))
        {
            case NORTH :
            {
                shape = Shapes.or(shape, BACK_N);
                break;
            }
            case EAST :
            {
                shape = Shapes.or(shape, BACK_E);
                break;
            }
            case SOUTH :
            {
                shape = Shapes.or(shape, BACK_S);
                break;
            }
            default:
            {
                shape = Shapes.or(shape, BACK_W);
                break;
            }
        }
        return shape;
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
        pBuilder.add( FACING, WATERLOGGED);
    }
}
