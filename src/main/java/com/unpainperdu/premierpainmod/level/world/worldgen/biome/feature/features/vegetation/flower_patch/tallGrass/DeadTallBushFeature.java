package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation.flower_patch.tallGrass;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DeadTallBushFeature extends AbstractTallGrassFeature
{

    public DeadTallBushFeature(Codec<NoneFeatureConfiguration> pCodec)
    {
        super(pCodec, 2, 5, 2, BlockRegister.DEAD_TALL_BUSH.get(), BlockTags.SAND);
    }
}
