package com.unpainperdu.premierpainmod.data;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import com.unpainperdu.premierpainmod.world.block.VillagerStatue;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider
{
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper)
    {
        super(output, PremierPainMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        statueBlock(BlockRegister.OAK_VILLAGER_STATUE.get(),
                models().singleTexture(
                        BlockRegister.OAK_VILLAGER_STATUE.getId().getPath(),
                        modLoc(ModelProvider.BLOCK_FOLDER + "/statueBlock"),

                        ),
                models().singleTexture(
                        BlockRegister.OAK_VILLAGER_STATUE.getId().getPath(),
                        modLoc(ModelProvider.BLOCK_FOLDER + "/statueBlock"),
                );
    }
    public void statueBlock(Block block, ModelFile bottom, ModelFile top)
    {
        getVariantBuilder(block).forAllStatesExcept(state ->
        {
            int yRot = ((int) state.getValue(VillagerStatue.FACING).toYRot()) + 90;
            boolean lower = state.getValue(VillagerStatue.HALF) == DoubleBlockHalf.LOWER;
            yRot %= 360;
            ModelFile model = null;
            if (lower)
            {
                model = bottom;
            }
            if (!lower)
            {
                model = top;
            }

            return ConfiguredModel.builder().modelFile(model)
                    .rotationY(yRot)
                    .build();
        });
    }
}
