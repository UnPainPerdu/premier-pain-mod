package com.unpainperdu.premierpainmod.datagen.data.level.world;

import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DeathMessageType;

public class ModDamageType
{
    public static final ResourceKey<DamageType> LIBERTY_DAMAGE1 = damageTypesRegister("liberty_damage1");
    public static final ResourceKey<DamageType> LIBERTY_DAMAGE2 = damageTypesRegister("liberty_damage2");
    public static final ResourceKey<DamageType> LIBERTY_DAMAGE3 = damageTypesRegister("liberty_damage3");

    private static ResourceKey<DamageType> damageTypesRegister(String path)
    {
        return ResourceKey.create(Registries.DAMAGE_TYPE, ResourceUtil.createResourceLocation(path));
    }

    public static void boostrap(BootstrapContext<DamageType> context)
    {
        context.register(ModDamageType.LIBERTY_DAMAGE1, new DamageType(ModDamageType.LIBERTY_DAMAGE1.location().toString(),
                DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER,
                0.1f,
                DamageEffects.HURT,
                DeathMessageType.DEFAULT));
        context.register(ModDamageType.LIBERTY_DAMAGE2, new DamageType(ModDamageType.LIBERTY_DAMAGE2.location().toString(),
                DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER,
                0.1f,
                DamageEffects.HURT,
                DeathMessageType.DEFAULT));
        context.register(ModDamageType.LIBERTY_DAMAGE3, new DamageType(ModDamageType.LIBERTY_DAMAGE3.location().toString(),
                DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER,
                0.1f,
                DamageEffects.HURT,
                DeathMessageType.DEFAULT));
    }
}
