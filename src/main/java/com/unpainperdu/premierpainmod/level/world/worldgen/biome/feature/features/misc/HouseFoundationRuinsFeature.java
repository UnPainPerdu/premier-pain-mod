package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.misc;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.util.tool_kit.DirectionHelper;
import com.unpainperdu.premierpainmod.util.tool_kit.PosHelper;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseFoundationRuinsFeature extends Feature<NoneFeatureConfiguration>
{
    private int numberA = 1000;
    private int countInFlag = 0;
    private boolean flag = false;
    public HouseFoundationRuinsFeature(Codec<NoneFeatureConfiguration> pCodec)
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
        Direction direction = DirectionHelper.getRandomDirection(rand);

        int randomChanceSpawn = RandomUtil.getRandomPositiveIntInRange(3, rand);
        if (!(randomChanceSpawn == 1) || PosHelper.isFlying(pos, worldIn))
        {
            return false;
        }
        int randomChanceShape = RandomUtil.getRandomPositiveIntInRange(10, rand);
        if (randomChanceShape < 5)
        {
            generate5x5SquareHouseFoundationRuins(worldIn, rand, pos, direction);

        }
        else if (randomChanceShape < 8)
        {
            generate5BlockCircleHouseFoundationRuins(worldIn, rand, pos, direction);
        }
        else
        {
            generateLHouseFoundationRuins(worldIn, rand, pos, direction);
        }

        this.numberA = 1000;
        this.countInFlag = 0;
        this.flag = false;
        return true;
    }

    private void generate5x5SquareHouseFoundationRuins(WorldGenLevel worldIn, RandomSource rand, BlockPos pos, Direction direction)
    {
        ArrayList<BlockPos> floorList = getPosListSquareFoundation(pos, worldIn, direction);
        ArrayList<BlockPos> wallFirstLevelList = PosHelper.setPosAboveForAll(getSidePos(floorList), 1);
        ArrayList<BlockPos> wallSecondLevelList = PosHelper.setPosAboveForAll(getSidePos(floorList), 2);
        floorList = PosHelper.setAllPosToTheGround(floorList, worldIn);
        for (BlockPos pos1 : floorList)
        {
            generateStoneBricks(pos1, worldIn, rand, direction);
        }
        this.numberA = 5;
        wallFirstLevelList = PosHelper.setAllPosToTheGround(wallFirstLevelList, worldIn);
        for (BlockPos pos2 : wallFirstLevelList)
        {
            generateStoneBricks(pos2, worldIn, rand, direction);
        }
        this.numberA = 2;
        wallSecondLevelList = PosHelper.setAllPosToTheGround(wallSecondLevelList, worldIn);
        for (BlockPos pos3 : wallSecondLevelList)
        {
            generateStoneBricks(pos3, worldIn, rand, direction);
        }
    }
    private void generate5BlockCircleHouseFoundationRuins(WorldGenLevel worldIn, RandomSource rand, BlockPos pos, Direction direction)
    {
        ArrayList<BlockPos> floorList = getPosListCircleFoundation(pos, worldIn, direction);
        ArrayList<BlockPos> wallFirstLevelList = PosHelper.setPosAboveForAll(getSidePos(floorList), 1);
        ArrayList<BlockPos> wallSecondLevelList = PosHelper.setPosAboveForAll(getSidePos(floorList), 2);
        floorList = PosHelper.setAllPosToTheGround(floorList, worldIn);
        for (BlockPos pos1 : floorList)
        {
            generateStoneBricks(pos1, worldIn, rand, direction);
        }
        this.numberA = 2;
        wallFirstLevelList = PosHelper.setAllPosToTheGround(wallFirstLevelList, worldIn);
        for (BlockPos pos2 : wallFirstLevelList)
        {
            generateStoneBricks(pos2, worldIn, rand, direction);
        }
        wallSecondLevelList = PosHelper.setAllPosToTheGround(wallSecondLevelList, worldIn);
        for (BlockPos pos3 : wallSecondLevelList)
        {
            generateStoneBricks(pos3, worldIn, rand, direction);
        }
    }
    private void generateLHouseFoundationRuins(WorldGenLevel worldIn, RandomSource rand, BlockPos pos, Direction direction)
    {
        ArrayList<BlockPos> floorList = getPosListLFoundation(pos, worldIn, direction);
        ArrayList<BlockPos> wallFirstLevelList = PosHelper.setPosAboveForAll(getSidePos(floorList), 1);
        ArrayList<BlockPos> wallSecondLevelList = PosHelper.setPosAboveForAll(getSidePos(floorList), 2);
        floorList = PosHelper.setAllPosToTheGround(floorList, worldIn);
        for (BlockPos pos1 : floorList)
        {
            generateStoneBricks(pos1, worldIn, rand, direction);
        }

        this.numberA = 4;
        wallFirstLevelList = PosHelper.setAllPosToTheGround(wallFirstLevelList, worldIn);
        for (BlockPos pos2 : wallFirstLevelList)
        {
            generateStoneBricks(pos2, worldIn, rand, direction);
        }

        this.numberA = 2;
        wallSecondLevelList = PosHelper.setAllPosToTheGround(wallSecondLevelList, worldIn);
        for (BlockPos pos3 : wallSecondLevelList)
        {
            generateStoneBricks(pos3, worldIn, rand, direction);
        }
    }

    private ArrayList<BlockPos> getPosListSquareFoundation(BlockPos pos, WorldGenLevel worldIn, Direction direction)
    {
        ArrayList<BlockPos> list = new ArrayList<>();

        list.add(pos); //center of square

        // 3x3
        BlockPos posTempFront = PosHelper.getFront(pos, direction);
        BlockPos posTempBehind = PosHelper.getBehind(pos, direction);
        list.add(posTempFront);
        list.add(PosHelper.getLeft(posTempFront,direction));
        list.add(PosHelper.getRight(posTempFront,direction));
        list.add(PosHelper.getBehind(PosHelper.getLeft(posTempFront,direction), direction));
        list.add(PosHelper.getBehind(PosHelper.getRight(posTempFront,direction), direction));
        list.add(posTempBehind);
        list.add(PosHelper.getLeft(posTempBehind,direction));
        list.add(PosHelper.getRight(posTempBehind,direction));

        //5x5
        posTempFront = PosHelper.getFront(posTempFront, direction);
        posTempBehind = PosHelper.getBehind(posTempBehind, direction);
        BlockPos posTempLeft = PosHelper.getLeft(pos, direction, 2);
        BlockPos posTempRight = PosHelper.getRight(pos, direction, 2);
            //front
        list.add(posTempFront);
        list.add(PosHelper.getLeft(posTempFront,direction));
        list.add(PosHelper.getLeft(posTempFront,direction, 2));
        list.add(PosHelper.getRight(posTempFront,direction));
        list.add(PosHelper.getRight(posTempFront,direction, 2));
            //behind
        list.add(posTempBehind);
        list.add(PosHelper.getLeft(posTempBehind,direction));
        list.add(PosHelper.getLeft(posTempBehind,direction, 2));
        list.add(PosHelper.getRight(posTempBehind,direction));
        list.add(PosHelper.getRight(posTempBehind,direction, 2));
            //left
        list.add(posTempLeft);
        list.add(PosHelper.getBehind(posTempLeft,direction));
        list.add(PosHelper.getFront(posTempLeft,direction));
        //right
        list.add(posTempRight);
        list.add(PosHelper.getBehind(posTempRight,direction));
        list.add(PosHelper.getFront(posTempRight,direction));

        return list;
    }
    private ArrayList<BlockPos> getPosListCircleFoundation(BlockPos pos, WorldGenLevel worldIn, Direction direction)
    {
        ArrayList<BlockPos> list = new ArrayList<>();

        list.add(pos); //center of circle

        // 3x3
        BlockPos posTempFront = PosHelper.getFront(pos, direction);
        BlockPos posTempBehind = PosHelper.getBehind(pos, direction);
        list.add(posTempFront);
        list.add(PosHelper.getLeft(posTempFront,direction));
        list.add(PosHelper.getRight(posTempFront,direction));
        list.add(PosHelper.getBehind(PosHelper.getLeft(posTempFront,direction), direction));
        list.add(PosHelper.getBehind(PosHelper.getRight(posTempFront,direction), direction));
        list.add(posTempBehind);
        list.add(PosHelper.getLeft(posTempBehind,direction));
        list.add(PosHelper.getRight(posTempBehind,direction));

        list.add(PosHelper.getFront(pos, direction, 2));
        list.add(PosHelper.getBehind(pos, direction, 2));
        list.add(PosHelper.getLeft(pos, direction, 2));
        list.add(PosHelper.getRight(pos, direction, 2));

        return list ;
    }
    private ArrayList<BlockPos> getPosListLFoundation(BlockPos pos, WorldGenLevel worldIn, Direction direction)
    {
        ArrayList<BlockPos> list = new ArrayList<>();
        ArrayList<BlockPos> tempListA = getPosListSquareFoundation(pos, worldIn, direction);
        ArrayList<BlockPos> tempListB = getPosListSquareFoundation(PosHelper.getRight(pos, direction, 5), worldIn, direction);
        ArrayList<BlockPos> tempListC = getPosListSquareFoundation(PosHelper.getFront(pos, direction, 5), worldIn, direction);
        list.addAll(tempListA);
        list.addAll(tempListB);
        list.addAll(tempListC);

        return list;
    }

    private static ArrayList<BlockPos> getSidePos(ArrayList<BlockPos> posList)
    {
        ArrayList<BlockPos> list = new ArrayList<>();
        for (BlockPos pos1 : posList)
        {
            List<BlockPos> sidePosList = Arrays.asList(pos1.north(), pos1.east(), pos1.west(), pos1.south());
            for (BlockPos sidePos : sidePosList)
            {
                if (!PosHelper.isPosInList(sidePos, posList))
                {
                    list.add(pos1);
                    break;
                }
            }
        }
        return list;
    }
    private void generateStoneBricks(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        int randomSpawn = RandomUtil.getRandomPositiveIntInRange(this.numberA,rand);
        if(randomSpawn == 1)
        {
            this.countInFlag += 1;
            if (this.countInFlag > 6)
            {
                this.flag = true;
            }
        }
        else if(!this.flag)
        {
            int random = RandomUtil.getRandomPositiveIntInRange(10, rand);
            if (random < 4)
            {
                worldIn.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 2);
            }
            else
            {
                worldIn.setBlock(pos, Blocks.MOSSY_COBBLESTONE.defaultBlockState(), 2);
            }
        }
    }
}
