package com.unpainperdu.premierpainmod.level.world.block.vegetation.crop;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractCropLikeBlock;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JellyShroomBlock extends AbstractCropLikeBlock
{
    public static final MapCodec<JellyShroomBlock> CODEC = simpleCodec(JellyShroomBlock::new);
    public static final EnumProperty<Direction> FACING = ModBlockStateProperties.DIRECTION;

    public JellyShroomBlock(Properties properties)
    {
        super(properties, 4, 0, BlockTags.DIRT);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(AGE, 0));
    }


    @Override
    protected @NotNull MapCodec<? extends AbstractCropLikeBlock> codec()
    {
        return CODEC;
    }

    @Override
    protected @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context)
    {
        //offset type declared at registration
        Vec3 vec3 = state.getOffset(pos);
        return Block.box(1, 0, 1, 15, 10, 15).move(vec3.x, vec3.y, vec3.z);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(AGE, FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
    }
}