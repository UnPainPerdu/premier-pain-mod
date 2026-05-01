package com.unpainperdu.premierpainmod.datagen.data.tag;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.datagen.data.level.world.entity.ModPaintingVariant;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.PaintingVariantTags;

import java.util.concurrent.CompletableFuture;

public class ModPaintingVariantTagsProvider extends net.minecraft.data.tags.PaintingVariantTagsProvider
{
    public ModPaintingVariantTagsProvider(
            PackOutput packOutput,
            CompletableFuture<HolderLookup.Provider> lookupProvider
    )
    {
        super(packOutput, lookupProvider, PremierPainMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider)
    {
        super.addTags(provider);

        this.tag(PaintingVariantTags.PLACEABLE)
                .add(
                        ModPaintingVariant.LANDSCAPE_0,
                        ModPaintingVariant.LANDSCAPE_1,
                        ModPaintingVariant.LANDSCAPE_2,
                        ModPaintingVariant.FLOWERD_CACTUS,
                        ModPaintingVariant.UNDERGROUND_GATE
                );
    }
}