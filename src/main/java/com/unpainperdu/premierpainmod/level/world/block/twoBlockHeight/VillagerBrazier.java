package com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VillagerBrazier extends AbstactTwoBlockHeightBlock
{
    public static final MapCodec<VillagerBrazier> CODEC = simpleCodec(VillagerBrazier::new);

    public VillagerBrazier(Properties pProperties)
    {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, Boolean.FALSE));
    }
    @Override
    public MapCodec<VillagerBrazier> codec() {
        return CODEC;
    }

    private static final VoxelShape UPPER_SHAPE = Block.box(2, 0, 2, 14, 4, 14);
    private static final VoxelShape BELOW_SHAPE = Block.box(2, 0, 2, 14, 16, 14);
    //forme hit-box, début-fin x y z

    //Applique la hit-box
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter p_60556_, BlockPos bPos, CollisionContext p_60558_)
    {
        DoubleBlockHalf doubleblockhalf = pState.getValue(HALF);
        if (doubleblockhalf == DoubleBlockHalf.UPPER)
        {
            return UPPER_SHAPE;
        }
        else
        {
            return BELOW_SHAPE;
        }

    }
}
