package com.unpainperdu.premierpainmod.util.register.block;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.BeerBlock;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.*;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.adaptable_sit.VillagerBench;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.adaptable_sit.VillagerCouch;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height_with_block_entity.VillagerMusicalFridgeBlock;
import com.unpainperdu.premierpainmod.level.world.block.event_block.LibertyBlock;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height.VillagerBrazier;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height.VillagerStatue;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height.VillagerThroneChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.VillagerDrawer;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.villager_shelf.StandingVillagerShelf;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width.VillagerWorkshop;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.villager_shelf.WallVillagerShelf;
import com.unpainperdu.premierpainmod.level.world.block.tree.*;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.basicFlower.CuriosityFlower;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.crop.JellyShroomBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.growingAboveVegetation.CivilizationsFlowerBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.CactusFlowerBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.FloweredCactusBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.twoBlockHeight.BasicTallGrassBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.twoBlockHeight.skySpears.SkySpearsFlower;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.twoBlockHeight.DeadTallGrass;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.twoBlockHeight.skySpears.SkySpears;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.ModTreeGrower;
import com.unpainperdu.premierpainmod.util.register.fluid.FluidRegister;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import com.unpainperdu.premierpainmod.util.type.ModWoodTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.*;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class BlockRegister
{
    private BlockRegister(){}

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PremierPainMod.MOD_ID);

    public static final List<String> MATERIALS = Arrays.asList("oak",
            "birch","spruce","jungle",
            "acacia","dark_oak","mangrove",
            "cherry","bamboo","crimson",
            "warped","pale_oak","stone",
            "mossy_stone","andesite","diorite",
            "granite","prismarine","blackstone",
            "purpur_block","deepslate","tuff",
            "packed_mud","sandstone","red_sandstone",
            "quartz_block","nether_bricks","basalt",
            "end_stone","coal_block","iron_block",
            "gold_block","redstone_block","emerald_block",
            "diamond_block","copper_block","lapis_block",
            "netherite_block","obsidian","amethyst_block",
            "dripstone_block","bedrock","mountain_currant",
            "moriche_palm","achiote"

    );


    private static final List<String> BLOCKTYPES = Arrays.asList("villager_statue", "villager_pedestal", "villager_brazier",
            "villager_table", "villager_chair", "villager_throne_chair",
            "villager_drawer", "standing_villager_shelf", "wall_villager_shelf",
            "villager_bench", "villager_couch", "villager_brewing_station",
            "villager_musical_fridge","villager_chiseled_head"
    );

    public static final Map<String, DeferredBlock<Block>> AllMaterialsMap = createAllMaterialsBlocks();

    //public static final DeferredBlock<Block> TEST_BLOCK = registerBlock("test_block", () -> new VillagerBrewingStation(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion().noLootTable()));
    //liquid block zone, see FluidRegister too
    //beer
    private static final BlockBehaviour.Properties beerStandardProperties = BlockBehaviour.Properties.of().replaceable().noCollission().strength(100.0F).pushReaction(PushReaction.DESTROY).noLootTable().liquid().sound(SoundType.EMPTY);
    public static final DeferredBlock<Block> PAIN_DIEUX = registerBlockOnly("pain_dieux",
            () -> new BeerBlock((FlowingFluid) FluidRegister.PAIN_DIEUX_FLUID.get(), beerStandardProperties.mapColor(MapColor.COLOR_YELLOW)));
    public static final DeferredBlock<Block> LA_CHATEAU = registerBlockOnly("la_chateau",
            () -> new BeerBlock((FlowingFluid) FluidRegister.LA_CHATEAU_FLUID.get(), beerStandardProperties.mapColor(MapColor.COLOR_BROWN)));
    public static final DeferredBlock<Block> DEBIER = registerBlockOnly("debier",
            () -> new BeerBlock((FlowingFluid) FluidRegister.DEBIER_FLUID.get(), beerStandardProperties.mapColor(MapColor.COLOR_GREEN)));
    public static final DeferredBlock<Block> ENVAHISSEUR_ROUGE = registerBlockOnly("envahisseur_rouge",
            () -> new BeerBlock((FlowingFluid) FluidRegister.ENVAHISSEUR_ROUGE_FLUID.get(), beerStandardProperties.mapColor(MapColor.COLOR_GREEN)));
    public static final DeferredBlock<Block> RASPBUISSON = registerBlockOnly("raspbuisson",
            () -> new BeerBlock((FlowingFluid) FluidRegister.RASPBUISSON_FLUID.get(), beerStandardProperties.mapColor(MapColor.NETHER)));
    public static final DeferredBlock<Block> LA_BLANCHE_CITADINE = registerBlockOnly("la_blanche_citadine",
            () -> new BeerBlock((FlowingFluid) FluidRegister.LA_BLANCHE_CITADINE_FLUID.get(), beerStandardProperties.mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final DeferredBlock<Block> CRANE_NOIR = registerBlockOnly("crane_noir",
            () -> new BeerBlock((FlowingFluid) FluidRegister.CRANE_NOIR_FLUID.get(), beerStandardProperties.mapColor(MapColor.COLOR_BLACK)));
    public static final DeferredBlock<Block> TAK = registerBlockOnly("tak",
            () -> new BeerBlock((FlowingFluid) FluidRegister.TAK_FLUID.get(), beerStandardProperties.mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final DeferredBlock<Block> DISENDER = registerBlockOnly("disender",
            () -> new BeerBlock((FlowingFluid) FluidRegister.DISENDER_FLUID.get(), beerStandardProperties.mapColor(MapColor.COLOR_PURPLE)));

    //WorkShopZone
    public static final DeferredBlock<Block> VILLAGER_WORKSHOP = registerBlock("villager_workshop", () -> new VillagerWorkshop(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
     //Villager Singing stone event block
    public static final DeferredBlock<Block> LIBERTY_BLOCK =  registerBlock("liberty_block", () -> new LibertyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(0.0F, 0.0F).noLootTable().noOcclusion()));
    //vegetation
        //misc
    public static final DeferredBlock<Block> FLOWERED_CACTUS_BLOCK =  registerBlock("flowered_cactus_block", () -> new FloweredCactusBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CACTUS).noOcclusion()));
    public static final DeferredBlock<Block> CACTUS_FLOWER_BLOCK =  registerBlock("cactus_flower_block", () -> new CactusFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> POTTED_CACTUS_FLOWER_BLOCK =  registerFlowerPot("potted_cactus_flower_block", () -> CACTUS_FLOWER_BLOCK);
    public static final DeferredBlock<Block> SKY_SPEARS =  registerBlock("sky_spears", () -> new SkySpears(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> SKY_SPEARS_FLOWER =  registerBlock("sky_spears_flower", () -> new SkySpearsFlower(BlockBehaviour.Properties.ofFullCopy(BlockRegister.SKY_SPEARS.get())));
    public static final DeferredBlock<Block> POTTED_SKY_SPEARS_FLOWER =  registerFlowerPot("potted_sky_spears_flower", () -> SKY_SPEARS_FLOWER);
    public static final DeferredBlock<Block> DEAD_TALL_BUSH =  registerBlock("dead_tall_bush", () -> new DeadTallGrass(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> OLD_WILD_WHEAT =  registerBlock("old_wild_wheat", () -> new BasicTallGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));
        //cropLike
    public static final DeferredBlock<Block> JELLYSHROOM =  registerBlock("jellyshroom", () -> new JellyShroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> POTTED_JELLYSHROOM =  registerFlowerPot("potted_jellyshroom", () -> JELLYSHROOM);
    /*
        1 block flower
        -->
        flower block
        flower pot
         */
    public static final DeferredBlock<Block> RUINS_FLOWER =  registerBlock("ruins_flower", () -> new FlowerBlock(MobEffects.WITHER,5,BlockBehaviour.Properties.ofFullCopy(Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> POTTED_RUINS_FLOWER = registerFlowerPot("potted_ruins_flower",() -> RUINS_FLOWER);
    public static final DeferredBlock<Block> CIVILIZATIONS_FLOWER =  registerBlock("civilizations_flower", () -> new CivilizationsFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> POTTED_CIVILIZATIONS_FLOWER = registerFlowerPot("potted_civilizations_flower",() -> CIVILIZATIONS_FLOWER);
    public static final DeferredBlock<Block> CURIOSITY_FLOWER =  registerBlock("curiosity_flower", () -> new CuriosityFlower(MobEffects.REGENERATION,5,BlockBehaviour.Properties.ofFullCopy(Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> POTTED_CURIOSITY_FLOWER = registerFlowerPot("potted_curiosity_flower",() -> CURIOSITY_FLOWER);
        //dead bush block (like flower)
    public static final DeferredBlock<Block> DEAD_RUINS_FLOWER =  registerBlock("dead_ruins_flower", () -> new DeadBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEAD_BUSH).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> POTTED_DEAD_RUINS_FLOWER = registerFlowerPot("potted_dead_ruins_flower",() -> DEAD_RUINS_FLOWER);
    //tree
        //mountain_currant
    public static final DeferredBlock<Block> MOUNTAIN_CURRANT_LOG =  registerBlock("mountain_currant_log", () -> new LogBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> STRIPPED_MOUNTAIN_CURRANT_LOG =  registerBlock("stripped_mountain_currant_log", () -> new LogBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> MOUNTAIN_CURRANT_WOOD =  registerBlock("mountain_currant_wood", () -> new LogBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> STRIPPED_MOUNTAIN_CURRANT_WOOD =  registerBlock("stripped_mountain_currant_wood", () -> new LogBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> MOUNTAIN_CURRANT_PLANKS =  registerBlock("mountain_currant_planks", () -> new FlammableBlock(20,5,BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> MOUNTAIN_CURRANT_LEAVES =  registerBlock("mountain_currant_leaves", () -> new ModLeavesBlock(true, 60,30,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> MOUNTAIN_CURRANT_STAIRS =  registerBlock("mountain_currant_stairs", () -> registerStair(() -> MOUNTAIN_CURRANT_PLANKS));
    public static final DeferredBlock<Block> MOUNTAIN_CURRANT_SLAB =  registerBlock("mountain_currant_slab", () -> registerSlab(() -> MOUNTAIN_CURRANT_PLANKS));
    public static final DeferredBlock<Block> MOUNTAIN_CURRANT_BUTTON =  registerBlock("mountain_currant_button", () -> registerButton(Blocks.OAK_BUTTON, BlockSetType.OAK, 30));
    public static final DeferredBlock<Block> MOUNTAIN_CURRANT_PRESSURE_PLATE=  registerBlock("mountain_currant_pressure_plate", () -> registerPressurePlate(BlockSetType.OAK, () -> MOUNTAIN_CURRANT_PLANKS));
    public static final DeferredBlock<Block> MOUNTAIN_CURRANT_FENCE =  registerBlock("mountain_currant_fence", () -> registerFence(() -> MOUNTAIN_CURRANT_PLANKS));
    public static final DeferredBlock<Block> MOUNTAIN_CURRANT_FENCE_GATE =  registerBlock("mountain_currant_fence_gate", () -> registerFenceGate(WoodType.OAK, () -> MOUNTAIN_CURRANT_PLANKS));
    public static final DeferredBlock<Block> MOUNTAIN_CURRANT_DOOR =  registerBlock("mountain_currant_door", () -> registerDoor(BlockSetType.OAK, () -> MOUNTAIN_CURRANT_PLANKS));
    public static final DeferredBlock<Block> MOUNTAIN_CURRANT_TRAPDOOR =  registerBlock("mountain_currant_trapdoor", () -> registerTrapdoor(BlockSetType.OAK, () -> MOUNTAIN_CURRANT_PLANKS));
    public static final DeferredBlock<Block> MOUNTAIN_CURRANT_SIGN =  registerBlockOnly("mountain_currant_sign", () -> new ModStandingSignBlock(ModWoodTypes.MOUNTAIN_CURRANT, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final DeferredBlock<Block> MOUNTAIN_CURRANT_WALL_SIGN =  registerBlockOnly("mountain_currant_wall_sign", () -> new ModWallSignBlock(ModWoodTypes.MOUNTAIN_CURRANT, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final DeferredBlock<Block> MOUNTAIN_CURRANT_HANGING_SIGN =  registerBlockOnly("mountain_currant_hanging_sign", () -> new ModHangingSignBlock(ModWoodTypes.MOUNTAIN_CURRANT, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final DeferredBlock<Block> MOUNTAIN_CURRANT_WALL_HANGING_SIGN =  registerBlockOnly("mountain_currant_wall_hanging_sign", () -> new ModWallHangingSignBlock(ModWoodTypes.MOUNTAIN_CURRANT, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final DeferredBlock<Block> MOUNTAIN_CURRANT_SAPLING =  registerBlock("mountain_currant_sapling", () -> new SaplingBlock(ModTreeGrower.MOUNTAIN_CURRANT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> POTTED_MOUNTAIN_CURRANT_SAPLING = registerFlowerPot("potted_mountain_currant_sapling",() -> MOUNTAIN_CURRANT_SAPLING);
        //moriche_palm
    public static final DeferredBlock<Block> MORICHE_PALM_LOG =  registerBlock("moriche_palm_log", () -> new LogBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> STRIPPED_MORICHE_PALM_LOG =  registerBlock("stripped_moriche_palm_log", () -> new LogBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> MORICHE_PALM_WOOD =  registerBlock("moriche_palm_wood", () -> new LogBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> STRIPPED_MORICHE_PALM_WOOD =  registerBlock("stripped_moriche_palm_wood", () -> new LogBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> MORICHE_PALM_PLANKS =  registerBlock("moriche_palm_planks", () -> new FlammableBlock(20,5,BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> MORICHE_PALM_LEAVES =  registerBlock("moriche_palm_leaves", () -> new ModLeavesBlock(false, 60,30,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> MORICHE_PALM_STAIRS =  registerBlock("moriche_palm_stairs", () -> registerStair(() -> MORICHE_PALM_PLANKS));
    public static final DeferredBlock<Block> MORICHE_PALM_SLAB =  registerBlock("moriche_palm_slab", () -> registerSlab(() -> MORICHE_PALM_PLANKS));
    public static final DeferredBlock<Block> MORICHE_PALM_BUTTON =  registerBlock("moriche_palm_button", () -> registerButton(Blocks.OAK_BUTTON, BlockSetType.OAK, 30));
    public static final DeferredBlock<Block> MORICHE_PALM_PRESSURE_PLATE=  registerBlock("moriche_palm_pressure_plate", () -> registerPressurePlate(BlockSetType.OAK, () -> MORICHE_PALM_PLANKS));
    public static final DeferredBlock<Block> MORICHE_PALM_FENCE =  registerBlock("moriche_palm_fence", () -> registerFence(() -> MORICHE_PALM_PLANKS));
    public static final DeferredBlock<Block> MORICHE_PALM_FENCE_GATE =  registerBlock("moriche_palm_fence_gate", () -> registerFenceGate(WoodType.OAK, () -> MORICHE_PALM_PLANKS));
    public static final DeferredBlock<Block> MORICHE_PALM_DOOR =  registerBlock("moriche_palm_door", () -> registerDoor(BlockSetType.OAK, () -> MORICHE_PALM_PLANKS));
    public static final DeferredBlock<Block> MORICHE_PALM_TRAPDOOR =  registerBlock("moriche_palm_trapdoor", () -> registerTrapdoor(BlockSetType.OAK, () -> MORICHE_PALM_PLANKS));
    public static final DeferredBlock<Block> MORICHE_PALM_SIGN =  registerBlockOnly("moriche_palm_sign", () -> new ModStandingSignBlock(ModWoodTypes.MORICHE_PALM, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final DeferredBlock<Block> MORICHE_PALM_WALL_SIGN =  registerBlockOnly("moriche_palm_wall_sign", () -> new ModWallSignBlock(ModWoodTypes.MORICHE_PALM, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final DeferredBlock<Block> MORICHE_PALM_HANGING_SIGN =  registerBlockOnly("moriche_palm_hanging_sign", () -> new ModHangingSignBlock(ModWoodTypes.MORICHE_PALM, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final DeferredBlock<Block> MORICHE_PALM_WALL_HANGING_SIGN =  registerBlockOnly("moriche_palm_wall_hanging_sign", () -> new ModWallHangingSignBlock(ModWoodTypes.MORICHE_PALM, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final DeferredBlock<Block> MORICHE_PALM_SAPLING =  registerBlock("moriche_palm_sapling", () -> new SaplingBlock(ModTreeGrower.MORICHE_PALM, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> POTTED_MORICHE_PALM_SAPLING = registerFlowerPot("potted_moriche_palm_sapling",() -> MORICHE_PALM_SAPLING);
        //achiote
    public static final DeferredBlock<Block> ACHIOTE_LOG =  registerBlock("achiote_log", () -> new LogBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> STRIPPED_ACHIOTE_LOG =  registerBlock("stripped_achiote_log", () -> new LogBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ACHIOTE_WOOD =  registerBlock("achiote_wood", () -> new LogBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> STRIPPED_ACHIOTE_WOOD =  registerBlock("stripped_achiote_wood", () -> new LogBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ACHIOTE_PLANKS =  registerBlock("achiote_planks", () -> new FlammableBlock(20,5,BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> ACHIOTE_LEAVES =  registerBlock("achiote_leaves", () -> new ModLeavesBlock(true, 60,30,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> ACHIOTE_STAIRS =  registerBlock("achiote_stairs", () -> registerStair(() -> ACHIOTE_PLANKS));
    public static final DeferredBlock<Block> ACHIOTE_SLAB =  registerBlock("achiote_slab", () -> registerSlab(() -> ACHIOTE_PLANKS));
    public static final DeferredBlock<Block> ACHIOTE_BUTTON =  registerBlock("achiote_button", () -> registerButton(Blocks.OAK_BUTTON, BlockSetType.OAK, 30));
    public static final DeferredBlock<Block> ACHIOTE_PRESSURE_PLATE=  registerBlock("achiote_pressure_plate", () -> registerPressurePlate(BlockSetType.OAK, () -> ACHIOTE_PLANKS));
    public static final DeferredBlock<Block> ACHIOTE_FENCE =  registerBlock("achiote_fence", () -> registerFence(() -> ACHIOTE_PLANKS));
    public static final DeferredBlock<Block> ACHIOTE_FENCE_GATE =  registerBlock("achiote_fence_gate", () -> registerFenceGate(WoodType.OAK, () -> ACHIOTE_PLANKS));
    public static final DeferredBlock<Block> ACHIOTE_DOOR =  registerBlock("achiote_door", () -> registerDoor(BlockSetType.OAK, () -> ACHIOTE_PLANKS));
    public static final DeferredBlock<Block> ACHIOTE_TRAPDOOR =  registerBlock("achiote_trapdoor", () -> registerTrapdoor(BlockSetType.OAK, () -> ACHIOTE_PLANKS));
    public static final DeferredBlock<Block> ACHIOTE_SIGN =  registerBlockOnly("achiote_sign", () -> new ModStandingSignBlock(ModWoodTypes.ACHIOTE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final DeferredBlock<Block> ACHIOTE_WALL_SIGN =  registerBlockOnly("achiote_wall_sign", () -> new ModWallSignBlock(ModWoodTypes.ACHIOTE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final DeferredBlock<Block> ACHIOTE_HANGING_SIGN =  registerBlockOnly("achiote_hanging_sign", () -> new ModHangingSignBlock(ModWoodTypes.ACHIOTE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final DeferredBlock<Block> ACHIOTE_WALL_HANGING_SIGN =  registerBlockOnly("achiote_wall_hanging_sign", () -> new ModWallHangingSignBlock(ModWoodTypes.ACHIOTE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final DeferredBlock<Block> ACHIOTE_SAPLING =  registerBlock("achiote_sapling", () -> new SaplingBlock(ModTreeGrower.ACHIOTE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> POTTED_ACHIOTE_SAPLING = registerFlowerPot("potted_achiote_sapling",() -> ACHIOTE_SAPLING);

    private static Map<String, DeferredBlock<Block>> createAllMaterialsBlocks()
    {
        Map<String, DeferredBlock<Block>> map = new HashMap<>();

        for (String blockType : BLOCKTYPES)
        {
            for (String material : MATERIALS)
            {
                String id = material + "_" +  blockType;
                map.put(id, allMaterialsBlockRegister(blockType, id, getMaterialType(material)));
            }
        }

        return map;
    }

    private static String getMaterialType(String material)
    {

        return switch (material)
        {
            case "cherry" -> "cherry";
            case "bamboo" -> "bamboo";
            case "crimson", "warped" -> "netherwood";
            case "stone", "mossy_stone", "andesite", "diorite", "granite", "prismarine", "blackstone", "purpur", "quartz_block" -> "stone";
            case "deepslate" -> "deepslate";
            case "tuff" -> "tuff";
            case "sandstone", "red_sandstone" -> "sandstone";
            case "nether_bricks" -> "nether_bricks";
            case "basalt" -> "basalt";
            case "end_stone" -> "endstone";
            case "coal_block" -> "mineral_strong";
            case "iron_block", "gold_block", "redstone_block", "emerald_block", "diamond_block" -> "metal";
            case "copper_block" -> "copper";
            case "lapis_block" -> "mineral_weak";
            case "netherite_block" -> "netherite";
            case "obsidian" -> "obsidian";
            case "amethyst_block" -> "amethyst";
            case "dripstone_block" -> "dripstone";
            case "bedrock" -> "bedrock";
            case "packed_mud" -> "mud";
            default -> "wood";
        };
    }

    //create the block with a name and the factory (factory include properties)
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
    {
        DeferredBlock<T> madeBlock = BLOCKS.register(name, block);
        registerBlockItem(name, madeBlock);
        return madeBlock;
    }
    private static <T extends Block> DeferredBlock<T> registerBlockOnly(String name, Supplier<T> block)
    {
        return BLOCKS.register(name, block);
    }

    //create the item block of the block
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
        ItemRegister.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static ToIntFunction<BlockState> litBlockEmission(int lightValue)
    {
        return state -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }

    private static <T extends Block> DeferredBlock<T> allMaterialsBlockRegister(String block, String name, String type)
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
            case "nether_bricks":
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
            case "obsidian":
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
                return (DeferredBlock<T>) registerBlockOnly(name, () -> new StandingVillagerShelf(properties));
            }
            case "wall_villager_shelf":
            {
                return (DeferredBlock<T>) registerBlockOnly(name, () -> new WallVillagerShelf(properties));
            }
            case "villager_bench":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBench(properties));
            }
            case "villager_couch":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerCouch(properties));
            }
            case "villager_brewing_station":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerBrewingStation(properties));
            }
            case "villager_musical_fridge":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerMusicalFridgeBlock(properties));
            }
            case "villager_chiseled_head":
            {
                return (DeferredBlock<T>) registerBlock(name, () -> new VillagerChiseledHead(properties.lightLevel(litBlockEmission(13))));
            }
            default :
            {
                return null;
            }
        }
    }
    private static <T extends Block> DeferredBlock<T> registerFlowerPot(String name, Supplier<DeferredBlock<Block>> flowerBlock)
    {
        return (DeferredBlock<T>) BLOCKS.register(name, () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), flowerBlock.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM).noOcclusion()));
    }

    private static Block registerStair(Supplier<DeferredBlock<Block>> baseBlock)
    {
        return new StairBlock(baseBlock.get().get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(baseBlock.get().get()));
    }

    private static Block registerSlab(Supplier<DeferredBlock<Block>> baseBlock)
    {
        return new SlabBlock(BlockBehaviour.Properties.ofFullCopy(baseBlock.get().get()));
    }

    private static Block registerButton(Block button, BlockSetType type, int tickToStayPressed)
    {
        return new ButtonBlock(type, tickToStayPressed, BlockBehaviour.Properties.ofFullCopy(button));
    }

    private static Block registerPressurePlate(BlockSetType type, Supplier<DeferredBlock<Block>> baseBlock)
    {
        return new PressurePlateBlock(type, BlockBehaviour.Properties.ofFullCopy(baseBlock.get().get()));
    }

    private static Block registerFence(Supplier<DeferredBlock<Block>> baseBlock)
    {
        return new FenceBlock(BlockBehaviour.Properties.ofFullCopy(baseBlock.get().get()));
    }

    private static Block registerFenceGate(WoodType type, Supplier<DeferredBlock<Block>> baseBlock)
    {
        return new FenceGateBlock(type, BlockBehaviour.Properties.ofFullCopy(baseBlock.get().get()));
    }

    private static Block registerDoor(BlockSetType type, Supplier<DeferredBlock<Block>> baseBlock)
    {
        return new DoorBlock(type, BlockBehaviour.Properties.ofFullCopy(baseBlock.get().get()).noOcclusion().pushReaction(PushReaction.DESTROY));
    }

    private static Block registerTrapdoor(BlockSetType type, Supplier<DeferredBlock<Block>> baseBlock)
    {
        return new TrapDoorBlock(type, BlockBehaviour.Properties.ofFullCopy(baseBlock.get().get()).noOcclusion().isValidSpawn(Blocks::never));
    }

    public static void register(IEventBus modEventBus)
    {
        BLOCKS.register(modEventBus);
    }
}
