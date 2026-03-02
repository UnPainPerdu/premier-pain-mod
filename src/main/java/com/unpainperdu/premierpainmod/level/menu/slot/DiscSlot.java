package com.unpainperdu.premierpainmod.level.menu.slot;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class DiscSlot extends Slot
{
    public DiscSlot(Container container, int slot, int x, int y)
    {
        super(container, slot, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack)
    {
        return stack.has(DataComponents.JUKEBOX_PLAYABLE);
    }
}
