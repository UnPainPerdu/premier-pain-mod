package com.unpainperdu.premierpainmod.level.world.menu.menu.allMaterialsBlock;

import com.unpainperdu.premierpainmod.level.world.menu.slot.MugAndBottleOnlySlot;
import com.unpainperdu.premierpainmod.level.world.menu.slot.NoPlacementSlot;
import com.unpainperdu.premierpainmod.level.world.menu.slot.WaterBucketSlot;
import com.unpainperdu.premierpainmod.util.ModContainerData.IFluidStackContainerData;
import com.unpainperdu.premierpainmod.util.ModContainerData.SimpleFluidContainerData;
import com.unpainperdu.premierpainmod.util.register.MenuTypesRegister;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;

public class VillagerBrewingStationMenu extends AbstractContainerMenu
{
    private static final int SLOTS = 15;
    private final Container container;
    private final ContainerData data;
    private final IFluidStackContainerData fluidData;
    private final int containerRows = 3;

    public static VillagerBrewingStationMenu VillagerBrewingStationMenu(int pContainerId, Inventory pPlayerInventory)
    {
        return new VillagerBrewingStationMenu(MenuTypesRegister.VILLAGER_BREWING_STATION.get(), pContainerId, pPlayerInventory);
    }
    public static VillagerBrewingStationMenu VillagerBrewingStationMenu(int pContainerId, Inventory pPlayerInventory, Container pContainer, ContainerData data, IFluidStackContainerData fluidData)
    {
        return new VillagerBrewingStationMenu(MenuTypesRegister.VILLAGER_BREWING_STATION.get(), pContainerId, pPlayerInventory, pContainer, data, fluidData);
    }

    private VillagerBrewingStationMenu(MenuType<?> pType, int pContainerId, Inventory pPlayerInventory)
    {
        this(pType, pContainerId, pPlayerInventory, new SimpleContainer(SLOTS), new SimpleContainerData(3), new SimpleFluidContainerData(1));
    }

    public VillagerBrewingStationMenu(int pContainerId, Inventory pPlayerInventory)
    {
        this(MenuTypesRegister.VILLAGER_BREWING_STATION.get(),pContainerId, pPlayerInventory,  new SimpleContainer(SLOTS), new SimpleContainerData(2), new SimpleFluidContainerData(1));
    }

    public VillagerBrewingStationMenu(MenuType<?> pType, int pContainerId, Inventory pPlayerInventory, Container pContainer, ContainerData data, IFluidStackContainerData fluidData)
    {
        super(MenuTypesRegister.VILLAGER_BREWING_STATION.get(), pContainerId);

        checkContainerSize(pContainer, SLOTS);
        this.data = data;
        this.fluidData = fluidData;
        System.out.println("progress : " + data.get(0));
        System.out.println("max : " + data.get(1));
        System.out.println(fluidData.get(0));
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

        this.addDataSlots(data);
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

    public boolean isBrewing()
    {
        return data.get(0) > 0;
    }

    public int getBrewingProgress()
    {
        int i = this.data.get(0);
        int j = this.data.get(1);
        int bubbleSize = 27;
        return j != 0 && i != 0 ? i * bubbleSize / j : 0;
    }

    public FluidStack getFluidStack()
    {
        return this.fluidData.get(0);
    }

    public int getFluidAmount()
    {
        return getFluidStack().getAmount();
    }

    public Fluid getFluid()
    {
        return getFluidStack().getFluid();
    }
}
