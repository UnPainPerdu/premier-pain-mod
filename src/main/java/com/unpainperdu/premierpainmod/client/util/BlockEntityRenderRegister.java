package com.unpainperdu.premierpainmod.client.util;

import com.unpainperdu.premierpainmod.client.render.renderBlockEntity.VillagerPedestalRender;
import com.unpainperdu.premierpainmod.client.render.renderBlockEntity.VillagerShelfRender;
import com.unpainperdu.premierpainmod.util.register.BlockEntityRegister;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;

public class BlockEntityRenderRegister
{

    public static void onRegisterBlockRenderers(ClientRegisterHandler.BlockRendererRegistry consumer)
    {
        consumer.register(BlockEntityRegister.PEDESTAL_BLOCK_ENTITY.get(), c ->new VillagerPedestalRender());
        consumer.register(BlockEntityRegister.VILLAGER_SHELF_BLOCK_ENTITY.get(), c ->new VillagerShelfRender());
        consumer.register(BlockEntityRegister.MOD_SIGN.get(), SignRenderer::new);
        consumer.register(BlockEntityRegister.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
    }
}
