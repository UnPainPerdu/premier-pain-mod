package com.unpainperdu.premierpainmod.level.world.block.vegetation.twoBlockHeight;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstractBlock.AbstractTallGrass;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DeadTallGrass extends AbstractTallGrass
{
    public static final MapCodec<DeadTallGrass> CODEC = simpleCodec(DeadTallGrass::new);

    public DeadTallGrass(Properties properties)
    {
        super(properties, BlockTags.SAND);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context)
    {
        return Block.box(0,0,0,16,16,16);
    }

    @Override
    public MapCodec<DeadTallGrass> codec()
    {
        return CODEC;
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity)
    {
        Vec3 vec3 = new Vec3(0.85, 0.85, 0.85);
        entity.makeStuckInBlock(state, vec3);
    }
}
