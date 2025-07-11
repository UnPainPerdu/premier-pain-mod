package com.unpainperdu.premierpainmod.client.util.tool_kit.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;

//xyz is the same as shape of block
public class FluidDisplayRenderHelper
{
    private FluidDisplayRenderHelper()
    {
    }


    public static void drawVertex(VertexConsumer builder, PoseStack poseStack,
                                  float x, float y, float z,
                                  float u, float v,
                                  float packedLight, int packedOverlay, int tintColor
    )
    {
        builder.addVertex(poseStack.last().pose(), x/16, y/16, z/16)
                .setColor(tintColor)
                .setUv(u, v)
                .setOverlay(packedOverlay)
                .setLight((int) packedLight)
                .setNormal(poseStack.last(), 0, 1, 0)
        ;
    }

    /**
     * xyz1 is the first corner in coo pixel.
     * xyz2 is the second corner in coo pixel.
     * minUV and mawUV define the size of the texture to apply on the face describe with xyz12.
     **/
    public static void drawVerticalFace(VertexConsumer builder, PoseStack poseStack,
                                        float x1, float y1, float z1,
                                        float x2, float y2, float z2,
                                        float minU, float minV,
                                        float maxU, float maxV,
                                        int tintColor, int packedLight, int packedOverlay
    )
    {
        drawVertex(
                builder, poseStack,
                x1, y1, z1,
                minU, minV,
                packedLight, packedOverlay, tintColor
        );

        drawVertex(
                builder, poseStack,
                x1, y2, z1,
                minU, maxV,
                packedLight, packedOverlay, tintColor
        );

        drawVertex(
                builder, poseStack,
                x2, y2, z2,
                maxU, maxV,
                packedLight, packedOverlay, tintColor
        );

        drawVertex(
                builder, poseStack,
                x2, y1, z2,
                maxU, minV,
                packedLight, packedOverlay, tintColor
        );
    }

    /**
     * xyz1 is the first corner in coo pixel.
     * xyz2 is the second corner in coo pixel.
     * minUV and mawUV define the size of the texture to apply on the face describe with xyz12.
     **/
    public static void drawHorizontalFace(VertexConsumer builder, PoseStack poseStack,
                                        float x1, float y, float z1,
                                        float x2, float z2,
                                        float minU, float minV,
                                        float maxU, float maxV,
                                        int tintColor, int packedLight, int packedOverlay
    )
    {
        drawVertex(
                builder, poseStack,
                x1, y, z1,
                minU, maxV,
                packedLight, packedOverlay, tintColor
        );

        drawVertex(
                builder, poseStack,
                x1, y, z2,
                minU, minV,
                packedLight, packedOverlay, tintColor
        );

        drawVertex(
                builder, poseStack,
                x2, y, z2,
                maxU, minV,
                packedLight, packedOverlay, tintColor
        );

        drawVertex(
                builder, poseStack,
                x2, y, z1,
                maxU, maxV,
                packedLight, packedOverlay, tintColor
        );
    }

    /**
     * drawFace relative to direction of block.
     * xyz1 is the first corner in coo pixel.
     * xyz2 is the second corner in coo pixel.
     * minUV and mawUV define the size of the texture to apply on the face describe with xyz12.
     **/
    public static void drawFaceRelatively(VertexConsumer builder, PoseStack poseStack,
                                          float x1, float y1, float z1,
                                          float x2, float y2, float z2,
                                          float minU, float minV,
                                          float maxU, float maxV,
                                          int tintColor, int packedLight, int packedOverlay,
                                          Direction direction
    )
    {
        float final_x1 = x1;
        float final_x2 = x2;
        float final_z1 = z1;
        float final_z2 = z2;

        //north is default -> no change
        switch (direction)
        {
            case WEST ->
            {
                final_x1 = z1;
                final_x2 = z2;
                final_z1 = Math.abs(x1 - 16);
                final_z2 = Math.abs(x2 - 16);
            }
            case EAST ->
            {
                final_x1 = Math.abs(z1 - 16);
                final_x2 = Math.abs(z2 - 16);
                final_z1 = x1;
                final_z2 = x2;
            }
            case SOUTH ->
            {
                final_x1 = Math.abs(x1 - 16);
                final_x2 = Math.abs(x2 - 16);
                final_z1 = Math.abs(z1 - 16);
                final_z2 = Math.abs(z2 - 16);
            }
        }

        if(final_x1 > final_x2)
        {
            float t = final_x1;
            final_x1 = final_x2;
            final_x2 = t;
        }

        if(final_z1 > final_z2)
        {
            float t = final_z1;
            final_z1 = final_z2;
            final_z2 = t;
        }

        if(y1 == y2)
        {
            drawHorizontalFace(builder, poseStack,
                    final_x1, y1, final_z1,
                    final_x2, final_z2,
                    minU, minV,
                    maxU, maxV,
                    tintColor,
                    packedLight, packedOverlay
            );
        }
        else
        {
            drawVerticalFace(builder, poseStack,
                    final_x1, y1, final_z1,
                    final_x2, y2, final_z2,
                    minU, minV,
                    maxU, maxV,
                    tintColor,
                    packedLight, packedOverlay
            );
        }
    }

    /**
     * drawFace relative to direction of block.
     * xz1 is the first corner in coo pixel.
     * xz2 is the second corner in coo pixel.
     * y is the high
     **/
    public static void drawFaceRelativelyHorizontally(VertexConsumer builder, TextureAtlasSprite sprite, PoseStack poseStack,
                                                      float x1, float y, float z1,
                                                      float x2, float z2,
                                                      int tintColor, int packedLight, int packedOverlay,
                                                      Direction direction
    )
    {
        float minU = sprite.getU(x1/16F);
        float maxU = sprite.getU(x2/16F);
        float minV = sprite.getV(z1/16F);
        float maxV = sprite.getV(z2/16F);

        FluidDisplayRenderHelper.drawFaceRelatively(builder, poseStack,
                x1, y, z1,
                x2, y, z2,
                minU, minV,
                maxU, maxV,
                tintColor, packedLight,packedOverlay,
                direction
        );
    }
}
