package com.unpainperdu.premierpainmod.level.world.block.vegetation.basicFlower;

import com.unpainperdu.premierpainmod.level.world.block.vegetation.VegetationUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class CuriosityFlower extends FlowerBlock
{
    public static final int MAX_FLOWER_STATE = 5;
    public static final IntegerProperty MAX_FLOWER_SPREAD = IntegerProperty.create("max_flower_spread", 0, MAX_FLOWER_STATE);

    public CuriosityFlower(Holder<MobEffect> pEffect, float pSeconds, Properties pProperties)
    {
        super(pEffect, pSeconds, pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(MAX_FLOWER_SPREAD, 0));
    }

    @Override
    protected void randomTick(BlockState blockState, ServerLevel level, BlockPos pos, RandomSource rand)
    {
        if(blockState.getValue(MAX_FLOWER_SPREAD) < MAX_FLOWER_STATE)
        {
            BlockPos newPos = VegetationUtil.getRandomPosWithSameY(pos, rand);
            newPos = VegetationUtil.checkAndChangeIfPosBad(newPos, level);
            if (!(newPos == null))
            {
                level.setBlock(pos, blockState.setValue(MAX_FLOWER_SPREAD, blockState.getValue(MAX_FLOWER_SPREAD) + 1), 4);
                level.setBlockAndUpdate(newPos, this.defaultBlockState().setValue(MAX_FLOWER_SPREAD, blockState.getValue(MAX_FLOWER_SPREAD) + 1));
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(MAX_FLOWER_SPREAD);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState pState)
    {
        return true;
    }
}
