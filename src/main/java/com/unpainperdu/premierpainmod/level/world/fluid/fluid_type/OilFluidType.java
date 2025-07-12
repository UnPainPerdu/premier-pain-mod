package com.unpainperdu.premierpainmod.level.world.fluid.fluid_type;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

public class OilFluidType extends AbstractFluidType
{
    private final ResourceLocation stillTexture = ResourceLocation.parse("block/water_still");
    private final ResourceLocation flowingTexture = ResourceLocation.parse("block/water_flow");
    private final ResourceLocation overlayTexture = ResourceLocation.parse("block/water_overlay");
    private final float fogStart;
    private final float fogEnd;
    private final int tintColor;
    private final Vector3f fogColor;

    public OilFluidType(Properties properties, int tintColor, Vector3f fogColor)
    {
        super(properties);
        this.tintColor = tintColor;
        this.fogColor = fogColor;
        this.fogStart = 1f;
        this.fogEnd = 3f;
    }

    @Override
    public boolean canConvertToSource(@NotNull FluidStack stack)
    {
        return false;
    }

    @Override
    public boolean canConvertToSource(@NotNull FluidState state, @NotNull LevelReader reader, @NotNull BlockPos pos)
    {
        return false;
    }

    public IClientFluidTypeExtensions register()
    {
        return new IClientFluidTypeExtensions()
        {
            @Override
            public @NotNull ResourceLocation getStillTexture()
            {
                return stillTexture;
            }

            @Override
            public @NotNull ResourceLocation getFlowingTexture()
            {
                return flowingTexture;
            }

            @Override
            public ResourceLocation getOverlayTexture()
            {
                return overlayTexture;
            }

            @Override
            public int getTintColor()
            {
                return tintColor;
            }

            @Override
            public @NotNull Vector3f modifyFogColor(@NotNull Camera camera, float partialTick, @NotNull ClientLevel level, int renderDistance, float darkenWorldAmount, @NotNull Vector3f fluidFogColor)
            {
                return fogColor;
            }

            @Override
            public void modifyFogRender(@NotNull Camera camera, FogRenderer.@NotNull FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, @NotNull FogShape shape)
            {
                RenderSystem.setShaderFogStart(fogStart);
                RenderSystem.setShaderFogEnd(fogEnd);
            }
        };
    }
}
