package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure;

import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;

public class ModStructure
{
    public static final ResourceKey<Structure> FOREST_PREMIER_PAIN_TEMPLE = damageTypesRegister("forest_premier_pain_temple");

    private static ResourceKey<Structure> damageTypesRegister(String path)
    {
        return ResourceKey.create(Registries.STRUCTURE, ResourceUtil.createResourceLocation(path));
    }

    public static void boostrap(BootstrapContext<Structure> context)
    {

    }
}
