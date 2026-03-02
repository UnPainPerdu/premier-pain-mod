package com.unpainperdu.premierpainmod.event;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.surface.ModSurfaceRule;
import com.unpainperdu.premierpainmod.util.common_setup_event.CommonSetupEventPottedThing;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import terrablender.api.SurfaceRuleManager;

public class FMLCommonSetup
{
    public static void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, PremierPainMod.MOD_ID, ModSurfaceRule.makeRules()));
        CommonSetupEventPottedThing.setupEventPottedThing(event);
    }
}