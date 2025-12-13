package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool;

import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool.temple.ForestTemplatePool;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool.temple.SandDesertTemplatePool;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool.temple.SwampPremierPainTempleTemplatePool;
import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class ModStructureTemplatePool
{
    private ModStructureTemplatePool()
    {
    }

    /*
     *   If pool = 1 element, in this class.
     *   Check PlainVillagePools.java for example.
     **/
    public static ResourceKey<StructureTemplatePool> register(String path)
    {
        return ResourceKey.create(Registries.TEMPLATE_POOL, ResourceUtil.createResourceLocation(path));
    }

    public static void registerPool(BootstrapContext<StructureTemplatePool> context, String path, StructureTemplatePool pool)
    {
        context.register(register(path), pool);
    }

    public static void boostrap(BootstrapContext<StructureTemplatePool> context)
    {
        Holder<StructureTemplatePool> EmptyStructureTemplatePool = context.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY);

        ForestTemplatePool.boostrap(context, EmptyStructureTemplatePool);
        SandDesertTemplatePool.boostrap(context, EmptyStructureTemplatePool);
        SwampPremierPainTempleTemplatePool.boostrap(context, EmptyStructureTemplatePool);
        OldGreatPahtTemplatePool.boostrap(context, EmptyStructureTemplatePool);
        JungleUnderGroundPetraTemplatePool.boostrap(context, EmptyStructureTemplatePool);
    }
}
