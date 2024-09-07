package com.unpainperdu.premierpainmod.datagen.data.lootTable;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.abstractBlock.AbstractTallGrass;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerPedestalBlock;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerTableBlock;
import com.unpainperdu.premierpainmod.level.world.block.state.properties.TwoBlockWidthPart;
import com.unpainperdu.premierpainmod.level.world.block.abstractBlock.AbstractTwoBlockHeightBlock;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockHeight.VillagerStatue;
import com.unpainperdu.premierpainmod.level.world.block.abstractBlock.AbstractTwoBlockWidth;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockWidth.VillagerWorkshop;
import com.unpainperdu.premierpainmod.level.world.block.abstractBlock.AbstractTwoBlockWidthWithBlockEntity;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.growingAboveVegetation.CivilizationsFlowerBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.CactusFlowerBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.FloweredCactusBlock;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.ModList;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DeadBushBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class ModBlockLootTableSubProvider extends BlockLootSubProvider
{
    public ModBlockLootTableSubProvider(HolderLookup.Provider provider)
    {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags(),provider);
    }

    @Override
    public void generate()
    {
        for(DeferredBlock<Block> Defferedblock : ModList.ALL_BLOCKS)
        {
            Block block = Defferedblock.get();
            String blockName = BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MOD_ID +":","");
            if(!blockName.contains("bedrock"))
            {
                if (is2HeightBlockLoot(block))
                {
                    twoBlockHeightLootTableGenerator(block);
                }
                else if (is2WidthBlockLoot(block))
                {
                    twoBlockWidthLootTableGenerator(block);
                }

                else if(isNormalLoot(block))
                {
                    normalBlockLootTableGenerator(block);
                }
                else if(block instanceof DeadBushBlock)
                {
                    itemOr2ndItemIfShearLootTableProvider(block, Items.STICK);
                }
            }
        }
        //potted thing
            //flower
        pottedFlowerLootTableGenerator(BlockRegister.POTTED_RUINS_FLOWER.get(), BlockRegister.RUINS_FLOWER.get());
        pottedFlowerLootTableGenerator(BlockRegister.POTTED_CIVILIZATIONS_FLOWER.get(), BlockRegister.CIVILIZATIONS_FLOWER.get());
        pottedFlowerLootTableGenerator(BlockRegister.POTTED_CURIOSITY_FLOWER.get(), BlockRegister.CURIOSITY_FLOWER.get());
            //dead bush
        pottedFlowerLootTableGenerator(BlockRegister.POTTED_DEAD_RUINS_FLOWER.get(), BlockRegister.DEAD_RUINS_FLOWER.get());
            //misc
        pottedFlowerLootTableGenerator(BlockRegister.POTTED_CACTUS_FLOWER_BLOCK.get(), BlockRegister.CACTUS_FLOWER_BLOCK.get());
    }
    @Override
    protected @NotNull Iterable<Block> getKnownBlocks()
    {
        return BuiltInRegistries.BLOCK.entrySet().stream()
                .filter(e -> e.getKey().location().getNamespace().equals(PremierPainMod.MOD_ID))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    private void normalBlockLootTableGenerator(Block block)
    {
        super.add(block, this.createSingleItemTable(block));
    }

    private void twoBlockHeightLootTableGenerator(Block block)
    {
        super.add(block, this.createSinglePropConditionTable(block, VillagerStatue.HALF, DoubleBlockHalf.LOWER));
    }

    private void twoBlockWidthLootTableGenerator(Block block)
    {
        super.add(block, this.createSinglePropConditionTable(block, VillagerWorkshop.PART, TwoBlockWidthPart.RIGHT));
    }

    private void pottedFlowerLootTableGenerator(Block flowerPot, Block flowerBlock)
    {
        super.add(flowerPot, this.createPotFlowerItemTable(flowerBlock));
    }

    private void itemOr2ndItemIfShearLootTableProvider(Block deadBush, ItemLike resultIfNotShear)
    {
        super.add(deadBush, this.createShearsDispatchTable(deadBush, (LootPoolSingletonContainer.Builder) this.applyExplosionCondition(deadBush, LootItem.lootTableItem(resultIfNotShear))));
    }

    private boolean isNormalLoot(Block block)
    {
        return block instanceof VillagerPedestalBlock
                || block instanceof VillagerTableBlock
                || block instanceof VillagerChairBlock
                || block instanceof FlowerBlock
                || block instanceof CivilizationsFlowerBlock
                || block instanceof FloweredCactusBlock
                || block instanceof CactusFlowerBlock;
    }

    private boolean is2HeightBlockLoot(Block block)
    {
        return block instanceof AbstractTwoBlockHeightBlock
                ||block instanceof AbstractTallGrass;
    }
    private boolean is2WidthBlockLoot(Block block)
    {
        return block instanceof AbstractTwoBlockWidth
                || block instanceof AbstractTwoBlockWidthWithBlockEntity;
    }
}