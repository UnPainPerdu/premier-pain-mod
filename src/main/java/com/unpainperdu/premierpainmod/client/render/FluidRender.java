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
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.LA_CHATEAU_FLUID.get(), RenderType.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.FLOWING_LA_CHATEAU_FLUID.get(), RenderType.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.DEBIER_FLUID.get(), RenderType.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.FLOWING_DEBIER_FLUID.get(), RenderType.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.ENVAHISSEUR_ROUGE_FLUID.get(), RenderType.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.FLOWING_ENVAHISSEUR_ROUGE_FLUID.get(), RenderType.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.RASPBUISSON_FLUID.get(), RenderType.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.FLOWING_RASPBUISSON_FLUID.get(), RenderType.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.LA_BLANCHE_CITADINE_FLUID.get(), RenderType.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.FLOWING_LA_BLANCHE_CITADINE_FLUID.get(), RenderType.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.CRANE_NOIR_FLUID.get(), RenderType.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.FLOWING_CRANE_NOIR_FLUID.get(), RenderType.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.TAK_FLUID.get(), RenderType.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.FLOWING_TAK_FLUID.get(), RenderType.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.DISENDER_FLUID.get(), RenderType.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(FluidRegister.FLOWING_DISENDER_FLUID.get(), RenderType.TRANSLUCENT);
    }
}
