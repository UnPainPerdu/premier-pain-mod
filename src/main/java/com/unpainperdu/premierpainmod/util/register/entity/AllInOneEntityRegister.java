package com.unpainperdu.premierpainmod.util.register.entity;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.SeatEntity;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.MountainCurrantGolemEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;

public class AllInOneEntityRegister
{
    private AllInOneEntityRegister()
    {
    }

    //always mob_name_egg
    public static final Map<String, DeferredItem<Item>> EGG_ITEM_MAP = new HashMap<>();

    //All entity must end with _entity
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, PremierPainMod.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<SeatEntity>> SEAT_ENTITY = registerEntity("seat_entity",
            EntityType.Builder.<SeatEntity>of(SeatEntity::new, MobCategory.MISC)
                    .setTrackingRange(256)
                    .setUpdateInterval(20)
                    .sized(0.0001F, 0.0001F));

    public static final DeferredHolder<EntityType<?>, EntityType<MountainCurrantGolemEntity>> MOUNTAIN_CURRANT_GOLEM_ENTITY = registerEntityWithEggs("mountain_currant_golem_entity",
            EntityType.Builder.of(MountainCurrantGolemEntity::new, MobCategory.CREATURE)
                    .sized(0.6F, 3.6F)
    );

    /**
     * It does not use vanilla egg template for texture
     */
    public static <T extends Mob> DeferredHolder<EntityType<?>, EntityType<T>> registerEntityWithEggs(String name, EntityType.Builder<T> entityBuilder)
    {
        String eggName = name.replace("_entity", "_egg");
        DeferredHolder<EntityType<?>, EntityType<T>> entity = EntityRegister.registerEntity(name, entityBuilder);
        EGG_ITEM_MAP.put(eggName, EggItemRegister.generateEgg(eggName, entity));
        return entity;
    }

    public static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> registerEntity(String name, EntityType.Builder<T> entityBuilder)
    {
        return EntityRegister.registerEntity(name, entityBuilder);
    }

    public static void register(IEventBus modEventBus)
    {
        ENTITY_TYPES.register(modEventBus);
    }
}
