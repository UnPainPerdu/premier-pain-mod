package com.unpainperdu.premierpainmod.event.entity;

import com.unpainperdu.premierpainmod.level.world.entity.mobs.FloweredLizardEntity;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.MountainCurrantGolemEntity;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.WoolGolemEntity;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

public class EntityAttributes
{
    public static void registerEntityAttributes(EntityAttributeCreationEvent event)
    {
        event.put(AllInOneEntityRegister.MOUNTAIN_CURRANT_GOLEM_ENTITY.get(), MountainCurrantGolemEntity.createAttributes().build());
        event.put(AllInOneEntityRegister.WOOL_GOLEM_ENTITY.get(), WoolGolemEntity.createAttributes().build());
        event.put(AllInOneEntityRegister.FLOWERED_LIZARD_ENTITY.get(), FloweredLizardEntity.createAttributes().build());
    }
}