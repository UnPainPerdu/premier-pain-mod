package com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.trunk_placer;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.unpainperdu.premierpainmod.util.register.tree.TrunkPlacerTypesRegister;
import com.unpainperdu.premierpainmod.util.tool_kit.DirectionHelper;
import com.unpainperdu.premierpainmod.util.tool_kit.PosHelper;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.BiConsumer;

public class WeepingWillowTrunkPlacer extends TrunkPlacer
{
    public static final MapCodec<WeepingWillowTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            trunkPlacerParts(instance).apply(instance, WeepingWillowTrunkPlacer::new));

    public WeepingWillowTrunkPlacer(int baseHeight, int heightRandA, int heightRandB)
    {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected @NotNull TrunkPlacerType<?> type()
    {
        return TrunkPlacerTypesRegister.WEEPING_WILLOW_TRUNK_PLACER.get();
    }

    @Override
    public @NotNull List<FoliagePlacer.FoliageAttachment> placeTrunk(
            @NotNull LevelSimulatedReader level,
            @NotNull BiConsumer<BlockPos, BlockState> blockSetter,
            @NotNull RandomSource random,
            int freeTreeHeight,
            @NotNull BlockPos startTrunkPos,
            @NotNull TreeConfiguration config
    )
    {
        setDirtAt(level, blockSetter, random, startTrunkPos.below(), config);
        Direction direction = DirectionHelper.getRandomDirection(random);

        BlockPos endTrunkPos = getEndPos(random, direction, freeTreeHeight, startTrunkPos);

        List<BlockPos> trunkPosList = PosHelper.getBlockPosLine(startTrunkPos, endTrunkPos);
        int logTopPlace = trunkPosList.size();
        int logPlaced = 0;

        int randomChance = RandomUtil.getRandomPositiveIntInRange(100, random);

        for (BlockPos pos : trunkPosList)
        {
            this.placeLog(level, blockSetter, random, pos, config);
            this.placeLog(level, blockSetter, random, pos.above(), config);
            logPlaced += 1;
            int prog = logPlaced * 100 / logTopPlace;
            if (logPlaced == 1)
            {
                this.placeLog(level, blockSetter, random, pos.north(), config);
                this.placeLog(level, blockSetter, random, pos.west(), config);
                this.placeLog(level, blockSetter, random, pos.south(), config);
                this.placeLog(level, blockSetter, random, pos.east(), config);
            }
            else if (prog < 30)
            {
                this.placeLog(level, blockSetter, random, pos.relative(direction.getOpposite()), config);
                this.placeLog(level, blockSetter, random, pos.above(), config);
            }
            else if (prog < 90 && prog / 2 < randomChance)
            {
                this.placeLog(level, blockSetter, random, pos.below(), config);
            }
        }

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(endTrunkPos, 0, false));
    }

    private BlockPos getEndPos(RandomSource rand, Direction direction, int height, BlockPos startTrunkPos)
    {
        int xOffSet = RandomUtil.getRandomPositiveIntInRange(height, rand);
        int zOffSet = RandomUtil.getRandomPositiveIntInRange(height, rand);
        int finalX = startTrunkPos.getX();
        int finalY = startTrunkPos.getY() + height;
        int finalZ = startTrunkPos.getZ();
        switch (direction)
        {
            case NORTH ->
            {
                finalX += xOffSet;
                finalZ += zOffSet;
            }
            case WEST ->
            {
                finalX -= xOffSet;
                finalZ += zOffSet;
            }
            case SOUTH ->
            {
                finalX -= xOffSet;
                finalZ -= zOffSet;
            }
            default ->
            {
                finalX += xOffSet;
                finalZ -= zOffSet;
            }
        }

        return new BlockPos(finalX, finalY, finalZ);
    }
}
