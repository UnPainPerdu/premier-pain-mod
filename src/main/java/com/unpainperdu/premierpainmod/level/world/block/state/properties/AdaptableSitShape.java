package com.unpainperdu.premierpainmod.level.world.block.state.properties;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum AdaptableSitShape implements StringRepresentable
{
    ALONE("middle_alone"),
    WITH_RIGHT("middle_with_right"),
    WITH_LEFT("middle_with_left"),
    WITH_LEFT_AND_RIGHT("middle_with_left_and_right")
    ;

    private final String name;

    AdaptableSitShape(String pName)
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
