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
    public static final TagKey<Block> WEEPING_WILLOW_LOGS = create("weeping_willow_logs");
    public static final TagKey<Block> VILLAGER_STATUE = create("villager_statue");
    public static final TagKey<Block> VILLAGER_PEDESTAL = create("villager_pedestal");
    public static final TagKey<Block> VILLAGER_BRAZIER = create("villager_brazier");
    public static final TagKey<Block> VILLAGER_TABLE = create("villager_table");
    public static final TagKey<Block> VILLAGER_CHAIR = create("villager_chair");
    public static final TagKey<Block> VILLAGER_THRONE_CHAIR = create("villager_throne_chair");
    public static final TagKey<Block> VILLAGER_DRAWER = create("villager_drawer");
    public static final TagKey<Block> VILLAGER_SHELF = create("villager_shelf");
    public static final TagKey<Block> VILLAGER_BENCH = create("villager_bench");
    public static final TagKey<Block> VILLAGER_COUCH = create("villager_couch");
    public static final TagKey<Block> VILLAGER_BREWING_STATION = create("villager_brewing_station");
    public static final TagKey<Block> VILLAGER_MUSICAL_FRIDGE = create("villager_musical_fridge");
    public static final TagKey<Block> VILLAGER_CHISELED_HEAD = create("villager_chiseled_head");
    public static final TagKey<Block> VILLAGER_DRY_TOILET = create("villager_dry_toilet");

    private static TagKey<Block> create(String name)
    {
        return create(ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, name));
    }

    public static TagKey<Block> create(ResourceLocation name)
    {
        return TagKey.create(Registries.BLOCK, name);
    }
}
