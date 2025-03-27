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
import com.unpainperdu.premierpainmod.level.world.block.vegetation.growingAboveVegetation.AbstractGrowingAboveVegetation;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.CactusFlowerBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.FloweredCactusBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.twoBlockHeight.skySpears.SkySpearsFlower;
import com.unpainperdu.premierpainmod.level.world.item.items.all_materials_block.VillagerShelfItem;
import com.unpainperdu.premierpainmod.level.world.item.items.drinkable_beer_item.DrinkableBeerItem;
import com.unpainperdu.premierpainmod.util.java_comparator.ItemComparator;
import com.unpainperdu.premierpainmod.util.mod_list.ModItemList;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.mod_list.ModBLockList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreativeMainTab
{
    private CreativeMainTab(){}

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
        //all materials
        output.accept(BlockRegister.VILLAGER_WORKSHOP.get());
        generateAllMaterials(output);

    }

    private static void generateVegetation(CreativeModeTab.Output output)
    {
        List<List<Block>> orderedByListVegetation = new ArrayList<>();
        for (int i = 0; i < 9; i++)
        {
            orderedByListVegetation.add(new ArrayList<>());
        }
        for(Block block : ModBLockList.ALL_BLOCKS)
        {
            switch (block)
            {
                case AbstractTallGrass t -> orderedByListVegetation.get(0).add(block);
                case CactusFlowerBlock t -> orderedByListVegetation.get(1).add(block);
                case FloweredCactusBlock t -> orderedByListVegetation.get(2).add(block);
                case AbstractGrowingAboveVegetation t -> orderedByListVegetation.get(3).add(block);
                case FlowerBlock t -> orderedByListVegetation.get(4).add(block);
                case TallFlowerBlock t -> orderedByListVegetation.get(5).add(block);
                case DeadBushBlock t -> orderedByListVegetation.get(6).add(block);
                case SkySpearsFlower t -> orderedByListVegetation.get(7).add(block);
                case JellyShroomBlock t -> orderedByListVegetation.get(8).add(block);
                default -> {/*nothing to do*/}
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
        List<String> woods = Arrays.asList(
                "mountain_currant", "moriche_palm", "achiote"
        );

        for (String wood : woods)
        {
            output.accept(getItemFromId(wood + "_log"));
            output.accept(getItemFromId(wood + "_wood"));
            output.accept(getItemFromId("stripped_" + wood + "_log"));
            output.accept(getItemFromId("stripped_" + wood + "_wood"));
            output.accept(getItemFromId(wood + "_planks"));
            output.accept(getItemFromId(wood + "_stairs"));
            output.accept(getItemFromId(wood + "_slab"));
            output.accept(getItemFromId(wood + "_fence"));
            output.accept(getItemFromId(wood + "_fence_gate"));
            output.accept(getItemFromId(wood + "_door"));
            output.accept(getItemFromId(wood + "_trapdoor"));
            output.accept(getItemFromId(wood + "_pressure_plate"));
            output.accept(getItemFromId(wood + "_button"));
            output.accept(getItemFromId(wood + "_sign"));
            output.accept(getItemFromId(wood + "_hanging_sign"));
            output.accept(getItemFromId(wood + "_leaves"));
            output.accept(getItemFromId(wood + "_sapling"));
            output.accept(getItemFromId(wood + "_boat"));
            output.accept(getItemFromId(wood + "_chest_boat"));
        }

    }

    private static void generateAllMaterials(CreativeModeTab.Output output)
    {
        List<Item> itemList = new ArrayList<>();
        for(Block block : ModBLockList.ALL_BLOCKS)
        {
            if(block instanceof VillagerStatue
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

        for(Item item : ModItemList.ALL_ITEMS)
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
        for(Item item : ModItemList.ALL_ITEMS)
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
        for(Item item : ModItemList.ALL_ITEMS)
        {
            if (item instanceof BucketItem)
            {
                output.accept(item);
            }
        }
    }

    private static void generateMiscItems(CreativeModeTab.Output output)
    {
        for(Item item : ModItemList.ALL_ITEMS)
        {
            if(
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

    private static Item getItemFromId(String path)
    {
        return getItemFromId(PremierPainMod.MOD_ID, path);
    }

    private static Item getItemFromId(String nameSpace, String path)
    {
        return BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(nameSpace, path));
    }
}

