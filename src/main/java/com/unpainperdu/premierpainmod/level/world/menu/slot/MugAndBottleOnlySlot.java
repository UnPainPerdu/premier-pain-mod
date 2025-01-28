package com.unpainperdu.premierpainmod.level.world.menu.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class MugAndBottleOnlySlot extends Slot
{

    public MugAndBottleOnlySlot(Container container, int slot, int x, int y)
    {
        super(container, slot, x, y);
    }

    //todo change item
    @Override
    public boolean mayPlace(ItemStack stack)
    {
        return stack.is(Items.GLASS_BOTTLE) || stack.is(Items.BUCKET);
    }
}