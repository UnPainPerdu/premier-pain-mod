package com.unpainperdu.premierpainmod.datagen.data.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModTagSpliter
{
    private ModTagSpliter()
    {
    }

    public static void spliter(boolean run, DataGenerator generator, PackOutput packOutput, ExistingFileHelper fileHelper, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(packOutput, lookupProvider, fileHelper);
        generator.addProvider(run, blockTagsProvider);
        generator.addProvider(run, new ModItemTagProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), fileHelper));
        generator.addProvider(run, new ModBiomeTagProvider(packOutput, lookupProvider, fileHelper));
        generator.addProvider(run, new ModFluidTag(packOutput, lookupProvider, fileHelper));
        generator.addProvider(run, new ModPaintingVariantTagsProvider(packOutput, lookupProvider, fileHelper));
    }
}
