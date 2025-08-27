package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.tool_kit.PosHelper;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ModFeatureUtils
{
    private ModFeatureUtils()
    {
    }

    /**
     * @param isReplacing is for let block replace non-air block
     **/
    public static void generateBlock(WorldGenLevel worldIn, BlockPos pos, RandomSource rand, BlockState block, boolean isReplacing)
    {
        generateBlock(worldIn, pos, rand, Collections.singletonList(block), isReplacing);
    }

    /**
     * @param isReplacing      is for let block replace non-air block
     * @param randomizedBlocks is a list of possible state which one of them will be chosen randomly
     **/
    public static void generateBlock(WorldGenLevel worldIn, BlockPos pos, RandomSource rand, List<BlockState> randomizedBlocks, boolean isReplacing)
    {
        int listSize = randomizedBlocks.size();
        if (isReplacing || worldIn.getBlockState(pos).getBlock() instanceof AirBlock)
        {
            if (listSize == 1)
            {
                worldIn.setBlock(pos, randomizedBlocks.getFirst(), 2);
            }
            else if (listSize > 1)
            {
                int randomInt = RandomUtil.getRandomPositiveIntInRange(randomizedBlocks.size(), rand);
                worldIn.setBlock(pos, randomizedBlocks.get(randomInt), 2);
            }
        }
    }

    /**
     * @param isReplacing      is for let block replace non-air block
     * @param randomizedBlocks is a list of possible state which one of them will be chosen randomly
     **/
    public static void placeBlockAroundOne(WorldGenLevel worldIn, BlockPos pos, RandomSource rand, List<BlockState> randomizedBlocks, boolean isReplacing)
    {
        ArrayList<BlockPos> posAround = new ArrayList<>(Arrays.asList(pos.above(), pos.north(), pos.east(), pos.south(), pos.west()));
        PosHelper.setAllPosToTheGround(posAround, worldIn);

        for (BlockPos pos1 : posAround)
        {
            if (worldIn.getBlockState(pos1).getBlock() instanceof AirBlock)
            {
                generateBlock(worldIn, pos1, rand, randomizedBlocks, isReplacing);
            }
        }
    }

    public static Block getBlockFromId(String path)
    {
        return getBlockFromId(PremierPainMod.MOD_ID, path);
    }

    public static Block getBlockFromId(String nameSpace, String path)
    {
        return BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(nameSpace, path));
    }
}
