package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.misc;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.VillagerChiseledHead;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.features.ModFeatureUtils;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.tool_kit.DirectionHelper;
import com.unpainperdu.premierpainmod.util.tool_kit.PosHelper;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class VillagerTotemFeature extends Feature<NoneFeatureConfiguration>
{
    public VillagerTotemFeature(Codec<NoneFeatureConfiguration> codec)
    {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context)
    {
        WorldGenLevel worldIn = context.level();
        RandomSource rand = context.random();
        BlockPos pos = context.origin();
        Direction direction = DirectionHelper.getRandomDirection(rand);

        if (!isValidGenerationPoint(worldIn, pos))
        {
            return false;
        }

        int baseHeight = RandomUtil.getRandomPositiveIntInRange(3, rand) + 1;

        for (int i = 0; i < baseHeight; i++)
        {
            ModFeatureUtils.generateBlock(worldIn, pos, rand, BlockRegister.STRIPPED_ACHIOTE_LOG.get().defaultBlockState(), false);
            if (i == baseHeight - 1)
            {
                BlockPos leftArmPos = PosHelper.getLeft(pos, direction);
                BlockPos rightArmPos = PosHelper.getRight(pos, direction);
                generateConnectedFence(worldIn, rand, leftArmPos, direction, true);
                generateConnectedFence(worldIn, rand, rightArmPos, direction, false);
                leftArmPos = leftArmPos.above();
                ModFeatureUtils.generateBlock(worldIn, leftArmPos, rand, BlockRegister.MORICHE_PALM_FENCE.get().defaultBlockState(), false);
                rightArmPos = rightArmPos.above();
                ModFeatureUtils.generateBlock(worldIn, rightArmPos, rand, BlockRegister.MORICHE_PALM_FENCE.get().defaultBlockState(), false);
            }
            pos = pos.above();
        }

        ModFeatureUtils.generateBlock(worldIn, pos, rand, ModFeatureUtils.getBlockFromId("moriche_palm_villager_chiseled_head").defaultBlockState().setValue(VillagerChiseledHead.LIT, (RandomUtil.getRandomPositiveIntInRange(2, rand) == 0)), false);
        pos = pos.above();
        ModFeatureUtils.generateBlock(worldIn, pos, rand, BlockRegister.ACHIOTE_SLAB.get().defaultBlockState(), false);
        return true;
    }

    private boolean isValidGenerationPoint(WorldGenLevel level, BlockPos pos)
    {
        Block block = level.getBlockState(pos).getBlock();
        Block blockBelow = level.getBlockState(pos.below()).getBlock();

        return (block instanceof AirBlock) && (blockBelow.defaultBlockState().is(BlockTags.DIRT));
    }

    private void generateConnectedFence(WorldGenLevel worldIn, RandomSource rand, BlockPos pos, Direction direction, boolean isLeft)
    {
        Direction direction1;
        if (isLeft)
        {
            direction1 = DirectionHelper.getLeftDirection(direction);
        }
        else
        {
            direction1 = DirectionHelper.getRightDirection(direction);
        }
        BooleanProperty property = getPropertyFromDirection(direction1);

        BlockState state = BlockRegister.MORICHE_PALM_FENCE.get().defaultBlockState().setValue(property, true);
        ModFeatureUtils.generateBlock(worldIn, pos, rand, state, false);
    }

    private BooleanProperty getPropertyFromDirection(Direction direction)
    {
        BooleanProperty property;
        switch (direction)
        {
            case WEST -> property = FenceBlock.EAST;
            case EAST -> property = FenceBlock.WEST;
            case SOUTH -> property = FenceBlock.NORTH;
            default -> property = FenceBlock.SOUTH;
        }

        return property;
    }
}
