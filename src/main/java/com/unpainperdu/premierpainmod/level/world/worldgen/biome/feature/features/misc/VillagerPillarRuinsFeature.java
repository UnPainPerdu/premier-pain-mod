package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.misc;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.ModFeatureUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ColoredFallingBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class VillagerPillarRuinsFeature extends Feature<NoneFeatureConfiguration>
{

    public VillagerPillarRuinsFeature(Codec<NoneFeatureConfiguration> pCodec)
    {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext)
    {
        RandomSource rand = pContext.random();
        WorldGenLevel worldIn = pContext.level();
        ChunkGenerator chunkGenerator = pContext.chunkGenerator();
        BlockPos pos = pContext.origin();
        NoneFeatureConfiguration config = pContext.config();
        Direction direction = ModFeatureUtils.getDirection(rand);

        Block block = worldIn.getBlockState(pos.below()).getBlock();

        int chanceSpawn = ModFeatureUtils.getRandomPositiveIntInRange(10, rand);
        if (chanceSpawn<7 || !(block instanceof ColoredFallingBlock))
        {
            return false;
        }

        basicPillarGeneration(worldIn, chunkGenerator, rand, pos, config, direction);

        return true;
    }

    private void basicPillarGeneration(WorldGenLevel worldIn, ChunkGenerator chunkGenerator, RandomSource rand, BlockPos pos, NoneFeatureConfiguration config, Direction direction)
    {
        pos = ModFeatureUtils.getRandomHeight(pos, rand, 1, 2);

        generateFoot(worldIn, rand, pos, direction);

        pos = pos.above(2);
        pos = generate2x2LevelWithBlock(worldIn, rand,pos,direction, Blocks.CUT_SANDSTONE);
        pos = generate2x2LevelWithBlock(worldIn, rand,pos,direction, Blocks.CUT_SANDSTONE);
        pos = generate2x2LevelWithBlock(worldIn, rand,pos,direction, Blocks.CUT_SANDSTONE);
        pos = generate2x2LevelWithBlock(worldIn, rand,pos,direction, Blocks.CUT_SANDSTONE);
        pos = generate2x2LevelWithBlock(worldIn, rand,pos,direction, Blocks.CUT_SANDSTONE);
    }

    private void generateFoot(WorldGenLevel worldIn, RandomSource rand, BlockPos pos, Direction direction)
    {
        /*
        start at x
        tempPos y
           y--y
           ----
           -x--
           y--y
        */
        //1rst layer
        BlockPos tempPosBehindLeft = ModFeatureUtils.getLeft(ModFeatureUtils.getBehind(pos,direction, 2), direction);
        BlockPos tempPosBehindRight = ModFeatureUtils.getRight(ModFeatureUtils.getBehind(pos,direction, 2), direction, 2);
        BlockPos tempPosFrontLeft = ModFeatureUtils.getLeft(ModFeatureUtils.getFront(pos,direction), direction);
        BlockPos tempPosFrontRight = ModFeatureUtils.getRight(ModFeatureUtils.getFront(pos,direction), direction, 2);

        //base 2x2
        worldIn.setBlock(pos, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getRight(pos, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getBehind(pos, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getBehind(ModFeatureUtils.getRight(pos, direction), direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);

        // behind from tempPosBehindLeft
        worldIn.setBlock(tempPosBehindLeft, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getRight(tempPosBehindLeft, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getRight(tempPosBehindLeft, direction, 2), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        // left from tempPosFrontLeft
        worldIn.setBlock(tempPosFrontLeft, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getBehind(tempPosFrontLeft, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getBehind(tempPosFrontLeft, direction, 2), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        // front from tempPosFrontRight
        worldIn.setBlock(tempPosFrontRight, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getLeft(tempPosFrontRight, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getLeft(tempPosFrontRight, direction, 2), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        // right from tempPosBehindRight
        worldIn.setBlock(tempPosBehindRight, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getFront(tempPosBehindRight, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getFront(tempPosBehindRight, direction, 2), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);

        //2nd layer
        pos = pos.above();

        tempPosBehindLeft = ModFeatureUtils.getLeft(ModFeatureUtils.getBehind(pos,direction, 2), direction);
        tempPosBehindRight = ModFeatureUtils.getRight(ModFeatureUtils.getBehind(pos,direction, 2), direction, 2);
        tempPosFrontLeft = ModFeatureUtils.getLeft(ModFeatureUtils.getFront(pos,direction), direction);
        tempPosFrontRight = ModFeatureUtils.getRight(ModFeatureUtils.getFront(pos,direction), direction, 2);

        //base 2x2
        worldIn.setBlock(pos, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getRight(pos, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getBehind(pos, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getBehind(ModFeatureUtils.getRight(pos, direction), direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);

        // behind from tempPosBehindLeft
        worldIn.setBlock(tempPosBehindLeft, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getRight(tempPosBehindLeft, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getRight(tempPosBehindLeft, direction, 2), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        // left from tempPosFrontLeft
        worldIn.setBlock(tempPosFrontLeft, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getBehind(tempPosFrontLeft, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getBehind(tempPosFrontLeft, direction, 2), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        // front from tempPosFrontRight
        worldIn.setBlock(tempPosFrontRight, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getLeft(tempPosFrontRight, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getLeft(tempPosFrontRight, direction, 2), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        // right from tempPosBehindRight
        worldIn.setBlock(tempPosBehindRight, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getFront(tempPosBehindRight, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getFront(tempPosBehindRight, direction, 2), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);

        //3nd layer
        pos = pos.above();

        //base 2x2
        worldIn.setBlock(pos, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getRight(pos, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getBehind(pos, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getBehind(ModFeatureUtils.getRight(pos, direction), direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);

        tempPosBehindLeft = ModFeatureUtils.getLeft(ModFeatureUtils.getBehind(pos,direction, 2), direction);
        tempPosBehindRight = ModFeatureUtils.getRight(ModFeatureUtils.getBehind(pos,direction, 2), direction, 2);
        tempPosFrontLeft = ModFeatureUtils.getLeft(ModFeatureUtils.getFront(pos,direction), direction);
        tempPosFrontRight = ModFeatureUtils.getRight(ModFeatureUtils.getFront(pos,direction), direction, 2);

        // behind from tempPosBehindLeft
        worldIn.setBlock(tempPosBehindLeft, Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, ModFeatureUtils.getNextDirection_NESW(direction,2)).setValue(StairBlock.SHAPE, StairsShape.OUTER_LEFT), 1 & 2);
        worldIn.setBlock(ModFeatureUtils.getRight(tempPosBehindLeft, direction), Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, ModFeatureUtils.getNextDirection_NESW(direction,2)), 1 & 2);
        worldIn.setBlock(ModFeatureUtils.getRight(tempPosBehindLeft, direction, 2), Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, ModFeatureUtils.getNextDirection_NESW(direction,2)), 1 & 2);
        // left from tempPosFrontLeft
        worldIn.setBlock(tempPosFrontLeft, Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, ModFeatureUtils.getNextDirection_NESW(direction)).setValue(StairBlock.SHAPE, StairsShape.OUTER_LEFT), 1 & 2);
        worldIn.setBlock(ModFeatureUtils.getBehind(tempPosFrontLeft, direction), Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, ModFeatureUtils.getNextDirection_NESW(direction)), 1 & 2);
        worldIn.setBlock(ModFeatureUtils.getBehind(tempPosFrontLeft, direction, 2), Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, ModFeatureUtils.getNextDirection_NESW(direction)), 1 & 2);
        // front from tempPosFrontRight
        worldIn.setBlock(tempPosFrontRight, Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, direction).setValue(StairBlock.SHAPE, StairsShape.OUTER_LEFT), 1 & 2);
        worldIn.setBlock(ModFeatureUtils.getLeft(tempPosFrontRight, direction), Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING,direction), 1 & 2);
        worldIn.setBlock(ModFeatureUtils.getLeft(tempPosFrontRight, direction, 2), Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, direction), 1 & 2);
        // right from tempPosBehindRight
        worldIn.setBlock(tempPosBehindRight, Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, ModFeatureUtils.getNextDirection_NESW(direction,3)).setValue(StairBlock.SHAPE, StairsShape.OUTER_LEFT), 1 & 2);
        worldIn.setBlock(ModFeatureUtils.getFront(tempPosBehindRight, direction), Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, ModFeatureUtils.getNextDirection_NESW(direction,3)), 1 & 2);
        worldIn.setBlock(ModFeatureUtils.getFront(tempPosBehindRight, direction, 2), Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, ModFeatureUtils.getNextDirection_NESW(direction,3)), 1 & 2);

    }

    private BlockPos generate2x2LevelWithBlock(WorldGenLevel worldIn, RandomSource rand, BlockPos pos, Direction direction, Block block)
    {
        /*
        start at x
        --
        x-
        */
        worldIn.setBlock(pos, block.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getRight(pos, direction), block.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getBehind(pos, direction), block.defaultBlockState(), 2);
        worldIn.setBlock(ModFeatureUtils.getBehind(ModFeatureUtils.getRight(pos, direction), direction), block.defaultBlockState(), 2);

        return pos.above();
    }
}
