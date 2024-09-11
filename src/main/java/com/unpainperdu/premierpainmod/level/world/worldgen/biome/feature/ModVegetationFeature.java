package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature;

import com.google.common.collect.ImmutableList;
import com.unpainperdu.premierpainmod.util.register.FeatureRegister;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class ModVegetationFeature
{
    //flower
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_RUINS_FLOWER = ModFeatureUtil.createKey("patch_ruins_flower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_CIVILIZATIONS_FLOWER = ModFeatureUtil.createKey("patch_civilizations_flower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_CURIOSITY_FLOWER = ModFeatureUtil.createKey("patch_curiosity_flower");
    //dead bush
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DEAD_RUINS_FLOWER = ModFeatureUtil.createKey("patch_dead_ruins_flower");
    //tree
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREE_MANGROVE = ModFeatureUtil.createKey("tree_mangrove");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREE_OAK_SWAMP = ModFeatureUtil.createKey("tree_oak_swamp");
    //misc
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERED_CACTUS = ModFeatureUtil.createKey("flowered_cactus");
    //tall grass
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKY_SPEARS = ModFeatureUtil.createKey("sky_spears");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_TALL_BUSH = ModFeatureUtil.createKey("dead_tall_bush");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> pContext)
    {
        //vanilla thing
        HolderGetter<PlacedFeature> holdergetter1 = pContext.lookup(Registries.PLACED_FEATURE);
        Holder<PlacedFeature> holder22 = holdergetter1.getOrThrow(TreePlacements.TALL_MANGROVE_CHECKED);
        Holder<PlacedFeature> holder29 = holdergetter1.getOrThrow(TreePlacements.MANGROVE_CHECKED);
        //flower
        FeatureUtils.register(pContext, ModVegetationFeature.PATCH_RUINS_FLOWER, FeatureRegister.PATCH_RUINS_FLOWER.get(), NoneFeatureConfiguration.INSTANCE);
        FeatureUtils.register(pContext, ModVegetationFeature.PATCH_CIVILIZATIONS_FLOWER, FeatureRegister.PATCH_CIVILIZATIONS_FLOWER.get(), NoneFeatureConfiguration.INSTANCE);
        FeatureUtils.register(pContext, ModVegetationFeature.PATCH_CURIOSITY_FLOWER, FeatureRegister.PATCH_CURIOSITY_FLOWER.get(), NoneFeatureConfiguration.INSTANCE);
        //dead bush
        FeatureUtils.register(pContext, ModVegetationFeature.PATCH_DEAD_RUINS_FLOWER, FeatureRegister.PATCH_DEAD_RUINS_FLOWER.get(), NoneFeatureConfiguration.INSTANCE);
        //tree
        FeatureUtils.register(pContext, TREE_MANGROVE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder22, 0.85F)), holder29));
        FeatureUtils.register(pContext, TREE_OAK_SWAMP, Feature.TREE, createStraightBlobTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 5, 3, 0, 3).decorators(ImmutableList.of(new LeaveVineDecorator(0.25F))).build());
        //misc
        FeatureUtils.register(pContext, ModVegetationFeature.FLOWERED_CACTUS, FeatureRegister.FLOWERED_CACTUS.get(), NoneFeatureConfiguration.INSTANCE);
        //tall grass
        FeatureUtils.register(pContext, ModVegetationFeature.SKY_SPEARS, FeatureRegister.SKY_SPEARS.get(), NoneFeatureConfiguration.INSTANCE);
        FeatureUtils.register(pContext, ModVegetationFeature.DEAD_TALL_BUSH, FeatureRegister.DEAD_TALL_BUSH.get(), NoneFeatureConfiguration.INSTANCE);
    }

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(
            Block pLogBlock, Block pLeavesBlock, int pBaseHeight, int pHeightRandA, int pHeightRandB, int pRadius
    ) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(pLogBlock),
                new StraightTrunkPlacer(pBaseHeight, pHeightRandA, pHeightRandB),
                BlockStateProvider.simple(pLeavesBlock),
                new BlobFoliagePlacer(ConstantInt.of(pRadius), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }

}

