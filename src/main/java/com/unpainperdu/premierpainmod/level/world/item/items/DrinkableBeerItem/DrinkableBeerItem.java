package com.unpainperdu.premierpainmod.level.world.item.items.DrinkableBeerItem;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class DrinkableBeerItem extends Item
{
    private DrinkableBeerItemType type;
    private final String translatableDescriptionId;
    private final Holder<MobEffect> effect;

    public DrinkableBeerItem(Properties properties, DrinkableBeerItemType type, String translatableDescriptionId, Holder<MobEffect> effect)
    {
        super(properties);
        this.type = type;
        this.translatableDescriptionId = translatableDescriptionId;
        this.effect = effect;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag)
    {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        MutableComponent mutablecomponent = Component.translatable("item.description."+this.translatableDescriptionId);
        pTooltipComponents.add(mutablecomponent.withStyle(ChatFormatting.GRAY));
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    //when end eating
    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }


    @Override
    public UseAnim getUseAnimation(ItemStack stack)
    {
        return UseAnim.DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity)
    {
        FoodProperties foodproperties = stack.getFoodProperties(livingEntity);
        ItemStack stack1;
        if (foodproperties != null)
        {
            stack1 = livingEntity.eat(level, stack, foodproperties);
            livingEntity.addEffect(new MobEffectInstance(effect, type.getEffectDuration(), 2));
        }
        else
        {
            stack1 = stack;
        }
        return stack1;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }
}
