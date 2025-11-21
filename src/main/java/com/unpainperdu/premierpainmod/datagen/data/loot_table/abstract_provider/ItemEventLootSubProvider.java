package com.unpainperdu.premierpainmod.datagen.data.loot_table.abstract_provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

public abstract class ItemEventLootSubProvider implements LootTableSubProvider
{
    public static final String DIRECTORY = "item_events";

    protected final HolderLookup.Provider registries;

    protected ItemEventLootSubProvider(HolderLookup.Provider registries)
    {
        this.registries = registries;
    }

    public static ResourceKey<LootTable> createKey(String modid, String name)
    {
        return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(modid, DIRECTORY + "/" + name));
    }
}
