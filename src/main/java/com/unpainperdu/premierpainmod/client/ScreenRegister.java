package com.unpainperdu.premierpainmod.client;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.client.gui.screen.villagerWorkshopRecipeScreen.VillagerWorkshopRecipeScreen;
import com.unpainperdu.premierpainmod.client.gui.screen.VillagerDrawerScreen.VillagerDrawerScreen;
import com.unpainperdu.premierpainmod.util.register.MenuTypesRegister;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = PremierPainMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ScreenRegister
{
    // Event is listened to on the mod event bus
    @SubscribeEvent
    private static void registerScreens(RegisterMenuScreensEvent event)
    {
        event.register(MenuTypesRegister.VILLAGER_WORKSHOP.get(), VillagerWorkshopRecipeScreen::new);
        event.register(MenuTypesRegister.VILLAGER_DRAWER.get(), VillagerDrawerScreen::new);
    }
}
