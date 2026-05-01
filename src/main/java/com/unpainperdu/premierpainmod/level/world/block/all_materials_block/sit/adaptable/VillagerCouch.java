package com.unpainperdu.premierpainmod.level.world.block.all_materials_block.sit.adaptable;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractAdaptableSit;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.ModBlockStateProperties;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.AdaptableSitShape;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.VillagerCarpetColor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import org.jetbrains.annotations.NotNull;

public class VillagerCouch extends AbstractAdaptableSit //TODO, transform it in simple a BE fusion with seat entity ? child seat entity spawn if no seat entity and dispawn only if no carpet ?
{
    public static final EnumProperty<VillagerCarpetColor> CARPET_COLOR = ModBlockStateProperties.VILLAGER_CARPET_COLOR;
    public static final MapCodec<VillagerCouch> CODEC = simpleCodec(VillagerCouch::new);

    public VillagerCouch(Properties properties)
    {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition
                        .any()
                        .setValue(FACING, Direction.NORTH)
                        .setValue(ADAPTABLE_SIT, AdaptableSitShape.ALONE)
                        .setValue(WATERLOGGED, Boolean.FALSE)
                        .setValue(CARPET_COLOR, VillagerCarpetColor.WHITE)
        );
    }

    @Override
    public @NotNull MapCodec<? extends AbstractAdaptableSit> codec()
    {
        return CODEC;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(ADAPTABLE_SIT, FACING, WATERLOGGED, CARPET_COLOR);
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType)
    {
        return false;
    }
}