package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.ModFeatureUtils;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.ArrayList;

public class RuinsFlowerPatchFeature extends Feature<NoneFeatureConfiguration>
{

    public RuinsFlowerPatchFeature(Codec<NoneFeatureConfiguration> pCodec)
    {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext)
    {
        WorldGenLevel worldIn = pContext.level();
        ChunkGenerator chunkGenerator = pContext.chunkGenerator();
        RandomSource rand = pContext.random();
        BlockPos pos = pContext.origin();
        NoneFeatureConfiguration config = pContext.config();
        Direction direction = ModFeatureUtils.getDirection(rand);

        if (!isValidPlacementLocation(worldIn, pos))
        {
            return false;
        }
        else
        {
            ArrayList<BlockPos> listPos = ModFeatureUtils.getRandomPosWithSameY(pos, 5,10,5, rand);
            listPos = ModFeatureUtils.setAllPosToTheGround(listPos, worldIn);

            for (BlockPos pos1 : listPos)
            {
                if (isValidPlacementLocation(worldIn, pos1))
                {
                    worldIn.setBlock(pos1, BlockRegister.RUINS_FLOWER.get().defaultBlockState(), 2);
                }
            }
            return true;
        }
    }
    private static boolean isValidPlacementLocation(LevelAccessor levelAccessor, BlockPos pos)
    {
        Block block = levelAccessor.getBlockState(pos).getBlock();
        Block blockBelow = levelAccessor.getBlockState(pos.below()).getBlock();

        if ((block instanceof AirBlock) && (blockBelow instanceof GrassBlock))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
