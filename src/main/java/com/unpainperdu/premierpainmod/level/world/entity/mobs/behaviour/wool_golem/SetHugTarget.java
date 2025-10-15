package com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour.wool_golem;

import com.mojang.datafixers.util.Pair;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.WoolGolemEntity;
import com.unpainperdu.premierpainmod.util.register.ai.MemoryModuleTypeRegister;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.memory.NearestVisibleLivingEntities;
import net.minecraft.world.entity.ai.memory.WalkTarget;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.tslat.smartbrainlib.api.core.behaviour.ExtendedBehaviour;
import net.tslat.smartbrainlib.object.MemoryTest;
import net.tslat.smartbrainlib.util.BrainUtils;

import java.util.List;
import java.util.function.Predicate;

public class SetHugTarget<E extends LivingEntity> extends ExtendedBehaviour<E>
{
    private static final MemoryTest MEMORY_REQUIREMENTS = MemoryTest.builder(4).hasMemory(MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES).noMemory(MemoryModuleTypeRegister.TARGET.get()).noMemory(MemoryModuleTypeRegister.TARGET_CD.get()).noMemory(MemoryModuleType.WALK_TARGET);

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements()
    {
        return MEMORY_REQUIREMENTS;
    }

    @Override
    protected void start(E entity)
    {
        setTarget(entity);
    }

    @Override
    protected void stop(E entity)
    {
        BrainUtils.setForgettableMemory(entity, MemoryModuleTypeRegister.TARGET_CD.get(), Unit.INSTANCE, 350 + RandomUtil.getRandomIntInRange(200, entity.getRandom()));
    }

    private void setTarget(E entity)
    {
        NearestVisibleLivingEntities nearestVisibleLivingEntities = BrainUtils.getMemory(entity, MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES);
        if (nearestVisibleLivingEntities != null)
        {
            LivingEntity target = null;
            List<LivingEntity> monsters = nearestVisibleLivingEntities.find(livingEntity -> livingEntity instanceof Monster).toList();
            List<LivingEntity> players = nearestVisibleLivingEntities.find(livingEntity -> livingEntity instanceof Player).filter(livingEntity ->
            {
                Player player = (Player) livingEntity;
                return !player.isCreative();
            }).filter(SetHugTarget::hasMissingHP)
                    .toList();
            List<LivingEntity> villagers = nearestVisibleLivingEntities.find(livingEntity -> livingEntity instanceof Villager).filter(SetHugTarget::hasMissingHP).toList();
            List<LivingEntity> golems = nearestVisibleLivingEntities.find(livingEntity -> livingEntity instanceof AbstractGolem).filter(SetHugTarget::hasMissingHP).toList();
            if (!monsters.isEmpty())
            {
                target = monsters.getFirst();
            }
            else if (!players.isEmpty())
            {
                target = players.getFirst();
            }
            else if (!villagers.isEmpty())
            {
                target = villagers.getFirst();
            }
            else if (!golems.isEmpty())
            {
                target = golems.getFirst();
            }
            if (target != null)
            {
                if (entity instanceof WoolGolemEntity)
                {
                    entity.setPose(Pose.SHOOTING);
                    BrainUtils.setMemory(entity, MemoryModuleTypeRegister.HAS_CHANGED_HITBOX.get(), Unit.INSTANCE);
                }
                BrainUtils.setForgettableMemory(entity, MemoryModuleTypeRegister.TARGET.get(), target, 300);
                BrainUtils.setForgettableMemory(entity, MemoryModuleType.WALK_TARGET, new WalkTarget(target, 2F, 0), 300);
            }
        }
    }

    private static boolean hasMissingHP(LivingEntity entity)
    {
        return entity.getHealth() < entity.getMaxHealth();
    }
}
