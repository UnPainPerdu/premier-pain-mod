package com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

public enum LiquidContent implements StringRepresentable
{
    EMPTY("empty", 0xf1FFFFFF, new Vector3f(1.0f, 1.0f, 1.0f)),
    WATER("water", 0xf13F76E4, new Vector3f(63f/255f, 118f/255f, 228f/255f)),
    BLOND_BEER("blond_beer", 0xf1faa12d, new Vector3f(250f/255f, 161f/255f, 45f/255f)),
    BROWN_BEER("brown_beer", 0xf1935800, new Vector3f(147f/255f, 88f/255f, 0f)),
    GREEN_BEER("green_beer", 0xf1369244, new Vector3f(54f/255f, 146f/255f, 68f/255f)),
    RED_BEER("red_beer", 0xf1ce2222, new Vector3f(206f/255f, 34f/255f, 34f/255f)),
    DARK_RED_BEER("dark_red_beer", 0xf1520c0c, new Vector3f(82f/255f, 12f/255f, 12f/255f)),
    WHITE_BEER("white_beer", 0xf1e9de95, new Vector3f(233f/255f, 222f/255f, 149f/255f)),
    BLACK_BEER("black_beer", 0xf12c1a04, new Vector3f(44f/255f, 26f/255f, 04f/255f)),
    AMBER_BEER("amber_beer", 0xf1fa7700, new Vector3f(250f/255f, 119f/255f, 0)),
    PURPLE_BEER("purple_beer", 0xf1ac08cc, new Vector3f(172f/255f, 8f/255f, 204f/255f))
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
