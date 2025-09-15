package com.unpainperdu.premierpainmod.datagen;

import com.unpainperdu.premierpainmod.datagen.data.ModAdvancementProvider;
import com.unpainperdu.premierpainmod.datagen.asset.ModParticleDescriptionProvider;
import com.unpainperdu.premierpainmod.datagen.asset.ModSoundProvider;
import com.unpainperdu.premierpainmod.datagen.asset.language.ModLanguageProvider;
import com.unpainperdu.premierpainmod.datagen.asset.model.block.ModBlockStateProvider;
import com.unpainperdu.premierpainmod.datagen.asset.model.ModItemStateProvider;
import com.unpainperdu.premierpainmod.datagen.data.*;
import com.unpainperdu.premierpainmod.datagen.data.data_pack_registries.ModDataPackProvider;
import com.unpainperdu.premierpainmod.datagen.data.datamap.ModDataMap;
import com.unpainperdu.premierpainmod.datagen.data.loot_table.ModLootTableProvider;
import com.unpainperdu.premierpainmod.datagen.data.tag.ModBiomeTagProvider;
import com.unpainperdu.premierpainmod.datagen.data.tag.ModBlockTagProvider;
import com.unpainperdu.premierpainmod.datagen.data.tag.ModFluidTag;
import com.unpainperdu.premierpainmod.datagen.data.tag.ModItemTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
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

        BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(packOutput, lookupProvider, fileHelper);

        new ModLanguageProvider(event, generator, packOutput);
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new ModLootTableProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new ModItemTagProvider(packOutput,lookupProvider, blockTagsProvider.contentsGetter(), fileHelper));
        generator.addProvider(event.includeServer(),new ModBiomeTagProvider(packOutput, lookupProvider, fileHelper));
        generator.addProvider(event.includeServer(),new ModBlockStateProvider(packOutput, fileHelper));
        generator.addProvider(event.includeServer(),new ModItemStateProvider(packOutput, fileHelper));
        generator.addProvider(event.includeServer(), new ModSoundProvider(packOutput,fileHelper));
        generator.addProvider(event.includeServer(), new ModGlobalLootModifierProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new ModDataMap(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new ModFluidTag(packOutput, lookupProvider, fileHelper));
        generator.addProvider(event.includeServer(), new ModAdvancementProvider(packOutput, lookupProvider, fileHelper));
        generator.addProvider(event.includeClient(), new ModParticleDescriptionProvider(packOutput, fileHelper));

        ModDataPackProvider.onGatherData(event);
    }
}
