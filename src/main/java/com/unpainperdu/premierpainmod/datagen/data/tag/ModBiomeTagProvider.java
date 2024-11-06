package com.unpainperdu.premierpainmod.datagen.data.tag;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.ModBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends BiomeTagsProvider
{
    public ModBiomeTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(pOutput, pProvider, PremierPainMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider)
    {

        //Premier Pain ruins
            //forest
        this.tag(BiomeTags.IS_FOREST).add(ModBiomes.FOREST_PREMIER_PAIN_RUINS);
        this.tag(BiomeTags.IS_OVERWORLD).add(ModBiomes.FOREST_PREMIER_PAIN_RUINS);
            //swamp
        this.tag(BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS).add(ModBiomes.SWAMP_PREMIER_PAIN_RUINS);
        this.tag(BiomeTags.IS_OVERWORLD).add(ModBiomes.SWAMP_PREMIER_PAIN_RUINS);
            //desert
        this.tag(BiomeTags.SNOW_GOLEM_MELTS).add(ModBiomes.SAND_DESERT_PREMIER_PAIN_RUINS);
        this.tag(BiomeTags.SPAWNS_WARM_VARIANT_FROGS).add(ModBiomes.SAND_DESERT_PREMIER_PAIN_RUINS);
        this.tag(BiomeTags.IS_OVERWORLD).add(ModBiomes.SAND_DESERT_PREMIER_PAIN_RUINS);

        super.addTags(pProvider);
    }
}
