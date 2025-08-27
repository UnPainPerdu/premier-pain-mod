package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.outside_dry_toilet;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.AbstractFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.ModFeatureUtils;
import com.unpainperdu.premierpainmod.util.tool_kit.DirectionHelper;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.unpainperdu.premierpainmod.util.tool_kit.PosHelper.*;

public class OutsideDryToiletFeature extends AbstractFeature<OutsideDryToiletConfiguration>
{
    public OutsideDryToiletFeature(Codec<OutsideDryToiletConfiguration> codec)
    {
        super(codec);
    }

    @Override
    public boolean canGenerate(FeaturePlaceContext<OutsideDryToiletConfiguration> context)
    {
        WorldGenLevel worldIn = context.level();
        BlockPos pos = context.origin();
        BlockState stateBelow = worldIn.getBlockState(pos.below());


        return (!isFlying(pos, worldIn))
                && (
                (stateBelow.is(BlockTags.DIRT))
                        || (stateBelow.is(BlockTags.SAND))
                        || (stateBelow.is(BlockTags.BASE_STONE_OVERWORLD))
        );
    }

    @Override
    public void generate(FeaturePlaceContext<OutsideDryToiletConfiguration> context)
    {
        OutsideDryToiletConfiguration config = context.config();
        List<BlockStateProvider> groundStates = config.groundStates();
        List<BlockStateProvider> materialStates = config.materialStates();
        WorldGenLevel worldIn = context.level();
        RandomSource rand = context.random();
        BlockPos pos = context.origin();
        Direction direction = DirectionHelper.getRandomDirection(rand);

        pos = generateGround(worldIn, rand, pos, direction, groundStates);

        generateToilet(worldIn, rand, pos, direction, materialStates);
    }

    /**
     * @return return pos center of the ground and y + 1
     */
    private BlockPos generateGround(WorldGenLevel worldIn, RandomSource rand, BlockPos pos, Direction direction, List<BlockStateProvider> groundStatesProvider)
    {
        BlockPos finalPos = pos.above();
        List<BlockState> groundStates = new ArrayList<>();
        groundStatesProvider.forEach(gsp -> groundStates.add(gsp.getState(rand, pos)));

        List<BlockPos> posList = List.of(
                pos, getFront(pos, direction), getBehind(pos, direction), getLeft(pos, direction), getRight(pos, direction),
                getFront(getLeft(pos, direction), direction), getFront(getRight(pos, direction), direction),
                getBehind(getLeft(pos, direction), direction), getBehind(getRight(pos, direction), direction), // 3x3
                getFront(pos, direction, 2), getFront(getLeft(pos, direction), direction, 2), getFront(getRight(pos, direction), direction, 2) //4x3
        );

        posList.forEach(
                pos1 ->
                {
                    for (int i = 0; i < 2; i++)
                    {
                        ModFeatureUtils.generateBlock(worldIn, pos1.below(i), rand, groundStates, true);
                        if (i != 0)
                        {
                            groundPostGeneration(pos, worldIn, rand, groundStates);
                        }
                    }


                }
        );

        return finalPos;
    }

    private void groundPostGeneration(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, List<BlockState> states)
    {
        List<BlockPos> placementPosList = Arrays.asList(pos.above(), pos.east(), pos.west(), pos.north(), pos.south());
        ArrayList<BlockPos> tempPosList = new ArrayList<>();
        for (BlockPos pos1 : placementPosList)
        {
            BlockState blockState = worldIn.getBlockState(pos1);
            if (blockState.canBeReplaced())
            {
                tempPosList.add(pos1);
            }
        }
        for (BlockPos pos1 : tempPosList)
        {
            if (RandomUtil.getRandomPositiveIntInRange(100, rand) > 60)
            {
                ModFeatureUtils.generateBlock(worldIn, pos1, rand, states, false);
            }
        }
    }

    private void generateToilet(WorldGenLevel worldIn, RandomSource rand, BlockPos pos, Direction direction, List<BlockStateProvider> materialStatesProvider)
    {
        List<BlockState> materialStates = new ArrayList<>();
        materialStatesProvider.forEach(gsp -> materialStates.add(gsp.getState(rand, pos)));

        List<BlockPos> posList = List.of(
                pos, getFront(pos, direction), getBehind(pos, direction), getLeft(pos, direction), getRight(pos, direction),
                getFront(getLeft(pos, direction), direction), getFront(getRight(pos, direction), direction),
                getBehind(getLeft(pos, direction), direction), getBehind(getRight(pos, direction), direction) // 3x3
        );

        ModFeatureUtils.generateBlock(worldIn, posList.getFirst(), rand, materialStates.get(4).setValue(HorizontalDirectionalBlock.FACING, direction), true);
        ModFeatureUtils.generateBlock(worldIn, posList.getFirst().above(2), rand, materialStates.get(1), true);

        for (int i = 0; i < 3; i++)
        {
            if (i != 2)
            {
                ModFeatureUtils.generateBlock(worldIn, posList.get(1).above(i), rand, materialStates.get(3).setValue(HorizontalDirectionalBlock.FACING, direction).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, i == 0 ? DoubleBlockHalf.LOWER : DoubleBlockHalf.UPPER), true);
                ModFeatureUtils.generateBlock(worldIn, posList.get(3).above(i), rand, materialStates.get(1), true);
                ModFeatureUtils.generateBlock(worldIn, posList.get(4).above(i), rand, materialStates.get(1), true);
                ModFeatureUtils.generateBlock(worldIn, posList.get(5).above(i), rand, materialStates.getFirst(), true);
                ModFeatureUtils.generateBlock(worldIn, posList.get(6).above(i), rand, materialStates.getFirst(), true);
                ModFeatureUtils.generateBlock(worldIn, posList.get(7).above(i), rand, materialStates.getFirst(), true);
                ModFeatureUtils.generateBlock(worldIn, posList.get(8).above(i), rand, materialStates.getFirst(), true);

            }
            else
            {
                ModFeatureUtils.generateBlock(worldIn, posList.get(1).above(i), rand, materialStates.get(1), true);
                ModFeatureUtils.generateBlock(worldIn, posList.get(3).above(i), rand, materialStates.get(2), true);
                ModFeatureUtils.generateBlock(worldIn, posList.get(4).above(i), rand, materialStates.get(2), true);
                ModFeatureUtils.generateBlock(worldIn, posList.get(5).above(i), rand, materialStates.get(2), true);
                ModFeatureUtils.generateBlock(worldIn, posList.get(6).above(i), rand, materialStates.get(2), true);
                ModFeatureUtils.generateBlock(worldIn, posList.get(7).above(i), rand, materialStates.get(2), true);
                ModFeatureUtils.generateBlock(worldIn, posList.get(8).above(i), rand, materialStates.get(2), true);
            }
            ModFeatureUtils.generateBlock(worldIn, posList.get(2).above(i), rand, materialStates.get(1), true);
        }
    }
}
