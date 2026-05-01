package com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.villager_shelf;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractTwoBlockWidthWithBlockEntity;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.TwoBlockWidthPart;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

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
        BlockState blockstate = this.stateDefinition.any().setValue(PART, TwoBlockWidthPart.RIGHT).setValue(WATERLOGGED, Boolean.FALSE).setValue(HAS_SHELF_ON_TOP, Boolean.FALSE).setValue(HAS_SHELF_BELOW, Boolean.FALSE);

        this.registerDefaultState(blockstate);
    }

    @Override
    protected @NotNull MapCodec<? extends AbstractTwoBlockWidthWithBlockEntity> codec()
    {
        return CODEC;
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context)
    {
        TwoBlockWidthPart twoBlockWidthPart = state.getValue(PART);
        Direction direction = state.getValue(FACING);

        if (direction == Direction.SOUTH)
        {
            if (twoBlockWidthPart == TwoBlockWidthPart.RIGHT)
            {
                return RIGHT_SHAPE_SOUTH;
            }
            else
            {
                return LEFT_SHAPE_SOUTH;
            }
        }
        else if (direction == Direction.WEST)
        {
            if (twoBlockWidthPart == TwoBlockWidthPart.RIGHT)
            {
                return RIGHT_SHAPE_WEST;
            }
            else
            {
                return LEFT_SHAPE_WEST;
            }
        }
        else if (direction == Direction.EAST)
        {
            if (twoBlockWidthPart == TwoBlockWidthPart.RIGHT)
            {
                return RIGHT_SHAPE_EAST;
            }
            else
            {
                return LEFT_SHAPE_EAST;
            }
        }
        else
        {
            if (twoBlockWidthPart == TwoBlockWidthPart.RIGHT)
            {
                return RIGHT_SHAPE_NORTH;
            }
            else
            {
                return LEFT_SHAPE_NORTH;
            }
        }
    }

    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder)
    {
        builder.add(new Property[]{FACING, PART, WATERLOGGED, HAS_SHELF_ON_TOP, HAS_SHELF_BELOW});
    }

    @Override
    public Block getBlockShelf()
    {
        return this;
    }

    @Override
    protected BlockState updateShape(BlockState selfState, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos selfPos, Direction direction, BlockPos facingPos, BlockState facingState, RandomSource rand)
    {
        if (selfState.getValue(WATERLOGGED))
        {
            scheduledTickAccess.createTick(selfPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        TwoBlockWidthPart twoBlockWidthPart = selfState.getValue(PART);
        if (direction != getNeighbourDirection(twoBlockWidthPart, DirectionSwitcher(selfState.getValue(FACING))))
        {
            if (twoBlockWidthPart == TwoBlockWidthPart.RIGHT && direction == reverseDirectionSwitcher(selfState.getValue(FACING)) && !selfState.canSurvive(level, selfPos))
            {
                return Blocks.AIR.defaultBlockState();
            }
            else
            {
                if (direction == Direction.UP)
                {
                    return selfState.setValue(HAS_SHELF_ON_TOP, this.connectsTo(facingState, facingState.isFaceSturdy(level, facingPos, direction.getOpposite()), direction.getOpposite()));
                }
                else if (direction == Direction.DOWN)
                {
                    return selfState.setValue(HAS_SHELF_BELOW, this.connectsTo(facingState, facingState.isFaceSturdy(level, facingPos, direction.getOpposite()), direction.getOpposite()));
                }
                else
                {
                    return super.superUpdateShape(selfState, level, scheduledTickAccess, selfPos, direction, facingPos, facingState, rand);
                }
            }
        }
        else
        {
            if (facingState.is(this) && facingState.getValue(PART) != selfState.getValue(PART))
            {
                return selfState;
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