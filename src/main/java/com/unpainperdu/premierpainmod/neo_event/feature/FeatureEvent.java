package com.unpainperdu.premierpainmod.neo_event.feature;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockGrowFeatureEvent;

@EventBusSubscriber(modid = PremierPainMod.MOD_ID)
public class FeatureEvent
{
    private FeatureEvent()
    {
    }

    @SubscribeEvent
    public static void blockGrowFeatureEvent(BlockGrowFeatureEvent event)
    {
        VanillaOakReplacer.event(event);
        VanillaBirchReplacer.event(event);
    }
}
