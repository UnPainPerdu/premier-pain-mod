package com.unpainperdu.premierpainmod.level.world.block.all_materials_block;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.help_interface.CarpetedBlock;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.ModBlockStateProperties;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.VillagerCarpetColor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Map;

public class VillagerTableBlock extends Block implements SimpleWaterloggedBlock, CarpetedBlock //TODO, transform it in simple a BE
{
    public static final MapCodec<VillagerTableBlock> CODEC = simpleCodec(VillagerTableBlock::new);
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<VillagerCarpetColor> COLOR = ModBlockStateProperties.VILLAGER_CARPET_COLOR;
    protected static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = PipeBlock.PROPERTY_BY_DIRECTION;
    private static final VoxelShape SHAPE = Block.box(1, 12, 1, 15, 15, 15);

    public VillagerTableBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition
                        .any()
                        .setValue(NORTH, Boolean.FALSE)
                        .setValue(EAST, Boolean.FALSE)
                        .setValue(SOUTH, Boolean.FALSE)
                        .setValue(WEST, Boolean.FALSE)
                        .setValue(WATERLOGGED, Boolean.FALSE)
                        .setValue(COLOR, VillagerCarpetColor.NONE)
        );
    }

    protected MapCodec<VillagerTableBlock> codec()
    {
        return CODEC;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(NORTH, EAST, SOUTH, WEST, WATERLOGGED, COLOR);
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_)
    {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext)
    {
        BlockGetter blockgetter = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
        BlockPos blockpos1 = blockpos.north();
        BlockPos blockpos2 = blockpos.east();
        BlockPos blockpos3 = blockpos.south();
        BlockPos blockpos4 = blockpos.west();
        BlockState blockstate = blockgetter.getBlockState(blockpos1);
        BlockState blockstate1 = blockgetter.getBlockState(blockpos2);
        BlockState blockstate2 = blockgetter.getBlockState(blockpos3);
        BlockState blockstate3 = blockgetter.getBlockState(blockpos4);
        return super.getStateForPlacement(pContext)
                .setValue(NORTH, this.connectsTo(blockstate))
                .setValue(EAST, this.connectsTo(blockstate1))
                .setValue(SOUTH, this.connectsTo(blockstate2))
                .setValue(WEST, this.connectsTo(blockstate3))
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }

    public boolean connectsTo(BlockState pState)
    {
        return pState.getBlock() instanceof VillagerTableBlock;
    }

    @Override
    protected @NotNull FluidState getFluidState(BlockState pState)
    {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    protected BlockState updateShape(BlockState selfState, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos selfPos, Direction direction, BlockPos facingPos, BlockState facingState, RandomSource rand)
    {
        if (selfState.getValue(WATERLOGGED))
        {
            scheduledTickAccess.createTick(selfPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return direction.getAxis().getPlane() == Direction.Plane.HORIZONTAL
                ? selfState.setValue(
                PROPERTY_BY_DIRECTION.get(direction),
                this.connectsTo(facingState)
        )
                : super.updateShape(selfState, level, scheduledTickAccess, selfPos, direction, facingPos, facingState, rand);
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rot)
    {
        return switch (rot)
        {
            case CLOCKWISE_180 -> state.setValue(NORTH, state.getValue(SOUTH))
                    .setValue(EAST, state.getValue(WEST))
                    .setValue(SOUTH, state.getValue(NORTH))
                    .setValue(WEST, state.getValue(EAST));
            case COUNTERCLOCKWISE_90 -> state.setValue(NORTH, state.getValue(EAST))
                    .setValue(EAST, state.getValue(SOUTH))
                    .setValue(SOUTH, state.getValue(WEST))
                    .setValue(WEST, state.getValue(NORTH));
            case CLOCKWISE_90 -> state.setValue(NORTH, state.getValue(WEST))
                    .setValue(EAST, state.getValue(NORTH))
                    .setValue(SOUTH, state.getValue(EAST))
                    .setValue(WEST, state.getValue(SOUTH));
            default -> state;
        };
    }

    @Override
    public VillagerCarpetColor getCarpetColor(BlockState state)
    {
        return state.getValue(VillagerTableBlock.COLOR);
    }

    @Override
    public void setCarpetColor(Level level, BlockPos pos, BlockState state, VillagerCarpetColor newColor)
    {
        level.setBlock(pos, state.setValue(VillagerTableBlock.COLOR, newColor), 3);
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType)
    {
        return false;
    }
}