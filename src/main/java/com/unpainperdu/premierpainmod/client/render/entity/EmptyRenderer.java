package com.unpainperdu.premierpainmod.client.render.entity;

import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class EmptyRenderer<T extends Entity> extends EntityRenderer<T>
{
    public EmptyRenderer(EntityRendererProvider.Context ctx)
    {
        super(ctx);
    }

    @Override
    public boolean shouldRender(@NotNull T entity, @NotNull Frustum camera, double camX, double camY, double camZ)
    {
        return false;
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull T entity)
    {
        return null;
    }
}
