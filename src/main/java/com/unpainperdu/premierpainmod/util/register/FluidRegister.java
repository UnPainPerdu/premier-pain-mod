package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FluidRegister
{
    public static final DeferredRegister<Fluid> FLUID = DeferredRegister.create(Registries.FLUID, PremierPainMod.MOD_ID);

    public static void register(IEventBus modEventBus)
    {
        FLUID.register(modEventBus);
    }
}
