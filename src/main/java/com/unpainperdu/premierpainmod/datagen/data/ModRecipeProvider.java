package com.unpainperdu.premierpainmod.datagen.data;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockWidth.VillagerWorkshop;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockWidthWithBlockEntity.villagerShelf.VillagerShelf;
import com.unpainperdu.premierpainmod.level.world.item.crafting.builders.VillagerWorkshopRecipeBuilder;
import com.unpainperdu.premierpainmod.level.world.item.items.allMaterialsBlock.VillagerShelfItem;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.ModList;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
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
            //food
                //vegetation
        oneItemToAnotherOneRecipeBuilder(BlockRegister.CACTUS_FLOWER_BLOCK, ItemRegister.CACTUS_FLOWER_FRUIT);
        oneItemToAnotherOneRecipeBuilder(BlockRegister.SKY_SPEARS_FLOWER, ItemRegister.SKY_SPEARS_FRUIT);
        //block
            //misc
        oneItemToAnotherOneRecipeInFurnaceBuilder(BlockRegister.FLOWERED_CACTUS_BLOCK, Items.GREEN_DYE, RecipeCategory.MISC, 0.2f, 300);
            //flower to colorant
        oneItemToAnotherOneRecipeBuilder(BlockRegister.CIVILIZATIONS_FLOWER, Items.ORANGE_DYE);
        oneItemToAnotherOneRecipeBuilder(BlockRegister.RUINS_FLOWER, Items.BROWN_DYE);
        oneItemToAnotherOneRecipeBuilder(BlockRegister.CURIOSITY_FLOWER, Items.MAGENTA_DYE);
            //all materials recipes
        for(DeferredBlock<Block> Defferedblock : ModList.ALL_BLOCKS)
        {
            Block block = Defferedblock.get();
            String blockName = BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MOD_ID +":","");
            if(!(block instanceof VillagerShelf))
            {
                if (block instanceof VillagerWorkshop) {
                    villagerWorkshopRecipeBuilder(block);
                }
                //oak like
                else if (blockName.contains("dark_oak"))
                {
                    buildingBlocksReciperBluilder(block, Blocks.DARK_OAK_PLANKS);

                }  else if (blockName.contains("pale_oak"))
                {
                    buildingBlocksReciperBluilder(block, Items.STICK);
                }
                else if (blockName.contains("oak")) {
                    buildingBlocksReciperBluilder(block, Blocks.OAK_PLANKS);
                }
                //stone like
                //sandstone like
                else if (blockName.contains("red_sandstone")) {
                    buildingBlocksReciperBluilder(block, Blocks.RED_SANDSTONE);
                } else if (blockName.contains("sandstone")) {
                    buildingBlocksReciperBluilder(block, Blocks.SANDSTONE);
                }
                //other
                else if (blockName.contains("mossy_stone")) {
                    buildingBlocksReciperBluilder(block, Blocks.MOSSY_COBBLESTONE);
                } else if (blockName.contains("end_stone")) {
                    buildingBlocksReciperBluilder(block, Blocks.END_STONE);
                } else if (blockName.contains("blackstone")) {
                    buildingBlocksReciperBluilder(block, Blocks.BLACKSTONE);
                } else if (blockName.contains("redstone")) {
                    buildingBlocksReciperBluilder(block, Blocks.REDSTONE_BLOCK);
                } else if (blockName.contains("dripstone")) {
                    buildingBlocksReciperBluilder(block, Blocks.DRIPSTONE_BLOCK);
                } else if (blockName.contains("stone")) {
                    buildingBlocksReciperBluilder(block, Blocks.COBBLESTONE);
                }
                //other
                else if (blockName.contains("birch")) {
                    buildingBlocksReciperBluilder(block, Blocks.BIRCH_PLANKS);
                } else if (blockName.contains("spruce")) {
                    buildingBlocksReciperBluilder(block, Blocks.SPRUCE_PLANKS);
                } else if (blockName.contains("jungle")) {
                    buildingBlocksReciperBluilder(block, Blocks.JUNGLE_PLANKS);
                } else if (blockName.contains("acacia")) {
                    buildingBlocksReciperBluilder(block, Blocks.ACACIA_PLANKS);
                } else if (blockName.contains("mangrove")) {
                    buildingBlocksReciperBluilder(block, Blocks.MANGROVE_PLANKS);
                } else if (blockName.contains("cherry")) {
                    buildingBlocksReciperBluilder(block, Blocks.CHERRY_PLANKS);
                } else if (blockName.contains("bamboo")) {
                    buildingBlocksReciperBluilder(block, Blocks.BAMBOO_PLANKS);
                } else if (blockName.contains("crimson")) {
                    buildingBlocksReciperBluilder(block, Blocks.CRIMSON_PLANKS);
                } else if (blockName.contains("warped")) {
                    buildingBlocksReciperBluilder(block, Blocks.WARPED_PLANKS);
                } else if (blockName.contains("andesite")) {
                    buildingBlocksReciperBluilder(block, Blocks.ANDESITE);
                } else if (blockName.contains("diorite")) {
                    buildingBlocksReciperBluilder(block, Blocks.DIORITE);
                } else if (blockName.contains("granite")) {
                    buildingBlocksReciperBluilder(block, Blocks.GRANITE);
                } else if (blockName.contains("prismarine")) {
                    buildingBlocksReciperBluilder(block, Blocks.PRISMARINE);
                } else if (blockName.contains("purpur")) {
                    buildingBlocksReciperBluilder(block, Blocks.PURPUR_BLOCK);
                } else if (blockName.contains("deepslate")) {
                    buildingBlocksReciperBluilder(block, Blocks.COBBLED_DEEPSLATE);
                } else if (blockName.contains("tuff")) {
                    buildingBlocksReciperBluilder(block, Blocks.TUFF);
                } else if (blockName.contains("packed_mud")) {
                    buildingBlocksReciperBluilder(block, Blocks.PACKED_MUD);
                } else if (blockName.contains("quartz")) {
                    buildingBlocksReciperBluilder(block, Blocks.QUARTZ_BLOCK);
                } else if (blockName.contains("nether_bricks")) {
                    buildingBlocksReciperBluilder(block, Blocks.NETHER_BRICKS);
                } else if (blockName.contains("basalt")) {
                    buildingBlocksReciperBluilder(block, Blocks.BASALT);
                } else if (blockName.contains("coal")) {
                    buildingBlocksReciperBluilder(block, Blocks.COAL_BLOCK);
                } else if (blockName.contains("iron")) {
                    buildingBlocksReciperBluilder(block, Blocks.IRON_BLOCK);
                } else if (blockName.contains("gold")) {
                    buildingBlocksReciperBluilder(block, Blocks.GOLD_BLOCK);
                } else if (blockName.contains("emerald")) {
                    buildingBlocksReciperBluilder(block, Blocks.EMERALD_BLOCK);
                } else if (blockName.contains("diamond")) {
                    buildingBlocksReciperBluilder(block, Blocks.DIAMOND_BLOCK);
                } else if (blockName.contains("copper")) {
                    buildingBlocksReciperBluilder(block, Blocks.COPPER_BLOCK);
                } else if (blockName.contains("lapis")) {
                    buildingBlocksReciperBluilder(block, Blocks.LAPIS_BLOCK);
                } else if (blockName.contains("netherite")) {
                    buildingBlocksReciperBluilder(block, Blocks.NETHERITE_BLOCK);
                } else if (blockName.contains("obsidian")) {
                    buildingBlocksReciperBluilder(block, Blocks.OBSIDIAN);
                } else if (blockName.contains("amethyst")) {
                    buildingBlocksReciperBluilder(block, Blocks.AMETHYST_BLOCK);
                } else if (blockName.contains("bedrock")) {
                    buildingBlocksReciperBluilder(block, Blocks.BEDROCK);
                }
            }
        }
        for(
                DeferredItem<Item> Deffereditem : ModList.ALL_ITEMS)
        {
            Item item = Deffereditem.get();
            String itemName = BuiltInRegistries.ITEM.getKey(item).toString().replace(PremierPainMod.MOD_ID +":","");
            if((item instanceof VillagerShelfItem))
            {
                    //oak like
                if (itemName.contains("dark_oak")) {
                    buildingBlocksReciperBluilder(item, Blocks.DARK_OAK_PLANKS);
                } else if (itemName.contains("oak")) {
                    buildingBlocksReciperBluilder(item, Blocks.OAK_PLANKS);
                }
                //stone like
                //sandstone like
                else if (itemName.contains("red_sandstone")) {
                    buildingBlocksReciperBluilder(item, Blocks.RED_SANDSTONE);
                } else if (itemName.contains("sandstone")) {
                    buildingBlocksReciperBluilder(item, Blocks.SANDSTONE);
                }
                //other
                else if (itemName.contains("mossy_stone")) {
                    buildingBlocksReciperBluilder(item, Blocks.MOSSY_COBBLESTONE);
                } else if (itemName.contains("end_stone")) {
                    buildingBlocksReciperBluilder(item, Blocks.END_STONE);
                } else if (itemName.contains("blackstone")) {
                    buildingBlocksReciperBluilder(item, Blocks.BLACKSTONE);
                } else if (itemName.contains("redstone")) {
                    buildingBlocksReciperBluilder(item, Blocks.REDSTONE_BLOCK);
                } else if (itemName.contains("dripstone")) {
                    buildingBlocksReciperBluilder(item, Blocks.DRIPSTONE_BLOCK);
                } else if (itemName.contains("stone")) {
                    buildingBlocksReciperBluilder(item, Blocks.COBBLESTONE);
                }
                //other
                else if (itemName.contains("birch")) {
                    buildingBlocksReciperBluilder(item, Blocks.BIRCH_PLANKS);
                } else if (itemName.contains("spruce")) {
                    buildingBlocksReciperBluilder(item, Blocks.SPRUCE_PLANKS);
                } else if (itemName.contains("jungle")) {
                    buildingBlocksReciperBluilder(item, Blocks.JUNGLE_PLANKS);
                } else if (itemName.contains("acacia")) {
                    buildingBlocksReciperBluilder(item, Blocks.ACACIA_PLANKS);
                } else if (itemName.contains("mangrove")) {
                    buildingBlocksReciperBluilder(item, Blocks.MANGROVE_PLANKS);
                } else if (itemName.contains("cherry")) {
                    buildingBlocksReciperBluilder(item, Blocks.CHERRY_PLANKS);
                } else if (itemName.contains("bamboo")) {
                    buildingBlocksReciperBluilder(item, Blocks.BAMBOO_PLANKS);
                } else if (itemName.contains("crimson")) {
                    buildingBlocksReciperBluilder(item, Blocks.CRIMSON_PLANKS);
                } else if (itemName.contains("warped")) {
                    buildingBlocksReciperBluilder(item, Blocks.WARPED_PLANKS);
                } else if (itemName.contains("andesite")) {
                    buildingBlocksReciperBluilder(item, Blocks.ANDESITE);
                } else if (itemName.contains("diorite")) {
                    buildingBlocksReciperBluilder(item, Blocks.DIORITE);
                } else if (itemName.contains("granite")) {
                    buildingBlocksReciperBluilder(item, Blocks.GRANITE);
                } else if (itemName.contains("prismarine")) {
                    buildingBlocksReciperBluilder(item, Blocks.PRISMARINE);
                } else if (itemName.contains("purpur")) {
                    buildingBlocksReciperBluilder(item, Blocks.PURPUR_BLOCK);
                } else if (itemName.contains("deepslate")) {
                    buildingBlocksReciperBluilder(item, Blocks.COBBLED_DEEPSLATE);
                } else if (itemName.contains("tuff")) {
                    buildingBlocksReciperBluilder(item, Blocks.TUFF);
                } else if (itemName.contains("packed_mud")) {
                    buildingBlocksReciperBluilder(item, Blocks.PACKED_MUD);
                } else if (itemName.contains("quartz")) {
                    buildingBlocksReciperBluilder(item, Blocks.QUARTZ_BLOCK);
                } else if (itemName.contains("nether_bricks")) {
                    buildingBlocksReciperBluilder(item, Blocks.NETHER_BRICKS);
                } else if (itemName.contains("basalt")) {
                    buildingBlocksReciperBluilder(item, Blocks.BASALT);
                } else if (itemName.contains("coal")) {
                    buildingBlocksReciperBluilder(item, Blocks.COAL_BLOCK);
                } else if (itemName.contains("iron")) {
                    buildingBlocksReciperBluilder(item, Blocks.IRON_BLOCK);
                } else if (itemName.contains("gold")) {
                    buildingBlocksReciperBluilder(item, Blocks.GOLD_BLOCK);
                } else if (itemName.contains("emerald")) {
                    buildingBlocksReciperBluilder(item, Blocks.EMERALD_BLOCK);
                } else if (itemName.contains("diamond")) {
                    buildingBlocksReciperBluilder(item, Blocks.DIAMOND_BLOCK);
                } else if (itemName.contains("copper")) {
                    buildingBlocksReciperBluilder(item, Blocks.COPPER_BLOCK);
                } else if (itemName.contains("lapis")) {
                    buildingBlocksReciperBluilder(item, Blocks.LAPIS_BLOCK);
                } else if (itemName.contains("netherite")) {
                    buildingBlocksReciperBluilder(item, Blocks.NETHERITE_BLOCK);
                } else if (itemName.contains("obsidian")) {
                    buildingBlocksReciperBluilder(item, Blocks.OBSIDIAN);
                } else if (itemName.contains("amethyst")) {
                    buildingBlocksReciperBluilder(item, Blocks.AMETHYST_BLOCK);
                } else if (itemName.contains("bedrock")) {
                    buildingBlocksReciperBluilder(item, Blocks.BEDROCK);
                }
            }
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

    private void oneItemToAnotherOneRecipeBuilder(ItemLike resource, ItemLike result)
    {
        String resultName = BuiltInRegistries.BLOCK.getKey((Block) ((DeferredBlock<Block>) resource).get()).toString().replace(PremierPainMod.MOD_ID +":","");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result).requires(resource).unlockedBy("has_" + resultName, has(resource)).save(ModRecipeProvider.recipeOutput);
    }

    /*
    for example cactus is 0.2 exp
    time in tick
    */
    private void oneItemToAnotherOneRecipeInFurnaceBuilder(ItemLike resource, ItemLike result,RecipeCategory recipeCategory , float exp, int cookingTime)
    {
        String resultName = BuiltInRegistries.BLOCK.getKey((Block) ((DeferredBlock<Block>) resource).get()).toString().replace(PremierPainMod.MOD_ID +":","");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(resource), recipeCategory, result, exp, cookingTime)
                .unlockedBy("has_" + resultName, has(resource))
                .save(ModRecipeProvider.recipeOutput);
    }
}