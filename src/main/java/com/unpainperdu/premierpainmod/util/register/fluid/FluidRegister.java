package com.unpainperdu.premierpainmod.util.register.fluid;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.fluid.beer.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FluidRegister
{
    private FluidRegister()
    {
    }

    public static final DeferredRegister<Fluid> FLUID = DeferredRegister.create(Registries.FLUID, PremierPainMod.MOD_ID);

    //beer
    //pain dieux
    public static final DeferredHolder<Fluid, Fluid> PAIN_DIEUX_FLUID = FLUID.register("pain_dieux_fluid", PainDieuxFluid.Source::new);
    public static final DeferredHolder<Fluid, Fluid> FLOWING_PAIN_DIEUX_FLUID = FLUID.register("flowing_pain_dieux_fluid", PainDieuxFluid.Flowing::new);
    //LA_CHATEAU
    public static final DeferredHolder<Fluid, Fluid> LA_CHATEAU_FLUID = FLUID.register("la_chateau_fluid", LaChateauFluid.Source::new);
    public static final DeferredHolder<Fluid, Fluid> FLOWING_LA_CHATEAU_FLUID = FLUID.register("flowing_la_chateau_fluid", LaChateauFluid.Flowing::new);
    //DEBIER
    public static final DeferredHolder<Fluid, Fluid> DEBIER_FLUID = FLUID.register("debier_fluid", DeBierFluid.Source::new);
    public static final DeferredHolder<Fluid, Fluid> FLOWING_DEBIER_FLUID = FLUID.register("flowing_debier_fluid", DeBierFluid.Flowing::new);
    //ENVAHISSEUR_ROUGE
    public static final DeferredHolder<Fluid, Fluid> ENVAHISSEUR_ROUGE_FLUID = FLUID.register("envahisseur_rouge_fluid", EnvahisseurRougeFluid.Source::new);
    public static final DeferredHolder<Fluid, Fluid> FLOWING_ENVAHISSEUR_ROUGE_FLUID = FLUID.register("flowing_envahisseur_rouge_fluid", EnvahisseurRougeFluid.Flowing::new);
    //RASPBUISSON
    public static final DeferredHolder<Fluid, Fluid> RASPBUISSON_FLUID = FLUID.register("raspbuisson_fluid", RaspBuissonFluid.Source::new);
    public static final DeferredHolder<Fluid, Fluid> FLOWING_RASPBUISSON_FLUID = FLUID.register("flowing_raspbuisson_fluid", RaspBuissonFluid.Flowing::new);
    //LA_BLANCHE_CITADINE
    public static final DeferredHolder<Fluid, Fluid> LA_BLANCHE_CITADINE_FLUID = FLUID.register("la_blanche_citadine_fluid", LaBlancheCitadineFluid.Source::new);
    public static final DeferredHolder<Fluid, Fluid> FLOWING_LA_BLANCHE_CITADINE_FLUID = FLUID.register("flowing_la_blanche_citadine_fluid", LaBlancheCitadineFluid.Flowing::new);
    //CRANE_NOIR
    public static final DeferredHolder<Fluid, Fluid> CRANE_NOIR_FLUID = FLUID.register("crane_noir_fluid", CraneNoirFluid.Source::new);
    public static final DeferredHolder<Fluid, Fluid> FLOWING_CRANE_NOIR_FLUID = FLUID.register("flowing_crane_noir_fluid", CraneNoirFluid.Flowing::new);
    //TAK
    public static final DeferredHolder<Fluid, Fluid> TAK_FLUID = FLUID.register("crane_tak_fluid", TakFluid.Source::new);
    public static final DeferredHolder<Fluid, Fluid> FLOWING_TAK_FLUID = FLUID.register("flowing_tak_fluid", TakFluid.Flowing::new);
    //DISENDER
    public static final DeferredHolder<Fluid, Fluid> DISENDER_FLUID = FLUID.register("crane_disender_fluid", DisEnderFluid.Source::new);
    public static final DeferredHolder<Fluid, Fluid> FLOWING_DISENDER_FLUID = FLUID.register("flowing_disender_fluid", DisEnderFluid.Flowing::new);

    public static void register(IEventBus modEventBus)
    {
        FLUID.register(modEventBus);
    }
}
