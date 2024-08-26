package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.misc.BushAndStoneFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.misc.HouseFoundationRuinsFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.misc.VillagerPillarRuinsFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.misc.VillagerStatueRuinsFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation.dead_bush_patch.DeadRuinsFlowerPatchFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation.flower_patch.CivilizationsFlowerPatchFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation.flower_patch.CuriosityFlowerPatchFeature;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation.flower_patch.RuinsFlowerPatchFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FeatureRegister
{
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, PremierPainMod.MOD_ID);
    //misc
    public static DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> VILLAGER_STATUE_RUINS = FEATURES.register("villager_statue_ruins",() -> new VillagerStatueRuinsFeature(NoneFeatureConfiguration.CODEC));
    public static DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> BUSH_AND_STONE = FEATURES.register("bush_and_stone",() -> new BushAndStoneFeature(NoneFeatureConfiguration.CODEC));
    public static DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> HOUSE_FOUNDATION_RUINS = FEATURES.register("house_foundation_ruins",() -> new HouseFoundationRuinsFeature(NoneFeatureConfiguration.CODEC));
    public static DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> VILLAGER_PILLAR_RUINS_DESERT = FEATURES.register("villager_pillar_ruins_desert",() -> new VillagerPillarRuinsFeature(NoneFeatureConfiguration.CODEC));
    //vegetation
        //flower
    public static DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> PATCH_RUINS_FLOWER = FEATURES.register("patch_ruins_flower",() -> new RuinsFlowerPatchFeature(NoneFeatureConfiguration.CODEC));
    public static DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> PATCH_CIVILIZATIONS_FLOWER = FEATURES.register("patch_civilizations_flower",() -> new CivilizationsFlowerPatchFeature(NoneFeatureConfiguration.CODEC));
    public static DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> PATCH_CURIOSITY_FLOWER = FEATURES.register("patch_curiosity_flower",() -> new CuriosityFlowerPatchFeature(NoneFeatureConfiguration.CODEC));
        //dead bush
    public static DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> PATCH_DEAD_RUINS_FLOWER = FEATURES.register("patch_dead_ruins_flower",() -> new DeadRuinsFlowerPatchFeature(NoneFeatureConfiguration.CODEC));
        //tree
    public static DeferredHolder<Feature<?>,Feature<TreeConfiguration>> TREE_MANGROVE = FEATURES.register("tree_mangrove",() -> new TreeFeature(TreeConfiguration.CODEC));


    public static void register(IEventBus modEventBus)
    {
        FEATURES.register(modEventBus);
    }
}
