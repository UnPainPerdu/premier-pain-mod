package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation.flower_patch.tallGrass;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.level.world.block.abstractBlock.AbstractTallGrass;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.ModFeatureUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.ArrayList;


public abstract class AbstractTallGrassFeature extends Feature<NoneFeatureConfiguration>
{
    protected int minNumberOfPos;
    protected int maxNumberOfPos;
    protected int spread;
    protected final Block tallGrass;
    protected final TagKey<Block> ground;

    public AbstractTallGrassFeature(Codec<NoneFeatureConfiguration> pCodec, int minNumberOfPos, int maxNumberOfPos, int spread, Block tallGrass, TagKey<Block> blockTagToPutOntPatch)
    {
        super(pCodec);
        this.minNumberOfPos = minNumberOfPos;
        this.maxNumberOfPos = maxNumberOfPos;
        this.spread = spread;
        this.tallGrass = tallGrass;
        this.ground = blockTagToPutOntPatch;
    }

    protected void generateFlower(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        BlockState state = this.tallGrass.defaultBlockState().setValue(AbstractTallGrass.HALF, DoubleBlockHalf.LOWER);
        ModFeatureUtils.generateBlock(worldIn, pos, rand, state,false);

        state = state.setValue(AbstractTallGrass.HALF, DoubleBlockHalf.UPPER);
        ModFeatureUtils.generateBlock(worldIn, pos.above(), rand, state,false);
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
    private boolean isValidPlacementLocation(LevelAccessor levelAccessor, BlockPos pos)
    {
        Block block = levelAccessor.getBlockState(pos).getBlock();
        Block blockBelow = levelAccessor.getBlockState(pos.below()).getBlock();

        if((block instanceof AirBlock) && (blockBelow.defaultBlockState().is(this.ground)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
