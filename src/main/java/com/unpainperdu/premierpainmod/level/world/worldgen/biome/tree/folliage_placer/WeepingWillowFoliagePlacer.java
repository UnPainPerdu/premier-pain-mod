package com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.folliage_placer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.unpainperdu.premierpainmod.util.register.tree.FoliagePlacerTypesRegister;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class WeepingWillowFoliagePlacer extends FoliagePlacer
{
    private final int height;

    public static final MapCodec<WeepingWillowFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            foliagePlacerParts(instance)
                    .and(Codec.intRange(0, 16).fieldOf("height")
                            .forGetter(fp -> fp.height))
                    .apply(instance, WeepingWillowFoliagePlacer::new));

    public WeepingWillowFoliagePlacer(IntProvider radius, IntProvider offset, int height)
    {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected @NotNull FoliagePlacerType<?> type()
    {
        return FoliagePlacerTypesRegister.WEEPING_WILLOW_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(@NotNull LevelSimulatedReader level, @NotNull FoliageSetter blockSetter, @NotNull RandomSource random, @NotNull TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset)
    {
        //0 for local y is at the top of logs.
        // range 2 => 5*5
        createLeavesLayer(level, blockSetter, random, config, attachment.pos(), 1, 2,
                List.of());
        createLeavesLayer(level, blockSetter, random, config, attachment.pos(), 2, 1,
                Arrays.asList(
                        0, 4,
                        20, 24
                ));
        createLeavesLayer(level, blockSetter, random, config, attachment.pos(), 3, 0,
                Arrays.asList(
                        0, 1, 5, 6,
                        7, 13,
                        35, 41,
                        42, 43, 45, 46
                ));
        createLeavesLayer(level, blockSetter, random, config, attachment.pos(), 4, -1,
                Arrays.asList(
                        0, 1, 2, 6, 7, 8,
                        9, 10, 17, 18,
                        19, 27,
                        54, 62,
                        63, 64, 70, 71,
                        72, 73, 74, 78, 79, 80
                ));
        createLeavesLayer(level, blockSetter, random, config, attachment.pos(), 3, -2,
                Arrays.asList(
                        0, 1, 5, 6,
                        7, 13,
                        35, 41,
                        42, 43, 45, 46
                ), 60);
    }

    @Override
    public int foliageHeight(@NotNull RandomSource random, int height, @NotNull TreeConfiguration config)
    {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, boolean large)
    {

        return random.nextInt(100) < 5;
    }

    private void createLeavesLayer(LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, BlockPos pos, int range, int localY, List<Integer> airBlockZone)
    {
        this.createLeavesLayer(level, foliageSetter, random, config, pos, range, localY, airBlockZone, 100);
    }

    private void createLeavesLayer(LevelSimulatedReader level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, BlockPos pos, int range, int localY, List<Integer> airBlockZone, int probability)
    {
        int i = 0;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        localY += 2;


        for (int j = -range; j <= range; j++)
        {
            for (int k = -range; k <= range; k++)
            {
                if (!this.shouldSkipLocationSigned(random, j, localY, k, range, false) && !airBlockZone.contains(i) && this.customShouldSkipLocation(random, probability))
                {
                    blockpos$mutableblockpos.setWithOffset(pos, j, localY, k);
                    tryPlaceLeaf(level, foliageSetter, random, config, blockpos$mutableblockpos);
                }
                i++;
            }
        }
    }

    private boolean customShouldSkipLocation(RandomSource rand, int probability)
    {
        int randomInt = RandomUtil.getRandomPositiveIntInRange(100, rand);

        return probability > randomInt;
    }
}
