package com.unpainperdu.premierpainmod.client.util.register.render;

import com.unpainperdu.premierpainmod.client.render.entity.EmptyRenderer;
import com.unpainperdu.premierpainmod.client.render.entity.flowered_lizard.FloweredLizardRender;
import com.unpainperdu.premierpainmod.client.render.entity.mountain_currant_golem.MountainCurrantGolemRender;
import com.unpainperdu.premierpainmod.client.render.entity.wool_golem.WoolGolemRender;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

public class EntityRenderRegister
{
    public static void registerEntityRender()
    {
        //entity_for_blocks
        EntityRenderers.register(AllInOneEntityRegister.SEAT_ENTITY.get(), EmptyRenderer::new);
        EntityRenderers.register(AllInOneEntityRegister.TOILET_SEAT_ENTITY.get(), EmptyRenderer::new);
        //projectile
        EntityRenderers.register(AllInOneEntityRegister.FLOWERED_LIZARD_THROWN_EGG.get(), ThrownItemRenderer::new);
        //mobs
        EntityRenderers.register(AllInOneEntityRegister.MOUNTAIN_CURRANT_GOLEM_ENTITY.get(), MountainCurrantGolemRender::new);
        EntityRenderers.register(AllInOneEntityRegister.WOOL_GOLEM_ENTITY.get(), WoolGolemRender::new);
        EntityRenderers.register(AllInOneEntityRegister.FLOWERED_LIZARD_ENTITY.get(), FloweredLizardRender::new);
    }
}
