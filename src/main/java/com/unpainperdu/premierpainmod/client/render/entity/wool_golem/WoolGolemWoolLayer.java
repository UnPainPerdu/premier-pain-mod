package com.unpainperdu.premierpainmod.client.render.entity.wool_golem;

import com.mojang.blaze3d.vertex.PoseStack;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.WoolGolemEntity;
import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
import org.jetbrains.annotations.NotNull;

public class WoolGolemWoolLayer extends RenderLayer<WoolGolemEntity, WoolGolemModel>
{

    private static final ResourceLocation WOOL_LOCATION = ResourceUtil.createResourceLocation("textures/entity/mob/wool_golem/wool.png");

    public WoolGolemWoolLayer(RenderLayerParent<WoolGolemEntity, WoolGolemModel> renderer)
    {
        super(renderer);
    }

    @Override
    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight,
                       @NotNull WoolGolemEntity livingEntity, float limbSwing, float limbSwingAmount,
                       float partialTick, float ageInTicks, float netHeadYaw, float headPitch)
    {
        if (!livingEntity.isInvisible())
        {
            int i;
            if (livingEntity.hasCustomName() && "UnPainPerdu".equals(livingEntity.getName().getString()))
            {
                int k = livingEntity.tickCount / 25 + livingEntity.getId();
                int l = DyeColor.values().length;
                int i1 = k % l;
                int j1 = (k + 1) % l;
                float f = ((float) (livingEntity.tickCount % 25) + partialTick) / 25.0F;
                int k1 = WoolGolemEntity.getColor(DyeColor.byId(i1));
                int l1 = WoolGolemEntity.getColor(DyeColor.byId(j1));
                i = FastColor.ARGB32.lerp(f, k1, l1);
            }
            else
            {
                i = WoolGolemEntity.getColor(livingEntity.getWoolDye());
            }
            renderColoredCutoutModel(this.getParentModel(), WOOL_LOCATION, poseStack, bufferSource, packedLight, livingEntity, i);
        }
    }
}
