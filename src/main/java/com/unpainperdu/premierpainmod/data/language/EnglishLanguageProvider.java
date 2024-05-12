package com.unpainperdu.premierpainmod.data.language;

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
    }
    private void StatueTranslation(String suffix)
    {
        String translation = capitalize(suffix);
        String statue = "_villager_statue";
        String Tstatue = " villager statue";
        add("block."+PremierPainMod.MODID+"."+suffix+statue,translation+Tstatue);
    }
}