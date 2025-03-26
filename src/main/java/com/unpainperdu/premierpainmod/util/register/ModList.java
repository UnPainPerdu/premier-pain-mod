package com.unpainperdu.premierpainmod.util.register;

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
import com.unpainperdu.premierpainmod.level.world.item.items.all_materials_block.VillagerShelfItem;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.*;

public class ModList
{
    private ModList(){}

    public static final List<DeferredBlock<Block>> ALL_BLOCKS = generateAllBlocksList();

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
        for (DeferredBlock<Block> deferredBlock : ALL_BLOCKS)
        {
            for (Class<?> c : cList)
            {
                Block block = deferredBlock.get();
                if (c.isInstance(block))
                {
                    list.add(block);
                }
            }

        }
        return list;
    }

    public static List<DeferredItem<Item>> ALL_ITEMS = generateAllItemsList();

    /***
     * @return AllMaterialsblocks items in inventory
     */
    public static List<Item> getAllMaterialsBlocksAsItem()
    {
        List<Item> list = new ArrayList<>();
        for (Block block : getAllMaterialsBlocks())
        {

            if (!(block instanceof WallVillagerShelf)
                    && !(block instanceof StandingVillagerShelf)
            )
            {
                list.add(block.asItem());
            }
        }

        for (DeferredItem<Item> deferredItem : ALL_ITEMS)
        {
            Item item = deferredItem.get();
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
        for (DeferredItem<Item> deferredBlock : ALL_ITEMS)
        {
            for (Class<?> c : cList)
            {
                Item item = deferredBlock.get();
                if (c.isInstance(item))
                {
                    list.add(item);
                }
            }

        }
        return list;
    }

    private static List<DeferredBlock<Block>> generateAllBlocksList()
    {
        List<DeferredBlock<Block>> allBlocks = Arrays.asList(
                //liquid
                    //beer
                BlockRegister.PAIN_DIEUX,
                BlockRegister.LA_CHATEAU,
                BlockRegister.DEBIER,
                BlockRegister.ENVAHISSEUR_ROUGE,
                BlockRegister.RASPBUISSON,
                BlockRegister.LA_BLANCHE_CITADINE,
                BlockRegister.CRANE_NOIR,
                BlockRegister.TAK,
                BlockRegister.DISENDER,
                //workshop
                BlockRegister.VILLAGER_WORKSHOP,

                //flower and pot
                BlockRegister.RUINS_FLOWER,
                BlockRegister.POTTED_RUINS_FLOWER,
                BlockRegister.CIVILIZATIONS_FLOWER,
                BlockRegister.POTTED_CIVILIZATIONS_FLOWER,
                BlockRegister.CURIOSITY_FLOWER,
                BlockRegister.POTTED_CURIOSITY_FLOWER,
                //tall block
                BlockRegister.HELICON_FLOWER,
                //dead bush and pot
                BlockRegister.DEAD_RUINS_FLOWER,
                BlockRegister.POTTED_DEAD_RUINS_FLOWER,
                //vegetation
                //crop
                BlockRegister.JELLYSHROOM,
                BlockRegister.POTTED_JELLYSHROOM,
                //potted crop

                //misc
                BlockRegister.FLOWERED_CACTUS_BLOCK,
                BlockRegister.CACTUS_FLOWER_BLOCK,
                BlockRegister.SKY_SPEARS,
                BlockRegister.SKY_SPEARS_FLOWER,
                BlockRegister.POTTED_SKY_SPEARS_FLOWER,
                BlockRegister.DEAD_TALL_BUSH,
                BlockRegister.OLD_WILD_WHEAT,
                //tree
                    //mountain_currant
                BlockRegister.MOUNTAIN_CURRANT_LOG,
                BlockRegister.STRIPPED_MOUNTAIN_CURRANT_LOG,
                BlockRegister.MOUNTAIN_CURRANT_WOOD,
                BlockRegister.STRIPPED_MOUNTAIN_CURRANT_WOOD,
                BlockRegister.MOUNTAIN_CURRANT_PLANKS,
                BlockRegister.MOUNTAIN_CURRANT_LEAVES,
                BlockRegister.MOUNTAIN_CURRANT_STAIRS,
                BlockRegister.MOUNTAIN_CURRANT_SLAB,
                BlockRegister.MOUNTAIN_CURRANT_BUTTON,
                BlockRegister.MOUNTAIN_CURRANT_PRESSURE_PLATE,
                BlockRegister.MOUNTAIN_CURRANT_FENCE,
                BlockRegister.MOUNTAIN_CURRANT_FENCE_GATE,
                BlockRegister.MOUNTAIN_CURRANT_DOOR,
                BlockRegister.MOUNTAIN_CURRANT_TRAPDOOR,
                BlockRegister.MOUNTAIN_CURRANT_SIGN,
                BlockRegister.MOUNTAIN_CURRANT_WALL_SIGN,
                BlockRegister.MOUNTAIN_CURRANT_HANGING_SIGN,
                BlockRegister.MOUNTAIN_CURRANT_WALL_HANGING_SIGN,
                BlockRegister.MOUNTAIN_CURRANT_SAPLING,
                BlockRegister.POTTED_MOUNTAIN_CURRANT_SAPLING,
                    //moriche_palm
                BlockRegister.MORICHE_PALM_LOG,
                BlockRegister.STRIPPED_MORICHE_PALM_LOG,
                BlockRegister.MORICHE_PALM_WOOD,
                BlockRegister.STRIPPED_MORICHE_PALM_WOOD,
                BlockRegister.MORICHE_PALM_PLANKS,
                BlockRegister.MORICHE_PALM_LEAVES,
                BlockRegister.MORICHE_PALM_STAIRS,
                BlockRegister.MORICHE_PALM_SLAB,
                BlockRegister.MORICHE_PALM_BUTTON,
                BlockRegister.MORICHE_PALM_PRESSURE_PLATE,
                BlockRegister.MORICHE_PALM_FENCE,
                BlockRegister.MORICHE_PALM_FENCE_GATE,
                BlockRegister.MORICHE_PALM_DOOR,
                BlockRegister.MORICHE_PALM_TRAPDOOR,
                BlockRegister.MORICHE_PALM_SIGN,
                BlockRegister.MORICHE_PALM_WALL_SIGN,
                BlockRegister.MORICHE_PALM_HANGING_SIGN,
                BlockRegister.MORICHE_PALM_WALL_HANGING_SIGN,
                BlockRegister.MORICHE_PALM_SAPLING,
                BlockRegister.POTTED_MORICHE_PALM_SAPLING,
                    //achiote
                BlockRegister.ACHIOTE_LOG,
                BlockRegister.STRIPPED_ACHIOTE_LOG,
                BlockRegister.ACHIOTE_WOOD,
                BlockRegister.STRIPPED_ACHIOTE_WOOD,
                BlockRegister.ACHIOTE_PLANKS,
                BlockRegister.ACHIOTE_LEAVES,
                BlockRegister.ACHIOTE_STAIRS,
                BlockRegister.ACHIOTE_SLAB,
                BlockRegister.ACHIOTE_BUTTON,
                BlockRegister.ACHIOTE_PRESSURE_PLATE,
                BlockRegister.ACHIOTE_FENCE,
                BlockRegister.ACHIOTE_FENCE_GATE,
                BlockRegister.ACHIOTE_DOOR,
                BlockRegister.ACHIOTE_TRAPDOOR,
                BlockRegister.ACHIOTE_SIGN,
                BlockRegister.ACHIOTE_WALL_SIGN,
                BlockRegister.ACHIOTE_HANGING_SIGN,
                BlockRegister.ACHIOTE_WALL_HANGING_SIGN,
                BlockRegister.ACHIOTE_SAPLING,
                BlockRegister.POTTED_ACHIOTE_SAPLING
        );
        ArrayList<DeferredBlock<Block>> tempList = new ArrayList<>(allBlocks);
        tempList.addAll(BlockRegister.AllMaterialsMap.values());
        tempList.sort(new BlockComparator());
        return tempList.stream().toList();
    }

    private static List<DeferredItem<Item>> generateAllItemsList()
    {
        List<DeferredItem<Item>> allItems = Arrays.asList(
                //villager'singing stone
                ItemRegister.LIBERTY_VILLAGER_SINGING_STONE,
                ItemRegister.DIGGY_VILLAGER_SINGING_STONE,
                ItemRegister.MADNESS_VILLAGER_SINGING_STONE,
                //beer
                    //empty
                ItemRegister.EMPTY_GLASS,
                ItemRegister.EMPTY_BOTTLE,
                ItemRegister.EMPTY_MUG,
                    //PainDieux
                ItemRegister.PAIN_DIEUX_BUCKET,
                ItemRegister.PAIN_DIEUX_GLASS,
                ItemRegister.PAIN_DIEUX_BOTTLE,
                ItemRegister.PAIN_DIEUX_MUG,
                    //LA_CHATEAU
                ItemRegister.LA_CHATEAU_BUCKET,
                ItemRegister.LA_CHATEAU_GLASS,
                ItemRegister.LA_CHATEAU_BOTTLE,
                ItemRegister.LA_CHATEAU_MUG,
                    //DEBIER
                ItemRegister.DEBIER_BUCKET,
                ItemRegister.DEBIER_GLASS,
                ItemRegister.DEBIER_BOTTLE,
                ItemRegister.DEBIER_MUG,
                    //ENVAHISSEUR_ROUGE
                ItemRegister.ENVAHISSEUR_ROUGE_BUCKET,
                ItemRegister.ENVAHISSEUR_ROUGE_GLASS,
                ItemRegister.ENVAHISSEUR_ROUGE_BOTTLE,
                ItemRegister.ENVAHISSEUR_ROUGE_MUG,
                    //RASPBUISSON
                ItemRegister.RASPBUISSON_BUCKET,
                ItemRegister.RASPBUISSON_GLASS,
                ItemRegister.RASPBUISSON_BOTTLE,
                ItemRegister.RASPBUISSON_MUG,
                    //LA_BLANCHE_CITADINE
                ItemRegister.LA_BLANCHE_CITADINE_BUCKET,
                ItemRegister.LA_BLANCHE_CITADINE_GLASS,
                ItemRegister.LA_BLANCHE_CITADINE_BOTTLE,
                ItemRegister.LA_BLANCHE_CITADINE_MUG,
                    //CRANE_NOIR
                ItemRegister.CRANE_NOIR_BUCKET,
                ItemRegister.CRANE_NOIR_GLASS,
                ItemRegister.CRANE_NOIR_BOTTLE,
                ItemRegister.CRANE_NOIR_MUG,
                    //TAK
                ItemRegister.TAK_BUCKET,
                ItemRegister.TAK_GLASS,
                ItemRegister.TAK_BOTTLE,
                ItemRegister.TAK_MUG,
                    //DISENDER
                ItemRegister.DISENDER_BUCKET,
                ItemRegister.DISENDER_GLASS,
                ItemRegister.DISENDER_BOTTLE,
                ItemRegister.DISENDER_MUG,
                //food
                    //vegetation
                ItemRegister.CACTUS_FLOWER_FRUIT,
                ItemRegister.SKY_SPEARS_FRUIT,
                ItemRegister.JELLY_HAT,
                ItemRegister.MOUNTAIN_CURRANT,
                ItemRegister.MORICHE_PALM_FRUIT,
                    ItemRegister.ACHIOTE_FRUIT,
                    //stew
                ItemRegister.JELLYSHROOM_STEW,
                ItemRegister.CACTUS_STEW,
                ItemRegister.POTATOES_AND_SPEARS_BOWL,
                ItemRegister.FRUITS_BOWL,
                //tree
                    //mountain_currant
                ItemRegister.MOUNTAIN_CURRANT_SIGN,
                ItemRegister.MOUNTAIN_CURRANT_HANGING_SIGN,
                ItemRegister.MOUNTAIN_CURRANT_BOAT,
                ItemRegister.MOUNTAIN_CURRANT_CHEST_BOAT,
                    //moriche_palm
                ItemRegister.MORICHE_PALM_SIGN,
                ItemRegister.MORICHE_PALM_HANGING_SIGN,
                ItemRegister.MORICHE_PALM_BOAT,
                ItemRegister.MORICHE_PALM_CHEST_BOAT,
                    //achiote
                ItemRegister.ACHIOTE_SIGN,
                ItemRegister.ACHIOTE_HANGING_SIGN,
                ItemRegister.ACHIOTE_BOAT,
                ItemRegister.ACHIOTE_CHEST_BOAT
        );
        ArrayList<DeferredItem<Item>> tempList = new ArrayList<>(allItems);
        tempList.addAll(ItemRegister.AllMaterialsMap.values());
        tempList.sort(new ItemComparator());
        return tempList;
    }

    public static class BlockComparator implements Comparator<DeferredBlock<Block>>
    {

        @Override
        public int compare(DeferredBlock<Block> o1, DeferredBlock<Block> o2)
        {
            String id1 = o1.getId().toString();
            String id2 = o2.getId().toString();

            return id1.compareTo(id2);
        }
    }

    public static class ItemComparator implements Comparator<DeferredItem<Item>>
    {

        @Override
        public int compare(DeferredItem<Item> o1, DeferredItem<Item> o2)
        {
            String id1 = o1.getId().toString();
            String id2 = o2.getId().toString();

            return id1.compareTo(id2);
        }
    }
}

