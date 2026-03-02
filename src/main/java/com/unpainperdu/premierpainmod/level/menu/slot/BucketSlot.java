package com.unpainperdu.premierpainmod.level.menu.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class BucketSlot extends Slot
{
    public BucketSlot(Container container, int slot, int x, int y)
    {
        super(container, slot, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack)
    {
        return stack.getItem() instanceof BucketItem && !stack.is(Items.BUCKET);
    }
}
