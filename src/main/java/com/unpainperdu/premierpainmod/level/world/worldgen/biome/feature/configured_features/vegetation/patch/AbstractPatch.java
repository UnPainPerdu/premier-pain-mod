package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.vegetation.patch;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.AbstractFeature;
import com.unpainperdu.premierpainmod.util.tool_kit.PosHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPatch extends AbstractFeature<PatchConfiguration>
{
    public AbstractPatch(Codec<PatchConfiguration> codec)
    {
        super(codec);
    }

    @Override
    public boolean canGenerate(FeaturePlaceContext<PatchConfiguration> context)
    {
        PatchConfiguration config = context.config();
        List<TagKey<Block>> groundAllowed = config.groundAllowed();

        WorldGenLevel worldIn = context.level();
        BlockPos pos = context.origin();

        return isValidPlacementLocation(worldIn, pos, groundAllowed);
    }

    @Override
    public void generate(FeaturePlaceContext<PatchConfiguration> context)
    {
        PatchConfiguration config = context.config();
        int spread = config.spread();
        int minFlowerNumber = config.minFlowerNumber();
        int maxFlowerNumber = config.maxFlowerNumber();
        List<TagKey<Block>> groundAllowed = config.groundAllowed();

        WorldGenLevel worldIn = context.level();
        RandomSource rand = context.random();
        BlockPos pos = context.origin();

        ChunkPos originChunk = new ChunkPos(pos);

        ArrayList<BlockPos> listPos = PosHelper.getRandomPosWithSameY(pos, minFlowerNumber, maxFlowerNumber, spread, rand);
        listPos = PosHelper.setAllPosToTheGround(listPos, worldIn);

        for (BlockPos pos1 : listPos)
        {
            ChunkPos placementChunk = new ChunkPos(pos1);
            if (isValidPlacementLocation(worldIn, pos1, groundAllowed) && placementChunk.equals(originChunk))
            {
                placeFeature(context, pos1);
            }
        }
    }

    private static boolean isValidPlacementLocation(LevelAccessor levelAccessor, BlockPos pos, List<TagKey<Block>> groundAllowed)
    {
        boolean isValidGround = false;
        Block block = levelAccessor.getBlockState(pos).getBlock();
        Block blockBelow = levelAccessor.getBlockState(pos.below()).getBlock();
        for (TagKey<Block> tag : groundAllowed)
        {
            if (blockBelow.defaultBlockState().is(tag))
            {
                isValidGround = true;
                break;
            }
        }
        return (block instanceof AirBlock) && isValidGround;
    }

    public abstract void placeFeature(FeaturePlaceContext<PatchConfiguration> context, BlockPos posToPlace);
}
