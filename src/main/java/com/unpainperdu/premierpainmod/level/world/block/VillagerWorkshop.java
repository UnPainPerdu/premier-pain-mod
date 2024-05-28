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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class VillagerWorkshop extends HorizontalDirectionalBlock
{
    public static final MapCodec<VillagerWorkshop> CODEC = simpleCodec(VillagerWorkshop::new);
    public static final EnumProperty<VillagerWorkshopPart> PART;
    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 12, 16);

    public VillagerWorkshop(Properties pProperties)
    {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, VillagerWorkshopPart.RIGHT));
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
        if (pFacing != getNeighbourDirection((VillagerWorkshopPart) pState.getValue(PART), directionSwitcher(pState)))
        {
            return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
        }
        else
        {
            return pFacingState.is(this) && pFacingState.getValue(PART) != pState.getValue(PART) ? (BlockState)pState : Blocks.AIR.defaultBlockState();
        }
    }

    private static Direction getNeighbourDirection(VillagerWorkshopPart pPart, Direction pDirection)
    {
        return pPart == VillagerWorkshopPart.RIGHT ? pDirection : pDirection.getOpposite();
    }
    public BlockState playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer)
    {
        if (!pLevel.isClientSide && pPlayer.isCreative())
        {
            VillagerWorkshopPart villagerWorkshopPart = (VillagerWorkshopPart)pState.getValue(PART);
            if (villagerWorkshopPart == VillagerWorkshopPart.RIGHT)
            {
                BlockPos blockpos = pPos.relative(getNeighbourDirection(villagerWorkshopPart, directionSwitcher(pState)));
                BlockState blockstate = pLevel.getBlockState(blockpos);
                if (blockstate.is(this) && blockstate.getValue(PART) == VillagerWorkshopPart.LEFT)
                {
                    pLevel.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
                    pLevel.levelEvent(pPlayer, 2001, blockpos, Block.getId(blockstate));
                }
            }
        }
        return super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext)
    {
        Direction direction = pContext.getHorizontalDirection();
        BlockPos blockpos = pContext.getClickedPos();
        BlockPos blockpos1 = blockpos.relative(direction);
        Level level = pContext.getLevel();
        return level.getBlockState(blockpos1).canBeReplaced(pContext) && level.getWorldBorder().isWithinBounds(blockpos1) ? (BlockState)this.defaultBlockState().setValue(FACING, direction) : null;
    }
    //Applique la hit-box
    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_)
    {
        return SHAPE;
    }

    public static Direction getConnectedDirection(BlockState pState)
    {
        Direction direction = directionSwitcher(pState);
        return pState.getValue(PART) == VillagerWorkshopPart.LEFT ? direction.getOpposite() : direction;
    }

    public static DoubleBlockCombiner.BlockType getBlockType(BlockState pState)
    {
        VillagerWorkshopPart villagerWorkshopPart = (VillagerWorkshopPart)pState.getValue(PART);
        return villagerWorkshopPart == VillagerWorkshopPart.LEFT ? DoubleBlockCombiner.BlockType.FIRST : DoubleBlockCombiner.BlockType.SECOND;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(new Property[]{FACING, PART});
    }
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack)
    {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
        if (!pLevel.isClientSide)
        {
            BlockPos blockpos = pPos.relative(directionSwitcher(pState));
            pLevel.setBlock(blockpos, (BlockState)pState.setValue(PART, VillagerWorkshopPart.LEFT), 3);
            pLevel.blockUpdated(pPos, Blocks.AIR);
            pState.updateNeighbourShapes(pLevel, pPos, 3);
        }

    }
    private static Direction directionSwitcher(BlockState pState)
    {
        switch (pState.getValue(FACING))
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
    static
    {
        PART = EnumProperty.create("villagerworkshoppart", VillagerWorkshopPart.class);
    }
}
