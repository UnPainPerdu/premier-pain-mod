package com.unpainperdu.premierpainmod.client.event;

import com.unpainperdu.premierpainmod.level.world.entity.blockEntity.SeatEntity;
import com.unpainperdu.premierpainmod.util.register.EntityRegister;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(bus = Bus.MOD, value = Dist.CLIENT)
public class SeatClient
{
    private SeatClient() {}

    @SubscribeEvent
    public static void onFMLCLientSetup(FMLClientSetupEvent event)
    {
        EntityRenderers.register(EntityRegister.SEAT_ENTITY.get(), EmptyRenderer::new);
    }

    private static class EmptyRenderer extends EntityRenderer<SeatEntity>
    {

        protected EmptyRenderer(EntityRendererProvider.Context ctx)
        {
            super(ctx);
        }

        @Override
        public boolean shouldRender(SeatEntity entity, Frustum camera, double camX, double camY, double camZ)
        {
            return false;
        }

        @Override
        public ResourceLocation getTextureLocation(SeatEntity entity)
        {
            return null;
        }
    }
}