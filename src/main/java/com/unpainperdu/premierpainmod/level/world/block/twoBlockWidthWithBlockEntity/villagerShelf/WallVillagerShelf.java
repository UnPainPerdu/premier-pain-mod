package com.unpainperdu.premierpainmod.level.world.block.twoBlockWidthWithBlockEntity.villagerShelf;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.state.properties.TwoBlockWidthPart;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidthWithBlockEntity.AbstractTwoBlockWidthWithBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WallVillagerShelf extends VillagerShelf
{
    private static final VoxelShape RIGHT_SHAPE_SOUTH = Block.box(1, 4, 10, 16, 15, 16);
    private static final VoxelShape LEFT_SHAPE_SOUTH = Block.box(0, 4, 10, 15, 15, 16);

    private static final VoxelShape RIGHT_SHAPE_NORTH = Block.box(0, 4, 0, 15, 15, 6);
    private static final VoxelShape LEFT_SHAPE_NORTH = Block.box(1, 4, 0, 16, 15, 6);

    private static final VoxelShape RIGHT_SHAPE_WEST = Block.box(0, 4, 1, 6, 15, 16);
    private static final VoxelShape LEFT_SHAPE_WEST = Block.box(0, 4, 0, 6, 15, 15);

    private static final VoxelShape RIGHT_SHAPE_EAST = Block.box(10, 4, 0, 16, 15, 15);
    private static final VoxelShape LEFT_SHAPE_EAST = Block.box(10, 4, 1, 16, 15, 16);

    public static final MapCodec<WallVillagerShelf> CODEC = simpleCodec(WallVillagerShelf::new);



    public WallVillagerShelf(Properties pProperties)
    {
        super(pProperties);
        BlockState blockstate = this.stateDefinition.any().setValue(PART, TwoBlockWidthPart.RIGHT).setValue(WATERLOGGED, Boolean.FALSE);
        this.registerDefaultState(blockstate);
    }

    @Override
    protected MapCodec<? extends AbstractTwoBlockWidthWithBlockEntity> codec()
    {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos pos, CollisionContext collisionContext)
    {
        TwoBlockWidthPart twoBlockWidthPart = blockState.getValue(PART);
        Direction direction = blockState.getValue(FACING);

        if(direction == Direction.SOUTH)
        {
            if (twoBlockWidthPart == TwoBlockWidthPart.RIGHT)
            {
                return RIGHT_SHAPE_SOUTH;
            } else {
                return LEFT_SHAPE_SOUTH;
            }
        } else if (direction == Direction.WEST)
        {
            if (twoBlockWidthPart == TwoBlockWidthPart.RIGHT)
            {
                return RIGHT_SHAPE_WEST;
            } else {
                return LEFT_SHAPE_WEST;
            }
        } else if (direction == Direction.EAST)
        {
            if (twoBlockWidthPart == TwoBlockWidthPart.RIGHT)
            {
                return RIGHT_SHAPE_EAST;
            } else {
                return LEFT_SHAPE_EAST;
            }
        } else
        {
            if (twoBlockWidthPart == TwoBlockWidthPart.RIGHT)
            {
                return RIGHT_SHAPE_NORTH;
            } else {
                return LEFT_SHAPE_NORTH;
            }
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(new Property[]{FACING, PART, WATERLOGGED});
    }

    @Override
    public Block getBlockShelf()
    {
        return this;
    }
}
