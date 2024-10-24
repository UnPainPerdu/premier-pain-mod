package com.unpainperdu.premierpainmod.datagen;

import com.unpainperdu.premierpainmod.datagen.asset.ModSoundProvider;
import com.unpainperdu.premierpainmod.datagen.asset.language.ModLanguageProvider;
import com.unpainperdu.premierpainmod.datagen.asset.model.ModBlockStateProvider;
import com.unpainperdu.premierpainmod.datagen.asset.model.ModItemStateProvider;
import com.unpainperdu.premierpainmod.datagen.data.*;
import com.unpainperdu.premierpainmod.datagen.data.dataPackRegistries.ModDataPackProvider;
import com.unpainperdu.premierpainmod.datagen.data.datamap.ModDataMap;
import com.unpainperdu.premierpainmod.datagen.data.lootTable.ModLootTableProvider;
import com.unpainperdu.premierpainmod.datagen.data.tag.ModBiomeTagProvider;
import com.unpainperdu.premierpainmod.datagen.data.tag.ModBlockTagProvider;
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
        generator.addProvider(event.includeServer(),new ModBiomeTagProvider(packOutput, lookupProvider, fileHelper));
        generator.addProvider(event.includeServer(),new ModBlockStateProvider(packOutput, fileHelper));
        generator.addProvider(event.includeServer(),new ModItemStateProvider(packOutput, fileHelper));
        generator.addProvider(event.includeServer(), new ModSoundProvider(packOutput,fileHelper));
        generator.addProvider(event.includeServer(), new ModGlobalLootModifierProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new ModDataMap(packOutput, lookupProvider));


        ModDataPackProvider.onGatherData(event);
    }
}
