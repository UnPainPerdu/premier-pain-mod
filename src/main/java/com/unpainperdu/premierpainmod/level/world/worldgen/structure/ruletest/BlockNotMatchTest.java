package com.unpainperdu.premierpainmod.level.world.worldgen.structure.ruletest;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.util.register.structure.RuleTestRegister;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTestType;
import org.jetbrains.annotations.NotNull;

public class BlockNotMatchTest extends RuleTest
{
    public static final MapCodec<BlockNotMatchTest> CODEC = BuiltInRegistries.BLOCK
            .byNameCodec()
            .fieldOf("block")
            .xmap(BlockNotMatchTest::new, test -> test.block);
    private final Block block;

    public BlockNotMatchTest(Block block)
    {
        this.block = block;
    }

    @Override
    public boolean test(BlockState state, @NotNull RandomSource random)
    {
        return !state.is(this.block);
    }

    @Override
    protected @NotNull RuleTestType<?> getType()
    {
        return RuleTestRegister.BLOCK_NOT_MATCH.get();
    }
}
