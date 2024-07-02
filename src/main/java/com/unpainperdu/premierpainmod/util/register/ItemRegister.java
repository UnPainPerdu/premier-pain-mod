package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.item.items.VillagerShelfItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegister
{
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PremierPainMod.MODID);

    // Creates a new food item with the id "examplemod:example_id", nutrition 1 and saturation 2
    public static final DeferredItem<Item> VILLAGER_ICON = ITEMS.register("villager_icon", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TEST_VILLAGER_SHELF = ITEMS.register("test_villager_shelf",() -> new VillagerShelfItem(new Item.Properties(),BlockRegister.TEST_STANDING_SHELF.get(),BlockRegister.TEST_WALL_SHELF.get()));

    public static void register(IEventBus modEventBus)
    {
        ITEMS.register(modEventBus);
    }
}
