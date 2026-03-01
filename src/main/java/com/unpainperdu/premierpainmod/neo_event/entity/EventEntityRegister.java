package com.unpainperdu.premierpainmod.neo_event.entity;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.client.render.entity.flowered_lizard.FloweredLizardModel;
import com.unpainperdu.premierpainmod.client.render.entity.mountain_currant_golem.MountainCurrantGolemModel;
import com.unpainperdu.premierpainmod.client.render.entity.wool_golem.WoolGolemModel;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.FloweredLizardEntity;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.MountainCurrantGolemEntity;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.WoolGolemEntity;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber(modid = PremierPainMod.MOD_ID)
public class EventEntityRegister
{
    @SubscribeEvent
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(MountainCurrantGolemModel.LAYER_LOCATION, MountainCurrantGolemModel::createBodyLayer);
        event.registerLayerDefinition(WoolGolemModel.LAYER_LOCATION, WoolGolemModel::createBodyLayer);
        event.registerLayerDefinition(FloweredLizardModel.LAYER_LOCATION, FloweredLizardModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event)
    {
        event.put(AllInOneEntityRegister.MOUNTAIN_CURRANT_GOLEM_ENTITY.get(), MountainCurrantGolemEntity.createAttributes().build());
        event.put(AllInOneEntityRegister.WOOL_GOLEM_ENTITY.get(), WoolGolemEntity.createAttributes().build());
        event.put(AllInOneEntityRegister.FLOWERED_LIZARD_ENTITY.get(), FloweredLizardEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacement(RegisterSpawnPlacementsEvent event)
    {
        event.register(
                AllInOneEntityRegister.FLOWERED_LIZARD_ENTITY.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FloweredLizardEntity::checkFloweredLizardSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.REPLACE
        );
    }
}