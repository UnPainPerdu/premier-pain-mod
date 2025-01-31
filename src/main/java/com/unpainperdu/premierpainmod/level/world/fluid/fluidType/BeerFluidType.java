package com.unpainperdu.premierpainmod.level.world.fluid.fluidType;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.LiquidContent;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;
import org.joml.Vector3f;

import javax.annotation.Nullable;

public class BeerFluidType extends FluidType
{
    private final ResourceLocation stillTexture = ResourceLocation.parse("block/water_still");;
    private final ResourceLocation flowingTexture = ResourceLocation.parse("block/water_flow");;
    private final ResourceLocation overlayTexture = ResourceLocation.parse("block/water_overlay");;
    private final int tintColor;
    private final Vector3f fogColor;
    private final float fogStart;
    private final float fogEnd;
    private final LiquidContent liquidContent;

    public BeerFluidType(Properties properties, LiquidContent liquidContent)
    {
        super(properties);
        this.tintColor = liquidContent.getTintIndex();
        this.fogColor = liquidContent.getFogColor();
        this.liquidContent = liquidContent;
        this.fogStart = 1f;
        this.fogEnd = 3f;
    }

    @Override
    public boolean canConvertToSource(FluidStack stack)
    {
        return false;
    }

    @Override
    public boolean canConvertToSource(FluidState state, LevelReader reader, BlockPos pos)
    {
        return false;
    }

    public LiquidContent getLiquidContent()
    {
        return liquidContent;
    }

    public ResourceLocation getStillTexture()
    {
        return this.stillTexture;
    }

    public ResourceLocation getFlowingTexture()
    {
        return this.flowingTexture;
    }

    public int getTintColor()
    {
        return this.tintColor;
    }

    public ResourceLocation getOverlayTexture()
    {
        return this.overlayTexture;
    }

    public Vector3f getFogColor()
    {
        return this.fogColor;
    }

    public float getFogStart()
    {
        return this.fogStart;
    }

    public float getFogEnd()
    {
        return this.fogEnd;
    }

    public IClientFluidTypeExtensions register()
    {
        return new IClientFluidTypeExtensions()
        {
            @Override
            public ResourceLocation getStillTexture()
            {
                return stillTexture;
            }

            @Override
            public ResourceLocation getFlowingTexture()
            {
                return flowingTexture;
            }

            @Override
            public @Nullable ResourceLocation getOverlayTexture()
            {
                return overlayTexture;
            }

            @Override
            public int getTintColor()
            {
                return tintColor;
            }

            @Override
            public Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor)
            {
                return fogColor;
            }

            @Override
            public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape)
            {
                RenderSystem.setShaderFogStart(fogStart);
                RenderSystem.setShaderFogEnd(fogEnd);
            }
        };
    }
}
