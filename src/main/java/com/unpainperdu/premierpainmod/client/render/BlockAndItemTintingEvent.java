package com.unpainperdu.premierpainmod.client.render;

import com.unpainperdu.premierpainmod.level.world.block.tree.ModLeavesBlock;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import static com.unpainperdu.premierpainmod.util.register.block.WoodBlockEnum.LEAVES;

@EventBusSubscriber(value = Dist.CLIENT)
public class BlockAndItemTintingEvent
{
    @SubscribeEvent
    public static void registerBlockColorHandlers(RegisterColorHandlersEvent.Block event)
    {
        String leaves = LEAVES.toString();
        //vegetation
        //tree
        setTintingForFruitLeaves(event, BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get(leaves).get());
        setTintingForVegetation(event, BlockRegister.MORICHE_PALM_WOOD_TYPE_MAP.get(leaves).get());
        setTintingForFruitLeaves(event, BlockRegister.ACHIOTE_WOOD_TYPE_MAP.get(leaves).get());
        setTintingForVegetation(event, BlockRegister.WEEPING_WILLOW_WOOD_TYPE_MAP.get(leaves).get());
        setTintingForTintedCrossModel(event, BlockRegister.FALLING_WEEPING_WILLOW_LEAVES.get());
    }
    //TODO primer 1.21.4 -> now in item model
    /*
    @SubscribeEvent
    public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event)
    {
        String leaves = LEAVES.toString();
        event.register((stack, tintIndex) -> 0x91BD59,
                BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get(leaves),
                BlockRegister.MORICHE_PALM_WOOD_TYPE_MAP.get(leaves),
                BlockRegister.ACHIOTE_WOOD_TYPE_MAP.get(leaves),
                BlockRegister.WEEPING_WILLOW_WOOD_TYPE_MAP.get(leaves),
                BlockRegister.FALLING_WEEPING_WILLOW_LEAVES
        );
    }
    */

    private static void setTintingForVegetation(RegisterColorHandlersEvent.Block event, Block block)
    {
        event.register((state, level, pos, tintIndex) -> level != null && pos != null
                        ? BiomeColors.getAverageFoliageColor(level, pos)
                        : FoliageColor.FOLIAGE_DEFAULT,
                block);
    }

    private static void setTintingForFruitLeaves(RegisterColorHandlersEvent.Block event, Block block)
    {
        event.register(BlockAndItemTintingEvent::getColorForFruitLeaves, block);
    }

    private static int getColorForFruitLeaves(BlockState state, BlockAndTintGetter level, BlockPos pos, int tintIndex)
    {
        int color = 0xFFFFFF;

        if ((tintIndex == 0 || tintIndex == 5) || !state.getValue(ModLeavesBlock.HAS_FRUIT))
        {
            color = level != null && pos != null
                    ? BiomeColors.getAverageFoliageColor(level, pos)
                    : FoliageColor.FOLIAGE_DEFAULT;
        }

        return color;
    }

    private static void setTintingForTintedCrossModel(RegisterColorHandlersEvent.Block event, Block block)
    {
        event.register(BlockAndItemTintingEvent::getColorForTintedCrossModel, block);
    }

    private static int getColorForTintedCrossModel(BlockState state, BlockAndTintGetter level, BlockPos pos, int tintIndex)
    {
        int color = 0xFFFFFF;

        if (tintIndex == 0 || tintIndex == 5)
        {
            color = level != null && pos != null
                    ? BiomeColors.getAverageFoliageColor(level, pos)
                    : FoliageColor.FOLIAGE_DEFAULT;
        }

        return color;
    }
}