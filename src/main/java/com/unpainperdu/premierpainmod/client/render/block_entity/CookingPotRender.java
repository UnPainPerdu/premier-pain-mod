package com.unpainperdu.premierpainmod.client.render.block_entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.VillagerBrewingStation;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.crafting_block.CookingPotBlockEntity;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
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
        Level level = blockEntity.getLevel();
        if (level != null)
        {
            FluidTank tank = blockEntity.getFluidTank();
            BlockState state = blockEntity.getBlockState();
            Direction direction = state.getValue(VillagerBrewingStation.FACING);
            RandomSource rand = level.getRandom();
            if (!tank.isEmpty())
            {


                FluidStack fluid = tank.getFluid();
                IClientFluidTypeExtensions fluidTypeExtensions = IClientFluidTypeExtensions.of(fluid.getFluid());
                ResourceLocation stillTexture = fluidTypeExtensions.getStillTexture(fluid);
                TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(stillTexture);
                BlockPos pos = blockEntity.getBlockPos();
                FluidState fluidState = fluid.getFluid().defaultFluidState();
                int tintColor = fluidTypeExtensions.getTintColor(fluidState, level, pos);
                VertexConsumer builder = buffer.getBuffer(RenderType.entityTranslucent(sprite.atlasLocation()));


                renderFluid(builder, sprite, poseStack,
                        tintColor, packedLight, packedOverlay,
                        direction
                );
                if (state.getValue(BlockStateProperties.LIT))
                {
                    double x = pos.getX() + ((RandomUtil.getRandomPositiveIntInRange(6, rand) + 5) / 16F);
                    double y = pos.getY() + ((RandomUtil.getRandomPositiveIntInRange(10, rand) + 6) / 16F);
                    double z = pos.getZ() + ((RandomUtil.getRandomPositiveIntInRange(6, rand) + 5) / 16F);
                    level.addParticle(ParticleTypes.BUBBLE, x, y, z, 0, 0.5d, 0);
                }
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
                tintColor, packedLight, packedOverlay,
                direction
        );
    }
}
