package com.unpainperdu.premierpainmod.datagen.data.tag.mod_tags;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags
{
    public static final TagKey<Block> MOUNTAIN_CURRANT_LOGS = create("mountain_currant_logs");
    public static final TagKey<Block> MORICHE_PALM_LOGS = create("moriche_palm_logs");
    public static final TagKey<Block> ACHIOTE_LOGS = create("achiote_logs");

    private static TagKey<Block> create(String name)
    {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID,name));
    }

    public static TagKey<Block> create(ResourceLocation name)
    {
        return TagKey.create(Registries.BLOCK, name);
    }
}
