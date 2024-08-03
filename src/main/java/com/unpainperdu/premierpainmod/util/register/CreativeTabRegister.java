package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidthWithBlockEntity.villagerShelf.VillagerShelf;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreativeTabRegister
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PremierPainMod.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PREMIER_PAIN_MOD = CREATIVE_MODE_TABS.register("premier_pain_mod", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.premierpainmod"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ItemRegister.VILLAGER_ICON.get().getDefaultInstance())
            .displayItems((parameters, output) ->
            {
                //Blocks
                for(DeferredBlock<Block> defferedBlock : ModList.ALL_BLOCKS)
                {
                    creativeTabBlock(defferedBlock, output);
                }
                //Items
                for(DeferredItem<Item> defferedItem : ModList.ALL_ITEMS)
                {
                    creativeTabItems(defferedItem, output);
                }

            }).build());

    private static void creativeTabBlock(DeferredBlock<Block> deferredBlock, CreativeModeTab.Output output)
    {
        Block block = deferredBlock.get();
        if(!(block instanceof VillagerShelf))
        {
            output.accept(block);
        }
    }
    private static void creativeTabItems(DeferredItem<Item> deferredItem, CreativeModeTab.Output output)
    {
        Item item = deferredItem.get();
        if(!(item.getDescriptionId().equals("item.premierpainmod.villager_icon")))
        {
            output.accept(item);
        }
    }
    public static void register(IEventBus modEventBus)
    {
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
