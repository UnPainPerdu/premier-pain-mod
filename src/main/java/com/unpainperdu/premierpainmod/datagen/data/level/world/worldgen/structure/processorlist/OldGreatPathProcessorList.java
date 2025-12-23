package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.processorlist;

import com.google.common.collect.ImmutableList;
import com.unpainperdu.premierpainmod.level.world.worldgen.structure.ruletest.BlockNotMatchTest;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

import static com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.processorlist.ModStructureProcessorList.register;

public class OldGreatPathProcessorList
{
    public static final ResourceKey<StructureProcessorList> JELLYSHROOM_FARM = register("jellyshroom_farm");
    public static final ResourceKey<StructureProcessorList> OLD_GREAT_FIELD_STRUCTURE_PATH = register("old_great_field_structure_path");

    public static void boostrap(BootstrapContext<StructureProcessorList> context)
    {
        context.register(OLD_GREAT_FIELD_STRUCTURE_PATH, new StructureProcessorList(ImmutableList.of(
                        new RuleProcessor(
                                ImmutableList.of(
                                        //handle water
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.RAW_GOLD_BLOCK, 0.3F),
                                                new BlockMatchTest(Blocks.WATER),
                                                Blocks.COBBLESTONE.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.RAW_GOLD_BLOCK, 0.5F),
                                                new BlockMatchTest(Blocks.WATER),
                                                Blocks.STONE_BRICKS.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.RAW_GOLD_BLOCK, 1.0F),
                                                new BlockMatchTest(Blocks.WATER),
                                                Blocks.MOSSY_COBBLESTONE.defaultBlockState()
                                        ),
                                        //"real" processors
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

        context.register(JELLYSHROOM_FARM, new StructureProcessorList(ImmutableList.of(
                        new RuleProcessor(
                                ImmutableList.of(
                                        //shroom handler
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
                                        //if no water
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.COBBLESTONE, 0.6F),
                                                new BlockNotMatchTest(Blocks.WATER),
                                                Blocks.MOSSY_COBBLESTONE.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.COBBLESTONE, 0.2F),
                                                new BlockNotMatchTest(Blocks.WATER),
                                                Blocks.AIR.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.COBBLESTONE_WALL, 0.15F),
                                                new BlockNotMatchTest(Blocks.WATER),
                                                Blocks.AIR.defaultBlockState()
                                        ),
                                        new ProcessorRule(
                                                new RandomBlockMatchTest(Blocks.COBBLESTONE_STAIRS, 0.1F),
                                                new BlockNotMatchTest(Blocks.WATER),
                                                Blocks.AIR.defaultBlockState()
                                        )
                                )
                        )
                )
                )
        );
    }
}
