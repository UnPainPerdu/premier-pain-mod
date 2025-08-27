package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.bush_and_rock.BushAndRockConfiguration;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.bush_and_rock.BushAndRockFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.house_foundation_ruins.HouseFoundationRuinsConfiguration;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.house_foundation_ruins.HouseFoundationRuinsFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.outside_dry_toilet.OutsideDryToiletConfiguration;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.outside_dry_toilet.OutsideDryToiletFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.random_ruins_state.villager_statue_ruins.VillagerStatueRuinsConfiguration;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.random_ruins_state.villager_statue_ruins.VillagerStatueRuinsFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.vegetation.patch.BasicFlowerPatchFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.vegetation.patch.GrowingAboveVegetationPatchFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.vegetation.patch.PatchConfiguration;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.vegetation.patch.TallVegetationPatchFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.misc.MudPackFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.misc.VillagerPillarRuinsFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.misc.VillagerTotemFeature;
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
    public static final DeferredHolder<Feature<?>, Feature<VillagerStatueRuinsConfiguration>> VILLAGER_STATUE_RUINS = FEATURES.register("villager_statue_ruins", () -> new VillagerStatueRuinsFeature(VillagerStatueRuinsConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, Feature<BushAndRockConfiguration>> BUSH_AND_ROCK = FEATURES.register("bush_and_rock", () -> new BushAndRockFeature(BushAndRockConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, Feature<HouseFoundationRuinsConfiguration>> HOUSE_FOUNDATION_RUINS = FEATURES.register("house_foundation_ruins", () -> new HouseFoundationRuinsFeature(HouseFoundationRuinsConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> VILLAGER_PILLAR_RUINS_DESERT = FEATURES.register("villager_pillar_ruins_desert", () -> new VillagerPillarRuinsFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> MUD_PACK = FEATURES.register("mud_pack", () -> new MudPackFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> VILLAGER_TOTEM = FEATURES.register("villager_totem", () -> new VillagerTotemFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, Feature<OutsideDryToiletConfiguration>> OUTSIDE_DRY_TOILET = FEATURES.register("outside_dry_toilet", () -> new OutsideDryToiletFeature(OutsideDryToiletConfiguration.CODEC));
    //vegetation
    //flower
    public static final DeferredHolder<Feature<?>, Feature<PatchConfiguration>> BASIC_VEGETATION_PATCH = FEATURES.register("basic_vegetation_flower", () -> new BasicFlowerPatchFeature(PatchConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, Feature<PatchConfiguration>> TALL_VEGETATION_PATCH = FEATURES.register("tall_vegetation_flower", () -> new TallVegetationPatchFeature(PatchConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>, Feature<PatchConfiguration>> GROWING_ABOVE_VEGETATION_PATCH = FEATURES.register("growing_above_vegetation_flower", () -> new GrowingAboveVegetationPatchFeature(PatchConfiguration.CODEC));
    //misc
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> FLOWERED_CACTUS = FEATURES.register("flowered_cactus", () -> new FloweredCactusFeature(NoneFeatureConfiguration.CODEC));

    public static void register(IEventBus modEventBus)
    {
        FEATURES.register(modEventBus);
    }
}
