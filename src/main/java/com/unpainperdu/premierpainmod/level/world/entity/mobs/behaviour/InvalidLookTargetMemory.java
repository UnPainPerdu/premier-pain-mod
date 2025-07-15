package com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour;

import com.mojang.datafixers.util.Pair;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.PositionTracker;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.tslat.smartbrainlib.api.core.behaviour.custom.misc.InvalidateMemory;
import net.tslat.smartbrainlib.object.MemoryTest;

import java.util.List;

public class InvalidLookTargetMemory<E extends LivingEntity> extends InvalidateMemory<E, PositionTracker>
{
    private static final MemoryTest MEMORY_REQUIREMENTS = MemoryTest.builder(1).hasMemory(MemoryModuleType.LOOK_TARGET);
    private final double maxDistanceSight;

    public InvalidLookTargetMemory(double maxDistanceSight)
    {
        super(MemoryModuleType.LOOK_TARGET);
        this.customPredicate = this::getCustomPredicate;
        this.maxDistanceSight = maxDistanceSight;
    }

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements()
    {
        return MEMORY_REQUIREMENTS;
    }

    private boolean getCustomPredicate(E entity, PositionTracker target)
    {
        boolean removeTarget = false;
        if (!target.isVisibleBy(entity))
        {
            removeTarget = true;
        }
        double visibleDistance = Math.max(this.maxDistanceSight, 2);
        if (entity.distanceToSqr(target.currentPosition()) >= visibleDistance * visibleDistance)
        {
            removeTarget = true;
        }
        return removeTarget;
    }
}
