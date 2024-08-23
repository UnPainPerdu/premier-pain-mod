package com.unpainperdu.premierpainmod.util.commonSetupEvent;

import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.DeferredBlock;

public class CommonSetupEventPottedThing
{
    public static void setupEventPottedThing(final FMLCommonSetupEvent event)
    {
        //flower
        setPottedThing(event, BlockRegister.RUINS_FLOWER, BlockRegister.POTTED_RUINS_FLOWER);
        setPottedThing(event, BlockRegister.CIVILIZATIONS_FLOWER, BlockRegister.POTTED_CIVILIZATIONS_FLOWER);
        setPottedThing(event, BlockRegister.CURIOSITY_FLOWER, BlockRegister.POTTED_CURIOSITY_FLOWER);
        //dead bush
        setPottedThing(event, BlockRegister.DEAD_RUINS_FLOWER, BlockRegister.POTTED_DEAD_RUINS_FLOWER);
    }

    public static void setPottedThing(final FMLCommonSetupEvent event, DeferredBlock<Block> thingToPot, DeferredBlock<Block> thingPotted)
    {
        event.enqueueWork(() -> ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(thingToPot.getId(),thingPotted));
    }
}
