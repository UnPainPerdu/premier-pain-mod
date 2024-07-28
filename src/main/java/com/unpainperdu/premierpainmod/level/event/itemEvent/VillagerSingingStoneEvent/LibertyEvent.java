package com.unpainperdu.premierpainmod.level.event.itemEvent.VillagerSingingStoneEvent;

import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class LibertyEvent extends AbstractVillagerSingingStoneEvent{
    public LibertyEvent()
    {
        super("LibertyEvent");
    }

    @Override
    public void castEvent(Level level, Player player, InteractionHand usedHand)
    {
        BlockPos pos = player.getBlockPosBelowThatAffectsMyMovement();
        pos = pos.above(30);
        level.setBlock(pos, BlockRegister.LIBERTY_BLOCK.get().defaultBlockState(), 0);
    }
}
