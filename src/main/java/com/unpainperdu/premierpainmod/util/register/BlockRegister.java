package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.*;
import com.unpainperdu.premierpainmod.level.world.block.eventBlock.LibertyBlock;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight.VillagerBrazier;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight.VillagerStatue;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight.VillagerThroneChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidthWithBlockEntity.VillagerDrawer;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidthWithBlockEntity.villagerShelf.StandingVillagerShelf;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidth.VillagerWorkshop;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidthWithBlockEntity.villagerShelf.WallVillagerShelf;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class BlockRegister
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PremierPainMod.MOD_ID);

    //WorkShopZone
    public static final DeferredBlock<Block> VILLAGER_WORKSHOP = registerBlock("villager_workshop", () -> new VillagerWorkshop(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    /*materials :
    oak
    birch
    spruce
    jungle
    acacia
    dark_oak
    mangrove
    cherry
    bamboo
    crimson
    warped
    stone
    end_stone
    mossy_stone
    andesite
    diorite
    granite
    prismarine
    blackstone
    deepslate
    tuff
    sandstone
    red_sandstone
    basalt (polished as "planks")
    obsidian (obsidian as "planks")
    bedrock
    packed_mud
    nether_bricks
    quartz_block (chiseled as "planks")
    iron_block
    gold_block
    copper_block
    amethyst_block
    dripstone_block
    netherite_block
    purpur_block
    coal_block
    redstone_block
    diamond_block
    emerald_block
    lapis_block
     */
        //statue
    public static final DeferredBlock<Block> OAK_VILLAGER_STATUE = blockModRegister("villager_statue","oak_villager_statue","wood");
    public static final DeferredBlock<Block> BIRCH_VILLAGER_STATUE = blockModRegister("villager_statue","birch_villager_statue","wood");
    public static final DeferredBlock<Block> SPRUCE_VILLAGER_STATUE = blockModRegister("villager_statue","spruce_villager_statue","wood");
    public static final DeferredBlock<Block> JUNGLE_VILLAGER_STATUE = blockModRegister("villager_statue","jungle_villager_statue","wood");
    public static final DeferredBlock<Block> ACACIA_VILLAGER_STATUE = blockModRegister("villager_statue","acacia_villager_statue","wood");
    public static final DeferredBlock<Block> DARK_OAK_VILLAGER_STATUE = blockModRegister("villager_statue","dark_oak_villager_statue","wood");
    public static final DeferredBlock<Block> MANGROVE_VILLAGER_STATUE = blockModRegister("villager_statue","mangrove_villager_statue","wood");
    public static final DeferredBlock<Block> CHERRY_VILLAGER_STATUE = blockModRegister("villager_statue","cherry_villager_statue","cherry");
    public static final DeferredBlock<Block> BAMBOO_VILLAGER_STATUE = blockModRegister("villager_statue","bamboo_villager_statue","bamboo");
    public static final DeferredBlock<Block> CRIMSON_VILLAGER_STATUE = blockModRegister("villager_statue","crimson_villager_statue","netherwood");
    public static final DeferredBlock<Block> WARPED_VILLAGER_STATUE = blockModRegister("villager_statue","warped_villager_statue","netherwood");
    public static final DeferredBlock<Block> STONE_VILLAGER_STATUE =  blockModRegister("villager_statue","stone_villager_statue","stone");
    public static final DeferredBlock<Block> MOSSY_STONE_VILLAGER_STATUE =  blockModRegister("villager_statue","mossy_stone_villager_statue","stone");
    public static final DeferredBlock<Block> ANDESITE_VILLAGER_STATUE =  blockModRegister("villager_statue","andesite_villager_statue","stone");
    public static final DeferredBlock<Block> DIORITE_VILLAGER_STATUE =  blockModRegister("villager_statue","diorite_villager_statue","stone");
    public static final DeferredBlock<Block> GRANITE_VILLAGER_STATUE =  blockModRegister("villager_statue","granite_villager_statue","stone");
    public static final DeferredBlock<Block> PRISMARINE_VILLAGER_STATUE =  blockModRegister("villager_statue","prismarine_villager_statue","stone");
    public static final DeferredBlock<Block> BLACKSTONE_VILLAGER_STATUE =  blockModRegister("villager_statue","blackstone_villager_statue","stone");
    public static final DeferredBlock<Block> PURPUR_BLOCK_VILLAGER_STATUE =  blockModRegister("villager_statue","purpur_block_villager_statue","stone");
    public static final DeferredBlock<Block> DEEPSLATE_VILLAGER_STATUE =  blockModRegister("villager_statue","deepslate_villager_statue","deepslate");
    public static final DeferredBlock<Block> TUFF_VILLAGER_STATUE =  blockModRegister("villager_statue","tuff_villager_statue","tuff");
    public static final DeferredBlock<Block> PACKED_MUD_VILLAGER_STATUE =  blockModRegister("villager_statue","packed_mud_villager_statue","mud");
    public static final DeferredBlock<Block> SANDSTONE_VILLAGER_STATUE =  blockModRegister("villager_statue","sandstone_villager_statue","sandstone");
    public static final DeferredBlock<Block> RED_SANDSTONE_VILLAGER_STATUE =  blockModRegister("villager_statue","red_sandstone_villager_statue","sandstone");
    public static final DeferredBlock<Block> QUARTZ_BLOCK_VILLAGER_STATUE =  blockModRegister("villager_statue","quartz_block_villager_statue","sandstone");
    public static final DeferredBlock<Block> NETHER_BRICKS_VILLAGER_STATUE =  blockModRegister("villager_statue","nether_bricks_villager_statue","netherbrick");
    public static final DeferredBlock<Block> BASALT_VILLAGER_STATUE =  blockModRegister("villager_statue","basalt_villager_statue","basalt");
    public static final DeferredBlock<Block> END_STONE_VILLAGER_STATUE =  blockModRegister("villager_statue","end_stone_villager_statue","endstone");
    public static final DeferredBlock<Block> COAL_BLOCK_VILLAGER_STATUE =  blockModRegister("villager_statue","coal_block_villager_statue","mineral_strong");
    public static final DeferredBlock<Block> IRON_BLOCK_VILLAGER_STATUE =  blockModRegister("villager_statue","iron_block_villager_statue","metal");
    public static final DeferredBlock<Block> GOLD_BLOCK_VILLAGER_STATUE =  blockModRegister("villager_statue","gold_block_villager_statue","metal");
    public static final DeferredBlock<Block> REDSTONE_BLOCK_VILLAGER_STATUE =  blockModRegister("villager_statue","redstone_block_villager_statue","metal");
    public static final DeferredBlock<Block> EMERALD_BLOCK_VILLAGER_STATUE =  blockModRegister("villager_statue","emerald_block_villager_statue","metal");
    public static final DeferredBlock<Block> DIAMOND_BLOCK_VILLAGER_STATUE =  blockModRegister("villager_statue","diamond_block_villager_statue","metal");
    public static final DeferredBlock<Block> COPPER_BLOCK_VILLAGER_STATUE =  blockModRegister("villager_statue","copper_block_villager_statue","copper");
    public static final DeferredBlock<Block> LAPIS_BLOCK_VILLAGER_STATUE =  blockModRegister("villager_statue","lapis_block_villager_statue","mineral_weak");
    public static final DeferredBlock<Block> NETHERITE_BLOCK_VILLAGER_STATUE =  blockModRegister("villager_statue","netherite_block_villager_statue","netherite");
    public static final DeferredBlock<Block> OBSIDIAN_VILLAGER_STATUE =  blockModRegister("villager_statue","obsidian_villager_statue","obsidan");
    public static final DeferredBlock<Block> AMETHYST_BLOCK_VILLAGER_STATUE =  blockModRegister("villager_statue","amethyst_block_villager_statue","amethyst");
    public static final DeferredBlock<Block> DRIPSTONE_BLOCK_VILLAGER_STATUE =  blockModRegister("villager_statue","dripstone_block_villager_statue","dripstone");
    public static final DeferredBlock<Block> BEDROCK_VILLAGER_STATUE =  blockModRegister("villager_statue","bedrock_villager_statue","bedrock");
        //pedestal
    public static final DeferredBlock<Block> OAK_PEDESTAL = blockModRegister("villager_pedestal","oak_villager_pedestal","wood");
    public static final DeferredBlock<Block> BIRCH_PEDESTAL = blockModRegister("villager_pedestal","birch_villager_pedestal","wood");
    public static final DeferredBlock<Block> SPRUCE_PEDESTAL = blockModRegister("villager_pedestal","spruce_villager_pedestal","wood");
    public static final DeferredBlock<Block> JUNGLE_PEDESTAL = blockModRegister("villager_pedestal","jungle_villager_pedestal","wood");
    public static final DeferredBlock<Block> ACACIA_PEDESTAL = blockModRegister("villager_pedestal","acacia_villager_pedestal","wood");
    public static final DeferredBlock<Block> DARK_OAK_PEDESTAL = blockModRegister("villager_pedestal","dark_oak_villager_pedestal","wood");
    public static final DeferredBlock<Block> MANGROVE_PEDESTAL = blockModRegister("villager_pedestal","mangrove_villager_pedestal","wood");
    public static final DeferredBlock<Block> CHERRY_PEDESTAL = blockModRegister("villager_pedestal","cherry_villager_pedestal","cherry");
    public static final DeferredBlock<Block> BAMBOO_PEDESTAL = blockModRegister("villager_pedestal","bamboo_villager_pedestal","bamboo");
    public static final DeferredBlock<Block> CRIMSON_PEDESTAL = blockModRegister("villager_pedestal","crimson_villager_pedestal","netherwood");
    public static final DeferredBlock<Block> WARPED_PEDESTAL = blockModRegister("villager_pedestal","warped_villager_pedestal","netherwood");
    public static final DeferredBlock<Block> STONE_PEDESTAL =  blockModRegister("villager_pedestal","stone_villager_pedestal","stone");
    public static final DeferredBlock<Block> MOSSY_STONE_PEDESTAL =  blockModRegister("villager_pedestal","mossy_stone_villager_pedestal","stone");
    public static final DeferredBlock<Block> ANDESITE_PEDESTAL =  blockModRegister("villager_pedestal","andesite_villager_pedestal","stone");
    public static final DeferredBlock<Block> DIORITE_PEDESTAL =  blockModRegister("villager_pedestal","diorite_villager_pedestal","stone");
    public static final DeferredBlock<Block> GRANITE_PEDESTAL =  blockModRegister("villager_pedestal","granite_villager_pedestal","stone");
    public static final DeferredBlock<Block> PRISMARINE_PEDESTAL =  blockModRegister("villager_pedestal","prismarine_villager_pedestal","stone");
    public static final DeferredBlock<Block> BLACKSTONE_PEDESTAL =  blockModRegister("villager_pedestal","blackstone_villager_pedestal","stone");
    public static final DeferredBlock<Block> PURPUR_BLOCK_PEDESTAL =  blockModRegister("villager_pedestal","purpur_block_villager_pedestal","stone");
    public static final DeferredBlock<Block> DEEPSLATE_PEDESTAL =  blockModRegister("villager_pedestal","deepslate_villager_pedestal","deepslate");
    public static final DeferredBlock<Block> TUFF_PEDESTAL =  blockModRegister("villager_pedestal","tuff_villager_pedestal","tuff");
    public static final DeferredBlock<Block> PACKED_MUD_PEDESTAL =  blockModRegister("villager_pedestal","packed_mud_villager_pedestal","mud");
    public static final DeferredBlock<Block> SANDSTONE_PEDESTAL =  blockModRegister("villager_pedestal","sandstone_villager_pedestal","sandstone");
    public static final DeferredBlock<Block> RED_SANDSTONE_PEDESTAL =  blockModRegister("villager_pedestal","red_sandstone_villager_pedestal","sandstone");
    public static final DeferredBlock<Block> QUARTZ_BLOCK_PEDESTAL =  blockModRegister("villager_pedestal","quartz_block_villager_pedestal","sandstone");
    public static final DeferredBlock<Block> NETHER_BRICKS_PEDESTAL =  blockModRegister("villager_pedestal","nether_bricks_villager_pedestal","netherbrick");
    public static final DeferredBlock<Block> BASALT_PEDESTAL =  blockModRegister("villager_pedestal","basalt_villager_pedestal","basalt");
    public static final DeferredBlock<Block> END_STONE_PEDESTAL =  blockModRegister("villager_pedestal","end_stone_villager_pedestal","endstone");
    public static final DeferredBlock<Block> COAL_BLOCK_PEDESTAL =  blockModRegister("villager_pedestal","coal_block_villager_pedestal","mineral_strong");
    public static final DeferredBlock<Block> IRON_BLOCK_PEDESTAL =  blockModRegister("villager_pedestal","iron_block_villager_pedestal","metal");
    public static final DeferredBlock<Block> GOLD_BLOCK_PEDESTAL =  blockModRegister("villager_pedestal","gold_block_villager_pedestal","metal");
    public static final DeferredBlock<Block> REDSTONE_BLOCK_PEDESTAL =  blockModRegister("villager_pedestal","redstone_block_villager_pedestal","metal");
    public static final DeferredBlock<Block> EMERALD_BLOCK_PEDESTAL =  blockModRegister("villager_pedestal","emerald_block_villager_pedestal","metal");
    public static final DeferredBlock<Block> DIAMOND_BLOCK_PEDESTAL =  blockModRegister("villager_pedestal","diamond_block_villager_pedestal","metal");
    public static final DeferredBlock<Block> COPPER_BLOCK_PEDESTAL =  blockModRegister("villager_pedestal","copper_block_villager_pedestal","copper");
    public static final DeferredBlock<Block> LAPIS_BLOCK_PEDESTAL =  blockModRegister("villager_pedestal","lapis_block_villager_pedestal","mineral_weak");
    public static final DeferredBlock<Block> NETHERITE_BLOCK_PEDESTAL =  blockModRegister("villager_pedestal","netherite_block_villager_pedestal","netherite");
    public static final DeferredBlock<Block> OBSIDIAN_PEDESTAL =  blockModRegister("villager_pedestal","obsidian_villager_pedestal","obsidan");
    public static final DeferredBlock<Block> AMETHYST_BLOCK_PEDESTAL =  blockModRegister("villager_pedestal","amethyst_block_villager_pedestal","amethyst");
    public static final DeferredBlock<Block> DRIPSTONE_BLOCK_PEDESTAL =  blockModRegister("villager_pedestal","dripstone_block_villager_pedestal","dripstone");
    public static final DeferredBlock<Block> BEDROCK_PEDESTAL =  blockModRegister("villager_pedestal","bedrock_villager_pedestal","bedrock");
        //brazier
    public static final DeferredBlock<Block> OAK_VILLAGER_BRAZIER = blockModRegister("villager_brazier","oak_villager_brazier","wood");
    public static final DeferredBlock<Block> BIRCH_VILLAGER_BRAZIER = blockModRegister("villager_brazier","birch_villager_brazier","wood");
    public static final DeferredBlock<Block> SPRUCE_VILLAGER_BRAZIER = blockModRegister("villager_brazier","spruce_villager_brazier","wood");
    public static final DeferredBlock<Block> JUNGLE_VILLAGER_BRAZIER = blockModRegister("villager_brazier","jungle_villager_brazier","wood");
    public static final DeferredBlock<Block> ACACIA_VILLAGER_BRAZIER = blockModRegister("villager_brazier","acacia_villager_brazier","wood");
    public static final DeferredBlock<Block> DARK_OAK_VILLAGER_BRAZIER = blockModRegister("villager_brazier","dark_oak_villager_brazier","wood");
    public static final DeferredBlock<Block> MANGROVE_VILLAGER_BRAZIER = blockModRegister("villager_brazier","mangrove_villager_brazier","wood");
    public static final DeferredBlock<Block> CHERRY_VILLAGER_BRAZIER = blockModRegister("villager_brazier","cherry_villager_brazier","cherry");
    public static final DeferredBlock<Block> BAMBOO_VILLAGER_BRAZIER = blockModRegister("villager_brazier","bamboo_villager_brazier","bamboo");
    public static final DeferredBlock<Block> CRIMSON_VILLAGER_BRAZIER = blockModRegister("villager_brazier","crimson_villager_brazier","netherwood");
    public static final DeferredBlock<Block> WARPED_VILLAGER_BRAZIER = blockModRegister("villager_brazier","warped_villager_brazier","netherwood");
    public static final DeferredBlock<Block> STONE_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","stone_villager_brazier","stone");
    public static final DeferredBlock<Block> MOSSY_STONE_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","mossy_stone_villager_brazier","stone");
    public static final DeferredBlock<Block> ANDESITE_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","andesite_villager_brazier","stone");
    public static final DeferredBlock<Block> DIORITE_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","diorite_villager_brazier","stone");
    public static final DeferredBlock<Block> GRANITE_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","granite_villager_brazier","stone");
    public static final DeferredBlock<Block> PRISMARINE_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","prismarine_villager_brazier","stone");
    public static final DeferredBlock<Block> BLACKSTONE_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","blackstone_villager_brazier","stone");
    public static final DeferredBlock<Block> PURPUR_BLOCK_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","purpur_block_villager_brazier","stone");
    public static final DeferredBlock<Block> DEEPSLATE_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","deepslate_villager_brazier","deepslate");
    public static final DeferredBlock<Block> TUFF_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","tuff_villager_brazier","tuff");
    public static final DeferredBlock<Block> PACKED_MUD_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","packed_mud_villager_brazier","mud");
    public static final DeferredBlock<Block> SANDSTONE_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","sandstone_villager_brazier","sandstone");
    public static final DeferredBlock<Block> RED_SANDSTONE_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","red_sandstone_villager_brazier","sandstone");
    public static final DeferredBlock<Block> QUARTZ_BLOCK_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","quartz_block_villager_brazier","sandstone");
    public static final DeferredBlock<Block> NETHER_BRICKS_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","nether_bricks_villager_brazier","netherbrick");
    public static final DeferredBlock<Block> BASALT_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","basalt_villager_brazier","basalt");
    public static final DeferredBlock<Block> END_STONE_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","end_stone_villager_brazier","endstone");
    public static final DeferredBlock<Block> COAL_BLOCK_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","coal_block_villager_brazier","mineral_strong");
    public static final DeferredBlock<Block> IRON_BLOCK_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","iron_block_villager_brazier","metal");
    public static final DeferredBlock<Block> GOLD_BLOCK_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","gold_block_villager_brazier","metal");
    public static final DeferredBlock<Block> REDSTONE_BLOCK_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","redstone_block_villager_brazier","metal");
    public static final DeferredBlock<Block> EMERALD_BLOCK_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","emerald_block_villager_brazier","metal");
    public static final DeferredBlock<Block> DIAMOND_BLOCK_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","diamond_block_villager_brazier","metal");
    public static final DeferredBlock<Block> COPPER_BLOCK_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","copper_block_villager_brazier","copper");
    public static final DeferredBlock<Block> LAPIS_BLOCK_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","lapis_block_villager_brazier","mineral_weak");
    public static final DeferredBlock<Block> NETHERITE_BLOCK_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","netherite_block_villager_brazier","netherite");
    public static final DeferredBlock<Block> OBSIDIAN_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","obsidian_villager_brazier","obsidan");
    public static final DeferredBlock<Block> AMETHYST_BLOCK_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","amethyst_block_villager_brazier","amethyst");
    public static final DeferredBlock<Block> DRIPSTONE_BLOCK_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","dripstone_block_villager_brazier","dripstone");
    public static final DeferredBlock<Block> BEDROCK_VILLAGER_BRAZIER =  blockModRegister("villager_brazier","bedrock_villager_brazier","bedrock");
        //table zone
    public static final DeferredBlock<Block> OAK_VILLAGER_TABLE = blockModRegister("villager_table","oak_villager_table","wood");
    public static final DeferredBlock<Block> BIRCH_VILLAGER_TABLE = blockModRegister("villager_table","birch_villager_table","wood");
    public static final DeferredBlock<Block> SPRUCE_VILLAGER_TABLE = blockModRegister("villager_table","spruce_villager_table","wood");
    public static final DeferredBlock<Block> JUNGLE_VILLAGER_TABLE = blockModRegister("villager_table","jungle_villager_table","wood");
    public static final DeferredBlock<Block> ACACIA_VILLAGER_TABLE = blockModRegister("villager_table","acacia_villager_table","wood");
    public static final DeferredBlock<Block> DARK_OAK_VILLAGER_TABLE = blockModRegister("villager_table","dark_oak_villager_table","wood");
    public static final DeferredBlock<Block> MANGROVE_VILLAGER_TABLE = blockModRegister("villager_table","mangrove_villager_table","wood");
    public static final DeferredBlock<Block> CHERRY_VILLAGER_TABLE = blockModRegister("villager_table","cherry_villager_table","cherry");
    public static final DeferredBlock<Block> BAMBOO_VILLAGER_TABLE = blockModRegister("villager_table","bamboo_villager_table","bamboo");
    public static final DeferredBlock<Block> CRIMSON_VILLAGER_TABLE = blockModRegister("villager_table","crimson_villager_table","netherwood");
    public static final DeferredBlock<Block> WARPED_VILLAGER_TABLE = blockModRegister("villager_table","warped_villager_table","netherwood");
    public static final DeferredBlock<Block> STONE_VILLAGER_TABLE =  blockModRegister("villager_table","stone_villager_table","stone");
    public static final DeferredBlock<Block> MOSSY_STONE_VILLAGER_TABLE =  blockModRegister("villager_table","mossy_stone_villager_table","stone");
    public static final DeferredBlock<Block> ANDESITE_VILLAGER_TABLE =  blockModRegister("villager_table","andesite_villager_table","stone");
    public static final DeferredBlock<Block> DIORITE_VILLAGER_TABLE =  blockModRegister("villager_table","diorite_villager_table","stone");
    public static final DeferredBlock<Block> GRANITE_VILLAGER_TABLE =  blockModRegister("villager_table","granite_villager_table","stone");
    public static final DeferredBlock<Block> PRISMARINE_VILLAGER_TABLE =  blockModRegister("villager_table","prismarine_villager_table","stone");
    public static final DeferredBlock<Block> BLACKSTONE_VILLAGER_TABLE =  blockModRegister("villager_table","blackstone_villager_table","stone");
    public static final DeferredBlock<Block> PURPUR_BLOCK_VILLAGER_TABLE =  blockModRegister("villager_table","purpur_block_villager_table","stone");
    public static final DeferredBlock<Block> DEEPSLATE_VILLAGER_TABLE =  blockModRegister("villager_table","deepslate_villager_table","deepslate");
    public static final DeferredBlock<Block> TUFF_VILLAGER_TABLE =  blockModRegister("villager_table","tuff_villager_table","tuff");
    public static final DeferredBlock<Block> PACKED_MUD_VILLAGER_TABLE =  blockModRegister("villager_table","packed_mud_villager_table","mud");
    public static final DeferredBlock<Block> SANDSTONE_VILLAGER_TABLE =  blockModRegister("villager_table","sandstone_villager_table","sandstone");
    public static final DeferredBlock<Block> RED_SANDSTONE_VILLAGER_TABLE =  blockModRegister("villager_table","red_sandstone_villager_table","sandstone");
    public static final DeferredBlock<Block> QUARTZ_BLOCK_VILLAGER_TABLE =  blockModRegister("villager_table","quartz_block_villager_table","sandstone");
    public static final DeferredBlock<Block> NETHER_BRICKS_VILLAGER_TABLE =  blockModRegister("villager_table","nether_bricks_villager_table","netherbrick");
    public static final DeferredBlock<Block> BASALT_VILLAGER_TABLE =  blockModRegister("villager_table","basalt_villager_table","basalt");
    public static final DeferredBlock<Block> END_STONE_VILLAGER_TABLE =  blockModRegister("villager_table","end_stone_villager_table","endstone");
    public static final DeferredBlock<Block> COAL_BLOCK_VILLAGER_TABLE =  blockModRegister("villager_table","coal_block_villager_table","mineral_strong");
    public static final DeferredBlock<Block> IRON_BLOCK_VILLAGER_TABLE =  blockModRegister("villager_table","iron_block_villager_table","metal");
    public static final DeferredBlock<Block> GOLD_BLOCK_VILLAGER_TABLE =  blockModRegister("villager_table","gold_block_villager_table","metal");
    public static final DeferredBlock<Block> REDSTONE_BLOCK_VILLAGER_TABLE =  blockModRegister("villager_table","redstone_block_villager_table","metal");
    public static final DeferredBlock<Block> EMERALD_BLOCK_VILLAGER_TABLE =  blockModRegister("villager_table","emerald_block_villager_table","metal");
    public static final DeferredBlock<Block> DIAMOND_BLOCK_VILLAGER_TABLE =  blockModRegister("villager_table","diamond_block_villager_table","metal");
    public static final DeferredBlock<Block> COPPER_BLOCK_VILLAGER_TABLE =  blockModRegister("villager_table","copper_block_villager_table","copper");
    public static final DeferredBlock<Block> LAPIS_BLOCK_VILLAGER_TABLE =  blockModRegister("villager_table","lapis_block_villager_table","mineral_weak");
    public static final DeferredBlock<Block> NETHERITE_BLOCK_VILLAGER_TABLE =  blockModRegister("villager_table","netherite_block_villager_table","netherite");
    public static final DeferredBlock<Block> OBSIDIAN_VILLAGER_TABLE =  blockModRegister("villager_table","obsidian_villager_table","obsidan");
    public static final DeferredBlock<Block> AMETHYST_BLOCK_VILLAGER_TABLE =  blockModRegister("villager_table","amethyst_block_villager_table","amethyst");
    public static final DeferredBlock<Block> DRIPSTONE_BLOCK_VILLAGER_TABLE =  blockModRegister("villager_table","dripstone_block_villager_table","dripstone");
    public static final DeferredBlock<Block> BEDROCK_VILLAGER_TABLE =  blockModRegister("villager_table","bedrock_villager_table","bedrock");
        //chair zone
    public static final DeferredBlock<Block> OAK_VILLAGER_CHAIR = blockModRegister("villager_chair","oak_villager_chair","wood");
    public static final DeferredBlock<Block> BIRCH_VILLAGER_CHAIR = blockModRegister("villager_chair","birch_villager_chair","wood");
    public static final DeferredBlock<Block> SPRUCE_VILLAGER_CHAIR = blockModRegister("villager_chair","spruce_villager_chair","wood");
    public static final DeferredBlock<Block> JUNGLE_VILLAGER_CHAIR = blockModRegister("villager_chair","jungle_villager_chair","wood");
    public static final DeferredBlock<Block> ACACIA_VILLAGER_CHAIR = blockModRegister("villager_chair","acacia_villager_chair","wood");
    public static final DeferredBlock<Block> DARK_OAK_VILLAGER_CHAIR = blockModRegister("villager_chair","dark_oak_villager_chair","wood");
    public static final DeferredBlock<Block> MANGROVE_VILLAGER_CHAIR = blockModRegister("villager_chair","mangrove_villager_chair","wood");
    public static final DeferredBlock<Block> CHERRY_VILLAGER_CHAIR = blockModRegister("villager_chair","cherry_villager_chair","cherry");
    public static final DeferredBlock<Block> BAMBOO_VILLAGER_CHAIR = blockModRegister("villager_chair","bamboo_villager_chair","bamboo");
    public static final DeferredBlock<Block> CRIMSON_VILLAGER_CHAIR = blockModRegister("villager_chair","crimson_villager_chair","netherwood");
    public static final DeferredBlock<Block> WARPED_VILLAGER_CHAIR = blockModRegister("villager_chair","warped_villager_chair","netherwood");
    public static final DeferredBlock<Block> STONE_VILLAGER_CHAIR =  blockModRegister("villager_chair","stone_villager_chair","stone");
    public static final DeferredBlock<Block> MOSSY_STONE_VILLAGER_CHAIR =  blockModRegister("villager_chair","mossy_stone_villager_chair","stone");
    public static final DeferredBlock<Block> ANDESITE_VILLAGER_CHAIR =  blockModRegister("villager_chair","andesite_villager_chair","stone");
    public static final DeferredBlock<Block> DIORITE_VILLAGER_CHAIR =  blockModRegister("villager_chair","diorite_villager_chair","stone");
    public static final DeferredBlock<Block> GRANITE_VILLAGER_CHAIR =  blockModRegister("villager_chair","granite_villager_chair","stone");
    public static final DeferredBlock<Block> PRISMARINE_VILLAGER_CHAIR =  blockModRegister("villager_chair","prismarine_villager_chair","stone");
    public static final DeferredBlock<Block> BLACKSTONE_VILLAGER_CHAIR =  blockModRegister("villager_chair","blackstone_villager_chair","stone");
    public static final DeferredBlock<Block> PURPUR_BLOCK_VILLAGER_CHAIR =  blockModRegister("villager_chair","purpur_block_villager_chair","stone");
    public static final DeferredBlock<Block> DEEPSLATE_VILLAGER_CHAIR =  blockModRegister("villager_chair","deepslate_villager_chair","deepslate");
    public static final DeferredBlock<Block> TUFF_VILLAGER_CHAIR =  blockModRegister("villager_chair","tuff_villager_chair","tuff");
    public static final DeferredBlock<Block> PACKED_MUD_VILLAGER_CHAIR =  blockModRegister("villager_chair","packed_mud_villager_chair","mud");
    public static final DeferredBlock<Block> SANDSTONE_VILLAGER_CHAIR =  blockModRegister("villager_chair","sandstone_villager_chair","sandstone");
    public static final DeferredBlock<Block> RED_SANDSTONE_VILLAGER_CHAIR =  blockModRegister("villager_chair","red_sandstone_villager_chair","sandstone");
    public static final DeferredBlock<Block> QUARTZ_BLOCK_VILLAGER_CHAIR =  blockModRegister("villager_chair","quartz_block_villager_chair","sandstone");
    public static final DeferredBlock<Block> NETHER_BRICKS_VILLAGER_CHAIR =  blockModRegister("villager_chair","nether_bricks_villager_chair","netherbrick");
    public static final DeferredBlock<Block> BASALT_VILLAGER_CHAIR =  blockModRegister("villager_chair","basalt_villager_chair","basalt");
    public static final DeferredBlock<Block> END_STONE_VILLAGER_CHAIR =  blockModRegister("villager_chair","end_stone_villager_chair","endstone");
    public static final DeferredBlock<Block> COAL_BLOCK_VILLAGER_CHAIR =  blockModRegister("villager_chair","coal_block_villager_chair","mineral_strong");
    public static final DeferredBlock<Block> IRON_BLOCK_VILLAGER_CHAIR =  blockModRegister("villager_chair","iron_block_villager_chair","metal");
    public static final DeferredBlock<Block> GOLD_BLOCK_VILLAGER_CHAIR =  blockModRegister("villager_chair","gold_block_villager_chair","metal");
    public static final DeferredBlock<Block> REDSTONE_BLOCK_VILLAGER_CHAIR =  blockModRegister("villager_chair","redstone_block_villager_chair","metal");
    public static final DeferredBlock<Block> EMERALD_BLOCK_VILLAGER_CHAIR =  blockModRegister("villager_chair","emerald_block_villager_chair","metal");
    public static final DeferredBlock<Block> DIAMOND_BLOCK_VILLAGER_CHAIR =  blockModRegister("villager_chair","diamond_block_villager_chair","metal");
    public static final DeferredBlock<Block> COPPER_BLOCK_VILLAGER_CHAIR =  blockModRegister("villager_chair","copper_block_villager_chair","copper");
    public static final DeferredBlock<Block> LAPIS_BLOCK_VILLAGER_CHAIR =  blockModRegister("villager_chair","lapis_block_villager_chair","mineral_weak");
    public static final DeferredBlock<Block> NETHERITE_BLOCK_VILLAGER_CHAIR =  blockModRegister("villager_chair","netherite_block_villager_chair","netherite");
    public static final DeferredBlock<Block> OBSIDIAN_VILLAGER_CHAIR =  blockModRegister("villager_chair","obsidian_villager_chair","obsidan");
    public static final DeferredBlock<Block> AMETHYST_BLOCK_VILLAGER_CHAIR =  blockModRegister("villager_chair","amethyst_block_villager_chair","amethyst");
    public static final DeferredBlock<Block> DRIPSTONE_BLOCK_VILLAGER_CHAIR =  blockModRegister("villager_chair","dripstone_block_villager_chair","dripstone");
    public static final DeferredBlock<Block> BEDROCK_VILLAGER_CHAIR =  blockModRegister("villager_chair","bedrock_villager_chair","bedrock");
        //throne chair
    public static final DeferredBlock<Block> OAK_VILLAGER_THRONE_CHAIR = blockModRegister("villager_throne_chair","oak_villager_throne_chair","wood");
    public static final DeferredBlock<Block> BIRCH_VILLAGER_THRONE_CHAIR = blockModRegister("villager_throne_chair","birch_villager_throne_chair","wood");
    public static final DeferredBlock<Block> SPRUCE_VILLAGER_THRONE_CHAIR = blockModRegister("villager_throne_chair","spruce_villager_throne_chair","wood");
    public static final DeferredBlock<Block> JUNGLE_VILLAGER_THRONE_CHAIR = blockModRegister("villager_throne_chair","jungle_villager_throne_chair","wood");
    public static final DeferredBlock<Block> ACACIA_VILLAGER_THRONE_CHAIR = blockModRegister("villager_throne_chair","acacia_villager_throne_chair","wood");
    public static final DeferredBlock<Block> DARK_OAK_VILLAGER_THRONE_CHAIR = blockModRegister("villager_throne_chair","dark_oak_villager_throne_chair","wood");
    public static final DeferredBlock<Block> MANGROVE_VILLAGER_THRONE_CHAIR = blockModRegister("villager_throne_chair","mangrove_villager_throne_chair","wood");
    public static final DeferredBlock<Block> CHERRY_VILLAGER_THRONE_CHAIR = blockModRegister("villager_throne_chair","cherry_villager_throne_chair","cherry");
    public static final DeferredBlock<Block> BAMBOO_VILLAGER_THRONE_CHAIR = blockModRegister("villager_throne_chair","bamboo_villager_throne_chair","bamboo");
    public static final DeferredBlock<Block> CRIMSON_VILLAGER_THRONE_CHAIR = blockModRegister("villager_throne_chair","crimson_villager_throne_chair","netherwood");
    public static final DeferredBlock<Block> WARPED_VILLAGER_THRONE_CHAIR = blockModRegister("villager_throne_chair","warped_villager_throne_chair","netherwood");
    public static final DeferredBlock<Block> STONE_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","stone_villager_throne_chair","stone");
    public static final DeferredBlock<Block> MOSSY_STONE_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","mossy_stone_villager_throne_chair","stone");
    public static final DeferredBlock<Block> ANDESITE_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","andesite_villager_throne_chair","stone");
    public static final DeferredBlock<Block> DIORITE_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","diorite_villager_throne_chair","stone");
    public static final DeferredBlock<Block> GRANITE_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","granite_villager_throne_chair","stone");
    public static final DeferredBlock<Block> PRISMARINE_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","prismarine_villager_throne_chair","stone");
    public static final DeferredBlock<Block> BLACKSTONE_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","blackstone_villager_throne_chair","stone");
    public static final DeferredBlock<Block> PURPUR_BLOCK_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","purpur_block_villager_throne_chair","stone");
    public static final DeferredBlock<Block> DEEPSLATE_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","deepslate_villager_throne_chair","deepslate");
    public static final DeferredBlock<Block> TUFF_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","tuff_villager_throne_chair","tuff");
    public static final DeferredBlock<Block> PACKED_MUD_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","packed_mud_villager_throne_chair","mud");
    public static final DeferredBlock<Block> SANDSTONE_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","sandstone_villager_throne_chair","sandstone");
    public static final DeferredBlock<Block> RED_SANDSTONE_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","red_sandstone_villager_throne_chair","sandstone");
    public static final DeferredBlock<Block> QUARTZ_BLOCK_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","quartz_block_villager_throne_chair","sandstone");
    public static final DeferredBlock<Block> NETHER_BRICKS_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","nether_bricks_villager_throne_chair","netherbrick");
    public static final DeferredBlock<Block> BASALT_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","basalt_villager_throne_chair","basalt");
    public static final DeferredBlock<Block> END_STONE_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","end_stone_villager_throne_chair","endstone");
    public static final DeferredBlock<Block> COAL_BLOCK_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","coal_block_villager_throne_chair","mineral_strong");
    public static final DeferredBlock<Block> IRON_BLOCK_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","iron_block_villager_throne_chair","metal");
    public static final DeferredBlock<Block> GOLD_BLOCK_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","gold_block_villager_throne_chair","metal");
    public static final DeferredBlock<Block> REDSTONE_BLOCK_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","redstone_block_villager_throne_chair","metal");
    public static final DeferredBlock<Block> EMERALD_BLOCK_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","emerald_block_villager_throne_chair","metal");
    public static final DeferredBlock<Block> DIAMOND_BLOCK_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","diamond_block_villager_throne_chair","metal");
    public static final DeferredBlock<Block> COPPER_BLOCK_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","copper_block_villager_throne_chair","copper");
    public static final DeferredBlock<Block> LAPIS_BLOCK_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","lapis_block_villager_throne_chair","mineral_weak");
    public static final DeferredBlock<Block> NETHERITE_BLOCK_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","netherite_block_villager_throne_chair","netherite");
    public static final DeferredBlock<Block> OBSIDIAN_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","obsidian_villager_throne_chair","obsidan");
    public static final DeferredBlock<Block> AMETHYST_BLOCK_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","amethyst_block_villager_throne_chair","amethyst");
    public static final DeferredBlock<Block> DRIPSTONE_BLOCK_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","dripstone_block_villager_throne_chair","dripstone");
    public static final DeferredBlock<Block> BEDROCK_VILLAGER_THRONE_CHAIR =  blockModRegister("villager_throne_chair","bedrock_villager_throne_chair","bedrock");

    //drawer
    public static final DeferredBlock<Block> OAK_VILLAGER_DRAWER = blockModRegister("villager_drawer","oak_villager_drawer","wood");
    public static final DeferredBlock<Block> BIRCH_VILLAGER_DRAWER = blockModRegister("villager_drawer","birch_villager_drawer","wood");
    public static final DeferredBlock<Block> SPRUCE_VILLAGER_DRAWER = blockModRegister("villager_drawer","spruce_villager_drawer","wood");
    public static final DeferredBlock<Block> JUNGLE_VILLAGER_DRAWER = blockModRegister("villager_drawer","jungle_villager_drawer","wood");
    public static final DeferredBlock<Block> ACACIA_VILLAGER_DRAWER = blockModRegister("villager_drawer","acacia_villager_drawer","wood");
    public static final DeferredBlock<Block> DARK_OAK_VILLAGER_DRAWER = blockModRegister("villager_drawer","dark_oak_villager_drawer","wood");
    public static final DeferredBlock<Block> MANGROVE_VILLAGER_DRAWER = blockModRegister("villager_drawer","mangrove_villager_drawer","wood");
    public static final DeferredBlock<Block> CHERRY_VILLAGER_DRAWER = blockModRegister("villager_drawer","cherry_villager_drawer","cherry");
    public static final DeferredBlock<Block> BAMBOO_VILLAGER_DRAWER = blockModRegister("villager_drawer","bamboo_villager_drawer","bamboo");
    public static final DeferredBlock<Block> CRIMSON_VILLAGER_DRAWER = blockModRegister("villager_drawer","crimson_villager_drawer","netherwood");
    public static final DeferredBlock<Block> WARPED_VILLAGER_DRAWER = blockModRegister("villager_drawer","warped_villager_drawer","netherwood");
    public static final DeferredBlock<Block> STONE_VILLAGER_DRAWER =  blockModRegister("villager_drawer","stone_villager_drawer","stone");
    public static final DeferredBlock<Block> MOSSY_STONE_VILLAGER_DRAWER =  blockModRegister("villager_drawer","mossy_stone_villager_drawer","stone");
    public static final DeferredBlock<Block> ANDESITE_VILLAGER_DRAWER =  blockModRegister("villager_drawer","andesite_villager_drawer","stone");
    public static final DeferredBlock<Block> DIORITE_VILLAGER_DRAWER =  blockModRegister("villager_drawer","diorite_villager_drawer","stone");
    public static final DeferredBlock<Block> GRANITE_VILLAGER_DRAWER =  blockModRegister("villager_drawer","granite_villager_drawer","stone");
    public static final DeferredBlock<Block> PRISMARINE_VILLAGER_DRAWER =  blockModRegister("villager_drawer","prismarine_villager_drawer","stone");
    public static final DeferredBlock<Block> BLACKSTONE_VILLAGER_DRAWER =  blockModRegister("villager_drawer","blackstone_villager_drawer","stone");
    public static final DeferredBlock<Block> PURPUR_BLOCK_VILLAGER_DRAWER =  blockModRegister("villager_drawer","purpur_block_villager_drawer","stone");
    public static final DeferredBlock<Block> DEEPSLATE_VILLAGER_DRAWER =  blockModRegister("villager_drawer","deepslate_villager_drawer","deepslate");
    public static final DeferredBlock<Block> TUFF_VILLAGER_DRAWER =  blockModRegister("villager_drawer","tuff_villager_drawer","tuff");
    public static final DeferredBlock<Block> PACKED_MUD_VILLAGER_DRAWER =  blockModRegister("villager_drawer","packed_mud_villager_drawer","mud");
    public static final DeferredBlock<Block> SANDSTONE_VILLAGER_DRAWER =  blockModRegister("villager_drawer","sandstone_villager_drawer","sandstone");
    public static final DeferredBlock<Block> RED_SANDSTONE_VILLAGER_DRAWER =  blockModRegister("villager_drawer","red_sandstone_villager_drawer","sandstone");
    public static final DeferredBlock<Block> QUARTZ_BLOCK_VILLAGER_DRAWER =  blockModRegister("villager_drawer","quartz_block_villager_drawer","sandstone");
    public static final DeferredBlock<Block> NETHER_BRICKS_VILLAGER_DRAWER =  blockModRegister("villager_drawer","nether_bricks_villager_drawer","netherbrick");
    public static final DeferredBlock<Block> BASALT_VILLAGER_DRAWER =  blockModRegister("villager_drawer","basalt_villager_drawer","basalt");
    public static final DeferredBlock<Block> END_STONE_VILLAGER_DRAWER =  blockModRegister("villager_drawer","end_stone_villager_drawer","endstone");
    public static final DeferredBlock<Block> COAL_BLOCK_VILLAGER_DRAWER =  blockModRegister("villager_drawer","coal_block_villager_drawer","mineral_strong");
    public static final DeferredBlock<Block> IRON_BLOCK_VILLAGER_DRAWER =  blockModRegister("villager_drawer","iron_block_villager_drawer","metal");
    public static final DeferredBlock<Block> GOLD_BLOCK_VILLAGER_DRAWER =  blockModRegister("villager_drawer","gold_block_villager_drawer","metal");
    public static final DeferredBlock<Block> REDSTONE_BLOCK_VILLAGER_DRAWER =  blockModRegister("villager_drawer","redstone_block_villager_drawer","metal");
    public static final DeferredBlock<Block> EMERALD_BLOCK_VILLAGER_DRAWER =  blockModRegister("villager_drawer","emerald_block_villager_drawer","metal");
    public static final DeferredBlock<Block> DIAMOND_BLOCK_VILLAGER_DRAWER =  blockModRegister("villager_drawer","diamond_block_villager_drawer","metal");
    public static final DeferredBlock<Block> COPPER_BLOCK_VILLAGER_DRAWER =  blockModRegister("villager_drawer","copper_block_villager_drawer","copper");
    public static final DeferredBlock<Block> LAPIS_BLOCK_VILLAGER_DRAWER =  blockModRegister("villager_drawer","lapis_block_villager_drawer","mineral_weak");
    public static final DeferredBlock<Block> NETHERITE_BLOCK_VILLAGER_DRAWER =  blockModRegister("villager_drawer","netherite_block_villager_drawer","netherite");
    public static final DeferredBlock<Block> OBSIDIAN_VILLAGER_DRAWER =  blockModRegister("villager_drawer","obsidian_villager_drawer","obsidan");
    public static final DeferredBlock<Block> AMETHYST_BLOCK_VILLAGER_DRAWER =  blockModRegister("villager_drawer","amethyst_block_villager_drawer","amethyst");
    public static final DeferredBlock<Block> DRIPSTONE_BLOCK_VILLAGER_DRAWER =  blockModRegister("villager_drawer","dripstone_block_villager_drawer","dripstone");
    public static final DeferredBlock<Block> BEDROCK_VILLAGER_DRAWER =  blockModRegister("villager_drawer","bedrock_villager_drawer","bedrock");
    //shelf
        //standing
    public static final DeferredBlock<Block> OAK_STANDING_VILLAGER_SHELF = blockModRegister("standing_villager_shelf","oak_standing_villager_shelf","wood");
    public static final DeferredBlock<Block> BIRCH_STANDING_VILLAGER_SHELF = blockModRegister("standing_villager_shelf","birch_standing_villager_shelf","wood");
    public static final DeferredBlock<Block> SPRUCE_STANDING_VILLAGER_SHELF = blockModRegister("standing_villager_shelf","spruce_standing_villager_shelf","wood");
    public static final DeferredBlock<Block> JUNGLE_STANDING_VILLAGER_SHELF = blockModRegister("standing_villager_shelf","jungle_standing_villager_shelf","wood");
    public static final DeferredBlock<Block> ACACIA_STANDING_VILLAGER_SHELF = blockModRegister("standing_villager_shelf","acacia_standing_villager_shelf","wood");
    public static final DeferredBlock<Block> DARK_OAK_STANDING_VILLAGER_SHELF = blockModRegister("standing_villager_shelf","dark_oak_standing_villager_shelf","wood");
    public static final DeferredBlock<Block> MANGROVE_STANDING_VILLAGER_SHELF = blockModRegister("standing_villager_shelf","mangrove_standing_villager_shelf","wood");
    public static final DeferredBlock<Block> CHERRY_STANDING_VILLAGER_SHELF = blockModRegister("standing_villager_shelf","cherry_standing_villager_shelf","cherry");
    public static final DeferredBlock<Block> BAMBOO_STANDING_VILLAGER_SHELF = blockModRegister("standing_villager_shelf","bamboo_standing_villager_shelf","bamboo");
    public static final DeferredBlock<Block> CRIMSON_STANDING_VILLAGER_SHELF = blockModRegister("standing_villager_shelf","crimson_standing_villager_shelf","netherwood");
    public static final DeferredBlock<Block> WARPED_STANDING_VILLAGER_SHELF = blockModRegister("standing_villager_shelf","warped_standing_villager_shelf","netherwood");
    public static final DeferredBlock<Block> STONE_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","stone_standing_villager_shelf","stone");
    public static final DeferredBlock<Block> MOSSY_STONE_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","mossy_stone_standing_villager_shelf","stone");
    public static final DeferredBlock<Block> ANDESITE_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","andesite_standing_villager_shelf","stone");
    public static final DeferredBlock<Block> DIORITE_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","diorite_standing_villager_shelf","stone");
    public static final DeferredBlock<Block> GRANITE_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","granite_standing_villager_shelf","stone");
    public static final DeferredBlock<Block> PRISMARINE_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","prismarine_standing_villager_shelf","stone");
    public static final DeferredBlock<Block> BLACKSTONE_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","blackstone_standing_villager_shelf","stone");
    public static final DeferredBlock<Block> PURPUR_BLOCK_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","purpur_block_standing_villager_shelf","stone");
    public static final DeferredBlock<Block> DEEPSLATE_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","deepslate_standing_villager_shelf","deepslate");
    public static final DeferredBlock<Block> TUFF_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","tuff_standing_villager_shelf","tuff");
    public static final DeferredBlock<Block> PACKED_MUD_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","packed_mud_standing_villager_shelf","mud");
    public static final DeferredBlock<Block> SANDSTONE_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","sandstone_standing_villager_shelf","sandstone");
    public static final DeferredBlock<Block> RED_SANDSTONE_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","red_sandstone_standing_villager_shelf","sandstone");
    public static final DeferredBlock<Block> QUARTZ_BLOCK_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","quartz_block_standing_villager_shelf","sandstone");
    public static final DeferredBlock<Block> NETHER_BRICKS_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","nether_bricks_standing_villager_shelf","netherbrick");
    public static final DeferredBlock<Block> BASALT_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","basalt_standing_villager_shelf","basalt");
    public static final DeferredBlock<Block> END_STONE_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","end_stone_standing_villager_shelf","endstone");
    public static final DeferredBlock<Block> COAL_BLOCK_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","coal_block_standing_villager_shelf","mineral_strong");
    public static final DeferredBlock<Block> IRON_BLOCK_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","iron_block_standing_villager_shelf","metal");
    public static final DeferredBlock<Block> GOLD_BLOCK_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","gold_block_standing_villager_shelf","metal");
    public static final DeferredBlock<Block> REDSTONE_BLOCK_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","redstone_block_standing_villager_shelf","metal");
    public static final DeferredBlock<Block> EMERALD_BLOCK_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","emerald_block_standing_villager_shelf","metal");
    public static final DeferredBlock<Block> DIAMOND_BLOCK_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","diamond_block_standing_villager_shelf","metal");
    public static final DeferredBlock<Block> COPPER_BLOCK_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","copper_block_standing_villager_shelf","copper");
    public static final DeferredBlock<Block> LAPIS_BLOCK_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","lapis_block_standing_villager_shelf","mineral_weak");
    public static final DeferredBlock<Block> NETHERITE_BLOCK_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","netherite_block_standing_villager_shelf","netherite");
    public static final DeferredBlock<Block> OBSIDIAN_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","obsidian_standing_villager_shelf","obsidan");
    public static final DeferredBlock<Block> AMETHYST_BLOCK_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","amethyst_block_standing_villager_shelf","amethyst");
    public static final DeferredBlock<Block> DRIPSTONE_BLOCK_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","dripstone_block_standing_villager_shelf","dripstone");
    public static final DeferredBlock<Block> BEDROCK_STANDING_VILLAGER_SHELF =  blockModRegister("standing_villager_shelf","bedrock_standing_villager_shelf","bedrock");
        //wall
    public static final DeferredBlock<Block> OAK_WALL_VILLAGER_SHELF = blockModRegister("wall_villager_shelf","oak_wall_villager_shelf","wood");
    public static final DeferredBlock<Block> BIRCH_WALL_VILLAGER_SHELF = blockModRegister("wall_villager_shelf","birch_wall_villager_shelf","wood");
    public static final DeferredBlock<Block> SPRUCE_WALL_VILLAGER_SHELF = blockModRegister("wall_villager_shelf","spruce_wall_villager_shelf","wood");
    public static final DeferredBlock<Block> JUNGLE_WALL_VILLAGER_SHELF = blockModRegister("wall_villager_shelf","jungle_wall_villager_shelf","wood");
    public static final DeferredBlock<Block> ACACIA_WALL_VILLAGER_SHELF = blockModRegister("wall_villager_shelf","acacia_wall_villager_shelf","wood");
    public static final DeferredBlock<Block> DARK_OAK_WALL_VILLAGER_SHELF = blockModRegister("wall_villager_shelf","dark_oak_wall_villager_shelf","wood");
    public static final DeferredBlock<Block> MANGROVE_WALL_VILLAGER_SHELF = blockModRegister("wall_villager_shelf","mangrove_wall_villager_shelf","wood");
    public static final DeferredBlock<Block> CHERRY_WALL_VILLAGER_SHELF = blockModRegister("wall_villager_shelf","cherry_wall_villager_shelf","cherry");
    public static final DeferredBlock<Block> BAMBOO_WALL_VILLAGER_SHELF = blockModRegister("wall_villager_shelf","bamboo_wall_villager_shelf","bamboo");
    public static final DeferredBlock<Block> CRIMSON_WALL_VILLAGER_SHELF = blockModRegister("wall_villager_shelf","crimson_wall_villager_shelf","netherwood");
    public static final DeferredBlock<Block> WARPED_WALL_VILLAGER_SHELF = blockModRegister("wall_villager_shelf","warped_wall_villager_shelf","netherwood");
    public static final DeferredBlock<Block> STONE_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","stone_wall_villager_shelf","stone");
    public static final DeferredBlock<Block> MOSSY_STONE_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","mossy_stone_wall_villager_shelf","stone");
    public static final DeferredBlock<Block> ANDESITE_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","andesite_wall_villager_shelf","stone");
    public static final DeferredBlock<Block> DIORITE_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","diorite_wall_villager_shelf","stone");
    public static final DeferredBlock<Block> GRANITE_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","granite_wall_villager_shelf","stone");
    public static final DeferredBlock<Block> PRISMARINE_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","prismarine_wall_villager_shelf","stone");
    public static final DeferredBlock<Block> BLACKSTONE_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","blackstone_wall_villager_shelf","stone");
    public static final DeferredBlock<Block> PURPUR_BLOCK_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","purpur_block_wall_villager_shelf","stone");
    public static final DeferredBlock<Block> DEEPSLATE_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","deepslate_wall_villager_shelf","deepslate");
    public static final DeferredBlock<Block> TUFF_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","tuff_wall_villager_shelf","tuff");
    public static final DeferredBlock<Block> PACKED_MUD_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","packed_mud_wall_villager_shelf","mud");
    public static final DeferredBlock<Block> SANDSTONE_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","sandstone_wall_villager_shelf","sandstone");
    public static final DeferredBlock<Block> RED_SANDSTONE_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","red_sandstone_wall_villager_shelf","sandstone");
    public static final DeferredBlock<Block> QUARTZ_BLOCK_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","quartz_block_wall_villager_shelf","sandstone");
    public static final DeferredBlock<Block> NETHER_BRICKS_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","nether_bricks_wall_villager_shelf","netherbrick");
    public static final DeferredBlock<Block> BASALT_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","basalt_wall_villager_shelf","basalt");
    public static final DeferredBlock<Block> END_STONE_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","end_stone_wall_villager_shelf","endstone");
    public static final DeferredBlock<Block> COAL_BLOCK_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","coal_block_wall_villager_shelf","mineral_strong");
    public static final DeferredBlock<Block> IRON_BLOCK_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","iron_block_wall_villager_shelf","metal");
    public static final DeferredBlock<Block> GOLD_BLOCK_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","gold_block_wall_villager_shelf","metal");
    public static final DeferredBlock<Block> REDSTONE_BLOCK_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","redstone_block_wall_villager_shelf","metal");
    public static final DeferredBlock<Block> EMERALD_BLOCK_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","emerald_block_wall_villager_shelf","metal");
    public static final DeferredBlock<Block> DIAMOND_BLOCK_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","diamond_block_wall_villager_shelf","metal");
    public static final DeferredBlock<Block> COPPER_BLOCK_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","copper_block_wall_villager_shelf","copper");
    public static final DeferredBlock<Block> LAPIS_BLOCK_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","lapis_block_wall_villager_shelf","mineral_weak");
    public static final DeferredBlock<Block> NETHERITE_BLOCK_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","netherite_block_wall_villager_shelf","netherite");
    public static final DeferredBlock<Block> OBSIDIAN_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","obsidian_wall_villager_shelf","obsidan");
    public static final DeferredBlock<Block> AMETHYST_BLOCK_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","amethyst_block_wall_villager_shelf","amethyst");
    public static final DeferredBlock<Block> DRIPSTONE_BLOCK_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","dripstone_block_wall_villager_shelf","dripstone");
    public static final DeferredBlock<Block> BEDROCK_WALL_VILLAGER_SHELF =  blockModRegister("wall_villager_shelf","bedrock_wall_villager_shelf","bedrock");
    //Villager Singing stone event block
    public static final DeferredBlock<Block> LIBERTY_BLOCK =  registerBlock("liberty_block", () -> new LibertyBlock(
            BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .strength(0.0F, 0.0F)
            .noLootTable()
            .noOcclusion()
            ));
    //create the block with a name and the factory (factory include properties)
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
    {
        DeferredBlock<T> madeBlock = BLOCKS.register(name, block);
        registerBlockItem(name, madeBlock);
        return madeBlock;
    }
    private static <T extends Block> DeferredBlock<T> registerBlockForShelf(String name, Supplier<T> block)
    {
        DeferredBlock<T> madeBlock = BLOCKS.register(name, block);
        return madeBlock;
    }

    //create the item block of the block
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
        ItemRegister.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static ToIntFunction<BlockState> litBlockEmission(int pLightValue)
    {
        return p_50763_ -> p_50763_.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
    }

    private static <T extends Block> DeferredBlock<T> blockModRegister(String block,String name, String type)
    {

        BlockBehaviour.Properties properties;
        /*
          wood as default
        */
        switch (type)
        {
            case "stone":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion();
                break;
            }
            case "cobblestone":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).noOcclusion();
                break;
            }
            case "deepslate":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE).noOcclusion();
                break;
            }
            case "tuff":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF).noOcclusion();
                break;
            }
            case "mud":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD).noOcclusion();
                break;
            }
            case "sandstone":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).noOcclusion();
                break;
            }
            case "netherbrick":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS).noOcclusion();
                break;
            }
            case "mineral_weak":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK).noOcclusion();
                break;
            }
            case "mineral_strong":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).noOcclusion();
                break;
            }
            case "metal":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion();
                break;
            }
            case "copper":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).noOcclusion();
                break;
            }
            case "basalt":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT).noOcclusion();
                break;
            }
            case "endstone":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).noOcclusion();
                break;
            }
            case "obsidan":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).noOcclusion();
                break;
            }
            case "netherite":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).noOcclusion();
                break;
            }
            case "amethyst":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).noOcclusion();
                break;
            }
            case "dripstone":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK).noOcclusion();
                break;
            }
            case "bedrock":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK).noOcclusion();
                break;
            }
            case "netherwood":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion();
                break;
            }
            case "cherry":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion();
                break;
            }
            case "bamboo":
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion();
                break;
            }

            default :
            {
                properties =  BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion();
                break;
            }
        }
        switch (block)
        {
            case "villager_statue":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(properties));
            }
            case "villager_pedestal":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerPedestalBlock(properties));
            }
            case "villager_brazier":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrazier(Boolean.TRUE,1, properties.lightLevel(litBlockEmission(15))));
            }
            case "villager_table":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerTableBlock(properties));
            }
            case "villager_chair":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChairBlock(properties));
            }
            case "villager_throne_chair":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerThroneChairBlock(properties));
            }
            case "villager_drawer":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerDrawer(properties));
            }
            case "standing_villager_shelf":
            {
                return (DeferredBlock<T>) registerBlockForShelf(name, () -> new StandingVillagerShelf(properties));
            }
            case "wall_villager_shelf":
            {
                return (DeferredBlock<T>) registerBlockForShelf(name, () -> new WallVillagerShelf(properties));
            }
            default :
            {
                return null;
            }
        }
    }

    public static void register(IEventBus modEventBus)
    {
        BLOCKS.register(modEventBus);
    }
}
