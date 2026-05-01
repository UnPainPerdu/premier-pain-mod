package com.unpainperdu.premierpainmod.util.register.entity.villager;

import com.google.common.collect.ImmutableSet;
import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class VillagerProfessionRegister
{
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, PremierPainMod.MOD_ID);

    public static final DeferredHolder<VillagerProfession, VillagerProfession> BREWER = VILLAGER_PROFESSIONS.register("brewer",
            () -> new VillagerProfession("brewer",
                    poiTypeHolder -> poiTypeHolder.value().equals(VillagerPointOfInterestRegister.BREWER.value()),
                    poiTypeHolder -> poiTypeHolder.value().equals(VillagerPointOfInterestRegister.BREWER.value()),
                    ImmutableSet.of(),
                    ImmutableSet.of(),
                    SoundEvents.BREWING_STAND_BREW
            )
    );

    public static void register(IEventBus modEventBus)
    {
        VILLAGER_PROFESSIONS.register(modEventBus);
    }
}