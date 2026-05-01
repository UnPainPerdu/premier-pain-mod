package com.unpainperdu.premierpainmod.level.world.item.items.sign;

import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

public class DeferredHangingSignItem extends HangingSignItem
{
    public DeferredHangingSignItem(DeferredBlock<Block> block, DeferredBlock<Block> wallBlock, Properties properties)
    {
        super(block.get(), wallBlock.get(), properties);
    }
}
