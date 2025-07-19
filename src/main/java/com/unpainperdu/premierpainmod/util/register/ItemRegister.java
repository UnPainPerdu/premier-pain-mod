package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.event.item_event.villager_singing_stone_event.AbstractVillagerSingingStoneEvent;
import com.unpainperdu.premierpainmod.level.event.item_event.villager_singing_stone_event.DiggyEvent;
import com.unpainperdu.premierpainmod.level.event.item_event.villager_singing_stone_event.LibertyEvent;
import com.unpainperdu.premierpainmod.level.event.item_event.villager_singing_stone_event.MadnessEvent;
import com.unpainperdu.premierpainmod.level.world.fluid.beer.*;
import com.unpainperdu.premierpainmod.level.world.fluid.oil.MorichePalmOilFluid;
import com.unpainperdu.premierpainmod.level.world.item.items.VillagerSingingStone;
import com.unpainperdu.premierpainmod.level.world.item.items.all_materials_block.VillagerShelfItem;
import com.unpainperdu.premierpainmod.level.world.item.items.drinkable_beer_item.DrinkableBeerItem;
import com.unpainperdu.premierpainmod.level.world.item.items.drinkable_beer_item.DrinkableBeerItemType;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.vehicle.Boat;
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

import static com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister.getFluid;

public class ItemRegister
{
    private ItemRegister()
    {
    }

    //register zone
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PremierPainMod.MOD_ID);
    public static final Map<String, DeferredItem<Item>> AllMaterialsMap = createAllMaterialsItems();
    //villager's singing stone
    public static final DeferredItem<Item> LIBERTY_VILLAGER_SINGING_STONE = villagerSingingStoneRegister("liberty_villager_singing_stone", 10, () -> SoundEventRegister.LIBERTY_SOUND, new LibertyEvent());
    public static final DeferredItem<Item> DIGGY_VILLAGER_SINGING_STONE = villagerSingingStoneRegister("diggy_villager_singing_stone", 10, () -> SoundEventRegister.DIGGY_SOUND, new DiggyEvent());
    public static final DeferredItem<Item> MADNESS_VILLAGER_SINGING_STONE = villagerSingingStoneRegister("madness_villager_singing_stone", 20, () -> SoundEventRegister.MADNESS_SOUND, new MadnessEvent());
    //fluid
    //oil
    public static final DeferredItem<Item> MORICHE_PALM_OIL_BUCKET = ITEMS.register("moriche_palm_oil_bucket", () -> new BucketItem(getFluid(MorichePalmOilFluid.NAME).get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    //beer
    //empty
    public static final DeferredItem<Item> EMPTY_GLASS = ITEMS.register("empty_glass", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> EMPTY_BOTTLE = ITEMS.register("empty_bottle", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> EMPTY_MUG = ITEMS.register("empty_mug", () -> new Item(new Item.Properties().stacksTo(16)));
    //PainDieux
    public static final DeferredItem<Item> PAIN_DIEUX_BUCKET = ITEMS.register("pain_dieux_bucket", () -> new BucketItem(getFluid(PainDieuxFluid.NAME).get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> PAIN_DIEUX_GLASS = glassBeerRegister("pain_dieux_glass", MobEffects.DIG_SPEED, 2, 1);
    public static final DeferredItem<Item> PAIN_DIEUX_BOTTLE = bottleBeerRegister("pain_dieux_bottle", MobEffects.DIG_SPEED, 2, 1);
    public static final DeferredItem<Item> PAIN_DIEUX_MUG = mugBeerRegister("pain_dieux_mug", MobEffects.DIG_SPEED, 2, 1);
    //LA_CHATEAU
    public static final DeferredItem<Item> LA_CHATEAU_BUCKET = ITEMS.register("la_chateau_bucket", () -> new BucketItem(getFluid(LaChateauFluid.NAME).get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> LA_CHATEAU_GLASS = glassBeerRegister("la_chateau_glass", MobEffects.HEAL, 1, 0);
    public static final DeferredItem<Item> LA_CHATEAU_BOTTLE = bottleBeerRegister("la_chateau_bottle", MobEffects.HEAL, 1, 0);
    public static final DeferredItem<Item> LA_CHATEAU_MUG = mugBeerRegister("la_chateau_mug", MobEffects.HEAL, 1, 0);
    //DEBIER
    public static final DeferredItem<Item> DEBIER_BUCKET = ITEMS.register("debier_bucket", () -> new BucketItem(getFluid(DeBierFluid.NAME).get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> DEBIER_GLASS = glassBeerRegister("debier_glass", MobEffects.LUCK, 2, 1);
    public static final DeferredItem<Item> DEBIER_BOTTLE = bottleBeerRegister("debier_bottle", MobEffects.LUCK, 2, 1);
    public static final DeferredItem<Item> DEBIER_MUG = mugBeerRegister("debier_mug", MobEffects.LUCK, 2, 1);
    //ENVAHISSEUR_ROUGE
    public static final DeferredItem<Item> ENVAHISSEUR_ROUGE_BUCKET = ITEMS.register("envahisseur_rouge_bucket", () -> new BucketItem(getFluid(EnvahisseurRougeFluid.NAME).get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> ENVAHISSEUR_ROUGE_GLASS = glassBeerRegister("envahisseur_rouge_glass", MobEffects.DAMAGE_BOOST, 2, 0.25f);
    public static final DeferredItem<Item> ENVAHISSEUR_ROUGE_BOTTLE = bottleBeerRegister("envahisseur_rouge_bottle", MobEffects.DAMAGE_BOOST, 2, 0.25f);
    public static final DeferredItem<Item> ENVAHISSEUR_ROUGE_MUG = mugBeerRegister("envahisseur_rouge_mug", MobEffects.DAMAGE_BOOST, 2, 0.25f);
    //RASPBUISSON
    public static final DeferredItem<Item> RASPBUISSON_BUCKET = ITEMS.register("raspbuisson_bucket", () -> new BucketItem(getFluid(RaspBuissonFluid.NAME).get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> RASPBUISSON_GLASS = glassBeerRegister("raspbuisson_glass", MobEffects.REGENERATION, 1, 0.8f);
    public static final DeferredItem<Item> RASPBUISSON_BOTTLE = bottleBeerRegister("raspbuisson_bottle", MobEffects.REGENERATION, 1, 0.8f);
    public static final DeferredItem<Item> RASPBUISSON_MUG = mugBeerRegister("raspbuisson_mug", MobEffects.REGENERATION, 1, 0.8f);
    //LA_BLANCHE_CITADINE
    public static final DeferredItem<Item> LA_BLANCHE_CITADINE_BUCKET = ITEMS.register("la_blanche_citadine_bucket", () -> new BucketItem(getFluid(LaBlancheCitadineFluid.NAME).get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> LA_BLANCHE_CITADINE_GLASS = glassBeerRegister("la_blanche_citadine_glass", MobEffects.MOVEMENT_SPEED, 2, 1);
    public static final DeferredItem<Item> LA_BLANCHE_CITADINE_BOTTLE = bottleBeerRegister("la_blanche_citadine_bottle", MobEffects.MOVEMENT_SPEED, 2, 1);
    public static final DeferredItem<Item> LA_BLANCHE_CITADINE_MUG = mugBeerRegister("la_blanche_citadine_mug", MobEffects.MOVEMENT_SPEED, 2, 1);
    //CRANE_NOIR
    public static final DeferredItem<Item> CRANE_NOIR_BUCKET = ITEMS.register("crane_noir_bucket", () -> new BucketItem(getFluid(CraneNoirFluid.NAME).get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> CRANE_NOIR_GLASS = glassBeerRegister("crane_noir_glass", MobEffects.DAMAGE_RESISTANCE, 1, 1.2f);
    public static final DeferredItem<Item> CRANE_NOIR_BOTTLE = bottleBeerRegister("crane_noir_bottle", MobEffects.DAMAGE_RESISTANCE, 1, 1.2f);
    public static final DeferredItem<Item> CRANE_NOIR_MUG = mugBeerRegister("crane_noir_mug", MobEffects.DAMAGE_RESISTANCE, 1, 1.2f);
    //TAK
    public static final DeferredItem<Item> TAK_BUCKET = ITEMS.register("tak_bucket", () -> new BucketItem(getFluid(TakFluid.NAME).get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> TAK_GLASS = glassBeerRegister("tak_glass", MobEffects.FIRE_RESISTANCE, 1, 1);
    public static final DeferredItem<Item> TAK_BOTTLE = bottleBeerRegister("tak_bottle", MobEffects.FIRE_RESISTANCE, 1, 1);
    public static final DeferredItem<Item> TAK_MUG = mugBeerRegister("tak_mug", MobEffects.FIRE_RESISTANCE, 1, 1);
    //DISENDER
    public static final DeferredItem<Item> DISENDER_BUCKET = ITEMS.register("disender_bucket", () -> new BucketItem(getFluid(DisEnderFluid.NAME).get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> DISENDER_GLASS = glassBeerRegister("disender_glass", MobEffects.SLOW_FALLING, 2, 1);
    public static final DeferredItem<Item> DISENDER_BOTTLE = bottleBeerRegister("disender_bottle", MobEffects.SLOW_FALLING, 2, 1);
    public static final DeferredItem<Item> DISENDER_MUG = mugBeerRegister("disender_mug", MobEffects.SLOW_FALLING, 2, 1);
    //food
    public static final DeferredItem<Item> HALF_COOKED_FRIES = basicFoodItemRegister("half_cooked_fries", 64, 4, 0.3f);
    public static final DeferredItem<Item> FRIES = basicFoodItemRegister("fries", 64, 6, 0.6f);
    public static final DeferredItem<Item> FRIES_CONE = basicFoodItemRegister("fries_cone", 1, 15, 1f);
    //vegetation
    public static final DeferredItem<Item> CACTUS_FLOWER_FRUIT = basicFoodItemRegister("cactus_flower_fruit", 64, 4, 0.3f);
    public static final DeferredItem<Item> SKY_SPEARS_FRUIT = basicFoodItemRegister("sky_spears_fruit", 64, 4, 0.3f);
    public static final DeferredItem<Item> JELLY_HAT = basicFoodItemRegister("jelly_hat", 64, 3, 0.10f);
    public static final DeferredItem<Item> MOUNTAIN_CURRANT = fastFoodItemRegister("mountain_currant", 64, 1, 0.2f);
    public static final DeferredItem<Item> MORICHE_PALM_FRUIT = basicFoodItemRegister("moriche_palm_fruit", 64, 3, 0.2f);
    public static final DeferredItem<Item> ACHIOTE_FRUIT = fastFoodItemRegister("achiote_fruit", 64, 1, 0.2f);
    //stew
    public static final DeferredItem<Item> JELLYSHROOM_STEW = stewFoodItemRegister("jellyshroom_stew", 5);
    public static final DeferredItem<Item> CACTUS_STEW = stewFoodItemRegister("cactus_stew", 6);
    public static final DeferredItem<Item> POTATOES_AND_SPEARS_BOWL = stewFoodItemRegister("potatoes_and_spears_bowl", 6);
    public static final DeferredItem<Item> FRUITS_BOWL = stewFoodItemRegister("fruits_bowl", 9);
    //tree
    //mountain_currant
    public static final Map<String, DeferredItem<Item>> ITEM_MOUNTAIN_CURRANT_WOOD_TYPE_MAP = generateAllItemForWood("mountain_currant", () -> BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP);
    //moriche_palm
    public static final Map<String, DeferredItem<Item>> ITEM_MORICHE_PALM_WOOD_TYPE_MAP = generateAllItemForWood("moriche_palm", () -> BlockRegister.MORICHE_PALM_WOOD_TYPE_MAP);
    //achiote
    public static final Map<String, DeferredItem<Item>> ITEM_ACHIOTE_WOOD_TYPE_MAP = generateAllItemForWood("achiote", () -> BlockRegister.ACHIOTE_WOOD_TYPE_MAP);

    private static Map<String, DeferredItem<Item>> createAllMaterialsItems()
    {
        Map<String, DeferredItem<Item>> map = new HashMap<>();
        for (String material : BlockRegister.MATERIALS)
        {
            String id = material + "_villager_shelf";
            map.put(id, villagerShelfRegister(id, () -> BlockRegister.AllMaterialsMap.get(material + "_standing_villager_shelf"), () -> BlockRegister.AllMaterialsMap.get(material + "_wall_villager_shelf")));
        }
        return map;
    }

    private static DeferredItem<Item> villagerShelfRegister(String name, Supplier<DeferredBlock<Block>> standingBlock, Supplier<DeferredBlock<Block>> wallBlock)
    {
        return ITEMS.register(name, () -> new VillagerShelfItem(new Item.Properties(), standingBlock.get().get(), wallBlock.get().get()));
    }

    private static DeferredItem<Item> villagerSingingStoneRegister(String name, int delayInSecond, Supplier<DeferredHolder<SoundEvent, SoundEvent>> soundEvent, AbstractVillagerSingingStoneEvent event)
    {
        return ITEMS.register(name, () -> new VillagerSingingStone(new Item.Properties().stacksTo(1), soundEvent.get().get(), name, event, delayInSecond));
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

    private static DeferredItem<Item> fastFoodItemRegister(String name, int maxStackSize, int nutrition, float saturation)
    {
        return ITEMS.register(name, () -> new Item(new Item.Properties()
                .food(new FoodProperties.Builder()
                        .nutrition(nutrition)
                        .saturationModifier(saturation)
                        .fast()
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

    private static DeferredItem<Item> glassBeerRegister(String name, Holder<MobEffect> effect, int potionLevel, float timeMultiplicater)
    {
        return beerItemRegister(name, DrinkableBeerItemType.GLASS, 1, 0.3f, () -> ItemRegister.EMPTY_GLASS, effect, potionLevel, timeMultiplicater);
    }

    private static DeferredItem<Item> bottleBeerRegister(String name, Holder<MobEffect> effect, int potionLevel, float timeMultiplicater)
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
                , DrinkableBeerItemType.BOTTLE, name, effect, potionLevel, timeMultiplicater));
    }

    private static DeferredItem<Item> mugBeerRegister(String name, Holder<MobEffect> effect, int potionLevel, float timeMultiplicater)
    {
        return beerItemRegister(name, DrinkableBeerItemType.MUG, 1, 0.4f, () -> ItemRegister.EMPTY_MUG, effect, potionLevel, timeMultiplicater);
    }

    private static DeferredItem<Item> beerItemRegister(String name, DrinkableBeerItemType type, int nutrition, float saturation, Supplier<DeferredItem<Item>> usingConvertTo, Holder<MobEffect> effect, int potionLevel, float timeMultiplicater)
    {
        return ITEMS.register(name, () -> new DrinkableBeerItem(new Item.Properties()
                .food(new FoodProperties.Builder()
                        .nutrition(nutrition)
                        .saturationModifier(saturation)
                        .usingConvertsTo(usingConvertTo.get())
                        .build()
                )
                .stacksTo(16)
                , type, name, effect, potionLevel, timeMultiplicater));
    }

    private static Map<String, DeferredItem<Item>> generateAllItemForWood(String name, Supplier<Map<String, DeferredBlock<Block>>> woodTypeBlocks)
    {
        Map<String, DeferredItem<Item>> map = new HashMap<>();
        map.put("sign", signItemRegister(name + "_sign", () -> woodTypeBlocks.get().get("sign"), () -> woodTypeBlocks.get().get("wall_sign")));
        map.put("hanging_sign", hangingSignItemRegister(name + "_hanging_sign", () -> woodTypeBlocks.get().get("hanging_sign"), () -> woodTypeBlocks.get().get("wall_hanging_sign")));
        map.put("boat", ITEMS.register(name + "_boat", () -> new BoatItem(false, Boat.Type.valueOf("premierpainmod_" + (name.toUpperCase())), new Item.Properties().stacksTo(1))));
        map.put("chest_boat", ITEMS.register(name + "_chest_boat", () -> new BoatItem(true, Boat.Type.valueOf("premierpainmod_" + (name.toUpperCase())), new Item.Properties().stacksTo(1))));
        return map;
    }

    public static void register(IEventBus modEventBus)
    {
        ITEMS.register(modEventBus);
    }
}
