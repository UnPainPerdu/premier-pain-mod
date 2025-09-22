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
    private AllMaterialsBlockEnum()
    {
    }

    public enum Material
    {
        OAK(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()),
        BIRCH(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion()),
        SPRUCE(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion()),
        JUNGLE(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion()),
        ACACIA(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()),
        DARK_OAK(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()),
        MANGROVE(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()),
        CHERRY(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()),
        BAMBOO(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()),
        CRIMSON(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()),
        WARPED(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()),
        PALE_OAK(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()),
        STONE(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()),
        MOSSY_STONE(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSSY_COBBLESTONE).noOcclusion()),
        ANDESITE(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE).noOcclusion()),
        DIORITE(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE).noOcclusion()),
        GRANITE(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE).noOcclusion()),
        PRISMARINE(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE).noOcclusion()),
        BLACKSTONE(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).noOcclusion()),
        PURPUR_BLOCK(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK).noOcclusion()),
        DEEPSLATE(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).noOcclusion()),
        TUFF(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF).noOcclusion()),
        PACKED_MUD(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD).noOcclusion()),
        SANDSTONE(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).noOcclusion()),
        RED_SANDSTONE(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE).noOcclusion()),
        QUARTZ_BLOCK(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion()),
        NETHER_BRICKS(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS).noOcclusion()),
        BASALT(BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT).noOcclusion()),
        END_STONE(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).noOcclusion()),
        COAL_BLOCK(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK).noOcclusion()),
        IRON_BLOCK(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()),
        GOLD_BLOCK(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK).noOcclusion()),
        REDSTONE_BLOCK(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK).noOcclusion()),
        EMERALD_BLOCK(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK).noOcclusion()),
        DIAMOND_BLOCK(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).noOcclusion()),
        COPPER_BLOCK(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).noOcclusion()),
        LAPIS_BLOCK(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK).noOcclusion()),
        NETHERITE_BLOCK(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).noOcclusion()),
        OBSIDIAN(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).noOcclusion()),
        AMETHYST_BLOCK(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).noOcclusion()),
        DRIPSTONE_BLOCK(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK).noOcclusion()),
        BEDROCK(BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK).noOcclusion()),
        MOUNTAIN_CURRANT(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()),
        MORICHE_PALM(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()),
        ACHIOTE(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()),
        WEEPING_WILLOW(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());

        private final BlockBehaviour.Properties properties;

        Material(BlockBehaviour.Properties properties)
        {
            this.properties = properties;
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
        VILLAGER_BRAZIER(properties -> new VillagerBrazier(Boolean.TRUE, 1, properties.lightLevel(litBlockEmission(15)))),
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
        VILLAGER_DRY_TOILET(VillagerDryToiletBlock::new);

        private final Function<BlockBehaviour.Properties, Block> block;

        Type(Function<BlockBehaviour.Properties, Block> block)
        {
            this.block = block;
        }

        public Block getBlock(BlockBehaviour.Properties properties)
        {
            return block.apply(properties);
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
}
