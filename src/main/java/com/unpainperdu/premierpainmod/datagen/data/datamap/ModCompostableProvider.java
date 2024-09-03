package com.unpainperdu.premierpainmod.datagen.data.datamap;

import com.unpainperdu.premierpainmod.level.world.block.vegetation.growingAboveVegetation.AbstractGrowingAboveVegetation;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.CactusFlowerBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.FloweredCactusBlock;
import com.unpainperdu.premierpainmod.util.register.ModList;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;

public class ModCompostableProvider
{
    protected static void gather(DataMapProvider.Builder<Compostable, Item> compostableBuilder)
    {
        compostableBuilder.replace(false);
        for(DeferredBlock<Block> deferredBlock : ModList.ALL_BLOCKS)
        {
            setBlockCompostable(deferredBlock.get(), compostableBuilder);
        }
        for(DeferredItem<Item> deferredItem : ModList.ALL_ITEMS)
        {
            setBlockCompostable(deferredItem.get(), compostableBuilder);
        }
    }
    private static void setBlockCompostable(Block block, DataMapProvider.Builder<Compostable, Item> compostableBuilder)
    {
        setBlockCompostable(block.asItem(), compostableBuilder);
    }

    private static void setBlockCompostable(Item item, DataMapProvider.Builder<Compostable, Item> compostableBuilder)
    {
        Block block = Block.byItem(item);
        if(block instanceof FlowerBlock
            || block instanceof CactusFlowerBlock
            || block instanceof FloweredCactusBlock
        )
        {
            compostableBuilder.add(item.getDefaultInstance().getItemHolder() ,new Compostable(0.65f),false);
        }
        else if(block instanceof AbstractGrowingAboveVegetation)
        {
            compostableBuilder.add(item.getDefaultInstance().getItemHolder() ,new Compostable(0.5f),false);
        }
    }
}
