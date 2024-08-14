package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature;

import com.unpainperdu.premierpainmod.util.register.FeatureRegister;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ModVegetationFeature
{
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_RUINS_FLOWER = ModFeatureUtil.createKey("patch_ruins_flower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_CIVILIZATIONS_FLOWER = ModFeatureUtil.createKey("patch_civilizations_flower");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> pContext)
    {
        FeatureUtils.register(pContext, ModVegetationFeature.PATCH_RUINS_FLOWER, FeatureRegister.PATCH_RUINS_FLOWER.get(), NoneFeatureConfiguration.INSTANCE);
        FeatureUtils.register(pContext, ModVegetationFeature.PATCH_CIVILIZATIONS_FLOWER, FeatureRegister.PATCH_CIVILIZATIONS_FLOWER.get(), NoneFeatureConfiguration.INSTANCE);

    }
}
