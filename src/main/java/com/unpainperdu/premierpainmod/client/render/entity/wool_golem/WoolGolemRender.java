package com.unpainperdu.premierpainmod.client.render.entity.wool_golem;

import com.unpainperdu.premierpainmod.level.world.entity.mobs.WoolGolemEntity;
import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WoolGolemRender extends MobRenderer<WoolGolemEntity, WoolGolemRenderState, WoolGolemModel>
{

    public WoolGolemRender(EntityRendererProvider.Context context)
    {
        super(context, new WoolGolemModel(context.bakeLayer(WoolGolemModel.LAYER_LOCATION)), 1.0F);
        this.addLayer(new WoolGolemWoolLayer(this));
    }

    @Override
    public WoolGolemRenderState createRenderState()
    {
        return new WoolGolemRenderState();
    }

    @Override
    public ResourceLocation getTextureLocation(WoolGolemRenderState renderState)
    {
        return ResourceUtil.createResourceLocation("textures/entity/mob/wool_golem/cloth.png");
    }

    @Override
    public void extractRenderState(WoolGolemEntity woolGolemEntity, WoolGolemRenderState woolGolemRenderState, float partialTick)
    {
        super.extractRenderState(woolGolemEntity, woolGolemRenderState, partialTick);
        woolGolemRenderState.woolColor = woolGolemEntity.getWoolDye();
        woolGolemRenderState.id = woolGolemEntity.getId();
        woolGolemRenderState.HUG.copyFrom(woolGolemEntity.HUG);
        woolGolemRenderState.SIT.copyFrom(woolGolemEntity.SIT);
        woolGolemRenderState.GETUP.copyFrom(woolGolemEntity.GETUP);
    }
}