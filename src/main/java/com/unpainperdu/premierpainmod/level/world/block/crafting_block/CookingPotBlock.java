package com.unpainperdu.premierpainmod.level.world.block.crafting_block;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.crafting_block.CookingPotBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.Nullable;

public class CookingPotBlock extends BaseEntityBlock implements SimpleWaterloggedBlock
{
    public static final MapCodec<CookingPotBlock> CODEC = simpleCodec(CookingPotBlock::new);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public CookingPotBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec()
    {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new CookingPotBlockEntity(pos, state);
    }
}
