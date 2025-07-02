package com.unpainperdu.premierpainmod.level.world.entity.block_entity.crafting_block;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.crafting_block.CookingPotBlock;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.cooking_pot_block.CookingPotInput;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.cooking_pot_block.CookingPotRecipe;
import com.unpainperdu.premierpainmod.level.world.menu.menu.all_materials_block.CookingPotMenu;
import com.unpainperdu.premierpainmod.util.register.block.BlockEntityRegister;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.recipe.RecipeTypeRegister;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeCraftingHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CookingPotBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, RecipeCraftingHolder, StackedContentsCompatible
{
    public static final int FLUID_INPUT = 0;
    public static final int[] ITEM_INPUT = new int[]{1, 2, 3};
    public static final int[] ITEM_OUTPUT = new int[]{4, 5, 6};
    public static final int FLUID_OUTPUT = 7;
    public static final int SLOT_NUMBER = 8;
    private NonNullList<ItemStack> items = NonNullList.withSize(SLOT_NUMBER, ItemStack.EMPTY);
    private final FluidTank fluidTank;
    private static final int MAX_COOKING_TIME = 60;
    private final List<Integer> cookingTime = setupCookingTimeList();

    public final ContainerData dataAccess = new ContainerData()
    {
        @Override
        public int get(int dataIndex)
        {
            return getCookingTime(dataIndex);
        }

        @Override
        public void set(int dataIndex, int newValue)
        {
            setCookingTime(dataIndex, newValue);
        }

        @Override
        public int getCount()
        {
            return 3;
        }
    };
    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
    private final RecipeManager.CachedCheck<CookingPotInput, ? extends CookingPotRecipe> quickCheck;

    public CookingPotBlockEntity(BlockPos pos, BlockState blockState)
    {
        super(BlockEntityRegister.COOKING_POT_BLOCK_ENTITY.get(), pos, blockState);
        this.fluidTank = new FluidTank(1000);
        this.quickCheck = RecipeManager.createCheck(RecipeTypeRegister.COOKING_POT_RECIPE_TYPE.get());
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int containerId, @NotNull Inventory inventory)
    {
        return new CookingPotMenu(containerId, inventory, this);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, CookingPotBlockEntity blockEntity)
    {
        boolean hasChanged = false;
        FluidTank fluidTank = blockEntity.getFluidTank();
        NonNullList<ItemStack> itemStacks = blockEntity.items;
        //tank part
        //input
        if (fluidTank.isEmpty())
        {
            if (itemStacks.get(FLUID_INPUT).getItem() instanceof BucketItem bucket)
            {
                Fluid fluidFromBucket = bucket.content;
                blockEntity.fluidTank.fill(new FluidStack(fluidFromBucket, 1000), IFluidHandler.FluidAction.EXECUTE);
                itemStacks.set(FLUID_INPUT, new ItemStack(Items.BUCKET));
                blockEntity.setItems(itemStacks);
                playSound(blockEntity.getLevel(), blockEntity.getBlockPos(), SoundEvents.BUCKET_EMPTY);
                hasChanged = true;
            }
        }
        //output
        if (!(fluidTank.isEmpty()) && fluidTank.getFluidAmount() == 1000 && itemStacks.get(FLUID_OUTPUT).is(Items.BUCKET))
        {
            Fluid fluidFromEntity = fluidTank.getFluid().getFluid();
            Item item = fluidFromEntity.getBucket();
            blockEntity.fluidTank.drain(1000, IFluidHandler.FluidAction.EXECUTE);
            itemStacks.set(FLUID_OUTPUT, new ItemStack(item));
            blockEntity.setItems(itemStacks);
            playSound(blockEntity.getLevel(), blockEntity.getBlockPos(), SoundEvents.BUCKET_FILL);
            hasChanged = true;
        }
        //craft part

        //change part
        if (hasChanged)
        {
            blockEntity.setChanged();
        }
    }

    @Override
    public int @NotNull [] getSlotsForFace(@NotNull Direction side)
    {
        return new int[0];
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, @NotNull ItemStack itemStack, @Nullable Direction direction)
    {
        return true;
    }

    @Override
    public boolean canTakeItemThroughFace(int index, @NotNull ItemStack stack, @NotNull Direction direction)
    {
        return true;
    }

    @Override
    protected @NotNull Component getDefaultName()
    {
        return Component.translatable(BlockRegister.COOKING_POT_BLOCK.get().getDescriptionId());
    }

    @Override
    protected @NotNull NonNullList<ItemStack> getItems()
    {
        return this.items;
    }

    @Override
    protected void setItems(@NotNull NonNullList<ItemStack> items)
    {
        this.items = items;
    }

    @Override
    public int getContainerSize()
    {
        return SLOT_NUMBER;
    }

    @Override
    public void setRecipeUsed(@Nullable RecipeHolder<?> recipe)
    {
        if (recipe != null)
        {
            ResourceLocation resourcelocation = recipe.id();
            this.recipesUsed.addTo(resourcelocation, 1);
        }
    }

    @Nullable
    @Override
    public RecipeHolder<?> getRecipeUsed()
    {
        return null;
    }

    @Override
    public void fillStackedContents(@NotNull StackedContents contents)
    {
        for (ItemStack itemstack : this.items)
        {
            contents.accountStack(itemstack);
        }
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries)
    {
        super.loadAdditional(tag, registries);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(tag, this.items, registries);
        fluidTank.readFromNBT(registries, tag.getCompound("tank"));
        for (int i = 0; i < 3; i++)
        {
            setCookingTime(i, tag.getInt("cooking_time_" + i));
        }
        CompoundTag compoundtag = tag.getCompound("RecipesUsed");
        for (String s : compoundtag.getAllKeys())
        {
            this.recipesUsed.put(ResourceLocation.parse(s), compoundtag.getInt(s));
        }
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider registries)
    {
        super.saveAdditional(tag, registries);
        for (int i = 0; i < 3; i++)
        {
            tag.putInt("cooking_time_" + i, this.cookingTime.get(i));
        }
        ContainerHelper.saveAllItems(tag, this.items, registries);
        CompoundTag compoundTagFluidTank = new CompoundTag();
        fluidTank.writeToNBT(registries, compoundTagFluidTank);
        tag.put("tank", compoundTagFluidTank);
        CompoundTag compoundTagRecipe = new CompoundTag();
        this.recipesUsed.forEach((p_187449_, p_187450_) -> compoundTagRecipe.putInt(p_187449_.toString(), p_187450_));
        tag.put("RecipesUsed", compoundTagRecipe);
    }

    public void setCookingTime(int index, int cookingTime)
    {
        this.cookingTime.set(index, cookingTime);
    }

    public int getCookingTime(int index)
    {
        return cookingTime.get(index);
    }

    private static List<Integer> setupCookingTimeList()
    {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++)
        {
            list.add(0);
        }
        return list;
    }

    public FluidTank getFluidTank()
    {
        return fluidTank;
    }

    @javax.annotation.Nullable
    public static <T extends BlockEntity> BlockEntityTicker<T> createTicker(
            Level level, BlockEntityType<T> serverType, BlockEntityType<CookingPotBlockEntity> clientType
    )
    {
        return level.isClientSide ? null : createTickerHelper(serverType, clientType, CookingPotBlockEntity::serverTick);
    }

    @javax.annotation.Nullable
    public static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> serverType, BlockEntityType<E> clientType, BlockEntityTicker<? super E> ticker)
    {
        return clientType == serverType ? (BlockEntityTicker<A>) ticker : null;
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider registries)
    {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag, registries);
        return tag;
    }

    @Override
    public void handleUpdateTag(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider lookupProvider)
    {
        loadAdditional(tag, lookupProvider);
    }

    @Override
    public void onDataPacket(@NotNull Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.@NotNull Provider lookupProvider)
    {
        CompoundTag tag = pkt.getTag();
        loadAdditional(tag == null ? new CompoundTag() : tag, lookupProvider);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void setChanged()
    {
        if (level instanceof ServerLevel serverLevel)
        {
            serverLevel.getChunkSource().blockChanged(getBlockPos());
        }
        super.setChanged();
    }

    private static void playSound(Level level, BlockPos pos, SoundEvent pSound)
    {
        if (level != null)
        {
            level.playSound(null, pos, pSound, SoundSource.BLOCKS, 1.0F, 1.0F);
        }
    }
}
