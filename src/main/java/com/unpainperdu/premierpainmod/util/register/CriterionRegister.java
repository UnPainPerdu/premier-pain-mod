package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CriterionRegister
{
    private CriterionRegister()
    {
    }

    public static final DeferredRegister<CriterionTrigger<?>> CRITERION = DeferredRegister.create(BuiltInRegistries.TRIGGER_TYPES, PremierPainMod.MOD_ID);

    public static void register(IEventBus bus)
    {
        CRITERION.register(bus);
    }
}
