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
    public static final ResourceKey<PlacedFeature> PATCH_CURIOSITY_FLOWER = ModPlacementUtil.createKey("patch_curiosity_flower");
    //dead bush
    public static final ResourceKey<PlacedFeature> PATCH_DEAD_RUINS_FLOWER = ModPlacementUtil.createKey("patch_dead_ruins_flower");
    //tree
    public static final ResourceKey<PlacedFeature> TREE_MANGROVE = ModPlacementUtil.createKey("tree_mangrove");
    public static final ResourceKey<PlacedFeature> TREE_OAK_SWAMP = ModPlacementUtil.createKey("tree_oak_swamp");
    //misc
    public static final ResourceKey<PlacedFeature> FLOWERED_CACTUS = ModPlacementUtil.createKey("flowered_cactus");
    //tall grass
    public static final ResourceKey<PlacedFeature> PATCH_SKY_SPEARS = ModPlacementUtil.createKey("patch_sky_spears");
    public static final ResourceKey<PlacedFeature> PATCH_DEAD_TALL_BUSH = ModPlacementUtil.createKey("patch_dead_tall_bush");

    public static void bootstrap(BootstrapContext<PlacedFeature> pContext)
    {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureGetter = pContext.lookup(Registries.CONFIGURED_FEATURE);

        //flower
        final Holder<ConfiguredFeature<?, ?>> PATCH_RUINS_FLOWER_HOLDER = configuredFeatureGetter.getOrThrow(ModVegetationFeature.PATCH_RUINS_FLOWER);
        register(pContext, ModVegetationPlacement.PATCH_RUINS_FLOWER, PATCH_RUINS_FLOWER_HOLDER, RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        final Holder<ConfiguredFeature<?, ?>> PATCH_CIVILIZATIONS_FLOWER_HOLDER = configuredFeatureGetter.getOrThrow(ModVegetationFeature.PATCH_CIVILIZATIONS_FLOWER);
        register(pContext, ModVegetationPlacement.PATCH_CIVILIZATIONS_FLOWER, PATCH_CIVILIZATIONS_FLOWER_HOLDER, RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        final Holder<ConfiguredFeature<?, ?>> PATCH_CURIOSITY_FLOWER_HOLDER = configuredFeatureGetter.getOrThrow(ModVegetationFeature.PATCH_CURIOSITY_FLOWER);
        register(pContext, ModVegetationPlacement.PATCH_CURIOSITY_FLOWER, PATCH_CURIOSITY_FLOWER_HOLDER, NoiseThresholdCountPlacement.of(-0.8, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        //dead bush
        final Holder<ConfiguredFeature<?, ?>> PATCH_DEAD_RUINS_FLOWER_HOLDER = configuredFeatureGetter.getOrThrow(ModVegetationFeature.PATCH_DEAD_RUINS_FLOWER);
        register(pContext, ModVegetationPlacement.PATCH_DEAD_RUINS_FLOWER, PATCH_DEAD_RUINS_FLOWER_HOLDER, RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        //tree
        final Holder<ConfiguredFeature<?, ?>> TREE_MANGROVE_HOLDER = configuredFeatureGetter.getOrThrow(ModVegetationFeature.TREE_MANGROVE);
        register(pContext, ModVegetationPlacement.TREE_MANGROVE, TREE_MANGROVE_HOLDER, RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        final Holder<ConfiguredFeature<?, ?>> TREE_OAK_SWAMP_HOLDER = configuredFeatureGetter.getOrThrow(ModVegetationFeature.TREE_OAK_SWAMP);
        register(
                pContext,
                ModVegetationPlacement.TREE_OAK_SWAMP,
                TREE_OAK_SWAMP_HOLDER,
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                SurfaceWaterDepthFilter.forMaxDepth(2),
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                BiomeFilter.biome());
        //misc
        final Holder<ConfiguredFeature<?, ?>> FLOWERED_CACTUS_HOLDER = configuredFeatureGetter.getOrThrow(ModVegetationFeature.FLOWERED_CACTUS);
        register(pContext, ModVegetationPlacement.FLOWERED_CACTUS, FLOWERED_CACTUS_HOLDER, RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        //tall grass
        final Holder<ConfiguredFeature<?, ?>> SKY_SPEARS_HOLDER = configuredFeatureGetter.getOrThrow(ModVegetationFeature.SKY_SPEARS);
        register(pContext, ModVegetationPlacement.PATCH_SKY_SPEARS, SKY_SPEARS_HOLDER, RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        final Holder<ConfiguredFeature<?, ?>> DEAD_TALL_BUSH_HOLDER = configuredFeatureGetter.getOrThrow(ModVegetationFeature.DEAD_TALL_BUSH);
        register(pContext, ModVegetationPlacement.PATCH_DEAD_TALL_BUSH, DEAD_TALL_BUSH_HOLDER, RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


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
