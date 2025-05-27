package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature;

import com.google.common.collect.ImmutableList;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.vegetation.patch.PatchConfiguration;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.folliage_placer.AchioteFoliagePlacer;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.folliage_placer.MorichePalmFoliagePlacer;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.folliage_placer.MountainCurrantFoliagePlacer;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.trunk_placer.AchioteTrunkPlacer;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.trunk_placer.MorichePalmTrunkPlacer;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.trunk_placer.MountainCurrantTrunkPlacer;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.FeatureRegister;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
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
        //tall_flower
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_FALLING_HELICON_FLOWER = ModFeatureUtil.createKey("patch_falling_helicon_flower");
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> OLD_WILD_WHEAT = ModFeatureUtil.createKey("old_wild_wheat");
    //tree
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOUNTAIN_CURRANT = ModFeatureUtil.createKey("mountain_currant");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MORICHE_PALM = ModFeatureUtil.createKey("moriche_palm");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ACHIOTE = ModFeatureUtil.createKey("achiote");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> pContext)
    {
        //vanilla thing
        HolderGetter<PlacedFeature> holdergetter1 = pContext.lookup(Registries.PLACED_FEATURE);
        Holder<PlacedFeature> holder22 = holdergetter1.getOrThrow(TreePlacements.TALL_MANGROVE_CHECKED);
        Holder<PlacedFeature> holder29 = holdergetter1.getOrThrow(TreePlacements.MANGROVE_CHECKED);
        //flower
        FeatureUtils.register(pContext, ModVegetationFeature.PATCH_RUINS_FLOWER, FeatureRegister.BASIC_VEGETATION_PATCH.get(),
                new PatchConfiguration.Builder()
                        .spread(5)
                        .minFlowerNumber(5)
                        .maxFlowerNumber(10)
                        .states(List.of(BlockStateProvider.simple(BlockRegister.RUINS_FLOWER.get().defaultBlockState())))
                        .groundAllowed(List.of(BlockTags.DIRT))
                        .builder()
        );

        FeatureUtils.register(pContext, ModVegetationFeature.PATCH_CIVILIZATIONS_FLOWER, FeatureRegister.GROWING_ABOVE_VEGETATION_PATCH.get(),
                new PatchConfiguration.Builder()
                        .spread(2)
                        .minFlowerNumber(2)
                        .maxFlowerNumber(5)
                        .states(List.of(BlockStateProvider.simple(BlockRegister.CIVILIZATIONS_FLOWER.get().defaultBlockState())))
                        .groundAllowed(List.of(BlockTags.DIRT))
                        .builder()
        );
        FeatureUtils.register(pContext, ModVegetationFeature.PATCH_CURIOSITY_FLOWER, FeatureRegister.BASIC_VEGETATION_PATCH.get(),
                new PatchConfiguration.Builder()
                        .spread(10)
                        .minFlowerNumber(1)
                        .maxFlowerNumber(3)
                        .states(List.of(BlockStateProvider.simple(BlockRegister.CURIOSITY_FLOWER.get().defaultBlockState())))
                        .groundAllowed(List.of(BlockTags.DIRT))
                        .builder()
        );
            //tall_flower
        FeatureUtils.register(pContext, ModVegetationFeature.PATCH_FALLING_HELICON_FLOWER, FeatureRegister.TALL_VEGETATION_PATCH.get(),
                new PatchConfiguration.Builder()
                        .spread(4)
                        .minFlowerNumber(4)
                        .maxFlowerNumber(15)
                        .states(List.of(BlockStateProvider.simple(BlockRegister.FALLING_HELICON_FLOWER.get().defaultBlockState())))
                        .groundAllowed(List.of(BlockTags.DIRT))
                        .builder()
        );
        //dead bush
        FeatureUtils.register(pContext, ModVegetationFeature.PATCH_DEAD_RUINS_FLOWER, FeatureRegister.BASIC_VEGETATION_PATCH.get(),
                new PatchConfiguration.Builder()
                    .spread(5)
                    .minFlowerNumber(5)
                    .maxFlowerNumber(10)
                    .states(List.of(BlockStateProvider.simple(BlockRegister.DEAD_RUINS_FLOWER.get().defaultBlockState())))
                    .groundAllowed(List.of(BlockTags.DIRT, BlockTags.SAND))
                    .builder()
        );
        //tree
        FeatureUtils.register(pContext, TREE_MANGROVE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder22, 0.85F)), holder29));
        FeatureUtils.register(pContext, TREE_OAK_SWAMP, Feature.TREE, createStraightBlobTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 5, 3, 0, 3).decorators(ImmutableList.of(new LeaveVineDecorator(0.25F))).build());
        //misc
        FeatureUtils.register(pContext, ModVegetationFeature.FLOWERED_CACTUS, FeatureRegister.FLOWERED_CACTUS.get(), NoneFeatureConfiguration.INSTANCE);
        //tall grass
        FeatureUtils.register(pContext, ModVegetationFeature.SKY_SPEARS, FeatureRegister.TALL_VEGETATION_PATCH.get(),
                new PatchConfiguration.Builder()
                        .spread(2)
                        .minFlowerNumber(7)
                        .maxFlowerNumber(11)
                        .states(List.of(BlockStateProvider.simple(BlockRegister.SKY_SPEARS.get().defaultBlockState())))
                        .groundAllowed(List.of(BlockTags.DIRT))
                        .builder()
        );
        FeatureUtils.register(pContext, ModVegetationFeature.DEAD_TALL_BUSH, FeatureRegister.TALL_VEGETATION_PATCH.get(),
                new PatchConfiguration.Builder()
                        .spread(2)
                        .minFlowerNumber(2)
                        .maxFlowerNumber(5)
                        .states(List.of(BlockStateProvider.simple(BlockRegister.DEAD_TALL_BUSH.get().defaultBlockState())))
                        .groundAllowed(List.of(BlockTags.DIRT, BlockTags.SAND))
                        .builder()
        );
        FeatureUtils.register(pContext, ModVegetationFeature.OLD_WILD_WHEAT, FeatureRegister.TALL_VEGETATION_PATCH.get(),
                new PatchConfiguration.Builder()
                        .spread(1)
                        .minFlowerNumber(1)
                        .maxFlowerNumber(5)
                        .states(List.of(BlockStateProvider.simple(BlockRegister.OLD_WILD_WHEAT.get().defaultBlockState())))
                        .groundAllowed(List.of(BlockTags.DIRT))
                        .builder()
        );
        //tree
        FeatureUtils.register(pContext, MOUNTAIN_CURRANT, Feature.TREE, createMountainCurrantTree(BlockRegister.MOUNTAIN_CURRANT_LOG.get(), BlockRegister.MOUNTAIN_CURRANT_LEAVES.get(), 3).build());
        FeatureUtils.register(pContext, MORICHE_PALM, Feature.TREE, createMorichePalmTree(BlockRegister.MORICHE_PALM_LOG.get(), BlockRegister.MORICHE_PALM_LEAVES.get()).build());
        FeatureUtils.register(pContext, ACHIOTE, Feature.TREE, createAchioteTree(BlockRegister.ACHIOTE_LOG.get(), BlockRegister.ACHIOTE_LEAVES.get()).build());
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

    private static TreeConfiguration.TreeConfigurationBuilder createMountainCurrantTree(
            Block pLogBlock, Block pLeavesBlock, int pRadius
    )
    {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(pLogBlock),
                new MountainCurrantTrunkPlacer(2, 1, 0),
                BlockStateProvider.simple(pLeavesBlock),
                new MountainCurrantFoliagePlacer(ConstantInt.of(pRadius), ConstantInt.of(0), 2),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }

    private static TreeConfiguration.TreeConfigurationBuilder createMorichePalmTree(
            Block pLogBlock, Block pLeavesBlock)
    {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(pLogBlock),
                new MorichePalmTrunkPlacer(13, 10, 7),
                BlockStateProvider.simple(pLeavesBlock),
                new MorichePalmFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 2),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }

    private static TreeConfiguration.TreeConfigurationBuilder createAchioteTree(
            Block pLogBlock, Block pLeavesBlock)
    {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(pLogBlock),
                new AchioteTrunkPlacer(3, 2, 2),
                BlockStateProvider.simple(pLeavesBlock),
                new AchioteFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 2),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }

}

