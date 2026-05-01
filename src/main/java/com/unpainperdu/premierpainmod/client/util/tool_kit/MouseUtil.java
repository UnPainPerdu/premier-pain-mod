package com.unpainperdu.premierpainmod.client.util.tool_kit;

import com.unpainperdu.premierpainmod.client.gui.render.FluidTankRenderer;

public class MouseUtil
{
    public static boolean isMouseAboveFluidArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, FluidTankRenderer renderer)
    {
        return isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, renderer.getWidth(), renderer.getHeight());
    }

    public static boolean isMouseOver(double mouseX, double mouseY, int x, int y, int sizeX, int sizeY)
    {
        return (mouseX >= x && mouseX <= x + sizeX) && (mouseY >= y && mouseY <= y + sizeY);
    }
}