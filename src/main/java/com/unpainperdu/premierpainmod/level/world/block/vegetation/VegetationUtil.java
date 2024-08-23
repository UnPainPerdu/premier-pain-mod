package com.unpainperdu.premierpainmod.level.world.block.vegetation;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrassBlock;

public class VegetationUtil
{
    public static BlockPos getRandomPosWithSameY(BlockPos pos, RandomSource rand)
    {
        Direction direction = getRandomDirection(rand);

        int randomOffSet = getRandomPositiveIntInRange(3, rand) + 1; //[1;3]
        pos = pos.relative(direction,randomOffSet);

        randomOffSet = getRandomPositiveIntInRange(2, rand) + 1; //[1;2]
        direction = getRandomLeftOrRight(rand, direction);
        pos = pos.relative( direction , randomOffSet);

        return pos;
    }

    public static Direction getRandomDirection(RandomSource rand)
    {
        Direction direction;

        switch (getRandomPositiveIntInRange(4, rand))
        {
            case 0 :
            {
                direction = Direction.NORTH;
                break;
            }
            case 1 :
            {
                direction = Direction.EAST;
                break;
            }
            case 2 :
            {
                direction = Direction.SOUTH;
                break;
            }
            default:
            {
                direction = Direction.WEST;
                break;
            }
        }
        return direction;
    }

    public static Direction getRandomLeftOrRight(RandomSource rand, Direction direction)
    {
        int chance = getRandomPositiveIntInRange(2, rand);
        if(direction == Direction.NORTH || direction == Direction.SOUTH)
        {
            direction = chance==0? Direction.EAST: Direction.WEST;
        }
        else
        {
            direction = chance==0? Direction.NORTH: Direction.SOUTH;
        }
        return direction;
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

    /**
     *If pos is not good and unchangeable -> return null
     **/
    public static BlockPos checkAndChangeIfPosBad(BlockPos pos, ServerLevel level)
    {
        BlockPos finalPos = null;
        Block block = level.getBlockState(pos).getBlock();
        if(block instanceof AirBlock)
        {
            int i = 0;
            while(i < 5)
            {
                BlockPos posBelow = pos.below();
                Block blockBelow = level.getBlockState(posBelow).getBlock();
                if (blockBelow instanceof GrassBlock)
                {
                    finalPos = pos;
                    break;
                }
                pos = pos.below();
                i++;
            }
        }
        else
        {
            int j = 0;
            while(j < 5)
            {
                BlockPos posAbove = pos.above(j + 1);
                Block blockAbove = level.getBlockState(posAbove).getBlock();
                if (blockAbove instanceof AirBlock)
                {
                    BlockPos posBelow = posAbove.below();
                    Block blockBelow = level.getBlockState(posBelow).getBlock();
                    if(blockBelow instanceof GrassBlock)
                    {
                        finalPos = posAbove;
                        break;
                    }
                }
                j++;
            }
        }

        return finalPos;
    }
}
