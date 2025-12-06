package com.unpainperdu.premierpainmod.level.world.worldgen.structure.processor;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractCropLikeBlock;
import com.unpainperdu.premierpainmod.util.register.structure.StructureProcessorRegister;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ExtendedBlockAgeProcessor extends StructureProcessor
{
    public static final MapCodec<ExtendedBlockAgeProcessor> CODEC = Codec.FLOAT.fieldOf("mossiness").xmap(ExtendedBlockAgeProcessor::new, extendedBlockAgeProcessor -> extendedBlockAgeProcessor.mossiness);
    private static final BlockState[] NON_MOSSY_REPLACEMENTS = new BlockState[]{
            Blocks.STONE_SLAB.defaultBlockState(), Blocks.STONE_BRICK_SLAB.defaultBlockState()
    };
    private final float mossiness;

    public ExtendedBlockAgeProcessor(float mossiness)
    {
        this.mossiness = mossiness;
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public StructureTemplate.StructureBlockInfo process(@NotNull LevelReader levelReader, @NotNull BlockPos seedPos, @NotNull BlockPos rawEntityInfo, StructureTemplate.@NotNull StructureBlockInfo blockInfo, StructureTemplate.@NotNull StructureBlockInfo relativeBlockInfo, @NotNull StructurePlaceSettings placementSettings, @org.jetbrains.annotations.Nullable StructureTemplate template)
    {
        RandomSource randomsource = placementSettings.getRandom(relativeBlockInfo.pos());
        BlockState blockstate = relativeBlockInfo.state();
        BlockPos blockpos = relativeBlockInfo.pos();
        BlockState blockstate1 = null;
        if (blockstate.is(Blocks.STONE_BRICKS) || blockstate.is(Blocks.STONE) || blockstate.is(Blocks.CHISELED_STONE_BRICKS))
        {
            blockstate1 = this.maybeReplaceFullStoneBlock(randomsource);
        }
        else if (blockstate.is(BlockTags.STAIRS))
        {
            blockstate1 = this.maybeReplaceStairs(randomsource, relativeBlockInfo.state());
        }
        else if (blockstate.is(BlockTags.SLABS))
        {
            blockstate1 = this.maybeReplaceSlab(randomsource);
        }
        else if (blockstate.is(BlockTags.WALLS))
        {
            blockstate1 = this.maybeReplaceWall(randomsource);
        }
        else if (blockstate.is(Blocks.OBSIDIAN))
        {
            blockstate1 = this.maybeReplaceObsidian(randomsource);
        }
        else if (blockstate.is(BlockTags.CROPS))
        {
            blockstate1 = getStateAfterPerformBonemeal(randomsource, blockstate);
        }

        return blockstate1 != null ? new StructureTemplate.StructureBlockInfo(blockpos, blockstate1, relativeBlockInfo.nbt()) : relativeBlockInfo;
    }

    @Nullable
    private BlockState maybeReplaceFullStoneBlock(RandomSource random)
    {
        if (random.nextFloat() >= 0.5F)
        {
            return null;
        }
        else
        {
            BlockState[] ablockstate = new BlockState[]{
                    Blocks.CRACKED_STONE_BRICKS.defaultBlockState(), getRandomFacingStairs(random, Blocks.STONE_BRICK_STAIRS)
            };
            BlockState[] ablockstate1 = new BlockState[]{
                    Blocks.MOSSY_STONE_BRICKS.defaultBlockState(), getRandomFacingStairs(random, Blocks.MOSSY_STONE_BRICK_STAIRS)
            };
            return this.getRandomBlock(random, ablockstate, ablockstate1);
        }
    }

    @Nullable
    private BlockState maybeReplaceStairs(RandomSource random, BlockState state)
    {
        Direction direction = state.getValue(StairBlock.FACING);
        Half half = state.getValue(StairBlock.HALF);
        if (random.nextFloat() >= 0.5F)
        {
            return null;
        }
        else
        {
            BlockState[] ablockstate = new BlockState[]{
                    Blocks.MOSSY_STONE_BRICK_STAIRS.defaultBlockState().setValue(StairBlock.FACING, direction).setValue(StairBlock.HALF, half),
                    Blocks.MOSSY_STONE_BRICK_SLAB.defaultBlockState()
            };
            return this.getRandomBlock(random, NON_MOSSY_REPLACEMENTS, ablockstate);
        }
    }

    @Nullable
    private BlockState maybeReplaceSlab(RandomSource random)
    {
        return random.nextFloat() < this.mossiness ? Blocks.MOSSY_STONE_BRICK_SLAB.defaultBlockState() : null;
    }

    @Nullable
    private BlockState maybeReplaceWall(RandomSource random)
    {
        return random.nextFloat() < this.mossiness ? Blocks.MOSSY_STONE_BRICK_WALL.defaultBlockState() : null;
    }

    @Nullable
    private BlockState maybeReplaceObsidian(RandomSource random)
    {
        return random.nextFloat() < 0.15F ? Blocks.CRYING_OBSIDIAN.defaultBlockState() : null;
    }

    private static BlockState getRandomFacingStairs(RandomSource random, Block stairsBlock)
    {
        return stairsBlock.defaultBlockState()
                .setValue(StairBlock.FACING, Direction.Plane.HORIZONTAL.getRandomDirection(random))
                .setValue(StairBlock.HALF, Util.getRandom(Half.values(), random));
    }

    private BlockState getRandomBlock(RandomSource random, BlockState[] normalStates, BlockState[] mossyStates)
    {
        return random.nextFloat() < this.mossiness ? getRandomBlock(random, mossyStates) : getRandomBlock(random, normalStates);
    }

    private static BlockState getRandomBlock(RandomSource random, BlockState[] states)
    {
        return states[random.nextInt(states.length)];
    }

    private BlockState getStateAfterPerformBonemeal(RandomSource rand, BlockState state)
    {
        if (state.hasProperty(BlockStateProperties.AGE_7))
        {
            if (state.getBlock() instanceof CropBlock cropBlock)
            {
                int j = cropBlock.getMaxAge();
                int i = state.getValue(BlockStateProperties.AGE_7) + Mth.nextInt(rand, 2, 5);
                if (i > j)
                {
                    i = j;
                }
                state = state.setValue(BlockStateProperties.AGE_7, i);
            }
        }
        if (state.hasProperty(BlockStateProperties.AGE_15))
        {
            if (state.getBlock() instanceof AbstractCropLikeBlock abstractCropLikeBlock)
            {
                int ageAdd = RandomUtil.getRandomPositiveIntInRange(4, rand);
                int newAge = state.getValue(BlockStateProperties.AGE_15) + ageAdd;
                int j = abstractCropLikeBlock.getMaxAge();
                if (newAge > j)
                {
                    newAge = j;
                }
                state = state.setValue(BlockStateProperties.AGE_15, newAge);
            }
        }

        return state;
    }

    @Override
    protected @NotNull StructureProcessorType<?> getType()
    {
        return StructureProcessorRegister.EXTENDED_AGE.get();
    }
}
