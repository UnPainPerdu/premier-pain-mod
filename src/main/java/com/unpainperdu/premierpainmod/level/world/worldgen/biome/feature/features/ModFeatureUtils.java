package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.LiquidBlock;

import java.util.ArrayList;

public class ModFeatureUtils
{

    public static BlockPos getRandomHeight(BlockPos pos, RandomSource rand)
    {
        int randomInt = getRandomPositiveIntInRange(12, rand);

        return pos.below(randomInt + 3);
    }

    public static int getRandomPositiveIntInRange(int modulo, RandomSource rand)
    {
        return (Math.abs(rand.nextInt()))%modulo;
    }

    public static int getRandomIntInRange(int modulo, RandomSource rand)
    {
        return (rand.nextInt())%modulo;
    }

    public static BlockPos getLeft(BlockPos pos, Direction direction)
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
    public static BlockPos getRight(BlockPos pos, Direction direction)
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
    public static BlockPos getBehind(BlockPos pos, Direction direction)
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
    public static BlockPos getFront(BlockPos pos, Direction direction)
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
            if (pos1 == pos)
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
                if(!(worldIn.getBlockState(belowPos).getBlock() instanceof AirBlock))
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
        if(worldIn.getBlockState(pos.below()).getBlock() instanceof AirBlock || worldIn.getBlockState(pos.below()).getBlock() instanceof LiquidBlock)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
