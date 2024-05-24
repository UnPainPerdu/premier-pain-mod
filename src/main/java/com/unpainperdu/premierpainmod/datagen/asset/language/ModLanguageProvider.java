package com.unpainperdu.premierpainmod.datagen.asset.language;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class ModLanguageProvider
{
    public ModLanguageProvider(GatherDataEvent event, DataGenerator generator, PackOutput packOutput)
    {
        generator.addProvider(event.includeClient(), new EnglishLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new FrenchLanguageProvider(packOutput));
    }
}
