package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreativeTabRegister
{
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "premierpaindmod" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PremierPainMod.MODID);

    // Creates a creative tab with the id "premierpaindmod:premier_pain_mod" for the example item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PREMIER_PAIN_MOD = CREATIVE_MODE_TABS.register("premier_pain_mod", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.premierpainmod")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ItemRegister.VILLAGER_ICON.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                //Items
                //Blocks
                    //WorkShop
                for(DeferredBlock<Block> block : BlockList.ALL_BLOCKS)
                {
                    output.accept(block.get());
                }

            }).build());
    public static void register(IEventBus modEventBus)
    {
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
