package com.unpainperdu.premierpainmod.util.register.creativeTab;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreativeTabRegister
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PremierPainMod.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PREMIER_PAIN_MOD = CREATIVE_MODE_TABS.register("premier_pain_mod", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.premierpainmod"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> BlockRegister.VILLAGER_WORKSHOP.get().asItem().getDefaultInstance())
            .withSearchBar(75)
            .backgroundTexture(ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "textures/gui/creative_tab/main_tab.png"))
            .displayItems(CreativeMainTab::generateCreativeMainTab).build());

    public static void register(IEventBus modEventBus)
    {
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
