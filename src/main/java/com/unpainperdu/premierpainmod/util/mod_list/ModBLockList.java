package com.unpainperdu.premierpainmod.util.mod_list;

import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.*;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.adaptable_sit.VillagerBench;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.adaptable_sit.VillagerCouch;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height.VillagerBrazier;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height.VillagerStatue;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height.VillagerThroneChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height_with_block_entity.VillagerMusicalFridgeBlock;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.VillagerDrawer;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.villager_shelf.StandingVillagerShelf;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.villager_shelf.WallVillagerShelf;
import com.unpainperdu.premierpainmod.util.java_comparator.BlockComparator;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

import java.util.*;

public class ModBLockList
{
    private ModBLockList(){}

    public static final List<Block> ALL_BLOCKS = generateAllBlocksList();

    private static List<Block> generateAllBlocksList()
    {
        Object[] allBlocksRegistered = BuiltInRegistries.BLOCK.stream().toArray();

        List<Block> allBlocks = new ArrayList<>();

        for (Object obj : allBlocksRegistered)
        {
            if (obj instanceof Block block)
            {
                if (BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals("premierpainmod"))
                {
                    allBlocks.add(block);
                }
            }
        }

        allBlocks.sort(new BlockComparator());
        return allBlocks;
    }

    /***
     *
     * @return AllMaterialsblocks in world
     */
    public static List<Block> getAllMaterialsBlocks()
    {
        return getAllBlocksFromClass(
                VillagerStatue.class,
                VillagerPedestalBlock.class,
                VillagerBrazier.class,
                VillagerTableBlock.class,
                VillagerChairBlock.class,
                VillagerThroneChairBlock.class,
                VillagerDrawer.class,
                StandingVillagerShelf.class,
                WallVillagerShelf.class,
                VillagerBench.class,
                VillagerCouch.class,
                VillagerBrewingStation.class,
                VillagerMusicalFridgeBlock.class,
                VillagerChiseledHead.class
        );
    }

    public static List<Block> getAllBlocksFromClass(Class<?>... cList)
    {
        List<Block> list = new ArrayList<>();
        for (Block block : ALL_BLOCKS)
        {
            for (Class<?> c : cList)
            {
                if (c.isInstance(block))
                {
                    list.add(block);
                }
            }

        }
        return list;
    }
}

