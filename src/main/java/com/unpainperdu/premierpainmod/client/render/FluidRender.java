package com.unpainperdu.premierpainmod.client.render;

import com.unpainperdu.premierpainmod.util.register.fluid.FluidRegister;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

public class FluidRender
{
    public static void setRenderLayerForFluid(FMLClientSetupEvent event)
    {
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.PAIN_DIEUX_FLUID.get(), RenderType.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.FLOWING_PAIN_DIEUX_FLUID.get(), RenderType.TRANSLUCENT);
    }
}
