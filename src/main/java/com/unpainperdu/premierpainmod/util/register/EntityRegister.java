package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.entity.blockEntity.SeatEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EntityRegister
{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, PremierPainMod.MOD_ID);

    public static final DeferredHolder<EntityType<?>,EntityType<SeatEntity>> SEAT_ENTITY = ENTITY_TYPES.register("seat_entity",() -> EntityType.Builder.<SeatEntity>of(SeatEntity::new, MobCategory.MISC).setTrackingRange(256)
            .setUpdateInterval(20)
            .sized(0.0001F, 0.0001F)
            .build(PremierPainMod.MOD_ID + ":seat_entity"));

    public static void register(IEventBus modEventBus)
    {
        ENTITY_TYPES.register(modEventBus);
    }
}
