package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.client.ScreenRegister;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForge;

public class RegisterHandler
{
    public static void globalRegister(IEventBus modEventBus)
    {
        // Register the Deferred Register to the mod event bus so blocks get registered
        BlockRegister.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ItemRegister.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CreativeTabRegister.register(modEventBus);
        RecipeTypeRegister.register(modEventBus);
        MenuTypesRegister.register(modEventBus);
    }
}
