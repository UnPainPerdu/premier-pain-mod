package com.unpainperdu.premierpainmod.datagen.data;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.ModList;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModBurnTimeProvider extends DataMapProvider
{
    public ModBurnTimeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather()
    {
        Builder<FurnaceFuel, Item> builder = builder(NeoForgeDataMaps.FURNACE_FUELS);
        builder.replace(false);
        for(DeferredBlock<Block> deferredBlock : ModList.ALL_BLOCKS)
        {
            setBlockBurnableByFurnace(deferredBlock.get(), builder);
        }
        for(DeferredItem<Item> deferredItem : ModList.ALL_ITEMS)
        {
            setBlockBurnableByFurnace(deferredItem.get(), builder);
        }
    }

    private void setBlockBurnableByFurnace(Block block, Builder<FurnaceFuel, Item> builder)
    {
        setBlockBurnableByFurnace(block.asItem(), builder);
    }

    private void setBlockBurnableByFurnace(Item item, Builder<FurnaceFuel, Item> builder)
    {
        String itemName = BuiltInRegistries.ITEM.getKey(item).toString().replace(PremierPainMod.MOD_ID + ":", "");

        if ((itemName.contains("dark_oak"))
                || (itemName.contains("oak"))
                || (itemName.contains("birch"))
                || (itemName.contains("spruce"))
                || (itemName.contains("jungle"))
                || (itemName.contains("acacia"))
                || (itemName.contains("mangrove"))
                || (itemName.contains("cherry"))
                || (itemName.contains("bamboo"))
        )
        {
            builder.add(item.getDefaultInstance().getItemHolder() ,new FurnaceFuel(300),false);
        }
    }
}
