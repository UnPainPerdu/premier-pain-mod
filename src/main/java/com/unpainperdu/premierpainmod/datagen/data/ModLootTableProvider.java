package com.unpainperdu.premierpainmod.datagen.data;


import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.VillagerWorkshop;
import com.unpainperdu.premierpainmod.level.world.block.state.properties.VillagerWorkshopPart;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight.VillagerThroneChairBlock;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight.VillagerStatue;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.core.registries.BuiltInRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ModLootTableProvider extends LootTableProvider
{
    public ModLootTableProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(
                output,
                Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(Blocks::new, LootContextParamSets.BLOCK)),
                lookupProvider
        );
    }

    private static class Blocks extends BlockLootSubProvider
    {
        public Blocks(HolderLookup.Provider provider)
        {
            super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags(),provider);
        }

        @Override
        public void generate()
        {
            //villager workshop
            VillagerWorkshopLootTableGenerator(BlockRegister.VILLAGER_WORKSHOP.get());
            //statue
            statueLootTableGenerator(BlockRegister.OAK_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.BIRCH_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.SPRUCE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.JUNGLE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.ACACIA_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.DARK_OAK_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.MANGROVE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.CHERRY_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.CRIMSON_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.WARPED_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.BAMBOO_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.STONE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.MOSSY_STONE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.ANDESITE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.DIORITE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.GRANITE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.PRISMARINE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.BLACKSTONE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.PURPUR_BLOCK_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.DEEPSLATE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.TUFF_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.PACKED_MUD_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.SANDSTONE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.RED_SANDSTONE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.QUARTZ_BLOCK_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.NETHER_BRICKS_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.BASALT_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.END_STONE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.COAL_BLOCK_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.IRON_BLOCK_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.GOLD_BLOCK_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.REDSTONE_BLOCK_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.EMERALD_BLOCK_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.DIAMOND_BLOCK_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.COPPER_BLOCK_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.LAPIS_BLOCK_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.NETHERITE_BLOCK_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.OBSIDIAN_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.AMETHYST_BLOCK_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.DRIPSTONE_BLOCK_VILLAGER_STATUE.get());
            //pedestal
            pedestalLootTableGenerator(BlockRegister.OAK_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.BIRCH_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.SPRUCE_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.JUNGLE_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.ACACIA_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.DARK_OAK_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.MANGROVE_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.CHERRY_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.CRIMSON_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.WARPED_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.BAMBOO_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.STONE_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.MOSSY_STONE_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.ANDESITE_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.DIORITE_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.GRANITE_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.PRISMARINE_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.BLACKSTONE_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.PURPUR_BLOCK_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.DEEPSLATE_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.TUFF_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.PACKED_MUD_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.SANDSTONE_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.RED_SANDSTONE_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.QUARTZ_BLOCK_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.NETHER_BRICKS_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.BASALT_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.END_STONE_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.COAL_BLOCK_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.IRON_BLOCK_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.GOLD_BLOCK_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.REDSTONE_BLOCK_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.EMERALD_BLOCK_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.DIAMOND_BLOCK_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.COPPER_BLOCK_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.LAPIS_BLOCK_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.NETHERITE_BLOCK_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.OBSIDIAN_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.AMETHYST_BLOCK_PEDESTAL.get());
            pedestalLootTableGenerator(BlockRegister.DRIPSTONE_BLOCK_PEDESTAL.get());
            //brazier
            brazierLootTableGenerator(BlockRegister.OAK_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.BIRCH_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.SPRUCE_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.JUNGLE_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.ACACIA_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.DARK_OAK_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.MANGROVE_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.CHERRY_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.CRIMSON_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.WARPED_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.BAMBOO_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.STONE_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.MOSSY_STONE_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.ANDESITE_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.DIORITE_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.GRANITE_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.PRISMARINE_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.BLACKSTONE_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.PURPUR_BLOCK_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.DEEPSLATE_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.TUFF_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.PACKED_MUD_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.SANDSTONE_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.RED_SANDSTONE_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.QUARTZ_BLOCK_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.NETHER_BRICKS_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.BASALT_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.END_STONE_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.COAL_BLOCK_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.IRON_BLOCK_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.GOLD_BLOCK_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.REDSTONE_BLOCK_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.EMERALD_BLOCK_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.DIAMOND_BLOCK_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.COPPER_BLOCK_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.LAPIS_BLOCK_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.NETHERITE_BLOCK_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.OBSIDIAN_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.AMETHYST_BLOCK_VILLAGER_BRAZIER.get());
            brazierLootTableGenerator(BlockRegister.DRIPSTONE_BLOCK_VILLAGER_BRAZIER.get());
            //table
            tableLootTableGenerator(BlockRegister.OAK_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.BIRCH_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.SPRUCE_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.JUNGLE_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.ACACIA_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.DARK_OAK_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.MANGROVE_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.CHERRY_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.CRIMSON_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.WARPED_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.BAMBOO_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.STONE_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.MOSSY_STONE_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.ANDESITE_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.DIORITE_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.GRANITE_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.PRISMARINE_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.BLACKSTONE_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.PURPUR_BLOCK_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.DEEPSLATE_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.TUFF_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.PACKED_MUD_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.SANDSTONE_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.RED_SANDSTONE_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.QUARTZ_BLOCK_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.NETHER_BRICKS_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.BASALT_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.END_STONE_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.COAL_BLOCK_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.IRON_BLOCK_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.GOLD_BLOCK_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.REDSTONE_BLOCK_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.EMERALD_BLOCK_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.DIAMOND_BLOCK_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.COPPER_BLOCK_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.LAPIS_BLOCK_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.NETHERITE_BLOCK_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.OBSIDIAN_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.AMETHYST_BLOCK_VILLAGER_TABLE.get());
            tableLootTableGenerator(BlockRegister.DRIPSTONE_BLOCK_VILLAGER_TABLE.get());
            //chair
            chairLootTableGenerator(BlockRegister.OAK_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.BIRCH_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.SPRUCE_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.JUNGLE_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.ACACIA_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.DARK_OAK_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.MANGROVE_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.CHERRY_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.CRIMSON_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.WARPED_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.BAMBOO_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.STONE_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.MOSSY_STONE_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.ANDESITE_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.DIORITE_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.GRANITE_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.PRISMARINE_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.BLACKSTONE_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.PURPUR_BLOCK_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.DEEPSLATE_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.TUFF_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.PACKED_MUD_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.SANDSTONE_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.RED_SANDSTONE_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.QUARTZ_BLOCK_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.NETHER_BRICKS_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.BASALT_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.END_STONE_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.COAL_BLOCK_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.IRON_BLOCK_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.GOLD_BLOCK_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.REDSTONE_BLOCK_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.EMERALD_BLOCK_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.DIAMOND_BLOCK_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.COPPER_BLOCK_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.LAPIS_BLOCK_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.NETHERITE_BLOCK_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.OBSIDIAN_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.AMETHYST_BLOCK_VILLAGER_CHAIR.get());
            chairLootTableGenerator(BlockRegister.DRIPSTONE_BLOCK_VILLAGER_CHAIR.get());
            //throne chair
            throneChairLootTableGenerator(BlockRegister.OAK_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.BIRCH_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.SPRUCE_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.JUNGLE_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.ACACIA_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.DARK_OAK_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.MANGROVE_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.CHERRY_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.CRIMSON_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.WARPED_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.BAMBOO_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.STONE_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.MOSSY_STONE_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.ANDESITE_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.DIORITE_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.GRANITE_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.PRISMARINE_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.BLACKSTONE_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.PURPUR_BLOCK_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.DEEPSLATE_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.TUFF_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.PACKED_MUD_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.SANDSTONE_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.RED_SANDSTONE_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.QUARTZ_BLOCK_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.NETHER_BRICKS_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.BASALT_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.END_STONE_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.COAL_BLOCK_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.IRON_BLOCK_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.GOLD_BLOCK_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.REDSTONE_BLOCK_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.EMERALD_BLOCK_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.DIAMOND_BLOCK_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.COPPER_BLOCK_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.LAPIS_BLOCK_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.NETHERITE_BLOCK_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.OBSIDIAN_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.AMETHYST_BLOCK_VILLAGER_THRONE_CHAIR.get());
            throneChairLootTableGenerator(BlockRegister.DRIPSTONE_BLOCK_VILLAGER_THRONE_CHAIR.get());
        }
        @Override
        protected @NotNull Iterable<Block> getKnownBlocks()
        {
            return BuiltInRegistries.BLOCK.entrySet().stream()
                    .filter(e -> e.getKey().location().getNamespace().equals(PremierPainMod.MODID))
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());
        }
        private void statueLootTableGenerator(Block statue)
        {
            super.add(statue, this.createSinglePropConditionTable(statue, VillagerStatue.HALF, DoubleBlockHalf.LOWER));
        }
        private void VillagerWorkshopLootTableGenerator(Block villagerWorkshop)
        {
            super.add(villagerWorkshop, this.createSinglePropConditionTable(villagerWorkshop, VillagerWorkshop.PART, VillagerWorkshopPart.RIGHT));
        }
        private void pedestalLootTableGenerator(Block pedestal)
        {
            super.add(pedestal, this.createSingleItemTable(pedestal));
        }
        private void brazierLootTableGenerator(Block brazier)
        {
            super.add(brazier, this.createSinglePropConditionTable(brazier, VillagerStatue.HALF, DoubleBlockHalf.LOWER));
        }
        private void tableLootTableGenerator(Block table)
        {
            super.add(table, this.createSingleItemTable(table));
        }
        private void chairLootTableGenerator(Block chair)
        {
            super.add(chair, this.createSingleItemTable(chair));
        }
        private void throneChairLootTableGenerator(Block chair)
        {
            super.add(chair, this.createSinglePropConditionTable(chair, VillagerThroneChairBlock.HALF, DoubleBlockHalf.LOWER));
        }
    }
}