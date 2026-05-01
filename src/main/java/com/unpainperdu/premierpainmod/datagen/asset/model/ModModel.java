package com.unpainperdu.premierpainmod.datagen.asset.model;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.datagen.asset.model.block.ModBlockModelProvider;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;

public class ModModel extends ModelProvider
{
    public ModModel(PackOutput output)
    {
        super(output, PremierPainMod.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels)
    {
        ModItemModelProvider.generate(itemModels);
        ModBlockModelProvider.generate(blockModels);
    }
}