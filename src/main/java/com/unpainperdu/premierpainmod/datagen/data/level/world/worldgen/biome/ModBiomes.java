package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome.overworld.ModOverWorldUndergroundBiomes;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome.overworld.ModOverworldSurfaceBiomes;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.feature.placement.ModMiscOverworldPlacements;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.feature.placement.ModVegetationPlacement;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

import java.util.List;

public class ModBiomes
{


    public static ResourceKey<Biome> createKey(String path)
    {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, path));
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
