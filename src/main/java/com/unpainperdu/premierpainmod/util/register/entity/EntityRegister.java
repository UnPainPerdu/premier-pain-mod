package com.unpainperdu.premierpainmod.util.register.entity;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.registries.DeferredHolder;

import static com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister.ENTITY_TYPES;

public class EntityRegister
{
    private EntityRegister()
    {
    }

    public static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> registerEntity(String name, EntityType.Builder<T> entityBuilder)
    {
        return ENTITY_TYPES.register(name, () -> entityBuilder.build(PremierPainMod.MOD_ID + ":" + name));
    }
}
