package com.unpainperdu.premierpainmod.util.register.tree;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.folliage_placer.MorichePalmFoliagePlacer;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.folliage_placer.MountainCurrantFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FoliagePlacerTypesRegister
{
    FoliagePlacerTypesRegister(){}

    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER = DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, PremierPainMod.MOD_ID);

    public static final DeferredHolder<FoliagePlacerType<?>,FoliagePlacerType<MountainCurrantFoliagePlacer>> MOUNTAIN_CURRANT_FOLIAGE_PLACER = FOLIAGE_PLACER.register("mountain_currant_foliage_placer", () -> new FoliagePlacerType<>(MountainCurrantFoliagePlacer.CODEC));
    public static final DeferredHolder<FoliagePlacerType<?>,FoliagePlacerType<MorichePalmFoliagePlacer>> MORICHE_PALM_FOLIAGE_PLACER = FOLIAGE_PLACER.register("moriche_palm_foliage_placer", () -> new FoliagePlacerType<>(MorichePalmFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus)
    {
        FOLIAGE_PLACER.register(eventBus);
    }
}
