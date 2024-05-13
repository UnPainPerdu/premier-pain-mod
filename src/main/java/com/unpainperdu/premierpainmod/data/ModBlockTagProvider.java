package com.unpainperdu.premierpainmod.data;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider
{
    public ModBlockTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper)
    {
        super(packOutput,lookupProvider, PremierPainMod.MODID, fileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider)
    {
        this.tag(BlockTags.MINEABLE_WITH_AXE).add
                (
                        BlockRegister.OAK_VILLAGER_STATUE.get(),  BlockRegister.BIRCH_VILLAGER_STATUE.get()
                );
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add
                (
                        BlockRegister.STONE_VILLAGER_STATUE.get()
                );
    }
}
