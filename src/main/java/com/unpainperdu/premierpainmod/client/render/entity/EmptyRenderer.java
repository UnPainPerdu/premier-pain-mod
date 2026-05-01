package com.unpainperdu.premierpainmod.client.render.entity;

import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.world.entity.Entity;

public class EmptyRenderer<T extends Entity> extends EntityRenderer<T, EntityRenderState>
{
    public EmptyRenderer(EntityRendererProvider.Context ctx)
    {
        super(ctx);
    }

    @Override
    public EntityRenderState createRenderState()
    {
        return new EntityRenderState();
    }

    @Override
    public boolean shouldRender(Entity livingEntity, Frustum camera, double camX, double camY, double camZ)
    {
        return false;
    }
}