package com.unpainperdu.premierpainmod.datagen.data.lootTable;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.abstractBlock.*;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerPedestalBlock;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerTableBlock;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.TwoBlockWidthPart;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockHeight.VillagerStatue;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockWidth.VillagerWorkshop;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.growingAboveVegetation.CivilizationsFlowerBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.CactusFlowerBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.FloweredCactusBlock;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.ModList;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DeadBushBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
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
    //manual thing
        //vegetation
            //tall grass
        itemOr2ndItemIfShearTwoBlockHeightLootTableGenerator(BlockRegister.SKY_SPEARS.get(), Items.STICK);
        itemOr2ndItemIfShearTwoBlockHeightLootTableGenerator(BlockRegister.DEAD_TALL_BUSH.get(), Items.STICK);
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

    private void itemOr2ndItemIfShearTwoBlockHeightLootTableGenerator(Block block, ItemLike resultIfNotShear)
    {
        super.add(block, this.createTallGrassDispatchTable(block, AbstractTallGrass.HALF, DoubleBlockHalf.LOWER, resultIfNotShear));
    }

    private <T extends Comparable<T> & StringRepresentable> LootTable.Builder createTallGrassDispatchTable(Block block, Property<T> property, T valueOfProperty, ItemLike resultIfNotShear)
    {
        LootPoolEntryContainer.Builder<?> builder = (LootPoolSingletonContainer.Builder) this.applyExplosionCondition(block, LootItem.lootTableItem(resultIfNotShear))
                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(property, valueOfProperty)));
        return LootTable.lootTable()
                .withPool(
                        this.applyExplosionCondition(
                            block
                            ,LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(block)
                                        .when(HAS_SHEARS)
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(property, valueOfProperty)))
                                        .otherwise(builder))));
    }

    private <T extends Comparable<T> & StringRepresentable> LootTable.Builder TEMPcreateTallGrassDispatchTable(Block block, Property<T> property, T valueOfProperty, ItemLike resultIfNotShear)
    {
        LootPoolEntryContainer.Builder<?> builder = (LootPoolSingletonContainer.Builder) this.applyExplosionCondition(block, LootItem.lootTableItem(resultIfNotShear))
                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(property, valueOfProperty)));

        return LootTable.lootTable()
                .withPool(
                        this.applyExplosionCondition(
                                block
                                ,LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(block)
                                                .when(HAS_SHEARS)
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(property, valueOfProperty)))
                                                .otherwise(builder))));
    }

    private boolean isNormalLoot(Block block)
    {
        return block instanceof VillagerPedestalBlock
                || block instanceof VillagerTableBlock
                || block instanceof VillagerChairBlock
                || block instanceof FlowerBlock
                || block instanceof CivilizationsFlowerBlock
                || block instanceof FloweredCactusBlock
                || block instanceof CactusFlowerBlock
                || block instanceof AbstractAdaptableSit
                ;
    }

    private boolean is2HeightBlockLoot(Block block)
    {
        return block instanceof AbstractTwoBlockHeightBlock;
    }
    private boolean is2WidthBlockLoot(Block block)
    {
        return block instanceof AbstractTwoBlockWidth
                || block instanceof AbstractTwoBlockWidthWithBlockEntity;
    }
}