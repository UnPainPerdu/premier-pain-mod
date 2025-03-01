package com.unpainperdu.premierpainmod.datagen.data.tag.mod_tags;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags
{
    public static final TagKey<Item> MOUNTAIN_CURRANT_LOGS = create("mountain_currant_logs");
    public static final TagKey<Item> MORICHE_PALM_LOGS = create("moriche_palm_logs");

    private static TagKey<Item> create(String name)
    {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID,name));
    }

    public static TagKey<Item> create(ResourceLocation name)
    {
        return TagKey.create(Registries.ITEM, name);
    }
}
