package com.unpainperdu.premierpainmod.level.menu.menu.all_materials_block;

import com.unpainperdu.premierpainmod.level.menu.slot.DiscSlot;
import com.unpainperdu.premierpainmod.util.register.MenuTypesRegister;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class VillagerMusicalFridgeMenu extends AbstractContainerMenu
{
    private static final int SLOTS = 37;
    private final Container container;
    private static final int CONTAINER_ROWS = 6;
    private static final int SLOTS_PER_ROW = 6;

    public VillagerMusicalFridgeMenu(int id, Inventory inv)
    {
        this(id, inv, new SimpleContainer(SLOTS));
    }

    public VillagerMusicalFridgeMenu(int id, Inventory inv, Container container)
    {
        super(MenuTypesRegister.VILLAGER_MUSICAL_FRIDGE.get(), id);
        checkContainerSize(container, SLOTS);
        this.container = container;
        this.container.startOpen(inv.player);
        int i = (CONTAINER_ROWS - 4) * 18;

        for (int j = 0; j < CONTAINER_ROWS; j++)
        {
            for (int k = 0; k < SLOTS_PER_ROW; k++)
            {
                this.addSlot(new Slot(this.container, (k + j * SLOTS_PER_ROW) + 1, 35 + k * 18, 18 + j * 18));
            }
        }

        this.addSlot(new DiscSlot(this.container, 0, 147, 108));


        //player inv drawing
        for (int l = 0; l < 3; l++)
        {
            for (int j1 = 0; j1 < 9; j1++)
            {
                this.addSlot(new Slot(inv, j1 + l * 9 + 9, 8 + j1 * 18, 102 + l * 18 + i));
            }
        }

        for (int i1 = 0; i1 < 9; i1++)
        {
            this.addSlot(new Slot(inv, i1, 8 + i1 * 18, 160 + i));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem())
        {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < SLOTS)
            {
                if (!this.moveItemStackTo(itemstack1, SLOTS, this.slots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.moveItemStackTo(itemstack1, 0, SLOTS, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.setByPlayer(ItemStack.EMPTY);
            }
            else
            {
                slot.setChanged();
            }
        }

        return itemstack;
    }


    @Override
    public boolean stillValid(Player player)
    {
        return this.container.stillValid(player);
    }

    @Override
    public void removed(Player player)
    {
        super.removed(player);
        this.container.stopOpen(player);
    }

    public Container getContainer()
    {
        return this.container;
    }

    public int getContainerRows()
    {
        return CONTAINER_ROWS;
    }
}