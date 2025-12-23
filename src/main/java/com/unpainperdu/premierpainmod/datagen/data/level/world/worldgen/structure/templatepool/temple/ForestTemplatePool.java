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

import static com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool.ModStructureTemplatePool.register;

public class ForestTemplatePool
{
    private ForestTemplatePool()
    {
    }

    public static final ResourceKey<StructureTemplatePool> START = register("premier_pain_temple/forest/main");

    public static void boostrap(BootstrapContext<StructureTemplatePool> context, Holder<StructureTemplatePool> emptyFallBack)
    {
        HolderGetter<StructureProcessorList> processorListHolderGetter = context.lookup(Registries.PROCESSOR_LIST);

        context.register(
                ForestTemplatePool.START,
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/forest/main", processorListHolderGetter.getOrThrow(ModStructureProcessorList.FOREST_TEMPLE_PROCESSOR)), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "premier_pain_temple/forest/exterior",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/forest/exterior_0", processorListHolderGetter.getOrThrow(ModStructureProcessorList.AGE_STONE)), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/forest/exterior_1", processorListHolderGetter.getOrThrow(ModStructureProcessorList.AGE_STONE)), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/forest/exterior_2", processorListHolderGetter.getOrThrow(ModStructureProcessorList.AGE_STONE)), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "premier_pain_temple/forest/interior",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/forest/interior_0", processorListHolderGetter.getOrThrow(ModStructureProcessorList.AGE_STONE)), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/forest/interior_1", processorListHolderGetter.getOrThrow(ModStructureProcessorList.AGE_STONE)), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/forest/interior_2", processorListHolderGetter.getOrThrow(ModStructureProcessorList.AGE_STONE)), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "premier_pain_temple/forest/pool",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/forest/pool_0", processorListHolderGetter.getOrThrow(ModStructureProcessorList.AGE_STONE_BEDROCK_REMOVER)), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/forest/pool_1", processorListHolderGetter.getOrThrow(ModStructureProcessorList.AGE_STONE)), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/forest/pool_2", processorListHolderGetter.getOrThrow(ModStructureProcessorList.AGE_STONE)), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
    }
}
