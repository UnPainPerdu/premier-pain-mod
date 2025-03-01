package com.unpainperdu.premierpainmod.datagen.data.tag;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.datagen.data.tag.mod_tags.ModBlockTags;
import com.unpainperdu.premierpainmod.datagen.data.tag.mod_tags.ModItemTags;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.ModList;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.concurrent.CompletableFuture;

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
    protected void addTags(HolderLookup.Provider pProvider)
    {
        copy(BlockTags.FLOWERS, ItemTags.FLOWERS);
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
        //mod
        copy(ModBlockTags.MOUNTAIN_CURRANT_LOGS, ModItemTags.MOUNTAIN_CURRANT_LOGS);
        copy(ModBlockTags.MORICHE_PALM_LOGS, ModItemTags.MORICHE_PALM_LOGS);

        for (Item item : ModList.getAllItemsFromClass(SignItem.class))
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

        for (Item item : ModList.getAllItemsFromClass(BoatItem.class))
        {
            this.tag(ItemTags.BOATS).add(item);
            String name = getName(item);
            if (name.contains("chest_boat"))
            {
                this.tag(ItemTags.CHEST_BOATS).add(item);
            }
        }

        for (DeferredItem<Item> deferredItem : ModList.ALL_ITEMS)
        {
            Item item = deferredItem.get();
            if (item.components().has(DataComponents.FOOD))
            {
                this.tag(Tags.Items.FOODS).add(item);
            }
        }

        this.tag(Tags.Items.FOODS_FRUIT).add(
                ItemRegister.MOUNTAIN_CURRANT.get(),
                ItemRegister.CACTUS_FLOWER_FRUIT.get(),
                ItemRegister.SKY_SPEARS_FRUIT.get()
                );
    }

    private String getName(Item item)
    {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(PremierPainMod.MOD_ID + ":", "");
    }
}
