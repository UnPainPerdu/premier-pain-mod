package com.unpainperdu.premierpainmod.neo_event.feature;

import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome.feature.features.ModVegetationFeature;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.util.RandomSource;
import net.neoforged.neoforge.event.level.BlockGrowFeatureEvent;

public class VanillaBirchReplacer
{
    private VanillaBirchReplacer()
    {
    }

    public static void event(BlockGrowFeatureEvent event)
    {
        RandomSource rand = event.getRandom();
        if (event.getFeature() != null)
        {
            if (event.getFeature().unwrapKey().isPresent() && event.getFeature().unwrapKey().get().equals(TreeFeatures.BIRCH))
            {
                if (RandomUtil.getRandomPositiveIntInRange(2, rand) == 0)
                {
                    event.setFeature(ModVegetationFeature.BIRCH_1);
                }
            }
        }
    }
}
