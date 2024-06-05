package com.unpainperdu.premierpainmod.datagen.asset.language;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class FrenchLanguageProvider extends LanguageProvider
{
    public FrenchLanguageProvider(PackOutput packOutput)
    {
        super(packOutput, PremierPainMod.MODID, "fr_fr");
    }
    @Override
    protected void addTranslations()
    {
        add("itemGroup.premierpainmod", "Mod Premier Pain");
        add("container."+ PremierPainMod.MODID +"villager_workshop","Atelier du villageois");
        //item
        add(ItemRegister.VILLAGER_ICON.get(), "Icone de villageois");
        //block
            // villager workshop
        villagerWorkshopTranslation();
            // "All material"
        globalAllMaterialTranslation("oak", "chêne");
        globalAllMaterialTranslation("birch","bouleau");
        globalAllMaterialTranslation("spruce","sapin");
        globalAllMaterialTranslation("jungle","acajou");
        globalAllMaterialTranslation("acacia","acacia");
        globalAllMaterialTranslation("dark_oak","chêne noir");
        globalAllMaterialTranslation("mangrove","palétuvier");
        globalAllMaterialTranslation("cherry","cerisier");
        globalAllMaterialTranslation("crimson", "bois carmin");
        globalAllMaterialTranslation("warped","bois biscornu");
        globalAllMaterialTranslation("bamboo","bambou");
        globalAllMaterialTranslation("stone","pierre");
        globalAllMaterialTranslation("mossy_stone","pierre mossue");
        globalAllMaterialTranslation("andesite","andésite");
        globalAllMaterialTranslation("diorite","diorite");
        globalAllMaterialTranslation("granite","granite");
        globalAllMaterialTranslation("prismarine","prismarine");
        globalAllMaterialTranslation("blackstone","pierre noir");
        globalAllMaterialTranslation("purpur_block","purpur");
        globalAllMaterialTranslation("deepslate","pierre des abîmes");
        globalAllMaterialTranslation("tuff","tuf");
        globalAllMaterialTranslation("packed_mud","terre crue");
        globalAllMaterialTranslation("sandstone","grès");
        globalAllMaterialTranslation("red_sandstone","grès rouge");
        globalAllMaterialTranslation("quartz_block","quartz");
        globalAllMaterialTranslation("nether_bricks","briques du nether");
        globalAllMaterialTranslation("basalt","basalt");
        globalAllMaterialTranslation("end_stone","pierre de l'end");
        globalAllMaterialTranslation("coal_block","charbon");
        globalAllMaterialTranslation("iron_block","fer");
        globalAllMaterialTranslation("gold_block","or");
        globalAllMaterialTranslation("redstone_block","redstone");
        globalAllMaterialTranslation("emerald_block","émeraude");
        globalAllMaterialTranslation("diamond_block","diamant");
        globalAllMaterialTranslation("copper_block","cuivre");
        globalAllMaterialTranslation("lapis_block","lapis-lazuli");
        globalAllMaterialTranslation("netherite_block","netherite");
        globalAllMaterialTranslation("obsidian","obsidienne");
        globalAllMaterialTranslation("amethyst_block","améthyste");
        globalAllMaterialTranslation("dripstone_block","spéléothème");
        globalAllMaterialTranslation("bedrock","bedrock");
    }
    //Only use for "all material" blocks
    private void globalAllMaterialTranslation(String suffix, String translationSuffix)
    {
        statueTranslation(suffix, translationSuffix);
        pedestalTranslation(suffix, translationSuffix);
        brazierTranslation(suffix, translationSuffix);
    }
    // will create translation : "block.premierpainmod.suffix_villager_statue": "Statue de villageois 'Suffix'"
    private void statueTranslation(String suffix, String translation)
    {
        String statue = "_villager_statue";
        String translationStatue = "Statue de villageois en ";
        add("block."+PremierPainMod.MODID+"."+suffix+statue,translationStatue + translation);
    }
    // will create translation : "block.premierpainmod.suffix_villager_statue": "'Suffix' pedestal"
    private void pedestalTranslation(String suffix, String translation)
    {
        String pedestal = "_villager_pedestal";
        String translationPedestal = "Piédestale en ";
        add("block."+PremierPainMod.MODID+"."+suffix+pedestal,translationPedestal + translation);
    }
    private void brazierTranslation(String suffix, String translation)
    {
        String pedestal = "_villager_brazier";
        String translationPedestal = "Brazero en ";
        add("block."+PremierPainMod.MODID+"."+suffix+pedestal,translationPedestal + translation);
    }
    private void villagerWorkshopTranslation()
    {
        add("block."+PremierPainMod.MODID+".villager_workshop","Atelier du villageois");
    }
}