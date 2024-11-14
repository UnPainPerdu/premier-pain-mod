package com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.folliage_placer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.unpainperdu.premierpainmod.util.register.tree.FoliagePlacerTypesRegister;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class MountainCurrantFoliagePlacer extends FoliagePlacer
{
    private final int height;

    public static final MapCodec<MountainCurrantFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(mountainCurrantFoliagePlacerInstance ->
            foliagePlacerParts(mountainCurrantFoliagePlacerInstance)
                    .and(Codec.intRange(0,16).fieldOf("height")
                            .forGetter(fp -> fp.height))
                    .apply(mountainCurrantFoliagePlacerInstance, MountainCurrantFoliagePlacer::new));

    public MountainCurrantFoliagePlacer(IntProvider radius, IntProvider offset, int height)
    {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type()
    {
        return FoliagePlacerTypesRegister.MOUNTAIN_CURRANT_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random, TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset)
    {
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos().above(-2), 2, 2, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos().above(-3), 2, 2, attachment.doubleTrunk());
        this.placeLeavesRow(level, blockSetter, random, config, attachment.pos().above(-4), 2, 2, attachment.doubleTrunk());
    }

    @Override
    public int foliageHeight(RandomSource random, int height, TreeConfiguration config)
    {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, boolean large)
    {

        return (localX == range || localZ == range) && (random.nextInt(3) == 0 || localY == 0);
    }
}
