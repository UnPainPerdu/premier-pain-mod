package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.outside_dry_toilet;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public record OutsideDryToiletConfiguration(List<BlockStateProvider> groundStates,
                                            List<BlockStateProvider> materialStates) implements FeatureConfiguration
{


    public static final Codec<OutsideDryToiletConfiguration> CODEC = RecordCodecBuilder.create(
            builder -> builder.group(
                            Codec.list(BlockStateProvider.CODEC).fieldOf("ground_states").forGetter(g -> g.groundStates),
                            Codec.list(BlockStateProvider.CODEC).fieldOf("material_states").forGetter(g -> g.materialStates)
                    )
                    .apply(builder, OutsideDryToiletConfiguration::new)
    );

    public static class Builder
    {
        private List<BlockStateProvider> groundStates;
        private List<BlockStateProvider> materialStates;

        /**
         * @param groundStates must not be empty
         **/
        public Builder groundStates(List<BlockStateProvider> groundStates)
        {
            this.groundStates = groundStates;
            return this;
        }

        /**
         * @param materialStates 0 for "log", 1 for "planks", 2 for "slabs", 3 for "door", 4 for dry toilet
         **/
        public Builder materialStates(List<BlockStateProvider> materialStates)
        {
            this.materialStates = materialStates;
            return this;
        }

        public OutsideDryToiletConfiguration build()
        {
            if (this.groundStates.isEmpty())
            {
                throw new IllegalArgumentException("groundStates list must not be empty");
            }

            if (this.materialStates.isEmpty())
            {
                throw new IllegalArgumentException("materialStates list must not be empty");
            }
            return new OutsideDryToiletConfiguration(this.groundStates, this.materialStates);
        }
    }
}
