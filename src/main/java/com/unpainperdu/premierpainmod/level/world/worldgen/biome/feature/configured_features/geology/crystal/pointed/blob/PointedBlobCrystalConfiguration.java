package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.geology.crystal.pointed.blob;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record PointedBlobCrystalConfiguration(
        FloatProvider spread,
        FloatProvider density,
        List<BlockStateProvider> blockAndPointedAndCluster
) implements FeatureConfiguration
{

    public static final Codec<PointedBlobCrystalConfiguration> CODEC = RecordCodecBuilder.create(
            builder -> builder.group(
                            FloatProvider.CODEC.fieldOf("spread").forGetter(g -> g.spread),
                            FloatProvider.CODEC.fieldOf("density").forGetter(g -> g.density),
                            Codec.list(BlockStateProvider.CODEC).fieldOf("blockAndPointedAndCluster").forGetter(g -> g.blockAndPointedAndCluster)
                    )
                    .apply(builder, PointedBlobCrystalConfiguration::new)
    );

    public static class Builder
    {
        private FloatProvider spread;
        private FloatProvider density;
        private List<BlockStateProvider> blockAndPointedAndCluster;

        /**
         * @param minSpread must be > 0 (vanilla spread pf dripstone at 0.5F)
         * @param maxSpread must be > minSpread
         **/
        public Builder spread(float minSpread, float maxSpread)
        {
            this.spread = UniformFloat.of(minSpread, maxSpread);
            return this;
        }

        public Builder density(float minDensity, float maxDensity)
        {
            this.density = UniformFloat.of(minDensity, maxDensity);
            return this;
        }

        /**
         * @param base    for the solid block
         * @param pointed for the pointed block
         * @param cluster for the cluster block, nullable
         **/
        public Builder blockAndPointedAndCluster(BlockStateProvider base, BlockStateProvider pointed, @Nullable BlockStateProvider cluster)
        {
            this.blockAndPointedAndCluster = cluster == null ? List.of(base, pointed) : List.of(base, pointed, cluster);
            return this;
        }

        public PointedBlobCrystalConfiguration build()
        {
            if (!(spread.getMinValue() > 0 || spread.getMaxValue() < spread.getMinValue()))
            {
                throw new IllegalArgumentException("min must be > 0 and max > min");
            }
            if (blockAndPointedAndCluster.size() > 3)
            {
                throw new IllegalArgumentException("to much BlockStateProvider");
            }
            if (blockAndPointedAndCluster.size() < 2)
            {
                throw new IllegalArgumentException("not enough BlockStateProvider");
            }

            return new PointedBlobCrystalConfiguration(this.spread, this.density, this.blockAndPointedAndCluster);
        }
    }
}