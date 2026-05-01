package com.unpainperdu.premierpainmod.level.world.item.items.drinkable_beer_item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DrinkableBeerItem extends Item
{
    private DrinkableBeerItemType type;
    private final String translatableDescriptionId;
    private final Holder<MobEffect> effect;
    private final int potionLevel;
    private final float timeMultiplicater;

    public DrinkableBeerItem(DrinkableBeerItemType type, String translatableDescriptionId, Holder<MobEffect> effect, int potionLevel, float timeMultiplicater, Properties properties)
    {
        super(properties);
        this.type = type;
        this.translatableDescriptionId = translatableDescriptionId;
        this.effect = effect;
        this.potionLevel = potionLevel;
        this.timeMultiplicater = timeMultiplicater;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag)
    {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        MutableComponent mutablecomponent = Component.translatable("item.description." + this.translatableDescriptionId);
        pTooltipComponents.add(mutablecomponent.withStyle(ChatFormatting.GRAY));
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack stack, @NotNull Level level, @NotNull LivingEntity livingEntity)
    {
        FoodProperties foodproperties = stack.getFoodProperties(livingEntity);
        ItemStack stack1;
        if (foodproperties != null)
        {
            stack1 = livingEntity.eat(level, stack, foodproperties);
            int time = (int) (type.getEffectDuration() * this.timeMultiplicater);
            if (time < 1)
            {
                time = 1;
            }
            int potLevel = this.potionLevel - 1;
            if (potLevel < 0)
            {
                potLevel = 0;
            }
            else if (potLevel > 255)
            {
                potLevel = 255;
            }
            livingEntity.addEffect(new MobEffectInstance(effect, time, potLevel));
        }
        else
        {
            stack1 = stack;
        }
        return stack1;
    }

    @Override
    public @NotNull InteractionResult use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand)
    {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }
}