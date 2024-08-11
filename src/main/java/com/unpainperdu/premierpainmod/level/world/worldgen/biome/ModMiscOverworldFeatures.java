package com.unpainperdu.premierpainmod.level.world.worldgen.biome;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.FeatureRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ModMiscOverworldFeatures
{
    public static final ResourceKey<ConfiguredFeature<?, ?>> VILLAGER_STATUE_RUINS = createKey("villager_statue_ruins");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> pContext)
    {
        FeatureUtils.register(pContext, ModMiscOverworldFeatures.VILLAGER_STATUE_RUINS, FeatureRegister.VILLAGER_STATUE_RUINS.get(), NoneFeatureConfiguration.INSTANCE);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name)
    {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, name));
    }
}
