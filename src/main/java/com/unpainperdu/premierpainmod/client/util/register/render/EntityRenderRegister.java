package com.unpainperdu.premierpainmod.client.util.register.render;

import com.unpainperdu.premierpainmod.client.render.entity.EmptyRenderer;
import com.unpainperdu.premierpainmod.client.render.entity.mountain_currant_golem.MountainCurrantGolemModel;
import com.unpainperdu.premierpainmod.client.render.entity.mountain_currant_golem.MountainCurrantGolemRender;
import com.unpainperdu.premierpainmod.client.render.entity.wool_golem.WoolGolemModel;
import com.unpainperdu.premierpainmod.client.render.entity.wool_golem.WoolGolemRender;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.MountainCurrantGolemEntity;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.WoolGolemEntity;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

public class EntityRenderRegister
{
    public static void registerEntityRender()
    {
        //entity_for_blocks
        EntityRenderers.register(AllInOneEntityRegister.SEAT_ENTITY.get(), EmptyRenderer::new);
        EntityRenderers.register(AllInOneEntityRegister.TOILET_SEAT_ENTITY.get(), EmptyRenderer::new);
        //mobs
        EntityRenderers.register(AllInOneEntityRegister.MOUNTAIN_CURRANT_GOLEM_ENTITY.get(), MountainCurrantGolemRender::new);
        EntityRenderers.register(AllInOneEntityRegister.WOOL_GOLEM_ENTITY.get(), WoolGolemRender::new);
    }

    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(MountainCurrantGolemModel.LAYER_LOCATION, MountainCurrantGolemModel::createBodyLayer);
        event.registerLayerDefinition(WoolGolemModel.LAYER_LOCATION, WoolGolemModel::createBodyLayer);
    }

    public static void registerEntityAttributes(EntityAttributeCreationEvent event)
    {
        event.put(AllInOneEntityRegister.MOUNTAIN_CURRANT_GOLEM_ENTITY.get(), MountainCurrantGolemEntity.createAttributes().build());
        event.put(AllInOneEntityRegister.WOOL_GOLEM_ENTITY.get(), WoolGolemEntity.createAttributes().build());
    }
}
