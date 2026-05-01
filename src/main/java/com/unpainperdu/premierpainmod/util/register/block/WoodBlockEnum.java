package com.unpainperdu.premierpainmod.util.register.block;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Map;

public enum WoodBlockEnum
{
    LOG,
    STRIPPED_LOG,
    WOOD,
    STRIPPED_WOOD,
    PLANKS,
    LEAVES,
    STAIRS,
    SLAB,
    BUTTON,
    PRESSURE_PLATE,
    FENCE,
    FENCE_GATE,
    DOOR,
    TRAPDOOR,
    SIGN,
    WALL_SIGN,
    HANGING_SIGN,
    WALL_HANGING_SIGN,
    SAPLING,
    POTTED_SAPLING;

    public static DeferredBlock<Block> getWoodBlock(WoodBlockEnum type, Map<String, DeferredBlock<Block>> woodBlockMap)
    {
        return woodBlockMap.get(type.toString());
    }

    @Override
    public String toString()
    {
        return super.toString().toLowerCase();
    }
}