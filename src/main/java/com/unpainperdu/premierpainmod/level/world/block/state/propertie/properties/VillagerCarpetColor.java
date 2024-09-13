package com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties;

import net.minecraft.util.StringRepresentable;

public enum VillagerCarpetColor implements StringRepresentable
{
    NONE("none"),
    WHITE("white"),
    LIGHT_GRAY("light_gray"),
    GRAY("gray"),
    BLACK("black"),
    BROWN("brown"),
    RED("red"),
    ORANGE("orange"),
    YELLOW("yellow"),
    LIME("lime"),
    GREEN("green"),
    CYAN("cyan"),
    LIGHT_BLUE("light_blue"),
    BLUE("blue"),
    PURPLE("purple"),
    MAGENTA("magenta"),
    PINK("pink");

    private final String name;

    private VillagerCarpetColor(String pName)
    {
        this.name = pName;
    }

    @Override
    public String toString()
    {
        return this.name;
    }

    @Override
    public String getSerializedName()
    {
        return this.name;
    }
}
