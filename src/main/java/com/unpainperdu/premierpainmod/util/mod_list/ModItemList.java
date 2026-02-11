package com.unpainperdu.premierpainmod.util.mod_list;

import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.villager_shelf.VillagerShelf;
import com.unpainperdu.premierpainmod.level.world.item.items.all_materials_block.VillagerShelfItem;
import com.unpainperdu.premierpainmod.util.java_comparator.ItemComparator;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ModItemList
{

    /**
     * Little reminder that's ALL items, so item from blocks included
     **/
    public static List<Item> ALL_ITEMS = generateAllItemsList();

    private static List<Item> generateAllItemsList()
    {
        Object[] allBlocksRegistered = BuiltInRegistries.ITEM.stream().toArray();

        List<Item> allItems = new ArrayList<>();

        for (Object obj : allBlocksRegistered)
        {
            if (obj instanceof Item item)
            {
                if (BuiltInRegistries.ITEM.getKey(item).getNamespace().equals("premierpainmod"))
                {
                    allItems.add(item);
                }
            }
        }

        allItems.sort(new ItemComparator());

        return allItems;
    }

    /***
     * @return AllMaterialsblocks items in inventory
     */
    public static List<Item> getAllMaterialsBlocksAsItem()
    {
        List<Item> list = new ArrayList<>(ModBLockList.getAllMaterialsBlocks().stream()
                .filter(block -> !(block instanceof VillagerShelf))
                .map(Block::asItem)
                .filter(item -> item != Items.AIR)
                .toList());

        for (Item item : ALL_ITEMS)
        {
            if (item instanceof VillagerShelfItem)
            {
                list.add(item);
            }
        }
        return list;
    }

    public static List<Item> getAllItemsFromClass(Class<?>... cList)
    {
        List<Item> list = new ArrayList<>();
        for (Item item : ALL_ITEMS)
        {
            for (Class<?> c : cList)
            {
                if (c.isInstance(item))
                {
                    list.add(item);
                }
            }

        }
        return list;
    }
}
