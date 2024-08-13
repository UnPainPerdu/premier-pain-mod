package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class ModFeatureUtil
{
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> pContext)
    {
        ModMiscOverworldFeatures.bootstrap(pContext);
        ModVegetationFeature.bootstrap(pContext);
    }
    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name)
    {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, name));
    }
}
