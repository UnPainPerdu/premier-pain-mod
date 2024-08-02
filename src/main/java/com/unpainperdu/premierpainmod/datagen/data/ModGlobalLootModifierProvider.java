package com.unpainperdu.premierpainmod.datagen.data;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.GLM.VillagerSingingStoneGLM;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider
{
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(output, lookupProvider,PremierPainMod.MODID);
    }

    @Override
    protected void start()
    {
        villagerSingingStoneGLMToVillageHouse("liberty", ItemRegister.LIBERTY_VILLAGER_SINGING_STONE.get());
        villagerSingingStoneGLMToVillageHouse("diggy", ItemRegister.DIGGY_VILLAGER_SINGING_STONE.get());
        villagerSingingStoneGLMToVillageHouse("madness", ItemRegister.MADNESS_VILLAGER_SINGING_STONE.get());
    }

    private static ResourceLocation locVanilla(String path)
    {
        return ResourceLocation.withDefaultNamespace(path);
    }

    private void villagerSingingStoneGLMToVillageHouse(String name, Item item)
    {
        float chance = 0.10f;
        name = name + "_singing_villager_stone_glm";
        String namePlains = name +"_for_plains";
        add(
                namePlains,
                new VillagerSingingStoneGLM(new LootItemCondition[]
                        {
                                new LootTableIdCondition.Builder(locVanilla("chests/village/village_plains_house")).build(),
                                LootItemRandomChanceCondition.randomChance(chance).build()
                        }
                        , item));

        String nameSavanna = name +"_for_savanna";
        add(
                nameSavanna,
                new VillagerSingingStoneGLM(new LootItemCondition[]
                        {
                                new LootTableIdCondition.Builder(locVanilla("chests/village/village_savanna_house")).build(),
                                LootItemRandomChanceCondition.randomChance(chance).build()
                        }
                        , item));

        String nameDesert = name +"_for_desert";
        add(
                nameDesert,
                new VillagerSingingStoneGLM(new LootItemCondition[]
                        {
                                new LootTableIdCondition.Builder(locVanilla("chests/village/village_desert_house")).build(),
                                LootItemRandomChanceCondition.randomChance(chance).build()
                        }
                        , item));

        String nameSnowy = name +"_for_snowy";
        add(
                nameSnowy,
                new VillagerSingingStoneGLM(new LootItemCondition[]
                        {
                                new LootTableIdCondition.Builder(locVanilla("chests/village/village_snowy_house")).build(),
                                LootItemRandomChanceCondition.randomChance(chance).build()
                        }
                        , item));

        String nameTaiga = name +"_for_taiga";
        add(
                nameTaiga,
                new VillagerSingingStoneGLM(new LootItemCondition[]
                        {
                                new LootTableIdCondition.Builder(locVanilla("chests/village/village_taiga_house")).build(),
                                LootItemRandomChanceCondition.randomChance(chance).build()
                        }
                        , item));
    }
}

