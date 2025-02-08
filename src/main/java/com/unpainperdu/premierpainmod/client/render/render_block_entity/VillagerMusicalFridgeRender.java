package com.unpainperdu.premierpainmod.client.render.render_block_entity;

import com.mojang.blaze3d.vertex.PoseStack;
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
import net.minecraft.world.level.block.state.BlockState;

public class VillagerMusicalFridgeRender implements BlockEntityRenderer<VillagerMusicalFridgeBlockEntity>
{
    @Override
    public void render(VillagerMusicalFridgeBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay)
    {
        BlockState state = blockEntity.getBlockState();
        Direction direction = state.getValue(VillagerMusicalFridgeBlock.FACING);
        NonNullList<ItemStack> itemStacks = blockEntity.getItems();
        float floor0 = 0f;
        float floor1 = 0f;
        float floor2 = 0f;
        float floor3 = 0f;
        float floor4 = 0f;
        float floor5 = 0f;
        float translationToBackOfShel = 0f;
        float scale = 0f;
        for (int i = 1; i < VillagerMusicalFridgeBlockEntity.CONTAINER_SIZE; i++)
        {
            ItemStack itemStack = itemStacks.get(i);
            Item item = itemStack.getItem();
            Block block = Block.byItem(item);
            System.out.println("tente de render " + itemStack + " en index " + i );
            if (!itemStack.isEmpty() && i == 1)
            {
                System.out.println("je render");
                poseStack.pushPose(); // initialisation ?

                poseStack.translate(0.5f,0,0.5f); //translation of rendered item

                Minecraft.getInstance().getItemRenderer().renderStatic(itemStack, ItemDisplayContext.FIXED, packedLight, packedOverlay, poseStack, bufferSource, blockEntity.getLevel(), i);  //set render item
                poseStack.popPose(); //display item
            }
        }


    }
}
