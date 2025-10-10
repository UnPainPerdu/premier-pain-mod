package com.unpainperdu.premierpainmod.client.render.entity.wool_golem;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.WoolGolemEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
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
        DyeColor dyeColor = entity.getWoolDye();
        String path = "textures/entity/mob/wool_golem/" + dyeColor.getName() + ".png";
        return ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, path);
    }
}
