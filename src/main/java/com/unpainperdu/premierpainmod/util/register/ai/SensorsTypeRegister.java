package com.unpainperdu.premierpainmod.util.register.ai;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SensorsTypeRegister
{
    public static final DeferredRegister<SensorType<?>> SENSOR_TYPE = DeferredRegister.create(Registries.SENSOR_TYPE, PremierPainMod.MOD_ID);

    //public static final DeferredHolder<SensorType<?>, SensorType<X>>

    private static <T extends Sensor<?>> DeferredHolder<SensorType<?>, SensorType<T>> register(String id, Supplier<T> sensor)
    {
        return SENSOR_TYPE.register(id, () -> new SensorType<>(sensor));
    }

    public static void register(IEventBus bus)
    {
        SENSOR_TYPE.register(bus);
    }
}
