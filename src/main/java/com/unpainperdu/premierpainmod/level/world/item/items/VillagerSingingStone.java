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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.List;

public class VillagerSingingStone extends Item
{
    private final SoundEvent soundPlayed;
    private final String translatableDescriptionId;
    private final AbstractVillagerSingingStoneEvent event;

    public VillagerSingingStone(Properties pProperties, SoundEvent soundPlayed, String translatableDescriptionId, AbstractVillagerSingingStoneEvent event)
    {
        super(pProperties);
        this.soundPlayed = soundPlayed;
        this.translatableDescriptionId = translatableDescriptionId;
        this.event = event;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag)
    {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
            MutableComponent mutablecomponent = Component.translatable(this.translatableDescriptionId+"_description");
            pTooltipComponents.add(mutablecomponent.withStyle(ChatFormatting.GRAY));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand)
    {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        pPlayer.startUsingItem(pUsedHand);
        play(pLevel, pPlayer, this.soundPlayed);
        pPlayer.getCooldowns().addCooldown(this, 200);
        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        this.getEvent().castEvent(pLevel, pPlayer, pUsedHand);
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity)
    {
        return 200;
    }

    /* !!! fait crash si null
    @Override
    public UseAnim getUseAnimation(ItemStack pStack)
    {
        return null;
    }
    */

    private static void play(Level pLevel, Player pPlayer,SoundEvent soundevent)
    {
        pLevel.playSound(pPlayer, pPlayer, soundevent, SoundSource.RECORDS, 16f, 1.0F);
    }

    private AbstractVillagerSingingStoneEvent getEvent()
    {
        return this.event;
    }
}
