package com.unpainperdu.premierpainmod.datagen.data.datamap;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMap extends DataMapProvider
{

    /**
     * Create a new provider.
     *
     * @param packOutput     the output location
     * @param lookupProvider a {@linkplain CompletableFuture} supplying the registries
     */
    public ModDataMap(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather()
    {
        Builder<Compostable, Item> compostableBuilder = builder(NeoForgeDataMaps.COMPOSTABLES);
        ModCompostableProvider.gather(compostableBuilder);
        Builder<FurnaceFuel, Item> burnableBuilder = builder(NeoForgeDataMaps.FURNACE_FUELS);
        ModBurnTimeProvider.gather(burnableBuilder);
    }
}
