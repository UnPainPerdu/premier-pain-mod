package com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour.wool_golem;

import com.mojang.datafixers.util.Pair;
import com.unpainperdu.premierpainmod.util.register.ai.MemoryModuleTypeRegister;
import net.minecraft.util.Unit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.EntityTracker;
import net.minecraft.world.entity.ai.behavior.PositionTracker;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.monster.Monster;
import net.tslat.smartbrainlib.api.core.behaviour.ExtendedBehaviour;
import net.tslat.smartbrainlib.object.MemoryTest;
import net.tslat.smartbrainlib.util.BrainUtils;

import java.util.List;

public class Huging<E extends LivingEntity> extends ExtendedBehaviour<E>
{
    private static final MemoryTest MEMORY_REQUIREMENTS = MemoryTest.builder(1).hasMemory(MemoryModuleTypeRegister.TARGET.get());

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements()
    {
        return MEMORY_REQUIREMENTS;
    }

    @Override
    protected void start(E entity)
    {
        if (isInHugRange(entity))
        {
            hug(entity);
        }
    }

    @Override
    protected void stop(E entity)
    {
        BrainUtils.clearMemory(entity, MemoryModuleTypeRegister.TARGET.get());
        BrainUtils.setForgettableMemory(entity, MemoryModuleTypeRegister.HAS_CHANGED_HITBOX_TIMER.get(), Unit.INSTANCE, 60);
    }

    private boolean isInHugRange(E entity)
    {
        boolean isInHugRange = false;
        LivingEntity target = BrainUtils.getMemory(entity, MemoryModuleTypeRegister.TARGET.get());
        if (target != null)
        {
            PositionTracker positionTracker = new EntityTracker(target, false);
            if (positionTracker.currentBlockPosition().distManhattan(entity.blockPosition()) <= 1)
            {
                return true;
            }
        }
        return isInHugRange;
    }

    private void hug(E entity)
    {
        LivingEntity target = BrainUtils.getMemory(entity, MemoryModuleTypeRegister.TARGET.get());
        if (target != null)
        {
            if (target instanceof Monster)
            {
                target.kill();
            }
            else
            {
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 10));
                entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 5));
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 10));
                target.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 5));
                target.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 5));
            }
            entity.level().broadcastEntityEvent(entity, (byte) 100);
        }
    }
}
