package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.vegetation.patch;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public class GrowingAboveVegetationPatchFeature extends AbstractPatch
{
    public GrowingAboveVegetationPatchFeature(Codec<PatchConfiguration> codec)
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

        int randomHeight = RandomUtil.getRandomPositiveIntInRange(5, rand) + 1;
        for (int i = 0; i < randomHeight; i++)
        {
            worldIn.setBlock(posToPlace, states.getFirst().getState(rand, posToPlace), 2);
            posToPlace = posToPlace.above();
            Block block = worldIn.getBlockState(posToPlace).getBlock();
            if (!(block instanceof AirBlock))
            {
                break;
            }
        }
    }
}
