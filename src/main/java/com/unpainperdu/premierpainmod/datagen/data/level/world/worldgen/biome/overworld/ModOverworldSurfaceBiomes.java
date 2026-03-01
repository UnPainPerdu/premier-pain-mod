package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome.overworld;

import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.feature.placement.ModMiscOverworldPlacements;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.feature.placement.ModVegetationPlacement;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

import java.util.ArrayList;
import java.util.List;

import static com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome.ModBiomes.*;

public class ModOverworldSurfaceBiomes
{
    public static final List<ResourceKey<Biome>> OVERWORLD_SURFACE_BIOMES = new ArrayList<>();

    public static final ResourceKey<Biome> FOREST_PREMIER_PAIN_RUINS = createKey("forest_premier_pain_ruins", OVERWORLD_BIOMES, OVERWORLD_SURFACE_BIOMES);
    public static final ResourceKey<Biome> SAND_DESERT_PREMIER_PAIN_RUINS = createKey("sand_desert_premier_pain_ruins", OVERWORLD_BIOMES, OVERWORLD_SURFACE_BIOMES);
    public static final ResourceKey<Biome> SWAMP_PREMIER_PAIN_RUINS = createKey("swamp_premier_pain_ruins", OVERWORLD_BIOMES, OVERWORLD_SURFACE_BIOMES);
    public static final ResourceKey<Biome> OLD_GREAT_FIELD = createKey("old_great_field", OVERWORLD_BIOMES, OVERWORLD_SURFACE_BIOMES);
    public static final ResourceKey<Biome> JUNGLE_PREMIER_PAIN_RUINS = createKey("jungle_premier_pain_ruins", OVERWORLD_BIOMES, OVERWORLD_SURFACE_BIOMES);


    public static void boostrap(BootstrapContext<Biome> context)
    {
        context.register(FOREST_PREMIER_PAIN_RUINS, forestPremierPainRuins(context));
        context.register(SAND_DESERT_PREMIER_PAIN_RUINS, sandDesertPremierPainRuins(context));
        context.register(SWAMP_PREMIER_PAIN_RUINS, swampPremierPainRuins(context));
        context.register(OLD_GREAT_FIELD, greatOldField(context));
        context.register(JUNGLE_PREMIER_PAIN_RUINS, junglePremierPainRuins(context));
    }

    private static Biome forestPremierPainRuins(BootstrapContext<Biome> context)
    {
        float temperature = 0.8F;
        float downfall = 0.4f;

        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder featureBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        //must be in vanilla order
        BiomeDefaultFeatures.addDefaultCarversAndLakes(featureBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(featureBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(featureBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(featureBuilder);
        featureBuilder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, MiscOverworldPlacements.SPRING_WATER);
        BiomeDefaultFeatures.addSurfaceFreezing(featureBuilder);
        BiomeDefaultFeatures.plainsSpawns(mobBuilder);
        featureBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModMiscOverworldPlacements.FOREST_VILLAGER_STATUE_RUINS);
        addHouseFoundationRuins(featureBuilder);
        featureBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModMiscOverworldPlacements.BUSH_AND_ROCK);
        addRuinsFlowers(featureBuilder);
        addCivilizationsFlowers(featureBuilder);
        BiomeDefaultFeatures.addPlainGrass(featureBuilder);
        BiomeDefaultFeatures.addDefaultOres(featureBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(featureBuilder);
        BiomeDefaultFeatures.addPlainVegetation(featureBuilder);
        featureBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_BIRCH_AND_OAK);
        featureBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.OAK_1);
        featureBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.BIRCH_1);
        BiomeDefaultFeatures.addDefaultMushrooms(featureBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(featureBuilder);

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
                                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST))
                                .build()
                )
                .mobSpawnSettings(mobBuilder.build())
                .generationSettings(featureBuilder.build())
                .build();
    }

    private static Biome swampPremierPainRuins(BootstrapContext<Biome> context)
    {
        float temperature = 0.8F;
        float downfall = 0.9f;
        //must be in vanilla order

        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder featureBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        //mob spawn
        BiomeDefaultFeatures.commonSpawns(mobBuilder, 70);
        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1))
        .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.BOGGED, 30, 4, 4))
        .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FROG, 25, 2, 5))
        .addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 25, 8, 8))
        .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(AllInOneEntityRegister.FLOWERED_LIZARD_ENTITY.get(), 20, 1, 3));

        //block spawn
        BiomeDefaultFeatures.addFossilDecoration(featureBuilder);
        globalOverworldGeneration(featureBuilder);
        BiomeDefaultFeatures.addDefaultOres(featureBuilder);
        BiomeDefaultFeatures.addMangroveSwampDisks(featureBuilder);
        featureBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModMiscOverworldPlacements.MUD_PACK);
        featureBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModMiscOverworldPlacements.SWAMP_MANGROVE_OUTSIDE_DRY_TOILET);
        featureBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModMiscOverworldPlacements.SWAMP_WEEPING_WILLOW_OUTSIDE_DRY_TOILET);
        featureBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.WEEPING_WILLOW);
        featureBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.TREE_OAK_SWAMP);
        featureBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.TREE_MANGROVE);
        featureBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.PATCH_CURIOSITY_FLOWER);
        featureBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.PATCH_SKY_SPEARS);
        featureBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_NORMAL);
        featureBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
        featureBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_WATERLILY);
        featureBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(temperature)
                .downfall(downfall)
                .specialEffects(
                        new BiomeSpecialEffects.Builder()
                                .waterColor(3832426)
                                .waterFogColor(5077600)
                                .fogColor(12638463)
                                .skyColor(calculateSkyColor(temperature))
                                .foliageColorOverride(9285927)
                                .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.SWAMP)
                                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SWAMP))
                                .build()
                )
                .mobSpawnSettings(mobBuilder.build())
                .generationSettings(featureBuilder.build())
                .build();
    }

    private static Biome sandDesertPremierPainRuins(BootstrapContext<Biome> context)
    {
        float temperature = 2.0F;
        float downfall = 0.0f;

        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder featureBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addDefaultCarversAndLakes(featureBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(featureBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(featureBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(featureBuilder);
        featureBuilder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, MiscOverworldPlacements.SPRING_WATER);
        BiomeDefaultFeatures.addSurfaceFreezing(featureBuilder);
        BiomeDefaultFeatures.desertSpawns(mobBuilder);
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CAMEL, 1, 1, 3));
        featureBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModMiscOverworldPlacements.VILLAGER_PILLAR_RUINS_DESERT);
        featureBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.PATCH_DEAD_RUINS_FLOWER);
        featureBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.FLOWERED_CACTUS);
        featureBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.PATCH_DEAD_TALL_BUSH);
        BiomeDefaultFeatures.addDefaultOres(featureBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(featureBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(featureBuilder);
        BiomeDefaultFeatures.addDefaultGrass(featureBuilder);
        BiomeDefaultFeatures.addDesertVegetation(featureBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(featureBuilder);
        BiomeDefaultFeatures.addDesertExtraVegetation(featureBuilder);
        BiomeDefaultFeatures.addDesertExtraDecoration(featureBuilder);

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
                .mobSpawnSettings(mobBuilder.build())
                .generationSettings(featureBuilder.build())
                .build();
    }

    private static Biome greatOldField(BootstrapContext<Biome> context)
    {
        float temperature = 0.8F;
        float downfall = 0.4f;

        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder featureBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalOverworldGeneration(featureBuilder);
        BiomeDefaultFeatures.plainsSpawns(mobBuilder);
        featureBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.MOUNTAIN_CURRANT);
        featureBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.PATCH_OLD_WILD_WHEAT);
        BiomeDefaultFeatures.addPlainGrass(featureBuilder);
        BiomeDefaultFeatures.addDefaultOres(featureBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(featureBuilder);
        BiomeDefaultFeatures.addPlainVegetation(featureBuilder);

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
                                .foliageColorOverride(0xA6DD21)
                                .grassColorOverride(0xA6DD21)
                                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST))
                                .build()
                )
                .mobSpawnSettings(mobBuilder.build())
                .generationSettings(featureBuilder.build())
                .build();
    }

    private static Biome junglePremierPainRuins(BootstrapContext<Biome> context)
    {
        float temperature = 0.95F;
        float downfall = 0.9F;

        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder featureBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.baseJungleSpawns(mobBuilder);
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 5, 1, 2))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 8, 1, 3))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(AllInOneEntityRegister.FLOWERED_LIZARD_ENTITY.get(), 10, 1, 3));
        featureBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModMiscOverworldPlacements.VILLAGER_TOTEM);
        BiomeDefaultFeatures.addDefaultCarversAndLakes(featureBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(featureBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(featureBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(featureBuilder);
        featureBuilder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, MiscOverworldPlacements.SPRING_WATER);
        BiomeDefaultFeatures.addSurfaceFreezing(featureBuilder);
        BiomeDefaultFeatures.addDefaultOres(featureBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(featureBuilder);
        featureBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.MORICHE_PALM);
        featureBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.ACHIOTE);
        featureBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.PATCH_FALLING_HELICON_FLOWER);
        BiomeDefaultFeatures.addWarmFlowers(featureBuilder);
        BiomeDefaultFeatures.addJungleGrass(featureBuilder);
        BiomeDefaultFeatures.addJungleMelons(featureBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(temperature)
                .downfall(downfall)
                .specialEffects(
                        new BiomeSpecialEffects.Builder()
                                .waterColor(0x3F76E4)
                                .waterFogColor(329011)
                                .fogColor(12638463)
                                .skyColor(calculateSkyColor(temperature))
                                .foliageColorOverride(0x30BB0B)
                                .grassColorOverride(0x59C93C)
                                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE))
                                .build()
                )
                .mobSpawnSettings(mobBuilder.build())
                .generationSettings(featureBuilder.build())
                .build();
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
}
