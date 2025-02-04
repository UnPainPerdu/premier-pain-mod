package com.unpainperdu.premierpainmod.level.event.item_event.villager_singing_stone_event;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class PremierPainEvent extends AbstractVillagerSingingStoneEvent
{
    public PremierPainEvent()
    {
        super("PremierPainEvent");
    }

    @Override
    public void castEvent(Level level, Player player, InteractionHand usedHand)
    {

    }
}
