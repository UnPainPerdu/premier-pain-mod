package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.geology.crystal.tall;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.level.world.block.geology.GrowingCrystalCluster;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.AbstractFeature;
import com.unpainperdu.premierpainmod.util.tool_kit.PosHelper;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * spawn large pointed crystal made of normal block
 */
public class TallCrystalFeature extends AbstractFeature<TallCrystalConfiguration>
{
    public TallCrystalFeature(Codec<TallCrystalConfiguration> codec)
    {
        super(codec);
    }

    @Override
    public boolean canGenerate(FeaturePlaceContext<TallCrystalConfiguration> context)
    {
        WorldGenLevel worldIn = context.level();
        BlockPos pos = context.origin();
        BlockState state = worldIn.getBlockState(pos.below());
        return canConvertForStart(state);
    }

    private boolean canConvertForStart(BlockState state)
    {
        return state.is(BlockTags.BASE_STONE_OVERWORLD);
    }

    private boolean canConvert(BlockState state, BlockState stateWanted)
    {
        return state.is(BlockTags.BASE_STONE_OVERWORLD) || state.is(stateWanted.getBlock());
    }

    @Override
    public void generate(FeaturePlaceContext<TallCrystalConfiguration> context)
    {
        WorldGenLevel worldIn = context.level();
        BlockPos basePos = context.origin();
        RandomSource rand = context.random();
        TallCrystalConfiguration config = context.config();
        IntProvider height = config.height();
        BlockStateProvider block = config.block();
        BlockStateProvider cluster = config.cluster();
        Direction direction = getDirection(worldIn, basePos, rand);
        BlockPos tipPos = getTipPos(basePos, height.sample(rand), direction, rand);

        generateCrystal(worldIn, basePos, tipPos, rand, block, cluster);
    }

    private void generateCrystal(WorldGenLevel worldIn, BlockPos basePos, BlockPos tipPos, RandomSource rand, BlockStateProvider block, BlockStateProvider cluster)
    { //TODO fix crystal generating outside cave -- partially fixed now
        BlockState crystal = block.getState(rand, basePos);
        List<BlockPos> crystalPosList = PosHelper.getBlockPosLine(PosHelper.minY(basePos, tipPos), PosHelper.maxY(basePos, tipPos));
        crystalPosList.sort(Comparator.comparingInt(Vec3i::getY));
        List<BlockPos> PlacedcrystalPosList = new ArrayList<>();
        ChunkPos originChunk = new ChunkPos(basePos);
        for (BlockPos pos : crystalPosList)
        {
            ChunkPos placementChunk = new ChunkPos(pos);
            BlockState existingState = worldIn.getBlockState(pos);
            if (isInGeneratedChunks(originChunk, placementChunk)
                    && !(worldIn.canSeeSkyFromBelowWater(pos))
                    && (
                    canConvert(existingState, crystal)
                            || existingState.isAir()
                            || existingState.is(Blocks.WATER)
            ))
            {
                worldIn.setBlock(pos, crystal, 2);
                PlacedcrystalPosList.add(pos);
            }
            else
            {
                break;
            }
        }
        if (cluster != null)
        {
            for (BlockPos pos : PlacedcrystalPosList)
            {
                if (RandomUtil.getRandomPositiveIntInRange(3, rand) < 1)
                {
                    tryGenerateCluster(worldIn, pos, cluster.getState(rand, pos), originChunk, rand);
                }
            }
        }
    }

    private void tryGenerateCluster(WorldGenLevel worldIn, BlockPos currentPos, BlockState cluster, ChunkPos originChunk, RandomSource rand)
    {
        for (Direction direction : Direction.values())
        {
            BlockPos clusterPos = currentPos.relative(direction);
            BlockState currentState = worldIn.getBlockState(clusterPos);
            ChunkPos placementChunk = new ChunkPos(clusterPos);
            if (isInGeneratedChunks(originChunk, placementChunk) && (currentState.isAir() || currentState.is(Blocks.WATER)))
            {
                worldIn.setBlock(clusterPos, cluster.setValue(GrowingCrystalCluster.FACING, direction).setValue(GrowingCrystalCluster.WATERLOGGED, worldIn.isWaterAt(clusterPos)).setValue(GrowingCrystalCluster.AGE, RandomUtil.getRandomPositiveIntInRange(4, rand)), 2);
            }
        }
    }

    private Direction getDirection(WorldGenLevel worldIn, BlockPos pos, RandomSource rand)
    {
        Direction[] directions = Direction.values();
        for (Direction direction : directions)
        {
            if (worldIn.getBlockState(pos.relative(direction)).isAir())
            {
                return direction;
            }
        }
        return directions[RandomUtil.getRandomPositiveIntInRange(directions.length, rand)];
    }

    private BlockPos getTipPos(BlockPos basePos, int height, Direction direction, RandomSource rand)
    {
        BlockPos finalPos;
        switch (direction)
        {
            case UP ->
                    finalPos = new BlockPos(basePos.getX() + getTipOffset(height, rand), basePos.getY() + height, basePos.getZ() + getTipOffset(height, rand));
            case DOWN ->
                    finalPos = new BlockPos(basePos.getX() + getTipOffset(height, rand), basePos.getY() - height, basePos.getZ() + getTipOffset(height, rand));
            case NORTH ->
                    finalPos = new BlockPos(basePos.getX() + getTipOffset(height, rand), basePos.getY() + getTipOffset(height, rand), basePos.getZ() - height);
            case SOUTH ->
                    finalPos = new BlockPos(basePos.getX() + getTipOffset(height, rand), basePos.getY() + getTipOffset(height, rand), basePos.getZ() + height);
            case EAST ->
                    finalPos = new BlockPos(basePos.getX() + height, basePos.getY() + getTipOffset(height, rand), basePos.getZ() + getTipOffset(height, rand));
            default ->
                    finalPos = new BlockPos(basePos.getX() - height, basePos.getY() + getTipOffset(height, rand), basePos.getZ() + getTipOffset(height, rand));
        }
        return finalPos;
    }

    private int getTipOffset(int height, RandomSource rand)
    {
        return RandomUtil.getRandomIntInRange(1 + height / 4, rand);
    }
}