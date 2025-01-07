package com.unpainperdu.premierpainmod.util.register.creativeTab;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.abstractBlock.AbstractTallGrass;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.AdaptableSit.VillagerBench;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.AdaptableSit.VillagerCouch;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerPedestalBlock;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerTableBlock;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockHeight.VillagerBrazier;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockHeight.VillagerStatue;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockHeight.VillagerThroneChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockWidthWithBlockEntity.VillagerDrawer;
import com.unpainperdu.premierpainmod.level.world.block.tree.FlammableBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.crop.JellyShroomBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.growingAboveVegetation.AbstractGrowingAboveVegetation;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.CactusFlowerBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.FloweredCactusBlock;
import com.unpainperdu.premierpainmod.level.world.block.tree.LogBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.twoBlockHeight.skySpears.SkySpearsFlower;
import com.unpainperdu.premierpainmod.level.world.item.items.allMaterialsBlock.VillagerShelfItem;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.ModList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CreativeMainTab
{
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
        for(DeferredBlock<Block> deferredBlock : ModList.ALL_BLOCKS)
        {
            Block block = deferredBlock.get();
            if(block instanceof AbstractTallGrass
                    || block instanceof CactusFlowerBlock
                    || block instanceof FloweredCactusBlock
                    || block instanceof AbstractGrowingAboveVegetation
                    || block instanceof FlowerBlock
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
        for (DeferredBlock<Block> deferredBlock : ModList.ALL_BLOCKS)
        {
            Block block = deferredBlock.get();
            String blockName = BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MOD_ID + ":", "");
            if(block instanceof LogBlock
                    ||block instanceof FlammableBlock
                    ||block instanceof LeavesBlock
            )
            {
                output.accept(block);
            }
            if (blockName.contains("mountain_currant"))
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
        for (DeferredItem<Item> deferredItem : ModList.ALL_ITEMS)
        {
            Item item = deferredItem.get();
            String itemName = BuiltInRegistries.ITEM.getKey(item).toString().replace(PremierPainMod.MOD_ID + ":", "");
            if (itemName.contains("mountain_currant"))
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
        for(DeferredBlock<Block> deferredBlock : ModList.ALL_BLOCKS)
        {
            Block block = deferredBlock.get();
            if(block instanceof VillagerStatue
                    || block instanceof VillagerPedestalBlock
                    || block instanceof VillagerBrazier
                    || block instanceof VillagerTableBlock
                    || block instanceof VillagerChairBlock
                    || block instanceof VillagerThroneChairBlock
                    || block instanceof VillagerDrawer
                    || block instanceof VillagerBench
                    || block instanceof VillagerCouch
            )
            {
                itemList.add(block.asItem());
            }
        }

        for(DeferredItem<Item> deferredItem : ModList.ALL_ITEMS)
        {
            Item item = deferredItem.get();
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
        for(DeferredItem<Item> deferredItem : ModList.ALL_ITEMS)
        {
            Item item = deferredItem.get();
            if(
                    !(item instanceof VillagerShelfItem
                            || item instanceof SignItem
                    )
            )
            {
                output.accept(item);
            }
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

