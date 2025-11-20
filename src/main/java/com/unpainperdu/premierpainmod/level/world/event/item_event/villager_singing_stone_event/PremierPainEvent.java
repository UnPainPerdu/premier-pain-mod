package com.unpainperdu.premierpainmod.level.world.event.item_event.villager_singing_stone_event;

import com.unpainperdu.premierpainmod.level.world.event.item_event.ItemEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class PremierPainEvent extends ItemEvent
{
    public PremierPainEvent()
    {
        super("premierpain");
    }

    @Override
    public void castEvent(Level level, Player player, InteractionHand usedHand)
    {

    }
}
