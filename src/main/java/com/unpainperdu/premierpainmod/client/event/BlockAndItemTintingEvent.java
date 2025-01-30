package com.unpainperdu.premierpainmod.client.event;

import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerBrewingStation;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.LiquidContent;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.ModList;
import net.minecraft.client.renderer.BiomeColors;
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
        event.register((state, level, pos, tintIndex) -> level != null && pos != null
                        ? BiomeColors.getAverageFoliageColor(level, pos)
                        : FoliageColor.getDefaultColor(),
                BlockRegister.MOUNTAIN_CURRANT_LEAVES.get());
        for (Block block : ModList.getAllBlocksFromClass(VillagerBrewingStation.class))
        {
            event.register((state, level, pos, tintIndex) -> getColorFromContentBrewingStation(state, tintIndex),
                    block);
        }
    }

    @SubscribeEvent
    public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event)
    {
        event.register((stack, tintIndex) -> 0x91BD59,
                BlockRegister.MOUNTAIN_CURRANT_LEAVES.get());
    }

    private static int getColorFromContentBrewingStation(BlockState state, int tintIndex)
    {
        int color = 0xFFFFFF;
        if (tintIndex == 5)
        {
            switch (state.getValue(VillagerBrewingStation.CONTENT))
            {
                case LiquidContent.BEER ->{
                    color = 0xFFB330;
                    break;
                }
                default -> {
                    color = 0x3F76E4;
                }
            }
        }
        return color;
    }
}
