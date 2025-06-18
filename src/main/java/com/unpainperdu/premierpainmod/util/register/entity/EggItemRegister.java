package com.unpainperdu.premierpainmod.util.register.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.unpainperdu.premierpainmod.util.register.ItemRegister.ITEMS;

public class EggItemRegister
{
    private EggItemRegister()
    {
    }

    public static <T extends Mob> DeferredItem<Item> generateEgg(String name, DeferredHolder<EntityType<?>, EntityType<T>> entity)
    {
        return ITEMS.register(name, () -> new DeferredSpawnEggItem(entity, 16777215, 16777215, new Item.Properties()));
    }
}
