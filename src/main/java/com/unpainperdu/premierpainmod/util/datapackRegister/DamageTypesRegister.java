package com.unpainperdu.premierpainmod.util.datapackRegister;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class DamageTypesRegister
{
    /*
    need to datagen too
    */
    public static final ResourceKey<DamageType> LIBERTY_DAMAGE1 = damageTypesRegister("liberty_damage1");
    public static final ResourceKey<DamageType> LIBERTY_DAMAGE2 = damageTypesRegister("liberty_damage2");
    public static final ResourceKey<DamageType> LIBERTY_DAMAGE3 = damageTypesRegister("liberty_damage3");

    private static ResourceKey<DamageType> damageTypesRegister(String path)
    {
        return ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(PremierPainMod.MODID, path));
    }
}
