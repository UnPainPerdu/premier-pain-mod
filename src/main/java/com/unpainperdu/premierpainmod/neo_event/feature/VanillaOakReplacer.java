package com.unpainperdu.premierpainmod.neo_event.feature;

import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome.feature.features.ModVegetationFeature;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.util.RandomSource;
import net.neoforged.neoforge.event.level.BlockGrowFeatureEvent;

public class VanillaOakReplacer
{
    private VanillaOakReplacer()
    {
    }

    public static void event(BlockGrowFeatureEvent event)
    {
        RandomSource rand = event.getRandom();
        if (event.getFeature() != null)
        {
            if (event.getFeature().unwrapKey().isPresent() && event.getFeature().unwrapKey().get().equals(TreeFeatures.OAK))
            {
                if (RandomUtil.getRandomPositiveIntInRange(4, rand) < 2)
                {
                    event.setFeature(ModVegetationFeature.OAK_1);
                }
            }
        }
    }
}