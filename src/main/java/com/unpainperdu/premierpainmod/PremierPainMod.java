package com.unpainperdu.premierpainmod;

import com.unpainperdu.premierpainmod.datagen.DataGatherer;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.surface.ModSurfaceRule;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.RegisterHandler;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import terrablender.api.SurfaceRuleManager;

@Mod(PremierPainMod.MOD_ID)
public class PremierPainMod
{
    public static final String MOD_ID = "premierpainmod";
    private static final Logger LOGGER = LogUtils.getLogger();
    public PremierPainMod(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(DataGatherer::dataGatherer);
        modEventBus.addListener(this::commonSetup);
        RegisterHandler.globalRegister(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRule.makeRules()));
        event.enqueueWork(() -> ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockRegister.RUINS_FLOWER.getId(),BlockRegister.POTTED_RUINS_FLOWER));
    }

}