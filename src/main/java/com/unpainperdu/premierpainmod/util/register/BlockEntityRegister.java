package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.entity.blockEntity.SeatEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockEntityRegister
{
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister. create(BuiltInRegistries. BLOCK_ENTITY_TYPE, PremierPainMod.MODID);

    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<SeatEntity>> SEAT_ENTITY = BLOCK_ENTITIES.register("seat_entity",() -> BlockEntityType.Builder.of(SeatEntity::new, BlockRegister.TEST_BLOCK.get()).build(null));

    public static void register(IEventBus modEventBus)
    {
        BLOCK_ENTITIES.register(modEventBus);
    }
}
