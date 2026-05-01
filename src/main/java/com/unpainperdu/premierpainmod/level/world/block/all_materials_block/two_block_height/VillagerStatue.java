package com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractTwoBlockHeightBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

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
    public @NotNull MapCodec<VillagerStatue> codec() {
        return CODEC;
    }
    private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 16, 12);
    //forme hit-box, début-fin x y z

    //Applique la hit-box
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter blockGetter, @NotNull BlockPos pos, @NotNull CollisionContext context)
    {
        return SHAPE;
    }

    @Override
    protected boolean isPathfindable(@NotNull BlockState state, @NotNull PathComputationType pathComputationType)
    {
        return false;
    }
}