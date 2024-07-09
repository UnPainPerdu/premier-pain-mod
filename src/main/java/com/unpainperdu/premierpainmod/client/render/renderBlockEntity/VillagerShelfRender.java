package com.unpainperdu.premierpainmod.client.render.renderBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.unpainperdu.premierpainmod.level.world.block.VillagerPedestalBlock;
import com.unpainperdu.premierpainmod.level.world.entity.blockEntity.VillagerShelfBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class VillagerShelfRender implements BlockEntityRenderer<VillagerShelfBlockEntity>
{
    @Override
    public void render(VillagerShelfBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay)
    {
        Direction direction = pBlockEntity.getBlockState().getValue(VillagerPedestalBlock.FACING);
        NonNullList<ItemStack> itemStackList = pBlockEntity.getItems();
        int a = 0;
        for(ItemStack itemstack : itemStackList)
        {
            System.out.println("Objet numero : "+ a +" -> "+ itemstack);
            Item item = itemstack.getItem();
            Block block = Block.byItem(item);
            int i = (int) pBlockEntity.getBlockPos().asLong();
            if (itemstack != ItemStack.EMPTY)
            {
                pPoseStack.pushPose();
                pPoseStack.translate(0.5F, 1.25F, 0.5F);
                Direction direction1 = Direction.from2DDataValue((direction.get2DDataValue()) % 4);
                float f = -direction1.toYRot();
                pPoseStack.mulPose(Axis.YP.rotationDegrees(f));
                pPoseStack.mulPose(Axis.XP.rotationDegrees(0F));
                pPoseStack.scale(1F, 1F, 1F);
                Minecraft.getInstance().getItemRenderer().renderStatic(itemstack, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBuffer, pBlockEntity.getLevel(), i);
                pPoseStack.popPose();

            }
            a ++;
        }

    }
}
