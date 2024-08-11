package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.worldgen.feature.VillagerStatueRuinsFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FeatureRegister
{
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, PremierPainMod.MOD_ID);

    public static DeferredHolder<Feature<?>,Feature<NoneFeatureConfiguration>> VILLAGER_STATUE_RUINS = FEATURES.register("villager_statue_ruins",() -> new VillagerStatueRuinsFeature(NoneFeatureConfiguration.CODEC));


    public static void register(IEventBus modEventBus)
    {
        FEATURES.register(modEventBus);
    }
}
