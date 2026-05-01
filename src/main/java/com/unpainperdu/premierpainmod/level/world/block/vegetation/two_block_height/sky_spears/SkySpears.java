package com.unpainperdu.premierpainmod.level.world.block.vegetation.two_block_height.sky_spears;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractTallGrass;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class SkySpears extends AbstractTallGrass
{
    public static final MapCodec<SkySpears> CODEC = simpleCodec(SkySpears::new);

    public SkySpears(Properties properties)
    {
        super(properties, BlockTags.DIRT);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random)
    {
        if (RandomUtil.getRandomIntInRange(100, random) >= 65)
        {
            if (state.getValue(SkySpears.HALF) == DoubleBlockHalf.UPPER && level.getBlockState(pos.above()).isAir())
            {
               level.setBlock(pos.above(), BlockRegister.SKY_SPEARS_FLOWER.get().defaultBlockState(), 2);
            }
        }
    }

    @Override
    public MapCodec<SkySpears> codec()
    {
        return CODEC;
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state)
    {
        return true;
    }
}