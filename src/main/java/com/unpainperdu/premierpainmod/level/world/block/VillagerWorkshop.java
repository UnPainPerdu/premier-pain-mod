package com.unpainperdu.premierpainmod.level.world.block;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.state.properties.VillagerWorkshopPart;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class VillagerWorkshop extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock
{
    public static final MapCodec<VillagerWorkshop> CODEC = simpleCodec(VillagerWorkshop::new);
    public static final EnumProperty<VillagerWorkshopPart> PART;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 12, 16);

    public VillagerWorkshop(Properties pProperties)
    {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, VillagerWorkshopPart.RIGHT).setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec()
    {
        return CODEC;
    }

    @Nullable
    public static Direction getVillagerWorkshopOrientation(BlockGetter pLevel, BlockPos pPos)
    {
        BlockState blockstate = pLevel.getBlockState(pPos);
        return blockstate.getBlock() instanceof VillagerWorkshop ? (Direction)blockstate.getValue(FACING) : null;
    }

    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos)
    {
        if (pState.getValue(WATERLOGGED))
        {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }
        VillagerWorkshopPart villagerWorkshopPart = pState.getValue(PART);
        if (pFacing != getNeighbourDirection((VillagerWorkshopPart) pState.getValue(PART), DirectionSwitcher(pState.getValue(FACING))))
        {
            return villagerWorkshopPart == VillagerWorkshopPart.RIGHT && pFacing == reverseDirectionSwitcher(pState.getValue(FACING)) && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
        }
        else
        {
            return pFacingState.is(this) && pFacingState.getValue(PART) != pState.getValue(PART) ? (BlockState)pState : Blocks.AIR.defaultBlockState();
        }
    }

    @Override
    protected @NotNull FluidState getFluidState(BlockState pState)
    {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    private static Direction getNeighbourDirection(VillagerWorkshopPart pPart, Direction pDirection)
    {
        return pPart == VillagerWorkshopPart.RIGHT ? pDirection : pDirection.getOpposite();
    }

    public BlockState playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer)
    {
        if (!pLevel.isClientSide && (pPlayer.isCreative() || !pPlayer.hasCorrectToolForDrops(pState, pLevel, pPos)))
        {
            preventCreativeDropFromRightPart(pLevel, pPos, pState, pPlayer);
        }

        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
        return pState;
    }
    //Pète le bloc de droite si gauche cassé
    protected static void preventCreativeDropFromRightPart(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer)
    {
        VillagerWorkshopPart villagerWorkshopPart = (VillagerWorkshopPart)pState.getValue(PART);
        if (villagerWorkshopPart == VillagerWorkshopPart.LEFT)
        {
            BlockPos blockpos = pPos.relative(reverseDirectionSwitcher(pState.getValue(FACING)));
            BlockState blockstate = pLevel.getBlockState(blockpos);
            if (blockstate.is(pState.getBlock()) && blockstate.getValue(PART) == VillagerWorkshopPart.RIGHT)
            {
                BlockState blockstate1 = blockstate.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                pLevel.setBlock(blockpos, blockstate1, 35);
                pLevel.levelEvent(pPlayer, 2001, blockpos, Block.getId(blockstate));
            }
        }
    }
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext)
    {
        Level level = pContext.getLevel();
        Direction direction = pContext.getHorizontalDirection();
        BlockPos blockpos = pContext.getClickedPos();
        BlockPos blockpos1 = blockpos.relative(DirectionSwitcher(direction));
        FluidState fluidstateDown = level.getFluidState(blockpos);
        boolean flag = fluidstateDown.getType() == Fluids.WATER;

        return level.getBlockState(blockpos1).canBeReplaced(pContext) && level.getWorldBorder().isWithinBounds(blockpos1) ? (BlockState)this.defaultBlockState().setValue(FACING, direction).setValue(WATERLOGGED, Boolean.valueOf(flag)) : null;
    }
    //Applique la hit-box
    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_)
    {
        return SHAPE;
    }

    public static Direction getConnectedDirection(BlockState pState)
    {
        Direction direction = DirectionSwitcher(pState.getValue(FACING));
        return pState.getValue(PART) == VillagerWorkshopPart.LEFT ? direction.getOpposite() : direction;
    }

    public static DoubleBlockCombiner.BlockType getBlockType(BlockState pState)
    {
        VillagerWorkshopPart villagerWorkshopPart = (VillagerWorkshopPart)pState.getValue(PART);
        return villagerWorkshopPart == VillagerWorkshopPart.LEFT ? DoubleBlockCombiner.BlockType.FIRST : DoubleBlockCombiner.BlockType.SECOND;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(new Property[]{FACING, PART, WATERLOGGED});
    }
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack)
    {
        BlockPos blockpos1 = pPos.relative(DirectionSwitcher(pState.getValue(FACING)));
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
        if (!pLevel.isClientSide)
        {
            FluidState fluidstateUp = pLevel.getFluidState(blockpos1);
            boolean flag = fluidstateUp.getType() == Fluids.WATER;
            BlockPos blockpos = pPos.relative(DirectionSwitcher(pState.getValue(FACING)));
            pLevel.setBlock(blockpos, (BlockState)pState.setValue(PART, VillagerWorkshopPart.LEFT).setValue(WATERLOGGED, Boolean.valueOf(flag)), 3);
            pLevel.blockUpdated(pPos, Blocks.AIR);
            pState.updateNeighbourShapes(pLevel, pPos, 3);
        }

    }
    private static Direction DirectionSwitcher(Direction direction)
    {
        switch (direction)
        {
            case Direction.WEST:
            {
                return Direction.SOUTH;
            }
            case Direction.EAST:
            {
                return Direction.NORTH;
            }
            case Direction.SOUTH:
            {
                return Direction.EAST;
            }
            default:
            {
                return Direction.WEST;
            }
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
    static
    {
        PART = EnumProperty.create("villagerworkshoppart", VillagerWorkshopPart.class);
    }
}
