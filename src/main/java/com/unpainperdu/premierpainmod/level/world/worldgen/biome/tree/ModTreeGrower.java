package com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree;

import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.ModVegetationFeature;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrower
{
    public static final TreeGrower MOUNTAIN_CURRANT = new TreeGrower("mountain_currant", Optional.empty(), Optional.of(ModVegetationFeature.MOUNTAIN_CURRANT), Optional.empty());
    public static final TreeGrower MORICHE_PALM = new TreeGrower("moriche_palm", Optional.empty(), Optional.of(ModVegetationFeature.MORICHE_PALM), Optional.empty());
}
