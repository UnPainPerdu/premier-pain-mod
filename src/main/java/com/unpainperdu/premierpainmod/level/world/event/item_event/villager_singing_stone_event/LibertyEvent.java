package com.unpainperdu.premierpainmod.level.world.event.item_event.villager_singing_stone_event;

import com.unpainperdu.premierpainmod.datagen.data.loot_table.ModItemEventLootTable;
import com.unpainperdu.premierpainmod.level.world.event.item_event.ItemEvent;
import com.unpainperdu.premierpainmod.util.register.SoundEventRegister;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;

public class LibertyEvent extends ItemEvent
{
    private static final int HEIGHT_OF_SPAWN = 90;

    public LibertyEvent()
    {
        super("liberty");
    }

    @Override
    public void castEvent(Level level, Player player, InteractionHand usedHand)
    {
        if (!level.isClientSide && IsOnlyAirUpper(level, player))
        {
            BlockPos pos = player.getBlockPosBelowThatAffectsMyMovement();
            BlockPos posSpawnBlock = pos.above(HEIGHT_OF_SPAWN);
            BlockPos posSpawnItem = posSpawnBlock.above(2);
            double setToMiddleOfBLock = 0.5;
            double xPos = posSpawnItem.getX() + setToMiddleOfBLock;
            double yPos = posSpawnItem.getY() + setToMiddleOfBLock;
            double zPos = posSpawnItem.getZ() + setToMiddleOfBLock;

            level.setBlock(posSpawnBlock, BlockRegister.LIBERTY_BLOCK.get().defaultBlockState(), 0);
            for (ItemStack itemStack : getLootTableItemStack(level))
            {
                ItemEntity itementity = new ItemEntity(level, xPos, yPos, zPos, itemStack);
                itementity.setDeltaMovement(
                        0.0,
                        0.0,
                        0.0
                );
                level.addFreshEntity(itementity);
            }
        }
    }

    @Override
    public SoundEvent getMusicEvent()
    {
        return SoundEventRegister.LIBERTY_SOUND.get();
    }

    private boolean IsOnlyAirUpper(Level level, Player player)
    {
        BlockPos posPlayer = player.getBlockPosBelowThatAffectsMyMovement().above(2);
        boolean flag = true;
        BlockPos tempPos = posPlayer;
        for (int i = 0; i <= HEIGHT_OF_SPAWN; i++)
        {
            if (!(level.getBlockState(tempPos).getBlock() instanceof AirBlock))
            {
                flag = false;
            }
            tempPos = tempPos.above();
        }
        return flag;
    }


    private List<ItemStack> getLootTableItemStack(Level level)
    {
        if (level.isClientSide) throw new RuntimeException("level must be serverside");

        LootParams.Builder builder = new LootParams.Builder((ServerLevel) level);
        LootParams params = builder.create(LootContextParamSets.EMPTY);
        LootTable table = level.getServer().reloadableRegistries().getLootTable(ModItemEventLootTable.LIBERTY_ITEM_EVENT);
        return table.getRandomItems(params);
    }
}
