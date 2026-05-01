package com.unpainperdu.premierpainmod.util.register.structure;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.worldgen.structure.ruletest.BlockNotMatchTest;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTestType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RuleTestRegister
{
    public static final DeferredRegister<RuleTestType<?>> RULE_TEST_TYPE = DeferredRegister.create(BuiltInRegistries.RULE_TEST, PremierPainMod.MOD_ID);

    public static final DeferredHolder<RuleTestType<?>, RuleTestType<?>> BLOCK_NOT_MATCH = RULE_TEST_TYPE.register("block_not_match", () -> explicitRuleTestTypeTyping(BlockNotMatchTest.CODEC));

    private static <T extends RuleTest> RuleTestType<T> explicitRuleTestTypeTyping(MapCodec<T> structureCodec)
    {
        return () -> structureCodec;
    }

    public static void register(IEventBus modEventBus)
    {
        RULE_TEST_TYPE.register(modEventBus);
    }
}