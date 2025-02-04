package com.unpainperdu.premierpainmod.util.register.tree;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.trunk_placer.MountainCurrantTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.bus.api.IEventBus;

public class TrunkPlacerTypesRegister
{
    TrunkPlacerTypesRegister(){}

    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, PremierPainMod.MOD_ID);

    public static final DeferredHolder<TrunkPlacerType<?>,TrunkPlacerType<MountainCurrantTrunkPlacer>> MOUNTAIN_CURRANT_TRUNK_PLACER = TRUNK_PLACER.register("mountain_currant_trunk_placer", () -> new TrunkPlacerType<>(MountainCurrantTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus)
    {
        TRUNK_PLACER.register(eventBus);
    }
}
