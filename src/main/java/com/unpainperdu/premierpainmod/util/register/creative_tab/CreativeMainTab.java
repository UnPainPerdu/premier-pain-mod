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
import com.unpainperdu.premierpainmod.level.world.block.tree.FlammableBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.crop.JellyShroomBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.growingAboveVegetation.AbstractGrowingAboveVegetation;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.CactusFlowerBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.FloweredCactusBlock;
import com.unpainperdu.premierpainmod.level.world.block.tree.LogBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.twoBlockHeight.skySpears.SkySpearsFlower;
import com.unpainperdu.premierpainmod.level.world.item.items.all_materials_block.VillagerShelfItem;
import com.unpainperdu.premierpainmod.level.world.item.items.drinkable_beer_item.DrinkableBeerItem;
import com.unpainperdu.premierpainmod.util.mod_list.ModItemList;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.mod_list.ModBLockList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CreativeMainTab
{
    private CreativeMainTab(){}

    public static void generateCreativeMainTab(CreativeModeTab.ItemDisplayParameters param, CreativeModeTab.Output output)
    {
        //Items
        generateMiscItems(output);
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
        for(Block block : ModBLockList.ALL_BLOCKS)
        {
            if(block instanceof AbstractTallGrass
                    || block instanceof CactusFlowerBlock
                    || block instanceof FloweredCactusBlock
                    || block instanceof AbstractGrowingAboveVegetation
                    || block instanceof FlowerBlock
                    || block instanceof TallFlowerBlock
                    || block instanceof DeadBushBlock
                    || block instanceof SkySpearsFlower
                    || block instanceof JellyShroomBlock
            )
            {
                output.accept(block);
            }
        }
    }

    private static void generateWood(CreativeModeTab.Output output)
    {
        for (Block block : ModBLockList.ALL_BLOCKS)
        {
            String blockName = BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MOD_ID + ":", "");
            if(block instanceof LogBlock
                    ||block instanceof FlammableBlock
                    ||block instanceof LeavesBlock
            )
            {
                output.accept(block);
            }
            if (blockName.contains("mountain_currant")
                || blockName.contains("moriche_palm")
                || blockName.contains("achiote")
            )
            {
                if (block instanceof StairBlock
                        || block instanceof SlabBlock
                        || block instanceof ButtonBlock
                        || block instanceof PressurePlateBlock
                        || block instanceof FenceBlock
                        || block instanceof FenceGateBlock
                        || block instanceof DoorBlock
                        || block instanceof TrapDoorBlock
                        || block instanceof SaplingBlock
                )
                {
                    output.accept(block);
                }
            }
        }
        for (Item item : ModItemList.ALL_ITEMS)
        {
            String itemName = BuiltInRegistries.ITEM.getKey(item).toString().replace(PremierPainMod.MOD_ID + ":", "");
            if (itemName.contains("mountain_currant")
                    || itemName.contains("moriche_palm")
            )
            {
                if (item instanceof SignItem)
                {
                    output.accept(item);
                }
            }
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

    private static void generateMiscItems(CreativeModeTab.Output output)
    {
        for(Item item : ModItemList.ALL_ITEMS)
        {
            if(
                    !(item instanceof VillagerShelfItem
                            || item instanceof SignItem
                            || item instanceof BucketItem
                            || item instanceof DrinkableBeerItem
                    )
            )
            {
                output.accept(item);
            }
        }
        for(Item item : ModItemList.getAllItemsFromClass(BucketItem.class, DrinkableBeerItem.class))
        {
            output.accept(item);
        }

    }

    public static class ItemComparator implements Comparator<Item>
    {

        @Override
        public int compare(Item o1, Item o2)
        {
            String id1 = o1.toString();
            String id2 = o2.toString();

            return id1.compareTo(id2);
        }
    }
}

