package com.unpainperdu.premierpainmod.level.world.worldgen.structure.processor;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.ModBlockStateProperties;
import com.unpainperdu.premierpainmod.util.register.structure.StructureProcessorRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class ExtendedBlockRemover extends StructureProcessor
{
    public static final MapCodec<ExtendedBlockRemover> CODEC = RecordCodecBuilder.mapCodec(
            extendedBlockRemoverInstance -> extendedBlockRemoverInstance.group(
                            RegistryCodecs.homogeneousList(Registries.BLOCK).optionalFieldOf("rottable_blocks").forGetter(extendedBlockRemover -> extendedBlockRemover.rottableBlocks),
                            Codec.floatRange(0.0F, 1.0F).fieldOf("integrity").forGetter(extendedBlockRemover -> extendedBlockRemover.integrity)
                    )
                    .apply(extendedBlockRemoverInstance, ExtendedBlockRemover::new)
    );
    private final Optional<HolderSet<Block>> rottableBlocks;
    private final float integrity;

    public ExtendedBlockRemover(float integrity)
    {
        this(Optional.empty(), integrity);
    }

    private ExtendedBlockRemover(Optional<HolderSet<Block>> rottableBlocks, float integrity)
    {
        this.integrity = integrity;
        this.rottableBlocks = rottableBlocks;
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public StructureTemplate.StructureBlockInfo process(@NotNull LevelReader levelReader, @NotNull BlockPos seedPos, @NotNull BlockPos rawEntityInfo, StructureTemplate.@NotNull StructureBlockInfo blockInfo, StructureTemplate.@NotNull StructureBlockInfo relativeBlockInfo, @NotNull StructurePlaceSettings placementSettings, @org.jetbrains.annotations.Nullable StructureTemplate template)
    {
        RandomSource randomsource = placementSettings.getRandom(relativeBlockInfo.pos());
        boolean isHeightBlock = blockInfo.state().hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF);
        boolean isWidthBlock = blockInfo.state().hasProperty(ModBlockStateProperties.TWO_BLOCK_WIDTH_PART);

        return ((this.rottableBlocks.isEmpty() || blockInfo.state().is(this.rottableBlocks.get())) && !(randomsource.nextFloat() <= this.integrity)) && (!isWidthBlock && !isHeightBlock)
                ? null
                : relativeBlockInfo;
    }

    @Override
    protected @NotNull StructureProcessorType<?> getType()
    {
        return StructureProcessorRegister.EXTENDED_ROT.get();
    }
}
