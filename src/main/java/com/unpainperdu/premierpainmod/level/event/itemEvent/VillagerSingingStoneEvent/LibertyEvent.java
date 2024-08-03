package com.unpainperdu.premierpainmod.level.event.itemEvent.VillagerSingingStoneEvent;

import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Blocks;

import java.util.Random;

public class LibertyEvent extends AbstractVillagerSingingStoneEvent
{
    private static int heightOfSPawn;
    public LibertyEvent()
    {
        super("LibertyEvent");
    }

    @Override
    public void castEvent(Level level, Player player, InteractionHand usedHand)
    {
        heightOfSPawn = 30;
        if(IsOnlyAirUpper(level,player))
        {
            BlockPos pos = player.getBlockPosBelowThatAffectsMyMovement();
            BlockPos posSpawnBlock = pos.above(heightOfSPawn);
            BlockPos posSpawnItem = posSpawnBlock.above(2);
            level.setBlock(posSpawnBlock, BlockRegister.LIBERTY_BLOCK.get().defaultBlockState(), 0);
            double setToMiddleOfBLock = 0.5;
            double xPos = posSpawnItem.getX() + setToMiddleOfBLock;
            double yPos = posSpawnItem.getY() + setToMiddleOfBLock;
            double zPos = posSpawnItem.getZ() + setToMiddleOfBLock;
            ItemEntity itementity = new ItemEntity(level, xPos, yPos, zPos, randomLootGenerator());
            itementity.setDeltaMovement(
                    0.0,
                    0.0,
                    0.0
            );
            level.addFreshEntity(itementity);
        }
    }

    private boolean IsOnlyAirUpper(Level level, Player player)
    {
        BlockPos posPlayer = player.getBlockPosBelowThatAffectsMyMovement().above(2);
        boolean flag = true;
        BlockPos tempPos = posPlayer;
        for(int i = 0; i<= heightOfSPawn; i++)
        {
            if(!(level.getBlockState(tempPos).getBlock() instanceof AirBlock))
            {
                flag = false;
            }
            tempPos = tempPos.above();
        }
        return flag;
    }

    private ItemStack randomLootGenerator()
    {
        int randomNumber = new Random().nextInt(1000);
        if (randomNumber == 53)
        {
            return new ItemStack(Blocks.NETHERITE_BLOCK.asItem());
        }
        else
        {
            return new ItemStack(Items.EMERALD);
        }
    }
}
