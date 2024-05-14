package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.world.block.VillagerStatue;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockRegister
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PremierPainMod.MODID);

    //staute zone
    public static final DeferredBlock<Block> OAK_VILLAGER_STATUE = statueRegister("oak_villager_statue","wood");
    public static final DeferredBlock<Block> BIRCH_VILLAGER_STATUE = statueRegister("birch_villager_statue","wood");
    public static final DeferredBlock<Block> SPRUCE_VILLAGER_STATUE = statueRegister("spruce_villager_statue","wood");
    public static final DeferredBlock<Block> JUNGLE_VILLAGER_STATUE = statueRegister("jungle_villager_statue","wood");
    public static final DeferredBlock<Block> ACACIA_VILLAGER_STATUE = statueRegister("acacia_villager_statue","wood");
    public static final DeferredBlock<Block> DARK_OAK_VILLAGER_STATUE = statueRegister("dark_oak_villager_statue","wood");
    public static final DeferredBlock<Block> MANGROVE_VILLAGER_STATUE = statueRegister("mangrove_villager_statue","wood");
    public static final DeferredBlock<Block> CHERRY_VILLAGER_STATUE = statueRegister("cherry_villager_statue","wood");
    public static final DeferredBlock<Block> CRIMSON_VILLAGER_STATUE = statueRegister("crimson_villager_statue","wood");
    public static final DeferredBlock<Block> WARPED_VILLAGER_STATUE = statueRegister("warped_villager_statue","wood");
    public static final DeferredBlock<Block> BAMBOO_VILLAGER_STATUE = statueRegister("bamboo_villager_statue","wood");

    public static final DeferredBlock<Block> STONE_VILLAGER_STATUE =  statueRegister("stone_villager_statue","stone");
    public static final DeferredBlock<Block> ANDESITE_VILLAGER_STATUE =  statueRegister("andesite_villager_statue","stone");
    public static final DeferredBlock<Block> DIORITE_VILLAGER_STATUE =  statueRegister("diorite_villager_statue","stone");
    public static final DeferredBlock<Block> GRANITE_VILLAGER_STATUE =  statueRegister("granite_villager_statue","stone");
    public static final DeferredBlock<Block> PRISMARINE_VILLAGER_STATUE =  statueRegister("prismarine_villager_statue","stone");
    public static final DeferredBlock<Block> BLACKSTONE_VILLAGER_STATUE =  statueRegister("blackstone_villager_statue","stone");
    public static final DeferredBlock<Block> PURPUR_BLOCK_VILLAGER_STATUE =  statueRegister("purpur_block_villager_statue","stone");

    public static final DeferredBlock<Block> COBBLESTONE_VILLAGER_STATUE =  statueRegister("cobblestone_villager_statue","cobblestone");
    public static final DeferredBlock<Block> MOSSY_COBBLESTONE_VILLAGER_STATUE =  statueRegister("mossy_cobblestone_villager_statue","cobblestone");
    public static final DeferredBlock<Block> SMOOTH_STONE_VILLAGER_STATUE =  statueRegister("smooth_stone_villager_statue","cobblestone");

    public static final DeferredBlock<Block> COBBLED_DEEPSLATE_VILLAGER_STATUE =  statueRegister("cobbled_deepslate_villager_statue","deepslate");

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
    public static final DeferredBlock<Block> OBSIDIAN_BLOCK_VILLAGER_STATUE =  statueRegister("obsidian_block_villager_statue","netherite");

    public static final DeferredBlock<Block> AMETHYST_BLOCK_VILLAGER_STATUE =  statueRegister("amethyst_block_villager_statue","amethyst");

    public static final DeferredBlock<Block> DRIPSTONE_BLOCK_VILLAGER_STATUE =  statueRegister("dripstone_block_villager_statue","dripstone");

    public static final DeferredBlock<Block> BEDROCK_VILLAGER_STATUE =  statueRegister("bedrock_block_villager_statue","bedrock");
    //
    //end


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

    private static  <T extends Block> DeferredBlock<T> statueRegister(String name, String type)
    {
        switch (type) {
            case "stone":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.of().sound(SoundType.STONE).noOcclusion().strength(1.5f,6.0f).requiresCorrectToolForDrops()));
            }
            case "cobblestone":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.of().sound(SoundType.STONE).noOcclusion().strength(2.0f,6.0f).requiresCorrectToolForDrops()));
            }
            case "deepslate":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE).noOcclusion().strength(3.5f,6.0f).requiresCorrectToolForDrops()));
            }
            case "tuff":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.of().sound(SoundType.TUFF).noOcclusion().strength(1.5f,6.0f).requiresCorrectToolForDrops()));
            }
            case "mud":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.of().sound(SoundType.MUD).noOcclusion().strength(1.0f,3.0f)));
            }
            case "sandstone":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.of().noOcclusion().strength(0.8f).requiresCorrectToolForDrops()));
            }
            case "netherbrick":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.of().sound(SoundType.NETHER_BRICKS).noOcclusion().strength(2.0f,6.0f).requiresCorrectToolForDrops()));
            }
            case "mineral_weak":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.of().noOcclusion().strength(3.0f).requiresCorrectToolForDrops()));
            }
            case "mineral_strong":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.of().noOcclusion().strength(5.0f,6.0f).requiresCorrectToolForDrops()));
            }
            case "metal":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.of().sound(SoundType.METAL).noOcclusion().strength(5.0f,6.0f).requiresCorrectToolForDrops()));
            }
            case "copper":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.of().sound(SoundType.COPPER).noOcclusion().strength(5.0f,6.0f).requiresCorrectToolForDrops()));
            }
            case "basalt":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.of().sound(SoundType.BASALT).noOcclusion().strength(1.25f,4.2f).requiresCorrectToolForDrops()));
            }
            case "endstone":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.of().noOcclusion().strength(3.0f,9.0f).requiresCorrectToolForDrops()));
            }
            case "netherite":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.of().sound(SoundType.NETHERITE_BLOCK).noOcclusion().strength(50.0f,1200.0f).requiresCorrectToolForDrops()));
            }
            case "amethyst":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.of().sound(SoundType.AMETHYST).noOcclusion().strength(1.5f).requiresCorrectToolForDrops()));
            }
            case "dripstone":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.of().sound(SoundType.DRIPSTONE_BLOCK).noOcclusion().strength(1.5f, 1.0f).requiresCorrectToolForDrops()));
            }
            case "bedrock":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.of().noOcclusion().strength(-1.0f, 3600000.0f).noLootTable()));
            }
            default:
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.of().sound(SoundType.WOOD).noOcclusion().strength(2.0f,3.0f)));
            }
        }
    }

    public static void register(IEventBus modEventBus)
    {
        BLOCKS.register(modEventBus);
    }
}
