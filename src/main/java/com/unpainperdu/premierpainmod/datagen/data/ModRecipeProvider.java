package com.unpainperdu.premierpainmod.datagen.data;

import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

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
        statueRecipeBuilder(BlockRegister.STONE_VILLAGER_STATUE,"has_stone",Blocks.STONE);
        statueRecipeBuilder(BlockRegister.ANDESITE_VILLAGER_STATUE,"has_andesite",Blocks.ANDESITE);
        statueRecipeBuilder(BlockRegister.DIORITE_VILLAGER_STATUE,"has_diorite",Blocks.DIORITE);
        statueRecipeBuilder(BlockRegister.GRANITE_VILLAGER_STATUE,"has_granite",Blocks.GRANITE);
        statueRecipeBuilder(BlockRegister.PRISMARINE_VILLAGER_STATUE,"has_prismarine",Blocks.PRISMARINE);
        statueRecipeBuilder(BlockRegister.BLACKSTONE_VILLAGER_STATUE,"has_blackstone",Blocks.BLACKSTONE);
        statueRecipeBuilder(BlockRegister.PURPUR_BLOCK_VILLAGER_STATUE,"has_purpur_block",Blocks.PURPUR_BLOCK);
        statueRecipeBuilder(BlockRegister.COBBLESTONE_VILLAGER_STATUE,"has_cobblestone",Blocks.COBBLESTONE);
        statueRecipeBuilder(BlockRegister.MOSSY_COBBLESTONE_VILLAGER_STATUE,"has_mossy_cobblestone",Blocks.MOSSY_COBBLESTONE);
        statueRecipeBuilder(BlockRegister.SMOOTH_STONE_VILLAGER_STATUE,"has_smooth_stone",Blocks.SMOOTH_STONE);
        statueRecipeBuilder(BlockRegister.COBBLED_DEEPSLATE_VILLAGER_STATUE,"has_deepslate",Blocks.DEEPSLATE);
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
}