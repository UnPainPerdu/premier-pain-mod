package com.unpainperdu.premierpainmod.client.render.block_entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.core.Direction;

public class ItemDisplayRenderHelper
{
    private ItemDisplayRenderHelper(){}

    /**
     * Center to the pos of block entity
     *
     */
    public static void setItemRenderToCenter(Direction direction, PoseStack poseStack)
    {
        switch (direction)
        {
            //translation of rendered item 0f = nothing, 1f = 1 block
            case EAST -> poseStack.translate(-0.5f,0f,0.5f);
            case SOUTH -> poseStack.translate(0.5f,0f,0.5f);
            case WEST -> poseStack.translate(0.5f,0f,-0.5f);
            default -> poseStack.translate(-0.5f,0f,-0.5f);
        }
    }

    /**
     * set translation on relative x
     * x
     * ^
     * |
     * |
     * |
     * 0------------------->y
     *     main face
     *     (facing state)
     */
    public static void moveOnRelativeXInPixel(Direction direction, PoseStack poseStack, int pixel)
    {
        float translation = getTranslationFloatFromPixel(pixel);
        switch (direction)
        {
            case EAST -> poseStack.translate(0f,0f,translation);
            case SOUTH -> poseStack.translate(0f,0f,translation);
            case WEST -> poseStack.translate(0f,0f,translation);
            default -> poseStack.translate(0f,0f,translation);
        }
    }

    /**
     * set translation on relative y
     * x
     * ^
     * |
     * |
     * |
     * 0------------------->y
     *     main face
     *     (facing state)
     */
    public static void moveOnRelativeYInPixel(Direction direction, PoseStack poseStack, int pixel)
    {
        float translation = getTranslationFloatFromPixel(pixel);
        switch (direction)
        {
            case EAST -> poseStack.translate(-translation,0f,0f);
            case SOUTH -> poseStack.translate(-translation,0f,0f);
            case WEST -> poseStack.translate(-translation,0f,0f);
            default -> poseStack.translate(-translation,0f,0f);
        }
    }

    /**
     *
     * @param i ==> i/16 if i = 16 => translation of 1 block, if i = 1 => translation of 1 pixel
     */
    public static float getTranslationFloatFromPixel(int i)
    {
        return (float) i /16;
    }
}
