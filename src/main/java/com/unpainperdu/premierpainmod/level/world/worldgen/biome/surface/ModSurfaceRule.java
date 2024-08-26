package com.unpainperdu.premierpainmod.level.world.worldgen.biome.surface;

import com.unpainperdu.premierpainmod.level.world.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRule
{
    public static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    public static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);

    public static SurfaceRules.RuleSource makeRules()
    {

        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.RuleSource defaultGrassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        SurfaceRules.RuleSource sandSurface = makeSurfaceSurfaceRules(Blocks.SAND, Blocks.SAND,Blocks.SANDSTONE);
        SurfaceRules.RuleSource mudSurface = makeSurfaceSurfaceRules(Blocks.MUD, Blocks.MUD,Blocks.DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SAND_DESERT_PREMIER_PAIN_RUINS),
                        sandSurface),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SWAMP_PREMIER_PAIN_RUINS),
                        SurfaceRules.ifTrue(isAtOrAboveWaterLevel, mudSurface)),
                // Default to a grass and dirt surface
                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, defaultGrassSurface))
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block)
    {
        return SurfaceRules.state(block.defaultBlockState());
    }

    private static SurfaceRules.RuleSource makeSurfaceSurfaceRules(Block grassLike, Block dirtLike)
    {
        return SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),SurfaceRules.sequence(
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
