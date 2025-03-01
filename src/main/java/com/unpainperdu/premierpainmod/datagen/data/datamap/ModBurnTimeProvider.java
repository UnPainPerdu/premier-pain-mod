package com.unpainperdu.premierpainmod.datagen.data.datamap;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.tree.FlammableBlock;
import com.unpainperdu.premierpainmod.level.world.block.tree.LogBlock;
import com.unpainperdu.premierpainmod.util.register.ModList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;

import java.util.ArrayList;
import java.util.List;

public class ModBurnTimeProvider
{
    private static List<Item> verifDupli= new ArrayList<>();
    protected static void gather(DataMapProvider.Builder<FurnaceFuel, Item> burnableBuilder)
    {
        burnableBuilder.replace(false);
        //allMaterialsBlocks
        for(Item item : ModList.getAllMaterialsBlocksAsItem())
        {
            setBlockBurnableByFurnace(item, burnableBuilder);
        }
        //Log
        for(DeferredBlock<Block> deferredBlock : ModList.ALL_BLOCKS)
        {
            Block block = deferredBlock.get();
            if (block instanceof LogBlock
                    || block instanceof FlammableBlock
            )
            {
                addToBurnable(block.asItem(), 300, burnableBuilder);
            }
        }
    }

    protected static void setBlockBurnableByFurnace(Item item, DataMapProvider.Builder<FurnaceFuel, Item> burnableBuilder)
    {
        String itemName = BuiltInRegistries.ITEM.getKey(item).toString().replace(PremierPainMod.MOD_ID + ":", "");

        if ((itemName.contains("dark_oak"))
                || (itemName.contains("pale_oak"))
                || (itemName.contains("oak"))
                || (itemName.contains("birch"))
                || (itemName.contains("spruce"))
                || (itemName.contains("jungle"))
                || (itemName.contains("acacia"))
                || (itemName.contains("mangrove"))
                || (itemName.contains("cherry"))
                || (itemName.contains("bamboo"))
                || (itemName.contains("mountain_currant"))
                || (itemName.contains("moriche_palm"))
        )
        {
            addToBurnable(item, 300, burnableBuilder);
        }
    }

    private static void addToBurnable(Item item, int timeInTick, DataMapProvider.Builder<FurnaceFuel, Item> burnableBuilder)
    {
        if (!verifDupli.contains(item))
        {
            burnableBuilder.add(item.getDefaultInstance().getItemHolder(), new FurnaceFuel(timeInTick), false);
            verifDupli.add(item);
        }
    }
}
