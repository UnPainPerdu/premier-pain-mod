package com.unpainperdu.premierpainmod.datagen.data;


import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidth.VillagerWorkshop;
import com.unpainperdu.premierpainmod.level.world.block.state.properties.TwoBlockWidthPart;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight.VillagerBrazier;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight.VillagerThroneChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidthWithBlockEntity.VillagerDrawer;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidthWithBlockEntity.VillagerShelf;
import com.unpainperdu.premierpainmod.util.register.BlockList;
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
import net.neoforged.neoforge.registries.DeferredBlock;
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
            for(DeferredBlock<Block> Defferedblock : BlockList.ALL_BLOCKS)
            {
                Block block = Defferedblock.get();
                String blockName = BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MODID+":","");
                if(!blockName.contains("bedrock"))
                {
                    if (block instanceof VillagerStatue)
                    {
                        villagerStatueLootTableGenerator(block);
                    } else if (block instanceof VillagerWorkshop)
                    {
                        villagerWorkshopLootTableGenerator(block);
                    } else if (block instanceof VillagerBrazier)
                    {
                        villagerBrazierLootTableGenerator(block);
                    } else if (block instanceof VillagerThroneChairBlock)
                    {
                        villagerThroneChairLootTableGenerator(block);
                    }else if (block instanceof VillagerDrawer)
                    {
                        villagerDrawerLootTableGenerator(block);
                    }else if (block instanceof VillagerShelf)
                    {
                        villagerShelfLootTableGenerator(block);
                    } else
                    {
                        normalBlockLootTableGenerator(block);
                    }
                }
            }
        }
        @Override
        protected @NotNull Iterable<Block> getKnownBlocks()
        {
            return BuiltInRegistries.BLOCK.entrySet().stream()
                    .filter(e -> e.getKey().location().getNamespace().equals(PremierPainMod.MODID))
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());
        }

        private void normalBlockLootTableGenerator(Block block)
        {
            super.add(block, this.createSingleItemTable(block));
        }

        private void villagerStatueLootTableGenerator(Block statue)
        {
            super.add(statue, this.createSinglePropConditionTable(statue, VillagerStatue.HALF, DoubleBlockHalf.LOWER));
        }

        private void villagerWorkshopLootTableGenerator(Block villagerWorkshop)
        {
            super.add(villagerWorkshop, this.createSinglePropConditionTable(villagerWorkshop, VillagerWorkshop.PART, TwoBlockWidthPart.RIGHT));
        }

        private void villagerBrazierLootTableGenerator(Block brazier)
        {
            super.add(brazier, this.createSinglePropConditionTable(brazier, VillagerBrazier.HALF, DoubleBlockHalf.LOWER));
        }

        private void villagerThroneChairLootTableGenerator(Block chair)
        {
            super.add(chair, this.createSinglePropConditionTable(chair, VillagerThroneChairBlock.HALF, DoubleBlockHalf.LOWER));
        }
        private void villagerDrawerLootTableGenerator(Block villagerDrawer)
        {
            super.add(villagerDrawer, this.createSinglePropConditionTable(villagerDrawer, VillagerWorkshop.PART, TwoBlockWidthPart.RIGHT));
        }
        private void villagerShelfLootTableGenerator(Block villagerShelf)
        {
            super.add(villagerShelf, this.createSinglePropConditionTable(villagerShelf, VillagerWorkshop.PART, TwoBlockWidthPart.RIGHT));
        }
    }
}