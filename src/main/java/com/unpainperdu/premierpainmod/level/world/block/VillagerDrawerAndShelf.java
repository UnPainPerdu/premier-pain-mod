package com.unpainperdu.premierpainmod.level.world.block;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.state.properties.VillagerMultiBlock;
import com.unpainperdu.premierpainmod.level.world.block.state.properties.VillagerTableCarpetColor;
import com.unpainperdu.premierpainmod.level.world.block.state.properties.VillagerWorkshopPart;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class VillagerDrawerAndShelf extends Block implements SimpleWaterloggedBlock
{
    public static final MapCodec<VillagerDrawerAndShelf> CODEC = simpleCodec(VillagerDrawerAndShelf::new);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<VillagerMultiBlock> VILLAGER_MULTI_BLOCK_ENUM_PROPERTY;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public VillagerDrawerAndShelf(Properties properties)
    {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition
                        .any()
                        .setValue(VILLAGER_MULTI_BLOCK_ENUM_PROPERTY, VillagerMultiBlock.B1_L1)
                        .setValue(FACING, Direction.NORTH)
                        .setValue(WATERLOGGED, Boolean.FALSE)
        );
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(FACING, WATERLOGGED, VILLAGER_MULTI_BLOCK_ENUM_PROPERTY);
    }
    static
    {
        VILLAGER_MULTI_BLOCK_ENUM_PROPERTY = EnumProperty.create("villager_multi_block", VillagerMultiBlock.class);
    }
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext)
    {
        Level level = pContext.getLevel();
        BlockPos b1_l1 = pContext.getClickedPos();
        BlockPos b2_l1 = b1_l1.relative(reverseDirectionSwitcher(pContext.getHorizontalDirection()));
        BlockPos b1_l2 = b1_l1.above();
        BlockPos b2_l2 = b2_l1.above();
        BlockPos b1_l3 = b1_l2.above();
        BlockPos b2_l3 = b2_l2.above();

        FluidState fluidstateDown = level.getFluidState(b1_l1);

        boolean flag = fluidstateDown.getType() == Fluids.WATER;
        if ((b1_l3.getY() < level.getMaxBuildHeight() - 1)
                && (level.getBlockState(b2_l1).canBeReplaced(pContext))
                && (level.getBlockState(b2_l2).canBeReplaced(pContext))
                && (level.getBlockState(b2_l3).canBeReplaced(pContext))
                && (level.getBlockState(b1_l2).canBeReplaced(pContext))
                && (level.getBlockState(b1_l3).canBeReplaced(pContext))
        )
        {
            return this.defaultBlockState().setValue(VILLAGER_MULTI_BLOCK_ENUM_PROPERTY, VillagerMultiBlock.B1_L1).setValue(WATERLOGGED, flag).setValue(FACING, pContext.getHorizontalDirection());
        } else {
            return null;
        }
    }
    private static Direction reverseDirectionSwitcher(Direction direction)
    {
        switch (direction)
        {
            case Direction.WEST:
            {
                return Direction.NORTH;
            }
            case Direction.EAST:
            {
                return Direction.SOUTH;
            }
            case Direction.SOUTH:
            {
                return Direction.WEST;
            }
            default:
            {
                return Direction.EAST;
            }
        }
    }

    @Override
    protected @NotNull FluidState getFluidState(BlockState pState)
    {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack)
    {
        Direction direction = pState.getValue(FACING);
        BlockPos b1_l1 = pPos;
        BlockPos b2_l1 = b1_l1.relative(reverseDirectionSwitcher(direction));
        BlockPos b1_l2 = b1_l1.above();
        BlockPos b2_l2 = b2_l1.above();
        BlockPos b1_l3 = b1_l2.above();
        BlockPos b2_l3 = b2_l2.above();

        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
        if (!pLevel.isClientSide)
        {
            //b2_l1
            FluidState fluidState_b2_l1 = pLevel.getFluidState(b2_l1);
            boolean flag_b2_l1 = fluidState_b2_l1.getType() == Fluids.WATER;
            pLevel.setBlock(b2_l1, (BlockState)pState.setValue(FACING, direction).setValue(WATERLOGGED, flag_b2_l1).setValue(VILLAGER_MULTI_BLOCK_ENUM_PROPERTY, VillagerMultiBlock.B2_L1), 3);
            //b2_l2
            FluidState fluidState_b2_l2 = pLevel.getFluidState(b2_l2);
            boolean flag_b2_l2 = fluidState_b2_l2.getType() == Fluids.WATER;
            pLevel.setBlock(b2_l2, (BlockState)pState.setValue(FACING, direction).setValue(WATERLOGGED, flag_b2_l2).setValue(VILLAGER_MULTI_BLOCK_ENUM_PROPERTY, VillagerMultiBlock.B2_L2), 3);
            //b2_l3
            FluidState fluidState_b2_l3 = pLevel.getFluidState(b2_l3);
            boolean flag_b2_l3 = fluidState_b2_l3.getType() == Fluids.WATER;
            pLevel.setBlock(b2_l3, (BlockState)pState.setValue(FACING, direction).setValue(WATERLOGGED, flag_b2_l3).setValue(VILLAGER_MULTI_BLOCK_ENUM_PROPERTY, VillagerMultiBlock.B2_L3), 3);
            //b1_l2
            FluidState fluidState_b1_l2 = pLevel.getFluidState(b1_l2);
            boolean flag_b1_l2 = fluidState_b1_l2.getType() == Fluids.WATER;
            pLevel.setBlock(b1_l2, (BlockState)pState.setValue(FACING, direction).setValue(WATERLOGGED, flag_b1_l2).setValue(VILLAGER_MULTI_BLOCK_ENUM_PROPERTY, VillagerMultiBlock.B1_L2), 3);

            //b1_l3
            FluidState fluidState_b1_l3 = pLevel.getFluidState(b1_l3);
            boolean flag_b1_l3 = fluidState_b1_l3.getType() == Fluids.WATER;
            pLevel.setBlock(b1_l3, (BlockState)pState.setValue(FACING, direction).setValue(WATERLOGGED, flag_b1_l3).setValue(VILLAGER_MULTI_BLOCK_ENUM_PROPERTY, VillagerMultiBlock.B1_L3), 3);
            pLevel.blockUpdated(pPos, Blocks.AIR);
            pState.updateNeighbourShapes(pLevel, pPos, 3);
        }
    }

    /*
    public @NotNull BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos)
    {
        List<VillagerMultiBlock> list_villager_multiblock = Arrays.asList(
                VillagerMultiBlock.B1_L1,
                VillagerMultiBlock.B1_L2,
                VillagerMultiBlock.B1_L3,
                VillagerMultiBlock.B2_L1,
                VillagerMultiBlock.B2_L2,
                VillagerMultiBlock.B2_L3
                );
        VillagerMultiBlock villagerMultiBlock_current_block = pState.getValue(VILLAGER_MULTI_BLOCK_ENUM_PROPERTY);
        if (pState.getValue(WATERLOGGED))
        {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }
        // pas fini à partir d'ici
        if (villagerMultiBlock_current_block == VillagerMultiBlock.B1_L1)
        {
            if (pFacingState.is(this) && pFacingState.getValue(VILLAGER_MULTI_BLOCK_ENUM_PROPERTY) != villagerMultiBlock_current_block)
            {
                return pState.setValue(FACING, pFacingState.getValue(FACING));
            }
            else
            {
                return Blocks.AIR.defaultBlockState();
            }
        }
        else
        {
            return doubleblockhalf == DoubleBlockHalf.LOWER && pFacing == Direction.DOWN && !pState.canSurvive(pLevel, pCurrentPos)
                    ? Blocks.AIR.defaultBlockState()
                    : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
        }
    }

    /*
    public BlockState playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer)
    {
        if (!pLevel.isClientSide && (pPlayer.isCreative() || !pPlayer.hasCorrectToolForDrops(pState, pLevel, pPos)))
        {
            preventCreativeDropFromBottomPart(pLevel, pPos, pState, pPlayer);
        }

        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
        return pState;
    }

    protected static void preventCreativeDropFromBottomPart(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer)
    {
        DoubleBlockHalf doubleblockhalf = pState.getValue(HALF);
        if (doubleblockhalf == DoubleBlockHalf.UPPER)
        {
            BlockPos blockpos = pPos.below();
            BlockState blockstate = pLevel.getBlockState(blockpos);
            if (blockstate.is(pState.getBlock()) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER)
            {
                BlockState blockstate1 = blockstate.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                pLevel.setBlock(blockpos, blockstate1, 35);
                pLevel.levelEvent(pPlayer, 2001, blockpos, Block.getId(blockstate));
            }
        }
    }
     */
}
