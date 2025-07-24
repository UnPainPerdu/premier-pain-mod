package com.unpainperdu.premierpainmod.util.tool_kit;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class ResourceUtil
{
    private ResourceUtil()
    {
    }

    public static ResourceLocation createResourceLocation(String path)
    {
        return ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, path);
    }

    public static Block getModBlockFromId(String path)
    {
        return BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, path));
    }

    public static ResourceLocation getKey(Block block)
    {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    public static String getModName(Block block)
    {
        return getKey(block).toString().replace(PremierPainMod.MOD_ID + ":", "");
    }
}
