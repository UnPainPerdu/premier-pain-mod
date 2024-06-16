package com.unpainperdu.premierpainmod.level.event.blockEvent;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.VillagerTableBlock;
import com.unpainperdu.premierpainmod.level.world.block.state.properties.VillagerTableCarpetColor;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WoolCarpetBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import static java.lang.Boolean.TRUE;

@EventBusSubscriber(modid = PremierPainMod.MODID)
public class VillagerTableHandler
{
    private VillagerTableHandler() {}

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event)
    {
        Player player = event.getEntity();

        if (!event.getLevel().isClientSide && !player.isShiftKeyDown())
        {
            Level level = event.getLevel();
            BlockPos pos = event.getPos();
            BlockState state = level.getBlockState(pos);
            Block block = level.getBlockState(pos).getBlock();
            if ((isPlayerInRange(player, pos)) && (block instanceof VillagerTableBlock))
            {

                ItemStack itemStack =player.getMainHandItem();
                Item item = itemStack.getItem();
                Block carpetBlock = Block.byItem(item);
                if((carpetBlock instanceof WoolCarpetBlock) && (state.getValue(VillagerTableBlock.COLOR) == VillagerTableCarpetColor.NONE))
                {
                    level.setBlock(pos, state.setValue(VillagerTableBlock.COLOR, colorDedection((WoolCarpetBlock) carpetBlock)), 3);
                    level.playSound(null, pos, SoundEvents.WOOL_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    event.setCanceled(TRUE);
                }

                if ((item instanceof ShearsItem) && (state.getValue(VillagerTableBlock.COLOR) != VillagerTableCarpetColor.NONE))
                {
                    level.setBlock(pos, state.setValue(VillagerTableBlock.COLOR, VillagerTableCarpetColor.NONE), 3);
                    level.playSound(null, pos, SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F);
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
    private static VillagerTableCarpetColor colorDedection(WoolCarpetBlock carpetBlock)
    {
        switch (carpetBlock.getColor())
        {
            case WHITE : return VillagerTableCarpetColor.WHITE;
            case LIGHT_GRAY : return VillagerTableCarpetColor.LIGHT_GRAY;
            case GRAY : return VillagerTableCarpetColor.GRAY;
            case BLACK : return VillagerTableCarpetColor.BLACK;
            case BROWN : return VillagerTableCarpetColor.BROWN;
            case RED : return VillagerTableCarpetColor.RED;
            case ORANGE : return VillagerTableCarpetColor.ORANGE;
            case YELLOW : return VillagerTableCarpetColor.YELLOW;
            case LIME : return VillagerTableCarpetColor.LIME;
            case GREEN : return VillagerTableCarpetColor.GREEN;
            case CYAN : return VillagerTableCarpetColor.CYAN;
            case LIGHT_BLUE : return VillagerTableCarpetColor.LIGHT_BLUE;
            case BLUE : return VillagerTableCarpetColor.BLUE;
            case PURPLE : return VillagerTableCarpetColor.PURPLE;
            case MAGENTA : return VillagerTableCarpetColor.MAGENTA;
            case PINK : return VillagerTableCarpetColor.PINK;
            default: return VillagerTableCarpetColor.NONE;
        }
    }
}
