package com.unpainperdu.premierpainmod.datagen.data;

import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
        statueRecipeBuilder(BlockRegister.OAK_VILLAGER_STATUE,"has_oak_planks",Blocks.OAK_PLANKS);
        statueRecipeBuilder(BlockRegister.BIRCH_VILLAGER_STATUE,"has_birch_planks",Blocks.BIRCH_PLANKS);
        statueRecipeBuilder(BlockRegister.SPRUCE_VILLAGER_STATUE,"has_spruce_planks",Blocks.SPRUCE_PLANKS);
        statueRecipeBuilder(BlockRegister.JUNGLE_VILLAGER_STATUE,"has_jungle_planks",Blocks.JUNGLE_PLANKS);
        statueRecipeBuilder(BlockRegister.ACACIA_VILLAGER_STATUE,"has_acacia_planks",Blocks.ACACIA_PLANKS);
        statueRecipeBuilder(BlockRegister.DARK_OAK_VILLAGER_STATUE,"has_dark_oak_planks",Blocks.DARK_OAK_PLANKS);
        statueRecipeBuilder(BlockRegister.MANGROVE_VILLAGER_STATUE,"has_mangrove_planks",Blocks.MANGROVE_PLANKS);
        statueRecipeBuilder(BlockRegister.CHERRY_VILLAGER_STATUE,"has_cherry_planks",Blocks.CHERRY_PLANKS);
        statueRecipeBuilder(BlockRegister.CRIMSON_VILLAGER_STATUE,"has_crimson_planks",Blocks.CRIMSON_PLANKS);
        statueRecipeBuilder(BlockRegister.WARPED_VILLAGER_STATUE,"has_warped_planks",Blocks.WARPED_PLANKS);
        statueRecipeBuilder(BlockRegister.BAMBOO_VILLAGER_STATUE,"has_bamboo_planks",Blocks.BAMBOO_PLANKS);
        statueRecipeBuilder(BlockRegister.STONE_VILLAGER_STATUE,"has_cobblestone",Blocks.COBBLESTONE);
        statueRecipeBuilder(BlockRegister.MOSSY_STONE_VILLAGER_STATUE,"has_mossy_cobblestone",Blocks.MOSSY_COBBLESTONE);
        statueRecipeBuilder(BlockRegister.ANDESITE_VILLAGER_STATUE,"has_andesite",Blocks.ANDESITE);
        statueRecipeBuilder(BlockRegister.DIORITE_VILLAGER_STATUE,"has_diorite",Blocks.DIORITE);
        statueRecipeBuilder(BlockRegister.GRANITE_VILLAGER_STATUE,"has_granite",Blocks.GRANITE);
        statueRecipeBuilder(BlockRegister.PRISMARINE_VILLAGER_STATUE,"has_prismarine",Blocks.PRISMARINE);
        statueRecipeBuilder(BlockRegister.BLACKSTONE_VILLAGER_STATUE,"has_blackstone",Blocks.BLACKSTONE);
        statueRecipeBuilder(BlockRegister.PURPUR_BLOCK_VILLAGER_STATUE,"has_purpur_block",Blocks.PURPUR_BLOCK);
        statueRecipeBuilder(BlockRegister.DEEPSLATE_VILLAGER_STATUE,"has_deepslate",Blocks.DEEPSLATE);
        statueRecipeBuilder(BlockRegister.TUFF_VILLAGER_STATUE,"has_tuff",Blocks.TUFF);
        statueRecipeBuilder(BlockRegister.PACKED_MUD_VILLAGER_STATUE,"has_packed_mud",Blocks.PACKED_MUD);
        statueRecipeBuilder(BlockRegister.SANDSTONE_VILLAGER_STATUE,"has_sandstone",Blocks.SANDSTONE);
        statueRecipeBuilder(BlockRegister.RED_SANDSTONE_VILLAGER_STATUE,"has_red_sandstone",Blocks.RED_SANDSTONE);
        statueRecipeBuilder(BlockRegister.QUARTZ_BLOCK_VILLAGER_STATUE,"has_quartz_block",Blocks.QUARTZ_BLOCK);
        statueRecipeBuilder(BlockRegister.NETHER_BRICKS_VILLAGER_STATUE,"has_nether_bricks",Blocks.NETHER_BRICKS);
        statueRecipeBuilder(BlockRegister.BASALT_VILLAGER_STATUE,"has_basalt",Blocks.BASALT);
        statueRecipeBuilder(BlockRegister.END_STONE_VILLAGER_STATUE,"has_end_stone",Blocks.END_STONE);
        statueRecipeBuilder(BlockRegister.COAL_BLOCK_VILLAGER_STATUE,"has_coal_block",Blocks.COAL_BLOCK);
        statueRecipeBuilder(BlockRegister.IRON_BLOCK_VILLAGER_STATUE,"has_iron_block",Blocks.IRON_BLOCK);
        statueRecipeBuilder(BlockRegister.GOLD_BLOCK_VILLAGER_STATUE,"has_gold_block",Blocks.GOLD_BLOCK);
        statueRecipeBuilder(BlockRegister.REDSTONE_BLOCK_VILLAGER_STATUE,"has_redstone_block",Blocks.REDSTONE_BLOCK);
        statueRecipeBuilder(BlockRegister.EMERALD_BLOCK_VILLAGER_STATUE,"has_emerald_block",Blocks.EMERALD_BLOCK);
        statueRecipeBuilder(BlockRegister.DIAMOND_BLOCK_VILLAGER_STATUE,"has_diamond_block",Blocks.DIAMOND_BLOCK);
        statueRecipeBuilder(BlockRegister.COPPER_BLOCK_VILLAGER_STATUE,"has_copper_block",Blocks.COPPER_BLOCK);
        statueRecipeBuilder(BlockRegister.LAPIS_BLOCK_VILLAGER_STATUE,"has_lapis_block",Blocks.LAPIS_BLOCK);
        statueRecipeBuilder(BlockRegister.NETHERITE_BLOCK_VILLAGER_STATUE,"has_netherite_block",Blocks.NETHERITE_BLOCK);
        statueRecipeBuilder(BlockRegister.OBSIDIAN_VILLAGER_STATUE,"has_obsidian",Blocks.OBSIDIAN);
        statueRecipeBuilder(BlockRegister.AMETHYST_BLOCK_VILLAGER_STATUE,"has_amethyst_block",Blocks.AMETHYST_BLOCK);
        statueRecipeBuilder(BlockRegister.DRIPSTONE_BLOCK_VILLAGER_STATUE,"has_dripstone_block",Blocks.DRIPSTONE_BLOCK);
        statueRecipeBuilder(BlockRegister.BEDROCK_VILLAGER_STATUE,"has_bedrock",Blocks.BEDROCK);
            //pedestal
        pedestalRecipeBuilder(BlockRegister.OAK_PEDESTAL,"has_oak_planks",Blocks.OAK_PLANKS);
        pedestalRecipeBuilder(BlockRegister.BIRCH_PEDESTAL,"has_birch_planks",Blocks.BIRCH_PLANKS);
        pedestalRecipeBuilder(BlockRegister.SPRUCE_PEDESTAL,"has_spruce_planks",Blocks.SPRUCE_PLANKS);
        pedestalRecipeBuilder(BlockRegister.JUNGLE_PEDESTAL,"has_jungle_planks",Blocks.JUNGLE_PLANKS);
        pedestalRecipeBuilder(BlockRegister.ACACIA_PEDESTAL,"has_acacia_planks",Blocks.ACACIA_PLANKS);
        pedestalRecipeBuilder(BlockRegister.DARK_OAK_PEDESTAL,"has_dark_oak_planks",Blocks.DARK_OAK_PLANKS);
        pedestalRecipeBuilder(BlockRegister.MANGROVE_PEDESTAL,"has_mangrove_planks",Blocks.MANGROVE_PLANKS);
        pedestalRecipeBuilder(BlockRegister.CHERRY_PEDESTAL,"has_cherry_planks",Blocks.CHERRY_PLANKS);
        pedestalRecipeBuilder(BlockRegister.CRIMSON_PEDESTAL,"has_crimson_planks",Blocks.CRIMSON_PLANKS);
        pedestalRecipeBuilder(BlockRegister.WARPED_PEDESTAL,"has_warped_planks",Blocks.WARPED_PLANKS);
        pedestalRecipeBuilder(BlockRegister.BAMBOO_PEDESTAL,"has_bamboo_planks",Blocks.BAMBOO_PLANKS);
        pedestalRecipeBuilder(BlockRegister.STONE_PEDESTAL,"has_cobblestone",Blocks.COBBLESTONE);
        pedestalRecipeBuilder(BlockRegister.MOSSY_STONE_PEDESTAL,"has_mossy_cobblestone",Blocks.MOSSY_COBBLESTONE);
        pedestalRecipeBuilder(BlockRegister.ANDESITE_PEDESTAL,"has_andesite",Blocks.ANDESITE);
        pedestalRecipeBuilder(BlockRegister.DIORITE_PEDESTAL,"has_diorite",Blocks.DIORITE);
        pedestalRecipeBuilder(BlockRegister.GRANITE_PEDESTAL,"has_granite",Blocks.GRANITE);
        pedestalRecipeBuilder(BlockRegister.PRISMARINE_PEDESTAL,"has_prismarine",Blocks.PRISMARINE);
        pedestalRecipeBuilder(BlockRegister.BLACKSTONE_PEDESTAL,"has_blackstone",Blocks.BLACKSTONE);
        pedestalRecipeBuilder(BlockRegister.PURPUR_BLOCK_PEDESTAL,"has_purpur_block",Blocks.PURPUR_BLOCK);
        pedestalRecipeBuilder(BlockRegister.DEEPSLATE_PEDESTAL,"has_deepslate",Blocks.DEEPSLATE);
        pedestalRecipeBuilder(BlockRegister.TUFF_PEDESTAL,"has_tuff",Blocks.TUFF);
        pedestalRecipeBuilder(BlockRegister.PACKED_MUD_PEDESTAL,"has_packed_mud",Blocks.PACKED_MUD);
        pedestalRecipeBuilder(BlockRegister.SANDSTONE_PEDESTAL,"has_sandstone",Blocks.SANDSTONE);
        pedestalRecipeBuilder(BlockRegister.RED_SANDSTONE_PEDESTAL,"has_red_sandstone",Blocks.RED_SANDSTONE);
        pedestalRecipeBuilder(BlockRegister.QUARTZ_BLOCK_PEDESTAL,"has_quartz_block",Blocks.QUARTZ_BLOCK);
        pedestalRecipeBuilder(BlockRegister.NETHER_BRICKS_PEDESTAL,"has_nether_bricks",Blocks.NETHER_BRICKS);
        pedestalRecipeBuilder(BlockRegister.BASALT_PEDESTAL,"has_basalt",Blocks.BASALT);
        pedestalRecipeBuilder(BlockRegister.END_STONE_PEDESTAL,"has_end_stone",Blocks.END_STONE);
        pedestalRecipeBuilder(BlockRegister.COAL_BLOCK_PEDESTAL,"has_coal_block",Blocks.COAL_BLOCK);
        pedestalRecipeBuilder(BlockRegister.IRON_BLOCK_PEDESTAL,"has_iron_block",Blocks.IRON_BLOCK);
        pedestalRecipeBuilder(BlockRegister.GOLD_BLOCK_PEDESTAL,"has_gold_block",Blocks.GOLD_BLOCK);
        pedestalRecipeBuilder(BlockRegister.REDSTONE_BLOCK_PEDESTAL,"has_redstone_block",Blocks.REDSTONE_BLOCK);
        pedestalRecipeBuilder(BlockRegister.EMERALD_BLOCK_PEDESTAL,"has_emerald_block",Blocks.EMERALD_BLOCK);
        pedestalRecipeBuilder(BlockRegister.DIAMOND_BLOCK_PEDESTAL,"has_diamond_block",Blocks.DIAMOND_BLOCK);
        pedestalRecipeBuilder(BlockRegister.COPPER_BLOCK_PEDESTAL,"has_copper_block",Blocks.COPPER_BLOCK);
        pedestalRecipeBuilder(BlockRegister.LAPIS_BLOCK_PEDESTAL,"has_lapis_block",Blocks.LAPIS_BLOCK);
        pedestalRecipeBuilder(BlockRegister.NETHERITE_BLOCK_PEDESTAL,"has_netherite_block",Blocks.NETHERITE_BLOCK);
        pedestalRecipeBuilder(BlockRegister.OBSIDIAN_PEDESTAL,"has_obsidian",Blocks.OBSIDIAN);
        pedestalRecipeBuilder(BlockRegister.AMETHYST_BLOCK_PEDESTAL,"has_amethyst_block",Blocks.AMETHYST_BLOCK);
        pedestalRecipeBuilder(BlockRegister.DRIPSTONE_BLOCK_PEDESTAL,"has_dripstone_block",Blocks.DRIPSTONE_BLOCK);
        pedestalRecipeBuilder(BlockRegister.BEDROCK_PEDESTAL,"has_bedrock",Blocks.BEDROCK);
    }
    private void statueRecipeBuilder(ItemLike craftedBlock,String pName, ItemLike ingredient)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(craftedBlock, 1))
                .define('#', ingredient)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy(pName, has(ingredient))
                .save(ModRecipeProvider.recipeOutput);
    }
    private void pedestalRecipeBuilder(ItemLike craftedBlock,String pName, ItemLike ingredient)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(craftedBlock, 1))
                .define('#', ingredient)
                .pattern(" # ")
                .pattern("###")
                .unlockedBy(pName, has(ingredient))
                .save(ModRecipeProvider.recipeOutput);
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
}