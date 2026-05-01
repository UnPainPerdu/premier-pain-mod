package com.unpainperdu.premierpainmod.level.world.entity.block_entity.all_materials_block;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.menu.menu.all_materials_block.VillagerDrawerMenu;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.VillagerDrawer;
import com.unpainperdu.premierpainmod.util.register.block.BlockEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.state.BlockState;

public class VillagerDrawerBlockEntity extends BaseContainerBlockEntity
{
    private NonNullList<ItemStack> items = NonNullList.withSize(27, ItemStack.EMPTY);

    private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter()
    {
        @Override
        protected void onOpen(Level level, BlockPos blockPos, BlockState blockState)
        {
            VillagerDrawerBlockEntity.this.playSound(SoundEvents.BARREL_OPEN, blockPos, level);
            VillagerDrawerBlockEntity.this.updateBlockState(blockState, true);
        }

        @Override
        protected void onClose(Level level, BlockPos pos, BlockState state)
        {
            VillagerDrawerBlockEntity.this.playSound(SoundEvents.BARREL_CLOSE, pos, level);
            VillagerDrawerBlockEntity.this.updateBlockState(state, false);
        }

        @Override
        protected void openerCountChanged(Level level, BlockPos pos, BlockState state, int count, int openCount)
        {
        }

        @Override
        protected boolean isOwnContainer(Player player)
        {
            if (player.containerMenu instanceof VillagerDrawerMenu)
            {
                Container container = ((VillagerDrawerMenu) player.containerMenu).getContainer();
                return container == VillagerDrawerBlockEntity.this;
            }
            else
            {
                return false;
            }
        }
    };

    public VillagerDrawerBlockEntity(BlockPos pos, BlockState state)
    {
        super(BlockEntityRegister.VILLAGER_DRAWER_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    protected Component getDefaultName()
    {
        return Component.translatable("container." + PremierPainMod.MOD_ID + ".villager_drawer");
    }

    @Override
    protected NonNullList<ItemStack> getItems()
    {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items)
    {
        this.items = items;
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player)
    {
        return VillagerDrawerMenu.VillagerDrawerMenu(id, player, this);
    }

    @Override
    public int getContainerSize()
    {
        return 27;
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.loadAdditional(tag, registries);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(tag, this.items, registries);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.saveAdditional(tag, registries);
        ContainerHelper.saveAllItems(tag, this.items, registries);
    }


    @Override
    public void startOpen(Player player)
    {
        if (!this.remove && !player.isSpectator())
        {
            this.openersCounter.incrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    @Override
    public void stopOpen(Player player)
    {
        if (!this.remove && !player.isSpectator())
        {
            this.openersCounter.decrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    public void recheckOpen()
    {
        if (!this.remove)
        {
            this.openersCounter.recheckOpeners(this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    void playSound(SoundEvent sound, BlockPos pos, Level level)
    {
        level.playSound(null, pos, sound, SoundSource.BLOCKS, 1.0F, 1.0F);
    }

    void updateBlockState(BlockState state, boolean open)
    {
        this.level.setBlock(this.getBlockPos(), state.setValue(VillagerDrawer.OPEN, open), 3);
    }
}