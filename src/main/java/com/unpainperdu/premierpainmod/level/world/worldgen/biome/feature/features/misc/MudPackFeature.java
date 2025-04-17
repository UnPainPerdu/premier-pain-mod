package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.misc;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.ModFeatureUtils;
import com.unpainperdu.premierpainmod.util.tool_kit.DirectionHelper;
import com.unpainperdu.premierpainmod.util.tool_kit.PosHelper;
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

public class MudPackFeature extends Feature<NoneFeatureConfiguration>
{

    public MudPackFeature(Codec<NoneFeatureConfiguration> pCodec)
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
        mudPackGenerator(worldIn,chunkGenerator,rand,pos,config, direction);
        return true;
    }

    private void mudPackGenerator(WorldGenLevel worldIn, ChunkGenerator chunkGenerator, RandomSource rand, BlockPos pos, NoneFeatureConfiguration config,Direction direction)
    {
        Block block = worldIn.getBlockState(pos.below()).getBlock();
        if(!(block instanceof MudBlock))
        {
            return;
        }
        ArrayList<BlockPos> allPosList = new ArrayList<>();
        ArrayList<BlockPos> posListLayer1 = PosHelper.getRandomPosWithSameY(pos, 7,12, 1, rand);
        posListLayer1 = PosHelper.setAllPosToTheGround(posListLayer1, worldIn);

        for(BlockPos pos1 : posListLayer1)
        {
            ModFeatureUtils.generateBlock(worldIn, pos1, rand, Arrays.asList(Blocks.PACKED_MUD.defaultBlockState(), Blocks.MUD_BRICKS.defaultBlockState()),true);
            allPosList.add(pos1);
        }

        ArrayList<BlockPos> posListLayer2 = PosHelper.getRandomPosWithSameY(pos.above(), 3,7, 1, rand);
        posListLayer2 = PosHelper.setAllPosToTheGround(posListLayer2, worldIn);

        for(BlockPos pos1 : posListLayer2)
        {
            ModFeatureUtils.generateBlock(worldIn, pos1, rand, Arrays.asList(Blocks.PACKED_MUD.defaultBlockState(), Blocks.MUD_BRICKS.defaultBlockState()),true);
            allPosList.add(pos1);
        }

        ArrayList<BlockPos> posListLayer3 = PosHelper.getRandomPosWithSameY(pos.above(), 1,2, 1, rand);
        posListLayer3 = PosHelper.setAllPosToTheGround(posListLayer3, worldIn);

        for(BlockPos pos1 : posListLayer3)
        {
            ModFeatureUtils.generateBlock(worldIn, pos1, rand, Arrays.asList(Blocks.PACKED_MUD.defaultBlockState(), Blocks.MUD_BRICKS.defaultBlockState()),true);
            allPosList.add(pos1);
        }

        for(BlockPos pos1 : allPosList)
        {
            ModFeatureUtils.placeBlockAroundOne(worldIn, pos1, rand, Arrays.asList(Blocks.PACKED_MUD.defaultBlockState(), Blocks.MUD_BRICKS.defaultBlockState()), true);
        }
    }
}
