package com.unpainperdu.premierpainmod.event.block.color_switch_event.util;

import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.VillagerCarpetColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

public class DropEventColorHelper
{
    public static void dropCarpet(Level level, BlockPos pos, VillagerCarpetColor color)
    {
        ItemLike carpet;
        switch (color)
        {
            case VillagerCarpetColor.BLACK :
            {
                carpet = Items.BLACK_CARPET;
                break;
            }
            case VillagerCarpetColor.BLUE :
            {
                carpet = Items.BLUE_CARPET;
                break;
            }
            case VillagerCarpetColor.BROWN :
            {
                carpet = Items.BROWN_CARPET;
                break;
            }
            case VillagerCarpetColor.CYAN :
            {
                carpet = Items.CYAN_CARPET;
                break;
            }
            case VillagerCarpetColor.GRAY :
            {
                carpet = Items.GRAY_CARPET;
                break;
            }
            case VillagerCarpetColor.GREEN :
            {
                carpet = Items.GREEN_CARPET;
                break;
            }
            case VillagerCarpetColor.LIGHT_BLUE :
            {
                carpet = Items.LIGHT_BLUE_CARPET;
                break;
            }
            case VillagerCarpetColor.LIGHT_GRAY :
            {
                carpet = Items.LIGHT_GRAY_CARPET;
                break;
            }
            case VillagerCarpetColor.LIME :
            {
                carpet = Items.LIME_CARPET;
                break;
            }
            case VillagerCarpetColor.MAGENTA :
            {
                carpet = Items.MAGENTA_CARPET;
                break;
            }
            case VillagerCarpetColor.RED :
            {
                carpet = Items.RED_CARPET;
                break;
            }
            case VillagerCarpetColor.PINK :
            {
                carpet = Items.PINK_CARPET;
                break;
            }
            case VillagerCarpetColor.PURPLE :
            {
                carpet = Items.PURPLE_CARPET;
                break;
            }
            case VillagerCarpetColor.WHITE :
            {
                carpet = Items.WHITE_CARPET;
                break;
            }
            case VillagerCarpetColor.YELLOW :
            {
                carpet = Items.YELLOW_CARPET;
                break;
            }
            default :
            {
                carpet = Items.ORANGE_CARPET;
            }
        }
        ItemStack itemStack = new ItemStack(carpet);
        ItemEntity itementity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5, itemStack);
        level.addFreshEntity(itementity);
    }
}