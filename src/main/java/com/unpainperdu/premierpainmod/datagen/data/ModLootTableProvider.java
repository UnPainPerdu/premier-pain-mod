package com.unpainperdu.premierpainmod.datagen.data;


import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.VillagerWorkshop;
import com.unpainperdu.premierpainmod.level.world.block.state.properties.VillagerWorkshopPart;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import com.unpainperdu.premierpainmod.level.world.block.VillagerStatue;
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
                output, Set.of(), List.of(new LootTableProvider.SubProviderEntry(Blocks::new, LootContextParamSets.BLOCK)),
                lookupProvider
        );
    }

    private static class Blocks extends BlockLootSubProvider
    {
        protected Blocks()
        {
            super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
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
    }
}