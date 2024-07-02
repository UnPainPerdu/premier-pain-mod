package com.unpainperdu.premierpainmod.level.world.block.twoBlockWidthWithBlockEntity.villagerShelf;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidthWithBlockEntity.AbstractTwoBlockWidthWithBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class VillagerShelf extends AbstractTwoBlockWidthWithBlockEntity
{
    public static final List<BooleanProperty> SLOT_OCCUPIED_PROPERTIES = List.of(
            BlockStateProperties.CHISELED_BOOKSHELF_SLOT_0_OCCUPIED,
            BlockStateProperties.CHISELED_BOOKSHELF_SLOT_1_OCCUPIED,
            BlockStateProperties.CHISELED_BOOKSHELF_SLOT_2_OCCUPIED,
            BlockStateProperties.CHISELED_BOOKSHELF_SLOT_3_OCCUPIED,
            BlockStateProperties.CHISELED_BOOKSHELF_SLOT_4_OCCUPIED,
            BlockStateProperties.CHISELED_BOOKSHELF_SLOT_5_OCCUPIED
    );

    public VillagerShelf(BlockBehaviour.Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    protected abstract MapCodec<? extends AbstractTwoBlockWidthWithBlockEntity> codec();

    @Override
    public abstract VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_);

    protected abstract void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder);

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState)
    {
        return null;
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
            return InteractionResult.CONSUME;
        }
    }
    @Override
    protected RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }
}
