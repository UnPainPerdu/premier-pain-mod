package com.unpainperdu.premierpainmod.datagen.data.tag;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.ModBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.common.Tags;
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
        generateTagsForOverWorldBiome(ModBiomes.FOREST_PREMIER_PAIN_RUINS,
                BiomeTags.IS_FOREST,
                Tags.Biomes.IS_DENSE_VEGETATION
        );
            //swamp
        generateTagsForOverWorldBiome(ModBiomes.SWAMP_PREMIER_PAIN_RUINS,
                Tags.Biomes.IS_SWAMP,
                Tags.Biomes.IS_WET,
                BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS
        );
            //desert
        generateTagsForOverWorldBiome(ModBiomes.SAND_DESERT_PREMIER_PAIN_RUINS,
                Tags.Biomes.IS_DESERT,
                Tags.Biomes.IS_HOT,
                BiomeTags.SNOW_GOLEM_MELTS
        );
        //old great field
        generateTagsForOverWorldBiome(ModBiomes.OLD_GREAT_FIELD,
                Tags.Biomes.IS_PLAINS
        );

        super.addTags(pProvider);
    }

    private void generateTagsForOverWorldBiome(ResourceKey<Biome> biome, TagKey<Biome> ... tags)
    {
        for(TagKey<Biome> tag : tags)
        {
            generateTag(biome, tag);
        }
        generateTag(biome, BiomeTags.HAS_MINESHAFT);
        generateTag(biome, BiomeTags.IS_OVERWORLD);
    }

    private void generateTag(ResourceKey<Biome> biome, TagKey<Biome> tag)
    {
        this.tag(tag).addOptional(biome.location());
    }
}
