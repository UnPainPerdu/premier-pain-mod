package com.unpainperdu.premierpainmod.datagen.asset.model;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.world.block.VillagerStatue;
import net.minecraft.data.PackOutput;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider<T extends ModelBuilder<T>> extends BlockStateProvider
{
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, PremierPainMod.MODID, existingFileHelper);
    }


    @Override
    protected void registerStatesAndModels()
    {

    }
    private void simpleBlockWithItem(Block block)
    {
        simpleBlockWithItem(block, cubeAll(block));
    }
    private void villagerStatueWithItem(VillagerStatue statue)
    {
        //villagerStatue(statue,modLoc("block/bottomVillagerStatue"),modLoc("block/upperVillagerStatue"));
        simpleBlockItem(statue, cubeAll(statue));
    }
    private ResourceLocation key(Block block)
    {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
}
