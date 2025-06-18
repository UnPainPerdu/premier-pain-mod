package com.unpainperdu.premierpainmod.client.render.entity.mountain_currant_golem;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.MountainCurrantGolemEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MountainCurrantGolemRender extends MobRenderer<MountainCurrantGolemEntity, MountainCurrantGolemModel>
{

    public MountainCurrantGolemRender(EntityRendererProvider.Context context)
    {
        super(context, new MountainCurrantGolemModel(context.bakeLayer(MountainCurrantGolemModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(MountainCurrantGolemEntity entity)
    {
        return ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "textures/entity/mob/mountain_currant_golem.png");
    }
}
