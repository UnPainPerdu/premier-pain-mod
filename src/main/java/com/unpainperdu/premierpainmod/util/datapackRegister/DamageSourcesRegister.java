package com.unpainperdu.premierpainmod.util.datapackRegister;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;


public class DamageSourcesRegister
{
    public static DamageSource damageSourcesCreator (ResourceKey<DamageType> damageType, Level level)
    {

        return damageSourcesCreator(damageType,level, null);
    }
    public static DamageSource damageSourcesCreator (ResourceKey<DamageType> damageType, Level level, Entity pEntity)
    {

        return new DamageSource(
                level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(damageType),
                pEntity,
                pEntity,
                null
        );
    }
}
