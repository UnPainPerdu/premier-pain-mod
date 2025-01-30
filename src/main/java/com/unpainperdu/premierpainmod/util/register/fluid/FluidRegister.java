package com.unpainperdu.premierpainmod.util.register.fluid;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.fluid.beer.PainDieuxFluid;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FluidRegister
{
    public static final DeferredRegister<Fluid> FLUID = DeferredRegister.create(Registries.FLUID, PremierPainMod.MOD_ID);

    //beer
        //pain dieux
    public static final DeferredHolder<Fluid, Fluid> FLOWING_PAIN_DIEUX_FLUID = FLUID.register("flowing_pain_dieux_fluid", () -> new PainDieuxFluid.Flowing());
    public static final DeferredHolder<Fluid, Fluid> PAIN_DIEUX_FLUID = FLUID.register("pain_dieux_fluid", () -> new PainDieuxFluid.Source());

    public static void register(IEventBus modEventBus)
    {
        FLUID.register(modEventBus);
    }
}
