package com.unpainperdu.premierpainmod.level.world.entity.blockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class VillagerDrawerBlockEntity extends BaseContainerBlockEntity
{

    protected VillagerDrawerBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState)
    {
        super(pType, pPos, pBlockState);
    }

    @Override
    protected Component getDefaultName()
    {
        return Component.translatable("container.drawer");
    }

    @Override
    protected NonNullList<ItemStack> getItems()
    {
        return null;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> pItems)
    {

    }

    @Override
    protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory)
    {
        return null;
    }

    @Override
    public int getContainerSize()
    {
        return 0;
    }

    public void dowse()
    {
        if (this.level != null)
        {
            this.markUpdated();
        }
    }
    private void markUpdated()
    {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }
}
