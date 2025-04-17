package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation.flower_patch;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class CivilizationsFlowerPatchFeature extends AbstractFlowerPatch
{
    public CivilizationsFlowerPatchFeature(Codec<NoneFeatureConfiguration> pCodec)
    {
        super(pCodec,2,5,2);
    }

    @Override
    protected void generateFlower(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        int randomHeight = RandomUtil.getRandomPositiveIntInRange(5, rand) + 1;
        for (int i = 0; i < randomHeight; i++)
        {
            worldIn.setBlock(pos, BlockRegister.CIVILIZATIONS_FLOWER.get().defaultBlockState(), 2);
            pos = pos.above();
            Block block = worldIn.getBlockState(pos).getBlock();
            if (!(block instanceof AirBlock))
            {
                break;
            }
        }
    }
}
