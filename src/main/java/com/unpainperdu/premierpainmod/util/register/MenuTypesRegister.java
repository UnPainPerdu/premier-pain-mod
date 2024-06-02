package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.menu.villagerWorkshopMenu.TestMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MenuTypesRegister
{
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(BuiltInRegistries.MENU, PremierPainMod.MODID);

    public static final DeferredHolder<MenuType<?>,MenuType<TestMenu>> VILLAGER_WORKSHOP = register("villager_workshop", () -> new MenuType(TestMenu::new, FeatureFlags.DEFAULT_FLAGS));


    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>,MenuType<T>> register(final String name, final Supplier<MenuType<T>> menu)
    {
        return MENUS.register(name, menu);
    }
    public static void register(IEventBus modEventBus)
    {
        MENUS.register(modEventBus);
    }
}
