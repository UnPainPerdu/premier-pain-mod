package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation.flower_patch;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class CuriosityFlowerPatchFeature extends AbstractFlowerPatch
{

    public CuriosityFlowerPatchFeature(Codec<NoneFeatureConfiguration> pCodec)
    {
        super(pCodec,1, 3 ,10);
    }

    @Override
    protected void generateFlower(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        worldIn.setBlock(pos, BlockRegister.CURIOSITY_FLOWER.get().defaultBlockState(), 2);
    }
}
