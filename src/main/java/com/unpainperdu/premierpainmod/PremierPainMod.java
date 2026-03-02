package com.unpainperdu.premierpainmod;

import com.unpainperdu.premierpainmod.datagen.DataGatherer;
import com.unpainperdu.premierpainmod.event.FMLCommonSetup;
import com.unpainperdu.premierpainmod.event.entity.EntityAttributes;
import com.unpainperdu.premierpainmod.event.entity.EntityLayers;
import com.unpainperdu.premierpainmod.event.entity.RegisterSpawnPlacements;
import com.unpainperdu.premierpainmod.util.register.RegisterHandler;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(PremierPainMod.MOD_ID)
public class PremierPainMod
{
    public static final String MOD_ID = "premierpainmod";

    public PremierPainMod(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(DataGatherer::dataGatherer);
        modEventBus.addListener(FMLCommonSetup::commonSetup);
        modEventBus.addListener(EntityAttributes::registerEntityAttributes);
        modEventBus.addListener(EntityLayers::registerEntityLayers);
        modEventBus.addListener(RegisterSpawnPlacements::registerSpawnPlacement);
        RegisterHandler.globalRegister(modEventBus);
    }
}