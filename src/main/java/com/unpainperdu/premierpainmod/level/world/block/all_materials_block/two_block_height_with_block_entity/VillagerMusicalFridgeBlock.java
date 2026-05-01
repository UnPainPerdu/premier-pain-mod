package com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height_with_block_entity;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractTwoBlockHeightBlockWithBlockEntity;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.all_materials_block.VillagerMusicalFridgeBlockEntity;
import com.unpainperdu.premierpainmod.util.register.block.BlockEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VillagerMusicalFridgeBlock extends AbstractTwoBlockHeightBlockWithBlockEntity
{
    //lower part contain the block entity

    public static final MapCodec<VillagerMusicalFridgeBlock> CODEC = simpleCodec(VillagerMusicalFridgeBlock::new);
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

    public VillagerMusicalFridgeBlock(Properties pProperties)
    {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, Boolean.FALSE).setValue(OPEN, false));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(HALF, FACING, WATERLOGGED, OPEN);
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context)
    {
        VoxelShape shape;
        switch (state.getValue(FACING))
        {
            case EAST -> shape = Block.box(3, 0, 1, 16, 16, 15);

            case SOUTH -> shape = Block.box(1, 0, 3, 15, 16, 16);

            case WEST -> shape = Block.box(0, 0, 1, 13, 16, 15);

            default -> shape = Block.box(1, 0, 0, 15, 16, 13);

        }
        return shape;
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec()
    {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        if (state.getValue(HALF) == DoubleBlockHalf.LOWER)
        {
            return new VillagerMusicalFridgeBlockEntity(pos, state);
        }
        else
        {
            return null;
        }
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
            BlockEntity blockentity = getRealBlockEntity(level, pos, state);
            if (blockentity instanceof VillagerMusicalFridgeBlockEntity)
            {
                player.openMenu((VillagerMusicalFridgeBlockEntity) blockentity);
            }
            return InteractionResult.CONSUME;
        }
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving)
    {
        if (isLowerPart(state))
        {
            Containers.dropContentsOnDestroy(state, newState, level, pos);
            if (!state.is(newState.getBlock()) && level.getBlockEntity(pos) instanceof VillagerMusicalFridgeBlockEntity entity)
            {
                entity.getJukeboxSongPlayer().stop(level, state);
            }
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random)
    {
        BlockEntity blockEntity = getRealBlockEntity(level, pos, state);
        if (blockEntity instanceof VillagerMusicalFridgeBlockEntity)
        {
            ((VillagerMusicalFridgeBlockEntity) blockEntity).recheckOpen();
        }
    }

    public static boolean isLowerPart(BlockState state)
    {
        return state.getValue(HALF) == DoubleBlockHalf.LOWER;
    }

    public static BlockEntity getRealBlockEntity(Level level, BlockPos pos, BlockState state)
    {
        BlockEntity blockentity;
        if (isLowerPart(state))
        {
            blockentity = level.getBlockEntity(pos);
        }
        else
        {
            blockentity = level.getBlockEntity(pos.below());
        }
        return blockentity;
    }

    @javax.annotation.Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType)
    {
        return VillagerMusicalFridgeBlockEntity.createBrewingStationTicker(level, blockEntityType, BlockEntityRegister.VILLAGER_MUSICAL_FRIDGE_ENTITY.get());
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType)
    {
        return false;
    }
}