package com.unpainperdu.premierpainmod.datagen.data.tag;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.datagen.data.tag.mod_tags.ModBlockTags;
import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractCropLikeBlock;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width.VillagerWorkshop;
import com.unpainperdu.premierpainmod.level.world.block.tree.*;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.growing_above_vegetation.AbstractGrowingAboveVegetation;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.special_vegetation.CactusFloweredBlock.CactusFlowerBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.two_block_height.sky_spears.SkySpearsFlower;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.mod_list.ModBLockList;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
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
        //villager workshop
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(BlockRegister.VILLAGER_WORKSHOP.get());

        for(Block block : ModBLockList.getAllMaterialsBlocks())
        {
            String blockName = BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MOD_ID + ":", "");
            addTagForAllMaterialsBlock(block, blockName);
        }

        //potted thing
        for (Block block : ModBLockList.getAllBlocksFromClass(FlowerPotBlock.class))
        {
            this.tag(BlockTags.FLOWER_POTS).add(block);
        }

        //leaves
        for (Block block : ModBLockList.getAllBlocksFromClass(ModLeavesBlock.class))
        {
            this.tag(BlockTags.LEAVES).add(block);
            this.tag(BlockTags.REPLACEABLE_BY_TREES).add(block);
            this.tag(BlockTags.MINEABLE_WITH_HOE).add(block);
            this.tag(BlockTags.SWORD_EFFICIENT).add(block);
            this.tag(BlockTags.COMPLETES_FIND_TREE_TUTORIAL).add(block);
            this.tag(BlockTags.LAVA_POOL_STONE_CANNOT_REPLACE).add(block);
            this.tag(BlockTags.PARROTS_SPAWNABLE_ON).add(block);
        }

        //logs
        for (Block block : ModBLockList.getAllBlocksFromClass(LogBlock.class))
        {
            String blockName = getName(block);
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
            else
            {
                if (blockName.contains("log"))
                {
                    this.tag(Tags.Blocks.STRIPPED_LOGS).add(block);
                }
                else if (blockName.contains("wood"))
                {
                    this.tag(Tags.Blocks.STRIPPED_WOODS).add(block);
                }

            }
            if (blockName.contains("mountain_currant"))
            {
                tag(ModBlockTags.MOUNTAIN_CURRANT_LOGS).add(block);
            }
            if (blockName.contains("moriche_palm"))
            {
                tag(ModBlockTags.MORICHE_PALM_LOGS).add(block);
            }
            if (blockName.contains("achiote"))
            {
                tag(ModBlockTags.ACHIOTE_LOGS).add(block);
            }
        }

        //planks
        for (Block block : ModBLockList.getAllBlocksFromClass(FlammableBlock.class))
        {
            String blockName = getName(block);
            if (blockName.contains("planks"))
            {
                this.tag(BlockTags.PLANKS).add(block);
                this.tag(BlockTags.MINEABLE_WITH_AXE).add(block);
            }
        }

        //mountain currant crafted thing
        for (Block block : ModBLockList.getAllBlocksFromClass(
                StairBlock.class,
                SlabBlock.class,
                ButtonBlock.class,
                PressurePlateBlock.class,
                FenceBlock.class,
                FenceGateBlock.class,
                DoorBlock.class,
                TrapDoorBlock.class,
                SignBlock.class
        ))
        {
            String blockName = getName(block);
            if (blockName.contains("mountain_currant")
                || blockName.contains("moriche_palm")
                || blockName.contains("achiote")
            )
            {
                this.tag(BlockTags.MINEABLE_WITH_AXE).add(block);
                switch (block)
                {
                    case StairBlock stairBlock ->
                    {
                        this.tag(BlockTags.STAIRS).add(block);
                        this.tag(BlockTags.WOODEN_STAIRS).add(block);
                    }
                    case SlabBlock slabBlock ->
                    {
                        this.tag(BlockTags.SLABS).add(block);
                        this.tag(BlockTags.WOODEN_SLABS).add(block);
                    }
                    case ButtonBlock buttonBlock ->
                    {
                        this.tag(BlockTags.BUTTONS).add(block);
                        this.tag(BlockTags.WOODEN_BUTTONS).add(block);
                    }
                    case PressurePlateBlock pressurePlateBlock ->
                    {
                        this.tag(BlockTags.PRESSURE_PLATES).add(block);
                        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(block);
                        this.tag(BlockTags.WALL_POST_OVERRIDE).add(block);
                    }
                    case FenceBlock fenceBlock ->
                    {
                        this.tag(BlockTags.FENCES).add(block);
                        this.tag(BlockTags.WOODEN_FENCES).add(block);
                        this.tag(Tags.Blocks.FENCES).add(block);
                        this.tag(Tags.Blocks.FENCES_WOODEN).add(block);
                    }
                    case FenceGateBlock fenceGateBlock ->
                    {
                        this.tag(BlockTags.FENCE_GATES).add(block);
                        this.tag(BlockTags.UNSTABLE_BOTTOM_CENTER).add(block);
                        this.tag(Tags.Blocks.FENCE_GATES).add(block);
                        this.tag(Tags.Blocks.FENCE_GATES_WOODEN).add(block);
                    }
                    case DoorBlock doorBlock ->
                    {
                        this.tag(BlockTags.WOODEN_DOORS).add(block);
                        this.tag(BlockTags.DOORS).add(block);
                        this.tag(BlockTags.MOB_INTERACTABLE_DOORS).add(block);
                    }
                    case TrapDoorBlock trapDoorBlock ->
                    {
                        this.tag(BlockTags.WOODEN_TRAPDOORS).add(block);
                        this.tag(BlockTags.TRAPDOORS).add(block);
                    }
                    case SignBlock signBlock ->
                    {
                        this.tag(BlockTags.ALL_SIGNS).add(block);
                        switch (block)
                        {
                            case ModStandingSignBlock modStandingSignBlock ->
                            {
                                this.tag(BlockTags.STANDING_SIGNS).add(block);
                                this.tag(BlockTags.SIGNS).add(block);
                            }
                            case ModWallSignBlock modWallSignBlock ->
                            {
                                this.tag(BlockTags.WALL_SIGNS).add(block);
                                this.tag(BlockTags.SIGNS).add(block);
                            }
                            case ModHangingSignBlock modHangingSignBlock ->
                            {
                                this.tag(BlockTags.ALL_HANGING_SIGNS).add(block);
                                this.tag(BlockTags.CEILING_HANGING_SIGNS).add(block);
                            }
                            case ModWallHangingSignBlock modWallHangingSignBlock ->
                            {
                                this.tag(BlockTags.ALL_HANGING_SIGNS).add(block);
                                this.tag(BlockTags.WALL_HANGING_SIGNS).add(block);
                            }
                            default -> {}
                        }
                    }
                    default -> {}
                }
            }
        }

        //sapling
        for (Block block : ModBLockList.getAllBlocksFromClass(SaplingBlock.class))
        {
            this.tag(BlockTags.SAPLINGS).add(block);
            this.tag(BlockTags.MINEABLE_WITH_AXE).add(block);
            this.tag(BlockTags.SWORD_EFFICIENT).add(block);
        }

        //crop
        for (Block block : ModBLockList.getAllBlocksFromClass(AbstractCropLikeBlock.class))
        {
            this.tag(BlockTags.CROPS).add(block);
            this.tag(BlockTags.SWORD_EFFICIENT).add(block);
            this.tag(BlockTags.MINEABLE_WITH_AXE).add(block);
        }

        //flower
        for (Block block : ModBLockList.getAllBlocksFromClass(
                FlowerBlock.class,
                AbstractGrowingAboveVegetation.class,
                CactusFlowerBlock.class,
                SkySpearsFlower.class
        ))
        {
            this.tag(BlockTags.FLOWERS).add(block);
        }
            //tall flower
        for (Block block : ModBLockList.getAllBlocksFromClass(TallFlowerBlock.class))
        {
            this.tag(BlockTags.SWORD_EFFICIENT).add(block);
            this.tag(BlockTags.REPLACEABLE_BY_TREES).add(block);
            this.tag(BlockTags.FLOWERS).add(block);
            this.tag(BlockTags.TALL_FLOWERS).add(block);
        }

        //stealable by enderman
        for (Block block : ModBLockList.getAllBlocksFromClass(
                FlowerBlock.class,
                CactusFlowerBlock.class,
                SkySpearsFlower.class
        ))
        {
            this.tag(BlockTags.ENDERMAN_HOLDABLE).add(block);
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
                || (blockName.contains("moriche_palm"))
        )
        {
            this.tag(BlockTags.MINEABLE_WITH_AXE).add(block);
        }
    }

    private String getName(Block block)
    {
        return BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MOD_ID + ":", "");
    }
}
