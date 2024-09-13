package com.unpainperdu.premierpainmod.client.render.renderBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerPedestalBlock;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.TwoBlockWidthPart;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockWidthWithBlockEntity.villagerShelf.StandingVillagerShelf;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockWidthWithBlockEntity.villagerShelf.VillagerShelf;
import com.unpainperdu.premierpainmod.level.world.entity.blockEntity.allMaterialsBlock.VillagerShelfBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class VillagerShelfRender implements BlockEntityRenderer<VillagerShelfBlockEntity>
{
    @Override
    public void render(VillagerShelfBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay)
    {
        Block blockShelf = pBlockEntity.getBlockShelfBound();
        BlockState blockStateShelf = pBlockEntity.getBlockState();
        Direction direction = blockStateShelf.getValue(VillagerPedestalBlock.FACING);
        NonNullList<ItemStack> itemStackList = pBlockEntity.getItems();
        float fristFloor;
        float secoundFloor;
        int a = 0;
        float translationToBackOfShelf;
        float scale;
        if(blockShelf instanceof StandingVillagerShelf)
        {
            Boolean has_below = blockStateShelf.getValue(StandingVillagerShelf.HAS_SHELF_BELOW);
            Boolean has_top = blockStateShelf.getValue(StandingVillagerShelf.HAS_SHELF_ON_TOP);
            translationToBackOfShelf = 0.155f;
            scale = 0.45f;
            if(has_below && !has_top)
            {
                fristFloor = 0.18F;
                secoundFloor = 0.52F;
            }
            else if (has_below)
            {
                fristFloor = 0.18F;
                secoundFloor = 0.71F;
            }
            else
            {
                fristFloor = 0.30F;
                secoundFloor = 0.71F;
            }
        }
        else
        {
            fristFloor = 0.4F;
            secoundFloor = 0.7F;
            translationToBackOfShelf = 0.3125f;
            scale = 1f/3;
        }
            for (ItemStack itemstack : itemStackList)
            {
                Item item = itemstack.getItem();
                Block block = Block.byItem(item);
                int i = (int) pBlockEntity.getBlockPos().asLong();

                if (itemstack != ItemStack.EMPTY)
                {
                    pPoseStack.pushPose();
                    translationHelper(direction,pPoseStack,a,fristFloor,secoundFloor, translationToBackOfShelf,blockStateShelf);
                    if (block != Blocks.AIR)
                    {
                        Direction direction1 = Direction.from2DDataValue((direction.get2DDataValue()) % 4);
                        float f = -direction1.toYRot();
                        pPoseStack.mulPose(Axis.YP.rotationDegrees(f));
                        pPoseStack.mulPose(Axis.XP.rotationDegrees(0F));
                        pPoseStack.scale(scale, scale, scale);
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
                        pPoseStack.translate(0f,0.02f,0f);
                        Direction direction1 = Direction.from2DDataValue((direction.get2DDataValue()) % 4);
                        float f = -direction1.toYRot();
                        pPoseStack.mulPose(Axis.YP.rotationDegrees(f));
                        pPoseStack.mulPose(Axis.XP.rotationDegrees(0F));
                        pPoseStack.scale((float) ((Float) scale/1.5), (float) ((Float) scale/1.5), (float) ((Float) scale/1.5));
                        Minecraft.getInstance().getItemRenderer().renderStatic(itemstack, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBuffer, pBlockEntity.getLevel(), i);
                        pPoseStack.popPose();
                    }
                    else
                    {
                        Direction direction1 = Direction.from2DDataValue((direction.get2DDataValue()) % 4);
                        float f = -direction1.toYRot();
                        pPoseStack.mulPose(Axis.YP.rotationDegrees(f));
                        pPoseStack.mulPose(Axis.XP.rotationDegrees(0F));
                        pPoseStack.scale(scale/2, scale/2, scale/2);
                        Minecraft.getInstance().getItemRenderer().renderStatic(itemstack, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBuffer, pBlockEntity.getLevel(), i);
                        pPoseStack.popPose();
                    }
                }
                a++;
            }
    }
    private void translationHelper(Direction direction, PoseStack poseStack, int a, float fristFloor,float secoundFloor,float translationToBackOfShelf, BlockState blockStateShelf)
    {
        float modif = 0.278f;
        poseStack.translate(0.5f,0,0.5f); // center the item
        if (a < 3)
        {
            poseStack.translate(0f,secoundFloor,0f);
        }
        else
        {
            poseStack.translate(0f,fristFloor,0f);
        }
        int xMulti = 0;
        int zMulti = 0;
        float partTranslationX = 0f;
        float partTranslationZ = 0f;
        int ModuloA = (a%3) - 1;
        switch (direction)
        {
            case Direction.EAST :
            {
                if (blockStateShelf.getValue(VillagerShelf.PART) == TwoBlockWidthPart.LEFT)
                {
                    partTranslationX = translationToBackOfShelf;
                    partTranslationZ = 0.1f;
                }
                else
                {
                    partTranslationX = translationToBackOfShelf;
                    partTranslationZ = -0.1f;
                }
                zMulti = ModuloA;
                break;
            }
            case Direction.WEST :
            {
                if (blockStateShelf.getValue(VillagerShelf.PART) == TwoBlockWidthPart.LEFT)
                {
                    partTranslationX = -translationToBackOfShelf;
                    partTranslationZ = -0.1f;
                }
                else
                {
                    partTranslationX = -translationToBackOfShelf;
                    partTranslationZ = 0.1f;
                }
                zMulti = -ModuloA;
                break;
            }
            case Direction.SOUTH :
            {
                if (blockStateShelf.getValue(VillagerShelf.PART) == TwoBlockWidthPart.LEFT)
                {
                    partTranslationX = -0.1f;
                    partTranslationZ = translationToBackOfShelf;
                }
                else
                {
                    partTranslationX = 0.1f;
                    partTranslationZ = translationToBackOfShelf;
                }
                xMulti = -ModuloA;
                break;
            }
            default :
            {
                if (blockStateShelf.getValue(VillagerShelf.PART) == TwoBlockWidthPart.RIGHT)
                {
                    partTranslationX = -0.1f;
                    partTranslationZ = -translationToBackOfShelf;
                }
                else
                {
                    partTranslationX = 0.1f;
                    partTranslationZ = -translationToBackOfShelf;
                }
                xMulti = ModuloA;
                break;
            }
        }
        poseStack.translate(partTranslationX,0f,partTranslationZ);
        poseStack.translate(modif*xMulti, 0f, modif*zMulti);
    }
}
