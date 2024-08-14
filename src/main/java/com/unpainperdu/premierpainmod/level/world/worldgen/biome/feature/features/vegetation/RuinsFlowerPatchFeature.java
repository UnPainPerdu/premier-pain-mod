package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation.flower_patch.AbstractFlowerPatch;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class RuinsFlowerPatchFeature extends AbstractFlowerPatch
{

    public RuinsFlowerPatchFeature(Codec<NoneFeatureConfiguration> pCodec)
    {
        super(pCodec,5, 10 ,5);
    }

    @Override
    protected void generateFlower(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        worldIn.setBlock(pos, BlockRegister.RUINS_FLOWER.get().defaultBlockState(), 2);
    }
}
