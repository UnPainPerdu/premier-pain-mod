package com.unpainperdu.premierpainmod.util.tool_kit;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;


public class DamageSourcesCreator
{
    private DamageSourcesCreator(){}

    public static DamageSource create (ResourceKey<DamageType> damageType, Level level)
    {
        return create(damageType,level, null);
    }
    public static DamageSource create(ResourceKey<DamageType> damageType, Level level, Entity entity)
    {

        return new DamageSource(
                level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(damageType),
                entity,
                entity,
                null
        );
    }
}
