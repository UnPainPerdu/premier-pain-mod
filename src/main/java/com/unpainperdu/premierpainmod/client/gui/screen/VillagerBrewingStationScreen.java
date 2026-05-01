package com.unpainperdu.premierpainmod.client.gui.screen;

import com.unpainperdu.premierpainmod.client.gui.render.FluidTankRenderer;
import com.unpainperdu.premierpainmod.level.menu.menu.all_materials_block.VillagerBrewingStationMenu;
import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.fluids.FluidStack;

import java.util.Optional;

public class VillagerBrewingStationScreen extends AbstractContainerScreen<VillagerBrewingStationMenu> implements MenuAccess<VillagerBrewingStationMenu>
{
    private FluidTankRenderer fluidRenderer;

    private int itemOutputState = 0;
    private int itemOutputStateTime = 0;

    public VillagerBrewingStationScreen(VillagerBrewingStationMenu menu, Inventory playerInventory, Component title)
    {
        super(menu, playerInventory, title);
        fluidRenderer = new FluidTankRenderer(1000, true, 16, 43);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY)
    {
        guiGraphics.blit(RenderType::guiTextured, getBackgroundTexture(), leftPos, topPos, 0, 0, imageWidth, imageHeight, 256, 256);
        renderOutputItems(guiGraphics, partialTick);
        renderBrewingProgress(guiGraphics);
        renderFluidStack(guiGraphics);
    }

    @Override
    protected void containerTick()
    {
        this.itemOutputStateTime++;
        if (this.itemOutputStateTime == 30)
        {
            this.itemOutputState = 1;
        }
        else if (this.itemOutputStateTime == 60)
        {
            this.itemOutputState = 2;
        }
        else if (this.itemOutputStateTime > 89)
        {
            this.itemOutputState = 0;
            this.itemOutputStateTime = 0;
        }
        super.containerTick();
    }

    private void renderOutputItems(GuiGraphics guiGraphics, float partialTick)
    {
        ResourceLocation item;
        switch (this.itemOutputState)
        {
            case 0 ->
                    item = ResourceUtil.createResourceLocation("container/functional_block/villager_brewing_station/bucket");
            case 1 ->
                    item = ResourceUtil.createResourceLocation("container/functional_block/villager_brewing_station/bottle");
            default ->
                    item = ResourceUtil.createResourceLocation("container/functional_block/villager_brewing_station/mug");
        }
        if (this.menu.villagerBrewingStationBlockEntity.getItems().get(13).isEmpty())
        {
            guiGraphics.blitSprite(RenderType::guiTextured, item, 16, 16, 0, 0, leftPos + 152, topPos + 18, 16, 16);
        }
    }

    protected ResourceLocation getBackgroundTexture()
    {
        return ResourceUtil.createResourceLocation("textures/gui/container/all_materials_block/villager_brewing_station.png");
    }

    protected ResourceLocation getProgressTexture()
    {
        return ResourceUtil.createResourceLocation("container/functional_block/villager_brewing_station/bubble");
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick)
    {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }

    private void renderBrewingProgress(GuiGraphics guiGraphics)
    {
        if (this.menu.isBrewing())
        {
            int j = this.menu.getBrewingProgress();
            guiGraphics.blitSprite(RenderType::guiTextured, getProgressTexture(), 16, 27, 0, 27 - j, leftPos + 14, topPos + 41 + 27 - j, 16, j);
        }
    }

    private void renderFluidStack(GuiGraphics guiGraphics)
    {
        FluidStack fluidStack = this.menu.villagerBrewingStationBlockEntity.getFluidTank().getFluid();
        fluidRenderer.render(guiGraphics, leftPos + 36, topPos + 27, fluidStack);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY)
    {
        super.renderLabels(guiGraphics, mouseX, mouseY);

        renderFluidTooltipArea(guiGraphics, mouseX, mouseY, leftPos, topPos, menu.villagerBrewingStationBlockEntity.getFluidTank().getFluid(), 36, 27, fluidRenderer);
    }

    public void renderFluidTooltipArea(GuiGraphics guiGraphics, int pMouseX, int pMouseY, int x, int y,
                                       FluidStack stack, int offsetX, int offsetY, FluidTankRenderer renderer)
    {
        if (isMouseAboveArea(pMouseX, pMouseY, x, y, offsetX, offsetY, renderer))
        {
            guiGraphics.renderTooltip(this.font, renderer.getTooltip(stack, TooltipFlag.Default.NORMAL),
                    Optional.empty(), pMouseX - x, pMouseY - y);
        }
    }

    private static boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, FluidTankRenderer renderer)
    {
        return isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, renderer.getWidth(), renderer.getHeight());
    }

    public static boolean isMouseOver(double mouseX, double mouseY, int x, int y, int sizeX, int sizeY)
    {
        return (mouseX >= x && mouseX <= x + sizeX) && (mouseY >= y && mouseY <= y + sizeY);
    }
}