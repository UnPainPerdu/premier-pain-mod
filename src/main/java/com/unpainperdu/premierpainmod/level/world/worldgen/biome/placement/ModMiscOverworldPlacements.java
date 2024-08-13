package com.unpainperdu.premierpainmod.level.world.worldgen.biome.placement;

import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.ModMiscOverworldFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModMiscOverworldPlacements
{
    public static final ResourceKey<PlacedFeature> VILLAGER_STATUE_RUINS = ModPlacementUtil.createKey("villager_statue_ruins");
    public static final ResourceKey<PlacedFeature> BUSH_AND_STONE = ModPlacementUtil.createKey("bush_and_stone");

    public static void bootstrap(BootstrapContext<PlacedFeature> pContext)
    {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = pContext.lookup(Registries.CONFIGURED_FEATURE);

        final Holder<ConfiguredFeature<?, ?>> VILLAGER_STATUE_RUINS_HOLDER = holdergetter.getOrThrow(ModMiscOverworldFeatures.VILLAGER_STATUE_RUINS);
        final Holder<ConfiguredFeature<?, ?>> BUSH_AND_STONE_HOLDER = holdergetter.getOrThrow(ModMiscOverworldFeatures.BUSH_AND_STONE);

        register(pContext, VILLAGER_STATUE_RUINS, VILLAGER_STATUE_RUINS_HOLDER, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        register(pContext, BUSH_AND_STONE, BUSH_AND_STONE_HOLDER, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
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
