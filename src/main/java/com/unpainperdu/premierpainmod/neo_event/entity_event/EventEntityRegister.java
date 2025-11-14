package com.unpainperdu.premierpainmod.neo_event.entity_event;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.client.render.entity.mountain_currant_golem.MountainCurrantGolemModel;
import com.unpainperdu.premierpainmod.client.render.entity.wool_golem.WoolGolemModel;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.MountainCurrantGolemEntity;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.WoolGolemEntity;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = PremierPainMod.MOD_ID)
public class EventEntityRegister
{
    @SubscribeEvent
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(MountainCurrantGolemModel.LAYER_LOCATION, MountainCurrantGolemModel::createBodyLayer);
        event.registerLayerDefinition(WoolGolemModel.LAYER_LOCATION, WoolGolemModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event)
    {
        event.put(AllInOneEntityRegister.MOUNTAIN_CURRANT_GOLEM_ENTITY.get(), MountainCurrantGolemEntity.createAttributes().build());
        event.put(AllInOneEntityRegister.WOOL_GOLEM_ENTITY.get(), WoolGolemEntity.createAttributes().build());
    }
}
