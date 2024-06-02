package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight.VillagerBrazier;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight.VillagerStatue;
import com.unpainperdu.premierpainmod.level.world.block.PedestalBlock;
import com.unpainperdu.premierpainmod.level.world.block.VillagerWorkshop;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockRegister
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PremierPainMod.MODID);

    //test zone
    public static final DeferredBlock<Block> TEST = registerBlock("test", () -> new VillagerBrazier(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion().noLootTable()));
    //WorkShopZone
    public static final DeferredBlock<Block> VILLAGER_WORKSHOP = registerBlock("villager_workshop", () -> new VillagerWorkshop(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    //staute zone (41)
    public static final DeferredBlock<Block> OAK_VILLAGER_STATUE = statueRegister("oak_villager_statue","wood");
    public static final DeferredBlock<Block> BIRCH_VILLAGER_STATUE = statueRegister("birch_villager_statue","wood");
    public static final DeferredBlock<Block> SPRUCE_VILLAGER_STATUE = statueRegister("spruce_villager_statue","wood");
    public static final DeferredBlock<Block> JUNGLE_VILLAGER_STATUE = statueRegister("jungle_villager_statue","wood");
    public static final DeferredBlock<Block> ACACIA_VILLAGER_STATUE = statueRegister("acacia_villager_statue","wood");
    public static final DeferredBlock<Block> DARK_OAK_VILLAGER_STATUE = statueRegister("dark_oak_villager_statue","wood");
    public static final DeferredBlock<Block> MANGROVE_VILLAGER_STATUE = statueRegister("mangrove_villager_statue","wood");
    public static final DeferredBlock<Block> CHERRY_VILLAGER_STATUE = statueRegister("cherry_villager_statue","wood","cherry");
    public static final DeferredBlock<Block> BAMBOO_VILLAGER_STATUE = statueRegister("bamboo_villager_statue","wood","bamboo");
    public static final DeferredBlock<Block> CRIMSON_VILLAGER_STATUE = statueRegister("crimson_villager_statue","wood","netherwood");
    public static final DeferredBlock<Block> WARPED_VILLAGER_STATUE = statueRegister("warped_villager_statue","wood","netherwood");
    public static final DeferredBlock<Block> STONE_VILLAGER_STATUE =  statueRegister("stone_villager_statue","stone");
    public static final DeferredBlock<Block> MOSSY_STONE_VILLAGER_STATUE =  statueRegister("mossy_stone_villager_statue","stone");
    public static final DeferredBlock<Block> ANDESITE_VILLAGER_STATUE =  statueRegister("andesite_villager_statue","stone");
    public static final DeferredBlock<Block> DIORITE_VILLAGER_STATUE =  statueRegister("diorite_villager_statue","stone");
    public static final DeferredBlock<Block> GRANITE_VILLAGER_STATUE =  statueRegister("granite_villager_statue","stone");
    public static final DeferredBlock<Block> PRISMARINE_VILLAGER_STATUE =  statueRegister("prismarine_villager_statue","stone");
    public static final DeferredBlock<Block> BLACKSTONE_VILLAGER_STATUE =  statueRegister("blackstone_villager_statue","stone");
    public static final DeferredBlock<Block> PURPUR_BLOCK_VILLAGER_STATUE =  statueRegister("purpur_block_villager_statue","stone");
    public static final DeferredBlock<Block> DEEPSLATE_VILLAGER_STATUE =  statueRegister("deepslate_villager_statue","deepslate");
    public static final DeferredBlock<Block> TUFF_VILLAGER_STATUE =  statueRegister("tuff_villager_statue","tuff");
    public static final DeferredBlock<Block> PACKED_MUD_VILLAGER_STATUE =  statueRegister("packed_mud_villager_statue","mud");
    public static final DeferredBlock<Block> SANDSTONE_VILLAGER_STATUE =  statueRegister("sandstone_villager_statue","sandstone");
    public static final DeferredBlock<Block> RED_SANDSTONE_VILLAGER_STATUE =  statueRegister("red_sandstone_villager_statue","sandstone");
    public static final DeferredBlock<Block> QUARTZ_BLOCK_VILLAGER_STATUE =  statueRegister("quartz_block_villager_statue","sandstone");
    public static final DeferredBlock<Block> NETHER_BRICKS_VILLAGER_STATUE =  statueRegister("nether_bricks_villager_statue","netherbrick");
    public static final DeferredBlock<Block> BASALT_VILLAGER_STATUE =  statueRegister("basalt_villager_statue","basalt");
    public static final DeferredBlock<Block> END_STONE_VILLAGER_STATUE =  statueRegister("end_stone_villager_statue","endstone");
    public static final DeferredBlock<Block> COAL_BLOCK_VILLAGER_STATUE =  statueRegister("coal_block_villager_statue","mineral_strong");
    public static final DeferredBlock<Block> IRON_BLOCK_VILLAGER_STATUE =  statueRegister("iron_block_villager_statue","metal");
    public static final DeferredBlock<Block> GOLD_BLOCK_VILLAGER_STATUE =  statueRegister("gold_block_villager_statue","metal");
    public static final DeferredBlock<Block> REDSTONE_BLOCK_VILLAGER_STATUE =  statueRegister("redstone_block_villager_statue","metal");
    public static final DeferredBlock<Block> EMERALD_BLOCK_VILLAGER_STATUE =  statueRegister("emerald_block_villager_statue","metal");
    public static final DeferredBlock<Block> DIAMOND_BLOCK_VILLAGER_STATUE =  statueRegister("diamond_block_villager_statue","metal");
    public static final DeferredBlock<Block> COPPER_BLOCK_VILLAGER_STATUE =  statueRegister("copper_block_villager_statue","copper");
    public static final DeferredBlock<Block> LAPIS_BLOCK_VILLAGER_STATUE =  statueRegister("lapis_block_villager_statue","mineral_weak");
    public static final DeferredBlock<Block> NETHERITE_BLOCK_VILLAGER_STATUE =  statueRegister("netherite_block_villager_statue","netherite");
    public static final DeferredBlock<Block> OBSIDIAN_VILLAGER_STATUE =  statueRegister("obsidian_villager_statue","obsidan");
    public static final DeferredBlock<Block> AMETHYST_BLOCK_VILLAGER_STATUE =  statueRegister("amethyst_block_villager_statue","amethyst");
    public static final DeferredBlock<Block> DRIPSTONE_BLOCK_VILLAGER_STATUE =  statueRegister("dripstone_block_villager_statue","dripstone");
    public static final DeferredBlock<Block> BEDROCK_VILLAGER_STATUE =  statueRegister("bedrock_villager_statue","bedrock");
        //pedestal zone (41)
    public static final DeferredBlock<Block> OAK_PEDESTAL = pedestalRegister("oak_pedestal","wood");
    public static final DeferredBlock<Block> BIRCH_PEDESTAL = pedestalRegister("birch_pedestal","wood");
    public static final DeferredBlock<Block> SPRUCE_PEDESTAL = pedestalRegister("spruce_pedestal","wood");
    public static final DeferredBlock<Block> JUNGLE_PEDESTAL = pedestalRegister("jungle_pedestal","wood");
    public static final DeferredBlock<Block> ACACIA_PEDESTAL = pedestalRegister("acacia_pedestal","wood");
    public static final DeferredBlock<Block> DARK_OAK_PEDESTAL = pedestalRegister("dark_oak_pedestal","wood");
    public static final DeferredBlock<Block> MANGROVE_PEDESTAL = pedestalRegister("mangrove_pedestal","wood");
    public static final DeferredBlock<Block> CHERRY_PEDESTAL = pedestalRegister("cherry_pedestal","wood","cherry");
    public static final DeferredBlock<Block> BAMBOO_PEDESTAL = pedestalRegister("bamboo_pedestal","wood","bamboo");
    public static final DeferredBlock<Block> CRIMSON_PEDESTAL = pedestalRegister("crimson_pedestal","wood","netherwood");
    public static final DeferredBlock<Block> WARPED_PEDESTAL = pedestalRegister("warped_pedestal","wood","netherwood");
    public static final DeferredBlock<Block> STONE_PEDESTAL =  pedestalRegister("stone_pedestal","stone");
    public static final DeferredBlock<Block> MOSSY_STONE_PEDESTAL =  pedestalRegister("mossy_stone_pedestal","stone");
    public static final DeferredBlock<Block> ANDESITE_PEDESTAL =  pedestalRegister("andesite_pedestal","stone");
    public static final DeferredBlock<Block> DIORITE_PEDESTAL =  pedestalRegister("diorite_pedestal","stone");
    public static final DeferredBlock<Block> GRANITE_PEDESTAL =  pedestalRegister("granite_pedestal","stone");
    public static final DeferredBlock<Block> PRISMARINE_PEDESTAL =  pedestalRegister("prismarine_pedestal","stone");
    public static final DeferredBlock<Block> BLACKSTONE_PEDESTAL =  pedestalRegister("blackstone_pedestal","stone");
    public static final DeferredBlock<Block> PURPUR_BLOCK_PEDESTAL =  pedestalRegister("purpur_block_pedestal","stone");
    public static final DeferredBlock<Block> DEEPSLATE_PEDESTAL =  pedestalRegister("deepslate_pedestal","deepslate");
    public static final DeferredBlock<Block> TUFF_PEDESTAL =  pedestalRegister("tuff_pedestal","tuff");
    public static final DeferredBlock<Block> PACKED_MUD_PEDESTAL =  pedestalRegister("packed_mud_pedestal","mud");
    public static final DeferredBlock<Block> SANDSTONE_PEDESTAL =  pedestalRegister("sandstone_pedestal","sandstone");
    public static final DeferredBlock<Block> RED_SANDSTONE_PEDESTAL =  pedestalRegister("red_sandstone_pedestal","sandstone");
    public static final DeferredBlock<Block> QUARTZ_BLOCK_PEDESTAL =  pedestalRegister("quartz_block_pedestal","sandstone");
    public static final DeferredBlock<Block> NETHER_BRICKS_PEDESTAL =  pedestalRegister("nether_bricks_pedestal","netherbrick");
    public static final DeferredBlock<Block> BASALT_PEDESTAL =  pedestalRegister("basalt_pedestal","basalt");
    public static final DeferredBlock<Block> END_STONE_PEDESTAL =  pedestalRegister("end_stone_pedestal","endstone");
    public static final DeferredBlock<Block> COAL_BLOCK_PEDESTAL =  pedestalRegister("coal_block_pedestal","mineral_strong");
    public static final DeferredBlock<Block> IRON_BLOCK_PEDESTAL =  pedestalRegister("iron_block_pedestal","metal");
    public static final DeferredBlock<Block> GOLD_BLOCK_PEDESTAL =  pedestalRegister("gold_block_pedestal","metal");
    public static final DeferredBlock<Block> REDSTONE_BLOCK_PEDESTAL =  pedestalRegister("redstone_block_pedestal","metal");
    public static final DeferredBlock<Block> EMERALD_BLOCK_PEDESTAL =  pedestalRegister("emerald_block_pedestal","metal");
    public static final DeferredBlock<Block> DIAMOND_BLOCK_PEDESTAL =  pedestalRegister("diamond_block_pedestal","metal");
    public static final DeferredBlock<Block> COPPER_BLOCK_PEDESTAL =  pedestalRegister("copper_block_pedestal","copper");
    public static final DeferredBlock<Block> LAPIS_BLOCK_PEDESTAL =  pedestalRegister("lapis_block_pedestal","mineral_weak");
    public static final DeferredBlock<Block> NETHERITE_BLOCK_PEDESTAL =  pedestalRegister("netherite_block_pedestal","netherite");
    public static final DeferredBlock<Block> OBSIDIAN_PEDESTAL =  pedestalRegister("obsidian_pedestal","obsidan");
    public static final DeferredBlock<Block> AMETHYST_BLOCK_PEDESTAL =  pedestalRegister("amethyst_block_pedestal","amethyst");
    public static final DeferredBlock<Block> DRIPSTONE_BLOCK_PEDESTAL =  pedestalRegister("dripstone_block_pedestal","dripstone");
    public static final DeferredBlock<Block> BEDROCK_PEDESTAL =  pedestalRegister("bedrock_pedestal","bedrock");
        //brazier

    //create the block with a name and the factory (factory include properties)
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
    {
        DeferredBlock<T> madeBlock = BLOCKS.register(name, block);
        registerBlockItem(name, madeBlock);
        return madeBlock;
    }

    //create the item block of the block
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
        ItemRegister.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    private static  <T extends Block> DeferredBlock<T> statueRegister(String name, String familie, String type)
    {
        switch (familie)
        {
            case "wood":
                return (DeferredBlock<T>) statueRegister(name, type);
            default:
                return (DeferredBlock<T>) statueRegister(name, "default");
        }
    }
    private static  <T extends Block> DeferredBlock<T> statueRegister(String name, String type)
    {
        switch (type) {
            case "stone":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
            }
            case "cobblestone":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).noOcclusion()));
            }
            case "deepslate":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE).noOcclusion()));
            }
            case "tuff":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF).noOcclusion()));
            }
            case "mud":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD).noOcclusion()));
            }
            case "sandstone":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).noOcclusion()));
            }
            case "netherbrick":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS).noOcclusion()));
            }
            case "mineral_weak":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK).noOcclusion()));
            }
            case "mineral_strong":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).noOcclusion()));
            }
            case "metal":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
            }
            case "copper":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).noOcclusion()));
            }
            case "basalt":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT).noOcclusion()));
            }
            case "endstone":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).noOcclusion()));
            }
            case "obsidan":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).noOcclusion()));
            }
            case "netherite":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).noOcclusion()));
            }
            case "amethyst":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).noOcclusion()));
            }
            case "dripstone":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK).noOcclusion()));
            }
            case "bedrock":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK).noOcclusion()));
            }
            case "netherwood":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
            }
            case "cherry":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
            }
            case "bamboo":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
            }
            default:
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
            }
        }
    }
    private static  <T extends Block> DeferredBlock<T> pedestalRegister(String name, String familie, String type)
    {
        switch (familie)
        {
            case "wood":
                return (DeferredBlock<T>) pedestalRegister(name, type);
            default:
                return (DeferredBlock<T>) pedestalRegister(name, "default");
        }
    }
    private static <T extends Block> DeferredBlock<T> pedestalRegister(String name, String type)
    {
        switch (type) {
            case "stone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
            }
            case "cobblestone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).noOcclusion()));
            }
            case "deepslate": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE).noOcclusion()));
            }
            case "tuff": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF).noOcclusion()));
            }
            case "mud": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD).noOcclusion()));
            }
            case "sandstone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).noOcclusion()));
            }
            case "netherbrick": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS).noOcclusion()));
            }
            case "mineral_weak": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK).noOcclusion()));
            }
            case "mineral_strong": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).noOcclusion()));
            }
            case "metal": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
            }
            case "copper": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).noOcclusion()));
            }
            case "basalt": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT).noOcclusion()));
            }
            case "endstone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).noOcclusion()));
            }
            case "obsidan": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).noOcclusion()));
            }
            case "netherite": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).noOcclusion()));
            }
            case "amethyst": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).noOcclusion()));
            }
            case "dripstone": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK).noOcclusion()));
            }
            case "bedrock": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK).noOcclusion()));
            }
            case "netherwood": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
            }
            case "cherry": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
            }
            case "bamboo": {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
            }
            default: {
                return (DeferredBlock<T>) registerBlock(name, () -> new PedestalBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
            }
        }
    }

    public static void register(IEventBus modEventBus)
    {
        BLOCKS.register(modEventBus);
    }
}
