package com.unpainperdu.premierpainmod.level.world.worldgen.biome;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomes
{
    public static  final ResourceKey<Biome> PREMIER_PAIN_RUINS = ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "premier_pain_ruins"));

    public static void boostrap(BootstrapContext<Biome> context)
    {
        context.register(PREMIER_PAIN_RUINS, premierPainRuins(context));
    }

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder pGenerationSettings)
    {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(pGenerationSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(pGenerationSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(pGenerationSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(pGenerationSettings);
        BiomeDefaultFeatures.addDefaultSprings(pGenerationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(pGenerationSettings);
    }

    protected static int calculateSkyColor(float pTemperature)
    {
        float $$1 = pTemperature / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    private static Biome premierPainRuins(BootstrapContext<Biome> context)
    {
        float temperature = 0.8F;

        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        //must be in vanilla order
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(biomegenerationsettings$builder);
        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, MiscOverworldPlacements.SPRING_WATER);
        BiomeDefaultFeatures.addSurfaceFreezing(biomegenerationsettings$builder);
        BiomeDefaultFeatures.plainsSpawns(mobspawnsettings$builder);
        addVillagerStatue(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addPlainGrass(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addPlainVegetation(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(temperature)
                .downfall(0.4F)
                .specialEffects(
                        new BiomeSpecialEffects.Builder()
                                .waterColor(4159204)
                                .waterFogColor(329011)
                                .fogColor(12638463)
                                .skyColor(calculateSkyColor(temperature))
                                .foliageColorOverride(0x00FF00)
                                .grassColorOverride(0x50bb00)
                                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE))
                                .build()
                )
                .mobSpawnSettings(mobspawnsettings$builder.build())
                .generationSettings(biomegenerationsettings$builder.build())
                .build();
    }

    public static void addVillagerStatue(BiomeGenerationSettings.Builder pBuilder)
    {
        pBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModMiscOverworldPlacements.VILLAGER_STATUE_RUINS);
    }
}
