package com.unpainperdu.premierpainmod.level.world.event.item_event.villager_singing_stone_event;

import com.unpainperdu.premierpainmod.level.world.event.item_event.ItemEvent;
import com.unpainperdu.premierpainmod.util.register.SoundEventRegister;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.List;

public class DiggyEvent extends ItemEvent
{
    public DiggyEvent()
    {
        super("diggy");
    }

    @Override
    public void castEvent(Level level, Player player, InteractionHand usedHand)
    {
        playSound(level, player, SoundEventRegister.DIGGY_SOUND.get());
        player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 2));
    }
}
