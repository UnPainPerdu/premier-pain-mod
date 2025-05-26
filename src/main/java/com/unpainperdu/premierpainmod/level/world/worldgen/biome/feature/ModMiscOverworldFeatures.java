package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature;

import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.bush_and_rock_feature.BushAndRockConfiguration;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.house_foundation_ruins.HouseFoundationRuinsConfiguration;
import com.unpainperdu.premierpainmod.util.register.FeatureRegister;
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

    public static final ResourceKey<ConfiguredFeature<?, ?>> VILLAGER_STATUE_RUINS = ModFeatureUtil.createKey("villager_statue_ruins");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BUSH_AND_ROCK = ModFeatureUtil.createKey("bush_and_rock");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HOUSE_FOUNDATION_RUINS = ModFeatureUtil.createKey("house_foundation_ruins");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VILLAGER_PILLAR_RUINS_DESERT = ModFeatureUtil.createKey("villager_pillar_ruins_desert");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUD_PACK = ModFeatureUtil.createKey("mud_pack");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VILLAGER_TOTEM = ModFeatureUtil.createKey("villager_totem");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> pContext)
    {
        FeatureUtils.register(pContext, ModMiscOverworldFeatures.VILLAGER_STATUE_RUINS, FeatureRegister.VILLAGER_STATUE_RUINS.get(), NoneFeatureConfiguration.INSTANCE);
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
    }
}
