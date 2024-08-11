package com.unpainperdu.premierpainmod.level.world.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class VillagerStatueRuinsFeature extends Feature<NoneFeatureConfiguration>
{
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

            pos = generateBasicShape(pos, worldIn, rand, direction);

            generateArm(pos, worldIn, rand, direction);
            pos = generateBasicShape(pos, worldIn, rand, direction);

            pos = generateBasicShape(pos, worldIn, rand, direction);

            pos = generateNeck(pos, worldIn, rand, direction);
        }
    }

    /**
     * Generate a 3x2 stone bricks panel and return the pos for the next level
     */
    private BlockPos generateBasicShape(BlockPos pos, WorldGenLevel worldIn, RandomSource rand,Direction direction)
    {
        generateStoneBricks(pos,worldIn,rand);

        pos = getLeft(pos, direction);
        generateStoneBricks(pos,worldIn,rand);

        pos = getBehind(pos, direction);
        generateStoneBricks(pos,worldIn,rand);

        pos = getRight(pos, direction);
        generateStoneBricks(pos,worldIn,rand);

        pos = getRight(pos, direction);
        generateStoneBricks(pos,worldIn,rand);

        pos = getFront(pos, direction);
        generateStoneBricks(pos,worldIn,rand);

        return getLeft(pos, direction).above();
    }

    private void generateArm(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        pos = getFront(pos, direction);
        generateStoneBricks(pos,worldIn,rand);

        BlockPos rightPos = getRight(pos,direction);
        generateStoneBricks(rightPos,worldIn,rand);

        rightPos = getRight(rightPos,direction);
        generateStoneBricksStair(rightPos,worldIn,rand,direction);

        rightPos = getBehind(rightPos,direction);
        generateStoneBricks(rightPos,worldIn,rand);

        rightPos = rightPos.above();
        generateStoneBricksStair(rightPos,worldIn,rand,direction);

        rightPos = getBehind(rightPos,direction);
        generateStoneBricks(rightPos,worldIn,rand);

        pos = getLeft(pos,direction);
        generateStoneBricks(pos,worldIn,rand);

        pos = getLeft(pos,direction);
        generateStoneBricksStair(pos,worldIn,rand,direction);

        pos = getBehind(pos,direction);
        generateStoneBricks(pos,worldIn,rand);

        pos = pos.above();
        generateStoneBricksStair(pos,worldIn,rand,direction);

        pos = getBehind(pos,direction);
        generateStoneBricks(pos,worldIn,rand);
    }

    private BlockPos generateNeck(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        generateStoneBricksSlab(pos, worldIn, rand, true);

        //1st layer
        pos = getRight(pos, direction);
        generateStoneBricksSlab(pos, worldIn, rand, true);

        pos = getBehind(pos, direction);
        generateStoneBricks(pos,worldIn,rand);

        pos = getLeft(pos, direction);
        generateStoneBricks(pos,worldIn,rand);

        pos = getLeft(pos, direction);
        generateStoneBricks(pos,worldIn,rand);

        pos = getFront(pos, direction);
        generateStoneBricksSlab(pos, worldIn, rand, true);

        //2nd layer
        pos = getRight(pos, direction).above();
        generateStoneBricksSlab(pos, worldIn, rand, true);
        generateMouth(pos,worldIn,rand,direction);

        pos = getBehind(pos,direction);
        generateStoneBricks(pos,worldIn,rand);
        generateStoneBricks(getLeft(pos,direction),worldIn,rand);
        generateStoneBricks(getRight(pos,direction),worldIn,rand);

        pos = getFront(pos, direction).above();

        return pos;
    }

    private void generateStoneBricks(BlockPos pos, WorldGenLevel worldIn, RandomSource rand)
    {
        int random = getRandomPositiveIntInRange(10,rand);
        if (random<2)
        {
            worldIn.setBlock(pos,Blocks.STONE_BRICKS.defaultBlockState(),2);
        }
        else if (random<6)
        {
            worldIn.setBlock(pos,Blocks.MOSSY_STONE_BRICKS.defaultBlockState(),2);
        }
        else
        {
            worldIn.setBlock(pos,Blocks.CRACKED_STONE_BRICKS.defaultBlockState(),2);
        }
    }
    private void generateStoneBricksSlab(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, boolean isUp)
    {
        int random = getRandomPositiveIntInRange(10,rand);
        SlabType type = isUp ? SlabType.TOP : SlabType.BOTTOM;
        if (random<4)
        {
            worldIn.setBlock(pos,Blocks.STONE_BRICK_SLAB.defaultBlockState().setValue(SlabBlock.TYPE, type),2);
        }
        else
        {
            worldIn.setBlock(pos,Blocks.MOSSY_STONE_BRICK_SLAB.defaultBlockState().setValue(SlabBlock.TYPE, type),2);
        }
    }
    private void generateStoneBricksStair(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        int random = getRandomPositiveIntInRange(10,rand);
        if (random<4)
        {
            worldIn.setBlock(pos,Blocks.STONE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, direction),2);
        }
        else
        {
            worldIn.setBlock(pos,Blocks.MOSSY_STONE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, direction),2);
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
        if (random<4)
        {
            worldIn.setBlock(leftPos,Blocks.STONE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, directionLeft).setValue(StairBlock.HALF, Half.TOP),2);
        }
        else
        {
            worldIn.setBlock(leftPos,Blocks.MOSSY_STONE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, directionLeft).setValue(StairBlock.HALF, Half.TOP),2);
        }

        random = getRandomPositiveIntInRange(10,rand);
        if (random<4)
        {
            worldIn.setBlock(rightPos,Blocks.STONE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, directionRight).setValue(StairBlock.HALF, Half.TOP),2);
        }
        else
        {
            worldIn.setBlock(rightPos,Blocks.MOSSY_STONE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, directionRight).setValue(StairBlock.HALF, Half.TOP),2);
        }
    }
}
