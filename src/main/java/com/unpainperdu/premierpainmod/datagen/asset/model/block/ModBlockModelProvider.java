package com.unpainperdu.premierpainmod.datagen.asset.model.block;

import com.unpainperdu.premierpainmod.level.world.block.geology.GrowingCrystalCluster;
import com.unpainperdu.premierpainmod.level.world.block.geology.PointedCrystalBlock;
import com.unpainperdu.premierpainmod.util.register.block.AllMaterialsBlockEnum;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.registries.DeferredBlock;

import static com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil.createResourceLocation;
import static com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil.getModName;
import static net.minecraft.client.data.models.BlockModelGenerators.createSimpleBlock;

public class ModBlockModelProvider
{
    public static void generate(BlockModelGenerators blockModels)
    {
        generateTallFlowers(blockModels, BlockRegister.FALLING_HELICON_FLOWER);
        //all_materials
        /*
        generateVillagerStatueWithItem(blockModels);
        generateVillagerPedestalWithItem(blockModels);
        generateVillagerBrazierWithItem(blockModels);
         */

        //old
        /*
        for (Block block : ModBLockList.ALL_BLOCKS)
        {
            switch (block)
            {
                case VillagerTableBlock ignored -> villagerTableWithItem(block);
                case VillagerChairBlock ignored -> villagerChairWithItem(block);
                case VillagerThroneChairBlock ignored -> villagerThroneChairWithItem(block);
                case VillagerDrawer ignored -> villagerDrawerWithItem(block);
                case WallVillagerShelf ignored -> wallVillagerShelf(block);
                case StandingVillagerShelf ignored -> standingVillagerShelf(block);
                case FlowerBlock ignored -> flowerBlockWithItem(block);
                case AbstractGrowingAboveVegetation ignored -> growingVegetationWithItem(block);
                case DeadBushBlock ignored -> deadBushWithItem(block);
                case AbstractTallGrass ignored -> tallGrassWithItem(block);
                case VillagerBench ignored -> villagerBenchWithItem(block);
                case VillagerCouch ignored -> villagerCouchWithItem(block);
                case VillagerBrewingStation ignored -> villagerBrewingStationWithItem(block);
                case VillagerMusicalFridgeBlock ignored -> villagerMusicalFridgeBlockWithItem(block);
                case VillagerChiseledHead ignored -> villagerChiseledHeadBlockWithItem(block);
                case VillagerDryToiletBlock ignored -> villagerDryToiletBlockWithItem(block);
                case TallFlowerBlock ignored -> tallFlower(block);
                default ->
                {
                }
            }
        }

         */
        //manual
        //vegetation
        //tall grass
        skySpearsFlowerWithItem();
        skySpearsFlowerPotBlock();
        //crop
        jellyshroomWithItem();
        //misc
        cactusFlowerBlockWithItem();
        floweredCactusBlockWithItem();
        //potted thing
        //flower
        flowerPotBlock(BlockRegister.POTTED_RUINS_FLOWER.get(), BlockRegister.RUINS_FLOWER.get());
        flowerPotBlockForGrowingVegetation(BlockRegister.POTTED_CIVILIZATIONS_FLOWER.get(), BlockRegister.CIVILIZATIONS_FLOWER.get());
        flowerPotBlock(BlockRegister.POTTED_CURIOSITY_FLOWER.get(), BlockRegister.CURIOSITY_FLOWER.get());
        //dead bush
        deadBushPotBlock(BlockRegister.POTTED_DEAD_RUINS_FLOWER.get(), BlockRegister.DEAD_RUINS_FLOWER.get());
        //misc
        pottedFloweredCactus();
        //crop
        universalPottedBlockWithCustomModel(BlockRegister.POTTED_JELLYSHROOM.get(), "premierpainmod:block/vegetation/crop/jellyshroom/potted_jellyshroom");
        //tree
        WoodSetBlockStateProviderMethod woodProvider = new WoodSetBlockStateProviderMethod(this);
        woodProvider.allWoodBlocks("mountain_currant", true);
        woodProvider.allWoodBlocks("moriche_palm", false);
        woodProvider.allWoodBlocks("achiote", true);
        woodProvider.allWoodBlocks("weeping_willow", false);
        woodProvider.fallingLeaves(BlockRegister.FALLING_WEEPING_WILLOW_LEAVES.get(), "weeping_willow");
        //geology
        ResourceLocation gypsumTexture = createResourceLocation("block/geology/gypsum/gypsum");
        simpleBlockWithItem(BlockRegister.GYPSUM.get(), this.models().cubeAll(getModName(BlockRegister.GYPSUM.get()), gypsumTexture));
        stairWithItem(BlockRegister.GYPSUM_STAIRS.get(), gypsumTexture);
        slabWithItem(BlockRegister.GYPSUM_SLAB.get(), gypsumTexture);
        wallBlockWithItem(BlockRegister.GYPSUM_WALL.get(), gypsumTexture);
        ResourceLocation polishedGypsumTexture = createResourceLocation("block/geology/gypsum/polished_gypsum");
        simpleBlockWithItem(BlockRegister.POLISHED_GYPSUM.get(), this.models().cubeAll(getModName(BlockRegister.POLISHED_GYPSUM.get()), polishedGypsumTexture));
        stairWithItem(BlockRegister.POLISHED_GYPSUM_STAIRS.get(), polishedGypsumTexture);
        slabWithItem(BlockRegister.POLISHED_GYPSUM_SLAB.get(), polishedGypsumTexture);
        wallBlockWithItem(BlockRegister.POLISHED_GYPSUM_WALL.get(), polishedGypsumTexture);
        cuttedBlockWithItem(BlockRegister.CUTTED_GYPSUM.get(), "block/geology/gypsum/cutted_gypsum", "block/geology/gypsum/polished_gypsum");
        crystalClusterWithItem((GrowingCrystalCluster) BlockRegister.GYPSUM_CLUSTER.get(), "block/geology/gypsum/");
        pointedCrystalWithItem((PointedCrystalBlock) BlockRegister.POINTED_GYPSUM.get(), "block/geology/gypsum");
        //crafting_block
        villagerWorkshopWithItem();
        cookingPotBlockWithItem();
        //event block
        simpleBlockWithItemWithCustomModel(BlockRegister.LIBERTY_BLOCK.get(), "premierpainmod:block/event_block/liberty_block/liberty_block");
    }



    private static void createBlockWithModel(BlockModelGenerators blockModels, Block block, ResourceLocation model)
    {
        blockModels.blockStateOutput.accept(createSimpleBlock(block, model));
    }

    private static void generateTallFlowers(BlockModelGenerators blockModels, DeferredBlock<Block> block)
    {
        blockModels.createDoublePlantWithDefaultItem(block.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    }

    private static void generateVillagerStatueWithItem(BlockModelGenerators blockModels)
    {
        for (AllMaterialsBlockEnum.Material material : AllMaterialsBlockEnum.Material.values())
        {
            AllMaterialsBlockEnum.Type type = AllMaterialsBlockEnum.Type.VILLAGER_STATUE;
            ResourceLocation bottom = ModTexturedModel.VILLAGER_STATUE_MODEL_BOTTOM.create(material, type, blockModels.modelOutput);
            ResourceLocation top = ModTexturedModel.VILLAGER_STATUE_MODEL_TOP.create(material, type, blockModels.modelOutput);
            Block block = AllMaterialsBlockEnum.getAllMaterialBlock(type, material).get();

            blockModels.blockStateOutput.accept(
                    MultiVariantGenerator.multiVariant(block)
                            .with(
                                    PropertyDispatch.property(BlockStateProperties.DOUBLE_BLOCK_HALF)
                                            .select(
                                                    DoubleBlockHalf.LOWER,
                                                    Variant.variant().with(VariantProperties.MODEL, bottom)
                                            )
                                            .select(
                                                    DoubleBlockHalf.UPPER,
                                                    Variant.variant().with(VariantProperties.MODEL, top)
                                            )
                            )
                            .with(BlockModelGenerators.createHorizontalFacingDispatch())
            );
            blockModels.registerSimpleFlatItemModel(block);
        }
    }

    private static void generateVillagerPedestalWithItem(BlockModelGenerators blockModels)
    {
        for (AllMaterialsBlockEnum.Material material : AllMaterialsBlockEnum.Material.values())
        {
            AllMaterialsBlockEnum.Type type = AllMaterialsBlockEnum.Type.VILLAGER_PEDESTAL;
            ResourceLocation model = ModTexturedModel.VILLAGER_PEDESTAL.create(material, type, blockModels.modelOutput);
            Block block = AllMaterialsBlockEnum.getAllMaterialBlock(type, material).get();
            createBlockWithModel(blockModels, block, model);
            blockModels.registerSimpleItemModel(block.asItem(), model);
        }
    }

    private static void generateVillagerBrazierWithItem(BlockModelGenerators blockModels)
    {
        for (AllMaterialsBlockEnum.Material material : AllMaterialsBlockEnum.Material.values())
        {
            AllMaterialsBlockEnum.Type type = AllMaterialsBlockEnum.Type.VILLAGER_BRAZIER;
            ResourceLocation bottom = ModTexturedModel.VILLAGER_BRAZIER_BOTTOM.create(material, type, blockModels.modelOutput);
            ResourceLocation topUnlit = ModTexturedModel.VILLAGER_BRAZIER_UPPER_UNLIT.create(material, type, blockModels.modelOutput);
            ResourceLocation topLit = ModTexturedModel.VILLAGER_BRAZIER_UPPER_LIT.updateAllMaterialTemplate(template -> template.extend().renderType(ResourceLocation.withDefaultNamespace("cutout_mipped")).build()).create(material, type, blockModels.modelOutput);
            ResourceLocation item = ModTexturedModel.VILLAGER_BRAZIER_ITEM.create(material, type, blockModels.modelOutput);
            Block block = AllMaterialsBlockEnum.getAllMaterialBlock(type, material).get();

            blockModels.blockStateOutput.accept(
                    MultiVariantGenerator.multiVariant(block)
                            .with(
                                    PropertyDispatch.properties(
                                                    BlockStateProperties.DOUBLE_BLOCK_HALF,
                                                    BlockStateProperties.LIT
                                            )
                                            .select(
                                                    DoubleBlockHalf.LOWER,
                                                    false,
                                                    Variant.variant().with(VariantProperties.MODEL, bottom)
                                            )
                                            .select(
                                                    DoubleBlockHalf.LOWER,
                                                    true,
                                                    Variant.variant().with(VariantProperties.MODEL, bottom)
                                            )
                                            .select(
                                                    DoubleBlockHalf.UPPER,
                                                    false,
                                                    Variant.variant().with(VariantProperties.MODEL, topUnlit)
                                            )
                                            .select(
                                                    DoubleBlockHalf.UPPER,
                                                    true,
                                                    Variant.variant().with(VariantProperties.MODEL, topLit)
                                            )
                            )
                            .with(BlockModelGenerators.createHorizontalFacingDispatch())
            );
            blockModels.registerSimpleItemModel(block.asItem(), item);
        }
    }

    private static void generateVillagerTableWithItem(BlockModelGenerators blockModels)
    {
        //TODO carpeted not handled
        for (AllMaterialsBlockEnum.Material material : AllMaterialsBlockEnum.Material.values())
        {
            AllMaterialsBlockEnum.Type type = AllMaterialsBlockEnum.Type.VILLAGER_TABLE;
            ResourceLocation solo = ModTexturedModel.VILLAGER_TABLE_SOLO.create(material, type, blockModels.modelOutput);
            ResourceLocation duo = ModTexturedModel.VILLAGER_TABLE_DUO.create(material, type, blockModels.modelOutput);
            ResourceLocation trioLine = ModTexturedModel.VILLAGER_TABLE_TRIO_LINE.create(material, type, blockModels.modelOutput);
            ResourceLocation trioAngle = ModTexturedModel.VILLAGER_TABLE_TRIO_ANGLE.create(material, type, blockModels.modelOutput);
            ResourceLocation quantuor = ModTexturedModel.VILLAGER_TABLE_QUATUOR.create(material, type, blockModels.modelOutput);
            ResourceLocation pentuor = ModTexturedModel.VILLAGER_TABLE_PENTUOR.create(material, type, blockModels.modelOutput);
            Block block = AllMaterialsBlockEnum.getAllMaterialBlock(type, material).get();

            blockModels.blockStateOutput.accept(
                    MultiVariantGenerator.multiVariant(block)
                            .with(
                                    PropertyDispatch.property(BlockStateProperties.DOUBLE_BLOCK_HALF)
                                            .select(
                                                    DoubleBlockHalf.LOWER,
                                                    Variant.variant().with(VariantProperties.MODEL, bottom)
                                            )
                                            .select(
                                                    DoubleBlockHalf.UPPER,
                                                    Variant.variant().with(VariantProperties.MODEL, top)
                                            )
                            )
            );
            blockModels.registerSimpleFlatItemModel(block);
        }
    }

    //old
    /*
    private static void villagerTableWithItem(Block table)
    {
        String name = getModName(table);
        String material = name.replace("_villager_table", "");
        String textureTable = "block/all_materials_block/multiple_use_texture/" + material;
        String textureParticle = "block/all_materials_block/multiple_use_particle/" + material;

        VariantBlockStateBuilder variantBuilder = getVariantBuilder(table);
        variantBuilder.forAllStates(state ->
        {
            String carpetTexture = textureCarpetSelection(state.getValue(VillagerTableBlock.COLOR));
            String modelName = getKey(table).toString();
            String modelPath = "premierpainmod:block/all_materials_block/villager_table/";
            int rotation;
            boolean flag = (state.getValue(VillagerTableBlock.COLOR) == VillagerCarpetColor.NONE);
            //Duo part
            //North only
            if ((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                modelPath += "villager_table_duo/";
                rotation = 270;
                if (flag)
                {
                    modelName += "_duo_n";
                    modelPath += "villager_table_duo";
                }
                else
                {
                    modelName += "_duo_n_c" + nameModelCarpetSelection(state.getValue(VillagerTableBlock.COLOR));
                    modelPath += "villager_table_duo_carpeted";
                }
            }
            //West only
            else if ((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                modelPath += "villager_table_duo/";
                rotation = 180;
                if (flag)
                {
                    modelName += "_duo_w";
                    modelPath += "villager_table_duo";
                }
                else
                {
                    modelName += "_duo_w_c" + nameModelCarpetSelection(state.getValue(VillagerTableBlock.COLOR));
                    modelPath += "villager_table_duo_carpeted";
                }
            }
            //South only
            else if ((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                modelPath += "villager_table_duo/";
                rotation = 90;
                if (flag)
                {
                    modelName += "_duo_s";
                    modelPath += "villager_table_duo";
                }
                else
                {
                    modelName += "_duo_s_c" + nameModelCarpetSelection(state.getValue(VillagerTableBlock.COLOR));
                    modelPath += "villager_table_duo_carpeted";
                }
            }
            //East only
            else if ((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                modelPath += "villager_table_duo/";
                rotation = 0;
                if (flag)
                {
                    modelName += "_duo_e";
                    modelPath += "villager_table_duo";
                }
                else
                {
                    modelName += "_duo_e_c" + nameModelCarpetSelection(state.getValue(VillagerTableBlock.COLOR));
                    modelPath += "villager_table_duo_carpeted";
                }
            }
            //Trio Part
            //N S
            else if ((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                modelPath += "villager_table_trio/line/";
                rotation = 90;
                if (flag)
                {
                    modelName += "_trio_ns";
                    modelPath += "villager_table_trio_line";
                }
                else
                {
                    modelName += "_trio_ns_c" + nameModelCarpetSelection(state.getValue(VillagerTableBlock.COLOR));
                    modelPath += "villager_table_trio_line_carpeted";
                }
            }
            //W E
            else if ((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                modelPath += "villager_table_trio/line/";
                rotation = 0;
                if (flag)
                {
                    modelName += "_trio_we";
                    modelPath += "villager_table_trio_line";
                }
                else
                {
                    modelName += "_trio_we_c" + nameModelCarpetSelection(state.getValue(VillagerTableBlock.COLOR));
                    modelPath += "villager_table_trio_line_carpeted";
                }
            }
            //N W
            else if ((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                modelPath += "villager_table_trio/angle/";
                rotation = 180;
                if (flag)
                {
                    modelName += "_trio_nw";
                    modelPath += "villager_table_trio_angle";
                }
                else
                {
                    modelName += "_trio_nw_c" + nameModelCarpetSelection(state.getValue(VillagerTableBlock.COLOR));
                    modelPath += "villager_table_trio_angle_carpeted";
                }
            }
            //N E
            else if ((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                modelPath += "villager_table_trio/angle/";
                rotation = 270;
                if (flag)
                {
                    modelName += "_trio_ne";
                    modelPath += "villager_table_trio_angle";
                }
                else
                {
                    modelName += "_trio_ne_c" + nameModelCarpetSelection(state.getValue(VillagerTableBlock.COLOR));
                    modelPath += "villager_table_trio_angle_carpeted";
                }
            }
            //S W
            else if ((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                modelPath += "villager_table_trio/angle/";
                rotation = 90;
                if (flag)
                {
                    modelName += "_trio_sw";
                    modelPath += "villager_table_trio_angle";
                }
                else
                {
                    modelName += "_trio_sw_c" + nameModelCarpetSelection(state.getValue(VillagerTableBlock.COLOR));
                    modelPath += "villager_table_trio_angle_carpeted";
                }
            }
            //S E
            else if ((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                modelPath += "villager_table_trio/angle/";
                rotation = 0;
                if (flag)
                {
                    modelName += "_trio_se";
                    modelPath += "villager_table_trio_angle";
                }
                else
                {
                    modelName += "_trio_se_c" + nameModelCarpetSelection(state.getValue(VillagerTableBlock.COLOR));
                    modelPath += "villager_table_trio_angle_carpeted";
                }
            }
            //Quatuor Part
            //N E S
            else if ((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                modelPath += "villager_table_quatuor/";
                rotation = 270;
                if (flag)
                {
                    modelName += "_quatuor_nes";
                    modelPath += "villager_table_quatuor";
                }
                else
                {
                    modelName += "_quatuor_nes_c" + nameModelCarpetSelection(state.getValue(VillagerTableBlock.COLOR));
                    modelPath += "villager_table_quatuor_carpeted";
                }
            }
            //E S W
            else if ((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                modelPath += "villager_table_quatuor/";
                rotation = 0;
                if (flag)
                {
                    modelName += "_quatuor_esw";
                    modelPath += "villager_table_quatuor";
                }
                else
                {
                    modelName += "_quatuor_esw_c" + nameModelCarpetSelection(state.getValue(VillagerTableBlock.COLOR));
                    modelPath += "villager_table_quatuor_carpeted";
                }
            }
            //S W N
            else if ((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                modelPath += "villager_table_quatuor/";
                rotation = 90;
                if (flag)
                {
                    modelName += "_quatuor_swn";
                    modelPath += "villager_table_quatuor";
                }
                else
                {
                    modelName += "_quatuor_swn_c" + nameModelCarpetSelection(state.getValue(VillagerTableBlock.COLOR));
                    modelPath += "villager_table_quatuor_carpeted";
                }
            }
            //W N E
            else if ((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                modelPath += "villager_table_quatuor/";
                rotation = 180;
                if (flag)
                {
                    modelName += "_quatuor_wne";
                    modelPath += "villager_table_quatuor";
                }
                else
                {
                    modelName += "_quatuor_wne_c" + nameModelCarpetSelection(state.getValue(VillagerTableBlock.COLOR));
                    modelPath += "villager_table_quatuor_carpeted";
                }
            }
            //total part
            else if ((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                modelPath += "villager_table_pentuor/";
                rotation = 0;
                if (flag)
                {
                    modelName += "_pentuor";
                    modelPath += "villager_table_pentuor";
                }
                else
                {
                    modelName += "_pentuor_c" + nameModelCarpetSelection(state.getValue(VillagerTableBlock.COLOR));
                    modelPath += "villager_table_pentuor_carpeted";
                }
            }
            //solo
            else
            {
                modelPath += "villager_table_solo/";
                rotation = 0;
                if (flag)
                {
                    modelName += "_solo";
                    modelPath += "villager_table_solo";
                }
                else
                {
                    modelName += "_solo_c" + nameModelCarpetSelection(state.getValue(VillagerTableBlock.COLOR));
                    modelPath += "villager_table_solo_carpeted";
                }
            }
            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName, modelPath)
                            .texture("0", textureTable)
                            .texture("1", carpetTexture)
                            .texture("2", textureParticle))
                    .rotationY(rotation)
                    .build();
        });
        ModelFile villagerWorkshopModel = models().withExistingParent(getKey(table).toString(), "premierpainmod:block/all_materials_block/villager_table/villager_table_solo/villager_table_solo").texture("0", "block/all_materials_block/multiple_use_texture/" + material);
        itemModels().getBuilder(getKey(table).getPath()).parent(villagerWorkshopModel);
    }

    private static void villagerChairWithItem(Block chair)
    {
        String chairName = BuiltInRegistries.BLOCK.getKey(chair).toString().replace(PremierPainMod.MOD_ID + ":", "");
        String material = chairName.replace("_villager_chair", "");
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(chair);
        variantBuilder.forAllStates(state ->
                ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(getKey(chair).toString(), "premierpainmod:block/all_materials_block/villager_chair/villager_chair")
                                .texture("0", "block/all_materials_block/multiple_use_texture/" + material)
                                .texture("1", "block/all_materials_block/multiple_use_particle/" + material))
                        .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                        .build());
        ModelFile villagerChairModel = models().withExistingParent(getKey(chair).toString(), "premierpainmod:block/all_materials_block/villager_chair/villager_chair").texture("0", "block/all_materials_block/multiple_use_texture/" + material);
        itemModels().getBuilder(getKey(chair).getPath()).parent(villagerChairModel);
    }

    private static void villagerThroneChairWithItem(Block throneChair)
    {
        String throneChairName = getModName(throneChair);
        String material = throneChairName.replace("_villager_throne_chair", "");
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(throneChair);
        variantBuilder.forAllStates(state ->
        {
            String modelName = getKey(throneChair).toString();
            String modelPath = "premierpainmod:block/all_materials_block/villager_throne_chair/";
            String texture0 = "block/all_materials_block/multiple_use_texture/" + material;
            String texture1 = textureCarpetSelection(state.getValue(VillagerThroneChairBlock.COLOR));
            String particle = "block/all_materials_block/multiple_use_particle/" + material;
            boolean flag = (state.getValue(VillagerThroneChairBlock.COLOR) == VillagerCarpetColor.NONE);
            if (state.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER)
            {
                if (flag)
                {
                    modelName += "_bottom";
                    modelPath += "wo_carpet/villager_throne_chair_bottom";
                }
                else
                {
                    modelName += "_bottom_c" + nameModelCarpetSelection(state.getValue(VillagerThroneChairBlock.COLOR));
                    modelPath += "w_carpet/villager_throne_chair_bottom_carpeted";
                }
            }
            else
            {
                if (flag)
                {
                    modelName += "_upper";
                    modelPath += "wo_carpet/villager_throne_chair_upper";
                }
                else
                {
                    modelName += "_upper_c" + nameModelCarpetSelection(state.getValue(VillagerThroneChairBlock.COLOR));
                    modelPath += "w_carpet/villager_throne_chair_upper_carpeted";
                }
            }
            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName, modelPath)
                            .texture("0", texture0)
                            .texture("1", texture1)
                            .texture("2", particle))
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });
        ModelFile villagerChairModel = models().withExistingParent(getKey(throneChair).toString(), "premierpainmod:block/all_materials_block/villager_throne_chair/wo_carpet/villager_throne_chair_m").texture("0", "block/all_materials_block/multiple_use_texture/" + material);
        itemModels().getBuilder(getKey(throneChair).getPath()).parent(villagerChairModel);
    }

    private static void villagerDrawerWithItem(Block villagerDrawer)
    {
        String villagerDrawerName = BuiltInRegistries.BLOCK.getKey(villagerDrawer).toString().replace(PremierPainMod.MOD_ID + ":", "");
        String material = villagerDrawerName.replace("_villager_drawer", "");

        String texture = "block/all_materials_block/multiple_use_texture/" + material;
        String particle = "block/all_materials_block/multiple_use_particle/" + material;

        VariantBlockStateBuilder variantBuilder = getVariantBuilder(villagerDrawer);
        variantBuilder.forAllStates(state ->
        {
            String modelName = getKey(villagerDrawer).toString();
            String modelPath = "premierpainmod:block/all_materials_block/villager_drawer/";

            if (state.getValue(VillagerDrawer.PART) == TwoBlockWidthPart.RIGHT)
            {
                if (state.getValue(VillagerDrawer.OPEN) == FALSE)
                {
                    modelName += "_right_closed";
                    modelPath += "villager_drawer_right_closed";
                }
                else
                {
                    modelName += "_right_opened";
                    modelPath += "villager_drawer_right_opened";
                }
            }
            else
            {
                if (state.getValue(VillagerDrawer.OPEN) == FALSE)
                {
                    modelName += "_left_closed";
                    modelPath += "villager_drawer_left_closed";
                }
                else
                {
                    modelName += "_left_opened";
                    modelPath += "villager_drawer_left_opened";
                }
            }
            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName, modelPath)
                            .texture("0", texture)
                            .texture("1", particle))
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });
        ModelFile villagerWorkshopModel = models().withExistingParent(getKey(villagerDrawer).toString(), "premierpainmod:block/all_materials_block/villager_drawer/villager_drawer_m")
                .texture("0", texture);
        itemModels().getBuilder(getKey(villagerDrawer).getPath()).parent(villagerWorkshopModel);
    }

    private static void wallVillagerShelf(Block villagerWallShelfWithItem)
    {
        String name = BuiltInRegistries.BLOCK.getKey(villagerWallShelfWithItem).toString().replace(PremierPainMod.MOD_ID + ":", "");
        String material = name.replace("_wall_villager_shelf", "");

        String texture = "block/all_materials_block/multiple_use_texture/" + material;
        String particle = "block/all_materials_block/multiple_use_particle/" + material;

        VariantBlockStateBuilder variantBuilder = getVariantBuilder(villagerWallShelfWithItem);
        variantBuilder.forAllStates(state ->
        {
            String modelName = getKey(villagerWallShelfWithItem).toString();
            String modelPath = "premierpainmod:block/all_materials_block/villager_shelf/wall/";
            if (state.getValue(VillagerDrawer.PART) == TwoBlockWidthPart.RIGHT)
            {
                modelName += "_right";
                modelPath += "wall_villager_shelf_right";
            }
            else
            {
                modelName += "_left";
                modelPath += "wall_villager_shelf_left";
            }
            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName, modelPath)
                            .texture("0", texture)
                            .texture("1", particle))
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });
    }

    private static void standingVillagerShelf(Block villagerWallShelfWithItem)
    {
        String name = BuiltInRegistries.BLOCK.getKey(villagerWallShelfWithItem).toString().replace(PremierPainMod.MOD_ID + ":", "");
        String material = name.replace("_standing_villager_shelf", "");

        String texture = "block/all_materials_block/multiple_use_texture/" + material;
        String particle = "block/all_materials_block/multiple_use_particle/" + material;

        VariantBlockStateBuilder variantBuilder = getVariantBuilder(villagerWallShelfWithItem);
        variantBuilder.forAllStates(state ->
        {
            String modelName = getKey(villagerWallShelfWithItem).toString();
            String modelPath = "premierpainmod:block/all_materials_block/villager_shelf/standing/";

            if (state.getValue(VillagerDrawer.PART) == TwoBlockWidthPart.RIGHT)
            {
                if ((state.getValue(StandingVillagerShelf.HAS_SHELF_BELOW)) && (state.getValue(StandingVillagerShelf.HAS_SHELF_ON_TOP)))
                {
                    modelName += "_right_middle";
                    modelPath += "middle_standing_villager_shelf_right";
                }
                else if ((state.getValue(StandingVillagerShelf.HAS_SHELF_BELOW)) && !(state.getValue(StandingVillagerShelf.HAS_SHELF_ON_TOP)))
                {
                    modelName += "_right_top";
                    modelPath += "top_standing_villager_shelf_right";
                }
                else
                {
                    modelName += "_right_base";
                    modelPath += "base_standing_villager_shelf_right";
                }
            }
            else
            {
                if ((state.getValue(StandingVillagerShelf.HAS_SHELF_BELOW)) && (state.getValue(StandingVillagerShelf.HAS_SHELF_ON_TOP)))
                {
                    modelName += "_left_middle";
                    modelPath += "middle_standing_villager_shelf_left";
                }
                else if ((state.getValue(StandingVillagerShelf.HAS_SHELF_BELOW)) && !(state.getValue(StandingVillagerShelf.HAS_SHELF_ON_TOP)))
                {
                    modelName += "_left_top";
                    modelPath += "top_standing_villager_shelf_left";
                }
                else
                {
                    modelName += "_left_base";
                    modelPath += "base_standing_villager_shelf_left";
                }
            }
            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName, modelPath)
                            .texture("0", texture)
                            .texture("1", particle))
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });
    }

    private static void flowerBlockWithItem(Block block)
    {
        String name = BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MOD_ID + ":", "");

        ModelFile modelFile = models().withExistingParent(name, "block/cross").texture("cross", "block/vegetation/flower_block/one_block_flower/" + name).renderType("cutout");
        ModelFile itemModelFile = models().withExistingParent(name + "_item", "item/generated").texture("layer0", "block/vegetation/flower_block/one_block_flower/" + name);

        simpleBlock(block, modelFile);
        itemModels().getBuilder(getKey(block).getPath()).parent(itemModelFile);
    }

    private static void flowerPotBlock(Block flowerPotBlock, Block flowerBlock)
    {
        String nameFlower = BuiltInRegistries.BLOCK.getKey(flowerBlock).toString().replace(PremierPainMod.MOD_ID + ":", "");
        pottedBlockWithBasicModel(flowerPotBlock, "block/vegetation/flower_block/one_block_flower/" + nameFlower);
    }

    private static void deadBushPotBlock(Block deadBushPotBlock, Block deadBushBlock)
    {
        String nameFlower = BuiltInRegistries.BLOCK.getKey(deadBushBlock).toString().replace(PremierPainMod.MOD_ID + ":", "");
        pottedBlockWithBasicModel(deadBushPotBlock, "block/vegetation/dead_bush/" + nameFlower);
    }

    private static void growingVegetationWithItem(Block block)
    {
        String name = BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MOD_ID + ":", "");

        ModelFile modelFile = models().withExistingParent(name, "block/cross").texture("cross", "block/vegetation/flower_block/growing_flower_block/" + name).renderType("cutout");
        ModelFile itemModelFile = models().withExistingParent(name + "_item", "item/generated").texture("layer0", "block/vegetation/flower_block/growing_flower_block/" + name);

        simpleBlock(block, modelFile);
        itemModels().getBuilder(getKey(block).getPath()).parent(itemModelFile);
    }

    private static void deadBushWithItem(Block block)
    {
        String name = BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MOD_ID + ":", "");

        ModelFile modelFile = models().withExistingParent(name, "block/cross").texture("cross", "block/vegetation/dead_bush/" + name).renderType("cutout");
        ModelFile itemModelFile = models().withExistingParent(name + "_item", "item/generated").texture("layer0", "block/vegetation/dead_bush/" + name);

        simpleBlock(block, modelFile);
        itemModels().getBuilder(getKey(block).getPath()).parent(itemModelFile);
    }

    private static void flowerPotBlockForGrowingVegetation(Block flowerPotBlock, Block flowerBlock)
    {
        String nameFlower = BuiltInRegistries.BLOCK.getKey(flowerBlock).toString().replace(PremierPainMod.MOD_ID + ":", "");
        pottedBlockWithBasicModel(flowerPotBlock, "block/vegetation/flower_block/growing_flower_block/" + nameFlower);
    }

    private static void floweredCactusBlockWithItem()
    {
        Block block = BlockRegister.FLOWERED_CACTUS_BLOCK.get();
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block);
        variantBuilder.forAllStates(state ->
        {
            String modelName = getKey(block).toString();
            String modelPath = "premierpainmod:block/vegetation/misc/flowered_cactus/";
            if (state.getValue(FloweredCactusBlock.PART_NUM) == 1)
            {
                modelName += "_1";
                modelPath += "flowered_cactus_1";
            }
            else if (state.getValue(FloweredCactusBlock.PART_NUM) == 2)
            {
                modelName += "_2";
                modelPath += "flowered_cactus_2";
            }
            else if (state.getValue(FloweredCactusBlock.PART_NUM) == 3)
            {
                modelName += "_3";
                modelPath += "flowered_cactus_3";
            }
            else
            {
                modelName += "_0";
                modelPath += "flowered_cactus_0";
            }
            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName, modelPath))
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });
        ModelFile model;
        model = models().withExistingParent(getKey(block).toString(), "premierpainmod:block/vegetation/misc/flowered_cactus/flowered_cactus_0");
        itemModels().getBuilder(getKey(block).getPath()).parent(model);
    }

    private static void cactusFlowerBlockWithItem()
    {
        Block block = BlockRegister.CACTUS_FLOWER_BLOCK.get();
        ModelFile pedestalModel = models().withExistingParent(getKey(block).toString(), "premierpainmod:block/vegetation/misc/flowered_cactus/cactus_flower/cactus_flower");
        simpleBlock(block, pedestalModel);
        itemModels().getBuilder(getKey(block).getPath()).parent(models()
                        .getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "block/vegetation/misc/flowered_cactus/cactus_flower/cactus_flower_item");
    }

    private static void pottedFloweredCactus()
    {
        Block flowerPotBlock = BlockRegister.POTTED_CACTUS_FLOWER_BLOCK.get();
        pottedBlockWithBasicModel(flowerPotBlock, "block/vegetation/misc/flowered_cactus/cactus_flower/cactus_flower_item");
    }

    private static void universalPottedBlockWithCustomModel(Block pottedBlock, String modelPath)
    {
        String namePottedBlock = BuiltInRegistries.BLOCK.getKey(pottedBlock).toString().replace(PremierPainMod.MOD_ID + ":", "");
        ModelFile modelFile = models().withExistingParent(namePottedBlock, modelPath)
                .renderType("cutout");
        simpleBlock(pottedBlock, modelFile);
    }

    public static void pottedBlockWithBasicModel(Block pottedBlock, String folderOfPng)
    {
        String namePottedBlock = BuiltInRegistries.BLOCK.getKey(pottedBlock).toString().replace(PremierPainMod.MOD_ID + ":", "");

        ModelFile modelFile = models().withExistingParent(namePottedBlock, ResourceLocation.withDefaultNamespace("flower_pot_cross"))
                .texture("plant", folderOfPng)
                .renderType("cutout");
        simpleBlock(pottedBlock, modelFile);
    }

    private static void tallGrassWithItem(Block block)
    {
        String name = getModName(block);

        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block);
        variantBuilder.forAllStates(state ->
        {
            String modelName = getKey(block).toString();
            String texturePath = "block/vegetation/tall_grass/" + name + "/";
            if (state.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER)
            {
                modelName += "_lower";
                texturePath += name + "_lower";
            }
            else
            {
                modelName += "_upper";
                texturePath += name + "_upper";
            }
            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName, "block/cross")
                            .texture("cross", texturePath)
                            .renderType("cutout"))
                    .build();
        });

        itemModels().getBuilder((getKey(block).getPath()).replace("premierpainmod:block/", "premierpainmod:item/"))
                .parent(models()
                        .getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "block/vegetation/tall_grass/" + name + "/" + name + "_upper");
    }

    private static void villagerBenchWithItem(Block block)
    {
        String name = BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MOD_ID + ":", "");
        String material = name.replace("_villager_bench", "");

        String texture = "block/all_materials_block/multiple_use_texture/" + material;
        String particle = "block/all_materials_block/multiple_use_particle/" + material;

        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block);
        variantBuilder.forAllStates(state ->
        {
            String modelName = getKey(block).toString();
            String modelPath = "premierpainmod:block/all_materials_block/villager_bench/";
            if (state.getValue(VillagerBench.ADAPTABLE_SIT) == AdaptableSitShape.ALONE)
            {
                modelName += "_alone";
                modelPath += "villager_bench_alone";
            }
            else if (state.getValue(VillagerBench.ADAPTABLE_SIT) == AdaptableSitShape.WITH_LEFT_AND_RIGHT)
            {
                modelName += "_with_left_and_right";
                modelPath += "villager_bench_with_left_and_right";
            }
            else if (state.getValue(VillagerBench.ADAPTABLE_SIT) == AdaptableSitShape.WITH_LEFT)
            {
                modelName += "_with_right";
                modelPath += "villager_bench_with_right";
            }
            else
            {
                modelName += "_with_left";
                modelPath += "villager_bench_with_left";
            }
            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName, modelPath)
                            .texture("0", texture)
                            .texture("1", particle))
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });
        ModelFile villagerBenchModel = models().withExistingParent(getKey(block).toString(), "premierpainmod:block/all_materials_block/villager_bench/villager_bench_alone").texture("0", "block/all_materials_block/multiple_use_texture/" + material);
        itemModels().getBuilder(getKey(block).getPath()).parent(villagerBenchModel);
    }

    private static void villagerCouchWithItem(Block block)
    {
        String name = BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MOD_ID + ":", "");
        String material = name.replace("_villager_couch", "");


        String texture = "block/all_materials_block/multiple_use_texture/" + material;
        String particle = "block/all_materials_block/multiple_use_particle/" + material;

        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block);
        variantBuilder.forAllStates(state ->
        {
            VillagerCarpetColor villagerCarpetColor = state.getValue(VillagerCouch.CARPET_COLOR);
            String carpetTexture = textureCarpetSelection(villagerCarpetColor);
            String modelName = getKey(block).toString();
            String modelPath = "premierpainmod:block/all_materials_block/villager_couch/";
            if (state.getValue(VillagerBench.ADAPTABLE_SIT) == AdaptableSitShape.ALONE)
            {
                modelName += "_alone" + nameModelCarpetSelection(villagerCarpetColor);
                modelPath += "villager_couch_alone";
            }
            else if (state.getValue(VillagerBench.ADAPTABLE_SIT) == AdaptableSitShape.WITH_LEFT_AND_RIGHT)
            {
                modelName += "_with_left_and_right" + nameModelCarpetSelection(villagerCarpetColor);
                modelPath += "villager_couch_with_left_and_right";
            }
            else if (state.getValue(VillagerBench.ADAPTABLE_SIT) == AdaptableSitShape.WITH_RIGHT)
            {
                modelName += "_with_right" + nameModelCarpetSelection(villagerCarpetColor);
                modelPath += "villager_couch_with_right";
            }
            else
            {
                modelName += "_with_left" + nameModelCarpetSelection(villagerCarpetColor);
                modelPath += "villager_couch_with_left";
            }
            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName, modelPath)
                            .texture("0", texture)
                            .texture("1", carpetTexture)
                            .texture("2", particle))
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });
        ModelFile villagerBenchModel = models().withExistingParent(getKey(block).toString(), "premierpainmod:block/all_materials_block/villager_couch/villager_couch_alone")
                .texture("0", "block/all_materials_block/multiple_use_texture/" + material)
                .texture("1", "premierpainmod:block/all_materials_block/multiple_use_carpet/villager_table_carpet_white");
        itemModels().getBuilder(getKey(block).getPath()).parent(villagerBenchModel);
    }

    private static void villagerBrewingStationWithItem(Block block)
    {
        String name = getModName(block);
        String material = name.replace("_villager_brewing_station", "");
        String texture = "block/all_materials_block/multiple_use_texture/" + material;
        String particle = "block/all_materials_block/multiple_use_particle/" + material;
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block);
        variantBuilder.forAllStates(state ->
        {
            String modelPath = "premierpainmod:block/all_materials_block/villager_brewing_station/villager_brewing_station";
            String modelName = getKey(block).toString();

            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName, modelPath)
                            .texture("1", texture)
                            .texture("2", particle))
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });
        ModelFile baseModel = models().withExistingParent(getKey(block).toString(), "premierpainmod:block/all_materials_block/villager_brewing_station/villager_brewing_station").texture("1", "block/all_materials_block/multiple_use_texture/" + material).texture("2", "block/all_materials_block/multiple_use_particle/" + material);
        itemModels().getBuilder(getKey(block).getPath()).parent(baseModel);
    }

    private static void villagerMusicalFridgeBlockWithItem(Block block)
    {
        String name = getModName(block);
        String material = name.replace("_villager_musical_fridge", "");
        String texture = "block/all_materials_block/multiple_use_texture/" + material;
        String particle = "block/all_materials_block/multiple_use_particle/" + material;
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block);
        variantBuilder.forAllStates(state ->
        {
            String modelPath = "premierpainmod:block/all_materials_block/villager_musical_fridge/villager_musical_fridge_";
            String modelName = getKey(block).toString();
            if (state.getValue(VillagerMusicalFridgeBlock.HALF) == DoubleBlockHalf.LOWER)
            {
                modelPath = modelPath + "lower_";
                modelName = modelName + "_lower_";
            }
            else
            {
                modelPath = modelPath + "upper_";
                modelName = modelName + "_upper_";
            }

            if (state.getValue(VillagerMusicalFridgeBlock.OPEN))
            {
                modelPath = modelPath + "opened";
                modelName = modelName + "opened";
            }
            else
            {
                modelPath = modelPath + "closed";
                modelName = modelName + "closed";
            }

            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName, modelPath)
                            .texture("1", texture)
                            .texture("2", particle))
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });
        ModelFile baseModel = models().withExistingParent(getKey(block).toString(), "premierpainmod:block/all_materials_block/villager_musical_fridge/villager_musical_fridge_item")
                .texture("2", texture);
        itemModels().getBuilder(getKey(block).getPath()).parent(baseModel);
    }

    private static void villagerChiseledHeadBlockWithItem(Block block)
    {
        String name = getModName(block);
        String material = name.replace("_villager_chiseled_head", "");
        String texture = "block/all_materials_block/multiple_use_texture/" + material;
        String particle = "block/all_materials_block/multiple_use_particle/" + material;
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block);
        variantBuilder.forAllStates(state ->
        {
            String modelPath = "premierpainmod:block/all_materials_block/villager_chiseled_head/villager_chiseled_head_";
            String modelName = getKey(block).toString();
            int rotationX;
            int rotationY;
            if (state.getValue(VillagerChiseledHead.LIT))
            {
                modelPath += "lit";
                modelName += "_lit";
            }
            else
            {
                modelPath += "unlit";
                modelName += "_unlit";
            }

            if (state.getValue(VillagerChiseledHead.AXIS) == Direction.Axis.X)
            {
                rotationX = 90;
                rotationY = 270;
            }
            else if (state.getValue(VillagerChiseledHead.AXIS) == Direction.Axis.Y)
            {
                rotationX = 0;
                rotationY = 0;
            }
            else
            {
                rotationX = 90;
                rotationY = 180;
            }

            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName, modelPath)
                            .texture("1", texture)
                            .texture("2", particle))
                    .rotationX(rotationX)
                    .rotationY(rotationY)
                    .build();
        });

        ModelFile baseModel = models().withExistingParent(getKey(block).toString(), "premierpainmod:block/all_materials_block/villager_chiseled_head/villager_chiseled_head_lit")
                .texture("1", texture);
        itemModels().getBuilder(getKey(block).getPath()).parent(baseModel);
    }

    private static void villagerDryToiletBlockWithItem(Block block)
    {
        String name = getModName(block);
        String material = name.replace("_villager_dry_toilet", "");
        String texture = "block/all_materials_block/multiple_use_texture/" + material;
        String particle = "block/all_materials_block/multiple_use_particle/" + material;
        ModelFile baseModel = models().withExistingParent(getKey(block).toString(), "premierpainmod:block/all_materials_block/villager_dry_toilet/villager_dry_toilet")
                .texture("1", texture)
                .texture("2", particle);
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block);
        variantBuilder.forAllStates(state ->
                ConfiguredModel.builder()
                        .modelFile(baseModel)
                        .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                        .build());
        itemModels().getBuilder(getKey(block).getPath()).parent(baseModel);
    }

    private static void skySpearsFlowerWithItem()
    {
        Block block = BlockRegister.SKY_SPEARS_FLOWER.get();
        ModelFile blockModel = models().withExistingParent(getKey(block).toString(), "premierpainmod:block/vegetation/tall_grass/sky_spears_flower")
                .texture("0", "block/vegetation/tall_grass/sky_spears/sky_spears_flower");
        simpleBlock(block, blockModel);
        itemModels().getBuilder((getKey(block).getPath()).replace("premierpainmod:block/", "premierpainmod:item/"))
                .parent(models()
                        .getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "block/vegetation/tall_grass/sky_spears/sky_spears_flower");
    }

    private static void skySpearsFlowerPotBlock()
    {
        Block pottedBlock = BlockRegister.POTTED_SKY_SPEARS_FLOWER.get();
        pottedBlockWithBasicModel(pottedBlock, "block/vegetation/tall_grass/sky_spears/sky_spears_flower");
    }

    private static void jellyshroomWithItem()
    {
        Block block = BlockRegister.JELLYSHROOM.get();
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block);
        variantBuilder.forAllStates(state ->
        {
            String modelPath = "premierpainmod:block/vegetation/crop/jellyshroom/jellyshroom_";
            String modelName = getKey(block) + "_";
            switch (state.getValue(JellyShroomBlock.AGE))
            {
                case 1:
                {
                    modelPath += "1";
                    modelName += "1";
                    break;
                }

                case 2:
                {
                    modelPath += "2";
                    modelName += "2";
                    break;
                }
                case 3:
                {
                    modelPath += "3";
                    modelName += "3";
                    break;
                }
                case 4:
                {
                    modelPath += "4";
                    modelName += "4";
                    break;
                }
                default:
                {
                    modelPath += "0";
                    modelName += "0";
                }
            }
            ModelFile blockModel = models().withExistingParent(modelName, modelPath);
            return ConfiguredModel.builder()
                    .modelFile(blockModel)
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });
        itemModels().getBuilder((getKey(block).getPath()).replace("premierpainmod:block/", "premierpainmod:item/"))
                .parent(models()
                        .getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/vegetation/crop/jellyshroom");
    }

    protected void axisRotatedBlockWithItem(Block block, ResourceLocation side, ResourceLocation bottomAndTop)
    {
        String name = getModName(block);
        axisBlock((RotatedPillarBlock) block, side, bottomAndTop);
        simpleBlockItem(block, models().cubeColumn(name, side, bottomAndTop));
    }

    protected void stairWithItem(Block stairs, ResourceLocation texture)
    {
        stairsBlock((StairBlock) stairs, texture);
        ModelFile model = models().stairs(getModName(stairs) + "_item", texture, texture, texture);
        itemModels().getBuilder(getKey(stairs).getPath()).parent(model);
    }

    protected void slabWithItem(Block block, ResourceLocation texture)
    {
        ModelFile singleSLabModel = models().slab(getModName(block), texture, texture, texture);

        slabBlock((SlabBlock) block,
                singleSLabModel,
                models().slabTop(getModName(block) + "_top", texture, texture, texture),
                models().cubeAll(getModName(block) + "_full", texture));
        itemModels().getBuilder(getKey(block).getPath()).parent(singleSLabModel);
    }

    protected void buttonWithItem(Block block, ResourceLocation texture)
    {
        String baseName = getModName(block);
        ModelFile button = models().button(baseName, texture);
        ModelFile buttonPressed = models().buttonPressed(baseName + "_pressed", texture);
        buttonBlock((ButtonBlock) block, button, buttonPressed);
        ModelFile itemModel = models().withExistingParent(baseName + "_item", "block/button_inventory").texture("texture", texture);
        itemModels().getBuilder(getKey(block).getPath()).parent(itemModel);
    }

    protected void pressurePlateWithItem(Block block, ResourceLocation texture)
    {
        ModelFile pressurePlate = models().pressurePlate(getModName(block), texture);
        ModelFile pressurePlateDown = models().pressurePlateDown(getModName(block) + "_down", texture);
        pressurePlateBlock((PressurePlateBlock) block, pressurePlate, pressurePlateDown);
        itemModels().getBuilder(getKey(block).getPath()).parent(pressurePlate);
    }

    protected void fenceWithItem(Block block, ResourceLocation texture)
    {
        String baseName = getModName(block);
        fourWayBlock((CrossCollisionBlock) block,
                models().fencePost(baseName + "_post", texture),
                models().fenceSide(baseName + "_side", texture));
        ModelFile itemModel = models().withExistingParent(baseName + "_item", "block/fence_inventory").texture("texture", texture);
        itemModels().getBuilder(getKey(block).getPath()).parent(itemModel);
    }

    protected void fenceGateWithItem(Block block, ResourceLocation texture)
    {
        String baseName = getModName(block);
        ModelFile gate = models().fenceGate(baseName, texture);
        ModelFile gateOpen = models().fenceGateOpen(baseName + "_open", texture);
        ModelFile gateWall = models().fenceGateWall(baseName + "_wall", texture);
        ModelFile gateWallOpen = models().fenceGateWallOpen(baseName + "_wall_open", texture);
        fenceGateBlock((FenceGateBlock) block, gate, gateOpen, gateWall, gateWallOpen);
        itemModels().getBuilder(getKey(block).getPath()).parent(gate);
    }

    protected void doorWithItem(Block door, ResourceLocation bottom, ResourceLocation Top, ResourceLocation item)
    {
        doorBlockWithRenderType((DoorBlock) door, bottom, Top, "cutout");
        itemModels().getBuilder(
                        (getKey(door).getPath()).replace("premierpainmod:block/", "premierpainmod:item/"))
                .parent(models()
                        .getExistingFile(mcLoc("item/generated")))
                .texture("layer0", item);
    }

    protected void trapdoorWithItem(Block block, ResourceLocation texture)
    {
        String name = getModName(block);
        trapdoorBlockWithRenderType((TrapDoorBlock) block, texture, true, "cutout");
        ModelFile model = models().trapdoorBottom(name, texture);
        itemModels().getBuilder(getKey(block).getPath()).parent(model);
    }

    protected void wallBlockWithItem(Block block, ResourceLocation texture)
    {
        String name = getModName(block);
        wallBlockWithRenderType((WallBlock) block, texture, "cutout");
        ModelFile model = models().wallInventory(name, texture);
        itemModels().getBuilder(getKey(block).getPath()).parent(model);
    }

    protected void cuttedBlockWithItem(Block block, String side, String topAndBottom)
    {
        String name = getModName(block);
        ModelFile model = models().cubeColumn(name, ResourceUtil.createResourceLocation(side), ResourceUtil.createResourceLocation(topAndBottom));
        simpleBlockWithItemWithCustomModel(block, model);
        simpleBlockItem(block, model);
    }

    protected void woodenSign(Block standing, Block wall, ResourceLocation texture)
    {
        signBlock((StandingSignBlock) standing, (WallSignBlock) wall, texture);
    }

    protected void woodenHangingSign(Block ceiling, Block wall, ResourceLocation texture)
    {
        hangingSignBlock((CeilingHangingSignBlock) ceiling, (WallHangingSignBlock) wall, texture);
    }

    private static void tallFlower(Block block)
    {
        String name = getModName(block);
        String top = "block/vegetation/flower_block/tall_flower/" + name + "/top";
        String bottom = "block/vegetation/flower_block/tall_flower/" + name + "/bottom";
        String modelPath = "block/cross";

        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block);
        variantBuilder.forAllStates(state ->
        {
            String modelName = name;
            String texture;

            if (state.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.LOWER)
            {
                modelName += "_bottom";
                texture = bottom;
            }
            else
            {
                modelName += "_top";
                texture = top;
            }
            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName, modelPath)
                            .texture("cross", texture)
                            .renderType("cutout"))
                    .build();
        });
        ModelFile itemModelFile = models().withExistingParent(name + "_item", "item/generated")
                .texture("layer0", top);
        itemModels().getBuilder(getKey(block).getPath()).parent(itemModelFile);
    }

    private static void villagerWorkshopWithItem()
    {
        Block villagerWorkshop = BlockRegister.VILLAGER_WORKSHOP.get();
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(villagerWorkshop);
        variantBuilder.forAllStates(state ->
        {
            String modelName = getKey(villagerWorkshop).toString();
            String modelPath;
            if (state.getValue(VillagerWorkshop.PART) == TwoBlockWidthPart.RIGHT)
            {
                modelName += "_right";
                modelPath = "premierpainmod:block/functional_block/villager_workshop/villager_workshop_right_m";
            }
            else
            {
                modelName += "_left";
                modelPath = "premierpainmod:block/functional_block/villager_workshop/villager_workshop_left_m";
            }

            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName, modelPath))
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });

        ModelFile villagerWorkshopModel = models().withExistingParent(getKey(villagerWorkshop).toString(), "premierpainmod:block/functional_block/villager_workshop/villager_workshop_m");
        itemModels().getBuilder(getKey(villagerWorkshop).getPath()).parent(villagerWorkshopModel);
    }

    private static void cookingPotBlockWithItem()
    {
        Block block = BlockRegister.COOKING_POT_BLOCK.get();
        String name = getModName(block);
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block);
        ModelFile baseModel = models().withExistingParent(name + "_base", "premierpainmod:block/functional_block/cooking_pot/cooking_pot_base");
        ModelFile hangingModel = models().withExistingParent(name + "_hanging", "premierpainmod:block/functional_block/cooking_pot/cooking_pot_hanging");
        variantBuilder.forAllStates(state ->
        {
            ModelFile finalModel;
            if (state.getValue(ModBlockStateProperties.HANGING))
            {
                finalModel = hangingModel;
            }
            else
            {
                finalModel = baseModel;
            }
            return ConfiguredModel.builder()
                    .modelFile(finalModel)
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });
        itemModels().getBuilder(getKey(block).getPath()).parent(baseModel);
    }

    private static void crystalClusterWithItem(GrowingCrystalCluster block, String generalTextureFolder)
    {
        String name = getModName(block);
        String baseTexturePath = generalTextureFolder + name + "_";
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block);
        variantBuilder.forAllStates(state ->
        {
            String modelName = getKey(block) + "_";
            int currentAgeState = state.getValue(GrowingCrystalCluster.AGE);
            int xRotation = 0;
            int yRotation = 0;
            switch (state.getValue(BlockStateProperties.FACING))
            {
                case DOWN -> xRotation = 180;
                case NORTH -> xRotation = 90;
                case EAST ->
                {
                    xRotation = 90;
                    yRotation = 90;
                }
                case SOUTH ->
                {
                    xRotation = 90;
                    yRotation = 180;
                }
                case WEST ->
                {
                    xRotation = 90;
                    yRotation = 270;
                }
                default ->
                {
                }
            }
            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName + currentAgeState, "block/cross")
                            .texture("cross", baseTexturePath + currentAgeState)
                            .renderType("cutout"))
                    .rotationX(xRotation)
                    .rotationY(yRotation)
                    .build();
        });
        itemModels().getBuilder((getKey(block).getPath()).replace("premierpainmod:block/", "premierpainmod:item/"))
                .parent(models()
                        .getExistingFile(mcLoc("item/generated")))
                .texture("layer0", baseTexturePath + 0);
    }

    private static void pointedCrystalWithItem(PointedCrystalBlock block, String generalTextureFolder)
    {
        String baseTexturePath = generalTextureFolder + "/" + getModName(block) + "_";
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block);
        variantBuilder.forAllStates(state ->
        {
            String modelName = getKey(block) + "_";
            String textureName = baseTexturePath;
            int xRotation = 0;
            int yRotation = 0;
            switch (state.getValue(PointedCrystalBlock.POINTED_CRYSTAL_STATE))
            {
                case PointedCrystalState.BASE ->
                {
                    modelName += "base";
                    textureName += "base";
                }
                case PointedCrystalState.MIDDLE ->
                {
                    modelName += "middle";
                    textureName += "middle";
                }
                case PointedCrystalState.START_TOP ->
                {
                    modelName += "start_top";
                    textureName += "start_top";
                }
                case PointedCrystalState.TOP ->
                {
                    modelName += "top";
                    textureName += "top";
                }
            }
            switch (state.getValue(BlockStateProperties.FACING))
            {
                case DOWN -> xRotation = 180;
                case NORTH -> xRotation = 90;
                case EAST ->
                {
                    xRotation = 90;
                    yRotation = 90;
                }
                case SOUTH ->
                {
                    xRotation = 90;
                    yRotation = 180;
                }
                case WEST ->
                {
                    xRotation = 90;
                    yRotation = 270;
                }
                default ->
                {
                }
            }

            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName, "block/cross")
                            .texture("cross", textureName)
                            .renderType("cutout"))
                    .rotationX(xRotation)
                    .rotationY(yRotation)
                    .build();

        });

        itemModels().getBuilder((getKey(block).getPath()).replace("premierpainmod:block/", "premierpainmod:item/"))
                .parent(models()
                        .getExistingFile(mcLoc("item/generated")))
                .texture("layer0", baseTexturePath + "top");
    }

    private String textureCarpetSelection(VillagerCarpetColor villagerCarpetColor)
    {
        String texturePath = "premierpainmod:block/all_materials_block/multiple_use_carpet/";
        switch (villagerCarpetColor)
        {
            case WHITE:
            {
                texturePath += "villager_table_carpet_white";
                break;
            }
            case LIGHT_GRAY:
            {
                texturePath += "villager_table_carpet_light_gray";
                break;
            }
            case GRAY:
            {
                texturePath += "villager_table_carpet_gray";
                break;
            }
            case BLACK:
            {
                texturePath += "villager_table_carpet_black";
                break;
            }
            case BROWN:
            {
                texturePath += "villager_table_carpet_brown";
                break;
            }
            case RED:
            {
                texturePath += "villager_table_carpet_red";
                break;
            }
            case ORANGE:
            {
                texturePath += "villager_table_carpet_orange";
                break;
            }
            case YELLOW:
            {
                texturePath += "villager_table_carpet_yellow";
                break;
            }
            case LIME:
            {
                texturePath += "villager_table_carpet_lime";
                break;
            }
            case GREEN:
            {
                texturePath += "villager_table_carpet_green";
                break;
            }
            case CYAN:
            {
                texturePath += "villager_table_carpet_cyan";
                break;
            }
            case LIGHT_BLUE:
            {
                texturePath += "villager_table_carpet_light_blue";
                break;
            }
            case BLUE:
            {
                texturePath += "villager_table_carpet_blue";
                break;
            }
            case PURPLE:
            {
                texturePath += "villager_table_carpet_purple";
                break;
            }
            case MAGENTA:
            {
                texturePath += "villager_table_carpet_magenta";
                break;
            }
            default:
            {
                texturePath += "villager_table_carpet_pink";
                break;
            }
        }
        return texturePath;
    }

    private String nameModelCarpetSelection(VillagerCarpetColor villagerCarpetColor)
    {
        return switch (villagerCarpetColor)
        {
            case WHITE -> "_white";
            case LIGHT_GRAY -> "_light_gray";
            case GRAY -> "_gray";
            case BLACK -> "_black";
            case BROWN -> "_brown";
            case RED -> "_red";
            case ORANGE -> "_orange";
            case YELLOW -> "_yellow";
            case LIME -> "_lime";
            case GREEN -> "_green";
            case CYAN -> "_cyan";
            case LIGHT_BLUE -> "_light_blue";
            case BLUE -> "_blue";
            case PURPLE -> "_purple";
            case MAGENTA -> "_magenta";
            default -> "_pink";
        };
    }

     */
}