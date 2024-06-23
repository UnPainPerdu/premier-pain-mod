package com.unpainperdu.premierpainmod.level.world.block.state.properties;

import net.minecraft.util.StringRepresentable;

public enum TwoBlockWidthPart implements StringRepresentable
{
    RIGHT("right"),
    LEFT("left");

    private final String name;

    private TwoBlockWidthPart(String pName) {
        this.name = pName;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
