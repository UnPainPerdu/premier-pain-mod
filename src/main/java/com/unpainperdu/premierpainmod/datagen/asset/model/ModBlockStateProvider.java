package com.unpainperdu.premierpainmod.datagen.asset.model;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.VillagerChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.VillagerPedestalBlock;
import com.unpainperdu.premierpainmod.level.world.block.VillagerTableBlock;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidth.VillagerWorkshop;
import com.unpainperdu.premierpainmod.level.world.block.state.properties.VillagerTableCarpetColor;
import com.unpainperdu.premierpainmod.level.world.block.state.properties.TwoBlockWidthPart;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight.VillagerBrazier;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight.VillagerStatue;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight.VillagerThroneChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidthWithBlockEntity.VillagerDrawer;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidthWithBlockEntity.villagerShelf.StandingVillagerShelf;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidthWithBlockEntity.villagerShelf.WallVillagerShelf;
import com.unpainperdu.premierpainmod.util.register.BlockList;
import net.minecraft.data.PackOutput;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
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
        super(output, PremierPainMod.MODID, existingFileHelper);
    }


    @Override
    protected void registerStatesAndModels()
    {
        //test zone
        for(DeferredBlock<Block> Defferedblock : BlockList.ALL_BLOCKS)
        {
            Block block = Defferedblock.get();
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

        }
    }
    private void simpleBlockWithItem(Block block)
    {
        simpleBlockWithItem(block, cubeAll(block));
    }
    private void villagerPedestalWithItem(Block pedestal)
    {
        String name = getName(pedestal);
        String material = name.replace("_villager_pedestal","_villager");
        ModelFile pedestalModel = models().withExistingParent(getKey(pedestal).toString(),"premierpainmod:block/villager_pedestal/villager_pedestal").texture("0", "block/multiple_use_texture/" + material).texture("1","block/multiple_use_particule/" + material);
        simpleBlock(pedestal, pedestalModel);
        itemModels().getBuilder(getKey(pedestal).getPath()).parent(pedestalModel);
    }
    private void villagerStatueWithItem(Block statue)
    {
        String name = getName(statue);
        String material = name.replace("_villager_statue","_villager");

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
                                .modelFile(models().withExistingParent(getKey(statue).toString()+"_bottom","premierpainmod:block/villager_statue/villager_statue_bottom").texture("0", "block/multiple_use_texture/" + material).texture("1","block/multiple_use_particule/" + material))
                                .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                                .build();
                    }
                    else
                    {
                        return ConfiguredModel.builder()
                                .modelFile(models().withExistingParent(getKey(statue).toString()+"_upper","premierpainmod:block/villager_statue/villager_statue_upper").texture("0", "block/multiple_use_texture/" + material).texture("1","block/multiple_use_particule/" + material))
                                .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                                .build();
                    }
        });
        itemModels().getBuilder((getKey(statue).getPath()).replace("premierpainmod:block/","premierpainmod:item/"))
                .parent(models()
                        .getExistingFile(mcLoc("item/generated")))
                .texture("layer0","item/villager_statue/" + name);
    }
    private void villagerWorkshopWithItem(Block villagerWorkshop)
    {
        String name = getName(villagerWorkshop);

        VariantBlockStateBuilder variantBuilder = getVariantBuilder(villagerWorkshop);
        variantBuilder.forAllStates(state ->
        {
            if(state.getValue(VillagerWorkshop.PART) == TwoBlockWidthPart.RIGHT)
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(getKey(villagerWorkshop).toString()+"_right","premierpainmod:block/villager_workshop/villager_workshop_right_m"))
                        .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                        .build();
            }
            else
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(getKey(villagerWorkshop).toString()+"_left","premierpainmod:block/villager_workshop/villager_workshop_left_m"))
                        .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                        .build();
            }
        });

        ModelFile villagerWorkshopModel = models().withExistingParent(getKey(villagerWorkshop).toString(),"premierpainmod:block/villager_workshop/villager_workshop_m");
        itemModels().getBuilder(getKey(villagerWorkshop).getPath()).parent(villagerWorkshopModel);
    }
    private void villagerBrazierWithItem(Block brazier)
    {
        String name = getName(brazier);
        String material = name.replace("_villager_brazier","_villager");

        String texture_bottom = "block/multiple_use_texture/" + material;
        String texture_upper;
        String particule = "block/multiple_use_particule/" + material;

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
            texture_upper = "block/villager_brazier/wood_villager_brazier_upper";
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
                        .modelFile(models().withExistingParent(getKey(brazier).toString()+"_bottom","premierpainmod:block/villager_brazier/villager_brazier_bottom").texture("0",texture_bottom).texture("1", particule))
                        .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                        .build();
            }
            else
            {
                if(state.getValue(BlockStateProperties.LIT ) == TRUE)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(brazier).toString() + "_upper_lit", "premierpainmod:block/villager_brazier/villager_brazier_upper_lit").texture("0",texture_upper).texture("3", particule))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(brazier).toString() + "_upper_unlit", "premierpainmod:block/villager_brazier/villager_brazier_upper_unlit").texture("0",texture_upper).texture("3", particule))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
            }
        });

        ModelFile brazierModel = models().withExistingParent(getKey(brazier).toString()+"_m","premierpainmod:block/villager_brazier/villager_brazier_m");
        itemModels().getBuilder(getKey(brazier).getPath()).parent(brazierModel).texture("0", texture_bottom).texture("1", texture_upper);
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
            boolean flag = (state.getValue(VillagerTableBlock.COLOR) == VillagerTableCarpetColor.NONE);
            //Duo part
                //North only
            if((state.getValue(VillagerTableBlock.NORTH) == TRUE) && (state.getValue(VillagerTableBlock.WEST) == FALSE) && (state.getValue(VillagerTableBlock.SOUTH) == FALSE) && (state.getValue(VillagerTableBlock.EAST) == FALSE))
            {
                if(flag)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_n", "premierpainmod:block/villager_table/villager_table_duo").texture("0", "block/villager_table/table/" + villagerTableName))
                            .rotationY(270)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_n_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/villager_table/villager_table_duo_carpeted").texture("0", "block/villager_table/table/" + villagerTableName).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)))
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
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_w", "premierpainmod:block/villager_table/villager_table_duo").texture("0", "block/villager_table/table/" + villagerTableName))
                            .rotationY(180)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_w_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/villager_table/villager_table_duo_carpeted").texture("0", "block/villager_table/table/" + villagerTableName).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)))
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
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_s", "premierpainmod:block/villager_table/villager_table_duo").texture("0", "block/villager_table/table/" + villagerTableName))
                            .rotationY(90)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_s_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/villager_table/villager_table_duo_carpeted").texture("0", "block/villager_table/table/" + villagerTableName).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)))
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
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_e", "premierpainmod:block/villager_table/villager_table_duo").texture("0", "block/villager_table/table/" + villagerTableName))
                            .rotationY(0)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_e_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/villager_table/villager_table_duo_carpeted").texture("0", "block/villager_table/table/" + villagerTableName).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)))
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
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_trio_ns", "premierpainmod:block/villager_table/villager_table_trio_line").texture("0", "block/villager_table/table/" + villagerTableName))
                            .rotationY(90)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_ns_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/villager_table/villager_table_trio_line_carpeted").texture("0", "block/villager_table/table/" + villagerTableName).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)))
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
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_trio_we", "premierpainmod:block/villager_table/villager_table_trio_line").texture("0", "block/villager_table/table/" + villagerTableName))
                            .rotationY(0)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_we_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/villager_table/villager_table_trio_line_carpeted").texture("0", "block/villager_table/table/" + villagerTableName).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)))
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
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_trio_nw", "premierpainmod:block/villager_table/villager_table_trio_angle").texture("0", "block/villager_table/table/" + villagerTableName))
                            .rotationY(180)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_nw_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/villager_table/villager_table_trio_angle_carpeted").texture("0", "block/villager_table/table/" + villagerTableName).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)))
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
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_trio_ne", "premierpainmod:block/villager_table/villager_table_trio_angle").texture("0", "block/villager_table/table/" + villagerTableName))
                            .rotationY(270)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_ne_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/villager_table/villager_table_trio_angle_carpeted").texture("0", "block/villager_table/table/" + villagerTableName).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)))
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
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_trio_sw", "premierpainmod:block/villager_table/villager_table_trio_angle").texture("0", "block/villager_table/table/" + villagerTableName))
                            .rotationY(90)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_sw_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/villager_table/villager_table_trio_angle_carpeted").texture("0", "block/villager_table/table/" + villagerTableName).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)))
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
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_trio_se", "premierpainmod:block/villager_table/villager_table_trio_angle").texture("0", "block/villager_table/table/" + villagerTableName))
                            .rotationY(0)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_duo_se_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/villager_table/villager_table_trio_angle_carpeted").texture("0", "block/villager_table/table/" + villagerTableName).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)))
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
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_quatuor_nes", "premierpainmod:block/villager_table/villager_table_quatuor").texture("0", "block/villager_table/table/" + villagerTableName))
                            .rotationY(270)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_quatuor_nes_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/villager_table/villager_table_quatuor_carpeted").texture("0", "block/villager_table/table/" + villagerTableName).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)))
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
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_quatuor_esw", "premierpainmod:block/villager_table/villager_table_quatuor").texture("0", "block/villager_table/table/" + villagerTableName))
                            .rotationY(0)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_quatuor_esw_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/villager_table/villager_table_quatuor_carpeted").texture("0", "block/villager_table/table/" + villagerTableName).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)))
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
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_quatuor_swn", "premierpainmod:block/villager_table/villager_table_quatuor").texture("0", "block/villager_table/table/" + villagerTableName))
                            .rotationY(90)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_quatuor_swn_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/villager_table/villager_table_quatuor_carpeted").texture("0", "block/villager_table/table/" + villagerTableName).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)))
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
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_quatuor_wne", "premierpainmod:block/villager_table/villager_table_quatuor").texture("0", "block/villager_table/table/" + villagerTableName))
                            .rotationY(180)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_quatuor_wne_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/villager_table/villager_table_quatuor_carpeted").texture("0", "block/villager_table/table/" + villagerTableName).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)))
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
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_pentuor", "premierpainmod:block/villager_table/villager_table_pentuor").texture("0", "block/villager_table/table/" + villagerTableName))
                            .rotationY(0)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_pentuor_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/villager_table/villager_table_pentuor_carpeted").texture("0", "block/villager_table/table/" + villagerTableName).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)))
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
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_solo", "premierpainmod:block/villager_table/villager_table_solo").texture("0", "block/villager_table/table/" + villagerTableName))
                            .rotationY(0)
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(table).toString() + "_solo_c" + nameModelTableWithCarpetSelection(state, (VillagerTableBlock) table), "premierpainmod:block/villager_table/villager_table_solo_carpeted").texture("0", "block/villager_table/table/" + villagerTableName).texture("1",textureTableWithCarpetSelection(state, (VillagerTableBlock) table)))
                            .rotationY(0)
                            .build();
                }
            }
        });
        ModelFile villagerWorkshopModel = models().withExistingParent(getKey(table).toString(),"premierpainmod:block/villager_table/villager_table_solo").texture("0","block/villager_table/table/" + villagerTableName);
        itemModels().getBuilder(getKey(table).getPath()).parent(villagerWorkshopModel);
    }
    private String textureTableWithCarpetSelection(BlockState state,VillagerTableBlock table)
    {
        String villagerTableName = BuiltInRegistries.BLOCK.getKey(table).toString().replace(PremierPainMod.MODID+":","");
        switch (state.getValue(VillagerTableBlock.COLOR))
        {
            case WHITE: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_white";
            case LIGHT_GRAY: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_light_gray";
            case GRAY: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_gray";
            case BLACK: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_black";
            case BROWN: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_brown";
            case RED: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_red";
            case ORANGE: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_orange";
            case YELLOW: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_yellow";
            case LIME: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_lime";
            case GREEN: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_green";
            case CYAN: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_cyan";
            case LIGHT_BLUE: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_light_blue";
            case BLUE: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_blue";
            case PURPLE: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_purple";
            case MAGENTA: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_magenta";
            default: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_pink";
        }
    }

    private String nameModelTableWithCarpetSelection(BlockState state,VillagerTableBlock table)
    {
        String villagerTableName = BuiltInRegistries.BLOCK.getKey(table).toString().replace(PremierPainMod.MODID+":","");
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
        String chairName = BuiltInRegistries.BLOCK.getKey(chair).toString().replace(PremierPainMod.MODID+":","");
        String material = chairName.replace("_chair","");
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(chair);
        VariantBlockStateBuilder.PartialBlockstate partialState = variantBuilder.partialState();
        variantBuilder.forAllStates(state ->
        {
            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(getKey(chair).toString(),"premierpainmod:block/villager_chair/villager_chair").texture("0","block/multiple_use_texture/" + material))
                    .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                    .build();
        });
        ModelFile villagerChairModel = models().withExistingParent(getKey(chair).toString(),"premierpainmod:block/villager_chair/villager_chair").texture("0","block/multiple_use_texture/" + material);
        itemModels().getBuilder(getKey(chair).getPath()).parent(villagerChairModel);
    }
    private void villagerThroneChairWithItem(Block throneChair)
    {
        String throneChairName = BuiltInRegistries.BLOCK.getKey(throneChair).toString().replace(PremierPainMod.MODID+":","");
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
                            .modelFile(models().withExistingParent(getKey(throneChair).toString() + "_bottom", "premierpainmod:block/villager_throne_chair/villager_throne_chair_bottom").texture("0","block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(throneChair).toString() + "_bottom_c" + nameModelThroneChairWithCarpetSelection(state, (VillagerThroneChairBlock) throneChair), "premierpainmod:block/villager_throne_chair/villager_throne_chair_bottom_carpeted").texture("0","block/multiple_use_texture/" + material).texture("1",textureThroneChairWithCarpetSelection(state, (VillagerThroneChairBlock) throneChair)))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
            }
            else
            {
                if(flag)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(throneChair).toString() + "_upper", "premierpainmod:block/villager_throne_chair/villager_throne_chair_upper").texture("0","block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(throneChair).toString() + "_upper_c" + nameModelThroneChairWithCarpetSelection(state, (VillagerThroneChairBlock) throneChair), "premierpainmod:block/villager_throne_chair/villager_throne_chair_upper_carpeted").texture("0","block/multiple_use_texture/" + material).texture("1",textureThroneChairWithCarpetSelection(state, (VillagerThroneChairBlock) throneChair)))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
            }
        });
        ModelFile villagerChairModel = models().withExistingParent(getKey(throneChair).toString(),"premierpainmod:block/villager_throne_chair/villager_throne_chair_m").texture("0","block/multiple_use_texture/" + material);
        itemModels().getBuilder(getKey(throneChair).getPath()).parent(villagerChairModel);
    }

    private void villagerDrawerWithItem(Block villagerDrawer)
    {
        String villagerDrawerName = BuiltInRegistries.BLOCK.getKey(villagerDrawer).toString().replace(PremierPainMod.MODID+":","");
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
                            .modelFile(models().withExistingParent(getKey(villagerDrawer).toString() + "_right_closed", "premierpainmod:block/villager_drawer/villager_drawer_right_closed").texture("0","block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(villagerDrawer).toString() + "_right_opened", "premierpainmod:block/villager_drawer/villager_drawer_right_opened").texture("0","block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
            }
            else
            {
                if(state.getValue(VillagerDrawer.OPEN) == FALSE)
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(villagerDrawer).toString() + "_left_closed", "premierpainmod:block/villager_drawer/villager_drawer_left_closed").texture("0","block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
                else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(villagerDrawer).toString() + "_left_opened", "premierpainmod:block/villager_drawer/villager_drawer_left_opened").texture("0","block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
            }
        });
        ModelFile villagerWorkshopModel = models().withExistingParent(getKey(villagerDrawer).toString(),"premierpainmod:block/villager_drawer/villager_drawer_m").texture("0","block/multiple_use_texture/" + material);
        itemModels().getBuilder(getKey(villagerDrawer).getPath()).parent(villagerWorkshopModel);
    }
    private void wallVillagerShelf(Block villagerWallShelfWithItem)
    {
        String name = BuiltInRegistries.BLOCK.getKey(villagerWallShelfWithItem).toString().replace(PremierPainMod.MODID+":","");
        String material = name.replace("_wall_villager_shelf","_villager");

        VariantBlockStateBuilder variantBuilder = getVariantBuilder(villagerWallShelfWithItem);
        VariantBlockStateBuilder.PartialBlockstate partialState = variantBuilder.partialState();
        variantBuilder.forAllStates(state ->
        {
            if(state.getValue(VillagerDrawer.PART) == TwoBlockWidthPart.RIGHT)
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(getKey(villagerWallShelfWithItem).toString() + "_right", "premierpainmod:block/villager_shelf/wall/wall_villager_shelf_right").texture("0","block/multiple_use_texture/" + material))
                        .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                        .build();
            }
            else
            {
                return ConfiguredModel.builder()
                        .modelFile(models().withExistingParent(getKey(villagerWallShelfWithItem).toString() + "_left", "premierpainmod:block/villager_shelf/wall/wall_villager_shelf_left").texture("0","block/multiple_use_texture/" + material))
                        .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                        .build();
            }
        });
    }
    private void standingVillagerShelf(Block villagerWallShelfWithItem)
    {
        String name = BuiltInRegistries.BLOCK.getKey(villagerWallShelfWithItem).toString().replace(PremierPainMod.MODID+":","");
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
                            .modelFile(models().withExistingParent(getKey(villagerWallShelfWithItem).toString() + "_right_middle", "premierpainmod:block/villager_shelf/standing/middle_standing_villager_shelf_right").texture("0", "block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                } else if ((state.getValue(StandingVillagerShelf.HAS_SHELF_BELOW)) && !(state.getValue(StandingVillagerShelf.HAS_SHELF_ON_TOP)))
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(villagerWallShelfWithItem).toString() + "_right_top", "premierpainmod:block/villager_shelf/standing/top_standing_villager_shelf_right").texture("0", "block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(villagerWallShelfWithItem).toString() + "_right_base", "premierpainmod:block/villager_shelf/standing/base_standing_villager_shelf_right").texture("0", "block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }
            }
            else
            {
                if((state.getValue(StandingVillagerShelf.HAS_SHELF_BELOW)) && (state.getValue(StandingVillagerShelf.HAS_SHELF_ON_TOP)))
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(villagerWallShelfWithItem).toString() + "_left_middle", "premierpainmod:block/villager_shelf/standing/middle_standing_villager_shelf_left").texture("0","block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                } else if ((state.getValue(StandingVillagerShelf.HAS_SHELF_BELOW)) && !(state.getValue(StandingVillagerShelf.HAS_SHELF_ON_TOP)))
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(villagerWallShelfWithItem).toString() + "_left_top", "premierpainmod:block/villager_shelf/standing/top_standing_villager_shelf_left").texture("0","block/multiple_use_texture/" + material))
                            .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                            .build();
                }else
                {
                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(getKey(villagerWallShelfWithItem).toString() + "_left_base", "premierpainmod:block/villager_shelf/standing/base_standing_villager_shelf_left").texture("0","block/multiple_use_texture/" + material))
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
            case WHITE: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_white";
            case LIGHT_GRAY: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_light_gray";
            case GRAY: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_gray";
            case BLACK: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_black";
            case BROWN: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_brown";
            case RED: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_red";
            case ORANGE: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_orange";
            case YELLOW: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_yellow";
            case LIME: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_lime";
            case GREEN: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_green";
            case CYAN: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_cyan";
            case LIGHT_BLUE: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_light_blue";
            case BLUE: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_blue";
            case PURPLE: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_purple";
            case MAGENTA: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_magenta";
            default: return "premierpainmod:block/villager_table/carpet/villager_table_carpet_pink";
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
    private ResourceLocation getKey(Block block)
    {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private String getName(Block block)
    {
        return getKey(block).toString().replace(PremierPainMod.MODID+":","");
    }
}
