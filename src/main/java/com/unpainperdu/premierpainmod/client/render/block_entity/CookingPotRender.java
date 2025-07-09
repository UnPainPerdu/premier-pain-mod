package com.unpainperdu.premierpainmod.client.render.block_entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.VillagerBrewingStation;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.crafting_block.CookingPotBlockEntity;
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

public class CookingPotRender implements BlockEntityRenderer<CookingPotBlockEntity>
{
    @Override
    public void render(CookingPotBlockEntity blockEntity, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight, int packedOverlay)
    {

        FluidTank tank = blockEntity.getFluidTank();

        if (!tank.isEmpty())
        {
            Level level = blockEntity.getLevel();
            if (level != null)
            {
                FluidStack fluid = tank.getFluid();
                IClientFluidTypeExtensions fluidTypeExtensions = IClientFluidTypeExtensions.of(fluid.getFluid());
                ResourceLocation stillTexture = fluidTypeExtensions.getStillTexture(fluid);
                TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(stillTexture);
                BlockPos pos = blockEntity.getBlockPos();
                FluidState fluidState = fluid.getFluid().defaultFluidState();
                int tintColor = fluidTypeExtensions.getTintColor(fluidState, level, pos);
                VertexConsumer builder = buffer.getBuffer(RenderType.entityTranslucent(sprite.atlasLocation()));
                BlockState state = blockEntity.getBlockState();
                Direction direction = state.getValue(VillagerBrewingStation.FACING);

                renderFluid(builder, sprite, poseStack,
                        tintColor, packedLight, packedOverlay,
                        direction
                );
            }

        }
    }

    public static void renderFluid(VertexConsumer builder, TextureAtlasSprite sprite, PoseStack poseStack,
                                      int tintColor, int packedLight, int packedOverlay, Direction direction
    )
    {
        FluidDisplayRenderHelper.drawFaceRelativelyHorizontally(builder, sprite, poseStack,
                4.001F, 7.999F, 4.001F,
                12.001F, 12.001F,
                tintColor, packedLight,packedOverlay,
                direction
        );
    }
}
