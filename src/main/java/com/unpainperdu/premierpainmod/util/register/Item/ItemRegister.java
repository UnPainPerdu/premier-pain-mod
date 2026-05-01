package com.unpainperdu.premierpainmod.util.register.Item;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.fluid.beer.*;
import com.unpainperdu.premierpainmod.level.world.fluid.oil.MorichePalmOilFluid;
import com.unpainperdu.premierpainmod.level.world.item.items.DeferredBoatItem;
import com.unpainperdu.premierpainmod.level.world.item.items.VillagerSingingStone;
import com.unpainperdu.premierpainmod.level.world.item.items.all_materials_block.VillagerShelfItem;
import com.unpainperdu.premierpainmod.level.world.item.items.drinkable_beer_item.DrinkableBeerItem;
import com.unpainperdu.premierpainmod.level.world.item.items.drinkable_beer_item.DrinkableBeerItemType;
import com.unpainperdu.premierpainmod.level.world.item.items.projectile.egg.FloweredLizardEggItem;
import com.unpainperdu.premierpainmod.level.world.item.items.sign.DeferredHangingSignItem;
import com.unpainperdu.premierpainmod.level.world.item.items.sign.DeferredSignItem;
import com.unpainperdu.premierpainmod.util.register.block.AllMaterialsBlockEnum;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.block.WoodBlockEnum;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;

import static com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister.getFluid;

public class ItemRegister
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PremierPainMod.MOD_ID);

    public static final Map<String, DeferredItem<Item>> AllMaterialsMap = createAllMaterialsItems();
    //geology
    public static final DeferredItem<Item> GYPSUM_SHARD = ITEMS.registerItem("gypsum_shard", Item::new);
    //villager's singing stone
    public static final DeferredItem<Item> LIBERTY_VILLAGER_SINGING_STONE = ITEMS.registerItem("liberty_villager_singing_stone", p -> new VillagerSingingStone(ItemEventRegister.LIBERTY, 200, p), ModItemProperties.VILLAGER_SINGING_STONE);
    public static final DeferredItem<Item> DIGGY_VILLAGER_SINGING_STONE = ITEMS.registerItem("diggy_villager_singing_stone", p -> new VillagerSingingStone(ItemEventRegister.DIGGY, 200, p), ModItemProperties.VILLAGER_SINGING_STONE);
    public static final DeferredItem<Item> MADNESS_VILLAGER_SINGING_STONE = ITEMS.registerItem("madness_villager_singing_stone", p -> new VillagerSingingStone(ItemEventRegister.MADNESS, 400, p), ModItemProperties.VILLAGER_SINGING_STONE);
    //fluid
    //  oil
    public static final DeferredItem<Item> MORICHE_PALM_OIL_BUCKET = ITEMS.registerItem("moriche_palm_oil_bucket", p -> new BucketItem(getFluid(MorichePalmOilFluid.NAME).get(), p), ModItemProperties.BUCKET);
    //  beer
    //      empty
    public static final DeferredItem<Item> EMPTY_GLASS = ITEMS.registerItem("empty_glass", Item::new, ModItemProperties.EMPTY_BEER);
    public static final DeferredItem<Item> EMPTY_BOTTLE = ITEMS.registerItem("empty_bottle", Item::new, ModItemProperties.EMPTY_BEER);
    public static final DeferredItem<Item> EMPTY_MUG = ITEMS.registerItem("empty_mug", Item::new, ModItemProperties.EMPTY_BEER);
    //      PAIN_DIEUX
    public static final DeferredItem<Item> PAIN_DIEUX_BUCKET = ITEMS.registerItem("pain_dieux_bucket", p -> new BucketItem(getFluid(PainDieuxFluid.NAME).get(), p), ModItemProperties.BUCKET);
    public static final DeferredItem<Item> PAIN_DIEUX_GLASS = glassBeerRegister("pain_dieux_glass", MobEffects.DIG_SPEED, 2, 1);
    public static final DeferredItem<Item> PAIN_DIEUX_BOTTLE = bottleBeerRegister("pain_dieux_bottle", MobEffects.DIG_SPEED, 2, 1);
    public static final DeferredItem<Item> PAIN_DIEUX_MUG = mugBeerRegister("pain_dieux_mug", MobEffects.DIG_SPEED, 2, 1);
    //      LA_CHATEAU
    public static final DeferredItem<Item> LA_CHATEAU_BUCKET = ITEMS.registerItem("la_chateau_bucket", p -> new BucketItem(getFluid(LaChateauFluid.NAME).get(), p), ModItemProperties.BUCKET);
    public static final DeferredItem<Item> LA_CHATEAU_GLASS = glassBeerRegister("la_chateau_glass", MobEffects.HEAL, 1, 0);
    public static final DeferredItem<Item> LA_CHATEAU_BOTTLE = bottleBeerRegister("la_chateau_bottle", MobEffects.HEAL, 1, 0);
    public static final DeferredItem<Item> LA_CHATEAU_MUG = mugBeerRegister("la_chateau_mug", MobEffects.HEAL, 1, 0);
    //      DEBIER
    public static final DeferredItem<Item> DEBIER_BUCKET = ITEMS.registerItem("debier_bucket", p -> new BucketItem(getFluid(DeBierFluid.NAME).get(), p), ModItemProperties.BUCKET);
    public static final DeferredItem<Item> DEBIER_GLASS = glassBeerRegister("debier_glass", MobEffects.LUCK, 2, 1);
    public static final DeferredItem<Item> DEBIER_BOTTLE = bottleBeerRegister("debier_bottle", MobEffects.LUCK, 2, 1);
    public static final DeferredItem<Item> DEBIER_MUG = mugBeerRegister("debier_mug", MobEffects.LUCK, 2, 1);
    //      ENVAHISSEUR_ROUGE
    public static final DeferredItem<Item> ENVAHISSEUR_ROUGE_BUCKET = ITEMS.registerItem("envahisseur_rouge_bucket", p -> new BucketItem(getFluid(EnvahisseurRougeFluid.NAME).get(), p), ModItemProperties.BUCKET);
    public static final DeferredItem<Item> ENVAHISSEUR_ROUGE_GLASS = glassBeerRegister("envahisseur_rouge_glass", MobEffects.DAMAGE_BOOST, 2, 0.25f);
    public static final DeferredItem<Item> ENVAHISSEUR_ROUGE_BOTTLE = bottleBeerRegister("envahisseur_rouge_bottle", MobEffects.DAMAGE_BOOST, 2, 0.25f);
    public static final DeferredItem<Item> ENVAHISSEUR_ROUGE_MUG = mugBeerRegister("envahisseur_rouge_mug", MobEffects.DAMAGE_BOOST, 2, 0.25f);
    //      RASPBUISSON
    public static final DeferredItem<Item> RASPBUISSON_BUCKET = ITEMS.registerItem("raspbuisson_bucket", p -> new BucketItem(getFluid(RaspBuissonFluid.NAME).get(), p), ModItemProperties.BUCKET);
    public static final DeferredItem<Item> RASPBUISSON_GLASS = glassBeerRegister("raspbuisson_glass", MobEffects.REGENERATION, 1, 0.8f);
    public static final DeferredItem<Item> RASPBUISSON_BOTTLE = bottleBeerRegister("raspbuisson_bottle", MobEffects.REGENERATION, 1, 0.8f);
    public static final DeferredItem<Item> RASPBUISSON_MUG = mugBeerRegister("raspbuisson_mug", MobEffects.REGENERATION, 1, 0.8f);
    //      LA_BLANCHE_CITADINE
    public static final DeferredItem<Item> LA_BLANCHE_CITADINE_BUCKET = ITEMS.registerItem("la_blanche_citadine_bucket", p -> new BucketItem(getFluid(LaBlancheCitadineFluid.NAME).get(), p), ModItemProperties.BUCKET);
    public static final DeferredItem<Item> LA_BLANCHE_CITADINE_GLASS = glassBeerRegister("la_blanche_citadine_glass", MobEffects.MOVEMENT_SPEED, 2, 1);
    public static final DeferredItem<Item> LA_BLANCHE_CITADINE_BOTTLE = bottleBeerRegister("la_blanche_citadine_bottle", MobEffects.MOVEMENT_SPEED, 2, 1);
    public static final DeferredItem<Item> LA_BLANCHE_CITADINE_MUG = mugBeerRegister("la_blanche_citadine_mug", MobEffects.MOVEMENT_SPEED, 2, 1);
    //      CRANE_NOIR
    public static final DeferredItem<Item> CRANE_NOIR_BUCKET = ITEMS.registerItem("crane_noir_bucket", p -> new BucketItem(getFluid(CraneNoirFluid.NAME).get(), p), ModItemProperties.BUCKET);
    public static final DeferredItem<Item> CRANE_NOIR_GLASS = glassBeerRegister("crane_noir_glass", MobEffects.DAMAGE_RESISTANCE, 1, 1.2f);
    public static final DeferredItem<Item> CRANE_NOIR_BOTTLE = bottleBeerRegister("crane_noir_bottle", MobEffects.DAMAGE_RESISTANCE, 1, 1.2f);
    public static final DeferredItem<Item> CRANE_NOIR_MUG = mugBeerRegister("crane_noir_mug", MobEffects.DAMAGE_RESISTANCE, 1, 1.2f);
    //      TAK
    public static final DeferredItem<Item> TAK_BUCKET = ITEMS.registerItem("tak_bucket", p -> new BucketItem(getFluid(TakFluid.NAME).get(), p), ModItemProperties.BUCKET);
    public static final DeferredItem<Item> TAK_GLASS = glassBeerRegister("tak_glass", MobEffects.FIRE_RESISTANCE, 1, 1);
    public static final DeferredItem<Item> TAK_BOTTLE = bottleBeerRegister("tak_bottle", MobEffects.FIRE_RESISTANCE, 1, 1);
    public static final DeferredItem<Item> TAK_MUG = mugBeerRegister("tak_mug", MobEffects.FIRE_RESISTANCE, 1, 1);
    //      DISENDER
    public static final DeferredItem<Item> DISENDER_BUCKET = ITEMS.registerItem("disender_bucket", p -> new BucketItem(getFluid(DisEnderFluid.NAME).get(), p), ModItemProperties.BUCKET);
    public static final DeferredItem<Item> DISENDER_GLASS = glassBeerRegister("disender_glass", MobEffects.SLOW_FALLING, 2, 1);
    public static final DeferredItem<Item> DISENDER_BOTTLE = bottleBeerRegister("disender_bottle", MobEffects.SLOW_FALLING, 2, 1);
    public static final DeferredItem<Item> DISENDER_MUG = mugBeerRegister("disender_mug", MobEffects.SLOW_FALLING, 2, 1);
    //food
        /*
    nutrition --> 1 = 1/2 jigot
    saturation -->
    */
    public static final DeferredItem<Item> HALF_COOKED_FRIES = ITEMS.registerItem("half_cooked_fries", Item::new, ModItemProperties.BASIC_FOOD.apply(64, 4, 0.3f));
    public static final DeferredItem<Item> FRIES = ITEMS.registerItem("fries", Item::new, ModItemProperties.BASIC_FOOD.apply(64, 6, 0.6f));
    public static final DeferredItem<Item> FRIES_CONE = ITEMS.registerItem("fries_cone", Item::new, ModItemProperties.BASIC_FOOD.apply(1, 15, 0.8f));
    public static final DeferredItem<Item> BREADING = ITEMS.registerItem("breading", Item::new, ModItemProperties.BASIC_FOOD.apply(64, 1, 0.1f));
    public static final DeferredItem<Item> UNCOOKED_BREADED_CHICKEN_WING = ITEMS.registerItem("uncooked_breaded_chicken_wing", Item::new, ModItemProperties.BASIC_FOOD.apply(64, 3, 0.1F));
    public static final DeferredItem<Item> BREADED_CHICKEN_WING = ITEMS.registerItem("breaded_chicken_wing", Item::new, ModItemProperties.BASIC_FOOD.apply(64, 8, 0.6f));
    public static final DeferredItem<Item> UNCOOKED_BREADED_FISH = ITEMS.registerItem("uncooked_breaded_fish", Item::new, ModItemProperties.BASIC_FOOD.apply(64, 3, 0.1f));
    public static final DeferredItem<Item> BREADED_FISH = ITEMS.registerItem("breaded_fish", Item::new, ModItemProperties.BASIC_FOOD.apply(64, 8, 0.6f));
    public static final DeferredItem<Item> UNCOOKED_SCHNITZEL = ITEMS.registerItem("uncooked_schnitzel", Item::new, ModItemProperties.BASIC_FOOD.apply(64, 4, 0.3f));
    public static final DeferredItem<Item> SCHNITZEL = ITEMS.registerItem("schnitzel", Item::new, ModItemProperties.BASIC_FOOD.apply(64, 10, 0.8f));
    public static final DeferredItem<Item> HARD_BOILED_EGG = ITEMS.registerItem("hard_boiled_egg", Item::new, ModItemProperties.BASIC_FOOD.apply(16, 6, 0.9f));
    public static final DeferredItem<Item> FLOWERED_LIZARD_MEAT = ITEMS.registerItem("flowered_lizard_meat", Item::new, ModItemProperties.BASIC_FOOD.apply(64, 3, 0.1f));
    public static final DeferredItem<Item> COOKED_FLOWERED_LIZARD_MEAT = ITEMS.registerItem("cooked_flowered_lizard_meat", Item::new, ModItemProperties.BASIC_FOOD.apply(64, 8, 0.6f));
    public static final DeferredItem<Item> HARD_BOILED_FLOWERED_LIZARD_EGG = ITEMS.registerItem("hard_boiled_flowered_lizard_egg", Item::new, ModItemProperties.BASIC_FOOD.apply(16, 8, 0.9f));
    public static final DeferredItem<Item> FRIED_FLOWERED_LIZARD_EGG = ITEMS.registerItem("fried_flowered_lizard_egg", Item::new, ModItemProperties.BASIC_FOOD.apply(64, 7, 1.0f));
    //  vegetation
    public static final DeferredItem<Item> CACTUS_FLOWER_FRUIT = ITEMS.registerItem("cactus_flower_fruit", Item::new, ModItemProperties.BASIC_FOOD.apply(64, 4, 0.3f));
    public static final DeferredItem<Item> SKY_SPEARS_FRUIT = ITEMS.registerItem("sky_spears_fruit", Item::new, ModItemProperties.BASIC_FOOD.apply(64, 4, 0.3f));
    public static final DeferredItem<Item> JELLY_HAT = ITEMS.registerItem("jelly_hat", Item::new, ModItemProperties.BASIC_FOOD.apply(64, 3, 0.10f));
    public static final DeferredItem<Item> MOUNTAIN_CURRANT = ITEMS.registerItem("mountain_currant", Item::new, ModItemProperties.BASIC_FAST_FOOD.apply(64, 1, 0.2f));
    public static final DeferredItem<Item> MORICHE_PALM_FRUIT = ITEMS.registerItem("moriche_palm_fruit", Item::new, ModItemProperties.BASIC_FOOD.apply(64, 3, 0.2f));
    public static final DeferredItem<Item> ACHIOTE_FRUIT = ITEMS.registerItem("achiote_fruit", Item::new, ModItemProperties.BASIC_FAST_FOOD.apply(64, 1, 0.2f));
    //  stew
    public static final DeferredItem<Item> JELLYSHROOM_STEW = ITEMS.registerItem("jellyshroom_stew", Item::new, ModItemProperties.BASIC_STEW_FOOD.apply(5));
    public static final DeferredItem<Item> CACTUS_STEW = ITEMS.registerItem("cactus_stew", Item::new, ModItemProperties.BASIC_STEW_FOOD.apply(6));
    public static final DeferredItem<Item> POTATOES_AND_SPEARS_BOWL = ITEMS.registerItem("potatoes_and_spears_bowl", Item::new, ModItemProperties.BASIC_STEW_FOOD.apply(6));
    public static final DeferredItem<Item> FRUITS_BOWL = ITEMS.registerItem("fruits_bowl", Item::new, ModItemProperties.BASIC_STEW_FOOD.apply(9));
    //tree
    //  mountain_currant
    public static final Map<String, DeferredItem<Item>> ITEM_MOUNTAIN_CURRANT_WOOD_TYPE_MAP = generateAllItemForWood("mountain_currant", BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP, AllInOneEntityRegister.MOUNTAIN_CURRANT_BOAT, AllInOneEntityRegister.MOUNTAIN_CURRANT_CHEST_BOAT);
    //  moriche_palm
    public static final Map<String, DeferredItem<Item>> ITEM_MORICHE_PALM_WOOD_TYPE_MAP = generateAllItemForWood("moriche_palm", BlockRegister.MORICHE_PALM_WOOD_TYPE_MAP, AllInOneEntityRegister.MORICHE_PALM_BOAT, AllInOneEntityRegister.MORICHE_PALM_CHEST_BOAT);
    //  achiote
    public static final Map<String, DeferredItem<Item>> ITEM_ACHIOTE_WOOD_TYPE_MAP = generateAllItemForWood("achiote", BlockRegister.ACHIOTE_WOOD_TYPE_MAP, AllInOneEntityRegister.ACHIOTE_BOAT, AllInOneEntityRegister.ACHIOTE_CHEST_BOAT);
    //  achiote
    public static final Map<String, DeferredItem<Item>> ITEM_WEEPING_WILLOW_WOOD_TYPE_MAP = generateAllItemForWood("weeping_willow", BlockRegister.WEEPING_WILLOW_WOOD_TYPE_MAP, AllInOneEntityRegister.WEEPING_WILLOW_BOAT, AllInOneEntityRegister.WEEPING_WILLOW_CHEST_BOAT);
    //loot_mob
    public static final DeferredItem<Item> FLOWERED_LIZARD_SCALE = ITEMS.registerItem("flowered_lizard_scale", Item::new);
    public static final DeferredItem<Item> FLOWERED_LIZARD_EGG = ITEMS.registerItem("flowered_lizard_egg", FloweredLizardEggItem::new, new Item.Properties().stacksTo(16));
    //armor
    //  horrse
    public static final DeferredItem<Item> FLOWERED_LIZARD_SCALE_HORSE_ARMOR = horseArmorRegister("flowered_lizard_scale_horse_armor", ModArmorMaterial.FLOWERED_LIZARD_SCALE); //TODO create armor material

    private static Map<String, DeferredItem<Item>> createAllMaterialsItems()
    {
        Map<String, DeferredItem<Item>> map = new HashMap<>();
        for (String material : AllMaterialsBlockEnum.getAllMaterialName())
        {
            String name = material + "_villager_shelf";
            map.put(name, ITEMS.registerItem(name, p -> new VillagerShelfItem(BlockRegister.ALL_MATERIALS_MAP.get(material + "_standing_villager_shelf"), BlockRegister.ALL_MATERIALS_MAP.get(material + "_wall_villager_shelf"), p)));
        }
        return map;
    }

    private static DeferredItem<Item> bottleBeerRegister(String name, Holder<MobEffect> effect, int potionLevel, float timeMultiplicater)
    {
        return beerItemRegister(name, DrinkableBeerItemType.BOTTLE, effect, potionLevel, timeMultiplicater, ModItemProperties.BEER_BOTTLE);
    }

    private static DeferredItem<Item> glassBeerRegister(String name, Holder<MobEffect> effect, int potionLevel, float timeMultiplicater)
    {
        return beerItemRegister(name, DrinkableBeerItemType.GLASS, effect, potionLevel, timeMultiplicater, ModItemProperties.BBER_GLASS);
    }

    private static DeferredItem<Item> mugBeerRegister(String name, Holder<MobEffect> effect, int potionLevel, float timeMultiplicater)
    {
        return beerItemRegister(name, DrinkableBeerItemType.MUG, effect, potionLevel, timeMultiplicater, ModItemProperties.BEER_MUG);
    }

    private static DeferredItem<Item> beerItemRegister(String name, DrinkableBeerItemType type, Holder<MobEffect> effect, int potionLevel, float timeMultiplicater, Item.Properties properties)
    {
        return ITEMS.registerItem(
                name,
                p -> new DrinkableBeerItem(type, name, effect, potionLevel, timeMultiplicater, p),
                properties
        );
    }

    private static Map<String, DeferredItem<Item>> generateAllItemForWood(String name, Map<String, DeferredBlock<Block>> woodTypeBlocks, DeferredHolder<EntityType<?>, EntityType<Boat>> boat, DeferredHolder<EntityType<?>, EntityType<ChestBoat>> chestBoat)
    {
        Map<String, DeferredItem<Item>> map = new HashMap<>();
        map.put("sign", ITEMS.registerItem(name + "_sign", p -> new DeferredSignItem(WoodBlockEnum.getWoodBlock(WoodBlockEnum.SIGN, woodTypeBlocks), WoodBlockEnum.getWoodBlock(WoodBlockEnum.WALL_SIGN, woodTypeBlocks), p), ModItemProperties.SIGN));
        map.put("hanging_sign", ITEMS.registerItem(name + "_hanging_sign", p -> new DeferredHangingSignItem(WoodBlockEnum.getWoodBlock(WoodBlockEnum.HANGING_SIGN, woodTypeBlocks), WoodBlockEnum.getWoodBlock(WoodBlockEnum.WALL_HANGING_SIGN, woodTypeBlocks), p), ModItemProperties.SIGN));
        map.put("boat", ITEMS.registerItem(name + "_boat", p -> new DeferredBoatItem<>(boat, p), new Item.Properties().stacksTo(1)));
        map.put("chest_boat", ITEMS.registerItem(name + "_chest_boat", p -> new DeferredBoatItem<>(chestBoat, p), new Item.Properties().stacksTo(1)));
        return map;
    }

    private static DeferredItem<Item> horseArmorRegister(String name, ArmorMaterial material)
    {
        return ITEMS.registerItem(name, p -> new AnimalArmorItem(material, AnimalArmorItem.BodyType.EQUESTRIAN, SoundEvents.HORSE_ARMOR, false, p), new Item.Properties().stacksTo(1));
    }

    public static void register(IEventBus modEventBus)
    {
        ITEMS.register(modEventBus);
    }
}