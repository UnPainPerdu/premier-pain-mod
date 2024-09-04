package com.unpainperdu.premierpainmod.level.world.entity.blockEntity.allMaterialsBlock;

import com.unpainperdu.premierpainmod.level.world.menu.allMaterialsBlock.villagerShelfMenu.VillagerShelfMenu;
import com.unpainperdu.premierpainmod.util.register.BlockEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

public class VillagerShelfBlockEntity extends BaseContainerBlockEntity
{
    private NonNullList<ItemStack> items = NonNullList.withSize(6, ItemStack.EMPTY);
    private Block BlockShelfBound;

    public VillagerShelfBlockEntity(BlockPos pPos, BlockState pBlockState)
    {
        super(BlockEntityRegister.VILLAGER_SHELF_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    public VillagerShelfBlockEntity(BlockPos pPos, BlockState pBlockState, Block block)
    {
        super(BlockEntityRegister.VILLAGER_SHELF_BLOCK_ENTITY.get(), pPos, pBlockState);
        this.BlockShelfBound = block;
    }

    @Override
    protected Component getDefaultName()
    {
        return Component.empty();
    }

    public Block getBlockShelfBound()
    {
        return this.BlockShelfBound;
    }

    @Override
    public NonNullList<ItemStack> getItems()
    {
        return this.items;
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries)
    {
        CompoundTag compoundtag = new CompoundTag();
        ContainerHelper.saveAllItems(compoundtag, this.items, true, pRegistries);
        return compoundtag;
    }

    public void dowse()
    {
        if (this.level != null)
        {
            this.markUpdated();
        }
    }

    @Override
    protected void setItems(NonNullList<ItemStack> pItems)
    {
        this.items = pItems;
    }

    @Override
    protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory)
    {
        return VillagerShelfMenu.VillagerShelfMenu(pContainerId, pInventory, this);
    }

    @Override
    public int getContainerSize()
    {
        return 6;
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries)
    {
        super.loadAdditional(pTag, pRegistries);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(pTag, this.items, pRegistries);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries)
    {
        super.saveAdditional(pTag, pRegistries);
        ContainerHelper.saveAllItems(pTag, this.items, pRegistries);
    }

    private void markUpdated()
    {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }
    @Override
    public void stopOpen(Player pPlayer)
    {
        if (!this.remove && !pPlayer.isSpectator())
        {
            this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(pPlayer, this.getBlockState()));
            this.markUpdated();
        }
    }

    @Override
    protected void applyImplicitComponents(BlockEntity.DataComponentInput pComponentInput) {
        super.applyImplicitComponents(pComponentInput);
        pComponentInput.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).copyInto(this.getItems());
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.Builder pComponents) {
        super.collectImplicitComponents(pComponents);
        pComponents.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(this.getItems()));
    }

    @Override
    public void removeComponentsFromTag(CompoundTag pTag) {
        pTag.remove("Items");
    }

}
