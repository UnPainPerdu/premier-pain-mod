package com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour;

import com.mojang.datafixers.util.Pair;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.tslat.smartbrainlib.api.core.behaviour.ExtendedBehaviour;
import net.tslat.smartbrainlib.object.MemoryTest;
import net.tslat.smartbrainlib.util.BrainUtils;

import java.util.List;

public class ConvertLastHitByEntityIntoTarget<E extends LivingEntity> extends ExtendedBehaviour<E>
{
    private static final MemoryTest MEMORY_REQUIREMENTS = MemoryTest.builder(2).usesMemory(MemoryModuleType.ATTACK_TARGET).hasMemory(MemoryModuleType.HURT_BY_ENTITY);

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements()
    {
        return MEMORY_REQUIREMENTS;
    }

    @Override
    protected void start(E entity)
    {
        LivingEntity livingEntity = BrainUtils.getMemory(entity, MemoryModuleType.HURT_BY_ENTITY);

        if (livingEntity != null)
        {
            BrainUtils.clearMemory(entity, MemoryModuleType.HURT_BY_ENTITY);
            BrainUtils.setForgettableMemory(entity, MemoryModuleType.ATTACK_TARGET, livingEntity, 120);
        }

    }
}
