package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool;

import com.unpainperdu.premierpainmod.util.register.Item.ItemRegister;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class CommonLootTable
{
    private CommonLootTable(){}

    public static LootPool.Builder addVillagerSingingStone(LootPool.Builder lootTable, int weight)
    {
        return lootTable
                .add(LootItem.lootTableItem(ItemRegister.LIBERTY_VILLAGER_SINGING_STONE)
                        .setWeight(weight)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                )
                .add(LootItem.lootTableItem(ItemRegister.DIGGY_VILLAGER_SINGING_STONE)
                        .setWeight(weight)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                )
                .add(LootItem.lootTableItem(ItemRegister.MADNESS_VILLAGER_SINGING_STONE)
                        .setWeight(weight)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                );
    }
}
