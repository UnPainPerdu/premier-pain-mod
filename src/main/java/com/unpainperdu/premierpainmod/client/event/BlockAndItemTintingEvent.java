package com.unpainperdu.premierpainmod.client.event;

import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
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
        event.register((state, level, pos, tintIndex) -> level != null && pos != null
                        ? BiomeColors.getAverageFoliageColor(level, pos)
                        : FoliageColor.getDefaultColor(),
                BlockRegister.MOUNTAIN_CURRANT_LEAVES.value());
    }

    @SubscribeEvent
    public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event)
    {
        event.register((stack, tintIndex) -> {
                    BlockState blockstate = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
                    return BlockColors.createDefault().getColor(blockstate, null, null, tintIndex);
                },
                BlockRegister.MOUNTAIN_CURRANT_LEAVES.value());
    }
}
