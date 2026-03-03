package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool.temple;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.processorlist.ModStructureProcessorList;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool.ModStructureTemplatePool;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class SwampPremierPainTempleTemplatePool
{
    private SwampPremierPainTempleTemplatePool()
    {
    }

    public static final ResourceKey<StructureTemplatePool> START = ModStructureTemplatePool.register("premier_pain_temple/swamp/frist_floor");

    public static void boostrap(BootstrapContext<StructureTemplatePool> context, Holder<StructureTemplatePool> emptyFallBack)
    {
        HolderGetter<StructureProcessorList> processorListHolderGetter = context.lookup(Registries.PROCESSOR_LIST);

        context.register(
                START,
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/swamp/frist_floor", processorListHolderGetter.getOrThrow(ModStructureProcessorList.RANDOM_BLOCK_REMOVER)), 1)),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "premier_pain_temple/swamp/connector_0-1",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/swamp/connector_0-1"), 1)),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "premier_pain_temple/swamp/connector_1-2",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/swamp/connector_1-2"), 1)),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "premier_pain_temple/swamp/connector_2-3",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/swamp/connector_2-3"), 1)),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "premier_pain_temple/swamp/second_floor",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/swamp/second_floor", processorListHolderGetter.getOrThrow(ModStructureProcessorList.RANDOM_BLOCK_REMOVER)), 1)),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "premier_pain_temple/swamp/third_floor",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/swamp/third_floor", processorListHolderGetter.getOrThrow(ModStructureProcessorList.RANDOM_BLOCK_REMOVER)), 1)

                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "premier_pain_temple/swamp/fourth_floor",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/swamp/fourth_floor", processorListHolderGetter.getOrThrow(ModStructureProcessorList.RANDOM_BLOCK_REMOVER)), 1)

                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "premier_pain_temple/swamp/first_floor_interior",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/swamp/first_floor_interior_0"), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/swamp/first_floor_interior_1"), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/swamp/first_floor_interior_2"), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "premier_pain_temple/swamp/second_floor_interior",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/swamp/second_floor_interior_0"), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/swamp/second_floor_interior_1"), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "premier_pain_temple/swamp/third_floor_interior",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/swamp/third_floor_interior_0"), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/swamp/third_floor_interior_1"), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "premier_pain_temple/swamp/fourth_floor_interior",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/swamp/fourth_floor_interior_0", processorListHolderGetter.getOrThrow(ModStructureProcessorList.BEDROCK_TO_AIR)), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/swamp/fourth_floor_interior_1", processorListHolderGetter.getOrThrow(ModStructureProcessorList.BEDROCK_TO_AIR)), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
    }
}
