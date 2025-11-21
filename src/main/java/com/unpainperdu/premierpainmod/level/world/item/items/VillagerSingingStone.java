package com.unpainperdu.premierpainmod.level.world.item.items;

import com.unpainperdu.premierpainmod.level.world.event.item_event.ItemEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class VillagerSingingStone extends Item
{
    private final Supplier<ItemEvent> eventSupplier;
    private final int delay;

    public VillagerSingingStone(Properties properties, Supplier<ItemEvent> eventSupplier, int delay)
    {
        super(properties);
        this.eventSupplier = eventSupplier;
        this.delay = delay;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, Item.@NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag)
    {
        getEvent().addTooltipComponent(tooltipComponents);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand usedHand)
    {
        playSound(level, player, getEvent().getMusicEvent());
        ItemStack itemstack = player.getItemInHand(usedHand);
        player.startUsingItem(usedHand);
        player.getCooldowns().addCooldown(this, this.delay);
        player.awardStat(Stats.ITEM_USED.get(this));
        int randomNumber = new Random().nextInt(100);
        if ((player.isCreative()) || (randomNumber < 35) || ((randomNumber < 95) && (player.hasEffect(MobEffects.HERO_OF_THE_VILLAGE))))
        {
            this.getEvent().castEvent(level, player, usedHand);
        }
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public int getUseDuration(@NotNull ItemStack itemStack, @NotNull LivingEntity entity)
    {
        return this.delay;
    }

    private ItemEvent getEvent()
    {
        return this.eventSupplier.get();
    }

    public void playSound(Level level, Player player, SoundEvent soundEvent)
    {
        level.playSound(player, player, soundEvent, SoundSource.RECORDS, 16f, 1.0F);
    }
}
