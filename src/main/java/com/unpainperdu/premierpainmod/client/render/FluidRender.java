package com.unpainperdu.premierpainmod.client.render;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

import static com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister.FLUIDS;


public class FluidRender
{
    public static void setRenderLayerForFluid(FMLClientSetupEvent event)
    {
        for (DeferredHolder<Fluid, Fluid> fluidHolder : FLUIDS.values())
        {
            Fluid fluid = fluidHolder.get();
            {
                ItemBlockRenderTypes.setRenderLayer(fluid, RenderType.TRANSLUCENT);
            }
        }
    }
}