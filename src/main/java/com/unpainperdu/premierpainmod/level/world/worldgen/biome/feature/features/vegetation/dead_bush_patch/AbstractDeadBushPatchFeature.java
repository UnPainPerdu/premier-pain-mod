package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation.dead_bush_patch;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.ModFeatureUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ColoredFallingBlock;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.ArrayList;

public abstract class AbstractDeadBushPatchFeature extends Feature<NoneFeatureConfiguration>
{
    protected int minNumberOfPos;
    protected int maxNumberOfPos;
    protected int spread;
    public AbstractDeadBushPatchFeature(Codec<NoneFeatureConfiguration> pCodec, int minNumberOfPos, int maxNumberOfPos, int spread)
    {
        super(pCodec);
        this.minNumberOfPos = minNumberOfPos;
        this.maxNumberOfPos = maxNumberOfPos;
        this.spread = spread;
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
            ArrayList<BlockPos> listPos = ModFeatureUtils.getRandomPosWithSameY(pos, this.minNumberOfPos, this.maxNumberOfPos, this.spread, rand);
            listPos = ModFeatureUtils.setAllPosToTheGround(listPos, worldIn);

            for (BlockPos pos1 : listPos)
            {
                if (isValidPlacementLocation(worldIn, pos1))
                {
                    generateFlower(pos1, worldIn, rand, direction);
                }
            }
            return true;
        }
    }
    private static boolean isValidPlacementLocation(LevelAccessor levelAccessor, BlockPos pos)
    {
        Block block = levelAccessor.getBlockState(pos).getBlock();
        Block blockBelow = levelAccessor.getBlockState(pos.below()).getBlock();

        if ((block instanceof AirBlock) && (blockBelow instanceof ColoredFallingBlock))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    protected abstract void generateFlower(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction) ;
}
