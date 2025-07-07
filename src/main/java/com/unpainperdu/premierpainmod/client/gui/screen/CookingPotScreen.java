package com.unpainperdu.premierpainmod.client.gui.screen;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.client.gui.render.FluidTankRenderer;
import com.unpainperdu.premierpainmod.level.world.menu.menu.all_materials_block.CookingPotMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class CookingPotScreen extends AbstractContainerScreen<CookingPotMenu> implements MenuAccess<CookingPotMenu>
{
    private final FluidTankRenderer fluidRenderer;

    public CookingPotScreen(CookingPotMenu menu, Inventory playerInventory, Component title)
    {
        super(menu, playerInventory, title);
        fluidRenderer = new FluidTankRenderer(1000, true, 16, 43);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY)
    {
        guiGraphics.blit(getBackgroundTexture(), leftPos, topPos, 0, 0, imageWidth, 185);
        renderLit(guiGraphics);
        renderProgress(guiGraphics);
        renderFluidStack(guiGraphics);
    }

    private static ResourceLocation loc(String path)
    {
        return ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, path);
    }

    protected ResourceLocation getBackgroundTexture()
    {
        return loc("textures/gui/container/functional_block/cooking_pot.png");
    }

    protected ResourceLocation getArrowTexture()
    {
        return loc("container/functional_block/cooking_pot/arrow");
    }

    protected ResourceLocation getLitTexture()
    {
        return loc("container/functional_block/cooking_pot/lit");
    }

    private void renderLit(GuiGraphics guiGraphics)
    {
        boolean isLit = this.menu.getState().getValue(BlockStateProperties.LIT);
        if (isLit)
        {
            guiGraphics.blitSprite(getLitTexture(), 14, 14, 0, 0,leftPos + 58, topPos + 77, 14, 14);
        }
    }

    private void renderProgress(GuiGraphics guiGraphics)
    {
        if (this.menu.isCooking(0))
        {
            renderArrow(0, guiGraphics);
        }
        if (this.menu.isCooking(1))
        {
            renderArrow(1, guiGraphics);
        }
        if (this.menu.isCooking(2))
        {
            renderArrow(2, guiGraphics);
        }
    }

    private void renderArrow(int indexOfCookingTime, GuiGraphics guiGraphics)
    {
        int j = this.menu.getBrewingProgress(indexOfCookingTime);
        guiGraphics.blitSprite(getArrowTexture(), 26, 10, 0, 0,leftPos + 113, topPos + 21 + (indexOfCookingTime*24), j, 10);
    }

    private void renderFluidStack(GuiGraphics guiGraphics)
    {
        FluidStack fluidStack = this.menu.entity.getFluidTank().getFluid();
        fluidRenderer.render(guiGraphics, leftPos + 58, topPos + 31, fluidStack);
    }

    @Override
    protected void renderLabels(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY)
    {
        guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 4210752, false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, 92, 4210752, false);
        renderFluidTooltipArea(guiGraphics, mouseX, mouseY, leftPos, topPos, menu.entity.getFluidTank().getFluid(), 58, 31, fluidRenderer);
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
