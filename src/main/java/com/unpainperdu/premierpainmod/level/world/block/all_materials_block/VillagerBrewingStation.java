package com.unpainperdu.premierpainmod.level.world.block.all_materials_block;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.ModBlockStateProperties;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.LiquidContent;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.all_materials_block.VillagerBrewingStationBlockEntity;
import com.unpainperdu.premierpainmod.util.register.block.BlockEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
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
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VillagerBrewingStation extends BaseEntityBlock
{
    public static final MapCodec<VillagerBrewingStation> CODEC = simpleCodec(VillagerBrewingStation::new);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    private static final VoxelShape BASE = Block.box(1, 0, 1, 15, 15, 15);
    private static final VoxelShape NORTH_PART = Block.box(1, 0, 0, 15, 15, 1);
    private static final VoxelShape SOUTH_PART = Block.box(1, 0, 15, 15, 15, 16);
    private static final VoxelShape WEST_PART = Block.box(0, 0, 1, 1, 15, 15);
    private static final VoxelShape EAST_PART = Block.box(15, 0, 1, 16, 15, 15);
    private static final VoxelShape Y_SHAPE = Shapes.or(BASE, NORTH_PART, SOUTH_PART);
    private static final VoxelShape X_SHAPE = Shapes.or(BASE, WEST_PART, EAST_PART);

    public VillagerBrewingStation(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.FALSE).setValue(FACING, Direction.NORTH));
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
        return new VillagerBrewingStationBlockEntity(pos, state);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext)
    {
        Direction direction = blockState.getValue(FACING);
        return direction.getAxis() == Direction.Axis.X ? X_SHAPE : Y_SHAPE;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult)
    {
        if (level.isClientSide)
        {
            return InteractionResult.SUCCESS;
        } else
        {
            this.openContainer(level, pos, player);
            return InteractionResult.CONSUME;
        }
    }


    protected void openContainer(Level level, BlockPos pos, Player player)
    {
        BlockEntity blockentity = level.getBlockEntity(pos);
        if (blockentity instanceof VillagerBrewingStationBlockEntity)
        {
            player.openMenu((VillagerBrewingStationBlockEntity)blockentity, pos);
        }
    }

    @Override
    protected int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos pos)
    {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
    }

    @Override
    protected boolean hasAnalogOutputSignal(BlockState state)
    {
        return true;
    }

    @Override
    protected @NotNull FluidState getFluidState(BlockState pState)
    {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (pState.getValue(WATERLOGGED))
        {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add( WATERLOGGED, FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext)
    {
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
        return this.defaultBlockState()
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER)
                .setValue(FACING, pContext.getHorizontalDirection());
    }

    @Override
    protected BlockState rotate(BlockState pState, Rotation pRot)
    {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }

    @Override
    protected RenderShape getRenderShape(BlockState pState)
    {
        return RenderShape.MODEL;
    }

    @Override
    protected void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving)
    {
        if (!pState.is(pNewState.getBlock()))
        {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof VillagerBrewingStationBlockEntity)
            {
                Containers.dropContents(pLevel, pPos, ((VillagerBrewingStationBlockEntity)blockentity).getItems());
            }

            super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
        }
    }

    @javax.annotation.Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType)
    {
        return VillagerBrewingStationBlockEntity.createBrewingStationTicker(level, blockEntityType, BlockEntityRegister.VILLAGER_BREWING_STATION_ENTITY.get());
    }
}
