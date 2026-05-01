package com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractTwoBlockWidthWithBlockEntity;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.TwoBlockWidthPart;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.all_materials_block.VillagerDrawerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VillagerDrawer extends AbstractTwoBlockWidthWithBlockEntity
{
    private static final VoxelShape RIGHT_SHAPE_SOUTH = Block.box(2, 0, 2, 16, 16, 16);
    private static final VoxelShape LEFT_SHAPE_SOUTH = Block.box(0, 0, 2, 14, 16, 16);

    private static final VoxelShape RIGHT_SHAPE_NORTH = Block.box(0, 0, 0, 14, 16, 14);
    private static final VoxelShape LEFT_SHAPE_NORTH = Block.box(2, 0, 0, 16, 16, 14);

    private static final VoxelShape RIGHT_SHAPE_WEST = Block.box(0, 0, 2, 14, 16, 16);
    private static final VoxelShape LEFT_SHAPE_WEST = Block.box(0, 0, 0, 14, 16, 14);

    private static final VoxelShape RIGHT_SHAPE_EAST = Block.box(2, 0, 0, 16, 16, 14);
    private static final VoxelShape LEFT_SHAPE_EAST = Block.box(2, 0, 2, 16, 16, 16);

    public static final MapCodec<VillagerDrawer> CODEC = simpleCodec(VillagerDrawer::new);
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

    public VillagerDrawer(Properties pProperties)
    {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, TwoBlockWidthPart.RIGHT).setValue(WATERLOGGED, Boolean.FALSE).setValue(OPEN, Boolean.FALSE));
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
        builder.add(FACING, PART, WATERLOGGED, OPEN);
    }

    @Nullable

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState)
    {
        return new VillagerDrawerBlockEntity(pPos, pState);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult)
    {
        if (pLevel.isClientSide)
        {
            return InteractionResult.SUCCESS;
        }
        else
        {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof VillagerDrawerBlockEntity)
            {
                pPlayer.openMenu((VillagerDrawerBlockEntity) blockentity);
            }
            return InteractionResult.CONSUME;
        }
    }

    @Override
    protected void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving)
    {
        Containers.dropContentsOnDestroy(pState, pNewState, pLevel, pPos);
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom)
    {
        BlockEntity blockentity = pLevel.getBlockEntity(pPos);
        if (blockentity instanceof VillagerDrawerBlockEntity)
        {
            ((VillagerDrawerBlockEntity) blockentity).recheckOpen();
        }
    }
}