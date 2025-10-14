package com.unpainperdu.premierpainmod.level.event.block_event;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.WoolGolemEntity;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import oshi.util.tuples.Pair;

import java.util.ArrayList;
import java.util.List;

import static com.unpainperdu.premierpainmod.util.tool_kit.PosHelper.getLeft;
import static com.unpainperdu.premierpainmod.util.tool_kit.PosHelper.getRight;

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
        Direction faceInteractionDirection = event.getFace();
        Direction pumpkinDirection = (Direction.orderedByNearest(player)[0] == Direction.DOWN) || (Direction.orderedByNearest(player)[0] == Direction.UP)? Direction.orderedByNearest(player)[1] : Direction.orderedByNearest(player)[0];
        ItemStack itemStack = player.getMainHandItem();

        if ((!level.isClientSide()))
        {
            Pair<Entity, List<BlockPos>> currantGolemCondition;

            if (itemStack.is(Blocks.CARVED_PUMPKIN.asItem()) && faceInteractionDirection == Direction.UP)
            {
                currantGolemCondition = canSpawnMountainCurrantGolem(level, pos);
                if (currantGolemCondition.getA() != null)
                {
                    generateGolem(level, player, pos, itemStack, currantGolemCondition, 4);
                    return;
                }
                currantGolemCondition = canSpawnWoolGolem(level, pos, pumpkinDirection);
                if (currantGolemCondition.getA() != null)
                {
                    generateGolem(level, player, pos, itemStack, currantGolemCondition, 3);
                    return;
                }
            }
        }
    }

    private static Pair<Entity, List<BlockPos>> canSpawnMountainCurrantGolem(Level level, BlockPos pos)
    {
        boolean canSpawn = true;
        Entity entity = null;
        List<BlockPos> posList = new ArrayList<>();
        BlockState currentBlock = level.getBlockState(pos);
        posList.add(pos);
        if (!currentBlock.is(BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get("stripped_log")))
        {
            canSpawn = false;
        }
        pos = pos.below();
        posList.add(pos);
        currentBlock = level.getBlockState(pos);
        if (!currentBlock.is(BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get("stripped_log")))
        {
            canSpawn = false;
        }
        pos = pos.below();
        posList.add(pos);
        currentBlock = level.getBlockState(pos);
        if (!currentBlock.is(BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get("stripped_log")))
        {
            canSpawn = false;
        }
        if (canSpawn)
        {
            entity = AllInOneEntityRegister.MOUNTAIN_CURRANT_GOLEM_ENTITY.get().create(level);
        }
        return new Pair<>(entity, posList);
    }

    private static Pair<Entity, List<BlockPos>> canSpawnWoolGolem(Level level, BlockPos pos, Direction direction)
    {
        var boxedCanSpawn = new Object()
        {
            boolean canSpawn = true;
        };
        WoolGolemEntity entity = null;
        List<BlockPos> posList = new ArrayList<>();
        posList.add(pos);
        posList.add(getLeft(pos, direction));
        posList.add(getRight(pos, direction));
        posList.add(pos.below());
        posList.add(getLeft(pos.below(), direction));
        posList.add(getRight(pos.below(), direction));
        var boxedselectedDyeColor = new Object()
        {
            DyeColor selectedDyeColor = null;
        };

        posList.forEach(posF ->
        {
            BlockState currentBlockState = level.getBlockState(posF);
            if (currentBlockState.is(BlockTags.WOOL))
            {
                if (boxedselectedDyeColor.selectedDyeColor == null)
                {
                    boxedselectedDyeColor.selectedDyeColor = WoolGolemEntity.getWoolDyeFromBlock(currentBlockState.getBlock());
                }
                else
                {
                    if (!boxedselectedDyeColor.selectedDyeColor.equals(WoolGolemEntity.getWoolDyeFromBlock(currentBlockState.getBlock())))
                    {
                        boxedCanSpawn.canSpawn = false;
                    }
                }
            }
            else
            {
                boxedCanSpawn.canSpawn = false;
            }
        });
        if (boxedCanSpawn.canSpawn)
        {
            entity = AllInOneEntityRegister.WOOL_GOLEM_ENTITY.get().create(level);
            if (entity != null)
            {
                entity.setWoolDye(boxedselectedDyeColor.selectedDyeColor);
            }
        }
        return new Pair<>(entity, posList);
    }

    private static void generateGolem(Level level, Player player, BlockPos pos, ItemStack itemStack, Pair<Entity, List<BlockPos>> entityAndPos, int golemHeight)
    {
        pos = pos.below(golemHeight-2);
        entityAndPos.getB().forEach(posF -> level.setBlock(posF, Blocks.AIR.defaultBlockState(), 2));
        entityAndPos.getA().moveTo(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
        level.addFreshEntity(entityAndPos.getA());
        if (!player.isCreative())
        {
            itemStack.shrink(1);
        }
    }
}
