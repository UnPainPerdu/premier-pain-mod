package com.unpainperdu.premierpainmod.datagen.data.datamap;

import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractTallGrass;
import com.unpainperdu.premierpainmod.level.world.block.tree.ModLeavesBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.growingAboveVegetation.AbstractGrowingAboveVegetation;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.CactusFlowerBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.FloweredCactusBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.twoBlockHeight.skySpears.SkySpearsFlower;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.ModList;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;

public class ModCompostableProvider
{
    //vanilla list at compostable.json
    static DataMapProvider.Builder<Compostable, Item> builder;
    protected static void gather(DataMapProvider.Builder<Compostable, Item> compostableBuilder)
    {
        builder = compostableBuilder;
        compostableBuilder.replace(false);

        addToCompostable(ItemRegister.SKY_SPEARS_FRUIT.get(),0.6F);
        addToCompostable(ItemRegister.CACTUS_FLOWER_FRUIT.get(), 0.6F);
        addToCompostable(BlockRegister.JELLYSHROOM.get(), 0.4F);
        for(DeferredBlock<Block> deferredBlock : ModList.ALL_BLOCKS)
        {
            setCompostable(deferredBlock.get());
        }
        for(DeferredItem<Item> deferredItem : ModList.ALL_ITEMS)
        {
            setCompostable(deferredItem.get());
        }
    }
    private static void setCompostable(Block block)
    {
        setCompostable(block.asItem());
    }

    private static void setCompostable(Item item)
    {
        Block block = Block.byItem(item);
        if(block instanceof FlowerBlock
                || block instanceof CactusFlowerBlock
                || block instanceof FloweredCactusBlock
                || block instanceof AbstractTallGrass
                || block instanceof SkySpearsFlower
                || block instanceof TallFlowerBlock
        )
        {
            addToCompostable(item, 0.65f);
        }
        else if(block instanceof AbstractGrowingAboveVegetation)
        {
            addToCompostable(item, 0.5f);
        }
        else if (block instanceof ModLeavesBlock
                    || block instanceof SaplingBlock)
        {
            addToCompostable(item, 0.3f);
        }
    }

    private static void addToCompostable(Block block, float amountAddToCompost)
    {
        addToCompostable(block.asItem(), amountAddToCompost);
    }

    private static void addToCompostable(Item item, float amountAddToCompost)
    {
        builder.add(item.getDefaultInstance().getItemHolder() ,new Compostable(amountAddToCompost),false);
    }
}
