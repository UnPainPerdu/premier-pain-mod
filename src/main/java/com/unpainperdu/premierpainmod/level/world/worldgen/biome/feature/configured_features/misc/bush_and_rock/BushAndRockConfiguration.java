package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.bush_and_rock;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public record BushAndRockConfiguration(int maxExcludedNumberOfBlock,
                                       List<BlockStateProvider> statesForRock,
                                       int percentageOfCoverageBy2ndLayer,
                                       List<BlockStateProvider> statesFor2ndLayer
) implements FeatureConfiguration
{

    public static final Codec<BushAndRockConfiguration> CODEC = RecordCodecBuilder.create(
            builder -> builder.group(
                            Codec.INT.fieldOf("max_excluded_number_of_block").forGetter(g -> g.maxExcludedNumberOfBlock),
                            Codec.list(BlockStateProvider.CODEC).fieldOf("states_for_rock").forGetter(g -> g.statesForRock),
                            Codec.INT.fieldOf("percentage_of_coverage_by_2nd_layer").forGetter(g -> g.percentageOfCoverageBy2ndLayer),
                            Codec.list(BlockStateProvider.CODEC).fieldOf("states_for_2nd_layer").forGetter(g -> g.statesFor2ndLayer)
                    )
                    .apply(builder, BushAndRockConfiguration::new)
    );

    public static class Builder
    {
        private int maxExcludedNumberOfBlock;
        private List<BlockStateProvider> statesForRock;
        private int percentageOfCoverageBy2ndLayer = 50;
        private List<BlockStateProvider> statesFor2ndLayer = List.of();

        /**
         * @param maxExcludedNumberOfBlock must be > 0
         **/
        public Builder maxExcludedNumberOfBlock(int maxExcludedNumberOfBlock)
        {
            this.maxExcludedNumberOfBlock = maxExcludedNumberOfBlock;
            return this;
        }

        /**
         * @param statesForRock must not be empty
         **/
        public Builder statesForRock(List<BlockStateProvider> statesForRock)
        {
            this.statesForRock = statesForRock;
            return this;
        }

        /**
         * @param percentageOfCoverageBy2ndLayer must be > 0 and < 101, default at 50
         **/
        public Builder percentageOfCoverageBy2ndLayer(int percentageOfCoverageBy2ndLayer)
        {
            this.percentageOfCoverageBy2ndLayer = percentageOfCoverageBy2ndLayer;
            return this;
        }

        /**
         * @param statesFor2ndLayer can be empty / ignored
         **/
        public Builder statesFor2ndLayer(List<BlockStateProvider> statesFor2ndLayer)
        {
            this.statesFor2ndLayer = statesFor2ndLayer;
            return this;
        }

        public BushAndRockConfiguration build()
        {
            if (maxExcludedNumberOfBlock < 1)
            {
                throw new IllegalArgumentException("maxExcludedNumberOfBlock must be > 0");
            }
            if (percentageOfCoverageBy2ndLayer < 1 || percentageOfCoverageBy2ndLayer > 100)
            {
                throw new IllegalArgumentException("percentageOfCoverageBy2ndLayer must be > 0 and <= 100");
            }
            if (statesForRock.isEmpty())
            {
                throw new IllegalArgumentException("statesForRock list must not be empty");
            }
            return new BushAndRockConfiguration(this.maxExcludedNumberOfBlock, this.statesForRock, this.percentageOfCoverageBy2ndLayer, this.statesFor2ndLayer);
        }
    }
}
