package com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.AdaptableSit;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstractBlock.AbstractAdaptableSit;

public class VillagerBench extends AbstractAdaptableSit
{
    public static final MapCodec<VillagerBench> CODEC = simpleCodec(VillagerBench::new);

    public VillagerBench(Properties properties)
    {
        super(properties);
    }

    @Override
    public MapCodec<? extends AbstractAdaptableSit> codec()
    {
        return CODEC;
    }
}
