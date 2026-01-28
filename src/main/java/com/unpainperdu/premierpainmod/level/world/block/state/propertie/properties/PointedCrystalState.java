package com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum PointedCrystalState implements StringRepresentable
{
    BASE("base"),
    MIDDLE("middle"),
    START_TOP("start_top"),
    TOP("top");

    private final String name;

    PointedCrystalState(String name)
    {
        this.name = name;
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
