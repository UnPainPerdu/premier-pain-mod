package com.unpainperdu.premierpainmod.datagen.asset.model;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerPedestalBlock;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.VillagerTableBlock;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockWidth.VillagerWorkshop;
import com.unpainperdu.premierpainmod.level.world.block.state.properties.VillagerTableCarpetColor;
import com.unpainperdu.premierpainmod.level.world.block.state.properties.TwoBlockWidthPart;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockHeight.VillagerBrazier;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockHeight.VillagerStatue;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockHeight.VillagerThroneChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockWidthWithBlockEntity.VillagerDrawer;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockWidthWithBlockEntity.villagerShelf.StandingVillagerShelf;
import com.unpainperdu.premierpainmod.level.world.block.allMaterialsBlock.twoBlockWidthWithBlockEntity.villagerShelf.WallVillagerShelf;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.growingAboveVegetation.AbstractGrowingAboveVegetation;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock.FloweredCactusBlock;
import com.unpainperdu.premierpainmod.util.register.ModList;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.data.PackOutput;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DeadBushBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class ModBlockStateProvider extends BlockStateProvider
{
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, PremierPainMod.MOD_ID, existingFileHelper);
    }


    @Override
    protected void registerStatesAndModels()
    {
        for(DeferredBlock<Block> DeferredBlock : ModList.ALL_BLOCKS)
        {
            Block block = DeferredBlock.get();
            if(block instanceof VillagerWorkshop) {villagerWorkshopWithItem(block);}
            else if(block instanceof VillagerStatue) {villagerStatueWithItem(block);}
            else if(block instanceof VillagerPedestalBlock) {villagerPedestalWithItem(block);}
            else if(block instanceof VillagerBrazier) {villagerBrazierWithItem(block);}
            else if(block instanceof VillagerTableBlock) {villagerTableWithItem(block);}
            else if(block instanceof VillagerChairBlock) {villagerChairWithItem(block);}
            else if(block instanceof VillagerThroneChairBlock) {villagerThroneChairWithItem(block);}
            else if(block instanceof VillagerDrawer) {villagerDrawerWithItem(block);}
            else if(block instanceof WallVillagerShelf) {wallVillagerShelf(block);}
            else if(block instanceof StandingVillagerShelf) {standingVillagerShelf(block);}
            else if (block instanceof FlowerBlock) {flowerBlockWithItem(block);}
            else if (block instanceof AbstractGrowingAboveVegetation) {growingVegetationWithItem(block);}
            else if (block instanceof DeadBushBlock) {deadBushWithItem(block);}
        }
        //manual
        cactusFlowerBlockWithItem();
        floweredCactusBlockWithItem();
        pottedFloweredCactus();
        //potted thing
            //flower
        flowerPotBlock(BlockRegister.POTTED_RUINS_FLOWER.get(), BlockRegister.RUINS_FLOWER.get());
        flowerPotBlockForGrowingVegetation(BlockRegister.POTTED_CIVILIZATIONS_FLOWER.get(), BlockRegister.CIVILIZATIONS_FLOWER.get());
        flowerPotBlock(BlockRegister.POTTED_CURIOSITY_FLOWER.get(), BlockRegister.CURIOSITY_FLOWER.get());
            //dead bush
        deadBushPotBlock(BlockRegister.POTTED_DEAD_RUINS_FLOWER.get(), BlockRegister.DEAD_RUINS_FLOWER.get());
        //else
        simpleBlockWithItemWithCustomModel(BlockRegister.LIBERTY_BLOCK.get(),"premierpainmod:block/event_block/liberty_block/liberty_block");
    }

    private void simpleBlockWithItem(Block block)
    {
        simpleBlockWithItem(block, cubeAll(block));
    }
    private void simpleBlockWithItemWithCustomModel(Block block, String modelPath)
    {
        String name = getName(block);
        ModelFile model = models().withExistingParent(getKey(block).toString(),modelPath);
        simpleBlock(block, model);
        itemModels().getBuilder(getKey(block).getPath()).parent(model);
    }
    private void villagerPedestalWithItem(Block pedestal)
    {
        String name = getName(pedestal);
        String material = name.replace("_villager_pedestal","_villager");
        ModelFile pedestalModel = models().withExistingParent(getKey(pedestal).toString(),"premierpainmod:block/all_materials_block/villager_pedestal/villager_pedestal").texture("0", "block/all_materials_block/multiple_use_texture/" + material).texture("1","block/all_materials_block/multiple_use_particle/" + material);
        simpleBlock(pedestal, pedestalModel);
        itemModels().getBuilder(getKey(pedestal).getPath()).parent(pedestalModel);
    }
    private void villagerStatueWithItem(Block statue)
    {
        String name = getName(statue);
        String material = name.replace("_villager_statue","_villager");

        VariantBlockStateBuilder variantBuilder = getVariantBuilder(statue);
        VariantBlockStateBuilder.PartialBlockstate partialState = variantBuilder.partialState();
        variantBuilder.forAllStates(state ->
            {
                String modelName = getKey(statue).toString();
                String modelPath = "premierpainmod:block/all_materials_block/villager_statue/";
                String texturePath = "block/all_materials_block/multiple_use_texture/" + material;
                String particlePath = "block/all_materials_block/multiple_use_particle/" + material;
                if(state.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF ) == DoubleBlockHalf.LOWER)
                    {
                        modelName += "_bottom";
                        modelPath += "villager_statue_bottom";
                    }
                    else
                    {
                        modelName += "_upper";
                        modelPath += "villager_statue_upper";
                    }
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(modelName,modelPath)
                                .texture("0", texturePath)
                                .texture("1",particlePath))
                        .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                        .build();
            });

        itemModels().getBuilder((getKey(statue).getPath()).replace("premierpainmod:block/","premierpainmod:item/"))
                .parent(models()
                        .getExistingFile(mcLoc("item/generated")))
                .texture("layer0","item/all_materials_block_item/villager_statue/" + name);
    }
    private void villagerWorkshopWithItem(Block villagerWorkshop)
    {

        VariantBlockStateBuilder variantBuilder = getVariantBuilder(villagerWorkshop);
        variantBuilder.forAllStates(state ->
        {
            String modelName = getKey(villagerWorkshop).toString();
            String modelPath;
            if(state.getValue(VillagerWorkshop.PART) == TwoBlockWidthPart.RIGHT)
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
                    .modelFile(models().withExistingParent(modelName,modelPath))
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });

        ModelFile villagerWorkshopModel = models().withExistingParent(getKey(villagerWorkshop).toString(),"premierpainmod:block/functional_block/villager_workshop/villager_workshop_m");
        itemModels().getBuilder(getKey(villagerWorkshop).getPath()).parent(villagerWorkshopModel);
    }
    private void villagerBrazierWithItem(Block brazier)
    {
        String name = getName(brazier);
        String material = name.replace("_villager_brazier","_villager");

        String texture_bottom = "block/all_materials_block/multiple_use_texture/" + material;
        String texture_upper;
        String particle = "block/all_materials_block/multiple_use_particle/" + material;

        if(material.equals("oak_villager")
            ||material.equals("birch_villager")
            ||material.equals("spruce_villager")
            ||material.equals("jungle_villager")
            ||material.equals("acacia_villager")
            ||material.equals("dark_oak_villager")
            ||material.equals("mangrove_villager")
            ||material.equals("cherry_villager")
            ||material.equals("bamboo_villager")
        )
        {
            texture_upper = "block/all_materials_block/villager_brazier/wood_villager_brazier_upper";
        }
        else
        {
            texture_upper = texture_bottom;
        }

        VariantBlockStateBuilder variantBuilder = getVariantBuilder(brazier);
        variantBuilder.forAllStates(state ->
        {
            String texture;
            String modelName = getKey(brazier).toString();
            String modelPath = "premierpainmod:block/all_materials_block/villager_brazier/";
            if(state.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF ) == DoubleBlockHalf.LOWER)
            {
                modelName += "_bottom";
                modelPath += "villager_brazier_bottom";
                texture = texture_bottom;
            }
            else
            {
                if(state.getValue(BlockStateProperties.LIT ) == TRUE)
                {
                    modelName += "_upper_lit";
                    modelPath += "villager_brazier_upper_lit";
                    texture = texture_upper;
                }
                else
                {
                    modelName += "_upper_unlit";
                    modelPath += "villager_brazier_upper_unlit";
                    texture = texture_upper;
                }
            }
            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName, modelPath)
                            .texture("0",texture)
                            .texture("3", particle))
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });

        ModelFile brazierModel = models().withExistingParent(getKey(brazier).toString()+"_m","premierpainmod:block/all_materials_block/villager_brazier/villager_brazier_m");
        itemModels().getBuilder(getKey(brazier).getPath()).parent(brazierModel).texture("0", texture_bottom).texture("1", texture_upper);
    }

    private void villagerTableWithItem(Block table)
    {
        String name = getName(table);
        String material = name.replace("_villager_table","_villager");
        String textureTable =  "block/all_materials_block/multiple_use_texture/" + material;
        String textureParticle = "block/all_materials_block/multiple_use_particle/" + material;

        VariantBlockStateBuilder variantBuilder = getVariantBuilder(table);
        variantBuilder.forAllStates(state ->
        {
            String carpetTexture = textureTableWithCarpetSelection(state, (VillagerTableBlock) table);
            String modelName = getKey(table).toString();
            String modelPath = "premierpainmod:block/all_materials_block/villager_table/";
            int rotation;
            boolean flag = (state.getValue(VillagerTableBlock.COLOR) == VillagerTableCarpetColor.NONE);
            //Duo part
                //North only
            if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                modelPath += "villager_table_duo/";
                rotation = 270;
                if(flag)
                {
                    modelName += "_duo_n";
                    modelPath += "villager_table_duo";
                }
                else
                {
                    modelName += "_duo_n_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table);
                    modelPath += "villager_table_duo_carpeted";
                }
            }
                //West only
            else if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                modelPath += "villager_table_duo/";
                rotation = 180;
                if(flag)
                {
                    modelName += "_duo_w";
                    modelPath += "villager_table_duo";
                }
                else
                {
                    modelName += "_duo_w_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table);
                    modelPath += "villager_table_duo_carpeted";
                }
            }
                //South only
            else if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                modelPath += "villager_table_duo/";
                rotation = 90;
                if(flag)
                {
                    modelName += "_duo_s";
                    modelPath += "villager_table_duo";
                }
                else
                {
                    modelName += "_duo_s_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table);
                    modelPath += "villager_table_duo_carpeted";
                }
            }
                //East only
            else if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                modelPath += "villager_table_duo/";
                rotation = 0;
                if(flag)
                {
                    modelName += "_duo_e";
                    modelPath += "villager_table_duo";
                }
                else
                {
                    modelName += "_duo_e_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table);
                    modelPath += "villager_table_duo_carpeted";
                }
            }
            //Trio Part
                //N S
            else if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                modelPath += "villager_table_trio/line/";
                rotation = 90;
                if(flag)
                {
                    modelName += "_trio_ns";
                    modelPath += "villager_table_trio_line";
                }
                else
                {
                    modelName += "_trio_ns_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table);
                    modelPath += "villager_table_trio_line_carpeted";
                }
            }
                //W E
            else if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                modelPath += "villager_table_trio/line/";
                rotation = 0;
                if(flag)
                {
                    modelName += "_trio_we";
                    modelPath += "villager_table_trio_line";
                }
                else
                {
                    modelName += "_trio_we_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table);
                    modelPath += "villager_table_trio_line_carpeted";
                }
            }
                //N W
            else if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                modelPath += "villager_table_trio/angle/";
                rotation = 180;
                if(flag)
                {
                    modelName += "_trio_nw";
                    modelPath += "villager_table_trio_angle";
                }
                else
                {
                    modelName += "_trio_nw_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table);
                    modelPath += "villager_table_trio_angle_carpeted";
                }
            }
                //N E
            else if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                modelPath += "villager_table_trio/angle/";
                rotation = 270;
                if(flag)
                {
                    modelName += "_trio_ne";
                    modelPath += "villager_table_trio_angle";
                }
                else
                {
                    modelName += "_trio_ne_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table);
                    modelPath += "villager_table_trio_angle_carpeted";
                }
            }
                //S W
            else if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                modelPath += "villager_table_trio/angle/";
                rotation = 90;
                if(flag)
                {
                    modelName += "_trio_sw";
                    modelPath += "villager_table_trio_angle";
                }
                else
                {
                    modelName += "_trio_sw_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table);
                    modelPath += "villager_table_trio_angle_carpeted";
                }
            }
                //S E
            else if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                modelPath += "villager_table_trio/angle/";
                rotation = 0;
                if(flag)
                {
                    modelName += "_trio_se";
                    modelPath += "villager_table_trio_angle";
                }
                else
                {
                    modelName += "_trio_se_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table);
                    modelPath += "villager_table_trio_angle_carpeted";
                }
            }
            //Quatuor Part
                //N E S
            else if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                modelPath += "villager_table_quatuor/";
                rotation = 270;
                if(flag)
                {
                    modelName += "_quatuor_nes";
                    modelPath += "villager_table_quatuor";
                }
                else
                {
                    modelName += "_quatuor_nes_c"+ nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table);
                    modelPath += "villager_table_quatuor_carpeted";
                }
            }
                //E S W
            else if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                modelPath += "villager_table_quatuor/";
                rotation = 0;
                if(flag)
                {
                    modelName += "_quatuor_esw";
                    modelPath += "villager_table_quatuor";
                }
                else
                {
                    modelName += "_quatuor_esw_c"+ nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table);
                    modelPath += "villager_table_quatuor_carpeted";
                }
            }
                //S W N
            else if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                modelPath += "villager_table_quatuor/";
                rotation = 90;
                if(flag)
                {
                    modelName += "_quatuor_swn";
                    modelPath += "villager_table_quatuor";
                }
                else
                {
                    modelName += "_quatuor_swn_c"+ nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table);
                    modelPath += "villager_table_quatuor_carpeted";
                }
            }
                //W N E
            else if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                modelPath += "villager_table_quatuor/";
                rotation = 180;
                if(flag)
                {
                    modelName += "_quatuor_wne";
                    modelPath += "villager_table_quatuor";
                }
                else
                {
                    modelName += "_quatuor_wne_c"+ nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table);
                    modelPath += "villager_table_quatuor_carpeted";
                }
            }
            //total part
            else if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                modelPath += "villager_table_pentuor/";
                rotation = 0;
                if(flag)
                {
                    modelName += "_pentuor";
                    modelPath += "villager_table_pentuor";
                }
                else
                {
                    modelName += "_pentuor_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table);
                    modelPath += "villager_table_pentuor_carpeted";
                }
            }
            //solo
            else
            {
                modelPath += "villager_table_solo/";
                rotation = 0;
                if(flag)
                {
                    modelName += "_solo";
                    modelPath += "villager_table_solo";
                }
                else
                {
                    modelName += "_solo_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table);
                    modelPath += "villager_table_solo_carpeted";
                }
            }
            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName , modelPath)
                            .texture("0", textureTable)
                            .texture("1",carpetTexture)
                            .texture("2",textureParticle))
                    .rotationY(rotation)
                    .build();
        });
        ModelFile villagerWorkshopModel = models().withExistingParent(getKey(table).toString(),"premierpainmod:block/all_materials_block/villager_table/villager_table_solo/villager_table_solo").texture("0", "block/all_materials_block/multiple_use_texture/" + material);
        itemModels().getBuilder(getKey(table).getPath()).parent(villagerWorkshopModel);
    }
    private String textureTableWithCarpetSelection(BlockState state,VillagerTableBlock table)
    {
        switch (state.getValue(VillagerTableBlock.COLOR))
        {
            case WHITE: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_white";
            case LIGHT_GRAY: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_light_gray";
            case GRAY: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_gray";
            case BLACK: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_black";
            case BROWN: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_brown";
            case RED: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_red";
            case ORANGE: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_orange";
            case YELLOW: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_yellow";
            case LIME: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_lime";
            case GREEN: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_green";
            case CYAN: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_cyan";
            case LIGHT_BLUE: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_light_blue";
            case BLUE: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_blue";
            case PURPLE: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_purple";
            case MAGENTA: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_magenta";
            default: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_pink";
        }
    }

    private String nameModelTableWithCarpetSelection(BlockState state,VillagerTableBlock table)
    {
        switch (state.getValue(VillagerTableBlock.COLOR))
        {
            case WHITE: return "_white";
            case LIGHT_GRAY: return "_light_gray";
            case GRAY: return "_gray";
            case BLACK: return "_black";
            case BROWN: return "_brown";
            case RED: return "_red";
            case ORANGE: return "_orange";
            case YELLOW: return "_yellow";
            case LIME: return "_lime";
            case GREEN: return "_green";
            case CYAN: return "_cyan";
            case LIGHT_BLUE: return "_light_blue";
            case BLUE: return "_blue";
            case PURPLE: return "_purple";
            case MAGENTA: return "_magenta";
            default: return "_pink";
        }
    }
    private void villagerChairWithItem(Block chair)
    {
        String chairName = BuiltInRegistries.BLOCK.getKey(chair).toString().replace(PremierPainMod.MOD_ID +":","");
        String material = chairName.replace("_chair","");
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(chair);
        variantBuilder.forAllStates(state ->
        {
            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(getKey(chair).toString(),"premierpainmod:block/all_materials_block/villager_chair/villager_chair")
                            .texture("0","block/all_materials_block/multiple_use_texture/" + material)
                            .texture("1", "block/all_materials_block/multiple_use_particle/" + material))
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });
        ModelFile villagerChairModel = models().withExistingParent(getKey(chair).toString(),"premierpainmod:block/all_materials_block/villager_chair/villager_chair").texture("0","block/all_materials_block/multiple_use_texture/" + material);
        itemModels().getBuilder(getKey(chair).getPath()).parent(villagerChairModel);
    }
    private void villagerThroneChairWithItem(Block throneChair)
    {
        String throneChairName = getName(throneChair);
        String material = throneChairName.replace("_throne_chair","");
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(throneChair);
        variantBuilder.forAllStates(state ->
        {
            String modelName = getKey(throneChair).toString();
            String modelPath = "premierpainmod:block/all_materials_block/villager_throne_chair/";
            String texture0 = "block/all_materials_block/multiple_use_texture/" + material;
            String texture1 = textureThroneChairWithCarpetSelection(state, (VillagerThroneChairBlock) throneChair);;
            String particle = "block/all_materials_block/multiple_use_particle/" + material;
            boolean flag = (state.getValue(VillagerThroneChairBlock.COLOR) == VillagerTableCarpetColor.NONE);
            if(state.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF ) == DoubleBlockHalf.LOWER)
            {
                if(flag)
                {
                    modelName += "_bottom";
                    modelPath += "wo_carpet/villager_throne_chair_bottom";
                }
                else
                {
                    modelName += "_bottom_c" + nameModelThroneChairWithCarpetSelection(state, (VillagerThroneChairBlock) throneChair);
                    modelPath += "w_carpet/villager_throne_chair_bottom_carpeted";
                }
            }
            else
            {
                if(flag)
                {
                    modelName += "_upper";
                    modelPath += "wo_carpet/villager_throne_chair_upper";
                }
                else
                {
                    modelName += "_upper_c" + nameModelThroneChairWithCarpetSelection(state, (VillagerThroneChairBlock) throneChair);
                    modelPath += "w_carpet/villager_throne_chair_upper_carpeted";
                }
            }
            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName , modelPath)
                            .texture("0",texture0)
                            .texture("1",texture1)
                            .texture("2", particle))
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });
        ModelFile villagerChairModel = models().withExistingParent(getKey(throneChair).toString(),"premierpainmod:block/all_materials_block/villager_throne_chair/wo_carpet/villager_throne_chair_m").texture("0","block/all_materials_block/multiple_use_texture/" + material);
        itemModels().getBuilder(getKey(throneChair).getPath()).parent(villagerChairModel);
    }

    private void villagerDrawerWithItem(Block villagerDrawer)
    {
        String villagerDrawerName = BuiltInRegistries.BLOCK.getKey(villagerDrawer).toString().replace(PremierPainMod.MOD_ID +":","");
        String material = villagerDrawerName.replace("_drawer","");

        String texture = "block/all_materials_block/multiple_use_texture/" + material;
        String particle = "block/all_materials_block/multiple_use_particle/" + material;

        VariantBlockStateBuilder variantBuilder = getVariantBuilder(villagerDrawer);
        variantBuilder.forAllStates(state ->
        {
            String modelName = getKey(villagerDrawer).toString();
            String modelPath = "premierpainmod:block/all_materials_block/villager_drawer/" ;

            if(state.getValue(VillagerDrawer.PART) == TwoBlockWidthPart.RIGHT)
            {
                if(state.getValue(VillagerDrawer.OPEN) == FALSE)
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
                if(state.getValue(VillagerDrawer.OPEN) == FALSE)
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
                            .texture("0",texture)
                            .texture("1", particle))
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });
        ModelFile villagerWorkshopModel = models().withExistingParent(getKey(villagerDrawer).toString(),"premierpainmod:block/all_materials_block/villager_drawer/villager_drawer_m")
                .texture("0",texture);
        itemModels().getBuilder(getKey(villagerDrawer).getPath()).parent(villagerWorkshopModel);
    }
    private void wallVillagerShelf(Block villagerWallShelfWithItem)
    {
        String name = BuiltInRegistries.BLOCK.getKey(villagerWallShelfWithItem).toString().replace(PremierPainMod.MOD_ID +":","");
        String material = name.replace("_wall_villager_shelf","_villager");

        String texture = "block/all_materials_block/multiple_use_texture/" + material;
        String particle = "block/all_materials_block/multiple_use_particle/" + material;

        VariantBlockStateBuilder variantBuilder = getVariantBuilder(villagerWallShelfWithItem);
        variantBuilder.forAllStates(state ->
        {
            String modelName = getKey(villagerWallShelfWithItem).toString();
            String modelPath = "premierpainmod:block/all_materials_block/villager_shelf/wall/";
            if(state.getValue(VillagerDrawer.PART) == TwoBlockWidthPart.RIGHT)
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
                            .texture("0",texture)
                            .texture("1", particle))
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });
    }
    private void standingVillagerShelf(Block villagerWallShelfWithItem)
    {
        String name = BuiltInRegistries.BLOCK.getKey(villagerWallShelfWithItem).toString().replace(PremierPainMod.MOD_ID +":","");
        String material = name.replace("_standing_villager_shelf","_villager");

        String texture = "block/all_materials_block/multiple_use_texture/" + material;
        String particle = "block/all_materials_block/multiple_use_particle/" + material;

        VariantBlockStateBuilder variantBuilder = getVariantBuilder(villagerWallShelfWithItem);
        variantBuilder.forAllStates(state ->
        {
            String modelName = getKey(villagerWallShelfWithItem).toString();
            String modelPath = "premierpainmod:block/all_materials_block/villager_shelf/standing/";

            if(state.getValue(VillagerDrawer.PART) == TwoBlockWidthPart.RIGHT)
            {
                if((state.getValue(StandingVillagerShelf.HAS_SHELF_BELOW)) && (state.getValue(StandingVillagerShelf.HAS_SHELF_ON_TOP)))
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
                if((state.getValue(StandingVillagerShelf.HAS_SHELF_BELOW)) && (state.getValue(StandingVillagerShelf.HAS_SHELF_ON_TOP)))
                {
                    modelName += "_left_middle";
                    modelPath += "middle_standing_villager_shelf_left";
                }
                else if ((state.getValue(StandingVillagerShelf.HAS_SHELF_BELOW)) && !(state.getValue(StandingVillagerShelf.HAS_SHELF_ON_TOP)))
                {
                    modelName += "_left_top";
                    modelPath += "top_standing_villager_shelf_left";
                }else
                {
                    modelName += "_left_base";
                    modelPath += "base_standing_villager_shelf_left";
                }
            }
            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName, modelPath)
                            .texture("0",texture)
                            .texture("1", particle))
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });
    }

    private String textureThroneChairWithCarpetSelection(BlockState state,VillagerThroneChairBlock ThroneTable)
    {
        switch (state.getValue(VillagerThroneChairBlock.COLOR))
        {
            case WHITE: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_white";
            case LIGHT_GRAY: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_light_gray";
            case GRAY: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_gray";
            case BLACK: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_black";
            case BROWN: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_brown";
            case RED: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_red";
            case ORANGE: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_orange";
            case YELLOW: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_yellow";
            case LIME: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_lime";
            case GREEN: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_green";
            case CYAN: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_cyan";
            case LIGHT_BLUE: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_light_blue";
            case BLUE: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_blue";
            case PURPLE: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_purple";
            case MAGENTA: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_magenta";
            default: return "premierpainmod:block/all_materials_block/villager_table/carpet/villager_table_carpet_pink";
        }
    }

    private String nameModelThroneChairWithCarpetSelection(BlockState state,VillagerThroneChairBlock ThroneTable)
    {
        switch (state.getValue(VillagerThroneChairBlock.COLOR))
        {
            case WHITE: return "_white";
            case LIGHT_GRAY: return "_light_gray";
            case GRAY: return "_gray";
            case BLACK: return "_black";
            case BROWN: return "_brown";
            case RED: return "_red";
            case ORANGE: return "_orange";
            case YELLOW: return "_yellow";
            case LIME: return "_lime";
            case GREEN: return "_green";
            case CYAN: return "_cyan";
            case LIGHT_BLUE: return "_light_blue";
            case BLUE: return "_blue";
            case PURPLE: return "_purple";
            case MAGENTA: return "_magenta";
            default: return "_pink";
        }
    }

    private void flowerBlockWithItem(Block block)
    {
        String name = BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MOD_ID +":","");

        ModelFile modelFile = models().withExistingParent(name, "block/cross").texture("cross", "block/vegetation/flower_block/one_block_flower/" + name).renderType("cutout");
        ModelFile itemModelFile = models().withExistingParent(name + "_item", "item/generated").texture("layer0", "block/vegetation/flower_block/one_block_flower/" + name);

        simpleBlock(block, modelFile);
        itemModels().getBuilder(getKey(block).getPath()).parent(itemModelFile);
    }

    private void flowerPotBlock(Block flowerPotBlock, Block flowerBlock)
    {
        String name = BuiltInRegistries.BLOCK.getKey(flowerPotBlock).toString().replace(PremierPainMod.MOD_ID +":","");
        String nameFlower = BuiltInRegistries.BLOCK.getKey(flowerBlock).toString().replace(PremierPainMod.MOD_ID +":","");


        ModelFile modelFile = models().withExistingParent(name, ResourceLocation.withDefaultNamespace("flower_pot_cross")).texture("plant", "block/vegetation/flower_block/one_block_flower/" + nameFlower).renderType("cutout");
        simpleBlock(flowerPotBlock, modelFile);
    }
    private void deadBushPotBlock(Block deadBushPotBlock, Block deadBushBlock)
    {
        String name = BuiltInRegistries.BLOCK.getKey(deadBushPotBlock).toString().replace(PremierPainMod.MOD_ID +":","");
        String nameFlower = BuiltInRegistries.BLOCK.getKey(deadBushBlock).toString().replace(PremierPainMod.MOD_ID +":","");


        ModelFile modelFile = models().withExistingParent(name, ResourceLocation.withDefaultNamespace("flower_pot_cross")).texture("plant", "block/vegetation/dead_bush/" + nameFlower).renderType("cutout");
        simpleBlock(deadBushPotBlock, modelFile);
    }

    private void growingVegetationWithItem(Block block)
    {
        String name = BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MOD_ID +":","");

        ModelFile modelFile = models().withExistingParent(name, "block/cross").texture("cross", "block/vegetation/flower_block/growing_block_flower/" + name).renderType("cutout");
        ModelFile itemModelFile = models().withExistingParent(name + "_item", "item/generated").texture("layer0", "block/vegetation/flower_block/growing_block_flower/" + name);

        simpleBlock(block, modelFile);
        itemModels().getBuilder(getKey(block).getPath()).parent(itemModelFile);
    }

    private void deadBushWithItem(Block block)
    {
        String name = BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MOD_ID +":","");

        ModelFile modelFile = models().withExistingParent(name, "block/cross").texture("cross", "block/vegetation/dead_bush/" + name).renderType("cutout");
        ModelFile itemModelFile = models().withExistingParent(name + "_item", "item/generated").texture("layer0", "block/vegetation/dead_bush/" + name);

        simpleBlock(block, modelFile);
        itemModels().getBuilder(getKey(block).getPath()).parent(itemModelFile);
    }

    private void flowerPotBlockForGrowingVegetation(Block flowerPotBlock, Block flowerBlock)
    {
        String name = BuiltInRegistries.BLOCK.getKey(flowerPotBlock).toString().replace(PremierPainMod.MOD_ID +":","");
        String nameFlower = BuiltInRegistries.BLOCK.getKey(flowerBlock).toString().replace(PremierPainMod.MOD_ID +":","");


        ModelFile modelFile = models().withExistingParent(name, ResourceLocation.withDefaultNamespace("flower_pot_cross")).texture("plant", "block/vegetation/flower_block/growing_block_flower/" + nameFlower).renderType("cutout");
        simpleBlock(flowerPotBlock, modelFile);
    }

    private void floweredCactusBlockWithItem()
    {
        Block block = BlockRegister.FLOWERED_CACTUS_BLOCK.get();
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block);
        variantBuilder.forAllStates(state ->
        {
            if(state.getValue(FloweredCactusBlock.PART_NUM ) == 1)
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(getKey(block).toString()+"_1","premierpainmod:block/vegetation/misc/flowered_cactus/flowered_cactus_1"))
                        .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                        .build();
            }
            else if (state.getValue(FloweredCactusBlock.PART_NUM ) == 2)
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(getKey(block).toString()+"_2","premierpainmod:block/vegetation/misc/flowered_cactus/flowered_cactus_2"))
                        .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                        .build();
            }
            else if (state.getValue(FloweredCactusBlock.PART_NUM ) == 3)
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(getKey(block).toString()+"_3","premierpainmod:block/vegetation/misc/flowered_cactus/flowered_cactus_3"))
                        .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                        .build();
            }
            else
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(getKey(block).toString()+"_0","premierpainmod:block/vegetation/misc/flowered_cactus/flowered_cactus_0"))
                        .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                        .build();
            }
        });
        ModelFile model;
        model = models().withExistingParent(getKey(block).toString(),"premierpainmod:block/vegetation/misc/flowered_cactus/flowered_cactus_0");
        itemModels().getBuilder(getKey(block).getPath()).parent(model);
    }

    private void cactusFlowerBlockWithItem()
    {
        Block block = BlockRegister.CACTUS_FLOWER_BLOCK.get();
        String name = getName(block);
        ModelFile pedestalModel = models().withExistingParent(getKey(block).toString(),"premierpainmod:block/vegetation/misc/flowered_cactus/cactus_flower/cactus_flower");
        simpleBlock(block, pedestalModel);
        itemModels().getBuilder(getKey(block).getPath()).parent(models()
                .getExistingFile(mcLoc("item/generated")))
                .texture("layer0","block/vegetation/misc/flowered_cactus/cactus_flower/cactus_flower_item");
    }

    private void pottedFloweredCactus()
    {
        Block flowerPotBlock = BlockRegister.POTTED_CACTUS_FLOWER_BLOCK.get();
        Block blockToPot = BlockRegister.CACTUS_FLOWER_BLOCK.get();

        String nameFlowerPotBlock = BuiltInRegistries.BLOCK.getKey(flowerPotBlock).toString().replace(PremierPainMod.MOD_ID +":","");

        ModelFile modelFile = models().withExistingParent(nameFlowerPotBlock, ResourceLocation.withDefaultNamespace("flower_pot_cross")).texture("plant", "block/vegetation/misc/flowered_cactus/cactus_flower/cactus_flower_item").renderType("cutout");
        simpleBlock(flowerPotBlock, modelFile);
    }

    private ResourceLocation getKey(Block block)
    {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private String getName(Block block)
    {
        return getKey(block).toString().replace(PremierPainMod.MOD_ID +":","");
    }
}
