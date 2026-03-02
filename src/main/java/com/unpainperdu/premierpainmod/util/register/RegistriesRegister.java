package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.level.world.event.item_event.ItemEvent;
import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegistryBuilder;

public class RegistriesRegister
{
    public static final ResourceKey<Registry<ItemEvent>> ITEM_EVENT_REGISTRY_KEY = ResourceKey.createRegistryKey(ResourceUtil.createResourceLocation("item_event"));
    public static final Registry<ItemEvent> ITEM_EVENT_REGISTRY = new RegistryBuilder<>(ITEM_EVENT_REGISTRY_KEY)
            .defaultKey(ResourceUtil.createResourceLocation("empty"))
            .create();

    public static void registerRegistries(NewRegistryEvent event)
    {
        event.register(ITEM_EVENT_REGISTRY);
    }
}
