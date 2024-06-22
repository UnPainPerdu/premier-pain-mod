package com.unpainperdu.premierpainmod.level.world.block.state.properties;

import net.minecraft.util.StringRepresentable;

public enum VillagerMultiBlock implements StringRepresentable
{
    /*
    Able to go to 3x3x3
    start with layer 1 at bottom and do the 2nd and after the 3rd
    Block in a layer order :
    789
    456
    123
    */
    //Block 1 layer 1
    B1_L1("b1_l1"),
    B2_L1("b2_l1"),
    B3_L1("b3_l1"),
    B4_L1("b4_l1"),
    B5_L1("b5_l1"),
    B6_L1("b6_l1"),
    B7_L1("b7_l1"),
    B8_L1("b8_l1"),
    B9_L1("b9_l1"),
    B1_L2("b1_l2"),
    B2_L2("b2_l2"),
    B3_L2("b3_l2"),
    B4_L2("b4_l2"),
    B5_L2("b5_l2"),
    B6_L2("b6_l2"),
    B7_L2("b7_l2"),
    B8_L2("b8_l2"),
    B9_L2("b9_l2"),
    B1_L3("b1_l3"),
    B2_L3("b2_l3"),
    B3_L3("b3_l3"),
    B4_L3("b4_l3"),
    B5_L3("b5_l3"),
    B6_L3("b6_l3"),
    B7_L3("b7_l3"),
    B8_L3("b8_l3"),
    B9_L3("b9_l3");

    private final String name;

    private VillagerMultiBlock(String pName)
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
