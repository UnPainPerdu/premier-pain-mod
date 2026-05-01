package com.unpainperdu.premierpainmod.util.tool_kit;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

public class DamageSourcesCreator
{
    public static DamageSource create(ResourceKey<DamageType> damageType, Level level)
    {
        return create(damageType, level, null);
    }

    public static DamageSource create(ResourceKey<DamageType> damageType, Level level, Entity entity)
    {

        return new DamageSource(
                level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(damageType),
                entity,
                entity,
                null
        );
    }
}