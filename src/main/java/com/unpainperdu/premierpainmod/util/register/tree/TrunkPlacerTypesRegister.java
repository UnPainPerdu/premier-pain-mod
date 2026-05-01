package com.unpainperdu.premierpainmod.util.register.tree;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.trunk_placer.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TrunkPlacerTypesRegister
{
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, PremierPainMod.MOD_ID);

    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<MountainCurrantTrunkPlacer>> MOUNTAIN_CURRANT_TRUNK_PLACER = TRUNK_PLACER.register("mountain_currant_trunk_placer", () -> new TrunkPlacerType<>(MountainCurrantTrunkPlacer.CODEC));
    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<MorichePalmTrunkPlacer>> MORICHE_PALM_TRUNK_PLACER = TRUNK_PLACER.register("moriche_palm_trunk_placer", () -> new TrunkPlacerType<>(MorichePalmTrunkPlacer.CODEC));
    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<AchioteTrunkPlacer>> ACHIOTE_TRUNK_PLACER = TRUNK_PLACER.register("achiote_trunk_placer", () -> new TrunkPlacerType<>(AchioteTrunkPlacer.CODEC));
    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<WeepingWillowTrunkPlacer>> WEEPING_WILLOW_TRUNK_PLACER = TRUNK_PLACER.register("weeping_willow_trunk_placer", () -> new TrunkPlacerType<>(WeepingWillowTrunkPlacer.CODEC));
    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<EnhancedBirchTrunkPlacer>> ENHANCED_BIRCH_TRUNK_PLACER = TRUNK_PLACER.register("enhanced_birch_trunk_placer", () -> new TrunkPlacerType<>(EnhancedBirchTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus)
    {
        TRUNK_PLACER.register(eventBus);
    }
}