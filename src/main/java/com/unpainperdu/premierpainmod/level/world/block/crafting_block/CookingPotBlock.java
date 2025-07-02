package com.unpainperdu.premierpainmod.level.world.block.crafting_block;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.ModBlockStateProperties;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.all_materials_block.VillagerBrewingStationBlockEntity;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.crafting_block.CookingPotBlockEntity;
import com.unpainperdu.premierpainmod.util.register.block.BlockEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.LavaFluid;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CookingPotBlock extends BaseEntityBlock implements SimpleWaterloggedBlock
{
    public static final MapCodec<CookingPotBlock> CODEC = simpleCodec(CookingPotBlock::new);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty HANGING = ModBlockStateProperties.HANGING;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public CookingPotBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.FALSE).setValue(LIT, Boolean.FALSE).setValue(HANGING, Boolean.FALSE).setValue(FACING, Direction.NORTH));
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec()
    {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(WATERLOGGED, FACING, LIT, HANGING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        FluidState fluidstate = level.getFluidState(context.getClickedPos());
        return this.defaultBlockState()
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER)
                .setValue(LIT, canBeLit(level, pos))
                .setValue(FACING, context.getHorizontalDirection())
                .setValue(HANGING, canBeHanging(level, pos))
                ;
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
            this.openContainer(level, pos, player);
            return InteractionResult.CONSUME;
        }
    }

    protected void openContainer(Level level, BlockPos pos, Player player)
    {
        BlockEntity blockentity = level.getBlockEntity(pos);
        if (blockentity instanceof CookingPotBlockEntity pot)
        {
            player.openMenu(pot, pos);
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state)
    {
        return new CookingPotBlockEntity(pos, state);
    }

    @javax.annotation.Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> blockEntityType)
    {
        return CookingPotBlockEntity.createTicker(level, blockEntityType, BlockEntityRegister.COOKING_POT_BLOCK_ENTITY.get());
    }

    @Override
    protected @NotNull BlockState rotate(BlockState state, Rotation rot)
    {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    protected @NotNull RenderShape getRenderShape(@NotNull BlockState state)
    {
        return RenderShape.MODEL;
    }

    @Override
    protected void onRemove(BlockState state, @NotNull Level level, @NotNull BlockPos pos, BlockState newState, boolean isMoving)
    {
        if (!state.is(newState.getBlock()))
        {
            BlockEntity blockentity = level.getBlockEntity(pos);
            if (blockentity instanceof VillagerBrewingStationBlockEntity)
            {
                Containers.dropContents(level, pos, ((VillagerBrewingStationBlockEntity) blockentity).getItems());
            }

            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    private boolean canBeLit(Level level, BlockPos potPos)
    {
        boolean isFireBlockBehind = false;
        BlockPos belowPos = potPos.below();
        BlockState state = level.getBlockState(belowPos);
        Block block = state.getBlock();
        if (block instanceof CampfireBlock)
        {
            isFireBlockBehind = state.getValue(BlockStateProperties.LIT);
        }
        if (block instanceof MagmaBlock
            || block instanceof BaseFireBlock
        )
        {
            isFireBlockBehind = true;
        }
        if (block instanceof LiquidBlock liquidBlock)
        {
            if (liquidBlock.fluid instanceof LavaFluid)
            {
                isFireBlockBehind = true;
            }
        }

        return isFireBlockBehind;
    }

    private boolean canBeHanging(Level level, BlockPos potPos)
    {
        boolean canBeHanging = false;
        BlockPos belowPos = potPos.below();
        BlockState state = level.getBlockState(belowPos);
        Block block = state.getBlock();
        if (block instanceof CampfireBlock
            || block instanceof BaseFireBlock
        )
        {
            canBeHanging = true;
        }
        if (block instanceof LiquidBlock liquidBlock)
        {
            if (liquidBlock.fluid instanceof LavaFluid)
            {
                canBeHanging = true;
            }
        }

        return canBeHanging;
    }
}
