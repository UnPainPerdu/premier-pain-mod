package com.unpainperdu.premierpainmod.level.world.entity.blockEntity;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidthWithBlockEntity.VillagerDrawer;
import com.unpainperdu.premierpainmod.level.world.menu.villagerDrawerMenu.VillagerDrawerMenu;
import com.unpainperdu.premierpainmod.util.register.BlockEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
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
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.entity.BarrelBlockEntity;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.state.BlockState;

public class VillagerDrawerBlockEntity extends BaseContainerBlockEntity
{
    private NonNullList<ItemStack> items = NonNullList.withSize(27, ItemStack.EMPTY);

    private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter()
    {
        @Override
        protected void onOpen(Level pLevel, BlockPos pBlockPos, BlockState pBlockState)
        {
            VillagerDrawerBlockEntity.this.playSound(pBlockState, SoundEvents.BARREL_OPEN, pBlockPos, pLevel);
            VillagerDrawerBlockEntity.this.updateBlockState(pBlockState, true);
        }

        @Override
        protected void onClose(Level pLevel, BlockPos pBlockPos, BlockState pBlockState)
        {
            VillagerDrawerBlockEntity.this.playSound(pBlockState, SoundEvents.BARREL_CLOSE, pBlockPos, pLevel);
            VillagerDrawerBlockEntity.this.updateBlockState(pBlockState, false);
        }

        @Override
        protected void openerCountChanged(Level p_155066_, BlockPos p_155067_, BlockState p_155068_, int p_155069_, int p_155070_)
        {
        }

        @Override
        protected boolean isOwnContainer(Player p_155060_)
        {
            if (p_155060_.containerMenu instanceof VillagerDrawerMenu)
            {
                Container container = ((VillagerDrawerMenu)p_155060_.containerMenu).getContainer();
                return container == VillagerDrawerBlockEntity.this;
            } else {
                return false;
            }
        }
    };

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
        return 27;
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


    @Override
    public void startOpen(Player pPlayer)
    {
        if (!this.remove && !pPlayer.isSpectator())
        {
            this.openersCounter.incrementOpeners(pPlayer, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    @Override
    public void stopOpen(Player pPlayer)
    {
        if (!this.remove && !pPlayer.isSpectator())
        {
            this.openersCounter.decrementOpeners(pPlayer, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    public void recheckOpen()
    {
        if (!this.remove)
        {
            this.openersCounter.recheckOpeners(this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }
    void playSound(BlockState pState, SoundEvent pSound, BlockPos pos, Level level)
    {
        level.playSound(null, pos, pSound, SoundSource.BLOCKS, 1.0F, 1.0F);
    }
    void updateBlockState(BlockState pState, boolean pOpen)
    {
        this.level.setBlock(this.getBlockPos(), pState.setValue(VillagerDrawer.OPEN, Boolean.valueOf(pOpen)), 3);
    }
}
