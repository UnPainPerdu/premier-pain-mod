package com.unpainperdu.premierpainmod.level.event.item_event.villager_singing_stone_event;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public abstract class AbstractVillagerSingingStoneEvent
{
    private String name;

    public AbstractVillagerSingingStoneEvent(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public abstract void castEvent(Level level, Player player, InteractionHand usedHand);

    protected int secondToTick(int second)
    {
        return second * 20;
    }
}
