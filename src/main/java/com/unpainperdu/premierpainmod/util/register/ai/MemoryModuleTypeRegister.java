package com.unpainperdu.premierpainmod.util.register.ai;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Optional;
import java.util.function.Supplier;

public class MemoryModuleTypeRegister
{
    public static final DeferredRegister<MemoryModuleType<?>> MEMORY_MODULE_TYPE = DeferredRegister.create(Registries.MEMORY_MODULE_TYPE, PremierPainMod.MOD_ID);

    private static <T> Supplier<MemoryModuleType<T>> register(String id)
    {
        return register(id, Optional.empty());
    }

    private static <T> Supplier<MemoryModuleType<T>> register(String id, Optional<Codec<T>> codec)
    {
        return MEMORY_MODULE_TYPE.register(id, () -> new MemoryModuleType<>(codec));
    }

    public static void register(IEventBus bus)
    {
        MEMORY_MODULE_TYPE.register(bus);
    }
}
