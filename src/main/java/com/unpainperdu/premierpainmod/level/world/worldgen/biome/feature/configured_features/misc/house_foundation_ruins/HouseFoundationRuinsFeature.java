package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.house_foundation_ruins;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.AbstractFeature;
import com.unpainperdu.premierpainmod.util.tool_kit.DirectionHelper;
import com.unpainperdu.premierpainmod.util.tool_kit.PosHelper;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseFoundationRuinsFeature extends AbstractFeature<HouseFoundationRuinsConfiguration>
{
    private int numberA;
    private int countInFlag;
    private boolean flag;

    public HouseFoundationRuinsFeature(Codec<HouseFoundationRuinsConfiguration> codec)
    {
        super(codec);
    }

    @Override
    public boolean canGenerate(FeaturePlaceContext<HouseFoundationRuinsConfiguration> context)
    {
        WorldGenLevel worldIn = context.level();
        BlockPos pos = context.origin();
        BlockState stateBelow = worldIn.getBlockState(pos.below());


        return (!PosHelper.isFlying(pos, worldIn))
                && (
                (stateBelow.is(BlockTags.DIRT))
                        || (stateBelow.is(BlockTags.SAND))
                        || (stateBelow.is(BlockTags.BASE_STONE_OVERWORLD))
        );
    }

    @Override
    public void generate(FeaturePlaceContext<HouseFoundationRuinsConfiguration> context)
    {
        this.numberA = 1000;
        this.countInFlag = 0;
        this.flag = false;
        HouseFoundationRuinsConfiguration config = context.config();
        List<BlockStateProvider> states = config.states();

        WorldGenLevel worldIn = context.level();
        ChunkGenerator chunkGenerator = context.chunkGenerator();
        RandomSource rand = context.random();
        BlockPos pos = context.origin();
        Direction direction = DirectionHelper.getRandomDirection(rand);

        int randomChanceShape = RandomUtil.getRandomPositiveIntInRange(3, rand);
        switch (randomChanceShape)
        {
            case 0 -> generate5x5SquareHouseFoundationRuins(worldIn, rand, pos, direction, states);
            case 1 -> generate5BlockCircleHouseFoundationRuins(worldIn, rand, pos, direction, states);
            case 2 -> generateLHouseFoundationRuins(worldIn, rand, pos, direction, states);
        }


    }

    private void generate5x5SquareHouseFoundationRuins(WorldGenLevel worldIn, RandomSource rand, BlockPos pos, Direction direction, List<BlockStateProvider> states)
    {
        ArrayList<BlockPos> floorList = getPosListSquareFoundation(pos, worldIn, direction);
        ArrayList<BlockPos> wallFirstLevelList = PosHelper.setPosAboveForAll(getSidePos(floorList), 1);
        ArrayList<BlockPos> wallSecondLevelList = PosHelper.setPosAboveForAll(getSidePos(floorList), 2);
        floorList = PosHelper.setAllPosToTheGround(floorList, worldIn);
        for (BlockPos pos1 : floorList)
        {
            placeBlock(pos1, worldIn, rand, states);
        }
        this.numberA = 5;
        wallFirstLevelList = PosHelper.setAllPosToTheGround(wallFirstLevelList, worldIn);
        for (BlockPos pos2 : wallFirstLevelList)
        {
            placeBlock(pos2, worldIn, rand, states);
        }
        this.numberA = 2;
        wallSecondLevelList = PosHelper.setAllPosToTheGround(wallSecondLevelList, worldIn);
        for (BlockPos pos3 : wallSecondLevelList)
        {
            placeBlock(pos3, worldIn, rand, states);
        }
    }

    private void generate5BlockCircleHouseFoundationRuins(WorldGenLevel worldIn, RandomSource rand, BlockPos pos, Direction direction, List<BlockStateProvider> states)
    {
        ArrayList<BlockPos> floorList = getPosListCircleFoundation(pos, worldIn, direction);
        ArrayList<BlockPos> wallFirstLevelList = PosHelper.setPosAboveForAll(getSidePos(floorList), 1);
        ArrayList<BlockPos> wallSecondLevelList = PosHelper.setPosAboveForAll(getSidePos(floorList), 2);
        floorList = PosHelper.setAllPosToTheGround(floorList, worldIn);
        for (BlockPos pos1 : floorList)
        {
            placeBlock(pos1, worldIn, rand, states);
        }
        this.numberA = 2;
        wallFirstLevelList = PosHelper.setAllPosToTheGround(wallFirstLevelList, worldIn);
        for (BlockPos pos2 : wallFirstLevelList)
        {
            placeBlock(pos2, worldIn, rand, states);
        }
        wallSecondLevelList = PosHelper.setAllPosToTheGround(wallSecondLevelList, worldIn);
        for (BlockPos pos3 : wallSecondLevelList)
        {
            placeBlock(pos3, worldIn, rand, states);
        }
    }

    private void generateLHouseFoundationRuins(WorldGenLevel worldIn, RandomSource rand, BlockPos pos, Direction direction, List<BlockStateProvider> states)
    {
        ArrayList<BlockPos> floorList = getPosListLFoundation(pos, worldIn, direction);
        ArrayList<BlockPos> wallFirstLevelList = PosHelper.setPosAboveForAll(getSidePos(floorList), 1);
        ArrayList<BlockPos> wallSecondLevelList = PosHelper.setPosAboveForAll(getSidePos(floorList), 2);
        floorList = PosHelper.setAllPosToTheGround(floorList, worldIn);
        for (BlockPos pos1 : floorList)
        {
            placeBlock(pos1, worldIn, rand, states);
        }

        this.numberA = 4;
        wallFirstLevelList = PosHelper.setAllPosToTheGround(wallFirstLevelList, worldIn);
        for (BlockPos pos2 : wallFirstLevelList)
        {
            placeBlock(pos2, worldIn, rand, states);
        }

        this.numberA = 2;
        wallSecondLevelList = PosHelper.setAllPosToTheGround(wallSecondLevelList, worldIn);
        for (BlockPos pos3 : wallSecondLevelList)
        {
            placeBlock(pos3, worldIn, rand, states);
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
        list.add(PosHelper.getLeft(posTempFront, direction));
        list.add(PosHelper.getRight(posTempFront, direction));
        list.add(PosHelper.getBehind(PosHelper.getLeft(posTempFront, direction), direction));
        list.add(PosHelper.getBehind(PosHelper.getRight(posTempFront, direction), direction));
        list.add(posTempBehind);
        list.add(PosHelper.getLeft(posTempBehind, direction));
        list.add(PosHelper.getRight(posTempBehind, direction));

        //5x5
        posTempFront = PosHelper.getFront(posTempFront, direction);
        posTempBehind = PosHelper.getBehind(posTempBehind, direction);
        BlockPos posTempLeft = PosHelper.getLeft(pos, direction, 2);
        BlockPos posTempRight = PosHelper.getRight(pos, direction, 2);
        //front
        list.add(posTempFront);
        list.add(PosHelper.getLeft(posTempFront, direction));
        list.add(PosHelper.getLeft(posTempFront, direction, 2));
        list.add(PosHelper.getRight(posTempFront, direction));
        list.add(PosHelper.getRight(posTempFront, direction, 2));
        //behind
        list.add(posTempBehind);
        list.add(PosHelper.getLeft(posTempBehind, direction));
        list.add(PosHelper.getLeft(posTempBehind, direction, 2));
        list.add(PosHelper.getRight(posTempBehind, direction));
        list.add(PosHelper.getRight(posTempBehind, direction, 2));
        //left
        list.add(posTempLeft);
        list.add(PosHelper.getBehind(posTempLeft, direction));
        list.add(PosHelper.getFront(posTempLeft, direction));
        //right
        list.add(posTempRight);
        list.add(PosHelper.getBehind(posTempRight, direction));
        list.add(PosHelper.getFront(posTempRight, direction));

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
        list.add(PosHelper.getLeft(posTempFront, direction));
        list.add(PosHelper.getRight(posTempFront, direction));
        list.add(PosHelper.getBehind(PosHelper.getLeft(posTempFront, direction), direction));
        list.add(PosHelper.getBehind(PosHelper.getRight(posTempFront, direction), direction));
        list.add(posTempBehind);
        list.add(PosHelper.getLeft(posTempBehind, direction));
        list.add(PosHelper.getRight(posTempBehind, direction));

        list.add(PosHelper.getFront(pos, direction, 2));
        list.add(PosHelper.getBehind(pos, direction, 2));
        list.add(PosHelper.getLeft(pos, direction, 2));
        list.add(PosHelper.getRight(pos, direction, 2));

        return list;
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

    private void placeBlock(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, List<BlockStateProvider> states)
    {
        int randomSpawn = RandomUtil.getRandomPositiveIntInRange(this.numberA, rand);
        int randomInt = RandomUtil.getRandomPositiveIntInRange(states.size(), rand);
        BlockState state;
        if (randomSpawn == 1)
        {
            this.countInFlag += 1;
            if (this.countInFlag > 6)
            {
                this.flag = true;
            }
        }
        else if (!this.flag)
        {
            try
            {
                state = states.get(randomInt).getState(rand, pos);
            } catch (Exception ignored)
            {
                try
                {
                    state = states.getFirst().getState(rand, pos);
                } catch (Exception ignored2)
                {
                    throw new RuntimeException("states list must contain at least 1 state");
                }
            }
            worldIn.setBlock(pos, state, 2);
        }
    }
}
