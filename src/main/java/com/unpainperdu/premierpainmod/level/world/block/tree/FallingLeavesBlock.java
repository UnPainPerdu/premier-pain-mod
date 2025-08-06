package com.unpainperdu.premierpainmod.level.world.block.tree;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.ModBlockStateProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class FallingLeavesBlock extends Block implements SimpleWaterloggedBlock
{
    public static final MapCodec<FallingLeavesBlock> CODEC = simpleCodec(FallingLeavesBlock::new);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty BOTTOM_PART = ModBlockStateProperties.BOTTOM_PART;

    public FallingLeavesBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(BOTTOM_PART, true)
                .setValue(WATERLOGGED, false)
        );
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(BOTTOM_PART, WATERLOGGED);
    }
}
