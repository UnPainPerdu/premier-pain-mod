package com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockHeight;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstractBlock.AbstractTwoBlockHeightBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VillagerStatue extends AbstractTwoBlockHeightBlock
{
    public static final MapCodec<VillagerStatue> CODEC = simpleCodec(VillagerStatue::new);

    public VillagerStatue(Properties pProperties)
    {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(HALF, DoubleBlockHalf.LOWER)
                .setValue(WATERLOGGED, Boolean.FALSE));
    }
    @Override
    public MapCodec<VillagerStatue> codec() {
        return CODEC;
    }
    private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 16, 12);
    //forme hit-box, début-fin x y z

    //Applique la hit-box
    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_)
    {
        return SHAPE;
    }

}