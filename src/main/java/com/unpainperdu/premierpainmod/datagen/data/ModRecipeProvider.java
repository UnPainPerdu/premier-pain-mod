package com.unpainperdu.premierpainmod.datagen.data;

import com.unpainperdu.premierpainmod.level.world.item.crafting.builders.VillagerWorkshopRecipeBuilder;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.text.html.HTML;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    private static RecipeOutput recipeOutput;
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput)
    {
        ModRecipeProvider.recipeOutput = pRecipeOutput;
        //item
        //block
            // Villager workshop
        villagerWorkshopRecipeBuilder(BlockRegister.VILLAGER_WORKSHOP);
            //statue
        buildingBlocksReciperBluilder(BlockRegister.OAK_VILLAGER_STATUE,Blocks.OAK_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.BIRCH_VILLAGER_STATUE,Blocks.BIRCH_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.SPRUCE_VILLAGER_STATUE,Blocks.SPRUCE_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.JUNGLE_VILLAGER_STATUE,Blocks.JUNGLE_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.ACACIA_VILLAGER_STATUE,Blocks.ACACIA_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.DARK_OAK_VILLAGER_STATUE,Blocks.DARK_OAK_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.MANGROVE_VILLAGER_STATUE,Blocks.MANGROVE_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.CHERRY_VILLAGER_STATUE,Blocks.CHERRY_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.CRIMSON_VILLAGER_STATUE,Blocks.CRIMSON_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.WARPED_VILLAGER_STATUE,Blocks.WARPED_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.BAMBOO_VILLAGER_STATUE,Blocks.BAMBOO_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.STONE_VILLAGER_STATUE,Blocks.COBBLESTONE);
        buildingBlocksReciperBluilder(BlockRegister.MOSSY_STONE_VILLAGER_STATUE,Blocks.MOSSY_COBBLESTONE);
        buildingBlocksReciperBluilder(BlockRegister.ANDESITE_VILLAGER_STATUE,Blocks.ANDESITE);
        buildingBlocksReciperBluilder(BlockRegister.DIORITE_VILLAGER_STATUE,Blocks.DIORITE);
        buildingBlocksReciperBluilder(BlockRegister.GRANITE_VILLAGER_STATUE,Blocks.GRANITE);
        buildingBlocksReciperBluilder(BlockRegister.PRISMARINE_VILLAGER_STATUE,Blocks.PRISMARINE);
        buildingBlocksReciperBluilder(BlockRegister.BLACKSTONE_VILLAGER_STATUE,Blocks.BLACKSTONE);
        buildingBlocksReciperBluilder(BlockRegister.PURPUR_BLOCK_VILLAGER_STATUE,Blocks.PURPUR_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.DEEPSLATE_VILLAGER_STATUE,Blocks.COBBLED_DEEPSLATE);
        buildingBlocksReciperBluilder(BlockRegister.TUFF_VILLAGER_STATUE,Blocks.TUFF);
        buildingBlocksReciperBluilder(BlockRegister.PACKED_MUD_VILLAGER_STATUE,Blocks.PACKED_MUD);
        buildingBlocksReciperBluilder(BlockRegister.SANDSTONE_VILLAGER_STATUE,Blocks.SANDSTONE);
        buildingBlocksReciperBluilder(BlockRegister.RED_SANDSTONE_VILLAGER_STATUE,Blocks.RED_SANDSTONE);
        buildingBlocksReciperBluilder(BlockRegister.QUARTZ_BLOCK_VILLAGER_STATUE,Blocks.QUARTZ_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.NETHER_BRICKS_VILLAGER_STATUE,Blocks.NETHER_BRICKS);
        buildingBlocksReciperBluilder(BlockRegister.BASALT_VILLAGER_STATUE,Blocks.BASALT);
        buildingBlocksReciperBluilder(BlockRegister.END_STONE_VILLAGER_STATUE,Blocks.END_STONE);
        buildingBlocksReciperBluilder(BlockRegister.COAL_BLOCK_VILLAGER_STATUE,Blocks.COAL_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.IRON_BLOCK_VILLAGER_STATUE,Blocks.IRON_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.GOLD_BLOCK_VILLAGER_STATUE,Blocks.GOLD_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.REDSTONE_BLOCK_VILLAGER_STATUE,Blocks.REDSTONE_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.EMERALD_BLOCK_VILLAGER_STATUE,Blocks.EMERALD_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.DIAMOND_BLOCK_VILLAGER_STATUE,Blocks.DIAMOND_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.COPPER_BLOCK_VILLAGER_STATUE,Blocks.COPPER_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.LAPIS_BLOCK_VILLAGER_STATUE,Blocks.LAPIS_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.NETHERITE_BLOCK_VILLAGER_STATUE,Blocks.NETHERITE_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.OBSIDIAN_VILLAGER_STATUE,Blocks.OBSIDIAN);
        buildingBlocksReciperBluilder(BlockRegister.AMETHYST_BLOCK_VILLAGER_STATUE,Blocks.AMETHYST_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.DRIPSTONE_BLOCK_VILLAGER_STATUE,Blocks.DRIPSTONE_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.BEDROCK_VILLAGER_STATUE,Blocks.BEDROCK);
            //pedestal
        buildingBlocksReciperBluilder(BlockRegister.OAK_PEDESTAL,Blocks.OAK_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.BIRCH_PEDESTAL,Blocks.BIRCH_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.SPRUCE_PEDESTAL,Blocks.SPRUCE_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.JUNGLE_PEDESTAL,Blocks.JUNGLE_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.ACACIA_PEDESTAL,Blocks.ACACIA_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.DARK_OAK_PEDESTAL,Blocks.DARK_OAK_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.MANGROVE_PEDESTAL,Blocks.MANGROVE_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.CHERRY_PEDESTAL,Blocks.CHERRY_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.CRIMSON_PEDESTAL,Blocks.CRIMSON_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.WARPED_PEDESTAL,Blocks.WARPED_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.BAMBOO_PEDESTAL,Blocks.BAMBOO_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.STONE_PEDESTAL,Blocks.COBBLESTONE);
        buildingBlocksReciperBluilder(BlockRegister.MOSSY_STONE_PEDESTAL,Blocks.MOSSY_COBBLESTONE);
        buildingBlocksReciperBluilder(BlockRegister.ANDESITE_PEDESTAL,Blocks.ANDESITE);
        buildingBlocksReciperBluilder(BlockRegister.DIORITE_PEDESTAL,Blocks.DIORITE);
        buildingBlocksReciperBluilder(BlockRegister.GRANITE_PEDESTAL,Blocks.GRANITE);
        buildingBlocksReciperBluilder(BlockRegister.PRISMARINE_PEDESTAL,Blocks.PRISMARINE);
        buildingBlocksReciperBluilder(BlockRegister.BLACKSTONE_PEDESTAL,Blocks.BLACKSTONE);
        buildingBlocksReciperBluilder(BlockRegister.PURPUR_BLOCK_PEDESTAL,Blocks.PURPUR_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.DEEPSLATE_PEDESTAL,Blocks.COBBLED_DEEPSLATE);
        buildingBlocksReciperBluilder(BlockRegister.TUFF_PEDESTAL,Blocks.TUFF);
        buildingBlocksReciperBluilder(BlockRegister.PACKED_MUD_PEDESTAL,Blocks.PACKED_MUD);
        buildingBlocksReciperBluilder(BlockRegister.SANDSTONE_PEDESTAL,Blocks.SANDSTONE);
        buildingBlocksReciperBluilder(BlockRegister.RED_SANDSTONE_PEDESTAL,Blocks.RED_SANDSTONE);
        buildingBlocksReciperBluilder(BlockRegister.QUARTZ_BLOCK_PEDESTAL,Blocks.QUARTZ_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.NETHER_BRICKS_PEDESTAL,Blocks.NETHER_BRICKS);
        buildingBlocksReciperBluilder(BlockRegister.BASALT_PEDESTAL,Blocks.BASALT);
        buildingBlocksReciperBluilder(BlockRegister.END_STONE_PEDESTAL,Blocks.END_STONE);
        buildingBlocksReciperBluilder(BlockRegister.COAL_BLOCK_PEDESTAL,Blocks.COAL_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.IRON_BLOCK_PEDESTAL,Blocks.IRON_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.GOLD_BLOCK_PEDESTAL,Blocks.GOLD_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.REDSTONE_BLOCK_PEDESTAL,Blocks.REDSTONE_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.EMERALD_BLOCK_PEDESTAL,Blocks.EMERALD_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.DIAMOND_BLOCK_PEDESTAL,Blocks.DIAMOND_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.COPPER_BLOCK_PEDESTAL,Blocks.COPPER_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.LAPIS_BLOCK_PEDESTAL,Blocks.LAPIS_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.NETHERITE_BLOCK_PEDESTAL,Blocks.NETHERITE_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.OBSIDIAN_PEDESTAL,Blocks.OBSIDIAN);
        buildingBlocksReciperBluilder(BlockRegister.AMETHYST_BLOCK_PEDESTAL,Blocks.AMETHYST_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.DRIPSTONE_BLOCK_PEDESTAL,Blocks.DRIPSTONE_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.BEDROCK_PEDESTAL,Blocks.BEDROCK);
            //brazier
        buildingBlocksReciperBluilder(BlockRegister.OAK_VILLAGER_BRAZIER,Blocks.OAK_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.BIRCH_VILLAGER_BRAZIER,Blocks.BIRCH_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.SPRUCE_VILLAGER_BRAZIER,Blocks.SPRUCE_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.JUNGLE_VILLAGER_BRAZIER,Blocks.JUNGLE_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.ACACIA_VILLAGER_BRAZIER,Blocks.ACACIA_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.DARK_OAK_VILLAGER_BRAZIER,Blocks.DARK_OAK_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.MANGROVE_VILLAGER_BRAZIER,Blocks.MANGROVE_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.CHERRY_VILLAGER_BRAZIER,Blocks.CHERRY_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.CRIMSON_VILLAGER_BRAZIER,Blocks.CRIMSON_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.WARPED_VILLAGER_BRAZIER,Blocks.WARPED_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.BAMBOO_VILLAGER_BRAZIER,Blocks.BAMBOO_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.STONE_VILLAGER_BRAZIER,Blocks.COBBLESTONE);
        buildingBlocksReciperBluilder(BlockRegister.MOSSY_STONE_VILLAGER_BRAZIER,Blocks.MOSSY_COBBLESTONE);
        buildingBlocksReciperBluilder(BlockRegister.ANDESITE_VILLAGER_BRAZIER,Blocks.ANDESITE);
        buildingBlocksReciperBluilder(BlockRegister.DIORITE_VILLAGER_BRAZIER,Blocks.DIORITE);
        buildingBlocksReciperBluilder(BlockRegister.GRANITE_VILLAGER_BRAZIER,Blocks.GRANITE);
        buildingBlocksReciperBluilder(BlockRegister.PRISMARINE_VILLAGER_BRAZIER,Blocks.PRISMARINE);
        buildingBlocksReciperBluilder(BlockRegister.BLACKSTONE_VILLAGER_BRAZIER,Blocks.BLACKSTONE);
        buildingBlocksReciperBluilder(BlockRegister.PURPUR_BLOCK_VILLAGER_BRAZIER,Blocks.PURPUR_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.DEEPSLATE_VILLAGER_BRAZIER,Blocks.COBBLED_DEEPSLATE);
        buildingBlocksReciperBluilder(BlockRegister.TUFF_VILLAGER_BRAZIER,Blocks.TUFF);
        buildingBlocksReciperBluilder(BlockRegister.PACKED_MUD_VILLAGER_BRAZIER,Blocks.PACKED_MUD);
        buildingBlocksReciperBluilder(BlockRegister.SANDSTONE_VILLAGER_BRAZIER,Blocks.SANDSTONE);
        buildingBlocksReciperBluilder(BlockRegister.RED_SANDSTONE_VILLAGER_BRAZIER,Blocks.RED_SANDSTONE);
        buildingBlocksReciperBluilder(BlockRegister.QUARTZ_BLOCK_VILLAGER_BRAZIER,Blocks.QUARTZ_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.NETHER_BRICKS_VILLAGER_BRAZIER,Blocks.NETHER_BRICKS);
        buildingBlocksReciperBluilder(BlockRegister.BASALT_VILLAGER_BRAZIER,Blocks.BASALT);
        buildingBlocksReciperBluilder(BlockRegister.END_STONE_VILLAGER_BRAZIER,Blocks.END_STONE);
        buildingBlocksReciperBluilder(BlockRegister.COAL_BLOCK_VILLAGER_BRAZIER,Blocks.COAL_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.IRON_BLOCK_VILLAGER_BRAZIER,Blocks.IRON_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.GOLD_BLOCK_VILLAGER_BRAZIER,Blocks.GOLD_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.REDSTONE_BLOCK_VILLAGER_BRAZIER,Blocks.REDSTONE_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.EMERALD_BLOCK_VILLAGER_BRAZIER,Blocks.EMERALD_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.DIAMOND_BLOCK_VILLAGER_BRAZIER,Blocks.DIAMOND_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.COPPER_BLOCK_VILLAGER_BRAZIER,Blocks.COPPER_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.LAPIS_BLOCK_VILLAGER_BRAZIER,Blocks.LAPIS_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.NETHERITE_BLOCK_VILLAGER_BRAZIER,Blocks.NETHERITE_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.OBSIDIAN_VILLAGER_BRAZIER,Blocks.OBSIDIAN);
        buildingBlocksReciperBluilder(BlockRegister.AMETHYST_BLOCK_VILLAGER_BRAZIER,Blocks.AMETHYST_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.DRIPSTONE_BLOCK_VILLAGER_BRAZIER,Blocks.DRIPSTONE_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.BEDROCK_VILLAGER_BRAZIER,Blocks.BEDROCK);
            //table
        buildingBlocksReciperBluilder(BlockRegister.OAK_VILLAGER_TABLE, Blocks.OAK_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.BIRCH_VILLAGER_TABLE,Blocks.BIRCH_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.SPRUCE_VILLAGER_TABLE,Blocks.SPRUCE_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.JUNGLE_VILLAGER_TABLE,Blocks.JUNGLE_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.ACACIA_VILLAGER_TABLE,Blocks.ACACIA_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.DARK_OAK_VILLAGER_TABLE,Blocks.DARK_OAK_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.MANGROVE_VILLAGER_TABLE,Blocks.MANGROVE_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.CHERRY_VILLAGER_TABLE,Blocks.CHERRY_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.CRIMSON_VILLAGER_TABLE,Blocks.CRIMSON_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.WARPED_VILLAGER_TABLE,Blocks.WARPED_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.BAMBOO_VILLAGER_TABLE,Blocks.BAMBOO_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.STONE_VILLAGER_TABLE,Blocks.COBBLESTONE);
        buildingBlocksReciperBluilder(BlockRegister.MOSSY_STONE_VILLAGER_TABLE,Blocks.MOSSY_COBBLESTONE);
        buildingBlocksReciperBluilder(BlockRegister.ANDESITE_VILLAGER_TABLE,Blocks.ANDESITE);
        buildingBlocksReciperBluilder(BlockRegister.DIORITE_VILLAGER_TABLE,Blocks.DIORITE);
        buildingBlocksReciperBluilder(BlockRegister.GRANITE_VILLAGER_TABLE,Blocks.GRANITE);
        buildingBlocksReciperBluilder(BlockRegister.PRISMARINE_VILLAGER_TABLE,Blocks.PRISMARINE);
        buildingBlocksReciperBluilder(BlockRegister.BLACKSTONE_VILLAGER_TABLE,Blocks.BLACKSTONE);
        buildingBlocksReciperBluilder(BlockRegister.PURPUR_BLOCK_VILLAGER_TABLE,Blocks.PURPUR_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.DEEPSLATE_VILLAGER_TABLE,Blocks.COBBLED_DEEPSLATE);
        buildingBlocksReciperBluilder(BlockRegister.TUFF_VILLAGER_TABLE,Blocks.TUFF);
        buildingBlocksReciperBluilder(BlockRegister.PACKED_MUD_VILLAGER_TABLE,Blocks.PACKED_MUD);
        buildingBlocksReciperBluilder(BlockRegister.SANDSTONE_VILLAGER_TABLE,Blocks.SANDSTONE);
        buildingBlocksReciperBluilder(BlockRegister.RED_SANDSTONE_VILLAGER_TABLE,Blocks.RED_SANDSTONE);
        buildingBlocksReciperBluilder(BlockRegister.QUARTZ_BLOCK_VILLAGER_TABLE,Blocks.QUARTZ_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.NETHER_BRICKS_VILLAGER_TABLE,Blocks.NETHER_BRICKS);
        buildingBlocksReciperBluilder(BlockRegister.BASALT_VILLAGER_TABLE,Blocks.BASALT);
        buildingBlocksReciperBluilder(BlockRegister.END_STONE_VILLAGER_TABLE,Blocks.END_STONE);
        buildingBlocksReciperBluilder(BlockRegister.COAL_BLOCK_VILLAGER_TABLE,Blocks.COAL_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.IRON_BLOCK_VILLAGER_TABLE,Blocks.IRON_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.GOLD_BLOCK_VILLAGER_TABLE,Blocks.GOLD_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.REDSTONE_BLOCK_VILLAGER_TABLE,Blocks.REDSTONE_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.EMERALD_BLOCK_VILLAGER_TABLE,Blocks.EMERALD_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.DIAMOND_BLOCK_VILLAGER_TABLE,Blocks.DIAMOND_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.COPPER_BLOCK_VILLAGER_TABLE,Blocks.COPPER_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.LAPIS_BLOCK_VILLAGER_TABLE,Blocks.LAPIS_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.NETHERITE_BLOCK_VILLAGER_TABLE,Blocks.NETHERITE_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.OBSIDIAN_VILLAGER_TABLE,Blocks.OBSIDIAN);
        buildingBlocksReciperBluilder(BlockRegister.AMETHYST_BLOCK_VILLAGER_TABLE,Blocks.AMETHYST_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.DRIPSTONE_BLOCK_VILLAGER_TABLE,Blocks.DRIPSTONE_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.BEDROCK_VILLAGER_TABLE,Blocks.BEDROCK);
            //chair
        buildingBlocksReciperBluilder(BlockRegister.OAK_VILLAGER_CHAIR, Blocks.OAK_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.BIRCH_VILLAGER_CHAIR,Blocks.BIRCH_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.SPRUCE_VILLAGER_CHAIR,Blocks.SPRUCE_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.JUNGLE_VILLAGER_CHAIR,Blocks.JUNGLE_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.ACACIA_VILLAGER_CHAIR,Blocks.ACACIA_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.DARK_OAK_VILLAGER_CHAIR,Blocks.DARK_OAK_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.MANGROVE_VILLAGER_CHAIR,Blocks.MANGROVE_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.CHERRY_VILLAGER_CHAIR,Blocks.CHERRY_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.CRIMSON_VILLAGER_CHAIR,Blocks.CRIMSON_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.WARPED_VILLAGER_CHAIR,Blocks.WARPED_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.BAMBOO_VILLAGER_CHAIR,Blocks.BAMBOO_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.STONE_VILLAGER_CHAIR,Blocks.COBBLESTONE);
        buildingBlocksReciperBluilder(BlockRegister.MOSSY_STONE_VILLAGER_CHAIR,Blocks.MOSSY_COBBLESTONE);
        buildingBlocksReciperBluilder(BlockRegister.ANDESITE_VILLAGER_CHAIR,Blocks.ANDESITE);
        buildingBlocksReciperBluilder(BlockRegister.DIORITE_VILLAGER_CHAIR,Blocks.DIORITE);
        buildingBlocksReciperBluilder(BlockRegister.GRANITE_VILLAGER_CHAIR,Blocks.GRANITE);
        buildingBlocksReciperBluilder(BlockRegister.PRISMARINE_VILLAGER_CHAIR,Blocks.PRISMARINE);
        buildingBlocksReciperBluilder(BlockRegister.BLACKSTONE_VILLAGER_CHAIR,Blocks.BLACKSTONE);
        buildingBlocksReciperBluilder(BlockRegister.PURPUR_BLOCK_VILLAGER_CHAIR,Blocks.PURPUR_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.DEEPSLATE_VILLAGER_CHAIR,Blocks.COBBLED_DEEPSLATE);
        buildingBlocksReciperBluilder(BlockRegister.TUFF_VILLAGER_CHAIR,Blocks.TUFF);
        buildingBlocksReciperBluilder(BlockRegister.PACKED_MUD_VILLAGER_CHAIR,Blocks.PACKED_MUD);
        buildingBlocksReciperBluilder(BlockRegister.SANDSTONE_VILLAGER_CHAIR,Blocks.SANDSTONE);
        buildingBlocksReciperBluilder(BlockRegister.RED_SANDSTONE_VILLAGER_CHAIR,Blocks.RED_SANDSTONE);
        buildingBlocksReciperBluilder(BlockRegister.QUARTZ_BLOCK_VILLAGER_CHAIR,Blocks.QUARTZ_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.NETHER_BRICKS_VILLAGER_CHAIR,Blocks.NETHER_BRICKS);
        buildingBlocksReciperBluilder(BlockRegister.BASALT_VILLAGER_CHAIR,Blocks.BASALT);
        buildingBlocksReciperBluilder(BlockRegister.END_STONE_VILLAGER_CHAIR,Blocks.END_STONE);
        buildingBlocksReciperBluilder(BlockRegister.COAL_BLOCK_VILLAGER_CHAIR,Blocks.COAL_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.IRON_BLOCK_VILLAGER_CHAIR,Blocks.IRON_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.GOLD_BLOCK_VILLAGER_CHAIR,Blocks.GOLD_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.REDSTONE_BLOCK_VILLAGER_CHAIR,Blocks.REDSTONE_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.EMERALD_BLOCK_VILLAGER_CHAIR,Blocks.EMERALD_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.DIAMOND_BLOCK_VILLAGER_CHAIR,Blocks.DIAMOND_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.COPPER_BLOCK_VILLAGER_CHAIR,Blocks.COPPER_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.LAPIS_BLOCK_VILLAGER_CHAIR,Blocks.LAPIS_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.NETHERITE_BLOCK_VILLAGER_CHAIR,Blocks.NETHERITE_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.OBSIDIAN_VILLAGER_CHAIR,Blocks.OBSIDIAN);
        buildingBlocksReciperBluilder(BlockRegister.AMETHYST_BLOCK_VILLAGER_CHAIR,Blocks.AMETHYST_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.DRIPSTONE_BLOCK_VILLAGER_CHAIR,Blocks.DRIPSTONE_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.BEDROCK_VILLAGER_CHAIR,Blocks.BEDROCK);
            //throne chair
        buildingBlocksReciperBluilder(BlockRegister.OAK_VILLAGER_THRONE_CHAIR, Blocks.OAK_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.BIRCH_VILLAGER_THRONE_CHAIR,Blocks.BIRCH_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.SPRUCE_VILLAGER_THRONE_CHAIR,Blocks.SPRUCE_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.JUNGLE_VILLAGER_THRONE_CHAIR,Blocks.JUNGLE_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.ACACIA_VILLAGER_THRONE_CHAIR,Blocks.ACACIA_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.DARK_OAK_VILLAGER_THRONE_CHAIR,Blocks.DARK_OAK_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.MANGROVE_VILLAGER_THRONE_CHAIR,Blocks.MANGROVE_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.CHERRY_VILLAGER_THRONE_CHAIR,Blocks.CHERRY_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.CRIMSON_VILLAGER_THRONE_CHAIR,Blocks.CRIMSON_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.WARPED_VILLAGER_THRONE_CHAIR,Blocks.WARPED_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.BAMBOO_VILLAGER_THRONE_CHAIR,Blocks.BAMBOO_PLANKS);
        buildingBlocksReciperBluilder(BlockRegister.STONE_VILLAGER_THRONE_CHAIR,Blocks.COBBLESTONE);
        buildingBlocksReciperBluilder(BlockRegister.MOSSY_STONE_VILLAGER_THRONE_CHAIR,Blocks.MOSSY_COBBLESTONE);
        buildingBlocksReciperBluilder(BlockRegister.ANDESITE_VILLAGER_THRONE_CHAIR,Blocks.ANDESITE);
        buildingBlocksReciperBluilder(BlockRegister.DIORITE_VILLAGER_THRONE_CHAIR,Blocks.DIORITE);
        buildingBlocksReciperBluilder(BlockRegister.GRANITE_VILLAGER_THRONE_CHAIR,Blocks.GRANITE);
        buildingBlocksReciperBluilder(BlockRegister.PRISMARINE_VILLAGER_THRONE_CHAIR,Blocks.PRISMARINE);
        buildingBlocksReciperBluilder(BlockRegister.BLACKSTONE_VILLAGER_THRONE_CHAIR,Blocks.BLACKSTONE);
        buildingBlocksReciperBluilder(BlockRegister.PURPUR_BLOCK_VILLAGER_THRONE_CHAIR,Blocks.PURPUR_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.DEEPSLATE_VILLAGER_THRONE_CHAIR,Blocks.COBBLED_DEEPSLATE);
        buildingBlocksReciperBluilder(BlockRegister.TUFF_VILLAGER_THRONE_CHAIR,Blocks.TUFF);
        buildingBlocksReciperBluilder(BlockRegister.PACKED_MUD_VILLAGER_THRONE_CHAIR,Blocks.PACKED_MUD);
        buildingBlocksReciperBluilder(BlockRegister.SANDSTONE_VILLAGER_THRONE_CHAIR,Blocks.SANDSTONE);
        buildingBlocksReciperBluilder(BlockRegister.RED_SANDSTONE_VILLAGER_THRONE_CHAIR,Blocks.RED_SANDSTONE);
        buildingBlocksReciperBluilder(BlockRegister.QUARTZ_BLOCK_VILLAGER_THRONE_CHAIR,Blocks.QUARTZ_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.NETHER_BRICKS_VILLAGER_THRONE_CHAIR,Blocks.NETHER_BRICKS);
        buildingBlocksReciperBluilder(BlockRegister.BASALT_VILLAGER_THRONE_CHAIR,Blocks.BASALT);
        buildingBlocksReciperBluilder(BlockRegister.END_STONE_VILLAGER_THRONE_CHAIR,Blocks.END_STONE);
        buildingBlocksReciperBluilder(BlockRegister.COAL_BLOCK_VILLAGER_THRONE_CHAIR,Blocks.COAL_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.IRON_BLOCK_VILLAGER_THRONE_CHAIR,Blocks.IRON_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.GOLD_BLOCK_VILLAGER_THRONE_CHAIR,Blocks.GOLD_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.REDSTONE_BLOCK_VILLAGER_THRONE_CHAIR,Blocks.REDSTONE_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.EMERALD_BLOCK_VILLAGER_THRONE_CHAIR,Blocks.EMERALD_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.DIAMOND_BLOCK_VILLAGER_THRONE_CHAIR,Blocks.DIAMOND_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.COPPER_BLOCK_VILLAGER_THRONE_CHAIR,Blocks.COPPER_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.LAPIS_BLOCK_VILLAGER_THRONE_CHAIR,Blocks.LAPIS_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.NETHERITE_BLOCK_VILLAGER_THRONE_CHAIR,Blocks.NETHERITE_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.OBSIDIAN_VILLAGER_THRONE_CHAIR,Blocks.OBSIDIAN);
        buildingBlocksReciperBluilder(BlockRegister.AMETHYST_BLOCK_VILLAGER_THRONE_CHAIR,Blocks.AMETHYST_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.DRIPSTONE_BLOCK_VILLAGER_THRONE_CHAIR,Blocks.DRIPSTONE_BLOCK);
        buildingBlocksReciperBluilder(BlockRegister.BEDROCK_VILLAGER_THRONE_CHAIR,Blocks.BEDROCK);
    }
    private void buildingBlocksReciperBluilder(ItemLike craftedBlock, ItemLike ingredient)
    {
        villagerWorkshopResultFromBase(craftedBlock,RecipeCategory.BUILDING_BLOCKS,ingredient);
    }

    private void villagerWorkshopRecipeBuilder(ItemLike craftedBlock)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(craftedBlock, 1))
                .define('1', Items.COPPER_INGOT)
                .define('2', Items.EMERALD)
                .define('#', Blocks.STONE)
                .pattern("121")
                .pattern("###")
                .unlockedBy("has_stone", has(Blocks.STONE))
                .save(ModRecipeProvider.recipeOutput);
    }

    //pCategory = RecipeCategory. / pResult = crafted block / pmaterial = ingredient / pRecipeOutput =
    protected static void villagerWorkshopResultFromBase( ItemLike pResult,RecipeCategory pCategory, ItemLike pMaterial)
    {
        villagerWorkshopResultFromBase(pCategory, pResult, pMaterial, 1);
    }

    protected static void villagerWorkshopResultFromBase(RecipeCategory pCategory, ItemLike pResult, ItemLike pMaterial, int pResultCount)
    {
        VillagerWorkshopRecipeBuilder.villagerWorkshoping(Ingredient.of(pMaterial), pCategory, pResult, pResultCount)
                .unlockedBy(getHasName(pMaterial), has(pMaterial))
                .save(ModRecipeProvider.recipeOutput, BuiltInRegistries.ITEM.getKey(pResult.asItem())+"_villagerworkshopping");
    }
}