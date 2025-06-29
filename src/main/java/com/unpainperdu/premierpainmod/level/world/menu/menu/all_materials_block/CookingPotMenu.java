package com.unpainperdu.premierpainmod.level.world.menu.menu.all_materials_block;

import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.VillagerBrewingStation;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.crafting_block.CookingPotBlockEntity;
import com.unpainperdu.premierpainmod.level.world.menu.slot.MugAndBottleOnlySlot;
import com.unpainperdu.premierpainmod.level.world.menu.slot.NoPlacementSlot;
import com.unpainperdu.premierpainmod.level.world.menu.slot.WaterBucketSlot;
import com.unpainperdu.premierpainmod.util.mod_list.ModBLockList;
import com.unpainperdu.premierpainmod.util.register.MenuTypesRegister;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

public class CookingPotMenu extends AbstractContainerMenu
{
    private static final int INPUT_SLOT = 3;
    private static final int OUTPUT_SLOT = 3;
    private final Container container;
    private final ContainerData data;
    public final CookingPotBlockEntity entity;

    public CookingPotMenu(int id, Inventory inv, BlockEntity entity)
    {
        super(MenuTypesRegister.COOKING_POT_BLOCK.get(), id);
        this.entity = (CookingPotBlockEntity) entity;
        this.data = this.entity.dataAccess;
        checkContainerSize((Container) entity, CookingPotBlockEntity.SLOT_NUMBER);
        this.container = (Container) entity;
        this.container.startOpen(inv.player);
        this.addSlot(new WaterBucketSlot(this.container, 0, 8, 18));
        this.addSlot(new MugAndBottleOnlySlot(this.container, 13, 8 + 8 * 18, 18));
        this.addSlot(new NoPlacementSlot(this.container, 14, 8 + 8 * 18, 18 + 2 * 18));

        int n = 1;
        for (int j = 0; j < 3; j++)
        {
            for (int k = 0; k < 4; k++)
            {
                this.addSlot(new Slot(this.container, n, 8 + (k+3) * 18, 18 + j * 18));
                n++;
            }
        }
        this.addDataSlots(data);


        int i = (3 - 4) * 18;

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
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem())
        {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < CookingPotBlockEntity.SLOT_NUMBER)
            {
                if (!this.moveItemStackTo(itemstack1, CookingPotBlockEntity.SLOT_NUMBER, this.slots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.moveItemStackTo(itemstack1, 0, CookingPotBlockEntity.SLOT_NUMBER, false))
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
        boolean flag = false;
        for (Block block : ModBLockList.getAllBlocksFromClass(VillagerBrewingStation.class))
        {
            if (stillValid(ContainerLevelAccess.create(entity.getLevel(), entity.getBlockPos()), pPlayer, block))
            {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void removed(Player pPlayer)
    {
        super.removed(pPlayer);
        this.container.stopOpen(pPlayer);
    }
}
