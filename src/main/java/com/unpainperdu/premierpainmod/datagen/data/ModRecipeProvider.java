package com.unpainperdu.premierpainmod.datagen.data;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.VillagerWorkshop;
import com.unpainperdu.premierpainmod.level.world.item.crafting.builders.VillagerWorkshopRecipeBuilder;
import com.unpainperdu.premierpainmod.util.register.BlockList;
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
import net.neoforged.neoforge.registries.DeferredBlock;
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
        for(DeferredBlock<Block> Defferedblock : BlockList.ALL_BLOCKS)
        {
            Block block = Defferedblock.get();
            String blockName = BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MODID+":","");
            if(block instanceof VillagerWorkshop) {villagerWorkshopRecipeBuilder(block);}
            //oak like
            else if(blockName.contains("dark_oak")) {buildingBlocksReciperBluilder(block, Blocks.DARK_OAK_PLANKS);}
            else if(blockName.contains("oak")) {buildingBlocksReciperBluilder(block, Blocks.OAK_PLANKS);}
            //stone like
                //sandstone like
            else if(blockName.contains("red_sandstone")) {buildingBlocksReciperBluilder(block, Blocks.RED_SANDSTONE);}
            else if(blockName.contains("sandstone")) {buildingBlocksReciperBluilder(block, Blocks.SANDSTONE);}
                //other
            else if(blockName.contains("mossy_stone")) {buildingBlocksReciperBluilder(block, Blocks.MOSSY_COBBLESTONE);}
            else if(blockName.contains("end_stone")) {buildingBlocksReciperBluilder(block, Blocks.END_STONE);}
            else if(blockName.contains("blackstone")) {buildingBlocksReciperBluilder(block, Blocks.BLACKSTONE);}
            else if(blockName.contains("redstone")) {buildingBlocksReciperBluilder(block, Blocks.REDSTONE_BLOCK);}
            else if(blockName.contains("dripstone")) {buildingBlocksReciperBluilder(block, Blocks.DRIPSTONE_BLOCK);}
            else if(blockName.contains("stone")) {buildingBlocksReciperBluilder(block, Blocks.COBBLESTONE);}
            //other
            else if(blockName.contains("birch")) {buildingBlocksReciperBluilder(block, Blocks.BIRCH_PLANKS);}
            else if(blockName.contains("spruce")) {buildingBlocksReciperBluilder(block, Blocks.SPRUCE_PLANKS);}
            else if(blockName.contains("jungle")) {buildingBlocksReciperBluilder(block, Blocks.JUNGLE_PLANKS);}
            else if(blockName.contains("acacia")) {buildingBlocksReciperBluilder(block, Blocks.ACACIA_PLANKS);}
            else if(blockName.contains("mangrove")) {buildingBlocksReciperBluilder(block, Blocks.MANGROVE_PLANKS);}
            else if(blockName.contains("cherry")) {buildingBlocksReciperBluilder(block, Blocks.CHERRY_PLANKS);}
            else if(blockName.contains("bamboo")) {buildingBlocksReciperBluilder(block, Blocks.BAMBOO_PLANKS);}
            else if(blockName.contains("crimson")) {buildingBlocksReciperBluilder(block, Blocks.CRIMSON_PLANKS);}
            else if(blockName.contains("warped")) {buildingBlocksReciperBluilder(block, Blocks.WARPED_PLANKS);}
            else if(blockName.contains("andesite")) {buildingBlocksReciperBluilder(block, Blocks.ANDESITE);}
            else if(blockName.contains("diorite")) {buildingBlocksReciperBluilder(block, Blocks.DIORITE);}
            else if(blockName.contains("granite")) {buildingBlocksReciperBluilder(block, Blocks.GRANITE);}
            else if(blockName.contains("prismarine")) {buildingBlocksReciperBluilder(block, Blocks.PRISMARINE);}
            else if(blockName.contains("purpur")) {buildingBlocksReciperBluilder(block, Blocks.PURPUR_BLOCK);}
            else if(blockName.contains("deepslate")) {buildingBlocksReciperBluilder(block, Blocks.COBBLED_DEEPSLATE);}
            else if(blockName.contains("tuff")) {buildingBlocksReciperBluilder(block, Blocks.TUFF);}
            else if(blockName.contains("packed_mud")) {buildingBlocksReciperBluilder(block, Blocks.PACKED_MUD);}
            else if(blockName.contains("quartz")) {buildingBlocksReciperBluilder(block, Blocks.QUARTZ_BLOCK);}
            else if(blockName.contains("nether_bricks")) {buildingBlocksReciperBluilder(block, Blocks.NETHER_BRICKS);}
            else if(blockName.contains("basalt")) {buildingBlocksReciperBluilder(block, Blocks.BASALT);}
            else if(blockName.contains("coal")) {buildingBlocksReciperBluilder(block, Blocks.COAL_BLOCK);}
            else if(blockName.contains("iron")) {buildingBlocksReciperBluilder(block, Blocks.IRON_BLOCK);}
            else if(blockName.contains("gold")) {buildingBlocksReciperBluilder(block, Blocks.GOLD_BLOCK);}
            else if(blockName.contains("emerald")) {buildingBlocksReciperBluilder(block, Blocks.EMERALD_BLOCK);}
            else if(blockName.contains("diamond")) {buildingBlocksReciperBluilder(block, Blocks.DIAMOND_BLOCK);}
            else if(blockName.contains("copper")) {buildingBlocksReciperBluilder(block, Blocks.COPPER_BLOCK);}
            else if(blockName.contains("lapis")) {buildingBlocksReciperBluilder(block, Blocks.LAPIS_BLOCK);}
            else if(blockName.contains("netherite")) {buildingBlocksReciperBluilder(block, Blocks.NETHERITE_BLOCK);}
            else if(blockName.contains("obsidian")) {buildingBlocksReciperBluilder(block, Blocks.OBSIDIAN);}
            else if(blockName.contains("amethyst")) {buildingBlocksReciperBluilder(block, Blocks.AMETHYST_BLOCK);}
            else if(blockName.contains("bedrock")) {buildingBlocksReciperBluilder(block, Blocks.BEDROCK);}
        }

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