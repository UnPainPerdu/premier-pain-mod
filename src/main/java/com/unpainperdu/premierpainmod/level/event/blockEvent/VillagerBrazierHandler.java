package com.unpainperdu.premierpainmod.level.event.blockEvent;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight.VillagerBrazier;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.AABB;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent.RightClickBlock;

import static com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight.AbstactTwoBlockHeightBlock.HALF;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@EventBusSubscriber(modid = PremierPainMod.MODID)
public class VillagerBrazierHandler
{
    private VillagerBrazierHandler() {}

    @SubscribeEvent
    public static void onRightClickBlock(RightClickBlock event)
    {
        Player player = event.getEntity();

        if (!event.getLevel().isClientSide && !player.isShiftKeyDown())
        {
            Level level = event.getLevel();
            BlockPos pos = event.getPos();
            BlockState state = level.getBlockState(pos);
            Block block = level.getBlockState(pos).getBlock();

            if ((isPlayerInRange(player, pos)) && (block instanceof VillagerBrazier))
            {
                if(player.getMainHandItem().getItem() instanceof FlintAndSteelItem && !state.getValue(VillagerBrazier.WATERLOGGED) && !state.getValue(VillagerBrazier.LIT) && (state.getValue(HALF) == DoubleBlockHalf.UPPER))
                {
                    level.setBlock(pos, state.setValue(VillagerBrazier.LIT, TRUE), 3);
                    level.playSound(null, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    player.getMainHandItem().hurtAndBreak(1, player, LivingEntity.getSlotForHand(event.getHand()));
                }
                if((player.getMainHandItem().getItem() instanceof ShovelItem) && (!state.getValue(VillagerBrazier.WATERLOGGED)) && (state.getValue(VillagerBrazier.LIT)) && (state.getValue(HALF) == DoubleBlockHalf.UPPER))
                {
                    level.setBlock(pos, state.setValue(VillagerBrazier.LIT, FALSE), 3);
                    level.playSound(null, pos, SoundEvents.GENERIC_EXTINGUISH_FIRE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    player.getMainHandItem().hurtAndBreak(1, player, LivingEntity.getSlotForHand(event.getHand()));
                }
            }
        }
    }

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
