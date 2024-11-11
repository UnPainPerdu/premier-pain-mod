package com.unpainperdu.premierpainmod.util.type;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes
{
    public static final WoodType MOUNTAIN_CURRANT = create("mountain_currant");

    private static WoodType create(String name)
    {
        return WoodType.register(new WoodType(PremierPainMod.MOD_ID + ":" + name, ModBlockSetType.MOUNTAIN_CURRANT));
    }
}
