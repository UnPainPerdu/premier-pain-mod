package com.unpainperdu.premierpainmod.level.world.item.items.sign;

import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

public class DeferredSignItem extends SignItem
{
    public DeferredSignItem(DeferredBlock<Block> standingBlock, DeferredBlock<Block> wallBlock, Properties properties)
    {
        super(standingBlock.get(), wallBlock.get(), properties);
    }
}