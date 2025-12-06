package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure;

import com.google.common.collect.ImmutableList;
import com.unpainperdu.premierpainmod.level.world.worldgen.structure.processor.ExtendedBlockAgeProcessor;
import com.unpainperdu.premierpainmod.level.world.worldgen.structure.processor.ExtendedBlockRemover;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

public class ModStructureProcessorList
{
    public static final ResourceKey<StructureProcessorList> AGE_STONE = register("age_stone");
    public static final ResourceKey<StructureProcessorList> RANDOM_BLOCK_REMOVER = register("random_block_remover");
    public static final ResourceKey<StructureProcessorList> AGE_STONE_BEDROCK_REMOVER = register("age_stone_bedrock_remover");
    public static final ResourceKey<StructureProcessorList> RANDOM_BLOCK_REMOVER_BEDROCK_REMOVER = register("random_block_remover_bedrock_remover");
    public static final ResourceKey<StructureProcessorList> FOREST_TEMPLE_PROCESSOR = register("forest_temple_processor");
    public static final ResourceKey<StructureProcessorList> OLD_GREAT_FIELD_STRUCTURE_PATH = register("old_great_field_structure_path");
    public static final ResourceKey<StructureProcessorList> BEDROCK_TO_AIR = register("bedrock_to_air");
    public static final ResourceKey<StructureProcessorList> JELLYSHROOM_FARM = register("jellyshroom_farm");
    public static final ResourceKey<StructureProcessorList> JUNGLE_UNDERGROUND_PETRA = register("jungle_underground_petra");

    private static ResourceKey<StructureProcessorList> register(String path)
    {
        return ResourceKey.create(Registries.PROCESSOR_LIST, ResourceUtil.createResourceLocation(path));
    }

    public static void boostrap(BootstrapContext<StructureProcessorList> context)
    {
        context.register(AGE_STONE, new StructureProcessorList(ImmutableList.of(
                new ExtendedBlockAgeProcessor(0.7F)
        )));

        context.register(RANDOM_BLOCK_REMOVER, new StructureProcessorList(ImmutableList.of(
                new ExtendedBlockRemover(0.9F)

        )));

        context.register(AGE_STONE_BEDROCK_REMOVER, new StructureProcessorList(ImmutableList.of(
                new ExtendedBlockAgeProcessor(0.7F),
                new RuleProcessor(ImmutableList.of(new ProcessorRule(new RandomBlockMatchTest(Blocks.BEDROCK, 1.0F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState())))
        )));

        context.register(RANDOM_BLOCK_REMOVER_BEDROCK_REMOVER, new StructureProcessorList(ImmutableList.of(
                new ExtendedBlockRemover(0.9F),
                new RuleProcessor(ImmutableList.of(new ProcessorRule(new RandomBlockMatchTest(Blocks.BEDROCK, 1.0F), AlwaysTrueTest.INSTANCE, Blocks.AIR.defaultBlockState())))
        )));

        context.register(FOREST_TEMPLE_PROCESSOR, new StructureProcessorList(ImmutableList.of(
                new ExtendedBlockAgeProcessor(0.75F),
                new ExtendedBlockRemover(0.9F)
        )));


        context.register(OLD_GREAT_FIELD_STRUCTURE_PATH, new StructureProcessorList(ImmutableList.of(
                        new RuleProcessor(
                                ImmutableList.of(
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.RAW_GOLD_BLOCK, 1.0F),
                                                new BlockMatchTest(Blocks.WATER),
                                                Blocks.WATER.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.RAW_GOLD_BLOCK, 0.20F),
                                                AlwaysTrueTest.INSTANCE,
                                                Blocks.COBBLESTONE.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.RAW_GOLD_BLOCK, 0.25F),
                                                AlwaysTrueTest.INSTANCE,
                                                Blocks.COBBLESTONE_SLAB.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.RAW_GOLD_BLOCK, 0.35F),
                                                AlwaysTrueTest.INSTANCE,
                                                Blocks.GRAVEL.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.RAW_GOLD_BLOCK, 0.50F),
                                                AlwaysTrueTest.INSTANCE,
                                                Blocks.DIRT_PATH.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.RAW_GOLD_BLOCK, 1.0F),
                                                AlwaysTrueTest.INSTANCE,
                                                Blocks.GRASS_BLOCK.defaultBlockState()
                                        )
                                )
                        )
                )
                )
        );
        context.register(BEDROCK_TO_AIR, new StructureProcessorList(ImmutableList.of(
                        new RuleProcessor(
                                ImmutableList.of(
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.BEDROCK, 1.0F),
                                                AlwaysTrueTest.INSTANCE,
                                                Blocks.AIR.defaultBlockState()
                                        )
                                )
                        )
                )
                )
        );

        context.register(JELLYSHROOM_FARM, new StructureProcessorList(ImmutableList.of(
                        new RuleProcessor(
                                ImmutableList.of(
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.OAK_FENCE, 0.5F),
                                                AlwaysTrueTest.INSTANCE,
                                                Blocks.AIR.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.OAK_FENCE, 1.0F),
                                                AlwaysTrueTest.INSTANCE,
                                                BlockRegister.JELLYSHROOM.get().defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.COBBLESTONE, 0.6F),
                                                AlwaysTrueTest.INSTANCE,
                                                Blocks.MOSSY_COBBLESTONE.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.COBBLESTONE, 0.2F),
                                                AlwaysTrueTest.INSTANCE,
                                                Blocks.AIR.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.COBBLESTONE_WALL, 0.15F),
                                                AlwaysTrueTest.INSTANCE,
                                                Blocks.AIR.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.COBBLESTONE_STAIRS, 0.1F),
                                                AlwaysTrueTest.INSTANCE,
                                                Blocks.AIR.defaultBlockState()
                                        )
                                )
                        )
                )
                )
        );

        context.register(JUNGLE_UNDERGROUND_PETRA, new StructureProcessorList(ImmutableList.of(
                        new RuleProcessor(
                                ImmutableList.of(
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.BEDROCK, 1.0F),
                                                AlwaysTrueTest.INSTANCE,
                                                Blocks.AIR.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.STONE, 0.3F),
                                                AlwaysTrueTest.INSTANCE,
                                                Blocks.DIORITE.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.STONE, 0.4F),
                                                AlwaysTrueTest.INSTANCE,
                                                Blocks.MOSS_BLOCK.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.RAW_GOLD_BLOCK, 0.1F),
                                                AlwaysTrueTest.INSTANCE,
                                                Blocks.POLISHED_DIORITE.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.RAW_GOLD_BLOCK, 0.2F),
                                                AlwaysTrueTest.INSTANCE,
                                                Blocks.COBBLESTONE.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.RAW_GOLD_BLOCK, 0.1F),
                                                AlwaysTrueTest.INSTANCE,
                                                Blocks.DIORITE.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.RAW_GOLD_BLOCK, 1.0F),
                                                AlwaysTrueTest.INSTANCE,
                                                Blocks.STONE.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.DIAMOND_BLOCK, 0.5F),
                                                AlwaysTrueTest.INSTANCE,
                                                Blocks.COBBLESTONE.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.DIAMOND_BLOCK, 1.0F),
                                                AlwaysTrueTest.INSTANCE,
                                                Blocks.DIORITE.defaultBlockState()
                                        )
                                )
                        )
                )
                )
        );
    }
}
