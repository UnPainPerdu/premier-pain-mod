package com.unpainperdu.premierpainmod.level.world.worldgen.feature;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;

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
}
