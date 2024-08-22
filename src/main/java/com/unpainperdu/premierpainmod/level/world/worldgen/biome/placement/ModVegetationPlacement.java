package com.unpainperdu.premierpainmod.level.world.worldgen.biome.placement;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.ModVegetationFeature;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModVegetationPlacement
{
    //flower
    public static final ResourceKey<PlacedFeature> PATCH_RUINS_FLOWER = ModPlacementUtil.createKey("patch_ruins_flower");
    public static final ResourceKey<PlacedFeature> PATCH_CIVILIZATIONS_FLOWER = ModPlacementUtil.createKey("patch_civilizations_flower");
    //dead bush
    public static final ResourceKey<PlacedFeature> PATCH_DEAD_RUINS_FLOWER = ModPlacementUtil.createKey("patch_dead_ruins_flower");

    public static void bootstrap(BootstrapContext<PlacedFeature> pContext)
    {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureGetter = pContext.lookup(Registries.CONFIGURED_FEATURE);

        //flower
        final Holder<ConfiguredFeature<?, ?>> PATCH_RUINS_FLOWER_HOLDER = configuredFeatureGetter.getOrThrow(ModVegetationFeature.PATCH_RUINS_FLOWER);
        register(pContext, ModVegetationPlacement.PATCH_RUINS_FLOWER, PATCH_RUINS_FLOWER_HOLDER, RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        final Holder<ConfiguredFeature<?, ?>> PATCH_CIVILIZATIONS_FLOWER_HOLDER = configuredFeatureGetter.getOrThrow(ModVegetationFeature.PATCH_CIVILIZATIONS_FLOWER);
        register(pContext, ModVegetationPlacement.PATCH_CIVILIZATIONS_FLOWER, PATCH_CIVILIZATIONS_FLOWER_HOLDER, RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        //dead bush
        final Holder<ConfiguredFeature<?, ?>> PATCH_DEAD_RUINS_FLOWER_HOLDER = configuredFeatureGetter.getOrThrow(ModVegetationFeature.PATCH_DEAD_RUINS_FLOWER);
        register(pContext, ModVegetationPlacement.PATCH_DEAD_RUINS_FLOWER, PATCH_DEAD_RUINS_FLOWER_HOLDER, RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


    }

    protected static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedFeatureKey, Holder<ConfiguredFeature<?, ?>> configuredFeature, PlacementModifier... modifiers)
    {
        register(context, placedFeatureKey, configuredFeature, List.of(modifiers));
    }

    protected static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedFeatureKey, Holder<ConfiguredFeature<?, ?>> configuredFeature, List<PlacementModifier> modifiers)
    {
        context.register(placedFeatureKey, new PlacedFeature(configuredFeature, modifiers));
    }
}
