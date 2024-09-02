package com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock;

import net.minecraft.world.level.block.Block;

public class CactusFlowerBlock extends Block
{

    public CactusFlowerBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any());
    }
}
