package com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

public enum LiquidContent implements StringRepresentable
{
    EMPTY("empty", 0xf1FFFFFF, new Vector3f(1.0f, 1.0f, 1.0f)),
    WATER("water", 0xf13F76E4, new Vector3f(63f/255f, 118f/255f, 228f/255f)),
    BLOND_BEER("blond_beer", 0xf1faa12d, new Vector3f(250f/255f, 161f/255f, 45f/255f))
    ;

    private final String name;
    private final int tintIndex;
    private final Vector3f fogColor;

    LiquidContent(String pName, int tintIndex, Vector3f fogColor)
    {
        this.name = pName;
        this.tintIndex = tintIndex;
        this.fogColor = fogColor;
    }

    @Override
    public String toString()
    {
        return this.name;
    }

    public Vector3f getFogColor()
    {
        return fogColor;
    }

    public int getTintIndex()
    {
        return tintIndex;
    }

    @Override
    public @NotNull String getSerializedName()
    {
        return this.name;
    }
}
