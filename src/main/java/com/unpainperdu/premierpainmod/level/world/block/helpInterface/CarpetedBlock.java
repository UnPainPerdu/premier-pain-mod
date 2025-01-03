package com.unpainperdu.premierpainmod.level.world.block.helpInterface;

import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.VillagerCarpetColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public interface CarpetedBlock
{
    public VillagerCarpetColor getCarpetColor(BlockState state);

    public void setCarpetColor(Level level, BlockPos pos, BlockState state, VillagerCarpetColor newColor);
}
