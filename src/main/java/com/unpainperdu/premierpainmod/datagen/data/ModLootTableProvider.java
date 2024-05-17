package com.unpainperdu.premierpainmod.datagen.data;


import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import com.unpainperdu.premierpainmod.world.block.VillagerStatue;
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
            statueLootTableGenerator(BlockRegister.ANDESITE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.DIORITE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.GRANITE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.PRISMARINE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.BLACKSTONE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.PURPUR_BLOCK_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.COBBLESTONE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.MOSSY_COBBLESTONE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.SMOOTH_STONE_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.COBBLED_DEEPSLATE_VILLAGER_STATUE.get());
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
            statueLootTableGenerator(BlockRegister.OBSIDIAN_BLOCK_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.AMETHYST_BLOCK_VILLAGER_STATUE.get());
            statueLootTableGenerator(BlockRegister.DRIPSTONE_BLOCK_VILLAGER_STATUE.get());
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
    }
}