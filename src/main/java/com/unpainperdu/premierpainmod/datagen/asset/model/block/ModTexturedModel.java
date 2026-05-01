package com.unpainperdu.premierpainmod.datagen.asset.model.block;

import com.unpainperdu.premierpainmod.util.register.block.AllMaterialsBlockEnum;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ModTexturedModel
{
    //all_materials
    //  statue
    public static final ModTexturedModel.AllMaterialProvider VILLAGER_STATUE_MODEL_BOTTOM = createAllMaterialDefault(ModTextureMapping::defaultAllMaterial, ModModelTemplates.VILLAGER_STATUE_BOTTOM);
    public static final ModTexturedModel.AllMaterialProvider VILLAGER_STATUE_MODEL_TOP = createAllMaterialDefault(ModTextureMapping::defaultAllMaterial, ModModelTemplates.VILLAGER_STATUE_TOP);
    //  pedestal
    public static final ModTexturedModel.AllMaterialProvider VILLAGER_PEDESTAL = createAllMaterialDefault(ModTextureMapping::defaultAllMaterial, ModModelTemplates.VILLAGER_PEDESTAL);
    //  brazier
    public static final ModTexturedModel.AllMaterialProvider VILLAGER_BRAZIER_BOTTOM = createAllMaterialDefault(ModTextureMapping::defaultAllMaterial, ModModelTemplates.VILLAGER_BRAZIER_BOTTOM);
    public static final ModTexturedModel.AllMaterialProvider VILLAGER_BRAZIER_UPPER_UNLIT = createAllMaterialDefault(ModTextureMapping::defaultAllMaterial, ModModelTemplates.VILLAGER_BRAZIER_UPPER_UNLIT);
    public static final ModTexturedModel.AllMaterialProvider VILLAGER_BRAZIER_UPPER_LIT = createAllMaterialDefault(ModTextureMapping::defaultAllMaterial, ModModelTemplates.VILLAGER_BRAZIER_UPPER_LIT);
    public static final ModTexturedModel.AllMaterialProvider VILLAGER_BRAZIER_ITEM = createAllMaterialDefault(ModTextureMapping::defaultAllMaterial, ModModelTemplates.VILLAGER_BRAZIER_ITEM);
    //  table
    public static final ModTexturedModel.AllMaterialProvider VILLAGER_TABLE_SOLO = createAllMaterialDefault(ModTextureMapping::defaultAllMaterial, ModModelTemplates.VILLAGER_TABLE_SOLO);
    public static final ModTexturedModel.AllMaterialProvider VILLAGER_TABLE_DUO = createAllMaterialDefault(ModTextureMapping::defaultAllMaterial, ModModelTemplates.VILLAGER_TABLE_DUO);
    public static final ModTexturedModel.AllMaterialProvider VILLAGER_TABLE_TRIO_ANGLE = createAllMaterialDefault(ModTextureMapping::defaultAllMaterial, ModModelTemplates.VILLAGER_TABLE_TRIO_ANGLE);
    public static final ModTexturedModel.AllMaterialProvider VILLAGER_TABLE_TRIO_LINE = createAllMaterialDefault(ModTextureMapping::defaultAllMaterial, ModModelTemplates.VILLAGER_TABLE_TRIO_LINE);
    public static final ModTexturedModel.AllMaterialProvider VILLAGER_TABLE_QUATUOR = createAllMaterialDefault(ModTextureMapping::defaultAllMaterial, ModModelTemplates.VILLAGER_TABLE_QUATUOR);
    public static final ModTexturedModel.AllMaterialProvider VILLAGER_TABLE_PENTUOR = createAllMaterialDefault(ModTextureMapping::defaultAllMaterial, ModModelTemplates.VILLAGER_TABLE_PENTUOR);

    public static ModTexturedModel.AllMaterialProvider createAllMaterialDefault(Function<AllMaterialsBlockEnum.Material, TextureMapping> textureMappingGetter, ModelTemplate template)
    {
        return material -> new TexturedModel(textureMappingGetter.apply(material), template);
    }

    @FunctionalInterface
    @OnlyIn(Dist.CLIENT)
    public interface AllMaterialProvider extends net.neoforged.neoforge.client.extensions.ITexturedModelExtension.Provider
    {
        TexturedModel get(AllMaterialsBlockEnum.Material material);

        default ResourceLocation create(AllMaterialsBlockEnum.Material material, AllMaterialsBlockEnum.Type type, BiConsumer<ResourceLocation, ModelInstance> output)
        {
            return this.get(material).create(AllMaterialsBlockEnum.getAllMaterialBlock(type, material).get(), output);
        }

        default ModTexturedModel.AllMaterialProvider updateAllMaterialTemplate(UnaryOperator<ModelTemplate> modifier) {
            return material -> self().get(material).updateTemplate(modifier);
        }

        private ModTexturedModel.AllMaterialProvider self() {
            return this;
        }
    }
}