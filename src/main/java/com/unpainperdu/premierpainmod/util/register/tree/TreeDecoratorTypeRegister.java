package com.unpainperdu.premierpainmod.util.register.tree;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.tree.decorator.FallingLeavesDecorator;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TreeDecoratorTypeRegister
{
    private TreeDecoratorTypeRegister()
    {
    }

    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATOR = DeferredRegister.create(Registries.TREE_DECORATOR_TYPE.location(), PremierPainMod.MOD_ID);

    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<FallingLeavesDecorator>> FALLING_LEAVES = TREE_DECORATOR.register("falling_leaves", () -> new TreeDecoratorType<>(FallingLeavesDecorator.CODEC));

    public static void register(IEventBus eventBus)
    {
        TREE_DECORATOR.register(eventBus);
    }
}
