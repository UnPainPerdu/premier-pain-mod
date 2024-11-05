package com.unpainperdu.premierpainmod.level.world.item.items.food;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ModdedStewItem extends Item
{
    public ModdedStewItem(Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity)
    {
        FoodProperties foodproperties = itemStack.getFoodProperties(livingEntity);
        ItemStack returnItemStack = itemStack;
        if (foodproperties != null)
        {
            returnItemStack = livingEntity.eat(level, itemStack, foodproperties);
            //livingEntity.setItemSlot();
        }
        return returnItemStack;
    }
}
