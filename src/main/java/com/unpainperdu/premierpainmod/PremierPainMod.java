package com.unpainperdu.premierpainmod;

import com.unpainperdu.premierpainmod.datagen.DataGatherer;
import com.unpainperdu.premierpainmod.util.register.RegisterHandler;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(PremierPainMod.MOD_ID)
public class PremierPainMod
{
    public static final String MOD_ID = "premierpainmod";
    private static final Logger LOGGER = LogUtils.getLogger();
    public PremierPainMod(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(DataGatherer::dataGatherer);
        RegisterHandler.globalRegister(modEventBus);
    }
}