package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.level.world.worldgen.biome.ModTerraBlender;
import com.unpainperdu.premierpainmod.util.register.codec.CodecForGLMRegister;
import com.unpainperdu.premierpainmod.util.register.recipe.RecipeTypeRegister;
import net.neoforged.bus.api.IEventBus;

public class RegisterHandler
{
    public static void globalRegister(IEventBus modEventBus)
    {
        BlockRegister.register(modEventBus);
        BlockEntityRegister.register(modEventBus);
        EntityRegister.register(modEventBus);
        ItemRegister.register(modEventBus);
        CreativeTabRegister.register(modEventBus);
        RecipeTypeRegister.register(modEventBus);
        MenuTypesRegister.register(modEventBus);
        SoundEventRegister.register(modEventBus);
        CodecForGLMRegister.register(modEventBus);
        ModTerraBlender.registerBiomes();
    }
}
