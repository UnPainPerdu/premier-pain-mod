package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome.feature.features;

import com.google.common.collect.ImmutableList;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.vegetation.patch.PatchConfiguration;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.decorator.FallingLeavesDecorator;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.folliage_placer.AchioteFoliagePlacer;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.folliage_placer.MorichePalmFoliagePlacer;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.folliage_placer.MountainCurrantFoliagePlacer;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.folliage_placer.WeepingWillowFoliagePlacer;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.trunk_placer.AchioteTrunkPlacer;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.trunk_placer.MorichePalmTrunkPlacer;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.trunk_placer.MountainCurrantTrunkPlacer;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.trunk_placer.WeepingWillowTrunkPlacer;
import com.unpainperdu.premierpainmod.util.register.FeatureRegister;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.block.WoodBlockEnum;
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> WEEPING_WILLOW = ModFeatureUtil.createKey("weeping_willow");
    //vanilla enhanced
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_1 = ModFeatureUtil.createKey("oak_1");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context)
    {
        //vanilla thing
        HolderGetter<PlacedFeature> holdergetter1 = context.lookup(Registries.PLACED_FEATURE);
        Holder<PlacedFeature> holder22 = holdergetter1.getOrThrow(TreePlacements.TALL_MANGROVE_CHECKED);
        Holder<PlacedFeature> holder29 = holdergetter1.getOrThrow(TreePlacements.MANGROVE_CHECKED);
        //patch
        //basic
        FeatureUtils.register(context, ModVegetationFeature.PATCH_RUINS_FLOWER, FeatureRegister.BASIC_VEGETATION_PATCH.get(),
                new PatchConfiguration.Builder()
                        .spread(5)
                        .minFlowerNumber(5)
                        .maxFlowerNumber(10)
                        .states(List.of(BlockStateProvider.simple(BlockRegister.RUINS_FLOWER.get().defaultBlockState())))
                        .groundAllowed(List.of(BlockTags.DIRT))
                        .builder()
        );
        FeatureUtils.register(context, ModVegetationFeature.PATCH_CURIOSITY_FLOWER, FeatureRegister.BASIC_VEGETATION_PATCH.get(),
                new PatchConfiguration.Builder()
                        .spread(10)
                        .minFlowerNumber(1)
                        .maxFlowerNumber(3)
                        .states(List.of(BlockStateProvider.simple(BlockRegister.CURIOSITY_FLOWER.get().defaultBlockState())))
                        .groundAllowed(List.of(BlockTags.DIRT))
                        .builder()
        );
        FeatureUtils.register(context, ModVegetationFeature.PATCH_DEAD_RUINS_FLOWER, FeatureRegister.BASIC_VEGETATION_PATCH.get(),
                new PatchConfiguration.Builder()
                        .spread(5)
                        .minFlowerNumber(5)
                        .maxFlowerNumber(10)
                        .states(List.of(BlockStateProvider.simple(BlockRegister.DEAD_RUINS_FLOWER.get().defaultBlockState())))
                        .groundAllowed(List.of(BlockTags.DIRT, BlockTags.SAND))
                        .builder()
        );
        //growing above
        FeatureUtils.register(context, ModVegetationFeature.PATCH_CIVILIZATIONS_FLOWER, FeatureRegister.GROWING_ABOVE_VEGETATION_PATCH.get(),
                new PatchConfiguration.Builder()
                        .spread(2)
                        .minFlowerNumber(2)
                        .maxFlowerNumber(5)
                        .states(List.of(BlockStateProvider.simple(BlockRegister.CIVILIZATIONS_FLOWER.get().defaultBlockState())))
                        .groundAllowed(List.of(BlockTags.DIRT))
                        .builder()
        );
        //tall
        FeatureUtils.register(context, ModVegetationFeature.PATCH_FALLING_HELICON_FLOWER, FeatureRegister.TALL_VEGETATION_PATCH.get(),
                new PatchConfiguration.Builder()
                        .spread(4)
                        .minFlowerNumber(4)
                        .maxFlowerNumber(15)
                        .states(List.of(BlockStateProvider.simple(BlockRegister.FALLING_HELICON_FLOWER.get().defaultBlockState())))
                        .groundAllowed(List.of(BlockTags.DIRT))
                        .builder()
        );
        FeatureUtils.register(context, ModVegetationFeature.SKY_SPEARS, FeatureRegister.TALL_VEGETATION_PATCH.get(),
                new PatchConfiguration.Builder()
                        .spread(2)
                        .minFlowerNumber(7)
                        .maxFlowerNumber(11)
                        .states(List.of(BlockStateProvider.simple(BlockRegister.SKY_SPEARS.get().defaultBlockState())))
                        .groundAllowed(List.of(BlockTags.DIRT))
                        .builder()
        );
        FeatureUtils.register(context, ModVegetationFeature.DEAD_TALL_BUSH, FeatureRegister.TALL_VEGETATION_PATCH.get(),
                new PatchConfiguration.Builder()
                        .spread(2)
                        .minFlowerNumber(2)
                        .maxFlowerNumber(5)
                        .states(List.of(BlockStateProvider.simple(BlockRegister.DEAD_TALL_BUSH.get().defaultBlockState())))
                        .groundAllowed(List.of(BlockTags.DIRT, BlockTags.SAND))
                        .builder()
        );
        FeatureUtils.register(context, ModVegetationFeature.OLD_WILD_WHEAT, FeatureRegister.TALL_VEGETATION_PATCH.get(),
                new PatchConfiguration.Builder()
                        .spread(1)
                        .minFlowerNumber(1)
                        .maxFlowerNumber(5)
                        .states(List.of(BlockStateProvider.simple(BlockRegister.OLD_WILD_WHEAT.get().defaultBlockState())))
                        .groundAllowed(List.of(BlockTags.DIRT))
                        .builder()
        );
        //tree
        FeatureUtils.register(context, TREE_MANGROVE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder22, 0.85F)), holder29));
        FeatureUtils.register(context, TREE_OAK_SWAMP, Feature.TREE, createStraightBlobTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 5, 3, 0, 3).decorators(ImmutableList.of(new LeaveVineDecorator(0.25F))).build());
        //misc
        FeatureUtils.register(context, ModVegetationFeature.FLOWERED_CACTUS, FeatureRegister.FLOWERED_CACTUS.get(), NoneFeatureConfiguration.INSTANCE);
        //tree
        FeatureUtils.register(context, MOUNTAIN_CURRANT, Feature.TREE, createMountainCurrantTree(BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get(WoodBlockEnum.LOG.toString()).get(), BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get(WoodBlockEnum.LEAVES.toString()).get()).build());
        FeatureUtils.register(context, MORICHE_PALM, Feature.TREE, createMorichePalmTree(BlockRegister.MORICHE_PALM_WOOD_TYPE_MAP.get(WoodBlockEnum.LOG.toString()).get(), BlockRegister.MORICHE_PALM_WOOD_TYPE_MAP.get(WoodBlockEnum.LEAVES.toString()).get()).build());
        FeatureUtils.register(context, ACHIOTE, Feature.TREE, createAchioteTree(BlockRegister.ACHIOTE_WOOD_TYPE_MAP.get(WoodBlockEnum.LOG.toString()).get(), BlockRegister.ACHIOTE_WOOD_TYPE_MAP.get(WoodBlockEnum.LEAVES.toString()).get()).build());
        FeatureUtils.register(context, WEEPING_WILLOW, Feature.TREE,
                createWeepingWillowTree(BlockRegister.WEEPING_WILLOW_WOOD_TYPE_MAP.get(WoodBlockEnum.LOG.toString()).get(), BlockRegister.WEEPING_WILLOW_WOOD_TYPE_MAP.get(WoodBlockEnum.LEAVES.toString()).get())
                        .decorators(ImmutableList.of(new FallingLeavesDecorator(0.9F, BlockStateProvider.simple(BlockRegister.FALLING_WEEPING_WILLOW_LEAVES.get()))))
                        .build());
        FeatureUtils.register(context, OAK_1, Feature.TREE, createAchioteTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 5 ,4).build());
    }

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(
            Block pLogBlock, Block pLeavesBlock, int pBaseHeight, int pHeightRandA, int pHeightRandB, int pRadius
    )
    {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(pLogBlock),
                new StraightTrunkPlacer(pBaseHeight, pHeightRandA, pHeightRandB),
                BlockStateProvider.simple(pLeavesBlock),
                new BlobFoliagePlacer(ConstantInt.of(pRadius), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }

    private static TreeConfiguration.TreeConfigurationBuilder createMountainCurrantTree(Block logBlock, Block leavesBlock)
    {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(logBlock),
                new MountainCurrantTrunkPlacer(2, 1, 0),
                BlockStateProvider.simple(leavesBlock),
                new MountainCurrantFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 2),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }

    private static TreeConfiguration.TreeConfigurationBuilder createMorichePalmTree(Block logBlock, Block leavesBlock)
    {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(logBlock),
                new MorichePalmTrunkPlacer(13, 10, 7),
                BlockStateProvider.simple(leavesBlock),
                new MorichePalmFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 2),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }

    private static TreeConfiguration.TreeConfigurationBuilder createAchioteTree(Block logBlock, Block leavesBlock)
    {
        return createAchioteTree(logBlock, leavesBlock, 3, 3);
    }

    private static TreeConfiguration.TreeConfigurationBuilder createAchioteTree(Block logBlock, Block leavesBlock, int baseHeight, int foliageradius)
    {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(logBlock),
                new AchioteTrunkPlacer(baseHeight, baseHeight - 1, baseHeight - 1),
                BlockStateProvider.simple(leavesBlock),
                new AchioteFoliagePlacer(ConstantInt.of(foliageradius), ConstantInt.of(0), 2),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }

    private static TreeConfiguration.TreeConfigurationBuilder createWeepingWillowTree(Block logBlock, Block leavesBlock)
    {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(logBlock),
                new WeepingWillowTrunkPlacer(6, 2, 1),
                BlockStateProvider.simple(leavesBlock),
                new WeepingWillowFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 2),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }

}

