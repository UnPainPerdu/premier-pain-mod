package com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.decorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.ModBlockStateProperties;
import com.unpainperdu.premierpainmod.util.register.tree.TreeDecoratorTypeRegister;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FallingLeavesDecorator extends TreeDecorator
{
    public static final MapCodec<FallingLeavesDecorator> CODEC = RecordCodecBuilder.mapCodec(
            builder -> builder.group(
                            Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter(fld -> fld.probability),
                            BlockStateProvider.CODEC.fieldOf("falling_leaves_blockstate").forGetter(fld -> fld.fallingLeaves)
                    )
                    .apply(builder, FallingLeavesDecorator::new));
    private final float probability;
    private final BlockStateProvider fallingLeaves;

    public FallingLeavesDecorator(float probability, BlockStateProvider fallingLeaves)
    {
        this.probability = probability;
        this.fallingLeaves = fallingLeaves;
    }

    @Override
    protected @NotNull TreeDecoratorType<?> type()
    {
        return TreeDecoratorTypeRegister.FALLING_LEAVES.get();
    }

    @Override
    public void place(@NotNull Context context)
    {
        RandomSource rand = context.random();
        List<BlockPos> leavesPos = context.leaves();
        for (BlockPos pos : leavesPos)
        {
            if (context.isAir(pos.below()))
            {
                if (rand.nextFloat() < this.probability)
                {
                    generateFallingLeaves(context, rand, pos.below());
                }
            }
        }

    }

    private void generateFallingLeaves(Context context, RandomSource rand, BlockPos firstFallingLeavesPos)
    {
        int fallingLeavesHeight = RandomUtil.getRandomPositiveIntInRange(6, rand) + 1;

        for (int i = 0; i < fallingLeavesHeight; i++)
        {
            if (!context.isAir(firstFallingLeavesPos.below(i)))
            {
                fallingLeavesHeight = i - 1;
                break;
            }
        }

        for (int i = 0; i < fallingLeavesHeight; i++)
        {
            if (!(i == fallingLeavesHeight - 1))
            {
                context.setBlock(firstFallingLeavesPos.below(i), this.fallingLeaves.getState(rand, firstFallingLeavesPos.below(i)).setValue(ModBlockStateProperties.BOTTOM_PART, false));
            }
            else
            {
                context.setBlock(firstFallingLeavesPos.below(i), this.fallingLeaves.getState(rand, firstFallingLeavesPos.below(i)));
            }
        }
    }
}
