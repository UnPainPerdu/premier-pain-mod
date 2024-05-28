package com.unpainperdu.premierpainmod.level.world.block.state.properties;

import net.minecraft.util.StringRepresentable;

public enum VillagerWorkshopPart implements StringRepresentable
{
    RIGHT("right"),
    LEFT("left");

    private final String name;

    private VillagerWorkshopPart(String pName) {
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
