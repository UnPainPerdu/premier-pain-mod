package com.unpainperdu.premierpainmod.datagen.data.loot_table;

import com.mojang.datafixers.util.Pair;
import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ModEntityLootTableSubProvider extends EntityLootSubProvider
{
    protected ModEntityLootTableSubProvider(HolderLookup.Provider provider)
    {
        super(FeatureFlags.DEFAULT_FLAGS, provider);
    }

    @Override
    protected @NotNull Stream<EntityType<?>> getKnownEntityTypes()
    {
        return BuiltInRegistries.ENTITY_TYPE.entrySet().stream()
                .filter(e -> e.getKey().location().getNamespace().equals(PremierPainMod.MOD_ID))
                .map(Map.Entry::getValue);
    }

    @Override
    public void generate()
    {
        Map<ItemLike, Integer> commonBasicItemLootMap = new LinkedHashMap<>();
        Map<ItemLike, Pair<Integer, Integer>> commonVariableNumberItemLootMap = new LinkedHashMap<>();

        commonBasicItemLootMap.put(BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get("planks"), 6);
        commonBasicItemLootMap.put(Items.STICK, 4);
        generateConstantLootTable(AllInOneEntityRegister.MOUNTAIN_CURRANT_GOLEM_ENTITY.get(), commonBasicItemLootMap);

        commonVariableNumberItemLootMap.put(Items.STRING, Pair.of(3,8));
        generateVariableLootTable(AllInOneEntityRegister.WOOL_GOLEM_ENTITY.get(), commonVariableNumberItemLootMap);

    }

    private void generateConstantLootTable(EntityType<?> entityType, Map<ItemLike, Integer> map)
    {
        LootTable.Builder lootTable = LootTable.lootTable();
        for (ItemLike itemLike : map.keySet())
        {
            LootPool.Builder lootPool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F));
            lootPool.add(LootItem.lootTableItem(itemLike).apply(SetItemCountFunction.setCount(ConstantValue.exactly(map.get(itemLike)))));
            lootTable.withPool(lootPool);
        }
        this.add(entityType, lootTable);
    }

    private void generateVariableLootTable(EntityType<?> entityType, Map<ItemLike, Pair<Integer, Integer>> map)
    {
        LootTable.Builder lootTable = LootTable.lootTable();
        for (ItemLike itemLike : map.keySet())
        {
            LootPool.Builder lootPool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F));
            lootPool.add(LootItem.lootTableItem(itemLike).apply(SetItemCountFunction.setCount(UniformGenerator.between(map.get(itemLike).getFirst(), map.get(itemLike).getSecond()))));
            lootTable.withPool(lootPool);
        }
        this.add(entityType, lootTable);
    }
}
