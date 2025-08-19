package com.unpainperdu.premierpainmod.level.world.block.tree;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.ModBlockStateProperties;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FallingLeavesBlock extends Block implements SimpleWaterloggedBlock
{
    public static final MapCodec<FallingLeavesBlock> CODEC = simpleCodec(FallingLeavesBlock::new);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty BOTTOM_PART = ModBlockStateProperties.BOTTOM_PART;

    public FallingLeavesBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(BOTTOM_PART, true)
                .setValue(WATERLOGGED, false)
        );
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(BOTTOM_PART, WATERLOGGED);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context)
    {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        FluidState fluidstate = level.getFluidState(context.getClickedPos());
        return this.defaultBlockState()
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER)
                .setValue(BOTTOM_PART, canBeBottomPart(level, pos))
                ;
    }

    @Override
    protected boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos)
    {
        BlockState aboveState = level.getBlockState(pos.above());

        return aboveState.is(BlockTags.LEAVES) || aboveState.getBlock() instanceof FallingLeavesBlock || aboveState.is(BlockTags.LOGS);
    }

    @Override
    protected @NotNull BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos)
    {
        BlockState resultState = state;
        if (!state.canSurvive(level, pos))
        {
            resultState = Blocks.AIR.defaultBlockState();
        }
        else if (level.getBlockState(pos.below()).getBlock() instanceof FallingLeavesBlock)
        {
            resultState = resultState.setValue(ModBlockStateProperties.BOTTOM_PART, false);
        }
        else
        {
            resultState = resultState.setValue(ModBlockStateProperties.BOTTOM_PART, true);
        }

        return resultState;
    }

    private boolean canBeBottomPart(Level level, BlockPos pos)
    {
        BlockState belowBlockState = level.getBlockState(pos.below());

        return !(belowBlockState.is(BlockRegister.FALLING_WEEPING_WILLOW_LEAVES.get()));
    }
}
