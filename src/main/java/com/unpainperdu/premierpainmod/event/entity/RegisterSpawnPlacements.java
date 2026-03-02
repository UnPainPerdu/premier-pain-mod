package com.unpainperdu.premierpainmod.event.entity;

import com.unpainperdu.premierpainmod.level.world.entity.mobs.FloweredLizardEntity;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

public class RegisterSpawnPlacements
{
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