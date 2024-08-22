package com.unpainperdu.premierpainmod.datagen.asset.language;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import static org.apache.commons.lang3.StringUtils.capitalize;

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
        add("container."+ PremierPainMod.MOD_ID +".villager_workshop","Villager workshop");
        add("container."+ PremierPainMod.MOD_ID +".villager_drawer","Villager drawer");
        //potion effect
        add("effect.minecraft.hero_of_the_village","Hero of villagers");
        //death message
        deathTranslation("liberty_damage1", "%s was a socialist");
        deathTranslation("liberty_damage2", "%s wanted a cup of LIBER-TEA");
        deathTranslation("liberty_damage3", "%s didn't give honor to a Super-Earth flag");
        //item
            //villagerSingingStone
        add(ItemRegister.LIBERTY_VILLAGER_SINGING_STONE.get(),"Villager singing stone of liberty");
        descriptionMaker(ItemRegister.LIBERTY_VILLAGER_SINGING_STONE.get().toString(),"Are you a true patriot ?");
        add(ItemRegister.DIGGY_VILLAGER_SINGING_STONE.get(),"Villager singing stone of digging");
        descriptionMaker(ItemRegister.DIGGY_VILLAGER_SINGING_STONE.get().toString(),"Don't fear the depth");
        add(ItemRegister.MADNESS_VILLAGER_SINGING_STONE.get(),"Villager singing stone of madness");
        descriptionMakerWIP(ItemRegister.MADNESS_VILLAGER_SINGING_STONE.get().toString(),"Enough! I have endured more than enough...");
        add(ItemRegister.PREMIER_PAIN_VILLAGER_SINGING_STONE.get(),"Premier Pain singing stone");
        descriptionMakerWIP(ItemRegister.PREMIER_PAIN_VILLAGER_SINGING_STONE.get().toString(),"From backing bread to rise the sword, we come from so far!");
            //other
        add(ItemRegister.VILLAGER_ICON.get(), "Villager icon");
        //block
            //blockEvent
        add(BlockRegister.LIBERTY_BLOCK.get(),"HellPod");
            // villager workshop
        villagerWorkshopTranslation();
            //flower
                //1 block flower
        add(BlockRegister.RUINS_FLOWER.get(), "Ruins flower");
                //growing flower
        add(BlockRegister.CIVILIZATIONS_FLOWER.get(), "Civilizations flower");
                //dead bush
        add(BlockRegister.DEAD_RUINS_FLOWER.get(), "Dead ruins flower");
            // "All material"
        globalAllMaterialTranslation("oak");
        globalAllMaterialTranslation("birch");
        globalAllMaterialTranslation("spruce");
        globalAllMaterialTranslation("jungle");
        globalAllMaterialTranslation("acacia");
        globalAllMaterialTranslation("dark","oak",true);
        globalAllMaterialTranslation("mangrove");
        globalAllMaterialTranslation("cherry");
        globalAllMaterialTranslation("crimson");
        globalAllMaterialTranslation("warped");
        globalAllMaterialTranslation("bamboo");
        globalAllMaterialTranslation("stone");
        globalAllMaterialTranslation("mossy","stone",true);
        globalAllMaterialTranslation("andesite");
        globalAllMaterialTranslation("diorite");
        globalAllMaterialTranslation("granite");
        globalAllMaterialTranslation("prismarine");
        globalAllMaterialTranslation("blackstone");
        globalAllMaterialTranslation("purpur","block",false);
        globalAllMaterialTranslation("deepslate");
        globalAllMaterialTranslation("tuff");
        globalAllMaterialTranslation("packed","mud",true);
        globalAllMaterialTranslation("sandstone");
        globalAllMaterialTranslation("red","sandstone",true);
        globalAllMaterialTranslation("quartz","block",false);
        globalAllMaterialTranslation("nether","bricks",true);
        globalAllMaterialTranslation("basalt");
        globalAllMaterialTranslation("end","stone",true);
        globalAllMaterialTranslation("coal","block",false);
        globalAllMaterialTranslation("iron","block",false);
        globalAllMaterialTranslation("gold","block",false);
        globalAllMaterialTranslation("redstone","block",false);
        globalAllMaterialTranslation("emerald","block",false);
        globalAllMaterialTranslation("diamond","block",false);
        globalAllMaterialTranslation("copper","block",false);
        globalAllMaterialTranslation("lapis","block",false);
        globalAllMaterialTranslation("netherite","block",false);
        globalAllMaterialTranslation("obsidian");
        globalAllMaterialTranslation("amethyst","block",false);
        globalAllMaterialTranslation("dripstone","block",false);
        globalAllMaterialTranslation("bedrock");
    }
    //Only use for "all material" blocks
    private void globalAllMaterialTranslation(String suffix)
    {
        statueTranslation(suffix);
        pedestalTranslation(suffix);
        brazierTranslation(suffix);
        tableTranslation(suffix);
        chairTranslation(suffix);
        throneChairTranslation(suffix);
        drawerTranslation(suffix);
        shelfTranslation(suffix);
    }
    //Only use for "all material" blocks
    private void globalAllMaterialTranslation(String suffix1, String suffix2, Boolean isSuffix2Translate)
    {
        statueTranslation(suffix1, suffix2, isSuffix2Translate);
        pedestalTranslation(suffix1, suffix2, isSuffix2Translate);
        brazierTranslation(suffix1, suffix2, isSuffix2Translate);
        tableTranslation(suffix1, suffix2, isSuffix2Translate);
        chairTranslation(suffix1, suffix2, isSuffix2Translate);
        throneChairTranslation(suffix1, suffix2, isSuffix2Translate);
        drawerTranslation(suffix1, suffix2, isSuffix2Translate);
        shelfTranslation(suffix1, suffix2, isSuffix2Translate);
    }
    // will create translation : "block.premierpainmod.suffix_villager_statue": "'Suffix' villager statue"
    private void statueTranslation(String suffix)
    {
        String translation = capitalize(suffix);
        String statue = "_villager_statue";
        String translationStatue = " villager statue";
        add("block."+PremierPainMod.MOD_ID +"."+suffix+statue,translation+translationStatue);
    }
    // will create translation : "block.premierpainmod.suffix_villager_statue": "'Suffix1' 'suffix2' villager statue"
    private void statueTranslation(String suffix1, String suffix2, Boolean isSuffix2Translate)
    {
        String translation1 = capitalize(suffix1);
        String statue = "_villager_statue";
        String translationStatue = " villager statue";
        if (!isSuffix2Translate)
        {
            add("block." + PremierPainMod.MOD_ID + "." + suffix1 + "_" + suffix2 + statue, translation1 + translationStatue);
        }
        else
        {
            add("block." + PremierPainMod.MOD_ID + "." + suffix1 + "_" + suffix2 + statue, translation1 +" "+ suffix2 + translationStatue);
        }
    }
    // will create translation : "block.premierpainmod.suffix_villager_statue": "'Suffix' pedestal"
    private void pedestalTranslation(String suffix)
    {
        String translation = capitalize(suffix);
        String pedestal = "_villager_pedestal";
        String translationPedestal = " villager pedestal";
        add("block."+PremierPainMod.MOD_ID +"."+suffix+pedestal,translation+translationPedestal);
    }
    // will create translation : "block.premierpainmod.suffix_villager_statue": "'Suffix1' 'suffix2' pedestal"
    private void pedestalTranslation(String suffix1, String suffix2, Boolean isSuffix2Translate)
    {
        String translation1 = capitalize(suffix1);
        String pedestal = "_villager_pedestal";
        String translationPedestal = " villager pedestal";
        if (!isSuffix2Translate)
        {
            add("block." + PremierPainMod.MOD_ID + "." + suffix1 + "_" + suffix2 + pedestal, translation1 + translationPedestal);
        }
        else
        {
            add("block." + PremierPainMod.MOD_ID + "." + suffix1 + "_" + suffix2 + pedestal, translation1 +" "+ suffix2 + translationPedestal);
        }
    }

    private void brazierTranslation(String suffix)
    {
        String translation = capitalize(suffix);
        String pedestal = "_villager_brazier";
        String translationPedestal = " villager brazier";
        add("block."+PremierPainMod.MOD_ID +"."+suffix+pedestal,translation+translationPedestal);
    }

    private void brazierTranslation(String suffix1, String suffix2, Boolean isSuffix2Translate)
    {
        String translation1 = capitalize(suffix1);
        String pedestal = "_villager_brazier";
        String translationPedestal = " villager brazier";
        if (!isSuffix2Translate)
        {
            add("block." + PremierPainMod.MOD_ID + "." + suffix1 + "_" + suffix2 + pedestal, translation1 + translationPedestal);
        }
        else
        {
            add("block." + PremierPainMod.MOD_ID + "." + suffix1 + "_" + suffix2 + pedestal, translation1 +" "+ suffix2 + translationPedestal);
        }
    }
    private void villagerWorkshopTranslation()
    {
        add("block."+PremierPainMod.MOD_ID +".villager_workshop","Villager Workshop");
    }
    private void tableTranslation(String suffix)
    {
        String translation = capitalize(suffix);
        String table = "_villager_table";
        String translationTable = " villager table";
        add("block."+PremierPainMod.MOD_ID +"."+ suffix + table,translation + translationTable);
    }

    private void tableTranslation(String suffix1, String suffix2, Boolean isSuffix2Translate)
    {
        String translation1 = capitalize(suffix1);
        String table = "_villager_table";
        String translationTable = " villager table";
        if (!isSuffix2Translate)
        {
            add("block." + PremierPainMod.MOD_ID + "." + suffix1 + "_" + suffix2 + table, translation1 + translationTable);
        }
        else
        {
            add("block." + PremierPainMod.MOD_ID + "." + suffix1 + "_" + suffix2 + table, translation1 +" "+ suffix2 + translationTable);
        }
    }
    private void chairTranslation(String suffix)
    {
        String translation = capitalize(suffix);
        String table = "_villager_chair";
        String translationTable = " villager chair";
        add("block."+PremierPainMod.MOD_ID +"."+ suffix + table,translation + translationTable);
    }

    private void chairTranslation(String suffix1, String suffix2, Boolean isSuffix2Translate)
    {
        String translation1 = capitalize(suffix1);
        String table = "_villager_chair";
        String translationTable = " villager chair";
        if (!isSuffix2Translate)
        {
            add("block." + PremierPainMod.MOD_ID + "." + suffix1 + "_" + suffix2 + table, translation1 + translationTable);
        }
        else
        {
            add("block." + PremierPainMod.MOD_ID + "." + suffix1 + "_" + suffix2 + table, translation1 +" "+ suffix2 + translationTable);
        }
    }
    private void throneChairTranslation(String suffix)
    {
        String translation = capitalize(suffix);
        String table = "_villager_throne_chair";
        String translationTable = " villager throne chair";
        add("block."+PremierPainMod.MOD_ID +"."+ suffix + table,translation + translationTable);
    }

    private void throneChairTranslation(String suffix1, String suffix2, Boolean isSuffix2Translate)
    {
        String translation1 = capitalize(suffix1);
        String table = "_villager_throne_chair";
        String translationTable = " villager throne chair";
        if (!isSuffix2Translate)
        {
            add("block." + PremierPainMod.MOD_ID + "." + suffix1 + "_" + suffix2 + table, translation1 + translationTable);
        }
        else
        {
            add("block." + PremierPainMod.MOD_ID + "." + suffix1 + "_" + suffix2 + table, translation1 +" "+ suffix2 + translationTable);
        }
    }
    private void drawerTranslation(String suffix)
    {
        String translation = capitalize(suffix);
        String table = "_villager_drawer";
        String translationTable = " villager drawer";
        add("block."+PremierPainMod.MOD_ID +"."+ suffix + table,translation + translationTable);
    }

    private void drawerTranslation(String suffix1, String suffix2, Boolean isSuffix2Translate)
    {
        String translation1 = capitalize(suffix1);
        String table = "_villager_drawer";
        String translationTable = " villager drawer";
        if (!isSuffix2Translate)
        {
            add("block." + PremierPainMod.MOD_ID + "." + suffix1 + "_" + suffix2 + table, translation1 + translationTable);
        }
        else
        {
            add("block." + PremierPainMod.MOD_ID + "." + suffix1 + "_" + suffix2 + table, translation1 +" "+ suffix2 + translationTable);
        }
    }
    private void shelfTranslation(String suffix)
    {
        String translation = capitalize(suffix);
        String shelfItem = "_villager_shelf";
        String wallShelf = "_wall_villager_shelf";
        String standingShelf = "_standing_villager_shelf";
        String translationTable = " villager shelf";
        add("block."+PremierPainMod.MOD_ID +"."+ suffix + standingShelf,translation + translationTable);
    }

    private void shelfTranslation(String suffix1, String suffix2, Boolean isSuffix2Translate)
    {
        String translation1 = capitalize(suffix1);
        String translationTable = " villager shelf";
        if (!isSuffix2Translate)
        {
            add("block." + PremierPainMod.MOD_ID + "." + suffix1 + "_" + suffix2 + "_standing_villager_shelf", translation1 + translationTable);
        }
        else
        {
            add("block." + PremierPainMod.MOD_ID + "." + suffix1 + "_" + suffix2 + "_standing_villager_shelf", translation1 +" "+ suffix2 + translationTable);
        }
    }

    private void deathTranslation(String id, String translation)
    {
        add("death.attack." + PremierPainMod.MOD_ID + ":" + id, translation);
    }
    private void descriptionMakerWIP(String idOfItem, String translation)
    {
        descriptionMaker(idOfItem,translation + " !!!Sound in WIP, will be more villager like when i will know how to do");
    }
    private void descriptionMaker(String idOfItem, String translation)
    {
        add("item.description."+idOfItem.replace(PremierPainMod.MOD_ID +":",""),translation);
    }
}