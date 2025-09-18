package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.level.world.worldgen.biome.ModTerraBlender;
import com.unpainperdu.premierpainmod.util.register.ai.MemoryModuleTypeRegister;
import com.unpainperdu.premierpainmod.util.register.ai.SensorsTypeRegister;
import com.unpainperdu.premierpainmod.util.register.block.BlockEntityRegister;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.codec.CodecForGLMRegister;
import com.unpainperdu.premierpainmod.util.register.creative_tab.CreativeTabRegister;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import com.unpainperdu.premierpainmod.util.register.entity.EntityRegister;
import com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister;
import com.unpainperdu.premierpainmod.util.register.recipe.RecipeTypeRegister;
import com.unpainperdu.premierpainmod.util.register.tree.FoliagePlacerTypesRegister;
import com.unpainperdu.premierpainmod.util.register.tree.TreeDecoratorTypeRegister;
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
        AllInOneEntityRegister.register(modEventBus);
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
        TreeDecoratorTypeRegister.register(modEventBus);
        AllInOneFluidRegister.register(modEventBus);
        ParticleTypeRegister.register(modEventBus);
        MemoryModuleTypeRegister.register(modEventBus);
        SensorsTypeRegister.register(modEventBus);
        CriterionRegister.register(modEventBus);
    }
}
