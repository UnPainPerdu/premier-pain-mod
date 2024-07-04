package com.unpainperdu.premierpainmod.datagen.asset.language;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class EnglishLanguageProvider extends LanguageProvider
{
    public EnglishLanguageProvider(PackOutput packOutput)
    {
        super(packOutput, PremierPainMod.MODID, "en_us");
    }
    @Override
    protected void addTranslations()
    {
        add("itemGroup.premierpainmod", "Premier Pain mod");
        add("container."+ PremierPainMod.MODID +".villager_workshop","Villager workshop");
        add("container."+ PremierPainMod.MODID +".villager_drawer","Villager drawer");
        //item
        add(ItemRegister.VILLAGER_ICON.get(), "Villager icon");
        //block
            // villager workshop
        villagerWorkshopTranslation();
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
        add("block."+PremierPainMod.MODID+"."+suffix+statue,translation+translationStatue);
    }
    // will create translation : "block.premierpainmod.suffix_villager_statue": "'Suffix1' 'suffix2' villager statue"
    private void statueTranslation(String suffix1, String suffix2, Boolean isSuffix2Translate)
    {
        String translation1 = capitalize(suffix1);
        String statue = "_villager_statue";
        String translationStatue = " villager statue";
        if (!isSuffix2Translate)
        {
            add("block." + PremierPainMod.MODID + "." + suffix1 + "_" + suffix2 + statue, translation1 + translationStatue);
        }
        else
        {
            add("block." + PremierPainMod.MODID + "." + suffix1 + "_" + suffix2 + statue, translation1 +" "+ suffix2 + translationStatue);
        }
    }
    // will create translation : "block.premierpainmod.suffix_villager_statue": "'Suffix' pedestal"
    private void pedestalTranslation(String suffix)
    {
        String translation = capitalize(suffix);
        String pedestal = "_villager_pedestal";
        String translationPedestal = " villager pedestal";
        add("block."+PremierPainMod.MODID+"."+suffix+pedestal,translation+translationPedestal);
    }
    // will create translation : "block.premierpainmod.suffix_villager_statue": "'Suffix1' 'suffix2' pedestal"
    private void pedestalTranslation(String suffix1, String suffix2, Boolean isSuffix2Translate)
    {
        String translation1 = capitalize(suffix1);
        String pedestal = "_villager_pedestal";
        String translationPedestal = " villager pedestal";
        if (!isSuffix2Translate)
        {
            add("block." + PremierPainMod.MODID + "." + suffix1 + "_" + suffix2 + pedestal, translation1 + translationPedestal);
        }
        else
        {
            add("block." + PremierPainMod.MODID + "." + suffix1 + "_" + suffix2 + pedestal, translation1 +" "+ suffix2 + translationPedestal);
        }
    }

    private void brazierTranslation(String suffix)
    {
        String translation = capitalize(suffix);
        String pedestal = "_villager_brazier";
        String translationPedestal = " villager brazier";
        add("block."+PremierPainMod.MODID+"."+suffix+pedestal,translation+translationPedestal);
    }

    private void brazierTranslation(String suffix1, String suffix2, Boolean isSuffix2Translate)
    {
        String translation1 = capitalize(suffix1);
        String pedestal = "_villager_brazier";
        String translationPedestal = " villager brazier";
        if (!isSuffix2Translate)
        {
            add("block." + PremierPainMod.MODID + "." + suffix1 + "_" + suffix2 + pedestal, translation1 + translationPedestal);
        }
        else
        {
            add("block." + PremierPainMod.MODID + "." + suffix1 + "_" + suffix2 + pedestal, translation1 +" "+ suffix2 + translationPedestal);
        }
    }
    private void villagerWorkshopTranslation()
    {
        add("block."+PremierPainMod.MODID+".villager_workshop","Villager Workshop");
    }
    private void tableTranslation(String suffix)
    {
        String translation = capitalize(suffix);
        String table = "_villager_table";
        String translationTable = " villager table";
        add("block."+PremierPainMod.MODID+"."+ suffix + table,translation + translationTable);
    }

    private void tableTranslation(String suffix1, String suffix2, Boolean isSuffix2Translate)
    {
        String translation1 = capitalize(suffix1);
        String table = "_villager_table";
        String translationTable = " villager table";
        if (!isSuffix2Translate)
        {
            add("block." + PremierPainMod.MODID + "." + suffix1 + "_" + suffix2 + table, translation1 + translationTable);
        }
        else
        {
            add("block." + PremierPainMod.MODID + "." + suffix1 + "_" + suffix2 + table, translation1 +" "+ suffix2 + translationTable);
        }
    }
    private void chairTranslation(String suffix)
    {
        String translation = capitalize(suffix);
        String table = "_villager_chair";
        String translationTable = " villager chair";
        add("block."+PremierPainMod.MODID+"."+ suffix + table,translation + translationTable);
    }

    private void chairTranslation(String suffix1, String suffix2, Boolean isSuffix2Translate)
    {
        String translation1 = capitalize(suffix1);
        String table = "_villager_chair";
        String translationTable = " villager chair";
        if (!isSuffix2Translate)
        {
            add("block." + PremierPainMod.MODID + "." + suffix1 + "_" + suffix2 + table, translation1 + translationTable);
        }
        else
        {
            add("block." + PremierPainMod.MODID + "." + suffix1 + "_" + suffix2 + table, translation1 +" "+ suffix2 + translationTable);
        }
    }
    private void throneChairTranslation(String suffix)
    {
        String translation = capitalize(suffix);
        String table = "_villager_throne_chair";
        String translationTable = " villager throne chair";
        add("block."+PremierPainMod.MODID+"."+ suffix + table,translation + translationTable);
    }

    private void throneChairTranslation(String suffix1, String suffix2, Boolean isSuffix2Translate)
    {
        String translation1 = capitalize(suffix1);
        String table = "_villager_throne_chair";
        String translationTable = " villager throne chair";
        if (!isSuffix2Translate)
        {
            add("block." + PremierPainMod.MODID + "." + suffix1 + "_" + suffix2 + table, translation1 + translationTable);
        }
        else
        {
            add("block." + PremierPainMod.MODID + "." + suffix1 + "_" + suffix2 + table, translation1 +" "+ suffix2 + translationTable);
        }
    }
    private void drawerTranslation(String suffix)
    {
        String translation = capitalize(suffix);
        String table = "_villager_drawer";
        String translationTable = " villager drawer";
        add("block."+PremierPainMod.MODID+"."+ suffix + table,translation + translationTable);
    }

    private void drawerTranslation(String suffix1, String suffix2, Boolean isSuffix2Translate)
    {
        String translation1 = capitalize(suffix1);
        String table = "_villager_drawer";
        String translationTable = " villager drawer";
        if (!isSuffix2Translate)
        {
            add("block." + PremierPainMod.MODID + "." + suffix1 + "_" + suffix2 + table, translation1 + translationTable);
        }
        else
        {
            add("block." + PremierPainMod.MODID + "." + suffix1 + "_" + suffix2 + table, translation1 +" "+ suffix2 + translationTable);
        }
    }
    private void shelfTranslation(String suffix)
    {
        String translation = capitalize(suffix);
        String shelfItem = "_villager_shelf";
        String wallShelf = "_wall_villager_shelf";
        String standingShelf = "_standing_villager_shelf";
        String translationTable = " villager shelf";
        add("block."+PremierPainMod.MODID+"."+ suffix + shelfItem,translation + translationTable);
        add("block."+PremierPainMod.MODID+"."+ suffix + wallShelf,translation + translationTable);
        add("block."+PremierPainMod.MODID+"."+ suffix + standingShelf,translation + translationTable);
    }

    private void shelfTranslation(String suffix1, String suffix2, Boolean isSuffix2Translate)
    {
        String translation1 = capitalize(suffix1);
        String shelfItem = "_villager_shelf";
        String wallShelf = "_wall_villager_shelf";
        String standingShelf = "_standing_villager_shelf";
        String translationTable = " villager shelf";
        if (!isSuffix2Translate)
        {
            add("block." + PremierPainMod.MODID + "." + suffix1 + "_" + suffix2 + shelfItem, translation1 + translationTable);
            add("block." + PremierPainMod.MODID + "." + suffix1 + "_" + suffix2 + wallShelf, translation1 + translationTable);
            add("block." + PremierPainMod.MODID + "." + suffix1 + "_" + suffix2 + standingShelf, translation1 + translationTable);
        }
        else
        {
            add("block." + PremierPainMod.MODID + "." + suffix1 + "_" + suffix2 + shelfItem, translation1 +" "+ suffix2 + translationTable);
        }
    }
}