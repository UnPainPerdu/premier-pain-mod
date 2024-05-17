package com.unpainperdu.premierpainmod.datagen.data;

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
                        BlockRegister.OAK_VILLAGER_STATUE.get(),
                        BlockRegister.BIRCH_VILLAGER_STATUE.get(),
                        BlockRegister.SPRUCE_VILLAGER_STATUE.get(),
                        BlockRegister.JUNGLE_VILLAGER_STATUE.get(),
                        BlockRegister.ACACIA_VILLAGER_STATUE.get(),
                        BlockRegister.DARK_OAK_VILLAGER_STATUE.get(),
                        BlockRegister.MANGROVE_VILLAGER_STATUE.get(),
                        BlockRegister.CHERRY_VILLAGER_STATUE.get(),
                        BlockRegister.CRIMSON_VILLAGER_STATUE.get(),
                        BlockRegister.WARPED_VILLAGER_STATUE.get(),
                        BlockRegister.BAMBOO_VILLAGER_STATUE.get()
                );
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add
                (
                        BlockRegister.STONE_VILLAGER_STATUE.get(),
                        BlockRegister.ANDESITE_VILLAGER_STATUE.get(),
                        BlockRegister.DIORITE_VILLAGER_STATUE.get(),
                        BlockRegister.PRISMARINE_VILLAGER_STATUE.get(),
                        BlockRegister.BLACKSTONE_VILLAGER_STATUE.get(),
                        BlockRegister.PURPUR_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.COBBLESTONE_VILLAGER_STATUE.get(),
                        BlockRegister.MOSSY_COBBLESTONE_VILLAGER_STATUE.get(),
                        BlockRegister.SMOOTH_STONE_VILLAGER_STATUE.get(),
                        BlockRegister.COBBLED_DEEPSLATE_VILLAGER_STATUE.get(),
                        BlockRegister.TUFF_VILLAGER_STATUE.get(),
                        BlockRegister.PACKED_MUD_VILLAGER_STATUE.get(),
                        BlockRegister.SANDSTONE_VILLAGER_STATUE.get(),
                        BlockRegister.RED_SANDSTONE_VILLAGER_STATUE.get(),
                        BlockRegister.QUARTZ_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.NETHER_BRICKS_VILLAGER_STATUE.get(),
                        BlockRegister.BASALT_VILLAGER_STATUE.get(),
                        BlockRegister.END_STONE_VILLAGER_STATUE.get(),
                        BlockRegister.COAL_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.IRON_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.GOLD_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.REDSTONE_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.EMERALD_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.DIAMOND_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.COPPER_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.LAPIS_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.NETHERITE_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.OBSIDIAN_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.AMETHYST_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.DRIPSTONE_BLOCK_VILLAGER_STATUE.get()
                );
        this.tag(BlockTags.NEEDS_STONE_TOOL).add
                (
                        BlockRegister.IRON_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.LAPIS_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.COPPER_BLOCK_VILLAGER_STATUE.get()
                );
        this.tag(BlockTags.NEEDS_IRON_TOOL).add
                (
                        BlockRegister.GOLD_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.EMERALD_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.DIAMOND_BLOCK_VILLAGER_STATUE.get()
                );
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add
                (
                        BlockRegister.NETHERITE_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.OBSIDIAN_BLOCK_VILLAGER_STATUE.get()
                );
    }
}
