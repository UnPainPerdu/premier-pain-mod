package com.unpainperdu.premierpainmod.level.world.block.tree;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.unpainperdu.premierpainmod.util.register.block.WoodBlockEnum.*;

public class LogBlock extends RotatedPillarBlock
{
    private static final List<Map<String, DeferredBlock<Block>>> WOOD_TYPE_LIST = new ArrayList<>();

    public LogBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction)
    {
        return true;
    }

    @Override
    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction)
    {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction)
    {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(@NotNull BlockState state, UseOnContext context, @NotNull ItemAbility itemAbility, boolean simulate)
    {
        if (context.getItemInHand().getItem() instanceof AxeItem)
        {
            Map<BlockState, BlockState> logAndWood = getLogAndWoodMap();

            if (logAndWood.containsKey(state.getBlock().defaultBlockState()))
            {
                return logAndWood.get(state.getBlock().defaultBlockState()).setValue(LogBlock.AXIS, state.getValue(LogBlock.AXIS));
            }
        }
        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }

    private Map<BlockState, BlockState> getLogAndWoodMap()
    {
        Map<BlockState, BlockState> logAndWoodMap = new HashMap<>();
        for (Map<String, DeferredBlock<Block>> m : WOOD_TYPE_LIST)
        {
            logAndWoodMap.put(m.get(LOG.toString()).get().defaultBlockState(), m.get(STRIPPED_LOG.toString()).get().defaultBlockState());
            logAndWoodMap.put(m.get(WOOD.toString()).get().defaultBlockState(), m.get(STRIPPED_WOOD.toString()).get().defaultBlockState());
        }
        return logAndWoodMap;
    }

    public static void registerNewWoodType(Map<String, DeferredBlock<Block>> woodType)
    {
        WOOD_TYPE_LIST.add(woodType);

    }
}