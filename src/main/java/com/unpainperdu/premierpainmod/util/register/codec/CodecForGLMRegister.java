package com.unpainperdu.premierpainmod.util.register.codec;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.GLM.VillagerSingingStoneGLM;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class CodecForGLMRegister
{
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, PremierPainMod.MODID);

    public static final Supplier<MapCodec<VillagerSingingStoneGLM>> VILLAGER_SINGING_STONE_GLM =
            GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("villager_singing_stone_glm", () -> VillagerSingingStoneGLM.CODEC);

    public static void register(IEventBus modEventBus)
    {
        GLOBAL_LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
    }
}
