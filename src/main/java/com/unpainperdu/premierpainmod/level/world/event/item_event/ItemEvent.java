package com.unpainperdu.premierpainmod.level.world.event.item_event;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.List;

public abstract class ItemEvent
{
    private final String name;

    private MutableComponent description;

    public ItemEvent(String name)
    {
        this.name = name;
        this.description = Component.translatable("item_event.description." + name).withStyle(ChatFormatting.GRAY);
    }

    public String getName()
    {
        return this.name;
    }

    public void setDescription(MutableComponent description)
    {
        this.description = description;
    }

    public MutableComponent getDescription()
    {
        return this.description;
    }

    public void addTooltipComponent(List<Component> components)
    {
        components.add(description);
    }

    public abstract void castEvent(Level level, Player player, InteractionHand usedHand);

    public abstract SoundEvent getMusicEvent();
}
