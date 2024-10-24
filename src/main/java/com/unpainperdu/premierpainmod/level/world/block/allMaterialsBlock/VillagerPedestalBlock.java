package com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.entity.blockEntity.allMaterialsBlock.PedestalBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VillagerPedestalBlock extends BaseEntityBlock implements SimpleWaterloggedBlock
{
    public static final MapCodec<VillagerPedestalBlock> CODEC = simpleCodec(VillagerPedestalBlock::new);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    protected static final VoxelShape SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);

    public VillagerPedestalBlock(Properties p_49795_)
    {
        super(p_49795_);
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.FALSE).setValue(FACING, Direction.NORTH));
    }

    @Override
    public MapCodec<? extends VillagerPedestalBlock> codec() {
        return CODEC;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add( WATERLOGGED, FACING);
    }

    @Override
    protected @NotNull FluidState getFluidState(BlockState pState)
    {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext)
    {
        return SHAPE;
    }
    @Override
    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
        BlockState blockstate = this.defaultBlockState()
                .setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER)).setValue(FACING, pContext.getHorizontalDirection());
        return blockstate;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState)
    {
        return new PedestalBlockEntity(pPos, pState);
    }
    @Override
    protected ItemInteractionResult useItemOn(
            ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult
    ) {
        if (pLevel.getBlockEntity(pPos) instanceof PedestalBlockEntity pedestalBlockEntity)
        {
            ItemStack itemstack = pPlayer.getItemInHand(pHand);
            if (!pLevel.isClientSide && pedestalBlockEntity.placeItem(pPlayer, itemstack))
            {
                pLevel.playSound(null, pPos, SoundEvents.ITEM_FRAME_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                return ItemInteractionResult.SUCCESS;
            }
            else if(!pLevel.isClientSide && pedestalBlockEntity.removeItem(pPos, pLevel, pPlayer, itemstack))
            {
                pLevel.playSound(null, pPos, SoundEvents.ITEM_FRAME_REMOVE_ITEM, SoundSource.BLOCKS, 1.0F, 1.0F);
                return ItemInteractionResult.SUCCESS;
            }
            return ItemInteractionResult.CONSUME;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
    @Override
    protected void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (!pState.is(pNewState.getBlock())) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof PedestalBlockEntity) {
                Containers.dropContents(pLevel, pPos, ((PedestalBlockEntity)blockentity).getItems());
            }

            super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
        }
    }
    @Override
    protected RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    public static void dowse(@javax.annotation.Nullable Entity pEntity, LevelAccessor pLevel, BlockPos pPos, BlockState pState) {

        BlockEntity blockentity = pLevel.getBlockEntity(pPos);
        if (blockentity instanceof PedestalBlockEntity)
        {
            ((PedestalBlockEntity)blockentity).dowse();
        }

        pLevel.gameEvent(pEntity, GameEvent.BLOCK_CHANGE, pPos);
    }
    @Override
    protected BlockState rotate(BlockState pState, Rotation pRot)
    {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }
}
