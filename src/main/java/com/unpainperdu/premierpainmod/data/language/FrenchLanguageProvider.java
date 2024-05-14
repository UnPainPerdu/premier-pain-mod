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
    }
    // will create translation : "block.premierpainmod.'suffix'_villager_statue": "Statue de villageois en 'translation'"
    private void StatueTranslation(String suffix, String translation)
    {
        String statue = "_villager_statue";
        String Tstatue = "Statue de villageois en ";
        add("block."+PremierPainMod.MODID+"."+suffix+statue,Tstatue+translation);
    }
}