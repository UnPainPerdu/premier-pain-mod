package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation.flower_patch.tallGrass;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class SkySpearsFeature extends AbstractTallGrassFeature
{
    public SkySpearsFeature(Codec<NoneFeatureConfiguration> pCodec)
    {
        super(pCodec, 3, 9, 2, BlockRegister.SKY_SPEARS.get(), BlockTags.DIRT);
    }
}
