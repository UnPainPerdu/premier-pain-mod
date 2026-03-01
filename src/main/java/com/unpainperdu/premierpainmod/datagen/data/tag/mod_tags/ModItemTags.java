package com.unpainperdu.premierpainmod.datagen.data.tag.mod_tags;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.List;

public class ModItemTags
{
    public static final TagKey<Item> MOUNTAIN_CURRANT_LOGS = create("mountain_currant_logs");
    public static final TagKey<Item> MORICHE_PALM_LOGS = create("moriche_palm_logs");
    public static final TagKey<Item> ACHIOTE_LOGS = create("achiote_logs");
    public static final TagKey<Item> WEEPING_WILLOW_LOGS = create("weeping_willow_logs");
    public static final TagKey<Item> GYPSUM = create("gypsum");
    public static final TagKey<Item> VILLAGER_STATUE = create("villager_statue");
    public static final TagKey<Item> VILLAGER_PEDESTAL = create("villager_pedestal");
    public static final TagKey<Item> VILLAGER_BRAZIER = create("villager_brazier");
    public static final TagKey<Item> VILLAGER_TABLE = create("villager_table");
    public static final TagKey<Item> VILLAGER_CHAIR = create("villager_chair");
    public static final TagKey<Item> VILLAGER_THRONE_CHAIR = create("villager_throne_chair");
    public static final TagKey<Item> VILLAGER_DRAWER = create("villager_drawer");
    public static final TagKey<Item> VILLAGER_SHELF = create("villager_shelf");
    public static final TagKey<Item> VILLAGER_BENCH = create("villager_bench");
    public static final TagKey<Item> VILLAGER_COUCH = create("villager_couch");
    public static final TagKey<Item> VILLAGER_BREWING_STATION = create("villager_brewing_station");
    public static final TagKey<Item> VILLAGER_MUSICAL_FRIDGE = create("villager_musical_fridge");
    public static final TagKey<Item> VILLAGER_CHISELED_HEAD = create("villager_chiseled_head");
    public static final TagKey<Item> VILLAGER_DRY_TOILET = create("villager_dry_toilet");
    public static final TagKey<Item> FLOWERED_LIZARD_FOOD = create("flowered_lizard_food");

    public static final List<TagKey<Item>> ALL_MATERIALS_TAGS = List.of(
            VILLAGER_STATUE,
            VILLAGER_PEDESTAL,
            VILLAGER_BRAZIER,
            VILLAGER_TABLE,
            VILLAGER_CHAIR,
            VILLAGER_THRONE_CHAIR,
            VILLAGER_DRAWER,
            VILLAGER_SHELF,
            VILLAGER_BENCH,
            VILLAGER_COUCH,
            VILLAGER_BREWING_STATION,
            VILLAGER_MUSICAL_FRIDGE,
            VILLAGER_CHISELED_HEAD,
            VILLAGER_DRY_TOILET);

    private static TagKey<Item> create(String name)
    {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, name));
    }

    public static TagKey<Item> create(ResourceLocation name)
    {
        return TagKey.create(Registries.ITEM, name);
    }
}
