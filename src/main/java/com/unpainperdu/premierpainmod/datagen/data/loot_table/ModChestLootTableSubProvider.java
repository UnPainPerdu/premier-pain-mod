package com.unpainperdu.premierpainmod.datagen.data.loot_table;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.Item.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

import static com.unpainperdu.premierpainmod.datagen.data.loot_table.chest.JungleUndergroundPetraChestLootTable.jungleUnderGroundPetraChestLootTableGenerator;

public class ModChestLootTableSubProvider implements LootTableSubProvider
{
    public final HolderLookup.Provider registries;

    public static final String CHEST_DIRECTORY = "chests";

    public static final ResourceKey<LootTable> FOREST_PREMIER_PAIN_TEMPLE_CHEST = createKey("premier_pain_temple/forest");
    public static final ResourceKey<LootTable> SAND_DESERT_PREMIER_PAIN_TEMPLE_CHEST = createKey("premier_pain_temple/sand_desert");
    public static final ResourceKey<LootTable> SWAMP_PREMIER_PAIN_TEMPLE_CHEST = createKey("premier_pain_temple/swamp");
    public static final ResourceKey<LootTable> OLD_GREAT_FIELD_FOOD_CHEST = createKey("old_great_field_food");

    //see https://fr.minecraft.wiki/w/Table_de_butin (in french)
    public ModChestLootTableSubProvider(HolderLookup.Provider lookupProvider)
    {
        this.registries = lookupProvider;
    }

    @Override
    public void generate(@NotNull BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output)
    {
        forestPremierPainTempleChestLootTableGenerator(output);
        sandDesertPremierPainTempleChestLootTableGenerator(output);
        swampPremierPainTempleChestLootTableGenerator(output);
        oldGreatFieldFoodChestLootTableGenerator(output);
        jungleUnderGroundPetraChestLootTableGenerator(output);
    }

    public static ResourceKey<LootTable> createKey(String name)
    {
        return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, CHEST_DIRECTORY + "/" + name));
    }

    private static void forestPremierPainTempleChestLootTableGenerator(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builder)
    {
        //vanilla way
        builder.accept(FOREST_PREMIER_PAIN_TEMPLE_CHEST, LootTable.lootTable()
                .withPool(
                        LootPool.lootPool()
                                .setRolls(UniformGenerator.between(4, 8))
                                .setBonusRolls(ConstantValue.exactly(0))
                                .add(LootItem.lootTableItem(BlockRegister.CIVILIZATIONS_FLOWER)
                                        .setWeight(3)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6)))
                                )
                                .add(LootItem.lootTableItem(ItemRegister.LIBERTY_VILLAGER_SINGING_STONE)
                                        .setWeight(1)
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                                )
                                .add(LootItem.lootTableItem(ItemRegister.DIGGY_VILLAGER_SINGING_STONE)
                                        .setWeight(1)
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                                )
                                .add(LootItem.lootTableItem(ItemRegister.MADNESS_VILLAGER_SINGING_STONE)
                                        .setWeight(1)
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                                )
                                .add(LootItem.lootTableItem(Items.EMERALD)
                                        .setWeight(2)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6)))
                                )
                                .add(LootItem.lootTableItem(Items.BREAD)
                                        .setWeight(10)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5)))
                                )
                                .add(LootItem.lootTableItem(Items.OAK_LOG)
                                        .setWeight(6)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                                )
                                .add(LootItem.lootTableItem(Items.OAK_SAPLING)
                                        .setWeight(2)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5)))
                                )
                                .add(LootItem.lootTableItem(Items.STICK)
                                        .setWeight(4)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 8)))
                                )
                                .add(LootItem.lootTableItem(Items.APPLE)
                                        .setWeight(2)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4)))
                                )
                                .add(LootItem.lootTableItem(Items.WHEAT)
                                        .setWeight(4)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                                )
                                .add(LootItem.lootTableItem(Items.WHEAT_SEEDS)
                                        .setWeight(4)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 12)))
                                )
                )
        );
    }

    private static void sandDesertPremierPainTempleChestLootTableGenerator(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builder)
    {
        // LootTable.lootTable() returns a loot table builder we can add loot tables to.
        builder.accept(SAND_DESERT_PREMIER_PAIN_TEMPLE_CHEST, LootTable.lootTable()
                // Add a loot table-level loot function. This example uses a number provider (see below).
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))) // lié au nombre d'items par slot et slot occupés
                // Add a loot pool.
                .withPool(LootPool.lootPool()
                        // Add a loot pool-level function, similar to above.
                        // Set the amount of rolls and bonus rolls, respectively.
                        // Both of these methods utilize a number provider.
                        .setRolls(UniformGenerator.between(8, 15)) // lié aussi au nombre d'items par slot et slot occupés
                        .setBonusRolls(ConstantValue.exactly(0))
                        // .add(LootItem.lootTableItem(ItemLikes).setWeight(int nullable).setQuality(int nullable))
                        // weight -> weight / (tous les weight) chances de spawn
                        // quality -> extra weight si potion luck
                        .add(LootItem.lootTableItem(BlockRegister.DEAD_RUINS_FLOWER).setWeight(75))
                        .add(LootItem.lootTableItem(ItemRegister.LIBERTY_VILLAGER_SINGING_STONE).setWeight(25))
                        .add(LootItem.lootTableItem(ItemRegister.DIGGY_VILLAGER_SINGING_STONE).setWeight(25))
                        .add(LootItem.lootTableItem(ItemRegister.MADNESS_VILLAGER_SINGING_STONE).setWeight(25))
                        .add(LootItem.lootTableItem(Items.EMERALD).setWeight(50))
                        .add(LootItem.lootTableItem(Items.BREAD).setWeight(250))
                        .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(150))
                        .add(LootItem.lootTableItem(Items.DEAD_BUSH).setWeight(50))
                        .add(LootItem.lootTableItem(Items.STICK).setWeight(100))
                        .add(LootItem.lootTableItem(Items.COPPER_INGOT).setWeight(50))
                        .add(LootItem.lootTableItem(Items.WHEAT).setWeight(100))
                        .add(LootItem.lootTableItem(Items.WHEAT_SEEDS).setWeight(100))
                )//total weight = 1000
        );
    }

    private static void swampPremierPainTempleChestLootTableGenerator(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builder)
    {
        builder.accept(SWAMP_PREMIER_PAIN_TEMPLE_CHEST, LootTable.lootTable()
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(8, 15))
                        .setBonusRolls(ConstantValue.exactly(0))
                        .add(LootItem.lootTableItem(Items.MANGROVE_PROPAGULE).setWeight(75))
                        .add(LootItem.lootTableItem(ItemRegister.LIBERTY_VILLAGER_SINGING_STONE).setWeight(25))
                        .add(LootItem.lootTableItem(ItemRegister.DIGGY_VILLAGER_SINGING_STONE).setWeight(25))
                        .add(LootItem.lootTableItem(ItemRegister.MADNESS_VILLAGER_SINGING_STONE).setWeight(25))
                        .add(LootItem.lootTableItem(Items.EMERALD).setWeight(50))
                        .add(LootItem.lootTableItem(Items.BREAD).setWeight(250))
                        .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(150))
                        .add(LootItem.lootTableItem(Items.POTATO).setWeight(50))
                        .add(LootItem.lootTableItem(Items.STICK).setWeight(100))
                        .add(LootItem.lootTableItem(Items.ARROW).setWeight(50))
                        .add(LootItem.lootTableItem(Items.CARROT).setWeight(100))
                        .add(LootItem.lootTableItem(Items.POISONOUS_POTATO).setWeight(100))
                )//total weight = 1000
        );
    }

    private static void oldGreatFieldFoodChestLootTableGenerator(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builder)
    {
        builder.accept(OLD_GREAT_FIELD_FOOD_CHEST, LootTable.lootTable()
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(8, 15))
                        .setBonusRolls(ConstantValue.exactly(0))
                        .add(LootItem.lootTableItem(ItemRegister.MOUNTAIN_CURRANT).setWeight(75))
                        .add(LootItem.lootTableItem(BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get("log")).setWeight(25))
                        .add(LootItem.lootTableItem(BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get("sapling")).setWeight(25))
                        .add(LootItem.lootTableItem(ItemRegister.FRUITS_BOWL).setWeight(25))
                        .add(LootItem.lootTableItem(ItemRegister.POTATOES_AND_SPEARS_BOWL).setWeight(25))
                        .add(LootItem.lootTableItem(Items.EMERALD).setWeight(50))
                        .add(LootItem.lootTableItem(Items.BREAD).setWeight(250))
                        .add(LootItem.lootTableItem(Items.APPLE).setWeight(150))
                        .add(LootItem.lootTableItem(Items.POTATO).setWeight(50))
                        .add(LootItem.lootTableItem(Items.STICK).setWeight(100))
                        .add(LootItem.lootTableItem(Items.CARROT).setWeight(100))
                        .add(LootItem.lootTableItem(Items.POISONOUS_POTATO).setWeight(100))
                )//total weight = 1000
        );
    }
}
