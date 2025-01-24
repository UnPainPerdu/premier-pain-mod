package com.unpainperdu.premierpainmod.level.world.menu.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class WaterBucketSlot extends Slot
{
    public WaterBucketSlot(Container container, int slot, int x, int y)
    {
        super(container, slot, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack)
    {
        return stack.is(Items.WATER_BUCKET);
    }
}
