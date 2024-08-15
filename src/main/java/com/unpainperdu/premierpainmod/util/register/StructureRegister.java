package com.unpainperdu.premierpainmod.util.register;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.worldgen.structure.PremierPainTempleStructures;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class StructureRegister
{
    /*
    See in data :
        -tags/worldgen/biome/has_structure/ for biome filter
        -worlgen/structure
        -worlgen/structure_set
        -worlgen/template_pool
     */
    public static final DeferredRegister<StructureType<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(Registries.STRUCTURE_TYPE, PremierPainMod.MOD_ID);

    public static final DeferredHolder<StructureType<?>, StructureType<PremierPainTempleStructures>> PREMIER_PAIN_TEMPLE_STRUCTURE = DEFERRED_REGISTRY_STRUCTURE.register("premier_pain_temple_structure", () -> explicitStructureTypeTyping(PremierPainTempleStructures.CODEC));

    private static <T extends Structure> StructureType<T> explicitStructureTypeTyping(MapCodec<T> structureCodec)
    {
        return () -> structureCodec;
    }

    public static void register(IEventBus modEventBus)
    {
        DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
    }

}
