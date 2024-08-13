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

public class HouseFoundationRuinsFeature extends Feature<NoneFeatureConfiguration>
{
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

        int randomChanceSpawn = ModFeatureUtils.getRandomPositiveIntInRange(2, rand);
        if (randomChanceSpawn == 1 || ModFeatureUtils.isFlying(pos, worldIn))
        {
           return false ;
        }
        generateHouseFoundationRuins(worldIn, chunkGenerator, rand, pos, config, direction);
        return true;
    }

    private void generateHouseFoundationRuins(WorldGenLevel worldIn, ChunkGenerator chunkGenerator, RandomSource rand, BlockPos pos, NoneFeatureConfiguration config,Direction direction)
    {
        firstLevel(worldIn, rand, pos, direction);
    }

    private BlockPos firstLevel(WorldGenLevel worldIn , RandomSource rand, BlockPos pos ,Direction direction)
    {
        return pos;
    }
}
