package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool;

import com.unpainperdu.premierpainmod.level.world.fluid.beer.BeerFluid;
import com.unpainperdu.premierpainmod.util.register.Item.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.ArrayList;
import java.util.List;

public class CommonLootTable
{
    private CommonLootTable()
    {
    }

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

    public static LootPool.Builder addAllBeerBottleMugGlass(LootPool.Builder lootTable, int weight)
    {
        List<ItemLike> drinks = new ArrayList<>();
        drinks.addAll(AllInOneFluidRegister.FLUIDS.values().stream().map(DeferredHolder::get).filter(fluid -> fluid instanceof BeerFluid).map(beerFluid -> (ItemLike) ((BeerFluid) beerFluid).getBottle()).toList());
        drinks.addAll(AllInOneFluidRegister.FLUIDS.values().stream().map(DeferredHolder::get).filter(fluid -> fluid instanceof BeerFluid).map(beerFluid -> (ItemLike) ((BeerFluid) beerFluid).getGlass()).toList());
        drinks.addAll(AllInOneFluidRegister.FLUIDS.values().stream().map(DeferredHolder::get).filter(fluid -> fluid instanceof BeerFluid).map(beerFluid -> (ItemLike) ((BeerFluid) beerFluid).getMug()).toList());
        drinks.forEach(d -> lootTable
                .add(LootItem.lootTableItem(d)
                        .setWeight(weight)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                ));
        return lootTable;
    }
}
