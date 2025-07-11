package com.unpainperdu.premierpainmod.client.render.block_entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height_with_block_entity.VillagerMusicalFridgeBlock;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.all_materials_block.VillagerMusicalFridgeBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import static com.unpainperdu.premierpainmod.client.util.tool_kit.render.ItemDisplayRenderHelper.*;

public class VillagerMusicalFridgeRender implements BlockEntityRenderer<VillagerMusicalFridgeBlockEntity>
{
    @Override
    public void render(VillagerMusicalFridgeBlockEntity blockEntity, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, int packedOverlay)
    {
        BlockState state = blockEntity.getBlockState();
        Direction direction = state.getValue(VillagerMusicalFridgeBlock.FACING);
        NonNullList<ItemStack> itemStacks = blockEntity.getItems();
        float scale = 0.25f;
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                int currentIndex = (j + (6 * i)) + 1;

                ItemStack itemStack = itemStacks.get(currentIndex);
                Item item = itemStack.getItem();
                Block block = Block.byItem(item);

                if (!itemStack.isEmpty())
                {
                    poseStack.pushPose();
                    //translation
                    setItemRenderToCenter(poseStack);
                    int pixel;
                    if (j < 3) //set item depth position
                    {
                        pixel = -2;
                    }
                    else
                    {
                        pixel = 1;
                    }
                    moveOnRelativeYInPixel(direction, poseStack, pixel);

                    if (j % 3 == 0)
                    {
                        pixel = -3;
                    }
                    else if (j % 3 == 1)
                    {
                        pixel = 0;
                    }
                    else
                    {
                        pixel = 3;
                    }
                    moveOnRelativeXInPixel(direction, poseStack, pixel);

                    float yTranslation = 2f - getTranslationFloatFromPixel(6 + (5 * i)) + getTranslationFloatFromPixel(2);
                    if (block == Blocks.AIR)
                    {
                        yTranslation += getTranslationFloatFromPixel(1); //set items 1 pixel upper
                    }

                    poseStack.translate(0f, yTranslation, 0f);
                    //rotate translation too, must be set last to avoid it
                    poseStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot())); // item rotation on y-axis
                    //scale translation too, must be set last to avoid it
                    poseStack.scale(scale, scale, scale);

                    Minecraft.getInstance().getItemRenderer().renderStatic(itemStack, ItemDisplayContext.FIXED, packedLight, packedOverlay, poseStack, bufferSource, blockEntity.getLevel(), i);  //set render item
                    poseStack.popPose(); //display item
                }
            }
        }
    }
}
