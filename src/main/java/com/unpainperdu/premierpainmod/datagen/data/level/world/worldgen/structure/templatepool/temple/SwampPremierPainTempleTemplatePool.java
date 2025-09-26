package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool.temple;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool.ModStructureTemplatePool;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class SwampPremierPainTempleTemplatePool
{
    private SwampPremierPainTempleTemplatePool()
    {
    }

    public static final ResourceKey<StructureTemplatePool> START = ModStructureTemplatePool.register("premier_pain_temple/swamp_premier_pain_temple_structure/bottom_swamp_premier_pain_temple");

    public static void boostrap(BootstrapContext<StructureTemplatePool> context, Holder<StructureTemplatePool> emptyFallBack)
    {
        context.register(
                START,
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/swamp_premier_pain_temple_structure/bottom_swamp_premier_pain_temple_structure"), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );

        ModStructureTemplatePool.registerPool(context, "premier_pain_temple/swamp_premier_pain_temple_structure/top_swamp_premier_pain_temple",
                new StructureTemplatePool(
                        emptyFallBack,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/swamp_premier_pain_temple_structure/top_swamp_premier_pain_temple_structure"), 1)

                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
    }
}
