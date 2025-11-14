package com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.villager_shelf;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractTwoBlockWidthWithBlockEntity;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.all_materials_block.VillagerShelfBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class VillagerShelf extends AbstractTwoBlockWidthWithBlockEntity
{

    public VillagerShelf(BlockBehaviour.Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    protected abstract @NotNull MapCodec<? extends AbstractTwoBlockWidthWithBlockEntity> codec();

    @Override
    public abstract @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context);

    protected abstract void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder);

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState)
    {
        return new VillagerShelfBlockEntity(pPos, pState, getBlockShelf());
    }

    public abstract Block getBlockShelf();

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
            if (blockentity instanceof VillagerShelfBlockEntity)
            {
                pPlayer.openMenu((VillagerShelfBlockEntity)blockentity);
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
    protected RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }
    public static void dowse(@javax.annotation.Nullable Entity pEntity, LevelAccessor pLevel, BlockPos pPos, BlockState pState) {

        BlockEntity blockentity = pLevel.getBlockEntity(pPos);
        if (blockentity instanceof VillagerShelfBlockEntity)
        {
            ((VillagerShelfBlockEntity)blockentity).dowse();
        }

        pLevel.gameEvent(pEntity, GameEvent.BLOCK_CHANGE, pPos);
    }
}
