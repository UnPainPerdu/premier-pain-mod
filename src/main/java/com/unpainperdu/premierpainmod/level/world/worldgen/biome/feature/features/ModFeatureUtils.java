package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ModFeatureUtils
{

    public static BlockPos getRandomHeight(BlockPos pos, RandomSource rand,int minDepth, int maxDepth)
    {
        int randomInt = getRandomPositiveIntInRange(maxDepth - minDepth + 1, rand);

        return pos.below(randomInt + minDepth);
    }

    /**
     * maxExcludedBorn must be >= 2, or it will be set to 2
     */
    public static int getRandomPositiveIntInRange(int maxExcludedBorn, RandomSource rand)
    {
        if (maxExcludedBorn<2)
        {
            maxExcludedBorn = 2;
        }
        return (Math.abs(rand.nextInt()))%maxExcludedBorn;
    }

    public static int getRandomIntInRange(int maxExcludedBorn, RandomSource rand)
    {
        if (maxExcludedBorn<2)
        {
            maxExcludedBorn = 2;
        }
        return (rand.nextInt())%maxExcludedBorn;
    }

    public static BlockPos getLeft(BlockPos pos, Direction direction)
    {
        return getLeft(pos, direction, 1);
    }

    public static BlockPos getLeft(BlockPos pos, Direction direction, int howMuch)
    {
        for (int i = 0; i < howMuch; i++)
        {
            switch (direction)
            {
                case Direction.NORTH:
                {
                    pos = pos.west();
                    break;
                }
                case Direction.EAST:
                {
                    pos = pos.north();
                    break;
                }
                case Direction.SOUTH:
                {
                    pos = pos.east();
                    break;
                }
                default:
                {
                    pos = pos.south();
                }
            }
        }
        return pos;
    }
    public static BlockPos getRight(BlockPos pos, Direction direction)
    {
        return getRight(pos, direction, 1);
    }
    public static BlockPos getRight(BlockPos pos, Direction direction, int howMuch)
    {
        for (int i = 0; i < howMuch; i++)
        {
            switch (direction)
            {
                case Direction.NORTH:
                {
                    pos = pos.east();
                    break;
                }
                case Direction.EAST:
                {
                    pos = pos.south();
                    break;
                }
                case Direction.SOUTH:
                {
                    pos = pos.west();
                    break;
                }
                default:
                {
                    pos = pos.north();
                }
            }
        }
        return pos;
    }
    public static BlockPos getBehind(BlockPos pos, Direction direction)
    {
        return getBehind(pos, direction, 1);
    }
    public static BlockPos getBehind(BlockPos pos, Direction direction, int howMuch)
    {
        for (int i = 0; i < howMuch; i++)
        {
            switch (direction)
            {
                case Direction.NORTH:
                {
                    pos = pos.north();
                    break;
                }
                case Direction.EAST:
                {
                    pos = pos.east();
                    break;
                }
                case Direction.SOUTH:
                {
                    pos = pos.south();
                    break;
                }
                default:
                {
                    pos = pos.west();
                }
            }
        }
        return pos;
    }
    public static BlockPos getFront(BlockPos pos, Direction direction)
    {
        return getFront(pos, direction, 1);
    }
    public static BlockPos getFront(BlockPos pos, Direction direction, int howMuch)
    {
        for (int i = 0; i < howMuch; i++)
        {
            switch (direction)
            {
                case Direction.NORTH:
                {
                    pos = pos.south();
                    break;
                }
                case Direction.EAST:
                {
                    pos = pos.west();
                    break;
                }
                case Direction.SOUTH:
                {
                    pos = pos.north();
                    break;
                }
                default:
                {
                    pos = pos.east();
                }
            }
        }
        return pos;
    }
    public static Direction getDirection(RandomSource rand)
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
    public static boolean isPosInList(BlockPos pos, ArrayList<BlockPos> posList)
    {
        boolean flag = false;
        for(BlockPos pos1 : posList)
        {
            if (pos1.equals(pos))
            {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * spread = max value in x and z that pos is far
     * */
    public static ArrayList<BlockPos> getRandomPosWithSameY (BlockPos pos,int minNumberOfPos, int maxNumberOfPos,int spread, RandomSource rand)
    {
        int random = getRandomPositiveIntInRange(maxNumberOfPos - minNumberOfPos, rand) + minNumberOfPos;
        ArrayList<BlockPos> list = new ArrayList<>();
        list.add(pos);

        for (int i = 0; i < random; i++)
        {
            int previousPosX = pos.getX();
            int previousPosY = pos.getY();
            int previousPosZ = pos.getZ();

            int newPosX = previousPosX + getRandomIntInRange(spread, rand);
            int newPosZ = previousPosZ + getRandomIntInRange(spread, rand);

            BlockPos tempPos = new BlockPos(newPosX, previousPosY, newPosZ);

            if(!(isPosInList(tempPos, list)))
            {
                list.add(tempPos);

                pos = tempPos;
            }
        }
        return list;
    }

    public static ArrayList<BlockPos> setAllPosToTheGround(ArrayList<BlockPos> list, WorldGenLevel worldIn)
    {
        ArrayList<BlockPos> tempList = new ArrayList<>();
        for(BlockPos pos1 : list)
        {
            int i = 0;
            boolean flag = false;
            while (!flag)
            {
                BlockPos belowPos = pos1.below();
                Block block = worldIn.getBlockState(belowPos).getBlock();
                if(!(block instanceof AirBlock) && !(block instanceof LiquidBlock) && !(block instanceof LeavesBlock))
                {
                    flag = true;
                    tempList.add(pos1);
                }
                else
                {
                    pos1 = belowPos;
                }
                if (i > 10)
                {
                    flag = true;
                }
                i ++;
            }
        }
        return tempList;
    }

    public static boolean isFlying(BlockPos pos, WorldGenLevel worldIn)
    {
        Block block = worldIn.getBlockState(pos.below()).getBlock();
        if(block instanceof AirBlock || block instanceof LiquidBlock || block instanceof LeavesBlock)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static ArrayList<BlockPos> upTo (ArrayList<BlockPos> list, int howMuch)
    {
        ArrayList<BlockPos> tempList = new ArrayList<>();
        for (BlockPos pos1 : list)
        {
            tempList.add(pos1.above(howMuch));
        }
        return tempList;
    }

    public static Direction getNextDirection_NESW(Direction direction)
    {
        return getNextDirection_NESW(direction, 1);
    }

    public static Direction getNextDirection_NESW(Direction direction, int howMuch)
    {
        for (int i = 0; i < howMuch; i++)
        {
            switch (direction)
            {
                case Direction.NORTH:
                {
                    direction = Direction.EAST;
                    break;
                }
                case Direction.EAST:
                {
                    direction = Direction.SOUTH;
                    break;
                }
                case Direction.SOUTH:
                {
                    direction = Direction.WEST;
                    break;
                }
                default:
                {
                    direction = Direction.NORTH;
                }
            }
        }
        return direction;
    }

    public static void generateBlock(WorldGenLevel worldIn, BlockPos pos, RandomSource rand, BlockState block, boolean isReplacing)
    {
        generateBlock(worldIn, pos, rand, Collections.singletonList(block), isReplacing);
    }
    public static void generateBlock(WorldGenLevel worldIn, BlockPos pos, RandomSource rand, List<BlockState> randomizedBlocks, boolean isReplacing)
    {
        int listSize = randomizedBlocks.size();
        if (listSize == 1)
        {
            if (isReplacing || worldIn.getBlockState(pos).getBlock() instanceof AirBlock)
            {
                worldIn.setBlock(pos, randomizedBlocks.getFirst(), 2);
            }
        }
        else if (listSize > 1)
        {
            if (isReplacing || worldIn.getBlockState(pos).getBlock() instanceof AirBlock)
            {
                int randomInt = getRandomPositiveIntInRange(randomizedBlocks.size(), rand);
                worldIn.setBlock(pos, randomizedBlocks.get(randomInt), 2);
            }
        }
        else
        {
            System.out.println("Warning : failed to generated block at " + pos);
        }
    }

    public static void placeBlockAroundOne(WorldGenLevel worldIn, BlockPos pos, RandomSource rand, List<BlockState> randomizedBlocks, boolean isReplacing)
    {
        ArrayList<BlockPos> posAround = new ArrayList<>(Arrays.asList(pos.above(), pos.north(), pos.east(), pos.south(), pos.west()));
        setAllPosToTheGround( posAround, worldIn);

        for(BlockPos pos1 : posAround)
        {
           if(worldIn.getBlockState(pos1).getBlock() instanceof AirBlock)
           {
               generateBlock(worldIn, pos1, rand, randomizedBlocks, isReplacing);
           }
        }
    }

    /**
     * return true if a randomInt in range [0,maxChance]  < chance
     */
    public static boolean isSpawning(int maxChance, int chance, RandomSource rand)
    {
        int randomInt = getRandomPositiveIntInRange(maxChance, rand);
        return randomInt < chance;
    }
}
