package com.unpainperdu.premierpainmod.event.entity;

import com.unpainperdu.premierpainmod.client.render.entity.flowered_lizard.FloweredLizardModel;
import com.unpainperdu.premierpainmod.client.render.entity.mountain_currant_golem.MountainCurrantGolemModel;
import com.unpainperdu.premierpainmod.client.render.entity.wool_golem.WoolGolemModel;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class EntityLayers
{
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(MountainCurrantGolemModel.LAYER_LOCATION, MountainCurrantGolemModel::createBodyLayer);
        event.registerLayerDefinition(WoolGolemModel.LAYER_LOCATION, WoolGolemModel::createBodyLayer);
        event.registerLayerDefinition(FloweredLizardModel.LAYER_LOCATION, FloweredLizardModel::createBodyLayer);
    }
}
