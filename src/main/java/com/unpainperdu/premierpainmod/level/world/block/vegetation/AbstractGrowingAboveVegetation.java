package com.unpainperdu.premierpainmod.level.world.block.vegetation;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractGrowingAboveVegetation extends Block
{
    public static final IntegerProperty MAX_HEIGHT = IntegerProperty.create("max_height", 0, 25);
    public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
    protected static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 16, 14);

    public final int max_height;

    public AbstractGrowingAboveVegetation(Properties properties, int max_height)
    {
        super(properties);
        this.max_height = max_height;
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(MAX_HEIGHT, 0));
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext)
    {
        return SHAPE;
    }

    @Override
    protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom)
    {
        if (!pState.canSurvive(pLevel, pPos))
        {
            pLevel.destroyBlock(pPos, true);
        }
    }

    @Override
    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom)
    {
        if (pLevel.isEmptyBlock(pPos.above()))
        {
            int i = 1;

            while (pLevel.getBlockState(pPos.below(i)).getBlock() instanceof AbstractGrowingAboveVegetation)
            {
                i++;
            }

            int maxHeight = pState.getValue(MAX_HEIGHT);
            if (i < maxHeight)
            {
                int j = pState.getValue(AGE);
                if (net.neoforged.neoforge.common.CommonHooks.canCropGrow(pLevel, pPos, pState, true))
                {
                    if (j == 15)
                    {
                        pLevel.setBlockAndUpdate(pPos.above(), this.defaultBlockState().setValue(MAX_HEIGHT, maxHeight));
                        net.neoforged.neoforge.common.CommonHooks.fireCropGrowPost(pLevel, pPos.above(), this.defaultBlockState());
                        System.out.println("modif");
                        pLevel.setBlock(pPos, pState.setValue(AGE, 0).setValue(MAX_HEIGHT, getRandomMaxHeight(getSeedFromPos(pPos))), 4);
                    }
                    else
                    {
                        pLevel.setBlock(pPos, pState.setValue(AGE, j + 1), 4);
                    }
                }
            }
        }
    }

    @Override
    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos)
    {
        if (!pState.canSurvive(pLevel, pCurrentPos))
        {
            pLevel.scheduleTick(pCurrentPos, this, 1);
        }

        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    @Override
    protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos)
    {
        BlockState blockstate = pLevel.getBlockState(pPos.below());
        if (blockstate.is(this))
        {
            return true;
        }
        else
        {
            if (blockstate.is(BlockTags.DIRT))
            {
                return true;
            }
            return false;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(AGE, MAX_HEIGHT);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState pState)
    {
        return true;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext)
    {
        BlockPos pos = pContext.getClickedPos();
        long seed = getSeedFromPos(pos);
        int randomMaxHeight = getRandomMaxHeight(seed);
        return this.defaultBlockState().setValue(MAX_HEIGHT, randomMaxHeight);
    }

    public int getRandomMaxHeight()
    {
        return getRandomMaxHeight((long) (Math.abs(RandomSource.create().nextInt()))%20);
    }
    public int getRandomMaxHeight(long seed)
    {
        return ((Math.abs(RandomSource.create(seed).nextInt())) % (this.max_height -1) ) + 2 ;
    }

    public long getSeedFromPos(BlockPos pos)
    {
        return pos.getX() + pos.getY() + pos.getZ() + (long) (Math.abs(RandomSource.create().nextInt()))%20;
    }
}
