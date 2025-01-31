package com.unpainperdu.premierpainmod.util.register.fluid;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.LiquidContent;
import com.unpainperdu.premierpainmod.level.world.fluid.fluidType.BeerFluidType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.joml.Vector3f;

public class FluidTypeRegister
{
    public static final DeferredRegister<FluidType> FLUID_TYPE = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, PremierPainMod.MOD_ID);

    //vector -> x = r, y = g, z = b
    //rgb -> 0xA1d68000 -> d6 80 00
    // into decimal float -> 214f 128f 000f
    //now /255f
    public static final DeferredHolder<FluidType, BeerFluidType> PAIN_DIEUX_TYPE = FLUID_TYPE.register("pain_dieux_type",
            () -> new BeerFluidType(BeerFluidType.Properties.create()
                    .canConvertToSource(false)
                    .fallDistanceModifier(0F)
                    .canHydrate(false)
                    .descriptionId("premierpainmod.block.description." + "pain_dieux_type")
                    , LiquidContent.BLOND_BEER));

    public static void register(IEventBus bus)
    {
        FLUID_TYPE.register(bus);
    }
}
