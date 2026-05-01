package com.unpainperdu.premierpainmod.client.render.entity.flowered_lizard;

import com.mojang.blaze3d.vertex.PoseStack;
import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.FloweredLizardEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FloweredLizardRender extends MobRenderer<FloweredLizardEntity, FloweredLizardRenderState, FloweredLizardModel>
{
    public FloweredLizardRender(EntityRendererProvider.Context context)
    {
        super(context, new FloweredLizardModel(context.bakeLayer(FloweredLizardModel.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public FloweredLizardRenderState createRenderState()
    {
        return new FloweredLizardRenderState();
    }

    @Override
    public void render(FloweredLizardRenderState floweredLizardRenderState, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
    {
        float scale = floweredLizardRenderState.isBaby ? FloweredLizardEntity.BABY_SCALE : 1F;
        poseStack.scale(scale, scale, scale);
        super.render(floweredLizardRenderState, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(FloweredLizardRenderState renderState)
    {
        return ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "textures/entity/mob/flowered_lizard/main.png");
    }

    @Override
    public void extractRenderState(FloweredLizardEntity entity, FloweredLizardRenderState renderState, float partialTick)
    {
        super.extractRenderState(entity, renderState, partialTick);
        renderState.idleAnimationState.copyFrom(entity.idleAnimationState);
        renderState.walkAnimationState.copyFrom(entity.walkAnimationState);
        renderState.attack0AnimationState.copyFrom(entity.attack0AnimationState);
        renderState.attack1AnimationState.copyFrom(entity.attack1AnimationState);
        renderState.attack2AnimationState.copyFrom(entity.attack2AnimationState);
        renderState.eatAnimationState.copyFrom(entity.eatAnimationState);
    }
}