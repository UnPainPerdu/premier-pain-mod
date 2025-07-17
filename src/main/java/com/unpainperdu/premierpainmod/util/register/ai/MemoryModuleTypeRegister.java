package com.unpainperdu.premierpainmod.util.register.ai;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Optional;

public class MemoryModuleTypeRegister
{
    public static final DeferredRegister<MemoryModuleType<?>> MEMORY_MODULE_TYPE = DeferredRegister.create(Registries.MEMORY_MODULE_TYPE, PremierPainMod.MOD_ID);

    public static final DeferredHolder<MemoryModuleType<?>, MemoryModuleType<BlockPos>> CHOSEN_BLOCK = register("chosen_block");
    public static final DeferredHolder<MemoryModuleType<?>, MemoryModuleType<Unit>> BONE_MEALING_CD = register("bone_mealing_cd", Unit.CODEC);
    public static final DeferredHolder<MemoryModuleType<?>, MemoryModuleType<Unit>> FAIL_CD = register("fail_cd", Unit.CODEC);

    private static <T> DeferredHolder<MemoryModuleType<?>, MemoryModuleType<T>> register(String id)
    {
        return register(id, Optional.empty());
    }

    private static <T> DeferredHolder<MemoryModuleType<?>, MemoryModuleType<T>> register(String id, Codec<T> codec)
    {
        return register(id, Optional.of(codec));
    }

    private static <T> DeferredHolder<MemoryModuleType<?>, MemoryModuleType<T>> register(String id, Optional<Codec<T>> codec)
    {
        return MEMORY_MODULE_TYPE.register(id, () -> new MemoryModuleType<>(codec));
    }

    public static void register(IEventBus bus)
    {
        MEMORY_MODULE_TYPE.register(bus);
    }
}
