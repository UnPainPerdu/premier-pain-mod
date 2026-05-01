package com.unpainperdu.premierpainmod.util.register.block;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.crafting_block.CookingPotBlock;
import com.unpainperdu.premierpainmod.level.world.block.crafting_block.VillagerWorkshop;
import com.unpainperdu.premierpainmod.level.world.block.event_block.LibertyBlock;
import com.unpainperdu.premierpainmod.level.world.block.geology.*;
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
import com.unpainperdu.premierpainmod.util.register.Item.ItemRegister;
import com.unpainperdu.premierpainmod.util.type.ModWoodTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import static com.unpainperdu.premierpainmod.util.register.block.WoodBlockEnum.*;

public class BlockRegister
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PremierPainMod.MOD_ID);

    public static final Map<String, DeferredBlock<Block>> ALL_MATERIALS_MAP = createAllMaterialsBlocks();
    //geology
    //  gypsum
    public static final DeferredBlock<Block> GYPSUM = registerBlock("gypsum", AmethystBlock::new, ModBlockProperties.GYPSUM);
    public static final DeferredBlock<Block> GYPSUM_STAIRS = registerStair("gypsum_stairs", CrystalStairBlock::new, () -> GYPSUM);
    public static final DeferredBlock<Block> GYPSUM_SLAB = registerBlock("gypsum_slab", CrystalSlabBlock::new, ModBlockProperties.GYPSUM);
    public static final DeferredBlock<Block> GYPSUM_WALL = registerBlock("gypsum_wall", CrystalWallBlock::new, ModBlockProperties.GYPSUM);
    public static final DeferredBlock<Block> POINTED_GYPSUM = registerBlock("pointed_gypsum", PointedCrystalBlock::new, ModBlockProperties.GYPSUM_NO_OCLUSION);
    public static final DeferredBlock<Block> GYPSUM_CLUSTER = registerBlock("gypsum_cluster", GrowingCrystalCluster::new, ModBlockProperties.GYPSUM_NO_OCLUSION);
    public static final DeferredBlock<Block> CUTTED_GYPSUM = registerBlock("cutted_gypsum", AmethystBlock::new, ModBlockProperties.GYPSUM);
    public static final DeferredBlock<Block> POLISHED_GYPSUM = registerBlock("polished_gypsum", AmethystBlock::new, ModBlockProperties.GYPSUM);
    public static final DeferredBlock<Block> POLISHED_GYPSUM_STAIRS = registerStair("polished_gypsum_stairs", CrystalStairBlock::new, () -> POLISHED_GYPSUM);
    public static final DeferredBlock<Block> POLISHED_GYPSUM_SLAB = registerBlock("polished_gypsum_slab", CrystalSlabBlock::new, ModBlockProperties.GYPSUM);
    public static final DeferredBlock<Block> POLISHED_GYPSUM_WALL = registerBlock("polished_gypsum_wall", CrystalWallBlock::new, ModBlockProperties.GYPSUM);
    //crafting_block
    public static final DeferredBlock<Block> VILLAGER_WORKSHOP = registerBlock("villager_workshop", VillagerWorkshop::new, ModBlockProperties.VILLAGER_WORKSHOP);
    public static final DeferredBlock<Block> COOKING_POT_BLOCK = registerBlock("cooking_pot_block", CookingPotBlock::new, ModBlockProperties.COOKING_POT_BLOCK);
    //villager Singing stone event block
    public static final DeferredBlock<Block> LIBERTY_BLOCK = registerBlock("liberty_block", LibertyBlock::new, ModBlockProperties.LIBERTY_BLOCK);
    //vegetation
    //  misc
    public static final DeferredBlock<Block> FLOWERED_CACTUS_BLOCK = registerBlock("flowered_cactus_block", FloweredCactusBlock::new, ModBlockProperties.FLOWERED_CACTUS_BLOCK);
    public static final DeferredBlock<Block> CACTUS_FLOWER_BLOCK = registerBlock("cactus_flower_block", CactusFlowerBlock::new, ModBlockProperties.CACTUS_FLOWER_BLOCK);
    public static final DeferredBlock<Block> POTTED_CACTUS_FLOWER_BLOCK = registerFlowerPot("potted_cactus_flower_block", () -> CACTUS_FLOWER_BLOCK);
    public static final DeferredBlock<Block> SKY_SPEARS = registerBlock("sky_spears", SkySpears::new, ModBlockProperties.SKY_SPEARS);
    public static final DeferredBlock<Block> SKY_SPEARS_FLOWER = registerBlock("sky_spears_flower", SkySpearsFlower::new, ModBlockProperties.SKY_SPEARS);
    public static final DeferredBlock<Block> POTTED_SKY_SPEARS_FLOWER = registerFlowerPot("potted_sky_spears_flower", () -> SKY_SPEARS_FLOWER);
    public static final DeferredBlock<Block> DEAD_TALL_BUSH = registerBlock("dead_tall_bush", DeadTallGrass::new, ModBlockProperties.DEAD_TALL_BUSH);
    public static final DeferredBlock<Block> OLD_WILD_WHEAT = registerBlock("old_wild_wheat", BasicTallGrassBlock::new, ModBlockProperties.OLD_WILD_WHEAT);
    //  cropLike
    public static final DeferredBlock<Block> JELLYSHROOM = registerBlock("jellyshroom", JellyShroomBlock::new, ModBlockProperties.JELLYSHROOM);
    public static final DeferredBlock<Block> POTTED_JELLYSHROOM = registerFlowerPot("potted_jellyshroom", () -> JELLYSHROOM);
    /*  1 block flower
        - flower block
        - flower pot
        */
    public static final DeferredBlock<Block> RUINS_FLOWER = registerBlock("ruins_flower", p -> new FlowerBlock(MobEffects.WITHER, 5, p), ModBlockProperties.BASIC_FLOWER);
    public static final DeferredBlock<Block> POTTED_RUINS_FLOWER = registerFlowerPot("potted_ruins_flower", () -> RUINS_FLOWER);
    public static final DeferredBlock<Block> CIVILIZATIONS_FLOWER = registerBlock("civilizations_flower", CivilizationsFlowerBlock::new, ModBlockProperties.BASIC_FLOWER);
    public static final DeferredBlock<Block> POTTED_CIVILIZATIONS_FLOWER = registerFlowerPot("potted_civilizations_flower", () -> CIVILIZATIONS_FLOWER);
    public static final DeferredBlock<Block> CURIOSITY_FLOWER = registerBlock("curiosity_flower", p -> new CuriosityFlower(MobEffects.INVISIBILITY, 15, p), ModBlockProperties.BASIC_FLOWER);
    public static final DeferredBlock<Block> POTTED_CURIOSITY_FLOWER = registerFlowerPot("potted_curiosity_flower", () -> CURIOSITY_FLOWER);
    //  2 blocks tall flower
    public static final DeferredBlock<Block> FALLING_HELICON_FLOWER = registerBlock("falling_helicon_flower", TallFlowerBlock::new, ModBlockProperties.BASIC_TALL_FLOWER);
    //  dead bush like
    public static final DeferredBlock<Block> DEAD_RUINS_FLOWER = registerBlock("dead_ruins_flower", DeadBushBlock::new, ModBlockProperties.DEAD_RUINS_FLOWER);
    public static final DeferredBlock<Block> POTTED_DEAD_RUINS_FLOWER = registerFlowerPot("potted_dead_ruins_flower", () -> DEAD_RUINS_FLOWER);
    //  tree
    public static final Map<String, DeferredBlock<Block>> MOUNTAIN_CURRANT_WOOD_TYPE_MAP = generateAllBlockForWood("mountain_currant", ModWoodTypes.MOUNTAIN_CURRANT, ModTreeGrower.MOUNTAIN_CURRANT, true, ModBlockProperties.MOUNTAIN_CURRANT_GENERIC);
    public static final Map<String, DeferredBlock<Block>> MORICHE_PALM_WOOD_TYPE_MAP = generateAllBlockForWood("moriche_palm", ModWoodTypes.MORICHE_PALM, ModTreeGrower.MORICHE_PALM, false, ModBlockProperties.MORICHE_PALM_GENERIC);
    public static final Map<String, DeferredBlock<Block>> ACHIOTE_WOOD_TYPE_MAP = generateAllBlockForWood("achiote", ModWoodTypes.ACHIOTE, ModTreeGrower.ACHIOTE, true, ModBlockProperties.ACHIOTE_GENERIC);
    public static final Map<String, DeferredBlock<Block>> WEEPING_WILLOW_WOOD_TYPE_MAP = generateAllBlockForWood("weeping_willow", ModWoodTypes.WEEPING_WILLOW, ModTreeGrower.WEEPING_WILLOW, false, ModBlockProperties.WEEPING_WILLOW_GENERIC);
    public static final DeferredBlock<Block> FALLING_WEEPING_WILLOW_LEAVES = registerBlock("falling_weeping_willow_leaves", FallingLeavesBlock::new, ModBlockProperties.FALLING_WEEPING_WILLOW_LEAVES);

    private static Map<String, DeferredBlock<Block>> createAllMaterialsBlocks()
    {
        Map<String, DeferredBlock<Block>> map = new HashMap<>();

        for (AllMaterialsBlockEnum.Type blockType : AllMaterialsBlockEnum.getAllTypeValues())
        {
            for (AllMaterialsBlockEnum.Material material : AllMaterialsBlockEnum.getAllMaterialValues())
            {
                String id = material.toString() + "_" + blockType;
                if (blockType == AllMaterialsBlockEnum.Type.WALL_VILLAGER_SHELF || blockType == AllMaterialsBlockEnum.Type.STANDING_VILLAGER_SHELF)
                {
                    map.put(id, registerBlockOnly(id, blockType.getContructor(), material.getProperties()));
                }
                else
                {
                    map.put(id, registerBlock(id, blockType.getContructor(), material.getProperties()));
                }
            }
        }
        return map;
    }

    public static ToIntFunction<BlockState> litBlockEmission(int lightValue)
    {
        return state ->
        {
            int finalLightValue = 0;
            if (!state.hasProperty(BlockStateProperties.LIT))
            {
                finalLightValue = lightValue;

            }
            else if (state.getValue(BlockStateProperties.LIT))
            {
                finalLightValue = lightValue;
            }
            return finalLightValue;
        };
    }

    private static Map<String, DeferredBlock<Block>> generateAllBlockForWood(String name, WoodType woodType, TreeGrower treeGrower, boolean canHaveFruit, BlockBehaviour.Properties planksProperties)
    {
        //TODO Map<aEnum, ....
        Map<String, DeferredBlock<Block>> map = new HashMap<>();
        map.put(LOG.toString(), registerBlock(name + "_log", LogBlock::new, planksProperties));
        map.put(STRIPPED_LOG.toString(), registerBlock("stripped_" + name + "_log", LogBlock::new, planksProperties));
        map.put(WOOD.toString(), registerBlock(name + "_wood", LogBlock::new, planksProperties));
        map.put(STRIPPED_WOOD.toString(), registerBlock("stripped_" + name + "_wood", LogBlock::new, planksProperties));
        map.put(PLANKS.toString(), registerBlock(name + "_planks", p -> new FlammableBlock(20, 5, p), planksProperties));
        map.put(LEAVES.toString(), registerBlock(name + "_leaves", p -> new ModLeavesBlock(canHaveFruit, 60, 30, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
        map.put(STAIRS.toString(), registerStair(name + "_stairs", StairBlock::new, () -> map.get(PLANKS.toString())));
        map.put(SLAB.toString(), registerBlock(name + "_slab", SlabBlock::new, planksProperties));
        map.put(BUTTON.toString(), registerBlock(name + "_button", p -> new ButtonBlock(woodType.setType(), 30, p), planksProperties));
        map.put(PRESSURE_PLATE.toString(), registerBlock(name + "_pressure_plate", p -> new PressurePlateBlock(woodType.setType(), p), planksProperties));
        map.put(FENCE.toString(), registerBlock(name + "_fence", FenceBlock::new, planksProperties));
        map.put(FENCE_GATE.toString(), registerBlock(name + "_fence_gate", p -> new FenceGateBlock(woodType, p), planksProperties));
        map.put(DOOR.toString(), registerBlock(name + "_door", p -> new DoorBlock(woodType.setType(), p), planksProperties));
        map.put(TRAPDOOR.toString(), registerBlock(name + "_trapdoor", p -> new TrapDoorBlock(woodType.setType(), p), planksProperties));
        BlockBehaviour.Properties signProperties = ModBlockProperties.getPropertiesCopy(planksProperties).forceSolidOn().noCollission().strength(1.0F);
        map.put(SIGN.toString(), registerBlockOnly(name + "_sign", p -> new ModStandingSignBlock(woodType, p), signProperties));
        map.put(WALL_SIGN.toString(), registerBlockOnly(name + "_wall_sign", p -> new ModWallSignBlock(woodType, p), signProperties));
        map.put(HANGING_SIGN.toString(), registerBlockOnly(name + "_hanging_sign", p -> new ModHangingSignBlock(woodType, p), signProperties));
        map.put(WALL_HANGING_SIGN.toString(), registerBlockOnly(name + "_wall_hanging_sign", p -> new ModWallHangingSignBlock(woodType, p), signProperties));
        map.put(SAPLING.toString(), registerBlock(name + "_sapling", p -> new SaplingBlock(treeGrower, p), ModBlockProperties.SAPLING));
        map.put(POTTED_SAPLING.toString(), registerFlowerPot("potted_" + name + "_sapling", () -> map.get(SAPLING.toString())));
        LogBlock.registerNewWoodType(map);
        return map;
    }

    private static DeferredBlock<Block> registerFlowerPot(String name, Supplier<DeferredBlock<Block>> flowerBlock)
    {
        return BLOCKS.registerBlock(name, p -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), flowerBlock.get(), p), ModBlockProperties.BASIC_POT);
    }

    private static DeferredBlock<Block> registerStair(String name, BiFunction<BlockState, BlockBehaviour.Properties, ? extends StairBlock> stairConstructor, Supplier<DeferredBlock<Block>> baseBlock)
    {
        return registerBlock(name, p -> stairConstructor.apply(baseBlock.get().get().defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(baseBlock.get().get()));
    }

    private static DeferredBlock<Block> registerBlockOnly(String name, Function<BlockBehaviour.Properties, ? extends Block> blockConstructor, BlockBehaviour.Properties properties)
    {
        return BLOCKS.registerBlock(name, blockConstructor, properties);
    }

    private static void registerBlockItem(String name, Supplier<Block> block)
    {
        ItemRegister.ITEMS.registerItem(name, p -> new BlockItem(block.get(), p), new Item.Properties().useBlockDescriptionPrefix());
    }

    private static DeferredBlock<Block> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends Block> blockConstructor, BlockBehaviour.Properties properties)
    {
        DeferredBlock<Block> madeBlock = registerBlockOnly(name, blockConstructor, properties);
        registerBlockItem(name, madeBlock);
        return madeBlock;
    }

    public static void register(IEventBus modEventBus)
    {
        BLOCKS.register(modEventBus);
    }
}