package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool.temple;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool.ModStructureTemplatePool;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import static com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool.ModStructureTemplatePool.register;

public class SandDesertTemplatePool
{
    private SandDesertTemplatePool()
    {
    }

    public static final ResourceKey<StructureTemplatePool> START = register("premier_pain_temple/sand_desert/main");

    public static void boostrap(BootstrapContext<StructureTemplatePool> context, Holder<StructureTemplatePool> emptyFallBack)
    {
        context.register(
                SandDesertTemplatePool.START,
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/sand_desert/main"), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "premier_pain_temple/sand_desert/corridor",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/sand_desert/corridor_0"), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/sand_desert/corridor_1"), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/sand_desert/corridor_2"), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "premier_pain_temple/sand_desert/micro_room",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/sand_desert/micro_room_0"), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/sand_desert/micro_room_1"), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/sand_desert/micro_room_2"), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/sand_desert/micro_room_3"), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "premier_pain_temple/sand_desert/small_room",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/sand_desert/small_room_0"), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/sand_desert/small_room_1"), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/sand_desert/small_room_2"), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/sand_desert/small_room_3"), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "premier_pain_temple/sand_desert/medium_room",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/sand_desert/medium_room_0"), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/sand_desert/medium_room_1"), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/sand_desert/medium_room_2"), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "premier_pain_temple/sand_desert/big_room",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/sand_desert/big_room_0"), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/sand_desert/big_room_1"), 1),
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/sand_desert/big_room_2"), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
    }
}
