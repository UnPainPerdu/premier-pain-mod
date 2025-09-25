package com.unpainperdu.premierpainmod.datagen.data.tag.mod_tags;

import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ModBiomeTags
{
    public static final TagKey<Biome> HAS_FOREST_PREMIER_PAIN_TEMPLE = create("has_forest_premier_pain_temple");
    public static final TagKey<Biome> HAS_SAND_DESERT_PREMIER_PAIN_TEMPLE = create("has_sand_desert_premier_pain_temple");

    public static TagKey<Biome> create(String name)
    {
        return TagKey.create(Registries.BIOME, ResourceUtil.createResourceLocation(name));
    }
}
