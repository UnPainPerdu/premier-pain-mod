package com.unpainperdu.premierpainmod.level.world.menu.villagerDrawerMenu;

import com.unpainperdu.premierpainmod.util.register.MenuTypesRegister;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class VillagerDrawerMenu extends AbstractContainerMenu
{
    private static final int SLOTS_PER_ROW = 9;
    private final Container container;
    private final int containerRows;


    public static VillagerDrawerMenu VillagerDrawerMenu(int pContainerId, Inventory pPlayerInventory)
    {
        return new VillagerDrawerMenu(MenuTypesRegister.VILLAGER_DRAWER.get(), pContainerId, pPlayerInventory, 3);
    }
    public static VillagerDrawerMenu VillagerDrawerMenu(int pContainerId, Inventory pPlayerInventory, Container pContainer)
    {
        return new VillagerDrawerMenu(MenuTypesRegister.VILLAGER_DRAWER.get(), pContainerId, pPlayerInventory, pContainer, 3);
    }

    private VillagerDrawerMenu(MenuType<?> pType, int pContainerId, Inventory pPlayerInventory, int pRows)
    {
        this(pType, pContainerId, pPlayerInventory, new SimpleContainer(9 * pRows), pRows);
    }

    public VillagerDrawerMenu(int pContainerId, Inventory pPlayerInventory)
    {
        this(MenuTypesRegister.VILLAGER_DRAWER.get(),pContainerId, pPlayerInventory,  new SimpleContainer(9 * 3),3);
    }

    public VillagerDrawerMenu(MenuType<?> pType, int pContainerId, Inventory pPlayerInventory, Container pContainer, int pRows)
    {
        super(MenuTypesRegister.VILLAGER_DRAWER.get(), pContainerId);

        checkContainerSize(pContainer, 9 * 3);
        this.container = new SimpleContainer(9 * 3);

        this.containerRows = pRows;
        this.container.startOpen(pPlayerInventory.player);
        int i = (this.containerRows - 4) * 18;

        for (int j = 0; j < this.containerRows; j++)
        {
            for (int k = 0; k < 9; k++)
            {
                this.addSlot(new Slot(this.container, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }

        for (int l = 0; l < 3; l++)
        {
            for (int j1 = 0; j1 < 9; j1++)
            {
                this.addSlot(new Slot(pPlayerInventory, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
            }
        }

        for (int i1 = 0; i1 < 9; i1++)
        {
            this.addSlot(new Slot(pPlayerInventory, i1, 8 + i1 * 18, 161 + i));
        }
    }



    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot != null && slot.hasItem())
        {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (pIndex < this.containerRows * 9)
            {
                if (!this.moveItemStackTo(itemstack1, this.containerRows * 9, this.slots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, this.containerRows * 9, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.setByPlayer(ItemStack.EMPTY);
            } else
            {
                slot.setChanged();
            }
        }

        return itemstack;
    }


    @Override
    public boolean stillValid(Player pPlayer)
    {
        return this.container.stillValid(pPlayer);
    }

    @Override
    public void removed(Player pPlayer)
    {
        super.removed(pPlayer);
        this.container.stopOpen(pPlayer);
    }

    public Container getContainer() {
        return this.container;
    }

    public int getRowCount() {
        return this.containerRows;
    }
}
