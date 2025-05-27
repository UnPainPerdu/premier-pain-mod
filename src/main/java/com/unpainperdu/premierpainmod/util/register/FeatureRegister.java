package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.bush_and_rock_feature.BushAndRockConfiguration;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.bush_and_rock_feature.BushAndRockFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.house_foundation_ruins.HouseFoundationRuinsConfiguration;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.house_foundation_ruins.HouseFoundationRuinsFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.vegetation.patch.BasicFlowerPatchFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.vegetation.patch.PatchConfiguration;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.vegetation.patch.TallVegetationPatchFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.misc.MudPackFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.misc.VillagerPillarRuinsFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.misc.VillagerStatueRuinsFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.misc.VillagerTotemFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation.flower_patch.CivilizationsFlowerPatchFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation.misc.FloweredCactusFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FeatureRegister
{
    private FeatureRegister()
    {
    }

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, PremierPainMod.MOD_ID);
    //misc
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> VILLAGER_STATUE_RUINS = FEATURES.register("villager_statue_ruins", () -> new VillagerStatueRuinsFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, Feature<BushAndRockConfiguration>> BUSH_AND_ROCK = FEATURES.register("bush_and_rock", () -> new BushAndRockFeature(BushAndRockConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, Feature<HouseFoundationRuinsConfiguration>> HOUSE_FOUNDATION_RUINS = FEATURES.register("house_foundation_ruins", () -> new HouseFoundationRuinsFeature(HouseFoundationRuinsConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> VILLAGER_PILLAR_RUINS_DESERT = FEATURES.register("villager_pillar_ruins_desert", () -> new VillagerPillarRuinsFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> MUD_PACK = FEATURES.register("mud_pack", () -> new MudPackFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> VILLAGER_TOTEM = FEATURES.register("villager_totem", () -> new VillagerTotemFeature(NoneFeatureConfiguration.CODEC));
    //vegetation
    //flower
    public static final DeferredHolder<Feature<?>, Feature<PatchConfiguration>> BASIC_VEGETATION_PATCH = FEATURES.register("basic_vegetation_flower", () -> new BasicFlowerPatchFeature(PatchConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, Feature<PatchConfiguration>> TALL_VEGETATION_PATCH = FEATURES.register("tall_vegetation_flower", () -> new TallVegetationPatchFeature(PatchConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> PATCH_CIVILIZATIONS_FLOWER = FEATURES.register("patch_civilizations_flower", () -> new CivilizationsFlowerPatchFeature(NoneFeatureConfiguration.CODEC));
    //misc
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> FLOWERED_CACTUS = FEATURES.register("flowered_cactus", () -> new FloweredCactusFeature(NoneFeatureConfiguration.CODEC));

    public static void register(IEventBus modEventBus)
    {
        FEATURES.register(modEventBus);
    }
}
