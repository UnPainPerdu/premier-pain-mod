package com.unpainperdu.premierpainmod.util.tool_kit;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ResourceUtil
{
    private ResourceUtil()
    {
    }

    public static ResourceLocation createResourceLocation(String path)
    {
        return ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, path);
    }

    public static Item getModItemFromId(String path)
    {
        return BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, path));
    }

    public static Block getModBlockFromId(String path)
    {
        return BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, path));
    }

    public static ResourceLocation getKey(Block block)
    {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    public static ResourceLocation getKey(Item item)
    {
        return BuiltInRegistries.ITEM.getKey(item);
    }

    public static String getModName(ItemLike itemLike)
    {
        return switch (itemLike)
        {
            case Block block -> getBlockName(block);
            case DeferredBlock<?> deferredBlock -> getBlockName(deferredBlock.get());
            case Item item -> getItemName(item);
            case DeferredItem<?> deferredItem -> getItemName(deferredItem.get());
            default -> throw new RuntimeException("the itemlike \" " + itemLike + "\" is not an item or a block");
        };
    }

    private static String getBlockName(Block block)
    {
        return getKey(block).toString().replace(PremierPainMod.MOD_ID + ":", "");
    }

    private static String getItemName(Item item)
    {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(PremierPainMod.MOD_ID + ":", "");
    }
}