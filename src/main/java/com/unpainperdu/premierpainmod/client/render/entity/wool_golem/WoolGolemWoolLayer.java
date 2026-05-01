package com.unpainperdu.premierpainmod.client.render.entity.wool_golem;

import com.mojang.blaze3d.vertex.PoseStack;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.WoolGolemEntity;
import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.world.item.DyeColor;

public class WoolGolemWoolLayer extends RenderLayer<WoolGolemRenderState, WoolGolemModel>
{

    private static final ResourceLocation WOOL_LOCATION = ResourceUtil.createResourceLocation("textures/entity/mob/wool_golem/wool.png");

    public WoolGolemWoolLayer(RenderLayerParent<WoolGolemRenderState, WoolGolemModel> renderer)
    {
        super(renderer);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, WoolGolemRenderState renderState, float yRot, float xRot)
    {
        if (!renderState.isInvisible)
        {
            int i;
            if (renderState.customName != null && "UnPainPerdu".equals(renderState.customName.getString()))
            {
                int k = (int) (renderState.ageInTicks / 25 + renderState.id);
                int l = DyeColor.values().length;
                int i1 = k % l;
                int j1 = (k + 1) % l;
                float f = ((float) (k % 25) + Mth.frac(renderState.ageInTicks)) / 25.0F;
                int k1 = WoolGolemEntity.getColor(DyeColor.byId(i1));
                int l1 = WoolGolemEntity.getColor(DyeColor.byId(j1));
                i = ARGB.lerp(f, k1, l1);
            }
            else
            {
                i = WoolGolemEntity.getColor(renderState.woolColor);
            }
            renderColoredCutoutModel(this.getParentModel(), WOOL_LOCATION, poseStack, bufferSource, packedLight, renderState, i);
        }
    }
}