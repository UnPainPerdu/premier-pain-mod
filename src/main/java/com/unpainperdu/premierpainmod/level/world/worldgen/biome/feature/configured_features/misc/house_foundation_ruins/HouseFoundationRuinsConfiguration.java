package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.house_foundation_ruins;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public record HouseFoundationRuinsConfiguration(List<BlockStateProvider> states) implements FeatureConfiguration
{


    public static final Codec<HouseFoundationRuinsConfiguration> CODEC = RecordCodecBuilder.create(
            builder -> builder.group(
                        Codec.list(BlockStateProvider.CODEC).fieldOf("states").forGetter(g -> g.states)
                    )
                    .apply(builder, HouseFoundationRuinsConfiguration::new)
    );

    public static class Builder
    {
        private List<BlockStateProvider> states;

        /**
         * @param states must not be empty
         **/
        public Builder states(List<BlockStateProvider> states)
        {
            this.states = states;
            return this;
        }

        public HouseFoundationRuinsConfiguration build()
        {
            if (states.isEmpty())
            {
                throw new IllegalArgumentException("states list must not be empty");
            }
            return new HouseFoundationRuinsConfiguration(states);
        }
    }
}
