package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class ModStructureTemplatePool
{
    /*
     *   If pool = 1 element, in this class.
     *   Check PlainVillagePools.java for example.
     **/
    public static final ResourceKey<StructureTemplatePool> FOREST_PREMIER_PAIN_TEMPLE_POOL = register("forest_premier_pain_temple_pool");

    private static ResourceKey<StructureTemplatePool> register(String path)
    {
        return ResourceKey.create(Registries.TEMPLATE_POOL, ResourceUtil.createResourceLocation(path));
    }

    public static void boostrap(BootstrapContext<StructureTemplatePool> context)
    {
        HolderGetter<StructureTemplatePool> vanillaTemplatePoolHolderGetter = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> EmptyStructureTemplatePool = vanillaTemplatePoolHolderGetter.getOrThrow(Pools.EMPTY);

        context.register(
                FOREST_PREMIER_PAIN_TEMPLE_POOL,
                new StructureTemplatePool(
                        EmptyStructureTemplatePool,
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.single("premierpainmod:premier_pain_temple/forest_premier_pain_temple_structure"), 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
    }
}
