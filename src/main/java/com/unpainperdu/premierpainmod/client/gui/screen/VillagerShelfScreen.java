package com.unpainperdu.premierpainmod.client.gui.screen;

import com.unpainperdu.premierpainmod.level.menu.menu.all_materials_block.VillagerShelfMenu;
import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class VillagerShelfScreen extends AbstractContainerScreen<VillagerShelfMenu> implements MenuAccess<VillagerShelfMenu>
{

    public VillagerShelfScreen(VillagerShelfMenu pMenu, Inventory pPlayerInventory, Component pTitle)
    {
        super(pMenu, pPlayerInventory, pTitle);

    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY)
    {
        pGuiGraphics.blit(RenderType::guiTextured, getBackgroundTexture(), leftPos, topPos, 0, 0, imageWidth, imageHeight, 256, 256);
    }

    protected ResourceLocation getBackgroundTexture()
    {
        return ResourceUtil.createResourceLocation("textures/gui/container/all_materials_block/villager_shelf.png");
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick)
    {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }
}