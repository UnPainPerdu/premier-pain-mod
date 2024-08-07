package com.unpainperdu.premierpainmod.level.world.worldgen.biome;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerraBlender
{
    public static void registerBiomes()
    {
        Regions.register(new ModOverworldRegion(ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID,"overworld"),5));
    }
}
