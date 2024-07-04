package com.unpainperdu.premierpainmod.level.world.block.twoBlockWidthWithBlockEntity.villagerShelf;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.VillagerTableBlock;
import com.unpainperdu.premierpainmod.level.world.block.state.properties.TwoBlockWidthPart;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidthWithBlockEntity.AbstractTwoBlockWidthWithBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class StandingVillagerShelf extends VillagerShelf
{
    private static final BooleanProperty HAS_SHELF_ON_TOP = BooleanProperty.create("has_shelf_on_top");
    private static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 16, 15);
    public static final MapCodec<StandingVillagerShelf> CODEC = simpleCodec(StandingVillagerShelf::new);

    public StandingVillagerShelf(Properties pProperties)
    {
        super(pProperties);
        BlockState blockstate = this.stateDefinition.any().setValue(PART, TwoBlockWidthPart.RIGHT).setValue(WATERLOGGED, Boolean.FALSE).setValue(HAS_SHELF_ON_TOP,Boolean.FALSE);

        this.registerDefaultState(blockstate);
    }

    @Override
    protected MapCodec<? extends AbstractTwoBlockWidthWithBlockEntity> codec()
    {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_)
    {
        return SHAPE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(new Property[]{FACING, PART, WATERLOGGED, HAS_SHELF_ON_TOP});
    }

    @Override
    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos)
    {
        if (pState.getValue(WATERLOGGED))
        {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        TwoBlockWidthPart twoBlockWidthPart = pState.getValue(PART);
        if (pFacing != getNeighbourDirection(twoBlockWidthPart, DirectionSwitcher(pState.getValue(FACING))))
        {
            if (twoBlockWidthPart == TwoBlockWidthPart.RIGHT && pFacing == reverseDirectionSwitcher(pState.getValue(FACING)) && !pState.canSurvive(pLevel, pCurrentPos))
            {
                return Blocks.AIR.defaultBlockState();
            }
            else
            {
                if(pFacing == Direction.UP)
                {
                    return pState.setValue(HAS_SHELF_ON_TOP, this.connectsTo(pFacingState, pFacingState.isFaceSturdy(pLevel, pFacingPos, pFacing.getOpposite()), pFacing.getOpposite()));
                }
                else
                {
                    return super.superUpdateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
                }
            }
        }
        else
        {
            if (pFacingState.is(this) && pFacingState.getValue(PART) != pState.getValue(PART))
            {
                return (BlockState) pState;
            }
            else
            {
               return Blocks.AIR.defaultBlockState();
            }
        }
    }
    public boolean connectsTo(BlockState pState, boolean pIsSideSolid, Direction pDirection)
    {
        Block block = pState.getBlock();
        return block instanceof StandingVillagerShelf;
    }
}
