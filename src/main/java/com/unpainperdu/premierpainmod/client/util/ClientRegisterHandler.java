package com.unpainperdu.premierpainmod.client.util;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientRegisterHandler
{
    @FunctionalInterface
    public interface BlockRendererRegistry
    {
        <T extends BlockEntity> void register(BlockEntityType<? extends T> type, BlockEntityRendererProvider<T> factory);
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        BlockEntityRenderRegister.onRegisterBlockRenderers(new BlockRendererRegistry()
        {
            @Override
            public <T extends BlockEntity> void register(BlockEntityType<? extends T> type, BlockEntityRendererProvider<T> factory)
            {
                event.registerBlockEntityRenderer(type, factory);
            }
        });
    }
}
