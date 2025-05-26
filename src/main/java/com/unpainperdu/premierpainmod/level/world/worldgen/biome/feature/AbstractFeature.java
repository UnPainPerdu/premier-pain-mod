package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractFeature<T extends FeatureConfiguration> extends Feature<T>
{
    public AbstractFeature(Codec<T> codec)
    {
        super(codec);
    }

    @Override
    public boolean place(@NotNull FeaturePlaceContext<T> context)
    {
        if (canGenerate(context))
        {
            generate(context);
            return true;
        }
        else
        {
            return false;
        }
    }

    public abstract boolean canGenerate(FeaturePlaceContext<T> context);

    public abstract void generate(FeaturePlaceContext<T> context);
}
