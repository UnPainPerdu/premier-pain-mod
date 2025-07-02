package com.unpainperdu.premierpainmod.client.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.client.gui.screen.*;
import com.unpainperdu.premierpainmod.util.register.MenuTypesRegister;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = PremierPainMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ScreenRegister
{
    @SubscribeEvent
    private static void registerScreens(RegisterMenuScreensEvent event)
    {
        event.register(MenuTypesRegister.VILLAGER_WORKSHOP.get(), VillagerWorkshopRecipeScreen::new);
        event.register(MenuTypesRegister.VILLAGER_DRAWER.get(), VillagerDrawerScreen::new);
        event.register(MenuTypesRegister.VILLAGER_SHELF.get(), VillagerShelfScreen::new);
        event.register(MenuTypesRegister.VILLAGER_BREWING_STATION.get(), VillagerBrewingStationScreen::new);
        event.register(MenuTypesRegister.VILLAGER_MUSICAL_FRIDGE.get(), VillagerMusicalFridgeScreen::new);
        event.register(MenuTypesRegister.COOKING_POT_BLOCK.get(), CookingPotScreen::new);
    }
}
