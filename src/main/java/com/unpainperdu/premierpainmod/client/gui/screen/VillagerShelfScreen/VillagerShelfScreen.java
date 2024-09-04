package com.unpainperdu.premierpainmod.client.gui.screen.VillagerShelfScreen;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.menu.allMaterialsBlock.villagerShelfMenu.VillagerShelfMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
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
        pGuiGraphics.blit(getBackgroundTexture(), leftPos, topPos, 0, 0, imageWidth, imageHeight);
    }

    private static ResourceLocation loc(String path)
    {
        return ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, path);
    }

    protected ResourceLocation getBackgroundTexture()
    {
        return loc("textures/gui/container/villager_shelf/villager_shelf.png");
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }
}
