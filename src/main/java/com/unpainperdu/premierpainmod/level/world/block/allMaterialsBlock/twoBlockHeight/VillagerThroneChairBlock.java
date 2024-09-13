package com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockHeight;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstractBlock.AbstractTwoBlockHeightBlock;
import com.unpainperdu.premierpainmod.level.world.block.state.properties.VillagerCarpetColor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VillagerThroneChairBlock extends AbstractTwoBlockHeightBlock
{
    public static final MapCodec<VillagerStatue> CODEC = simpleCodec(VillagerStatue::new);
    public static final EnumProperty<VillagerCarpetColor> COLOR;

    public VillagerThroneChairBlock(Properties pProperties)
    {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(HALF, DoubleBlockHalf.LOWER)
                .setValue(WATERLOGGED, Boolean.FALSE)
                .setValue(COLOR, VillagerCarpetColor.NONE));
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(HALF, FACING, WATERLOGGED, COLOR);
    }

    @Override
    public MapCodec<VillagerStatue> codec()
    {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter p_60556_, BlockPos bPos, CollisionContext p_60558_)
    {
        VoxelShape COMMON_SHAPE = Block.box(3, 1, 3, 13, 8, 13);

        VoxelShape NORTH_UPPER_SHAPE = Block.box(3, 0, 1, 13, 12, 3);
        VoxelShape NORTH_BELOW_SHAPE =Shapes.or(COMMON_SHAPE, Block.box(3, 8, 1, 13, 16, 3));

        VoxelShape EAST_UPPER_SHAPE = Block.box(13, 0, 3, 15, 12, 13);
        VoxelShape EAST_BELOW_SHAPE =Shapes.or(COMMON_SHAPE, Block.box(13, 8, 3, 15, 16, 13));

        VoxelShape SOUTH_UPPER_SHAPE = Block.box(3, 0, 13, 13, 12, 15);
        VoxelShape SOUTH_BELOW_SHAPE =Shapes.or(COMMON_SHAPE, Block.box(3, 8, 13, 13, 16, 15));

        VoxelShape WEAST_UPPER_SHAPE = Block.box(1, 0, 3, 3, 12, 13);
        VoxelShape WEST_BELOW_SHAPE =Shapes.or(COMMON_SHAPE, Block.box(1, 8, 3, 3, 16, 13));

        VoxelShape NW_FOOT_SHAPE = Block.box(1,0,1,3,12,3);
        VoxelShape NE_FOOT_SHAPE = Block.box(13,0,1,15,12,3);
        VoxelShape SW_FOOT_SHAPE = Block.box(1,0,13,3,12,15);
        VoxelShape SE_FOOT_SHAPE = Block.box(13,0,13,15,12,15);

        VoxelShape NS_SIDE_SHAPE = Shapes.or(Block.box(1,10,1,3,12,15), Block.box(13,10,1,15,12,15));
        VoxelShape WE_SIDE_SHAPE = Shapes.or(Block.box(1,10,1,15,12,3), Block.box(1,10,13,15,12,15));

        VoxelShape FEETS = Shapes.or(NW_FOOT_SHAPE,NE_FOOT_SHAPE,SW_FOOT_SHAPE,SE_FOOT_SHAPE);

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
                    return Shapes.or(EAST_BELOW_SHAPE, FEETS, WE_SIDE_SHAPE);
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
                    return Shapes.or(SOUTH_BELOW_SHAPE, FEETS, NS_SIDE_SHAPE);
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
                    return Shapes.or(WEST_BELOW_SHAPE, FEETS, WE_SIDE_SHAPE);
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
                    return Shapes.or(NORTH_BELOW_SHAPE, FEETS, NS_SIDE_SHAPE);
                }
            }
        }
    }
    static
    {
        COLOR = EnumProperty.create("villagertablecarpetcolor", VillagerCarpetColor.class);
    }
}