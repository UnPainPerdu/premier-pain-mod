package com.unpainperdu.premierpainmod.datagen.asset.model;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.VillagerTableBlock;
import com.unpainperdu.premierpainmod.level.world.block.VillagerWorkshop;
import com.unpainperdu.premierpainmod.level.world.block.state.properties.VillagerWorkshopPart;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.data.PackOutput;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GameMasterBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class ModBlockStateProvider extends BlockStateProvider
{
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, PremierPainMod.MODID, existingFileHelper);
    }


    @Override
    protected void registerStatesAndModels()
    {
        //test zone
        villagerTableWithItem(BlockRegister.TEST_BLOCK.get());
        //workshop
        villagerWorkshopWithItem(BlockRegister.VILLAGER_WORKSHOP.get());
        //villager statue
        villagerStatueWithItem(BlockRegister.OAK_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.BIRCH_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.SPRUCE_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.JUNGLE_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.ACACIA_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.DARK_OAK_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.MANGROVE_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.CHERRY_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.BAMBOO_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.CRIMSON_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.WARPED_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.STONE_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.MOSSY_STONE_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.ANDESITE_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.DIORITE_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.GRANITE_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.PRISMARINE_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.BLACKSTONE_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.PURPUR_BLOCK_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.DEEPSLATE_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.TUFF_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.PACKED_MUD_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.SANDSTONE_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.RED_SANDSTONE_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.QUARTZ_BLOCK_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.NETHER_BRICKS_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.BASALT_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.END_STONE_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.COAL_BLOCK_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.IRON_BLOCK_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.GOLD_BLOCK_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.REDSTONE_BLOCK_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.EMERALD_BLOCK_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.DIAMOND_BLOCK_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.COPPER_BLOCK_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.LAPIS_BLOCK_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.NETHERITE_BLOCK_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.OBSIDIAN_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.AMETHYST_BLOCK_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.DRIPSTONE_BLOCK_VILLAGER_STATUE.get());
        villagerStatueWithItem(BlockRegister.BEDROCK_VILLAGER_STATUE.get());
        //pedestal
        pedestalWithItem(BlockRegister.OAK_PEDESTAL.get());
        pedestalWithItem(BlockRegister.BIRCH_PEDESTAL.get());
        pedestalWithItem(BlockRegister.SPRUCE_PEDESTAL.get());
        pedestalWithItem(BlockRegister.JUNGLE_PEDESTAL.get());
        pedestalWithItem(BlockRegister.ACACIA_PEDESTAL.get());
        pedestalWithItem(BlockRegister.DARK_OAK_PEDESTAL.get());
        pedestalWithItem(BlockRegister.MANGROVE_PEDESTAL.get());
        pedestalWithItem(BlockRegister.CHERRY_PEDESTAL.get());
        pedestalWithItem(BlockRegister.BAMBOO_PEDESTAL.get());
        pedestalWithItem(BlockRegister.CRIMSON_PEDESTAL.get());
        pedestalWithItem(BlockRegister.WARPED_PEDESTAL.get());
        pedestalWithItem(BlockRegister.STONE_PEDESTAL.get());
        pedestalWithItem(BlockRegister.MOSSY_STONE_PEDESTAL.get());
        pedestalWithItem(BlockRegister.ANDESITE_PEDESTAL.get());
        pedestalWithItem(BlockRegister.DIORITE_PEDESTAL.get());
        pedestalWithItem(BlockRegister.GRANITE_PEDESTAL.get());
        pedestalWithItem(BlockRegister.PRISMARINE_PEDESTAL.get());
        pedestalWithItem(BlockRegister.BLACKSTONE_PEDESTAL.get());
        pedestalWithItem(BlockRegister.PURPUR_BLOCK_PEDESTAL.get());
        pedestalWithItem(BlockRegister.DEEPSLATE_PEDESTAL.get());
        pedestalWithItem(BlockRegister.TUFF_PEDESTAL.get());
        pedestalWithItem(BlockRegister.PACKED_MUD_PEDESTAL.get());
        pedestalWithItem(BlockRegister.SANDSTONE_PEDESTAL.get());
        pedestalWithItem(BlockRegister.RED_SANDSTONE_PEDESTAL.get());
        pedestalWithItem(BlockRegister.QUARTZ_BLOCK_PEDESTAL.get());
        pedestalWithItem(BlockRegister.NETHER_BRICKS_PEDESTAL.get());
        pedestalWithItem(BlockRegister.BASALT_PEDESTAL.get());
        pedestalWithItem(BlockRegister.END_STONE_PEDESTAL.get());
        pedestalWithItem(BlockRegister.COAL_BLOCK_PEDESTAL.get());
        pedestalWithItem(BlockRegister.IRON_BLOCK_PEDESTAL.get());
        pedestalWithItem(BlockRegister.GOLD_BLOCK_PEDESTAL.get());
        pedestalWithItem(BlockRegister.REDSTONE_BLOCK_PEDESTAL.get());
        pedestalWithItem(BlockRegister.EMERALD_BLOCK_PEDESTAL.get());
        pedestalWithItem(BlockRegister.DIAMOND_BLOCK_PEDESTAL.get());
        pedestalWithItem(BlockRegister.COPPER_BLOCK_PEDESTAL.get());
        pedestalWithItem(BlockRegister.LAPIS_BLOCK_PEDESTAL.get());
        pedestalWithItem(BlockRegister.NETHERITE_BLOCK_PEDESTAL.get());
        pedestalWithItem(BlockRegister.OBSIDIAN_PEDESTAL.get());
        pedestalWithItem(BlockRegister.AMETHYST_BLOCK_PEDESTAL.get());
        pedestalWithItem(BlockRegister.DRIPSTONE_BLOCK_PEDESTAL.get());
        pedestalWithItem(BlockRegister.BEDROCK_PEDESTAL.get());
        //brazier
        villagerBrazierWithItem(BlockRegister.OAK_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.BIRCH_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.SPRUCE_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.JUNGLE_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.ACACIA_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.DARK_OAK_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.MANGROVE_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.CHERRY_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.BAMBOO_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.CRIMSON_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.WARPED_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.STONE_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.MOSSY_STONE_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.ANDESITE_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.DIORITE_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.GRANITE_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.PRISMARINE_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.BLACKSTONE_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.PURPUR_BLOCK_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.DEEPSLATE_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.TUFF_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.PACKED_MUD_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.SANDSTONE_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.RED_SANDSTONE_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.QUARTZ_BLOCK_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.NETHER_BRICKS_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.BASALT_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.END_STONE_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.COAL_BLOCK_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.IRON_BLOCK_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.GOLD_BLOCK_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.REDSTONE_BLOCK_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.EMERALD_BLOCK_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.DIAMOND_BLOCK_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.COPPER_BLOCK_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.LAPIS_BLOCK_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.NETHERITE_BLOCK_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.OBSIDIAN_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.AMETHYST_BLOCK_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.DRIPSTONE_BLOCK_VILLAGER_BRAZIER.get());
        villagerBrazierWithItem(BlockRegister.BEDROCK_VILLAGER_BRAZIER.get());
        //table
        villagerTableWithItem(BlockRegister.OAK_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.BIRCH_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.SPRUCE_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.JUNGLE_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.ACACIA_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.DARK_OAK_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.MANGROVE_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.CHERRY_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.BAMBOO_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.CRIMSON_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.WARPED_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.STONE_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.MOSSY_STONE_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.ANDESITE_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.DIORITE_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.GRANITE_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.PRISMARINE_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.BLACKSTONE_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.PURPUR_BLOCK_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.DEEPSLATE_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.TUFF_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.PACKED_MUD_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.SANDSTONE_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.RED_SANDSTONE_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.QUARTZ_BLOCK_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.NETHER_BRICKS_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.BASALT_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.END_STONE_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.COAL_BLOCK_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.IRON_BLOCK_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.GOLD_BLOCK_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.REDSTONE_BLOCK_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.EMERALD_BLOCK_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.DIAMOND_BLOCK_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.COPPER_BLOCK_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.LAPIS_BLOCK_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.NETHERITE_BLOCK_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.OBSIDIAN_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.AMETHYST_BLOCK_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.DRIPSTONE_BLOCK_VILLAGER_TABLE.get());
        villagerTableWithItem(BlockRegister.BEDROCK_VILLAGER_TABLE.get());
    }
    private void simpleBlockWithItem(Block block)
    {
        simpleBlockWithItem(block, cubeAll(block));
    }
    private void pedestalWithItem(Block pedestal)
    {
        String pedestaleName = BuiltInRegistries.BLOCK.getKey(pedestal).toString().replace(PremierPainMod.MODID+":","");
        ModelFile pedestalModel = models().withExistingParent(key(pedestal).toString(),"premierpainmod:block/villager_pedestal").texture("0","block/villager_pedestal/" + pedestaleName);
        simpleBlock(pedestal, pedestalModel);
        itemModels().getBuilder(key(pedestal).getPath()).parent(pedestalModel);
    }
    private void villagerStatueWithItem(Block statue)
    {
        String statueName = BuiltInRegistries.BLOCK.getKey(statue).toString().replace(PremierPainMod.MODID+":","");
        // Get a variant block state builder.
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(statue);
        // Create a partial state and set properties on it.
        VariantBlockStateBuilder.PartialBlockstate partialState = variantBuilder.partialState();
        // Alternatively, forAllStates(Function<BlockState, ConfiguredModel[]>) creates a model for every state.
        // The passed function will be called once for each possible state.
        variantBuilder.forAllStates(state ->
        {
                    if(state.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF ) == DoubleBlockHalf.LOWER)
                    {
                        // Return a ConfiguredModel depending on the state's properties.
                        // For example, the following code will rotate the model depending on the horizontal rotation of the block.
                        return ConfiguredModel.builder()
                                .modelFile(models().withExistingParent(key(statue).toString()+"_bottom","premierpainmod:block/villager_statue/villager_statue_bottom").texture("0","block/villager_statue/" + statueName + "_bottom"))
                                .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                                .build();
                    }
                    else
                    {
                        return ConfiguredModel.builder()
                                .modelFile(models().withExistingParent(key(statue).toString()+"_upper","premierpainmod:block/villager_statue/villager_statue_upper").texture("0","block/villager_statue/" + statueName + "_upper"))
                                .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                                .build();
                    }
        });
        itemModels().getBuilder((key(statue).getPath()).replace("premierpainmod:block/","premierpainmod:item/"))
                .parent(models()
                        .getExistingFile(mcLoc("item/generated")))
                .texture("layer0","item/villager_statue/" + statueName);
    }
    private void villagerWorkshopWithItem(Block villagerWorkshop)
    {
        // Get a variant block state builder.
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(villagerWorkshop);
        // Create a partial state and set properties on it.
        VariantBlockStateBuilder.PartialBlockstate partialState = variantBuilder.partialState();
        // Alternatively, forAllStates(Function<BlockState, ConfiguredModel[]>) creates a model for every state.
        // The passed function will be called once for each possible state.
        variantBuilder.forAllStates(state ->
        {
            if(state.getValue(VillagerWorkshop.PART) == VillagerWorkshopPart.RIGHT)
            {
                // Return a ConfiguredModel depending on the state's properties.
                // For example, the following code will rotate the model depending on the horizontal rotation of the block.
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(key(villagerWorkshop).toString()+"_right","premierpainmod:block/villager_workshop/villager_workshop_right_m"))
                        .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                        .build();
            }
            else
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(key(villagerWorkshop).toString()+"_left","premierpainmod:block/villager_workshop/villager_workshop_left_m"))
                        .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                        .build();
            }
        });
        String villagerWorkshopName = BuiltInRegistries.BLOCK.getKey(villagerWorkshop).toString().replace(PremierPainMod.MODID+":","");
        ModelFile villagerWorkshopModel = models().withExistingParent(key(villagerWorkshop).toString(),"premierpainmod:block/villager_workshop/villager_workshop_m");
        itemModels().getBuilder(key(villagerWorkshop).getPath()).parent(villagerWorkshopModel);
    }
    private void villagerBrazierWithItem(Block brazier)
    {
        String brazierName = BuiltInRegistries.BLOCK.getKey(brazier).toString().replace(PremierPainMod.MODID+":","");
        // Get a variant block state builder.
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(brazier);
        // Create a partial state and set properties on it.
        VariantBlockStateBuilder.PartialBlockstate partialState = variantBuilder.partialState();
        // Alternatively, forAllStates(Function<BlockState, ConfiguredModel[]>) creates a model for every state.
        // The passed function will be called once for each possible state.
        variantBuilder.forAllStates(state ->
        {
            if(state.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF ) == DoubleBlockHalf.LOWER)
            {
                // Return a ConfiguredModel depending on the state's properties.
                // For example, the following code will rotate the model depending on the horizontal rotation of the block.
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(key(brazier).toString()+"_bottom","premierpainmod:block/villager_brazier/villager_brazier_bottom").texture("0","block/villager_brazier/" + brazierName + "_bottom"))
                        .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                        .build();
            }
            else
            {
                if(state.getValue(BlockStateProperties.LIT ) == TRUE)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(key(brazier).toString() + "_upper_lit", "premierpainmod:block/villager_brazier/villager_brazier_upper_lit").texture("0","block/villager_brazier/" + brazierName + "_upper"))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(key(brazier).toString() + "_upper_unlit", "premierpainmod:block/villager_brazier/villager_brazier_upper_unlit").texture("0","block/villager_brazier/" + brazierName + "_upper"))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
            }
        });

        ModelFile brazierModel = models().withExistingParent(key(brazier).toString()+"_m","premierpainmod:block/villager_brazier/villager_brazier_m");
        itemModels().getBuilder(key(brazier).getPath()).parent(brazierModel).texture("3","block/villager_brazier/" + brazierName + "_upper").texture("2","block/villager_brazier/" + brazierName + "_bottom");
    }

    private void villagerTableWithItem(Block table)
    {
        String villagerTableName = BuiltInRegistries.BLOCK.getKey(table).toString().replace(PremierPainMod.MODID+":","");
        // Get a variant block state builder.
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(table);
        // Create a partial state and set properties on it.
        VariantBlockStateBuilder.PartialBlockstate partialState = variantBuilder.partialState();
        // Alternatively, forAllStates(Function<BlockState, ConfiguredModel[]>) creates a model for every state.
        // The passed function will be called once for each possible state.
        variantBuilder.forAllStates(state ->
        {
            //Duo part
                //North only
            if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(key(table).toString()+"_duo_n","premierpainmod:block/villager_table/villager_table_duo").texture("0","block/villager_table/" + villagerTableName))
                        .rotationY(270)
                        .build();
            }
                //West only
            if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(key(table).toString()+"_duo_w","premierpainmod:block/villager_table/villager_table_duo").texture("0","block/villager_table/" + villagerTableName))
                        .rotationY(180)
                        .build();
            }
                //South only
            if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(key(table).toString()+"_duo_s","premierpainmod:block/villager_table/villager_table_duo").texture("0","block/villager_table/" + villagerTableName))
                        .rotationY(90)
                        .build();
            }
                //East only
            if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(key(table).toString()+"_duo_e","premierpainmod:block/villager_table/villager_table_duo").texture("0","block/villager_table/" + villagerTableName))
                        .rotationY(0)
                        .build();
            }
            //Trio Part
                //N S
            if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(key(table).toString()+"_trio_ns","premierpainmod:block/villager_table/villager_table_trio_line").texture("0","block/villager_table/" + villagerTableName))
                        .rotationY(90)
                        .build();
            }
                //W E
            if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(key(table).toString()+"_trio_we","premierpainmod:block/villager_table/villager_table_trio_line").texture("0","block/villager_table/" + villagerTableName))
                        .rotationY(0)
                        .build();
            }
                //N W
            if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(key(table).toString()+"_trio_nw","premierpainmod:block/villager_table/villager_table_trio_angle").texture("0","block/villager_table/" + villagerTableName))
                        .rotationY(180)
                        .build();
            }
                //N E
            if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(key(table).toString()+"_trio_ne","premierpainmod:block/villager_table/villager_table_trio_angle").texture("0","block/villager_table/" + villagerTableName))
                        .rotationY(270)
                        .build();
            }
                //S W
            if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(key(table).toString()+"_trio_sw","premierpainmod:block/villager_table/villager_table_trio_angle").texture("0","block/villager_table/" + villagerTableName))
                        .rotationY(90)
                        .build();
            }
                //S E
            if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(key(table).toString()+"_trio_se","premierpainmod:block/villager_table/villager_table_trio_angle").texture("0","block/villager_table/" + villagerTableName))
                        .rotationY(0)
                        .build();
            }
            //Quatuor Part
                //N E S
            if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(key(table).toString()+"_quatuor_nes","premierpainmod:block/villager_table/villager_table_quatuor").texture("0","block/villager_table/" + villagerTableName))
                        .rotationY(270)
                        .build();
            }
                //E S W
            if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(key(table).toString()+"_quatuor_esw","premierpainmod:block/villager_table/villager_table_quatuor").texture("0","block/villager_table/" + villagerTableName))
                        .rotationY(0)
                        .build();
            }
                //S W N
            if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(key(table).toString()+"_quatuor_swn","premierpainmod:block/villager_table/villager_table_quatuor").texture("0","block/villager_table/" + villagerTableName))
                        .rotationY(90)
                        .build();
            }
                //W N E
            if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(key(table).toString()+"_quatuor_wne","premierpainmod:block/villager_table/villager_table_quatuor").texture("0","block/villager_table/" + villagerTableName))
                        .rotationY(180)
                        .build();
            }
            //total part
            if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(key(table).toString()+"_pentuor","premierpainmod:block/villager_table/villager_table_pentuor").texture("0","block/villager_table/" + villagerTableName))
                        .rotationY(0)
                        .build();
            }
            //solo
            else
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(key(table).toString()+"_solo","premierpainmod:block/villager_table/villager_table_solo").texture("0","block/villager_table/" + villagerTableName))
                        .rotationY(0)
                        .build();
            }
        });
        ModelFile villagerWorkshopModel = models().withExistingParent(key(table).toString(),"premierpainmod:block/villager_table/villager_table_solo").texture("0","block/villager_table/" + villagerTableName);
        itemModels().getBuilder(key(table).getPath()).parent(villagerWorkshopModel);
    }

    private ResourceLocation key(Block block)
    {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
}
