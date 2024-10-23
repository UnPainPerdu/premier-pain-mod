package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.event.itemEvent.VillagerSingingStoneEvent.*;
import com.unpainperdu.premierpainmod.level.world.item.items.allMaterialsBlock.VillagerShelfItem;
import com.unpainperdu.premierpainmod.level.world.item.items.VillagerSingingStone;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ItemRegister
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PremierPainMod.MOD_ID);

    public static final DeferredItem<Item> VILLAGER_ICON = ITEMS.register("villager_icon", () -> new Item(new Item.Properties()));
    //Item Villager Shelf
    public static final DeferredItem<Item> OAK_VILLAGER_SHELF = villagerShelfRegister("oak_villager_shelf", () -> BlockRegister.OAK_STANDING_VILLAGER_SHELF,() -> BlockRegister.OAK_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  BIRCH_VILLAGER_SHELF = villagerShelfRegister("birch_villager_shelf", () ->BlockRegister.BIRCH_STANDING_VILLAGER_SHELF,() -> BlockRegister.BIRCH_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  SPRUCE_VILLAGER_SHELF = villagerShelfRegister("spruce_villager_shelf", () ->BlockRegister.SPRUCE_STANDING_VILLAGER_SHELF,() -> BlockRegister.SPRUCE_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  JUNGLE_VILLAGER_SHELF = villagerShelfRegister("jungle_villager_shelf", () ->BlockRegister.JUNGLE_STANDING_VILLAGER_SHELF,() -> BlockRegister.JUNGLE_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  ACACIA_VILLAGER_SHELF = villagerShelfRegister("acacia_villager_shelf", () ->BlockRegister.ACACIA_STANDING_VILLAGER_SHELF,() -> BlockRegister.ACACIA_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  DARK_OAK_VILLAGER_SHELF = villagerShelfRegister("dark_oak_villager_shelf", () ->BlockRegister.DARK_OAK_STANDING_VILLAGER_SHELF,() -> BlockRegister.DARK_OAK_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  MANGROVE_VILLAGER_SHELF = villagerShelfRegister("mangrove_villager_shelf", () ->BlockRegister.MANGROVE_STANDING_VILLAGER_SHELF,() -> BlockRegister.MANGROVE_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  CHERRY_VILLAGER_SHELF = villagerShelfRegister("cherry_villager_shelf", () ->BlockRegister.CHERRY_STANDING_VILLAGER_SHELF,() -> BlockRegister.CHERRY_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  BAMBOO_VILLAGER_SHELF = villagerShelfRegister("bamboo_villager_shelf", () ->BlockRegister.BAMBOO_STANDING_VILLAGER_SHELF,() -> BlockRegister.BAMBOO_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  CRIMSON_VILLAGER_SHELF = villagerShelfRegister("crimson_villager_shelf", () ->BlockRegister.CRIMSON_STANDING_VILLAGER_SHELF,() -> BlockRegister.CRIMSON_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  WARPED_VILLAGER_SHELF = villagerShelfRegister("warped_villager_shelf", () ->BlockRegister.WARPED_STANDING_VILLAGER_SHELF,() -> BlockRegister.WARPED_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  PALE_OAK_VILLAGER_SHELF = villagerShelfRegister("pale_oak_villager_shelf", () ->BlockRegister.PALE_OAK_STANDING_VILLAGER_SHELF,() -> BlockRegister.PALE_OAK_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  STONE_VILLAGER_SHELF = villagerShelfRegister("stone_villager_shelf", () ->BlockRegister.STONE_STANDING_VILLAGER_SHELF,() -> BlockRegister.STONE_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  MOSSY_STONE_VILLAGER_SHELF = villagerShelfRegister("mossy_stone_villager_shelf", () ->BlockRegister.MOSSY_STONE_STANDING_VILLAGER_SHELF,() -> BlockRegister.MOSSY_STONE_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  ANDESITE_VILLAGER_SHELF = villagerShelfRegister("andesite_villager_shelf", () ->BlockRegister.ANDESITE_STANDING_VILLAGER_SHELF,() -> BlockRegister.ANDESITE_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  DIORITE_VILLAGER_SHELF = villagerShelfRegister("diorite_villager_shelf", () ->BlockRegister.DIORITE_STANDING_VILLAGER_SHELF,() -> BlockRegister.DIORITE_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  GRANITE_VILLAGER_SHELF = villagerShelfRegister("granite_villager_shelf", () ->BlockRegister.GRANITE_STANDING_VILLAGER_SHELF,() -> BlockRegister.GRANITE_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  PRISMARINE_VILLAGER_SHELF = villagerShelfRegister("prismarine_villager_shelf", () ->BlockRegister.PRISMARINE_STANDING_VILLAGER_SHELF,() -> BlockRegister.PRISMARINE_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  BLACKSTONE_VILLAGER_SHELF = villagerShelfRegister("blackstone_villager_shelf", () ->BlockRegister.BLACKSTONE_STANDING_VILLAGER_SHELF,() -> BlockRegister.BLACKSTONE_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  PURPUR_BLOCK_VILLAGER_SHELF = villagerShelfRegister("purpur_block_villager_shelf", () ->BlockRegister.PURPUR_BLOCK_STANDING_VILLAGER_SHELF,() -> BlockRegister.PURPUR_BLOCK_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  DEEPSLATE_VILLAGER_SHELF = villagerShelfRegister("deepslate_villager_shelf", () ->BlockRegister.DEEPSLATE_STANDING_VILLAGER_SHELF,() -> BlockRegister.DEEPSLATE_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  TUFF_VILLAGER_SHELF = villagerShelfRegister("tuff_villager_shelf", () ->BlockRegister.TUFF_STANDING_VILLAGER_SHELF,() -> BlockRegister.TUFF_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  PACKED_MUD_VILLAGER_SHELF = villagerShelfRegister("packed_mud_villager_shelf", () ->BlockRegister.PACKED_MUD_STANDING_VILLAGER_SHELF,() -> BlockRegister.PACKED_MUD_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  SANDSTONE_VILLAGER_SHELF = villagerShelfRegister("sandstone_villager_shelf", () ->BlockRegister.SANDSTONE_STANDING_VILLAGER_SHELF,() -> BlockRegister.SANDSTONE_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  RED_SANDSTONE_VILLAGER_SHELF = villagerShelfRegister("red_sandstone_villager_shelf", () ->BlockRegister.RED_SANDSTONE_STANDING_VILLAGER_SHELF,() -> BlockRegister.RED_SANDSTONE_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  QUARTZ_BLOCK_VILLAGER_SHELF = villagerShelfRegister("quartz_block_villager_shelf", () ->BlockRegister.QUARTZ_BLOCK_STANDING_VILLAGER_SHELF,() -> BlockRegister.QUARTZ_BLOCK_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  NETHER_BRICKS_VILLAGER_SHELF = villagerShelfRegister("nether_bricks_villager_shelf", () ->BlockRegister.NETHER_BRICKS_STANDING_VILLAGER_SHELF,() -> BlockRegister.NETHER_BRICKS_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  BASALT_VILLAGER_SHELF = villagerShelfRegister("basalt_villager_shelf", () ->BlockRegister.BASALT_STANDING_VILLAGER_SHELF,() -> BlockRegister.BASALT_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  END_STONE_VILLAGER_SHELF = villagerShelfRegister("end_stone_villager_shelf", () ->BlockRegister.END_STONE_STANDING_VILLAGER_SHELF,() -> BlockRegister.END_STONE_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  COAL_BLOCK_VILLAGER_SHELF = villagerShelfRegister("coal_block_villager_shelf", () ->BlockRegister.COAL_BLOCK_STANDING_VILLAGER_SHELF,() -> BlockRegister.COAL_BLOCK_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  IRON_BLOCK_VILLAGER_SHELF = villagerShelfRegister("iron_block_villager_shelf", () ->BlockRegister.IRON_BLOCK_STANDING_VILLAGER_SHELF,() -> BlockRegister.IRON_BLOCK_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  GOLD_BLOCK_VILLAGER_SHELF = villagerShelfRegister("gold_block_villager_shelf", () ->BlockRegister.GOLD_BLOCK_STANDING_VILLAGER_SHELF,() -> BlockRegister.GOLD_BLOCK_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  REDSTONE_BLOCK_VILLAGER_SHELF = villagerShelfRegister("redstone_block_villager_shelf", () ->BlockRegister.REDSTONE_BLOCK_STANDING_VILLAGER_SHELF,() -> BlockRegister.REDSTONE_BLOCK_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  EMERALD_BLOCK_VILLAGER_SHELF = villagerShelfRegister("emerald_block_villager_shelf", () ->BlockRegister.EMERALD_BLOCK_STANDING_VILLAGER_SHELF,() -> BlockRegister.EMERALD_BLOCK_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  DIAMOND_BLOCK_VILLAGER_SHELF = villagerShelfRegister("diamond_block_villager_shelf", () ->BlockRegister.DIAMOND_BLOCK_STANDING_VILLAGER_SHELF,() -> BlockRegister.DIAMOND_BLOCK_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  COPPER_BLOCK_VILLAGER_SHELF = villagerShelfRegister("copper_block_villager_shelf", () ->BlockRegister.COPPER_BLOCK_STANDING_VILLAGER_SHELF,() -> BlockRegister.COPPER_BLOCK_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  LAPIS_BLOCK_VILLAGER_SHELF = villagerShelfRegister("lapis_block_villager_shelf", () ->BlockRegister.LAPIS_BLOCK_STANDING_VILLAGER_SHELF,() -> BlockRegister.LAPIS_BLOCK_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  NETHERITE_BLOCK_VILLAGER_SHELF = villagerShelfRegister("netherite_block_villager_shelf", () ->BlockRegister.NETHERITE_BLOCK_STANDING_VILLAGER_SHELF,() -> BlockRegister.NETHERITE_BLOCK_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  OBSIDIAN_VILLAGER_SHELF = villagerShelfRegister("obsidian_villager_shelf", () ->BlockRegister.OBSIDIAN_STANDING_VILLAGER_SHELF,() -> BlockRegister.OBSIDIAN_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  AMETHYST_BLOCK_VILLAGER_SHELF = villagerShelfRegister("amethyst_block_villager_shelf", () ->BlockRegister.AMETHYST_BLOCK_STANDING_VILLAGER_SHELF,() -> BlockRegister.AMETHYST_BLOCK_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  DRIPSTONE_BLOCK_VILLAGER_SHELF = villagerShelfRegister("dripstone_block_villager_shelf", () ->BlockRegister.DRIPSTONE_BLOCK_STANDING_VILLAGER_SHELF,() -> BlockRegister.DRIPSTONE_BLOCK_WALL_VILLAGER_SHELF);
    public static final DeferredItem<Item>  BEDROCK_VILLAGER_SHELF = villagerShelfRegister("bedrock_villager_shelf",() -> BlockRegister.BEDROCK_STANDING_VILLAGER_SHELF,() ->BlockRegister.BEDROCK_WALL_VILLAGER_SHELF);
    //villager's singing stone
    public static final DeferredItem<Item>  LIBERTY_VILLAGER_SINGING_STONE = villagerSingingStoneRegister("liberty_villager_singing_stone", 10, () -> SoundEventRegister.LIBERTY_SOUND,new LibertyEvent());
    public static final DeferredItem<Item>  DIGGY_VILLAGER_SINGING_STONE =villagerSingingStoneRegister("diggy_villager_singing_stone", 10, () -> SoundEventRegister.DIGGY_SOUND,new DiggyEvent());
    public static final DeferredItem<Item>  MADNESS_VILLAGER_SINGING_STONE = villagerSingingStoneRegister("madness_villager_singing_stone", 20, () -> SoundEventRegister.MADNESS_SOUND,new MadnessEvent());
    public static final DeferredItem<Item>  PREMIER_PAIN_VILLAGER_SINGING_STONE = villagerSingingStoneRegister("premier_pain_villager_singing_stone", 10, () -> SoundEventRegister.PREMIER_PAIN_SOUND,new PremierPainEvent());
    //food
        //vegetation
    public static final DeferredItem<Item> CACTUS_FLOWER_FRUIT = basicFoodItemRegister("cactus_flower_fruit",64,4,0.3f);
    public static final DeferredItem<Item> SKY_SPEARS_FRUIT = basicFoodItemRegister("sky_spears_fruit",64,4,0.3f);


    private static DeferredItem<Item> villagerShelfRegister(String name, Supplier<DeferredBlock<Block>> standingBlock, Supplier<DeferredBlock<Block>> wallBlock)
    {
        return ITEMS.register(name,() -> new VillagerShelfItem(new Item.Properties(),standingBlock.get().get(),wallBlock.get().get()));
    }

    private static DeferredItem<Item> villagerSingingStoneRegister(String name, int delayInSecond, Supplier<DeferredHolder<SoundEvent, SoundEvent>> soundEvent, AbstractVillagerSingingStoneEvent event)
    {
        return ITEMS.register(name, () -> new VillagerSingingStone(new Item.Properties().stacksTo(1), soundEvent.get().get(), name, event, delayInSecond));
    }
    private static DeferredItem<Item> basicItemRegister(String name, int maxStackSize)
    {
        return ITEMS.register(name, () -> new Item(new Item.Properties().stacksTo(maxStackSize)));
    }
    /*
    nutrition --> 1 = 1/2 jigot
    saturation -->
    */
    private static DeferredItem<Item> basicFoodItemRegister(String name, int maxStackSize, int nutrition, float saturation)
    {
        return ITEMS.register(name, () -> new Item(new Item.Properties()
                        .food(new FoodProperties.Builder()
                            .nutrition(nutrition)
                            .saturationModifier(saturation)
                            .build()
                            )
                        .stacksTo(maxStackSize)
                        ));
    }
    public static void register(IEventBus modEventBus)
    {
        ITEMS.register(modEventBus);
    }
}
