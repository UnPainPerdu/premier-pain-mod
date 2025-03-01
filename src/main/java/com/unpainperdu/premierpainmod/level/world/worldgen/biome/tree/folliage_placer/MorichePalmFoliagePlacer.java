package com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.folliage_placer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.unpainperdu.premierpainmod.util.register.tree.FoliagePlacerTypesRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

import java.util.Arrays;
import java.util.List;

public class MorichePalmFoliagePlacer extends FoliagePlacer
{
    private final int height;

    public static final MapCodec<MorichePalmFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            foliagePlacerParts(instance)
                    .and(Codec.intRange(0,16).fieldOf("height")
                            .forGetter(fp -> fp.height))
                    .apply(instance, MorichePalmFoliagePlacer::new));

    public MorichePalmFoliagePlacer(IntProvider radius, IntProvider offset, int height)
    {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type()
    {
        return FoliagePlacerTypesRegister.MORICHE_PALM_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random, TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset)
    {
        //0 for distance is at the top of logs. Don't touch localY
        // range 2 => 5*5
        createLeavesLayer(level, blockSetter, random, config, attachment.pos().above(1), 2, 0,
                Arrays.asList(
                        1,3,
                        5,9,
                        15,19,
                        21,23
                ));
        createLeavesLayer(level, blockSetter, random, config, attachment.pos().above(0), 3, 0,
                Arrays.asList(
                        0,2,4,6,
                        14,20,
                        28,34,
                        42,44,46,48
                ));
        createLeavesLayer(level, blockSetter, random, config, attachment.pos().above(-1), 2, 0,
                Arrays.asList(
                        0,4,
                        20,24
                ));
        createLeavesLayer(level, blockSetter, random, config, attachment.pos().above(-2), 2, 0,
                Arrays.asList(
                        0,4,
                        20,24
                ));
        createLeavesLayer(level, blockSetter, random, config, attachment.pos().above(-3), 2, 0,
                Arrays.asList(
                        0,1,3,4,
                        5,9,
                        15,19,
                        20,21,23,24
                ));
        createLeavesLayer(level, blockSetter, random, config, attachment.pos().above(-4), 2, 0,
                Arrays.asList(
                        0,1,3,4,
                        5,9,
                        15,19,
                        20,21,23,24
                ));
        createLeavesLayer(level, blockSetter, random, config, attachment.pos().above(-5), 1, 0,
                Arrays.asList());
        createLeavesLayer(level, blockSetter, random, config, attachment.pos().above(-6), 1, 0,
                Arrays.asList(
                        0,2,
                        6,8
                ));
        createLeavesLayer(level, blockSetter, random, config, attachment.pos().above(-7), 1, 0,
                Arrays.asList(
                        0,2,
                        6,8
                ));

    }

    @Override
    public int foliageHeight(RandomSource random, int height, TreeConfiguration config)
    {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, boolean large)
    {

        return random.nextInt(10) == 0;
    }

    private void createLeavesLayer(LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, BlockPos pos, int range, int localY, List<Integer> airBlockZone)
    {
        int i = 0;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for (int j = -range; j <= range; j++)
        {
            for (int k = -range; k <= range; k++)
            {
                if (!this.shouldSkipLocationSigned(random, j, localY, k, range, false) && !airBlockZone.contains(i))
                {
                    blockpos$mutableblockpos.setWithOffset(pos, j, localY, k);
                    tryPlaceLeaf(level, foliageSetter, random, config, blockpos$mutableblockpos);
                }
                i++;
            }
        }
    }
}
