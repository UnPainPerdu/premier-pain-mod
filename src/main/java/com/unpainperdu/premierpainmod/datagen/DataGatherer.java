package com.unpainperdu.premierpainmod.datagen;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.datagen.asset.ModParticleDescriptionProvider;
import com.unpainperdu.premierpainmod.datagen.asset.ModSoundProvider;
import com.unpainperdu.premierpainmod.datagen.asset.language.ModLanguageProvider;
import com.unpainperdu.premierpainmod.datagen.asset.model.ModItemStateProvider;
import com.unpainperdu.premierpainmod.datagen.asset.model.block.ModBlockStateProvider;
import com.unpainperdu.premierpainmod.datagen.data.ModAdvancementProvider;
import com.unpainperdu.premierpainmod.datagen.data.ModGlobalLootModifierProvider;
import com.unpainperdu.premierpainmod.datagen.data.ModRecipeProvider;
import com.unpainperdu.premierpainmod.datagen.data.datamap.ModDataMap;
import com.unpainperdu.premierpainmod.datagen.data.level.world.ModDamageType;
import com.unpainperdu.premierpainmod.datagen.data.level.world.block.entity.ModPaintingVariant;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome.ModBiomes;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome.feature.features.ModFeatureUtil;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome.feature.placement.ModPlacementUtil;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.ModStructure;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.processorlist.ModStructureProcessorList;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.ModStructureSet;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool.ModStructureTemplatePool;
import com.unpainperdu.premierpainmod.datagen.data.loot_table.ModLootTableProvider;
import com.unpainperdu.premierpainmod.datagen.data.tag.ModTagSpliter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DataGatherer
{
    public static void dataGatherer(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = onGatherData(event);

        ModLanguageProvider.spliter(event, generator, packOutput);
        ModTagSpliter.spliter(event.includeServer(), generator, packOutput, fileHelper, lookupProvider);
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new ModLootTableProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new ModBlockStateProvider(packOutput, fileHelper));
        generator.addProvider(event.includeServer(), new ModItemStateProvider(packOutput, fileHelper));
        generator.addProvider(event.includeServer(), new ModSoundProvider(packOutput, fileHelper));
        generator.addProvider(event.includeServer(), new ModGlobalLootModifierProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new ModDataMap(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new ModAdvancementProvider(packOutput, lookupProvider, fileHelper));
        generator.addProvider(event.includeClient(), new ModParticleDescriptionProvider(packOutput, fileHelper));
    }

    private static CompletableFuture<HolderLookup.Provider> onGatherData(GatherDataEvent event)
    {
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        return event.getGenerator().addProvider(event.includeServer(),
                (DataProvider.Factory<DatapackBuiltinEntriesProvider>) output -> new DatapackBuiltinEntriesProvider(
                        output,
                        lookupProvider,
                        new RegistrySetBuilder()
                                .add(Registries.DAMAGE_TYPE, ModDamageType::boostrap)
                                .add(Registries.BIOME, ModBiomes::boostrap)
                                .add(Registries.PLACED_FEATURE, ModPlacementUtil::bootstrap)
                                .add(Registries.CONFIGURED_FEATURE, ModFeatureUtil::bootstrap)
                                .add(Registries.TEMPLATE_POOL, ModStructureTemplatePool::boostrap)
                                .add(Registries.STRUCTURE, ModStructure::boostrap)
                                .add(Registries.STRUCTURE_SET, ModStructureSet::boostrap)
                                .add(Registries.PROCESSOR_LIST, ModStructureProcessorList::boostrap)
                                .add(Registries.PAINTING_VARIANT, ModPaintingVariant::boostrap)
                        ,
                        Set.of(PremierPainMod.MOD_ID))
        ).getRegistryProvider();
    }
}
