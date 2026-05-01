package com.unpainperdu.premierpainmod.level.world.item.items;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;

public class DeferredSpawnEgg<T extends Mob> extends SpawnEggItem
{
    public DeferredSpawnEgg(DeferredHolder<EntityType<?>, EntityType<T>> entity, Properties properties)
    {
        super(entity.get(), properties);
    }
}
