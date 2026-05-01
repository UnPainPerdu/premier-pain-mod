package com.unpainperdu.premierpainmod.level.world.block.all_materials_block.sit.adaptable;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractAdaptableSit;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.AdaptableSitShape;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import org.jetbrains.annotations.NotNull;

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
    public @NotNull MapCodec<? extends AbstractAdaptableSit> codec()
    {
        return CODEC;
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType)
    {
        return false;
    }
}