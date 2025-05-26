package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.bush_and_rock_feature;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.AbstractFeature;
import com.unpainperdu.premierpainmod.util.tool_kit.PosHelper;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BushAndRockFeature extends AbstractFeature<BushAndRockConfiguration>
{
    public BushAndRockFeature(Codec codec)
    {
        super(codec);
    }

    @Override
    public boolean canGenerate(FeaturePlaceContext<BushAndRockConfiguration> context)
    {
        WorldGenLevel worldIn = context.level();
        BlockPos pos = context.origin();
        BlockState state = worldIn.getBlockState(pos.below());
        return state.is(BlockTags.SAND) || state.is(BlockTags.DIRT);
    }

    @Override
    public void generate(FeaturePlaceContext<BushAndRockConfiguration> context)
    {
        BushAndRockConfiguration config = context.config();
        int maxExcludedNumberOfBlock = config.maxExcludedNumberOfBlock();
        List<BlockStateProvider> statesForRock = config.statesForRock();
        int percentageOfCoverageBy2ndLayer = config.percentageOfCoverageBy2ndLayer();
        List<BlockStateProvider> statesFor2ndLayer = config.statesFor2ndLayer();
        boolean is2ndLayerGenerating = statesFor2ndLayer.isEmpty();

        WorldGenLevel worldIn = context.level();
        RandomSource rand = context.random();
        BlockPos pos = context.origin();

        int nbrBock = RandomUtil.getRandomPositiveIntInRange(maxExcludedNumberOfBlock, rand);
        ArrayList<BlockPos> posList = new ArrayList<>();
        for (int i = 0; i <= nbrBock; i++)
        {
            posList.add(pos);
            BlockPos posTemp = getRandomPosNextToPos(pos, rand);
            if (!PosHelper.isPosInList(posTemp, posList))
            {
                pos = posTemp;
            }
        }
        int i = 0;
        for (BlockPos pos1 : posList)
        {
            int forFlag1 = 6;
            BlockPos belowPos = pos1;
            for (int j = 0; j < forFlag1; j++)
            {
                belowPos = belowPos.below();
                Block blockBelow = worldIn.getBlockState(belowPos).getBlock();
                if (blockBelow instanceof AirBlock)
                {
                    if (!PosHelper.isPosInList(belowPos, posList))
                    {
                        posList.set(i, belowPos);
                    }
                }
                else
                {
                    j = 6;
                }
            }
            i++;
        }
        for (BlockPos pos1 : posList)
        {
            RockGenerator(pos1, worldIn, rand, statesForRock);
        }
        for (BlockPos pos1 : posList)
        {
            postGeneration(pos1, worldIn, rand, percentageOfCoverageBy2ndLayer, is2ndLayerGenerating, statesForRock, statesFor2ndLayer);
        }
    }

    private void RockGenerator(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, List<BlockStateProvider> statesForRock)
    {
        int randomInt = RandomUtil.getRandomPositiveIntInRange(statesForRock.size(), rand);
        BlockState state;
        try
        {
            state = statesForRock.get(randomInt).getState(rand, pos);
        } catch (Exception ignored)
        {
            try
            {
                state = statesForRock.getFirst().getState(rand, pos);
            } catch (Exception ignored2)
            {
                throw new RuntimeException("statesForRock list must contain at least 1 state");
            }
        }
        worldIn.setBlock(pos, state, 2);
    }

    private void secondLayerGenerator(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, List<BlockStateProvider> statesFor2ndLayer)
    {
        int randomInt = RandomUtil.getRandomPositiveIntInRange(statesFor2ndLayer.size(), rand);
        BlockState state;
        try
        {
            state = statesFor2ndLayer.get(randomInt).getState(rand, pos);
        } catch (Exception ignored)
        {
            try
            {
                state = statesFor2ndLayer.getFirst().getState(rand, pos);
            } catch (Exception ignored2)
            {
                throw new RuntimeException("statesForRock list must contain at least 1 states");
            }
        }
        worldIn.setBlock(pos, state, 2);
    }

    private BlockPos getRandomPosNextToPos(BlockPos pos, RandomSource rand)
    {
        int random = RandomUtil.getRandomPositiveIntInRange(5, rand);
        switch (random)
        {
            case 0:
            {
                pos = pos.east();
                break;
            }
            case 1:
            {
                pos = pos.west();
                break;
            }
            case 2:
            {
                pos = pos.south();
                break;
            }
            case 3:
            {
                pos = pos.north();
                break;
            }
            default:
            {
                pos = pos.above();
                break;
            }
        }
        return pos;
    }

    private void postGeneration(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, int percentageOfCoverageBy2ndLayer, boolean is2ndLayerGenerating, List<BlockStateProvider> statesForRock, List<BlockStateProvider> statesFor2ndLayer)
    {
        List<BlockPos> placementPosList = Arrays.asList(pos.above(), pos.east(), pos.west(), pos.north(), pos.south());
        ArrayList<BlockPos> tempPosList = new ArrayList<>();
        for (BlockPos pos1 : placementPosList)
        {
            Block block = worldIn.getBlockState(pos1).getBlock();
            if (block instanceof AirBlock)
            {
                tempPosList.add(pos1);
            }
        }
        for (BlockPos pos1 : tempPosList)
        {
            int randomInt = RandomUtil.getRandomPositiveIntInRange(100, rand) + 1; //[1,100]
            int randomInt2 = RandomUtil.getRandomPositiveIntInRange(randomInt, rand) + 1;
            if (randomInt < percentageOfCoverageBy2ndLayer)
            {
                secondLayerGenerator(pos1, worldIn, rand, statesFor2ndLayer);
            }
            else if (randomInt2 < percentageOfCoverageBy2ndLayer/2 && is2ndLayerGenerating)
            {
                RockGenerator(pos1, worldIn, rand, statesFor2ndLayer);
            }
        }
    }
}
