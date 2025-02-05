package com.unpainperdu.premierpainmod.level.world.entity.block_entity.all_materials_block;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.VillagerDrawer;
import com.unpainperdu.premierpainmod.level.world.menu.menu.all_materials_block.VillagerMusicalFridgeMenu;
import com.unpainperdu.premierpainmod.level.world.menu.menu.all_materials_block.villager_drawer_menu.VillagerDrawerMenu;
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

public class VillagerMusicalFridgeBlockEntity extends BaseContainerBlockEntity
{
    private static final int CONTAINER_SIZE = 37;
    private static final int DISC_SLOT = 36;
    private static final int[] ITEMS_SLOTS = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35};
    private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter()
    {
        @Override
        protected void onOpen(Level pLevel, BlockPos pBlockPos, BlockState pBlockState)
        {
            VillagerMusicalFridgeBlockEntity.this.playSound(pBlockState, SoundEvents.BARREL_OPEN, pBlockPos, pLevel);
            VillagerMusicalFridgeBlockEntity.this.updateBlockStateIsOpen(pBlockState, true);
        }

        @Override
        protected void onClose(Level pLevel, BlockPos pBlockPos, BlockState pBlockState)
        {
            VillagerMusicalFridgeBlockEntity.this.playSound(pBlockState, SoundEvents.BARREL_CLOSE, pBlockPos, pLevel);
            VillagerMusicalFridgeBlockEntity.this.updateBlockStateIsOpen(pBlockState, false);
        }

        @Override
        protected void openerCountChanged(Level p_155066_, BlockPos p_155067_, BlockState p_155068_, int p_155069_, int p_155070_)
        {
        }

        @Override
        protected boolean isOwnContainer(Player player)
        {
            if (player.containerMenu instanceof VillagerMusicalFridgeMenu)
            {
                Container container = ((VillagerMusicalFridgeMenu)player.containerMenu).getContainer();
                return container == VillagerMusicalFridgeBlockEntity.this;
            }
            else
            {
                return false;
            }
        }
    };


    private NonNullList<ItemStack> items = NonNullList.withSize(CONTAINER_SIZE, ItemStack.EMPTY);

    public VillagerMusicalFridgeBlockEntity(BlockPos pos, BlockState blockState)
    {
        super(BlockEntityRegister.VILLAGER_MUSICAL_FRIDGE_ENTITY.get(), pos, blockState);
    }

    @Override
    protected Component getDefaultName()
    {
        return Component.translatable("container."+ PremierPainMod.MOD_ID +".villager_musical_fridge");
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

    protected ItemStack getDisc()
    {
        return this.items.get(DISC_SLOT);
    }

    protected void setDisc(ItemStack itemStack)
    {
        this.items.set(DISC_SLOT, itemStack);
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
    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory)
    {
        return new VillagerMusicalFridgeMenu(containerId, inventory, this);
    }

    @Override
    public int getContainerSize()
    {
        return CONTAINER_SIZE;
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
    void updateBlockStateIsOpen(BlockState pState, boolean pOpen)
    {
        this.level.setBlock(this.getBlockPos(), pState.setValue(VillagerDrawer.OPEN, Boolean.valueOf(pOpen)), 3);
    }
}
