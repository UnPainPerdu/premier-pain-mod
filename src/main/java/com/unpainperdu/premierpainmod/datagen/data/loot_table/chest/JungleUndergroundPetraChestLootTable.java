package com.unpainperdu.premierpainmod.datagen.data.loot_table.chest;

import com.unpainperdu.premierpainmod.util.register.Item.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

import static com.unpainperdu.premierpainmod.datagen.data.loot_table.ModChestLootTableSubProvider.createKey;

public class JungleUndergroundPetraChestLootTable
{
    private static final String BASE_NAME = "jungle_underground_petra_";

    public static final ResourceKey<LootTable> JUNGLE_UNDERGROUND_PETRA_HOUSE = createKey(BASE_NAME + "house");
    public static final ResourceKey<LootTable> JUNGLE_UNDERGROUND_PETRA_FIELD = createKey(BASE_NAME + "field");
    public static final ResourceKey<LootTable> JUNGLE_UNDERGROUND_PETRA_SMITHY = createKey(BASE_NAME + "smithy");
    public static final ResourceKey<LootTable> JUNGLE_UNDERGROUND_PETRA_MASON = createKey(BASE_NAME + "mason");


    private JungleUndergroundPetraChestLootTable()
    {
    }

    public static void jungleUnderGroundPetraChestLootTableGenerator(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builder)
    {
        builder.accept(JUNGLE_UNDERGROUND_PETRA_HOUSE, LootTable.lootTable()
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                .withPool(jungleUnderGroundPetraHouseLootTable()));
        builder.accept(JUNGLE_UNDERGROUND_PETRA_FIELD, LootTable.lootTable()
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                .withPool(jungleUnderGroundPetraFieldLootTable()));
        builder.accept(JUNGLE_UNDERGROUND_PETRA_SMITHY, LootTable.lootTable()
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                .withPool(jungleUnderGroundPetraSmithyLootTable()));
        builder.accept(JUNGLE_UNDERGROUND_PETRA_MASON, LootTable.lootTable()
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                .withPool(jungleUnderGroundPetraMasonLootTable()));
    }

    private static LootPool.Builder jungleUnderGroundPetraCommonLootTable(LootPool.Builder builder)
    {
        return builder.add(LootItem.lootTableItem(ItemRegister.MORICHE_PALM_FRUIT).setWeight(25))
                .add(LootItem.lootTableItem(ItemRegister.ACHIOTE_FRUIT).setWeight(25))
                .add(LootItem.lootTableItem(BlockRegister.MORICHE_PALM_WOOD_TYPE_MAP.get("log")).setWeight(25))
                .add(LootItem.lootTableItem(BlockRegister.ACHIOTE_WOOD_TYPE_MAP.get("log")).setWeight(25))
                .add(LootItem.lootTableItem(Items.EMERALD).setWeight(25))
                .add(LootItem.lootTableItem(Items.POTATO).setWeight(25))
                .add(LootItem.lootTableItem(Items.POISONOUS_POTATO).setWeight(10))
                ;
    }

    private static LootPool.Builder jungleUnderGroundPetraHouseLootTable()
    {
        LootPool.Builder lootPool = LootPool.lootPool();
        lootPool.setRolls(UniformGenerator.between(3, 7))
                .add(LootItem.lootTableItem(ItemRegister.LIBERTY_VILLAGER_SINGING_STONE).setWeight(5))
                .add(LootItem.lootTableItem(ItemRegister.DIGGY_VILLAGER_SINGING_STONE).setWeight(5))
                .add(LootItem.lootTableItem(ItemRegister.MADNESS_VILLAGER_SINGING_STONE).setWeight(5))
                .add(LootItem.lootTableItem(BlockRegister.MORICHE_PALM_WOOD_TYPE_MAP.get("sapling")).setWeight(25))
                .add(LootItem.lootTableItem(BlockRegister.ACHIOTE_WOOD_TYPE_MAP.get("sapling")).setWeight(25))
        ;
        lootPool = jungleUnderGroundPetraCommonLootTable(lootPool);
        return lootPool;
    }

    private static LootPool.Builder jungleUnderGroundPetraFieldLootTable()
    {
        LootPool.Builder lootPool = LootPool.lootPool();
        lootPool.setRolls(UniformGenerator.between(3, 8))
                .add(LootItem.lootTableItem(Items.BONE_MEAL).setWeight(20))
                .add(LootItem.lootTableItem(BlockRegister.JELLYSHROOM).setWeight(25))
                .add(LootItem.lootTableItem(ItemRegister.JELLY_HAT).setWeight(15))
        ;
        lootPool = jungleUnderGroundPetraCommonLootTable(lootPool);
        return lootPool;
    }

    private static LootPool.Builder jungleUnderGroundPetraSmithyLootTable()
    {
        LootPool.Builder lootPool = LootPool.lootPool();
        lootPool.setRolls(UniformGenerator.between(3, 10))
                .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(20))
                .add(LootItem.lootTableItem(Blocks.OBSIDIAN).setWeight(15))
                .add(LootItem.lootTableItem(Items.IRON_PICKAXE).setWeight(1))
        ;
        lootPool = jungleUnderGroundPetraCommonLootTable(lootPool);
        return lootPool;
    }

    private static LootPool.Builder jungleUnderGroundPetraMasonLootTable()
    {
        LootPool.Builder lootPool = LootPool.lootPool();
        lootPool.setRolls(UniformGenerator.between(3, 9))
                .add(LootItem.lootTableItem(Items.BRICK).setWeight(15))
                .add(LootItem.lootTableItem(Blocks.CLAY).setWeight(15))
                .add(LootItem.lootTableItem(Items.CLAY_BALL).setWeight(15))
        ;
        lootPool = jungleUnderGroundPetraCommonLootTable(lootPool);
        return lootPool;
    }
}
