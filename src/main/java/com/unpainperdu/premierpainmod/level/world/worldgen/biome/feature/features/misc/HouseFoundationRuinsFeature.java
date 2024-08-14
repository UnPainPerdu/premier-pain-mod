package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.misc;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.ModFeatureUtils;
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
        Direction direction = ModFeatureUtils.getDirection(rand);

        int randomChanceSpawn = ModFeatureUtils.getRandomPositiveIntInRange(3, rand);
        if (!(randomChanceSpawn == 1) || ModFeatureUtils.isFlying(pos, worldIn))
        {
            return false;
        }
        generateHouseFoundationRuins(worldIn, rand, pos, direction);
        this.numberA = 1000;
        this.countInFlag = 0;
        this.flag = false;
        return true;
    }

    private void generateHouseFoundationRuins(WorldGenLevel worldIn, RandomSource rand, BlockPos pos, Direction direction)
    {
        ArrayList<BlockPos> floorList = getPosListSquareFoundation(pos, worldIn, direction);
        ArrayList<BlockPos> wallFirstLevelList = ModFeatureUtils.upTo(getSidePos(floorList), 1);
        ArrayList<BlockPos> wallSecondLevelList = ModFeatureUtils.upTo(getSidePos(floorList), 2);
        floorList = ModFeatureUtils.setAllPosToTheGround(floorList, worldIn);
        for (BlockPos pos1 : floorList)
        {
            generateStoneBricks(pos1, worldIn, rand, direction);
        }
        this.numberA = 5;
        wallFirstLevelList = ModFeatureUtils.setAllPosToTheGround(wallFirstLevelList, worldIn);
        for (BlockPos pos2 : wallFirstLevelList)
        {
            generateStoneBricks(pos2, worldIn, rand, direction);
        }
        this.numberA = 2;
        wallSecondLevelList = ModFeatureUtils.setAllPosToTheGround(wallSecondLevelList, worldIn);
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
        BlockPos posTempFront = ModFeatureUtils.getFront(pos, direction);
        BlockPos posTempBehind = ModFeatureUtils.getBehind(pos, direction);
        list.add(posTempFront);
        list.add(ModFeatureUtils.getLeft(posTempFront,direction));
        list.add(ModFeatureUtils.getRight(posTempFront,direction));
        list.add(ModFeatureUtils.getBehind(ModFeatureUtils.getLeft(posTempFront,direction), direction));
        list.add(ModFeatureUtils.getBehind(ModFeatureUtils.getRight(posTempFront,direction), direction));
        list.add(posTempBehind);
        list.add(ModFeatureUtils.getLeft(posTempBehind,direction));
        list.add(ModFeatureUtils.getRight(posTempBehind,direction));

        //5x5
        posTempFront = ModFeatureUtils.getFront(posTempFront, direction);
        posTempBehind = ModFeatureUtils.getBehind(posTempBehind, direction);
        BlockPos posTempLeft = ModFeatureUtils.getLeft(pos, direction, 2);
        BlockPos posTempRight = ModFeatureUtils.getRight(pos, direction, 2);
            //front
        list.add(posTempFront);
        list.add(ModFeatureUtils.getLeft(posTempFront,direction));
        list.add(ModFeatureUtils.getLeft(posTempFront,direction, 2));
        list.add(ModFeatureUtils.getRight(posTempFront,direction));
        list.add(ModFeatureUtils.getRight(posTempFront,direction, 2));
            //behind
        list.add(posTempBehind);
        list.add(ModFeatureUtils.getLeft(posTempBehind,direction));
        list.add(ModFeatureUtils.getLeft(posTempBehind,direction, 2));
        list.add(ModFeatureUtils.getRight(posTempBehind,direction));
        list.add(ModFeatureUtils.getRight(posTempBehind,direction, 2));
            //left
        list.add(posTempLeft);
        list.add(ModFeatureUtils.getBehind(posTempLeft,direction));
        list.add(ModFeatureUtils.getFront(posTempLeft,direction));
        //right
        list.add(posTempRight);
        list.add(ModFeatureUtils.getBehind(posTempRight,direction));
        list.add(ModFeatureUtils.getFront(posTempRight,direction));

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
                if (!ModFeatureUtils.isPosInList(sidePos, posList))
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
        int randomSpawn = ModFeatureUtils.getRandomPositiveIntInRange(this.numberA,rand);
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
            int random = ModFeatureUtils.getRandomPositiveIntInRange(10, rand);
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
