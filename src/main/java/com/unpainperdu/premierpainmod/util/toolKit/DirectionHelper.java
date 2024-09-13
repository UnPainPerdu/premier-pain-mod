package com.unpainperdu.premierpainmod.util.toolKit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;

public class DirectionHelper
{
    public static BlockPos getLeftPos(BlockPos pos, Direction direction)
    {
        return getLeftPos(pos, direction, 1);
    }
    public static BlockPos getLeftPos(BlockPos pos, Direction direction, int howMuch)
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
    public static BlockPos getRightPos(BlockPos pos, Direction direction)
    {
        return getRightPos(pos, direction, 1);
    }
    public static BlockPos getRightPos(BlockPos pos, Direction direction, int howMuch)
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
    public static BlockPos getBehindPos(BlockPos pos, Direction direction)
    {
        return getBehindPos(pos, direction, 1);
    }
    public static BlockPos getBehindPos(BlockPos pos, Direction direction, int howMuch)
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
    public static BlockPos getFrontPos(BlockPos pos, Direction direction)
    {
        return getFrontPos(pos, direction, 1);
    }
    public static BlockPos getFrontPos(BlockPos pos, Direction direction, int howMuch)
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
        switch(RandomUtil.getRandomPositiveIntInRange(4,rand))
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
    public static Direction getLeftDirection(Direction direction)
    {
        return direction.getCounterClockWise();
    }
    public static Direction getRightDirection(Direction direction)
    {
        return direction.getClockWise();
    }
}
