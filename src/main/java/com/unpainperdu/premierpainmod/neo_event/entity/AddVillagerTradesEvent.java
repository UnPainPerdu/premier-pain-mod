package com.unpainperdu.premierpainmod.neo_event.entity;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.fluid.beer.BeerFluid;
import com.unpainperdu.premierpainmod.util.register.Item.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.entity.villager.VillagerProfessionRegister;
import com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;

@EventBusSubscriber(modid = PremierPainMod.MOD_ID)
public class AddVillagerTradesEvent
{
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event)
    {
        VillagerProfession villagerProfession = event.getType();
        Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

        if (villagerProfession.equals(VillagerProfessionRegister.BREWER.get()))
        {
            generateBrewerTrades(trades);
        }
    }

    private static void generateBrewerTrades(Int2ObjectMap<List<VillagerTrades.ItemListing>> trades)
    {
        //level 1
        trades.get(1).add((trader, random) -> new MerchantOffer(
                        new ItemCost(BlockRegister.CIVILIZATIONS_FLOWER, 8),
                        new ItemStack(Items.EMERALD, 1),
                        12,
                        3
                        , 0.05F
                )
        );

        trades.get(1).add((trader, random) -> new MerchantOffer(
                        new ItemCost(ItemRegister.SKY_SPEARS_FRUIT, 8),
                        new ItemStack(Items.EMERALD, 1),
                        12,
                        3
                        , 0.05F
                )
        );

        trades.get(1).add((trader, random) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 5),
                        new ItemStack(BlockRegister.SKY_SPEARS_FLOWER, 1),
                        5,
                        10
                        , 0.05F
                )
        );
        trades.get(1).add((trader, random) -> new MerchantOffer(
                        new ItemCost(ItemRegister.CACTUS_FLOWER_FRUIT, 8),
                        new ItemStack(Items.EMERALD, 1),
                        12,
                        3
                        , 0.05F
                )
        );

        trades.get(1).add((trader, random) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 8),
                        new ItemStack(BlockRegister.FLOWERED_CACTUS_BLOCK, 1),
                        5,
                        10
                        , 0.05F
                )
        );
        //level 2
        trades.get(2).add((trader, random) -> new MerchantOffer(
                        new ItemCost(ItemRegister.EMPTY_GLASS, 4),
                        new ItemStack(Items.EMERALD, 1),
                        12,
                        7
                        , 0.05F
                )
        );
        trades.get(2).add((trader, random) -> new MerchantOffer(
                        new ItemCost(ItemRegister.EMPTY_BOTTLE, 4),
                        new ItemStack(Items.EMERALD, 1),
                        12,
                        7
                        , 0.05F
                )
        );
        trades.get(2).add((trader, random) -> new MerchantOffer(
                        new ItemCost(ItemRegister.EMPTY_MUG, 4),
                        new ItemStack(Items.EMERALD, 1),
                        12,
                        7
                        , 0.05F
                )
        );
        //level 3
        List<ItemLike> bottle = AllInOneFluidRegister.FLUIDS.values().stream().map(DeferredHolder::get).filter(fluid -> fluid instanceof BeerFluid).map(beerFluid -> (ItemLike) ((BeerFluid) beerFluid).getBottle()).toList();
        generateEmmeraldTrades(trades, 3, 3, 6, 15, 0.05F, bottle);
        //level 4
        List<ItemLike> mug = AllInOneFluidRegister.FLUIDS.values().stream().map(DeferredHolder::get).filter(fluid -> fluid instanceof BeerFluid).map(beerFluid -> (ItemLike) ((BeerFluid) beerFluid).getMug()).toList();
        generateEmmeraldTrades(trades, 4, 5, 6, 20, 0.05F, mug);
        //level 5
        List<ItemLike> glass = AllInOneFluidRegister.FLUIDS.values().stream().map(DeferredHolder::get).filter(fluid -> fluid instanceof BeerFluid).map(beerFluid -> (ItemLike) ((BeerFluid) beerFluid).getGlass()).toList();
        generateItemTrades(trades, 5, 5,1, 1, 25, 0.05F, glass);
    }

    private static void generateEmmeraldTrades(Int2ObjectMap<List<VillagerTrades.ItemListing>> trades, int villagerLevel, int emeraldCost, int maxUses, int villagerXp, float priceMultiplier, List<ItemLike> itemsToSell)
    {
        for (ItemLike itemLike : itemsToSell)
        {
            trades.get(villagerLevel).add((trader, random) -> new MerchantOffer(
                            new ItemCost(Items.EMERALD, emeraldCost),
                            new ItemStack(itemLike, 1),
                            maxUses,
                            villagerXp
                            , priceMultiplier
                    )
            );
        }
    }

    private static void generateItemTrades(Int2ObjectMap<List<VillagerTrades.ItemListing>> trades, int villagerLevel, int emeraldReward, int itemCost, int maxUses, int villagerXp, float priceMultiplier, List<ItemLike> itemsToSell)
    {
        for (ItemLike itemLike : itemsToSell)
        {
            trades.get(villagerLevel).add((trader, random) -> new MerchantOffer(
                            new ItemCost(itemLike, itemCost),
                            new ItemStack(Items.EMERALD, emeraldReward),
                            maxUses,
                            villagerXp
                            , priceMultiplier
                    )
            );
        }
    }

    @SubscribeEvent
    public static void addWanderingCustomTrades(WandererTradesEvent event)
    {

    }
}
