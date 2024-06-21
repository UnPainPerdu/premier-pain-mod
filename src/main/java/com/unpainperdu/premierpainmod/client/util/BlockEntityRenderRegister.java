package com.unpainperdu.premierpainmod.client.util;

import com.unpainperdu.premierpainmod.client.render.renderBlockEntity.VillagerPedestalRender;
import com.unpainperdu.premierpainmod.util.register.BlockEntityRegister;

public class BlockEntityRenderRegister
{

    public static void onRegisterBlockRenderers(ClientRegisterHandler.BlockRendererRegistry consumer)
    {
        consumer.register(BlockEntityRegister.PEDESTAL_BLOCK_ENTITY.get(), c ->new VillagerPedestalRender());
    }
}
