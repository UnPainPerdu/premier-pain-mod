package com.unpainperdu.premierpainmod.util.register.entity;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.FloweredLizardEntity;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.MountainCurrantGolemEntity;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.WoolGolemEntity;
import com.unpainperdu.premierpainmod.level.world.entity.projectile.egg.FloweredLizardThrownEgg;
import com.unpainperdu.premierpainmod.level.world.entity.seat.SeatEntity;
import com.unpainperdu.premierpainmod.level.world.entity.seat.ToiletSeatEntity;
import com.unpainperdu.premierpainmod.level.world.item.items.DeferredSpawnEgg;
import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.unpainperdu.premierpainmod.util.register.Item.ItemRegister.ITEMS;

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
    //vehicule
    //  boat
    public static final DeferredHolder<EntityType<?>, EntityType<Boat>> MOUNTAIN_CURRANT_BOAT = registerEntity(
            "mountain_currant_boat",
            EntityType.Builder.of(boatFactory(() -> Items.OAK_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
    );

    public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> MOUNTAIN_CURRANT_CHEST_BOAT = registerEntity(
            "mountain_currant_chest_boat",
            EntityType.Builder.of(chestBoatFactory(() -> Items.OAK_CHEST_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<Boat>> MORICHE_PALM_BOAT = registerEntity(
            "moriche_palm_boat",
            EntityType.Builder.of(boatFactory(() -> Items.OAK_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
    );

    public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> MORICHE_PALM_CHEST_BOAT = registerEntity(
            "moriche_palm_chest_boat",
            EntityType.Builder.of(chestBoatFactory(() -> Items.OAK_CHEST_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<Boat>> ACHIOTE_BOAT = registerEntity(
            "achiote_boat",
            EntityType.Builder.of(boatFactory(() -> Items.OAK_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
    );

    public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> ACHIOTE_CHEST_BOAT = registerEntity(
            "achiote_chest_boat",
            EntityType.Builder.of(chestBoatFactory(() -> Items.OAK_CHEST_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<Boat>> WEEPING_WILLOW_BOAT = registerEntity(
            "weeping_willow_boat",
            EntityType.Builder.of(boatFactory(() -> Items.OAK_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
    );

    public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> WEEPING_WILLOW_CHEST_BOAT = registerEntity(
            "weeping_willow_chest_boat",
            EntityType.Builder.of(chestBoatFactory(() -> Items.OAK_CHEST_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375F, 0.5625F)
                    .eyeHeight(0.5625F)
                    .clientTrackingRange(10)
    );
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

    private static EntityType.EntityFactory<Boat> boatFactory(Supplier<Item> boatItemGetter)
    {
        return (boatEntityType, level) -> new Boat(boatEntityType, level, boatItemGetter);
    }

    private static EntityType.EntityFactory<ChestBoat> chestBoatFactory(Supplier<Item> boatItemGetter)
    {
        return (chestBoatEntityType, level) -> new ChestBoat(chestBoatEntityType, level, boatItemGetter);
    }

    public static <T extends Mob> DeferredHolder<EntityType<?>, EntityType<T>> registerEntityWithEggs(String name, EntityType.Builder<T> entityBuilder)
    {
        String eggName = name + EGG_SUFFIX;
        DeferredHolder<EntityType<?>, EntityType<T>> entity = registerEntity(name, entityBuilder);
        EGG_ITEM_MAP.put(eggName, registerEgg(eggName, entity));
        return entity;
    }

    public static <T extends Mob> DeferredItem<Item> registerEgg(String name, DeferredHolder<EntityType<?>, EntityType<T>> entity)
    {
        return ITEMS.registerItem(name, p -> new DeferredSpawnEgg<>(entity, p));
    }

    public static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> registerEntity(String name, EntityType.Builder<T> entityBuilder)
    {
        return ENTITY_TYPES.register(name, () -> entityBuilder.build(createResourceKey(name)));
    }

    private static ResourceKey<EntityType<?>> createResourceKey(String name)
    {
        return ResourceKey.create(Registries.ENTITY_TYPE, ResourceUtil.createResourceLocation(name));
    }
}