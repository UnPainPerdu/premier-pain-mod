package com.unpainperdu.premierpainmod.level.world.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VillagerStatueRuinsFeature extends Feature<NoneFeatureConfiguration>
{
    private int numberA = 10000;
    private int countInFlag = 0;
    private boolean flag = false;
/*
        b = block
        p = start pos

        -> bbb
           bpb
            ^
         nouse side
*/
    public VillagerStatueRuinsFeature(Codec<NoneFeatureConfiguration> pCodec)
    {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext)
    {
        WorldGenLevel worldIn = pContext.level();
        ChunkGenerator chunkGenerator = pContext.chunkGenerator();
        RandomSource rand = pContext.random();
        BlockPos pos = pContext.origin();
        NoneFeatureConfiguration config = pContext.config();
        Direction direction = getDirection(rand);
        int i = 0;
        basicStatueGeneration(worldIn,chunkGenerator,rand,pos,config, direction);
        this.numberA = 10000;
        this.flag = false;
        return true;
    }

    private void basicStatueGeneration(WorldGenLevel worldIn, ChunkGenerator chunkGenerator, RandomSource rand, BlockPos pos, NoneFeatureConfiguration config,Direction direction)
    {
        Block block = worldIn.getBlockState(pos.below()).getBlock();
        if(block instanceof GrassBlock)
        {
            pos = getRandomHeight(pos, rand);
            //base (all time buried)
            pos = generateBasicShape(pos, worldIn, rand, direction);

            pos = generateBasicShape(pos, worldIn, rand, direction);

            pos = generateBasicShape(pos, worldIn, rand, direction);
            //start of the statue
            pos = generateBasicShape(pos, worldIn, rand, direction);

            this.numberA = 18;
            pos = generateBasicShape(pos, worldIn, rand, direction);

            generateArm(pos, worldIn, rand, direction);
            pos = generateBasicShape(pos, worldIn, rand, direction);

            pos = generateBasicShape(pos, worldIn, rand, direction);

            pos = generateNeck(pos, worldIn, rand, direction);

            generateNoise(pos,worldIn,rand,direction);
            pos = generateBasicShape(pos, worldIn, rand, direction);

            pos = generateEyes(pos, worldIn, rand, direction);
            generateEyebrow(pos, worldIn, rand, direction);

            pos = generateBasicShape(pos, worldIn, rand, direction);
            pos = generateBasicShape(pos, worldIn, rand, direction);
        }
    }

    /**
     * Generate a 3x2 stone bricks panel and return the pos for the next level
     */
    private BlockPos generateBasicShape(BlockPos pos, WorldGenLevel worldIn, RandomSource rand,Direction direction)
    {
        generateStoneBricks(pos,worldIn,rand, direction);

        pos = getLeft(pos, direction);
        generateStoneBricks(pos,worldIn,rand, direction);

        pos = getBehind(pos, direction);
        generateStoneBricks(pos,worldIn,rand, direction);

        pos = getRight(pos, direction);
        generateStoneBricks(pos,worldIn,rand, direction);

        pos = getRight(pos, direction);
        generateStoneBricks(pos,worldIn,rand, direction);

        pos = getFront(pos, direction);
        generateStoneBricks(pos,worldIn,rand, direction);

        return getLeft(pos, direction).above();
    }

    private void generateArm(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        pos = getFront(pos, direction);
        generateStoneBricks(pos,worldIn,rand, direction);

        BlockPos rightPos = getRight(pos,direction);
        generateStoneBricks(rightPos,worldIn,rand,direction);

        rightPos = getRight(rightPos,direction);
        generateStoneBricksStair(rightPos,worldIn,rand,direction);

        rightPos = getBehind(rightPos,direction);
        generateStoneBricks(rightPos,worldIn,rand,direction);

        rightPos = rightPos.above();
        generateStoneBricksStair(rightPos,worldIn,rand,direction);

        rightPos = getBehind(rightPos,direction);
        generateStoneBricks(rightPos,worldIn,rand,direction);

        pos = getLeft(pos,direction);
        generateStoneBricks(pos,worldIn,rand, direction);

        pos = getLeft(pos,direction);
        generateStoneBricksStair(pos,worldIn,rand,direction);

        pos = getBehind(pos,direction);
        generateStoneBricks(pos,worldIn,rand, direction);

        pos = pos.above();
        generateStoneBricksStair(pos,worldIn,rand,direction);

        pos = getBehind(pos,direction);
        generateStoneBricks(pos,worldIn,rand, direction);
    }

    private BlockPos generateNeck(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        generateStoneBricksSlab(pos, worldIn, rand, true);

        //1st layer
        pos = getRight(pos, direction);
        generateStoneBricksSlab(pos, worldIn, rand, true);

        pos = getBehind(pos, direction);
        generateStoneBricks(pos,worldIn,rand, direction);

        pos = getLeft(pos, direction);
        generateStoneBricks(pos,worldIn,rand, direction);

        pos = getLeft(pos, direction);
        generateStoneBricks(pos,worldIn,rand, direction);

        pos = getFront(pos, direction);
        generateStoneBricksSlab(pos, worldIn, rand, true);

        //2nd layer
        pos = getRight(pos, direction).above();
        generateStoneBricksSlab(pos, worldIn, rand, true);
        generateMouth(pos,worldIn,rand,direction);

        pos = getBehind(pos,direction);
        generateStoneBricks(pos,worldIn,rand, direction);
        generateStoneBricks(getLeft(pos,direction),worldIn,rand, direction);
        generateStoneBricks(getRight(pos,direction),worldIn,rand, direction);

        pos = getFront(pos, direction).above();

        return pos;
    }

    private void generateNoise(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        pos = getFront(pos, direction);
        generateStoneBricks(pos,worldIn,rand, direction);

        pos = pos.below();
        generateStoneBricks(pos,worldIn,rand, direction);

        pos = pos.below();
        generateStoneBricks(pos,worldIn,rand, direction);
    }
    private BlockPos generateEyes(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        generateStoneBricks(pos,worldIn,rand, direction);

        generateStoneBricksSlab(getLeft(pos, direction), worldIn, rand, true);
        pos = getRight(pos,direction);
        generateStoneBricksSlab(pos, worldIn, rand, true);

        pos = getBehind(pos, direction);
        generateStoneBricks(pos,worldIn,rand, direction);

        pos = getLeft(pos, direction);
        generateStoneBricks(pos,worldIn,rand, direction);

        pos = getLeft(pos, direction);
        generateStoneBricks(pos,worldIn,rand, direction);

        return getFront(getRight(pos, direction), direction).above();
    }

    private void generateEyebrow(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        pos = getFront(pos, direction);
        BlockPos posBelow = pos.below();
        generateStoneBricksSlab(pos,worldIn,rand,false);

        generateStoneBricksSlab(getRight(pos,direction),worldIn,rand, false);
        pos = getLeft(pos, direction);
        generateStoneBricksSlab(pos,worldIn,rand, false);

        generateStoneBricksSlab(posBelow,worldIn,rand,true);

        generateStoneBricksSlab(getRight(posBelow,direction),worldIn,rand, true);
        posBelow = getLeft(posBelow, direction);
        generateStoneBricksSlab(posBelow,worldIn,rand, true);
    }

    private void generateStoneBricks(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        boolean inFlag = false;
        int randomSpawn = getRandomPositiveIntInRange(numberA,rand);
        if(randomSpawn == 1)
        {
            inFlag = true;
            this.countInFlag +=1;
            if(this.countInFlag > 6)
            {
                this.flag = true;
            }
        }
        if(!this.flag && !inFlag)
        {
            int random = getRandomPositiveIntInRange(10, rand);
            if (random < 2)
            {
                worldIn.setBlock(pos, Blocks.STONE_BRICKS.defaultBlockState(), 2);
            }
            else if (random < 6)
            {
                worldIn.setBlock(pos, Blocks.MOSSY_STONE_BRICKS.defaultBlockState(), 2);
            }
            else
            {
                worldIn.setBlock(pos, Blocks.CRACKED_STONE_BRICKS.defaultBlockState(), 2);
            }
            BlockPos leftPos = getLeft(pos, direction);
            BlockPos rightPos = getRight(pos, direction);
            BlockPos frontPos = getFront(pos, direction);
            BlockPos behindPos = getBehind(pos, direction);
            Block leftBlock = worldIn.getBlockState(leftPos).getBlock();
            Block rightBlock = worldIn.getBlockState(rightPos).getBlock();
            Block frontBlock = worldIn.getBlockState(frontPos).getBlock();
            Block behindBlock = worldIn.getBlockState(behindPos).getBlock();

            int random2 = getRandomPositiveIntInRange(10, rand);
            if (random2 == 1 && leftBlock instanceof AirBlock)
            {
                generateVine(leftPos,worldIn, rand, direction);
            }
            random2 = getRandomPositiveIntInRange(10, rand);
            if (random2 == 1 && rightBlock instanceof AirBlock)
            {
                generateVine(rightPos,worldIn, rand, direction);
            }
            random2 = getRandomPositiveIntInRange(10, rand);
            if (random2 == 1 && frontBlock instanceof AirBlock)
            {
                generateVine(behindPos,worldIn, rand, direction);
            }
            random2 = getRandomPositiveIntInRange(10, rand);
            if (random2 == 1 && behindBlock instanceof AirBlock)
            {
                generateVine(frontPos,worldIn, rand, direction);
            }
        }
    }
    private void generateStoneBricksSlab(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, boolean isUp)
    {
        boolean inFlag = false;
        int randomSpawn = getRandomPositiveIntInRange(numberA,rand);
        if(randomSpawn == 1)
        {
            inFlag = true;
            this.countInFlag +=1;
            if(this.countInFlag > 6)
            {
                this.flag = true;
            }
        }
        if(!this.flag && !inFlag)
        {
            int random = getRandomPositiveIntInRange(10, rand);
            SlabType type = isUp ? SlabType.TOP : SlabType.BOTTOM;
            if (random < 4) {
                worldIn.setBlock(pos, Blocks.STONE_BRICK_SLAB.defaultBlockState().setValue(SlabBlock.TYPE, type), 2);
            } else {
                worldIn.setBlock(pos, Blocks.MOSSY_STONE_BRICK_SLAB.defaultBlockState().setValue(SlabBlock.TYPE, type), 2);
            }
        }
    }
    private void generateStoneBricksStairWithShape(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        boolean inFlag = false;
        int randomSpawn = getRandomPositiveIntInRange(numberA,rand);
        if(randomSpawn == 1)
        {
            inFlag = true;
            this.countInFlag +=1;
            if(this.countInFlag > 6)
            {
                this.flag = true;
            }
        }
        if(!this.flag && !inFlag)
        {
            int random = getRandomPositiveIntInRange(10, rand);
            if (random < 4)
            {
                worldIn.setBlock(pos, Blocks.STONE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, direction).setValue(StairBlock.HALF, Half.TOP), 2);
            } else
            {
                worldIn.setBlock(pos, Blocks.MOSSY_STONE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, direction).setValue(StairBlock.HALF, Half.TOP), 2);
            }
        }
    }
    private void generateStoneBricksStair(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        boolean inFlag = false;
        int randomSpawn = getRandomPositiveIntInRange(numberA,rand);
        if(randomSpawn == 1)
        {
            inFlag = true;
            this.countInFlag +=1;
            if(this.countInFlag > 5)
            {
                this.flag = true;
            }
        }
        if(!this.flag && !inFlag)
        {
            int random = getRandomPositiveIntInRange(10, rand);
            if (random < 4) {
                worldIn.setBlock(pos, Blocks.STONE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, direction), 2);
            } else {
                worldIn.setBlock(pos, Blocks.MOSSY_STONE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, direction), 2);
            }
        }
    }

    private Direction getDirection(RandomSource rand)
    {
        switch(getRandomPositiveIntInRange(4,rand))
        {
            case 0:
            {
              return Direction.NORTH;
            }
            case 1:
            {
                return Direction.EAST;
            }
            case 2:
            {
                return Direction.SOUTH;
            }
            default :
            {
                return Direction.WEST;
            }
        }
    }

    private BlockPos getLeft(BlockPos pos, Direction direction)
    {
        switch (direction)
        {
            case Direction.NORTH:
            {
                return pos.west();
            }
            case Direction.EAST:
            {
                return pos.north();
            }
            case Direction.SOUTH:
            {
                return pos.east();
            }
            default :
            {
                return pos.south();
            }
        }
    }
    private BlockPos getRight(BlockPos pos, Direction direction)
    {
        switch (direction)
        {
            case Direction.NORTH:
            {
                return pos.east();
            }
            case Direction.EAST:
            {
                return pos.south();
            }
            case Direction.SOUTH:
            {
                return pos.west();
            }
            default :
            {
                return pos.north();
            }
        }
    }
    private BlockPos getBehind(BlockPos pos, Direction direction)
    {
        switch (direction)
        {
            case Direction.NORTH:
            {
                return pos.north();
            }
            case Direction.EAST:
            {
                return pos.east();
            }
            case Direction.SOUTH:
            {
                return pos.south();
            }
            default :
            {
                return pos.west();
            }
        }
    }
    private BlockPos getFront(BlockPos pos, Direction direction)
    {
        switch (direction)
        {
            case Direction.NORTH:
            {
                return pos.south();
            }
            case Direction.EAST:
            {
                return pos.west();
            }
            case Direction.SOUTH:
            {
                return pos.north();
            }
            default :
            {
                return pos.east();
            }
        }
    }

    private BlockPos getRandomHeight(BlockPos pos,RandomSource rand)
    {
        int randomInt = getRandomPositiveIntInRange(12, rand);

            return pos.below(randomInt + 3);
    }

    private int getRandomPositiveIntInRange(int modulo, RandomSource rand)
    {
        return (Math.abs(rand.nextInt()))%modulo;
    }

    private void generateMouth(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        BlockPos leftPos = getLeft(pos, direction);
        BlockPos rightPos = getRight(pos, direction);
        Direction directionLeft;
        Direction directionRight;

        switch (direction)
        {
            case Direction.NORTH :
            {
                directionLeft = Direction.WEST;
                directionRight = Direction.EAST;
                break;
            }
            case Direction.EAST :
            {
                directionLeft = Direction.NORTH;
                directionRight = Direction.SOUTH;
                break;
            }
            case Direction.SOUTH :
            {
                directionLeft = Direction.EAST;
                directionRight = Direction.WEST;
                break;
            }
            default :
            {
                directionLeft = Direction.SOUTH;
                directionRight = Direction.NORTH;
                break;
            }
        }
        int random = getRandomPositiveIntInRange(10,rand);
        generateStoneBricksStairWithShape(rightPos, worldIn, rand, directionRight);
        generateStoneBricksStairWithShape(leftPos, worldIn, rand, directionLeft);
    }

    private void generateVine(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        int i = 0;
        List<BlockPos> posList =  Arrays.asList(getLeft(pos, direction), getRight(pos, direction), getFront(pos, direction), getBehind(pos, direction));
        List<Block> blockList = new ArrayList<>();
        List<Direction> directionList = new ArrayList<>();
        for(BlockPos posFor : posList)
        {
            blockList.add(worldIn.getBlockState(posFor).getBlock());
            directionList.add(Direction.fromDelta((pos.getX()-posList.get(i).getX()),pos.getY()-posList.get(i).getY(),pos.getZ()-posList.get(i).getZ()));
            i ++;
        }

        i = 0;
        BlockState blockState = Blocks.VINE.defaultBlockState();

        for(Block block : blockList)
        {
            if(!(block instanceof AirBlock) && !(block instanceof VineBlock) && !(block instanceof BushBlock))
            {
                switch (directionList.get(i))
                {
                    case NORTH :
                    {
                        blockState = blockState.setValue(VineBlock.SOUTH, true);
                        break;
                    }
                    case EAST :
                    {
                        blockState = blockState.setValue(VineBlock.WEST, true);
                        break;
                    }
                    case SOUTH :
                    {
                        blockState = blockState.setValue(VineBlock.NORTH, true);
                        break;
                    }
                    default :
                    {
                        blockState = blockState.setValue(VineBlock.EAST, true);
                        break;
                    }
                }
            }
            i++;
        }

        worldIn.setBlock(pos, blockState,1 & 2);

        int randomLength = getRandomPositiveIntInRange(4, rand);
        boolean flagLengthVine = false;
        BlockPos posModif = pos;

        for (int j = 0; j < randomLength; j++)
        {
            posModif = posModif.below();
            Block blockModif = worldIn.getBlockState(posModif).getBlock();
            if(!flagLengthVine && blockModif instanceof AirBlock)
            {
                worldIn.setBlock(posModif, blockState,1 & 2);
            }
            else
            {
                flagLengthVine = true;
            }
        }
    }
}
