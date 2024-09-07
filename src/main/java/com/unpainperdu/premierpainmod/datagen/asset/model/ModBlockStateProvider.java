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
            if(state.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF ) == DoubleBlockHalf.LOWER)
            {
                // Return a ConfiguredModel depending on the state's properties.
                // For example, the following code will rotate the model depending on the horizontal rotation of the block.
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(getKey(brazier).toString()+"_bottom","premierpainmod:block/all_materials_block/villager_brazier/villager_brazier_bottom").texture("0",texture_bottom).texture("1", particle))
                        .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                        .build();
            }
            else
            {
                if(state.getValue(BlockStateProperties.LIT ) == TRUE)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(brazier).toString() + "_upper_lit", "premierpainmod:block/all_materials_block/villager_brazier/villager_brazier_upper_lit").texture("0",texture_upper).texture("3", particle))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(brazier).toString() + "_upper_unlit", "premierpainmod:block/all_materials_block/villager_brazier/villager_brazier_upper_unlit").texture("0",texture_upper).texture("3", particle))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
            }
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
            boolean flag = (state.getValue(VillagerTableBlock.COLOR) == VillagerTableCarpetColor.NONE);
            //Duo part
                //North only
            if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                if(flag)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_n", "premierpainmod:block/all_materials_block/villager_table/villager_table_duo/villager_table_duo").texture("0", textureTable).texture("2",textureParticle))
                            .rotationY(270)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_n_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/all_materials_block/villager_table/villager_table_duo/villager_table_duo_carpeted").texture("0", textureTable).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)).texture("2", textureParticle))
                            .rotationY(270)
                            .build();
                }
            }
                //West only
            if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                if(flag)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_w", "premierpainmod:block/all_materials_block/villager_table/villager_table_duo/villager_table_duo").texture("0", textureTable).texture("2",textureParticle))
                            .rotationY(180)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_w_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/all_materials_block/villager_table/villager_table_duo/villager_table_duo_carpeted").texture("0", textureTable).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)).texture("2", textureParticle))
                            .rotationY(180)
                            .build();
                }
            }
                //South only
            if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                if(flag)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_s", "premierpainmod:block/all_materials_block/villager_table/villager_table_duo/villager_table_duo").texture("0", textureTable).texture("2", textureParticle))
                            .rotationY(90)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_s_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/all_materials_block/villager_table/villager_table_duo/villager_table_duo_carpeted").texture("0", textureTable).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)).texture("2", textureParticle))
                            .rotationY(90)
                            .build();
                }
            }
                //East only
            if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                if(flag)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_e", "premierpainmod:block/all_materials_block/villager_table/villager_table_duo/villager_table_duo").texture("0", textureTable).texture("2", textureParticle))
                            .rotationY(0)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_e_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/all_materials_block/villager_table/villager_table_duo/villager_table_duo_carpeted").texture("0", textureTable).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)).texture("2", textureParticle))
                            .rotationY(0)
                            .build();
                }
            }
            //Trio Part
                //N S
            if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                if(flag)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_trio_ns", "premierpainmod:block/all_materials_block/villager_table/villager_table_trio/line/villager_table_trio_line").texture("0", textureTable).texture("2",textureParticle))
                            .rotationY(90)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_ns_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/all_materials_block/villager_table/villager_table_trio/line/villager_table_trio_line_carpeted").texture("0", textureTable).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)).texture("2",textureParticle))
                            .rotationY(90)
                            .build();
                }
            }
                //W E
            if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                if(flag)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_trio_we", "premierpainmod:block/all_materials_block/villager_table/villager_table_trio/line/villager_table_trio_line").texture("0", textureTable).texture("2",textureParticle))
                            .rotationY(0)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_we_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/all_materials_block/villager_table/villager_table_trio/line/villager_table_trio_line_carpeted").texture("0", textureTable).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)).texture("2",textureParticle))
                            .rotationY(0)
                            .build();
                }
            }
                //N W
            if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                if(flag)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_trio_nw", "premierpainmod:block/all_materials_block/villager_table/villager_table_trio/angle/villager_table_trio_angle").texture("0", textureTable).texture("2",textureParticle))
                            .rotationY(180)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_nw_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/all_materials_block/villager_table/villager_table_trio/angle/villager_table_trio_angle_carpeted").texture("0", textureTable).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)).texture("2",textureParticle))
                            .rotationY(180)
                            .build();
                }
            }
                //N E
            if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                if(flag)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_trio_ne", "premierpainmod:block/all_materials_block/villager_table/villager_table_trio/angle/villager_table_trio_angle").texture("0", textureTable).texture("2",textureParticle))
                            .rotationY(270)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_ne_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/all_materials_block/villager_table/villager_table_trio/angle/villager_table_trio_angle_carpeted").texture("0", textureTable).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)).texture("2",textureParticle))
                            .rotationY(270)
                            .build();
                }
            }
                //S W
            if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                if(flag)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_trio_sw", "premierpainmod:block/all_materials_block/villager_table/villager_table_trio/angle/villager_table_trio_angle").texture("0", textureTable).texture("2",textureParticle))
                            .rotationY(90)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_sw_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/all_materials_block/villager_table/villager_table_trio/angle/villager_table_trio_angle_carpeted").texture("0", textureTable).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)).texture("2",textureParticle))
                            .rotationY(90)
                            .build();
                }
            }
                //S E
            if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                if(flag)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_trio_se", "premierpainmod:block/all_materials_block/villager_table/villager_table_trio/angle/villager_table_trio_angle").texture("0", textureTable).texture("2",textureParticle))
                            .rotationY(0)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_trio_se_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/all_materials_block/villager_table/villager_table_trio/angle/villager_table_trio_angle_carpeted").texture("0", textureTable).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)).texture("2",textureParticle))
                            .rotationY(0)
                            .build();
                }
            }
            //Quatuor Part
                //N E S
            if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                if(flag)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_quatuor_nes", "premierpainmod:block/all_materials_block/villager_table/villager_table_quatuor/villager_table_quatuor").texture("0", textureTable).texture("2", textureParticle))
                            .rotationY(270)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_quatuor_nes_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/all_materials_block/villager_table/villager_table_quatuor/villager_table_quatuor_carpeted").texture("0", textureTable).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)).texture("2", textureParticle))
                            .rotationY(270)
                            .build();
                }
            }
                //E S W
            if((state.getValue(VillagerTableBlock.NORTH) == FALSE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                if(flag)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_quatuor_esw", "premierpainmod:block/all_materials_block/villager_table/villager_table_quatuor/villager_table_quatuor").texture("0", textureTable).texture("2", textureParticle))
                            .rotationY(0)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_quatuor_esw_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/all_materials_block/villager_table/villager_table_quatuor/villager_table_quatuor_carpeted").texture("0", textureTable).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)).texture("2", textureParticle))
                            .rotationY(0)
                            .build();
                }
            }
                //S W N
            if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                if(flag)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_quatuor_swn", "premierpainmod:block/all_materials_block/villager_table/villager_table_quatuor/villager_table_quatuor").texture("0", textureTable).texture("2", textureParticle))
                            .rotationY(90)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_quatuor_swn_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/all_materials_block/villager_table/villager_table_quatuor/villager_table_quatuor_carpeted").texture("0", textureTable).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)).texture("2", textureParticle))
                            .rotationY(90)
                            .build();
                }
            }
                //W N E
            if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                if(flag)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_quatuor_wne", "premierpainmod:block/all_materials_block/villager_table/villager_table_quatuor/villager_table_quatuor").texture("0", textureTable).texture("2", textureParticle))
                            .rotationY(180)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_quatuor_wne_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/all_materials_block/villager_table/villager_table_quatuor/villager_table_quatuor_carpeted").texture("0", textureTable).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)).texture("2", textureParticle))
                            .rotationY(180)
                            .build();
                }
            }
            //total part
            if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == TRUE) && (state.getValue(VillagerTableBlock.SOUTH) == TRUE) && (state.getValue(VillagerTableBlock.EAST) == TRUE))
            {
                if(flag)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_pentuor", "premierpainmod:block/all_materials_block/villager_table/villager_table_pentuor/villager_table_pentuor").texture("0", textureTable).texture("2", textureParticle))
                            .rotationY(0)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_pentuor_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/all_materials_block/villager_table/villager_table_pentuor/villager_table_pentuor_carpeted").texture("0", textureTable).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)).texture("2", textureParticle))
                            .rotationY(0)
                            .build();
                }
            }
            //solo
            else
            {
                if(flag)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_solo", "premierpainmod:block/all_materials_block/villager_table/villager_table_solo/villager_table_solo").texture("0", textureTable).texture("2",textureParticle))
                            .rotationY(0)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_solo_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/all_materials_block/villager_table/villager_table_solo/villager_table_solo_carpeted").texture("0", textureTable).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)).texture("2",textureParticle))
                            .rotationY(0)
                            .build();
                }
            }
        });
        ModelFile villagerWorkshopModel = models().withExistingParent(getKey(table).toString(),"premierpainmod:block/all_materials_block/villager_table/villager_table_solo/villager_table_solo").texture("0", "block/all_materials_block/multiple_use_texture/" + material);
        itemModels().getBuilder(getKey(table).getPath()).parent(villagerWorkshopModel);
    }
    private String textureTableWithCarpetSelection(BlockState state,VillagerTableBlock table)
    {
        String villagerTableName = BuiltInRegistries.BLOCK.getKey(table).toString().replace(PremierPainMod.MOD_ID +":","");
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
        String villagerTableName = BuiltInRegistries.BLOCK.getKey(table).toString().replace(PremierPainMod.MOD_ID +":","");
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
        VariantBlockStateBuilder.PartialBlockstate partialState = variantBuilder.partialState();
        variantBuilder.forAllStates(state ->
        {
            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(getKey(chair).toString(),"premierpainmod:block/all_materials_block/villager_chair/villager_chair").texture("0","block/all_materials_block/multiple_use_texture/" + material))
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });
        ModelFile villagerChairModel = models().withExistingParent(getKey(chair).toString(),"premierpainmod:block/all_materials_block/villager_chair/villager_chair").texture("0","block/all_materials_block/multiple_use_texture/" + material);
        itemModels().getBuilder(getKey(chair).getPath()).parent(villagerChairModel);
    }
    private void villagerThroneChairWithItem(Block throneChair)
    {
        String throneChairName = BuiltInRegistries.BLOCK.getKey(throneChair).toString().replace(PremierPainMod.MOD_ID +":","");
        String material = throneChairName.replace("_throne_chair","");
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(throneChair);
        VariantBlockStateBuilder.PartialBlockstate partialState = variantBuilder.partialState();
        variantBuilder.forAllStates(state ->
        {
            boolean flag = (state.getValue(VillagerThroneChairBlock.COLOR) == VillagerTableCarpetColor.NONE);
            if(state.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF ) == DoubleBlockHalf.LOWER)
            {
                if(flag)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(throneChair).toString() + "_bottom", "premierpainmod:block/all_materials_block/villager_throne_chair/wo_carpet/villager_throne_chair_bottom").texture("0","block/all_materials_block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(throneChair).toString() + "_bottom_c" + nameModelThroneChairWithCarpetSelection(state, (VillagerThroneChairBlock) throneChair), "premierpainmod:block/all_materials_block/villager_throne_chair/w_carpet/villager_throne_chair_bottom_carpeted").texture("0","block/all_materials_block/multiple_use_texture/" + material).texture("1",textureThroneChairWithCarpetSelection(state, (VillagerThroneChairBlock) throneChair)))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
            }
            else
            {
                if(flag)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(throneChair).toString() + "_upper", "premierpainmod:block/all_materials_block/villager_throne_chair/wo_carpet/villager_throne_chair_upper").texture("0","block/all_materials_block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(throneChair).toString() + "_upper_c" + nameModelThroneChairWithCarpetSelection(state, (VillagerThroneChairBlock) throneChair), "premierpainmod:block/all_materials_block/villager_throne_chair/w_carpet/villager_throne_chair_upper_carpeted").texture("0","block/all_materials_block/multiple_use_texture/" + material).texture("1",textureThroneChairWithCarpetSelection(state, (VillagerThroneChairBlock) throneChair)))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
            }
        });
        ModelFile villagerChairModel = models().withExistingParent(getKey(throneChair).toString(),"premierpainmod:block/all_materials_block/villager_throne_chair/wo_carpet/villager_throne_chair_m").texture("0","block/all_materials_block/multiple_use_texture/" + material);
        itemModels().getBuilder(getKey(throneChair).getPath()).parent(villagerChairModel);
    }

    private void villagerDrawerWithItem(Block villagerDrawer)
    {
        String villagerDrawerName = BuiltInRegistries.BLOCK.getKey(villagerDrawer).toString().replace(PremierPainMod.MOD_ID +":","");
        String material = villagerDrawerName.replace("_drawer","");

        VariantBlockStateBuilder variantBuilder = getVariantBuilder(villagerDrawer);
        VariantBlockStateBuilder.PartialBlockstate partialState = variantBuilder.partialState();
        variantBuilder.forAllStates(state ->
        {
            if(state.getValue(VillagerDrawer.PART) == TwoBlockWidthPart.RIGHT)
            {
                if(state.getValue(VillagerDrawer.OPEN) == FALSE)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(villagerDrawer).toString() + "_right_closed", "premierpainmod:block/all_materials_block/villager_drawer/villager_drawer_right_closed").texture("0","block/all_materials_block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(villagerDrawer).toString() + "_right_opened", "premierpainmod:block/all_materials_block/villager_drawer/villager_drawer_right_opened").texture("0","block/all_materials_block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
            }
            else
            {
                if(state.getValue(VillagerDrawer.OPEN) == FALSE)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(villagerDrawer).toString() + "_left_closed", "premierpainmod:block/all_materials_block/villager_drawer/villager_drawer_left_closed").texture("0","block/all_materials_block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(villagerDrawer).toString() + "_left_opened", "premierpainmod:block/all_materials_block/villager_drawer/villager_drawer_left_opened").texture("0","block/all_materials_block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
            }
        });
        ModelFile villagerWorkshopModel = models().withExistingParent(getKey(villagerDrawer).toString(),"premierpainmod:block/all_materials_block/villager_drawer/villager_drawer_m").texture("0","block/all_materials_block/multiple_use_texture/" + material);
        itemModels().getBuilder(getKey(villagerDrawer).getPath()).parent(villagerWorkshopModel);
    }
    private void wallVillagerShelf(Block villagerWallShelfWithItem)
    {
        String name = BuiltInRegistries.BLOCK.getKey(villagerWallShelfWithItem).toString().replace(PremierPainMod.MOD_ID +":","");
        String material = name.replace("_wall_villager_shelf","_villager");

        VariantBlockStateBuilder variantBuilder = getVariantBuilder(villagerWallShelfWithItem);
        VariantBlockStateBuilder.PartialBlockstate partialState = variantBuilder.partialState();
        variantBuilder.forAllStates(state ->
        {
            if(state.getValue(VillagerDrawer.PART) == TwoBlockWidthPart.RIGHT)
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(getKey(villagerWallShelfWithItem).toString() + "_right", "premierpainmod:block/all_materials_block/villager_shelf/wall/wall_villager_shelf_right").texture("0","block/all_materials_block/multiple_use_texture/" + material))
                        .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                        .build();
            }
            else
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(getKey(villagerWallShelfWithItem).toString() + "_left", "premierpainmod:block/all_materials_block/villager_shelf/wall/wall_villager_shelf_left").texture("0","block/all_materials_block/multiple_use_texture/" + material))
                        .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                        .build();
            }
        });
    }
    private void standingVillagerShelf(Block villagerWallShelfWithItem)
    {
        String name = BuiltInRegistries.BLOCK.getKey(villagerWallShelfWithItem).toString().replace(PremierPainMod.MOD_ID +":","");
        String material = name.replace("_standing_villager_shelf","_villager");

        VariantBlockStateBuilder variantBuilder = getVariantBuilder(villagerWallShelfWithItem);
        VariantBlockStateBuilder.PartialBlockstate partialState = variantBuilder.partialState();
        variantBuilder.forAllStates(state ->
        {
            if(state.getValue(VillagerDrawer.PART) == TwoBlockWidthPart.RIGHT)
            {
                if((state.getValue(StandingVillagerShelf.HAS_SHELF_BELOW)) && (state.getValue(StandingVillagerShelf.HAS_SHELF_ON_TOP)))
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(villagerWallShelfWithItem).toString() + "_right_middle", "premierpainmod:block/all_materials_block/villager_shelf/standing/middle_standing_villager_shelf_right").texture("0", "block/all_materials_block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                } else if ((state.getValue(StandingVillagerShelf.HAS_SHELF_BELOW)) && !(state.getValue(StandingVillagerShelf.HAS_SHELF_ON_TOP)))
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(villagerWallShelfWithItem).toString() + "_right_top", "premierpainmod:block/all_materials_block/villager_shelf/standing/top_standing_villager_shelf_right").texture("0", "block/all_materials_block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(villagerWallShelfWithItem).toString() + "_right_base", "premierpainmod:block/all_materials_block/villager_shelf/standing/base_standing_villager_shelf_right").texture("0", "block/all_materials_block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
            }
            else
            {
                if((state.getValue(StandingVillagerShelf.HAS_SHELF_BELOW)) && (state.getValue(StandingVillagerShelf.HAS_SHELF_ON_TOP)))
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(villagerWallShelfWithItem).toString() + "_left_middle", "premierpainmod:block/all_materials_block/villager_shelf/standing/middle_standing_villager_shelf_left").texture("0","block/all_materials_block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                } else if ((state.getValue(StandingVillagerShelf.HAS_SHELF_BELOW)) && !(state.getValue(StandingVillagerShelf.HAS_SHELF_ON_TOP)))
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(villagerWallShelfWithItem).toString() + "_left_top", "premierpainmod:block/all_materials_block/villager_shelf/standing/top_standing_villager_shelf_left").texture("0","block/all_materials_block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(villagerWallShelfWithItem).toString() + "_left_base", "premierpainmod:block/all_materials_block/villager_shelf/standing/base_standing_villager_shelf_left").texture("0","block/all_materials_block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
            }
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
