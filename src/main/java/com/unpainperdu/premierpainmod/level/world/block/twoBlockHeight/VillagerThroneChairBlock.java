package com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VillagerThroneChairBlock extends AbstactTwoBlockHeightBlock
{
    public static final MapCodec<VillagerStatue> CODEC = simpleCodec(VillagerStatue::new);

    public VillagerThroneChairBlock(Properties pProperties)
    {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(HALF, DoubleBlockHalf.LOWER)
                .setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    public MapCodec<VillagerStatue> codec()
    {
        return CODEC;
    }

    private static final VoxelShape COMMON_SHAPE = Block.box(1, 0, 1, 15, 8, 15);

    private static final VoxelShape NORTH_UPPER_SHAPE = Block.box(3, 0, 1, 13, 12, 3);
    private static final VoxelShape NORTH_BELOW_SHAPE =Shapes.or(COMMON_SHAPE, Block.box(3, 8, 1, 13, 16, 3));

    private static final VoxelShape EAST_UPPER_SHAPE = Block.box(13, 0, 3, 15, 12, 13);
    private static final VoxelShape EAST_BELOW_SHAPE =Shapes.or(COMMON_SHAPE, Block.box(13, 8, 3, 15, 16, 13));

    private static final VoxelShape SOUTH_UPPER_SHAPE = Block.box(3, 0, 13, 13, 12, 15);
    private static final VoxelShape SOUTH_BELOW_SHAPE =Shapes.or(COMMON_SHAPE, Block.box(3, 8, 13, 13, 16, 15));

    private static final VoxelShape WEAST_UPPER_SHAPE = Block.box(1, 0, 3, 3, 12, 13);
    private static final VoxelShape WEST_BELOW_SHAPE =Shapes.or(COMMON_SHAPE, Block.box(1, 8, 3, 3, 16, 13));

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter p_60556_, BlockPos bPos, CollisionContext p_60558_)
    {
        DoubleBlockHalf doubleblockhalf = pState.getValue(HALF);
        Direction direction = pState.getValue(FACING);
        switch (direction)
        {
            case Direction.EAST:
            {
                if (doubleblockhalf == DoubleBlockHalf.UPPER)
                {
                    return EAST_UPPER_SHAPE;
                }
                else
                {
                    return EAST_BELOW_SHAPE;
                }
            }
            case Direction.SOUTH:
            {
                if (doubleblockhalf == DoubleBlockHalf.UPPER)
                {
                    return SOUTH_UPPER_SHAPE;
                }
                else
                {
                    return SOUTH_BELOW_SHAPE;
                }
            }
            case Direction.WEST:
            {
                if (doubleblockhalf == DoubleBlockHalf.UPPER)
                {
                    return WEAST_UPPER_SHAPE;
                }
                else
                {
                    return WEST_BELOW_SHAPE;
                }
            }
            default:
            {
                if (doubleblockhalf == DoubleBlockHalf.UPPER)
                {
                    return NORTH_UPPER_SHAPE;
                }
                else
                {
                    return NORTH_BELOW_SHAPE;
                }
            }
        }
    }
}