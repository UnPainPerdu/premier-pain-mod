package com.unpainperdu.premierpainmod.client.render.entity.flowered_lizard;

import com.mojang.blaze3d.vertex.PoseStack;
import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.FloweredLizardEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class FloweredLizardRender extends MobRenderer<FloweredLizardEntity, FloweredLizardModel>
{
    public FloweredLizardRender(EntityRendererProvider.Context context)
    {
        super(context, new FloweredLizardModel(context.bakeLayer(FloweredLizardModel.LAYER_LOCATION)), 0.7F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull FloweredLizardEntity entity)
    {
        return ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "textures/entity/mob/flowered_lizard/main.png");
    }

    @Override
    public void render(FloweredLizardEntity entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight)
    {
        float scale = entity.isBaby() ? FloweredLizardEntity.BABY_SCALE : 1F;
        poseStack.scale(scale, scale, scale);

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
