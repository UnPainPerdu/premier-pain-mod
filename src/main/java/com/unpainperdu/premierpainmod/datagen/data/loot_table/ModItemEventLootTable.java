package com.unpainperdu.premierpainmod.datagen.data.loot_table;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.datagen.data.loot_table.abstract_provider.ItemEventLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class ModItemEventLootTable extends ItemEventLootSubProvider
{
    public static final ResourceKey<LootTable> LIBERTY_ITEM_EVENT = createKey(PremierPainMod.MOD_ID, "liberty");

    protected ModItemEventLootTable(HolderLookup.Provider registries)
    {
        super(registries);
    }

    @Override
    public void generate(@NotNull BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output)
    {
        libertyItemEvent(output);
    }

    private static void libertyItemEvent(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builder)
    {
        builder.accept(LIBERTY_ITEM_EVENT, LootTable.lootTable()
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(Items.NETHERITE_BLOCK).setWeight(1))
                        .add(LootItem.lootTableItem(Items.EMERALD).setWeight(999))
                ));
    }
}
