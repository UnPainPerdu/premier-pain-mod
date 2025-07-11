package com.unpainperdu.premierpainmod.level.world.block.crafting_block;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.ModBlockStateProperties;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.crafting_block.CookingPotBlockEntity;
import com.unpainperdu.premierpainmod.util.register.block.BlockEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
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
    protected @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context)
    {
        VoxelShape finalShape;
        if (state.getValue(ModBlockStateProperties.HANGING))
        {
            finalShape = Block.box(1, 0, 1, 15, 16, 15);
        }
        else
        {
            finalShape = Block.box(1, 0, 1, 15, 9, 15);
        }
        return finalShape;
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
    protected @NotNull BlockState updateShape(BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos)
    {
        if (state.getValue(WATERLOGGED))
        {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
            state = state.setValue(BlockStateProperties.LIT, false);
        }
        if (canBeHanging(level, pos))
        {
            state = state.setValue(ModBlockStateProperties.HANGING, true);
        }
        else
        {
            state = state.setValue(ModBlockStateProperties.HANGING, false);
        }
        if (canBeLit(level, pos) && !state.getValue(WATERLOGGED))
        {
            state = state.setValue(BlockStateProperties.LIT, true);
        }
        else
        {
            state = state.setValue(BlockStateProperties.LIT, false);
        }

        return state;
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult)
    {
        if (level.isClientSide)
        {
            return InteractionResult.SUCCESS;
        }
        else
        {
            BlockEntity blockentity = level.getBlockEntity(pos);
            if (blockentity instanceof CookingPotBlockEntity pot)
            {
                player.openMenu(pot, pos);
            }
            return InteractionResult.CONSUME;
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
            if (blockentity instanceof CookingPotBlockEntity)
            {
                Containers.dropContents(level, pos, ((CookingPotBlockEntity) blockentity).getItems());
            }

            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    private boolean canBeLit(LevelAccessor level, BlockPos potPos)
    {
        boolean isFireBlockBehind = false;
        BlockPos belowPos = potPos.below();
        BlockState stateBelow = level.getBlockState(belowPos);
        Block block = stateBelow.getBlock();
        if (block instanceof CampfireBlock && canBeHanging(level, potPos))
        {
            isFireBlockBehind = stateBelow.getValue(BlockStateProperties.LIT);
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
        BlockState state = level.getBlockState(potPos);
        if (state.hasProperty(BlockStateProperties.WATERLOGGED))
        {
            if (state.getValue(BlockStateProperties.WATERLOGGED))
            {
                isFireBlockBehind = false;
            }
        }


        return isFireBlockBehind;
    }

    private boolean canBeHanging(LevelAccessor level, BlockPos potPos)
    {
        boolean canBeHanging = false;
        BlockPos belowPos = potPos.below();
        BlockState state = level.getBlockState(belowPos);
        Block block = state.getBlock();
        if (block instanceof CampfireBlock
                || block instanceof BaseFireBlock)
        {
            canBeHanging = true;
        }
        if (block instanceof LiquidBlock
                || block instanceof AirBlock)
        {
            BlockPos belowBelowPos = belowPos.below();
            BlockState belowBelowState = level.getBlockState(belowBelowPos);
            Block belowBelowBlock = belowBelowState.getBlock();
            if (!(belowBelowBlock instanceof LiquidBlock
                    || belowBelowBlock instanceof AirBlock))
            {
                canBeHanging = true;
            }
        }
        return canBeHanging;
    }

    @Override
    public boolean placeLiquid(@NotNull LevelAccessor level, @NotNull BlockPos pos, BlockState state, @NotNull FluidState fluidState)
    {
        if (!state.getValue(BlockStateProperties.WATERLOGGED) && fluidState.getType() == Fluids.WATER)
        {
            if (!level.isClientSide())
            {
                state = state.setValue(BlockStateProperties.WATERLOGGED, true).setValue(BlockStateProperties.LIT, false);
                level.setBlock(pos, state, 3);
                level.scheduleTick(pos, fluidState.getType(), fluidState.getType().getTickDelay(level));
            }
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public @NotNull ItemStack pickupBlock(@Nullable Player player, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockState state)
    {
        if (state.getValue(BlockStateProperties.WATERLOGGED))
        {
            level.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, false), 3);
            if (canBeLit(level, pos))
            {
                level.setBlock(pos, state.setValue(BlockStateProperties.LIT, true), 3);
            }
            if (!state.canSurvive(level, pos))
            {
                level.destroyBlock(pos, true);
            }

            return new ItemStack(Items.WATER_BUCKET);
        }
        else
        {
            return ItemStack.EMPTY;
        }
    }
}
