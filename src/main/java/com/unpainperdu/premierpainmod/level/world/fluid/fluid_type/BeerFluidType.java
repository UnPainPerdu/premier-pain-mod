package com.unpainperdu.premierpainmod.level.world.fluid.fluid_type;

import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogParameters;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector4f;

public class BeerFluidType extends AbstractFluidType
{
    private final ResourceLocation stillTexture = ResourceLocation.parse("block/water_still");
    private final ResourceLocation flowingTexture = ResourceLocation.parse("block/water_flow");
    private final ResourceLocation overlayTexture = ResourceLocation.parse("block/water_overlay");
    private final float fogStart;
    private final float fogEnd;
    private final int tintColor;
    private final Vector4f fogColor;

    public BeerFluidType(Properties properties, int tintColor, Vector4f fogColor)
    {
        super(properties);
        this.tintColor = tintColor;
        this.fogColor = fogColor;
        this.fogStart = 3f;
        this.fogEnd = 5f;
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

    @Override
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
            public FogParameters modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, FogParameters fogParameters)
            {
                return new FogParameters(
                        fogStart,
                        fogEnd,
                        fogParameters.shape(),
                        fogParameters.red(),
                        fogParameters.green(),
                        fogParameters.blue(),
                        fogParameters.alpha()
                );
            }

            @Override
            public Vector4f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector4f fluidFogColor)
            {
                return fogColor;
            }
        };
    }
}