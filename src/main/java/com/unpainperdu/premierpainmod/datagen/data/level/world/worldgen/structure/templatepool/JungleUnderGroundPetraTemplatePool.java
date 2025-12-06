package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.ModStructureProcessorList;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class JungleUnderGroundPetraTemplatePool
{
    private JungleUnderGroundPetraTemplatePool()
    {
    }

    public static final ResourceKey<StructureTemplatePool> START = ModStructureTemplatePool.register("jungle_underground_petra/vertical_tunnel");
    public static final ResourceKey<StructureTemplatePool> ROOM_FALLBACK = ModStructureTemplatePool.register("jungle_underground_petra/room_wall");
    public static final ResourceKey<StructureTemplatePool> WALL_L_FALLBACK = ModStructureTemplatePool.register("jungle_underground_petra/wall_l_fallback");

    public static void boostrap(BootstrapContext<StructureTemplatePool> context, Holder<StructureTemplatePool> emptyFallBack)
    {
        HolderGetter<StructureProcessorList> processorListHolderGetter = context.lookup(Registries.PROCESSOR_LIST);
        HolderGetter<StructureTemplatePool> structureTemplatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);

        context.register(
                START,
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/vertical_tunnel", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        context.register(
                WALL_L_FALLBACK,
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/wall_l_0", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/wall_l_1", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/wall_l_2", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        context.register(
                ROOM_FALLBACK,
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/room_wall_0", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/room_wall_1", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "jungle_underground_petra/corridor",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/corridor_0", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/corridor_1", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/corridor_2", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "jungle_underground_petra/gate",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/gate", processorListHolderGetter.getOrThrow(ModStructureProcessorList.BEDROCK_TO_AIR)), 100)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "jungle_underground_petra/main",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/main", processorListHolderGetter.getOrThrow(ModStructureProcessorList.BEDROCK_TO_AIR)), 100)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "jungle_underground_petra/room",
                new StructureTemplatePool(
                        structureTemplatePoolHolderGetter.getOrThrow(ROOM_FALLBACK),
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/house_s_0", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 130),
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/house_s_1", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 130),
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/house_l_0", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 100),
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/house_l_1", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 100),
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/field_0", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 110),
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/field_1", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 110),
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/smithy", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 90),
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/church", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 90),
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/mason", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 90),
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/house_xs_0", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/house_xs_1", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/house_xs_2", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/house_xs_3", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "jungle_underground_petra/wall_l",
                new StructureTemplatePool(
                        structureTemplatePoolHolderGetter.getOrThrow(WALL_L_FALLBACK),
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/corridor_entrance", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "jungle_underground_petra/wall_s",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/wall_s_0", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/wall_s_1", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:jungle_underground_petra/wall_s_2", processorListHolderGetter.getOrThrow(ModStructureProcessorList.JUNGLE_UNDERGROUND_PETRA)), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
    }
}
