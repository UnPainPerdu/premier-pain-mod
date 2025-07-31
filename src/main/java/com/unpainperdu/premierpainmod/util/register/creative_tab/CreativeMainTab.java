package com.unpainperdu.premierpainmod.util.register.creative_tab;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractTallGrass;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.*;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.adaptable_sit.VillagerBench;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.adaptable_sit.VillagerCouch;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height.VillagerBrazier;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height.VillagerStatue;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height.VillagerThroneChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height_with_block_entity.VillagerMusicalFridgeBlock;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.VillagerDrawer;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.crop.JellyShroomBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.growing_above_vegetation.AbstractGrowingAboveVegetation;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.special_vegetation.CactusFloweredBlock.CactusFlowerBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.special_vegetation.CactusFloweredBlock.FloweredCactusBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.two_block_height.sky_spears.SkySpearsFlower;
import com.unpainperdu.premierpainmod.level.world.item.items.all_materials_block.VillagerShelfItem;
import com.unpainperdu.premierpainmod.level.world.item.items.drinkable_beer_item.DrinkableBeerItem;
import com.unpainperdu.premierpainmod.util.java_comparator.ItemComparator;
import com.unpainperdu.premierpainmod.util.mod_list.ModBLockList;
import com.unpainperdu.premierpainmod.util.mod_list.ModItemList;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DeadBushBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CreativeMainTab
{
    private CreativeMainTab()
    {
    }

    public static void generateCreativeMainTab(CreativeModeTab.ItemDisplayParameters param, CreativeModeTab.Output output)
    {
        //Items
        generateMiscItems(output);
        //fluid
        generateBucket(output);
        //food
        generateFood(output);
        //beer
        generateBeerItems(output);
        //vegetation
        generateVegetation(output);
        //wood and tree
        generateWood(output);
        //crafting machine
        output.accept(BlockRegister.VILLAGER_WORKSHOP.get());
        output.accept(BlockRegister.COOKING_POT_BLOCK.get());
        //all materials
        generateAllMaterials(output);

    }

    private static void generateVegetation(CreativeModeTab.Output output)
    {
        List<List<Block>> orderedByListVegetation = new ArrayList<>();
        for (int i = 0; i < 9; i++)
        {
            orderedByListVegetation.add(new ArrayList<>());
        }
        for (Block block : ModBLockList.ALL_BLOCKS)
        {
            switch (block)
            {
                case AbstractTallGrass ignored -> orderedByListVegetation.get(0).add(block);
                case CactusFlowerBlock ignored -> orderedByListVegetation.get(1).add(block);
                case FloweredCactusBlock ignored -> orderedByListVegetation.get(2).add(block);
                case AbstractGrowingAboveVegetation ignored -> orderedByListVegetation.get(3).add(block);
                case FlowerBlock ignored -> orderedByListVegetation.get(4).add(block);
                case TallFlowerBlock ignored -> orderedByListVegetation.get(5).add(block);
                case DeadBushBlock ignored -> orderedByListVegetation.get(6).add(block);
                case SkySpearsFlower ignored -> orderedByListVegetation.get(7).add(block);
                case JellyShroomBlock ignored -> orderedByListVegetation.get(8).add(block);
                default ->
                {/*nothing to do*/}
            }
            for (List<Block> lb : orderedByListVegetation)
            {
                for (Block b : lb)
                {
                    output.accept(b);
                }
            }
        }
    }

    private static void generateWood(CreativeModeTab.Output output)
    {
        generateWood(output, BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP);
        generateWood(output, BlockRegister.MORICHE_PALM_WOOD_TYPE_MAP);
        generateWood(output, BlockRegister.ACHIOTE_WOOD_TYPE_MAP);
        generateWood(output, BlockRegister.WEEPING_WILLOW_WOOD_TYPE_MAP, BlockRegister.FALLING_WEEPING_WILLOW_LEAVES);
    }

    private static void generateWood(CreativeModeTab.Output output, Map<String, DeferredBlock<Block>> woodType, ItemLike... extra)
    {
        for (DeferredBlock<Block> block : woodType.values())
        {
            if (!block.asItem().getDefaultInstance().isEmpty())
            {
                output.accept(block);
            }
        }
        for (ItemLike item : extra)
        {
            output.accept(item);
        }

    }

    private static void generateAllMaterials(CreativeModeTab.Output output)
    {
        List<Item> itemList = new ArrayList<>();
        for (Block block : ModBLockList.ALL_BLOCKS)
        {
            if (block instanceof VillagerStatue
                    || block instanceof VillagerPedestalBlock
                    || block instanceof VillagerBrazier
                    || block instanceof VillagerTableBlock
                    || block instanceof VillagerChairBlock
                    || block instanceof VillagerThroneChairBlock
                    || block instanceof VillagerDrawer
                    || block instanceof VillagerBench
                    || block instanceof VillagerCouch
                    || block instanceof VillagerBrewingStation
                    || block instanceof VillagerMusicalFridgeBlock
                    || block instanceof VillagerChiseledHead
            )
            {
                itemList.add(block.asItem());
            }
        }

        for (Item item : ModItemList.ALL_ITEMS)
        {
            if (item instanceof VillagerShelfItem)
            {
                itemList.add(item);
            }
        }

        itemList.sort(new ItemComparator());
        for (Item item : itemList)
        {
            output.accept(item);
        }
    }

    private static void generateBeerItems(CreativeModeTab.Output output)
    {
        output.accept(ItemRegister.EMPTY_BOTTLE.get());
        output.accept(ItemRegister.EMPTY_GLASS.get());
        output.accept(ItemRegister.EMPTY_MUG.get());
        for (Item item : ModItemList.ALL_ITEMS)
        {
            if (
                    item instanceof DrinkableBeerItem
            )
            {
                output.accept(item);
            }
        }

    }

    private static void generateFood(CreativeModeTab.Output output)
    {
        for (Item item : ModItemList.ALL_ITEMS)
        {
            if (
                    !(item instanceof DrinkableBeerItem)
                            && item.getDefaultInstance().has(DataComponents.FOOD)
            )
            {
                output.accept(item);
            }
        }
    }

    private static void generateBucket(CreativeModeTab.Output output)
    {
        for (Item item : ModItemList.ALL_ITEMS)
        {
            if (item instanceof BucketItem)
            {
                output.accept(item);
            }
        }
    }

    private static void generateMiscItems(CreativeModeTab.Output output)
    {
        for (Item item : ModItemList.ALL_ITEMS)
        {
            if (
                    !(
                            item instanceof VillagerShelfItem
                                    || item instanceof SignItem
                                    || item instanceof BucketItem
                                    || item instanceof BoatItem
                                    || item == ItemRegister.EMPTY_BOTTLE.get()
                                    || item == ItemRegister.EMPTY_GLASS.get()
                                    || item == ItemRegister.EMPTY_MUG.get()
                                    || item.getDefaultInstance().has(DataComponents.FOOD)
                    )
            )
            {
                if (Block.byItem(item).defaultBlockState().isAir())
                {
                    output.accept(item);
                }
            }
        }
    }
}

