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
                        //statue
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
                        BlockRegister.BAMBOO_VILLAGER_STATUE.get(),
                        //pedestal
                        BlockRegister.OAK_PEDESTAL.get(),
                        BlockRegister.BIRCH_PEDESTAL.get(),
                        BlockRegister.SPRUCE_PEDESTAL.get(),
                        BlockRegister.JUNGLE_PEDESTAL.get(),
                        BlockRegister.ACACIA_PEDESTAL.get(),
                        BlockRegister.DARK_OAK_PEDESTAL.get(),
                        BlockRegister.MANGROVE_PEDESTAL.get(),
                        BlockRegister.CHERRY_PEDESTAL.get(),
                        BlockRegister.CRIMSON_PEDESTAL.get(),
                        BlockRegister.WARPED_PEDESTAL.get(),
                        BlockRegister.BAMBOO_PEDESTAL.get()
                );
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add
                (
                        //villager workshop
                        BlockRegister.VILLAGER_WORKSHOP.get(),
                        //statue
                        BlockRegister.STONE_VILLAGER_STATUE.get(),
                        BlockRegister.MOSSY_STONE_VILLAGER_STATUE.get(),
                        BlockRegister.ANDESITE_VILLAGER_STATUE.get(),
                        BlockRegister.DIORITE_VILLAGER_STATUE.get(),
                        BlockRegister.PRISMARINE_VILLAGER_STATUE.get(),
                        BlockRegister.BLACKSTONE_VILLAGER_STATUE.get(),
                        BlockRegister.PURPUR_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.DEEPSLATE_VILLAGER_STATUE.get(),
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
                        BlockRegister.OBSIDIAN_VILLAGER_STATUE.get(),
                        BlockRegister.AMETHYST_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.DRIPSTONE_BLOCK_VILLAGER_STATUE.get(),
                        //pedestal
                        BlockRegister.STONE_PEDESTAL.get(),
                        BlockRegister.MOSSY_STONE_PEDESTAL.get(),
                        BlockRegister.ANDESITE_PEDESTAL.get(),
                        BlockRegister.DIORITE_PEDESTAL.get(),
                        BlockRegister.PRISMARINE_PEDESTAL.get(),
                        BlockRegister.BLACKSTONE_PEDESTAL.get(),
                        BlockRegister.PURPUR_BLOCK_PEDESTAL.get(),
                        BlockRegister.DEEPSLATE_PEDESTAL.get(),
                        BlockRegister.TUFF_PEDESTAL.get(),
                        BlockRegister.PACKED_MUD_PEDESTAL.get(),
                        BlockRegister.SANDSTONE_PEDESTAL.get(),
                        BlockRegister.RED_SANDSTONE_PEDESTAL.get(),
                        BlockRegister.QUARTZ_BLOCK_PEDESTAL.get(),
                        BlockRegister.NETHER_BRICKS_PEDESTAL.get(),
                        BlockRegister.BASALT_PEDESTAL.get(),
                        BlockRegister.END_STONE_PEDESTAL.get(),
                        BlockRegister.COAL_BLOCK_PEDESTAL.get(),
                        BlockRegister.IRON_BLOCK_PEDESTAL.get(),
                        BlockRegister.GOLD_BLOCK_PEDESTAL.get(),
                        BlockRegister.REDSTONE_BLOCK_PEDESTAL.get(),
                        BlockRegister.EMERALD_BLOCK_PEDESTAL.get(),
                        BlockRegister.DIAMOND_BLOCK_PEDESTAL.get(),
                        BlockRegister.COPPER_BLOCK_PEDESTAL.get(),
                        BlockRegister.LAPIS_BLOCK_PEDESTAL.get(),
                        BlockRegister.NETHERITE_BLOCK_PEDESTAL.get(),
                        BlockRegister.OBSIDIAN_PEDESTAL.get(),
                        BlockRegister.AMETHYST_BLOCK_PEDESTAL.get(),
                        BlockRegister.DRIPSTONE_BLOCK_PEDESTAL.get()
                );
        this.tag(BlockTags.NEEDS_STONE_TOOL).add
                (
                        BlockRegister.IRON_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.LAPIS_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.COPPER_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.IRON_BLOCK_PEDESTAL.get(),
                        BlockRegister.LAPIS_BLOCK_PEDESTAL.get(),
                        BlockRegister.COPPER_BLOCK_PEDESTAL.get()
                );
        this.tag(BlockTags.NEEDS_IRON_TOOL).add
                (
                        BlockRegister.GOLD_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.EMERALD_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.DIAMOND_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.GOLD_BLOCK_PEDESTAL.get(),
                        BlockRegister.EMERALD_BLOCK_PEDESTAL.get(),
                        BlockRegister.DIAMOND_BLOCK_PEDESTAL.get()
                );
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add
                (
                        BlockRegister.NETHERITE_BLOCK_VILLAGER_STATUE.get(),
                        BlockRegister.OBSIDIAN_VILLAGER_STATUE.get(),
                        BlockRegister.NETHERITE_BLOCK_PEDESTAL.get(),
                        BlockRegister.OBSIDIAN_PEDESTAL.get()
                );
    }
}
