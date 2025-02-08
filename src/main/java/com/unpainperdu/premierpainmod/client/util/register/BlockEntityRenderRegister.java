package com.unpainperdu.premierpainmod.client.util.register;

import com.unpainperdu.premierpainmod.client.render.render_block_entity.VillagerMusicalFridgeRender;
import com.unpainperdu.premierpainmod.client.render.render_block_entity.VillagerPedestalRender;
import com.unpainperdu.premierpainmod.client.render.render_block_entity.VillagerShelfRender;
import com.unpainperdu.premierpainmod.util.register.block.BlockEntityRegister;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;

public class BlockEntityRenderRegister
{

    public static void onRegisterBlockRenderers(ClientRegisterHandler.BlockRendererRegistry consumer)
    {
        consumer.register(BlockEntityRegister.PEDESTAL_BLOCK_ENTITY.get(), c ->new VillagerPedestalRender());
        consumer.register(BlockEntityRegister.VILLAGER_SHELF_BLOCK_ENTITY.get(), c ->new VillagerShelfRender());
        consumer.register(BlockEntityRegister.VILLAGER_MUSICAL_FRIDGE_ENTITY.get(), c ->new VillagerMusicalFridgeRender());
        consumer.register(BlockEntityRegister.MOD_SIGN.get(), SignRenderer::new);
        consumer.register(BlockEntityRegister.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
    }
}
