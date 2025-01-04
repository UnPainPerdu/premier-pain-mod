package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.event.itemEvent.VillagerSingingStoneEvent.*;
import com.unpainperdu.premierpainmod.level.world.item.items.allMaterialsBlock.VillagerShelfItem;
import com.unpainperdu.premierpainmod.level.world.item.items.VillagerSingingStone;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SignItem;
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

    public static void register(IEventBus modEventBus)
    {
        ITEMS.register(modEventBus);
    }
}
