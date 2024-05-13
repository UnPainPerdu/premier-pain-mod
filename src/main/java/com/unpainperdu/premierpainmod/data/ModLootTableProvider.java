package com.unpainperdu.premierpainmod.data;


import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
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
            this.dropSelf(BlockRegister.OAK_VILLAGER_STATUE.get());
            this.dropSelf(BlockRegister.BIRCH_VILLAGER_STATUE.get());
        }
        @Override
        protected @NotNull Iterable<Block> getKnownBlocks()
        {
            return BuiltInRegistries.BLOCK.entrySet().stream()
                    .filter(e -> e.getKey().location().getNamespace().equals(PremierPainMod.MODID))
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());
        }
    }
}