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
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class EnhancedBirchFoliagePlacer extends FoliagePlacer
{
    private final int height;

    public static final MapCodec<EnhancedBirchFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            foliagePlacerParts(instance)
                    .and(Codec.intRange(0, 16).fieldOf("height")
                            .forGetter(fp -> fp.height))
                    .apply(instance, EnhancedBirchFoliagePlacer::new));

    public EnhancedBirchFoliagePlacer(IntProvider radius, IntProvider offset, int height)
    {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected @NotNull FoliagePlacerType<?> type()
    {
        return FoliagePlacerTypesRegister.ENHANCED_BIRCH_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(@NotNull LevelSimulatedReader level, @NotNull FoliageSetter blockSetter, @NotNull RandomSource random, @NotNull TreeConfiguration config, int maxFreeTreeHeight, @NotNull FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset)
    {
        int customOffset = -foliageRadius / 2;
        List<BlockPos> leavesPos = generateCube(attachment.pos(), foliageRadius);
        leavesPos.forEach(pos ->
        {
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
            mutableBlockPos.setWithOffset(pos, customOffset, offset-2, customOffset);
            tryPlaceLeaf(level, blockSetter, random, config, mutableBlockPos);
        });
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

    public static List<BlockPos> generateCube(BlockPos originPos, int sideLong)
    {
        List<BlockPos> poss = new ArrayList<>();
        for (int x = 0; x < sideLong; x++)
        {
            for (int y = 0; y < sideLong; y++)
            {
                for (int z = 0; z < sideLong; z++)
                {
                    int count = 0;
                    if (x == 0 || x == sideLong - 1) count++;
                    if (y == 0 || y == sideLong - 1) count++;
                    if (z == 0 || z == sideLong - 1) count++;
                    if (count < 2)
                    {
                        poss.add(new BlockPos(originPos.getX() + x, originPos.getY() + y, originPos.getZ() + z));
                    }
                }
            }
        }
        return poss;
    }
}
