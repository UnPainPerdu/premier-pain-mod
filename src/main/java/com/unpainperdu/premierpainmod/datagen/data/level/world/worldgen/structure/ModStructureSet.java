package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure;

import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class ModStructureSet
{
    public static final ResourceKey<StructureSet> FOREST_PREMIER_PAIN_TEMPLE_SET = register("forest_premier_pain_temple_set");
    public static final ResourceKey<StructureSet> SAND_DESERT_PREMIER_PAIN_TEMPLE_SET = register("sand_desert_premier_pain_temple_set");

    private static ResourceKey<StructureSet> register(String path)
    {
        return ResourceKey.create(Registries.STRUCTURE_SET, ResourceUtil.createResourceLocation(path));
    }

    public static void boostrap(BootstrapContext<StructureSet> context)
    {
        HolderGetter<Structure> structureHoldergetter = context.lookup(Registries.STRUCTURE);
        HolderGetter<Biome> biomeHoldergetter = context.lookup(Registries.BIOME);

        context.register(
                FOREST_PREMIER_PAIN_TEMPLE_SET,
                new StructureSet(
                        structureHoldergetter.getOrThrow(ModStructure.FOREST_PREMIER_PAIN_TEMPLE), new RandomSpreadStructurePlacement(50, 45, RandomSpreadType.LINEAR, 1642136474)
                )
        );

        context.register(
                SAND_DESERT_PREMIER_PAIN_TEMPLE_SET,
                new StructureSet(
                        structureHoldergetter.getOrThrow(ModStructure.SAND_DESERT_PREMIER_PAIN_TEMPLE), new RandomSpreadStructurePlacement(50, 45, RandomSpreadType.LINEAR, 1642136474)
                )
        );
    }
}
