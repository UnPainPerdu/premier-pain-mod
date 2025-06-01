package com.unpainperdu.premierpainmod.util.tool_kit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class DirectionHelper
{
    //todo it looks like DirectionHelper is duplicated with PosHelper
    private DirectionHelper(){}

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

    public static Direction getRandomDirection(RandomSource rand)
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

    /**
     * true if east or west
     **/
    public static boolean isBlockOnXAxis(BlockState state)
    {
        Direction facing = state.getValue(BlockStateProperties.FACING);
        return facing == Direction.EAST || facing == Direction.WEST;
    }

    /**
     * true if north or south
     **/
    public static boolean isBlockOnZAxis(BlockState state)
    {
        Direction facing = state.getValue(BlockStateProperties.FACING);
        return facing == Direction.NORTH || facing == Direction.SOUTH;
    }

    /**
     * true if up or down
     **/
    public static boolean isBlockOnYAxis(BlockState state)
    {
        Direction facing = state.getValue(BlockStateProperties.FACING);
        return facing == Direction.UP || facing == Direction.DOWN;
    }
}
