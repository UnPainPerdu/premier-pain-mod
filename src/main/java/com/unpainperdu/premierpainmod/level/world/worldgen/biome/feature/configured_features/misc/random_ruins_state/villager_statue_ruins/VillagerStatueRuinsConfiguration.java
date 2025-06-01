package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.random_ruins_state.villager_statue_ruins;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.ArrayList;
import java.util.List;

public record VillagerStatueRuinsConfiguration(List<BlockStateProvider> blockStates,
                                               List<BlockStateProvider> stairStates,
                                               List<BlockStateProvider> slabStates
                                               ) implements FeatureConfiguration
{
    public static final Codec<VillagerStatueRuinsConfiguration> CODEC = RecordCodecBuilder.create(
            builder -> builder.group(
                            Codec.list(BlockStateProvider.CODEC).fieldOf("blockStates").forGetter(g -> g.blockStates),
                            Codec.list(BlockStateProvider.CODEC).fieldOf("stairStates").forGetter(g -> g.stairStates),
                            Codec.list(BlockStateProvider.CODEC).fieldOf("slabStates").forGetter(g -> g.slabStates)
                            )
                    .apply(builder, VillagerStatueRuinsConfiguration::new)
    );

    public static class Builder
    {
        private List<BlockStateProvider> blockStates;
        private List<BlockStateProvider> stairStates;
        private List<BlockStateProvider> slabStates;

        /**
         * @param blockStates must not be empty, must be normal block
         **/
        public Builder blockStates(List<BlockState> blockStates)
        {
            List<BlockStateProvider> temp = new ArrayList<>();
            blockStates.forEach(t -> temp.add(BlockStateProvider.simple(t)));
            this.blockStates = temp;
            return this;
        }

        /**
         * @param stairStates must not be empty, must be stair block
         **/
        public Builder stairStates(List<BlockState> stairStates)
        {
            List<BlockStateProvider> temp = new ArrayList<>();
            stairStates.forEach(t -> temp.add(BlockStateProvider.simple(t)));
            this.stairStates = temp;
            return this;
        }

        /**
         * @param slabStates must not be empty, must be slab block
         **/
        public Builder slabStates(List<BlockState> slabStates)
        {
            List<BlockStateProvider> temp = new ArrayList<>();
            slabStates.forEach(t -> temp.add(BlockStateProvider.simple(t)));
            this.slabStates = temp;
            return this;
        }

        public VillagerStatueRuinsConfiguration build()
        {
            if (this.blockStates.isEmpty())
            {
                throw new IllegalArgumentException("blockStates list must not be empty");
            }
            if (this.stairStates.isEmpty())
            {
                throw new IllegalArgumentException("stairStates list must not be empty");
            }
            if (this.slabStates.isEmpty())
            {
                throw new IllegalArgumentException("slabStates list must not be empty");
            }

            return new VillagerStatueRuinsConfiguration(this.blockStates, this.stairStates, this.slabStates);
        }
    }
}
