package com.unpainperdu.premierpainmod.client.gui.screen;

import com.unpainperdu.premierpainmod.level.menu.menu.all_materials_block.VillagerMusicalFridgeMenu;
import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class VillagerMusicalFridgeScreen extends AbstractContainerScreen<VillagerMusicalFridgeMenu> implements MenuAccess<VillagerMusicalFridgeMenu>
{
    private final int containerRows;

    public VillagerMusicalFridgeScreen(VillagerMusicalFridgeMenu pMenu, Inventory pPlayerInventory, Component pTitle)
    {
        super(pMenu, pPlayerInventory, pTitle);
        this.containerRows = menu.getContainerRows();
        this.imageHeight = 114 + this.containerRows * 18;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY)
    {
        pGuiGraphics.blit(RenderType::guiTextured, getBackgroundTexture(), leftPos, topPos, 0, 0, imageWidth, imageHeight, 256, 256);
    }

    protected ResourceLocation getBackgroundTexture()
    {
        return ResourceUtil.createResourceLocation("textures/gui/container/all_materials_block/villager_musical_fridge.png");
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick)
    {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY)
    {
        guiGraphics.drawString(this.font, this.title, this.titleLabelX + 27, this.titleLabelY, 4210752, false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 4210752, false);
    }
}