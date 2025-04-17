package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.misc;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.util.tool_kit.DirectionHelper;
import com.unpainperdu.premierpainmod.util.tool_kit.PosHelper;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
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
        Direction direction = DirectionHelper.getRandomDirection(rand);

        Block block = worldIn.getBlockState(pos.below()).getBlock();

        int chanceSpawn = RandomUtil.getRandomPositiveIntInRange(101, rand);
        if (chanceSpawn<75 || !(block instanceof ColoredFallingBlock))
        {
            return false;
        }
        int randomSwitch = RandomUtil.getRandomPositiveIntInRange(2, rand);
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
        pos = getRandomHeight(pos, rand, 1, 2);

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
        BlockPos footPos = getRandomHeight(pos, rand, 1, 2);

        generateFoot(worldIn, rand, footPos, direction);
        footPos = footPos.above(3);
        footPos = generate2x2LevelWithBlock(worldIn, rand,footPos,direction, Blocks.CUT_SANDSTONE);
        this.howMuchChance = 50;
        footPos = generate2x2LevelWithBlock(worldIn, rand,footPos,direction, Blocks.CUT_SANDSTONE);

        this.howMuchChance = 25;
        BlockPos pos1 = PosHelper.getFront(pos.above(5), direction, 3);
        pos1 = PosHelper.getRight(pos1, direction);
        BlockPos pos2 = PosHelper.getFront(pos1, direction);
        BlockPos pos3 = PosHelper.getFront(pos2, direction);
        BlockPos pos4 = PosHelper.getFront(pos3, direction);
        BlockPos pos5 = PosHelper.getFront(pos4, direction);
        BlockPos pos6 = PosHelper.getFront(pos5, direction);
        BlockPos pos7 = PosHelper.getFront(pos6, direction);
        BlockPos pos8 = PosHelper.getFront(pos7, direction);

        this.countInFlag = -550000;
        ArrayList<BlockPos> posListBelow = new ArrayList<>(
                Arrays.asList(
                pos1, PosHelper.getLeft(pos1, direction),
                pos2, PosHelper.getLeft(pos2, direction),
                pos3, PosHelper.getLeft(pos3, direction),
                pos4, PosHelper.getLeft(pos4, direction),
                pos5, PosHelper.getLeft(pos5, direction),
                pos6, PosHelper.getLeft(pos6, direction),
                pos7, PosHelper.getLeft(pos7, direction),
                pos8, PosHelper.getLeft(pos8, direction)
                ));

        int i = 0;
        posListBelow = PosHelper.setAllPosToTheGround(posListBelow, worldIn);
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

        ArrayList<BlockPos> posListAbove = PosHelper.setPosAboveForAll(posListBelow, 1);
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
        BlockPos tempPosBehindLeft = PosHelper.getLeft(PosHelper.getBehind(pos,direction, 2), direction);
        BlockPos tempPosBehindRight = PosHelper.getRight(PosHelper.getBehind(pos,direction, 2), direction, 2);
        BlockPos tempPosFrontLeft = PosHelper.getLeft(PosHelper.getFront(pos,direction), direction);
        BlockPos tempPosFrontRight = PosHelper.getRight(PosHelper.getFront(pos,direction), direction, 2);

        //base 2x2
        worldIn.setBlock(pos, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getRight(pos, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getBehind(pos, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getBehind(PosHelper.getRight(pos, direction), direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);

        // behind from tempPosBehindLeft
        worldIn.setBlock(tempPosBehindLeft, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getRight(tempPosBehindLeft, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getRight(tempPosBehindLeft, direction, 2), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        // left from tempPosFrontLeft
        worldIn.setBlock(tempPosFrontLeft, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getBehind(tempPosFrontLeft, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getBehind(tempPosFrontLeft, direction, 2), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        // front from tempPosFrontRight
        worldIn.setBlock(tempPosFrontRight, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getLeft(tempPosFrontRight, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getLeft(tempPosFrontRight, direction, 2), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        // right from tempPosBehindRight
        worldIn.setBlock(tempPosBehindRight, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getFront(tempPosBehindRight, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getFront(tempPosBehindRight, direction, 2), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);

        //2nd layer
        pos = pos.above();

        tempPosBehindLeft = PosHelper.getLeft(PosHelper.getBehind(pos,direction, 2), direction);
        tempPosBehindRight = PosHelper.getRight(PosHelper.getBehind(pos,direction, 2), direction, 2);
        tempPosFrontLeft = PosHelper.getLeft(PosHelper.getFront(pos,direction), direction);
        tempPosFrontRight = PosHelper.getRight(PosHelper.getFront(pos,direction), direction, 2);

        //base 2x2
        worldIn.setBlock(pos, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getRight(pos, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getBehind(pos, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getBehind(PosHelper.getRight(pos, direction), direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);

        // behind from tempPosBehindLeft
        worldIn.setBlock(tempPosBehindLeft, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getRight(tempPosBehindLeft, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getRight(tempPosBehindLeft, direction, 2), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        // left from tempPosFrontLeft
        worldIn.setBlock(tempPosFrontLeft, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getBehind(tempPosFrontLeft, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getBehind(tempPosFrontLeft, direction, 2), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        // front from tempPosFrontRight
        worldIn.setBlock(tempPosFrontRight, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getLeft(tempPosFrontRight, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getLeft(tempPosFrontRight, direction, 2), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        // right from tempPosBehindRight
        worldIn.setBlock(tempPosBehindRight, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getFront(tempPosBehindRight, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getFront(tempPosBehindRight, direction, 2), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);

        //3nd layer
        pos = pos.above();

        //base 2x2
        worldIn.setBlock(pos, Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getRight(pos, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getBehind(pos, direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);
        worldIn.setBlock(PosHelper.getBehind(PosHelper.getRight(pos, direction), direction), Blocks.CUT_SANDSTONE.defaultBlockState(), 2);

        tempPosBehindLeft = PosHelper.getLeft(PosHelper.getBehind(pos,direction, 2), direction);
        tempPosBehindRight = PosHelper.getRight(PosHelper.getBehind(pos,direction, 2), direction, 2);
        tempPosFrontLeft = PosHelper.getLeft(PosHelper.getFront(pos,direction), direction);
        tempPosFrontRight = PosHelper.getRight(PosHelper.getFront(pos,direction), direction, 2);

        // behind from tempPosBehindLeft
        worldIn.setBlock(tempPosBehindLeft, Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, DirectionHelper.getNextDirection_NESW(direction,2)).setValue(StairBlock.SHAPE, StairsShape.OUTER_LEFT), 1 & 2);
        worldIn.setBlock(PosHelper.getRight(tempPosBehindLeft, direction), Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, DirectionHelper.getNextDirection_NESW(direction,2)), 1 & 2);
        worldIn.setBlock(PosHelper.getRight(tempPosBehindLeft, direction, 2), Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, DirectionHelper.getNextDirection_NESW(direction,2)), 1 & 2);
        // left from tempPosFrontLeft
        worldIn.setBlock(tempPosFrontLeft, Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, DirectionHelper.getNextDirection_NESW(direction)).setValue(StairBlock.SHAPE, StairsShape.OUTER_LEFT), 1 & 2);
        worldIn.setBlock(PosHelper.getBehind(tempPosFrontLeft, direction), Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, DirectionHelper.getNextDirection_NESW(direction)), 1 & 2);
        worldIn.setBlock(PosHelper.getBehind(tempPosFrontLeft, direction, 2), Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, DirectionHelper.getNextDirection_NESW(direction)), 1 & 2);
        // front from tempPosFrontRight
        worldIn.setBlock(tempPosFrontRight, Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, direction).setValue(StairBlock.SHAPE, StairsShape.OUTER_LEFT), 1 & 2);
        worldIn.setBlock(PosHelper.getLeft(tempPosFrontRight, direction), Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING,direction), 1 & 2);
        worldIn.setBlock(PosHelper.getLeft(tempPosFrontRight, direction, 2), Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, direction), 1 & 2);
        // right from tempPosBehindRight
        worldIn.setBlock(tempPosBehindRight, Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, DirectionHelper.getNextDirection_NESW(direction,3)).setValue(StairBlock.SHAPE, StairsShape.OUTER_LEFT), 1 & 2);
        worldIn.setBlock(PosHelper.getFront(tempPosBehindRight, direction), Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, DirectionHelper.getNextDirection_NESW(direction,3)), 1 & 2);
        worldIn.setBlock(PosHelper.getFront(tempPosBehindRight, direction, 2), Blocks.SANDSTONE_STAIRS.defaultBlockState().setValue(StairBlock.FACING, DirectionHelper.getNextDirection_NESW(direction,3)), 1 & 2);

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
        generateBlock(worldIn, rand, PosHelper.getRight(pos, direction) , state);
        generateBlock(worldIn, rand, PosHelper.getBehind(pos, direction) , state);
        generateBlock(worldIn, rand, PosHelper.getBehind(PosHelper.getRight(pos, direction), direction) , state);

        return pos.above();
    }

    private void generateBlock(WorldGenLevel worldIn, RandomSource rand, BlockPos pos, BlockState state)
    {
        boolean inFlag = false;
        int randomSpawn = RandomUtil.getRandomPositiveIntInRange(this.maxChance + 1,rand);
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

    public static BlockPos getRandomHeight(BlockPos pos, RandomSource rand,int minDepth, int maxDepth)
    {
        int randomInt = RandomUtil.getRandomPositiveIntInRange(maxDepth - minDepth + 1, rand);

        return pos.below(randomInt + minDepth);
    }
}
