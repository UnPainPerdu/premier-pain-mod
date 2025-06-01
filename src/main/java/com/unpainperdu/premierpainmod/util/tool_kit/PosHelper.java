package com.unpainperdu.premierpainmod.util.tool_kit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.LiquidBlock;

import java.util.ArrayList;
import java.util.List;

public class PosHelper
{
    private PosHelper(){}

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

    public static boolean isPosInList(BlockPos pos, List<BlockPos> posList)
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
        int random = RandomUtil.getRandomPositiveIntInRange(maxNumberOfPos - minNumberOfPos, rand) + minNumberOfPos;
        ArrayList<BlockPos> list = new ArrayList<>();
        list.add(pos);

        for (int i = 0; i < random; i++)
        {
            int previousPosX = pos.getX();
            int previousPosY = pos.getY();
            int previousPosZ = pos.getZ();

            int newPosX = previousPosX + RandomUtil.getRandomIntInRange(spread, rand);
            int newPosZ = previousPosZ + RandomUtil.getRandomIntInRange(spread, rand);

            BlockPos tempPos = new BlockPos(newPosX, previousPosY, newPosZ);

            if(!(isPosInList(tempPos, list)))
            {
                list.add(tempPos);

                pos = tempPos;
            }
        }
        return list;
    }

    public static ArrayList<BlockPos> setAllPosToTheGround(List<BlockPos> list, WorldGenLevel worldIn)
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
        return block instanceof AirBlock || block instanceof LiquidBlock || block instanceof LeavesBlock;
    }

    /**
     * set all pos in the list above their current pos
     * @param howMuch is for how much block above you want to set the pos
     **/
    public static ArrayList<BlockPos> setPosAboveForAll(List<BlockPos> list, int howMuch)
    {
        ArrayList<BlockPos> tempList = new ArrayList<>();
        for (BlockPos pos1 : list)
        {
            tempList.add(pos1.above(howMuch));
        }
        return tempList;
    }

    public static BlockPos changeRandomlyYPos(RandomSource rand, BlockPos pos, int minOffset, int maxOffSet)
    {
        int i = RandomUtil.getRandomPositiveIntInRange(2, rand);
        int yChange = RandomUtil.getRandomPositiveIntInRange(maxOffSet - minOffset + 1, rand) + minOffset;
        int y =  pos.getY() + (yChange * (i == 0 ? -1 : 1));
        return new BlockPos(pos.getX(), y, pos.getZ());
    }
}
