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
                    //WorkShopZone
                output.accept(BlockRegister.VILLAGER_WORKSHOP.get());
                    //statue
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
                output.accept(BlockRegister.MOSSY_STONE_VILLAGER_STATUE.get());
                output.accept(BlockRegister.ANDESITE_VILLAGER_STATUE.get());
                output.accept(BlockRegister.DIORITE_VILLAGER_STATUE.get());
                output.accept(BlockRegister.GRANITE_VILLAGER_STATUE.get());
                output.accept(BlockRegister.PRISMARINE_VILLAGER_STATUE.get());
                output.accept(BlockRegister.BLACKSTONE_VILLAGER_STATUE.get());
                output.accept(BlockRegister.PURPUR_BLOCK_VILLAGER_STATUE.get());
                output.accept(BlockRegister.DEEPSLATE_VILLAGER_STATUE.get());
                output.accept(BlockRegister.TUFF_VILLAGER_STATUE.get());
                output.accept(BlockRegister.PACKED_MUD_VILLAGER_STATUE.get());
                output.accept(BlockRegister.SANDSTONE_VILLAGER_STATUE.get());
                output.accept(BlockRegister.RED_SANDSTONE_VILLAGER_STATUE.get());
                output.accept(BlockRegister.QUARTZ_BLOCK_VILLAGER_STATUE.get());
                output.accept(BlockRegister.NETHER_BRICKS_VILLAGER_STATUE.get());
                output.accept(BlockRegister.BASALT_VILLAGER_STATUE.get());
                output.accept(BlockRegister.END_STONE_VILLAGER_STATUE.get());
                output.accept(BlockRegister.COAL_BLOCK_VILLAGER_STATUE.get());
                output.accept(BlockRegister.IRON_BLOCK_VILLAGER_STATUE.get());
                output.accept(BlockRegister.GOLD_BLOCK_VILLAGER_STATUE.get());
                output.accept(BlockRegister.REDSTONE_BLOCK_VILLAGER_STATUE.get());
                output.accept(BlockRegister.EMERALD_BLOCK_VILLAGER_STATUE.get());
                output.accept(BlockRegister.DIAMOND_BLOCK_VILLAGER_STATUE.get());
                output.accept(BlockRegister.COPPER_BLOCK_VILLAGER_STATUE.get());
                output.accept(BlockRegister.LAPIS_BLOCK_VILLAGER_STATUE.get());
                output.accept(BlockRegister.NETHERITE_BLOCK_VILLAGER_STATUE.get());
                output.accept(BlockRegister.OBSIDIAN_VILLAGER_STATUE.get());
                output.accept(BlockRegister.AMETHYST_BLOCK_VILLAGER_STATUE.get());
                output.accept(BlockRegister.DRIPSTONE_BLOCK_VILLAGER_STATUE.get());
                output.accept(BlockRegister.BEDROCK_VILLAGER_STATUE.get());
                    //pedestal
                output.accept(BlockRegister.OAK_PEDESTAL.get());
                output.accept(BlockRegister.BIRCH_PEDESTAL.get());
                output.accept(BlockRegister.SPRUCE_PEDESTAL.get());
                output.accept(BlockRegister.JUNGLE_PEDESTAL.get());
                output.accept(BlockRegister.ACACIA_PEDESTAL.get());
                output.accept(BlockRegister.DARK_OAK_PEDESTAL.get());
                output.accept(BlockRegister.MANGROVE_PEDESTAL.get());
                output.accept(BlockRegister.CHERRY_PEDESTAL.get());
                output.accept(BlockRegister.CRIMSON_PEDESTAL.get());
                output.accept(BlockRegister.WARPED_PEDESTAL.get());
                output.accept(BlockRegister.BAMBOO_PEDESTAL.get());
                output.accept(BlockRegister.STONE_PEDESTAL.get());
                output.accept(BlockRegister.MOSSY_STONE_PEDESTAL.get());
                output.accept(BlockRegister.ANDESITE_PEDESTAL.get());
                output.accept(BlockRegister.DIORITE_PEDESTAL.get());
                output.accept(BlockRegister.GRANITE_PEDESTAL.get());
                output.accept(BlockRegister.PRISMARINE_PEDESTAL.get());
                output.accept(BlockRegister.BLACKSTONE_PEDESTAL.get());
                output.accept(BlockRegister.PURPUR_BLOCK_PEDESTAL.get());
                output.accept(BlockRegister.DEEPSLATE_PEDESTAL.get());
                output.accept(BlockRegister.TUFF_PEDESTAL.get());
                output.accept(BlockRegister.PACKED_MUD_PEDESTAL.get());
                output.accept(BlockRegister.SANDSTONE_PEDESTAL.get());
                output.accept(BlockRegister.RED_SANDSTONE_PEDESTAL.get());
                output.accept(BlockRegister.QUARTZ_BLOCK_PEDESTAL.get());
                output.accept(BlockRegister.NETHER_BRICKS_PEDESTAL.get());
                output.accept(BlockRegister.BASALT_PEDESTAL.get());
                output.accept(BlockRegister.END_STONE_PEDESTAL.get());
                output.accept(BlockRegister.COAL_BLOCK_PEDESTAL.get());
                output.accept(BlockRegister.IRON_BLOCK_PEDESTAL.get());
                output.accept(BlockRegister.GOLD_BLOCK_PEDESTAL.get());
                output.accept(BlockRegister.REDSTONE_BLOCK_PEDESTAL.get());
                output.accept(BlockRegister.EMERALD_BLOCK_PEDESTAL.get());
                output.accept(BlockRegister.DIAMOND_BLOCK_PEDESTAL.get());
                output.accept(BlockRegister.COPPER_BLOCK_PEDESTAL.get());
                output.accept(BlockRegister.LAPIS_BLOCK_PEDESTAL.get());
                output.accept(BlockRegister.NETHERITE_BLOCK_PEDESTAL.get());
                output.accept(BlockRegister.OBSIDIAN_PEDESTAL.get());
                output.accept(BlockRegister.AMETHYST_BLOCK_PEDESTAL.get());
                output.accept(BlockRegister.DRIPSTONE_BLOCK_PEDESTAL.get());
                output.accept(BlockRegister.BEDROCK_PEDESTAL.get());
                    //brazier zone
                output.accept(BlockRegister.OAK_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.BIRCH_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.SPRUCE_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.JUNGLE_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.ACACIA_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.DARK_OAK_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.MANGROVE_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.CHERRY_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.CRIMSON_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.WARPED_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.BAMBOO_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.STONE_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.MOSSY_STONE_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.ANDESITE_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.DIORITE_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.GRANITE_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.PRISMARINE_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.BLACKSTONE_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.PURPUR_BLOCK_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.DEEPSLATE_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.TUFF_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.PACKED_MUD_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.SANDSTONE_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.RED_SANDSTONE_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.QUARTZ_BLOCK_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.NETHER_BRICKS_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.BASALT_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.END_STONE_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.COAL_BLOCK_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.IRON_BLOCK_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.GOLD_BLOCK_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.REDSTONE_BLOCK_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.EMERALD_BLOCK_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.DIAMOND_BLOCK_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.COPPER_BLOCK_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.LAPIS_BLOCK_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.NETHERITE_BLOCK_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.OBSIDIAN_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.AMETHYST_BLOCK_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.DRIPSTONE_BLOCK_VILLAGER_BRAZIER.get());
                output.accept(BlockRegister.BEDROCK_VILLAGER_BRAZIER.get());
                    //table zone
                output.accept(BlockRegister.OAK_VILLAGER_TABLE.get());
                output.accept(BlockRegister.BIRCH_VILLAGER_TABLE.get());
                output.accept(BlockRegister.SPRUCE_VILLAGER_TABLE.get());
                output.accept(BlockRegister.JUNGLE_VILLAGER_TABLE.get());
                output.accept(BlockRegister.ACACIA_VILLAGER_TABLE.get());
                output.accept(BlockRegister.DARK_OAK_VILLAGER_TABLE.get());
                output.accept(BlockRegister.MANGROVE_VILLAGER_TABLE.get());
                output.accept(BlockRegister.CHERRY_VILLAGER_TABLE.get());
                output.accept(BlockRegister.CRIMSON_VILLAGER_TABLE.get());
                output.accept(BlockRegister.WARPED_VILLAGER_TABLE.get());
                output.accept(BlockRegister.BAMBOO_VILLAGER_TABLE.get());
                output.accept(BlockRegister.STONE_VILLAGER_TABLE.get());
                output.accept(BlockRegister.MOSSY_STONE_VILLAGER_TABLE.get());
                output.accept(BlockRegister.ANDESITE_VILLAGER_TABLE.get());
                output.accept(BlockRegister.DIORITE_VILLAGER_TABLE.get());
                output.accept(BlockRegister.GRANITE_VILLAGER_TABLE.get());
                output.accept(BlockRegister.PRISMARINE_VILLAGER_TABLE.get());
                output.accept(BlockRegister.BLACKSTONE_VILLAGER_TABLE.get());
                output.accept(BlockRegister.PURPUR_BLOCK_VILLAGER_TABLE.get());
                output.accept(BlockRegister.DEEPSLATE_VILLAGER_TABLE.get());
                output.accept(BlockRegister.TUFF_VILLAGER_TABLE.get());
                output.accept(BlockRegister.PACKED_MUD_VILLAGER_TABLE.get());
                output.accept(BlockRegister.SANDSTONE_VILLAGER_TABLE.get());
                output.accept(BlockRegister.RED_SANDSTONE_VILLAGER_TABLE.get());
                output.accept(BlockRegister.QUARTZ_BLOCK_VILLAGER_TABLE.get());
                output.accept(BlockRegister.NETHER_BRICKS_VILLAGER_TABLE.get());
                output.accept(BlockRegister.BASALT_VILLAGER_TABLE.get());
                output.accept(BlockRegister.END_STONE_VILLAGER_TABLE.get());
                output.accept(BlockRegister.COAL_BLOCK_VILLAGER_TABLE.get());
                output.accept(BlockRegister.IRON_BLOCK_VILLAGER_TABLE.get());
                output.accept(BlockRegister.GOLD_BLOCK_VILLAGER_TABLE.get());
                output.accept(BlockRegister.REDSTONE_BLOCK_VILLAGER_TABLE.get());
                output.accept(BlockRegister.EMERALD_BLOCK_VILLAGER_TABLE.get());
                output.accept(BlockRegister.DIAMOND_BLOCK_VILLAGER_TABLE.get());
                output.accept(BlockRegister.COPPER_BLOCK_VILLAGER_TABLE.get());
                output.accept(BlockRegister.LAPIS_BLOCK_VILLAGER_TABLE.get());
                output.accept(BlockRegister.NETHERITE_BLOCK_VILLAGER_TABLE.get());
                output.accept(BlockRegister.OBSIDIAN_VILLAGER_TABLE.get());
                output.accept(BlockRegister.AMETHYST_BLOCK_VILLAGER_TABLE.get());
                output.accept(BlockRegister.DRIPSTONE_BLOCK_VILLAGER_TABLE.get());
                output.accept(BlockRegister.BEDROCK_VILLAGER_TABLE.get());
            }).build());
    public static void register(IEventBus modEventBus)
    {
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
