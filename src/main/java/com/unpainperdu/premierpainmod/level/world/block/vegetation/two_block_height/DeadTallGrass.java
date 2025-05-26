package com.unpainperdu.premierpainmod.level.world.block.vegetation.two_block_height;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractTallGrass;
import net.minecraft.tags.BlockTags;

public class DeadTallGrass extends AbstractTallGrass
{
    public static final MapCodec<DeadTallGrass> CODEC = simpleCodec(DeadTallGrass::new);

    public DeadTallGrass(Properties properties)
    {
        super(properties, BlockTags.SAND);
    }

    @Override
    public MapCodec<DeadTallGrass> codec()
    {
        return CODEC;
    }
}
