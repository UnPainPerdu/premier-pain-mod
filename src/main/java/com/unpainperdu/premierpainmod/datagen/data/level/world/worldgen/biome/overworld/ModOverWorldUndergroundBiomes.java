package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome.overworld;

import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.feature.placement.ModMiscOverworldPlacements;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

import java.util.ArrayList;

import static com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome.ModBiomes.*;

public class ModOverWorldUndergroundBiomes
{
    public static final ArrayList<ResourceKey<Biome>> OVERWORLD_UNDERGORUND_BIOMES = new ArrayList<>();

    public static final ResourceKey<Biome> GYPSUM_CAVE = createKey("gypsum_cave", OVERWORLD_BIOMES, OVERWORLD_UNDERGORUND_BIOMES);

    public static void boostrap(BootstrapContext<Biome> context)
    {
        context.register(GYPSUM_CAVE, gypsumCave(context));
    }

    private static Biome gypsumCave(BootstrapContext<Biome> context)
    {
        float temperature = 2.0F;
        float downfall = 0.8f;

        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder featureBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.dripstoneCavesSpawns(mobBuilder);
        globalOverworldGeneration(featureBuilder);
        BiomeDefaultFeatures.addPlainGrass(featureBuilder);
        BiomeDefaultFeatures.addDefaultOres(featureBuilder, true);
        BiomeDefaultFeatures.addDefaultSoftDisks(featureBuilder);
        BiomeDefaultFeatures.addPlainVegetation(featureBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(featureBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(featureBuilder);
        featureBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModMiscOverworldPlacements.TALL_CRYSTAL);
        featureBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModMiscOverworldPlacements.POINTED_CRYSTAL);
        featureBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModMiscOverworldPlacements.POINTED_BLOB_CRYSTAL);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(temperature)
                .downfall(downfall)
                .specialEffects(
                        new BiomeSpecialEffects.Builder()
                                .waterColor(4159204)
                                .waterFogColor(329011)
                                .fogColor(12638463)
                                .skyColor(calculateSkyColor(temperature))
                                .foliageColorOverride(0x59AE30)
                                .grassColorOverride(0x79C05A)
                                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DRIPSTONE_CAVES))
                                .build()
                )
                .mobSpawnSettings(mobBuilder.build())
                .generationSettings(featureBuilder.build())
                .build();
    }
}
