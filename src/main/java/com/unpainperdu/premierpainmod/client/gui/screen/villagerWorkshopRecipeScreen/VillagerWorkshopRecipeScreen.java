package com.unpainperdu.premierpainmod.client.gui.screen.villagerWorkshopRecipeScreen;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.item.crafting.villagerWorkshopRecipe.VillagerWorkshopRecipe;
import com.unpainperdu.premierpainmod.level.world.menu.allMaterialsBlock.villagerWorkshopMenu.VillagerWorkshopMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class VillagerWorkshopRecipeScreen extends AbstractContainerScreen<VillagerWorkshopMenu>
{
    private static final int SCROLLER_WIDTH = 12;
    private static final int SCROLLER_HEIGHT = 15;
    private static final int SCROLLABLE_HEIGHT = 54;
    private static final int RECIPE_BUTTON_WIDTH = 16;
    private static final int RECIPE_BUTTON_HEIGHT = 18;
    private static final int RECIPE_COLUMNS = 4;
    private static final int RECIPE_ROWS = 3;
    private static final int RECIPE_LIST_X = 52;
    private static final int RECIPE_LIST_Y = 14;

    private float scrollOffs;
    private boolean scrolling;
    private int startIndex;
    private boolean displayRecipes;

    public VillagerWorkshopRecipeScreen(VillagerWorkshopMenu menu, Inventory playerInventory, Component title)
    {
        super(menu, playerInventory, title);

        menu.registerUpdateListener(this::containerChanged);
        --titleLabelY;
    }
    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick)
    {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY)
    {
        guiGraphics.blit(getBackgroundTexture(), leftPos, topPos, 0, 0, imageWidth, imageHeight);
        int i = (int) (41 * scrollOffs);
        ResourceLocation scrollerLoc = isScrollBarActive() ? getScrollerSprite() : getScrollerDisabledSprite();
        guiGraphics.blitSprite(scrollerLoc, leftPos + 119, topPos + 15 + i, SCROLLER_WIDTH, SCROLLER_HEIGHT);
        int listStartX = leftPos + RECIPE_LIST_X;
        int listStartY = topPos + RECIPE_LIST_Y;
        int j1 = startIndex + 12;
        renderButtons(guiGraphics, mouseX, mouseY, listStartX, listStartY, j1);
        renderRecipes(guiGraphics, listStartX, listStartY, j1);
    }

    @Override
    protected void renderTooltip(GuiGraphics guiGraphics, int mouseX, int mouseY)
    {
        super.renderTooltip(guiGraphics, mouseX, mouseY);
        if (displayRecipes)
        {
            int listStartX = leftPos + RECIPE_LIST_X;
            int listStartY = topPos + RECIPE_LIST_Y;
            int k = startIndex + 12;
            List<RecipeHolder<VillagerWorkshopRecipe>> recipes = menu.getRecipes();

            for (int l = startIndex; l < k && l < menu.getNumRecipes(); ++l)
            {
                int i = l - startIndex;
                int i1 = listStartX + i % 4 * RECIPE_BUTTON_WIDTH;
                int i2 = listStartY + i / 4 * RECIPE_BUTTON_HEIGHT + 2;
                if (mouseX >= i1 && mouseX < i1 + RECIPE_BUTTON_WIDTH && mouseY >= i2 && mouseY < i2 + RECIPE_BUTTON_HEIGHT)
                {
                    guiGraphics.renderTooltip(font, recipes.get(l).value().getResultItem(minecraft.level.registryAccess()), mouseX, mouseY);
                }
            }
        }
    }

    private void renderButtons(GuiGraphics guiGraphics, int mouseX, int mouseY, int listStartX, int listStartY, int apdwo)
    {
        for (int i = startIndex; i < apdwo && i < menu.getNumRecipes(); ++i)
        {
            int j = i - startIndex;
            int k = listStartX + j % RECIPE_COLUMNS * RECIPE_BUTTON_WIDTH;
            int l = j / RECIPE_COLUMNS;
            int i1 = listStartY + l * RECIPE_BUTTON_HEIGHT + 2;
            ResourceLocation buttonLoc = getRecipeSprite();
            if (i == menu.getSelectedRecipeIndex()) {
                buttonLoc = getRecipeSelectedSprite();
            }
            else if (mouseX >= k && mouseY >= i1 && mouseX < k + RECIPE_BUTTON_WIDTH && mouseY < i1 + RECIPE_BUTTON_HEIGHT)
            {
                buttonLoc = getRecipeHighlightedSprite();
            }

            guiGraphics.blitSprite(buttonLoc, k, i1 - 1, 16, 18);
        }
    }

    private void renderRecipes(GuiGraphics guiGraphics, int listStartX, int listStartY, int awdwad)
    {
        List<RecipeHolder<VillagerWorkshopRecipe>> recipes = menu.getRecipes();

        for (int i = startIndex; i < awdwad && i < menu.getNumRecipes(); ++i)
        {
            int j = i - startIndex;
            int x = listStartX + j % RECIPE_COLUMNS * RECIPE_BUTTON_WIDTH;
            int l = j / RECIPE_COLUMNS;
            int y = listStartY + l * RECIPE_BUTTON_HEIGHT + 2;
            guiGraphics.renderItem(recipes.get(i).value().getResultItem(minecraft.level.registryAccess()), x, y);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton)
    {
        scrolling = false;
        if (displayRecipes)
        {
            int listStartX = leftPos + RECIPE_LIST_X;
            int listStartY = topPos + RECIPE_LIST_Y;
            int k = startIndex + 12;

            for (int button = startIndex; button < k; ++button)
            {
                int i1 = button - startIndex;
                double d0 = mouseX - (double) (listStartX + i1 % 4 * RECIPE_BUTTON_WIDTH);
                double d1 = mouseY - (double) (listStartY + i1 / 4 * RECIPE_BUTTON_HEIGHT);
                if (d0 >= 0 && d1 >= 0 && d0 < RECIPE_BUTTON_WIDTH && d1 < RECIPE_BUTTON_HEIGHT && menu.clickMenuButton(minecraft.player, button))
                {
                    Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1));
                    minecraft.gameMode.handleInventoryButtonClick(menu.containerId, button);
                    return true;
                }
            }

            listStartX = leftPos + 119;
            listStartY = topPos + 9;
            if (mouseX >= listStartX && mouseX < listStartX + SCROLLER_WIDTH && mouseY >= listStartY && mouseY < listStartY + SCROLLABLE_HEIGHT)
            {
                scrolling = true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY)
    {
        if (scrolling && isScrollBarActive())
        {
            int startY = topPos + 14;
            int endY = startY + SCROLLABLE_HEIGHT;
            scrollOffs = (float) ((mouseY - startY - 7.5F) / ((endY - startY) - SCROLLER_HEIGHT));
            scrollOffs = Mth.clamp(scrollOffs, 0, 1);
            startIndex = (int) ((scrollOffs * getOffscreenRows()) + 0.5D) * 4;
            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double d, double d1)
    {
        if (isScrollBarActive()) {
            int i = getOffscreenRows();
            float f = (float) d1 / (float) i;
            scrollOffs = Mth.clamp(scrollOffs - f, 0.0F, 1.0F);
            startIndex = (int) ((double) (scrollOffs * (float) i) + 0.5D) * 4;
        }

        return true;
    }

    private boolean isScrollBarActive()
    {
        return displayRecipes && menu.getNumRecipes() > 12;
    }

    protected int getOffscreenRows()
    {
        return (menu.getNumRecipes() + 4 - 1) / 4 - RECIPE_ROWS;
    }

    private void containerChanged()
    {
        displayRecipes = menu.hasInputItem();
        if (!displayRecipes) {
            scrollOffs = 0;
            startIndex = 0;
        }
    }
    private static ResourceLocation loc(String path)
    {
        return ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, path);
    }

    protected ResourceLocation getBackgroundTexture() {
        return loc("textures/gui/container/villager_workshop.png");
    }

    protected ResourceLocation getScrollerSprite() {
        return loc("container/villager_workshop/scroller");
    }

    protected ResourceLocation getScrollerDisabledSprite() {
        return loc("container/villager_workshop/scroller_disabled");
    }

    protected ResourceLocation getRecipeSprite() {
        return loc("container/villager_workshop/recipe");
    }

    protected ResourceLocation getRecipeSelectedSprite() {
        return loc("container/villager_workshop/recipe_selected");
    }

    protected ResourceLocation getRecipeHighlightedSprite() {
        return loc("container/villager_workshop/recipe_highlighted");
    }
}
