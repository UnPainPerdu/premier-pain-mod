package com.unpainperdu.premierpainmod.level.world.worldgen.biome;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.placement.ModMiscOverworldPlacements;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.placement.ModVegetationPlacement;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomes
{
    public static  final ResourceKey<Biome> FOREST_PREMIER_PAIN_RUINS = ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "forest_premier_pain_ruins"));
    public static  final ResourceKey<Biome> SAND_DESERT_PREMIER_PAIN_RUINS = ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "sand_desert_premier_pain_ruins"));

    public static void boostrap(BootstrapContext<Biome> context)
    {
        context.register(FOREST_PREMIER_PAIN_RUINS, forestPremierPainRuins(context));
        context.register(SAND_DESERT_PREMIER_PAIN_RUINS, sandDesertPremierPainRuins(context));
    }

    protected static int calculateSkyColor(float pTemperature)
    {
        float $$1 = pTemperature / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    private static Biome forestPremierPainRuins(BootstrapContext<Biome> context)
    {
        float temperature = 0.8F;
        float downfall = 0.4f;

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
        addHouseFoundationRuins(biomegenerationsettings$builder);
        addBushAndStoneFeature(biomegenerationsettings$builder);
        addRuinsFlowers(biomegenerationsettings$builder);
        addCivilizationsFlowers(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addPlainGrass(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addPlainVegetation(biomegenerationsettings$builder);
        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_BIRCH_AND_OAK);
        BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);

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
                                .foliageColorOverride(0x00FF00)
                                .grassColorOverride(0x50bb00)
                                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST))
                                .build()
                )
                .mobSpawnSettings(mobspawnsettings$builder.build())
                .generationSettings(biomegenerationsettings$builder.build())
                .build();
    }

    private static Biome sandDesertPremierPainRuins(BootstrapContext<Biome> context)
    {
        float temperature = 2.0F;
        float downfall = 0.0f;

        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        //must be in vanilla order
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(biomegenerationsettings$builder);
        biomegenerationsettings$builder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, MiscOverworldPlacements.SPRING_WATER);
        BiomeDefaultFeatures.addSurfaceFreezing(biomegenerationsettings$builder);
        BiomeDefaultFeatures.desertSpawns(mobspawnsettings$builder);
        addVillagerPillarRuinsDesert(biomegenerationsettings$builder);
        addDeadRuinsFlower(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultFlowers(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultGrass(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDesertVegetation(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDesertExtraVegetation(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDesertExtraDecoration(biomegenerationsettings$builder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(temperature)
                .downfall(downfall)
                .specialEffects(
                        new BiomeSpecialEffects.Builder()
                                .waterColor(4159204)
                                .waterFogColor(329011)
                                .fogColor(12638463)
                                .skyColor(calculateSkyColor(temperature))
                                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DESERT))
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

    public static void addBushAndStoneFeature(BiomeGenerationSettings.Builder pBuilder)
    {
        pBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModMiscOverworldPlacements.BUSH_AND_STONE);
    }

    public static void addRuinsFlowers(BiomeGenerationSettings.Builder pBuilder)
    {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.PATCH_RUINS_FLOWER);
    }

    public static void addCivilizationsFlowers(BiomeGenerationSettings.Builder pBuilder)
    {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.PATCH_CIVILIZATIONS_FLOWER);
    }

    public static void addHouseFoundationRuins(BiomeGenerationSettings.Builder pBuilder)
    {
        pBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModMiscOverworldPlacements.HOUSE_FOUNDATION_RUINS);
    }

    public static void addVillagerPillarRuinsDesert(BiomeGenerationSettings.Builder pBuilder)
    {
        pBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModMiscOverworldPlacements.VILLAGER_PILLAR_RUINS_DESERT);
    }

    public static void addDeadRuinsFlower(BiomeGenerationSettings.Builder pBuilder)
    {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.PATCH_DEAD_RUINS_FLOWER);
    }
}
