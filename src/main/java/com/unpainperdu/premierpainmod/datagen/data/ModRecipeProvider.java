package com.unpainperdu.premierpainmod.datagen.data;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.datagen.data.tag.mod_tags.ModItemTags;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.villager_shelf.VillagerShelf;
import com.unpainperdu.premierpainmod.level.world.item.crafting.builders.VillagerBrewingStationRecipeBuilder;
import com.unpainperdu.premierpainmod.level.world.item.crafting.builders.VillagerWorkshopRecipeBuilder;
import com.unpainperdu.premierpainmod.level.world.item.items.all_materials_block.VillagerShelfItem;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.ModList;
import com.unpainperdu.premierpainmod.util.register.fluid.FluidRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
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
        //testField
        //fluid
        BrewingStationRecipeBuilder(new FluidStack(Fluids.WATER, 1000), new FluidStack(FluidRegister.PAIN_DIEUX_FLUID, 1000)
                , BlockRegister.CIVILIZATIONS_FLOWER.get(), Items.SUGAR, Items.WHEAT);
        BrewingStationRecipeBuilder(new FluidStack(Fluids.WATER, 1000), new FluidStack(FluidRegister.LA_CHATEAU_FLUID, 1000)
                , BlockRegister.CIVILIZATIONS_FLOWER.get(), Items.SUGAR, Items.GLISTERING_MELON_SLICE, Items.WHEAT);
        BrewingStationRecipeBuilder(new FluidStack(Fluids.WATER, 1000), new FluidStack(FluidRegister.DEBIER_FLUID, 1000)
                , BlockRegister.CIVILIZATIONS_FLOWER.get(), Items.SUGAR, Items.RABBIT_FOOT, ItemRegister.MOUNTAIN_CURRANT.get());
        BrewingStationRecipeBuilder(new FluidStack(Fluids.WATER, 1000), new FluidStack(FluidRegister.ENVAHISSEUR_ROUGE_FLUID, 1000)
                , BlockRegister.CIVILIZATIONS_FLOWER.get(), Items.SUGAR, Items.APPLE, Items.BLAZE_POWDER);
        BrewingStationRecipeBuilder(new FluidStack(Fluids.WATER, 1000), new FluidStack(FluidRegister.RASPBUISSON_FLUID, 1000)
                , BlockRegister.CIVILIZATIONS_FLOWER.get(), Items.SUGAR, Items.APPLE, Items.GLISTERING_MELON_SLICE, ItemRegister.CACTUS_FLOWER_FRUIT.get());
        BrewingStationRecipeBuilder(new FluidStack(Fluids.WATER, 1000), new FluidStack(FluidRegister.LA_BLANCHE_CITADINE_FLUID, 1000)
                , BlockRegister.CIVILIZATIONS_FLOWER.get(), Items.SUGAR, Items.SUGAR_CANE, Items.BONE_MEAL);
        BrewingStationRecipeBuilder(new FluidStack(Fluids.WATER, 1000), new FluidStack(FluidRegister.CRANE_NOIR_FLUID, 1000)
                , BlockRegister.CIVILIZATIONS_FLOWER.get(), Items.SUGAR, Items.IRON_INGOT, Items.INK_SAC);
        BrewingStationRecipeBuilder(new FluidStack(Fluids.WATER, 1000), new FluidStack(FluidRegister.TAK_FLUID, 1000)
                , BlockRegister.CIVILIZATIONS_FLOWER.get(), Items.SUGAR, ItemRegister.SKY_SPEARS_FRUIT.get(), Blocks.NETHERRACK.asItem());
        BrewingStationRecipeBuilder(new FluidStack(Fluids.WATER, 1000), new FluidStack(FluidRegister.DISENDER_FLUID, 1000)
                , BlockRegister.CIVILIZATIONS_FLOWER.get(), Items.SUGAR, Items.FEATHER, ItemRegister.JELLY_HAT.get());
        //item
            //beer
                //empty
        createEmptyContainer();
                //Pain Dieux
        shapelessRecipeBuilder(ItemRegister.PAIN_DIEUX_BOTTLE, ItemRegister.PAIN_DIEUX_BUCKET, 4, ItemRegister.PAIN_DIEUX_BUCKET, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE);
        shapelessRecipeBuilder(ItemRegister.PAIN_DIEUX_GLASS, ItemRegister.PAIN_DIEUX_BOTTLE, 1, ItemRegister.PAIN_DIEUX_BOTTLE, ItemRegister.EMPTY_GLASS);
                //LA_CHATEAU
        shapelessRecipeBuilder(ItemRegister.LA_CHATEAU_BOTTLE, ItemRegister.LA_CHATEAU_BUCKET, 4, ItemRegister.LA_CHATEAU_BUCKET, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE);
        shapelessRecipeBuilder(ItemRegister.LA_CHATEAU_GLASS, ItemRegister.LA_CHATEAU_BOTTLE, 1, ItemRegister.LA_CHATEAU_BOTTLE, ItemRegister.EMPTY_GLASS);
                //DEBIER
        shapelessRecipeBuilder(ItemRegister.DEBIER_BOTTLE, ItemRegister.DEBIER_BUCKET, 4, ItemRegister.DEBIER_BUCKET, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE);
        shapelessRecipeBuilder(ItemRegister.DEBIER_GLASS, ItemRegister.DEBIER_BOTTLE, 1, ItemRegister.DEBIER_BOTTLE, ItemRegister.EMPTY_GLASS);
                //ENVAHISSEUR_ROUGE
        shapelessRecipeBuilder(ItemRegister.ENVAHISSEUR_ROUGE_BOTTLE, ItemRegister.ENVAHISSEUR_ROUGE_BUCKET, 4, ItemRegister.ENVAHISSEUR_ROUGE_BUCKET, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE);
        shapelessRecipeBuilder(ItemRegister.ENVAHISSEUR_ROUGE_GLASS, ItemRegister.ENVAHISSEUR_ROUGE_BOTTLE, 1, ItemRegister.ENVAHISSEUR_ROUGE_BOTTLE, ItemRegister.EMPTY_GLASS);
                //RASPBUISSON
        shapelessRecipeBuilder(ItemRegister.RASPBUISSON_BOTTLE, ItemRegister.RASPBUISSON_BUCKET, 4, ItemRegister.RASPBUISSON_BUCKET, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE);
        shapelessRecipeBuilder(ItemRegister.RASPBUISSON_GLASS, ItemRegister.RASPBUISSON_BOTTLE, 1, ItemRegister.RASPBUISSON_BOTTLE, ItemRegister.EMPTY_GLASS);
                //LA_BLANCHE_CITADINE
        shapelessRecipeBuilder(ItemRegister.LA_BLANCHE_CITADINE_BOTTLE, ItemRegister.LA_BLANCHE_CITADINE_BUCKET, 4, ItemRegister.LA_BLANCHE_CITADINE_BUCKET, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE);
        shapelessRecipeBuilder(ItemRegister.LA_BLANCHE_CITADINE_GLASS, ItemRegister.LA_BLANCHE_CITADINE_BOTTLE, 1, ItemRegister.LA_BLANCHE_CITADINE_BOTTLE, ItemRegister.EMPTY_GLASS);
                //CRANE_NOIR
        shapelessRecipeBuilder(ItemRegister.CRANE_NOIR_BOTTLE, ItemRegister.CRANE_NOIR_BUCKET, 4, ItemRegister.CRANE_NOIR_BUCKET, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE);
        shapelessRecipeBuilder(ItemRegister.CRANE_NOIR_GLASS, ItemRegister.CRANE_NOIR_BOTTLE, 1, ItemRegister.CRANE_NOIR_BOTTLE, ItemRegister.EMPTY_GLASS);
                //TAK
        shapelessRecipeBuilder(ItemRegister.TAK_BOTTLE, ItemRegister.TAK_BUCKET, 4, ItemRegister.TAK_BUCKET, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE);
        shapelessRecipeBuilder(ItemRegister.TAK_GLASS, ItemRegister.TAK_BOTTLE, 1, ItemRegister.TAK_BOTTLE, ItemRegister.EMPTY_GLASS);
                //DISENDER
        shapelessRecipeBuilder(ItemRegister.DISENDER_BOTTLE, ItemRegister.DISENDER_BUCKET, 4, ItemRegister.DISENDER_BUCKET, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE);
        shapelessRecipeBuilder(ItemRegister.DISENDER_GLASS, ItemRegister.DISENDER_BOTTLE, 1, ItemRegister.DISENDER_BOTTLE, ItemRegister.EMPTY_GLASS);
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
        oneItemToAnotherOneRecipeBuilder(BlockRegister.CIVILIZATIONS_FLOWER, Items.ORANGE_DYE, "_mod_flower");
        oneItemToAnotherOneRecipeBuilder(BlockRegister.RUINS_FLOWER, Items.BROWN_DYE, "_mod_flower");
        oneItemToAnotherOneRecipeBuilder(BlockRegister.CURIOSITY_FLOWER, Items.MAGENTA_DYE, "_mod_flower");
            //wood
                //mountain_currant
        oneItemToAnotherOneRecipeBuilder(ModItemTags.MOUNTAIN_CURRANT_LOGS, BlockRegister.MOUNTAIN_CURRANT_PLANKS, 4);
        fourSameIntoOneRecipeBuilder(BlockRegister.MOUNTAIN_CURRANT_WOOD.get(), BlockRegister.MOUNTAIN_CURRANT_LOG.get(), 3);
        fourSameIntoOneRecipeBuilder(BlockRegister.STRIPPED_MOUNTAIN_CURRANT_WOOD.get(), BlockRegister.STRIPPED_MOUNTAIN_CURRANT_LOG.get(), 3);
        stairsRecipeBuilder(BlockRegister.MOUNTAIN_CURRANT_STAIRS.get(), BlockRegister.MOUNTAIN_CURRANT_PLANKS.get());
        slabRecipeBuilder(BlockRegister.MOUNTAIN_CURRANT_SLAB.get(), BlockRegister.MOUNTAIN_CURRANT_PLANKS.get());
        buttonRecipeBuilder(BlockRegister.MOUNTAIN_CURRANT_BUTTON.get(), BlockRegister.MOUNTAIN_CURRANT_PLANKS.get());
        pressurePlateRecipeBuilder(BlockRegister.MOUNTAIN_CURRANT_PRESSURE_PLATE.get(), BlockRegister.MOUNTAIN_CURRANT_PLANKS.get());
        fenceRecipeBuilder(BlockRegister.MOUNTAIN_CURRANT_FENCE.get(), BlockRegister.MOUNTAIN_CURRANT_PLANKS.get());
        fenceGateRecipeBuilder(BlockRegister.MOUNTAIN_CURRANT_FENCE_GATE.get(), BlockRegister.MOUNTAIN_CURRANT_PLANKS.get());
        doorRecipeBuilder(BlockRegister.MOUNTAIN_CURRANT_DOOR.get(), BlockRegister.MOUNTAIN_CURRANT_PLANKS.get());
        trapdoorRecipeBuilder(BlockRegister.MOUNTAIN_CURRANT_TRAPDOOR.get(), BlockRegister.MOUNTAIN_CURRANT_PLANKS.get());
        signRecipeBuilder(ItemRegister.MOUNTAIN_CURRANT_SIGN.get(), BlockRegister.MOUNTAIN_CURRANT_PLANKS.get());
        hangingSignRecipeBuilder(ItemRegister.MOUNTAIN_CURRANT_HANGING_SIGN.get(), BlockRegister.STRIPPED_MOUNTAIN_CURRANT_LOG.get());
        boatRecipeBuilder(ItemRegister.MOUNTAIN_CURRANT_BOAT.get(), BlockRegister.MOUNTAIN_CURRANT_PLANKS.get());
        boatWithChestRecipeBuilder(ItemRegister.MOUNTAIN_CURRANT_CHEST_BOAT.get(), ItemRegister.MOUNTAIN_CURRANT_BOAT.get());
            //moriche_palm
        oneItemToAnotherOneRecipeBuilder(ModItemTags.MORICHE_PALM_LOGS, BlockRegister.MORICHE_PALM_PLANKS, 4);
        fourSameIntoOneRecipeBuilder(BlockRegister.MORICHE_PALM_WOOD.get(), BlockRegister.MORICHE_PALM_LOG.get(), 3);
        fourSameIntoOneRecipeBuilder(BlockRegister.STRIPPED_MORICHE_PALM_WOOD.get(), BlockRegister.STRIPPED_MORICHE_PALM_LOG.get(), 3);
        stairsRecipeBuilder(BlockRegister.MORICHE_PALM_STAIRS.get(), BlockRegister.MORICHE_PALM_PLANKS.get());
        slabRecipeBuilder(BlockRegister.MORICHE_PALM_SLAB.get(), BlockRegister.MORICHE_PALM_PLANKS.get());
        buttonRecipeBuilder(BlockRegister.MORICHE_PALM_BUTTON.get(), BlockRegister.MORICHE_PALM_PLANKS.get());
        pressurePlateRecipeBuilder(BlockRegister.MORICHE_PALM_PRESSURE_PLATE.get(), BlockRegister.MORICHE_PALM_PLANKS.get());
        fenceRecipeBuilder(BlockRegister.MORICHE_PALM_FENCE.get(), BlockRegister.MORICHE_PALM_PLANKS.get());
        fenceGateRecipeBuilder(BlockRegister.MORICHE_PALM_FENCE_GATE.get(), BlockRegister.MORICHE_PALM_PLANKS.get());
        doorRecipeBuilder(BlockRegister.MORICHE_PALM_DOOR.get(), BlockRegister.MORICHE_PALM_PLANKS.get());
        trapdoorRecipeBuilder(BlockRegister.MORICHE_PALM_TRAPDOOR.get(), BlockRegister.MORICHE_PALM_PLANKS.get());
        signRecipeBuilder(ItemRegister.MORICHE_PALM_SIGN.get(), BlockRegister.MORICHE_PALM_PLANKS.get());
        hangingSignRecipeBuilder(ItemRegister.MORICHE_PALM_HANGING_SIGN.get(), BlockRegister.STRIPPED_MORICHE_PALM_LOG.get());
        boatRecipeBuilder(ItemRegister.MORICHE_PALM_BOAT.get(), BlockRegister.MORICHE_PALM_PLANKS.get());
        boatWithChestRecipeBuilder(ItemRegister.MORICHE_PALM_CHEST_BOAT.get(), ItemRegister.MORICHE_PALM_BOAT.get());
            //achiote
        oneItemToAnotherOneRecipeBuilder(ModItemTags.ACHIOTE_LOGS, BlockRegister.ACHIOTE_PLANKS, 4);
        fourSameIntoOneRecipeBuilder(BlockRegister.ACHIOTE_WOOD.get(), BlockRegister.ACHIOTE_LOG.get(), 3);
        fourSameIntoOneRecipeBuilder(BlockRegister.STRIPPED_ACHIOTE_WOOD.get(), BlockRegister.STRIPPED_ACHIOTE_LOG.get(), 3);
        stairsRecipeBuilder(BlockRegister.ACHIOTE_STAIRS.get(), BlockRegister.ACHIOTE_PLANKS.get());
        slabRecipeBuilder(BlockRegister.ACHIOTE_SLAB.get(), BlockRegister.ACHIOTE_PLANKS.get());
        buttonRecipeBuilder(BlockRegister.ACHIOTE_BUTTON.get(), BlockRegister.ACHIOTE_PLANKS.get());
        pressurePlateRecipeBuilder(BlockRegister.ACHIOTE_PRESSURE_PLATE.get(), BlockRegister.ACHIOTE_PLANKS.get());
        fenceRecipeBuilder(BlockRegister.ACHIOTE_FENCE.get(), BlockRegister.ACHIOTE_PLANKS.get());
        fenceGateRecipeBuilder(BlockRegister.ACHIOTE_FENCE_GATE.get(), BlockRegister.ACHIOTE_PLANKS.get());
        doorRecipeBuilder(BlockRegister.ACHIOTE_DOOR.get(), BlockRegister.ACHIOTE_PLANKS.get());
        trapdoorRecipeBuilder(BlockRegister.ACHIOTE_TRAPDOOR.get(), BlockRegister.ACHIOTE_PLANKS.get());
        signRecipeBuilder(ItemRegister.ACHIOTE_SIGN.get(), BlockRegister.ACHIOTE_PLANKS.get());
        hangingSignRecipeBuilder(ItemRegister.ACHIOTE_HANGING_SIGN.get(), BlockRegister.STRIPPED_ACHIOTE_LOG.get());
        boatRecipeBuilder(ItemRegister.ACHIOTE_BOAT.get(), BlockRegister.ACHIOTE_PLANKS.get());
        boatWithChestRecipeBuilder(ItemRegister.ACHIOTE_CHEST_BOAT.get(), ItemRegister.ACHIOTE_BOAT.get());
            //all materials recipes
        for(Block block : ModList.getAllMaterialsBlocks())
        {
            String blockName = BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MOD_ID +":","");
            if(!(block instanceof VillagerShelf))
            {
                // order mater for compose material
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
                else if (blockName.contains("moriche_palm"))
                {
                    buildingBlocksRecipeBluilder(block, BlockRegister.MORICHE_PALM_PLANKS);
                }
                else if (blockName.contains("achiote"))
                {
                    buildingBlocksRecipeBluilder(block, BlockRegister.ACHIOTE_PLANKS);
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
                if (itemName.contains("dark_oak"))
                {
                    buildingBlocksRecipeBluilder(item, Blocks.DARK_OAK_PLANKS);
                }
                else if (itemName.contains("pale_oak"))
                {
                    buildingBlocksRecipeBluilder(item, Items.STICK);
                }
                else if (itemName.contains("oak"))
                {
                    buildingBlocksRecipeBluilder(item, Blocks.OAK_PLANKS);
                }
                //stone like
                //sandstone like
                else if (itemName.contains("red_sandstone"))
                {
                    buildingBlocksRecipeBluilder(item, Blocks.RED_SANDSTONE);
                }
                else if (itemName.contains("sandstone"))
                {
                    buildingBlocksRecipeBluilder(item, Blocks.SANDSTONE);
                }
                //other
                else if (itemName.contains("mossy_stone"))
                {
                    buildingBlocksRecipeBluilder(item, Blocks.MOSSY_COBBLESTONE);
                }
                else if (itemName.contains("mountain_currant"))
                {
                    buildingBlocksRecipeBluilder(item, BlockRegister.MOUNTAIN_CURRANT_PLANKS);
                }
                else if (itemName.contains("moriche_palm"))
                {
                    buildingBlocksRecipeBluilder(item, BlockRegister.MORICHE_PALM_PLANKS);
                }
                else if (itemName.contains("end_stone"))
                {
                    buildingBlocksRecipeBluilder(item, Blocks.END_STONE);
                }
                else if (itemName.contains("blackstone"))
                {
                    buildingBlocksRecipeBluilder(item, Blocks.BLACKSTONE);
                }
                else if (itemName.contains("redstone"))
                {
                    buildingBlocksRecipeBluilder(item, Blocks.REDSTONE_BLOCK);
                }
                else if (itemName.contains("dripstone"))
                {
                    buildingBlocksRecipeBluilder(item, Blocks.DRIPSTONE_BLOCK);
                }
                else if (itemName.contains("stone"))
                {
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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result, numberOutput)
                .requires(resource)
                .unlockedBy("has_" + resultName, has(resource))
                .save(ModRecipeProvider.recipeOutput);
    }

    private void oneItemToAnotherOneRecipeBuilder(TagKey<Item> resource, ItemLike result)
    {
        oneItemToAnotherOneRecipeBuilder(resource, result, 1);
    }

    private void oneItemToAnotherOneRecipeBuilder(TagKey<Item> resource, ItemLike result, int numberOutput)
    {
        String resultName = getName(result.asItem());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result, numberOutput)
                .requires(resource)
                .unlockedBy("has_" + resultName, has(resource))
                .save(ModRecipeProvider.recipeOutput);
    }

    /*
    * Use it if the recipe may result a vanilla item
    * @name add itself at the name of folder name
    **/
    private void oneItemToAnotherOneRecipeBuilder(ItemLike resource, ItemLike result, String name)
    {
        oneItemToAnotherOneRecipeBuilder(resource, result, 1, name);
    }

    private void oneItemToAnotherOneRecipeBuilder(ItemLike resource, ItemLike result, int numberOutput, String name)
    {
        String resultName = getName(result.asItem());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result, numberOutput)
                .requires(resource)
                .unlockedBy("has_" + resultName, has(resource))
                .save(ModRecipeProvider.recipeOutput, "premierpainmod:"+resultName+name);
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
                .save(ModRecipeProvider.recipeOutput, "premierpainmod:" + resultName + "_furnace");
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

    private void stairsRecipeBuilder(Block result, Block blockNeeded)
    {
        String resultName = getName(result);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 4))
                .define('#', blockNeeded)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy("has_" + resultName + "_left", has(blockNeeded))
                .save(ModRecipeProvider.recipeOutput);
    }

    private void slabRecipeBuilder(Block result, Block blockNeeded)
    {
        String resultName = getName(result);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 6))
                .define('#', blockNeeded)
                .pattern("###")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(ModRecipeProvider.recipeOutput);
    }

    private void buttonRecipeBuilder(Block result, Block blockNeeded)
    {
        String resultName = getName(result);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 1))
                .define('#', blockNeeded)
                .pattern("#")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(ModRecipeProvider.recipeOutput);
    }

    private void pressurePlateRecipeBuilder(Block result, Block blockNeeded)
    {
        String resultName = getName(result);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 1))
                .define('#', blockNeeded)
                .pattern("##")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(ModRecipeProvider.recipeOutput);
    }

    private void fenceRecipeBuilder(Block result, Block blockNeeded)
    {
        String resultName = getName(result);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 3))
                .define('#', blockNeeded)
                .define('s', Items.STICK)
                .pattern("#s#")
                .pattern("#s#")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(ModRecipeProvider.recipeOutput);
    }

    private void fenceGateRecipeBuilder(Block result, Block blockNeeded)
    {
        String resultName = getName(result);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 1))
                .define('#', blockNeeded)
                .define('s', Items.STICK)
                .pattern("s#s")
                .pattern("s#s")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(ModRecipeProvider.recipeOutput);
    }

    private void doorRecipeBuilder(Block result, Block blockNeeded)
    {
        String resultName = getName(result);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 3))
                .define('#', blockNeeded)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(ModRecipeProvider.recipeOutput);
    }

    private void trapdoorRecipeBuilder(Block result, Block blockNeeded)
    {
        String resultName = getName(result);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 2))
                .define('#', blockNeeded)
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(ModRecipeProvider.recipeOutput);
    }

    private void signRecipeBuilder(Item result, Block blockNeeded)
    {
        String resultName = getName(result);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 3))
                .define('#', blockNeeded)
                .define('t', Items.STICK)
                .pattern("###")
                .pattern("###")
                .pattern(" t ")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(ModRecipeProvider.recipeOutput);
    }

    private void hangingSignRecipeBuilder(Item result, Block blockNeeded)
    {
        String resultName = getName(result);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 6))
                .define('#', blockNeeded)
                .define('t', Items.CHAIN)
                .pattern("t t")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(ModRecipeProvider.recipeOutput);
    }

    private void boatRecipeBuilder(Item result, Block blockNeeded)
    {
        String resultName = getName(result);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 1))
                .define('#', blockNeeded)
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(ModRecipeProvider.recipeOutput, "premierpainmod:"+resultName+"_custom");
    }
    private void boatWithChestRecipeBuilder(Item ChestBoat, Item boat)
    {
        String resultName = getName(ChestBoat);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(ChestBoat, 1))
                .define('$', Blocks.CHEST)
                .define('#', boat)
                .pattern("$")
                .pattern("#")
                .unlockedBy("has_" + resultName, has(boat))
                .save(ModRecipeProvider.recipeOutput, "premierpainmod:"+resultName+"_custom");
    }

    private void fourSameIntoOneRecipeBuilder(Block result, Block blockNeeded)
    {
        fourSameIntoOneRecipeBuilder(result, blockNeeded, 1);
    }
    private void fourSameIntoOneRecipeBuilder(Block result, Block blockNeeded, int resultCount)
    {
        String resultName = getName(result);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, resultCount))
                .define('#', blockNeeded)
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(ModRecipeProvider.recipeOutput);
    }

    private void BrewingStationRecipeBuilder(FluidStack fluidInput, FluidStack fluidOutput, ItemLike ... itemLikes)
    {
        String resultName = getName(fluidOutput);
        SizedFluidIngredient sizedFluidIngredient = new SizedFluidIngredient(FluidIngredient.single(fluidInput),1000);
        ArrayList<Ingredient> ingredientList = new ArrayList<>();
        for (ItemLike itemLike : itemLikes)
        {
            ingredientList.add(Ingredient.of(itemLike));
        }
        new VillagerBrewingStationRecipeBuilder(sizedFluidIngredient, ingredientList, fluidOutput)
                .unlockedBy("has_civilization_flower", has(BlockRegister.CIVILIZATIONS_FLOWER))
                .save(ModRecipeProvider.recipeOutput, ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "brewing_" + resultName));
    }

    private void createEmptyContainer()
    {
        TagKey<Item> wood = ItemTags.PLANKS;
        Item ironNugget = Items.IRON_NUGGET;
        Block glass = Blocks.GLASS;

        Item result = ItemRegister.EMPTY_GLASS.get();
        String resultName = getName(result);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 5))
                .define('#', glass)
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_" + resultName, has(glass))
                .save(ModRecipeProvider.recipeOutput);

        result = ItemRegister.EMPTY_BOTTLE.get();
        resultName = getName(result);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 7))
                .define('#', glass)
                .pattern("# #")
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_" + resultName, has(glass))
                .save(ModRecipeProvider.recipeOutput);

        result = ItemRegister.EMPTY_MUG.get();
        resultName = getName(result);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 7))
                .define('#', wood)
                .define('$', ironNugget)
                .pattern("# #")
                .pattern("$ $")
                .pattern("###")
                .unlockedBy("has_" + resultName, has(glass))
                .save(ModRecipeProvider.recipeOutput);
    }

    private String getName(Block block)
    {
        return getKey(block).toString().replace(PremierPainMod.MOD_ID +":","");
    }

    private String getName(Item item)
    {
        String result = getKey(item).toString().replace(PremierPainMod.MOD_ID +":","");
        result = result.replace("minecraft:","");
        return result;
    }

    private String getName(FluidStack fluid)
    {
        String result = getKey(fluid.getFluid().getBucket()).toString().replace(PremierPainMod.MOD_ID +":","");
        result = result.replace("minecraft:","");
        return result;
    }

    private ResourceLocation getKey(Block block)
    {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private ResourceLocation getKey(Item item)
    {
        return BuiltInRegistries.ITEM.getKey(item);
    }
}