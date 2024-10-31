package com.unpainperdu.premierpainmod.level.world.block.abstractBlock;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.util.toolKit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public abstract class AbstractCropLikeBlock extends Block implements BonemealableBlock
{
    public final int MAX_AGE;
    public final int MIN_LIGHT_NEEDED;
    protected final TagKey<Block> BLOCKS_ON;
    public boolean isLightNeeded = false;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_15;

    public AbstractCropLikeBlock(Properties properties, int maxAge, int lightNeeded, TagKey<Block> blocksOn)
    {
        super(properties);
        MAX_AGE = maxAge;
        MIN_LIGHT_NEEDED = lightNeeded;
        BLOCKS_ON = blocksOn;
        if (lightNeeded > 0)
        {
            this.isLightNeeded = true;
        }
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state)
    {
        return (state.getValue(AbstractCropLikeBlock.AGE) < MAX_AGE);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random)
    {
        if (!level.isAreaLoaded(pos, 1)) return;
        if (state.getValue(AbstractCropLikeBlock.AGE) < MAX_AGE)
        {
            if (!(isLightNeeded) || level.getRawBrightness(pos, 0) >= MIN_LIGHT_NEEDED)
            {
                level.setBlock(pos, state.setValue(AbstractCropLikeBlock.AGE, state.getValue(AbstractCropLikeBlock.AGE) + 1), 2);
            }
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(AGE);
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState pFacingState, LevelAccessor level, BlockPos pos, BlockPos pFacingPos)
    {
        if (!state.canSurvive(level, pos))
        {
            level.scheduleTick(pos, this, 1);
        }

        return super.updateShape(state, direction, pFacingState, level, pos, pFacingPos);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos)
    {
        boolean flag = false;
        state = level.getBlockState(pos);
        BlockState stateBelow = level.getBlockState(pos.below());
        if(state.getBlock() instanceof AirBlock)
        {
            if (stateBelow.is(BLOCKS_ON))
            {
                flag = true;
            }
        }
        else if (state.getBlock() instanceof AbstractCropLikeBlock)
        {
            if (stateBelow.is(BLOCKS_ON))
            {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random)
    {
        if (!state.canSurvive(level, pos))
        {
            level.destroyBlock(pos, true);
        }
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType)
    {
        return false;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state)
    {
        return (level.getBlockState(pos).getValue(AGE) < MAX_AGE) && (!(isLightNeeded) || level.getRawBrightness(pos, 0) >= MIN_LIGHT_NEEDED);
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state)
    {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state)
    {
        int ageAdd = RandomUtil.getRandomPositiveIntInRange(4, random);
        int newAge = state.getValue(AGE) + ageAdd;
        if (newAge > MAX_AGE)
        {
            newAge = MAX_AGE;
        }
        level.setBlock(pos, state.setValue(AGE, newAge), 2);
    }

    @Override
    protected abstract MapCodec<? extends AbstractCropLikeBlock> codec();

    @Override
    protected abstract VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context);
}
