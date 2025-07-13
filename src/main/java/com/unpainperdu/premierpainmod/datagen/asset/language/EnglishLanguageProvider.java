package com.unpainperdu.premierpainmod.datagen.asset.language;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class EnglishLanguageProvider extends LanguageProvider
{
    public EnglishLanguageProvider(PackOutput packOutput)
    {
        super(packOutput, PremierPainMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations()
    {
        add("itemGroup.premierpainmod", "Premier Pain mod");
        //gui
        add("container." + PremierPainMod.MOD_ID + ".villager_workshop", "Villager workshop");
        add("container." + PremierPainMod.MOD_ID + "cooking_pot.bin_button", "Empty fluid tank without refund");
        add("container." + PremierPainMod.MOD_ID + ".villager_drawer", "Villager drawer");
        add("container." + PremierPainMod.MOD_ID + ".villager_brewing_station", "Brewing station");
        add("container." + PremierPainMod.MOD_ID + ".villager_musical_fridge", "Musical fridge");
        add(PremierPainMod.MOD_ID + ".tooltip.liquid.amount.with.capacity", "%s / %s mB");
        //potion effect
        add("effect.minecraft.hero_of_the_village", "Hero of villagers");
        //death message
        deathTranslation("liberty_damage1", "%s was a socialist");
        deathTranslation("liberty_damage2", "%s wanted a cup of LIBER-TEA");
        deathTranslation("liberty_damage3", "%s didn't give honor to a Super-Earth flag");
        //item
        //villagerSingingStone
        add(ItemRegister.LIBERTY_VILLAGER_SINGING_STONE.get(), "Villager Singing Stone of Liberty");
        descriptionMaker(ItemRegister.LIBERTY_VILLAGER_SINGING_STONE.get().toString(), "Are you a true patriot ?");
        add(ItemRegister.DIGGY_VILLAGER_SINGING_STONE.get(), "Villager Singing Stone of Digging");
        descriptionMaker(ItemRegister.DIGGY_VILLAGER_SINGING_STONE.get().toString(), "Don't fear the depth");
        add(ItemRegister.MADNESS_VILLAGER_SINGING_STONE.get(), "Villager Singing Stone of Madness");
        descriptionMakerWIP(ItemRegister.MADNESS_VILLAGER_SINGING_STONE.get().toString(), "Enough! I have endured more than enough...");
        //fluid
        //oil
        add(PremierPainMod.MOD_ID + ".block.description.moriche_palm_oil_type", "Moriche Palm Oil");
        add(ItemRegister.MORICHE_PALM_OIL_BUCKET.get(), "Moriche Palm Oil Bucket");
        //beer
        //empty
        add(ItemRegister.EMPTY_GLASS.get(), "Empty Polymorphic Glass");
        add(ItemRegister.EMPTY_BOTTLE.get(), "Empty Polymorphic Bottle");
        add(ItemRegister.EMPTY_MUG.get(), "Empty Mug");
        //pain dieux
        add(PremierPainMod.MOD_ID + ".block.description.pain_dieux_type", "Pain Dieux");
        add(ItemRegister.PAIN_DIEUX_BUCKET.get(), "Pain Dieux Bucket");
        add(ItemRegister.PAIN_DIEUX_GLASS.get(), "Pain Dieux Glass");
        add(ItemRegister.PAIN_DIEUX_BOTTLE.get(), "Pain Dieux Bottle");
        add(ItemRegister.PAIN_DIEUX_MUG.get(), "Pain Dieux Mug");
        add("item.description.pain_dieux_glass", "A unique glass for an unique beer.");
        add("item.description.pain_dieux_bottle", "A classy bottle of good beverage.");
        add("item.description.pain_dieux_mug", "Nothing better than a fresh Pain Dieux");
        //la chateau
        add(PremierPainMod.MOD_ID + ".block.description.la_chateau_type", "La Chateau");
        add(ItemRegister.LA_CHATEAU_BUCKET.get(), "La Chateau Bucket");
        add(ItemRegister.LA_CHATEAU_GLASS.get(), "La Chateau Glass");
        add(ItemRegister.LA_CHATEAU_BOTTLE.get(), "La Chateau Bottle");
        add(ItemRegister.LA_CHATEAU_MUG.get(), "La Chateau Mug");
        add("item.description.la_chateau_glass", "A solid royal glass.");
        add("item.description.la_chateau_bottle", "You already know you will enjoy it.");
        add("item.description.la_chateau_mug", "A big mug worthy for a knight!");
        //debier
        add(PremierPainMod.MOD_ID + ".block.description.debier_type", "DeBier");
        add(ItemRegister.DEBIER_BUCKET.get(), "DeBier Bucket");
        add(ItemRegister.DEBIER_GLASS.get(), "DeBier Glass");
        add(ItemRegister.DEBIER_BOTTLE.get(), "DeBier Bottle");
        add(ItemRegister.DEBIER_MUG.get(), "DeBier Mug");
        add("item.description.debier_glass", "Strong luck well served.");
        add("item.description.debier_bottle", "Saint-Patrick's favorite.");
        add("item.description.debier_mug", "you will be traeted as an Irish!");
        //envahisseur_rouge
        add(PremierPainMod.MOD_ID + ".block.description.envahisseur_rouge_type", "Envahisseur Rouge");
        add(ItemRegister.ENVAHISSEUR_ROUGE_BUCKET.get(), "Envahisseur Rouge Bucket");
        add(ItemRegister.ENVAHISSEUR_ROUGE_GLASS.get(), "Envahisseur Rouge Glass");
        add(ItemRegister.ENVAHISSEUR_ROUGE_BOTTLE.get(), "Envahisseur Rouge Bottle");
        add(ItemRegister.ENVAHISSEUR_ROUGE_MUG.get(), "Envahisseur Rouge Mug");
        add("item.description.envahisseur_rouge_glass", "VIOLENCE.");
        add("item.description.envahisseur_rouge_bottle", "Only this bottle can handle it.");
        add("item.description.envahisseur_rouge_mug", "Lead a raid like a god!");
        //raspbuisson
        add(PremierPainMod.MOD_ID + ".block.description.raspbuisson_type", "RaspBuisson");
        add(ItemRegister.RASPBUISSON_BUCKET.get(), "RaspBuisson Bucket");
        add(ItemRegister.RASPBUISSON_GLASS.get(), "RaspBuisson Glass");
        add(ItemRegister.RASPBUISSON_BOTTLE.get(), "RaspBuisson Bottle");
        add(ItemRegister.RASPBUISSON_MUG.get(), "RaspBuisson Mug");
        add("item.description.raspbuisson_glass", "Delicate raspberry flavor well served.");
        add("item.description.raspbuisson_bottle", "Such a color attract everyone.");
        add("item.description.raspbuisson_mug", "So fresh!");
        //la_blanche_citadine
        add(PremierPainMod.MOD_ID + ".block.description.la_blanche_citadine_type", "La Blanche Citadine");
        add(ItemRegister.LA_BLANCHE_CITADINE_BUCKET.get(), "La Blanche Citadine Bucket");
        add(ItemRegister.LA_BLANCHE_CITADINE_GLASS.get(), "La Blanche Citadine Glass");
        add(ItemRegister.LA_BLANCHE_CITADINE_BOTTLE.get(), "La Blanche Citadine Bottle");
        add(ItemRegister.LA_BLANCHE_CITADINE_MUG.get(), "La Blanche Citadine Mug");
        add("item.description.la_blanche_citadine_glass", "Light and perfect for the evening.");
        add("item.description.la_blanche_citadine_bottle", "Simply delicious.");
        add("item.description.la_blanche_citadine_mug", "Faster toward the barrel!");
        //crane_noir
        add(PremierPainMod.MOD_ID + ".block.description.crane_noir_type", "Crane Noir");
        add(ItemRegister.CRANE_NOIR_BUCKET.get(), "Crane Noir Bucket");
        add(ItemRegister.CRANE_NOIR_GLASS.get(), "Crane Noir Glass");
        add(ItemRegister.CRANE_NOIR_BOTTLE.get(), "Crane Noir Bottle");
        add(ItemRegister.CRANE_NOIR_MUG.get(), "Crane Noir Mug");
        add("item.description.crane_noir_glass", "A quality drink to drink into the skulls of your enemies.");
        add("item.description.crane_noir_bottle", "Solide as obsidian.");
        add("item.description.crane_noir_mug", "Your stamina is getting multiplied!");
        //tak
        add(PremierPainMod.MOD_ID + ".block.description.tak_type", "Tak");
        add(ItemRegister.TAK_BUCKET.get(), "Tak Bucket");
        add(ItemRegister.TAK_GLASS.get(), "Tak Glass");
        add(ItemRegister.TAK_BOTTLE.get(), "Tak Bottle");
        add(ItemRegister.TAK_MUG.get(), "Tak Mug");
        add("item.description.tak_glass", "TakTakTak.");
        add("item.description.tak_bottle", "TakTak.");
        add("item.description.tak_mug", "TakTakTakTakTakTakTakTak!");
        //disender
        add(PremierPainMod.MOD_ID + ".block.description.disender_type", "DisEnder");
        add(ItemRegister.DISENDER_BUCKET.get(), "DisEnder Bucket");
        add(ItemRegister.DISENDER_GLASS.get(), "DisEnder Glass");
        add(ItemRegister.DISENDER_BOTTLE.get(), "DisEnder Bottle");
        add(ItemRegister.DISENDER_MUG.get(), "DisEnder Mug");
        add("item.description.disender_glass", "Very oddly interesting.");
        add("item.description.disender_bottle", "It's special but tasty.");
        add("item.description.disender_mug", "Fresh and foamy");
        //food
        add(ItemRegister.HALF_COOKED_FRIES.get(), "Simple backed Fries");
        add(ItemRegister.FRIES.get(), "Fries");
        add(ItemRegister.FRIES_CONE.get(), "Fries Cone");
        //vegetation
        add(ItemRegister.SKY_SPEARS_FRUIT.get(), "Sky Spears Fruit");
        add(ItemRegister.CACTUS_FLOWER_FRUIT.get(), "Cactus Flower Fruit");
        add(ItemRegister.JELLY_HAT.get(), "Jelly Hat");
        add(ItemRegister.MOUNTAIN_CURRANT.get(), "Mountain Currant");
        add(ItemRegister.MORICHE_PALM_FRUIT.get(), "Moriche Palm Fruit");
        add(ItemRegister.ACHIOTE_FRUIT.get(), "Achiote Fruit");
        //stew
        add(ItemRegister.JELLYSHROOM_STEW.get(), "Jellyshroom Stew");
        add(ItemRegister.CACTUS_STEW.get(), "Cactus Fruit Stew");
        add(ItemRegister.POTATOES_AND_SPEARS_BOWL.get(), "Potatoes and Spear Fruit Bowl");
        add(ItemRegister.FRUITS_BOWL.get(), "Fruits Bowl");
        //egg
        add(AllInOneEntityRegister.EGG_ITEM_MAP.get("mountain_currant_golem_egg").get(), "Mountain Currant Golem Egg");
        //block
        //blockEvent
        add(BlockRegister.LIBERTY_BLOCK.get(), "HellPod");
        //crafting_block
        add(BlockRegister.VILLAGER_WORKSHOP.get(), "Villager Workshop");
        add(BlockRegister.COOKING_POT_BLOCK.get(), "Cooking Pot");
        //vegetation
        //tall grass
        add(BlockRegister.SKY_SPEARS.get(), "Sky Spears");
        add(BlockRegister.SKY_SPEARS_FLOWER.get(), "Sky Spears Flower");
        add(BlockRegister.DEAD_TALL_BUSH.get(), "Dry Bush");
        add(BlockRegister.OLD_WILD_WHEAT.get(), "Old Wild Wheat");
        //misc
        add(BlockRegister.FLOWERED_CACTUS_BLOCK.get(), "Flowered Cactus");
        add(BlockRegister.CACTUS_FLOWER_BLOCK.get(), "Cactus Flower");

        //flower
        //1 block flower
        add(BlockRegister.RUINS_FLOWER.get(), "Ruins Flower");
        add(BlockRegister.CURIOSITY_FLOWER.get(), "Curiosity Flower");
        //growing flower
        add(BlockRegister.CIVILIZATIONS_FLOWER.get(), "Civilizations Flower");
        //tall flower
        add(BlockRegister.FALLING_HELICON_FLOWER.get(), "Falling Helicon");
        //dead bush
        add(BlockRegister.DEAD_RUINS_FLOWER.get(), "Dead Ruins Flower");
        //crop
        add(BlockRegister.JELLYSHROOM.get(), "Jellyshroom");
        //tree
        treeTranslator("mountain_currant", "Mountain Currant");
        treeTranslator("moriche_palm", "Moriche Palm");
        treeTranslator("achiote", "Achiote");
        // "All material"
        globalAllMaterialTranslation("oak", "Oak");
        globalAllMaterialTranslation("birch", "Birch");
        globalAllMaterialTranslation("spruce", "Spruce");
        globalAllMaterialTranslation("jungle", "Jungle");
        globalAllMaterialTranslation("acacia", "Acacia");
        globalAllMaterialTranslation("dark_oak", "Dark Oak");
        globalAllMaterialTranslation("pale_oak", "Pale Oak");
        globalAllMaterialTranslation("mangrove", "Mangrove");
        globalAllMaterialTranslation("cherry", "Cherry");
        globalAllMaterialTranslation("crimson", "Crimson");
        globalAllMaterialTranslation("warped", "Warped");
        globalAllMaterialTranslation("bamboo", "Bamboo");
        globalAllMaterialTranslation("stone", "Stone");
        globalAllMaterialTranslation("mossy_stone", "Mossy Stone");
        globalAllMaterialTranslation("andesite", "Andesite");
        globalAllMaterialTranslation("diorite", "Diorite");
        globalAllMaterialTranslation("granite", "Granite");
        globalAllMaterialTranslation("prismarine", "Prismarine");
        globalAllMaterialTranslation("blackstone", "Blackstone");
        globalAllMaterialTranslation("purpur_block", "Purpur");
        globalAllMaterialTranslation("deepslate", "Deepslate");
        globalAllMaterialTranslation("tuff", "Tuff");
        globalAllMaterialTranslation("packed_mud", "Packed Mud");
        globalAllMaterialTranslation("sandstone", "Sandstone");
        globalAllMaterialTranslation("red_sandstone", "Red Sandstone");
        globalAllMaterialTranslation("quartz_block", "Quartz");
        globalAllMaterialTranslation("nether_bricks", "Nether Bricks");
        globalAllMaterialTranslation("basalt", "Basalt");
        globalAllMaterialTranslation("end_stone", "End Stone");
        globalAllMaterialTranslation("coal_block", "Coal");
        globalAllMaterialTranslation("iron_block", "Iron");
        globalAllMaterialTranslation("gold_block", "Gold");
        globalAllMaterialTranslation("redstone_block", "Redstone");
        globalAllMaterialTranslation("emerald_block", "Emerald");
        globalAllMaterialTranslation("diamond_block", "Diamond");
        globalAllMaterialTranslation("copper_block", "Copper");
        globalAllMaterialTranslation("lapis_block", "Lapis");
        globalAllMaterialTranslation("netherite_block", "Netherite");
        globalAllMaterialTranslation("obsidian", "Obsidian");
        globalAllMaterialTranslation("amethyst_block", "Amethyst");
        globalAllMaterialTranslation("dripstone_block", "Dripstone");
        globalAllMaterialTranslation("bedrock", "Bedrock");
        globalAllMaterialTranslation("mountain_currant", "Mountain Currant");
        globalAllMaterialTranslation("moriche_palm", "Moriche Palm");
        globalAllMaterialTranslation("achiote", "Achiote");
    }

    //Only use for "all material" blocks
    private void globalAllMaterialTranslation(String suffix, String translationSuffix)
    {
        statueTranslation(suffix, translationSuffix);
        pedestalTranslation(suffix, translationSuffix);
        brazierTranslation(suffix, translationSuffix);
        tableTranslation(suffix, translationSuffix);
        chairTranslation(suffix, translationSuffix);
        throneChairTranslation(suffix, translationSuffix);
        drawerTranslation(suffix, translationSuffix);
        shelfTranslation(suffix, translationSuffix);
        benchTranslation(suffix, translationSuffix);
        couchTranslation(suffix, translationSuffix);
        brewingStationTranslation(suffix, translationSuffix);
        villagerMusicalFridgeTranslation(suffix, translationSuffix);
        villagerChiseledHeadTranslation(suffix, translationSuffix);
    }

    // will create translation : "block.premierpainmod.suffix_villager_statue": "'Suffix' villager statue"
    private void statueTranslation(String suffix, String translationSuffix)
    {
        String statue = "_villager_statue";
        String translationStatue = " villager statue";
        add("block." + PremierPainMod.MOD_ID + "." + suffix + statue, translationSuffix + translationStatue);
    }

    // will create translation : "block.premierpainmod.suffix_villager_statue": "'Suffix' pedestal"
    private void pedestalTranslation(String suffix, String translationSuffix)
    {
        String pedestal = "_villager_pedestal";
        String translationPedestal = " villager pedestal";
        add("block." + PremierPainMod.MOD_ID + "." + suffix + pedestal, translationSuffix + translationPedestal);
    }

    private void brazierTranslation(String suffix, String translationSuffix)
    {
        String pedestal = "_villager_brazier";
        String translationPedestal = " villager brazier";
        add("block." + PremierPainMod.MOD_ID + "." + suffix + pedestal, translationSuffix + translationPedestal);
    }

    private void tableTranslation(String suffix, String translationSuffix)
    {
        String table = "_villager_table";
        String translationTable = " villager table";
        add("block." + PremierPainMod.MOD_ID + "." + suffix + table, translationSuffix + translationTable);
    }

    private void chairTranslation(String suffix, String translationSuffix)
    {
        String table = "_villager_chair";
        String translationTable = " villager chair";
        add("block." + PremierPainMod.MOD_ID + "." + suffix + table, translationSuffix + translationTable);
    }

    private void throneChairTranslation(String suffix, String translationSuffix)
    {
        String table = "_villager_throne_chair";
        String translationTable = " villager throne chair";
        add("block." + PremierPainMod.MOD_ID + "." + suffix + table, translationSuffix + translationTable);
    }

    private void drawerTranslation(String suffix, String translationSuffix)
    {
        String table = "_villager_drawer";
        String translationTable = " villager drawer";
        add("block." + PremierPainMod.MOD_ID + "." + suffix + table, translationSuffix + translationTable);
    }

    private void shelfTranslation(String suffix, String translationSuffix)
    {
        String standingShelf = "_standing_villager_shelf";
        String translationTable = " villager shelf";
        add("block." + PremierPainMod.MOD_ID + "." + suffix + standingShelf, translationSuffix + translationTable);
    }

    private void benchTranslation(String suffix, String translationSuffix)
    {
        String bench = "_villager_bench";
        String translationTable = " villager bench";
        add("block." + PremierPainMod.MOD_ID + "." + suffix + bench, translationSuffix + translationTable);
    }

    private void couchTranslation(String suffix, String translationSuffix)
    {
        String bench = "_villager_couch";
        String translationTable = " villager couch";
        add("block." + PremierPainMod.MOD_ID + "." + suffix + bench, translationSuffix + translationTable);
    }

    private void brewingStationTranslation(String suffix, String translationSuffix)
    {
        String bench = "_villager_brewing_station";
        String translationTable = " villager brewing station";
        add("block." + PremierPainMod.MOD_ID + "." + suffix + bench, translationSuffix + translationTable);
    }

    private void villagerMusicalFridgeTranslation(String suffix, String translationSuffix)
    {
        String fridge = "_villager_musical_fridge";
        String translationFridge = " villager musical fridge";
        add("block." + PremierPainMod.MOD_ID + "." + suffix + fridge, translationSuffix + translationFridge);
    }

    private void villagerChiseledHeadTranslation(String suffix, String translationSuffix)
    {
        String chiseledHead = "_villager_chiseled_head";
        String translationChiseledHead = " Villager Chiseled Head";
        add("block." + PremierPainMod.MOD_ID + "." + suffix + chiseledHead, translationSuffix + translationChiseledHead);
    }

    private void deathTranslation(String id, String translation)
    {
        add("death.attack." + PremierPainMod.MOD_ID + ":" + id, translation);
    }

    private void descriptionMakerWIP(String idOfItem, String translation)
    {
        descriptionMaker(idOfItem, translation + " !!!Sound in WIP, will be more villager like when i will know how to do");
    }

    private void descriptionMaker(String idOfItem, String translation)
    {
        add("item.description." + idOfItem.replace(PremierPainMod.MOD_ID + ":", ""), translation);
    }

    /***
     *
     * @param nameOfTree need to be in this form : dark_oak
     * @param translation need to be in this form : Dark Oak
     */
    private void treeTranslator(String nameOfTree, String translation)
    {
        String block = "block." + PremierPainMod.MOD_ID + ".";
        String item = "item." + PremierPainMod.MOD_ID + ".";
        add(block + nameOfTree + "_log", translation + " Log");
        add(block + nameOfTree + "_wood", translation + " Wood");
        add(block + "stripped_" + nameOfTree + "_log", "Stripped " + translation + " Log");
        add(block + "stripped_" + nameOfTree + "_wood", "Stripped " + translation + " Wood");
        add(block + nameOfTree + "_planks", translation + " Planks");
        add(block + nameOfTree + "_leaves", translation + " Leaves");
        add(block + nameOfTree + "_stairs", translation + " Stairs");
        add(block + nameOfTree + "_slab", translation + " Slab");
        add(block + nameOfTree + "_button", translation + " Button");
        add(block + nameOfTree + "_pressure_plate", translation + " Pressure Plate");
        add(block + nameOfTree + "_fence", translation + " Fence");
        add(block + nameOfTree + "_fence_gate", translation + " Fence Gate");
        add(block + nameOfTree + "_door", translation + " Door");
        add(block + nameOfTree + "_trapdoor", translation + " Trapdoor");
        add(block + nameOfTree + "_sign", translation + " Sign");
        add(block + nameOfTree + "_hanging_sign", translation + " Hanging Sign");
        add(block + nameOfTree + "_sapling", translation + " Sapling");
        add(item + nameOfTree + "_boat", translation + " Boat");
        add(item + nameOfTree + "_chest_boat", translation + " Boat with Chest");
    }
}