package com.unpainperdu.premierpainmod.datagen.asset.language;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.event.item_event.ItemEvent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

public class CommonLanguageProvider
{
    private final LanguageProvider languageProvider;

    public CommonLanguageProvider(LanguageProvider languageProvider)
    {
        this.languageProvider = languageProvider;
    }

    public void deathTranslation(ResourceKey<DamageType> dammageType, String translation)
    {
        this.languageProvider.add("death.attack." + PremierPainMod.MOD_ID + ":" + dammageType.location().toString().replace("premierpainmod:", ""), translation);
    }

    public void itemEventDescriptionMakerWIP(ItemEvent itemEvent, String translation)
    {
        itemEventDescriptionMaker(itemEvent, translation + " !!!Sound in WIP, will be more villager like when i will know how to do");
    }

    public void itemEventDescriptionMaker(ItemEvent itemEvent, String translation)
    {
        this.languageProvider.add(itemEvent.getDescription().getString(), translation);
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

    public void generateVillagerProfessionTranslation(DeferredHolder<VillagerProfession, VillagerProfession> profession, String translation)
    {
        this.languageProvider.add("entity.minecraft.villager." + PremierPainMod.MOD_ID + "." + profession.get().name(), translation);
    }
}
