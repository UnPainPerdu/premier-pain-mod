package com.unpainperdu.premierpainmod.util.register.block;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.*;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.adaptable_sit.VillagerBench;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.adaptable_sit.VillagerCouch;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height.VillagerBrazier;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height.VillagerStatue;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height.VillagerThroneChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height_with_block_entity.VillagerMusicalFridgeBlock;
import com.unpainperdu.premierpainmod.level.world.block.crafting_block.CookingPotBlock;
import com.unpainperdu.premierpainmod.level.world.block.crafting_block.VillagerWorkshop;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.VillagerDrawer;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.villager_shelf.StandingVillagerShelf;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.villager_shelf.WallVillagerShelf;
import com.unpainperdu.premierpainmod.level.world.block.event_block.LibertyBlock;
import com.unpainperdu.premierpainmod.level.world.block.tree.*;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.basicFlower.CuriosityFlower;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.crop.JellyShroomBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.growing_above_vegetation.CivilizationsFlowerBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.special_vegetation.CactusFloweredBlock.CactusFlowerBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.special_vegetation.CactusFloweredBlock.FloweredCactusBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.two_block_height.BasicTallGrassBlock;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.two_block_height.DeadTallGrass;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.two_block_height.sky_spears.SkySpears;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.two_block_height.sky_spears.SkySpearsFlower;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.ModTreeGrower;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import com.unpainperdu.premierpainmod.util.type.ModWoodTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class BlockRegister
{
    private BlockRegister()
    {
    }

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PremierPainMod.MOD_ID);

    public static final List<String> MATERIALS = Arrays.asList("oak",
            "birch", "spruce", "jungle",
            "acacia", "dark_oak", "mangrove",
            "cherry", "bamboo", "crimson",
            "warped", "pale_oak", "stone",
            "mossy_stone", "andesite", "diorite",
            "granite", "prismarine", "blackstone",
            "purpur_block", "deepslate", "tuff",
            "packed_mud", "sandstone", "red_sandstone",
            "quartz_block", "nether_bricks", "basalt",
            "end_stone", "coal_block", "iron_block",
            "gold_block", "redstone_block", "emerald_block",
            "diamond_block", "copper_block", "lapis_block",
            "netherite_block", "obsidian", "amethyst_block",
            "dripstone_block", "bedrock", "mountain_currant",
            "moriche_palm", "achiote", "weeping_willow"

    );


    private static final List<String> BLOCKTYPES = Arrays.asList("villager_statue", "villager_pedestal", "villager_brazier",
            "villager_table", "villager_chair", "villager_throne_chair",
            "villager_drawer", "standing_villager_shelf", "wall_villager_shelf",
            "villager_bench", "villager_couch", "villager_brewing_station",
            "villager_musical_fridge", "villager_chiseled_head"
    );

    public static final Map<String, DeferredBlock<Block>> AllMaterialsMap = createAllMaterialsBlocks();

    //crafting_block
    public static final DeferredBlock<Block> VILLAGER_WORKSHOP = registerBlock("villager_workshop", () -> new VillagerWorkshop(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));
    public static final DeferredBlock<Block> COOKING_POT_BLOCK = registerBlock("cooking_pot_block", () -> new CookingPotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
    //Villager Singing stone event block
    public static final DeferredBlock<Block> LIBERTY_BLOCK = registerBlock("liberty_block", () -> new LibertyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(0.0F, 0.0F).noLootTable().noOcclusion()));
    //vegetation
    //misc
    public static final DeferredBlock<Block> FLOWERED_CACTUS_BLOCK = registerBlock("flowered_cactus_block", () -> new FloweredCactusBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CACTUS).noOcclusion()));
    public static final DeferredBlock<Block> CACTUS_FLOWER_BLOCK = registerBlock("cactus_flower_block", () -> new CactusFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY).noOcclusion().noCollission().offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final DeferredBlock<Block> POTTED_CACTUS_FLOWER_BLOCK = registerFlowerPot("potted_cactus_flower_block", () -> CACTUS_FLOWER_BLOCK);
    public static final DeferredBlock<Block> SKY_SPEARS = registerBlock("sky_spears", () -> new SkySpears(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final DeferredBlock<Block> SKY_SPEARS_FLOWER = registerBlock("sky_spears_flower", () -> new SkySpearsFlower(BlockBehaviour.Properties.ofFullCopy(BlockRegister.SKY_SPEARS.get())));
    public static final DeferredBlock<Block> POTTED_SKY_SPEARS_FLOWER = registerFlowerPot("potted_sky_spears_flower", () -> SKY_SPEARS_FLOWER);
    public static final DeferredBlock<Block> DEAD_TALL_BUSH = registerBlock("dead_tall_bush", () -> new DeadTallGrass(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final DeferredBlock<Block> OLD_WILD_WHEAT = registerBlock("old_wild_wheat", () -> new BasicTallGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY).offsetType(BlockBehaviour.OffsetType.XZ)));
    //cropLike
    public static final DeferredBlock<Block> JELLYSHROOM = registerBlock("jellyshroom", () -> new JellyShroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final DeferredBlock<Block> POTTED_JELLYSHROOM = registerFlowerPot("potted_jellyshroom", () -> JELLYSHROOM);
    /*  1 block flower
        -->
        flower block
        flower pot */
    public static final DeferredBlock<Block> RUINS_FLOWER = registerBlock("ruins_flower", () -> new FlowerBlock(MobEffects.WITHER, 5, BlockBehaviour.Properties.ofFullCopy(Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> POTTED_RUINS_FLOWER = registerFlowerPot("potted_ruins_flower", () -> RUINS_FLOWER);
    public static final DeferredBlock<Block> CIVILIZATIONS_FLOWER = registerBlock("civilizations_flower", () -> new CivilizationsFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> POTTED_CIVILIZATIONS_FLOWER = registerFlowerPot("potted_civilizations_flower", () -> CIVILIZATIONS_FLOWER);
    public static final DeferredBlock<Block> CURIOSITY_FLOWER = registerBlock("curiosity_flower", () -> new CuriosityFlower(MobEffects.REGENERATION, 5, BlockBehaviour.Properties.ofFullCopy(Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> POTTED_CURIOSITY_FLOWER = registerFlowerPot("potted_curiosity_flower", () -> CURIOSITY_FLOWER);
    //2 blocks tall flower
    public static final DeferredBlock<Block> FALLING_HELICON_FLOWER = registerTallFlower("falling_helicon_flower");
    //dead bush block (like flower)
    public static final DeferredBlock<Block> DEAD_RUINS_FLOWER = registerBlock("dead_ruins_flower", () -> new DeadBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEAD_BUSH).noOcclusion().noCollission().offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final DeferredBlock<Block> POTTED_DEAD_RUINS_FLOWER = registerFlowerPot("potted_dead_ruins_flower", () -> DEAD_RUINS_FLOWER);
    //tree
    //mountain_currant
    public static final Map<String, DeferredBlock<Block>> MOUNTAIN_CURRANT_WOOD_TYPE_MAP = generateAllBlockForWood("mountain_currant", ModWoodTypes.MOUNTAIN_CURRANT, ModTreeGrower.MOUNTAIN_CURRANT);
    //moriche_palm
    public static final Map<String, DeferredBlock<Block>> MORICHE_PALM_WOOD_TYPE_MAP = generateAllBlockForWood("moriche_palm", ModWoodTypes.MORICHE_PALM, ModTreeGrower.MORICHE_PALM);
    //achiote
    public static final Map<String, DeferredBlock<Block>> ACHIOTE_WOOD_TYPE_MAP = generateAllBlockForWood("achiote", ModWoodTypes.ACHIOTE, ModTreeGrower.ACHIOTE);
    //weeping_willow
    public static final Map<String, DeferredBlock<Block>> WEEPING_WILLOW_WOOD_TYPE_MAP = generateAllBlockForWood("weeping_willow", ModWoodTypes.WEEPING_WILLOW, ModTreeGrower.ACHIOTE);
    public static final DeferredBlock<Block> FALLING_WEEPING_WILLOW_LEAVES = registerBlock("falling_weeping_willow_leaves", () -> new FallingLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ALLIUM).noOcclusion().noCollission()));

    private static Map<String, DeferredBlock<Block>> createAllMaterialsBlocks()
    {
        Map<String, DeferredBlock<Block>> map = new HashMap<>();

        for (String blockType : BLOCKTYPES)
        {
            for (String material : MATERIALS)
            {
                String id = material + "_" + blockType;
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
            case "stone", "mossy_stone", "andesite", "diorite", "granite", "prismarine", "blackstone", "purpur",
                 "quartz_block" -> "stone";
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
    private static DeferredBlock<Block> registerBlock(String name, Supplier<Block> block)
    {
        DeferredBlock<Block> madeBlock = BLOCKS.register(name, block);
        registerBlockItem(name, madeBlock);
        return madeBlock;
    }

    private static DeferredBlock<Block> registerBlockOnly(String name, Supplier<Block> block)
    {
        return BLOCKS.register(name, block);
    }

    //create the item block of the block
    private static void registerBlockItem(String name, DeferredBlock<Block> block)
    {
        ItemRegister.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static ToIntFunction<BlockState> litBlockEmission(int lightValue)
    {
        return state -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }

    private static DeferredBlock<Block> allMaterialsBlockRegister(String block, String name, String type)
    {

        BlockBehaviour.Properties properties;
        /*
          wood as default
        */
        switch (type)
        {
            case "stone" -> properties = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion();
            case "cobblestone" -> properties = BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE).noOcclusion();
            case "deepslate" ->
                    properties = BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE).noOcclusion();
            case "tuff" -> properties = BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF).noOcclusion();
            case "mud" -> properties = BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD).noOcclusion();
            case "sandstone" -> properties = BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).noOcclusion();
            case "nether_bricks" ->
                    properties = BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS).noOcclusion();
            case "mineral_weak" -> properties = BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK).noOcclusion();
            case "mineral_strong" -> properties = BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).noOcclusion();
            case "metal" -> properties = BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion();
            case "copper" -> properties = BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).noOcclusion();
            case "basalt" -> properties = BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT).noOcclusion();
            case "endstone" -> properties = BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).noOcclusion();
            case "obsidian" -> properties = BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).noOcclusion();
            case "netherite" -> properties = BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).noOcclusion();
            case "amethyst" -> properties = BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).noOcclusion();
            case "dripstone" -> properties = BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK).noOcclusion();
            case "bedrock" -> properties = BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK).noOcclusion();
            case "netherwood" -> properties = BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion();
            case "cherry" -> properties = BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion();
            case "bamboo" -> properties = BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion();
            default -> properties = BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion();
        }
        return switch (block)
        {
            case "villager_statue" -> registerBlock(name, () -> new VillagerStatue(properties));
            case "villager_pedestal" -> registerBlock(name, () -> new VillagerPedestalBlock(properties));
            case "villager_brazier" ->
                    registerBlock(name, () -> new VillagerBrazier(Boolean.TRUE, 1, properties.lightLevel(litBlockEmission(15))));
            case "villager_table" -> registerBlock(name, () -> new VillagerTableBlock(properties));
            case "villager_chair" -> registerBlock(name, () -> new VillagerChairBlock(properties));
            case "villager_throne_chair" -> registerBlock(name, () -> new VillagerThroneChairBlock(properties));
            case "villager_drawer" -> registerBlock(name, () -> new VillagerDrawer(properties));
            case "standing_villager_shelf" -> registerBlockOnly(name, () -> new StandingVillagerShelf(properties));
            case "wall_villager_shelf" -> registerBlockOnly(name, () -> new WallVillagerShelf(properties));
            case "villager_bench" -> registerBlock(name, () -> new VillagerBench(properties));
            case "villager_couch" -> registerBlock(name, () -> new VillagerCouch(properties));
            case "villager_brewing_station" -> registerBlock(name, () -> new VillagerBrewingStation(properties));
            case "villager_musical_fridge" -> registerBlock(name, () -> new VillagerMusicalFridgeBlock(properties));
            case "villager_chiseled_head" ->
                    registerBlock(name, () -> new VillagerChiseledHead(properties.lightLevel(litBlockEmission(13))));
            default -> null;
        };
    }

    private static Map<String, DeferredBlock<Block>> generateAllBlockForWood(String name, WoodType woodType, TreeGrower treeGrower)
    {
        Map<String, DeferredBlock<Block>> map = new HashMap<>();
        map.put("log", registerBlock(name + "_log", () -> new LogBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())));
        map.put("stripped_log", registerBlock("stripped_" + name + "_log", () -> new LogBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())));
        map.put("wood", registerBlock(name + "_wood", () -> new LogBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())));
        map.put("stripped_wood", registerBlock("stripped_" + name + "_wood", () -> new LogBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava())));
        map.put("planks", registerBlock(name + "_planks", () -> new FlammableBlock(20, 5, BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava())));
        map.put("leaves", registerBlock(name + "_leaves", () -> new ModLeavesBlock(true, 60, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES))));
        map.put("stairs", registerBlock(name + "_stairs", () -> registerStair(() -> map.get("planks"))));
        map.put("slab", registerBlock(name + "_slab", () -> registerSlab(() -> map.get("planks"))));
        map.put("button", registerBlock(name + "_button", () -> registerButton(Blocks.OAK_BUTTON, BlockSetType.OAK, 30)));
        map.put("pressure_plate", registerBlock(name + "_pressure_plate", () -> registerPressurePlate(BlockSetType.OAK, () -> map.get("planks"))));
        map.put("fence", registerBlock(name + "_fence", () -> registerFence(() -> map.get("planks"))));
        map.put("fence_gate", registerBlock(name + "_fence_gate", () -> registerFenceGate(WoodType.OAK, () -> map.get("planks"))));
        map.put("door", registerBlock(name + "_door", () -> registerDoor(BlockSetType.OAK, () -> map.get("planks"))));
        map.put("trapdoor", registerBlock(name + "_trapdoor", () -> registerTrapdoor(BlockSetType.OAK, () -> map.get("planks"))));
        map.put("sign", registerBlockOnly(name + "_sign", () -> new ModStandingSignBlock(woodType, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava())));
        map.put("wall_sign", registerBlockOnly(name + "_wall_sign", () -> new ModWallSignBlock(woodType, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava())));
        map.put("hanging_sign", registerBlockOnly(name + "_hanging_sign", () -> new ModHangingSignBlock(woodType, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava())));
        map.put("wall_hanging_sign", registerBlockOnly(name + "_wall_hanging_sign", () -> new ModWallHangingSignBlock(woodType, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava())));
        map.put("sapling", registerBlock(name + "_sapling", () -> new SaplingBlock(treeGrower, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING))));
        map.put("potted_sapling", registerFlowerPot("potted_" + name + "_sapling", () -> map.get("sapling")));
        return map;
    }

    private static DeferredBlock<Block> registerFlowerPot(String name, Supplier<DeferredBlock<Block>> flowerBlock)
    {
        return BLOCKS.register(name, () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), flowerBlock.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM).noOcclusion()));
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

    private static DeferredBlock<Block> registerTallFlower(String name)
    {
        return registerBlock(name, () -> new TallFlowerBlock(BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollission()
                .instabreak()
                .sound(SoundType.GRASS)
                .offsetType(BlockBehaviour.OffsetType.XZ)
                .ignitedByLava()
                .pushReaction(PushReaction.DESTROY)));
    }

    public static void register(IEventBus modEventBus)
    {
        BLOCKS.register(modEventBus);
    }
}
