package com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour;

import com.mojang.datafixers.util.Pair;
import com.unpainperdu.premierpainmod.util.register.ai.MemoryModuleTypeRegister;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.tslat.smartbrainlib.api.core.behaviour.ExtendedBehaviour;
import net.tslat.smartbrainlib.object.MemoryTest;
import net.tslat.smartbrainlib.util.BrainUtil;

import java.util.List;

public class RestoreHitbox<E extends LivingEntity> extends ExtendedBehaviour<E>
{
    private static final MemoryTest MEMORY_REQUIREMENTS = MemoryTest.builder(3).noMemory(MemoryModuleTypeRegister.TARGET.get()).noMemory(MemoryModuleTypeRegister.HAS_CHANGED_HITBOX_TIMER.get()).hasMemory(MemoryModuleTypeRegister.HAS_CHANGED_HITBOX.get());

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements()
    {
        return MEMORY_REQUIREMENTS;
    }

    @Override
    protected void start(E entity)
    {
        entity.setPose(Pose.STANDING);
    }

    @Override
    protected void stop(E entity)
    {
        BrainUtil.clearMemory(entity, MemoryModuleTypeRegister.HAS_CHANGED_HITBOX.get());
    }
}