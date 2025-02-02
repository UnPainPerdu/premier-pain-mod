package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.event.itemEvent.VillagerSingingStoneEvent.*;
import com.unpainperdu.premierpainmod.level.world.item.items.DrinkableBeerItem.DrinkableBeerItem;
import com.unpainperdu.premierpainmod.level.world.item.items.DrinkableBeerItem.DrinkableBeerItemType;
import com.unpainperdu.premierpainmod.level.world.item.items.allMaterialsBlock.VillagerShelfItem;
import com.unpainperdu.premierpainmod.level.world.item.items.VillagerSingingStone;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.fluid.FluidRegister;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ItemRegister
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PremierPainMod.MOD_ID);
    public static final Map<String, DeferredItem<Item>> AllMaterialsMap = createAllMaterialsItems();
    //villager's singing stone
    public static final DeferredItem<Item>  LIBERTY_VILLAGER_SINGING_STONE = villagerSingingStoneRegister("liberty_villager_singing_stone", 10, () -> SoundEventRegister.LIBERTY_SOUND,new LibertyEvent());
    public static final DeferredItem<Item>  DIGGY_VILLAGER_SINGING_STONE =villagerSingingStoneRegister("diggy_villager_singing_stone", 10, () -> SoundEventRegister.DIGGY_SOUND,new DiggyEvent());
    public static final DeferredItem<Item>  MADNESS_VILLAGER_SINGING_STONE = villagerSingingStoneRegister("madness_villager_singing_stone", 20, () -> SoundEventRegister.MADNESS_SOUND,new MadnessEvent());
    public static final DeferredItem<Item>  PREMIER_PAIN_VILLAGER_SINGING_STONE = villagerSingingStoneRegister("premier_pain_villager_singing_stone", 10, () -> SoundEventRegister.PREMIER_PAIN_SOUND,new PremierPainEvent());
    //beer
        //empty
    public static final DeferredItem<Item>  EMPTY_GLASS = ITEMS.register("empty_glass", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item>  EMPTY_BOTTLE = ITEMS.register("empty_bottle", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item>  EMPTY_MUG = ITEMS.register("empty_mug", () -> new Item(new Item.Properties().stacksTo(16)));
        //PainDieux
    public static final DeferredItem<Item> PAIN_DIEUX_BUCKET = ITEMS.register("pain_dieux_bucket", () -> new BucketItem(FluidRegister.PAIN_DIEUX_FLUID.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> PAIN_DIEUX_GLASS = glassBeerRegister("pain_dieux_glass", MobEffects.DIG_SPEED);
    public static final DeferredItem<Item> PAIN_DIEUX_BOTTLE = bottleBeerRegister("pain_dieux_bottle", MobEffects.DIG_SPEED);
    public static final DeferredItem<Item> PAIN_DIEUX_MUG = mugBeerRegister("pain_dieux_mug", MobEffects.DIG_SPEED);
        //LA_CHATEAU
    public static final DeferredItem<Item> LA_CHATEAU_BUCKET = ITEMS.register("la_chateau_bucket", () -> new BucketItem(FluidRegister.PAIN_DIEUX_FLUID.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> LA_CHATEAU_GLASS = glassBeerRegister("la_chateau_glass", MobEffects.HEAL);
    public static final DeferredItem<Item> LA_CHATEAU_BOTTLE = bottleBeerRegister("la_chateau_bottle", MobEffects.HEAL);
    public static final DeferredItem<Item> LA_CHATEAU_MUG = mugBeerRegister("la_chateau_mug", MobEffects.HEAL);
        //DEBIER
    public static final DeferredItem<Item> DEBIER_BUCKET = ITEMS.register("debier_bucket", () -> new BucketItem(FluidRegister.PAIN_DIEUX_FLUID.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> DEBIER_GLASS = glassBeerRegister("debier_glass", MobEffects.LUCK);
    public static final DeferredItem<Item> DEBIER_BOTTLE = bottleBeerRegister("debier_bottle", MobEffects.LUCK);
    public static final DeferredItem<Item> DEBIER_MUG = mugBeerRegister("debier_mug", MobEffects.LUCK);
        //ENVAHISSEUR_ROUGE
    public static final DeferredItem<Item> ENVAHISSEUR_ROUGE_BUCKET = ITEMS.register("envahissuer_rouge_bucket", () -> new BucketItem(FluidRegister.PAIN_DIEUX_FLUID.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> ENVAHISSEUR_ROUGE_GLASS = glassBeerRegister("envahissuer_rouge_glass", MobEffects.DAMAGE_BOOST);
    public static final DeferredItem<Item> ENVAHISSEUR_ROUGE_BOTTLE = bottleBeerRegister("envahissuer_rouge_bottle", MobEffects.DAMAGE_BOOST);
    public static final DeferredItem<Item> ENVAHISSEUR_ROUGE_MUG = mugBeerRegister("envahissuer_rouge_mug", MobEffects.DAMAGE_BOOST);
        //RASPBUISSON
    public static final DeferredItem<Item> RASPBUISSON_BUCKET = ITEMS.register("raspbuisson_bucket", () -> new BucketItem(FluidRegister.PAIN_DIEUX_FLUID.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> RASPBUISSON_GLASS = glassBeerRegister("raspbuisson_glass", MobEffects.REGENERATION);
    public static final DeferredItem<Item> RASPBUISSON_BOTTLE = bottleBeerRegister("raspbuisson_bottle", MobEffects.REGENERATION);
    public static final DeferredItem<Item> RASPBUISSON_MUG = mugBeerRegister("raspbuisson_mug", MobEffects.REGENERATION);
        //LA_BLANCHE_CITADINE
    public static final DeferredItem<Item> LA_BLANCHE_CITADINE_BUCKET = ITEMS.register("la_blanche_citadine_bucket", () -> new BucketItem(FluidRegister.PAIN_DIEUX_FLUID.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> LA_BLANCHE_CITADINE_GLASS = glassBeerRegister("la_blanche_citadine_glass", MobEffects.MOVEMENT_SPEED);
    public static final DeferredItem<Item> LA_BLANCHE_CITADINE_BOTTLE = bottleBeerRegister("la_blanche_citadine_bottle", MobEffects.MOVEMENT_SPEED);
    public static final DeferredItem<Item> LA_BLANCHE_CITADINE_MUG = mugBeerRegister("la_blanche_citadine_mug", MobEffects.MOVEMENT_SPEED);
        //CRANE_NOIR
    public static final DeferredItem<Item> CRANE_NOIR_BUCKET = ITEMS.register("crane_noir_bucket", () -> new BucketItem(FluidRegister.PAIN_DIEUX_FLUID.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> CRANE_NOIR_GLASS = glassBeerRegister("crane_noir_glass", MobEffects.DAMAGE_RESISTANCE);
    public static final DeferredItem<Item> CRANE_NOIR_BOTTLE = bottleBeerRegister("crane_noir_bottle", MobEffects.DAMAGE_RESISTANCE);
    public static final DeferredItem<Item> CRANE_NOIR_MUG = mugBeerRegister("crane_noir_mug", MobEffects.DAMAGE_RESISTANCE);
        //TAK
    public static final DeferredItem<Item> TAK_BUCKET = ITEMS.register("tak_bucket", () -> new BucketItem(FluidRegister.PAIN_DIEUX_FLUID.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> TAK_GLASS = glassBeerRegister("tak_glass", MobEffects.FIRE_RESISTANCE);
    public static final DeferredItem<Item> TAK_BOTTLE = bottleBeerRegister("tak_bottle", MobEffects.FIRE_RESISTANCE);
    public static final DeferredItem<Item> TAK_MUG = mugBeerRegister("tak_mug", MobEffects.FIRE_RESISTANCE);
        //DISENDER
    public static final DeferredItem<Item> DISENDER_BUCKET = ITEMS.register("disender_bucket", () -> new BucketItem(FluidRegister.PAIN_DIEUX_FLUID.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> DISENDER_GLASS = glassBeerRegister("disender_glass", MobEffects.SLOW_FALLING);
    public static final DeferredItem<Item> DISENDER_BOTTLE = bottleBeerRegister("disender_bottle", MobEffects.SLOW_FALLING);
    public static final DeferredItem<Item> DISENDER_MUG = mugBeerRegister("disender_mug", MobEffects.SLOW_FALLING);
    //food
        //vegetation
    public static final DeferredItem<Item> CACTUS_FLOWER_FRUIT = basicFoodItemRegister("cactus_flower_fruit",64,4,0.3f);
    public static final DeferredItem<Item> SKY_SPEARS_FRUIT = basicFoodItemRegister("sky_spears_fruit",64,4,0.3f);
    public static final DeferredItem<Item> JELLY_HAT = basicFoodItemRegister("jelly_hat",64,3,0.10f);
    public static final DeferredItem<Item> MOUNTAIN_CURRANT = basicFoodItemRegister("mountain_currant",64,4,0.2f);
        //stew
    public static final DeferredItem<Item> JELLYSHROOM_STEW = stewFoodItemRegister("jellyshroom_stew", 5);
    public static final DeferredItem<Item> CACTUS_STEW = stewFoodItemRegister("cactus_stew", 6);
    public static final DeferredItem<Item> POTATOES_AND_SPEARS_BOWL = stewFoodItemRegister("potatoes_and_spears_bowl", 6);
    public static final DeferredItem<Item> FRUITS_BOWL = stewFoodItemRegister("fruits_bowl", 9);
    //tree
        //mountain currant
    public static final DeferredItem<Item> MOUNTAIN_CURRANT_SIGN = signItemRegister("mountain_currant_sign", () -> BlockRegister.MOUNTAIN_CURRANT_SIGN, () -> BlockRegister.MOUNTAIN_CURRANT_WALL_SIGN);
    public static final DeferredItem<Item> MOUNTAIN_CURRANT_HANGING_SIGN = hangingSignItemRegister("mountain_currant_hanging_sign", () -> BlockRegister.MOUNTAIN_CURRANT_HANGING_SIGN, () -> BlockRegister.MOUNTAIN_CURRANT_WALL_HANGING_SIGN);

    private static Map<String, DeferredItem<Item>> createAllMaterialsItems()
    {
        Map<String, DeferredItem<Item>> map = new HashMap<>();
        for (String material : BlockRegister.MATERIALS)
        {
            String id = material + "_villager_shelf";
            map.put(id ,villagerShelfRegister(id, () -> BlockRegister.AllMaterialsMap.get(material + "_standing_villager_shelf"), () -> BlockRegister.AllMaterialsMap.get(material + "_wall_villager_shelf")));
        }
        return map;
    }

    private static DeferredItem<Item> villagerShelfRegister(String name, Supplier<DeferredBlock<Block>> standingBlock, Supplier<DeferredBlock<Block>> wallBlock)
    {
        return ITEMS.register(name,() -> new VillagerShelfItem(new Item.Properties(),standingBlock.get().get(),wallBlock.get().get()));
    }

    private static DeferredItem<Item> villagerSingingStoneRegister(String name, int delayInSecond, Supplier<DeferredHolder<SoundEvent, SoundEvent>> soundEvent, AbstractVillagerSingingStoneEvent event)
    {
        return ITEMS.register(name, () -> new VillagerSingingStone(new Item.Properties().stacksTo(1), soundEvent.get().get(), name, event, delayInSecond));
    }
    private static DeferredItem<Item> basicItemRegister(String name, int maxStackSize)
    {
        return ITEMS.register(name, () -> new Item(new Item.Properties().stacksTo(maxStackSize)));
    }
    /*
    nutrition --> 1 = 1/2 jigot
    saturation -->
    */
    private static DeferredItem<Item> basicFoodItemRegister(String name, int maxStackSize, int nutrition, float saturation)
    {
        return ITEMS.register(name, () -> new Item(new Item.Properties()
                        .food(new FoodProperties.Builder()
                            .nutrition(nutrition)
                            .saturationModifier(saturation)
                            .build()
                            )
                        .stacksTo(maxStackSize)
                        ));
    }

    private static DeferredItem<Item> stewFoodItemRegister(String name, int nutrition)
    {
        return ITEMS.register(name, () -> new Item(new Item.Properties()
                .food(new FoodProperties.Builder()
                        .nutrition(nutrition)
                        .saturationModifier(0.6F)
                        .usingConvertsTo(Items.BOWL)
                        .build()
                )
                .stacksTo(4)
        ));
    }

    private static DeferredItem<Item> signItemRegister(String name, Supplier<DeferredBlock<Block>> standingBlock, Supplier<DeferredBlock<Block>> wallBlock)
    {
        return ITEMS.register(name, () -> new SignItem(new Item.Properties().stacksTo(16), standingBlock.get().get(), wallBlock.get().get()));
    }

    private static DeferredItem<Item> hangingSignItemRegister(String name, Supplier<DeferredBlock<Block>> standingBlock, Supplier<DeferredBlock<Block>> wallBlock)
    {
        return ITEMS.register(name, () -> new HangingSignItem(standingBlock.get().get(), wallBlock.get().get(), new Item.Properties().stacksTo(16)));
    }

    private static DeferredItem<Item> glassBeerRegister(String name, Holder<MobEffect> effect)
    {
        return beerItemRegister(name, DrinkableBeerItemType.GLASS, 1, 0.3f, () -> ItemRegister.EMPTY_GLASS, effect);
    }

    private static DeferredItem<Item> bottleBeerRegister(String name, Holder<MobEffect> effect)
    {
        return ITEMS.register(name, () -> new DrinkableBeerItem(new Item.Properties()
                .food(new FoodProperties.Builder()
                        .nutrition(1)
                        .saturationModifier(0.2f)
                        .usingConvertsTo(ItemRegister.EMPTY_BOTTLE.get())
                        .build()
                )
                        .craftRemainder(ItemRegister.EMPTY_BOTTLE.get())
                .stacksTo(16)
                , DrinkableBeerItemType.BOTTLE, name, effect));
    }

    private static DeferredItem<Item> mugBeerRegister(String name, Holder<MobEffect> effect)
    {
        return beerItemRegister(name, DrinkableBeerItemType.MUG, 1, 0.4f, () -> ItemRegister.EMPTY_MUG, effect);
    }

    private static DeferredItem<Item> beerItemRegister(String name, DrinkableBeerItemType type, int nutrition, float saturation, Supplier<DeferredItem<Item>> usingConvertTo, Holder<MobEffect> effect)
    {
        return ITEMS.register(name, () -> new DrinkableBeerItem(new Item.Properties()
                .food(new FoodProperties.Builder()
                        .nutrition(nutrition)
                        .saturationModifier(saturation)
                        .usingConvertsTo(usingConvertTo.get())
                        .build()
                )
                .stacksTo(16)
                , type, name, effect));
    }

    public static void register(IEventBus modEventBus)
    {
        ITEMS.register(modEventBus);
    }
}
