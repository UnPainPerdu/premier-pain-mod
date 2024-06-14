package com.unpainperdu.premierpainmod.level.world.entity.blockEntity;

import com.unpainperdu.premierpainmod.util.register.BlockEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SeatEntity extends BlockEntity
{
    public SeatEntity( BlockPos pPos, BlockState pBlockState)
    {
        super(BlockEntityRegister.SEAT_ENTITY.get(), pPos, pBlockState);
    }
}
