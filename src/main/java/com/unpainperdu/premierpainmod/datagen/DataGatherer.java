package com.unpainperdu.premierpainmod.datagen;

import com.unpainperdu.premierpainmod.datagen.asset.language.ModLanguageProvider;
import com.unpainperdu.premierpainmod.datagen.asset.model.ModBlockStateProvider;
import com.unpainperdu.premierpainmod.datagen.asset.model.ModItemStateProvider;
import com.unpainperdu.premierpainmod.datagen.data.ModBlockTagProvider;
import com.unpainperdu.premierpainmod.datagen.data.ModLootTableProvider;
import com.unpainperdu.premierpainmod.datagen.data.ModRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

public class DataGatherer
{
    public static void dataGatherer(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        new ModLanguageProvider(event, generator, packOutput);
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new ModLootTableProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(),new ModBlockTagProvider(packOutput, lookupProvider, fileHelper));
        generator.addProvider(event.includeServer(),new ModBlockStateProvider(packOutput, fileHelper));
        generator.addProvider(event.includeServer(),new ModItemStateProvider(packOutput, fileHelper));
    }
}
