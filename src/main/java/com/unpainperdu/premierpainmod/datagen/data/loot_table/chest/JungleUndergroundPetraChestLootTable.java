package com.unpainperdu.premierpainmod.datagen.data.loot_table.chest;

import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool.CommonLootTable;
import com.unpainperdu.premierpainmod.datagen.data.loot_table.ModChestLootTableSubProvider;
import com.unpainperdu.premierpainmod.util.register.Item.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

import static com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool.CommonLootTable.addVillagerSingingStone;

public class JungleUndergroundPetraChestLootTable
{
    private static final String BASE_NAME = "jungle_underground_petra/";

    public static final ResourceKey<LootTable> HOUSE = createKey("house");
    public static final ResourceKey<LootTable> FIELD = createKey("field");
    public static final ResourceKey<LootTable> SMITHY = createKey("smithy");
    public static final ResourceKey<LootTable> MASON = createKey("mason");
    public static final ResourceKey<LootTable> BEERHOUSE = createKey("beerhouse");


    private JungleUndergroundPetraChestLootTable()
    {
    }

    private static ResourceKey<LootTable> createKey(String name)
    {
        return ModChestLootTableSubProvider.createKey(BASE_NAME + name);
    }

    private static LootPool.Builder jungleUnderGroundPetraCommonLootTable(LootPool.Builder lootTable)
    {
        return addVillagerSingingStone(lootTable, 1)
                .add(LootItem.lootTableItem(ItemRegister.MORICHE_PALM_FRUIT)
                        .setWeight(5)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5)))
                )
                .add(LootItem.lootTableItem(ItemRegister.ACHIOTE_FRUIT)
                        .setWeight(5)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5)))
                )
                .add(LootItem.lootTableItem(BlockRegister.MORICHE_PALM_WOOD_TYPE_MAP.get("log"))
                        .setWeight(4)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4)))
                )
                .add(LootItem.lootTableItem(BlockRegister.ACHIOTE_WOOD_TYPE_MAP.get("log"))
                        .setWeight(4)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4)))
                )
                .add(LootItem.lootTableItem(Items.EMERALD)
                        .setWeight(2)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                )
                .add(LootItem.lootTableItem(Items.POTATO)
                        .setWeight(4)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8)))
                )
                .add(LootItem.lootTableItem(Items.POISONOUS_POTATO)
                        .setWeight(3)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                );
    }

    public static void jungleUnderGroundPetraChestLootTableGenerator(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builder)
    {
        houseLootTable(builder);
        fieldLootTable(builder);
        smithyLootTable(builder);
        masonLootTable(builder);
        beerHouseLootTable(builder);
    }

    private static void houseLootTable(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builder)
    {
        builder.accept(HOUSE, LootTable.lootTable()
                .withPool(
                        jungleUnderGroundPetraCommonLootTable(LootPool.lootPool())
                                .setRolls(UniformGenerator.between(3, 8))
                                .setBonusRolls(ConstantValue.exactly(0))
                                .add(LootItem.lootTableItem(BlockRegister.MORICHE_PALM_WOOD_TYPE_MAP.get("sapling"))
                                        .setWeight(5)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                                )
                                .add(LootItem.lootTableItem(BlockRegister.ACHIOTE_WOOD_TYPE_MAP.get("sapling"))
                                        .setWeight(5)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                                )
                )
        );
    }

    private static void fieldLootTable(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builder)
    {
        builder.accept(FIELD, LootTable.lootTable()
                .withPool(
                        jungleUnderGroundPetraCommonLootTable(LootPool.lootPool())
                                .setRolls(UniformGenerator.between(6, 8))
                                .setBonusRolls(ConstantValue.exactly(0))
                                .add(LootItem.lootTableItem(Items.BONE_MEAL)
                                        .setWeight(5)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 7)))
                                )
                                .add(LootItem.lootTableItem(BlockRegister.JELLYSHROOM)
                                        .setWeight(3)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                                )
                                .add(LootItem.lootTableItem(ItemRegister.JELLY_HAT)
                                        .setWeight(4)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 5)))
                                )
                )
        );
    }

    private static void smithyLootTable(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builder)
    {
        builder.accept(SMITHY, LootTable.lootTable()
                .withPool(
                        jungleUnderGroundPetraCommonLootTable(LootPool.lootPool())
                                .setRolls(UniformGenerator.between(3, 5))
                                .setBonusRolls(ConstantValue.exactly(0))
                                .add(LootItem.lootTableItem(Items.IRON_INGOT)
                                        .setWeight(4)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 7)))
                                )
                                .add(LootItem.lootTableItem(Blocks.OBSIDIAN)
                                        .setWeight(3)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                                )
                                .add(LootItem.lootTableItem(Items.IRON_PICKAXE)
                                        .setWeight(2)
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                                )
                                .add(LootItem.lootTableItem(Items.DIAMOND_PICKAXE)
                                        .setWeight(1)
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                                )
                )
        );
    }

    private static void masonLootTable(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builder)
    {
        builder.accept(MASON, LootTable.lootTable()
                .withPool(
                        jungleUnderGroundPetraCommonLootTable(LootPool.lootPool())
                                .setRolls(UniformGenerator.between(4, 7))
                                .setBonusRolls(ConstantValue.exactly(0))
                                .add(LootItem.lootTableItem(Items.BRICK)
                                        .setWeight(4)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(10, 24)))
                                )
                                .add(LootItem.lootTableItem(Blocks.CLAY)
                                        .setWeight(2)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                                )
                                .add(LootItem.lootTableItem(Items.CLAY_BALL)
                                        .setWeight(5)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(12, 28)))
                                )
                )
        );
    }

    private static void beerHouseLootTable(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builder)
    {
        builder.accept(BEERHOUSE, LootTable.lootTable()
                .withPool(
                        CommonLootTable.addAllBeerBottleMugGlass(jungleUnderGroundPetraCommonLootTable(LootPool.lootPool()), 2)
                                .setRolls(UniformGenerator.between(10, 15))
                                .setBonusRolls(ConstantValue.exactly(0))
                                .add(LootItem.lootTableItem(BlockRegister.CIVILIZATIONS_FLOWER)
                                        .setWeight(4)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 7)))
                                )
                                .add(LootItem.lootTableItem(Blocks.WHEAT)
                                        .setWeight(5)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 5)))
                                )
                                .add(LootItem.lootTableItem(Items.SUGAR)
                                        .setWeight(4)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                                )
                )
        );
    }
}
