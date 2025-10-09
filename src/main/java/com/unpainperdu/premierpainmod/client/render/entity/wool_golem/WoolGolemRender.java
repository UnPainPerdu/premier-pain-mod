package com.unpainperdu.premierpainmod.client.render.entity.wool_golem;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.MountainCurrantGolemEntity;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.WoolGolemEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class WoolGolemRender extends MobRenderer<WoolGolemEntity, WoolGolemModel>
{

    public WoolGolemRender(EntityRendererProvider.Context context)
    {
        super(context, new WoolGolemModel(context.bakeLayer(WoolGolemModel.LAYER_LOCATION)), 1.0F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull WoolGolemEntity entity)
    {
        ResourceLocation result = ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "textures/entity/mob/wool_golem/white.png");
        if (entity.getCustomName() != null)
        {
            if (entity.getCustomName().getString().equals("Mr.Fruit"))
            {
                result = ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "textures/entity/mob/wool_golem/black.png");
            }
        }
        return result;
    }
}
