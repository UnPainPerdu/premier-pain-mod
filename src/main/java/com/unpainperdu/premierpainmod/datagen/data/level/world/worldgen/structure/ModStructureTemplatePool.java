package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure;

import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class ModStructureTemplatePool
{
    public static final ResourceKey<StructureTemplatePool> FOREST_PREMIER_PAIN_TEMPLE_POOL = damageTypesRegister("forest_premier_pain_temple_pool");

    private static ResourceKey<StructureTemplatePool> damageTypesRegister(String path)
    {
        return ResourceKey.create(Registries.TEMPLATE_POOL, ResourceUtil.createResourceLocation(path));
    }

    public static void boostrap(BootstrapContext<StructureTemplatePool> context)
    {

    }
}
