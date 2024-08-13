package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.misc;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.ModFeatureUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BushAndStoneFeature extends Feature<NoneFeatureConfiguration>
{
    public BushAndStoneFeature(Codec<NoneFeatureConfiguration> pCodec)
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

        bushAndStoneGenerator(worldIn,chunkGenerator,rand,pos,config, direction);

        return true;
    }

    private void bushAndStoneGenerator(WorldGenLevel worldIn, ChunkGenerator chunkGenerator, RandomSource rand, BlockPos pos, NoneFeatureConfiguration config,Direction direction)
    {
        Block block = worldIn.getBlockState(pos.below()).getBlock();
        if(block instanceof GrassBlock)
        {
            int nbrBock = ModFeatureUtils.getRandomPositiveIntInRange(25,rand);
            ArrayList<BlockPos> posList = new ArrayList<>();
            for (int i = 4; i <= nbrBock; i++)
            {
                posList.add(pos);
                BlockPos posTemp = getRandomPosNextToPos(pos, rand);
                if(!ModFeatureUtils.isPosInList(posTemp, posList))
                {
                    pos = posTemp;
                }
            }
            int i = 0;
            for (BlockPos pos1 : posList)
            {
                int forFlag1 = 6;
                BlockPos belowPos = pos1;
                for (int j = 0; j < forFlag1; j++)
                {
                    belowPos = belowPos.below();
                    Block blockBelow = worldIn.getBlockState(belowPos).getBlock();
                    if(blockBelow instanceof AirBlock)
                    {
                        if (!ModFeatureUtils.isPosInList(belowPos, posList))
                        {
                            posList.set(i, belowPos);
                        }
                    }
                    else
                    {
                        j = 6;
                    }
                }
                i ++;
            }
            for (BlockPos pos1 : posList)
            {
                stoneBlockGenerator(pos1, worldIn,rand,direction);
            }
            for (BlockPos pos1 : posList)
            {
                postGeneration(pos1, worldIn, rand ,direction);
            }
        }
    }


    private void stoneBlockGenerator(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        int random = ModFeatureUtils.getRandomPositiveIntInRange(2,rand);
        if (random == 0)
        {
            worldIn.setBlock(pos, Blocks.STONE.defaultBlockState(),2);
        }
        else
        {
            worldIn.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(),2);
        }
    }
    private void oakLeaveGenerator(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        worldIn.setBlock(pos, Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.PERSISTENT, true),2);
    }

    private BlockPos getRandomPosNextToPos(BlockPos pos, RandomSource rand)
    {
        int random = ModFeatureUtils.getRandomPositiveIntInRange(5,rand);
        switch (random)
        {
            case 0 :
            {
                pos = pos.east();
                break;
            }
            case 1 :
            {
                pos = pos.west();
                break;
            }
            case 2 :
            {
                pos = pos.south();
                break;
            }
            case 3 :
            {
                pos = pos.north();
                break;
            }
            default :
            {
                pos = pos.above();
                break;
            }
        }
        return pos;
    }
    private void postGeneration(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        List<BlockPos> placementPosList = Arrays.asList(pos.above(), pos.east(), pos.west(), pos.north(), pos.south());
        ArrayList<BlockPos> tempPosList = new ArrayList<>();
        for (BlockPos pos1 : placementPosList)
        {
            Block block = worldIn.getBlockState(pos1).getBlock();
            if(block instanceof AirBlock)
            {
                tempPosList.add(pos1);
            }
        }
        for(BlockPos pos1 : tempPosList)
        {
            int random = ModFeatureUtils.getRandomPositiveIntInRange(20, rand);
            if(random<7)
            {
                stoneBlockGenerator(pos1, worldIn, rand, direction);
            }
            else if (random<16)
            {
                oakLeaveGenerator(pos1, worldIn, rand, direction);
            }
        }
    }
}
