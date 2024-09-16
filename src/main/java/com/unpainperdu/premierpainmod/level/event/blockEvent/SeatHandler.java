package com.unpainperdu.premierpainmod.level.event.blockEvent;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.abstractBlock.AbstractAdaptableSit;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockHeight.VillagerThroneChairBlock;
import com.unpainperdu.premierpainmod.level.world.entity.blockEntity.SeatEntity;
import com.unpainperdu.premierpainmod.util.seat.SeatUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.AABB;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.neoforged.neoforge.event.level.BlockEvent.BreakEvent;

import static com.unpainperdu.premierpainmod.level.world.block.abstractBlock.AbstractTwoBlockHeightBlock.HALF;

@EventBusSubscriber(modid = PremierPainMod.MOD_ID)
public class SeatHandler
{
    private SeatHandler() {}

    @SubscribeEvent
    public static void onRightClickBlock(RightClickBlock event)
    {
        Player player = event.getEntity();

        if (!event.getLevel().isClientSide && !SeatUtil.isPlayerSitting(player) && !player.isShiftKeyDown())
        {
            Level level = event.getLevel();
            BlockPos pos = event.getPos();
            BlockState state = level.getBlockState(pos);
            Block block = state.getBlock();
            if(block instanceof VillagerThroneChairBlock)
            {
                if (state.getValue(HALF) == DoubleBlockHalf.UPPER)
                {
                    pos = pos.below();
                }
            }
            if (isValidBlock(level, pos, state, block) && isPlayerInRange(player, pos) && !SeatUtil.isOccupied(level, pos) && player.getMainHandItem().isEmpty())
            {
                SeatEntity sit = new SeatEntity(level, pos);
                if (SeatUtil.addSitEntity(level, pos, sit, player.position()))
                {
                    level.addFreshEntity(sit);
                    player.startRiding(sit);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onBreak(BreakEvent event)
    {
        if (!event.getLevel().isClientSide())
        {
            //BreakEvent gets a Level in its constructor, so the cast is safe
            SeatEntity entity = SeatUtil.getSitEntity((Level) event.getLevel(), event.getPos());
            SeatEntity bottomEntity = SeatUtil.getSitEntity((Level) event.getLevel(), event.getPos().below());

            if (entity != null)
            {
                SeatUtil.removeSitEntity((Level) event.getLevel(), event.getPos());
                entity.ejectPassengers();
            }
            if (bottomEntity != null)
            {
                SeatUtil.removeSitEntity((Level) event.getLevel(), event.getPos());
                bottomEntity.ejectPassengers();
            }
        }
    }

    /**
     * Returns whether or not the given block can be sat on
     *
     * @param level The level to check in
     * @param pos The position to check at
     * @param state The block state at the given position in the given level
     * @param block The block to check
     * @return true if the given block can be sat one, false otherwhise
     */
    private static boolean isValidBlock(Level level, BlockPos pos, BlockState state, Block block)
    {
        boolean isValid = (block instanceof VillagerChairBlock)
                        || (block instanceof VillagerThroneChairBlock)
                        || (block instanceof AbstractAdaptableSit)
                ;
        return isValid;
    }
    /**
     * Returns whether or not the player is close enough to the block to be able to sit on it
     *
     * @param player The player
     * @param pos The position of the block to sit on
     * @return true if the player is close enough, false otherwhise
     */
    private static boolean isPlayerInRange(Player player, BlockPos pos)
    {
        BlockPos playerPos = player.blockPosition();
        int blockReachDistance = 3;

        pos = BlockPos.containing(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D);

        AABB range = new AABB(pos.getX() + blockReachDistance, pos.getY() + blockReachDistance, pos.getZ() + blockReachDistance, pos.getX() - blockReachDistance, pos.getY() - blockReachDistance, pos.getZ() - blockReachDistance);

        playerPos = BlockPos.containing(playerPos.getX() + 0.5D, playerPos.getY() + 0.5D, playerPos.getZ() + 0.5D);
        return range.minX <= playerPos.getX() && range.minY <= playerPos.getY() && range.minZ <= playerPos.getZ() && range.maxX >= playerPos.getX() && range.maxY >= playerPos.getY() && range.maxZ >= playerPos.getZ();
    }
}