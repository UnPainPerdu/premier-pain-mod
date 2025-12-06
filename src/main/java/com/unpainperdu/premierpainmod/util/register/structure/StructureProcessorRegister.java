package com.unpainperdu.premierpainmod.util.register.structure;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.worldgen.structure.processor.ExtendedBlockAgeProcessor;
import com.unpainperdu.premierpainmod.level.world.worldgen.structure.processor.ExtendedBlockRemover;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class StructureProcessorRegister
{
    private StructureProcessorRegister()
    {
    }

    public static final DeferredRegister<StructureProcessorType<?>> PROCESSOR_TYPE = DeferredRegister.create(BuiltInRegistries.STRUCTURE_PROCESSOR, PremierPainMod.MOD_ID);

    public static final DeferredHolder<StructureProcessorType<?>, StructureProcessorType<?>> EXTENDED_ROT = PROCESSOR_TYPE.register("extended_rot", () -> explicitProcessorTypeTyping(ExtendedBlockRemover.CODEC));
    public static final DeferredHolder<StructureProcessorType<?>, StructureProcessorType<?>> EXTENDED_AGE = PROCESSOR_TYPE.register("extended_age", () -> explicitProcessorTypeTyping(ExtendedBlockAgeProcessor.CODEC));

    private static <T extends net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor> StructureProcessorType<T> explicitProcessorTypeTyping(MapCodec<T> structureCodec)
    {
        return () -> structureCodec;
    }

    public static void register(IEventBus modEventBus)
    {
        PROCESSOR_TYPE.register(modEventBus);
    }
}
