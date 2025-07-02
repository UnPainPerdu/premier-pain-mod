package com.unpainperdu.premierpainmod.level.world.menu.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class OnlyTheseItemsSlot extends Slot
{
    private List<Item> items;

    public OnlyTheseItemsSlot(Container container, int slot, int x, int y, Item... items)
    {
        super(container, slot, x, y);
        this.items = Arrays.stream(items).toList();
    }

    @Override
    public boolean mayPlace(@NotNull ItemStack stack)
    {
        boolean canPlace = false;
        for (Item item : this.items)
        {
            if (stack.is(item))
            {
                canPlace = true;
                break;
            }
        }
        return canPlace;
    }
}
