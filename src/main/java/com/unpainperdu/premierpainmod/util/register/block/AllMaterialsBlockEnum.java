package com.unpainperdu.premierpainmod.util.register.block;

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
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.villager_shelf.StandingVillagerShelf;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.villager_shelf.WallVillagerShelf;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

import static com.unpainperdu.premierpainmod.util.register.block.BlockRegister.litBlockEmission;

public class AllMaterialsBlockEnum
{
    public enum Material
    {
        OAK(Blocks.OAK_PLANKS),
        BIRCH(Blocks.BIRCH_PLANKS),
        SPRUCE(Blocks.SPRUCE_PLANKS),
        JUNGLE(Blocks.JUNGLE_PLANKS),
        ACACIA(Blocks.ACACIA_PLANKS),
        DARK_OAK(Blocks.DARK_OAK_PLANKS),
        MANGROVE(Blocks.MANGROVE_PLANKS),
        CHERRY(Blocks.CHERRY_PLANKS),
        BAMBOO(Blocks.BAMBOO_PLANKS),
        CRIMSON(Blocks.CRIMSON_PLANKS),
        WARPED(Blocks.WARPED_PLANKS),
        PALE_OAK(Blocks.OAK_PLANKS),
        STONE(Blocks.STONE),
        MOSSY_STONE(Blocks.MOSSY_COBBLESTONE),
        ANDESITE(Blocks.ANDESITE),
        DIORITE(Blocks.DIORITE),
        GRANITE(Blocks.GRANITE),
        PRISMARINE(Blocks.PRISMARINE),
        BLACKSTONE(Blocks.BLACKSTONE),
        PURPUR_BLOCK(Blocks.PURPUR_BLOCK),
        DEEPSLATE(Blocks.DEEPSLATE),
        TUFF(Blocks.TUFF),
        PACKED_MUD(Blocks.PACKED_MUD),
        SANDSTONE(Blocks.SANDSTONE),
        RED_SANDSTONE(Blocks.RED_SANDSTONE),
        QUARTZ_BLOCK(Blocks.QUARTZ_BLOCK),
        NETHER_BRICKS(Blocks.NETHER_BRICKS),
        BASALT(Blocks.BASALT),
        END_STONE(Blocks.END_STONE),
        COAL_BLOCK(Blocks.COAL_BLOCK),
        IRON_BLOCK(Blocks.IRON_BLOCK),
        GOLD_BLOCK(Blocks.GOLD_BLOCK),
        REDSTONE_BLOCK(Blocks.REDSTONE_BLOCK),
        EMERALD_BLOCK(Blocks.EMERALD_BLOCK),
        DIAMOND_BLOCK(Blocks.DIAMOND_BLOCK),
        COPPER_BLOCK(Blocks.COPPER_BLOCK),
        LAPIS_BLOCK(Blocks.LAPIS_BLOCK),
        NETHERITE_BLOCK(Blocks.NETHERITE_BLOCK),
        OBSIDIAN(Blocks.OBSIDIAN),
        AMETHYST_BLOCK(Blocks.AMETHYST_BLOCK),
        DRIPSTONE_BLOCK(Blocks.DRIPSTONE_BLOCK),
        BEDROCK(Blocks.BEDROCK),
        MOUNTAIN_CURRANT(ModBlockProperties.MOUNTAIN_CURRANT_GENERIC),
        MORICHE_PALM(ModBlockProperties.MORICHE_PALM_GENERIC),
        ACHIOTE(ModBlockProperties.ACHIOTE_GENERIC),
        WEEPING_WILLOW(ModBlockProperties.WEEPING_WILLOW_GENERIC),
        GYPSUM(ModBlockProperties.GYPSUM);

        private final BlockBehaviour.Properties properties;

        Material(BlockBehaviour baseBlockBehaviour)
        {
            this.properties = ModBlockProperties.getPropertiesCopy(baseBlockBehaviour.properties());
        }

        Material(BlockBehaviour.Properties properties)
        {
            this.properties = ModBlockProperties.getPropertiesCopy(properties);
        }

        public BlockBehaviour.Properties getProperties()
        {
            return this.properties;
        }

        @Override
        public String toString()
        {
            return super.toString().toLowerCase(Locale.ROOT);
        }
    }

    public enum Type
    {
        VILLAGER_STATUE(VillagerStatue::new),
        VILLAGER_PEDESTAL(VillagerPedestalBlock::new),
        VILLAGER_BRAZIER(properties -> new VillagerBrazier(properties.lightLevel(litBlockEmission(15)))),
        VILLAGER_TABLE(VillagerTableBlock::new),
        VILLAGER_CHAIR(VillagerChairBlock::new),
        VILLAGER_THRONE_CHAIR(VillagerThroneChairBlock::new),
        VILLAGER_DRAWER(VillagerDrawer::new),
        STANDING_VILLAGER_SHELF(StandingVillagerShelf::new),
        WALL_VILLAGER_SHELF(WallVillagerShelf::new),
        VILLAGER_BENCH(VillagerBench::new),
        VILLAGER_COUCH(VillagerCouch::new),
        VILLAGER_BREWING_STATION(VillagerBrewingStation::new),
        VILLAGER_MUSICAL_FRIDGE(VillagerMusicalFridgeBlock::new),
        VILLAGER_CHISELED_HEAD(properties -> new VillagerChiseledHead(properties.lightLevel(litBlockEmission(13)))),
        VILLAGER_DRY_TOILET(properties -> new VillagerDryToiletBlock(properties.noOcclusion()));

        private final Function<BlockBehaviour.Properties, Block> constructor;

        Type(Function<BlockBehaviour.Properties, Block> constructor)
        {
            this.constructor = constructor;
        }

        public Function<BlockBehaviour.Properties, Block> getContructor()
        {
            return constructor;
        }

        @Override
        public String toString()
        {
            return super.toString().toLowerCase(Locale.ROOT);
        }
    }

    public static List<Type> getAllTypeValues()
    {
        return Arrays.stream(Type.values()).toList();
    }

    public static List<Material> getAllMaterialValues()
    {
        return Arrays.stream(Material.values()).toList();
    }

    public static List<String> getAllTypeName()
    {
        return Arrays.stream(Type.values())
                .map(Object::toString)
                .toList();
    }

    public static List<String> getAllMaterialName()
    {
        return Arrays.stream(Material.values())
                .map(Object::toString)
                .toList();
    }

    public static DeferredBlock<Block> getAllMaterialBlock(Type type, Material material)
    {
        return BlockRegister.ALL_MATERIALS_MAP.get(material.toString() + "_" + type.toString());
    }

    public static List<DeferredBlock<Block>> getAllMaterialBlocks(Type type)
    {
        return Arrays.stream(Material.values()).map(mat -> BlockRegister.ALL_MATERIALS_MAP.get(mat.toString() + "_" + type.toString())).toList();
    }

    public static List<DeferredBlock<Block>> getAllMaterialBlocks(Material material)
    {
        return Arrays.stream(Material.values()).map(type -> BlockRegister.ALL_MATERIALS_MAP.get(material.toString() + "_" + type.toString())).toList();
    }
}