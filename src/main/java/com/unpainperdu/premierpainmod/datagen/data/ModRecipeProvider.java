package com.unpainperdu.premierpainmod.datagen.data;

import com.unpainperdu.premierpainmod.PremierPainMod;
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
        oneItemToAnotherOneRecipeBuilder(BlockRegister.JELLYSHROOM, ItemRegister.JELLY_HAT);
                //stew
        shapelessRecipeBuilder(ItemRegister.JELLYSHROOM_STEW, ItemRegister.JELLY_HAT, 1, Items.BOWL, ItemRegister.JELLY_HAT, Items.SUGAR);
        shapelessRecipeBuilder(ItemRegister.CACTUS_STEW, ItemRegister.CACTUS_FLOWER_FRUIT, 1, Items.BOWL, ItemRegister.CACTUS_FLOWER_FRUIT, Items.SUGAR);
        shapelessRecipeBuilder(ItemRegister.POTATOES_AND_SPEARS_BOWL, ItemRegister.SKY_SPEARS_FRUIT, 1, Items.BOWL, ItemRegister.SKY_SPEARS_FRUIT, Items.BAKED_POTATO);
        shapelessRecipeBuilder(ItemRegister.FRUITS_BOWL, ItemRegister.CACTUS_FLOWER_FRUIT, 1, Items.BOWL, ItemRegister.CACTUS_FLOWER_FRUIT, Items.SWEET_BERRIES, Items.GLOW_BERRIES, Items.APPLE);
        //block
        villagerWorkshopRecipeBuilder();
            //misc
        oneItemToAnotherOneRecipeInFurnaceBuilder(BlockRegister.FLOWERED_CACTUS_BLOCK, Items.GREEN_DYE, RecipeCategory.MISC, 0.2f, 300);
            //flower to colorant
        oneItemToAnotherOneRecipeBuilder(BlockRegister.CIVILIZATIONS_FLOWER, Items.ORANGE_DYE);
        oneItemToAnotherOneRecipeBuilder(BlockRegister.RUINS_FLOWER, Items.BROWN_DYE);
        oneItemToAnotherOneRecipeBuilder(BlockRegister.CURIOSITY_FLOWER, Items.MAGENTA_DYE);
            //all materials recipes
        for(Block block : ModList.getAllMaterialsBlocks())
        {
            String blockName = BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MOD_ID +":","");
            if(!(block instanceof VillagerShelf))
            {
                //oak like
                if (blockName.contains("dark_oak"))
                {
                    buildingBlocksRecipeBluilder(block, Blocks.DARK_OAK_PLANKS);

                }  else if (blockName.contains("pale_oak"))
                {
                    buildingBlocksRecipeBluilder(block, Items.STICK);
                }
                else if (blockName.contains("oak"))
                {
                    buildingBlocksRecipeBluilder(block, Blocks.OAK_PLANKS);
                }
                //stone like
                //sandstone like
                else if (blockName.contains("red_sandstone"))
                {
                    buildingBlocksRecipeBluilder(block, Blocks.RED_SANDSTONE);
                } else if (blockName.contains("sandstone"))
                {
                    buildingBlocksRecipeBluilder(block, Blocks.SANDSTONE);
                }
                //other
                else if (blockName.contains("mossy_stone"))
                {
                    buildingBlocksRecipeBluilder(block, Blocks.MOSSY_COBBLESTONE);
                }
                else if (blockName.contains("mountain_currant"))
                {
                    buildingBlocksRecipeBluilder(block, BlockRegister.MOUNTAIN_CURRANT_PLANKS);
                }
                else if (blockName.contains("end_stone"))
                {
                    buildingBlocksRecipeBluilder(block, Blocks.END_STONE);
                } else if (blockName.contains("blackstone"))
                {
                    buildingBlocksRecipeBluilder(block, Blocks.BLACKSTONE);
                } else if (blockName.contains("redstone"))
                {
                    buildingBlocksRecipeBluilder(block, Blocks.REDSTONE_BLOCK);
                } else if (blockName.contains("dripstone"))
                {
                    buildingBlocksRecipeBluilder(block, Blocks.DRIPSTONE_BLOCK);
                } else if (blockName.contains("stone"))
                {
                    buildingBlocksRecipeBluilder(block, Blocks.COBBLESTONE);
                }
                //other
                else if (blockName.contains("birch")) {
                    buildingBlocksRecipeBluilder(block, Blocks.BIRCH_PLANKS);
                } else if (blockName.contains("spruce")) {
                    buildingBlocksRecipeBluilder(block, Blocks.SPRUCE_PLANKS);
                } else if (blockName.contains("jungle")) {
                    buildingBlocksRecipeBluilder(block, Blocks.JUNGLE_PLANKS);
                } else if (blockName.contains("acacia")) {
                    buildingBlocksRecipeBluilder(block, Blocks.ACACIA_PLANKS);
                } else if (blockName.contains("mangrove")) {
                    buildingBlocksRecipeBluilder(block, Blocks.MANGROVE_PLANKS);
                } else if (blockName.contains("cherry")) {
                    buildingBlocksRecipeBluilder(block, Blocks.CHERRY_PLANKS);
                } else if (blockName.contains("bamboo")) {
                    buildingBlocksRecipeBluilder(block, Blocks.BAMBOO_PLANKS);
                } else if (blockName.contains("crimson")) {
                    buildingBlocksRecipeBluilder(block, Blocks.CRIMSON_PLANKS);
                } else if (blockName.contains("warped")) {
                    buildingBlocksRecipeBluilder(block, Blocks.WARPED_PLANKS);
                } else if (blockName.contains("andesite")) {
                    buildingBlocksRecipeBluilder(block, Blocks.ANDESITE);
                } else if (blockName.contains("diorite")) {
                    buildingBlocksRecipeBluilder(block, Blocks.DIORITE);
                } else if (blockName.contains("granite")) {
                    buildingBlocksRecipeBluilder(block, Blocks.GRANITE);
                } else if (blockName.contains("prismarine")) {
                    buildingBlocksRecipeBluilder(block, Blocks.PRISMARINE);
                } else if (blockName.contains("purpur")) {
                    buildingBlocksRecipeBluilder(block, Blocks.PURPUR_BLOCK);
                } else if (blockName.contains("deepslate")) {
                    buildingBlocksRecipeBluilder(block, Blocks.COBBLED_DEEPSLATE);
                } else if (blockName.contains("tuff")) {
                    buildingBlocksRecipeBluilder(block, Blocks.TUFF);
                } else if (blockName.contains("packed_mud")) {
                    buildingBlocksRecipeBluilder(block, Blocks.PACKED_MUD);
                } else if (blockName.contains("quartz")) {
                    buildingBlocksRecipeBluilder(block, Blocks.QUARTZ_BLOCK);
                } else if (blockName.contains("nether_bricks")) {
                    buildingBlocksRecipeBluilder(block, Blocks.NETHER_BRICKS);
                } else if (blockName.contains("basalt")) {
                    buildingBlocksRecipeBluilder(block, Blocks.BASALT);
                } else if (blockName.contains("coal")) {
                    buildingBlocksRecipeBluilder(block, Blocks.COAL_BLOCK);
                } else if (blockName.contains("iron")) {
                    buildingBlocksRecipeBluilder(block, Blocks.IRON_BLOCK);
                } else if (blockName.contains("gold")) {
                    buildingBlocksRecipeBluilder(block, Blocks.GOLD_BLOCK);
                } else if (blockName.contains("emerald")) {
                    buildingBlocksRecipeBluilder(block, Blocks.EMERALD_BLOCK);
                } else if (blockName.contains("diamond")) {
                    buildingBlocksRecipeBluilder(block, Blocks.DIAMOND_BLOCK);
                } else if (blockName.contains("copper")) {
                    buildingBlocksRecipeBluilder(block, Blocks.COPPER_BLOCK);
                } else if (blockName.contains("lapis")) {
                    buildingBlocksRecipeBluilder(block, Blocks.LAPIS_BLOCK);
                } else if (blockName.contains("netherite")) {
                    buildingBlocksRecipeBluilder(block, Blocks.NETHERITE_BLOCK);
                } else if (blockName.contains("obsidian")) {
                    buildingBlocksRecipeBluilder(block, Blocks.OBSIDIAN);
                } else if (blockName.contains("amethyst")) {
                    buildingBlocksRecipeBluilder(block, Blocks.AMETHYST_BLOCK);
                } else if (blockName.contains("bedrock")) {
                    buildingBlocksRecipeBluilder(block, Blocks.BEDROCK);
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
                    buildingBlocksRecipeBluilder(item, Blocks.DARK_OAK_PLANKS);
                } else if (itemName.contains("oak")) {
                    buildingBlocksRecipeBluilder(item, Blocks.OAK_PLANKS);
                }
                //stone like
                //sandstone like
                else if (itemName.contains("red_sandstone")) {
                    buildingBlocksRecipeBluilder(item, Blocks.RED_SANDSTONE);
                } else if (itemName.contains("sandstone")) {
                    buildingBlocksRecipeBluilder(item, Blocks.SANDSTONE);
                }
                //other
                else if (itemName.contains("mossy_stone")) {
                    buildingBlocksRecipeBluilder(item, Blocks.MOSSY_COBBLESTONE);
                } else if (itemName.contains("end_stone")) {
                    buildingBlocksRecipeBluilder(item, Blocks.END_STONE);
                } else if (itemName.contains("blackstone")) {
                    buildingBlocksRecipeBluilder(item, Blocks.BLACKSTONE);
                } else if (itemName.contains("redstone")) {
                    buildingBlocksRecipeBluilder(item, Blocks.REDSTONE_BLOCK);
                } else if (itemName.contains("dripstone")) {
                    buildingBlocksRecipeBluilder(item, Blocks.DRIPSTONE_BLOCK);
                } else if (itemName.contains("stone")) {
                    buildingBlocksRecipeBluilder(item, Blocks.COBBLESTONE);
                }
                //other
                else if (itemName.contains("birch")) {
                    buildingBlocksRecipeBluilder(item, Blocks.BIRCH_PLANKS);
                } else if (itemName.contains("spruce")) {
                    buildingBlocksRecipeBluilder(item, Blocks.SPRUCE_PLANKS);
                } else if (itemName.contains("jungle")) {
                    buildingBlocksRecipeBluilder(item, Blocks.JUNGLE_PLANKS);
                } else if (itemName.contains("acacia")) {
                    buildingBlocksRecipeBluilder(item, Blocks.ACACIA_PLANKS);
                } else if (itemName.contains("mangrove")) {
                    buildingBlocksRecipeBluilder(item, Blocks.MANGROVE_PLANKS);
                } else if (itemName.contains("cherry")) {
                    buildingBlocksRecipeBluilder(item, Blocks.CHERRY_PLANKS);
                } else if (itemName.contains("bamboo")) {
                    buildingBlocksRecipeBluilder(item, Blocks.BAMBOO_PLANKS);
                } else if (itemName.contains("crimson")) {
                    buildingBlocksRecipeBluilder(item, Blocks.CRIMSON_PLANKS);
                } else if (itemName.contains("warped")) {
                    buildingBlocksRecipeBluilder(item, Blocks.WARPED_PLANKS);
                } else if (itemName.contains("andesite")) {
                    buildingBlocksRecipeBluilder(item, Blocks.ANDESITE);
                } else if (itemName.contains("diorite")) {
                    buildingBlocksRecipeBluilder(item, Blocks.DIORITE);
                } else if (itemName.contains("granite")) {
                    buildingBlocksRecipeBluilder(item, Blocks.GRANITE);
                } else if (itemName.contains("prismarine")) {
                    buildingBlocksRecipeBluilder(item, Blocks.PRISMARINE);
                } else if (itemName.contains("purpur")) {
                    buildingBlocksRecipeBluilder(item, Blocks.PURPUR_BLOCK);
                } else if (itemName.contains("deepslate")) {
                    buildingBlocksRecipeBluilder(item, Blocks.COBBLED_DEEPSLATE);
                } else if (itemName.contains("tuff")) {
                    buildingBlocksRecipeBluilder(item, Blocks.TUFF);
                } else if (itemName.contains("packed_mud")) {
                    buildingBlocksRecipeBluilder(item, Blocks.PACKED_MUD);
                } else if (itemName.contains("quartz")) {
                    buildingBlocksRecipeBluilder(item, Blocks.QUARTZ_BLOCK);
                } else if (itemName.contains("nether_bricks")) {
                    buildingBlocksRecipeBluilder(item, Blocks.NETHER_BRICKS);
                } else if (itemName.contains("basalt")) {
                    buildingBlocksRecipeBluilder(item, Blocks.BASALT);
                } else if (itemName.contains("coal")) {
                    buildingBlocksRecipeBluilder(item, Blocks.COAL_BLOCK);
                } else if (itemName.contains("iron")) {
                    buildingBlocksRecipeBluilder(item, Blocks.IRON_BLOCK);
                } else if (itemName.contains("gold")) {
                    buildingBlocksRecipeBluilder(item, Blocks.GOLD_BLOCK);
                } else if (itemName.contains("emerald")) {
                    buildingBlocksRecipeBluilder(item, Blocks.EMERALD_BLOCK);
                } else if (itemName.contains("diamond")) {
                    buildingBlocksRecipeBluilder(item, Blocks.DIAMOND_BLOCK);
                } else if (itemName.contains("copper")) {
                    buildingBlocksRecipeBluilder(item, Blocks.COPPER_BLOCK);
                } else if (itemName.contains("lapis")) {
                    buildingBlocksRecipeBluilder(item, Blocks.LAPIS_BLOCK);
                } else if (itemName.contains("netherite")) {
                    buildingBlocksRecipeBluilder(item, Blocks.NETHERITE_BLOCK);
                } else if (itemName.contains("obsidian")) {
                    buildingBlocksRecipeBluilder(item, Blocks.OBSIDIAN);
                } else if (itemName.contains("amethyst")) {
                    buildingBlocksRecipeBluilder(item, Blocks.AMETHYST_BLOCK);
                } else if (itemName.contains("bedrock")) {
                    buildingBlocksRecipeBluilder(item, Blocks.BEDROCK);
                }
            }
        }
    }
    private void buildingBlocksRecipeBluilder(ItemLike craftedBlock, ItemLike ingredient)
    {
        villagerWorkshopResultFromBase(craftedBlock,RecipeCategory.BUILDING_BLOCKS,ingredient);
    }

    private void villagerWorkshopRecipeBuilder()
    {
        Block craftedBlock = BlockRegister.VILLAGER_WORKSHOP.get();
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
        oneItemToAnotherOneRecipeBuilder(resource, result, 1);
    }

    private void oneItemToAnotherOneRecipeBuilder(ItemLike resource, ItemLike result, int numberOutput)
    {
        String resultName = BuiltInRegistries.BLOCK.getKey((Block) ((DeferredBlock<Block>) resource).get()).toString().replace(PremierPainMod.MOD_ID +":","");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result, numberOutput).requires(resource).unlockedBy("has_" + resultName, has(resource)).save(ModRecipeProvider.recipeOutput);
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

    private void shapelessRecipeBuilder(ItemLike result, ItemLike unlockItem, int numberOutput, ItemLike ... resource)
    {
        String resultName = BuiltInRegistries.ITEM.getKey((Item) ((DeferredItem<Item>) result).get()).toString().replace(PremierPainMod.MOD_ID +":","");

        ShapelessRecipeBuilder shapelessRecipeBuilder = ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result, numberOutput);
        for (ItemLike r : resource)
        {
            shapelessRecipeBuilder = shapelessRecipeBuilder.requires(r);
        }

        shapelessRecipeBuilder.unlockedBy("has_" + resultName, has(unlockItem)).save(ModRecipeProvider.recipeOutput);
    }
}