package com.unpainperdu.premierpainmod.level.world.entity.seat;

import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ToiletSeatEntity extends SeatEntity
{
    public ToiletSeatEntity(EntityType<SeatEntity> type, Level level)
    {
        super(type, level);
    }

    public ToiletSeatEntity(Level level, BlockPos pos)
    {
        super(AllInOneEntityRegister.TOILET_SEAT_ENTITY.get(), level);
        BlockState state = level.getBlockState(pos);
        double xPos = pos.getX() + 0.5D;
        double yPos = pos.getY() + 0.5D;
        double zPos = pos.getZ() + 0.5D;
        if (state.hasProperty(HorizontalDirectionalBlock.FACING))
        {
            switch (state.getValue(HorizontalDirectionalBlock.FACING))
            {
                case NORTH -> zPos += 0.25D;
                case WEST -> xPos += 0.25D;
                case SOUTH -> zPos -= 0.25D;
                default -> xPos -= 0.25D;
            }
        }
        setPos(xPos, yPos, zPos);
        noPhysics = true;
    }
}
