package com.unpainperdu.premierpainmod.util.tool_kit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class DirectionHelper
{
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
        return switch (RandomUtil.getRandomPositiveIntInRange(4, rand))
        {
            case 0 -> Direction.NORTH;
            case 1 -> Direction.EAST;
            case 2 -> Direction.SOUTH;
            default -> Direction.WEST;
        };
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
                case Direction.NORTH -> direction = Direction.EAST;
                case Direction.EAST -> direction = Direction.SOUTH;
                case Direction.SOUTH -> direction = Direction.WEST;
                default -> direction = Direction.NORTH;
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

    public static Direction.Axis getLogAxisFromPos(BlockPos pos, BlockPos otherPos)
    {
        Direction.Axis direction$axis = Direction.Axis.Y;
        int i = Math.abs(otherPos.getX() - pos.getX());
        int j = Math.abs(otherPos.getZ() - pos.getZ());
        int k = Math.max(i, j);
        if (k > 0)
        {
            if (i == k)
            {
                direction$axis = Direction.Axis.X;
            }
            else
            {
                direction$axis = Direction.Axis.Z;
            }
        }

        return direction$axis;
    }
}