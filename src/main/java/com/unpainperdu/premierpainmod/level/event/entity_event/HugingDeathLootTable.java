package com.unpainperdu.premierpainmod.level.event.entity_event;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.datagen.data.level.world.ModDamageType;
import net.minecraft.world.damagesource.DamageSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;

@EventBusSubscriber(modid = PremierPainMod.MOD_ID)
public class HugingDeathLootTable
{
    private HugingDeathLootTable()
    {
    }

    @SubscribeEvent
    public static void onHugingDeath(LivingDropsEvent event)
    {
        DamageSource damageSource = event.getSource();
        if (damageSource.is(ModDamageType.HUG_TO_DEATH))
        {
            event.setCanceled(true);
        }
    }
}
