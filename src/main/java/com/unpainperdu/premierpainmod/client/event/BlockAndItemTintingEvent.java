package com.unpainperdu.premierpainmod.client.event;

import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.VillagerBrewingStation;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.ModList;
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
        setTintingForVegetation(event, BlockRegister.MOUNTAIN_CURRANT_LEAVES.get());
        setTintingForVegetation(event, BlockRegister.MORICHE_PALM_LEAVES.get());
        for (Block block : ModList.getAllBlocksFromClass(VillagerBrewingStation.class))
        {
            event.register((state, level, pos, tintIndex) -> getColorFromContentBrewingStation(state, level, pos, tintIndex),block);
        }
    }

    @SubscribeEvent
    public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event)
    {
        event.register((stack, tintIndex) -> 0x91BD59,
                BlockRegister.MOUNTAIN_CURRANT_LEAVES.get(),
                BlockRegister.MORICHE_PALM_LEAVES.get()
        );
    }
    /*
    get tint color define in fluid type of the fluid in the fluid tank
    */
    private static int getColorFromContentBrewingStation(BlockState state, BlockAndTintGetter level, BlockPos pos, int tintIndex)
    {
        int color = 0xFFFFFF;
        try
        {
            if (tintIndex == 5)
            {
                color = state.getValue(VillagerBrewingStation.CONTENT).getTintIndex();
            }
        }
        catch (Exception ignored) {}

        return color;
    }

    private static void setTintingForVegetation(RegisterColorHandlersEvent.Block event, Block block)
    {
        event.register((state, level, pos, tintIndex) -> level != null && pos != null
                        ? BiomeColors.getAverageFoliageColor(level, pos)
                        : FoliageColor.getDefaultColor(),
                block);
    }
}
