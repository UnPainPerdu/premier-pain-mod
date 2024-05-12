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
    }
    private void StatueTranslation(String suffix, String translation)
    {
        String statue = "_villager_statue";
        String Tstatue = "Statue de villageois en ";
        add("block."+PremierPainMod.MODID+"."+suffix+statue,Tstatue+translation);
    }
}