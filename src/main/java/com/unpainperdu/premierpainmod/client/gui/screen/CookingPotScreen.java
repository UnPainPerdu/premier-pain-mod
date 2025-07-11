package com.unpainperdu.premierpainmod.client.gui.screen;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.client.gui.render.FluidTankRenderer;
import com.unpainperdu.premierpainmod.client.util.tool_kit.MouseUtil;
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
        renderButton(guiGraphics, mouseX, mouseY);
    }

    private static ResourceLocation loc(String path)
    {
        return ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, path);
    }

    private ResourceLocation getBackgroundTexture()
    {
        return loc("textures/gui/container/functional_block/cooking_pot.png");
    }

    private ResourceLocation getArrowTexture()
    {
        return loc("container/functional_block/cooking_pot/arrow");
    }

    private ResourceLocation getLitTexture()
    {
        return loc("container/functional_block/cooking_pot/lit");
    }

    private ResourceLocation getButtonTexture(boolean isHighlighted)
    {
        String path;
        if (isHighlighted)
        {
            path = "container/functional_block/cooking_pot/button_lit";
        }
        else
        {
            path = "container/functional_block/cooking_pot/button_unlit";
        }
        return loc(path);
    }

    private void renderLit(GuiGraphics guiGraphics)
    {
        boolean isLit = this.menu.getState().getValue(BlockStateProperties.LIT);
        if (isLit)
        {
            guiGraphics.blitSprite(getLitTexture(), 14, 14, 0, 0, leftPos + 58, topPos + 77, 14, 14);
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
        guiGraphics.blitSprite(getArrowTexture(), 26, 10, 0, 0, leftPos + 113, topPos + 21 + (indexOfCookingTime * 24), j, 10);
    }

    private void renderFluidStack(GuiGraphics guiGraphics)
    {
        FluidStack fluidStack = this.menu.entity.getFluidTank().getFluid();
        fluidRenderer.render(guiGraphics, leftPos + 58, topPos + 31, fluidStack);
    }

    private void renderButton(GuiGraphics guiGraphics, int mouseX, int mouseY)
    {
        guiGraphics.blitSprite(getButtonTexture(isAboveBinButton(mouseX, mouseY)), 16, 16, 0, 0, leftPos + 28, topPos + 45, 16, 16);
    }

    @Override
    protected void renderLabels(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY)
    {
        guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 4210752, false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, 92, 4210752, false);
        renderFluidTooltipArea(guiGraphics, mouseX, mouseY, leftPos, topPos, menu.entity.getFluidTank().getFluid(), 58, 31, fluidRenderer);
        renderBinButtonToolTipArea(guiGraphics, mouseX, mouseY);
    }

    private void renderFluidTooltipArea(GuiGraphics guiGraphics, int mouseX, int mouseY, int x, int y,
                                        FluidStack stack, int offsetX, int offsetY, FluidTankRenderer renderer)
    {
        if (MouseUtil.isMouseAboveFluidArea(mouseX, mouseY, x, y, offsetX, offsetY, renderer))
        {
            guiGraphics.renderTooltip(this.font, renderer.getTooltip(stack, TooltipFlag.Default.NORMAL),
                    Optional.empty(), mouseX - x, mouseY - y);
        }
    }

    private void renderBinButtonToolTipArea(GuiGraphics guiGraphics, int mouseX, int mouseY)
    {
        if (isAboveBinButton(mouseX, mouseY))
        {
            Component component = Component.translatable("container." + PremierPainMod.MOD_ID + "cooking_pot.bin_button");
            guiGraphics.renderTooltip(this.font, component, mouseX - leftPos, mouseY - topPos);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button)
    {
        if (isAboveBinButton(mouseX, mouseY))
        {
            if (this.minecraft != null && this.minecraft.player != null && this.minecraft.gameMode != null)
            {
                if (this.menu.clickMenuButton(this.minecraft.player, 0))
                {
                    this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, 0);
                    return true;
                }
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    private boolean isAboveBinButton(double mouseX, double mouseY)
    {
        return MouseUtil.isMouseOver(mouseX, mouseY, 28 + leftPos, 46 + topPos, 16, 16);
    }
}
