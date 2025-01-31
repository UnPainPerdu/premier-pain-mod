package com.unpainperdu.premierpainmod.client.event;

import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerBrewingStation;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.LiquidContent;
import com.unpainperdu.premierpainmod.level.world.entity.blockEntity.allMaterialsBlock.VillagerBrewingStationBlockEntity;
import com.unpainperdu.premierpainmod.level.world.fluid.beer.BeerFluid;
import com.unpainperdu.premierpainmod.level.world.fluid.fluidType.BeerFluidType;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.ModList;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

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
            event.register((state, level, pos, tintIndex) -> getColorFromContentBrewingStation(state, level, pos, tintIndex),block);
        }
    }

    @SubscribeEvent
    public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event)
    {
        event.register((stack, tintIndex) -> 0x91BD59,
                BlockRegister.MOUNTAIN_CURRANT_LEAVES.get());
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
}
