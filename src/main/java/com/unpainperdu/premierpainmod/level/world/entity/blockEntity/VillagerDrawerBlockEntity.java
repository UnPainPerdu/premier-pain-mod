package com.unpainperdu.premierpainmod.level.world.entity.blockEntity;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.menu.villagerDrawerMenu.VillagerDrawerMenu;
import com.unpainperdu.premierpainmod.util.register.BlockEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class VillagerDrawerBlockEntity extends BaseContainerBlockEntity
{
    private NonNullList<ItemStack> items = NonNullList.withSize(54, ItemStack.EMPTY);

    public VillagerDrawerBlockEntity( BlockPos pPos, BlockState pBlockState)
    {
        super(BlockEntityRegister.VILLAGER_DRAWER_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    @Override
    protected Component getDefaultName()
    {
        return Component.translatable("container."+ PremierPainMod.MODID +".villager_drawer");
    }

    @Override
    protected NonNullList<ItemStack> getItems()
    {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> pItems)
    {
        this.items = pItems;
    }

    @Override
    protected AbstractContainerMenu createMenu(int pId, Inventory pPlayer)
    {
        return VillagerDrawerMenu.VillagerDrawerMenu(pId, pPlayer, this);
    }

    @Override
    public int getContainerSize()
    {
        return 54;
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries)
    {
        super.loadAdditional(pTag, pRegistries);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(pTag, this.items, pRegistries);
        this.setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries)
    {
        super.saveAdditional(pTag, pRegistries);
        ContainerHelper.saveAllItems(pTag, this.items, pRegistries);
        this.setChanged();
    }


    @Override
    public void startOpen(Player pPlayer)
    {

    }

    @Override
    public void stopOpen(Player pPlayer)
    {

    }

}
