package com.unpainperdu.premierpainmod.datagen.data.tag;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.datagen.data.tag.mod_tags.ModBlockTags;
import com.unpainperdu.premierpainmod.datagen.data.tag.mod_tags.ModItemTags;
import com.unpainperdu.premierpainmod.level.world.item.items.all_materials_block.VillagerShelfItem;
import com.unpainperdu.premierpainmod.util.mod_list.ModItemList;
import com.unpainperdu.premierpainmod.util.register.Item.ItemRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil.getModName;

public class ModItemTagProvider extends ItemTagsProvider
{
    public ModItemTagProvider(PackOutput packOutput
            , CompletableFuture<HolderLookup.Provider> lookupProvider
            , CompletableFuture<TagLookup<Block>> blockTags
            , ExistingFileHelper fileHelper)
    {
        super(packOutput, lookupProvider, blockTags, PremierPainMod.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider)
    {
        copy(BlockTags.FLOWERS, ItemTags.FLOWERS);
        copy(BlockTags.TALL_FLOWERS, ItemTags.TALL_FLOWERS);
        copy(BlockTags.LOGS, ItemTags.LOGS);
        copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        copy(BlockTags.PLANKS, ItemTags.PLANKS);
        copy(BlockTags.STAIRS, ItemTags.STAIRS);
        copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        copy(BlockTags.SLABS, ItemTags.SLABS);
        copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        copy(BlockTags.BUTTONS, ItemTags.BUTTONS);
        copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        copy(BlockTags.FENCES, ItemTags.FENCES);
        copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);
        copy(Tags.Blocks.FENCE_GATES, Tags.Items.FENCE_GATES);
        copy(Tags.Blocks.FENCE_GATES_WOODEN, Tags.Items.FENCE_GATES_WOODEN);
        copy(BlockTags.DOORS, ItemTags.DOORS);
        copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        copy(BlockTags.TRAPDOORS, ItemTags.TRAPDOORS);
        copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
        copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        copy(Tags.Blocks.STRIPPED_WOODS, Tags.Items.STRIPPED_WOODS);
        copy(Tags.Blocks.STRIPPED_LOGS, Tags.Items.STRIPPED_LOGS);
        //mod
        copy(ModBlockTags.MOUNTAIN_CURRANT_LOGS, ModItemTags.MOUNTAIN_CURRANT_LOGS);
        copy(ModBlockTags.MORICHE_PALM_LOGS, ModItemTags.MORICHE_PALM_LOGS);
        copy(ModBlockTags.ACHIOTE_LOGS, ModItemTags.ACHIOTE_LOGS);
        copy(ModBlockTags.WEEPING_WILLOW_LOGS, ModItemTags.WEEPING_WILLOW_LOGS);
        copy(ModBlockTags.VILLAGER_STATUE, ModItemTags.VILLAGER_STATUE);
        copy(ModBlockTags.VILLAGER_PEDESTAL, ModItemTags.VILLAGER_PEDESTAL);
        copy(ModBlockTags.VILLAGER_BRAZIER, ModItemTags.VILLAGER_BRAZIER);
        copy(ModBlockTags.VILLAGER_TABLE, ModItemTags.VILLAGER_TABLE);
        copy(ModBlockTags.VILLAGER_CHAIR, ModItemTags.VILLAGER_CHAIR);
        copy(ModBlockTags.VILLAGER_THRONE_CHAIR, ModItemTags.VILLAGER_THRONE_CHAIR);
        copy(ModBlockTags.VILLAGER_DRAWER, ModItemTags.VILLAGER_DRAWER);
        copy(ModBlockTags.VILLAGER_BENCH, ModItemTags.VILLAGER_BENCH);
        copy(ModBlockTags.VILLAGER_COUCH, ModItemTags.VILLAGER_COUCH);
        copy(ModBlockTags.VILLAGER_BREWING_STATION, ModItemTags.VILLAGER_BREWING_STATION);
        copy(ModBlockTags.VILLAGER_MUSICAL_FRIDGE, ModItemTags.VILLAGER_MUSICAL_FRIDGE);
        copy(ModBlockTags.VILLAGER_CHISELED_HEAD, ModItemTags.VILLAGER_CHISELED_HEAD);
        copy(ModBlockTags.VILLAGER_DRY_TOILET, ModItemTags.VILLAGER_DRY_TOILET);

        for (Item item : ModItemList.getAllItemsFromClass(SignItem.class))
        {
            if (item instanceof HangingSignItem)
            {
                this.tag(ItemTags.HANGING_SIGNS).add(item);
            }
            else
            {
                this.tag(ItemTags.SIGNS).add(item);
            }
        }

        for (Item item : ModItemList.getAllItemsFromClass(BoatItem.class))
        {
            this.tag(ItemTags.BOATS).add(item);
            String name = getModName(item);
            if (name.contains("chest_boat"))
            {
                this.tag(ItemTags.CHEST_BOATS).add(item);
            }
        }

        for (Item item : ModItemList.ALL_ITEMS)
        {
            if (item.components().has(DataComponents.FOOD))
            {
                this.tag(Tags.Items.FOODS).add(item);
            }
            if (item instanceof BucketItem)
            {
                this.tag(Tags.Items.BUCKETS).add(item);
            }
        }

        this.tag(Tags.Items.FOODS_FRUIT).add(
                ItemRegister.MOUNTAIN_CURRANT.get(),
                ItemRegister.CACTUS_FLOWER_FRUIT.get(),
                ItemRegister.SKY_SPEARS_FRUIT.get(),
                ItemRegister.MORICHE_PALM_FRUIT.get(),
                ItemRegister.ACHIOTE_FRUIT.get()
        );

        for (Item item : ModItemList.ALL_ITEMS)
        {
            if (item instanceof VillagerShelfItem)
            {
                this.tag(ModItemTags.VILLAGER_SHELF).add(item);
            }
        }
    }
}
