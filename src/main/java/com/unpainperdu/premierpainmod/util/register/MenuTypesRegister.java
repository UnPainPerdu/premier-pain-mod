package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.menu.villagerDrawerMenu.VillagerDrawerMenu;
import com.unpainperdu.premierpainmod.level.world.menu.villagerShelfMenu.VillagerShelfMenu;
import com.unpainperdu.premierpainmod.level.world.menu.villagerWorkshopMenu.VillagerWorkshopMenu;
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
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(BuiltInRegistries.MENU, PremierPainMod.MOD_ID);

    public static final DeferredHolder<MenuType<?>,MenuType<VillagerWorkshopMenu>> VILLAGER_WORKSHOP = register("villager_workshop", () -> new MenuType(VillagerWorkshopMenu::new, FeatureFlags.DEFAULT_FLAGS));
    public static final DeferredHolder<MenuType<?>,MenuType<VillagerDrawerMenu>> VILLAGER_DRAWER = register("villager_drawer", () -> new MenuType(VillagerDrawerMenu::VillagerDrawerMenu, FeatureFlags.DEFAULT_FLAGS));
    public static final DeferredHolder<MenuType<?>,MenuType<VillagerShelfMenu>> VILLAGER_SHELF = register("villager_shelf", () -> new MenuType(VillagerShelfMenu::VillagerShelfMenu, FeatureFlags.DEFAULT_FLAGS));

    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>,MenuType<T>> register(final String name, final Supplier<MenuType<T>> menu)
    {
        return MENUS.register(name, menu);
    }
    public static void register(IEventBus modEventBus)
    {
        MENUS.register(modEventBus);
    }
}
