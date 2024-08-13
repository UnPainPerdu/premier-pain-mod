package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature;

import com.unpainperdu.premierpainmod.util.register.FeatureRegister;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ModMiscOverworldFeatures
{
    public static final ResourceKey<ConfiguredFeature<?, ?>> VILLAGER_STATUE_RUINS = ModFeatureUtil.createKey("villager_statue_ruins");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BUSH_AND_STONE = ModFeatureUtil.createKey("bush_and_stone");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> pContext)
    {
        FeatureUtils.register(pContext, ModMiscOverworldFeatures.VILLAGER_STATUE_RUINS, FeatureRegister.VILLAGER_STATUE_RUINS.get(), NoneFeatureConfiguration.INSTANCE);
        FeatureUtils.register(pContext, ModMiscOverworldFeatures.BUSH_AND_STONE, FeatureRegister.BUSH_AND_STONE.get(), NoneFeatureConfiguration.INSTANCE);
    }


}
