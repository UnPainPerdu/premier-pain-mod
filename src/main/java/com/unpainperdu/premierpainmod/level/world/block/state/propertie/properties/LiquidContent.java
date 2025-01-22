package com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum LiquidContent implements StringRepresentable
{
    EMPTY("empty"),
    WATER("water"),
    BEER("beer")
    ;

    private final String name;

    LiquidContent(String pName)
    {
        this.name = pName;
    }

    @Override
    public String toString()
    {
        return this.name;
    }

    @Override
    public @NotNull String getSerializedName()
    {
        return this.name;
    }
}
