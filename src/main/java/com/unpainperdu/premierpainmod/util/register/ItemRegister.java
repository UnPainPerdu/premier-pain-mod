package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.item.items.VillagerShelfItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegister
{
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PremierPainMod.MODID);

    // Creates a new food item with the id "examplemod:example_id", nutrition 1 and saturation 2
    public static final DeferredItem<Item> VILLAGER_ICON = ITEMS.register("villager_icon", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TEST_VILLAGER_SHELF = ITEMS.register("test_villager_shelf",() -> new VillagerShelfItem(new Item.Properties(),BlockRegister.TEST_STANDING_SHELF.get(),BlockRegister.TEST_WALL_SHELF.get()));
    //Item Villager Shelf
    //public static final DeferredItem<Item> OAK_VILLAGER_SHELF = itemShelfRegister("oak",BlockRegister.OAK_STANDING_VILLAGER_SHELF.get(),BlockRegister.OAK_WALL_VILLAGER_SHELF.get());
    public static void register(IEventBus modEventBus)
    {
        ITEMS.register(modEventBus);
    }

    private static <T extends Item> DeferredItem<T> itemShelfRegister(String prefixName, Block standingShelf, Block wallShelf)
    {
        String name = prefixName+"_villager_shelf_item";
        return (DeferredItem<T>) ITEMS.register(name,() -> new VillagerShelfItem(new Item.Properties(),standingShelf,wallShelf));
    }
}
