package com.unpainperdu.premierpainmod.level.world.block.tree;

import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;


public class LogBlock extends RotatedPillarBlock
{

    public LogBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction)
    {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction)
    {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction)
    {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate)
    {
        if (context.getItemInHand().getItem() instanceof AxeItem)
        {
            Map<BlockState, BlockState> logAndWoodMap = getLogAndWoodMap();
            if (logAndWoodMap.containsKey(state.getBlock().defaultBlockState()))
            {
                return  logAndWoodMap.get(state.getBlock().defaultBlockState()).setValue(LogBlock.AXIS, state.getValue(LogBlock.AXIS));
            }
        }
        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }

    private Map<BlockState, BlockState> getLogAndWoodMap()
    {
        Map<BlockState, BlockState> logAndWoodMap = new HashMap<>();
        logAndWoodMap.put(BlockRegister.MOUNTAIN_CURRANT_LOG.get().defaultBlockState(), BlockRegister.STRIPPED_MOUNTAIN_CURRANT_LOG.get().defaultBlockState());
        logAndWoodMap.put(BlockRegister.MOUNTAIN_CURRANT_WOOD.get().defaultBlockState(), BlockRegister.STRIPPED_MOUNTAIN_CURRANT_WOOD.get().defaultBlockState());
        logAndWoodMap.put(BlockRegister.MORICHE_PALM_LOG.get().defaultBlockState(), BlockRegister.STRIPPED_MORICHE_PALM_LOG.get().defaultBlockState());
        logAndWoodMap.put(BlockRegister.MORICHE_PALM_WOOD.get().defaultBlockState(), BlockRegister.STRIPPED_MORICHE_PALM_WOOD.get().defaultBlockState());

        return logAndWoodMap;
    }
}
