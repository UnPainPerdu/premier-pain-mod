package com.unpainperdu.premierpainmod.util.type;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes
{
    private ModWoodTypes(){}

    public static final WoodType MOUNTAIN_CURRANT = create("mountain_currant", ModBlockSetType.MOUNTAIN_CURRANT);
    public static final WoodType MORICHE_PALM = create("moriche_palm", ModBlockSetType.MORICHE_PALM);

    private static WoodType create(String name, BlockSetType type)
    {
        return WoodType.register(new WoodType(PremierPainMod.MOD_ID + ":" + name, type));
    }
}
