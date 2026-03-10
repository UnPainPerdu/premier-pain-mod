package com.unpainperdu.premierpainmod.datagen.data.level.world.entity;

import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

public class ModPaintingVariant
{
    public static final ResourceKey<PaintingVariant> LANDSCAPE_0 = paintingVariantRegister("landscape_0");
    public static final ResourceKey<PaintingVariant> LANDSCAPE_1 = paintingVariantRegister("landscape_1");
    public static final ResourceKey<PaintingVariant> LANDSCAPE_2 = paintingVariantRegister("landscape_2");
    public static final ResourceKey<PaintingVariant> FLOWERD_CACTUS = paintingVariantRegister("flowered_cactus");
    public static final ResourceKey<PaintingVariant> UNDERGROUND_GATE = paintingVariantRegister("underground_gate");

    private static ResourceKey<PaintingVariant> paintingVariantRegister(String path)
    {
        return ResourceKey.create(Registries.PAINTING_VARIANT, ResourceUtil.createResourceLocation(path));
    }

    private static void register(BootstrapContext<PaintingVariant> context, ResourceKey<PaintingVariant> key, int width, int height)
    {
        context.register(key, new PaintingVariant(width, height, key.location()));
    }

    public static void boostrap(BootstrapContext<PaintingVariant> context)
    {
        register(context, LANDSCAPE_0, 4 ,2);
        register(context, LANDSCAPE_1, 4 ,2);
        register(context, LANDSCAPE_2, 4 ,2);
        register(context, FLOWERD_CACTUS, 1 ,2);
        register(context, UNDERGROUND_GATE, 4 ,4);
    }
}
