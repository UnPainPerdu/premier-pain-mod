package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome.placement.feature.features;

import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.bush_and_rock.BushAndRockConfiguration;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.house_foundation_ruins.HouseFoundationRuinsConfiguration;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.outside_dry_toilet.OutsideDryToiletConfiguration;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.random_ruins_state.villager_statue_ruins.VillagerStatueRuinsConfiguration;
import com.unpainperdu.premierpainmod.util.register.FeatureRegister;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.block.WoodBlockEnum;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public class ModMiscOverworldFeatures
{
    private ModMiscOverworldFeatures(){}

    public static final ResourceKey<ConfiguredFeature<?, ?>> FOREST_VILLAGER_STATUE_RUINS = ModFeatureUtil.createKey("forest_villager_statue_ruins");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BUSH_AND_ROCK = ModFeatureUtil.createKey("bush_and_rock");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HOUSE_FOUNDATION_RUINS = ModFeatureUtil.createKey("house_foundation_ruins");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VILLAGER_PILLAR_RUINS_DESERT = ModFeatureUtil.createKey("villager_pillar_ruins_desert");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUD_PACK = ModFeatureUtil.createKey("mud_pack");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VILLAGER_TOTEM = ModFeatureUtil.createKey("villager_totem");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SWAMP_WEEPING_WILLOW_OUTSIDE_DRY_TOILET = ModFeatureUtil.createKey("swamp_weeping_willow_outside_dry_toilet");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SWAMP_MANGROVE_OUTSIDE_DRY_TOILET = ModFeatureUtil.createKey("swamp_mangrove_outside_dry_toilet");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> pContext)
    {
        FeatureUtils.register(pContext, ModMiscOverworldFeatures.FOREST_VILLAGER_STATUE_RUINS, FeatureRegister.VILLAGER_STATUE_RUINS.get(),
                new VillagerStatueRuinsConfiguration.Builder()
                        .blockStates(List.of(Blocks.STONE_BRICKS.defaultBlockState(),Blocks.MOSSY_STONE_BRICKS.defaultBlockState(),Blocks.CRACKED_STONE_BRICKS.defaultBlockState()))
                        .stairStates(List.of(Blocks.STONE_BRICK_STAIRS.defaultBlockState(),Blocks.MOSSY_STONE_BRICK_STAIRS.defaultBlockState()))
                        .slabStates(List.of(Blocks.STONE_BRICK_SLAB.defaultBlockState(),Blocks.MOSSY_STONE_BRICK_SLAB.defaultBlockState()))
                        .build()
        );
        FeatureUtils.register(pContext, ModMiscOverworldFeatures.BUSH_AND_ROCK, FeatureRegister.BUSH_AND_ROCK.get(),
                new BushAndRockConfiguration.Builder()
                        .maxExcludedNumberOfBlock(25)
                        .percentageOfCoverageBy2ndLayer(75)
                        .statesForRock(List.of(
                                BlockStateProvider.simple(Blocks.STONE.defaultBlockState()),
                                BlockStateProvider.simple(Blocks.COBBLESTONE.defaultBlockState())
                        ))
                        .statesFor2ndLayer(List.of(BlockStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.PERSISTENT, true))))
                        .build()
                );
        FeatureUtils.register(pContext, ModMiscOverworldFeatures.HOUSE_FOUNDATION_RUINS, FeatureRegister.HOUSE_FOUNDATION_RUINS.get(),
                new HouseFoundationRuinsConfiguration.Builder()
                        .states(List.of(
                                BlockStateProvider.simple(Blocks.COBBLESTONE.defaultBlockState()),
                                BlockStateProvider.simple(Blocks.MOSSY_COBBLESTONE.defaultBlockState())
                        ))
                        .build()
        );
        FeatureUtils.register(pContext, ModMiscOverworldFeatures.VILLAGER_PILLAR_RUINS_DESERT, FeatureRegister.VILLAGER_PILLAR_RUINS_DESERT.get(), NoneFeatureConfiguration.INSTANCE);
        FeatureUtils.register(pContext, ModMiscOverworldFeatures.MUD_PACK, FeatureRegister.MUD_PACK.get(), NoneFeatureConfiguration.INSTANCE);
        FeatureUtils.register(pContext, ModMiscOverworldFeatures.VILLAGER_TOTEM, FeatureRegister.VILLAGER_TOTEM.get(), NoneFeatureConfiguration.INSTANCE);
        FeatureUtils.register(pContext, ModMiscOverworldFeatures.SWAMP_WEEPING_WILLOW_OUTSIDE_DRY_TOILET, FeatureRegister.OUTSIDE_DRY_TOILET.get(),
                new OutsideDryToiletConfiguration.Builder()
                        .groundStates(List.of(
                                BlockStateProvider.simple(Blocks.MUD.defaultBlockState()),
                                BlockStateProvider.simple(Blocks.GRASS_BLOCK.defaultBlockState())
                        ))
                        .materialStates(List.of(
                                BlockStateProvider.simple(BlockRegister.WEEPING_WILLOW_WOOD_TYPE_MAP.get(WoodBlockEnum.LOG.toString()).get()),
                                BlockStateProvider.simple(BlockRegister.WEEPING_WILLOW_WOOD_TYPE_MAP.get(WoodBlockEnum.PLANKS.toString()).get()),
                                BlockStateProvider.simple(BlockRegister.WEEPING_WILLOW_WOOD_TYPE_MAP.get(WoodBlockEnum.SLAB.toString()).get()),
                                BlockStateProvider.simple(BlockRegister.WEEPING_WILLOW_WOOD_TYPE_MAP.get(WoodBlockEnum.DOOR.toString()).get()),
                                BlockStateProvider.simple(BlockRegister.ALL_MATERIALS_MAP.get("weeping_willow_villager_dry_toilet").get())
                        ))
                        .build()
        );

        FeatureUtils.register(pContext, ModMiscOverworldFeatures.SWAMP_MANGROVE_OUTSIDE_DRY_TOILET, FeatureRegister.OUTSIDE_DRY_TOILET.get(),
                new OutsideDryToiletConfiguration.Builder()
                        .groundStates(List.of(
                                BlockStateProvider.simple(Blocks.MUD.defaultBlockState()),
                                BlockStateProvider.simple(Blocks.GRASS_BLOCK.defaultBlockState())
                        ))
                        .materialStates(List.of(
                                BlockStateProvider.simple(Blocks.MANGROVE_LOG),
                                BlockStateProvider.simple(Blocks.MANGROVE_PLANKS),
                                BlockStateProvider.simple(Blocks.MANGROVE_SLAB),
                                BlockStateProvider.simple(Blocks.MANGROVE_DOOR),
                                BlockStateProvider.simple(BlockRegister.ALL_MATERIALS_MAP.get("mangrove_villager_dry_toilet").get())
                        ))
                        .build()
        );
    }
}
