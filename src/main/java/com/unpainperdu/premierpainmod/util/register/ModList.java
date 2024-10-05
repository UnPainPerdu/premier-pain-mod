package com.unpainperdu.premierpainmod.util.register;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Arrays;
import java.util.List;

public class ModList
{
    public static List<DeferredBlock<Block>> ALL_BLOCKS = Arrays.asList(
            //workshop
            BlockRegister.VILLAGER_WORKSHOP,
            //statue
            BlockRegister.OAK_VILLAGER_STATUE,
            BlockRegister.BIRCH_VILLAGER_STATUE,
            BlockRegister.SPRUCE_VILLAGER_STATUE,
            BlockRegister.JUNGLE_VILLAGER_STATUE,
            BlockRegister.ACACIA_VILLAGER_STATUE,
            BlockRegister.DARK_OAK_VILLAGER_STATUE,
            BlockRegister.MANGROVE_VILLAGER_STATUE,
            BlockRegister.CHERRY_VILLAGER_STATUE,
            BlockRegister.BAMBOO_VILLAGER_STATUE,
            BlockRegister.CRIMSON_VILLAGER_STATUE,
            BlockRegister.WARPED_VILLAGER_STATUE,
            BlockRegister.PALE_OAK_VILLAGER_STATUE,
            BlockRegister.STONE_VILLAGER_STATUE,
            BlockRegister.MOSSY_STONE_VILLAGER_STATUE,
            BlockRegister.ANDESITE_VILLAGER_STATUE,
            BlockRegister.DIORITE_VILLAGER_STATUE,
            BlockRegister.GRANITE_VILLAGER_STATUE,
            BlockRegister.PRISMARINE_VILLAGER_STATUE,
            BlockRegister.BLACKSTONE_VILLAGER_STATUE,
            BlockRegister.PURPUR_BLOCK_VILLAGER_STATUE,
            BlockRegister.DEEPSLATE_VILLAGER_STATUE,
            BlockRegister.TUFF_VILLAGER_STATUE,
            BlockRegister.PACKED_MUD_VILLAGER_STATUE,
            BlockRegister.SANDSTONE_VILLAGER_STATUE,
            BlockRegister.RED_SANDSTONE_VILLAGER_STATUE,
            BlockRegister.QUARTZ_BLOCK_VILLAGER_STATUE,
            BlockRegister.NETHER_BRICKS_VILLAGER_STATUE,
            BlockRegister.BASALT_VILLAGER_STATUE,
            BlockRegister.END_STONE_VILLAGER_STATUE,
            BlockRegister.COAL_BLOCK_VILLAGER_STATUE,
            BlockRegister.IRON_BLOCK_VILLAGER_STATUE,
            BlockRegister.GOLD_BLOCK_VILLAGER_STATUE,
            BlockRegister.REDSTONE_BLOCK_VILLAGER_STATUE,
            BlockRegister.EMERALD_BLOCK_VILLAGER_STATUE,
            BlockRegister.DIAMOND_BLOCK_VILLAGER_STATUE,
            BlockRegister.COPPER_BLOCK_VILLAGER_STATUE,
            BlockRegister.LAPIS_BLOCK_VILLAGER_STATUE,
            BlockRegister.NETHERITE_BLOCK_VILLAGER_STATUE,
            BlockRegister.OBSIDIAN_VILLAGER_STATUE,
            BlockRegister.AMETHYST_BLOCK_VILLAGER_STATUE,
            BlockRegister.DRIPSTONE_BLOCK_VILLAGER_STATUE,
            BlockRegister.BEDROCK_VILLAGER_STATUE,
            //pedestal
            BlockRegister.OAK_PEDESTAL,
            BlockRegister.BIRCH_PEDESTAL,
            BlockRegister.SPRUCE_PEDESTAL,
            BlockRegister.JUNGLE_PEDESTAL,
            BlockRegister.ACACIA_PEDESTAL,
            BlockRegister.DARK_OAK_PEDESTAL,
            BlockRegister.MANGROVE_PEDESTAL,
            BlockRegister.CHERRY_PEDESTAL,
            BlockRegister.BAMBOO_PEDESTAL,
            BlockRegister.CRIMSON_PEDESTAL,
            BlockRegister.WARPED_PEDESTAL,
            BlockRegister.PALE_OAK_PEDESTAL,
            BlockRegister.STONE_PEDESTAL,
            BlockRegister.MOSSY_STONE_PEDESTAL,
            BlockRegister.ANDESITE_PEDESTAL,
            BlockRegister.DIORITE_PEDESTAL,
            BlockRegister.GRANITE_PEDESTAL,
            BlockRegister.PRISMARINE_PEDESTAL,
            BlockRegister.BLACKSTONE_PEDESTAL,
            BlockRegister.PURPUR_BLOCK_PEDESTAL,
            BlockRegister.DEEPSLATE_PEDESTAL,
            BlockRegister.TUFF_PEDESTAL,
            BlockRegister.PACKED_MUD_PEDESTAL,
            BlockRegister.SANDSTONE_PEDESTAL,
            BlockRegister.RED_SANDSTONE_PEDESTAL,
            BlockRegister.QUARTZ_BLOCK_PEDESTAL,
            BlockRegister.NETHER_BRICKS_PEDESTAL,
            BlockRegister.BASALT_PEDESTAL,
            BlockRegister.END_STONE_PEDESTAL,
            BlockRegister.COAL_BLOCK_PEDESTAL,
            BlockRegister.IRON_BLOCK_PEDESTAL,
            BlockRegister.GOLD_BLOCK_PEDESTAL,
            BlockRegister.REDSTONE_BLOCK_PEDESTAL,
            BlockRegister.EMERALD_BLOCK_PEDESTAL,
            BlockRegister.DIAMOND_BLOCK_PEDESTAL,
            BlockRegister.COPPER_BLOCK_PEDESTAL,
            BlockRegister.LAPIS_BLOCK_PEDESTAL,
            BlockRegister.NETHERITE_BLOCK_PEDESTAL,
            BlockRegister.OBSIDIAN_PEDESTAL,
            BlockRegister.AMETHYST_BLOCK_PEDESTAL,
            BlockRegister.DRIPSTONE_BLOCK_PEDESTAL,
            BlockRegister.BEDROCK_PEDESTAL,
            //brazier
            BlockRegister.OAK_VILLAGER_BRAZIER,
            BlockRegister.BIRCH_VILLAGER_BRAZIER,
            BlockRegister.SPRUCE_VILLAGER_BRAZIER,
            BlockRegister.JUNGLE_VILLAGER_BRAZIER,
            BlockRegister.ACACIA_VILLAGER_BRAZIER,
            BlockRegister.DARK_OAK_VILLAGER_BRAZIER,
            BlockRegister.MANGROVE_VILLAGER_BRAZIER,
            BlockRegister.CHERRY_VILLAGER_BRAZIER,
            BlockRegister.BAMBOO_VILLAGER_BRAZIER,
            BlockRegister.CRIMSON_VILLAGER_BRAZIER,
            BlockRegister.WARPED_VILLAGER_BRAZIER,
            BlockRegister.PALE_OAK_VILLAGER_BRAZIER,
            BlockRegister.STONE_VILLAGER_BRAZIER,
            BlockRegister.MOSSY_STONE_VILLAGER_BRAZIER,
            BlockRegister.ANDESITE_VILLAGER_BRAZIER,
            BlockRegister.DIORITE_VILLAGER_BRAZIER,
            BlockRegister.GRANITE_VILLAGER_BRAZIER,
            BlockRegister.PRISMARINE_VILLAGER_BRAZIER,
            BlockRegister.BLACKSTONE_VILLAGER_BRAZIER,
            BlockRegister.PURPUR_BLOCK_VILLAGER_BRAZIER,
            BlockRegister.DEEPSLATE_VILLAGER_BRAZIER,
            BlockRegister.TUFF_VILLAGER_BRAZIER,
            BlockRegister.PACKED_MUD_VILLAGER_BRAZIER,
            BlockRegister.SANDSTONE_VILLAGER_BRAZIER,
            BlockRegister.RED_SANDSTONE_VILLAGER_BRAZIER,
            BlockRegister.QUARTZ_BLOCK_VILLAGER_BRAZIER,
            BlockRegister.NETHER_BRICKS_VILLAGER_BRAZIER,
            BlockRegister.BASALT_VILLAGER_BRAZIER,
            BlockRegister.END_STONE_VILLAGER_BRAZIER,
            BlockRegister.COAL_BLOCK_VILLAGER_BRAZIER,
            BlockRegister.IRON_BLOCK_VILLAGER_BRAZIER,
            BlockRegister.GOLD_BLOCK_VILLAGER_BRAZIER,
            BlockRegister.REDSTONE_BLOCK_VILLAGER_BRAZIER,
            BlockRegister.EMERALD_BLOCK_VILLAGER_BRAZIER,
            BlockRegister.DIAMOND_BLOCK_VILLAGER_BRAZIER,
            BlockRegister.COPPER_BLOCK_VILLAGER_BRAZIER,
            BlockRegister.LAPIS_BLOCK_VILLAGER_BRAZIER,
            BlockRegister.NETHERITE_BLOCK_VILLAGER_BRAZIER,
            BlockRegister.OBSIDIAN_VILLAGER_BRAZIER,
            BlockRegister.AMETHYST_BLOCK_VILLAGER_BRAZIER,
            BlockRegister.DRIPSTONE_BLOCK_VILLAGER_BRAZIER,
            BlockRegister.BEDROCK_VILLAGER_BRAZIER,
            //table
            BlockRegister.OAK_VILLAGER_TABLE,
            BlockRegister.BIRCH_VILLAGER_TABLE,
            BlockRegister.SPRUCE_VILLAGER_TABLE,
            BlockRegister.JUNGLE_VILLAGER_TABLE,
            BlockRegister.ACACIA_VILLAGER_TABLE,
            BlockRegister.DARK_OAK_VILLAGER_TABLE,
            BlockRegister.MANGROVE_VILLAGER_TABLE,
            BlockRegister.CHERRY_VILLAGER_TABLE,
            BlockRegister.BAMBOO_VILLAGER_TABLE,
            BlockRegister.CRIMSON_VILLAGER_TABLE,
            BlockRegister.WARPED_VILLAGER_TABLE,
            BlockRegister.PALE_OAK_VILLAGER_TABLE,
            BlockRegister.STONE_VILLAGER_TABLE,
            BlockRegister.MOSSY_STONE_VILLAGER_TABLE,
            BlockRegister.ANDESITE_VILLAGER_TABLE,
            BlockRegister.DIORITE_VILLAGER_TABLE,
            BlockRegister.GRANITE_VILLAGER_TABLE,
            BlockRegister.PRISMARINE_VILLAGER_TABLE,
            BlockRegister.BLACKSTONE_VILLAGER_TABLE,
            BlockRegister.PURPUR_BLOCK_VILLAGER_TABLE,
            BlockRegister.DEEPSLATE_VILLAGER_TABLE,
            BlockRegister.TUFF_VILLAGER_TABLE,
            BlockRegister.PACKED_MUD_VILLAGER_TABLE,
            BlockRegister.SANDSTONE_VILLAGER_TABLE,
            BlockRegister.RED_SANDSTONE_VILLAGER_TABLE,
            BlockRegister.QUARTZ_BLOCK_VILLAGER_TABLE,
            BlockRegister.NETHER_BRICKS_VILLAGER_TABLE,
            BlockRegister.BASALT_VILLAGER_TABLE,
            BlockRegister.END_STONE_VILLAGER_TABLE,
            BlockRegister.COAL_BLOCK_VILLAGER_TABLE,
            BlockRegister.IRON_BLOCK_VILLAGER_TABLE,
            BlockRegister.GOLD_BLOCK_VILLAGER_TABLE,
            BlockRegister.REDSTONE_BLOCK_VILLAGER_TABLE,
            BlockRegister.EMERALD_BLOCK_VILLAGER_TABLE,
            BlockRegister.DIAMOND_BLOCK_VILLAGER_TABLE,
            BlockRegister.COPPER_BLOCK_VILLAGER_TABLE,
            BlockRegister.LAPIS_BLOCK_VILLAGER_TABLE,
            BlockRegister.NETHERITE_BLOCK_VILLAGER_TABLE,
            BlockRegister.OBSIDIAN_VILLAGER_TABLE,
            BlockRegister.AMETHYST_BLOCK_VILLAGER_TABLE,
            BlockRegister.DRIPSTONE_BLOCK_VILLAGER_TABLE,
            BlockRegister.BEDROCK_VILLAGER_TABLE,
            //chair
            BlockRegister.OAK_VILLAGER_CHAIR,
            BlockRegister.BIRCH_VILLAGER_CHAIR,
            BlockRegister.SPRUCE_VILLAGER_CHAIR,
            BlockRegister.JUNGLE_VILLAGER_CHAIR,
            BlockRegister.ACACIA_VILLAGER_CHAIR,
            BlockRegister.DARK_OAK_VILLAGER_CHAIR,
            BlockRegister.MANGROVE_VILLAGER_CHAIR,
            BlockRegister.CHERRY_VILLAGER_CHAIR,
            BlockRegister.BAMBOO_VILLAGER_CHAIR,
            BlockRegister.CRIMSON_VILLAGER_CHAIR,
            BlockRegister.WARPED_VILLAGER_CHAIR,
            BlockRegister.PALE_OAK_VILLAGER_CHAIR,
            BlockRegister.STONE_VILLAGER_CHAIR,
            BlockRegister.MOSSY_STONE_VILLAGER_CHAIR,
            BlockRegister.ANDESITE_VILLAGER_CHAIR,
            BlockRegister.DIORITE_VILLAGER_CHAIR,
            BlockRegister.GRANITE_VILLAGER_CHAIR,
            BlockRegister.PRISMARINE_VILLAGER_CHAIR,
            BlockRegister.BLACKSTONE_VILLAGER_CHAIR,
            BlockRegister.PURPUR_BLOCK_VILLAGER_CHAIR,
            BlockRegister.DEEPSLATE_VILLAGER_CHAIR,
            BlockRegister.TUFF_VILLAGER_CHAIR,
            BlockRegister.PACKED_MUD_VILLAGER_CHAIR,
            BlockRegister.SANDSTONE_VILLAGER_CHAIR,
            BlockRegister.RED_SANDSTONE_VILLAGER_CHAIR,
            BlockRegister.QUARTZ_BLOCK_VILLAGER_CHAIR,
            BlockRegister.NETHER_BRICKS_VILLAGER_CHAIR,
            BlockRegister.BASALT_VILLAGER_CHAIR,
            BlockRegister.END_STONE_VILLAGER_CHAIR,
            BlockRegister.COAL_BLOCK_VILLAGER_CHAIR,
            BlockRegister.IRON_BLOCK_VILLAGER_CHAIR,
            BlockRegister.GOLD_BLOCK_VILLAGER_CHAIR,
            BlockRegister.REDSTONE_BLOCK_VILLAGER_CHAIR,
            BlockRegister.EMERALD_BLOCK_VILLAGER_CHAIR,
            BlockRegister.DIAMOND_BLOCK_VILLAGER_CHAIR,
            BlockRegister.COPPER_BLOCK_VILLAGER_CHAIR,
            BlockRegister.LAPIS_BLOCK_VILLAGER_CHAIR,
            BlockRegister.NETHERITE_BLOCK_VILLAGER_CHAIR,
            BlockRegister.OBSIDIAN_VILLAGER_CHAIR,
            BlockRegister.AMETHYST_BLOCK_VILLAGER_CHAIR,
            BlockRegister.DRIPSTONE_BLOCK_VILLAGER_CHAIR,
            BlockRegister.BEDROCK_VILLAGER_CHAIR,
            //throne chair
            BlockRegister.OAK_VILLAGER_THRONE_CHAIR,
            BlockRegister.BIRCH_VILLAGER_THRONE_CHAIR,
            BlockRegister.SPRUCE_VILLAGER_THRONE_CHAIR,
            BlockRegister.JUNGLE_VILLAGER_THRONE_CHAIR,
            BlockRegister.ACACIA_VILLAGER_THRONE_CHAIR,
            BlockRegister.DARK_OAK_VILLAGER_THRONE_CHAIR,
            BlockRegister.MANGROVE_VILLAGER_THRONE_CHAIR,
            BlockRegister.CHERRY_VILLAGER_THRONE_CHAIR,
            BlockRegister.BAMBOO_VILLAGER_THRONE_CHAIR,
            BlockRegister.CRIMSON_VILLAGER_THRONE_CHAIR,
            BlockRegister.WARPED_VILLAGER_THRONE_CHAIR,
            BlockRegister.PALE_OAK_VILLAGER_THRONE_CHAIR,
            BlockRegister.STONE_VILLAGER_THRONE_CHAIR,
            BlockRegister.MOSSY_STONE_VILLAGER_THRONE_CHAIR,
            BlockRegister.ANDESITE_VILLAGER_THRONE_CHAIR,
            BlockRegister.DIORITE_VILLAGER_THRONE_CHAIR,
            BlockRegister.GRANITE_VILLAGER_THRONE_CHAIR,
            BlockRegister.PRISMARINE_VILLAGER_THRONE_CHAIR,
            BlockRegister.BLACKSTONE_VILLAGER_THRONE_CHAIR,
            BlockRegister.PURPUR_BLOCK_VILLAGER_THRONE_CHAIR,
            BlockRegister.DEEPSLATE_VILLAGER_THRONE_CHAIR,
            BlockRegister.TUFF_VILLAGER_THRONE_CHAIR,
            BlockRegister.PACKED_MUD_VILLAGER_THRONE_CHAIR,
            BlockRegister.SANDSTONE_VILLAGER_THRONE_CHAIR,
            BlockRegister.RED_SANDSTONE_VILLAGER_THRONE_CHAIR,
            BlockRegister.QUARTZ_BLOCK_VILLAGER_THRONE_CHAIR,
            BlockRegister.NETHER_BRICKS_VILLAGER_THRONE_CHAIR,
            BlockRegister.BASALT_VILLAGER_THRONE_CHAIR,
            BlockRegister.END_STONE_VILLAGER_THRONE_CHAIR,
            BlockRegister.COAL_BLOCK_VILLAGER_THRONE_CHAIR,
            BlockRegister.IRON_BLOCK_VILLAGER_THRONE_CHAIR,
            BlockRegister.GOLD_BLOCK_VILLAGER_THRONE_CHAIR,
            BlockRegister.REDSTONE_BLOCK_VILLAGER_THRONE_CHAIR,
            BlockRegister.EMERALD_BLOCK_VILLAGER_THRONE_CHAIR,
            BlockRegister.DIAMOND_BLOCK_VILLAGER_THRONE_CHAIR,
            BlockRegister.COPPER_BLOCK_VILLAGER_THRONE_CHAIR,
            BlockRegister.LAPIS_BLOCK_VILLAGER_THRONE_CHAIR,
            BlockRegister.NETHERITE_BLOCK_VILLAGER_THRONE_CHAIR,
            BlockRegister.OBSIDIAN_VILLAGER_THRONE_CHAIR,
            BlockRegister.AMETHYST_BLOCK_VILLAGER_THRONE_CHAIR,
            BlockRegister.DRIPSTONE_BLOCK_VILLAGER_THRONE_CHAIR,
            BlockRegister.BEDROCK_VILLAGER_THRONE_CHAIR,
            //drawer
            BlockRegister.OAK_VILLAGER_DRAWER,
            BlockRegister.BIRCH_VILLAGER_DRAWER,
            BlockRegister.SPRUCE_VILLAGER_DRAWER,
            BlockRegister.JUNGLE_VILLAGER_DRAWER,
            BlockRegister.ACACIA_VILLAGER_DRAWER,
            BlockRegister.DARK_OAK_VILLAGER_DRAWER,
            BlockRegister.MANGROVE_VILLAGER_DRAWER,
            BlockRegister.CHERRY_VILLAGER_DRAWER,
            BlockRegister.BAMBOO_VILLAGER_DRAWER,
            BlockRegister.CRIMSON_VILLAGER_DRAWER,
            BlockRegister.WARPED_VILLAGER_DRAWER,
            BlockRegister.PALE_OAK_VILLAGER_DRAWER,
            BlockRegister.STONE_VILLAGER_DRAWER,
            BlockRegister.MOSSY_STONE_VILLAGER_DRAWER,
            BlockRegister.ANDESITE_VILLAGER_DRAWER,
            BlockRegister.DIORITE_VILLAGER_DRAWER,
            BlockRegister.GRANITE_VILLAGER_DRAWER,
            BlockRegister.PRISMARINE_VILLAGER_DRAWER,
            BlockRegister.BLACKSTONE_VILLAGER_DRAWER,
            BlockRegister.PURPUR_BLOCK_VILLAGER_DRAWER,
            BlockRegister.DEEPSLATE_VILLAGER_DRAWER,
            BlockRegister.TUFF_VILLAGER_DRAWER,
            BlockRegister.PACKED_MUD_VILLAGER_DRAWER,
            BlockRegister.SANDSTONE_VILLAGER_DRAWER,
            BlockRegister.RED_SANDSTONE_VILLAGER_DRAWER,
            BlockRegister.QUARTZ_BLOCK_VILLAGER_DRAWER,
            BlockRegister.NETHER_BRICKS_VILLAGER_DRAWER,
            BlockRegister.BASALT_VILLAGER_DRAWER,
            BlockRegister.END_STONE_VILLAGER_DRAWER,
            BlockRegister.COAL_BLOCK_VILLAGER_DRAWER,
            BlockRegister.IRON_BLOCK_VILLAGER_DRAWER,
            BlockRegister.GOLD_BLOCK_VILLAGER_DRAWER,
            BlockRegister.REDSTONE_BLOCK_VILLAGER_DRAWER,
            BlockRegister.EMERALD_BLOCK_VILLAGER_DRAWER,
            BlockRegister.DIAMOND_BLOCK_VILLAGER_DRAWER,
            BlockRegister.COPPER_BLOCK_VILLAGER_DRAWER,
            BlockRegister.LAPIS_BLOCK_VILLAGER_DRAWER,
            BlockRegister.NETHERITE_BLOCK_VILLAGER_DRAWER,
            BlockRegister.OBSIDIAN_VILLAGER_DRAWER,
            BlockRegister.AMETHYST_BLOCK_VILLAGER_DRAWER,
            BlockRegister.DRIPSTONE_BLOCK_VILLAGER_DRAWER,
            BlockRegister.BEDROCK_VILLAGER_DRAWER,
            //shelf
                //standing
            BlockRegister.OAK_STANDING_VILLAGER_SHELF,
            BlockRegister.BIRCH_STANDING_VILLAGER_SHELF,
            BlockRegister.SPRUCE_STANDING_VILLAGER_SHELF,
            BlockRegister.JUNGLE_STANDING_VILLAGER_SHELF,
            BlockRegister.ACACIA_STANDING_VILLAGER_SHELF,
            BlockRegister.DARK_OAK_STANDING_VILLAGER_SHELF,
            BlockRegister.MANGROVE_STANDING_VILLAGER_SHELF,
            BlockRegister.CHERRY_STANDING_VILLAGER_SHELF,
            BlockRegister.BAMBOO_STANDING_VILLAGER_SHELF,
            BlockRegister.CRIMSON_STANDING_VILLAGER_SHELF,
            BlockRegister.WARPED_STANDING_VILLAGER_SHELF,
            BlockRegister.PALE_OAK_STANDING_VILLAGER_SHELF,
            BlockRegister.STONE_STANDING_VILLAGER_SHELF,
            BlockRegister.MOSSY_STONE_STANDING_VILLAGER_SHELF,
            BlockRegister.ANDESITE_STANDING_VILLAGER_SHELF,
            BlockRegister.DIORITE_STANDING_VILLAGER_SHELF,
            BlockRegister.GRANITE_STANDING_VILLAGER_SHELF,
            BlockRegister.PRISMARINE_STANDING_VILLAGER_SHELF,
            BlockRegister.BLACKSTONE_STANDING_VILLAGER_SHELF,
            BlockRegister.PURPUR_BLOCK_STANDING_VILLAGER_SHELF,
            BlockRegister.DEEPSLATE_STANDING_VILLAGER_SHELF,
            BlockRegister.TUFF_STANDING_VILLAGER_SHELF,
            BlockRegister.PACKED_MUD_STANDING_VILLAGER_SHELF,
            BlockRegister.SANDSTONE_STANDING_VILLAGER_SHELF,
            BlockRegister.RED_SANDSTONE_STANDING_VILLAGER_SHELF,
            BlockRegister.QUARTZ_BLOCK_STANDING_VILLAGER_SHELF,
            BlockRegister.NETHER_BRICKS_STANDING_VILLAGER_SHELF,
            BlockRegister.BASALT_STANDING_VILLAGER_SHELF,
            BlockRegister.END_STONE_STANDING_VILLAGER_SHELF,
            BlockRegister.COAL_BLOCK_STANDING_VILLAGER_SHELF,
            BlockRegister.IRON_BLOCK_STANDING_VILLAGER_SHELF,
            BlockRegister.GOLD_BLOCK_STANDING_VILLAGER_SHELF,
            BlockRegister.REDSTONE_BLOCK_STANDING_VILLAGER_SHELF,
            BlockRegister.EMERALD_BLOCK_STANDING_VILLAGER_SHELF,
            BlockRegister.DIAMOND_BLOCK_STANDING_VILLAGER_SHELF,
            BlockRegister.COPPER_BLOCK_STANDING_VILLAGER_SHELF,
            BlockRegister.LAPIS_BLOCK_STANDING_VILLAGER_SHELF,
            BlockRegister.NETHERITE_BLOCK_STANDING_VILLAGER_SHELF,
            BlockRegister.OBSIDIAN_STANDING_VILLAGER_SHELF,
            BlockRegister.AMETHYST_BLOCK_STANDING_VILLAGER_SHELF,
            BlockRegister.DRIPSTONE_BLOCK_STANDING_VILLAGER_SHELF,
            BlockRegister.BEDROCK_STANDING_VILLAGER_SHELF,
                //wall
            BlockRegister.OAK_WALL_VILLAGER_SHELF,
            BlockRegister.BIRCH_WALL_VILLAGER_SHELF,
            BlockRegister.SPRUCE_WALL_VILLAGER_SHELF,
            BlockRegister.JUNGLE_WALL_VILLAGER_SHELF,
            BlockRegister.ACACIA_WALL_VILLAGER_SHELF,
            BlockRegister.DARK_OAK_WALL_VILLAGER_SHELF,
            BlockRegister.MANGROVE_WALL_VILLAGER_SHELF,
            BlockRegister.CHERRY_WALL_VILLAGER_SHELF,
            BlockRegister.BAMBOO_WALL_VILLAGER_SHELF,
            BlockRegister.CRIMSON_WALL_VILLAGER_SHELF,
            BlockRegister.WARPED_WALL_VILLAGER_SHELF,
            BlockRegister.PALE_OAK_WALL_VILLAGER_SHELF,
            BlockRegister.STONE_WALL_VILLAGER_SHELF,
            BlockRegister.MOSSY_STONE_WALL_VILLAGER_SHELF,
            BlockRegister.ANDESITE_WALL_VILLAGER_SHELF,
            BlockRegister.DIORITE_WALL_VILLAGER_SHELF,
            BlockRegister.GRANITE_WALL_VILLAGER_SHELF,
            BlockRegister.PRISMARINE_WALL_VILLAGER_SHELF,
            BlockRegister.BLACKSTONE_WALL_VILLAGER_SHELF,
            BlockRegister.PURPUR_BLOCK_WALL_VILLAGER_SHELF,
            BlockRegister.DEEPSLATE_WALL_VILLAGER_SHELF,
            BlockRegister.TUFF_WALL_VILLAGER_SHELF,
            BlockRegister.PACKED_MUD_WALL_VILLAGER_SHELF,
            BlockRegister.SANDSTONE_WALL_VILLAGER_SHELF,
            BlockRegister.RED_SANDSTONE_WALL_VILLAGER_SHELF,
            BlockRegister.QUARTZ_BLOCK_WALL_VILLAGER_SHELF,
            BlockRegister.NETHER_BRICKS_WALL_VILLAGER_SHELF,
            BlockRegister.BASALT_WALL_VILLAGER_SHELF,
            BlockRegister.END_STONE_WALL_VILLAGER_SHELF,
            BlockRegister.COAL_BLOCK_WALL_VILLAGER_SHELF,
            BlockRegister.IRON_BLOCK_WALL_VILLAGER_SHELF,
            BlockRegister.GOLD_BLOCK_WALL_VILLAGER_SHELF,
            BlockRegister.REDSTONE_BLOCK_WALL_VILLAGER_SHELF,
            BlockRegister.EMERALD_BLOCK_WALL_VILLAGER_SHELF,
            BlockRegister.DIAMOND_BLOCK_WALL_VILLAGER_SHELF,
            BlockRegister.COPPER_BLOCK_WALL_VILLAGER_SHELF,
            BlockRegister.LAPIS_BLOCK_WALL_VILLAGER_SHELF,
            BlockRegister.NETHERITE_BLOCK_WALL_VILLAGER_SHELF,
            BlockRegister.OBSIDIAN_WALL_VILLAGER_SHELF,
            BlockRegister.AMETHYST_BLOCK_WALL_VILLAGER_SHELF,
            BlockRegister.DRIPSTONE_BLOCK_WALL_VILLAGER_SHELF,
            BlockRegister.BEDROCK_WALL_VILLAGER_SHELF,
            //villager bench
            BlockRegister.OAK_VILLAGER_BENCH,
            BlockRegister.BIRCH_VILLAGER_BENCH,
            BlockRegister.SPRUCE_VILLAGER_BENCH,
            BlockRegister.JUNGLE_VILLAGER_BENCH,
            BlockRegister.ACACIA_VILLAGER_BENCH,
            BlockRegister.DARK_OAK_VILLAGER_BENCH,
            BlockRegister.MANGROVE_VILLAGER_BENCH,
            BlockRegister.CHERRY_VILLAGER_BENCH,
            BlockRegister.BAMBOO_VILLAGER_BENCH,
            BlockRegister.CRIMSON_VILLAGER_BENCH,
            BlockRegister.WARPED_VILLAGER_BENCH,
            BlockRegister.PALE_OAK_VILLAGER_BENCH,
            BlockRegister.STONE_VILLAGER_BENCH,
            BlockRegister.MOSSY_STONE_VILLAGER_BENCH,
            BlockRegister.ANDESITE_VILLAGER_BENCH,
            BlockRegister.DIORITE_VILLAGER_BENCH,
            BlockRegister.GRANITE_VILLAGER_BENCH,
            BlockRegister.PRISMARINE_VILLAGER_BENCH,
            BlockRegister.BLACKSTONE_VILLAGER_BENCH,
            BlockRegister.PURPUR_BLOCK_VILLAGER_BENCH,
            BlockRegister.DEEPSLATE_VILLAGER_BENCH,
            BlockRegister.TUFF_VILLAGER_BENCH,
            BlockRegister.PACKED_MUD_VILLAGER_BENCH,
            BlockRegister.SANDSTONE_VILLAGER_BENCH,
            BlockRegister.RED_SANDSTONE_VILLAGER_BENCH,
            BlockRegister.QUARTZ_BLOCK_VILLAGER_BENCH,
            BlockRegister.NETHER_BRICKS_VILLAGER_BENCH,
            BlockRegister.BASALT_VILLAGER_BENCH,
            BlockRegister.END_STONE_VILLAGER_BENCH,
            BlockRegister.COAL_BLOCK_VILLAGER_BENCH,
            BlockRegister.IRON_BLOCK_VILLAGER_BENCH,
            BlockRegister.GOLD_BLOCK_VILLAGER_BENCH,
            BlockRegister.REDSTONE_BLOCK_VILLAGER_BENCH,
            BlockRegister.EMERALD_BLOCK_VILLAGER_BENCH,
            BlockRegister.DIAMOND_BLOCK_VILLAGER_BENCH,
            BlockRegister.COPPER_BLOCK_VILLAGER_BENCH,
            BlockRegister.LAPIS_BLOCK_VILLAGER_BENCH,
            BlockRegister.NETHERITE_BLOCK_VILLAGER_BENCH,
            BlockRegister.OBSIDIAN_VILLAGER_BENCH,
            BlockRegister.AMETHYST_BLOCK_VILLAGER_BENCH,
            BlockRegister.DRIPSTONE_BLOCK_VILLAGER_BENCH,
            BlockRegister.BEDROCK_VILLAGER_BENCH,
            //villager couch
            BlockRegister.OAK_VILLAGER_COUCH,
            BlockRegister.BIRCH_VILLAGER_COUCH,
            BlockRegister.SPRUCE_VILLAGER_COUCH,
            BlockRegister.JUNGLE_VILLAGER_COUCH,
            BlockRegister.ACACIA_VILLAGER_COUCH,
            BlockRegister.DARK_OAK_VILLAGER_COUCH,
            BlockRegister.MANGROVE_VILLAGER_COUCH,
            BlockRegister.CHERRY_VILLAGER_COUCH,
            BlockRegister.BAMBOO_VILLAGER_COUCH,
            BlockRegister.CRIMSON_VILLAGER_COUCH,
            BlockRegister.WARPED_VILLAGER_COUCH,
            BlockRegister.PALE_OAK_VILLAGER_COUCH,
            BlockRegister.STONE_VILLAGER_COUCH,
            BlockRegister.MOSSY_STONE_VILLAGER_COUCH,
            BlockRegister.ANDESITE_VILLAGER_COUCH,
            BlockRegister.DIORITE_VILLAGER_COUCH,
            BlockRegister.GRANITE_VILLAGER_COUCH,
            BlockRegister.PRISMARINE_VILLAGER_COUCH,
            BlockRegister.BLACKSTONE_VILLAGER_COUCH,
            BlockRegister.PURPUR_BLOCK_VILLAGER_COUCH,
            BlockRegister.DEEPSLATE_VILLAGER_COUCH,
            BlockRegister.TUFF_VILLAGER_COUCH,
            BlockRegister.PACKED_MUD_VILLAGER_COUCH,
            BlockRegister.SANDSTONE_VILLAGER_COUCH,
            BlockRegister.RED_SANDSTONE_VILLAGER_COUCH,
            BlockRegister.QUARTZ_BLOCK_VILLAGER_COUCH,
            BlockRegister.NETHER_BRICKS_VILLAGER_COUCH,
            BlockRegister.BASALT_VILLAGER_COUCH,
            BlockRegister.END_STONE_VILLAGER_COUCH,
            BlockRegister.COAL_BLOCK_VILLAGER_COUCH,
            BlockRegister.IRON_BLOCK_VILLAGER_COUCH,
            BlockRegister.GOLD_BLOCK_VILLAGER_COUCH,
            BlockRegister.REDSTONE_BLOCK_VILLAGER_COUCH,
            BlockRegister.EMERALD_BLOCK_VILLAGER_COUCH,
            BlockRegister.DIAMOND_BLOCK_VILLAGER_COUCH,
            BlockRegister.COPPER_BLOCK_VILLAGER_COUCH,
            BlockRegister.LAPIS_BLOCK_VILLAGER_COUCH,
            BlockRegister.NETHERITE_BLOCK_VILLAGER_COUCH,
            BlockRegister.OBSIDIAN_VILLAGER_COUCH,
            BlockRegister.AMETHYST_BLOCK_VILLAGER_COUCH,
            BlockRegister.DRIPSTONE_BLOCK_VILLAGER_COUCH,
            BlockRegister.BEDROCK_VILLAGER_COUCH,
            //flower and pot
            BlockRegister.RUINS_FLOWER,
            BlockRegister.POTTED_RUINS_FLOWER,
            BlockRegister.CIVILIZATIONS_FLOWER,
            BlockRegister.POTTED_CIVILIZATIONS_FLOWER,
            BlockRegister.CURIOSITY_FLOWER,
            BlockRegister.POTTED_CURIOSITY_FLOWER,
            //dead bush and pot
            BlockRegister.DEAD_RUINS_FLOWER,
            BlockRegister.POTTED_DEAD_RUINS_FLOWER,
            //vegetation
                //misc
            BlockRegister.FLOWERED_CACTUS_BLOCK,
            BlockRegister.CACTUS_FLOWER_BLOCK,
            BlockRegister.SKY_SPEARS,
            BlockRegister.DEAD_TALL_BUSH
            );

    public static List<DeferredItem<Item>> ALL_ITEMS = Arrays.asList(
            //creative tab icon item
            ItemRegister.VILLAGER_ICON,
            // item villager shelf
            ItemRegister.OAK_VILLAGER_SHELF,
            ItemRegister.BIRCH_VILLAGER_SHELF,
            ItemRegister.SPRUCE_VILLAGER_SHELF,
            ItemRegister.JUNGLE_VILLAGER_SHELF,
            ItemRegister.ACACIA_VILLAGER_SHELF,
            ItemRegister.DARK_OAK_VILLAGER_SHELF,
            ItemRegister.MANGROVE_VILLAGER_SHELF,
            ItemRegister.CHERRY_VILLAGER_SHELF,
            ItemRegister.BAMBOO_VILLAGER_SHELF,
            ItemRegister.CRIMSON_VILLAGER_SHELF,
            ItemRegister.WARPED_VILLAGER_SHELF,
            ItemRegister.PALE_OAK_VILLAGER_SHELF,
            ItemRegister.STONE_VILLAGER_SHELF,
            ItemRegister.MOSSY_STONE_VILLAGER_SHELF,
            ItemRegister.ANDESITE_VILLAGER_SHELF,
            ItemRegister.DIORITE_VILLAGER_SHELF,
            ItemRegister.GRANITE_VILLAGER_SHELF,
            ItemRegister.PRISMARINE_VILLAGER_SHELF,
            ItemRegister.BLACKSTONE_VILLAGER_SHELF,
            ItemRegister.PURPUR_BLOCK_VILLAGER_SHELF,
            ItemRegister.DEEPSLATE_VILLAGER_SHELF,
            ItemRegister.TUFF_VILLAGER_SHELF,
            ItemRegister.PACKED_MUD_VILLAGER_SHELF,
            ItemRegister.SANDSTONE_VILLAGER_SHELF,
            ItemRegister.RED_SANDSTONE_VILLAGER_SHELF,
            ItemRegister.QUARTZ_BLOCK_VILLAGER_SHELF,
            ItemRegister.NETHER_BRICKS_VILLAGER_SHELF,
            ItemRegister.BASALT_VILLAGER_SHELF,
            ItemRegister.END_STONE_VILLAGER_SHELF,
            ItemRegister.COAL_BLOCK_VILLAGER_SHELF,
            ItemRegister.IRON_BLOCK_VILLAGER_SHELF,
            ItemRegister.GOLD_BLOCK_VILLAGER_SHELF,
            ItemRegister.REDSTONE_BLOCK_VILLAGER_SHELF,
            ItemRegister.EMERALD_BLOCK_VILLAGER_SHELF,
            ItemRegister.DIAMOND_BLOCK_VILLAGER_SHELF,
            ItemRegister.COPPER_BLOCK_VILLAGER_SHELF,
            ItemRegister.LAPIS_BLOCK_VILLAGER_SHELF,
            ItemRegister.NETHERITE_BLOCK_VILLAGER_SHELF,
            ItemRegister.OBSIDIAN_VILLAGER_SHELF,
            ItemRegister.AMETHYST_BLOCK_VILLAGER_SHELF,
            ItemRegister.DRIPSTONE_BLOCK_VILLAGER_SHELF,
            ItemRegister.BEDROCK_VILLAGER_SHELF,
            //villager'singing stone
            ItemRegister.LIBERTY_VILLAGER_SINGING_STONE,
            ItemRegister.DIGGY_VILLAGER_SINGING_STONE,
            ItemRegister.MADNESS_VILLAGER_SINGING_STONE
    );
}
