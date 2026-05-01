package com.unpainperdu.premierpainmod.datagen.asset.model.block;

import com.unpainperdu.premierpainmod.util.register.block.AllMaterialsBlockEnum;
import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;

public class ModTextureMapping
{
    public static TextureMapping defaultAllMaterial(AllMaterialsBlockEnum.Material material)
    {
        ResourceLocation layer0 = ResourceUtil.createResourceLocation("block/all_materials_block/multiple_use_texture/" + material);
        ResourceLocation particle = ResourceUtil.createResourceLocation("block/all_materials_block/multiple_use_texture/" + material);
        return new TextureMapping().put(ModTextureSlot.BASE, layer0)
                .put(ModTextureSlot.PARTICLE, particle);
    }
}