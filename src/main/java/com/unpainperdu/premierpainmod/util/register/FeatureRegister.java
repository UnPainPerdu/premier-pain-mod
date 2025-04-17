package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.misc.*;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation.dead_bush_patch.DeadRuinsFlowerPatchFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation.flower_patch.CivilizationsFlowerPatchFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation.flower_patch.CuriosityFlowerPatchFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation.flower_patch.RuinsFlowerPatchFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation.misc.FloweredCactusFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation.tallGrass.TallGrassFeature;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FeatureRegister
{
    private FeatureRegister(){}

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, PremierPainMod.MOD_ID);
    //misc
    public static final DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> VILLAGER_STATUE_RUINS = FEATURES.register("villager_statue_ruins",() -> new VillagerStatueRuinsFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> BUSH_AND_STONE = FEATURES.register("bush_and_stone",() -> new BushAndStoneFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> HOUSE_FOUNDATION_RUINS = FEATURES.register("house_foundation_ruins",() -> new HouseFoundationRuinsFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> VILLAGER_PILLAR_RUINS_DESERT = FEATURES.register("villager_pillar_ruins_desert",() -> new VillagerPillarRuinsFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> MUD_PACK = FEATURES.register("mud_pack",() -> new MudPackFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> VILLAGER_TOTEM = FEATURES.register("villager_totem",() -> new VillagerTotemFeature(NoneFeatureConfiguration.CODEC));
    //vegetation
        //flower
    public static final DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> PATCH_RUINS_FLOWER = FEATURES.register("patch_ruins_flower",() -> new RuinsFlowerPatchFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> PATCH_CIVILIZATIONS_FLOWER = FEATURES.register("patch_civilizations_flower",() -> new CivilizationsFlowerPatchFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> PATCH_CURIOSITY_FLOWER = FEATURES.register("patch_curiosity_flower",() -> new CuriosityFlowerPatchFeature(NoneFeatureConfiguration.CODEC));
    public static final DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> FALLING_HELICON_FLOWER = FEATURES.register("falling_helicon_flower",
            () -> new TallGrassFeature(NoneFeatureConfiguration.CODEC, 4, 15 ,4 ,BlockRegister.FALLING_HELICON_FLOWER.get(), BlockTags.DIRT));

    //dead bush
    public static final DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> PATCH_DEAD_RUINS_FLOWER = FEATURES.register("patch_dead_ruins_flower",() -> new DeadRuinsFlowerPatchFeature(NoneFeatureConfiguration.CODEC));
        //misc
    public static final DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> FLOWERED_CACTUS = FEATURES.register("flowered_cactus",() -> new FloweredCactusFeature(NoneFeatureConfiguration.CODEC));
        //tall grass
    public static final DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> SKY_SPEARS = FEATURES.register("sky_spears",
                () -> new TallGrassFeature(NoneFeatureConfiguration.CODEC, 7, 11 ,2 ,BlockRegister.SKY_SPEARS.get(), BlockTags.DIRT));
    public static final DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> DEAD_TALL_BUSH = FEATURES.register("dead_tall_bush",
            () -> new TallGrassFeature(NoneFeatureConfiguration.CODEC, 2, 5,2 , BlockRegister.DEAD_TALL_BUSH.get(), BlockTags.SAND));
    public static final DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> OLD_WILD_WHEAT = FEATURES.register("old_wild_wheat",
            () -> new TallGrassFeature(NoneFeatureConfiguration.CODEC, 1, 1 ,1 ,BlockRegister.OLD_WILD_WHEAT.get(), BlockTags.DIRT));

    public static void register(IEventBus modEventBus)
    {
        FEATURES.register(modEventBus);
    }
}
