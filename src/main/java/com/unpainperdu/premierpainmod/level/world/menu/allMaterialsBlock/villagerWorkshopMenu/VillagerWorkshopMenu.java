package com.unpainperdu.premierpainmod.level.world.menu.allMaterialsBlock.villagerWorkshopMenu;

import com.google.common.collect.Lists;
import java.util.List;

import com.unpainperdu.premierpainmod.level.world.item.crafting.villagerWorkshopRecipe.VillagerWorkshopRecipe;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.MenuTypesRegister;
import com.unpainperdu.premierpainmod.util.register.recipe.RecipeTypeRegister;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

public class VillagerWorkshopMenu extends AbstractContainerMenu
{
    public static final int INPUT_SLOT = 0;
    public static final int RESULT_SLOT = 1;
    private static final int INV_SLOT_START = 2;
    private static final int INV_SLOT_END = 29;
    private static final int USE_ROW_SLOT_START = 29;
    private static final int USE_ROW_SLOT_END = 38;
    private final ContainerLevelAccess access;
    /**
     * The index of the selected recipe in the GUI.
     */
    private final DataSlot selectedRecipeIndex = DataSlot.standalone();
    private final Level level;
    private List<RecipeHolder<VillagerWorkshopRecipe>> recipes = Lists.newArrayList();
    /**
     * The {@linkplain net.minecraft.world.item.ItemStack} set in the input slot by the player.
     */
    private ItemStack input = ItemStack.EMPTY;
    /**
     * Stores the game time of the last time the player took items from the crafting result slot. This is used to prevent the sound from being played multiple times on the same tick.
     */
    long lastSoundTime;
    final Slot inputSlot;
    /**
     * The inventory slot that stores the output of the crafting recipe.
     */
    final Slot resultSlot;
    Runnable slotUpdateListener = () -> {};
    public final Container container = new SimpleContainer(1)
    {
        @Override
        public void setChanged()
        {
            super.setChanged();
            VillagerWorkshopMenu.this.slotsChanged(this);
            VillagerWorkshopMenu.this.slotUpdateListener.run();
        }
    };
    /**
     * The inventory that stores the output of the crafting recipe.
     */
    final ResultContainer resultContainer = new ResultContainer();

    public VillagerWorkshopMenu(int pContainerId, Inventory pPlayerInventory)
    {
        this(pContainerId, pPlayerInventory, ContainerLevelAccess.NULL);
    }

    public VillagerWorkshopMenu(int pContainerId, Inventory pPlayerInventory, final ContainerLevelAccess pAccess)
    {
        super(MenuType.STONECUTTER, pContainerId);
        this.access = pAccess;
        this.level = pPlayerInventory.player.level();
        this.inputSlot = this.addSlot(new Slot(this.container, 0, 20, 33));
        this.resultSlot = this.addSlot(new Slot(this.resultContainer, 1, 143, 33) {
            @Override
            public boolean mayPlace(ItemStack p_40362_) {
                return false;
            }

            @Override
            public void onTake(Player player, ItemStack stack)
            {
                stack.onCraftedBy(player.level(), player, stack.getCount());
                VillagerWorkshopMenu.this.resultContainer.awardUsedRecipes(player, this.getRelevantItems());
                ItemStack itemstack = VillagerWorkshopMenu.this.inputSlot.remove(1);
                if (!itemstack.isEmpty())
                {
                    VillagerWorkshopMenu.this.setupResultSlot();
                }

                pAccess.execute((p_40364_, p_40365_) ->
                {
                    long l = p_40364_.getGameTime();
                    if (VillagerWorkshopMenu.this.lastSoundTime != l)
                    {
                        p_40364_.playSound(null, p_40365_, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
                        VillagerWorkshopMenu.this.lastSoundTime = l;
                    }
                });
                super.onTake(player, stack);
            }

            private List<ItemStack> getRelevantItems()
            {
                return List.of(VillagerWorkshopMenu.this.inputSlot.getItem());
            }
        });

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                this.addSlot(new Slot(pPlayerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; k++)
        {
            this.addSlot(new Slot(pPlayerInventory, k, 8 + k * 18, 142));
        }

        this.addDataSlot(this.selectedRecipeIndex);
    }

    /**
     * Returns the index of the selected recipe.
     */
    public int getSelectedRecipeIndex() {
        return this.selectedRecipeIndex.get();
    }

    public List<RecipeHolder<VillagerWorkshopRecipe>> getRecipes() {
        return this.recipes;
    }

    public int getNumRecipes() {
        return this.recipes.size();
    }

    public boolean hasInputItem() {
        return this.inputSlot.hasItem() && !this.recipes.isEmpty();
    }

    /**
     * Determines whether supplied player can use this container
     */
    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(this.access, pPlayer, BlockRegister.VILLAGER_WORKSHOP.get());
    }

    /**
     * Handles the given Button-click on the server, currently only used by enchanting. Name is for legacy.
     */
    @Override
    public boolean clickMenuButton(Player pPlayer, int pId)
    {
        if (this.isValidRecipeIndex(pId))
        {
            this.selectedRecipeIndex.set(pId);
            this.setupResultSlot();
        }

        return true;
    }

    private boolean isValidRecipeIndex(int pRecipeIndex)
    {
        return pRecipeIndex >= 0 && pRecipeIndex < this.recipes.size();
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    @Override
    public void slotsChanged(Container pInventory)
    {
        ItemStack itemstack = this.inputSlot.getItem();
        if (!itemstack.is(this.input.getItem()))
        {
            this.input = itemstack.copy();
            this.setupRecipeList(pInventory, itemstack);
        }
    }

    private void setupRecipeList(Container pContainer, ItemStack pStack)
    {
        this.recipes.clear();
        this.selectedRecipeIndex.set(-1);
        this.resultSlot.set(ItemStack.EMPTY);
        if (!pStack.isEmpty())
        {
            this.recipes = this.level.getRecipeManager().getRecipesFor(RecipeTypeRegister.VILLAGER_WORKSHOP_RECIPE_TYPE.get(), new SingleRecipeInput(pStack), this.level);
        }
    }

    void setupResultSlot()
    {
        if (!this.recipes.isEmpty() && this.isValidRecipeIndex(this.selectedRecipeIndex.get()))
        {
            RecipeHolder<VillagerWorkshopRecipe> recipeholder = this.recipes.get(this.selectedRecipeIndex.get());
            ItemStack itemstack = recipeholder.value().assemble(new SingleRecipeInput(this.container.getItem(RESULT_SLOT)), this.level.registryAccess());
            if (itemstack.isItemEnabled(this.level.enabledFeatures()))
            {
                this.resultContainer.setRecipeUsed(recipeholder);
                this.resultSlot.set(itemstack);
            }
            else
            {
                this.resultSlot.set(ItemStack.EMPTY);
            }
        }
        else
        {
            this.resultSlot.set(ItemStack.EMPTY);
        }
        this.broadcastChanges();
    }

    @Override
    public MenuType<?> getType() {
        return MenuTypesRegister.VILLAGER_WORKSHOP.get();
    }

    public void registerUpdateListener(Runnable pListener) {
        this.slotUpdateListener = pListener;
    }

    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in is null for the initial slot that was double-clicked.
     */
    @Override
    public boolean canTakeItemForPickAll(ItemStack pStack, Slot pSlot)
    {
        return pSlot.container != this.resultContainer && super.canTakeItemForPickAll(pStack, pSlot);
    }

    /**
     * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player inventory and the other inventory(s).
     */
    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot != null && slot.hasItem())
        {
            ItemStack itemstack1 = slot.getItem();
            Item item = itemstack1.getItem();
            itemstack = itemstack1.copy();
            if (pIndex == 1)
            {
                item.onCraftedBy(itemstack1, pPlayer.level(), pPlayer);
                if (!this.moveItemStackTo(itemstack1, 2, 38, true))
                {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            }
            else if (pIndex == 0)
            {
                if (!this.moveItemStackTo(itemstack1, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            }
            else if (this.level.getRecipeManager().getRecipeFor(RecipeTypeRegister.VILLAGER_WORKSHOP_RECIPE_TYPE.get(), new SingleRecipeInput(itemstack1), this.level).isPresent())
            {
                if (!this.moveItemStackTo(itemstack1, 0, 1, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (pIndex >= 2 && pIndex < 29)
            {
                if (!this.moveItemStackTo(itemstack1, 29, 38, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (pIndex >= 29 && pIndex < 38 && !this.moveItemStackTo(itemstack1, 2, 29, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.setByPlayer(ItemStack.EMPTY);
            }

            slot.setChanged();
            if (itemstack1.getCount() == itemstack.getCount())
            {
                return ItemStack.EMPTY;
            }

            slot.onTake(pPlayer, itemstack1);
            this.broadcastChanges();
        }

        return itemstack;
    }

    /**
     * Called when the container is closed.
     */
    @Override
    public void removed(Player pPlayer)
    {
        super.removed(pPlayer);
        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((p_40313_, p_40314_) -> this.clearContainer(pPlayer, this.container));
    }
}
