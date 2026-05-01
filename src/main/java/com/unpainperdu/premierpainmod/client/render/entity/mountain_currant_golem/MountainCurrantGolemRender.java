package com.unpainperdu.premierpainmod.client.render.entity.mountain_currant_golem;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.MountainCurrantGolemEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MountainCurrantGolemRender extends MobRenderer<MountainCurrantGolemEntity, MountainCurrantGolemRenderState, MountainCurrantGolemModel>
{

    public MountainCurrantGolemRender(EntityRendererProvider.Context context)
    {
        super(context, new MountainCurrantGolemModel(context.bakeLayer(MountainCurrantGolemModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public MountainCurrantGolemRenderState createRenderState()
    {
        return new MountainCurrantGolemRenderState();
    }

    @Override
    public ResourceLocation getTextureLocation(MountainCurrantGolemRenderState renderState)
    {
        ResourceLocation result = ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "textures/entity/mob/mountain_currant_golem/main.png");
        if (renderState.customName != null && renderState.customName.getString().equals("Mr.Fruit"))
        {
            result = ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "textures/entity/mob/mountain_currant_golem/mr_fruit.png");
        }
        return result;
    }

    @Override
    public void extractRenderState(MountainCurrantGolemEntity mountainCurrantGolemEntity, MountainCurrantGolemRenderState mountainCurrantGolemRenderState, float partialTick)
    {
        super.extractRenderState(mountainCurrantGolemEntity, mountainCurrantGolemRenderState, partialTick);
        mountainCurrantGolemRenderState.boneMealingAnimationState.copyFrom(mountainCurrantGolemEntity.boneMealingAnimationState);
    }
}