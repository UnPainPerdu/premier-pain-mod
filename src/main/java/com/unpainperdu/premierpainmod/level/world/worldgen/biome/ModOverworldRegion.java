package com.unpainperdu.premierpainmod.level.world.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class ModOverworldRegion extends Region
{
    protected final Climate.Parameter mushroomFields = Climate.Parameter.span(-1.2F, -1.05F);
    protected final Climate.Parameter deepOcean = Climate.Parameter.span(-1.05F, -0.455F);
    protected final Climate.Parameter ocean = Climate.Parameter.span(-0.455F, -0.19F);
    protected final Climate.Parameter coast = Climate.Parameter.span(-0.19F, -0.11F);
    protected final Climate.Parameter inland = Climate.Parameter.span(-0.11F, 0.55F);
    protected final Climate.Parameter nearInland = Climate.Parameter.span(-0.11F, 0.03F);
    protected final Climate.Parameter midInland = Climate.Parameter.span(0.03F, 0.3F);
    protected final Climate.Parameter farInland = Climate.Parameter.span(0.3F, 1.0F);

    public ModOverworldRegion(ResourceLocation name, int weight)
    {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper)
    {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
        // Overlap Vanilla's parameters with our own for our PREMIER_PAIN_RUINS biome.
        // The parameters for this biome are chosen arbitrarily.
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.NEUTRAL, ParameterUtils.Temperature.HOT))
                .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.HUMID))
                .continentalness(Climate.Parameter.span(midInland, farInland))
                .erosion(ParameterUtils.Erosion.EROSION_1)
                .depth(ParameterUtils.Depth.SURFACE)
                .weirdness(ParameterUtils.Weirdness.MID_SLICE_NORMAL_ASCENDING, ParameterUtils.Weirdness.MID_SLICE_NORMAL_DESCENDING)
                .build().forEach(point -> builder.add(point, ModBiomes.FOREST_PREMIER_PAIN_RUINS));

        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.NEUTRAL, ParameterUtils.Temperature.HOT))
                .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.HUMID))
                .continentalness(Climate.Parameter.span(midInland, farInland))
                .erosion(ParameterUtils.Erosion.EROSION_1)
                .depth(ParameterUtils.Depth.SURFACE)
                .weirdness(ParameterUtils.Weirdness.MID_SLICE_NORMAL_ASCENDING, ParameterUtils.Weirdness.MID_SLICE_NORMAL_DESCENDING)
                .build().forEach(point -> builder.add(point, ModBiomes.GREAT_OLD_FIELD));

        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.HOT)
                .humidity(ParameterUtils.Humidity.ARID)
                .continentalness(Climate.Parameter.span(midInland, farInland))
                .erosion(ParameterUtils.Erosion.EROSION_1)
                .depth(ParameterUtils.Depth.SURFACE)
                .weirdness(ParameterUtils.Weirdness.MID_SLICE_NORMAL_ASCENDING, ParameterUtils.Weirdness.MID_SLICE_NORMAL_DESCENDING)
                .build().forEach(point -> builder.add(point, ModBiomes.SAND_DESERT_PREMIER_PAIN_RUINS));

        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.NEUTRAL, ParameterUtils.Temperature.WARM))
                .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.HUMID))
                .continentalness(Climate.Parameter.span(midInland, farInland))
                .erosion(ParameterUtils.Erosion.EROSION_6)
                .depth(ParameterUtils.Depth.SURFACE)
                .weirdness(ParameterUtils.Weirdness.MID_SLICE_NORMAL_ASCENDING, ParameterUtils.Weirdness.MID_SLICE_NORMAL_DESCENDING)
                .build().forEach(point -> builder.add(point, ModBiomes.SWAMP_PREMIER_PAIN_RUINS));

        builder.build().forEach(mapper);
    }
}
