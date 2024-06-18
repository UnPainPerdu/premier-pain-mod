package com.unpainperdu.premierpainmod.level.world.entity.blockEntity;

import com.unpainperdu.premierpainmod.util.register.BlockEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Clearable;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;

public class PedestalBlockEntity extends BlockEntity implements Clearable
{
    private static final int NUM_SLOTS = 1;
    private final NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);

    public PedestalBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegister.PEDESTAL_BLOCK_ENTITY.get(), pPos, pBlockState);
    }
    @Override
    public void clearContent() {
        this.items.clear();
    }
    public NonNullList<ItemStack> getItems() {
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
    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries)
    {
        super.loadAdditional(pTag, pRegistries);
        this.items.clear();
        ContainerHelper.loadAllItems(pTag, this.items, pRegistries);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries)
    {
        super.saveAdditional(pTag, pRegistries);
        ContainerHelper.saveAllItems(pTag, this.items, true, pRegistries);
    }
    private void markUpdated()
    {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }
    public boolean placeItem(@Nullable LivingEntity entity, ItemStack pstack)
    {
        for (int i = 0; i < this.items.size(); i++)
        {
            ItemStack itemstack = this.items.get(i);
            if (itemstack.isEmpty())
            {
                System.out.println("base : "+ itemstack + " now : " + pstack +" IN");
                this.items.set(i, pstack.consumeAndReturn(1, entity));
                this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(entity, this.getBlockState()));
                this.markUpdated();
                return true;
            }
        }
        return false;
    }
    public boolean removeItem(BlockPos pPos, Level level, @Nullable LivingEntity entity, ItemStack pstack)
    {
        for (int i = 0; i < this.items.size(); i++)
        {
            ItemStack itemstack = this.items.get(i);
            System.out.println("base : "+ itemstack + " now : " + pstack +" OUT");
            if (!itemstack.isEmpty())
            {
                this.dropItem(level, pPos);
                this.items.set(i, pstack.consumeAndReturn(1, entity));
                this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(entity, this.getBlockState()));
                this.markUpdated();
                return true;
            }
        }
        return false;
    }

    public void dowse() {
        if (this.level != null) {
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

    private void dropItem(Level level, BlockPos pPos)
    {
        ItemStack itemstack = this.getItems().get(0);
        if (!itemstack.isEmpty())
        {
            this.spawnAtLocation(pPos, level, itemstack, 0.0F);
        }
    }
    @Nullable
    public ItemEntity spawnAtLocation(BlockPos pPos,Level level,ItemStack pStack, float pOffsetY)
    {
        if (pStack.isEmpty())
        {
            return null;
        }
        else if (level.isClientSide)
        {
            return null;
        }
        else
        {
            ItemEntity itementity = new ItemEntity(level, pPos.getX(), pPos.getY() + (double)pOffsetY, pPos.getZ(), pStack);
            itementity.setDefaultPickUpDelay();
            level.addFreshEntity(itementity);
            return itementity;
        }
    }
}
