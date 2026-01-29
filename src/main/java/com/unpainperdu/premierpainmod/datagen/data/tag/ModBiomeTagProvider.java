package com.unpainperdu.premierpainmod.datagen.data.tag;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome.overworld.ModOverworldSurfaceBiomes;
import com.unpainperdu.premierpainmod.datagen.data.tag.mod_tags.ModBiomeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends BiomeTagsProvider
{
    public ModBiomeTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(pOutput, provider, PremierPainMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider)
    {
        //Premier Pain ruins
        //forest
        generateTagsForOverWorldBiome(ModOverworldSurfaceBiomes.FOREST_PREMIER_PAIN_RUINS,
                BiomeTags.IS_FOREST,
                Tags.Biomes.IS_DENSE_VEGETATION,
                ModBiomeTags.HAS_FOREST_PREMIER_PAIN_TEMPLE
        );
        //desert
        generateTagsForOverWorldBiome(ModOverworldSurfaceBiomes.SAND_DESERT_PREMIER_PAIN_RUINS,
                Tags.Biomes.IS_DESERT,
                Tags.Biomes.IS_HOT,
                BiomeTags.SNOW_GOLEM_MELTS,
                ModBiomeTags.HAS_SAND_DESERT_PREMIER_PAIN_TEMPLE
        );
        //swamp
        generateTagsForOverWorldBiome(ModOverworldSurfaceBiomes.SWAMP_PREMIER_PAIN_RUINS,
                Tags.Biomes.IS_SWAMP,
                Tags.Biomes.IS_WET,
                BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS,
                ModBiomeTags.HAS_SWAMP_PREMIER_PAIN_TEMPLE
        );
        //jungle
        generateTagsForOverWorldBiome(ModOverworldSurfaceBiomes.JUNGLE_PREMIER_PAIN_RUINS,
                Tags.Biomes.IS_JUNGLE,
                Tags.Biomes.IS_WET,
                Tags.Biomes.IS_HOT,
                Tags.Biomes.IS_DENSE_VEGETATION,
                ModBiomeTags.HAS_JUNGLE_PREMIER_PAIN_TEMPLE
        );
        //old great field
        generateTagsForOverWorldBiome(ModOverworldSurfaceBiomes.OLD_GREAT_FIELD,
                Tags.Biomes.IS_PLAINS,
                ModBiomeTags.HAS_OLD_GREAT_FIELD
        );

        super.addTags(provider);
    }

    @SafeVarargs
    private void generateTagsForOverWorldBiome(ResourceKey<Biome> biome, TagKey<Biome>... tags)
    {
        for (TagKey<Biome> tag : tags)
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
