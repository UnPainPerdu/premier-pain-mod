package com.unpainperdu.premierpainmod.level.world.entity.block_entity.all_materials_block;

import com.unpainperdu.premierpainmod.util.register.block.BlockEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Clearable;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Objects;

public class PedestalBlockEntity extends BlockEntity implements Clearable
{
    private final NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);

    public PedestalBlockEntity(BlockPos pos, BlockState blockState)
    {
        super(BlockEntityRegister.PEDESTAL_BLOCK_ENTITY.get(), pos, blockState);
    }

    @Override
    public void clearContent()
    {
        this.items.clear();
    }

    public NonNullList<ItemStack> getItems()
    {
        return this.items;
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider registries)
    {
        CompoundTag compoundtag = new CompoundTag();
        ContainerHelper.saveAllItems(compoundtag, this.items, true, registries);
        return compoundtag;
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries)
    {
        super.loadAdditional(tag, registries);
        this.items.clear();
        ContainerHelper.loadAllItems(tag, this.items, registries);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries)
    {
        super.saveAdditional(tag, registries);
        ContainerHelper.saveAllItems(tag, this.items, true, registries);
    }

    private void markUpdated()
    {
        if (this.level != null)
        {
            this.setChanged();
            this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
        }
    }

    public boolean placeItem(@Nullable LivingEntity entity, ItemStack itemStack)
    {
        for (int i = 0; i < this.items.size(); i++)
        {
            ItemStack itemstack = this.items.get(i);
            if (itemstack.isEmpty() && this.level != null)
            {
                this.items.set(i, itemStack.consumeAndReturn(1, entity));
                this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(entity, this.getBlockState()));
                this.markUpdated();
                return true;
            }
        }
        return false;
    }

    public boolean removeItem(BlockPos pPos, Level level, @Nullable LivingEntity entity, ItemStack itemStack)
    {
        for (int i = 0; i < this.items.size(); i++)
        {
            ItemStack itemstack = this.items.get(i);
            if (!itemstack.isEmpty())
            {
                Containers.dropContents(level, pPos, ((PedestalBlockEntity) Objects.requireNonNull(level.getBlockEntity(pPos))).getItems());
                this.items.set(i, itemStack.consumeAndReturn(1, entity));
                level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(entity, this.getBlockState()));
                this.markUpdated();
                return true;
            }
        }
        return false;
    }

    @Override
    protected void applyImplicitComponents(BlockEntity.@NotNull DataComponentInput componentInput)
    {
        super.applyImplicitComponents(componentInput);
        componentInput.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).copyInto(this.getItems());
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.@NotNull Builder components)
    {
        super.collectImplicitComponents(components);
        components.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(this.getItems()));
    }
}