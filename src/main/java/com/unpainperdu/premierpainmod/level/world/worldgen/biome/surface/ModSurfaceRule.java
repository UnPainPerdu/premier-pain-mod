package com.unpainperdu.premierpainmod.level.world.worldgen.biome.surface;

import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome.overworld.ModOverworldSurfaceBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class ModSurfaceRule
{
    public static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    public static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource WATER = makeStateRule(Blocks.WATER);

    public static SurfaceRules.RuleSource makeRules()
    {
        SurfaceRules.ConditionSource surfacerules$conditionsource = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(97), 2);  //TODO undestand all this messs
        SurfaceRules.ConditionSource surfacerules$conditionsource1 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(256), 0);
        SurfaceRules.ConditionSource surfacerules$conditionsource2 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(63), -1);
        SurfaceRules.ConditionSource surfacerules$conditionsource3 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(74), 1);
        SurfaceRules.ConditionSource surfacerules$conditionsource4 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(60), 0);
        SurfaceRules.ConditionSource surfacerules$conditionsource5 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
        SurfaceRules.ConditionSource surfacerules$conditionsource6 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);
        SurfaceRules.ConditionSource surfacerules$conditionsource7 = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.ConditionSource surfacerules$conditionsource8 = SurfaceRules.waterBlockCheck(0, 0);
        SurfaceRules.ConditionSource surfacerules$conditionsource9 = SurfaceRules.waterStartCheck(-6, -1);
        SurfaceRules.ConditionSource surfacerules$conditionsource10 = SurfaceRules.hole();

        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.RuleSource defaultGrassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        SurfaceRules.RuleSource sandSurface = makeSurfaceSurfaceRules(Blocks.SAND, Blocks.SAND, Blocks.SANDSTONE);
        SurfaceRules.RuleSource mudSurface = makeSurfaceSurfaceRules(Blocks.MUD, Blocks.MUD, Blocks.DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(ModOverworldSurfaceBiomes.SAND_DESERT_PREMIER_PAIN_RUINS),
                        sandSurface
                ),
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(ModOverworldSurfaceBiomes.SWAMP_PREMIER_PAIN_RUINS),
                        SurfaceRules.ifTrue(isAtOrAboveWaterLevel, mudSurface)
                ),
                SurfaceRules.ifTrue(
                        SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(
                                SurfaceRules.isBiome(ModOverworldSurfaceBiomes.SWAMP_PREMIER_PAIN_RUINS),
                                SurfaceRules.ifTrue(
                                        surfacerules$conditionsource4,
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.not(surfacerules$conditionsource6), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0), WATER)
                                        )
                                )
                        )
                ),
                // Default to a grass and dirt surface
                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, defaultGrassSurface))
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block)
    {
        return SurfaceRules.state(block.defaultBlockState());
    }

    private static SurfaceRules.RuleSource makeSurfaceSurfaceRules(Block grassLike, Block dirtLike)
    {
        return SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, makeStateRule(grassLike)),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, makeStateRule(dirtLike)))
        );
    }

    private static SurfaceRules.RuleSource makeSurfaceSurfaceRules(Block grassLike, Block dirtLike, Block deeperThanDirt)
    {
        return SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, makeStateRule(grassLike)),
                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, makeStateRule(dirtLike)),
                        SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, makeStateRule(deeperThanDirt))
                )
        );
    }
}
