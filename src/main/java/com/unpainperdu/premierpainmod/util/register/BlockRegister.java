package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.*;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight.VillagerBrazier;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight.VillagerStatue;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight.VillagerThroneChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidth.VillagerDrawer;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidth.VillagerShelf;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidth.VillagerWorkshop;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class BlockRegister
{

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PremierPainMod.MODID);

    //test zone
    public static final DeferredBlock<Block> TEST_BLOCK = registerBlock("test_villager_drawer", () -> new VillagerDrawer(BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK).noOcclusion()));
    public static final DeferredBlock<Block> TEST_BLOCK2 = registerBlock("test_villager_shelf", () -> new VillagerShelf(BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK).noOcclusion()));
    //WorkShopZone
    public static final DeferredBlock<Block> VILLAGER_WORKSHOP = registerBlock("villager_workshop", () -> new VillagerWorkshop(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    /*materials :
    oak
    birch
    spruce
    jungle
    acacia
    dark_oak
    mangrove
    cherry
    bamboo
    crimson
    warped
    stone
    end_stone
    mossy_stone
    andesite
    diorite
    granite
    prismarine
    blackstone
    deepslate
    tuff
    sandstone
    red_sandstone
    basalt (polished as "planks")
    obsidian (obsidian as "planks")
    bedrock
    packed_mud
    nether_bricks
    quartz_block (chiseled as "planks")
    iron_block
    gold_block
    copper_block
    amethyst_block
    dripstone_block
    purpur_block
    coal_block
    redstone_block
    diamond_block
    emerald_block
    lapis_block
    netherite_block
     */
        //statue
    public static final DeferredBlock<Block> OAK_VILLAGER_STATUE = statueRegister("oak_villager_statue","wood");
    public static final DeferredBlock<Block> BIRCH_VILLAGER_STATUE = statueRegister("birch_villager_statue","wood");
    public static final DeferredBlock<Block> SPRUCE_VILLAGER_STATUE = statueRegister("spruce_villager_statue","wood");
    public static final DeferredBlock<Block> JUNGLE_VILLAGER_STATUE = statueRegister("jungle_villager_statue","wood");
    public static final DeferredBlock<Block> ACACIA_VILLAGER_STATUE = statueRegister("acacia_villager_statue","wood");
    public static final DeferredBlock<Block> DARK_OAK_VILLAGER_STATUE = statueRegister("dark_oak_villager_statue","wood");
    public static final DeferredBlock<Block> MANGROVE_VILLAGER_STATUE = statueRegister("mangrove_villager_statue","wood");
    public static final DeferredBlock<Block> CHERRY_VILLAGER_STATUE = statueRegister("cherry_villager_statue","wood","cherry");
    public static final DeferredBlock<Block> BAMBOO_VILLAGER_STATUE = statueRegister("bamboo_villager_statue","wood","bamboo");
    public static final DeferredBlock<Block> CRIMSON_VILLAGER_STATUE = statueRegister("crimson_villager_statue","wood","netherwood");
    public static final DeferredBlock<Block> WARPED_VILLAGER_STATUE = statueRegister("warped_villager_statue","wood","netherwood");
    public static final DeferredBlock<Block> STONE_VILLAGER_STATUE =  statueRegister("stone_villager_statue","stone");
    public static final DeferredBlock<Block> MOSSY_STONE_VILLAGER_STATUE =  statueRegister("mossy_stone_villager_statue","stone");
    public static final DeferredBlock<Block> ANDESITE_VILLAGER_STATUE =  statueRegister("andesite_villager_statue","stone");
    public static final DeferredBlock<Block> DIORITE_VILLAGER_STATUE =  statueRegister("diorite_villager_statue","stone");
    public static final DeferredBlock<Block> GRANITE_VILLAGER_STATUE =  statueRegister("granite_villager_statue","stone");
    public static final DeferredBlock<Block> PRISMARINE_VILLAGER_STATUE =  statueRegister("prismarine_villager_statue","stone");
    public static final DeferredBlock<Block> BLACKSTONE_VILLAGER_STATUE =  statueRegister("blackstone_villager_statue","stone");
    public static final DeferredBlock<Block> PURPUR_BLOCK_VILLAGER_STATUE =  statueRegister("purpur_block_villager_statue","stone");
    public static final DeferredBlock<Block> DEEPSLATE_VILLAGER_STATUE =  statueRegister("deepslate_villager_statue","deepslate");
    public static final DeferredBlock<Block> TUFF_VILLAGER_STATUE =  statueRegister("tuff_villager_statue","tuff");
    public static final DeferredBlock<Block> PACKED_MUD_VILLAGER_STATUE =  statueRegister("packed_mud_villager_statue","mud");
    public static final DeferredBlock<Block> SANDSTONE_VILLAGER_STATUE =  statueRegister("sandstone_villager_statue","sandstone");
    public static final DeferredBlock<Block> RED_SANDSTONE_VILLAGER_STATUE =  statueRegister("red_sandstone_villager_statue","sandstone");
    public static final DeferredBlock<Block> QUARTZ_BLOCK_VILLAGER_STATUE =  statueRegister("quartz_block_villager_statue","sandstone");
    public static final DeferredBlock<Block> NETHER_BRICKS_VILLAGER_STATUE =  statueRegister("nether_bricks_villager_statue","netherbrick");
    public static final DeferredBlock<Block> BASALT_VILLAGER_STATUE =  statueRegister("basalt_villager_statue","basalt");
    public static final DeferredBlock<Block> END_STONE_VILLAGER_STATUE =  statueRegister("end_stone_villager_statue","endstone");
    public static final DeferredBlock<Block> COAL_BLOCK_VILLAGER_STATUE =  statueRegister("coal_block_villager_statue","mineral_strong");
    public static final DeferredBlock<Block> IRON_BLOCK_VILLAGER_STATUE =  statueRegister("iron_block_villager_statue","metal");
    public static final DeferredBlock<Block> GOLD_BLOCK_VILLAGER_STATUE =  statueRegister("gold_block_villager_statue","metal");
    public static final DeferredBlock<Block> REDSTONE_BLOCK_VILLAGER_STATUE =  statueRegister("redstone_block_villager_statue","metal");
    public static final DeferredBlock<Block> EMERALD_BLOCK_VILLAGER_STATUE =  statueRegister("emerald_block_villager_statue","metal");
    public static final DeferredBlock<Block> DIAMOND_BLOCK_VILLAGER_STATUE =  statueRegister("diamond_block_villager_statue","metal");
    public static final DeferredBlock<Block> COPPER_BLOCK_VILLAGER_STATUE =  statueRegister("copper_block_villager_statue","copper");
    public static final DeferredBlock<Block> LAPIS_BLOCK_VILLAGER_STATUE =  statueRegister("lapis_block_villager_statue","mineral_weak");
    public static final DeferredBlock<Block> NETHERITE_BLOCK_VILLAGER_STATUE =  statueRegister("netherite_block_villager_statue","netherite");
    public static final DeferredBlock<Block> OBSIDIAN_VILLAGER_STATUE =  statueRegister("obsidian_villager_statue","obsidan");
    public static final DeferredBlock<Block> AMETHYST_BLOCK_VILLAGER_STATUE =  statueRegister("amethyst_block_villager_statue","amethyst");
    public static final DeferredBlock<Block> DRIPSTONE_BLOCK_VILLAGER_STATUE =  statueRegister("dripstone_block_villager_statue","dripstone");
    public static final DeferredBlock<Block> BEDROCK_VILLAGER_STATUE =  statueRegister("bedrock_villager_statue","bedrock");
        //pedestal
    public static final DeferredBlock<Block> OAK_PEDESTAL = pedestalRegister("oak_villager_pedestal","wood");
    public static final DeferredBlock<Block> BIRCH_PEDESTAL = pedestalRegister("birch_villager_pedestal","wood");
    public static final DeferredBlock<Block> SPRUCE_PEDESTAL = pedestalRegister("spruce_villager_pedestal","wood");
    public static final DeferredBlock<Block> JUNGLE_PEDESTAL = pedestalRegister("jungle_villager_pedestal","wood");
    public static final DeferredBlock<Block> ACACIA_PEDESTAL = pedestalRegister("acacia_villager_pedestal","wood");
    public static final DeferredBlock<Block> DARK_OAK_PEDESTAL = pedestalRegister("dark_oak_villager_pedestal","wood");
    public static final DeferredBlock<Block> MANGROVE_PEDESTAL = pedestalRegister("mangrove_villager_pedestal","wood");
    public static final DeferredBlock<Block> CHERRY_PEDESTAL = pedestalRegister("cherry_villager_pedestal","wood","cherry");
    public static final DeferredBlock<Block> BAMBOO_PEDESTAL = pedestalRegister("bamboo_villager_pedestal","wood","bamboo");
    public static final DeferredBlock<Block> CRIMSON_PEDESTAL = pedestalRegister("crimson_villager_pedestal","wood","netherwood");
    public static final DeferredBlock<Block> WARPED_PEDESTAL = pedestalRegister("warped_villager_pedestal","wood","netherwood");
    public static final DeferredBlock<Block> STONE_PEDESTAL =  pedestalRegister("stone_villager_pedestal","stone");
    public static final DeferredBlock<Block> MOSSY_STONE_PEDESTAL =  pedestalRegister("mossy_stone_villager_pedestal","stone");
    public static final DeferredBlock<Block> ANDESITE_PEDESTAL =  pedestalRegister("andesite_villager_pedestal","stone");
    public static final DeferredBlock<Block> DIORITE_PEDESTAL =  pedestalRegister("diorite_villager_pedestal","stone");
    public static final DeferredBlock<Block> GRANITE_PEDESTAL =  pedestalRegister("granite_villager_pedestal","stone");
    public static final DeferredBlock<Block> PRISMARINE_PEDESTAL =  pedestalRegister("prismarine_villager_pedestal","stone");
    public static final DeferredBlock<Block> BLACKSTONE_PEDESTAL =  pedestalRegister("blackstone_villager_pedestal","stone");
    public static final DeferredBlock<Block> PURPUR_BLOCK_PEDESTAL =  pedestalRegister("purpur_block_villager_pedestal","stone");
    public static final DeferredBlock<Block> DEEPSLATE_PEDESTAL =  pedestalRegister("deepslate_villager_pedestal","deepslate");
    public static final DeferredBlock<Block> TUFF_PEDESTAL =  pedestalRegister("tuff_villager_pedestal","tuff");
    public static final DeferredBlock<Block> PACKED_MUD_PEDESTAL =  pedestalRegister("packed_mud_villager_pedestal","mud");
    public static final DeferredBlock<Block> SANDSTONE_PEDESTAL =  pedestalRegister("sandstone_villager_pedestal","sandstone");
    public static final DeferredBlock<Block> RED_SANDSTONE_PEDESTAL =  pedestalRegister("red_sandstone_villager_pedestal","sandstone");
    public static final DeferredBlock<Block> QUARTZ_BLOCK_PEDESTAL =  pedestalRegister("quartz_block_villager_pedestal","sandstone");
    public static final DeferredBlock<Block> NETHER_BRICKS_PEDESTAL =  pedestalRegister("nether_bricks_villager_pedestal","netherbrick");
    public static final DeferredBlock<Block> BASALT_PEDESTAL =  pedestalRegister("basalt_villager_pedestal","basalt");
    public static final DeferredBlock<Block> END_STONE_PEDESTAL =  pedestalRegister("end_stone_villager_pedestal","endstone");
    public static final DeferredBlock<Block> COAL_BLOCK_PEDESTAL =  pedestalRegister("coal_block_villager_pedestal","mineral_strong");
    public static final DeferredBlock<Block> IRON_BLOCK_PEDESTAL =  pedestalRegister("iron_block_villager_pedestal","metal");
    public static final DeferredBlock<Block> GOLD_BLOCK_PEDESTAL =  pedestalRegister("gold_block_villager_pedestal","metal");
    public static final DeferredBlock<Block> REDSTONE_BLOCK_PEDESTAL =  pedestalRegister("redstone_block_villager_pedestal","metal");
    public static final DeferredBlock<Block> EMERALD_BLOCK_PEDESTAL =  pedestalRegister("emerald_block_villager_pedestal","metal");
    public static final DeferredBlock<Block> DIAMOND_BLOCK_PEDESTAL =  pedestalRegister("diamond_block_villager_pedestal","metal");
    public static final DeferredBlock<Block> COPPER_BLOCK_PEDESTAL =  pedestalRegister("copper_block_villager_pedestal","copper");
    public static final DeferredBlock<Block> LAPIS_BLOCK_PEDESTAL =  pedestalRegister("lapis_block_villager_pedestal","mineral_weak");
    public static final DeferredBlock<Block> NETHERITE_BLOCK_PEDESTAL =  pedestalRegister("netherite_block_villager_pedestal","netherite");
    public static final DeferredBlock<Block> OBSIDIAN_PEDESTAL =  pedestalRegister("obsidian_villager_pedestal","obsidan");
    public static final DeferredBlock<Block> AMETHYST_BLOCK_PEDESTAL =  pedestalRegister("amethyst_block_villager_pedestal","amethyst");
    public static final DeferredBlock<Block> DRIPSTONE_BLOCK_PEDESTAL =  pedestalRegister("dripstone_block_villager_pedestal","dripstone");
    public static final DeferredBlock<Block> BEDROCK_PEDESTAL =  pedestalRegister("bedrock_villager_pedestal","bedrock");
        //brazier
    public static final DeferredBlock<Block> OAK_VILLAGER_BRAZIER = brazierRegister("oak_villager_brazier","wood");
    public static final DeferredBlock<Block> BIRCH_VILLAGER_BRAZIER = brazierRegister("birch_villager_brazier","wood");
    public static final DeferredBlock<Block> SPRUCE_VILLAGER_BRAZIER = brazierRegister("spruce_villager_brazier","wood");
    public static final DeferredBlock<Block> JUNGLE_VILLAGER_BRAZIER = brazierRegister("jungle_villager_brazier","wood");
    public static final DeferredBlock<Block> ACACIA_VILLAGER_BRAZIER = brazierRegister("acacia_villager_brazier","wood");
    public static final DeferredBlock<Block> DARK_OAK_VILLAGER_BRAZIER = brazierRegister("dark_oak_villager_brazier","wood");
    public static final DeferredBlock<Block> MANGROVE_VILLAGER_BRAZIER = brazierRegister("mangrove_villager_brazier","wood");
    public static final DeferredBlock<Block> CHERRY_VILLAGER_BRAZIER = brazierRegister("cherry_villager_brazier","wood","cherry");
    public static final DeferredBlock<Block> BAMBOO_VILLAGER_BRAZIER = brazierRegister("bamboo_villager_brazier","wood","bamboo");
    public static final DeferredBlock<Block> CRIMSON_VILLAGER_BRAZIER = brazierRegister("crimson_villager_brazier","wood","netherwood");
    public static final DeferredBlock<Block> WARPED_VILLAGER_BRAZIER = brazierRegister("warped_villager_brazier","wood","netherwood");
    public static final DeferredBlock<Block> STONE_VILLAGER_BRAZIER =  brazierRegister("stone_villager_brazier","stone");
    public static final DeferredBlock<Block> MOSSY_STONE_VILLAGER_BRAZIER =  brazierRegister("mossy_stone_villager_brazier","stone");
    public static final DeferredBlock<Block> ANDESITE_VILLAGER_BRAZIER =  brazierRegister("andesite_villager_brazier","stone");
    public static final DeferredBlock<Block> DIORITE_VILLAGER_BRAZIER =  brazierRegister("diorite_villager_brazier","stone");
    public static final DeferredBlock<Block> GRANITE_VILLAGER_BRAZIER =  brazierRegister("granite_villager_brazier","stone");
    public static final DeferredBlock<Block> PRISMARINE_VILLAGER_BRAZIER =  brazierRegister("prismarine_villager_brazier","stone");
    public static final DeferredBlock<Block> BLACKSTONE_VILLAGER_BRAZIER =  brazierRegister("blackstone_villager_brazier","stone");
    public static final DeferredBlock<Block> PURPUR_BLOCK_VILLAGER_BRAZIER =  brazierRegister("purpur_block_villager_brazier","stone");
    public static final DeferredBlock<Block> DEEPSLATE_VILLAGER_BRAZIER =  brazierRegister("deepslate_villager_brazier","deepslate");
    public static final DeferredBlock<Block> TUFF_VILLAGER_BRAZIER =  brazierRegister("tuff_villager_brazier","tuff");
    public static final DeferredBlock<Block> PACKED_MUD_VILLAGER_BRAZIER =  brazierRegister("packed_mud_villager_brazier","mud");
    public static final DeferredBlock<Block> SANDSTONE_VILLAGER_BRAZIER =  brazierRegister("sandstone_villager_brazier","sandstone");
    public static final DeferredBlock<Block> RED_SANDSTONE_VILLAGER_BRAZIER =  brazierRegister("red_sandstone_villager_brazier","sandstone");
    public static final DeferredBlock<Block> QUARTZ_BLOCK_VILLAGER_BRAZIER =  brazierRegister("quartz_block_villager_brazier","sandstone");
    public static final DeferredBlock<Block> NETHER_BRICKS_VILLAGER_BRAZIER =  brazierRegister("nether_bricks_villager_brazier","netherbrick");
    public static final DeferredBlock<Block> BASALT_VILLAGER_BRAZIER =  brazierRegister("basalt_villager_brazier","basalt");
    public static final DeferredBlock<Block> END_STONE_VILLAGER_BRAZIER =  brazierRegister("end_stone_villager_brazier","endstone");
    public static final DeferredBlock<Block> COAL_BLOCK_VILLAGER_BRAZIER =  brazierRegister("coal_block_villager_brazier","mineral_strong");
    public static final DeferredBlock<Block> IRON_BLOCK_VILLAGER_BRAZIER =  brazierRegister("iron_block_villager_brazier","metal");
    public static final DeferredBlock<Block> GOLD_BLOCK_VILLAGER_BRAZIER =  brazierRegister("gold_block_villager_brazier","metal");
    public static final DeferredBlock<Block> REDSTONE_BLOCK_VILLAGER_BRAZIER =  brazierRegister("redstone_block_villager_brazier","metal");
    public static final DeferredBlock<Block> EMERALD_BLOCK_VILLAGER_BRAZIER =  brazierRegister("emerald_block_villager_brazier","metal");
    public static final DeferredBlock<Block> DIAMOND_BLOCK_VILLAGER_BRAZIER =  brazierRegister("diamond_block_villager_brazier","metal");
    public static final DeferredBlock<Block> COPPER_BLOCK_VILLAGER_BRAZIER =  brazierRegister("copper_block_villager_brazier","copper");
    public static final DeferredBlock<Block> LAPIS_BLOCK_VILLAGER_BRAZIER =  brazierRegister("lapis_block_villager_brazier","mineral_weak");
    public static final DeferredBlock<Block> NETHERITE_BLOCK_VILLAGER_BRAZIER =  brazierRegister("netherite_block_villager_brazier","netherite");
    public static final DeferredBlock<Block> OBSIDIAN_VILLAGER_BRAZIER =  brazierRegister("obsidian_villager_brazier","obsidan");
    public static final DeferredBlock<Block> AMETHYST_BLOCK_VILLAGER_BRAZIER =  brazierRegister("amethyst_block_villager_brazier","amethyst");
    public static final DeferredBlock<Block> DRIPSTONE_BLOCK_VILLAGER_BRAZIER =  brazierRegister("dripstone_block_villager_brazier","dripstone");
    public static final DeferredBlock<Block> BEDROCK_VILLAGER_BRAZIER =  brazierRegister("bedrock_villager_brazier","bedrock");
        //table zone
    public static final DeferredBlock<Block> OAK_VILLAGER_TABLE = villagerTableRegister("oak_villager_table","wood");
    public static final DeferredBlock<Block> BIRCH_VILLAGER_TABLE = villagerTableRegister("birch_villager_table","wood");
    public static final DeferredBlock<Block> SPRUCE_VILLAGER_TABLE = villagerTableRegister("spruce_villager_table","wood");
    public static final DeferredBlock<Block> JUNGLE_VILLAGER_TABLE = villagerTableRegister("jungle_villager_table","wood");
    public static final DeferredBlock<Block> ACACIA_VILLAGER_TABLE = villagerTableRegister("acacia_villager_table","wood");
    public static final DeferredBlock<Block> DARK_OAK_VILLAGER_TABLE = villagerTableRegister("dark_oak_villager_table","wood");
    public static final DeferredBlock<Block> MANGROVE_VILLAGER_TABLE = villagerTableRegister("mangrove_villager_table","wood");
    public static final DeferredBlock<Block> CHERRY_VILLAGER_TABLE = villagerTableRegister("cherry_villager_table","wood","cherry");
    public static final DeferredBlock<Block> BAMBOO_VILLAGER_TABLE = villagerTableRegister("bamboo_villager_table","wood","bamboo");
    public static final DeferredBlock<Block> CRIMSON_VILLAGER_TABLE = villagerTableRegister("crimson_villager_table","wood","netherwood");
    public static final DeferredBlock<Block> WARPED_VILLAGER_TABLE = villagerTableRegister("warped_villager_table","wood","netherwood");
    public static final DeferredBlock<Block> STONE_VILLAGER_TABLE =  villagerTableRegister("stone_villager_table","stone");
    public static final DeferredBlock<Block> MOSSY_STONE_VILLAGER_TABLE =  villagerTableRegister("mossy_stone_villager_table","stone");
    public static final DeferredBlock<Block> ANDESITE_VILLAGER_TABLE =  villagerTableRegister("andesite_villager_table","stone");
    public static final DeferredBlock<Block> DIORITE_VILLAGER_TABLE =  villagerTableRegister("diorite_villager_table","stone");
    public static final DeferredBlock<Block> GRANITE_VILLAGER_TABLE =  villagerTableRegister("granite_villager_table","stone");
    public static final DeferredBlock<Block> PRISMARINE_VILLAGER_TABLE =  villagerTableRegister("prismarine_villager_table","stone");
    public static final DeferredBlock<Block> BLACKSTONE_VILLAGER_TABLE =  villagerTableRegister("blackstone_villager_table","stone");
    public static final DeferredBlock<Block> PURPUR_BLOCK_VILLAGER_TABLE =  villagerTableRegister("purpur_block_villager_table","stone");
    public static final DeferredBlock<Block> DEEPSLATE_VILLAGER_TABLE =  villagerTableRegister("deepslate_villager_table","deepslate");
    public static final DeferredBlock<Block> TUFF_VILLAGER_TABLE =  villagerTableRegister("tuff_villager_table","tuff");
    public static final DeferredBlock<Block> PACKED_MUD_VILLAGER_TABLE =  villagerTableRegister("packed_mud_villager_table","mud");
    public static final DeferredBlock<Block> SANDSTONE_VILLAGER_TABLE =  villagerTableRegister("sandstone_villager_table","sandstone");
    public static final DeferredBlock<Block> RED_SANDSTONE_VILLAGER_TABLE =  villagerTableRegister("red_sandstone_villager_table","sandstone");
    public static final DeferredBlock<Block> QUARTZ_BLOCK_VILLAGER_TABLE =  villagerTableRegister("quartz_block_villager_table","sandstone");
    public static final DeferredBlock<Block> NETHER_BRICKS_VILLAGER_TABLE =  villagerTableRegister("nether_bricks_villager_table","netherbrick");
    public static final DeferredBlock<Block> BASALT_VILLAGER_TABLE =  villagerTableRegister("basalt_villager_table","basalt");
    public static final DeferredBlock<Block> END_STONE_VILLAGER_TABLE =  villagerTableRegister("end_stone_villager_table","endstone");
    public static final DeferredBlock<Block> COAL_BLOCK_VILLAGER_TABLE =  villagerTableRegister("coal_block_villager_table","mineral_strong");
    public static final DeferredBlock<Block> IRON_BLOCK_VILLAGER_TABLE =  villagerTableRegister("iron_block_villager_table","metal");
    public static final DeferredBlock<Block> GOLD_BLOCK_VILLAGER_TABLE =  villagerTableRegister("gold_block_villager_table","metal");
    public static final DeferredBlock<Block> REDSTONE_BLOCK_VILLAGER_TABLE =  villagerTableRegister("redstone_block_villager_table","metal");
    public static final DeferredBlock<Block> EMERALD_BLOCK_VILLAGER_TABLE =  villagerTableRegister("emerald_block_villager_table","metal");
    public static final DeferredBlock<Block> DIAMOND_BLOCK_VILLAGER_TABLE =  villagerTableRegister("diamond_block_villager_table","metal");
    public static final DeferredBlock<Block> COPPER_BLOCK_VILLAGER_TABLE =  villagerTableRegister("copper_block_villager_table","copper");
    public static final DeferredBlock<Block> LAPIS_BLOCK_VILLAGER_TABLE =  villagerTableRegister("lapis_block_villager_table","mineral_weak");
    public static final DeferredBlock<Block> NETHERITE_BLOCK_VILLAGER_TABLE =  villagerTableRegister("netherite_block_villager_table","netherite");
    public static final DeferredBlock<Block> OBSIDIAN_VILLAGER_TABLE =  villagerTableRegister("obsidian_villager_table","obsidan");
    public static final DeferredBlock<Block> AMETHYST_BLOCK_VILLAGER_TABLE =  villagerTableRegister("amethyst_block_villager_table","amethyst");
    public static final DeferredBlock<Block> DRIPSTONE_BLOCK_VILLAGER_TABLE =  villagerTableRegister("dripstone_block_villager_table","dripstone");
    public static final DeferredBlock<Block> BEDROCK_VILLAGER_TABLE =  villagerTableRegister("bedrock_villager_table","bedrock");
        //chair zone
    public static final DeferredBlock<Block> OAK_VILLAGER_CHAIR = villagerChairRegister("oak_villager_chair","wood");
    public static final DeferredBlock<Block> BIRCH_VILLAGER_CHAIR = villagerChairRegister("birch_villager_chair","wood");
    public static final DeferredBlock<Block> SPRUCE_VILLAGER_CHAIR = villagerChairRegister("spruce_villager_chair","wood");
    public static final DeferredBlock<Block> JUNGLE_VILLAGER_CHAIR = villagerChairRegister("jungle_villager_chair","wood");
    public static final DeferredBlock<Block> ACACIA_VILLAGER_CHAIR = villagerChairRegister("acacia_villager_chair","wood");
    public static final DeferredBlock<Block> DARK_OAK_VILLAGER_CHAIR = villagerChairRegister("dark_oak_villager_chair","wood");
    public static final DeferredBlock<Block> MANGROVE_VILLAGER_CHAIR = villagerChairRegister("mangrove_villager_chair","wood");
    public static final DeferredBlock<Block> CHERRY_VILLAGER_CHAIR = villagerChairRegister("cherry_villager_chair","wood","cherry");
    public static final DeferredBlock<Block> BAMBOO_VILLAGER_CHAIR = villagerChairRegister("bamboo_villager_chair","wood","bamboo");
    public static final DeferredBlock<Block> CRIMSON_VILLAGER_CHAIR = villagerChairRegister("crimson_villager_chair","wood","netherwood");
    public static final DeferredBlock<Block> WARPED_VILLAGER_CHAIR = villagerChairRegister("warped_villager_chair","wood","netherwood");
    public static final DeferredBlock<Block> STONE_VILLAGER_CHAIR =  villagerChairRegister("stone_villager_chair","stone");
    public static final DeferredBlock<Block> MOSSY_STONE_VILLAGER_CHAIR =  villagerChairRegister("mossy_stone_villager_chair","stone");
    public static final DeferredBlock<Block> ANDESITE_VILLAGER_CHAIR =  villagerChairRegister("andesite_villager_chair","stone");
    public static final DeferredBlock<Block> DIORITE_VILLAGER_CHAIR =  villagerChairRegister("diorite_villager_chair","stone");
    public static final DeferredBlock<Block> GRANITE_VILLAGER_CHAIR =  villagerChairRegister("granite_villager_chair","stone");
    public static final DeferredBlock<Block> PRISMARINE_VILLAGER_CHAIR =  villagerChairRegister("prismarine_villager_chair","stone");
    public static final DeferredBlock<Block> BLACKSTONE_VILLAGER_CHAIR =  villagerChairRegister("blackstone_villager_chair","stone");
    public static final DeferredBlock<Block> PURPUR_BLOCK_VILLAGER_CHAIR =  villagerChairRegister("purpur_block_villager_chair","stone");
    public static final DeferredBlock<Block> DEEPSLATE_VILLAGER_CHAIR =  villagerChairRegister("deepslate_villager_chair","deepslate");
    public static final DeferredBlock<Block> TUFF_VILLAGER_CHAIR =  villagerChairRegister("tuff_villager_chair","tuff");
    public static final DeferredBlock<Block> PACKED_MUD_VILLAGER_CHAIR =  villagerChairRegister("packed_mud_villager_chair","mud");
    public static final DeferredBlock<Block> SANDSTONE_VILLAGER_CHAIR =  villagerChairRegister("sandstone_villager_chair","sandstone");
    public static final DeferredBlock<Block> RED_SANDSTONE_VILLAGER_CHAIR =  villagerChairRegister("red_sandstone_villager_chair","sandstone");
    public static final DeferredBlock<Block> QUARTZ_BLOCK_VILLAGER_CHAIR =  villagerChairRegister("quartz_block_villager_chair","sandstone");
    public static final DeferredBlock<Block> NETHER_BRICKS_VILLAGER_CHAIR =  villagerChairRegister("nether_bricks_villager_chair","netherbrick");
    public static final DeferredBlock<Block> BASALT_VILLAGER_CHAIR =  villagerChairRegister("basalt_villager_chair","basalt");
    public static final DeferredBlock<Block> END_STONE_VILLAGER_CHAIR =  villagerChairRegister("end_stone_villager_chair","endstone");
    public static final DeferredBlock<Block> COAL_BLOCK_VILLAGER_CHAIR =  villagerChairRegister("coal_block_villager_chair","mineral_strong");
    public static final DeferredBlock<Block> IRON_BLOCK_VILLAGER_CHAIR =  villagerChairRegister("iron_block_villager_chair","metal");
    public static final DeferredBlock<Block> GOLD_BLOCK_VILLAGER_CHAIR =  villagerChairRegister("gold_block_villager_chair","metal");
    public static final DeferredBlock<Block> REDSTONE_BLOCK_VILLAGER_CHAIR =  villagerChairRegister("redstone_block_villager_chair","metal");
    public static final DeferredBlock<Block> EMERALD_BLOCK_VILLAGER_CHAIR =  villagerChairRegister("emerald_block_villager_chair","metal");
    public static final DeferredBlock<Block> DIAMOND_BLOCK_VILLAGER_CHAIR =  villagerChairRegister("diamond_block_villager_chair","metal");
    public static final DeferredBlock<Block> COPPER_BLOCK_VILLAGER_CHAIR =  villagerChairRegister("copper_block_villager_chair","copper");
    public static final DeferredBlock<Block> LAPIS_BLOCK_VILLAGER_CHAIR =  villagerChairRegister("lapis_block_villager_chair","mineral_weak");
    public static final DeferredBlock<Block> NETHERITE_BLOCK_VILLAGER_CHAIR =  villagerChairRegister("netherite_block_villager_chair","netherite");
    public static final DeferredBlock<Block> OBSIDIAN_VILLAGER_CHAIR =  villagerChairRegister("obsidian_villager_chair","obsidan");
    public static final DeferredBlock<Block> AMETHYST_BLOCK_VILLAGER_CHAIR =  villagerChairRegister("amethyst_block_villager_chair","amethyst");
    public static final DeferredBlock<Block> DRIPSTONE_BLOCK_VILLAGER_CHAIR =  villagerChairRegister("dripstone_block_villager_chair","dripstone");
    public static final DeferredBlock<Block> BEDROCK_VILLAGER_CHAIR =  villagerChairRegister("bedrock_villager_chair","bedrock");
        //throne chair
    public static final DeferredBlock<Block> OAK_VILLAGER_THRONE_CHAIR = villagerThroneChairRegister("oak_villager_throne_chair","wood");
    public static final DeferredBlock<Block> BIRCH_VILLAGER_THRONE_CHAIR = villagerThroneChairRegister("birch_villager_throne_chair","wood");
    public static final DeferredBlock<Block> SPRUCE_VILLAGER_THRONE_CHAIR = villagerThroneChairRegister("spruce_villager_throne_chair","wood");
    public static final DeferredBlock<Block> JUNGLE_VILLAGER_THRONE_CHAIR = villagerThroneChairRegister("jungle_villager_throne_chair","wood");
    public static final DeferredBlock<Block> ACACIA_VILLAGER_THRONE_CHAIR = villagerThroneChairRegister("acacia_villager_throne_chair","wood");
    public static final DeferredBlock<Block> DARK_OAK_VILLAGER_THRONE_CHAIR = villagerThroneChairRegister("dark_oak_villager_throne_chair","wood");
    public static final DeferredBlock<Block> MANGROVE_VILLAGER_THRONE_CHAIR = villagerThroneChairRegister("mangrove_villager_throne_chair","wood");
    public static final DeferredBlock<Block> CHERRY_VILLAGER_THRONE_CHAIR = villagerThroneChairRegister("cherry_villager_throne_chair","wood","cherry");
    public static final DeferredBlock<Block> BAMBOO_VILLAGER_THRONE_CHAIR = villagerThroneChairRegister("bamboo_villager_throne_chair","wood","bamboo");
    public static final DeferredBlock<Block> CRIMSON_VILLAGER_THRONE_CHAIR = villagerThroneChairRegister("crimson_villager_throne_chair","wood","netherwood");
    public static final DeferredBlock<Block> WARPED_VILLAGER_THRONE_CHAIR = villagerThroneChairRegister("warped_villager_throne_chair","wood","netherwood");
    public static final DeferredBlock<Block> STONE_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("stone_villager_throne_chair","stone");
    public static final DeferredBlock<Block> MOSSY_STONE_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("mossy_stone_villager_throne_chair","stone");
    public static final DeferredBlock<Block> ANDESITE_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("andesite_villager_throne_chair","stone");
    public static final DeferredBlock<Block> DIORITE_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("diorite_villager_throne_chair","stone");
    public static final DeferredBlock<Block> GRANITE_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("granite_villager_throne_chair","stone");
    public static final DeferredBlock<Block> PRISMARINE_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("prismarine_villager_throne_chair","stone");
    public static final DeferredBlock<Block> BLACKSTONE_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("blackstone_villager_throne_chair","stone");
    public static final DeferredBlock<Block> PURPUR_BLOCK_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("purpur_block_villager_throne_chair","stone");
    public static final DeferredBlock<Block> DEEPSLATE_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("deepslate_villager_throne_chair","deepslate");
    public static final DeferredBlock<Block> TUFF_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("tuff_villager_throne_chair","tuff");
    public static final DeferredBlock<Block> PACKED_MUD_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("packed_mud_villager_throne_chair","mud");
    public static final DeferredBlock<Block> SANDSTONE_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("sandstone_villager_throne_chair","sandstone");
    public static final DeferredBlock<Block> RED_SANDSTONE_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("red_sandstone_villager_throne_chair","sandstone");
    public static final DeferredBlock<Block> QUARTZ_BLOCK_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("quartz_block_villager_throne_chair","sandstone");
    public static final DeferredBlock<Block> NETHER_BRICKS_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("nether_bricks_villager_throne_chair","netherbrick");
    public static final DeferredBlock<Block> BASALT_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("basalt_villager_throne_chair","basalt");
    public static final DeferredBlock<Block> END_STONE_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("end_stone_villager_throne_chair","endstone");
    public static final DeferredBlock<Block> COAL_BLOCK_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("coal_block_villager_throne_chair","mineral_strong");
    public static final DeferredBlock<Block> IRON_BLOCK_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("iron_block_villager_throne_chair","metal");
    public static final DeferredBlock<Block> GOLD_BLOCK_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("gold_block_villager_throne_chair","metal");
    public static final DeferredBlock<Block> REDSTONE_BLOCK_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("redstone_block_villager_throne_chair","metal");
    public static final DeferredBlock<Block> EMERALD_BLOCK_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("emerald_block_villager_throne_chair","metal");
    public static final DeferredBlock<Block> DIAMOND_BLOCK_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("diamond_block_villager_throne_chair","metal");
    public static final DeferredBlock<Block> COPPER_BLOCK_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("copper_block_villager_throne_chair","copper");
    public static final DeferredBlock<Block> LAPIS_BLOCK_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("lapis_block_villager_throne_chair","mineral_weak");
    public static final DeferredBlock<Block> NETHERITE_BLOCK_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("netherite_block_villager_throne_chair","netherite");
    public static final DeferredBlock<Block> OBSIDIAN_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("obsidian_villager_throne_chair","obsidan");
    public static final DeferredBlock<Block> AMETHYST_BLOCK_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("amethyst_block_villager_throne_chair","amethyst");
    public static final DeferredBlock<Block> DRIPSTONE_BLOCK_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("dripstone_block_villager_throne_chair","dripstone");
    public static final DeferredBlock<Block> BEDROCK_VILLAGER_THRONE_CHAIR =  villagerThroneChairRegister("bedrock_villager_throne_chair","bedrock");

    //create the block with a name and the factory (factory include properties)
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
    {
        DeferredBlock<T> madeBlock = BLOCKS.register(name, block);
        registerBlockItem(name, madeBlock);
        return madeBlock;
    }

    //create the item block of the block
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
        ItemRegister.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    private static  <T extends Block> DeferredBlock<T> statueRegister(String name, String familie, String type)
    {
        switch (familie)
        {
            case "wood":
                return (DeferredBlock<T>) statueRegister(name, type);
            default:
                return (DeferredBlock<T>) statueRegister(name, "default");
        }
    }
    private static  <T extends Block> DeferredBlock<T> statueRegister(String name, String type)
    {
        switch (type) {
            case "stone":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
            }
            case "cobblestone":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).noOcclusion()));
            }
            case "deepslate":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE).noOcclusion()));
            }
            case "tuff":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF).noOcclusion()));
            }
            case "mud":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD).noOcclusion()));
            }
            case "sandstone":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).noOcclusion()));
            }
            case "netherbrick":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS).noOcclusion()));
            }
            case "mineral_weak":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK).noOcclusion()));
            }
            case "mineral_strong":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).noOcclusion()));
            }
            case "metal":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
            }
            case "copper":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).noOcclusion()));
            }
            case "basalt":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT).noOcclusion()));
            }
            case "endstone":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).noOcclusion()));
            }
            case "obsidan":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).noOcclusion()));
            }
            case "netherite":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).noOcclusion()));
            }
            case "amethyst":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).noOcclusion()));
            }
            case "dripstone":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK).noOcclusion()));
            }
            case "bedrock":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK).noOcclusion()));
            }
            case "netherwood":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
            }
            case "cherry":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
            }
            case "bamboo":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
            }
            default:
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
            }
        }
    }
    private static  <T extends Block> DeferredBlock<T> pedestalRegister(String name, String familie, String type)
    {
        switch (familie)
        {
            case "wood":
                return (DeferredBlock<T>) pedestalRegister(name, type);
            default:
                return (DeferredBlock<T>) pedestalRegister(name, "default");
        }
    }
    private static <T extends Block> DeferredBlock<T> pedestalRegister(String name, String type)
    {
        switch (type) {
            case "stone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
            }
            case "cobblestone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).noOcclusion()));
            }
            case "deepslate": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE).noOcclusion()));
            }
            case "tuff": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF).noOcclusion()));
            }
            case "mud": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD).noOcclusion()));
            }
            case "sandstone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).noOcclusion()));
            }
            case "netherbrick": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS).noOcclusion()));
            }
            case "mineral_weak": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK).noOcclusion()));
            }
            case "mineral_strong": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).noOcclusion()));
            }
            case "metal": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
            }
            case "copper": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).noOcclusion()));
            }
            case "basalt": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT).noOcclusion()));
            }
            case "endstone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).noOcclusion()));
            }
            case "obsidan": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).noOcclusion()));
            }
            case "netherite": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).noOcclusion()));
            }
            case "amethyst": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).noOcclusion()));
            }
            case "dripstone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK).noOcclusion()));
            }
            case "bedrock": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK).noOcclusion()));
            }
            case "netherwood": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
            }
            case "cherry": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
            }
            case "bamboo": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
            }
            default: {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
            }
        }
    }
    private static  <T extends Block> DeferredBlock<T> brazierRegister(String name, String familie, String type)
    {
        switch (familie)
        {
            case "wood":
                return (DeferredBlock<T>) brazierRegister(name, type);
            default:
                return (DeferredBlock<T>) brazierRegister(name, "default");
        }
    }
    private static <T extends Block> DeferredBlock<T> brazierRegister(String name, String type)
    {
        switch (type) {
            case "stone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            case "cobblestone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            case "deepslate": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            case "tuff": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            case "mud": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            case "sandstone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            case "netherbrick": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            case "mineral_weak": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            case "mineral_strong": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            case "metal": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            case "copper": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            case "basalt": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            case "endstone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            case "obsidan": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            case "netherite": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            case "amethyst": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            case "dripstone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            case "bedrock": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            case "netherwood": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            case "cherry": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            case "bamboo": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion().lightLevel(litBlockEmission(15))));
            }
            default: {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(true,1,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion().lightLevel(litBlockEmission(15))));
            }
        }
    }
    private static  <T extends Block> DeferredBlock<T> villagerTableRegister(String name, String familie, String type)
    {
        switch (familie)
        {
            case "wood":
                return (DeferredBlock<T>) villagerTableRegister(name, type);
            default:
                return (DeferredBlock<T>) villagerTableRegister(name, "default");
        }
    }
    private static <T extends Block> DeferredBlock<T> villagerTableRegister(String name, String type)
    {
        switch (type) {
            case "stone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock( BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
            }
            case "cobblestone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).noOcclusion()));
            }
            case "deepslate": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE).noOcclusion()));
            }
            case "tuff": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF).noOcclusion()));
            }
            case "mud": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD).noOcclusion()));
            }
            case "sandstone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).noOcclusion()));
            }
            case "netherbrick": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS).noOcclusion()));
            }
            case "mineral_weak": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK).noOcclusion()));
            }
            case "mineral_strong": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).noOcclusion()));
            }
            case "metal": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
            }
            case "copper": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).noOcclusion()));
            }
            case "basalt": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT).noOcclusion()));
            }
            case "endstone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).noOcclusion()));
            }
            case "obsidan": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).noOcclusion()));
            }
            case "netherite": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).noOcclusion()));
            }
            case "amethyst": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).noOcclusion()));
            }
            case "dripstone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK).noOcclusion()));
            }
            case "bedrock": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK).noOcclusion()));
            }
            case "netherwood": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
            }
            case "cherry": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
            }
            case "bamboo": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
            }
            default: {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
            }
        }
    }
    private static  <T extends Block> DeferredBlock<T> villagerChairRegister(String name, String familie, String type)
    {
        switch (familie)
        {
            case "wood":
                return (DeferredBlock<T>) villagerChairRegister(name, type);
            default:
                return (DeferredBlock<T>) villagerChairRegister(name, "default");
        }
    }
    private static <T extends Block> DeferredBlock<T> villagerChairRegister(String name, String type)
    {
        switch (type) {
            case "stone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock( BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
            }
            case "cobblestone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).noOcclusion()));
            }
            case "deepslate": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE).noOcclusion()));
            }
            case "tuff": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF).noOcclusion()));
            }
            case "mud": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD).noOcclusion()));
            }
            case "sandstone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).noOcclusion()));
            }
            case "netherbrick": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS).noOcclusion()));
            }
            case "mineral_weak": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK).noOcclusion()));
            }
            case "mineral_strong": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).noOcclusion()));
            }
            case "metal": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
            }
            case "copper": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).noOcclusion()));
            }
            case "basalt": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT).noOcclusion()));
            }
            case "endstone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).noOcclusion()));
            }
            case "obsidan": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).noOcclusion()));
            }
            case "netherite": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).noOcclusion()));
            }
            case "amethyst": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).noOcclusion()));
            }
            case "dripstone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK).noOcclusion()));
            }
            case "bedrock": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK).noOcclusion()));
            }
            case "netherwood": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
            }
            case "cherry": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
            }
            case "bamboo": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
            }
            default: {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
            }
        }
    }

    private static ToIntFunction<BlockState> litBlockEmission(int pLightValue)
    {
        return p_50763_ -> p_50763_.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
    }
    private static  <T extends Block> DeferredBlock<T> villagerThroneChairRegister(String name, String familie, String type)
    {
        switch (familie)
        {
            case "wood":
                return (DeferredBlock<T>) villagerThroneChairRegister(name, type);
            default:
                return (DeferredBlock<T>) villagerThroneChairRegister(name, "default");
        }
    }
    private static <T extends Block> DeferredBlock<T> villagerThroneChairRegister(String name, String type)
    {
        switch (type) {
            case "stone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock( BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
            }
            case "cobblestone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).noOcclusion()));
            }
            case "deepslate": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE).noOcclusion()));
            }
            case "tuff": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF).noOcclusion()));
            }
            case "mud": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD).noOcclusion()));
            }
            case "sandstone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).noOcclusion()));
            }
            case "netherbrick": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS).noOcclusion()));
            }
            case "mineral_weak": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK).noOcclusion()));
            }
            case "mineral_strong": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).noOcclusion()));
            }
            case "metal": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
            }
            case "copper": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).noOcclusion()));
            }
            case "basalt": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT).noOcclusion()));
            }
            case "endstone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).noOcclusion()));
            }
            case "obsidan": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).noOcclusion()));
            }
            case "netherite": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).noOcclusion()));
            }
            case "amethyst": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).noOcclusion()));
            }
            case "dripstone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK).noOcclusion()));
            }
            case "bedrock": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK).noOcclusion()));
            }
            case "netherwood": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
            }
            case "cherry": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
            }
            case "bamboo": {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
            }
            default: {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
            }
        }
    }

    public static void register(IEventBus modEventBus)
    {
        BLOCKS.register(modEventBus);
    }
}
