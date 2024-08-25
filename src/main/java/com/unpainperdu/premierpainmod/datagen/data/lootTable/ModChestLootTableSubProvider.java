package com.unpainperdu.premierpainmod.datagen.data.lootTable;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
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

import java.util.function.BiConsumer;

public class ModChestLootTableSubProvider implements LootTableSubProvider
{
    public HolderLookup.Provider registries;

    public static ResourceKey<LootTable> FOREST_PREMIER_PAIN_TEMPLE_CHEST = createKey("chests","premier_pain_temple"); // key not change to forest_... cause laziness
    public static ResourceKey<LootTable> SAND_DESERT_PREMIER_PAIN_TEMPLE_CHEST = createKey("chests","sand_desert_premier_pain_temple");

    public ModChestLootTableSubProvider(HolderLookup.Provider lookupProvider)
    {
        this.registries = lookupProvider;
    }
    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output)
    {
        forestPremierPainTempleChestLootTableGenerator(output);
        sandDesertPremierPainTempleChestLootTableGenerator(output);
    }

    public static ResourceKey<LootTable> createKey(String directory, String name)
    {
        return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, directory + "/"+name));
    }

    private static void forestPremierPainTempleChestLootTableGenerator(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builder)
    {
        // LootTable.lootTable() returns a loot table builder we can add loot tables to.
        builder.accept(FOREST_PREMIER_PAIN_TEMPLE_CHEST, LootTable.lootTable()
                // Add a loot table-level loot function. This example uses a number provider (see below).
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,2))) // lié au nombre d'items par slot et slot occupés
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
                        .add(LootItem.lootTableItem(BlockRegister.CIVILIZATIONS_FLOWER).setWeight(75))
                        .add(LootItem.lootTableItem(ItemRegister.LIBERTY_VILLAGER_SINGING_STONE).setWeight(25))
                        .add(LootItem.lootTableItem(ItemRegister.DIGGY_VILLAGER_SINGING_STONE).setWeight(25))
                        .add(LootItem.lootTableItem(ItemRegister.MADNESS_VILLAGER_SINGING_STONE).setWeight(25))
                        .add(LootItem.lootTableItem(Items.EMERALD).setWeight(50))
                        .add(LootItem.lootTableItem(Items.BREAD).setWeight(250))
                        .add(LootItem.lootTableItem(Items.OAK_LOG).setWeight(150))
                        .add(LootItem.lootTableItem(Items.OAK_SAPLING).setWeight(50))
                        .add(LootItem.lootTableItem(Items.STICK).setWeight(100))
                        .add(LootItem.lootTableItem(Items.APPLE).setWeight(50))
                        .add(LootItem.lootTableItem(Items.WHEAT).setWeight(100))
                        .add(LootItem.lootTableItem(Items.WHEAT_SEEDS).setWeight(100))
                )//total weight = 1000
        );
    }

    private static void sandDesertPremierPainTempleChestLootTableGenerator(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builder)
    {
        // LootTable.lootTable() returns a loot table builder we can add loot tables to.
        builder.accept(SAND_DESERT_PREMIER_PAIN_TEMPLE_CHEST, LootTable.lootTable()
                // Add a loot table-level loot function. This example uses a number provider (see below).
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,2))) // lié au nombre d'items par slot et slot occupés
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
}
