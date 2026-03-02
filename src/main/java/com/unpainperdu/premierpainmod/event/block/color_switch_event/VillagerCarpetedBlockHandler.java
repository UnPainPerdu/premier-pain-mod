package com.unpainperdu.premierpainmod.event.block.color_switch_event;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.event.block.color_switch_event.util.DropEventColorHelper;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.VillagerTableBlock;
import com.unpainperdu.premierpainmod.level.world.block.help_interface.CarpetedBlock;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.VillagerCarpetColor;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
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

@EventBusSubscriber(modid = PremierPainMod.MOD_ID)
public class VillagerCarpetedBlockHandler
{
    private VillagerCarpetedBlockHandler() {}

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
            if ((isPlayerInRange(player, pos)) && (block instanceof CarpetedBlock))
            {

                ItemStack itemStack = player.getMainHandItem();
                Item item = itemStack.getItem();
                Block carpetBlock = Block.byItem(item);
                CarpetedBlock carpetedBlock = (CarpetedBlock) block;
                if((carpetBlock instanceof WoolCarpetBlock) && (carpetedBlock.getCarpetColor(state) == VillagerCarpetColor.NONE))
                {
                    if (!player.isCreative())
                    {
                        ItemStack newItemStack = player.getMainHandItem();
                        newItemStack.shrink(1);
                        player.setItemSlot(EquipmentSlot.MAINHAND, newItemStack);
                    }

                    carpetedBlock.setCarpetColor(level, pos, state, colorDetection((WoolCarpetBlock) carpetBlock));
                    level.playSound(null, pos, SoundEvents.WOOL_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    event.setCanceled(TRUE);
                }

                if ((item instanceof ShearsItem) && (state.getValue(VillagerTableBlock.COLOR) != VillagerCarpetColor.NONE))
                {
                    if (!player.isCreative())
                    {
                        DropEventColorHelper.dropCarpet(level, pos, state.getValue(VillagerTableBlock.COLOR));
                    }
                    carpetedBlock.setCarpetColor(level, pos, state, VillagerCarpetColor.NONE);
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
    private static VillagerCarpetColor colorDetection(WoolCarpetBlock carpetBlock)
    {
        switch (carpetBlock.getColor())
        {
            case WHITE : return VillagerCarpetColor.WHITE;
            case LIGHT_GRAY : return VillagerCarpetColor.LIGHT_GRAY;
            case GRAY : return VillagerCarpetColor.GRAY;
            case BLACK : return VillagerCarpetColor.BLACK;
            case BROWN : return VillagerCarpetColor.BROWN;
            case RED : return VillagerCarpetColor.RED;
            case ORANGE : return VillagerCarpetColor.ORANGE;
            case YELLOW : return VillagerCarpetColor.YELLOW;
            case LIME : return VillagerCarpetColor.LIME;
            case GREEN : return VillagerCarpetColor.GREEN;
            case CYAN : return VillagerCarpetColor.CYAN;
            case LIGHT_BLUE : return VillagerCarpetColor.LIGHT_BLUE;
            case BLUE : return VillagerCarpetColor.BLUE;
            case PURPLE : return VillagerCarpetColor.PURPLE;
            case MAGENTA : return VillagerCarpetColor.MAGENTA;
            case PINK : return VillagerCarpetColor.PINK;
            default: return VillagerCarpetColor.NONE;
        }
    }
}
