package com.unpainperdu.premierpainmod.level.event.itemEvent.VillagerSingingStoneEvent;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class DiggyEvent extends AbstractVillagerSingingStoneEvent
{
    public DiggyEvent()
    {
        super("DiggyEvent");
    }

    @Override
    public void castEvent(Level level, Player player, InteractionHand usedHand)
    {
        player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED,12000, 2));
    }
}
