package com.unpainperdu.premierpainmod.util.register;

import net.neoforged.bus.api.IEventBus;

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
    }
}
