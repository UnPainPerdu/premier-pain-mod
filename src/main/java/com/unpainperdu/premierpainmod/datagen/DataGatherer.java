package com.unpainperdu.premierpainmod.datagen;

import com.unpainperdu.premierpainmod.datagen.asset.ModParticleDescriptionProvider;
import com.unpainperdu.premierpainmod.datagen.asset.ModSoundProvider;
import com.unpainperdu.premierpainmod.datagen.asset.language.EnglishLanguageProvider;
import com.unpainperdu.premierpainmod.datagen.asset.language.FrenchLanguageProvider;
import com.unpainperdu.premierpainmod.datagen.asset.model.ModModel;
import com.unpainperdu.premierpainmod.datagen.data.ModAdvancementProvider;
import com.unpainperdu.premierpainmod.datagen.data.ModGlobalLootModifierProvider;
import com.unpainperdu.premierpainmod.datagen.data.datamap.ModDataMap;
import com.unpainperdu.premierpainmod.datagen.data.level.world.ModDamageType;
import com.unpainperdu.premierpainmod.datagen.data.level.world.entity.ModPaintingVariant;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome.ModBiomes;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.feature.features.ModFeatureUtil;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.feature.placement.ModPlacementUtil;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.ModStructure;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.ModStructureSet;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.processorlist.ModStructureProcessorList;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool.ModStructureTemplatePool;
import com.unpainperdu.premierpainmod.datagen.data.loot_table.ModLootTableProvider;
import com.unpainperdu.premierpainmod.datagen.data.recipe.ModRecipeProvider;
import com.unpainperdu.premierpainmod.datagen.data.tag.*;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGatherer
{
    public static void dataGatherer(GatherDataEvent.Client event)
    {
        event.createDatapackRegistryObjects(
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
        );
        //languages
        event.createProvider(EnglishLanguageProvider::new);
        event.createProvider(FrenchLanguageProvider::new);
        //tags
        ModBlockTagProvider blockTagsProvider = event.createProvider(ModBlockTagProvider::new);
        event.createProvider((packOutput, loukupProvider) -> new ModItemTagProvider(packOutput, loukupProvider, blockTagsProvider.contentsGetter()));
        event.createProvider(ModBiomeTagProvider::new);
        event.createProvider(ModFluidTag::new);
        event.createProvider(ModPaintingVariantTagsProvider::new);
        event.createProvider(ModPoiTag::new);
        //other
        event.createProvider(ModModel::new);
        event.createProvider(ModRecipeProvider.Runner::new);
        event.createProvider(ModLootTableProvider::new);
        event.createProvider(ModModel::new);
        event.createProvider(ModSoundProvider::new);
        event.createProvider(ModGlobalLootModifierProvider::new);
        event.createProvider(ModDataMap::new);
        event.createProvider(ModAdvancementProvider::new);
        event.createProvider(ModParticleDescriptionProvider::new);
    }
}