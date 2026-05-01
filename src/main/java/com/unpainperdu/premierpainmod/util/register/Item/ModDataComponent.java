package com.unpainperdu.premierpainmod.util.register.Item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;

public class ModDataComponent
{
    public static final Consumable BEER = Consumable.builder()
            .animation(ItemUseAnimation.DRINK)
            .soundAfterConsume(SoundEvents.HONEY_DRINK)
            .build();
    public static final Consumable FAST_FOOD = Consumable.builder()
            .animation(ItemUseAnimation.DRINK)
            .soundAfterConsume(SoundEvents.HONEY_DRINK)
            .build();
}