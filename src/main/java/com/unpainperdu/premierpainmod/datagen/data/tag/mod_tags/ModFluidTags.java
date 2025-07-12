package com.unpainperdu.premierpainmod.datagen.data.tag.mod_tags;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public class ModFluidTags
{
    public static final TagKey<Fluid> BEER = create("beer");
    public static final TagKey<Fluid> OIL = create("oil");

    private static TagKey<Fluid> create(String name)
    {
        return TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, name));
    }
}
