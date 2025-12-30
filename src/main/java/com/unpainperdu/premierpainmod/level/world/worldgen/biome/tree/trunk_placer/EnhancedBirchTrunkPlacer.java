package com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.trunk_placer;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.unpainperdu.premierpainmod.util.register.tree.TrunkPlacerTypesRegister;
import com.unpainperdu.premierpainmod.util.tool_kit.DirectionHelper;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.BiConsumer;

public class EnhancedBirchTrunkPlacer extends TrunkPlacer
{
    public static final MapCodec<EnhancedBirchTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            trunkPlacerParts(instance).apply(instance, EnhancedBirchTrunkPlacer::new));

    public EnhancedBirchTrunkPlacer(int baseHeight, int heightRandA, int heightRandB)
    {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected @NotNull TrunkPlacerType<?> type()
    {
        return TrunkPlacerTypesRegister.ENHANCED_BIRCH_TRUNK_PLACER.get();
    }

    @Override
    public @NotNull List<FoliagePlacer.FoliageAttachment> placeTrunk(
            @NotNull LevelSimulatedReader level,
            @NotNull BiConsumer<BlockPos, BlockState> blockSetter,
            @NotNull RandomSource random,
            int freeTreeHeight,
            BlockPos pos,
            @NotNull TreeConfiguration config
    )
    {
        setDirtAt(level, blockSetter, random, pos.below(), config);

        for (int i = 0; i < freeTreeHeight; i++)
        {
            BlockPos currentLogPos = pos.above(i);
            this.placeLog(level, blockSetter, random, currentLogPos, config);
        }

        int limProba1 = RandomUtil.getRandomPositiveIntInRange(10, random);
        int limProba2 = RandomUtil.getRandomPositiveIntInRange(10, random);
        if (limProba1 < 6 && freeTreeHeight > 5)
        {
            int limbWantedHeight = (freeTreeHeight / 5) * 4;
            createLimb(level, blockSetter, random, pos, config, limbWantedHeight);
        }
        if (limProba2 < 6 && freeTreeHeight > 9)
        {
            int limbWantedHeight = ((freeTreeHeight / 5) * 3);
            createLimb(level, blockSetter, random, pos, config, limbWantedHeight);
        }

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pos.above(freeTreeHeight), 0, false));
    }

    private void createLimb(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, BlockPos originPos, TreeConfiguration config, int limbWantedHeight)
    {
        Direction direction = DirectionHelper.getRandomDirection(random);
        BlockPos startLog = originPos.above(limbWantedHeight);
        BlockPos limbLog = startLog.relative(direction);
        this.placeLog(level, blockSetter, random,limbLog, config,
                blockState -> blockState.trySetValue(RotatedPillarBlock.AXIS, DirectionHelper.getLogAxisFromPos(startLog, limbLog))
        );
    }
}
