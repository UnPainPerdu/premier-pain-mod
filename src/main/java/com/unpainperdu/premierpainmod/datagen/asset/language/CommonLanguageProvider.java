package com.unpainperdu.premierpainmod.datagen.asset.language;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class CommonLanguageProvider
{
    private final LanguageProvider languageProvider;

    public CommonLanguageProvider(LanguageProvider languageProvider)
    {
        this.languageProvider = languageProvider;
    }

    public void deathTranslation(String id, String translation)
    {
        this.languageProvider.add("death.attack." + PremierPainMod.MOD_ID + ":" + id, translation);
    }

    public void descriptionMakerWIP(String idOfItem, String translation)
    {
        descriptionMaker(idOfItem, translation + " !!!Sound in WIP, will be more villager like when i will know how to do");
    }

    public void descriptionMaker(String idOfItem, String translation)
    {
        this.languageProvider.add("item.description." + idOfItem.replace(PremierPainMod.MOD_ID + ":", ""), translation);
    }

    public void generateAdvancementTranslation(String advancementName, String titleTranslation, String descriptionTranslation)
    {
        this.languageProvider.add("advancements.premierpainmod." + advancementName + ".title", titleTranslation);
        this.languageProvider.add("advancements.premierpainmod." + advancementName + ".description", descriptionTranslation);
    }

    public void generateRootAdvancementTranslation(String advancementPageName, String titleTranslation, String descriptionTranslation)
    {
        this.languageProvider.add("advancements.premierpainmod." + advancementPageName + ".root.title", titleTranslation);
        this.languageProvider.add("advancements.premierpainmod." + advancementPageName + ".root.description", descriptionTranslation);
    }

    public void generatePaintingTranslation(String name, String titleTranslation, String author)
    {
        this.languageProvider.add("painting.premierpainmod." + name + ".title", titleTranslation);
        this.languageProvider.add("painting.premierpainmod." + name + ".author", author);
    }
}
