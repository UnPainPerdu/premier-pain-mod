package com.unpainperdu.premierpainmod.level.world.entity.block_entity.all_materials_block;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height_with_block_entity.VillagerMusicalFridgeBlock;
import com.unpainperdu.premierpainmod.level.world.menu.menu.all_materials_block.VillagerMusicalFridgeMenu;
import com.unpainperdu.premierpainmod.util.register.block.BlockEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
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
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.item.JukeboxSongPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import java.util.Optional;

public class VillagerMusicalFridgeBlockEntity extends BaseContainerBlockEntity
{
    private static final int CONTAINER_SIZE = 37;
    private static final int DISC_SLOT = 0;
    private static final int[] ITEMS_SLOTS = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
    private final JukeboxSongPlayer jukeboxSongPlayer = new JukeboxSongPlayer(this::onSongChanged, this.getBlockPos());
    private static int BASE_TIME_TO_WAIT = 6000;
    private int timeInTickForLastMusicPlay;
    private static String TIME_IN_TICK_FOR_LAST_MUSIC_PLAY_ID ="timeInTickForLastMusicPlay";

    private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter()
    {
        @Override
        protected void onOpen(Level level, BlockPos pos, BlockState state)
        {
            VillagerMusicalFridgeBlockEntity.this.playSound(state, SoundEvents.BARREL_OPEN, pos, level);
            VillagerMusicalFridgeBlockEntity.this.updateBlockStateIsOpen(state, pos, true);
            Optional<Holder<JukeboxSong>> optional = JukeboxSong.fromStack(level.registryAccess(), VillagerMusicalFridgeBlockEntity.this.getDisc());

            boolean flag = !VillagerMusicalFridgeBlockEntity.this.getDisc().isEmpty();
            if (flag && optional.isPresent() && VillagerMusicalFridgeBlockEntity.this.timeInTickForLastMusicPlay == 6000)
            {
                VillagerMusicalFridgeBlockEntity.this.jukeboxSongPlayer.play(level, optional.get());
                VillagerMusicalFridgeBlockEntity.this.timeInTickForLastMusicPlay = 0;
            }
            if (!flag)
            {
                VillagerMusicalFridgeBlockEntity.this.jukeboxSongPlayer.stop(level, getBlockState());
            }
        }

        @Override
        protected void onClose(Level level, BlockPos pos, BlockState state)
        {
            VillagerMusicalFridgeBlockEntity.this.playSound(state, SoundEvents.BARREL_CLOSE, pos, level);
            VillagerMusicalFridgeBlockEntity.this.updateBlockStateIsOpen(state, pos, false);
            boolean flag = VillagerMusicalFridgeBlockEntity.this.getDisc().isEmpty();
            if (flag)
            {
                VillagerMusicalFridgeBlockEntity.this.jukeboxSongPlayer.stop(level, getBlockState());
            }
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
        this.timeInTickForLastMusicPlay = 6000;
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
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.loadAdditional(tag, registries);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(tag, this.items, registries);
        this.timeInTickForLastMusicPlay = tag.getInt(TIME_IN_TICK_FOR_LAST_MUSIC_PLAY_ID);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.saveAdditional(tag, registries);
        tag.putInt(TIME_IN_TICK_FOR_LAST_MUSIC_PLAY_ID, this.timeInTickForLastMusicPlay);
        ContainerHelper.saveAllItems(tag, this.items, registries);
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

    public JukeboxSongPlayer getJukeboxSongPlayer()
    {
        return jukeboxSongPlayer;
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
    void updateBlockStateIsOpen(BlockState state, BlockPos pos, boolean open)
    {
        if (state.getValue(VillagerMusicalFridgeBlock.HALF) == DoubleBlockHalf.LOWER)
        {
            this.level.setBlock(pos.above(), state.setValue(VillagerMusicalFridgeBlock.OPEN, open).setValue(VillagerMusicalFridgeBlock.HALF, DoubleBlockHalf.UPPER), 3);
        }
        else
        {
            this.level.setBlock(pos.below(), state.setValue(VillagerMusicalFridgeBlock.OPEN, open).setValue(VillagerMusicalFridgeBlock.HALF, DoubleBlockHalf.LOWER), 3);
        }
        this.level.setBlock(pos, state.setValue(VillagerMusicalFridgeBlock.OPEN, open), 3);
    }

    public void onSongChanged()
    {
        this.level.updateNeighborsAt(this.getBlockPos(), this.getBlockState().getBlock());
        this.setChanged();
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, VillagerMusicalFridgeBlockEntity blockEntity)
    {
        if (blockEntity.timeInTickForLastMusicPlay < VillagerMusicalFridgeBlockEntity.BASE_TIME_TO_WAIT)
        {
            blockEntity.timeInTickForLastMusicPlay ++;
        }
    }

    @javax.annotation.Nullable
    public static <T extends BlockEntity> BlockEntityTicker<T> createBrewingStationTicker(Level level, BlockEntityType<T> serverType, BlockEntityType<VillagerMusicalFridgeBlockEntity> clientType)
    {
        return level.isClientSide ? null : createTickerHelper(serverType, clientType, VillagerMusicalFridgeBlockEntity::serverTick);
    }

    @javax.annotation.Nullable
    public static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> serverType, BlockEntityType<E> clientType, BlockEntityTicker<? super E> ticker)
    {
        return clientType == serverType ? (BlockEntityTicker<A>)ticker : null;
    }

}
