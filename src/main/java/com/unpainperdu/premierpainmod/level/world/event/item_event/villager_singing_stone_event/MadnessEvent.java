package com.unpainperdu.premierpainmod.level.world.event.item_event.villager_singing_stone_event;

import com.unpainperdu.premierpainmod.level.world.event.item_event.ItemEvent;
import com.unpainperdu.premierpainmod.util.register.SoundEventRegister;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Random;

public class MadnessEvent extends ItemEvent
{
    public MadnessEvent()
    {
        super("madness");
    }

    @Override
    public void castEvent(Level level, Player player, InteractionHand usedHand)
    {
        double xPos = player.getX();
        double yPos = player.getY();
        double zPos = player.getZ();

        for (int i = 0; i < 49; i++)
        {
            double randomX = ((double) new Random().nextInt(99)) / 100;
            double randomY = ((double) new Random().nextInt(199)) / 100;
            double randomZ = ((double) new Random().nextInt(99)) / 100;
            level.addParticle(ParticleTypes.FLAME, xPos + randomX - 0.5, yPos + randomY, zPos + randomZ - 0.5, 0.0, 0.0, 0.0);
        }
        playSound(level, player, SoundEventRegister.MADNESS_SOUND.get());
        player.igniteForSeconds(10.0f);
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 5));
    }
}
