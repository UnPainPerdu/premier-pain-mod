package com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.trunk_placer;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.unpainperdu.premierpainmod.util.register.tree.TrunkPlacerTypesRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class MountainCurrantTrunkPlacer extends TrunkPlacer
{
    public static final MapCodec<MountainCurrantTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(mountainCurrantTrunkPlacerInstance ->
            trunkPlacerParts(mountainCurrantTrunkPlacerInstance).apply(mountainCurrantTrunkPlacerInstance, MountainCurrantTrunkPlacer::new));

    public MountainCurrantTrunkPlacer(int baseHeight, int heightRandA, int heightRandB)
    {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type()
    {
        return TrunkPlacerTypesRegister.MOUNTAIN_CURRANT_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(
            LevelSimulatedReader level,
            BiConsumer<BlockPos, BlockState> blockSetter,
            RandomSource random,
            int freeTreeHeight,
            BlockPos pos,
            TreeConfiguration config
    )
    {
        setDirtAt(level, blockSetter, random, pos.below(), config);

        for (int i = 0; i < freeTreeHeight; i++)
        {
            this.placeLog(level, blockSetter, random, pos.above(i), config);
        }

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pos.above(freeTreeHeight), 0, false));
    }
}
