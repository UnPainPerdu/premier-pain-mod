package com.unpainperdu.premierpainmod.datagen.data.tag;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider
{
    public ModItemTagProvider(PackOutput packOutput
            , CompletableFuture<HolderLookup.Provider> lookupProvider
            , CompletableFuture<TagLookup<Block>> blockTags
            , ExistingFileHelper fileHelper)
    {
        super(packOutput, lookupProvider, blockTags, PremierPainMod.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider)
    {
        copy(BlockTags.FLOWERS, ItemTags.FLOWERS);
    }
}
