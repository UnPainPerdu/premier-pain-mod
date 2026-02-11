package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.geology.pointed_crystal;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.level.world.block.geology.GrowingCrystalCluster;
import com.unpainperdu.premierpainmod.level.world.block.geology.PointedCrystalBlock;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.PointedCrystalState;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.AbstractFeature;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.Arrays;
import java.util.List;

/**
 * spawn eparse pointed crystal with base crystal and if have one, cluster block crystal, similar to {@link net.minecraft.world.level.levelgen.feature.PointedDripstoneFeature} with horizontal pointed crystal handle
 */
public class PointedCrystalFeature extends AbstractFeature<PointedCrystalConfiguration>
{
    public PointedCrystalFeature(Codec<PointedCrystalConfiguration> codec)
    {
        super(codec);
    }

    @Override
    public boolean canGenerate(FeaturePlaceContext<PointedCrystalConfiguration> context)
    {
        WorldGenLevel worldIn = context.level();
        BlockPos pos = context.origin();
        BlockState state = worldIn.getBlockState(pos.below());
        return canConvert(state);
    }

    private boolean canConvert(BlockState state)
    {
        return state.is(BlockTags.BASE_STONE_OVERWORLD) || state.is(BlockTags.DIRT);
    }

    @Override
    public void generate(FeaturePlaceContext<PointedCrystalConfiguration> context)
    {
        WorldGenLevel worldIn = context.level();
        RandomSource rand = context.random();
        BlockPos pos = context.origin();

        PointedCrystalConfiguration config = context.config();
        FloatProvider spread = config.spread();
        FloatProvider density = config.density();
        List<BlockStateProvider> blockAndPointedAndCluster = config.blockAndPointedAndCluster();

        createPatchOfBlocks(worldIn, rand, pos, blockAndPointedAndCluster, spread, density);

    }

    private void createPatchOfBlocks(WorldGenLevel worldIn, RandomSource rand, BlockPos basePos, List<BlockStateProvider> blockAndPointedAndCluster, FloatProvider spread, FloatProvider density)
    {
        tryGenerateBase(worldIn, rand, basePos, blockAndPointedAndCluster, density);

        float realSpread = spread.sample(rand);

        for (Direction direction : Direction.values())
        {
            if (!(rand.nextFloat() > realSpread))
            {
                BlockPos blockpos = basePos.relative(direction);
                tryGenerateBase(worldIn, rand, blockpos, blockAndPointedAndCluster, density);
                if (!(rand.nextFloat() > realSpread))
                {
                    BlockPos blockpos1 = blockpos.relative(Direction.getRandom(rand));
                    tryGenerateBase(worldIn, rand, blockpos1, blockAndPointedAndCluster, density);
                    if (!(rand.nextFloat() > realSpread))
                    {
                        BlockPos blockpos2 = blockpos1.relative(Direction.getRandom(rand));
                        tryGenerateBase(worldIn, rand, blockpos2, blockAndPointedAndCluster, density);
                    }
                }
            }
        }
    }

    private void tryGenerateBase(WorldGenLevel worldIn, RandomSource rand, BlockPos pos, List<BlockStateProvider> blockAndPointedAndCluster, FloatProvider density)
    {
        if (worldIn.isStateAtPosition(pos, this::canConvert))
        {
            int realDensity = (int) (density.sample(rand) * 100);
            List<Direction> directions = getTipDirection(rand);
            BlockState wantedBaseBlockState = blockAndPointedAndCluster.getFirst().getState(rand, pos);
            BlockState wantedPointedBlockState = blockAndPointedAndCluster.get(1).getState(rand, pos);
            BlockState wantedClusterBlockState = blockAndPointedAndCluster.get(2).getState(rand, pos);
            worldIn.setBlock(pos, wantedBaseBlockState, 2);
            int l = RandomUtil.getRandomPositiveIntInRange(100, rand);
            boolean hasCluster = blockAndPointedAndCluster.size() > 2;
            for (Direction direction : directions)
            {
                int finalDensity = hasCluster ? realDensity : realDensity + 15;
                if (l < finalDensity)
                {
                    createPointed(worldIn, rand, pos, wantedPointedBlockState, direction);
                }
            }
            l = RandomUtil.getRandomPositiveIntInRange(100, rand);
            if (hasCluster && l < realDensity - 30)
            {
                createCluster(worldIn, rand, pos, wantedClusterBlockState);
            }
        }
    }

    private void createPointed(WorldGenLevel worldIn, RandomSource rand, BlockPos blockPosedOnPos, BlockState pointed, Direction tipDirection)
    {
        BlockPos startPointedPos = blockPosedOnPos.relative(tipDirection);
        if (worldIn.isStateAtPosition(startPointedPos, s -> s.isAir() || s.is(Blocks.WATER)))
        {
            tryGeneratePointed(RandomUtil.getRandomPositiveIntInRange(7, rand) + 1, pointed, worldIn, startPointedPos, tipDirection);
        }
    }

    private void tryGeneratePointed(int howLong, BlockState pointed, WorldGenLevel worldIn, BlockPos basePos, Direction direction)
    {
        BlockState wantedBlockState = pointed;
        int realHowLong = 0;
        for (int i = 0; i < howLong; i++)
        {
            BlockPos checkedPos = basePos.relative(direction, i);
            if (!(worldIn.isStateAtPosition(checkedPos, s -> s.isAir() || s.is(Blocks.WATER))))
            {
                realHowLong = i;
                break;
            }
        }

        for (int i = realHowLong; i > 0; i--)
        {
            BlockPos currentPos = basePos.relative(direction, i - 1);
            wantedBlockState = wantedBlockState.setValue(PointedCrystalBlock.FACING, direction).setValue(PointedCrystalBlock.WATERLOGGED, worldIn.isWaterAt(currentPos));

            if (i == realHowLong - 1)
            {
                wantedBlockState = wantedBlockState.setValue(PointedCrystalBlock.POINTED_CRYSTAL_STATE, PointedCrystalState.START_TOP);
            }
            else if (i == realHowLong - 2)
            {
                wantedBlockState = wantedBlockState.setValue(PointedCrystalBlock.POINTED_CRYSTAL_STATE, PointedCrystalState.MIDDLE);
            }
            else if (i < realHowLong - 2)
            {
                if (i == 1)
                {
                    wantedBlockState = wantedBlockState.setValue(PointedCrystalBlock.POINTED_CRYSTAL_STATE, PointedCrystalState.BASE);
                }
                else
                {
                    wantedBlockState = wantedBlockState.setValue(PointedCrystalBlock.POINTED_CRYSTAL_STATE, PointedCrystalState.MIDDLE);
                }
            }
            worldIn.setBlock(currentPos, wantedBlockState, 2);
        }
    }

    private void createCluster(WorldGenLevel worldIn, RandomSource rand, BlockPos blockPosedOnPos, BlockState cluster)
    {
        for (Direction direction : Direction.values())
        {
            if (RandomUtil.getRandomPositiveIntInRange(4, rand) > 1)
            {
                tryGenerateCluster(worldIn, rand, blockPosedOnPos.relative(direction), cluster, direction);
            }
        }
    }

    private void tryGenerateCluster(WorldGenLevel worldIn, RandomSource rand, BlockPos pos, BlockState cluster, Direction tipDirection)
    {
        if (worldIn.isStateAtPosition(pos, s -> s.isAir() || s.is(Blocks.WATER)))
        {
            worldIn.setBlock(pos, cluster.setValue(GrowingCrystalCluster.FACING, tipDirection).setValue(GrowingCrystalCluster.WATERLOGGED, worldIn.isWaterAt(pos)).setValue(GrowingCrystalCluster.AGE, RandomUtil.getRandomPositiveIntInRange(4, rand)), 2);
        }
    }

    private List<Direction> getTipDirection(RandomSource rand)
    {
        List<Direction> directions = Arrays.stream(Direction.values()).toList();
        Direction tempDirection0 = directions.get(RandomUtil.getRandomPositiveIntInRange(directions.size(), rand));
        Direction tempDirection1 = directions.get(RandomUtil.getRandomPositiveIntInRange(directions.size(), rand));

        return List.of(tempDirection0, tempDirection0.getOpposite(), tempDirection1, tempDirection1.getOpposite());
    }
}
