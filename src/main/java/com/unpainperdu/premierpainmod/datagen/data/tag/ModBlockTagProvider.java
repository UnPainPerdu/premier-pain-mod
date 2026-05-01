package com.unpainperdu.premierpainmod.datagen.data.tag;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.datagen.data.tag.mod_tags.ModBlockTags;
import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractCropLikeBlock;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.VillagerBrewingStation;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.VillagerChiseledHead;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.VillagerPedestalBlock;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.VillagerTableBlock;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.sit.VillagerChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.sit.VillagerDryToiletBlock;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.sit.VillagerThroneChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.sit.adaptable.VillagerBench;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.sit.adaptable.VillagerCouch;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height.VillagerBrazier;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height.VillagerStatue;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height_with_block_entity.VillagerMusicalFridgeBlock;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.VillagerDrawer;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.villager_shelf.VillagerShelf;
import com.unpainperdu.premierpainmod.level.world.block.tree.*;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.growing_above_vegetation.AbstractGrowingAboveVegetation;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.special_vegetation.CactusFloweredBlock.CactusFlowerBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.two_block_height.sky_spears.SkySpearsFlower;
import com.unpainperdu.premierpainmod.util.mod_list.ModBLockList;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import static com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil.getModName;

public class ModBlockTagProvider extends BlockTagsProvider
{
    public ModBlockTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(packOutput, lookupProvider, PremierPainMod.MOD_ID);
    }

    // only one this.tag(...) per tags
    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider)
    {
        //block mined behavor
        this.addToTag(
                BlockTags.NEEDS_STONE_TOOL,
                ModBLockList.getAllMaterialsBlocks().stream().filter(
                        b -> (getModName(b).contains("iron"))
                                || (getModName(b).contains("lapis"))
                                || (getModName(b).contains("copper"))
                )
        );
        this.addToTag(
                BlockTags.NEEDS_IRON_TOOL,
                ModBLockList.getAllMaterialsBlocks().stream().filter(
                        b -> (getModName(b).contains("gold"))
                                || (getModName(b).contains("emerald"))
                                || (getModName(b).contains("diamond"))
                )
        );
        this.addToTag(
                BlockTags.NEEDS_DIAMOND_TOOL,
                ModBLockList.getAllMaterialsBlocks().stream().filter(
                        b -> (getModName(b).contains("netherite"))
                                || (getModName(b).contains("obsidian"))
                )
        );
        this.addToTag(
                BlockTags.MINEABLE_WITH_PICKAXE,
                Stream.of(
                        BlockRegister.VILLAGER_WORKSHOP.get(),
                        BlockRegister.GYPSUM_STAIRS.get(),
                        BlockRegister.GYPSUM_SLAB.get(),
                        BlockRegister.GYPSUM_WALL.get(),
                        BlockRegister.GYPSUM.get(),
                        BlockRegister.POINTED_GYPSUM.get(),
                        BlockRegister.GYPSUM_CLUSTER.get(),
                        BlockRegister.CUTTED_GYPSUM.get(),
                        BlockRegister.POLISHED_GYPSUM.get(),
                        BlockRegister.POLISHED_GYPSUM_STAIRS.get(),
                        BlockRegister.POLISHED_GYPSUM_SLAB.get(),
                        BlockRegister.POLISHED_GYPSUM_WALL.get()
                ),
                ModBLockList.getAllMaterialsBlocks().stream().filter(
                        b -> (getModName(b).contains("red_sandstone"))
                                || (getModName(b).contains("sandstone"))
                                || (getModName(b).contains("mossy_stone"))
                                || (getModName(b).contains("end_stone"))
                                || (getModName(b).contains("blackstone"))
                                || (getModName(b).contains("redstone"))
                                || (getModName(b).contains("dripstone"))
                                || (getModName(b).contains("stone"))
                                || (getModName(b).contains("andesite"))
                                || (getModName(b).contains("diorite"))
                                || (getModName(b).contains("granite"))
                                || (getModName(b).contains("prismarine"))
                                || (getModName(b).contains("purpur"))
                                || (getModName(b).contains("deepslate"))
                                || (getModName(b).contains("tuff"))
                                || (getModName(b).contains("packed_mud"))
                                || (getModName(b).contains("quartz"))
                                || (getModName(b).contains("nether_bricks"))
                                || (getModName(b).contains("basalt"))
                                || (getModName(b).contains("coal"))
                                || (getModName(b).contains("iron"))
                                || (getModName(b).contains("gold"))
                                || (getModName(b).contains("emerald"))
                                || (getModName(b).contains("diamond"))
                                || (getModName(b).contains("copper"))
                                || (getModName(b).contains("lapis"))
                                || (getModName(b).contains("netherite"))
                                || (getModName(b).contains("obsidian"))
                                || (getModName(b).contains("amethyst"))
                                || (getModName(b).contains("gypsum"))
                )
        );
        this.addToTag(
                BlockTags.MINEABLE_WITH_HOE,
                ModBLockList.getAllBlocksFromClass(ModLeavesBlock.class).stream()
        );
        this.addToTag(
                BlockTags.MINEABLE_WITH_AXE,
                ModBLockList.getAllBlocksFromClass(
                        LogBlock.class,
                        SaplingBlock.class,
                        AbstractCropLikeBlock.class
                ).stream(),
                ModBLockList.getAllBlocksFromClass(FlammableBlock.class).stream().filter(block -> (getModName(block).contains("planks"))),
                getWoodTypeFilter(ModBLockList.getAllBlocksFromClass(
                        StairBlock.class,
                        SlabBlock.class,
                        ButtonBlock.class,
                        PressurePlateBlock.class,
                        FenceBlock.class,
                        FenceGateBlock.class,
                        DoorBlock.class,
                        TrapDoorBlock.class,
                        SignBlock.class
                ).stream()),
                ModBLockList.getAllMaterialsBlocks().stream().filter(
                        b -> getModName(b).contains("dark_oak")
                                || getModName(b).contains("oak")
                                || getModName(b).contains("birch")
                                || getModName(b).contains("spruce")
                                || getModName(b).contains("jungle")
                                || getModName(b).contains("acacia")
                                || getModName(b).contains("mangrove")
                                || getModName(b).contains("cherry")
                                || getModName(b).contains("crimson")
                                || getModName(b).contains("warped")
                                || getModName(b).contains("bamboo")
                                || getModName(b).contains("mountain_currant")
                                || getModName(b).contains("moriche_palm")
                                || getModName(b).contains("achiote")
                                || getModName(b).contains("weeping_willow")
                )
        );
        this.addToTag(
                BlockTags.SWORD_EFFICIENT,
                ModBLockList.getAllBlocksFromClass(
                        ModLeavesBlock.class,
                        SaplingBlock.class,
                        AbstractCropLikeBlock.class,
                        TallFlowerBlock.class
                ).stream()
        );
        //block category
        this.addToTag(
                BlockTags.FLOWER_POTS,
                ModBLockList.getAllBlocksFromClass(FlowerPotBlock.class).stream()
        );
        this.addToTag(
                BlockTags.PLANKS,
                ModBLockList.getAllBlocksFromClass(FlammableBlock.class).stream().filter(block -> (getModName(block).contains("planks")))
        );
        //  geology
        this.addToTag(
                ModBlockTags.GYPSUM,
                Stream.of(
                        BlockRegister.GYPSUM.get(),
                        BlockRegister.GYPSUM_STAIRS.get(),
                        BlockRegister.GYPSUM_SLAB.get(),
                        BlockRegister.GYPSUM_WALL.get(),
                        BlockRegister.POINTED_GYPSUM.get(),
                        BlockRegister.GYPSUM_CLUSTER.get(),
                        BlockRegister.CUTTED_GYPSUM.get(),
                        BlockRegister.POLISHED_GYPSUM.get(),
                        BlockRegister.POLISHED_GYPSUM_STAIRS.get(),
                        BlockRegister.POLISHED_GYPSUM_SLAB.get(),
                        BlockRegister.POLISHED_GYPSUM_WALL.get()
                )
        );
        //  all materials
        this.addToTag(
                ModBlockTags.VILLAGER_STATUE,
                ModBLockList.getAllBlocksFromClass(VillagerStatue.class).stream()
        );
        this.addToTag(
                ModBlockTags.VILLAGER_PEDESTAL,
                ModBLockList.getAllBlocksFromClass(VillagerPedestalBlock.class).stream()
        );
        this.addToTag(
                ModBlockTags.VILLAGER_BRAZIER,
                ModBLockList.getAllBlocksFromClass(VillagerBrazier.class).stream()
        );
        this.addToTag(
                ModBlockTags.VILLAGER_TABLE,
                ModBLockList.getAllBlocksFromClass(VillagerTableBlock.class).stream()
        );
        this.addToTag(
                ModBlockTags.VILLAGER_CHAIR,
                ModBLockList.getAllBlocksFromClass(VillagerChairBlock.class).stream()
        );
        this.addToTag(
                ModBlockTags.VILLAGER_THRONE_CHAIR,
                ModBLockList.getAllBlocksFromClass(VillagerThroneChairBlock.class).stream()
        );
        this.addToTag(
                ModBlockTags.VILLAGER_DRAWER,
                ModBLockList.getAllBlocksFromClass(VillagerDrawer.class).stream()
        );
        this.addToTag(
                ModBlockTags.VILLAGER_SHELF,
                ModBLockList.getAllBlocksFromClass(VillagerShelf.class).stream()
        );
        this.addToTag(
                ModBlockTags.VILLAGER_BENCH,
                ModBLockList.getAllBlocksFromClass(VillagerBench.class).stream()
        );
        this.addToTag(
                ModBlockTags.VILLAGER_COUCH,
                ModBLockList.getAllBlocksFromClass(VillagerCouch.class).stream()
        );
        this.addToTag(
                ModBlockTags.VILLAGER_BREWING_STATION,
                ModBLockList.getAllBlocksFromClass(VillagerBrewingStation.class).stream()
        );
        this.addToTag(
                ModBlockTags.VILLAGER_MUSICAL_FRIDGE,
                ModBLockList.getAllBlocksFromClass(VillagerMusicalFridgeBlock.class).stream()
        );
        this.addToTag(
                ModBlockTags.VILLAGER_CHISELED_HEAD,
                ModBLockList.getAllBlocksFromClass(VillagerChiseledHead.class).stream()
        );
        this.addToTag(
                ModBlockTags.VILLAGER_DRY_TOILET,
                ModBLockList.getAllBlocksFromClass(VillagerDryToiletBlock.class).stream()
        );
        //  construction
        this.addToTag(
                BlockTags.STAIRS,
                ModBLockList.getAllBlocksFromClass(StairBlock.class).stream()
        );
        this.addToTag(
                BlockTags.WOODEN_STAIRS,
                getWoodTypeFilter(ModBLockList.getAllBlocksFromClass(StairBlock.class).stream())
        );
        this.addToTag(
                BlockTags.SLABS,
                ModBLockList.getAllBlocksFromClass(SlabBlock.class).stream()
        );
        this.addToTag(
                BlockTags.WOODEN_SLABS,
                getWoodTypeFilter(ModBLockList.getAllBlocksFromClass(SlabBlock.class).stream())
        );
        this.addToTag(
                BlockTags.BUTTONS,
                ModBLockList.getAllBlocksFromClass(ButtonBlock.class).stream()
        );
        this.addToTag(
                BlockTags.WOODEN_BUTTONS,
                getWoodTypeFilter(ModBLockList.getAllBlocksFromClass(ButtonBlock.class).stream())
        );
        this.addToTag(
                BlockTags.PRESSURE_PLATES,
                ModBLockList.getAllBlocksFromClass(PressurePlateBlock.class).stream()
        );
        this.addToTag(
                BlockTags.WOODEN_PRESSURE_PLATES,
                getWoodTypeFilter(ModBLockList.getAllBlocksFromClass(PressurePlateBlock.class).stream())
        );
        this.addToTag(
                BlockTags.WALL_POST_OVERRIDE,
                ModBLockList.getAllBlocksFromClass(PressurePlateBlock.class).stream()
        );
        this.addToTag(
                BlockTags.FENCES,
                ModBLockList.getAllBlocksFromClass(FenceBlock.class).stream()
        );
        this.addToTag(
                BlockTags.WOODEN_FENCES,
                getWoodTypeFilter(ModBLockList.getAllBlocksFromClass(FenceBlock.class).stream())
        );
        this.addToTag(
                Tags.Blocks.FENCES,
                ModBLockList.getAllBlocksFromClass(FenceBlock.class).stream()
        );
        this.addToTag(
                Tags.Blocks.FENCES_WOODEN,
                getWoodTypeFilter(ModBLockList.getAllBlocksFromClass(FenceBlock.class).stream())
        );
        this.addToTag(
                BlockTags.FENCE_GATES,
                ModBLockList.getAllBlocksFromClass(FenceGateBlock.class).stream()
        );
        this.addToTag(
                BlockTags.UNSTABLE_BOTTOM_CENTER,
                ModBLockList.getAllBlocksFromClass(FenceGateBlock.class).stream()
        );
        this.addToTag(
                Tags.Blocks.FENCE_GATES,
                ModBLockList.getAllBlocksFromClass(FenceGateBlock.class).stream()
        );
        this.addToTag(
                Tags.Blocks.FENCE_GATES_WOODEN,
                getWoodTypeFilter(ModBLockList.getAllBlocksFromClass(FenceGateBlock.class).stream())
        );
        this.addToTag(
                BlockTags.DOORS,
                ModBLockList.getAllBlocksFromClass(DoorBlock.class).stream()
        );
        this.addToTag(
                BlockTags.WOODEN_DOORS,
                getWoodTypeFilter(ModBLockList.getAllBlocksFromClass(DoorBlock.class).stream())
        );
        this.addToTag(
                BlockTags.MOB_INTERACTABLE_DOORS,
                getWoodTypeFilter(ModBLockList.getAllBlocksFromClass(DoorBlock.class).stream())
        );
        this.addToTag(
                BlockTags.TRAPDOORS,
                ModBLockList.getAllBlocksFromClass(TrapDoorBlock.class).stream()
        );
        this.addToTag(
                BlockTags.WOODEN_TRAPDOORS,
                getWoodTypeFilter(ModBLockList.getAllBlocksFromClass(TrapDoorBlock.class).stream())
        );
        this.addToTag(
                BlockTags.ALL_SIGNS,
                ModBLockList.getAllBlocksFromClass(SignBlock.class).stream()
        );
        this.addToTag(
                BlockTags.SIGNS,
                ModBLockList.getAllBlocksFromClass(
                        ModStandingSignBlock.class,
                        ModWallSignBlock.class
                ).stream()
        );
        this.addToTag(
                BlockTags.STANDING_SIGNS,
                ModBLockList.getAllBlocksFromClass(ModStandingSignBlock.class).stream()
        );
        this.addToTag(
                BlockTags.WALL_SIGNS,
                ModBLockList.getAllBlocksFromClass(ModWallSignBlock.class).stream()
        );
        this.addToTag(
                BlockTags.ALL_HANGING_SIGNS,
                ModBLockList.getAllBlocksFromClass(
                        ModHangingSignBlock.class,
                        ModWallHangingSignBlock.class
                ).stream()
        );
        this.addToTag(
                BlockTags.CEILING_HANGING_SIGNS,
                ModBLockList.getAllBlocksFromClass(ModHangingSignBlock.class).stream()
        );
        this.addToTag(
                BlockTags.WALL_HANGING_SIGNS,
                ModBLockList.getAllBlocksFromClass(ModWallHangingSignBlock.class).stream()
        );
        this.addToTag(
                BlockTags.WALLS,
                ModBLockList.getAllBlocksFromClass(WallBlock.class).stream()
        );
        //  vegetation
        this.addToTag(
                BlockTags.CROPS,
                ModBLockList.getAllBlocksFromClass(AbstractCropLikeBlock.class).stream()
        );
        this.addToTag(
                BlockTags.FLOWERS,
                ModBLockList.getAllBlocksFromClass(
                        FlowerBlock.class,
                        AbstractGrowingAboveVegetation.class,
                        CactusFlowerBlock.class,
                        SkySpearsFlower.class,
                        TallFlowerBlock.class
                ).stream()
        );
        this.addToTag(
                BlockTags.SAPLINGS,
                ModBLockList.getAllBlocksFromClass(SaplingBlock.class).stream()
        );
        this.addToTag(
                BlockTags.LEAVES,
                ModBLockList.getAllBlocksFromClass(ModLeavesBlock.class).stream()
        );
        //      wood
        this.addToTag(
                BlockTags.LOGS,
                ModBLockList.getAllBlocksFromClass(LogBlock.class).stream()
        );
        this.addToTag(
                BlockTags.LOGS_THAT_BURN,
                ModBLockList.getAllBlocksFromClass(LogBlock.class).stream()
        );
        this.addToTag(
                BlockTags.OVERWORLD_NATURAL_LOGS,
                ModBLockList.getAllBlocksFromClass(LogBlock.class).stream().filter(block -> !(getModName(block).contains("stripped")))
        );
        this.addToTag(
                Tags.Blocks.STRIPPED_LOGS,
                ModBLockList.getAllBlocksFromClass(LogBlock.class).stream().filter(block -> (getModName(block).contains("stripped")) && (getModName(block).contains("log")))
        );
        this.addToTag(
                Tags.Blocks.STRIPPED_WOODS,
                ModBLockList.getAllBlocksFromClass(LogBlock.class).stream().filter(block -> (getModName(block).contains("stripped")) && (getModName(block).contains("wood")))
        );
        this.addToTag(
                ModBlockTags.MOUNTAIN_CURRANT_LOGS,
                ModBLockList.getAllBlocksFromClass(LogBlock.class).stream().filter(block -> (getModName(block).contains("mountain_currant")))
        );
        this.addToTag(
                ModBlockTags.MORICHE_PALM_LOGS,
                ModBLockList.getAllBlocksFromClass(LogBlock.class).stream().filter(block -> (getModName(block).contains("moriche_palm")))
        );
        this.addToTag(
                ModBlockTags.ACHIOTE_LOGS,
                ModBLockList.getAllBlocksFromClass(LogBlock.class).stream().filter(block -> (getModName(block).contains("achiote")))
        );
        this.addToTag(
                ModBlockTags.WEEPING_WILLOW_LOGS,
                ModBLockList.getAllBlocksFromClass(LogBlock.class).stream().filter(block -> (getModName(block).contains("weeping_willow")))
        );
        //mob interaction
        this.addToTag(
                BlockTags.SNAPS_GOAT_HORN,
                ModBLockList.getAllBlocksFromClass(LogBlock.class).stream()
        );
        this.addToTag(
                BlockTags.ENDERMAN_HOLDABLE,
                ModBLockList.getAllBlocksFromClass(
                        FlowerBlock.class,
                        CactusFlowerBlock.class,
                        SkySpearsFlower.class
                ).stream()
        );
        //tutorial
        this.addToTag(
                BlockTags.COMPLETES_FIND_TREE_TUTORIAL,
                ModBLockList.getAllBlocksFromClass(
                        LogBlock.class,
                        ModLeavesBlock.class
                ).stream(),
                ModBLockList.getAllBlocksFromClass(ModLeavesBlock.class).stream()
        );
        //generation
        //  world
        this.addToTag(
                BlockTags.LAVA_POOL_STONE_CANNOT_REPLACE,
                ModBLockList.getAllBlocksFromClass(
                        LogBlock.class,
                        ModLeavesBlock.class
                ).stream()
        );
        this.addToTag(
                BlockTags.REPLACEABLE_BY_TREES,
                ModBLockList.getAllBlocksFromClass(
                        ModLeavesBlock.class,
                        TallFlowerBlock.class
                ).stream()
        );
        //  mob spawn
        this.addToTag(
                BlockTags.PARROTS_SPAWNABLE_ON,
                ModBLockList.getAllBlocksFromClass(
                        LogBlock.class,
                        ModLeavesBlock.class
                ).stream()
        );

    }

    @SafeVarargs
    private void addToTag(TagKey<Block> blockTag, Stream<Block>... blockSteams)
    {
        this.tag(blockTag).add(
                Stream.of(blockSteams)
                        .flatMap(s -> s)
                        .toArray(Block[]::new)
        );
    }

    private Stream<Block> getWoodTypeFilter(Stream<Block> notFiltered)
    {
        return notFiltered.filter(block -> (getModName(block).contains("mountain_currant"))
                || (getModName(block).contains("moriche_palm"))
                || (getModName(block).contains("achiote"))
                || (getModName(block).contains("weeping_willow"))
        );
    }
}