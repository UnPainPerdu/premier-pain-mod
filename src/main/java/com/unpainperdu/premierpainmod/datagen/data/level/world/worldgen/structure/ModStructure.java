package com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure;

import com.unpainperdu.premierpainmod.datagen.data.tag.mod_tags.ModBiomeTags;
import com.unpainperdu.premierpainmod.level.world.worldgen.structure.PremierPainTempleStructures;
import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.pools.DimensionPadding;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;

import java.util.List;
import java.util.Optional;

public class ModStructure
{
    public static final ResourceKey<Structure> FOREST_PREMIER_PAIN_TEMPLE = register("forest_premier_pain_temple");
    public static final ResourceKey<Structure> SAND_DESERT_PREMIER_PAIN_TEMPLE = register("sand_desert_premier_pain_temple");

    public static final List<ResourceKey<Structure>> ALL_STRUCTURES = List.of(FOREST_PREMIER_PAIN_TEMPLE, SAND_DESERT_PREMIER_PAIN_TEMPLE);

    private static ResourceKey<Structure> register(String path)
    {
        return ResourceKey.create(Registries.STRUCTURE, ResourceUtil.createResourceLocation(path));
    }

    public static void boostrap(BootstrapContext<Structure> context)
    {
        HolderGetter<Biome> biomeHoldergetter = context.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> STPHoldergetter = context.lookup(Registries.TEMPLATE_POOL);

        context.register(
                FOREST_PREMIER_PAIN_TEMPLE,
                new PremierPainTempleStructures(
                        new Structure.StructureSettings.Builder(biomeHoldergetter.getOrThrow(ModBiomeTags.HAS_FOREST_PREMIER_PAIN_TEMPLE))
                                .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                                .build(),
                        STPHoldergetter.getOrThrow(ModStructureTemplatePool.FOREST_PREMIER_PAIN_TEMPLE_POOL),
                        Optional.empty(),
                        1,
                        ConstantHeight.of(VerticalAnchor.absolute(-13)),
                        Optional.of(Heightmap.Types.WORLD_SURFACE_WG),
                        80,
                        new DimensionPadding(0),
                        LiquidSettings.IGNORE_WATERLOGGING
                )
        );
        context.register(
                SAND_DESERT_PREMIER_PAIN_TEMPLE,
                new PremierPainTempleStructures(
                        new Structure.StructureSettings.Builder(biomeHoldergetter.getOrThrow(ModBiomeTags.HAS_SAND_DESERT_PREMIER_PAIN_TEMPLE))
                                .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                                .build(),
                        STPHoldergetter.getOrThrow(ModStructureTemplatePool.SAND_DESERT_PREMIER_PAIN_TEMPLE_POOL),
                        Optional.empty(),
                        1,
                        ConstantHeight.of(VerticalAnchor.absolute(-15)),
                        Optional.of(Heightmap.Types.WORLD_SURFACE_WG),
                        80,
                        new DimensionPadding(0),
                        LiquidSettings.IGNORE_WATERLOGGING
                )
        );
    }
}
