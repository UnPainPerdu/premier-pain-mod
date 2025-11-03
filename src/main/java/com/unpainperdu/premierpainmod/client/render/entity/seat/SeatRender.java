package com.unpainperdu.premierpainmod.client.render.entity.seat;

import com.unpainperdu.premierpainmod.level.world.entity.seat.SeatEntity;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(value = Dist.CLIENT)
public class SeatRender
{
    private SeatRender()
    {
    }

    @SubscribeEvent
    public static void onFMLCLientSetup(FMLClientSetupEvent event)
    {
        EntityRenderers.register(AllInOneEntityRegister.SEAT_ENTITY.get(), EmptyRenderer::new);
    }

    private static class EmptyRenderer extends EntityRenderer<SeatEntity>
    {

        protected EmptyRenderer(EntityRendererProvider.Context ctx)
        {
            super(ctx);
        }

        @Override
        public boolean shouldRender(@NotNull SeatEntity entity, @NotNull Frustum camera, double camX, double camY, double camZ)
        {
            return false;
        }

        @Override
        public ResourceLocation getTextureLocation(@NotNull SeatEntity entity)
        {
            return null;
        }
    }
}