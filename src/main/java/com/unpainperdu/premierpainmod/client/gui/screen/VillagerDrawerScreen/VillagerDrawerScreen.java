package com.unpainperdu.premierpainmod.client.gui.screen.VillagerDrawerScreen;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.menu.villagerDrawerMenu.VillagerDrawerMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class VillagerDrawerScreen extends AbstractContainerScreen<VillagerDrawerMenu> implements MenuAccess<VillagerDrawerMenu>
{

    public VillagerDrawerScreen(VillagerDrawerMenu pMenu, Inventory pPlayerInventory, Component pTitle)
    {
        super(pMenu, pPlayerInventory, pTitle);

    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY)
    {
        pGuiGraphics.blit(getBackgroundTexture(), leftPos, topPos, 0, 0, imageWidth, imageHeight);
    }

    private static ResourceLocation loc(String path)
    {
        return ResourceLocation.fromNamespaceAndPath(PremierPainMod.MODID, path);
    }

    protected ResourceLocation getBackgroundTexture()
    {
        return loc("textures/gui/container/villager_drawer/villager_drawer.png");
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }
}
