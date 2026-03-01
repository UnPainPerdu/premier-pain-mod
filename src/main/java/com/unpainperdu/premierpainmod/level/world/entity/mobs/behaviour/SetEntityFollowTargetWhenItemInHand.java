package com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour;

import com.mojang.datafixers.util.Pair;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.memory.NearestVisibleLivingEntities;
import net.minecraft.world.entity.ai.memory.WalkTarget;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.tslat.smartbrainlib.api.core.behaviour.ExtendedBehaviour;
import net.tslat.smartbrainlib.object.MemoryTest;
import net.tslat.smartbrainlib.util.BrainUtils;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

public class SetEntityFollowTargetWhenItemInHand<E extends PathfinderMob> extends ExtendedBehaviour<E> //TODO remove and replace use by net.tslat.smartbrainlib.api.core.behaviour.custom.move.FollowTemptation
{
    private static final MemoryTest MEMORY_REQUIREMENTS = MemoryTest.builder(2).noMemory(MemoryModuleType.WALK_TARGET).hasMemory(MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES);

    protected BiPredicate<E, Player> positionPredicate = this::defaultPredicate;
    private final List<Item> items;
    private final List<TagKey<Item>> itemTags;
    private final double maxDistanceSight;

    public static <E extends PathfinderMob> Builder<E> builder()
    {
        return new Builder<>();
    }

    private SetEntityFollowTargetWhenItemInHand(List<Item> items, List<TagKey<Item>> itemTags, double maxDistanceSight)
    {
        this.items = items;
        this.itemTags = itemTags;
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
        NearestVisibleLivingEntities nearestVisibleEntity = BrainUtils.getMemory(entity, MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES);
        if (nearestVisibleEntity != null)
        {
            Optional<LivingEntity> targetedPlayer = nearestVisibleEntity.findClosest(e -> e instanceof Player);
            if (targetedPlayer.isPresent())
            {
                if (playerHasGoodItem((Player) targetedPlayer.get()))
                {
                    return (Player) targetedPlayer.get();
                }
            }
        }
        return null;
    }

    private boolean playerHasGoodItem(Player player)
    {
        boolean playerHasGoodItem = false;
        ItemStack itemStackMainHand = player.getMainHandItem();
        ItemStack itemStackOffHand = player.getOffhandItem();
        for (Item item : this.items)
        {
            if (itemStackMainHand.is(item) || itemStackOffHand.is(item))
            {
                playerHasGoodItem = true;
                break;
            }
        }
        if (!playerHasGoodItem)
        {
            for (TagKey<Item> itemTags : this.itemTags)
            {
                if (itemStackMainHand.is(itemTags) || itemStackOffHand.is(itemTags))
                {
                    playerHasGoodItem = true;
                    break;
                }
            }
        }

        return playerHasGoodItem;
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

    public static class Builder<E extends PathfinderMob>
    {
        private List<Item> items = List.of();
        private List<TagKey<Item>> itemTags = List.of();
        private double maxDistanceSight;

        public Builder<E> setItems(ItemLike... itemLikes)
        {
            this.items = Arrays.stream(itemLikes).map(ItemLike::asItem).toList();
            return this;
        }

        public Builder<E> setItemTags(TagKey<Item>... tags)
        {
            this.itemTags = Arrays.stream(tags).toList();
            return this;
        }

        /**
         * @param maxDistanceSight must be => 1
         */
        public Builder<E> setMaxDistanceSight(double maxDistanceSight)
        {
            this.maxDistanceSight = maxDistanceSight;
            return this;
        }

        public SetEntityFollowTargetWhenItemInHand<E> build()
        {
            if (this.items.isEmpty() && this.itemTags.isEmpty())
            {
                throw new RuntimeException("items and itemsTags must totalized atleast one element");
            }
            if (this.maxDistanceSight < 1)
            {
                throw new RuntimeException("maxDistanceSight must be => 1");
            }

            return new SetEntityFollowTargetWhenItemInHand<>(this.items, this.itemTags, this.maxDistanceSight);
        }
    }
}
