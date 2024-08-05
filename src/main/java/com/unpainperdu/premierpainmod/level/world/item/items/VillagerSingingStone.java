package com.unpainperdu.premierpainmod.level.world.item.items;

import com.unpainperdu.premierpainmod.level.event.itemEvent.VillagerSingingStoneEvent.AbstractVillagerSingingStoneEvent;
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

import java.util.List;
import java.util.Random;

public class VillagerSingingStone extends Item
{
    private final SoundEvent soundPlayed;
    private final String translatableDescriptionId;
    private final AbstractVillagerSingingStoneEvent event;
    private final int delayInSecond;

    public VillagerSingingStone(Properties pProperties, SoundEvent soundPlayed, String translatableDescriptionId, AbstractVillagerSingingStoneEvent event, int delayInSecond)
    {
        super(pProperties);
        this.soundPlayed = soundPlayed;
        this.translatableDescriptionId = translatableDescriptionId;
        this.event = event;
        this.delayInSecond = delayInSecond;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag)
    {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
            MutableComponent mutablecomponent = Component.translatable("item.description."+this.translatableDescriptionId);
            pTooltipComponents.add(mutablecomponent.withStyle(ChatFormatting.GRAY));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand)
    {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);
        play(pLevel, pPlayer, this.soundPlayed);
        pPlayer.getCooldowns().addCooldown(this, this.delayInSecond*20);
        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        int randomNumber = new Random().nextInt(10);
        if((randomNumber == 4 || (pPlayer.getName().getString().equals("Dev") && pPlayer.isCreative())) || ((randomNumber < 8) && (pPlayer.hasEffect(MobEffects.HERO_OF_THE_VILLAGE))))
        {
            this.getEvent().castEvent(pLevel, pPlayer, pUsedHand);
        }
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity)
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
