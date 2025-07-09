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

public class VillagerMusicalFridgeRender implements BlockEntityRenderer<VillagerMusicalFridgeBlockEntity>
{
    @Override
    public void render(VillagerMusicalFridgeBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay)
    {
        BlockState state = blockEntity.getBlockState();
        Direction direction = state.getValue(VillagerMusicalFridgeBlock.FACING);
        NonNullList<ItemStack> itemStacks = blockEntity.getItems();  // !!! Need some methods in block entity class to send items to client !!!
        float scale = 0.25f;
        for (int i = 0; i < 6; i++) //do not handle disc slot
        {
            for (int j = 0; j < 6; j++)
            {
                int currentIndex = (j + (6*i)) + 1;

                ItemStack itemStack = itemStacks.get(currentIndex);
                Item item = itemStack.getItem();
                Block block = Block.byItem(item);

                if (!itemStack.isEmpty())
                {
                    float yTranslation = 2f - ItemDisplayRenderHelper.getTranslationFloatFromPixel(6 +(5*i)) + ItemDisplayRenderHelper.getTranslationFloatFromPixel(2);
                    if (block == Blocks.AIR)
                    {
                        yTranslation +=  ItemDisplayRenderHelper.getTranslationFloatFromPixel(1); //set items 1 pixel upper
                    }
                    poseStack.pushPose(); // initialisation
                    //rotation
                    poseStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot())); // item rotation on y-axis
                    poseStack.mulPose(Axis.XP.rotationDegrees(0F));                  // item rotation on x-axis
                    //translation
                    int pixel;
                    if (j < 3) //set item depth position
                    {
                        pixel = -2;
                    }
                    else
                    {
                        pixel = 1;
                    }

                    ItemDisplayRenderHelper.moveOnRelativeXInPixel(direction,poseStack, pixel);

                    if (j%3 == 0)
                    {
                        pixel = -3;
                    }
                    else if (j%3 == 1)
                    {
                        pixel = 0;
                    }
                    else
                    {
                        pixel = 3;
                    }
                    ItemDisplayRenderHelper.moveOnRelativeYInPixel(direction,poseStack, pixel);

                    ItemDisplayRenderHelper.setItemRenderToCenter(direction, poseStack);
                    poseStack.translate(0f,yTranslation, 0f);
                    //scale
                    poseStack.scale(scale, scale, scale);

                    Minecraft.getInstance().getItemRenderer().renderStatic(itemStack, ItemDisplayContext.FIXED, packedLight, packedOverlay, poseStack, bufferSource, blockEntity.getLevel(), i);  //set render item
                    poseStack.popPose(); //display item
                }
            }
        }
    }
}
