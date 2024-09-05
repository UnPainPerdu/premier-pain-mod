package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.vegetation.misc;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.FloweredCactusBlock;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.ModFeatureUtils;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Arrays;
import java.util.List;

public class FloweredCactusFeature extends Feature<NoneFeatureConfiguration>
{
    public FloweredCactusFeature(Codec<NoneFeatureConfiguration> codec)
    {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context)
    {
        WorldGenLevel worldIn = context.level();
        ChunkGenerator chunkGenerator = context.chunkGenerator();
        RandomSource rand = context.random();
        BlockPos pos = context.origin();
        NoneFeatureConfiguration config = context.config();
        Direction direction = ModFeatureUtils.getDirection(rand);

        int randomInt = ModFeatureUtils.getRandomPositiveIntInRange(100, rand);

        if (!isValidPlacementLocation(worldIn, pos) && randomInt > 30)
        {
            return false;
        }

        generateFloweredCactus(worldIn,rand,pos,config, direction);
        return true;
    }

    private static boolean isValidPlacementLocation(LevelAccessor levelAccessor, BlockPos pos)
    {
        Block block = levelAccessor.getBlockState(pos).getBlock();
        BlockState blockBelowState = levelAccessor.getBlockState(pos.below());

        return (block instanceof AirBlock) && blockBelowState.is(BlockTags.SAND);
    }

    private static void generateFloweredCactus(WorldGenLevel worldIn, RandomSource rand, BlockPos pos, NoneFeatureConfiguration config,Direction direction)
    {
        BlockState defaultFloweredCactusState = BlockRegister.FLOWERED_CACTUS_BLOCK.get().defaultBlockState();

        List<BlockPos> mainPosList = Arrays.asList(pos, pos.above(), pos.above(2), pos.above(3), pos.above(4));

        int i = 0 ;
        int maxHeight = ModFeatureUtils.getRandomIntInRange(4, rand) + 1 ;
        for (BlockPos pos1 : mainPosList)
        {
            if (i >= maxHeight)
            {
                break;
            }
            ModFeatureUtils.generateBlock(worldIn , pos1, rand, defaultFloweredCactusState, false);
            if (i > 1)
            {
                int numberArm = ModFeatureUtils.getRandomIntInRange(10, rand);
                if (numberArm < 3)
                {
                    generateNewArm(defaultFloweredCactusState, worldIn, pos1, rand);
                }
                generateNewArm(defaultFloweredCactusState, worldIn, pos1, rand);
            }
            i++;
        }
    }

    private static void generateNewArm(BlockState state, WorldGenLevel level, BlockPos pos, RandomSource rand)
    {
        int randomInt = ModFeatureUtils.getRandomPositiveIntInRange(4, rand);
        Direction direction;
        switch (randomInt)
        {
            case 0 :
            {
                direction = Direction.NORTH;
                break;
            }
            case 1 :
            {
                direction = Direction.SOUTH;
                break;
            }
            case 2 :
            {
                direction = Direction.WEST;
                break;
            }
            default:
            {
                direction = Direction.EAST;
                break;
            }
        }

        BlockPos newPos = pos.relative(direction);
        ModFeatureUtils.generateBlock(level, newPos, rand, state.setValue(FloweredCactusBlock.PART_NUM, 2)
                        .setValue(FloweredCactusBlock.FACING, direction.getOpposite())
                        .setValue(FloweredCactusBlock.GROW_STAGE,0), false);

        randomInt = ModFeatureUtils.getRandomPositiveIntInRange(10, rand);
        if (randomInt < 7 && level.getBlockState(newPos).getBlock() instanceof FloweredCactusBlock)
        {
            if(level.getBlockState(newPos).getValue(FloweredCactusBlock.PART_NUM) == 2 && level.getBlockState(newPos.above()).getBlock() instanceof AirBlock)
            {
                level.setBlock(newPos, state.setValue(FloweredCactusBlock.PART_NUM, 3).setValue(FloweredCactusBlock.FACING, direction.getOpposite()), 2);
                level.setBlock(newPos.above(), state.setValue(FloweredCactusBlock.PART_NUM, 1), 2);

                ModFeatureUtils.generateBlock(level, newPos.above(2), rand, BlockRegister.CACTUS_FLOWER_BLOCK.get().defaultBlockState(), false);
            }
        }
    }
}
