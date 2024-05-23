package com.unpainperdu.premierpainmod.datagen.asset.model;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.data.PackOutput;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider
{
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, PremierPainMod.MODID, existingFileHelper);
    }


    @Override
    protected void registerStatesAndModels()
    {
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
        villagerStatueWithItem(BlockRegister.COBBLED_DEEPSLATE_VILLAGER_STATUE.get());
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

    }
    private void simpleBlockWithItem(Block block)
    {
        simpleBlockWithItem(block, cubeAll(block));
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
                                .modelFile(models().withExistingParent(key(statue).toString()+"_bottom","premierpainmod:block/villager_statue_bottom").texture("0","block/villager_statue/test_villager_statue_bottom"))//.texture("0","block/villager_statue/" + statueName + "_bottom"))
                                .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                                .build();
                    }
                    else
                    {
                        return ConfiguredModel.builder()
                                .modelFile(models().withExistingParent(key(statue).toString()+"_upper","premierpainmod:block/villager_statue_upper").texture("0","block/villager_statue/test_villager_statue_upper"))//.texture("0","block/villager_statue/" + statueName + "_upper"))
                                .rotationY((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot())
                                .build();
                    }
        });
        itemModels().getBuilder((key(statue).getPath()).replace("premierpainmod:block/","premierpainmod:item/"))
                .parent(models()
                        .getExistingFile(mcLoc("item/generated")))
                .texture("layer0","item/villager_statue/" + statueName);
    }
    private ResourceLocation key(Block block)
    {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
}
