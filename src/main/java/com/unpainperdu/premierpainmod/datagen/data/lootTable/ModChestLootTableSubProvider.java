package com.unpainperdu.premierpainmod.datagen.data.lootTable;

import com.unpainperdu.premierpainmod.PremierPainMod;
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
    public ModChestLootTableSubProvider(HolderLookup.Provider lookupProvider)
    {
        this.registries = lookupProvider;
    }
    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> pOutput)
    {
        // LootTable.lootTable() returns a loot table builder we can add loot tables to.
        pOutput.accept(createKey("example_loot_table"), LootTable.lootTable()
                // Add a loot table-level loot function. This example uses a number provider (see below).
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(5)))
                // Add a loot pool.
                .withPool(LootPool.lootPool()
                        // Add a loot pool-level function, similar to above.
            // Set the amount of rolls and bonus rolls, respectively.
            // Both of these methods utilize a number provider.
            .setRolls(UniformGenerator.between(5, 9))
            .setBonusRolls(ConstantValue.exactly(1))
            // Add a loot entry. This example returns an item loot entry. See below for more loot entries.
            .add(LootItem.lootTableItem(Items.DIRT))
                )
        );
    }

    public static ResourceKey<LootTable> createKey(String name)
    {
        return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, name));
    }
}
