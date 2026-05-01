package com.unpainperdu.premierpainmod.client.render.entity.wool_golem;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.item.DyeColor;

public class WoolGolemRenderState extends LivingEntityRenderState
{
    public final AnimationState HUG = new AnimationState();
    public final AnimationState SIT = new AnimationState();
    public final AnimationState GETUP = new AnimationState();
    public DyeColor woolColor = DyeColor.WHITE;
    public int id;
}