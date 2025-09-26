package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure;

import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class ModStructureSet
{
    public static final ResourceKey<StructureSet> FOREST_PREMIER_PAIN_TEMPLE_SET = register("forest_premier_pain_temple_set");
    public static final ResourceKey<StructureSet> SAND_DESERT_PREMIER_PAIN_TEMPLE_SET = register("sand_desert_premier_pain_temple_set");
    public static final ResourceKey<StructureSet> SWAMP_PREMIER_PAIN_TEMPLE_SET = register("swamp_premier_pain_temple_set");
    public static final ResourceKey<StructureSet> OLD_GREAT_PATH_SET = register("old_great_path_set");
    public static final ResourceKey<StructureSet> JUNGLE_UNDERGROUND_PETRA_SET = register("jungle_underground_petra_set");

    private static ResourceKey<StructureSet> register(String path)
    {
        return ResourceKey.create(Registries.STRUCTURE_SET, ResourceUtil.createResourceLocation(path));
    }

    public static void boostrap(BootstrapContext<StructureSet> context)
    {
        HolderGetter<Structure> structureHoldergetter = context.lookup(Registries.STRUCTURE);

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
        context.register(
                SWAMP_PREMIER_PAIN_TEMPLE_SET,
                new StructureSet(
                        structureHoldergetter.getOrThrow(ModStructure.SWAMP_PREMIER_PAIN_TEMPLE), new RandomSpreadStructurePlacement(50, 45, RandomSpreadType.LINEAR, 1642136474)
                )
        );

        context.register(
                OLD_GREAT_PATH_SET,
                new StructureSet(
                        structureHoldergetter.getOrThrow(ModStructure.OLD_GREAT_PATH), new RandomSpreadStructurePlacement(25, 20, RandomSpreadType.LINEAR, 1642136474)
                )
        );

        context.register(
                JUNGLE_UNDERGROUND_PETRA_SET,
                new StructureSet(
                        structureHoldergetter.getOrThrow(ModStructure.JUNGLE_UNDERGROUND_PETRA), new RandomSpreadStructurePlacement(20, 8, RandomSpreadType.LINEAR, 1642136474)
                )
        );
    }
}
