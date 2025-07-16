package com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour;

import com.mojang.datafixers.util.Pair;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.memory.WalkTarget;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.tslat.smartbrainlib.api.core.behaviour.ExtendedBehaviour;
import net.tslat.smartbrainlib.object.MemoryTest;
import net.tslat.smartbrainlib.util.BrainUtils;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

public class SetEntityFollowTargetWhenItemInHand<E extends PathfinderMob> extends ExtendedBehaviour<E>
{
    private static final MemoryTest MEMORY_REQUIREMENTS = MemoryTest.builder(2).noMemory(MemoryModuleType.WALK_TARGET).hasMemory(MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES);

    protected BiPredicate<E, Player> positionPredicate = this::defaultPredicate;
    private final Item item;
    private final double maxDistanceSight;

    public SetEntityFollowTargetWhenItemInHand(ItemLike item, double maxDistanceSight)
    {
        this.item = item.asItem();
        this.maxDistanceSight = maxDistanceSight;
    }

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements()
    {
        return MEMORY_REQUIREMENTS;
    }

    @Override
    protected void start(E entity)
    {
        Player targetPos = getTarget(entity);

        if (!this.positionPredicate.test(entity, targetPos))
        {
            targetPos = null;
        }
        if (targetPos == null)
        {
            BrainUtils.clearMemory(entity, MemoryModuleType.WALK_TARGET);
        }
        else
        {
            BrainUtils.setMemory(entity, MemoryModuleType.WALK_TARGET, new WalkTarget(targetPos, 1.5F, 1));
        }
    }

    @Nullable
    private Player getTarget(E entity)
    {
        Optional<LivingEntity> target = BrainUtils.getMemory(entity, MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES).findClosest(this::isPlayerAndHasGoodItem);
        if (target.isPresent())
        {
            if (target.get() instanceof Player player)
            {
                return player;
            }
        }
        return null;
    }

    private boolean isPlayerAndHasGoodItem(Entity entity)
    {
        boolean isPlayerAndHasGoodItem = false;
        if (entity instanceof Player player)
        {
            ItemStack itemStackMainHand = player.getMainHandItem();
            ItemStack itemStackOffHand = player.getOffhandItem();
            if (itemStackMainHand.is(this.item) || itemStackOffHand.is(this.item))
            {
                isPlayerAndHasGoodItem = true;
            }
        }

        return isPlayerAndHasGoodItem;
    }

    private boolean defaultPredicate(PathfinderMob mob, Player player)
    {
        boolean defaultPredicateResult = false;
        if (player != null)
        {
            if (mob.getSensing().hasLineOfSight(player))
            {
                double visibleDistance = Math.max(mob.getVisibilityPercent(player) * this.maxDistanceSight, 2);
                if (mob.distanceToSqr(player) <= visibleDistance * visibleDistance)
                {
                    defaultPredicateResult = true;
                }
            }
        }
        return defaultPredicateResult;
    }
}
