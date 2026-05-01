package com.unpainperdu.premierpainmod.level.world.item.items.all_materials_block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

public class VillagerShelfItem extends StandingAndWallBlockItem
{
    public VillagerShelfItem(DeferredBlock<Block> standingBlock, DeferredBlock<Block> wallBlock, Item.Properties properties)
    {
        super(standingBlock.get(), wallBlock.get(), Direction.DOWN, properties);
    }
}