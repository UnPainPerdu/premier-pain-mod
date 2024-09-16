package com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.AdaptableSit;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstractBlock.AbstractAdaptableSit;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.ModBlockStateProperties;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.AdaptableSitShape;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.VillagerCarpetColor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VillagerCouch extends AbstractAdaptableSit
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
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context)
    {
        return Block.box(0, 0, 0, 16, 8, 16);
    }

    @Override
    public MapCodec<? extends AbstractAdaptableSit> codec()
    {
        return CODEC;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(ADAPTABLE_SIT, FACING, WATERLOGGED, CARPET_COLOR);
    }
}
