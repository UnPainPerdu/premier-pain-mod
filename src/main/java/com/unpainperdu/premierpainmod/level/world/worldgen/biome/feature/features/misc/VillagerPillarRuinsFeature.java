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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VillagerPillarRuinsFeature extends Feature<NoneFeatureConfiguration>
{
    private int maxChance = 100;     // howMuchChance % of maxChance
    private int howMuchChance = 10;   //
    private int countInFlag = 0;
    private boolean flag = false;

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

        int chanceSpawn = ModFeatureUtils.getRandomPositiveIntInRange(101, rand);
        if (chanceSpawn<75 || !(block instanceof ColoredFallingBlock))
        {
            return false;
        }
        int randomSwitch = ModFeatureUtils.getRandomPositiveIntInRange(2, rand);
        if (randomSwitch ==0)
        {
            basicPillarGeneration(worldIn, chunkGenerator, rand, pos, config, direction);
        }
        else
        {
            groundPillarGeneration(worldIn, chunkGenerator, rand, pos, config, direction);
        }

        this.maxChance = 100;
        this.howMuchChance = 10;
        this.flag = false;
        this.countInFlag = 0;

        return true;
    }

    private void basicPillarGeneration(WorldGenLevel worldIn, ChunkGenerator chunkGenerator, RandomSource rand, BlockPos pos, NoneFeatureConfiguration config, Direction direction)
    {
        pos = ModFeatureUtils.getRandomHeight(pos, rand, 1, 2);

        generateFoot(worldIn, rand, pos, direction);
        pos = pos.above(3);

        pos = generate2x2LevelWithBlock(worldIn, rand,pos,direction, Blocks.CUT_SANDSTONE);
        this.howMuchChance = 15;
        pos = generate2x2LevelWithBlock(worldIn, rand,pos,direction, Blocks.CUT_SANDSTONE);
        pos = generate2x2LevelWithBlock(worldIn, rand,pos,direction, Blocks.CHISELED_SANDSTONE);
        this.howMuchChance = 25;
        pos = generate2x2LevelWithBlock(worldIn, rand,pos,direction, Blocks.CUT_SANDSTONE);
        pos = generate2x2LevelWithBlock(worldIn, rand,pos,direction, Blocks.CUT_SANDSTONE);
        pos = generate2x2LevelWithBlock(worldIn, rand,pos,direction, Blocks.CUT_SANDSTONE);
        this.howMuchChance = 30;
        pos = generate2x2LevelWithBlock(worldIn, rand,pos,direction, Blocks.CUT_SANDSTONE);
        this.howMuchChance = 50;
        pos = generate2x2LevelWithBlock(worldIn, rand,pos,direction, Blocks.CHISELED_SANDSTONE);
        pos = generate2x2LevelWithBlock(worldIn, rand,pos,direction, Blocks.CUT_SANDSTONE);
        pos = generate2x2LevelWithBlock(worldIn, rand,pos,direction, Blocks.CUT_SANDSTONE);
    }

    private void groundPillarGeneration(WorldGenLevel worldIn, ChunkGenerator chunkGenerator, RandomSource rand, BlockPos pos, NoneFeatureConfiguration config, Direction direction)
    {
        BlockPos footPos = ModFeatureUtils.getRandomHeight(pos, rand, 1, 2);

        generateFoot(worldIn, rand, footPos, direction);
        footPos = footPos.above(3);
        footPos = generate2x2LevelWithBlock(worldIn, rand,footPos,direction, Blocks.CUT_SANDSTONE);
        this.howMuchChance = 50;
        footPos = generate2x2LevelWithBlock(worldIn, rand,footPos,direction, Blocks.CUT_SANDSTONE);

        this.howMuchChance = 25;
        BlockPos pos1 = ModFeatureUtils.getFront(pos.above(5), direction, 3);
        pos1 = ModFeatureUtils.getRight(pos1, direction);
        BlockPos pos2 = ModFeatureUtils.getFront(pos1, direction);
        BlockPos pos3 = ModFeatureUtils.getFront(pos2, direction);
        BlockPos pos4 = ModFeatureUtils.getFront(pos3, direction);
        BlockPos pos5 = ModFeatureUtils.getFront(pos4, direction);
        BlockPos pos6 = ModFeatureUtils.getFront(pos5, direction);
        BlockPos pos7 = ModFeatureUtils.getFront(pos6, direction);
        BlockPos pos8 = ModFeatureUtils.getFront(pos7, direction);

        this.countInFlag = -550000;
        ArrayList<BlockPos> posListBelow = new ArrayList<>(
                Arrays.asList(
                pos1, ModFeatureUtils.getLeft(pos1, direction),
                pos2, ModFeatureUtils.getLeft(pos2, direction),
                pos3, ModFeatureUtils.getLeft(pos3, direction),
                pos4, ModFeatureUtils.getLeft(pos4, direction),
                pos5, ModFeatureUtils.getLeft(pos5, direction),
                pos6, ModFeatureUtils.getLeft(pos6, direction),
                pos7, ModFeatureUtils.getLeft(pos7, direction),
                pos8, ModFeatureUtils.getLeft(pos8, direction)
                ));

        int i = 0;
        posListBelow = ModFeatureUtils.setAllPosToTheGround(posListBelow, worldIn);
        for (BlockPos posFor : posListBelow)
        {
            if (i <= 1 || (i >=10 && i <= 11))
            {
                generateBlock(worldIn, rand, posFor, Blocks.CHISELED_SANDSTONE.defaultBlockState());
            }
            else
            {
                generateBlock(worldIn, rand, posFor, Blocks.CUT_SANDSTONE.defaultBlockState());
            }
            i ++;
        }

        int j = 0;

        ArrayList<BlockPos> posListAbove = ModFeatureUtils.upTo(posListBelow, 1);
        for (BlockPos posFor : posListAbove)
        {
            if (j <= 1 || (j >=10 && j <= 11))
            {
                generateBlock(worldIn, rand, posFor, Blocks.CHISELED_SANDSTONE.defaultBlockState());
            }
            else
            {
                generateBlock(worldIn, rand, posFor, Blocks.CUT_SANDSTONE.defaultBlockState());
            }
            j ++;
        }
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
        BlockState state = block.defaultBlockState();
        generateBlock(worldIn, rand, pos , state);
        generateBlock(worldIn, rand, ModFeatureUtils.getRight(pos, direction) , state);
        generateBlock(worldIn, rand, ModFeatureUtils.getBehind(pos, direction) , state);
        generateBlock(worldIn, rand, ModFeatureUtils.getBehind(ModFeatureUtils.getRight(pos, direction), direction) , state);

        return pos.above();
    }

    private void generateBlock(WorldGenLevel worldIn, RandomSource rand, BlockPos pos, BlockState state)
    {
        boolean inFlag = false;
        int randomSpawn = ModFeatureUtils.getRandomPositiveIntInRange(this.maxChance + 1,rand);
        if(randomSpawn < this.howMuchChance)
        {
            inFlag = true;
            this.countInFlag +=1;
            if(this.countInFlag > 4)
            {
                this.flag = true;
            }
        }
        if(!this.flag && !inFlag)
        {
            worldIn.setBlock(pos, state, 2);
        }
    }
}
