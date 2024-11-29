package com.unpainperdu.premierpainmod.datagen.data.lootTable;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.abstractBlock.*;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerPedestalBlock;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerTableBlock;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.TwoBlockWidthPart;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockHeight.VillagerStatue;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockWidth.VillagerWorkshop;
import com.unpainperdu.premierpainmod.level.world.block.tree.FlammableBlock;
import com.unpainperdu.premierpainmod.level.world.block.tree.LogBlock;
import com.unpainperdu.premierpainmod.level.world.block.tree.ModLeavesBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.crop.JellyShroomBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.growingAboveVegetation.CivilizationsFlowerBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.CactusFlowerBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.FloweredCactusBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.twoBlockHeight.skySpears.SkySpearsFlower;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.ModList;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class ModBlockLootTableSubProvider extends BlockLootSubProvider
{
    private static final float[] NORMAL_LEAVES_STICK_CHANCES = new float[]{0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F};

    public ModBlockLootTableSubProvider(HolderLookup.Provider provider)
    {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags(),provider);
    }

    @Override
    public void generate()
    {
        for(DeferredBlock<Block> deferredBlock : ModList.ALL_BLOCKS)
        {
            Block block = deferredBlock.get();
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
        pottedFlowerLootTableGenerator(BlockRegister.POTTED_SKY_SPEARS_FLOWER.get(), BlockRegister.SKY_SPEARS_FLOWER.get());
        itemOr2ndItemIfShearTwoBlockHeightLootTableGenerator(BlockRegister.DEAD_TALL_BUSH.get(), Items.STICK);
        itemOr2ndItemIfShearTwoBlockHeightLootTableGenerator(BlockRegister.OLD_WILD_WHEAT.get(), Items.WHEAT, 2.0f);
            //crop
        jellyShroomLootTable();
        //potted thing
            //flower
        pottedFlowerLootTableGenerator(BlockRegister.POTTED_RUINS_FLOWER.get(), BlockRegister.RUINS_FLOWER.get());
        pottedFlowerLootTableGenerator(BlockRegister.POTTED_CIVILIZATIONS_FLOWER.get(), BlockRegister.CIVILIZATIONS_FLOWER.get());
        pottedFlowerLootTableGenerator(BlockRegister.POTTED_CURIOSITY_FLOWER.get(), BlockRegister.CURIOSITY_FLOWER.get());
            //dead bush
        pottedFlowerLootTableGenerator(BlockRegister.POTTED_DEAD_RUINS_FLOWER.get(), BlockRegister.DEAD_RUINS_FLOWER.get());
            //misc
        pottedFlowerLootTableGenerator(BlockRegister.POTTED_CACTUS_FLOWER_BLOCK.get(), BlockRegister.CACTUS_FLOWER_BLOCK.get());
            //crop
        pottedFlowerLootTableGenerator(BlockRegister.POTTED_JELLYSHROOM.get(), BlockRegister.JELLYSHROOM.get());
            //sapling
        pottedFlowerLootTableGenerator(BlockRegister.POTTED_MOUNTAIN_CURRANT_SAPLING.get(), BlockRegister.MOUNTAIN_CURRANT_SAPLING.get());
        //leaves
        leavesWithFruitLootTable(BlockRegister.MOUNTAIN_CURRANT_LEAVES.get(), BlockRegister.MOUNTAIN_CURRANT_SAPLING.get(), ItemRegister.MOUNTAIN_CURRANT.get());
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
        itemOr2ndItemIfShearTwoBlockHeightLootTableGenerator(block, resultIfNotShear, 1.0f);
    }

    private void itemOr2ndItemIfShearTwoBlockHeightLootTableGenerator(Block block, ItemLike resultIfNotShear, float numberNoShearItem)
    {
        super.add(block, this.createTallGrassDispatchTable(block, AbstractTallGrass.HALF, DoubleBlockHalf.LOWER, resultIfNotShear, numberNoShearItem));
    }

    private <T extends Comparable<T> & StringRepresentable> LootTable.Builder createTallGrassDispatchTable(Block block, Property<T> property, T valueOfProperty, ItemLike resultIfNotShear, float numberNoShearItem)
    {
        LootPoolEntryContainer.Builder<?> builder = (LootPoolSingletonContainer.Builder) this.applyExplosionCondition(block,
                        LootItem.lootTableItem(resultIfNotShear))
                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                    .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(property, valueOfProperty)))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(numberNoShearItem))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(property, valueOfProperty))));

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

    private void jellyShroomLootTable()
    {
        //temp
        Block block = BlockRegister.JELLYSHROOM.get();
        //normalBlockLootTableGenerator(block);

        super.add(block, this.createJellyshroomDispatchTable());
    }

    private LootTable.Builder createJellyshroomDispatchTable()
    {
        Block block = BlockRegister.JELLYSHROOM.get();
        IntegerProperty property = JellyShroomBlock.AGE ;

        return LootTable.lootTable()
                .withPool(
                        this.applyExplosionCondition(
                                block
                                ,LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(block)
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(property, 0))))
                                        .add(LootItem.lootTableItem(block)
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(property, 1))))
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(property, 1))))
                                        .add(LootItem.lootTableItem(block)
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(property, 2))))
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0f))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(property, 2))))
                                        .add(LootItem.lootTableItem(block)
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(property, 3))))
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0f))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(property, 3))))
                                        .add(LootItem.lootTableItem(block)
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(property, 4))))
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(5.0f))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(property, 4))))
                        ));
    }

    private void leavesLootTable(Block leave, Block sapling)
    {
        super.add(leave, createLeavesDrops(leave, sapling, NORMAL_LEAVES_SAPLING_CHANCES));
    }

    private void leavesWithFruitLootTable(Block leave, Block sapling, Item fruit)
    {
        super.add(leave, createLeavesWithFruitDispatchTable(leave, sapling, fruit, NORMAL_LEAVES_SAPLING_CHANCES));
    }

    private LootTable.Builder createLeavesWithFruitDispatchTable(Block leavesBlock, Block saplingBlock, Item fruit, float... chances)
    {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        return this.createSilkTouchOrShearsDispatchTable(
                        leavesBlock,
                        ((LootPoolSingletonContainer.Builder)this.applyExplosionCondition(leavesBlock, LootItem.lootTableItem(saplingBlock)))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), chances))
                )
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .when(this.doesNotHaveShearsOrSilkTouch())
                                .add(LootItem.lootTableItem(fruit)
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(leavesBlock)
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ModLeavesBlock.HAS_FRUIT, true))))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f)))
                                .add(
                                        ((LootPoolSingletonContainer.Builder)this.applyExplosionDecay(
                                                leavesBlock, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                        ))
                                                .when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), NORMAL_LEAVES_STICK_CHANCES))
                                )
                );
    }

    private LootItemCondition.Builder doesNotHaveShearsOrSilkTouch()
    {
        return this.hasShearsOrSilkTouch().invert();
    }

    private LootItemCondition.Builder hasShearsOrSilkTouch()
    {
        return HAS_SHEARS.or(this.hasSilkTouch());
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
                || block instanceof SkySpearsFlower
                || block instanceof FlammableBlock
                || block instanceof LogBlock
                || block instanceof StairBlock
                || block instanceof SlabBlock
                || block instanceof ButtonBlock
                || block instanceof PressurePlateBlock
                || block instanceof FenceBlock
                || block instanceof FenceGateBlock
                || block instanceof TrapDoorBlock
                || block instanceof SignBlock
                || block instanceof SaplingBlock
                ;
    }

    private boolean is2HeightBlockLoot(Block block)
    {
        return block instanceof AbstractTwoBlockHeightBlock
                        || block instanceof DoorBlock;

    }
    private boolean is2WidthBlockLoot(Block block)
    {
        return (block instanceof AbstractTwoBlockWidth
                || block instanceof AbstractTwoBlockWidthWithBlockEntity);
    }
}