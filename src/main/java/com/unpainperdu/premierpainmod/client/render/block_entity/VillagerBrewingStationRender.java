package com.unpainperdu.premierpainmod.client.render.block_entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.unpainperdu.premierpainmod.client.util.tool_kit.render.FluidDisplayRenderHelper;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.VillagerBrewingStation;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.all_materials_block.VillagerBrewingStationBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.NotNull;

public class VillagerBrewingStationRender implements BlockEntityRenderer<VillagerBrewingStationBlockEntity>
{
    @Override
    public void render(VillagerBrewingStationBlockEntity blockEntity, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight, int packedOverlay)
    {

        FluidTank tank = blockEntity.getFluidTank();
        FluidStack fluid = tank.getFluid();
        if (tank.isEmpty())
        {
            return;
        }
        IClientFluidTypeExtensions fluidTypeExtensions = IClientFluidTypeExtensions.of(fluid.getFluid());
        ResourceLocation stillTexture = fluidTypeExtensions.getStillTexture(fluid);
        Level level = blockEntity.getLevel();
        if (level == null)
        {
            return;
        }
        TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(ResourceLocation.withDefaultNamespace("blocks")).apply(stillTexture); //si foire, essayer TextureAtlas.LOCATION_BLOCKS ?
        BlockState state = blockEntity.getBlockState();
        BlockPos pos = blockEntity.getBlockPos();
        FluidState fluidState = fluid.getFluid().defaultFluidState();
        int tintColor = fluidTypeExtensions.getTintColor(fluidState, level, pos);
        float quantity = fluid.getAmount();
        float capacity = tank.getCapacity();
        float percentage = quantity / capacity * 100;
        Direction direction = state.getValue(VillagerBrewingStation.FACING);
        VertexConsumer builder = buffer.getBuffer(RenderType.entityTranslucent(sprite.atlasLocation()));

        float currentY = getPixelY(percentage);

        renderFrontGlassFluid(builder, sprite, poseStack,
                tintColor, packedLight, packedOverlay,
                currentY, direction
                );

        renderSideGlassFluid(builder, sprite, poseStack,
                tintColor, packedLight, packedOverlay,
                currentY, direction
        );

        renderTopFluid(builder, sprite, poseStack,
                tintColor, packedLight, packedOverlay,
                currentY, direction
        );

    }

    public static void renderFrontGlassFluid(VertexConsumer builder, TextureAtlasSprite sprite, PoseStack poseStack,
                                             int tintColor, int packedLight, int packedOverlay,
                                             float currentY, Direction direction
    )
    {
        float x1 = 8;
        float x2 = 12;
        float y1 = Math.min(6,currentY);
        float y2 = Math.min(10,currentY);
        float z = 15.8F;

        float minU = sprite.getU(x1/16F);
        float maxU = sprite.getU(x2/16F);
        float minV = sprite.getV(y1/16F);
        float maxV = sprite.getV(y2/16F);
        FluidDisplayRenderHelper.drawFaceRelatively(builder, poseStack,
                x1, y1, z,
                x2, y2, z,
                minU, minV,
                maxU, maxV,
                tintColor, packedLight,packedOverlay,
                direction
        );
    }

    public static void renderSideGlassFluid(VertexConsumer builder, TextureAtlasSprite sprite, PoseStack poseStack,
                                            int tintColor, int packedLight, int packedOverlay,
                                            float currentY, Direction direction
    )
    {
        float xA = 2.1F;
        float xB = 13.9F;
        float y1 = Math.min(10,currentY);
        float y2 = Math.min(12,currentY);
        float z1 = 4;
        float z2 = 13;

        float minU = sprite.getU(z1/16F);
        float maxU = sprite.getU(z2/16F);
        float minV = sprite.getV(y1/16F);
        float maxV = sprite.getV(y2/16F);

        FluidDisplayRenderHelper.drawFaceRelatively(builder, poseStack,
                xA, y1, z1,
                xA, y2, z2,
                minU, minV,
                maxU, maxV,
                tintColor, packedLight,packedOverlay,
                direction
        );

        FluidDisplayRenderHelper.drawFaceRelatively(builder, poseStack,
                xB, y1, z1,
                xB, y2, z2,
                minU, minV,
                maxU, maxV,
                tintColor, packedLight,packedOverlay,
                direction
        );
    }

    public static void renderTopFluid(VertexConsumer builder, TextureAtlasSprite sprite, PoseStack poseStack,
                                       int tintColor, int packedLight, int packedOverlay,
                                       float currentY, Direction direction
    )
    {
        float x1 = 2.001F;
        float x2 = 13.999F;
        float z1 = 0.001F;
        float z2 = 15.999F;

        if (currentY < 6)
        {
            x1 = x1 + 2;
            x2 = x2 - 2;
        }
        if (currentY < 5)
        {
            x1 = x1 + 1;
            x2 = x2 - 1;
        }
        if (currentY < 4)
        {
            x1 = x1 + 1;
            x2 = x2 - 1;
        }
        if (currentY < 3)
        {
            x1 = x1 + 1;
            x2 = x2 - 1;
        }

        float minU = sprite.getU(x1/16F);
        float maxU = sprite.getU(x2/16F);
        float minV = sprite.getV(z1/16F);
        float maxV = sprite.getV(z2/16F);

        FluidDisplayRenderHelper.drawFaceRelatively(builder, poseStack,
                x1, currentY, z1,
                x2, currentY, z2,
                minU, minV,
                maxU, maxV,
                tintColor, packedLight,packedOverlay,
                direction
        );
    }

    private float getPixelY(float percentage)
    {
        float defaultY = 11.999F;

        float result = 16 * (percentage/100);

        return (Math.min(result, defaultY));
    }
}
