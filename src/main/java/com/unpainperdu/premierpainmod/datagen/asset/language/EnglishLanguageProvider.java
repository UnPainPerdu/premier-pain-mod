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
        add(ItemRegister.VILLAGER_ICON.get(), "Villager icon");

        StatueTranslation("oak");
        StatueTranslation("birch");
        StatueTranslation("spruce");
        StatueTranslation("jungle");
        StatueTranslation("acacia");
        add("block.premierpainmod.dark_oak_villager_statue","Dark oak villager statue");
        StatueTranslation("mangrove");
        StatueTranslation("cherry");
        StatueTranslation("crimson");
        StatueTranslation("warped");
        StatueTranslation("bamboo");
        StatueTranslation("stone");
        StatueTranslation("andesite");
        StatueTranslation("diorite");
        StatueTranslation("granite");
        StatueTranslation("prismarine");
        StatueTranslation("blackstone");
        add("block.premierpainmod.purpur_block_villager_statue","Purpur villager statue");
        StatueTranslation("cobblestone");
        add("block.premierpainmod.mossy_cobblestone_villager_statue","Mossy cobblestone villager statue");
        add("block.premierpainmod.smooth_stone_villager_statue","Smooth stone villager statue");
        add("block.premierpainmod.cobbled_deepslate_villager_statue","Deepslate villager statue");
        StatueTranslation("tuff");
        add("block.premierpainmod.packed_mud_villager_statue","Packed mud villager statue");
        StatueTranslation("sandstone");
        add("block.premierpainmod.red_sandstone_villager_statue","Red sandstone villager statue");
        add("block.premierpainmod.quartz_block_villager_statue","Quartz villager statue");
        add("block.premierpainmod.nether_bricks_villager_statue","Nether bricks villager statue");
        StatueTranslation("basalt");
        add("block.premierpainmod.end_stone_villager_statue","End stone villager statue");
        add("block.premierpainmod.coal_block_villager_statue","Coal villager statue");
        add("block.premierpainmod.iron_block_villager_statue","Iron villager statue");
        add("block.premierpainmod.gold_block_villager_statue","Gold villager statue");
        add("block.premierpainmod.redstone_block_villager_statue","Redstone villager statue");
        add("block.premierpainmod.emerald_block_villager_statue","Emerald villager statue");
        add("block.premierpainmod.diamond_block_villager_statue","Diamond villager statue");
        add("block.premierpainmod.copper_block_villager_statue","Copper villager statue");
        add("block.premierpainmod.lapis_block_villager_statue","Lapis villager statue");
        add("block.premierpainmod.netherite_block_villager_statue","Netherite villager statue");
        add("block.premierpainmod.obsidian_block_villager_statue","Obsidian villager statue");
        add("block.premierpainmod.amethyst_block_villager_statue","Amethyst villager statue");
        add("block.premierpainmod.dripstone_block_villager_statue","Dripstone villager statue");
        add("block.premierpainmod.bedrock_block_villager_statue","Bedrock villager statue");
    }
    // will create translation : "block.premierpainmod.suffix_villager_statue": "'Suffix' villager statue"
    private void StatueTranslation(String suffix)
    {
        String translation = capitalize(suffix);
        String statue = "_villager_statue";
        String Tstatue = " villager statue";
        add("block."+PremierPainMod.MODID+"."+suffix+statue,translation+Tstatue);
    }
}