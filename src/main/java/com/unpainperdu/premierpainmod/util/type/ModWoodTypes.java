package com.unpainperdu.premierpainmod.util.type;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes
{
    public static final WoodType MOUNTAIN_CURRANT = create("mountain_currant", ModBlockSetType.MOUNTAIN_CURRANT);
    public static final WoodType MORICHE_PALM = create("moriche_palm", ModBlockSetType.MORICHE_PALM);
    public static final WoodType ACHIOTE = create("achiote", ModBlockSetType.ACHIOTE);
    public static final WoodType WEEPING_WILLOW = create("weeping_willow", ModBlockSetType.WEEPING_WILLOW);

    private static WoodType create(String name, BlockSetType type)
    {
        return WoodType.register(new WoodType(PremierPainMod.MOD_ID + ":" + name, type));
    }
}