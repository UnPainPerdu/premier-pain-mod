package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome.overworld.ModOverWorldUndergroundBiomes;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome.overworld.ModOverworldSurfaceBiomes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModBiomes
{

    public static final List<ResourceKey<Biome>> OVERWORLD_BIOMES = new ArrayList<>();

    @SafeVarargs
    public static ResourceKey<Biome> createKey(String path, List<ResourceKey<Biome>>... biomeListToAdd)
    {
        ResourceKey<Biome> ressource = ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, path));
        Arrays.stream(biomeListToAdd).forEach(list -> list.add(ressource));
        return ressource;
    }

    public static void boostrap(BootstrapContext<Biome> context)
    {
        ModOverworldSurfaceBiomes.boostrap(context);
        ModOverWorldUndergroundBiomes.boostrap(context);
    }

    public static int calculateSkyColor(float pTemperature)
    {
        float $$1 = pTemperature / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder pGenerationSettings)
    {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(pGenerationSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(pGenerationSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(pGenerationSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(pGenerationSettings);
        BiomeDefaultFeatures.addDefaultSprings(pGenerationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(pGenerationSettings);
    }
}
