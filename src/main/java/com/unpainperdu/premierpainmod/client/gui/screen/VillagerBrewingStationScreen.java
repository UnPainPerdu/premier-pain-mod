package com.unpainperdu.premierpainmod.client.gui.screen;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.menu.menu.allMaterialsBlock.VillagerBrewingStationMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

public class VillagerBrewingStationScreen extends AbstractContainerScreen<VillagerBrewingStationMenu> implements MenuAccess<VillagerBrewingStationMenu>
{
    public VillagerBrewingStationScreen(VillagerBrewingStationMenu menu, Inventory playerInventory, Component title)
    {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY)
    {
        guiGraphics.blit(getBackgroundTexture(), leftPos, topPos, 0, 0, imageWidth, imageHeight);
        renderBrewingProgress(guiGraphics, partialTick, mouseX, mouseY);
        renderFluidStack(guiGraphics, partialTick, mouseX, mouseY);
    }

    private static ResourceLocation loc(String path)
    {
        return ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, path);
    }

    protected ResourceLocation getBackgroundTexture()
    {
        return loc("textures/gui/container/all_materials_block/villager_brewing_station.png");
    }

    protected ResourceLocation getProgressTexture()
    {
        return loc("container/functional_block/villager_brewing_station/bubble");
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick)
    {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }

    private void renderBrewingProgress(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY)
    {
        if (this.menu.isBrewing())
        {
            int j = this.menu.getBrewingProgress();
            guiGraphics.blitSprite(getProgressTexture(), 16,27, 0, 27 - j, leftPos + 14,  topPos + 41 + 27 - j, 16, j);
        }
    }

    private void renderFluidStack(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY)
    {

    }
}
