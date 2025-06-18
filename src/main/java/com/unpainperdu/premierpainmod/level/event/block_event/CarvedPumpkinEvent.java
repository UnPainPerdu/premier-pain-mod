package com.unpainperdu.premierpainmod.level.event.block_event;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.MountainCurrantGolemEntity;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = PremierPainMod.MOD_ID)
public class CarvedPumpkinEvent
{
    private CarvedPumpkinEvent()
    {
    }

    @SubscribeEvent
    public static void onPlacedBlock(PlayerInteractEvent.RightClickBlock event)
    {
        Player player = event.getEntity();
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        ItemStack itemStack = player.getMainHandItem();

        if ((!level.isClientSide()))
        {
            if (hasCarvedPumpkinBlock(itemStack))
            {
                if (canSpawnMountainCurrantGolem(level, pos))
                {
                    if (!player.isCreative())
                    {
                        itemStack.shrink(1);
                    }
                    generateGolem(level, pos);
                }
            }
        }
    }

    private static boolean hasCarvedPumpkinBlock(ItemStack itemStack)
    {
        return itemStack.is(Blocks.CARVED_PUMPKIN.asItem());
    }

    private static boolean canSpawnMountainCurrantGolem(Level level, BlockPos pos)
    {
        boolean canSpawnMountainCurrantGolem = true;
        BlockState currentBlock = level.getBlockState(pos);
        if (!currentBlock.is(BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get("stripped_log")))
        {
            canSpawnMountainCurrantGolem = false;
        }
        pos = pos.below();
        currentBlock = level.getBlockState(pos);
        if (!currentBlock.is(BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get("stripped_log")))
        {
            canSpawnMountainCurrantGolem = false;
        }
        pos = pos.below();
        currentBlock = level.getBlockState(pos);
        if (!currentBlock.is(BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get("stripped_log")))
        {
            canSpawnMountainCurrantGolem = false;
        }
        return canSpawnMountainCurrantGolem;
    }

    private static void generateGolem(Level level, BlockPos pos)
    {
        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
        pos = pos.below();
        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
        pos = pos.below();
        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
        MountainCurrantGolemEntity mountainCurrantGolemEntity = AllInOneEntityRegister.MOUNTAIN_CURRANT_GOLEM_ENTITY.get().create(level);
        if (mountainCurrantGolemEntity != null)
        {
            mountainCurrantGolemEntity.moveTo( pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
            level.addFreshEntity(mountainCurrantGolemEntity);
        }

    }
}
