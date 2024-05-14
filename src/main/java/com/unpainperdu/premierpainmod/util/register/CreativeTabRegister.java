package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreativeTabRegister
{
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PremierPainMod.MODID);

    // Creates a creative tab with the id "examplemod:example_tab" for the example item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("premier_pain_mod", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.premierpainmod")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ItemRegister.VILLAGER_ICON.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                //Items
                //Blocks
                output.accept(BlockRegister.OAK_VILLAGER_STATUE.get());
                output.accept(BlockRegister.BIRCH_VILLAGER_STATUE.get());
                output.accept(BlockRegister.SPRUCE_VILLAGER_STATUE.get());
                output.accept(BlockRegister.JUNGLE_VILLAGER_STATUE.get());
                output.accept(BlockRegister.ACACIA_VILLAGER_STATUE.get());
                output.accept(BlockRegister.DARK_OAK_VILLAGER_STATUE.get());
                output.accept(BlockRegister.MANGROVE_VILLAGER_STATUE.get());
                output.accept(BlockRegister.CHERRY_VILLAGER_STATUE.get());
                output.accept(BlockRegister.CRIMSON_VILLAGER_STATUE.get());
                output.accept(BlockRegister.WARPED_VILLAGER_STATUE.get());
                output.accept(BlockRegister.BAMBOO_VILLAGER_STATUE.get());
                output.accept(BlockRegister.STONE_VILLAGER_STATUE.get());
            }).build());
    public static void register(IEventBus modEventBus)
    {
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
