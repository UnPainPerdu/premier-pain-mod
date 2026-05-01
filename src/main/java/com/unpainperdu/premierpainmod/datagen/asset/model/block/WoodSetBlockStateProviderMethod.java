package com.unpainperdu.premierpainmod.datagen.asset.model.block;

import com.unpainperdu.premierpainmod.level.world.block.state.propertie.ModBlockStateProperties;
import com.unpainperdu.premierpainmod.level.world.block.tree.ModLeavesBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;

import static com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil.*;

public class WoodSetBlockStateProviderMethod
{
    private final ModBlockModelProvider bs;

    public WoodSetBlockStateProviderMethod(ModBlockModelProvider bs)
    {
        this.bs = bs;
    }

    /**
     * @param treeId example : mountain_currant
     **/
    protected void allWoodBlocks(String treeId, boolean doesLeavesGrowFruit)
    {
        ResourceLocation planksTexture = createResourceLocation("block/tree/" + treeId + "/" + "planks");

        logWithItem(treeId);
        strippedLogWithItem(treeId);
        woodWithItem(treeId);
        strippedWoodWithItem(treeId);
        planksWithItem(treeId, planksTexture);
        if (doesLeavesGrowFruit)
        {
            fruitLeavesWithItem(treeId);
        }
        else
        {
            leavesWithItem(treeId);
        }
        this.bs.stairWithItem(getModBlockFromId(treeId + "_stairs"), planksTexture);
        this.bs.slabWithItem(getModBlockFromId(treeId + "_slab"), planksTexture);
        this.bs.buttonWithItem(getModBlockFromId(treeId + "_button"), planksTexture);
        this.bs.pressurePlateWithItem(getModBlockFromId(treeId + "_pressure_plate"), planksTexture);
        this.bs.fenceWithItem(getModBlockFromId(treeId + "_fence"), planksTexture);
        this.bs.fenceGateWithItem(getModBlockFromId(treeId + "_fence_gate"), planksTexture);
        woodenDoorWithItem(treeId);
        woodenTrapdoorWithItem(treeId);
        this.bs.woodenSign(getModBlockFromId(treeId + "_sign"), getModBlockFromId(treeId + "_wall_sign"), planksTexture);
        this.bs.woodenHangingSign(getModBlockFromId(treeId + "_hanging_sign"), getModBlockFromId(treeId + "_wall_hanging_sign"), planksTexture);
        saplingWithItem(treeId);
        this.bs.pottedBlockWithBasicModel(getModBlockFromId("potted_" + treeId + "_sapling"), "block/tree/" + treeId + "/sapling");
    }

    private void logWithItem(String treeId)
    {
        Block logBlock = getModBlockFromId(treeId + "_log");
        ResourceLocation side = createResourceLocation("block/tree/" + treeId + "/log_side");
        ResourceLocation bottomAndTop = createResourceLocation("block/tree/" + treeId + "/log_top");
        this.bs.axisRotatedBlockWithItem(logBlock, side, bottomAndTop);
    }

    private void strippedLogWithItem(String treeId)
    {
        Block logBlock = getModBlockFromId("stripped_" + treeId + "_log");
        ResourceLocation side = createResourceLocation("block/tree/" + treeId + "/stripped_log_side");
        ResourceLocation bottomAndTop = createResourceLocation("block/tree/" + treeId + "/stripped_log_top");
        this.bs.axisRotatedBlockWithItem(logBlock, side, bottomAndTop);
    }

    private void woodWithItem(String treeId)
    {
        Block woodBlock = getModBlockFromId(treeId + "_wood");
        ResourceLocation side = createResourceLocation("block/tree/" + treeId + "/log_side");
        this.bs.axisRotatedBlockWithItem(woodBlock, side, side);
    }

    private void strippedWoodWithItem(String treeId)
    {
        Block woodBlock = getModBlockFromId("stripped_" + treeId + "_wood");
        ResourceLocation side = createResourceLocation("block/tree/" + treeId + "/stripped_log_side");
        this.bs.axisRotatedBlockWithItem(woodBlock, side, side);
    }

    private void planksWithItem(String treeId, ResourceLocation planksTexture)
    {
        Block planks = getModBlockFromId(treeId + "_planks");
        this.bs.simpleBlockWithItem(planks, this.bs.models().cubeAll(getModName(planks), planksTexture));
    }

    private void leavesWithItem(String treeId)
    {
        Block leaves = getModBlockFromId(treeId + "_leaves");
        String name = getModName(leaves);
        ModelFile model = this.bs.models().leaves(name, createResourceLocation("block/tree/" + treeId + "/leaves")).renderType("cutout");
        this.bs.simpleBlockWithItem(leaves, model);
    }

    private void fruitLeavesWithItem(String treeId)
    {
        Block leaves = getModBlockFromId(treeId + "_leaves");
        String name = getModName(leaves);
        String leavesTexture = "block/tree/" + treeId + "/leaves";
        String fruitLeavesTexture = "block/tree/" + treeId + "/" + "leaves_fruit";
        String modelPath = "premierpainmod:block/vegetation/tree/leaves_with_fruit";

        ModelFile baseModel = this.bs.models().leaves(name, createResourceLocation(leavesTexture)).renderType("cutout");

        VariantBlockStateBuilder variantBuilder = this.bs.getVariantBuilder(leaves);
        variantBuilder.forAllStates(state ->
        {
            if (state.getValue(ModLeavesBlock.HAS_FRUIT))
            {
                return ConfiguredModel.builder()
                        .modelFile(this.bs.models().withExistingParent(name + "_fruit", modelPath)
                                .texture("0", leavesTexture)
                                .texture("1", fruitLeavesTexture)
                                .renderType("cutout"))
                        .build();
            }
            return ConfiguredModel.builder()
                    .modelFile(baseModel)
                    .build();
        });
        this.bs.itemModels().getBuilder(getKey(leaves).getPath()).parent(baseModel);
    }

    private void woodenDoorWithItem(String treeId)
    {
        Block door = getModBlockFromId(treeId + "_door");
        ResourceLocation bottom = createResourceLocation("block/tree/" + treeId + "/door_bottom");
        ResourceLocation top = createResourceLocation("block/tree/" + treeId + "/door_top");
        ResourceLocation item = createResourceLocation("item/tree/" + treeId + "/door");
        this.bs.doorWithItem(door, bottom, top, item);
    }

    private void woodenTrapdoorWithItem(String treeId)
    {
        Block block = getModBlockFromId(treeId + "_trapdoor");
        ResourceLocation texture = createResourceLocation("block/tree/" + treeId + "/trapdoor");
        this.bs.trapdoorWithItem(block, texture);
    }

    protected void saplingWithItem(String treeId)
    {
        Block sapling = getModBlockFromId(treeId + "_sapling");
        String name = getModName(sapling);
        ResourceLocation texture = createResourceLocation("block/tree/" + treeId + "/sapling");
        ModelFile modelFile = this.bs.models().withExistingParent(name, "block/cross").texture("cross", texture).renderType("cutout");
        ModelFile itemModelFile = this.bs.models().withExistingParent(name + "_item", "item/generated").texture("layer0", texture);

        this.bs.simpleBlock(sapling, modelFile);
        this.bs.itemModels().getBuilder(getKey(sapling).getPath()).parent(itemModelFile);
    }

    public void fallingLeaves(Block fallingLeaves, String treeId)
    {
        String name = getModName(fallingLeaves);
        String modelLoc = "premierpainmod:block/tintable_cross";
        ResourceLocation topTexture = createResourceLocation("block/tree/" + treeId + "/leaves");
        ResourceLocation bottomTexture = createResourceLocation("block/tree/" + treeId + "/falling_leaves");
        ModelFile baseModel = this.bs.models().withExistingParent(name, modelLoc).texture("0", topTexture).renderType("cutout");
        ModelFile bottomModel = this.bs.models().withExistingParent(name + "_bottom", modelLoc).texture("0", bottomTexture).renderType("cutout");
        ModelFile itemModelFile = this.bs.models().withExistingParent(name + "_item", "item/generated").texture("layer0", bottomTexture);
        VariantBlockStateBuilder variantBuilder = this.bs.getVariantBuilder(fallingLeaves);
        variantBuilder.forAllStates(state ->
        {
            if (state.getValue(ModBlockStateProperties.BOTTOM_PART))
            {
                return ConfiguredModel.builder()
                        .modelFile(bottomModel)
                        .build();
            }
            return ConfiguredModel.builder()
                    .modelFile(baseModel)
                    .build();
        });
        this.bs.itemModels().getBuilder(getKey(fallingLeaves).getPath()).parent(itemModelFile);
    }
}
