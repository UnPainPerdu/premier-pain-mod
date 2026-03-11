package com.unpainperdu.premierpainmod.util.register.entity;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.FloweredLizardEntity;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.MountainCurrantGolemEntity;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.WoolGolemEntity;
import com.unpainperdu.premierpainmod.level.world.entity.projectile.egg.FloweredLizardThrownEgg;
import com.unpainperdu.premierpainmod.level.world.entity.seat.SeatEntity;
import com.unpainperdu.premierpainmod.level.world.entity.seat.ToiletSeatEntity;
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

    //always mob_name_spawn_egg
    public static final Map<String, DeferredItem<Item>> EGG_ITEM_MAP = new HashMap<>();

    private static final String EGG_SUFFIX = "_spawn_egg";

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, PremierPainMod.MOD_ID);

    //utility
    public static final DeferredHolder<EntityType<?>, EntityType<SeatEntity>> SEAT_ENTITY = registerEntity("seat",
            EntityType.Builder.<SeatEntity>of(SeatEntity::new, MobCategory.MISC)
                    .setTrackingRange(256)
                    .setUpdateInterval(20)
                    .sized(0.0001F, 0.0001F));

    public static final DeferredHolder<EntityType<?>, EntityType<SeatEntity>> TOILET_SEAT_ENTITY = registerEntity("toilet_seat",
            EntityType.Builder.<SeatEntity>of(ToiletSeatEntity::new, MobCategory.MISC)
                    .setTrackingRange(256)
                    .setUpdateInterval(20)
                    .sized(0.0001F, 0.0001F));
    //projectile
    public static final DeferredHolder<EntityType<?>, EntityType<FloweredLizardThrownEgg>> FLOWERED_LIZARD_THROWN_EGG = registerEntity("flowered_lizard_thrown_egg",
            EntityType.Builder.<FloweredLizardThrownEgg>of(FloweredLizardThrownEgg::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(4)
                    .updateInterval(10));
    //mob
    //  golem
    public static final DeferredHolder<EntityType<?>, EntityType<MountainCurrantGolemEntity>> MOUNTAIN_CURRANT_GOLEM_ENTITY = registerEntityWithEggs("mountain_currant_golem",
            EntityType.Builder.of(MountainCurrantGolemEntity::new, MobCategory.CREATURE)
                    .sized(0.6F, 3.6F)
    );

    public static final DeferredHolder<EntityType<?>, EntityType<WoolGolemEntity>> WOOL_GOLEM_ENTITY = registerEntityWithEggs("wool_golem",
            EntityType.Builder.of(WoolGolemEntity::new, MobCategory.CREATURE)
                    .sized(1.66F, 3.0F)
    );
    //  animal

    public static final DeferredHolder<EntityType<?>, EntityType<FloweredLizardEntity>> FLOWERED_LIZARD_ENTITY = registerEntityWithEggs("flowered_lizard",
            EntityType.Builder.of(FloweredLizardEntity::new, MobCategory.CREATURE)
                    .sized(1.2F, 1.8F)
    );

    /**
     * It does not use vanilla egg template for texture
     */
    public static <T extends Mob> DeferredHolder<EntityType<?>, EntityType<T>> registerEntityWithEggs(String name, EntityType.Builder<T> entityBuilder)
    {
        String eggName = name + EGG_SUFFIX;
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

    /**
     * @param registerdMob must have been register with registerEntityWithEggs
     */
    public static <T extends Mob> DeferredItem<Item> getEgg(DeferredHolder<EntityType<?>, EntityType<T>> registerdMob)
    {
        return EGG_ITEM_MAP.get(registerdMob.getId().getPath() + EGG_SUFFIX);
    }
}
