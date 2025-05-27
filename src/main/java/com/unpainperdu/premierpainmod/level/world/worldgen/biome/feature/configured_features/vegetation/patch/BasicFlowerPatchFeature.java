package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.vegetation.patch;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public class BasicFlowerPatchFeature extends AbstractPatch
{

    public BasicFlowerPatchFeature(Codec<PatchConfiguration> codec)
    {
        super(codec);
    }

    @Override
    public void placeFeature(FeaturePlaceContext<PatchConfiguration> context, BlockPos posToPlace)
    {
        PatchConfiguration config = context.config();
        List<BlockStateProvider> states = config.states();

        RandomSource rand = context.random();
        WorldGenLevel worldIn = context.level();

        int randomInt = RandomUtil.getRandomPositiveIntInRange(states.size(), rand);
        BlockState state;
        try
        {
            state = states.get(randomInt).getState(rand, posToPlace);
        } catch (Exception ignored)
        {
            try
            {
                state = states.getFirst().getState(rand, posToPlace);
            } catch (Exception ignored2)
            {
                throw new RuntimeException("statesForRock list must contain at least 1 state");
            }
        }

        worldIn.setBlock(posToPlace, state, 2);
    }
}
