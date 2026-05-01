package com.unpainperdu.premierpainmod.client.render.block_entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
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
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.NotNull;

import static com.unpainperdu.premierpainmod.client.util.tool_kit.render.FluidDisplayRenderHelper.drawFaceRelativelyHorizontally;
import static com.unpainperdu.premierpainmod.client.util.tool_kit.render.ItemDisplayRenderHelper.*;

public class CookingPotRender implements BlockEntityRenderer<CookingPotBlockEntity>
{
    @Override
    public void render(CookingPotBlockEntity blockEntity, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight, int packedOverlay)
    {
        Level level = blockEntity.getLevel();
        if (level != null)
        {
            int baseYItemRenderOffset = -3;
            FluidTank tank = blockEntity.getFluidTank();
            BlockState state = blockEntity.getBlockState();
            Direction direction = state.getValue(VillagerBrewingStation.FACING);
            if (!tank.isEmpty())
            {
                baseYItemRenderOffset = 0;
                RandomSource rand = level.getRandom();
                FluidStack fluid = tank.getFluid();
                IClientFluidTypeExtensions fluidTypeExtensions = IClientFluidTypeExtensions.of(fluid.getFluid());
                ResourceLocation stillTexture = fluidTypeExtensions.getStillTexture(fluid);
                TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(ResourceLocation.withDefaultNamespace("blocks")).apply(stillTexture); //si foire, essayer TextureAtlas.LOCATION_BLOCKS ?
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
            for (int i = 1; i < 7; i++)
            {
                ItemStack itemStack = blockEntity.getItem(i);
                if (!itemStack.isEmpty())
                {
                    poseStack.pushPose();
                    setItemRenderToCenter(poseStack);
                    poseStack.translate(0, 0.5F, 0);
                    setPosItemStack(poseStack, direction, i, baseYItemRenderOffset);
                    //rotate translation too, must be set last to avoid it
                    setRotationItemStack(poseStack, direction, i);
                    float scale = 0.25f;
                    poseStack.scale(scale, scale, scale); //scale translation too, must be set last to avoid it
                    Minecraft.getInstance().getItemRenderer().renderStatic(itemStack, ItemDisplayContext.FIXED, packedLight, packedOverlay, poseStack, buffer, blockEntity.getLevel(), i);  //set render item
                    poseStack.popPose();
                }
            }
        }
    }

    public static void renderFluid(VertexConsumer builder, TextureAtlasSprite sprite, PoseStack poseStack,
                                   int tintColor, int packedLight, int packedOverlay, Direction direction
    )
    {
        drawFaceRelativelyHorizontally(builder, sprite, poseStack,
                4.001F, 7.999F, 4.001F,
                12.001F, 12.001F,
                tintColor, packedLight, packedOverlay,
                direction
        );
    }

    private void setPosItemStack(PoseStack poseStack, Direction direction, int index, int baseYItemRenderOffset)
    {
        float x;
        float y;
        float z;

        switch (index)
        {
            case 1 ->
            {
                x = -3F;
                y = 0;
                z = 0;
            }
            case 2 ->
            {
                x = 3F;
                y = -0.5F;
                z = 0;
            }
            case 3 ->
            {
                x = -1;
                y = -0.1F;
                z = 2;
            }
            case 4 ->
            {
                x = 1;
                y = 0;
                z = 2;
            }
            case 5 ->
            {
                x = -1;
                y = -0.2F;
                z = -2;
            }
            default ->
            {
                x = 1;
                y = 0.1F;
                z = -2;
            }
        }
        moveOnRelativeXInPixel(direction, poseStack, x);
        moveOnRelativeYInPixel(direction, poseStack, z);
        poseStack.translate(0F, getTranslationFloatFromPixel(y + baseYItemRenderOffset), 0F);
    }

    private void setRotationItemStack(PoseStack poseStack, Direction direction, int index)
    {
        poseStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
        int x;
        int y;
        int z;

        switch (index)
        {
            case 1 ->
            {
                x = 180;
                y = 5;
                z = 20;
            }
            case 2 ->
            {
                x = 175;
                y = 10;
                z = 50;
            }
            case 3 ->
            {
                x = 25;
                y = 10;
                z = 150;
            }
            case 4 ->
            {
                x = 145;
                y = 0;
                z = 55;
            }
            case 5 ->
            {
                x = 0;
                y = 145;
                z = 20;
            }
            default ->
            {
                x = 12;
                y = 25;
                z = 100;
            }
        }
        poseStack.mulPose(Axis.XP.rotationDegrees(x));
        poseStack.mulPose(Axis.YP.rotationDegrees(y));
        poseStack.mulPose(Axis.ZP.rotationDegrees(z));
    }
}