package com.unpainperdu.premierpainmod.level.world.item.items.allMaterialsBlock;

import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;

public class VillagerShelfItem extends StandingAndWallBlockItem
{
    public VillagerShelfItem(Item.Properties pProperties, Block pStandingBlock, Block pWallBlock)
    {
        super(pStandingBlock, pWallBlock, pProperties, Direction.DOWN);
    }
    public VillagerShelfItem(Block pBlock, Block pWallBlock, Properties pProperties, Direction pAttachmentDirection)
    {
        super(pBlock, pWallBlock, pProperties, pAttachmentDirection);
    }
}
