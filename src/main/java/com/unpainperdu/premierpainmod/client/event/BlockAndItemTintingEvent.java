package com.unpainperdu.premierpainmod.client.event;

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

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BlockAndItemTintingEvent
{
    @SubscribeEvent
    public static void registerBlockColorHandlers(RegisterColorHandlersEvent.Block event)
    {
        //vegetation
        //tree
        setTintingForFruitLeaves(event, BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get("leaves").get());
        setTintingForVegetation(event, BlockRegister.MORICHE_PALM_WOOD_TYPE_MAP.get("leaves").get());
        setTintingForFruitLeaves(event, BlockRegister.ACHIOTE_WOOD_TYPE_MAP.get("leaves").get());
    }

    @SubscribeEvent
    public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event)
    {
        event.register((stack, tintIndex) -> 0x91BD59,
                BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get("leaves").get(),
                BlockRegister.MORICHE_PALM_WOOD_TYPE_MAP.get("leaves").get(),
                BlockRegister.ACHIOTE_WOOD_TYPE_MAP.get("leaves").get()
        );
    }

    private static void setTintingForVegetation(RegisterColorHandlersEvent.Block event, Block block)
    {
        event.register((state, level, pos, tintIndex) -> level != null && pos != null
                        ? BiomeColors.getAverageFoliageColor(level, pos)
                        : FoliageColor.getDefaultColor(),
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
                    : FoliageColor.getDefaultColor();
        }

        return color;
    }
}
