package com.unpainperdu.premierpainmod.data.language;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.apache.commons.lang3.text.WordUtils;

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
        add(ItemRegister.VILLAGER_ICON.get(), "Icone de villageois");

        StatueTranslation("oak","chêne");
        StatueTranslation("birch","bouleau");
        StatueTranslation("spruce","sapin");
        StatueTranslation("jungle","acajou");
        StatueTranslation("acacia","acacia");
        add("block.premierpainmod.dark_oak_villager_statue","Statue de villageois en chêne noir");
        StatueTranslation("mangrove","palétuvier");
        StatueTranslation("cherry","cerisier");
        add("block.premierpainmod.crimson_villager_statue","Statue de villageois en bois carmin");
        add("block.premierpainmod.warped_villager_statue","Statue de villageois en bois biscornu");
        StatueTranslation("bamboo","bambou");
        StatueTranslation("stone","pierre");
        StatueTranslation("andesite","andésite");
        StatueTranslation("diorite","diorite");
        StatueTranslation("granite","granite");
        StatueTranslation("prismarine","prismarine");
        StatueTranslation("blackstone", "pierre noir");
        add("block.premierpainmod.purpur_block_villager_statue","Statue de villageois en purpur");
        StatueTranslation("cobblestone", "pierre taillée");
        add("block.premierpainmod.mossy_cobblestone_villager_statue","Statue de villageois en pierre mossue");
        add("block.premierpainmod.smooth_stone_villager_statue","Statue de villageois en pierre lisse");
        add("block.premierpainmod.cobbled_deepslate_villager_statue","Statue de villageois en pierre des abîmes");
        StatueTranslation("tuff","tuf");
        add("block.premierpainmod.packed_mud_villager_statue","Statue de villageois en terre crue");
        StatueTranslation("sandstone","grès");
        add("block.premierpainmod.red_sandstone_villager_statue","Statue de villageois en grès rouge");
        add("block.premierpainmod.quartz_block_villager_statue","Statue de villageois en quartz");
        add("block.premierpainmod.nether_bricks_villager_statue","Statue de villageois en briques du nether");
        StatueTranslation("basalt","basalt");
        add("block.premierpainmod.end_stone_villager_statue","Statue de villageois en pierre de l'end");
        add("block.premierpainmod.coal_block_villager_statue","Statue de villageois en charbon");
        add("block.premierpainmod.iron_block_villager_statue","Iron Statue de villageois en fer");
        add("block.premierpainmod.gold_block_villager_statue","Gold Statue de villageois en or");
        add("block.premierpainmod.redstone_block_villager_statue","Redstone Statue de villageois en redstone");
        add("block.premierpainmod.emerald_block_villager_statue","Emerald Statue de villageois en émeraude");
        add("block.premierpainmod.diamond_block_villager_statue","Statue de villageois en diamant");
        add("block.premierpainmod.copper_block_villager_statue","Statue de villageois en cuivre");
        add("block.premierpainmod.lapis_block_villager_statue","Statue de villageois en lapis-lazuli");
        add("block.premierpainmod.netherite_block_villager_statue","Statue de villageois en netherite");
        add("block.premierpainmod.obsidian_block_villager_statue","Statue de villageois en obsidienne");
        add("block.premierpainmod.amethyst_block_villager_statue","Statue de villageois en améthyste");
        add("block.premierpainmod.dripstone_block_villager_statue","Statue de villageois en spéléothème");
        add("block.premierpainmod.bedrock_block_villager_statue","Statue de villageois en bedrock");
    }
    // will create translation : "block.premierpainmod.'suffix'_villager_statue": "Statue de villageois en 'translation'"
    private void StatueTranslation(String suffix, String translation)
    {
        String statue = "_villager_statue";
        String Tstatue = "Statue de villageois en ";
        add("block."+PremierPainMod.MODID+"."+suffix+statue,Tstatue+translation);
    }
}