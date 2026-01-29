package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.feature.placement;

import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.feature.features.ModMiscOverworldFeatures;
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
    public static final ResourceKey<PlacedFeature> FOREST_VILLAGER_STATUE_RUINS = ModPlacementUtil.createKey("forest_villager_statue_ruins");
    public static final ResourceKey<PlacedFeature> BUSH_AND_ROCK = ModPlacementUtil.createKey("bush_and_rock");
    public static final ResourceKey<PlacedFeature> HOUSE_FOUNDATION_RUINS = ModPlacementUtil.createKey("house_foundation_ruins");
    public static final ResourceKey<PlacedFeature> VILLAGER_PILLAR_RUINS_DESERT = ModPlacementUtil.createKey("villager_pillar_ruins_desert");
    public static final ResourceKey<PlacedFeature> MUD_PACK = ModPlacementUtil.createKey("mud_pack");
    public static final ResourceKey<PlacedFeature> VILLAGER_TOTEM = ModPlacementUtil.createKey("villager_totem");
    public static final ResourceKey<PlacedFeature> SWAMP_WEEPING_WILLOW_OUTSIDE_DRY_TOILET = ModPlacementUtil.createKey("swamp_weeping_willow_outside_dry_toilet");
    public static final ResourceKey<PlacedFeature> SWAMP_MANGROVE_OUTSIDE_DRY_TOILET = ModPlacementUtil.createKey("swamp_mangrove_outside_dry_toilet");

    public static void bootstrap(BootstrapContext<PlacedFeature> pContext)
    {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = pContext.lookup(Registries.CONFIGURED_FEATURE);

        final Holder<ConfiguredFeature<?, ?>> FOREST_VILLAGER_STATUE_RUINS_HOLDER = holdergetter.getOrThrow(ModMiscOverworldFeatures.FOREST_VILLAGER_STATUE_RUINS);
        register(pContext, FOREST_VILLAGER_STATUE_RUINS, FOREST_VILLAGER_STATUE_RUINS_HOLDER, RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        final Holder<ConfiguredFeature<?, ?>> BUSH_AND_ROCK_HOLDER = holdergetter.getOrThrow(ModMiscOverworldFeatures.BUSH_AND_ROCK);
        register(pContext, BUSH_AND_ROCK, BUSH_AND_ROCK_HOLDER, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        final Holder<ConfiguredFeature<?, ?>> HOUSE_FOUNDATION_RUINS_HOLDER = holdergetter.getOrThrow(ModMiscOverworldFeatures.HOUSE_FOUNDATION_RUINS);
        register(pContext, HOUSE_FOUNDATION_RUINS, HOUSE_FOUNDATION_RUINS_HOLDER, RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        final Holder<ConfiguredFeature<?, ?>> VILLAGER_PILLAR_RUINS_DESERT_HOLDER = holdergetter.getOrThrow(ModMiscOverworldFeatures.VILLAGER_PILLAR_RUINS_DESERT);
        register(pContext, VILLAGER_PILLAR_RUINS_DESERT, VILLAGER_PILLAR_RUINS_DESERT_HOLDER, RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        final Holder<ConfiguredFeature<?, ?>> MUD_PACK_HOLDER = holdergetter.getOrThrow(ModMiscOverworldFeatures.MUD_PACK);
        register(pContext, MUD_PACK, MUD_PACK_HOLDER, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        final Holder<ConfiguredFeature<?, ?>> VILLAGER_TOTEM_HOLDER = holdergetter.getOrThrow(ModMiscOverworldFeatures.VILLAGER_TOTEM);
        register(pContext, VILLAGER_TOTEM, VILLAGER_TOTEM_HOLDER, RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        final Holder<ConfiguredFeature<?, ?>> SWAMP_WEEPING_WILLOW_OUTSIDE_DRY_TOILET_HOLDER = holdergetter.getOrThrow(ModMiscOverworldFeatures.SWAMP_WEEPING_WILLOW_OUTSIDE_DRY_TOILET);
        register(pContext, SWAMP_WEEPING_WILLOW_OUTSIDE_DRY_TOILET, SWAMP_WEEPING_WILLOW_OUTSIDE_DRY_TOILET_HOLDER, RarityFilter.onAverageOnceEvery(45), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        final Holder<ConfiguredFeature<?, ?>> SWAMP_MANGROVE_OUTSIDE_DRY_TOILET_HOLDER = holdergetter.getOrThrow(ModMiscOverworldFeatures.SWAMP_MANGROVE_OUTSIDE_DRY_TOILET);
        register(pContext, SWAMP_MANGROVE_OUTSIDE_DRY_TOILET, SWAMP_MANGROVE_OUTSIDE_DRY_TOILET_HOLDER, RarityFilter.onAverageOnceEvery(60), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

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
