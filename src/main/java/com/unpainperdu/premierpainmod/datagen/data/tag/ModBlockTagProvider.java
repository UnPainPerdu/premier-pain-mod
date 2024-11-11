package com.unpainperdu.premierpainmod.datagen.data.tag;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.datagen.data.tag.mod_tags.ModBlockTags;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockWidth.VillagerWorkshop;
import com.unpainperdu.premierpainmod.level.world.block.tree.*;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.growingAboveVegetation.AbstractGrowingAboveVegetation;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.CactusFlowerBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.twoBlockHeight.skySpears.SkySpearsFlower;
import com.unpainperdu.premierpainmod.util.register.ModList;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider
{
    public ModBlockTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper)
    {
        super(packOutput, lookupProvider, PremierPainMod.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider)
    {
        for(Block block : ModList.getAllMaterialsBlocks())
        {
            String blockName = BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MOD_ID + ":", "");
            addTagForAllMaterialsBlock(block, blockName);
        }
        for (DeferredBlock<Block> deferredblock : ModList.ALL_BLOCKS)
        {
            Block block = deferredblock.get();
            String blockName = BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MOD_ID + ":", "");

            //for all leaves
            if (block instanceof ModLeavesBlock)
            {
                this.tag(BlockTags.LEAVES).add(block);
                this.tag(BlockTags.REPLACEABLE_BY_TREES).add(block);
                this.tag(BlockTags.MINEABLE_WITH_HOE).add(block);
                this.tag(BlockTags.SWORD_EFFICIENT).add(block);
                this.tag(BlockTags.COMPLETES_FIND_TREE_TUTORIAL).add(block);
                this.tag(BlockTags.LAVA_POOL_STONE_CANNOT_REPLACE).add(block);
                this.tag(BlockTags.PARROTS_SPAWNABLE_ON).add(block);
            }
            //for all log
            if (block instanceof LogBlock)
            {
                this.tag(BlockTags.LOGS).add(block);
                this.tag(BlockTags.MINEABLE_WITH_AXE).add(block);
                this.tag(BlockTags.LOGS_THAT_BURN).add(block);
                this.tag(BlockTags.SNAPS_GOAT_HORN).add(block);
                this.tag(BlockTags.COMPLETES_FIND_TREE_TUTORIAL).add(block);
                this.tag(BlockTags.LAVA_POOL_STONE_CANNOT_REPLACE).add(block);
                this.tag(BlockTags.PARROTS_SPAWNABLE_ON).add(block);
                if (!blockName.contains("stripped"))
                {
                    this.tag(BlockTags.OVERWORLD_NATURAL_LOGS).add(block);
                }
                if (blockName.contains("mountain_currant"))
                {
                    tag(ModBlockTags.MOUNTAIN_CURRANT_LOGS).add(block);
                }
            }
            //for all planks
            if (block instanceof FlammableBlock)
            {
                if (blockName.contains("planks"))
                {
                    this.tag(BlockTags.PLANKS).add(block);
                    this.tag(BlockTags.MINEABLE_WITH_AXE).add(block);
                }
            }
            if (blockName.contains("mountain_currant"))
            {
                this.tag(BlockTags.MINEABLE_WITH_AXE).add(block);
                if (block instanceof StairBlock)
                {
                    this.tag(BlockTags.STAIRS).add(block);
                    this.tag(BlockTags.WOODEN_STAIRS).add(block);
                }
                else if (block instanceof SlabBlock)
                {
                    this.tag(BlockTags.SLABS).add(block);
                    this.tag(BlockTags.WOODEN_SLABS).add(block);
                }
                else if (block instanceof ButtonBlock)
                {
                    this.tag(BlockTags.BUTTONS).add(block);
                    this.tag(BlockTags.WOODEN_BUTTONS).add(block);
                }
                else if (block instanceof PressurePlateBlock)
                {
                    this.tag(BlockTags.PRESSURE_PLATES).add(block);
                    this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(block);
                    this.tag(BlockTags.WALL_POST_OVERRIDE).add(block);
                }
                else if (block instanceof FenceBlock)
                {
                    this.tag(BlockTags.FENCES).add(block);
                    this.tag(BlockTags.WOODEN_FENCES).add(block);
                    this.tag(Tags.Blocks.FENCES).add(block);
                    this.tag(Tags.Blocks.FENCES_WOODEN).add(block);
                }
                else if (block instanceof FenceGateBlock)
                {
                    this.tag(BlockTags.FENCE_GATES).add(block);
                    this.tag(BlockTags.UNSTABLE_BOTTOM_CENTER).add(block);
                    this.tag(Tags.Blocks.FENCE_GATES).add(block);
                    this.tag(Tags.Blocks.FENCE_GATES_WOODEN).add(block);
                }
                else if (block instanceof DoorBlock)
                {
                    this.tag(BlockTags.WOODEN_DOORS).add(block);
                    this.tag(BlockTags.DOORS).add(block);
                    this.tag(BlockTags.MOB_INTERACTABLE_DOORS).add(block);
                }
                else if (block instanceof TrapDoorBlock)
                {
                    this.tag(BlockTags.WOODEN_TRAPDOORS).add(block);
                    this.tag(BlockTags.TRAPDOORS).add(block);
                }
                else if (block instanceof SignBlock)
                {
                    this.tag(BlockTags.ALL_SIGNS).add(block);
                    if (block instanceof ModStandingSignBlock)
                    {
                        this.tag(BlockTags.STANDING_SIGNS).add(block);
                        this.tag(BlockTags.SIGNS).add(block);
                    }
                    else if (block instanceof ModWallSignBlock)
                    {
                        this.tag(BlockTags.WALL_SIGNS).add(block);
                        this.tag(BlockTags.SIGNS).add(block);
                    }
                    else if (block instanceof ModHangingSignBlock)
                    {
                        this.tag(BlockTags.ALL_HANGING_SIGNS).add(block);
                        this.tag(BlockTags.CEILING_HANGING_SIGNS).add(block);
                    }
                    else if (block instanceof ModWallHangingSignBlock)
                    {
                        this.tag(BlockTags.ALL_HANGING_SIGNS).add(block);
                        this.tag(BlockTags.WALL_HANGING_SIGNS).add(block);
                    }
                }
            }
            //wood slab
            //flower
            if (block instanceof FlowerBlock
                    || block instanceof AbstractGrowingAboveVegetation
                    || block instanceof CactusFlowerBlock
                    || block instanceof SkySpearsFlower
            )
            {
                this.tag(BlockTags.FLOWERS).add(block);
            }
            //stealable by enderman
            if (block instanceof FlowerBlock
                    || block instanceof CactusFlowerBlock
                    || block instanceof SkySpearsFlower
            )
            {
                this.tag(BlockTags.ENDERMAN_HOLDABLE).add(block);
            }
        }
    }

    private void addTagForAllMaterialsBlock(Block block, String blockName)
    {
        //mineable with pickaxe
        if ((block instanceof VillagerWorkshop)
                || (blockName.contains("red_sandstone"))
                || (blockName.contains("sandstone"))
                || (blockName.contains("mossy_stone"))
                || (blockName.contains("end_stone"))
                || (blockName.contains("blackstone"))
                || (blockName.contains("redstone"))
                || (blockName.contains("dripstone"))
                || (blockName.contains("stone"))
                || (blockName.contains("andesite"))
                || (blockName.contains("diorite"))
                || (blockName.contains("granite"))
                || (blockName.contains("prismarine"))
                || (blockName.contains("purpur"))
                || (blockName.contains("deepslate"))
                || (blockName.contains("tuff"))
                || (blockName.contains("packed_mud"))
                || (blockName.contains("quartz"))
                || (blockName.contains("nether_bricks"))
                || (blockName.contains("basalt"))
                || (blockName.contains("coal"))
                || (blockName.contains("iron"))
                || (blockName.contains("gold"))
                || (blockName.contains("emerald"))
                || (blockName.contains("diamond"))
                || (blockName.contains("copper"))
                || (blockName.contains("lapis"))
                || (blockName.contains("netherite"))
                || (blockName.contains("obsidian"))
                || (blockName.contains("amethyst"))
        )
        {
            this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            //need stone tool
            if ((blockName.contains("iron"))
                    || (blockName.contains("lapis"))
                    || (blockName.contains("copper"))
            )
            {
                this.tag(BlockTags.NEEDS_STONE_TOOL).add(block);
            }
            //need iron tool
            else if ((blockName.contains("gold"))
                    || (blockName.contains("emerald"))
                    || (blockName.contains("diamond"))
            )
            {
                this.tag(BlockTags.NEEDS_IRON_TOOL).add(block);
            }
            //need diamond tool
            else if ((blockName.contains("netherite"))
                    || (blockName.contains("obsidian"))
            )
            {
                this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(block);
            }
        }
        //mineable with axe
        else if ((blockName.contains("dark_oak"))
                || (blockName.contains("oak"))
                || (blockName.contains("birch"))
                || (blockName.contains("spruce"))
                || (blockName.contains("jungle"))
                || (blockName.contains("acacia"))
                || (blockName.contains("mangrove"))
                || (blockName.contains("cherry"))
                || (blockName.contains("crimson"))
                || (blockName.contains("warped"))
                || (blockName.contains("bamboo"))
                || (blockName.contains("mountain_currant"))
        )
        {
            this.tag(BlockTags.MINEABLE_WITH_AXE).add(block);
        }
    }
}
