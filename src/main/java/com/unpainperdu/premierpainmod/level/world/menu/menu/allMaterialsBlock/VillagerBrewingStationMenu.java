package com.unpainperdu.premierpainmod.level.world.menu.menu.allMaterialsBlock;

import com.unpainperdu.premierpainmod.level.world.menu.slot.MugAndBottleOnlySlot;
import com.unpainperdu.premierpainmod.level.world.menu.slot.NoPlacementSlot;
import com.unpainperdu.premierpainmod.level.world.menu.slot.WaterBucketSlot;
import com.unpainperdu.premierpainmod.util.register.MenuTypesRegister;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class VillagerBrewingStationMenu extends AbstractContainerMenu
{
    private static final int SLOTS = 15;
    private final Container container;
    private final int containerRows = 3;

    public static VillagerBrewingStationMenu VillagerBrewingStationMenu(int pContainerId, Inventory pPlayerInventory)
    {
        return new VillagerBrewingStationMenu(MenuTypesRegister.VILLAGER_BREWING_STATION.get(), pContainerId, pPlayerInventory);
    }
    public static VillagerBrewingStationMenu VillagerBrewingStationMenu(int pContainerId, Inventory pPlayerInventory, Container pContainer)
    {
        return new VillagerBrewingStationMenu(MenuTypesRegister.VILLAGER_BREWING_STATION.get(), pContainerId, pPlayerInventory, pContainer);
    }

    private VillagerBrewingStationMenu(MenuType<?> pType, int pContainerId, Inventory pPlayerInventory)
    {
        this(pType, pContainerId, pPlayerInventory, new SimpleContainer(SLOTS));
    }

    public VillagerBrewingStationMenu(int pContainerId, Inventory pPlayerInventory)
    {
        this(MenuTypesRegister.VILLAGER_BREWING_STATION.get(),pContainerId, pPlayerInventory,  new SimpleContainer(SLOTS));
    }

    public VillagerBrewingStationMenu(MenuType<?> pType, int pContainerId, Inventory pPlayerInventory, Container pContainer)
    {
        super(MenuTypesRegister.VILLAGER_BREWING_STATION.get(), pContainerId);

        checkContainerSize(pContainer, SLOTS);
        this.container = pContainer;
        this.container.startOpen(pPlayerInventory.player);
        int i = (this.containerRows - 4) * 18;

        this.addSlot(new WaterBucketSlot(this.container, 0, 8, 18));
        this.addSlot(new MugAndBottleOnlySlot(this.container, 13, 8 + 8 * 18, 18));
        this.addSlot(new NoPlacementSlot(this.container, 14, 8 + 8 * 18, 18 + 2 * 18));

        int n = 1;
        for (int j = 0; j < this.containerRows; j++)
        {
            for (int k = 0; k < 4; k++)
            {
                this.addSlot(new Slot(this.container, n, 8 + (k+3) * 18, 18 + j * 18));
                n++;
            }
        }

        for (int l = 0; l < 3; l++)
        {
            for (int j1 = 0; j1 < 9; j1++)
            {
                this.addSlot(new Slot(pPlayerInventory, j1 + l * 9 + 9, 8 + j1 * 18, 102 + l * 18 + i));
            }
        }

        for (int i1 = 0; i1 < 9; i1++)
        {
            this.addSlot(new Slot(pPlayerInventory, i1, 8 + i1 * 18, 160 + i));
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
            if (pIndex < SLOTS)
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

    public Container getContainer()
    {
        return this.container;
    }
}
