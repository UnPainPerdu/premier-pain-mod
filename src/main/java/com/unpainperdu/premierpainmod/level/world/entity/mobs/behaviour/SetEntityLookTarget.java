package com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour;

import com.mojang.datafixers.util.Pair;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.behavior.EntityTracker;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.tslat.smartbrainlib.api.core.behaviour.ExtendedBehaviour;
import net.tslat.smartbrainlib.object.MemoryTest;
import net.tslat.smartbrainlib.util.BrainUtils;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * Set the {@link MemoryModuleType#LOOK_TARGET} of the brain owner from {@link MemoryModuleType#NEAREST_VISIBLE_LIVING_ENTITIES}
 *
 * @param <E> The entity
 */
public class SetEntityLookTarget<E extends LivingEntity> extends ExtendedBehaviour<E>
{
    private static final MemoryTest MEMORY_REQUIREMENTS = MemoryTest.builder(2).hasMemory(MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES).noMemory(MemoryModuleType.LOOK_TARGET);
    protected BiPredicate<E, LivingEntity> lookPredicate = this::defaultPredicate;
    protected Predicate<LivingEntity> predicate = pl -> true;
    protected LivingEntity target = null;
    private final double maxDistanceSight;

    public SetEntityLookTarget(double maxDistanceSight)
    {
        super();
        this.maxDistanceSight = maxDistanceSight;
    }

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements()
    {
        return MEMORY_REQUIREMENTS;
    }

    @Override
    protected boolean checkExtraStartConditions(ServerLevel level, E entity)
    {
        for (LivingEntity livingEntity : BrainUtils.getMemory(entity, MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES).findAll((e) -> true))
        {
            if (this.predicate.test(livingEntity) && this.lookPredicate.test(entity, livingEntity))
            {
                this.target = livingEntity;

                break;
            }
        }

        return this.target != null;
    }

    protected boolean defaultPredicate(E entity, LivingEntity livingEntity)
    {
        if (entity.hasPassenger(livingEntity))
            return false;

        if (entity instanceof Mob mob)
        {
            if (!mob.getSensing().hasLineOfSight(livingEntity))
                return false;
        }
        else if (!entity.hasLineOfSight(livingEntity))
        {
            return false;
        }

        double visibleDistance = Math.max(livingEntity.getVisibilityPercent(entity) * this.maxDistanceSight, 2);

        return entity.distanceToSqr(livingEntity) <= visibleDistance * visibleDistance;
    }

    @Override
    protected void start(E entity)
    {
        BrainUtils.setMemory(entity, MemoryModuleType.LOOK_TARGET, new EntityTracker(this.target, true));
    }

    @Override
    protected void stop(E entity)
    {
        this.target = null;
    }
}
