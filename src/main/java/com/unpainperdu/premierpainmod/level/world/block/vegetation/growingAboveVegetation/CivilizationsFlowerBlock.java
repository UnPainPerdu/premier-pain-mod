package com.unpainperdu.premierpainmod.level.world.block.vegetation.growingAboveVegetation;

import com.mojang.serialization.MapCodec;

public class CivilizationsFlowerBlock extends AbstractGrowingAboveVegetation
{
    public static final MapCodec<CivilizationsFlowerBlock> CODEC = simpleCodec(CivilizationsFlowerBlock::new);

    public CivilizationsFlowerBlock(Properties properties)
    {
        super(properties, 5);
    }

    @Override
    public MapCodec<CivilizationsFlowerBlock> codec()
    {
        return CODEC;
    }
}
