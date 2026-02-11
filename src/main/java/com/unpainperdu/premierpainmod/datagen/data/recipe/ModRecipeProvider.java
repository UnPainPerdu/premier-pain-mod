package com.unpainperdu.premierpainmod.datagen.data.recipe;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.datagen.data.tag.mod_tags.ModItemTags;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.crafting_block.CookingPotBlockEntity;
import com.unpainperdu.premierpainmod.level.world.fluid.beer.*;
import com.unpainperdu.premierpainmod.level.world.fluid.oil.MorichePalmOilFluid;
import com.unpainperdu.premierpainmod.level.world.item.crafting.builders.CookingPotRecipeBuilder;
import com.unpainperdu.premierpainmod.level.world.item.crafting.builders.VillagerBrewingStationRecipeBuilder;
import com.unpainperdu.premierpainmod.level.world.item.crafting.builders.VillagerWorkshopRecipeBuilder;
import com.unpainperdu.premierpainmod.util.mod_list.ModItemList;
import com.unpainperdu.premierpainmod.util.register.Item.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.block.AllMaterialsBlockEnum;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.block.WoodBlockEnum;
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
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister.getFluid;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    protected RecipeOutput recipeOutput;

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput)
    {
        this.recipeOutput = recipeOutput;
        //cooking_pot
        cookingPotRecipeBuilder(getFluid(MorichePalmOilFluid.NAME).get(), 10, Items.POTATO, ItemRegister.HALF_COOKED_FRIES);
        cookingPotRecipeBuilder(getFluid(MorichePalmOilFluid.NAME).get(), 10, ItemRegister.HALF_COOKED_FRIES, ItemRegister.FRIES);
        cookingPotRecipeBuilder(Fluids.WATER, 10, Items.POTATO, Items.BAKED_POTATO);
        cookingPotRecipeBuilder(getFluid(MorichePalmOilFluid.NAME).get(), 10, ItemRegister.UNCOOKED_BREADED_CHICKEN_WING, ItemRegister.BREADED_CHICKEN_WING);
        cookingPotRecipeBuilder(getFluid(MorichePalmOilFluid.NAME).get(), 10, ItemRegister.UNCOOKED_BREADED_FISH, ItemRegister.BREADED_FISH);
        cookingPotRecipeBuilder(getFluid(MorichePalmOilFluid.NAME).get(), 10, ItemRegister.UNCOOKED_SCHNITZEL, ItemRegister.SCHNITZEL);
        cookingPotRecipeBuilder(Fluids.WATER, 10, Items.EGG, ItemRegister.HARD_BOILED_EGG);
        //fluid
        //  beer
        brewingStationRecipeBuilder(new FluidStack(Fluids.WATER, 1000), new FluidStack(getFluid(PainDieuxFluid.NAME), 1000)
                , BlockRegister.CIVILIZATIONS_FLOWER.get(), Items.SUGAR, Items.WHEAT);
        brewingStationRecipeBuilder(new FluidStack(Fluids.WATER, 1000), new FluidStack(getFluid(LaChateauFluid.NAME), 1000)
                , BlockRegister.CIVILIZATIONS_FLOWER.get(), Items.SUGAR, Items.GLISTERING_MELON_SLICE, ItemRegister.ACHIOTE_FRUIT);
        brewingStationRecipeBuilder(new FluidStack(Fluids.WATER, 1000), new FluidStack(getFluid(DeBierFluid.NAME), 1000)
                , BlockRegister.CIVILIZATIONS_FLOWER.get(), Items.SUGAR, Items.RABBIT_FOOT, ItemRegister.MOUNTAIN_CURRANT.get());
        brewingStationRecipeBuilder(new FluidStack(Fluids.WATER, 1000), new FluidStack(getFluid(EnvahisseurRougeFluid.NAME), 1000)
                , BlockRegister.CIVILIZATIONS_FLOWER.get(), Items.SUGAR, Items.APPLE, Items.BLAZE_POWDER);
        brewingStationRecipeBuilder(new FluidStack(Fluids.WATER, 1000), new FluidStack(getFluid(RaspBuissonFluid.NAME), 1000)
                , BlockRegister.CIVILIZATIONS_FLOWER.get(), Items.SUGAR, Items.APPLE, Items.GLISTERING_MELON_SLICE, ItemRegister.CACTUS_FLOWER_FRUIT.get());
        brewingStationRecipeBuilder(new FluidStack(Fluids.WATER, 1000), new FluidStack(getFluid(LaBlancheCitadineFluid.NAME), 1000)
                , BlockRegister.CIVILIZATIONS_FLOWER.get(), Items.SUGAR, Items.SUGAR_CANE, Items.BONE_MEAL);
        brewingStationRecipeBuilder(new FluidStack(Fluids.WATER, 1000), new FluidStack(getFluid(CraneNoirFluid.NAME), 1000)
                , BlockRegister.CIVILIZATIONS_FLOWER.get(), Items.SUGAR, Items.IRON_INGOT, Items.INK_SAC);
        brewingStationRecipeBuilder(new FluidStack(Fluids.WATER, 1000), new FluidStack(getFluid(TakFluid.NAME), 1000)
                , BlockRegister.CIVILIZATIONS_FLOWER.get(), Items.SUGAR, ItemRegister.SKY_SPEARS_FRUIT.get(), Blocks.NETHERRACK.asItem());
        brewingStationRecipeBuilder(new FluidStack(Fluids.WATER, 1000), new FluidStack(getFluid(DisEnderFluid.NAME), 1000)
                , BlockRegister.CIVILIZATIONS_FLOWER.get(), Items.SUGAR, Items.FEATHER, ItemRegister.JELLY_HAT.get());
        //standart craft
        //  item
        //      fluid
        //          oil
        shapelessRecipeBuilder(ItemRegister.MORICHE_PALM_OIL_BUCKET, ItemRegister.MORICHE_PALM_FRUIT, 1, Items.BUCKET, ItemRegister.MORICHE_PALM_FRUIT, ItemRegister.MORICHE_PALM_FRUIT, ItemRegister.MORICHE_PALM_FRUIT, ItemRegister.MORICHE_PALM_FRUIT);
        //          beer
        //              empty
        createEmptyBeerContainer();
        //              Pain Dieux
        shapelessRecipeBuilder(ItemRegister.PAIN_DIEUX_BOTTLE, ItemRegister.PAIN_DIEUX_BUCKET, 4, ItemRegister.PAIN_DIEUX_BUCKET, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE);
        shapelessRecipeBuilder(ItemRegister.PAIN_DIEUX_GLASS, ItemRegister.PAIN_DIEUX_BOTTLE, 1, ItemRegister.PAIN_DIEUX_BOTTLE, ItemRegister.EMPTY_GLASS);
        //              LA_CHATEAU
        shapelessRecipeBuilder(ItemRegister.LA_CHATEAU_BOTTLE, ItemRegister.LA_CHATEAU_BUCKET, 4, ItemRegister.LA_CHATEAU_BUCKET, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE);
        shapelessRecipeBuilder(ItemRegister.LA_CHATEAU_GLASS, ItemRegister.LA_CHATEAU_BOTTLE, 1, ItemRegister.LA_CHATEAU_BOTTLE, ItemRegister.EMPTY_GLASS);
        //              DEBIER
        shapelessRecipeBuilder(ItemRegister.DEBIER_BOTTLE, ItemRegister.DEBIER_BUCKET, 4, ItemRegister.DEBIER_BUCKET, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE);
        shapelessRecipeBuilder(ItemRegister.DEBIER_GLASS, ItemRegister.DEBIER_BOTTLE, 1, ItemRegister.DEBIER_BOTTLE, ItemRegister.EMPTY_GLASS);
        //              ENVAHISSEUR_ROUGE
        shapelessRecipeBuilder(ItemRegister.ENVAHISSEUR_ROUGE_BOTTLE, ItemRegister.ENVAHISSEUR_ROUGE_BUCKET, 4, ItemRegister.ENVAHISSEUR_ROUGE_BUCKET, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE);
        shapelessRecipeBuilder(ItemRegister.ENVAHISSEUR_ROUGE_GLASS, ItemRegister.ENVAHISSEUR_ROUGE_BOTTLE, 1, ItemRegister.ENVAHISSEUR_ROUGE_BOTTLE, ItemRegister.EMPTY_GLASS);
        //              RASPBUISSON
        shapelessRecipeBuilder(ItemRegister.RASPBUISSON_BOTTLE, ItemRegister.RASPBUISSON_BUCKET, 4, ItemRegister.RASPBUISSON_BUCKET, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE);
        shapelessRecipeBuilder(ItemRegister.RASPBUISSON_GLASS, ItemRegister.RASPBUISSON_BOTTLE, 1, ItemRegister.RASPBUISSON_BOTTLE, ItemRegister.EMPTY_GLASS);
        //              LA_BLANCHE_CITADINE
        shapelessRecipeBuilder(ItemRegister.LA_BLANCHE_CITADINE_BOTTLE, ItemRegister.LA_BLANCHE_CITADINE_BUCKET, 4, ItemRegister.LA_BLANCHE_CITADINE_BUCKET, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE);
        shapelessRecipeBuilder(ItemRegister.LA_BLANCHE_CITADINE_GLASS, ItemRegister.LA_BLANCHE_CITADINE_BOTTLE, 1, ItemRegister.LA_BLANCHE_CITADINE_BOTTLE, ItemRegister.EMPTY_GLASS);
        //              CRANE_NOIR
        shapelessRecipeBuilder(ItemRegister.CRANE_NOIR_BOTTLE, ItemRegister.CRANE_NOIR_BUCKET, 4, ItemRegister.CRANE_NOIR_BUCKET, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE);
        shapelessRecipeBuilder(ItemRegister.CRANE_NOIR_GLASS, ItemRegister.CRANE_NOIR_BOTTLE, 1, ItemRegister.CRANE_NOIR_BOTTLE, ItemRegister.EMPTY_GLASS);
        //              TAK
        shapelessRecipeBuilder(ItemRegister.TAK_BOTTLE, ItemRegister.TAK_BUCKET, 4, ItemRegister.TAK_BUCKET, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE);
        shapelessRecipeBuilder(ItemRegister.TAK_GLASS, ItemRegister.TAK_BOTTLE, 1, ItemRegister.TAK_BOTTLE, ItemRegister.EMPTY_GLASS);
        //              DISENDER
        shapelessRecipeBuilder(ItemRegister.DISENDER_BOTTLE, ItemRegister.DISENDER_BUCKET, 4, ItemRegister.DISENDER_BUCKET, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE, ItemRegister.EMPTY_BOTTLE);
        shapelessRecipeBuilder(ItemRegister.DISENDER_GLASS, ItemRegister.DISENDER_BOTTLE, 1, ItemRegister.DISENDER_BOTTLE, ItemRegister.EMPTY_GLASS);
        //      food
        shapelessRecipeBuilder(ItemRegister.FRIES_CONE, ItemRegister.FRIES, 1, Items.PAPER, ItemRegister.FRIES, ItemRegister.FRIES, ItemRegister.FRIES);
        shapelessRecipeBuilder(ItemRegister.BREADING, Items.BREAD, 3, Items.BREAD);
        shapelessRecipeBuilder(ItemRegister.UNCOOKED_BREADED_CHICKEN_WING, Items.CHICKEN, 2, Items.CHICKEN, ItemRegister.BREADING);
        shapelessRecipeBuilder(ItemRegister.UNCOOKED_BREADED_FISH, Items.SALMON, 1, Items.SALMON, ItemRegister.BREADING);
        shapelessRecipeBuilder(ItemRegister.UNCOOKED_BREADED_FISH, Items.COD, 1, Items.COD, ItemRegister.BREADING);
        shapelessRecipeBuilder(ItemRegister.UNCOOKED_SCHNITZEL, Items.BEEF, 1, Items.BEEF, ItemRegister.BREADING);
        shapelessRecipeBuilder(ItemRegister.UNCOOKED_SCHNITZEL, Items.PORKCHOP, 1, Items.PORKCHOP, ItemRegister.BREADING);
        //      vegetation
        oneItemToAnotherOneRecipeBuilder(BlockRegister.CACTUS_FLOWER_BLOCK, ItemRegister.CACTUS_FLOWER_FRUIT);
        oneItemToAnotherOneRecipeBuilder(BlockRegister.SKY_SPEARS_FLOWER, ItemRegister.SKY_SPEARS_FRUIT);
        oneItemToAnotherOneRecipeBuilder(BlockRegister.JELLYSHROOM, ItemRegister.JELLY_HAT);
        //      stew
        shapelessRecipeBuilder(ItemRegister.JELLYSHROOM_STEW, ItemRegister.JELLY_HAT, 1, Items.BOWL, ItemRegister.JELLY_HAT, Items.SUGAR);
        shapelessRecipeBuilder(ItemRegister.CACTUS_STEW, ItemRegister.CACTUS_FLOWER_FRUIT, 1, Items.BOWL, ItemRegister.CACTUS_FLOWER_FRUIT, Items.SUGAR);
        shapelessRecipeBuilder(ItemRegister.POTATOES_AND_SPEARS_BOWL, ItemRegister.SKY_SPEARS_FRUIT, 1, Items.BOWL, ItemRegister.SKY_SPEARS_FRUIT, Items.BAKED_POTATO);
        shapelessRecipeBuilder(ItemRegister.FRUITS_BOWL, ItemRegister.CACTUS_FLOWER_FRUIT, 1, Items.BOWL, ItemRegister.CACTUS_FLOWER_FRUIT, Items.SWEET_BERRIES, Items.GLOW_BERRIES, Items.APPLE);
        //  block
        //      crafting block
        villagerWorkshopRecipeBuilder();
        cookingPotBlockRecipeBuilder();
        //      geology
        //          gypsum
        fourSameIntoOneRecipeBuilder(BlockRegister.GYPSUM, ItemRegister.GYPSUM_SHARD);
        oneItemToAnotherOneRecipeBuilder(ItemRegister.GYPSUM_SHARD, BlockRegister.GYPSUM_CLUSTER);
        cuttedStoneRecipeBuilder(ItemRegister.GYPSUM_SHARD, BlockRegister.POINTED_GYPSUM, 1);
        fourSameIntoOneRecipeBuilder(BlockRegister.GYPSUM, BlockRegister.POINTED_GYPSUM, 2);
        stairsRecipeBuilder(BlockRegister.GYPSUM_STAIRS, BlockRegister.GYPSUM);
        slabRecipeBuilder(BlockRegister.GYPSUM_SLAB, BlockRegister.GYPSUM);
        trapdoorOrWallRecipeBuilder(BlockRegister.GYPSUM_WALL, BlockRegister.GYPSUM, 1);
        fourSameIntoOneRecipeBuilder(BlockRegister.POLISHED_GYPSUM, BlockRegister.GYPSUM, 4);
        stairsRecipeBuilder(BlockRegister.POLISHED_GYPSUM_STAIRS, BlockRegister.POLISHED_GYPSUM);
        slabRecipeBuilder(BlockRegister.POLISHED_GYPSUM_SLAB, BlockRegister.POLISHED_GYPSUM);
        trapdoorOrWallRecipeBuilder(BlockRegister.POLISHED_GYPSUM_WALL, BlockRegister.POLISHED_GYPSUM, 1);
        cuttedStoneRecipeBuilder(BlockRegister.POLISHED_GYPSUM_SLAB, BlockRegister.CUTTED_GYPSUM, 1);
        //      misc
        oneItemToAnotherOneRecipeInFurnaceBuilder(BlockRegister.FLOWERED_CACTUS_BLOCK, Items.GREEN_DYE, RecipeCategory.MISC, 0.2f, 300);
        //      flower to colorant
        oneItemToAnotherOneRecipeBuilder(BlockRegister.CIVILIZATIONS_FLOWER, Items.ORANGE_DYE);
        oneItemToAnotherOneRecipeBuilder(BlockRegister.RUINS_FLOWER, Items.BROWN_DYE);
        oneItemToAnotherOneRecipeBuilder(BlockRegister.CURIOSITY_FLOWER, Items.MAGENTA_DYE);
        oneItemToAnotherOneRecipeBuilder(BlockRegister.FALLING_HELICON_FLOWER, Items.RED_DYE, 2);
        //      wood
        //          mountain_currant
        generateWoodRecipe(BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP, ItemRegister.ITEM_MOUNTAIN_CURRANT_WOOD_TYPE_MAP, ModItemTags.MOUNTAIN_CURRANT_LOGS);
        //          moriche_palm
        generateWoodRecipe(BlockRegister.MORICHE_PALM_WOOD_TYPE_MAP, ItemRegister.ITEM_MORICHE_PALM_WOOD_TYPE_MAP, ModItemTags.MORICHE_PALM_LOGS);
        //          achiote
        generateWoodRecipe(BlockRegister.ACHIOTE_WOOD_TYPE_MAP, ItemRegister.ITEM_ACHIOTE_WOOD_TYPE_MAP, ModItemTags.ACHIOTE_LOGS);
        //          weeping willow
        generateWoodRecipe(BlockRegister.WEEPING_WILLOW_WOOD_TYPE_MAP, ItemRegister.ITEM_WEEPING_WILLOW_WOOD_TYPE_MAP, ModItemTags.WEEPING_WILLOW_LOGS);
        //stone cutter
        //  geology
        //      gypsum
        stonecutterResultFromBase(this.recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockRegister.GYPSUM_STAIRS, BlockRegister.GYPSUM);
        stonecutterResultFromBase(this.recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockRegister.GYPSUM_SLAB, BlockRegister.GYPSUM, 2);
        stonecutterResultFromBase(this.recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockRegister.GYPSUM_WALL, BlockRegister.GYPSUM);
        stonecutterResultFromBase(this.recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockRegister.CUTTED_GYPSUM, BlockRegister.GYPSUM);
        stonecutterResultFromBase(this.recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockRegister.POLISHED_GYPSUM, BlockRegister.GYPSUM);
        stonecutterResultFromBase(this.recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockRegister.POLISHED_GYPSUM_STAIRS, BlockRegister.GYPSUM);
        stonecutterResultFromBase(this.recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockRegister.POLISHED_GYPSUM_SLAB, BlockRegister.GYPSUM, 2);
        stonecutterResultFromBase(this.recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockRegister.POLISHED_GYPSUM_WALL, BlockRegister.GYPSUM);
        stonecutterResultFromBase(this.recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockRegister.POLISHED_GYPSUM_STAIRS, BlockRegister.POLISHED_GYPSUM);
        stonecutterResultFromBase(this.recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockRegister.POLISHED_GYPSUM_SLAB, BlockRegister.POLISHED_GYPSUM, 2);
        stonecutterResultFromBase(this.recipeOutput, RecipeCategory.BUILDING_BLOCKS, BlockRegister.POLISHED_GYPSUM_WALL, BlockRegister.POLISHED_GYPSUM);
        //villager workshop
        //  all materials recipes
        for (Item item : ModItemList.getAllMaterialsBlocksAsItem())
        {
            String itemName = BuiltInRegistries.ITEM.getKey(item).toString().replace(PremierPainMod.MOD_ID + ":", "");
            //oak like
            if (itemName.contains("dark_oak"))
            {
                villagerWorkshopResultFromBase(item, Blocks.DARK_OAK_PLANKS, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("pale_oak"))
            {
                villagerWorkshopResultFromBase(item, Items.STICK, RecipeCategory.BUILDING_BLOCKS); //TODO replace with paleOakPlank when updating MC version
            }
            else if (itemName.contains("oak"))
            {
                villagerWorkshopResultFromBase(item, Blocks.OAK_PLANKS, RecipeCategory.BUILDING_BLOCKS);
            }
            //stone like
            //sandstone like
            else if (itemName.contains("red_sandstone"))
            {
                villagerWorkshopResultFromBase(item, Blocks.RED_SANDSTONE, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("sandstone"))
            {
                villagerWorkshopResultFromBase(item, Blocks.SANDSTONE, RecipeCategory.BUILDING_BLOCKS);
            }
            //other
            else if (itemName.contains("mossy_stone"))
            {
                villagerWorkshopResultFromBase(item, Blocks.MOSSY_COBBLESTONE, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("mountain_currant"))
            {
                villagerWorkshopResultFromBase(item, BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get(WoodBlockEnum.PLANKS.toString()), RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("moriche_palm"))
            {
                villagerWorkshopResultFromBase(item, BlockRegister.MORICHE_PALM_WOOD_TYPE_MAP.get(WoodBlockEnum.PLANKS.toString()), RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("achiote"))
            {
                villagerWorkshopResultFromBase(item, BlockRegister.ACHIOTE_WOOD_TYPE_MAP.get(WoodBlockEnum.PLANKS.toString()), RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("weeping_willow"))
            {
                villagerWorkshopResultFromBase(item, BlockRegister.WEEPING_WILLOW_WOOD_TYPE_MAP.get(WoodBlockEnum.PLANKS.toString()), RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("end_stone"))
            {
                villagerWorkshopResultFromBase(item, Blocks.END_STONE, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("blackstone"))
            {
                villagerWorkshopResultFromBase(item, Blocks.BLACKSTONE, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("redstone"))
            {
                villagerWorkshopResultFromBase(item, Blocks.REDSTONE_BLOCK, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("dripstone"))
            {
                villagerWorkshopResultFromBase(item, Blocks.DRIPSTONE_BLOCK, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("stone"))
            {
                villagerWorkshopResultFromBase(item, Blocks.COBBLESTONE, RecipeCategory.BUILDING_BLOCKS);
            }
            //other
            else if (itemName.contains("birch"))
            {
                villagerWorkshopResultFromBase(item, Blocks.BIRCH_PLANKS, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("spruce"))
            {
                villagerWorkshopResultFromBase(item, Blocks.SPRUCE_PLANKS, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("jungle"))
            {
                villagerWorkshopResultFromBase(item, Blocks.JUNGLE_PLANKS, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("acacia"))
            {
                villagerWorkshopResultFromBase(item, Blocks.ACACIA_PLANKS, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("mangrove"))
            {
                villagerWorkshopResultFromBase(item, Blocks.MANGROVE_PLANKS, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("cherry"))
            {
                villagerWorkshopResultFromBase(item, Blocks.CHERRY_PLANKS, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("bamboo"))
            {
                villagerWorkshopResultFromBase(item, Blocks.BAMBOO_PLANKS, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("crimson"))
            {
                villagerWorkshopResultFromBase(item, Blocks.CRIMSON_PLANKS, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("warped"))
            {
                villagerWorkshopResultFromBase(item, Blocks.WARPED_PLANKS, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("andesite"))
            {
                villagerWorkshopResultFromBase(item, Blocks.ANDESITE, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("diorite"))
            {
                villagerWorkshopResultFromBase(item, Blocks.DIORITE, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("granite"))
            {
                villagerWorkshopResultFromBase(item, Blocks.GRANITE, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("prismarine"))
            {
                villagerWorkshopResultFromBase(item, Blocks.PRISMARINE, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("purpur"))
            {
                villagerWorkshopResultFromBase(item, Blocks.PURPUR_BLOCK, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("deepslate"))
            {
                villagerWorkshopResultFromBase(item, Blocks.COBBLED_DEEPSLATE, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("tuff"))
            {
                villagerWorkshopResultFromBase(item, Blocks.TUFF, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("packed_mud"))
            {
                villagerWorkshopResultFromBase(item, Blocks.PACKED_MUD, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("quartz"))
            {
                villagerWorkshopResultFromBase(item, Blocks.QUARTZ_BLOCK, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("nether_bricks"))
            {
                villagerWorkshopResultFromBase(item, Blocks.NETHER_BRICKS, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("basalt"))
            {
                villagerWorkshopResultFromBase(item, Blocks.BASALT, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("coal"))
            {
                villagerWorkshopResultFromBase(item, Blocks.COAL_BLOCK, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("iron"))
            {
                villagerWorkshopResultFromBase(item, Blocks.IRON_BLOCK, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("gold"))
            {
                villagerWorkshopResultFromBase(item, Blocks.GOLD_BLOCK, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("emerald"))
            {
                villagerWorkshopResultFromBase(item, Blocks.EMERALD_BLOCK, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("diamond"))
            {
                villagerWorkshopResultFromBase(item, Blocks.DIAMOND_BLOCK, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("copper"))
            {
                villagerWorkshopResultFromBase(item, Blocks.COPPER_BLOCK, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("lapis"))
            {
                villagerWorkshopResultFromBase(item, Blocks.LAPIS_BLOCK, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("netherite"))
            {
                villagerWorkshopResultFromBase(item, Blocks.NETHERITE_BLOCK, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("obsidian"))
            {
                villagerWorkshopResultFromBase(item, Blocks.OBSIDIAN, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("amethyst"))
            {
                villagerWorkshopResultFromBase(item, Blocks.AMETHYST_BLOCK, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("bedrock"))
            {
                villagerWorkshopResultFromBase(item, Blocks.BEDROCK, RecipeCategory.BUILDING_BLOCKS);
            }
            else if (itemName.contains("gypsum"))
            {
                villagerWorkshopResultFromBase(item, BlockRegister.GYPSUM, RecipeCategory.BUILDING_BLOCKS);
            }
        }
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
                .save(this.recipeOutput);
    }

    protected void villagerWorkshopResultFromBase(ItemLike result, ItemLike material, RecipeCategory category)
    {
        villagerWorkshopResultFromBase(category, result, material, 1);
    }

    protected void villagerWorkshopResultFromBase(RecipeCategory pCategory, ItemLike pResult, ItemLike pMaterial, int pResultCount)
    {
        VillagerWorkshopRecipeBuilder.villagerWorkshoping(Ingredient.of(pMaterial), pCategory, pResult, pResultCount)
                .unlockedBy(getHasName(pMaterial), has(pMaterial))
                .save(this.recipeOutput, BuiltInRegistries.ITEM.getKey(pResult.asItem()) + "_villagerworkshopping");
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
                .save(this.recipeOutput);
    }

    /**
     * Use it if the recipe may result a vanilla item
     * add "x from y" to json name
     **/
    private void oneItemToAnotherOneRecipeBuilder(ItemLike resource, ItemLike result)
    {
        oneItemToAnotherOneRecipeBuilder(resource, result, 1);
    }

    private void oneItemToAnotherOneRecipeBuilder(ItemLike resource, ItemLike result, int numberOutput)
    {
        String resultName = getName(result.asItem());
        String ingredientName = getName(resource.asItem());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result, numberOutput)
                .requires(resource)
                .unlockedBy("has_" + resultName, has(resource))
                .save(this.recipeOutput, "premierpainmod:" + resultName + "_from_" + ingredientName);
    }

    /*
    for example cactus is 0.2 exp
    time in tick
    */
    private void oneItemToAnotherOneRecipeInFurnaceBuilder(ItemLike resource, ItemLike result, RecipeCategory recipeCategory, float exp, int cookingTime)
    {
        String resultName = getName(result.asItem());
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(resource), recipeCategory, result, exp, cookingTime)
                .unlockedBy("has_" + resultName, has(resource))
                .save(this.recipeOutput, "premierpainmod:" + resultName + "_furnace");
    }


    private void shapelessRecipeBuilder(ItemLike result, ItemLike unlockItem, int numberOutput, ItemLike... resource)
    {
        String resultName = getName(result.asItem());

        String ingredientName = getName(unlockItem.asItem());

        ShapelessRecipeBuilder shapelessRecipeBuilder = ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result, numberOutput);
        for (ItemLike r : resource)
        {
            shapelessRecipeBuilder = shapelessRecipeBuilder.requires(r);
        }
        shapelessRecipeBuilder.unlockedBy("has_" + resultName, has(unlockItem)).save(this.recipeOutput, resultName + "_from_" + ingredientName);
    }

    private void stairsRecipeBuilder(ItemLike result, ItemLike blockNeeded)
    {
        String resultName = getName(result.asItem()) + "_from_" + getName(blockNeeded.asItem());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 4))
                .define('#', blockNeeded)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy("has_" + resultName + "_left", has(blockNeeded))
                .save(this.recipeOutput, "premierpainmod:" + resultName);
    }

    private void slabRecipeBuilder(ItemLike result, ItemLike blockNeeded)
    {
        String resultName = getName(result.asItem()) + "_from_" + getName(blockNeeded.asItem());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 6))
                .define('#', blockNeeded)
                .pattern("###")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(this.recipeOutput, "premierpainmod:" + resultName);
    }

    private void buttonRecipeBuilder(ItemLike result, ItemLike blockNeeded)
    {
        String resultName = getName(result.asItem());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 1))
                .define('#', blockNeeded)
                .pattern("#")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(this.recipeOutput);
    }

    private void pressurePlateRecipeBuilder(ItemLike result, ItemLike blockNeeded)
    {
        String resultName = getName(result.asItem());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 1))
                .define('#', blockNeeded)
                .pattern("##")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(this.recipeOutput);
    }

    private void fenceRecipeBuilder(ItemLike result, ItemLike blockNeeded)
    {
        String resultName = getName(result.asItem());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 3))
                .define('#', blockNeeded)
                .define('s', Items.STICK)
                .pattern("#s#")
                .pattern("#s#")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(this.recipeOutput);
    }

    private void fenceGateRecipeBuilder(ItemLike result, ItemLike blockNeeded)
    {
        String resultName = getName(result.asItem());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 1))
                .define('#', blockNeeded)
                .define('s', Items.STICK)
                .pattern("s#s")
                .pattern("s#s")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(this.recipeOutput);
    }

    private void doorRecipeBuilder(ItemLike result, ItemLike blockNeeded)
    {
        String resultName = getName(result.asItem());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 3))
                .define('#', blockNeeded)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(this.recipeOutput);
    }

    private void trapdoorOrWallRecipeBuilder(ItemLike result, ItemLike blockNeeded, int resultNumber)
    {
        String resultName = getName(result.asItem()) + "_from_" + getName(blockNeeded.asItem());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, resultNumber))
                .define('#', blockNeeded)
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(this.recipeOutput, "premierpainmod:" + resultName);
    }

    private void signRecipeBuilder(ItemLike result, ItemLike blockNeeded)
    {
        String resultName = getName(result.asItem());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 3))
                .define('#', blockNeeded)
                .define('t', Items.STICK)
                .pattern("###")
                .pattern("###")
                .pattern(" t ")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(this.recipeOutput);
    }

    private void hangingSignRecipeBuilder(ItemLike result, ItemLike blockNeeded)
    {
        String resultName = getName(result.asItem());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 6))
                .define('#', blockNeeded)
                .define('t', Items.CHAIN)
                .pattern("t t")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(this.recipeOutput);
    }

    private void boatRecipeBuilder(ItemLike result, ItemLike blockNeeded)
    {
        String resultName = getName(result.asItem());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 1))
                .define('#', blockNeeded)
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(this.recipeOutput, "premierpainmod:" + resultName + "_custom");
    }

    private void boatWithChestRecipeBuilder(ItemLike ChestBoat, ItemLike boat)
    {
        String resultName = getName(ChestBoat.asItem());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(ChestBoat, 1))
                .define('$', Blocks.CHEST)
                .define('#', boat)
                .pattern("$")
                .pattern("#")
                .unlockedBy("has_" + resultName, has(boat))
                .save(this.recipeOutput, "premierpainmod:" + resultName + "_custom");
    }

    private void fourSameIntoOneRecipeBuilder(ItemLike result, ItemLike blockNeeded)
    {
        fourSameIntoOneRecipeBuilder(result, blockNeeded, 1);
    }

    private void fourSameIntoOneRecipeBuilder(ItemLike result, ItemLike blockNeeded, int resultCount)
    {
        String resultName = getName(result.asItem()) + "_from_" + getName(blockNeeded.asItem());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, resultCount))
                .define('#', blockNeeded)
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_" + resultName, has(blockNeeded))
                .save(this.recipeOutput, "premierpainmod:" + resultName);
    }

    /**
     * @param itemLikes never reused existing recipe with more ingredients
     */
    private void brewingStationRecipeBuilder(FluidStack fluidInput, FluidStack fluidOutput, ItemLike... itemLikes)
    {
        String resultName = getName(fluidOutput);
        SizedFluidIngredient sizedFluidIngredient = new SizedFluidIngredient(FluidIngredient.single(fluidInput), 1000);
        ArrayList<Ingredient> ingredientList = new ArrayList<>();
        for (ItemLike itemLike : itemLikes)
        {
            ingredientList.add(Ingredient.of(itemLike));
        }
        new VillagerBrewingStationRecipeBuilder(sizedFluidIngredient, ingredientList, fluidOutput)
                .unlockedBy("has_civilization_flower", has(BlockRegister.CIVILIZATIONS_FLOWER))
                .save(this.recipeOutput, ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "brewing_" + resultName));
    }

    private void createEmptyBeerContainer()
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
                .save(this.recipeOutput);

        result = ItemRegister.EMPTY_BOTTLE.get();
        resultName = getName(result);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 7))
                .define('#', glass)
                .pattern("# #")
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_" + resultName, has(glass))
                .save(this.recipeOutput);

        result = ItemRegister.EMPTY_MUG.get();
        resultName = getName(result);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, 7))
                .define('#', wood)
                .define('$', ironNugget)
                .pattern("# #")
                .pattern("$ $")
                .pattern("###")
                .unlockedBy("has_" + resultName, has(glass))
                .save(this.recipeOutput);
    }

    private void generateWoodRecipe(Map<String, DeferredBlock<Block>> woodBlockMap, Map<String, DeferredItem<Item>> woodItemMap, TagKey<Item> logTag)
    {
        oneItemToAnotherOneRecipeBuilder(logTag, woodBlockMap.get("planks"), 4);
        fourSameIntoOneRecipeBuilder(woodBlockMap.get("wood"), woodBlockMap.get("log"), 3);
        fourSameIntoOneRecipeBuilder(woodBlockMap.get("stripped_wood"), woodBlockMap.get("stripped_log"), 3);
        stairsRecipeBuilder(woodBlockMap.get("stairs"), woodBlockMap.get("planks"));
        slabRecipeBuilder(woodBlockMap.get("slab"), woodBlockMap.get("planks"));
        buttonRecipeBuilder(woodBlockMap.get("button"), woodBlockMap.get("planks"));
        pressurePlateRecipeBuilder(woodBlockMap.get("pressure_plate"), woodBlockMap.get("planks"));
        fenceRecipeBuilder(woodBlockMap.get("fence"), woodBlockMap.get("planks"));
        fenceGateRecipeBuilder(woodBlockMap.get("fence_gate"), woodBlockMap.get("planks"));
        doorRecipeBuilder(woodBlockMap.get("door"), woodBlockMap.get("planks"));
        trapdoorOrWallRecipeBuilder(woodBlockMap.get("trapdoor"), woodBlockMap.get("planks"), 2);
        signRecipeBuilder(woodItemMap.get("sign"), woodBlockMap.get("planks").get());
        hangingSignRecipeBuilder(woodItemMap.get("hanging_sign"), woodBlockMap.get("stripped_log"));
        boatRecipeBuilder(woodItemMap.get("boat"), woodBlockMap.get("planks"));
        boatWithChestRecipeBuilder(woodItemMap.get("chest_boat"), woodItemMap.get("boat"));
    }

    private void cookingPotBlockRecipeBuilder()
    {
        Block craftedBlock = BlockRegister.COOKING_POT_BLOCK.get();
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(craftedBlock, 1))
                .define('1', Items.IRON_INGOT)
                .define('2', Items.WOODEN_SHOVEL)
                .pattern("121")
                .pattern("111")
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(this.recipeOutput);
    }

    private void cookingPotRecipeBuilder(Fluid fluidInput, int mBFluid, ItemLike itemStackInput, ItemLike itemStackOutput)
    {
        cookingPotRecipeBuilder(fluidInput, mBFluid, itemStackInput, itemStackOutput, 1);
    }

    private void cookingPotRecipeBuilder(Fluid fluidInput, int mBFluid, ItemLike itemStackInput, ItemLike itemStackOutput, int itemNumberOutput)
    {
        String resultName = getName(itemStackOutput.asItem());
        SizedFluidIngredient sizedFluidIngredient = new SizedFluidIngredient(FluidIngredient.single(fluidInput), CookingPotBlockEntity.MB_CONSUMED_BY_RECIPE);
        Ingredient ingredient = Ingredient.of(itemStackInput);
        ItemStack itemStackResult = new ItemStack(itemStackOutput, itemNumberOutput);

        new CookingPotRecipeBuilder(sizedFluidIngredient, ingredient, itemStackResult)
                .unlockedBy("has_" + getName(itemStackInput.asItem()), has(itemStackInput))
                .save(this.recipeOutput, ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "cooking_pot_" + resultName));
    }

    private void cuttedStoneRecipeBuilder(ItemLike twoInputItemLike, ItemLike result, int resultAmount)
    {
        String resultName = getName(result.asItem());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, new ItemStack(result, resultAmount))
                .define('#', twoInputItemLike)
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_" + resultName, has(twoInputItemLike))
                .save(this.recipeOutput);
    }

    private String getName(Item item)
    {
        String result = getKey(item).toString().replace(PremierPainMod.MOD_ID + ":", "");
        result = result.replace("minecraft:", "");
        return result;
    }

    private String getName(FluidStack fluid)
    {
        String result = getKey(fluid.getFluid().getBucket()).toString().replace(PremierPainMod.MOD_ID + ":", "");
        result = result.replace("minecraft:", "");
        return result;
    }

    private ResourceLocation getKey(Item item)
    {
        return BuiltInRegistries.ITEM.getKey(item);
    }
}