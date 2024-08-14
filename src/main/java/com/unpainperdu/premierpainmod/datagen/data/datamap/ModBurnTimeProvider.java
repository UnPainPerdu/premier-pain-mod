package com.unpainperdu.premierpainmod.datagen.data.datamap;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.ModList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;

public class ModBurnTimeProvider
{
    protected static void gather(DataMapProvider.Builder<FurnaceFuel, Item> burnableBuilder)
    {
        burnableBuilder.replace(false);
        for(DeferredBlock<Block> deferredBlock : ModList.ALL_BLOCKS)
        {
            setBlockBurnableByFurnace(deferredBlock.get(), burnableBuilder);
        }
        for(DeferredItem<Item> deferredItem : ModList.ALL_ITEMS)
        {
            setBlockBurnableByFurnace(deferredItem.get(), burnableBuilder);
        }
    }

    protected static void setBlockBurnableByFurnace(Block block, DataMapProvider.Builder<FurnaceFuel, Item> burnableBuilder)
    {
        setBlockBurnableByFurnace(block.asItem(), burnableBuilder);
    }

    protected static void setBlockBurnableByFurnace(Item item, DataMapProvider.Builder<FurnaceFuel, Item> burnableBuilder)
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
            burnableBuilder.add(item.getDefaultInstance().getItemHolder(), new FurnaceFuel(300), false);
        }
    }
}
