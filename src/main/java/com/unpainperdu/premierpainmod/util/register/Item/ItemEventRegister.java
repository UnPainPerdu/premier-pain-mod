package com.unpainperdu.premierpainmod.util.register.Item;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.event.item_event.ItemEvent;
import com.unpainperdu.premierpainmod.level.world.event.item_event.villager_singing_stone_event.DiggyEvent;
import com.unpainperdu.premierpainmod.level.world.event.item_event.villager_singing_stone_event.LibertyEvent;
import com.unpainperdu.premierpainmod.level.world.event.item_event.villager_singing_stone_event.MadnessEvent;
import com.unpainperdu.premierpainmod.level.world.event.item_event.villager_singing_stone_event.PremierPainEvent;
import com.unpainperdu.premierpainmod.util.register.RegistriesRegister;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemEventRegister
{
    public static final DeferredRegister<ItemEvent> ITEM_EVENT = DeferredRegister.create(RegistriesRegister.ITEM_EVENT_REGISTRY, PremierPainMod.MOD_ID);

    public static final DeferredHolder<ItemEvent, ItemEvent> LIBERTY = ITEM_EVENT.register("liberty", LibertyEvent::new);
    public static final DeferredHolder<ItemEvent, ItemEvent> DIGGY = ITEM_EVENT.register("diggy", DiggyEvent::new);
    public static final DeferredHolder<ItemEvent, ItemEvent> MADNESS = ITEM_EVENT.register("madness", MadnessEvent::new);
    public static final DeferredHolder<ItemEvent, ItemEvent> PREMIERPAIN = ITEM_EVENT.register("premierpain", PremierPainEvent::new);

    public static void register(IEventBus modEventBus)
    {
        ITEM_EVENT.register(modEventBus);
    }
}
