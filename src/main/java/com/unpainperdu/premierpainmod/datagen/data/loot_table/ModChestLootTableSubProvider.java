package com.unpainperdu.premierpainmod.datagen.data.loot_table;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.templatepool.CommonLootTable;
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
    public static final ResourceKey<LootTable> OLD_GREAT_FIELD_FOOD_CHEST = createKey("old_great_field/food");

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
                        CommonLootTable.addVillagerSingingStone(LootPool.lootPool(), 1)
                                .setRolls(UniformGenerator.between(4, 8))
                                .setBonusRolls(ConstantValue.exactly(0))
                                .add(LootItem.lootTableItem(BlockRegister.CIVILIZATIONS_FLOWER)
                                        .setWeight(3)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6)))
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
        builder.accept(SAND_DESERT_PREMIER_PAIN_TEMPLE_CHEST, LootTable.lootTable()
                .withPool(
                        CommonLootTable.addVillagerSingingStone(LootPool.lootPool(), 1)
                                .setRolls(UniformGenerator.between(4, 8))
                                .setBonusRolls(ConstantValue.exactly(0))
                                .add(LootItem.lootTableItem(BlockRegister.DEAD_RUINS_FLOWER)
                                        .setWeight(3)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6)))
                                )
                                .add(LootItem.lootTableItem(Items.EMERALD)
                                        .setWeight(2)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6)))
                                )
                                .add(LootItem.lootTableItem(Items.BREAD)
                                        .setWeight(5)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5)))
                                )
                                .add(LootItem.lootTableItem(Items.IRON_INGOT)
                                        .setWeight(3)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 7)))
                                )
                                .add(LootItem.lootTableItem(Items.DEAD_BUSH)
                                        .setWeight(4)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 9)))
                                )
                                .add(LootItem.lootTableItem(Items.STICK)
                                        .setWeight(4)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 8)))
                                )
                                .add(LootItem.lootTableItem(Items.COPPER_INGOT)
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

    private static void swampPremierPainTempleChestLootTableGenerator(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builder)
    {
        builder.accept(SWAMP_PREMIER_PAIN_TEMPLE_CHEST, LootTable.lootTable()
                .withPool(
                        CommonLootTable.addVillagerSingingStone(LootPool.lootPool(), 1)
                                .setRolls(UniformGenerator.between(4, 8))
                                .setBonusRolls(ConstantValue.exactly(0))
                                .add(LootItem.lootTableItem(Items.MANGROVE_PROPAGULE)
                                        .setWeight(3)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6)))
                                )
                                .add(LootItem.lootTableItem(Items.EMERALD)
                                        .setWeight(2)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6)))
                                )
                                .add(LootItem.lootTableItem(Items.BREAD)
                                        .setWeight(5)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5)))
                                )
                                .add(LootItem.lootTableItem(Items.IRON_INGOT)
                                        .setWeight(6)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4)))
                                )
                                .add(LootItem.lootTableItem(Items.POTATO)
                                        .setWeight(4)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 9)))
                                )
                                .add(LootItem.lootTableItem(Items.STICK)
                                        .setWeight(2)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 11)))
                                )
                                .add(LootItem.lootTableItem(Items.ARROW)
                                        .setWeight(2)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6)))
                                )
                                .add(LootItem.lootTableItem(Items.CARROT)
                                        .setWeight(4)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 7)))
                                )
                                .add(LootItem.lootTableItem(Items.POISONOUS_POTATO)
                                        .setWeight(4)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 3)))
                                )
                )
        );
    }

    private static void oldGreatFieldFoodChestLootTableGenerator(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> builder)
    {
        builder.accept(OLD_GREAT_FIELD_FOOD_CHEST, LootTable.lootTable()
                .withPool(
                        CommonLootTable.addVillagerSingingStone(LootPool.lootPool(), 1)
                                .setRolls(UniformGenerator.between(4, 8))
                                .setBonusRolls(ConstantValue.exactly(0))
                                .add(LootItem.lootTableItem(ItemRegister.MOUNTAIN_CURRANT)
                                        .setWeight(3)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6)))
                                )
                                .add(LootItem.lootTableItem(BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get("log"))
                                        .setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4)))
                                )
                                .add(LootItem.lootTableItem(BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get("sapling"))
                                        .setWeight(3)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                                )
                                .add(LootItem.lootTableItem(ItemRegister.FRUITS_BOWL)
                                        .setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                                )
                                .add(LootItem.lootTableItem(ItemRegister.POTATOES_AND_SPEARS_BOWL)
                                        .setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                                )
                                .add(LootItem.lootTableItem(Items.EMERALD)
                                        .setWeight(2)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6)))
                                )
                                .add(LootItem.lootTableItem(Items.BREAD)
                                        .setWeight(5)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6)))
                                )
                                .add(LootItem.lootTableItem(Items.APPLE)
                                        .setWeight(3)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                                )
                                .add(LootItem.lootTableItem(Items.POTATO)
                                        .setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 6)))
                                )
                                .add(LootItem.lootTableItem(Items.STICK)
                                        .setWeight(4)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 11)))
                                )
                                .add(LootItem.lootTableItem(Items.CARROT)
                                        .setWeight(2)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 7)))
                                )
                                .add(LootItem.lootTableItem(Items.POTATO)
                                        .setWeight(4)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                                )
                )
        );
    }
}
