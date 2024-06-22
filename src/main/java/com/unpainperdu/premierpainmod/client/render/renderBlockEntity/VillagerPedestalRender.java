package com.unpainperdu.premierpainmod.client.render.renderBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.unpainperdu.premierpainmod.level.world.block.VillagerPedestalBlock;
import com.unpainperdu.premierpainmod.level.world.entity.blockEntity.PedestalBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class VillagerPedestalRender implements BlockEntityRenderer<PedestalBlockEntity>
{
    private static final float SIZE = 0.375F;

    public void render(PedestalBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay)
    {
        Direction direction = pBlockEntity.getBlockState().getValue(VillagerPedestalBlock.FACING);
        NonNullList<ItemStack> nonnulllist = pBlockEntity.getItems();
        ItemStack itemstack = nonnulllist.getFirst();
        Item item = itemstack.getItem();
        Block block = Block.byItem(item);
        int i = (int)pBlockEntity.getBlockPos().asLong();
        if (itemstack != ItemStack.EMPTY)
        {
            if(block != Blocks.AIR)
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
            else if((item instanceof SwordItem)
                    || (item instanceof PickaxeItem)
                    || (item instanceof ShovelItem)
                    || (item instanceof AxeItem)
                    || (item instanceof HoeItem)
                    || (item instanceof BowItem)
                    || (item instanceof CrossbowItem)
                    || (item instanceof ShieldItem)
                    || (item instanceof MaceItem)
                    || (item instanceof TridentItem)
                    || (item instanceof ArmorItem)
            )
            {
                pPoseStack.pushPose();
                pPoseStack.translate(0.5F, 1.5F, 0.5F);
                Direction direction1 = Direction.from2DDataValue((direction.get2DDataValue()) % 4);
                float f = -direction1.toYRot();
                pPoseStack.mulPose(Axis.YP.rotationDegrees(f));
                if(item instanceof SwordItem)
                {
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(135F));
                }
                pPoseStack.scale(0.85F, 0.85F, 0.85F);
                Minecraft.getInstance().getItemRenderer().renderStatic(itemstack, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBuffer, pBlockEntity.getLevel(), i);
                pPoseStack.popPose();
            }
            else
            {
                pPoseStack.pushPose();
                pPoseStack.translate(0.5F, 1.25F, 0.5F);
                Direction direction1 = Direction.from2DDataValue((direction.get2DDataValue()) % 4);
                float f = -direction1.toYRot();
                pPoseStack.mulPose(Axis.YP.rotationDegrees(f));
                pPoseStack.mulPose(Axis.XP.rotationDegrees(0F));
                pPoseStack.scale(0.5F, 0.5F, 0.5F);
                Minecraft.getInstance().getItemRenderer().renderStatic(itemstack, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBuffer, pBlockEntity.getLevel(), i);
                pPoseStack.popPose();
            }

        }
    }
}