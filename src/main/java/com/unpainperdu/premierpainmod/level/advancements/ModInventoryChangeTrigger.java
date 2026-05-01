package com.unpainperdu.premierpainmod.level.advancements;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.unpainperdu.premierpainmod.util.register.CriterionRegister;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Optional;

public class ModInventoryChangeTrigger extends SimpleCriterionTrigger<ModInventoryChangeTrigger.TriggerInstance>
{
    /*
    * Just an example, not use
    * */
    @Override
    public @NotNull Codec<TriggerInstance> codec()
    {
        return TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer player, ItemStack stack)
    {
        this.trigger(player,
                triggerInstance -> triggerInstance.matches(stack)
        );
    }

    public record TriggerInstance(Optional<ContextAwarePredicate> player,
                                  ItemPredicate item) implements SimpleCriterionTrigger.SimpleInstance
    {
        public static final Codec<TriggerInstance> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(TriggerInstance::player),
                ItemPredicate.CODEC.fieldOf("item").forGetter(TriggerInstance::item)
        ).apply(instance, TriggerInstance::new));
        public static Criterion<TriggerInstance> hasAnyItems(ContextAwarePredicate player, Item... items)
        {
            if (Arrays.stream(items).toList().isEmpty())
            {
                throw new RuntimeException("hasAnyItems must have at least 1 item");
            }
            return hasAnyItems(player);
        }
        public static Criterion<TriggerInstance> hasAnyItems(ContextAwarePredicate player, ItemPredicate item)
        {
            return CriterionRegister.MOD_INVENTORY_CHANGE_TRIGGER.get().createCriterion(new TriggerInstance(Optional.of(player), item));
        }

        public boolean matches(ItemStack stack)
        {
            return this.item.test(stack);
        }

        @Override
        public @NotNull Optional<ContextAwarePredicate> player()
        {
            return this.player;
        }
    }
}