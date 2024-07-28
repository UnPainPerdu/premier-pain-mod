package com.unpainperdu.premierpainmod.datagen.data;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.GLM.VillagerSingingStoneGLM;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.WeatherCheck;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider
{
    // Get the PackOutput from GatherDataEvent.
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(output, lookupProvider,PremierPainMod.MODID);
    }

    @Override
    protected void start()
    {
        // Call #add to add a new GLM. This also adds a corresponding entry in global_loot_modifiers.json.
        add(
                // The name of the modifier. This will be the file name.
                "singing_villager_stone_glm",
                // The loot modifier to add. For the sake of example, we add a weather loot condition.
                new VillagerSingingStoneGLM(new LootItemCondition[]
                        {
                            WeatherCheck.weather().setRaining(true).build()
                        }
                , "somestring", 10, Items.DIRT),
        // A list of data load conditions. Note that these are unrelated to the loot conditions
        // specified on the modifier itself. For the sake of example, we add a mod loaded condition.
        // An overload of #add is available that accepts a vararg of conditions instead of a list.
        List.of(new ModLoadedCondition("create")));
    }
}

