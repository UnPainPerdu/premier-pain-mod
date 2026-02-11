package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.geology.tall_crystal;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record TallCrystalConfiguration(
        IntProvider height,
        BlockStateProvider block,
        BlockStateProvider cluster
) implements FeatureConfiguration
{

    public static final Codec<TallCrystalConfiguration> CODEC = RecordCodecBuilder.create(
            builder -> builder.group(
                            IntProvider.CODEC.fieldOf("height").forGetter(g -> g.height),
                            BlockStateProvider.CODEC.fieldOf("block").forGetter(g -> g.block),
                            BlockStateProvider.CODEC.fieldOf("cluster").forGetter(g -> g.cluster)
                    )
                    .apply(builder, TallCrystalConfiguration::new)
    );

    public static class Builder
    {
        private IntProvider height;
        private BlockStateProvider block;
        private BlockStateProvider cluster = null;

        /**
         * @param minHeight must be > 0 (vanilla spread pf dripstone at 0.5F)
         * @param maxHeight must be > minSpread
         **/
        public Builder height(int minHeight, int maxHeight)
        {
            this.height = UniformInt.of(minHeight, maxHeight);
            return this;
        }

        /**
         * @param cluster for the cluster block, can be ignored
         **/
        public Builder cluster(BlockStateProvider cluster)
        {
            this.cluster = cluster;
            return this;
        }

        /**
         * @param base for the solid block
         **/
        public Builder block(BlockStateProvider base)
        {
            this.block = base;
            return this;
        }

        public TallCrystalConfiguration build()
        {
            if (!(height.getMinValue() > 0 || height.getMaxValue() < height.getMinValue()))
            {
                throw new IllegalArgumentException("min must be > 0 and max > min");
            }
            if (block == null)
            {
                throw new IllegalArgumentException("block blockStateProvider must exist");
            }

            return new TallCrystalConfiguration(this.height, this.block, this.cluster);
        }
    }
}
