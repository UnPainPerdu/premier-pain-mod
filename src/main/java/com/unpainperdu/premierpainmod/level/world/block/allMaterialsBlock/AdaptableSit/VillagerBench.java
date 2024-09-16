package com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.AdaptableSit;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstractBlock.AbstractAdaptableSit;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.AdaptableSitShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VillagerBench extends AbstractAdaptableSit
{
    public static final MapCodec<VillagerBench> CODEC = simpleCodec(VillagerBench::new);

    public VillagerBench(Properties properties)
    {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition
                        .any()
                        .setValue(FACING, Direction.NORTH)
                        .setValue(ADAPTABLE_SIT, AdaptableSitShape.ALONE)
                        .setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context)
    {
        VoxelShape shape;
        if(state.getValue(FACING) == Direction.NORTH)
        {
            shape = Shapes.or(Block.box(0, 4, 1, 16, 7, 14), Block.box(0, 7, 1, 16, 16, 3));
        }
        else if (state.getValue(FACING) == Direction.EAST)
        {
            shape = Shapes.or(Block.box(2, 4, 0, 15, 7, 16), Block.box(13, 7, 0, 15, 16, 16));
        }
        else if (state.getValue(FACING) == Direction.WEST)
        {
            shape = Shapes.or(Block.box(1, 4, 0, 14, 7, 16), Block.box(1, 7, 0, 3, 16, 16));
        }
        else
        {
            shape = Shapes.or(Block.box(0, 4, 2, 16, 7, 15), Block.box(0, 7, 13, 16, 16, 15));
        }
        return shape;
    }

    @Override
    public MapCodec<? extends AbstractAdaptableSit> codec()
    {
        return CODEC;
    }
}
