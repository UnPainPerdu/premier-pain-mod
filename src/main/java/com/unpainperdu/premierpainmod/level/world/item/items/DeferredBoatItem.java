package com.unpainperdu.premierpainmod.level.world.item.items;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.AbstractBoat;
import net.minecraft.world.item.BoatItem;
import net.neoforged.neoforge.registries.DeferredHolder;

public class DeferredBoatItem<T extends AbstractBoat> extends BoatItem
{
    public DeferredBoatItem(DeferredHolder<EntityType<?>, EntityType<T>> entityType, Properties properties)
    {
        super(entityType.get(), properties);
    }
}
