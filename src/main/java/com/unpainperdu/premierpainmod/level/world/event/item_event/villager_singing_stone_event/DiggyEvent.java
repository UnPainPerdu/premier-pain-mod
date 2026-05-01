package com.unpainperdu.premierpainmod.level.world.event.item_event.villager_singing_stone_event;

import com.unpainperdu.premierpainmod.level.world.event.item_event.ItemEvent;
import com.unpainperdu.premierpainmod.util.register.SoundEventRegister;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class DiggyEvent extends ItemEvent
{
    public DiggyEvent()
    {
        super("diggy");
    }

    @Override
    public void castEvent(Level level, Player player, InteractionHand usedHand)
    {

        player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 2));
    }

    @Override
    public SoundEvent getMusicEvent()
    {
        return SoundEventRegister.DIGGY_SOUND.get();
    }
}