package com.unpainperdu.premierpainmod.client.render.entity.wool_golem;

import com.unpainperdu.premierpainmod.level.world.entity.mobs.WoolGolemEntity;
import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class WoolGolemRender extends MobRenderer<WoolGolemEntity, WoolGolemModel>
{

    public WoolGolemRender(EntityRendererProvider.Context context)
    {
        super(context, new WoolGolemModel(context.bakeLayer(WoolGolemModel.LAYER_LOCATION)), 1.0F);
        this.addLayer(new WoolGolemWoolLayer(this));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull WoolGolemEntity entity)
    {
        return ResourceUtil.createResourceLocation("textures/entity/mob/wool_golem/cloth.png");
    }
}
