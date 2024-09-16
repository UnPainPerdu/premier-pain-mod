package com.unpainperdu.premierpainmod.util.register.creativeTab;

import com.unpainperdu.premierpainmod.level.world.block.abstractBlock.AbstractTallGrass;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.AdaptableSit.VillagerBench;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerPedestalBlock;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerTableBlock;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockHeight.VillagerBrazier;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockHeight.VillagerStatue;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockHeight.VillagerThroneChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockWidthWithBlockEntity.VillagerDrawer;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.growingAboveVegetation.AbstractGrowingAboveVegetation;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.CactusFlowerBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.FloweredCactusBlock;
import com.unpainperdu.premierpainmod.level.world.item.items.VillagerSingingStone;
import com.unpainperdu.premierpainmod.level.world.item.items.allMaterialsBlock.VillagerShelfItem;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.ModList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class CreativeMainTab
{
    public static void generateCreativeMainTab(CreativeModeTab.ItemDisplayParameters param, CreativeModeTab.Output output)
    {
        //Items
        generateMiscItems(output);
        //vegetation
        generateVegetation(output);
        //all materials
        output.accept(BlockRegister.VILLAGER_WORKSHOP.get());
        generateAllMaterials(output);

    }

    private static void generateVegetation(CreativeModeTab.Output output)
    {
        for(DeferredBlock<Block> deferredBlock : ModList.ALL_BLOCKS)
        {
            Block block = deferredBlock.get();
            if(block instanceof AbstractTallGrass
                    || block instanceof CactusFlowerBlock
                    || block instanceof FloweredCactusBlock
                    || block instanceof AbstractGrowingAboveVegetation
                    || block instanceof FlowerBlock
            )
            {
                output.accept(block);
            }
        }
    }

    private static void generateAllMaterials(CreativeModeTab.Output output)
    {
        for(DeferredBlock<Block> deferredBlock : ModList.ALL_BLOCKS)
        {
            Block block = deferredBlock.get();
            if(block instanceof VillagerStatue
                    || block instanceof VillagerPedestalBlock
                    || block instanceof VillagerBrazier
                    || block instanceof VillagerTableBlock
                    || block instanceof VillagerChairBlock
                    || block instanceof VillagerThroneChairBlock
                    || block instanceof VillagerDrawer
                    || block instanceof VillagerBench
            )
            {
                output.accept(block);
            }
        }
        for(DeferredItem<Item> deferredItem : ModList.ALL_ITEMS)
        {
            Item item = deferredItem.get();
            if (item instanceof VillagerShelfItem)
            {
                output.accept(item);
            }
        }
    }

    private static void generateMiscItems(CreativeModeTab.Output output)
    {
        for(DeferredItem<Item> deferredItem : ModList.ALL_ITEMS)
        {
            Item item = deferredItem.get();
            if(item instanceof VillagerSingingStone)
            {
                output.accept(item);
            }
        }
    }
}
