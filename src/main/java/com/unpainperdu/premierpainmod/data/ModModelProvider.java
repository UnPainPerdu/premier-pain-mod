package com.unpainperdu.premierpainmod.data;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModModelProvider extends BlockStateProvider
{

    public ModModelProvider(PackOutput packOutput, ExistingFileHelper exFileHelper)
    {
        super(packOutput, PremierPainMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {

    }
}
