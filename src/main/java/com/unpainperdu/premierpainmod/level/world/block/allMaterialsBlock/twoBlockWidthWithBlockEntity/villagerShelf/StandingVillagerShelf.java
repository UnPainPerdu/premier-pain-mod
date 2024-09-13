package com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockWidthWithBlockEntity.villagerShelf;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.TwoBlockWidthPart;
import com.unpainperdu.premierpainmod.level.world.block.abstractBlock.AbstractTwoBlockWidthWithBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StandingVillagerShelf extends VillagerShelf
{
    public static final BooleanProperty HAS_SHELF_ON_TOP = BooleanProperty.create("has_shelf_on_top");

    public static final BooleanProperty HAS_SHELF_BELOW = BooleanProperty.create("has_shelf_below");

    private static final VoxelShape RIGHT_SHAPE_SOUTH = Block.box(1, 0, 4, 16, 16, 16);
    private static final VoxelShape LEFT_SHAPE_SOUTH = Block.box(0, 0, 4, 15, 16, 16);

    private static final VoxelShape RIGHT_SHAPE_NORTH = Block.box(0, 0, 0, 15, 16, 12);
    private static final VoxelShape LEFT_SHAPE_NORTH = Block.box(1, 0, 0, 16, 16, 12);

    private static final VoxelShape RIGHT_SHAPE_WEST = Block.box(0, 4, 1, 12, 16, 16);
    private static final VoxelShape LEFT_SHAPE_WEST = Block.box(0, 4, 0, 12, 16, 15);

    private static final VoxelShape RIGHT_SHAPE_EAST = Block.box(4, 0, 0, 16, 16, 15);
    private static final VoxelShape LEFT_SHAPE_EAST = Block.box(4, 0, 1, 16, 16, 16);

    public static final MapCodec<StandingVillagerShelf> CODEC = simpleCodec(StandingVillagerShelf::new);

    public StandingVillagerShelf(Properties pProperties)
    {
        super(pProperties);
        BlockState blockstate = this.stateDefinition.any().setValue(PART, TwoBlockWidthPart.RIGHT).setValue(WATERLOGGED, Boolean.FALSE).setValue(HAS_SHELF_ON_TOP,Boolean.FALSE).setValue(HAS_SHELF_BELOW,Boolean.FALSE);

        this.registerDefaultState(blockstate);
    }

    @Override
    protected MapCodec<? extends AbstractTwoBlockWidthWithBlockEntity> codec()
    {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext)
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
        pBuilder.add(new Property[]{FACING, PART, WATERLOGGED, HAS_SHELF_ON_TOP, HAS_SHELF_BELOW});
    }

    @Override
    public Block getBlockShelf()
    {
        return this;
    }

    @Override
    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos)
    {
        if (pState.getValue(WATERLOGGED))
        {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        TwoBlockWidthPart twoBlockWidthPart = pState.getValue(PART);
        if (pFacing != getNeighbourDirection(twoBlockWidthPart, DirectionSwitcher(pState.getValue(FACING))))
        {
            if (twoBlockWidthPart == TwoBlockWidthPart.RIGHT && pFacing == reverseDirectionSwitcher(pState.getValue(FACING)) && !pState.canSurvive(pLevel, pCurrentPos))
            {
                return Blocks.AIR.defaultBlockState();
            }
            else
            {
                if(pFacing == Direction.UP)
                {
                    return pState.setValue(HAS_SHELF_ON_TOP, this.connectsTo(pFacingState, pFacingState.isFaceSturdy(pLevel, pFacingPos, pFacing.getOpposite()), pFacing.getOpposite()));
                } else if (pFacing == Direction.DOWN)
                {
                    return pState.setValue(HAS_SHELF_BELOW, this.connectsTo(pFacingState, pFacingState.isFaceSturdy(pLevel, pFacingPos, pFacing.getOpposite()), pFacing.getOpposite()));
                } else
                {
                    return super.superUpdateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
                }
            }
        }
        else
        {
            if (pFacingState.is(this) && pFacingState.getValue(PART) != pState.getValue(PART))
            {
                return (BlockState) pState;
            }
            else
            {
               return Blocks.AIR.defaultBlockState();
            }
        }
    }
    public boolean connectsTo(BlockState pState, boolean pIsSideSolid, Direction pDirection)
    {
        Block block = pState.getBlock();
        return block instanceof StandingVillagerShelf;
    }
}
