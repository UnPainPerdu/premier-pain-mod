package com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.AdaptableSit;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstractBlock.AbstractAdaptableSit;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.AdaptableSitShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

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
    public MapCodec<? extends AbstractAdaptableSit> codec()
    {
        return CODEC;
    }

    protected Boolean isWithSameDirection(LevelAccessor level, BlockPos pos, Direction directionWanted)
    {
        boolean flag = false;
        BlockState stateChecked = level.getBlockState(pos);
        if(stateChecked.getBlock() instanceof VillagerBench)
        {
            flag = stateChecked.getValue(FACING) == directionWanted;
        }
        return flag;
    }
}
