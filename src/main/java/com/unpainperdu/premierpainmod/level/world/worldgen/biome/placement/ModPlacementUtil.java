package com.unpainperdu.premierpainmod.level.world.worldgen.biome.placement;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacementUtil
{
    public static void bootstrap(BootstrapContext<PlacedFeature> context)
    {
        ModMiscOverworldPlacements.bootstrap(context);
        ModVegetationPlacement.bootstrap(context);
    }

    public static ResourceKey<PlacedFeature> createKey(String name)
    {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, name));
    }
}
