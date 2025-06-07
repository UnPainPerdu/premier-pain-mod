package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.level.world.worldgen.biome.ModTerraBlender;
import com.unpainperdu.premierpainmod.util.register.block.BlockEntityRegister;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.codec.CodecForGLMRegister;
import com.unpainperdu.premierpainmod.util.register.creative_tab.CreativeTabRegister;
import com.unpainperdu.premierpainmod.util.register.fluid.FluidRegister;
import com.unpainperdu.premierpainmod.util.register.fluid.FluidTypeRegister;
import com.unpainperdu.premierpainmod.util.register.recipe.RecipeTypeRegister;
import com.unpainperdu.premierpainmod.util.register.tree.FoliagePlacerTypesRegister;
import com.unpainperdu.premierpainmod.util.register.tree.TrunkPlacerTypesRegister;
import net.neoforged.bus.api.IEventBus;

public class RegisterHandler
{
    private RegisterHandler()
    {
    }

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
        FeatureRegister.register(modEventBus);
        StructureRegister.register(modEventBus);
        TrunkPlacerTypesRegister.register(modEventBus);
        FoliagePlacerTypesRegister.register(modEventBus);
        FluidRegister.register(modEventBus);
        FluidTypeRegister.register(modEventBus);
        ParticleTypeRegister.register(modEventBus);
    }
}
