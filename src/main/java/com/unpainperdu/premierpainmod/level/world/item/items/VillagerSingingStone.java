package com.unpainperdu.premierpainmod.level.world.item.items;

import com.unpainperdu.premierpainmod.level.world.event.item_event.villager_singing_stone_event.AbstractVillagerSingingStoneEvent;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public class VillagerSingingStone extends Item
{
    private final SoundEvent soundPlayed;
    private final String translatableDescriptionId;
    private final AbstractVillagerSingingStoneEvent event;
    private final int delayInSecond;

    public VillagerSingingStone(Properties properties, SoundEvent soundPlayed, String translatableDescriptionId, AbstractVillagerSingingStoneEvent event, int delayInSecond)
    {
        super(properties);
        this.soundPlayed = soundPlayed;
        this.translatableDescriptionId = translatableDescriptionId;
        this.event = event;
        this.delayInSecond = delayInSecond;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, Item.@NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag)
    {
        super.appendHoverText(itemStack, context, tooltipComponents, tooltipFlag);
            MutableComponent mutablecomponent = Component.translatable("item.description."+this.translatableDescriptionId);
            tooltipComponents.add(mutablecomponent.withStyle(ChatFormatting.GRAY));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand usedHand)
    {
        ItemStack itemstack = player.getItemInHand(usedHand);
        player.startUsingItem(usedHand);
        play(level, player, this.soundPlayed);
        player.getCooldowns().addCooldown(this, this.delayInSecond*20);
        player.awardStat(Stats.ITEM_USED.get(this));
        int randomNumber = new Random().nextInt(100);
        if((player.isCreative()) || (randomNumber < 35) || ((randomNumber < 95) && (player.hasEffect(MobEffects.HERO_OF_THE_VILLAGE))))
        {
            this.getEvent().castEvent(level, player, usedHand);
        }
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public int getUseDuration(@NotNull ItemStack itemStack, @NotNull LivingEntity entity)
    {
        return this.delayInSecond*20;
    }

    private static void play(Level pLevel, Player pPlayer,SoundEvent soundevent)
    {
        pLevel.playSound(pPlayer, pPlayer, soundevent, SoundSource.RECORDS, 16f, 1.0F);
    }

    private AbstractVillagerSingingStoneEvent getEvent()
    {
        return this.event;
    }
}
