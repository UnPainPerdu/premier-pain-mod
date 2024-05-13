package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.world.block.VillagerStatue;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockRegister
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PremierPainMod.MODID);

    public static final DeferredBlock<Block> OAK_VILLAGER_STATUE = statueRegister("oak_villager_statue","wood");
    public static final DeferredBlock<Block> BIRCH_VILLAGER_STATUE = statueRegister("birch_villager_statue","wood");
    public static final DeferredBlock<Block> STONE_VILLAGER_STATUE =  statueRegister("stone_villager_statue","stone");

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
            case "metal":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerStatue(BlockBehaviour.Properties.of().sound(SoundType.METAL).noOcclusion().strength(5.0f,6.0f).requiresCorrectToolForDrops()));
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
