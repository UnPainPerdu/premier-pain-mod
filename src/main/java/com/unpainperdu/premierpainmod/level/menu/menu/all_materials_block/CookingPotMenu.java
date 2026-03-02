package com.unpainperdu.premierpainmod.level.menu.menu.all_materials_block;

import com.unpainperdu.premierpainmod.level.world.entity.block_entity.crafting_block.CookingPotBlockEntity;
import com.unpainperdu.premierpainmod.level.menu.slot.BucketSlot;
import com.unpainperdu.premierpainmod.level.menu.slot.NoPlacementSlot;
import com.unpainperdu.premierpainmod.level.menu.slot.OnlyTheseItemsSlot;
import com.unpainperdu.premierpainmod.util.register.MenuTypesRegister;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.unpainperdu.premierpainmod.level.world.entity.block_entity.crafting_block.CookingPotBlockEntity.*;

public class CookingPotMenu extends AbstractContainerMenu
{
    private final Container container;
    private final ContainerData data;
    public final CookingPotBlockEntity entity;

    public CookingPotMenu(int id, Inventory inv, BlockEntity entity)
    {
        super(MenuTypesRegister.COOKING_POT_BLOCK.get(), id);
        this.entity = (CookingPotBlockEntity) entity;
        this.data = this.entity.dataAccess;
        checkContainerSize((Container) entity, SLOT_NUMBER);
        this.container = (Container) entity;
        this.container.startOpen(inv.player);
        this.addDataSlots(data);
        this.addSlot(new BucketSlot(this.container, FLUID_INPUT, 28, 21));
        this.addSlot(new OnlyTheseItemsSlot(this.container, FLUID_OUTPUT, 28, 68, Items.BUCKET));

        for (int slotId : ITEM_INPUT)
        {
            this.addSlot(new Slot(this.container, slotId, 94, 18 + ((slotId - 1) * 24)));
        }

        for (int slotId : ITEM_OUTPUT)
        {
            this.addSlot(new NoPlacementSlot(this.container, slotId, 142, 18 + ((slotId - 4) * 24)));
        }

        //inv player
        for (int l = 0; l < 3; l++)
        {
            for (int j1 = 0; j1 < 9; j1++)
            {
                this.addSlot(new Slot(inv, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18));
            }
        }

        for (int i1 = 0; i1 < 9; i1++)
        {
            this.addSlot(new Slot(inv, i1, 8 + i1 * 18, 161));
        }
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem())
        {
            ItemStack itemStack1 = slot.getItem();
            itemstack = itemStack1.copy();
            if (index < SLOT_NUMBER)
            {
                if (!this.moveItemStackTo(itemStack1, SLOT_NUMBER, this.slots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.moveItemStackTo(itemStack1, 0, SLOT_NUMBER, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemStack1.isEmpty())
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
    public boolean stillValid(@NotNull Player player)
    {
        return stillValid(ContainerLevelAccess.create(Objects.requireNonNull(entity.getLevel()), entity.getBlockPos()), player, BlockRegister.COOKING_POT_BLOCK.get());
    }

    @Override
    public void removed(@NotNull Player pPlayer)
    {
        super.removed(pPlayer);
        this.container.stopOpen(pPlayer);
    }

    /**
     * @param index must be 0, 1 or 2
     */
    public boolean isCooking(int index)
    {
        return this.data.get(index) > 0;
    }

    public int getBrewingProgress(int index)
    {
        int currentTime = this.data.get(index);
        int arrowSize = 26;
        return currentTime != 0 ? currentTime * arrowSize / CookingPotBlockEntity.MAX_COOKING_TIME : 0;
    }

    public BlockPos getPos()
    {
        return ((BlockEntity) this.container).getBlockPos();
    }

    public BlockState getState()
    {
        return Objects.requireNonNull(((BlockEntity) this.container).getLevel()).getBlockState(getPos());
    }

    @Override
    public boolean clickMenuButton(@NotNull Player player, int id)
    {
        boolean isUsed = false;
        if (id == 0)
        {
            Level level = this.entity.getLevel();
            if (level != null)
            {
                FluidTank fluidTank = this.entity.getFluidTank();
                if (level.isClientSide())
                {
                    fluidTank.setFluid(new FluidStack(Fluids.EMPTY, 0));
                    level.playSound(player, this.entity.getBlockPos(), SoundEvents.UI_BUTTON_CLICK.value(), SoundSource.BLOCKS, 0.5F, 1.0F);
                    isUsed = true;
                }
                else
                {
                    if (!fluidTank.isEmpty())
                    {
                        fluidTank.setFluid(new FluidStack(Fluids.EMPTY, 0));
                        level.playSound(null, this.entity.getBlockPos(), SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                        isUsed = true;
                    }
                }

            }
        }
        return isUsed;
    }
}
