package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.item.items.VillagerShelfItem;
import com.unpainperdu.premierpainmod.level.world.item.items.VillagerSingingStone;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegister
{
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PremierPainMod.MODID);

    // Creates a new food item with the id "examplemod:example_id", nutrition 1 and saturation 2
    public static final DeferredItem<Item> VILLAGER_ICON = ITEMS.register("villager_icon", () -> new Item(new Item.Properties()));
    //Item Villager Shelf
    public static final DeferredItem<Item>  OAK_VILLAGER_SHELF = ITEMS.register("oak_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.OAK_STANDING_VILLAGER_SHELF.get(),BlockRegister.OAK_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  BIRCH_VILLAGER_SHELF = ITEMS.register("birch_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.BIRCH_STANDING_VILLAGER_SHELF.get(),BlockRegister.BIRCH_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  SPRUCE_VILLAGER_SHELF = ITEMS.register("spruce_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.SPRUCE_STANDING_VILLAGER_SHELF.get(),BlockRegister.SPRUCE_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  JUNGLE_VILLAGER_SHELF = ITEMS.register("jungle_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.JUNGLE_STANDING_VILLAGER_SHELF.get(),BlockRegister.JUNGLE_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  ACACIA_VILLAGER_SHELF = ITEMS.register("acacia_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.ACACIA_STANDING_VILLAGER_SHELF.get(),BlockRegister.ACACIA_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  DARK_OAK_VILLAGER_SHELF = ITEMS.register("dark_oak_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.DARK_OAK_STANDING_VILLAGER_SHELF.get(),BlockRegister.DARK_OAK_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  MANGROVE_VILLAGER_SHELF = ITEMS.register("mangrove_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.MANGROVE_STANDING_VILLAGER_SHELF.get(),BlockRegister.MANGROVE_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  CHERRY_VILLAGER_SHELF = ITEMS.register("cherry_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.CHERRY_STANDING_VILLAGER_SHELF.get(),BlockRegister.CHERRY_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  BAMBOO_VILLAGER_SHELF = ITEMS.register("bamboo_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.BAMBOO_STANDING_VILLAGER_SHELF.get(),BlockRegister.BAMBOO_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  CRIMSON_VILLAGER_SHELF = ITEMS.register("crimson_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.CRIMSON_STANDING_VILLAGER_SHELF.get(),BlockRegister.CRIMSON_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  WARPED_VILLAGER_SHELF = ITEMS.register("warped_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.WARPED_STANDING_VILLAGER_SHELF.get(),BlockRegister.WARPED_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  STONE_VILLAGER_SHELF = ITEMS.register("stone_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.STONE_STANDING_VILLAGER_SHELF.get(),BlockRegister.STONE_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  MOSSY_STONE_VILLAGER_SHELF = ITEMS.register("mossy_stone_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.MOSSY_STONE_STANDING_VILLAGER_SHELF.get(),BlockRegister.MOSSY_STONE_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  ANDESITE_VILLAGER_SHELF = ITEMS.register("andesite_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.ANDESITE_STANDING_VILLAGER_SHELF.get(),BlockRegister.ANDESITE_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  DIORITE_VILLAGER_SHELF = ITEMS.register("diorite_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.DIORITE_STANDING_VILLAGER_SHELF.get(),BlockRegister.DIORITE_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  GRANITE_VILLAGER_SHELF = ITEMS.register("granite_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.GRANITE_STANDING_VILLAGER_SHELF.get(),BlockRegister.GRANITE_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  PRISMARINE_VILLAGER_SHELF = ITEMS.register("prismarine_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.PRISMARINE_STANDING_VILLAGER_SHELF.get(),BlockRegister.PRISMARINE_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  BLACKSTONE_VILLAGER_SHELF = ITEMS.register("blackstone_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.BLACKSTONE_STANDING_VILLAGER_SHELF.get(),BlockRegister.BLACKSTONE_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  PURPUR_BLOCK_VILLAGER_SHELF = ITEMS.register("purpur_block_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.PURPUR_BLOCK_STANDING_VILLAGER_SHELF.get(),BlockRegister.PURPUR_BLOCK_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  DEEPSLATE_VILLAGER_SHELF = ITEMS.register("deepslate_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.DEEPSLATE_STANDING_VILLAGER_SHELF.get(),BlockRegister.DEEPSLATE_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  TUFF_VILLAGER_SHELF = ITEMS.register("tuff_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.TUFF_STANDING_VILLAGER_SHELF.get(),BlockRegister.TUFF_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  PACKED_MUD_VILLAGER_SHELF = ITEMS.register("packed_mud_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.PACKED_MUD_STANDING_VILLAGER_SHELF.get(),BlockRegister.PACKED_MUD_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  SANDSTONE_VILLAGER_SHELF = ITEMS.register("sandstone_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.SANDSTONE_STANDING_VILLAGER_SHELF.get(),BlockRegister.SANDSTONE_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  RED_SANDSTONE_VILLAGER_SHELF = ITEMS.register("red_sandstone_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.RED_SANDSTONE_STANDING_VILLAGER_SHELF.get(),BlockRegister.RED_SANDSTONE_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  QUARTZ_BLOCK_VILLAGER_SHELF = ITEMS.register("quartz_block_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.QUARTZ_BLOCK_STANDING_VILLAGER_SHELF.get(),BlockRegister.QUARTZ_BLOCK_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  NETHER_BRICKS_VILLAGER_SHELF = ITEMS.register("nether_bricks_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.NETHER_BRICKS_STANDING_VILLAGER_SHELF.get(),BlockRegister.NETHER_BRICKS_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  BASALT_VILLAGER_SHELF = ITEMS.register("basalt_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.BASALT_STANDING_VILLAGER_SHELF.get(),BlockRegister.BASALT_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  END_STONE_VILLAGER_SHELF = ITEMS.register("end_stone_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.END_STONE_STANDING_VILLAGER_SHELF.get(),BlockRegister.END_STONE_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  COAL_BLOCK_VILLAGER_SHELF = ITEMS.register("coal_block_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.COAL_BLOCK_STANDING_VILLAGER_SHELF.get(),BlockRegister.COAL_BLOCK_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  IRON_BLOCK_VILLAGER_SHELF = ITEMS.register("iron_block_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.IRON_BLOCK_STANDING_VILLAGER_SHELF.get(),BlockRegister.IRON_BLOCK_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  GOLD_BLOCK_VILLAGER_SHELF = ITEMS.register("gold_block_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.GOLD_BLOCK_STANDING_VILLAGER_SHELF.get(),BlockRegister.GOLD_BLOCK_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  REDSTONE_BLOCK_VILLAGER_SHELF = ITEMS.register("redstone_block_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.REDSTONE_BLOCK_STANDING_VILLAGER_SHELF.get(),BlockRegister.REDSTONE_BLOCK_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  EMERALD_BLOCK_VILLAGER_SHELF = ITEMS.register("emerald_block_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.EMERALD_BLOCK_STANDING_VILLAGER_SHELF.get(),BlockRegister.EMERALD_BLOCK_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  DIAMOND_BLOCK_VILLAGER_SHELF = ITEMS.register("diamond_block_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.DIAMOND_BLOCK_STANDING_VILLAGER_SHELF.get(),BlockRegister.DIAMOND_BLOCK_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  COPPER_BLOCK_VILLAGER_SHELF = ITEMS.register("copper_block_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.COPPER_BLOCK_STANDING_VILLAGER_SHELF.get(),BlockRegister.COPPER_BLOCK_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  LAPIS_BLOCK_VILLAGER_SHELF = ITEMS.register("lapis_block_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.LAPIS_BLOCK_STANDING_VILLAGER_SHELF.get(),BlockRegister.LAPIS_BLOCK_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  NETHERITE_BLOCK_VILLAGER_SHELF = ITEMS.register("netherite_block_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.NETHERITE_BLOCK_STANDING_VILLAGER_SHELF.get(),BlockRegister.NETHERITE_BLOCK_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  OBSIDIAN_VILLAGER_SHELF = ITEMS.register("obsidian_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.OBSIDIAN_STANDING_VILLAGER_SHELF.get(),BlockRegister.OBSIDIAN_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  AMETHYST_BLOCK_VILLAGER_SHELF = ITEMS.register("amethyst_block_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.AMETHYST_BLOCK_STANDING_VILLAGER_SHELF.get(),BlockRegister.AMETHYST_BLOCK_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  DRIPSTONE_BLOCK_VILLAGER_SHELF = ITEMS.register("dripstone_block_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.DRIPSTONE_BLOCK_STANDING_VILLAGER_SHELF.get(),BlockRegister.DRIPSTONE_BLOCK_WALL_VILLAGER_SHELF.get()));
    public static final DeferredItem<Item>  BEDROCK_VILLAGER_SHELF = ITEMS.register("bedrock_villager_shelf", () -> new VillagerShelfItem(new Item.Properties(),BlockRegister.BEDROCK_STANDING_VILLAGER_SHELF.get(),BlockRegister.BEDROCK_WALL_VILLAGER_SHELF.get()));
    //villager'singing stone
    //public static final DeferredItem<Item>  TEST_VILLAGER_SINGING_STONE = villagerSingingStoneRegister("test_villager_singing_stone",SoundEventRegister.TEST_SOUND.get());
    public static final DeferredItem<Item>  TEST_VILLAGER_SINGING_STONE = ITEMS.register("test_villager_singing_stone", () -> new VillagerSingingStone(new Item.Properties(), SoundEventRegister.TEST_SOUND.get(),"test_villager_singing_stone"));

    private static DeferredItem<Item> villagerSingingStoneRegister(String name, SoundEvent soundPlayed)
    {
        return ITEMS.register(name, () -> new VillagerSingingStone(new Item.Properties(), soundPlayed,name));
    }

    public static void register(IEventBus modEventBus)
{
    ITEMS.register(modEventBus);
}
}
