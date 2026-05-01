package com.unpainperdu.premierpainmod.util.register.Item;

import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Items;

import java.util.function.Function;

public class ModItemProperties
{
    public final static Properties VILLAGER_SINGING_STONE = new Item.Properties().stacksTo(1);
    public final static Properties BUCKET = new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1);
    public final static Properties EMPTY_BEER = new Item.Properties().stacksTo(16);
    public final static Properties BEER_BOTTLE = new Item.Properties().food(
                    new FoodProperties.Builder()
                            .nutrition(1)
                            .saturationModifier(0.2f)
                            .build()
            )
            .usingConvertsTo(ItemRegister.EMPTY_BOTTLE.get())
            .craftRemainder(ItemRegister.EMPTY_BOTTLE.get())
            .component(DataComponents.CONSUMABLE, ModDataComponent.BEER)
            .stacksTo(16);
    public final static Properties BBER_GLASS = new Item.Properties().food(
                    new FoodProperties.Builder()
                            .nutrition(1)
                            .saturationModifier(0.3f)
                            .build()
            )
            .usingConvertsTo(ItemRegister.EMPTY_GLASS.get())
            .craftRemainder(ItemRegister.EMPTY_GLASS.get())
            .component(DataComponents.CONSUMABLE, ModDataComponent.BEER)
            .stacksTo(16);
    public final static Properties BEER_MUG = new Item.Properties().food(
                    new FoodProperties.Builder()
                            .nutrition(1)
                            .saturationModifier(0.4f)
                            .build()
            )
            .usingConvertsTo(ItemRegister.EMPTY_MUG.get())
            .craftRemainder(ItemRegister.EMPTY_MUG.get())
            .component(DataComponents.CONSUMABLE, ModDataComponent.BEER)
            .stacksTo(16);
    public final static PropertyDispatch.TriFunction<Integer, Integer, Float, Properties> BASIC_FOOD = (maxStack, nutrition, saturation) -> new Properties()
            .food(
                    new FoodProperties.Builder()
                            .nutrition(nutrition)
                            .saturationModifier(saturation)
                            .build()
            )
            .stacksTo(maxStack);

    public final static PropertyDispatch.TriFunction<Integer, Integer, Float, Properties> BASIC_FAST_FOOD = (maxStack, nutrition, saturation) -> new Properties()
            .food(
                    new FoodProperties.Builder()
                            .nutrition(nutrition)
                            .saturationModifier(saturation)
                            .build()
            )
            .component(DataComponents.CONSUMABLE, ModDataComponent.FAST_FOOD)
            .stacksTo(maxStack);

    public final static Function<Integer,  Properties> BASIC_STEW_FOOD =  nutrition -> new Properties()
            .food(
                    new FoodProperties.Builder()
                            .nutrition(nutrition)
                            .saturationModifier(0.6F)
                            .build()
            )
            .usingConvertsTo(Items.BOWL)
            .stacksTo(4);
    public final static Properties SIGN = new Item.Properties().stacksTo(16);
    public final static Properties BOAT = new Item.Properties().stacksTo(1);
}