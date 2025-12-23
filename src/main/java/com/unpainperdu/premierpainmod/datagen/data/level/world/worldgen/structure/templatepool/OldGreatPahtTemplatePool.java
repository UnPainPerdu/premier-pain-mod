package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.processorlist.OldGreatPathProcessorList;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class OldGreatPahtTemplatePool
{
    private OldGreatPahtTemplatePool()
    {
    }

    public static final ResourceKey<StructureTemplatePool> START = ModStructureTemplatePool.register("old_great_field/all_path");

    public static void boostrap(BootstrapContext<StructureTemplatePool> context, Holder<StructureTemplatePool> emptyFallBack)
    {
        HolderGetter<StructureProcessorList> processorListHolderGetter = context.lookup(Registries.PROCESSOR_LIST);

        context.register(
                START,
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:old_great_field/straight_path", processorListHolderGetter.getOrThrow(OldGreatPathProcessorList.OLD_GREAT_FIELD_STRUCTURE_PATH)), 50),
                                Pair.of(StructurePoolElement.single("premierpainmod:old_great_field/l_left_path", processorListHolderGetter.getOrThrow(OldGreatPathProcessorList.OLD_GREAT_FIELD_STRUCTURE_PATH)), 20),
                                Pair.of(StructurePoolElement.single("premierpainmod:old_great_field/l_right_path", processorListHolderGetter.getOrThrow(OldGreatPathProcessorList.OLD_GREAT_FIELD_STRUCTURE_PATH)), 20),
                                Pair.of(StructurePoolElement.single("premierpainmod:old_great_field/cross_path", processorListHolderGetter.getOrThrow(OldGreatPathProcessorList.OLD_GREAT_FIELD_STRUCTURE_PATH)), 15)
                        ),
                        StructureTemplatePool.Projection.TERRAIN_MATCHING
                )
        );

        ModStructureTemplatePool.registerPool(context, "old_great_field/no_cross_or_t_path",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:old_great_field/straight_path", processorListHolderGetter.getOrThrow(OldGreatPathProcessorList.OLD_GREAT_FIELD_STRUCTURE_PATH)), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:old_great_field/l_left_path", processorListHolderGetter.getOrThrow(OldGreatPathProcessorList.OLD_GREAT_FIELD_STRUCTURE_PATH)), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:old_great_field/l_right_path", processorListHolderGetter.getOrThrow(OldGreatPathProcessorList.OLD_GREAT_FIELD_STRUCTURE_PATH)), 1)
                        ),
                        StructureTemplatePool.Projection.TERRAIN_MATCHING
                )
        );

        ModStructureTemplatePool.registerPool(context, "old_great_field/side_build_straight_path",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:old_great_field/ruin_bat_01", processorListHolderGetter.getOrThrow(OldGreatPathProcessorList.JELLYSHROOM_FARM)), 10),
                                Pair.of(StructurePoolElement.single("premierpainmod:old_great_field/ruin_bat_02", processorListHolderGetter.getOrThrow(OldGreatPathProcessorList.JELLYSHROOM_FARM)), 10),
                                Pair.of(StructurePoolElement.single("premierpainmod:old_great_field/ruin_bat_03", processorListHolderGetter.getOrThrow(OldGreatPathProcessorList.JELLYSHROOM_FARM)), 10),
                                Pair.of(StructurePoolElement.single("premierpainmod:old_great_field/jellyshroom_farm", processorListHolderGetter.getOrThrow(OldGreatPathProcessorList.JELLYSHROOM_FARM)), 10),
                                Pair.of(StructurePoolElement.empty(), 90)

                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
    }
}
